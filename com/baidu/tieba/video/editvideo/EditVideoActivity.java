package com.baidu.tieba.video.editvideo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.j.h;
import com.baidu.tieba.j.k;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.video.editvideo.b.b;
import com.baidu.tieba.video.editvideo.b.c;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.SelectCoverModel;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class EditVideoActivity extends BaseActivity implements a, b, b.a, MaskVideoView.b {
    private String bdm;
    private String csP;
    private com.baidu.tbadk.core.view.a dsY;
    private CustomMessageListener gMA;
    private String gMp;
    private List<VideoTitleData> gMq;
    private com.baidu.tieba.video.editvideo.view.a gMr;
    private SelectCoverModel gMs;
    private SelectMusicModel gMt;
    private String gMu;
    private String gMv;
    private boolean gMw;
    private com.baidu.tieba.video.editvideo.b.a gMx;
    private String gMy;
    private HttpMessageListener gMz;
    private h gyx;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;
    private boolean tV;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gyx = kVar.aSb();
        }
        this.gMz = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.gMq = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.gMA = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    EditVideoActivity.this.finishPage();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.i.activity_edit_video);
        this.csP = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.gMp = getIntent().getStringExtra("video_title");
        this.gMy = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.bdm = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.bdm) && !new File(this.bdm).exists()) {
            finishPage();
        }
        new File(com.baidu.tieba.video.b.gKK).mkdirs();
        this.gMs = new SelectCoverModel(getPageContext(), this, this.gyx);
        this.gMt = new SelectMusicModel(getPageContext(), this);
        this.gMx = new com.baidu.tieba.video.editvideo.b.a(this);
        this.gMx.a(this);
        this.gMr = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.g.root_layout), this.gyx);
        this.gMr.setData(this.bdm);
        this.gMr.aa(getIntent());
        this.gMr.a(this.gMx);
        this.gMr.setGenMaskCoverListener(this);
        this.gMs.bwQ();
        this.gMt.bwR();
        this.dsY = new com.baidu.tbadk.core.view.a(getPageContext());
        this.dsY.da(d.k.mixing);
        registerListener(this.gMA);
        bwm();
        registerListener(this.gMz);
        bwl();
        TiebaStatic.log("c12303");
    }

    private void bwk() {
        this.tV = true;
        this.gMv = null;
        this.gMu = null;
        auK();
    }

    public void bwl() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.csP)) {
            httpMessage.addParam("forum_id", this.csP);
        }
        sendMessage(httpMessage);
    }

    private void bwm() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().u(this.gMr.getRootView());
        if (this.gMr != null) {
            this.gMr.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gMr != null) {
            this.gMr.onPause();
        }
        if (this.gMx.bwv()) {
            this.gMx.bww();
        }
        this.gMw = false;
        this.tV = true;
        bwk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gMr != null) {
            this.gMr.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bwL().bwM();
        com.baidu.tieba.video.editvideo.model.b.bwO().bwP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gMr != null) {
            this.gMr.release();
        }
        if (this.gMs != null) {
            this.gMs.cancelLoadData();
        }
        if (this.gMt != null) {
            this.gMt.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gMr != null) {
            this.gMr.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        auK();
        this.gMw = false;
        if (this.gMr != null && this.gMr.bxd() != null) {
            this.gMr.bxd().pause();
            this.gMr.bxd().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bwn() {
        if (this.gMr != null && this.gMs != null && this.gMt != null) {
            if (!j.gP()) {
                getPageContext().showToast(d.k.no_network);
            } else if (!this.gMw) {
                this.gMw = true;
                this.tV = false;
                this.gMv = null;
                this.gMu = null;
                this.gMr.onPause();
                this.dsY.aI(true);
                bwp();
            }
        }
    }

    private void auK() {
        if (this.dsY != null) {
            this.dsY.aI(false);
        }
    }

    private void bwo() {
        if (this.tV) {
            this.tV = false;
        } else if (this.gMr.bxk()) {
            this.gMt.c(this.bdm, this.gMr.bxi(), com.baidu.tieba.video.b.gKJ + "video_" + System.currentTimeMillis() + ".mp4", this.gMr.isMute() ? false : true);
        } else if (this.gMr.isMute()) {
            this.gMt.c(this.bdm, null, com.baidu.tieba.video.b.gKJ + "video_" + System.currentTimeMillis() + ".mp4", this.gMr.isMute() ? false : true);
        } else {
            o(this.bdm, -4399, "");
        }
    }

    private void bwp() {
        if (this.tV) {
            this.tV = false;
            return;
        }
        String text = this.gMr.getText();
        if (TextUtils.isEmpty(text)) {
            this.gMs.aM(this.bdm, this.gMr.getCurrentPosition());
        } else {
            this.gMs.ra(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bwq() {
        File file;
        this.tV = false;
        if (this.gMr.bxk() || this.gMr.isMute()) {
            this.gMw = false;
            this.dsY.aI(true);
            this.gMr.onPause();
            if (this.gMv != null) {
                o(this.gMv, -4399, "");
            } else {
                bwo();
            }
        } else if (this.gMx.bwu()) {
            this.gMw = false;
            this.gMr.onPause();
            this.dsY.aI(true);
            tR(this.bdm);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.k.Z(new File(this.bdm).getAbsolutePath(), com.baidu.tieba.video.b.gKK + file.getName());
                tT(com.baidu.tieba.video.b.gKK + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bcS() {
        if (this.gMr == null || this.gMs == null) {
            auK();
            this.gMw = false;
        } else if (this.tV) {
            this.tV = false;
        } else {
            this.gMs.aM(this.bdm, this.gMr.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void qY(String str) {
        if (this.tV) {
            this.tV = false;
        } else if (this.gMw) {
            showToast(str);
            auK();
            this.gMw = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void z(Bitmap bitmap) {
        this.gMr.bxd().D(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void tP(String str) {
        if (this.tV) {
            this.tV = false;
            return;
        }
        this.gMu = str;
        bwo();
    }

    private void bwr() {
        if (this.tV) {
            this.tV = false;
        } else if (!TextUtils.isEmpty(this.gMu) && !TextUtils.isEmpty(this.gMv)) {
            this.mVideoInfo.setVideoPath(this.gMv);
            this.mVideoInfo.setThumbPath(this.gMu);
            if (this.gMr.bxk() && !TextUtils.isEmpty(this.gMr.bxj())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.gMr.bxj());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.gMy, this.csP, this.mForumName, this.gMp, 13003, this.mVideoInfo, this.mVideoTitleData, this.gMq);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            auK();
            this.gMw = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.k.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.k.music_cloud)));
        this.gMr.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void o(String str, int i, String str2) {
        if (this.tV) {
            this.tV = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.k.mixing_fail);
            auK();
            this.gMr.onResume();
            this.gMw = false;
            if (this.gyx != null) {
                this.gyx.ae(i, str2);
            }
        } else if (this.gMx.bwu()) {
            tR(str);
        } else {
            tS(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bws() {
        this.gMv = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dC(List<PendantData> list) {
        this.gMr.dC(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String tX = com.baidu.tieba.video.editvideo.model.a.bwL().tX(stringExtra);
                if (this.gMr != null && !TextUtils.isEmpty(tX)) {
                    this.gMr.cj(tX, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void tQ(String str) {
        tS(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ap(int i, String str) {
        if (this.gyx != null) {
            this.gyx.ae(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aq(int i, String str) {
        if (this.gyx != null) {
            this.gyx.ae(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        A(bitmap);
    }

    private void tR(String str) {
        this.gMr.bxg();
        this.gMr.bxh();
        this.gMr.bxd().releaseSource();
        this.gMx.tV(str);
    }

    private void tS(String str) {
        File file;
        this.gMv = str;
        if (this.gMw) {
            bwr();
            return;
        }
        String str2 = com.baidu.tieba.video.b.gKK + file.getName();
        com.baidu.tbadk.core.util.k.Z(new File(this.gMv).getAbsolutePath(), str2);
        tT(str2);
        auK();
        finishPage();
    }

    private void tT(String str) {
        try {
            new w(this).dY(str);
            c.ao(this, str);
        } catch (Exception e) {
        }
    }

    private void A(Bitmap bitmap) {
        if (this.gMr == null || this.gMs == null) {
            auK();
        } else if (this.tV) {
            this.tV = false;
        } else {
            if (!TextUtils.isEmpty(this.gMr.getText())) {
                bitmap = this.gMr.t(bitmap);
            }
            if (bitmap != null) {
                this.gMs.b(bitmap, com.baidu.tieba.video.b.gKI);
            }
        }
    }
}
