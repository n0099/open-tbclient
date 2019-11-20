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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.j.h;
import com.baidu.tieba.j.l;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.video.c;
import com.baidu.tieba.video.editvideo.b.b;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.model.SelectCoverModel;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class EditVideoActivity extends BaseActivity implements a, b, b.a, MaskVideoView.b {
    private String aFg;
    private String ajt;
    private String ePc;
    private com.baidu.tbadk.core.view.b fUF;
    private String fUk;
    private h jiP;
    private int jxI;
    private String jxJ;
    private List<VideoTitleData> jxK;
    private com.baidu.tieba.video.editvideo.view.a jxL;
    private SelectCoverModel jxM;
    private SelectMusicModel jxN;
    private String jxO;
    private String jxP;
    private boolean jxQ;
    private com.baidu.tieba.video.editvideo.b.a jxR;
    private HttpMessageListener jxS;
    private CustomMessageListener jxT;
    private String mForumName;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;
    private boolean oT;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.jiP = lVar.bMW();
        }
        this.jxS = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.jxK = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.jxT = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        setContentView(R.layout.activity_edit_video);
        this.ePc = getIntent().getStringExtra("forum_id");
        this.jxI = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.jxJ = getIntent().getStringExtra("video_title");
        this.fUk = getIntent().getStringExtra("KEY_CALL_FROM");
        this.ajt = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.aFg = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.aFg) && !new File(this.aFg).exists()) {
            finishPage();
        }
        new File(c.jwe).mkdirs();
        this.jxM = new SelectCoverModel(getPageContext(), this, this.jiP);
        this.jxN = new SelectMusicModel(getPageContext(), this);
        this.jxR = new com.baidu.tieba.video.editvideo.b.a(this);
        this.jxR.a(this);
        this.jxL = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.jiP);
        this.jxL.setData(this.aFg);
        this.jxL.aH(getIntent());
        this.jxL.a(this.jxR);
        this.jxL.setGenMaskCoverListener(this);
        this.jxM.ctA();
        this.jxN.ctB();
        this.fUF = new com.baidu.tbadk.core.view.b(getPageContext());
        this.fUF.setTipString(R.string.mixing);
        registerListener(this.jxT);
        csX();
        registerListener(this.jxS);
        csW();
        TiebaStatic.log("c12303");
    }

    private void csV() {
        this.oT = true;
        this.jxP = null;
        this.jxO = null;
        bpL();
    }

    public void csW() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.ePc)) {
            httpMessage.addParam("forum_id", this.ePc);
        }
        sendMessage(httpMessage);
    }

    private void csX() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jxL.getRootView());
        if (this.jxL != null) {
            this.jxL.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jxL != null) {
            this.jxL.onPause();
        }
        if (this.jxR.ctf()) {
            this.jxR.ctg();
        }
        this.jxQ = false;
        this.oT = true;
        csV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jxL != null) {
            this.jxL.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.ctv().ctw();
        com.baidu.tieba.video.editvideo.model.b.cty().ctz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jxL != null) {
            this.jxL.release();
        }
        if (this.jxM != null) {
            this.jxM.cancelLoadData();
        }
        if (this.jxN != null) {
            this.jxN.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jxL != null) {
            this.jxL.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        bpL();
        this.jxQ = false;
        if (this.jxL != null && this.jxL.ctN() != null) {
            this.jxL.ctN().pause();
            this.jxL.ctN().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void tU() {
        if (this.jxL == null || this.jxM == null || this.jxN == null) {
            bpL();
            this.jxQ = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.jxQ) {
            this.jxQ = true;
            this.oT = false;
            this.jxP = null;
            this.jxO = null;
            this.jxL.onPause();
            this.fUF.setDialogVisiable(true);
            csZ();
        }
    }

    private void bpL() {
        if (this.fUF != null) {
            this.fUF.setDialogVisiable(false);
        }
    }

    private void csY() {
        if (this.oT) {
            this.oT = false;
        } else if (this.jxL.ctU()) {
            this.jxN.e(this.aFg, this.jxL.ctS(), c.jwd + "video_" + System.currentTimeMillis() + ".mp4", this.jxL.isMute() ? false : true);
        } else if (this.jxL.isMute()) {
            this.jxN.e(this.aFg, null, c.jwd + "video_" + System.currentTimeMillis() + ".mp4", this.jxL.isMute() ? false : true);
        } else {
            r(this.aFg, -4399, "");
        }
    }

    private void csZ() {
        if (this.oT) {
            this.oT = false;
            return;
        }
        String text = this.jxL.getText();
        if (TextUtils.isEmpty(text)) {
            this.jxM.bn(this.aFg, this.jxL.getCurrentPosition());
        } else {
            this.jxM.Br(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cta() {
        File file;
        this.oT = false;
        if (this.jxL.ctU() || this.jxL.isMute()) {
            this.jxQ = false;
            this.fUF.setDialogVisiable(true);
            this.jxL.onPause();
            if (this.jxP != null) {
                r(this.jxP, -4399, "");
            } else {
                csY();
            }
        } else if (this.jxR.cte()) {
            this.jxQ = false;
            this.jxL.onPause();
            this.fUF.setDialogVisiable(true);
            EK(this.aFg);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.copyFile(new File(this.aFg).getAbsolutePath(), c.jwe + file.getName());
                EM(c.jwe + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bYv() {
        if (this.jxL == null || this.jxM == null) {
            bpL();
            this.jxQ = false;
        } else if (this.oT) {
            this.oT = false;
        } else {
            this.jxM.bn(this.aFg, this.jxL.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Bo(String str) {
        if (this.oT) {
            this.oT = false;
        } else if (this.jxQ) {
            showToast(str);
            bpL();
            this.jxQ = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void F(Bitmap bitmap) {
        this.jxL.ctN().J(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void EI(String str) {
        if (this.oT) {
            this.oT = false;
            return;
        }
        this.jxO = str;
        csY();
    }

    private void ctb() {
        if (this.oT) {
            this.oT = false;
        } else if (!TextUtils.isEmpty(this.jxO) && !TextUtils.isEmpty(this.jxP)) {
            this.mVideoInfo.setVideoPath(this.jxP);
            this.mVideoInfo.setThumbPath(this.jxO);
            if (this.jxL.ctU() && !TextUtils.isEmpty(this.jxL.ctT())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.jxL.ctT());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.fUk, this.ePc, this.mForumName, this.jxJ, RequestResponseCode.REQUEST_WRITE_NEW, this.mVideoInfo, this.mVideoTitleData, this.jxK);
            if (!StringUtils.isNull(this.ajt)) {
                writeVideoActivityConfig.addFromType(this.ajt);
            }
            writeVideoActivityConfig.setProZone(this.jxI);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
            bpL();
            this.jxQ = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(R.string.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(R.string.music_cloud)));
        this.jxL.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void r(String str, int i, String str2) {
        if (this.oT) {
            this.oT = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.mixing_fail);
            bpL();
            this.jxL.onResume();
            this.jxQ = false;
            if (this.jiP != null) {
                this.jiP.aw(i, str2);
            }
        } else if (this.jxR.cte()) {
            EK(str);
        } else {
            EL(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void ctc() {
        this.jxP = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void eB(List<PendantData> list) {
        this.jxL.eB(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String EP = com.baidu.tieba.video.editvideo.model.a.ctv().EP(stringExtra);
                if (this.jxL != null && !TextUtils.isEmpty(EP)) {
                    this.jxL.eg(EP, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void EJ(String str) {
        EL(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aK(int i, String str) {
        if (this.jiP != null) {
            this.jiP.aw(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aL(int i, String str) {
        if (this.jiP != null) {
            this.jiP.aw(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        G(bitmap);
    }

    private void EK(String str) {
        this.jxL.ctQ();
        this.jxL.ctR();
        this.jxL.ctN().releaseSource();
        this.jxR.EO(str);
    }

    private void EL(String str) {
        File file;
        this.jxP = str;
        if (this.jxQ) {
            ctb();
            return;
        }
        String str2 = c.jwe + file.getName();
        m.copyFile(new File(this.jxP).getAbsolutePath(), str2);
        EM(str2);
        bpL();
        finishPage();
    }

    private void EM(String str) {
        try {
            new w(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.aU(this, str);
        } catch (Exception e) {
            bpL();
            this.jxQ = false;
        }
    }

    private void G(Bitmap bitmap) {
        if (this.jxL == null || this.jxM == null) {
            bpL();
            this.jxQ = false;
        } else if (this.oT) {
            this.oT = false;
        } else {
            if (!TextUtils.isEmpty(this.jxL.getText())) {
                bitmap = this.jxL.z(bitmap);
            }
            if (bitmap != null) {
                this.jxM.b(bitmap, c.jwc);
            }
        }
    }
}
