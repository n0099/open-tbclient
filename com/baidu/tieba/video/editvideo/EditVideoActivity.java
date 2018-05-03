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
    private String bdl;
    private String crG;
    private com.baidu.tbadk.core.view.a drQ;
    private String gLm;
    private List<VideoTitleData> gLn;
    private com.baidu.tieba.video.editvideo.view.a gLo;
    private SelectCoverModel gLp;
    private SelectMusicModel gLq;
    private String gLr;
    private String gLs;
    private boolean gLt;
    private com.baidu.tieba.video.editvideo.b.a gLu;
    private String gLv;
    private HttpMessageListener gLw;
    private CustomMessageListener gLx;
    private h gxt;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;
    private boolean tW;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gxt = kVar.aSb();
        }
        this.gLw = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.gLn = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.gLx = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.crG = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.gLm = getIntent().getStringExtra("video_title");
        this.gLv = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.bdl = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.bdl) && !new File(this.bdl).exists()) {
            finishPage();
        }
        new File(com.baidu.tieba.video.b.gJH).mkdirs();
        this.gLp = new SelectCoverModel(getPageContext(), this, this.gxt);
        this.gLq = new SelectMusicModel(getPageContext(), this);
        this.gLu = new com.baidu.tieba.video.editvideo.b.a(this);
        this.gLu.a(this);
        this.gLo = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.g.root_layout), this.gxt);
        this.gLo.setData(this.bdl);
        this.gLo.aa(getIntent());
        this.gLo.a(this.gLu);
        this.gLo.setGenMaskCoverListener(this);
        this.gLp.bwS();
        this.gLq.bwT();
        this.drQ = new com.baidu.tbadk.core.view.a(getPageContext());
        this.drQ.cZ(d.k.mixing);
        registerListener(this.gLx);
        bwo();
        registerListener(this.gLw);
        bwn();
        TiebaStatic.log("c12303");
    }

    private void bwm() {
        this.tW = true;
        this.gLs = null;
        this.gLr = null;
        auL();
    }

    public void bwn() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.crG)) {
            httpMessage.addParam("forum_id", this.crG);
        }
        sendMessage(httpMessage);
    }

    private void bwo() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().u(this.gLo.getRootView());
        if (this.gLo != null) {
            this.gLo.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gLo != null) {
            this.gLo.onPause();
        }
        if (this.gLu.bwx()) {
            this.gLu.bwy();
        }
        this.gLt = false;
        this.tW = true;
        bwm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gLo != null) {
            this.gLo.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bwN().bwO();
        com.baidu.tieba.video.editvideo.model.b.bwQ().bwR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gLo != null) {
            this.gLo.release();
        }
        if (this.gLp != null) {
            this.gLp.cancelLoadData();
        }
        if (this.gLq != null) {
            this.gLq.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gLo != null) {
            this.gLo.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        auL();
        this.gLt = false;
        if (this.gLo != null && this.gLo.bxf() != null) {
            this.gLo.bxf().pause();
            this.gLo.bxf().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bwp() {
        if (this.gLo != null && this.gLp != null && this.gLq != null) {
            if (!j.gP()) {
                getPageContext().showToast(d.k.no_network);
            } else if (!this.gLt) {
                this.gLt = true;
                this.tW = false;
                this.gLs = null;
                this.gLr = null;
                this.gLo.onPause();
                this.drQ.aI(true);
                bwr();
            }
        }
    }

    private void auL() {
        if (this.drQ != null) {
            this.drQ.aI(false);
        }
    }

    private void bwq() {
        if (this.tW) {
            this.tW = false;
        } else if (this.gLo.bxm()) {
            this.gLq.c(this.bdl, this.gLo.bxk(), com.baidu.tieba.video.b.gJG + "video_" + System.currentTimeMillis() + ".mp4", this.gLo.isMute() ? false : true);
        } else if (this.gLo.isMute()) {
            this.gLq.c(this.bdl, null, com.baidu.tieba.video.b.gJG + "video_" + System.currentTimeMillis() + ".mp4", this.gLo.isMute() ? false : true);
        } else {
            o(this.bdl, -4399, "");
        }
    }

    private void bwr() {
        if (this.tW) {
            this.tW = false;
            return;
        }
        String text = this.gLo.getText();
        if (TextUtils.isEmpty(text)) {
            this.gLp.aM(this.bdl, this.gLo.getCurrentPosition());
        } else {
            this.gLp.qX(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bws() {
        File file;
        this.tW = false;
        if (this.gLo.bxm() || this.gLo.isMute()) {
            this.gLt = false;
            this.drQ.aI(true);
            this.gLo.onPause();
            if (this.gLs != null) {
                o(this.gLs, -4399, "");
            } else {
                bwq();
            }
        } else if (this.gLu.bww()) {
            this.gLt = false;
            this.gLo.onPause();
            this.drQ.aI(true);
            tO(this.bdl);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.k.Z(new File(this.bdl).getAbsolutePath(), com.baidu.tieba.video.b.gJH + file.getName());
                tQ(com.baidu.tieba.video.b.gJH + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bcS() {
        if (this.gLo == null || this.gLp == null) {
            auL();
            this.gLt = false;
        } else if (this.tW) {
            this.tW = false;
        } else {
            this.gLp.aM(this.bdl, this.gLo.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void qV(String str) {
        if (this.tW) {
            this.tW = false;
        } else if (this.gLt) {
            showToast(str);
            auL();
            this.gLt = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void z(Bitmap bitmap) {
        this.gLo.bxf().D(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void tM(String str) {
        if (this.tW) {
            this.tW = false;
            return;
        }
        this.gLr = str;
        bwq();
    }

    private void bwt() {
        if (this.tW) {
            this.tW = false;
        } else if (!TextUtils.isEmpty(this.gLr) && !TextUtils.isEmpty(this.gLs)) {
            this.mVideoInfo.setVideoPath(this.gLs);
            this.mVideoInfo.setThumbPath(this.gLr);
            if (this.gLo.bxm() && !TextUtils.isEmpty(this.gLo.bxl())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.gLo.bxl());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.gLv, this.crG, this.mForumName, this.gLm, 13003, this.mVideoInfo, this.mVideoTitleData, this.gLn);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            auL();
            this.gLt = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.k.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.k.music_cloud)));
        this.gLo.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void o(String str, int i, String str2) {
        if (this.tW) {
            this.tW = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.k.mixing_fail);
            auL();
            this.gLo.onResume();
            this.gLt = false;
            if (this.gxt != null) {
                this.gxt.ae(i, str2);
            }
        } else if (this.gLu.bww()) {
            tO(str);
        } else {
            tP(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bwu() {
        this.gLs = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dz(List<PendantData> list) {
        this.gLo.dz(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String tU = com.baidu.tieba.video.editvideo.model.a.bwN().tU(stringExtra);
                if (this.gLo != null && !TextUtils.isEmpty(tU)) {
                    this.gLo.cj(tU, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void tN(String str) {
        tP(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ap(int i, String str) {
        if (this.gxt != null) {
            this.gxt.ae(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aq(int i, String str) {
        if (this.gxt != null) {
            this.gxt.ae(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        A(bitmap);
    }

    private void tO(String str) {
        this.gLo.bxi();
        this.gLo.bxj();
        this.gLo.bxf().releaseSource();
        this.gLu.tS(str);
    }

    private void tP(String str) {
        File file;
        this.gLs = str;
        if (this.gLt) {
            bwt();
            return;
        }
        String str2 = com.baidu.tieba.video.b.gJH + file.getName();
        com.baidu.tbadk.core.util.k.Z(new File(this.gLs).getAbsolutePath(), str2);
        tQ(str2);
        auL();
        finishPage();
    }

    private void tQ(String str) {
        try {
            new w(this).dY(str);
            c.ao(this, str);
        } catch (Exception e) {
        }
    }

    private void A(Bitmap bitmap) {
        if (this.gLo == null || this.gLp == null) {
            auL();
        } else if (this.tW) {
            this.tW = false;
        } else {
            if (!TextUtils.isEmpty(this.gLo.getText())) {
                bitmap = this.gLo.t(bitmap);
            }
            if (bitmap != null) {
                this.gLp.b(bitmap, com.baidu.tieba.video.b.gJF);
            }
        }
    }
}
