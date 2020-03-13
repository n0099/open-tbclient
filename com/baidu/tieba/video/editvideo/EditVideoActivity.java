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
import com.baidu.adp.lib.f.e;
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
import com.baidu.tieba.k.h;
import com.baidu.tieba.k.l;
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
/* loaded from: classes10.dex */
public class EditVideoActivity extends BaseActivity implements a, b, b.a, MaskVideoView.b {
    private String aws;
    private String emo;
    private com.baidu.tbadk.core.view.a gOF;
    private String gOk;
    private h khZ;
    private com.baidu.tieba.video.editvideo.view.a kwA;
    private SelectCoverModel kwB;
    private SelectMusicModel kwC;
    private String kwD;
    private boolean kwE;
    private com.baidu.tieba.video.editvideo.b.a kwF;
    private HttpMessageListener kwG;
    private CustomMessageListener kwH;
    private int kwx;
    private String kwy;
    private List<VideoTitleData> kwz;
    private String mCoverPath;
    private String mForumName;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;
    private boolean rp;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.khZ = lVar.cgZ();
        }
        this.kwG = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.kwz = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.kwH = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.emo = getIntent().getStringExtra("forum_id");
        this.kwx = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.kwy = getIntent().getStringExtra("video_title");
        this.gOk = getIntent().getStringExtra("KEY_CALL_FROM");
        this.aws = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.kva).mkdirs();
        this.kwB = new SelectCoverModel(getPageContext(), this, this.khZ);
        this.kwC = new SelectMusicModel(getPageContext(), this);
        this.kwF = new com.baidu.tieba.video.editvideo.b.a(this);
        this.kwF.a(this);
        this.kwA = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.khZ);
        this.kwA.setData(this.mVideoPath);
        this.kwA.aA(getIntent());
        this.kwA.a(this.kwF);
        this.kwA.setGenMaskCoverListener(this);
        this.kwB.cQe();
        this.kwC.cQf();
        this.gOF = new com.baidu.tbadk.core.view.a(getPageContext());
        this.gOF.setTipString(R.string.mixing);
        registerListener(this.kwH);
        cPE();
        registerListener(this.kwG);
        cPD();
        TiebaStatic.log("c12303");
    }

    private void cPC() {
        this.rp = true;
        this.kwD = null;
        this.mCoverPath = null;
        bJO();
    }

    public void cPD() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.emo)) {
            httpMessage.addParam("forum_id", this.emo);
        }
        sendMessage(httpMessage);
    }

    private void cPE() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.kwA.getRootView());
        if (this.kwA != null) {
            this.kwA.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.kwA != null) {
            this.kwA.onPause();
        }
        if (this.kwF.cPN()) {
            this.kwF.interruptProcess();
        }
        this.kwE = false;
        this.rp = true;
        cPC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kwA != null) {
            this.kwA.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.cPZ().cQa();
        com.baidu.tieba.video.editvideo.model.b.cQc().cQd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kwA != null) {
            this.kwA.release();
        }
        if (this.kwB != null) {
            this.kwB.cancelLoadData();
        }
        if (this.kwC != null) {
            this.kwC.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kwA != null) {
            this.kwA.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        bJO();
        this.kwE = false;
        if (this.kwA != null && this.kwA.cQp() != null) {
            this.kwA.cQp().pause();
            this.kwA.cQp().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.kwA == null || this.kwB == null || this.kwC == null) {
            bJO();
            this.kwE = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.kwE) {
            this.kwE = true;
            this.rp = false;
            this.kwD = null;
            this.mCoverPath = null;
            this.kwA.onPause();
            this.gOF.setDialogVisiable(true);
            cPG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJO() {
        if (this.gOF != null) {
            this.gOF.setDialogVisiable(false);
        }
    }

    private void cPF() {
        if (this.rp) {
            this.rp = false;
        } else if (this.kwA.cQw()) {
            this.kwC.h(this.mVideoPath, this.kwA.cQu(), c.kuZ + "video_" + System.currentTimeMillis() + ".mp4", this.kwA.isMute() ? false : true);
        } else if (this.kwA.isMute()) {
            this.kwC.h(this.mVideoPath, null, c.kuZ + "video_" + System.currentTimeMillis() + ".mp4", this.kwA.isMute() ? false : true);
        } else {
            v(this.mVideoPath, -4399, "");
        }
    }

    private void cPG() {
        if (this.rp) {
            this.rp = false;
            return;
        }
        String text = this.kwA.getText();
        if (TextUtils.isEmpty(text)) {
            this.kwB.bw(this.mVideoPath, this.kwA.getCurrentPosition());
        } else {
            this.kwB.GB(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cPH() {
        File file;
        this.rp = false;
        if (this.kwA.cQw() || this.kwA.isMute()) {
            this.kwE = false;
            this.gOF.setDialogVisiable(true);
            this.kwA.onPause();
            if (this.kwD != null) {
                v(this.kwD, -4399, "");
            } else {
                cPF();
            }
        } else if (this.kwF.cPM()) {
            this.kwE = false;
            this.kwA.onPause();
            this.gOF.setDialogVisiable(true);
            JW(this.mVideoPath);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.copyFile(new File(this.mVideoPath).getAbsolutePath(), c.kva + file.getName());
                JY(c.kva + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cus() {
        if (this.kwA == null || this.kwB == null) {
            bJO();
            this.kwE = false;
        } else if (this.rp) {
            this.rp = false;
        } else {
            this.kwB.bw(this.mVideoPath, this.kwA.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Gz(String str) {
        if (this.rp) {
            this.rp = false;
        } else if (this.kwE) {
            showToast(str);
            bJO();
            this.kwE = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void G(Bitmap bitmap) {
        this.kwA.cQp().K(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void JV(String str) {
        if (this.rp) {
            this.rp = false;
            return;
        }
        this.mCoverPath = str;
        cPF();
    }

    private void cPI() {
        if (this.rp) {
            this.rp = false;
        } else if (!TextUtils.isEmpty(this.mCoverPath) && !TextUtils.isEmpty(this.kwD)) {
            this.mVideoInfo.setVideoPath(this.kwD);
            this.mVideoInfo.setThumbPath(this.mCoverPath);
            if (this.kwA.cQw() && !TextUtils.isEmpty(this.kwA.cQv())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.kwA.cQv());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.gOk, this.emo, this.mForumName, this.kwy, RequestResponseCode.REQUEST_WRITE_NEW, this.mVideoInfo, this.mVideoTitleData, this.kwz);
            if (!StringUtils.isNull(this.aws)) {
                writeVideoActivityConfig.addFromType(this.aws);
            }
            writeVideoActivityConfig.setProZone(this.kwx);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
            bJO();
            this.kwE = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(R.string.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(R.string.music_cloud)));
        this.kwA.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
        if (this.rp) {
            this.rp = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.mixing_fail);
            bJO();
            this.kwA.onResume();
            this.kwE = false;
            if (this.khZ != null) {
                this.khZ.aR(i, str2);
            }
        } else if (this.kwF.cPM()) {
            JW(str);
        } else {
            JX(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cPJ() {
        this.kwD = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void ep(List<PendantData> list) {
        this.kwA.ep(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String Kb = com.baidu.tieba.video.editvideo.model.a.cPZ().Kb(stringExtra);
                if (this.kwA != null && !TextUtils.isEmpty(Kb)) {
                    this.kwA.eK(Kb, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void onGenFilterVideoSuccess(String str) {
        JX(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void onGenFilterVideoFail(int i, String str) {
        if (this.khZ != null) {
            this.khZ.aR(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void onGenFilterVideoRecordError(int i, String str) {
        if (this.khZ != null) {
            this.khZ.aR(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void cPK() {
        e.gx().post(new Runnable() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
            @Override // java.lang.Runnable
            public void run() {
                EditVideoActivity.this.bJO();
                EditVideoActivity.this.showToast(R.string.mix_fail);
                EditVideoActivity.this.finishPage();
            }
        });
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        H(bitmap);
    }

    private void JW(String str) {
        this.kwA.cQs();
        this.kwA.cQt();
        this.kwA.cQp().releaseSource();
        this.kwF.Ka(str);
    }

    private void JX(String str) {
        File file;
        this.kwD = str;
        if (this.kwE) {
            cPI();
            return;
        }
        String str2 = c.kva + file.getName();
        m.copyFile(new File(this.kwD).getAbsolutePath(), str2);
        JY(str2);
        bJO();
        finishPage();
    }

    private void JY(String str) {
        try {
            new w(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.bp(this, str);
        } catch (Exception e) {
            bJO();
            this.kwE = false;
        }
    }

    private void H(Bitmap bitmap) {
        if (this.kwA == null || this.kwB == null) {
            bJO();
            this.kwE = false;
        } else if (this.rp) {
            this.rp = false;
        } else {
            if (!TextUtils.isEmpty(this.kwA.getText())) {
                bitmap = this.kwA.z(bitmap);
            }
            if (bitmap != null) {
                this.kwB.b(bitmap, c.kuY);
            }
        }
    }
}
