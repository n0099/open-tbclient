package com.baidu.tieba.video.editvideo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.l.g;
import com.baidu.tieba.l.k;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.video.c;
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
public class EditVideoActivity extends BaseActivity implements a, b, MaskVideoView.b {
    private boolean Od;
    private String bwo;
    private String fOD;
    private String jOM;
    private com.baidu.tbadk.core.view.a jPg;
    private String mCoverPath;
    private String mForumName;
    private String mFrom;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;
    private int meT;
    private g nAz;
    private com.baidu.tieba.video.b nOA;
    private HttpMessageListener nOB;
    private CustomMessageListener nOC;
    private int nOq;
    private FrsTabInfoData nOr;
    private String nOs;
    private List<VideoTitleData> nOt;
    private com.baidu.tieba.video.editvideo.view.a nOu;
    private SelectCoverModel nOv;
    private SelectMusicModel nOw;
    private boolean nOx;
    private com.baidu.tieba.video.editvideo.b.a nOy;
    private com.baidu.tieba.video.editvideo.view.b nOz;
    private int statisticFrom;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.nAz = kVar.dho();
        }
        this.nOB = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.nOt = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.nOC = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    EditVideoActivity.this.finishPage();
                }
            }
        };
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
            this.nOA.originPath = this.mVideoPath;
        }
        this.nOu.setData(this.mVideoPath);
        dSH();
        this.bwo = getIntent().getStringExtra("from_type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_edit_video);
        this.fOD = getIntent().getStringExtra("forum_id");
        this.meT = getIntent().getIntExtra("key_write_level", -1);
        this.nOq = getIntent().getIntExtra(EditVideoActivityConfig.KEY_PRO_ZONE, -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.nOs = getIntent().getStringExtra("video_title");
        this.jOM = getIntent().getStringExtra("KEY_CALL_FROM");
        this.statisticFrom = getIntent().getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0);
        this.bwo = getIntent().getStringExtra("from_type");
        this.mFrom = getIntent().getStringExtra("from");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.nOr = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.nMS).mkdirs();
        this.nOv = new SelectCoverModel(getPageContext(), this, this.nAz);
        this.nOw = new SelectMusicModel(getPageContext(), this);
        this.nOy = new com.baidu.tieba.video.editvideo.b.a(this);
        this.nOu = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.nAz);
        this.nOu.setData(this.mVideoPath);
        this.nOu.am(getIntent());
        this.nOu.a(this.nOy);
        this.nOu.setGenMaskCoverListener(this);
        this.nOv.dTh();
        this.nOw.dTi();
        this.jPg = new com.baidu.tbadk.core.view.a(getPageContext());
        this.jPg.setTipString(R.string.mixing);
        registerListener(this.nOC);
        dSK();
        registerListener(this.nOB);
        dSJ();
        TiebaStatic.log("c12303");
        this.nOA = new com.baidu.tieba.video.b(this, this.mVideoPath, this.mCoverPath) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
            @Override // com.baidu.tieba.video.b
            public void onCancel() {
                super.onCancel();
                EditVideoActivity.this.cKv();
            }

            @Override // com.baidu.tieba.video.b
            public void dSf() {
                EditVideoActivity.this.nOu.dTx();
                EditVideoActivity.this.nOu.dTy();
                EditVideoActivity.this.nOu.dTu().releaseSource();
            }

            @Override // com.baidu.tieba.video.b
            public void cb(int i, String str) {
                super.cb(i, str);
                EditVideoActivity.this.cKv();
            }

            @Override // com.baidu.tieba.video.b
            public void dSg() {
            }

            @Override // com.baidu.tieba.video.b
            public void cc(int i, String str) {
                super.cc(i, str);
                EditVideoActivity.this.cKv();
            }

            @Override // com.baidu.tieba.video.b
            public void a(VideoInfo videoInfo) {
                super.a(videoInfo);
                if (!EditVideoActivity.this.nOx) {
                    File file = new File(videoInfo.getVideoPath());
                    String str = c.nMS + file.getName();
                    if (!str.equals(file.getAbsolutePath())) {
                        o.copyFile(file.getAbsolutePath(), str);
                    }
                    EditVideoActivity.this.Ux(str);
                    EditVideoActivity.this.finishPage();
                }
            }
        };
        this.nOz = new com.baidu.tieba.video.editvideo.view.b(this.nOA);
        dSH();
    }

    private void dSH() {
        if (this.mVideoInfo != null && this.mVideoInfo.getEditVideoData() != null && this.nOu != null) {
            com.baidu.tieba.video.editvideo.data.a UH = this.nOu.UH(this.mVideoInfo.getEditVideoData().filterName);
            if (UH != null) {
                if (this.nOy != null) {
                    this.nOy.b(UH);
                }
                this.nOu.c(UH);
            }
            this.nOu.gH(this.mVideoInfo.getEditVideoData().musicPath, this.mVideoInfo.getEditVideoData().musicId);
            this.nOu.yY(!this.mVideoInfo.getEditVideoData().isMute);
        }
    }

    public String bnE() {
        return this.bwo;
    }

    private void dSI() {
        if (this.nOz != null) {
            this.nOz.cancel();
        }
        this.Od = true;
        this.mCoverPath = null;
        cKv();
    }

    public void dSJ() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.fOD)) {
            httpMessage.addParam("forum_id", this.fOD);
        }
        sendMessage(httpMessage);
    }

    private void dSK() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.nOu.getRootView());
        if (this.nOu != null) {
            this.nOu.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.nOu != null) {
            this.nOu.onPause();
            this.nOu.dTx();
            this.nOu.dTy();
            this.nOu.dTu().releaseSource();
        }
        if (this.nOy.dSP()) {
            this.nOy.dSQ();
        }
        this.nOx = false;
        this.Od = true;
        if (this.nOz != null) {
            this.nOz.cancel();
        }
        dSI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nOu != null) {
            this.nOu.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.dTc().dTd();
        com.baidu.tieba.video.editvideo.model.b.dTf().dTg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nOu != null) {
            this.nOu.release();
        }
        if (this.nOv != null) {
            this.nOv.cancelLoadData();
        }
        if (this.nOw != null) {
            this.nOw.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.nOu != null) {
            this.nOu.QH();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        cKv();
        this.nOx = false;
        if (this.nOz != null) {
            this.nOz.cancel();
        }
        if (this.nOu != null && this.nOu.dTu() != null) {
            this.nOu.dTu().pause();
            this.nOu.dTu().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.nOu == null || this.nOv == null || this.nOw == null) {
            cKv();
            this.nOx = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.nOx) {
            this.nOx = true;
            this.Od = false;
            if (this.nOz != null) {
                this.nOz.cancel();
            }
            this.mCoverPath = null;
            this.nOu.onPause();
            this.jPg.setDialogVisiable(true);
            dSL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKv() {
        if (this.jPg != null) {
            this.jPg.setDialogVisiable(false);
        }
    }

    private void dSL() {
        if (this.Od) {
            this.Od = false;
            return;
        }
        String text = this.nOu.getText();
        if (TextUtils.isEmpty(text)) {
            this.nOv.bX(this.mVideoPath, this.nOu.getCurrentPosition());
        } else {
            this.nOv.Qn(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bzx() {
        this.Od = false;
        this.nOx = false;
        this.nOA.yT(false);
        this.nOA.coverPath = this.mCoverPath;
        this.nOA.originPath = this.mVideoPath;
        this.nOA.musicPath = this.nOu.dTz();
        this.nOA.isMute = this.nOu.isMute();
        this.nOA.filterName = this.nOy.dSO();
        this.nOz.dTD();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dvX() {
        if (this.nOu == null || this.nOv == null) {
            cKv();
            this.nOx = false;
        } else if (this.Od) {
            this.Od = false;
        } else {
            this.nOv.bX(this.mVideoPath, this.nOu.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Ql(String str) {
        if (this.Od) {
            this.Od = false;
        } else if (this.nOx) {
            showToast(str);
            cKv();
            this.nOx = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void M(Bitmap bitmap) {
        this.nOu.dTu().Q(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Uw(String str) {
        String str2;
        String str3;
        AntiData antiData;
        PostPrefixData postPrefixData;
        if (this.Od) {
            this.Od = false;
            return;
        }
        this.mCoverPath = str;
        Uy(this.mCoverPath);
        cKv();
        if (getIntent() == null) {
            str2 = "";
            str3 = "";
            antiData = null;
            postPrefixData = null;
        } else {
            Serializable serializableExtra = getIntent().getSerializableExtra("anti_data");
            AntiData antiData2 = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
            Serializable serializableExtra2 = getIntent().getSerializableExtra("prefix_data");
            PostPrefixData postPrefixData2 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
            str3 = getIntent().getStringExtra("forum_first_dir");
            str2 = getIntent().getStringExtra("forum_second_dir");
            antiData = antiData2;
            postPrefixData = postPrefixData2;
        }
        if (!WriteActivityConfig.isAsyncWriting()) {
            EditVideoData editVideoData = new EditVideoData();
            editVideoData.coverPath = this.mCoverPath;
            editVideoData.originPath = this.mVideoPath;
            editVideoData.musicPath = this.nOu.dTz();
            editVideoData.musicId = this.nOu.dTA();
            editVideoData.isMute = this.nOu.isMute();
            editVideoData.filterName = this.nOy.dSO();
            this.mVideoInfo.setEditVideoData(editVideoData);
            WriteActivityConfig videoInfo = WriteActivityConfig.newInstance(this).setType(9).setFrom(this.mFrom).setCallFrom(this.jOM).setStatisticFrom(this.statisticFrom).setForumId(this.fOD).setForumName(this.mForumName).setAntiData(antiData).setPrefixData(postPrefixData).setForumDir(str3, str2).setFrsTabInfo(this.nOr).setVideoInfo(this.mVideoInfo);
            videoInfo.getIntent().setFlags(536870912);
            videoInfo.getIntent().setFlags(67108864);
            videoInfo.send();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(R.string.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(R.string.music_cloud)));
        this.nOu.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dSM() {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void fY(List<PendantData> list) {
        this.nOu.fY(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25032) {
                String stringExtra = intent.getStringExtra("music_resource");
                String stringExtra2 = intent.getStringExtra("music_id");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    String UB = com.baidu.tieba.video.editvideo.model.a.dTc().UB(stringExtra);
                    if (this.nOu != null && !TextUtils.isEmpty(UB)) {
                        this.nOu.gI(UB, stringExtra2);
                    }
                }
            }
        } else if (i2 == 100) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
            finish();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        N(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ux(String str) {
        try {
            new z(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.bs(this, str);
        } catch (Exception e) {
            cKv();
            this.nOx = false;
        }
    }

    private void Uy(String str) {
        try {
            new z(this).saveImage(str);
            com.baidu.tieba.video.editvideo.b.c.bs(this, str);
        } catch (Exception e) {
            cKv();
            this.nOx = false;
        }
    }

    private void N(Bitmap bitmap) {
        if (this.nOu == null || this.nOv == null) {
            cKv();
            this.nOx = false;
        } else if (this.Od) {
            this.Od = false;
        } else {
            if (!TextUtils.isEmpty(this.nOu.getText())) {
                bitmap = this.nOu.F(bitmap);
            }
            if (bitmap != null) {
                this.nOv.b(bitmap, c.nMQ);
            }
        }
    }
}
