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
    private String crJ;
    private com.baidu.tbadk.core.view.a drT;
    private CustomMessageListener gLA;
    private String gLp;
    private List<VideoTitleData> gLq;
    private com.baidu.tieba.video.editvideo.view.a gLr;
    private SelectCoverModel gLs;
    private SelectMusicModel gLt;
    private String gLu;
    private String gLv;
    private boolean gLw;
    private com.baidu.tieba.video.editvideo.b.a gLx;
    private String gLy;
    private HttpMessageListener gLz;
    private h gxw;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;
    private boolean tW;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gxw = kVar.aSb();
        }
        this.gLz = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.gLq = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.gLA = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.crJ = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.gLp = getIntent().getStringExtra("video_title");
        this.gLy = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.bdl = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.bdl) && !new File(this.bdl).exists()) {
            finishPage();
        }
        new File(com.baidu.tieba.video.b.gJK).mkdirs();
        this.gLs = new SelectCoverModel(getPageContext(), this, this.gxw);
        this.gLt = new SelectMusicModel(getPageContext(), this);
        this.gLx = new com.baidu.tieba.video.editvideo.b.a(this);
        this.gLx.a(this);
        this.gLr = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.g.root_layout), this.gxw);
        this.gLr.setData(this.bdl);
        this.gLr.aa(getIntent());
        this.gLr.a(this.gLx);
        this.gLr.setGenMaskCoverListener(this);
        this.gLs.bwS();
        this.gLt.bwT();
        this.drT = new com.baidu.tbadk.core.view.a(getPageContext());
        this.drT.da(d.k.mixing);
        registerListener(this.gLA);
        bwo();
        registerListener(this.gLz);
        bwn();
        TiebaStatic.log("c12303");
    }

    private void bwm() {
        this.tW = true;
        this.gLv = null;
        this.gLu = null;
        auL();
    }

    public void bwn() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.crJ)) {
            httpMessage.addParam("forum_id", this.crJ);
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
        getLayoutMode().u(this.gLr.getRootView());
        if (this.gLr != null) {
            this.gLr.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gLr != null) {
            this.gLr.onPause();
        }
        if (this.gLx.bwx()) {
            this.gLx.bwy();
        }
        this.gLw = false;
        this.tW = true;
        bwm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gLr != null) {
            this.gLr.onResume();
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
        if (this.gLr != null) {
            this.gLr.release();
        }
        if (this.gLs != null) {
            this.gLs.cancelLoadData();
        }
        if (this.gLt != null) {
            this.gLt.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gLr != null) {
            this.gLr.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        auL();
        this.gLw = false;
        if (this.gLr != null && this.gLr.bxf() != null) {
            this.gLr.bxf().pause();
            this.gLr.bxf().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bwp() {
        if (this.gLr != null && this.gLs != null && this.gLt != null) {
            if (!j.gP()) {
                getPageContext().showToast(d.k.no_network);
            } else if (!this.gLw) {
                this.gLw = true;
                this.tW = false;
                this.gLv = null;
                this.gLu = null;
                this.gLr.onPause();
                this.drT.aI(true);
                bwr();
            }
        }
    }

    private void auL() {
        if (this.drT != null) {
            this.drT.aI(false);
        }
    }

    private void bwq() {
        if (this.tW) {
            this.tW = false;
        } else if (this.gLr.bxm()) {
            this.gLt.c(this.bdl, this.gLr.bxk(), com.baidu.tieba.video.b.gJJ + "video_" + System.currentTimeMillis() + ".mp4", this.gLr.isMute() ? false : true);
        } else if (this.gLr.isMute()) {
            this.gLt.c(this.bdl, null, com.baidu.tieba.video.b.gJJ + "video_" + System.currentTimeMillis() + ".mp4", this.gLr.isMute() ? false : true);
        } else {
            o(this.bdl, -4399, "");
        }
    }

    private void bwr() {
        if (this.tW) {
            this.tW = false;
            return;
        }
        String text = this.gLr.getText();
        if (TextUtils.isEmpty(text)) {
            this.gLs.aM(this.bdl, this.gLr.getCurrentPosition());
        } else {
            this.gLs.qX(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bws() {
        File file;
        this.tW = false;
        if (this.gLr.bxm() || this.gLr.isMute()) {
            this.gLw = false;
            this.drT.aI(true);
            this.gLr.onPause();
            if (this.gLv != null) {
                o(this.gLv, -4399, "");
            } else {
                bwq();
            }
        } else if (this.gLx.bww()) {
            this.gLw = false;
            this.gLr.onPause();
            this.drT.aI(true);
            tO(this.bdl);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.k.Z(new File(this.bdl).getAbsolutePath(), com.baidu.tieba.video.b.gJK + file.getName());
                tQ(com.baidu.tieba.video.b.gJK + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bcS() {
        if (this.gLr == null || this.gLs == null) {
            auL();
            this.gLw = false;
        } else if (this.tW) {
            this.tW = false;
        } else {
            this.gLs.aM(this.bdl, this.gLr.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void qV(String str) {
        if (this.tW) {
            this.tW = false;
        } else if (this.gLw) {
            showToast(str);
            auL();
            this.gLw = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void z(Bitmap bitmap) {
        this.gLr.bxf().D(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void tM(String str) {
        if (this.tW) {
            this.tW = false;
            return;
        }
        this.gLu = str;
        bwq();
    }

    private void bwt() {
        if (this.tW) {
            this.tW = false;
        } else if (!TextUtils.isEmpty(this.gLu) && !TextUtils.isEmpty(this.gLv)) {
            this.mVideoInfo.setVideoPath(this.gLv);
            this.mVideoInfo.setThumbPath(this.gLu);
            if (this.gLr.bxm() && !TextUtils.isEmpty(this.gLr.bxl())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.gLr.bxl());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.gLy, this.crJ, this.mForumName, this.gLp, 13003, this.mVideoInfo, this.mVideoTitleData, this.gLq);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            auL();
            this.gLw = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.k.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.k.music_cloud)));
        this.gLr.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void o(String str, int i, String str2) {
        if (this.tW) {
            this.tW = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.k.mixing_fail);
            auL();
            this.gLr.onResume();
            this.gLw = false;
            if (this.gxw != null) {
                this.gxw.ae(i, str2);
            }
        } else if (this.gLx.bww()) {
            tO(str);
        } else {
            tP(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bwu() {
        this.gLv = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dz(List<PendantData> list) {
        this.gLr.dz(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String tU = com.baidu.tieba.video.editvideo.model.a.bwN().tU(stringExtra);
                if (this.gLr != null && !TextUtils.isEmpty(tU)) {
                    this.gLr.cj(tU, stringExtra2);
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
        if (this.gxw != null) {
            this.gxw.ae(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aq(int i, String str) {
        if (this.gxw != null) {
            this.gxw.ae(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        A(bitmap);
    }

    private void tO(String str) {
        this.gLr.bxi();
        this.gLr.bxj();
        this.gLr.bxf().releaseSource();
        this.gLx.tS(str);
    }

    private void tP(String str) {
        File file;
        this.gLv = str;
        if (this.gLw) {
            bwt();
            return;
        }
        String str2 = com.baidu.tieba.video.b.gJK + file.getName();
        com.baidu.tbadk.core.util.k.Z(new File(this.gLv).getAbsolutePath(), str2);
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
        if (this.gLr == null || this.gLs == null) {
            auL();
        } else if (this.tW) {
            this.tW = false;
        } else {
            if (!TextUtils.isEmpty(this.gLr.getText())) {
                bitmap = this.gLr.t(bitmap);
            }
            if (bitmap != null) {
                this.gLs.b(bitmap, com.baidu.tieba.video.b.gJI);
            }
        }
    }
}
