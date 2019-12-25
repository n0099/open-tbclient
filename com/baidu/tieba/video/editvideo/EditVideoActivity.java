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
/* loaded from: classes7.dex */
public class EditVideoActivity extends BaseActivity implements a, b, b.a, MaskVideoView.b {
    private String aru;
    private String fGQ;
    private String gIK;
    private com.baidu.tbadk.core.view.a gJf;
    private h kdc;
    private int krE;
    private String krF;
    private List<VideoTitleData> krG;
    private com.baidu.tieba.video.editvideo.view.a krH;
    private SelectCoverModel krI;
    private SelectMusicModel krJ;
    private String krK;
    private boolean krL;
    private com.baidu.tieba.video.editvideo.b.a krM;
    private HttpMessageListener krN;
    private CustomMessageListener krO;
    private String mCoverPath;
    private String mForumName;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;
    private boolean ro;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.kdc = lVar.cei();
        }
        this.krN = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.krG = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.krO = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.fGQ = getIntent().getStringExtra("forum_id");
        this.krE = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.krF = getIntent().getStringExtra("video_title");
        this.gIK = getIntent().getStringExtra("KEY_CALL_FROM");
        this.aru = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.kqh).mkdirs();
        this.krI = new SelectCoverModel(getPageContext(), this, this.kdc);
        this.krJ = new SelectMusicModel(getPageContext(), this);
        this.krM = new com.baidu.tieba.video.editvideo.b.a(this);
        this.krM.a(this);
        this.krH = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.kdc);
        this.krH.setData(this.mVideoPath);
        this.krH.aA(getIntent());
        this.krH.a(this.krM);
        this.krH.setGenMaskCoverListener(this);
        this.krI.cNB();
        this.krJ.cNC();
        this.gJf = new com.baidu.tbadk.core.view.a(getPageContext());
        this.gJf.setTipString(R.string.mixing);
        registerListener(this.krO);
        cMZ();
        registerListener(this.krN);
        cMY();
        TiebaStatic.log("c12303");
    }

    private void cMX() {
        this.ro = true;
        this.krK = null;
        this.mCoverPath = null;
        bHh();
    }

    public void cMY() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.fGQ)) {
            httpMessage.addParam("forum_id", this.fGQ);
        }
        sendMessage(httpMessage);
    }

    private void cMZ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.krH.getRootView());
        if (this.krH != null) {
            this.krH.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.krH != null) {
            this.krH.onPause();
        }
        if (this.krM.cNh()) {
            this.krM.interruptProcess();
        }
        this.krL = false;
        this.ro = true;
        cMX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.krH != null) {
            this.krH.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.cNw().cNx();
        com.baidu.tieba.video.editvideo.model.b.cNz().cNA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.krH != null) {
            this.krH.release();
        }
        if (this.krI != null) {
            this.krI.cancelLoadData();
        }
        if (this.krJ != null) {
            this.krJ.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.krH != null) {
            this.krH.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        bHh();
        this.krL = false;
        if (this.krH != null && this.krH.cNO() != null) {
            this.krH.cNO().pause();
            this.krH.cNO().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.krH == null || this.krI == null || this.krJ == null) {
            bHh();
            this.krL = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.krL) {
            this.krL = true;
            this.ro = false;
            this.krK = null;
            this.mCoverPath = null;
            this.krH.onPause();
            this.gJf.setDialogVisiable(true);
            cNb();
        }
    }

    private void bHh() {
        if (this.gJf != null) {
            this.gJf.setDialogVisiable(false);
        }
    }

    private void cNa() {
        if (this.ro) {
            this.ro = false;
        } else if (this.krH.cNV()) {
            this.krJ.h(this.mVideoPath, this.krH.cNT(), c.kqg + "video_" + System.currentTimeMillis() + ".mp4", this.krH.isMute() ? false : true);
        } else if (this.krH.isMute()) {
            this.krJ.h(this.mVideoPath, null, c.kqg + "video_" + System.currentTimeMillis() + ".mp4", this.krH.isMute() ? false : true);
        } else {
            u(this.mVideoPath, -4399, "");
        }
    }

    private void cNb() {
        if (this.ro) {
            this.ro = false;
            return;
        }
        String text = this.krH.getText();
        if (TextUtils.isEmpty(text)) {
            this.krI.bw(this.mVideoPath, this.krH.getCurrentPosition());
        } else {
            this.krI.Gc(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cNc() {
        File file;
        this.ro = false;
        if (this.krH.cNV() || this.krH.isMute()) {
            this.krL = false;
            this.gJf.setDialogVisiable(true);
            this.krH.onPause();
            if (this.krK != null) {
                u(this.krK, -4399, "");
            } else {
                cNa();
            }
        } else if (this.krM.cNg()) {
            this.krL = false;
            this.krH.onPause();
            this.gJf.setDialogVisiable(true);
            Jy(this.mVideoPath);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.copyFile(new File(this.mVideoPath).getAbsolutePath(), c.kqh + file.getName());
                JA(c.kqh + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void crN() {
        if (this.krH == null || this.krI == null) {
            bHh();
            this.krL = false;
        } else if (this.ro) {
            this.ro = false;
        } else {
            this.krI.bw(this.mVideoPath, this.krH.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void FZ(String str) {
        if (this.ro) {
            this.ro = false;
        } else if (this.krL) {
            showToast(str);
            bHh();
            this.krL = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void G(Bitmap bitmap) {
        this.krH.cNO().K(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Jx(String str) {
        if (this.ro) {
            this.ro = false;
            return;
        }
        this.mCoverPath = str;
        cNa();
    }

    private void cNd() {
        if (this.ro) {
            this.ro = false;
        } else if (!TextUtils.isEmpty(this.mCoverPath) && !TextUtils.isEmpty(this.krK)) {
            this.mVideoInfo.setVideoPath(this.krK);
            this.mVideoInfo.setThumbPath(this.mCoverPath);
            if (this.krH.cNV() && !TextUtils.isEmpty(this.krH.cNU())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.krH.cNU());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.gIK, this.fGQ, this.mForumName, this.krF, RequestResponseCode.REQUEST_WRITE_NEW, this.mVideoInfo, this.mVideoTitleData, this.krG);
            if (!StringUtils.isNull(this.aru)) {
                writeVideoActivityConfig.addFromType(this.aru);
            }
            writeVideoActivityConfig.setProZone(this.krE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
            bHh();
            this.krL = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(R.string.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(R.string.music_cloud)));
        this.krH.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
        if (this.ro) {
            this.ro = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.mixing_fail);
            bHh();
            this.krH.onResume();
            this.krL = false;
            if (this.kdc != null) {
                this.kdc.aL(i, str2);
            }
        } else if (this.krM.cNg()) {
            Jy(str);
        } else {
            Jz(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cNe() {
        this.krK = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void et(List<PendantData> list) {
        this.krH.et(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String JD = com.baidu.tieba.video.editvideo.model.a.cNw().JD(stringExtra);
                if (this.krH != null && !TextUtils.isEmpty(JD)) {
                    this.krH.ez(JD, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void onGenFilterVideoSuccess(String str) {
        Jz(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void onGenFilterVideoFail(int i, String str) {
        if (this.kdc != null) {
            this.kdc.aL(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void onGenFilterVideoRecordError(int i, String str) {
        if (this.kdc != null) {
            this.kdc.aL(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        H(bitmap);
    }

    private void Jy(String str) {
        this.krH.cNR();
        this.krH.cNS();
        this.krH.cNO().releaseSource();
        this.krM.JC(str);
    }

    private void Jz(String str) {
        File file;
        this.krK = str;
        if (this.krL) {
            cNd();
            return;
        }
        String str2 = c.kqh + file.getName();
        m.copyFile(new File(this.krK).getAbsolutePath(), str2);
        JA(str2);
        bHh();
        finishPage();
    }

    private void JA(String str) {
        try {
            new w(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.bl(this, str);
        } catch (Exception e) {
            bHh();
            this.krL = false;
        }
    }

    private void H(Bitmap bitmap) {
        if (this.krH == null || this.krI == null) {
            bHh();
            this.krL = false;
        } else if (this.ro) {
            this.ro = false;
        } else {
            if (!TextUtils.isEmpty(this.krH.getText())) {
                bitmap = this.krH.z(bitmap);
            }
            if (bitmap != null) {
                this.krI.b(bitmap, c.kqf);
            }
        }
    }
}
