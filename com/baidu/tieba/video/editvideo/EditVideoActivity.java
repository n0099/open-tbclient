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
    private String aFy;
    private String ajL;
    private String ePT;
    private String fVb;
    private com.baidu.tbadk.core.view.b fVw;
    private h jjG;
    private String jyA;
    private List<VideoTitleData> jyB;
    private com.baidu.tieba.video.editvideo.view.a jyC;
    private SelectCoverModel jyD;
    private SelectMusicModel jyE;
    private String jyF;
    private String jyG;
    private boolean jyH;
    private com.baidu.tieba.video.editvideo.b.a jyI;
    private HttpMessageListener jyJ;
    private CustomMessageListener jyK;
    private int jyz;
    private String mForumName;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;
    private boolean pz;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.jjG = lVar.bMY();
        }
        this.jyJ = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.jyB = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.jyK = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.ePT = getIntent().getStringExtra("forum_id");
        this.jyz = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.jyA = getIntent().getStringExtra("video_title");
        this.fVb = getIntent().getStringExtra("KEY_CALL_FROM");
        this.ajL = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.aFy = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.aFy) && !new File(this.aFy).exists()) {
            finishPage();
        }
        new File(c.jwV).mkdirs();
        this.jyD = new SelectCoverModel(getPageContext(), this, this.jjG);
        this.jyE = new SelectMusicModel(getPageContext(), this);
        this.jyI = new com.baidu.tieba.video.editvideo.b.a(this);
        this.jyI.a(this);
        this.jyC = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.jjG);
        this.jyC.setData(this.aFy);
        this.jyC.aH(getIntent());
        this.jyC.a(this.jyI);
        this.jyC.setGenMaskCoverListener(this);
        this.jyD.ctC();
        this.jyE.ctD();
        this.fVw = new com.baidu.tbadk.core.view.b(getPageContext());
        this.fVw.setTipString(R.string.mixing);
        registerListener(this.jyK);
        csZ();
        registerListener(this.jyJ);
        csY();
        TiebaStatic.log("c12303");
    }

    private void csX() {
        this.pz = true;
        this.jyG = null;
        this.jyF = null;
        bpN();
    }

    public void csY() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.ePT)) {
            httpMessage.addParam("forum_id", this.ePT);
        }
        sendMessage(httpMessage);
    }

    private void csZ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jyC.getRootView());
        if (this.jyC != null) {
            this.jyC.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jyC != null) {
            this.jyC.onPause();
        }
        if (this.jyI.cth()) {
            this.jyI.cti();
        }
        this.jyH = false;
        this.pz = true;
        csX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jyC != null) {
            this.jyC.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.ctx().cty();
        com.baidu.tieba.video.editvideo.model.b.ctA().ctB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jyC != null) {
            this.jyC.release();
        }
        if (this.jyD != null) {
            this.jyD.cancelLoadData();
        }
        if (this.jyE != null) {
            this.jyE.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jyC != null) {
            this.jyC.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        bpN();
        this.jyH = false;
        if (this.jyC != null && this.jyC.ctP() != null) {
            this.jyC.ctP().pause();
            this.jyC.ctP().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void tT() {
        if (this.jyC == null || this.jyD == null || this.jyE == null) {
            bpN();
            this.jyH = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.jyH) {
            this.jyH = true;
            this.pz = false;
            this.jyG = null;
            this.jyF = null;
            this.jyC.onPause();
            this.fVw.setDialogVisiable(true);
            ctb();
        }
    }

    private void bpN() {
        if (this.fVw != null) {
            this.fVw.setDialogVisiable(false);
        }
    }

    private void cta() {
        if (this.pz) {
            this.pz = false;
        } else if (this.jyC.ctW()) {
            this.jyE.e(this.aFy, this.jyC.ctU(), c.jwU + "video_" + System.currentTimeMillis() + ".mp4", this.jyC.isMute() ? false : true);
        } else if (this.jyC.isMute()) {
            this.jyE.e(this.aFy, null, c.jwU + "video_" + System.currentTimeMillis() + ".mp4", this.jyC.isMute() ? false : true);
        } else {
            r(this.aFy, -4399, "");
        }
    }

    private void ctb() {
        if (this.pz) {
            this.pz = false;
            return;
        }
        String text = this.jyC.getText();
        if (TextUtils.isEmpty(text)) {
            this.jyD.bn(this.aFy, this.jyC.getCurrentPosition());
        } else {
            this.jyD.Br(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void ctc() {
        File file;
        this.pz = false;
        if (this.jyC.ctW() || this.jyC.isMute()) {
            this.jyH = false;
            this.fVw.setDialogVisiable(true);
            this.jyC.onPause();
            if (this.jyG != null) {
                r(this.jyG, -4399, "");
            } else {
                cta();
            }
        } else if (this.jyI.ctg()) {
            this.jyH = false;
            this.jyC.onPause();
            this.fVw.setDialogVisiable(true);
            EK(this.aFy);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.copyFile(new File(this.aFy).getAbsolutePath(), c.jwV + file.getName());
                EM(c.jwV + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bYx() {
        if (this.jyC == null || this.jyD == null) {
            bpN();
            this.jyH = false;
        } else if (this.pz) {
            this.pz = false;
        } else {
            this.jyD.bn(this.aFy, this.jyC.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Bo(String str) {
        if (this.pz) {
            this.pz = false;
        } else if (this.jyH) {
            showToast(str);
            bpN();
            this.jyH = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void F(Bitmap bitmap) {
        this.jyC.ctP().J(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void EI(String str) {
        if (this.pz) {
            this.pz = false;
            return;
        }
        this.jyF = str;
        cta();
    }

    private void ctd() {
        if (this.pz) {
            this.pz = false;
        } else if (!TextUtils.isEmpty(this.jyF) && !TextUtils.isEmpty(this.jyG)) {
            this.mVideoInfo.setVideoPath(this.jyG);
            this.mVideoInfo.setThumbPath(this.jyF);
            if (this.jyC.ctW() && !TextUtils.isEmpty(this.jyC.ctV())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.jyC.ctV());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.fVb, this.ePT, this.mForumName, this.jyA, RequestResponseCode.REQUEST_WRITE_NEW, this.mVideoInfo, this.mVideoTitleData, this.jyB);
            if (!StringUtils.isNull(this.ajL)) {
                writeVideoActivityConfig.addFromType(this.ajL);
            }
            writeVideoActivityConfig.setProZone(this.jyz);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
            bpN();
            this.jyH = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(R.string.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(R.string.music_cloud)));
        this.jyC.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void r(String str, int i, String str2) {
        if (this.pz) {
            this.pz = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.mixing_fail);
            bpN();
            this.jyC.onResume();
            this.jyH = false;
            if (this.jjG != null) {
                this.jjG.ax(i, str2);
            }
        } else if (this.jyI.ctg()) {
            EK(str);
        } else {
            EL(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cte() {
        this.jyG = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void eB(List<PendantData> list) {
        this.jyC.eB(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String EP = com.baidu.tieba.video.editvideo.model.a.ctx().EP(stringExtra);
                if (this.jyC != null && !TextUtils.isEmpty(EP)) {
                    this.jyC.eg(EP, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void EJ(String str) {
        EL(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aL(int i, String str) {
        if (this.jjG != null) {
            this.jjG.ax(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aM(int i, String str) {
        if (this.jjG != null) {
            this.jjG.ax(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        G(bitmap);
    }

    private void EK(String str) {
        this.jyC.ctS();
        this.jyC.ctT();
        this.jyC.ctP().releaseSource();
        this.jyI.EO(str);
    }

    private void EL(String str) {
        File file;
        this.jyG = str;
        if (this.jyH) {
            ctd();
            return;
        }
        String str2 = c.jwV + file.getName();
        m.copyFile(new File(this.jyG).getAbsolutePath(), str2);
        EM(str2);
        bpN();
        finishPage();
    }

    private void EM(String str) {
        try {
            new w(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.aU(this, str);
        } catch (Exception e) {
            bpN();
            this.jyH = false;
        }
    }

    private void G(Bitmap bitmap) {
        if (this.jyC == null || this.jyD == null) {
            bpN();
            this.jyH = false;
        } else if (this.pz) {
            this.pz = false;
        } else {
            if (!TextUtils.isEmpty(this.jyC.getText())) {
                bitmap = this.jyC.z(bitmap);
            }
            if (bitmap != null) {
                this.jyD.b(bitmap, c.jwT);
            }
        }
    }
}
