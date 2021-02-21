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
/* loaded from: classes8.dex */
public class EditVideoActivity extends BaseActivity implements a, b, MaskVideoView.b {
    private boolean MD;
    private String buO;
    private String fNd;
    private String jNd;
    private com.baidu.tbadk.core.view.a jNx;
    private String mCoverPath;
    private String mForumName;
    private String mFrom;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;
    private int mcQ;
    private int nMl;
    private FrsTabInfoData nMm;
    private String nMn;
    private List<VideoTitleData> nMo;
    private com.baidu.tieba.video.editvideo.view.a nMp;
    private SelectCoverModel nMq;
    private SelectMusicModel nMr;
    private boolean nMs;
    private com.baidu.tieba.video.editvideo.b.a nMt;
    private com.baidu.tieba.video.editvideo.view.b nMu;
    private com.baidu.tieba.video.b nMv;
    private HttpMessageListener nMw;
    private CustomMessageListener nMx;
    private g nyu;
    private int statisticFrom;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.nyu = kVar.dhf();
        }
        this.nMw = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.nMo = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.nMx = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
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
            this.nMv.originPath = this.mVideoPath;
        }
        this.nMp.setData(this.mVideoPath);
        dSz();
        this.buO = getIntent().getStringExtra("from_type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_edit_video);
        this.fNd = getIntent().getStringExtra("forum_id");
        this.mcQ = getIntent().getIntExtra("key_write_level", -1);
        this.nMl = getIntent().getIntExtra(EditVideoActivityConfig.KEY_PRO_ZONE, -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.nMn = getIntent().getStringExtra("video_title");
        this.jNd = getIntent().getStringExtra("KEY_CALL_FROM");
        this.statisticFrom = getIntent().getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0);
        this.buO = getIntent().getStringExtra("from_type");
        this.mFrom = getIntent().getStringExtra("from");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.nMm = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.nKN).mkdirs();
        this.nMq = new SelectCoverModel(getPageContext(), this, this.nyu);
        this.nMr = new SelectMusicModel(getPageContext(), this);
        this.nMt = new com.baidu.tieba.video.editvideo.b.a(this);
        this.nMp = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.nyu);
        this.nMp.setData(this.mVideoPath);
        this.nMp.am(getIntent());
        this.nMp.a(this.nMt);
        this.nMp.setGenMaskCoverListener(this);
        this.nMq.dSZ();
        this.nMr.dTa();
        this.jNx = new com.baidu.tbadk.core.view.a(getPageContext());
        this.jNx.setTipString(R.string.mixing);
        registerListener(this.nMx);
        dSC();
        registerListener(this.nMw);
        dSB();
        TiebaStatic.log("c12303");
        this.nMv = new com.baidu.tieba.video.b(this, this.mVideoPath, this.mCoverPath) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
            @Override // com.baidu.tieba.video.b
            public void onCancel() {
                super.onCancel();
                EditVideoActivity.this.cKp();
            }

            @Override // com.baidu.tieba.video.b
            public void dRX() {
                EditVideoActivity.this.nMp.dTp();
                EditVideoActivity.this.nMp.dTq();
                EditVideoActivity.this.nMp.dTm().releaseSource();
            }

            @Override // com.baidu.tieba.video.b
            public void cb(int i, String str) {
                super.cb(i, str);
                EditVideoActivity.this.cKp();
            }

            @Override // com.baidu.tieba.video.b
            public void dRY() {
            }

            @Override // com.baidu.tieba.video.b
            public void cc(int i, String str) {
                super.cc(i, str);
                EditVideoActivity.this.cKp();
            }

            @Override // com.baidu.tieba.video.b
            public void a(VideoInfo videoInfo) {
                super.a(videoInfo);
                if (!EditVideoActivity.this.nMs) {
                    File file = new File(videoInfo.getVideoPath());
                    String str = c.nKN + file.getName();
                    if (!str.equals(file.getAbsolutePath())) {
                        o.copyFile(file.getAbsolutePath(), str);
                    }
                    EditVideoActivity.this.Uq(str);
                    EditVideoActivity.this.finishPage();
                }
            }
        };
        this.nMu = new com.baidu.tieba.video.editvideo.view.b(this.nMv);
        dSz();
    }

    private void dSz() {
        if (this.mVideoInfo != null && this.mVideoInfo.getEditVideoData() != null && this.nMp != null) {
            com.baidu.tieba.video.editvideo.data.a UA = this.nMp.UA(this.mVideoInfo.getEditVideoData().filterName);
            if (UA != null) {
                if (this.nMt != null) {
                    this.nMt.b(UA);
                }
                this.nMp.c(UA);
            }
            this.nMp.gH(this.mVideoInfo.getEditVideoData().musicPath, this.mVideoInfo.getEditVideoData().musicId);
            this.nMp.yZ(!this.mVideoInfo.getEditVideoData().isMute);
        }
    }

    public String bnC() {
        return this.buO;
    }

    private void dSA() {
        if (this.nMu != null) {
            this.nMu.cancel();
        }
        this.MD = true;
        this.mCoverPath = null;
        cKp();
    }

    public void dSB() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.fNd)) {
            httpMessage.addParam("forum_id", this.fNd);
        }
        sendMessage(httpMessage);
    }

    private void dSC() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.nMp.getRootView());
        if (this.nMp != null) {
            this.nMp.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.nMp != null) {
            this.nMp.onPause();
            this.nMp.dTp();
            this.nMp.dTq();
            this.nMp.dTm().releaseSource();
        }
        if (this.nMt.dSH()) {
            this.nMt.dSI();
        }
        this.nMs = false;
        this.MD = true;
        if (this.nMu != null) {
            this.nMu.cancel();
        }
        dSA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nMp != null) {
            this.nMp.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.dSU().dSV();
        com.baidu.tieba.video.editvideo.model.b.dSX().dSY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nMp != null) {
            this.nMp.release();
        }
        if (this.nMq != null) {
            this.nMq.cancelLoadData();
        }
        if (this.nMr != null) {
            this.nMr.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.nMp != null) {
            this.nMp.QE();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        cKp();
        this.nMs = false;
        if (this.nMu != null) {
            this.nMu.cancel();
        }
        if (this.nMp != null && this.nMp.dTm() != null) {
            this.nMp.dTm().pause();
            this.nMp.dTm().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.nMp == null || this.nMq == null || this.nMr == null) {
            cKp();
            this.nMs = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.nMs) {
            this.nMs = true;
            this.MD = false;
            if (this.nMu != null) {
                this.nMu.cancel();
            }
            this.mCoverPath = null;
            this.nMp.onPause();
            this.jNx.setDialogVisiable(true);
            dSD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKp() {
        if (this.jNx != null) {
            this.jNx.setDialogVisiable(false);
        }
    }

    private void dSD() {
        if (this.MD) {
            this.MD = false;
            return;
        }
        String text = this.nMp.getText();
        if (TextUtils.isEmpty(text)) {
            this.nMq.bX(this.mVideoPath, this.nMp.getCurrentPosition());
        } else {
            this.nMq.Qh(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bzu() {
        this.MD = false;
        this.nMs = false;
        this.nMv.yU(false);
        this.nMv.coverPath = this.mCoverPath;
        this.nMv.originPath = this.mVideoPath;
        this.nMv.musicPath = this.nMp.dTr();
        this.nMv.isMute = this.nMp.isMute();
        this.nMv.filterName = this.nMt.dSG();
        this.nMu.dTv();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dvO() {
        if (this.nMp == null || this.nMq == null) {
            cKp();
            this.nMs = false;
        } else if (this.MD) {
            this.MD = false;
        } else {
            this.nMq.bX(this.mVideoPath, this.nMp.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Qf(String str) {
        if (this.MD) {
            this.MD = false;
        } else if (this.nMs) {
            showToast(str);
            cKp();
            this.nMs = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void M(Bitmap bitmap) {
        this.nMp.dTm().Q(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Up(String str) {
        String str2;
        String str3;
        AntiData antiData;
        PostPrefixData postPrefixData;
        if (this.MD) {
            this.MD = false;
            return;
        }
        this.mCoverPath = str;
        Ur(this.mCoverPath);
        cKp();
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
            editVideoData.musicPath = this.nMp.dTr();
            editVideoData.musicId = this.nMp.dTs();
            editVideoData.isMute = this.nMp.isMute();
            editVideoData.filterName = this.nMt.dSG();
            this.mVideoInfo.setEditVideoData(editVideoData);
            WriteActivityConfig videoInfo = WriteActivityConfig.newInstance(this).setType(9).setFrom(this.mFrom).setCallFrom(this.jNd).setStatisticFrom(this.statisticFrom).setForumId(this.fNd).setForumName(this.mForumName).setAntiData(antiData).setPrefixData(postPrefixData).setForumDir(str3, str2).setFrsTabInfo(this.nMm).setVideoInfo(this.mVideoInfo);
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
        this.nMp.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dSE() {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void fY(List<PendantData> list) {
        this.nMp.fY(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25032) {
                String stringExtra = intent.getStringExtra("music_resource");
                String stringExtra2 = intent.getStringExtra("music_id");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    String Uu = com.baidu.tieba.video.editvideo.model.a.dSU().Uu(stringExtra);
                    if (this.nMp != null && !TextUtils.isEmpty(Uu)) {
                        this.nMp.gI(Uu, stringExtra2);
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
    public void Uq(String str) {
        try {
            new z(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.bs(this, str);
        } catch (Exception e) {
            cKp();
            this.nMs = false;
        }
    }

    private void Ur(String str) {
        try {
            new z(this).saveImage(str);
            com.baidu.tieba.video.editvideo.b.c.bs(this, str);
        } catch (Exception e) {
            cKp();
            this.nMs = false;
        }
    }

    private void N(Bitmap bitmap) {
        if (this.nMp == null || this.nMq == null) {
            cKp();
            this.nMs = false;
        } else if (this.MD) {
            this.MD = false;
        } else {
            if (!TextUtils.isEmpty(this.nMp.getText())) {
                bitmap = this.nMp.F(bitmap);
            }
            if (bitmap != null) {
                this.nMq.b(bitmap, c.nKL);
            }
        }
    }
}
