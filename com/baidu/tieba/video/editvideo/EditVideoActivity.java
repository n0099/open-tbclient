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
    private boolean ajC;
    private String bRm;
    private String cXh;
    private com.baidu.tbadk.core.view.b dTo;
    private h gZD;
    private String hof;
    private List<VideoTitleData> hog;
    private com.baidu.tieba.video.editvideo.view.a hoh;
    private SelectCoverModel hoi;
    private SelectMusicModel hoj;
    private String hok;
    private String hol;
    private boolean hom;
    private com.baidu.tieba.video.editvideo.b.a hon;
    private String hoo;
    private HttpMessageListener hop;
    private CustomMessageListener hoq;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gZD = kVar.aVx();
        }
        this.hop = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.hog = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.hoq = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.cXh = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.hof = getIntent().getStringExtra("video_title");
        this.hoo = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.bRm = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.bRm) && !new File(this.bRm).exists()) {
            finishPage();
        }
        new File(com.baidu.tieba.video.b.hmC).mkdirs();
        this.hoi = new SelectCoverModel(getPageContext(), this, this.gZD);
        this.hoj = new SelectMusicModel(getPageContext(), this);
        this.hon = new com.baidu.tieba.video.editvideo.b.a(this);
        this.hon.a(this);
        this.hoh = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.g.root_layout), this.gZD);
        this.hoh.setData(this.bRm);
        this.hoh.ad(getIntent());
        this.hoh.a(this.hon);
        this.hoh.setGenMaskCoverListener(this);
        this.hoi.bBa();
        this.hoj.bBb();
        this.dTo = new com.baidu.tbadk.core.view.b(getPageContext());
        this.dTo.fY(d.j.mixing);
        registerListener(this.hoq);
        bAv();
        registerListener(this.hop);
        bAu();
        TiebaStatic.log("c12303");
    }

    private void bAt() {
        this.ajC = true;
        this.hol = null;
        this.hok = null;
        ayR();
    }

    public void bAu() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.cXh)) {
            httpMessage.addParam("forum_id", this.cXh);
        }
        sendMessage(httpMessage);
    }

    private void bAv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().aN(i == 1);
        getLayoutMode().aM(this.hoh.getRootView());
        if (this.hoh != null) {
            this.hoh.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hoh != null) {
            this.hoh.onPause();
        }
        if (this.hon.bAE()) {
            this.hon.bAF();
        }
        this.hom = false;
        this.ajC = true;
        bAt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hoh != null) {
            this.hoh.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bAV().bAW();
        com.baidu.tieba.video.editvideo.model.b.bAY().bAZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hoh != null) {
            this.hoh.release();
        }
        if (this.hoi != null) {
            this.hoi.cancelLoadData();
        }
        if (this.hoj != null) {
            this.hoj.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hoh != null) {
            this.hoh.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        ayR();
        this.hom = false;
        com.baidu.tbadk.core.util.k.s(new File(com.baidu.tieba.video.b.hmB));
        if (this.hoh != null && this.hoh.bBn() != null) {
            this.hoh.bBn().pause();
            this.hoh.bBn().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bAw() {
        if (this.hoh != null && this.hoi != null && this.hoj != null) {
            if (!j.oJ()) {
                getPageContext().showToast(d.j.no_network);
            } else if (!this.hom) {
                this.hom = true;
                this.ajC = false;
                this.hol = null;
                this.hok = null;
                this.hoh.onPause();
                this.dTo.bn(true);
                bAy();
            }
        }
    }

    private void ayR() {
        if (this.dTo != null) {
            this.dTo.bn(false);
        }
    }

    private void bAx() {
        if (this.ajC) {
            this.ajC = false;
        } else if (this.hoh.bBu()) {
            this.hoj.c(this.bRm, this.hoh.bBs(), com.baidu.tieba.video.b.hmB + "video_" + System.currentTimeMillis() + ".mp4", this.hoh.isMute() ? false : true);
        } else if (this.hoh.isMute()) {
            this.hoj.c(this.bRm, null, com.baidu.tieba.video.b.hmB + "video_" + System.currentTimeMillis() + ".mp4", this.hoh.isMute() ? false : true);
        } else {
            n(this.bRm, -4399, "");
        }
    }

    private void bAy() {
        if (this.ajC) {
            this.ajC = false;
            return;
        }
        String text = this.hoh.getText();
        if (TextUtils.isEmpty(text)) {
            this.hoi.aK(this.bRm, this.hoh.getCurrentPosition());
        } else {
            this.hoi.qL(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bAz() {
        File file;
        this.ajC = false;
        if (this.hoh.bBu() || this.hoh.isMute()) {
            this.hom = false;
            this.dTo.bn(true);
            this.hoh.onPause();
            if (this.hol != null) {
                n(this.hol, -4399, "");
            } else {
                bAx();
            }
        } else if (this.hon.bAD()) {
            this.hom = false;
            this.hoh.onPause();
            this.dTo.bn(true);
            tD(this.bRm);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.k.X(new File(this.bRm).getAbsolutePath(), com.baidu.tieba.video.b.hmC + file.getName());
                tF(com.baidu.tieba.video.b.hmC + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bgC() {
        if (this.hoh == null || this.hoi == null) {
            ayR();
            this.hom = false;
        } else if (this.ajC) {
            this.ajC = false;
        } else {
            this.hoi.aK(this.bRm, this.hoh.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void qJ(String str) {
        if (this.ajC) {
            this.ajC = false;
        } else if (this.hom) {
            showToast(str);
            ayR();
            this.hom = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void s(Bitmap bitmap) {
        this.hoh.bBn().w(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void tB(String str) {
        if (this.ajC) {
            this.ajC = false;
            return;
        }
        this.hok = str;
        bAx();
    }

    private void bAA() {
        if (this.ajC) {
            this.ajC = false;
        } else if (!TextUtils.isEmpty(this.hok) && !TextUtils.isEmpty(this.hol)) {
            this.mVideoInfo.setVideoPath(this.hol);
            this.mVideoInfo.setThumbPath(this.hok);
            if (this.hoh.bBu() && !TextUtils.isEmpty(this.hoh.bBt())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.hoh.bBt());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.hoo, this.cXh, this.mForumName, this.hof, 13003, this.mVideoInfo, this.mVideoTitleData, this.hog);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
            ayR();
            this.hom = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.j.music_cloud)));
        this.hoh.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
        if (this.ajC) {
            this.ajC = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.j.mixing_fail);
            ayR();
            this.hoh.onResume();
            this.hom = false;
            if (this.gZD != null) {
                this.gZD.V(i, str2);
            }
        } else if (this.hon.bAD()) {
            tD(str);
        } else {
            tE(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bAB() {
        this.hol = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dC(List<PendantData> list) {
        this.hoh.dC(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String tJ = com.baidu.tieba.video.editvideo.model.a.bAV().tJ(stringExtra);
                if (this.hoh != null && !TextUtils.isEmpty(tJ)) {
                    this.hoh.ci(tJ, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void tC(String str) {
        tE(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void al(int i, String str) {
        if (this.gZD != null) {
            this.gZD.V(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void am(int i, String str) {
        if (this.gZD != null) {
            this.gZD.V(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        t(bitmap);
    }

    private void tD(String str) {
        this.hoh.bBq();
        this.hoh.bBr();
        this.hoh.bBn().releaseSource();
        this.hon.tH(str);
    }

    private void tE(String str) {
        File file;
        this.hol = str;
        if (this.hom) {
            bAA();
            return;
        }
        String str2 = com.baidu.tieba.video.b.hmC + file.getName();
        com.baidu.tbadk.core.util.k.X(new File(this.hol).getAbsolutePath(), str2);
        tF(str2);
        ayR();
        finishPage();
    }

    private void tF(String str) {
        try {
            new w(this).dV(str);
            c.ao(this, str);
        } catch (Exception e) {
        }
    }

    private void t(Bitmap bitmap) {
        if (this.hoh == null || this.hoi == null) {
            ayR();
        } else if (this.ajC) {
            this.ajC = false;
        } else {
            if (!TextUtils.isEmpty(this.hoh.getText())) {
                bitmap = this.hoh.m(bitmap);
            }
            if (bitmap != null) {
                this.hoi.b(bitmap, com.baidu.tieba.video.b.hmA);
            }
        }
    }
}
