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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.i.h;
import com.baidu.tieba.i.k;
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
    private String aAs;
    private String bdh;
    private com.baidu.tbadk.core.view.b dbG;
    private h gCP;
    private String gRb;
    private List<VideoTitleData> gRc;
    private com.baidu.tieba.video.editvideo.view.a gRd;
    private SelectCoverModel gRe;
    private SelectMusicModel gRf;
    private String gRg;
    private String gRh;
    private boolean gRi;
    private com.baidu.tieba.video.editvideo.b.a gRj;
    private String gRk;
    private HttpMessageListener gRl;
    private CustomMessageListener gRm;
    private String mForumName;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;
    private boolean vl;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gCP = kVar.aOj();
        }
        this.gRl = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.gRc = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.gRm = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        setContentView(d.h.activity_edit_video);
        this.aAs = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.gRb = getIntent().getStringExtra("video_title");
        this.gRk = getIntent().getStringExtra("KEY_CALL_FROM");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.bdh = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.bdh) && !new File(this.bdh).exists()) {
            finishPage();
        }
        new File(com.baidu.tieba.video.b.gPC).mkdirs();
        this.gRe = new SelectCoverModel(getPageContext(), this, this.gCP);
        this.gRf = new SelectMusicModel(getPageContext(), this);
        this.gRj = new com.baidu.tieba.video.editvideo.b.a(this);
        this.gRj.a(this);
        this.gRd = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.g.root_layout), this.gCP);
        this.gRd.setData(this.bdh);
        this.gRd.ad(getIntent());
        this.gRd.a(this.gRj);
        this.gRd.setGenMaskCoverListener(this);
        this.gRe.bCd();
        this.gRf.bCe();
        this.dbG = new com.baidu.tbadk.core.view.b(getPageContext());
        this.dbG.db(d.j.mixing);
        registerListener(this.gRm);
        bBy();
        registerListener(this.gRl);
        bBx();
        TiebaStatic.log("c12303");
    }

    private void bBw() {
        this.vl = true;
        this.gRh = null;
        this.gRg = null;
        aqz();
    }

    public void bBx() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.aAs)) {
            httpMessage.addParam("forum_id", this.aAs);
        }
        sendMessage(httpMessage);
    }

    private void bBy() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.gRd.getRootView());
        if (this.gRd != null) {
            this.gRd.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gRd != null) {
            this.gRd.onPause();
        }
        if (this.gRj.bBH()) {
            this.gRj.bBI();
        }
        this.gRi = false;
        this.vl = true;
        bBw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gRd != null) {
            this.gRd.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bBY().bBZ();
        com.baidu.tieba.video.editvideo.model.b.bCb().bCc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gRd != null) {
            this.gRd.release();
        }
        if (this.gRe != null) {
            this.gRe.cancelLoadData();
        }
        if (this.gRf != null) {
            this.gRf.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gRd != null) {
            this.gRd.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        aqz();
        this.gRi = false;
        com.baidu.tbadk.core.util.k.r(new File(com.baidu.tieba.video.b.gPB));
        if (this.gRd != null && this.gRd.bCq() != null) {
            this.gRd.bCq().pause();
            this.gRd.bCq().releaseSource();
        }
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBz() {
        if (this.gRd != null && this.gRe != null && this.gRf != null) {
            if (!j.hh()) {
                getPageContext().showToast(d.j.no_network);
            } else if (!this.gRi) {
                this.gRi = true;
                this.vl = false;
                this.gRh = null;
                this.gRg = null;
                this.gRd.onPause();
                this.dbG.aE(true);
                bBB();
            }
        }
    }

    private void aqz() {
        if (this.dbG != null) {
            this.dbG.aE(false);
        }
    }

    private void bBA() {
        if (this.vl) {
            this.vl = false;
        } else if (this.gRd.bCx()) {
            this.gRf.c(this.bdh, this.gRd.bCv(), com.baidu.tieba.video.b.gPB + "video_" + System.currentTimeMillis() + ".mp4", this.gRd.isMute() ? false : true);
        } else if (this.gRd.isMute()) {
            this.gRf.c(this.bdh, null, com.baidu.tieba.video.b.gPB + "video_" + System.currentTimeMillis() + ".mp4", this.gRd.isMute() ? false : true);
        } else {
            n(this.bdh, -4399, "");
        }
    }

    private void bBB() {
        if (this.vl) {
            this.vl = false;
            return;
        }
        String text = this.gRd.getText();
        if (TextUtils.isEmpty(text)) {
            this.gRe.aI(this.bdh, this.gRd.getCurrentPosition());
        } else {
            this.gRe.qq(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBC() {
        File file;
        this.vl = false;
        if (this.gRd.bCx() || this.gRd.isMute()) {
            this.gRi = false;
            this.dbG.aE(true);
            this.gRd.onPause();
            if (this.gRh != null) {
                n(this.gRh, -4399, "");
            } else {
                bBA();
            }
        } else if (this.gRj.bBG()) {
            this.gRi = false;
            this.gRd.onPause();
            this.dbG.aE(true);
            tZ(this.bdh);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.k.Z(new File(this.bdh).getAbsolutePath(), com.baidu.tieba.video.b.gPC + file.getName());
                ub(com.baidu.tieba.video.b.gPC + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void aZf() {
        if (this.gRd == null || this.gRe == null) {
            aqz();
            this.gRi = false;
        } else if (this.vl) {
            this.vl = false;
        } else {
            this.gRe.aI(this.bdh, this.gRd.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void qo(String str) {
        if (this.vl) {
            this.vl = false;
        } else if (this.gRi) {
            showToast(str);
            aqz();
            this.gRi = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void s(Bitmap bitmap) {
        this.gRd.bCq().w(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void tX(String str) {
        if (this.vl) {
            this.vl = false;
            return;
        }
        this.gRg = str;
        bBA();
    }

    private void bBD() {
        if (this.vl) {
            this.vl = false;
        } else if (!TextUtils.isEmpty(this.gRg) && !TextUtils.isEmpty(this.gRh)) {
            this.mVideoInfo.setVideoPath(this.gRh);
            this.mVideoInfo.setThumbPath(this.gRg);
            if (this.gRd.bCx() && !TextUtils.isEmpty(this.gRd.bCw())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.gRd.bCw());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.gRk, this.aAs, this.mForumName, this.gRb, 13003, this.mVideoInfo, this.mVideoTitleData, this.gRc)));
            aqz();
            this.gRi = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.j.music_cloud)));
        this.gRd.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
        if (this.vl) {
            this.vl = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.j.mixing_fail);
            aqz();
            this.gRd.onResume();
            this.gRi = false;
            if (this.gCP != null) {
                this.gCP.S(i, str2);
            }
        } else if (this.gRj.bBG()) {
            tZ(str);
        } else {
            ua(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBE() {
        this.gRh = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dN(List<PendantData> list) {
        this.gRd.dN(list);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String uf = com.baidu.tieba.video.editvideo.model.a.bBY().uf(stringExtra);
                if (this.gRd != null && !TextUtils.isEmpty(uf)) {
                    this.gRd.co(uf, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void tY(String str) {
        ua(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aj(int i, String str) {
        if (this.gCP != null) {
            this.gCP.S(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ak(int i, String str) {
        if (this.gCP != null) {
            this.gCP.S(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        t(bitmap);
    }

    private void tZ(String str) {
        this.gRd.bCt();
        this.gRd.bCu();
        this.gRd.bCq().releaseSource();
        this.gRj.ud(str);
    }

    private void ua(String str) {
        File file;
        this.gRh = str;
        if (this.gRi) {
            bBD();
            return;
        }
        String str2 = com.baidu.tieba.video.b.gPC + file.getName();
        com.baidu.tbadk.core.util.k.Z(new File(this.gRh).getAbsolutePath(), str2);
        ub(str2);
        aqz();
        finishPage();
    }

    private void ub(String str) {
        try {
            new w(this).dI(str);
            c.an(this, str);
        } catch (Exception e) {
        }
    }

    private void t(Bitmap bitmap) {
        if (this.gRd == null || this.gRe == null) {
            aqz();
        } else if (this.vl) {
            this.vl = false;
        } else {
            if (!TextUtils.isEmpty(this.gRd.getText())) {
                bitmap = this.gRd.j(bitmap);
            }
            if (bitmap != null) {
                this.gRe.b(bitmap, com.baidu.tieba.video.b.gPA);
            }
        }
    }
}
