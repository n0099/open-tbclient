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
    private String aAv;
    private String bdl;
    private com.baidu.tbadk.core.view.b dbK;
    private h gCU;
    private String gRg;
    private List<VideoTitleData> gRh;
    private com.baidu.tieba.video.editvideo.view.a gRi;
    private SelectCoverModel gRj;
    private SelectMusicModel gRk;
    private String gRl;
    private String gRm;
    private boolean gRn;
    private com.baidu.tieba.video.editvideo.b.a gRo;
    private String gRp;
    private HttpMessageListener gRq;
    private CustomMessageListener gRr;
    private String mForumName;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;
    private boolean vm;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gCU = kVar.aOk();
        }
        this.gRq = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.gRh = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.gRr = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.aAv = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.gRg = getIntent().getStringExtra("video_title");
        this.gRp = getIntent().getStringExtra("KEY_CALL_FROM");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.bdl = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.bdl) && !new File(this.bdl).exists()) {
            finishPage();
        }
        new File(com.baidu.tieba.video.b.gPH).mkdirs();
        this.gRj = new SelectCoverModel(getPageContext(), this, this.gCU);
        this.gRk = new SelectMusicModel(getPageContext(), this);
        this.gRo = new com.baidu.tieba.video.editvideo.b.a(this);
        this.gRo.a(this);
        this.gRi = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.g.root_layout), this.gCU);
        this.gRi.setData(this.bdl);
        this.gRi.ad(getIntent());
        this.gRi.a(this.gRo);
        this.gRi.setGenMaskCoverListener(this);
        this.gRj.bCe();
        this.gRk.bCf();
        this.dbK = new com.baidu.tbadk.core.view.b(getPageContext());
        this.dbK.db(d.j.mixing);
        registerListener(this.gRr);
        bBz();
        registerListener(this.gRq);
        bBy();
        TiebaStatic.log("c12303");
    }

    private void bBx() {
        this.vm = true;
        this.gRm = null;
        this.gRl = null;
        aqA();
    }

    public void bBy() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.aAv)) {
            httpMessage.addParam("forum_id", this.aAv);
        }
        sendMessage(httpMessage);
    }

    private void bBz() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.gRi.getRootView());
        if (this.gRi != null) {
            this.gRi.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gRi != null) {
            this.gRi.onPause();
        }
        if (this.gRo.bBI()) {
            this.gRo.bBJ();
        }
        this.gRn = false;
        this.vm = true;
        bBx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gRi != null) {
            this.gRi.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bBZ().bCa();
        com.baidu.tieba.video.editvideo.model.b.bCc().bCd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gRi != null) {
            this.gRi.release();
        }
        if (this.gRj != null) {
            this.gRj.cancelLoadData();
        }
        if (this.gRk != null) {
            this.gRk.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gRi != null) {
            this.gRi.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        aqA();
        this.gRn = false;
        com.baidu.tbadk.core.util.k.r(new File(com.baidu.tieba.video.b.gPG));
        if (this.gRi != null && this.gRi.bCr() != null) {
            this.gRi.bCr().pause();
            this.gRi.bCr().releaseSource();
        }
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBA() {
        if (this.gRi != null && this.gRj != null && this.gRk != null) {
            if (!j.hh()) {
                getPageContext().showToast(d.j.no_network);
            } else if (!this.gRn) {
                this.gRn = true;
                this.vm = false;
                this.gRm = null;
                this.gRl = null;
                this.gRi.onPause();
                this.dbK.aE(true);
                bBC();
            }
        }
    }

    private void aqA() {
        if (this.dbK != null) {
            this.dbK.aE(false);
        }
    }

    private void bBB() {
        if (this.vm) {
            this.vm = false;
        } else if (this.gRi.bCy()) {
            this.gRk.c(this.bdl, this.gRi.bCw(), com.baidu.tieba.video.b.gPG + "video_" + System.currentTimeMillis() + ".mp4", this.gRi.isMute() ? false : true);
        } else if (this.gRi.isMute()) {
            this.gRk.c(this.bdl, null, com.baidu.tieba.video.b.gPG + "video_" + System.currentTimeMillis() + ".mp4", this.gRi.isMute() ? false : true);
        } else {
            n(this.bdl, -4399, "");
        }
    }

    private void bBC() {
        if (this.vm) {
            this.vm = false;
            return;
        }
        String text = this.gRi.getText();
        if (TextUtils.isEmpty(text)) {
            this.gRj.aI(this.bdl, this.gRi.getCurrentPosition());
        } else {
            this.gRj.qq(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBD() {
        File file;
        this.vm = false;
        if (this.gRi.bCy() || this.gRi.isMute()) {
            this.gRn = false;
            this.dbK.aE(true);
            this.gRi.onPause();
            if (this.gRm != null) {
                n(this.gRm, -4399, "");
            } else {
                bBB();
            }
        } else if (this.gRo.bBH()) {
            this.gRn = false;
            this.gRi.onPause();
            this.dbK.aE(true);
            tZ(this.bdl);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.k.Z(new File(this.bdl).getAbsolutePath(), com.baidu.tieba.video.b.gPH + file.getName());
                ub(com.baidu.tieba.video.b.gPH + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void aZg() {
        if (this.gRi == null || this.gRj == null) {
            aqA();
            this.gRn = false;
        } else if (this.vm) {
            this.vm = false;
        } else {
            this.gRj.aI(this.bdl, this.gRi.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void qo(String str) {
        if (this.vm) {
            this.vm = false;
        } else if (this.gRn) {
            showToast(str);
            aqA();
            this.gRn = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void s(Bitmap bitmap) {
        this.gRi.bCr().w(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void tX(String str) {
        if (this.vm) {
            this.vm = false;
            return;
        }
        this.gRl = str;
        bBB();
    }

    private void bBE() {
        if (this.vm) {
            this.vm = false;
        } else if (!TextUtils.isEmpty(this.gRl) && !TextUtils.isEmpty(this.gRm)) {
            this.mVideoInfo.setVideoPath(this.gRm);
            this.mVideoInfo.setThumbPath(this.gRl);
            if (this.gRi.bCy() && !TextUtils.isEmpty(this.gRi.bCx())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.gRi.bCx());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.gRp, this.aAv, this.mForumName, this.gRg, 13003, this.mVideoInfo, this.mVideoTitleData, this.gRh)));
            aqA();
            this.gRn = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.j.music_cloud)));
        this.gRi.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
        if (this.vm) {
            this.vm = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.j.mixing_fail);
            aqA();
            this.gRi.onResume();
            this.gRn = false;
            if (this.gCU != null) {
                this.gCU.S(i, str2);
            }
        } else if (this.gRo.bBH()) {
            tZ(str);
        } else {
            ua(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBF() {
        this.gRm = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dN(List<PendantData> list) {
        this.gRi.dN(list);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String uf = com.baidu.tieba.video.editvideo.model.a.bBZ().uf(stringExtra);
                if (this.gRi != null && !TextUtils.isEmpty(uf)) {
                    this.gRi.co(uf, stringExtra2);
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
        if (this.gCU != null) {
            this.gCU.S(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ak(int i, String str) {
        if (this.gCU != null) {
            this.gCU.S(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        t(bitmap);
    }

    private void tZ(String str) {
        this.gRi.bCu();
        this.gRi.bCv();
        this.gRi.bCr().releaseSource();
        this.gRo.ud(str);
    }

    private void ua(String str) {
        File file;
        this.gRm = str;
        if (this.gRn) {
            bBE();
            return;
        }
        String str2 = com.baidu.tieba.video.b.gPH + file.getName();
        com.baidu.tbadk.core.util.k.Z(new File(this.gRm).getAbsolutePath(), str2);
        ub(str2);
        aqA();
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
        if (this.gRi == null || this.gRj == null) {
            aqA();
        } else if (this.vm) {
            this.vm = false;
        } else {
            if (!TextUtils.isEmpty(this.gRi.getText())) {
                bitmap = this.gRi.j(bitmap);
            }
            if (bitmap != null) {
                this.gRj.b(bitmap, com.baidu.tieba.video.b.gPF);
            }
        }
    }
}
