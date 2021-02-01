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
    private String jMP;
    private com.baidu.tbadk.core.view.a jNj;
    private String mCoverPath;
    private String mForumName;
    private String mFrom;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;
    private int mcB;
    private int nLL;
    private FrsTabInfoData nLM;
    private String nLN;
    private List<VideoTitleData> nLO;
    private com.baidu.tieba.video.editvideo.view.a nLP;
    private SelectCoverModel nLQ;
    private SelectMusicModel nLR;
    private boolean nLS;
    private com.baidu.tieba.video.editvideo.b.a nLT;
    private com.baidu.tieba.video.editvideo.view.b nLU;
    private com.baidu.tieba.video.b nLV;
    private HttpMessageListener nLW;
    private CustomMessageListener nLX;
    private g nxU;
    private int statisticFrom;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.nxU = kVar.dgY();
        }
        this.nLW = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.nLO = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.nLX = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
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
            this.nLV.originPath = this.mVideoPath;
        }
        this.nLP.setData(this.mVideoPath);
        dSr();
        this.buO = getIntent().getStringExtra("from_type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_edit_video);
        this.fNd = getIntent().getStringExtra("forum_id");
        this.mcB = getIntent().getIntExtra("key_write_level", -1);
        this.nLL = getIntent().getIntExtra(EditVideoActivityConfig.KEY_PRO_ZONE, -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.nLN = getIntent().getStringExtra("video_title");
        this.jMP = getIntent().getStringExtra("KEY_CALL_FROM");
        this.statisticFrom = getIntent().getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0);
        this.buO = getIntent().getStringExtra("from_type");
        this.mFrom = getIntent().getStringExtra("from");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.nLM = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.nKn).mkdirs();
        this.nLQ = new SelectCoverModel(getPageContext(), this, this.nxU);
        this.nLR = new SelectMusicModel(getPageContext(), this);
        this.nLT = new com.baidu.tieba.video.editvideo.b.a(this);
        this.nLP = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.nxU);
        this.nLP.setData(this.mVideoPath);
        this.nLP.am(getIntent());
        this.nLP.a(this.nLT);
        this.nLP.setGenMaskCoverListener(this);
        this.nLQ.dSR();
        this.nLR.dSS();
        this.jNj = new com.baidu.tbadk.core.view.a(getPageContext());
        this.jNj.setTipString(R.string.mixing);
        registerListener(this.nLX);
        dSu();
        registerListener(this.nLW);
        dSt();
        TiebaStatic.log("c12303");
        this.nLV = new com.baidu.tieba.video.b(this, this.mVideoPath, this.mCoverPath) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
            @Override // com.baidu.tieba.video.b
            public void onCancel() {
                super.onCancel();
                EditVideoActivity.this.cKi();
            }

            @Override // com.baidu.tieba.video.b
            public void dRP() {
                EditVideoActivity.this.nLP.dTh();
                EditVideoActivity.this.nLP.dTi();
                EditVideoActivity.this.nLP.dTe().releaseSource();
            }

            @Override // com.baidu.tieba.video.b
            public void cb(int i, String str) {
                super.cb(i, str);
                EditVideoActivity.this.cKi();
            }

            @Override // com.baidu.tieba.video.b
            public void dRQ() {
            }

            @Override // com.baidu.tieba.video.b
            public void cc(int i, String str) {
                super.cc(i, str);
                EditVideoActivity.this.cKi();
            }

            @Override // com.baidu.tieba.video.b
            public void a(VideoInfo videoInfo) {
                super.a(videoInfo);
                if (!EditVideoActivity.this.nLS) {
                    File file = new File(videoInfo.getVideoPath());
                    String str = c.nKn + file.getName();
                    if (!str.equals(file.getAbsolutePath())) {
                        o.copyFile(file.getAbsolutePath(), str);
                    }
                    EditVideoActivity.this.Ue(str);
                    EditVideoActivity.this.finishPage();
                }
            }
        };
        this.nLU = new com.baidu.tieba.video.editvideo.view.b(this.nLV);
        dSr();
    }

    private void dSr() {
        if (this.mVideoInfo != null && this.mVideoInfo.getEditVideoData() != null && this.nLP != null) {
            com.baidu.tieba.video.editvideo.data.a Uo = this.nLP.Uo(this.mVideoInfo.getEditVideoData().filterName);
            if (Uo != null) {
                if (this.nLT != null) {
                    this.nLT.b(Uo);
                }
                this.nLP.c(Uo);
            }
            this.nLP.gF(this.mVideoInfo.getEditVideoData().musicPath, this.mVideoInfo.getEditVideoData().musicId);
            this.nLP.yZ(!this.mVideoInfo.getEditVideoData().isMute);
        }
    }

    public String bnC() {
        return this.buO;
    }

    private void dSs() {
        if (this.nLU != null) {
            this.nLU.cancel();
        }
        this.MD = true;
        this.mCoverPath = null;
        cKi();
    }

    public void dSt() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.fNd)) {
            httpMessage.addParam("forum_id", this.fNd);
        }
        sendMessage(httpMessage);
    }

    private void dSu() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.nLP.getRootView());
        if (this.nLP != null) {
            this.nLP.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.nLP != null) {
            this.nLP.onPause();
            this.nLP.dTh();
            this.nLP.dTi();
            this.nLP.dTe().releaseSource();
        }
        if (this.nLT.dSz()) {
            this.nLT.dSA();
        }
        this.nLS = false;
        this.MD = true;
        if (this.nLU != null) {
            this.nLU.cancel();
        }
        dSs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nLP != null) {
            this.nLP.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.dSM().dSN();
        com.baidu.tieba.video.editvideo.model.b.dSP().dSQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nLP != null) {
            this.nLP.release();
        }
        if (this.nLQ != null) {
            this.nLQ.cancelLoadData();
        }
        if (this.nLR != null) {
            this.nLR.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.nLP != null) {
            this.nLP.QE();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        cKi();
        this.nLS = false;
        if (this.nLU != null) {
            this.nLU.cancel();
        }
        if (this.nLP != null && this.nLP.dTe() != null) {
            this.nLP.dTe().pause();
            this.nLP.dTe().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.nLP == null || this.nLQ == null || this.nLR == null) {
            cKi();
            this.nLS = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.nLS) {
            this.nLS = true;
            this.MD = false;
            if (this.nLU != null) {
                this.nLU.cancel();
            }
            this.mCoverPath = null;
            this.nLP.onPause();
            this.jNj.setDialogVisiable(true);
            dSv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKi() {
        if (this.jNj != null) {
            this.jNj.setDialogVisiable(false);
        }
    }

    private void dSv() {
        if (this.MD) {
            this.MD = false;
            return;
        }
        String text = this.nLP.getText();
        if (TextUtils.isEmpty(text)) {
            this.nLQ.bX(this.mVideoPath, this.nLP.getCurrentPosition());
        } else {
            this.nLQ.Qg(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bzu() {
        this.MD = false;
        this.nLS = false;
        this.nLV.yU(false);
        this.nLV.coverPath = this.mCoverPath;
        this.nLV.originPath = this.mVideoPath;
        this.nLV.musicPath = this.nLP.dTj();
        this.nLV.isMute = this.nLP.isMute();
        this.nLV.filterName = this.nLT.dSy();
        this.nLU.dTn();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dvH() {
        if (this.nLP == null || this.nLQ == null) {
            cKi();
            this.nLS = false;
        } else if (this.MD) {
            this.MD = false;
        } else {
            this.nLQ.bX(this.mVideoPath, this.nLP.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Qe(String str) {
        if (this.MD) {
            this.MD = false;
        } else if (this.nLS) {
            showToast(str);
            cKi();
            this.nLS = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void M(Bitmap bitmap) {
        this.nLP.dTe().Q(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Ud(String str) {
        String str2;
        String str3;
        AntiData antiData;
        PostPrefixData postPrefixData;
        if (this.MD) {
            this.MD = false;
            return;
        }
        this.mCoverPath = str;
        Uf(this.mCoverPath);
        cKi();
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
            editVideoData.musicPath = this.nLP.dTj();
            editVideoData.musicId = this.nLP.dTk();
            editVideoData.isMute = this.nLP.isMute();
            editVideoData.filterName = this.nLT.dSy();
            this.mVideoInfo.setEditVideoData(editVideoData);
            WriteActivityConfig videoInfo = WriteActivityConfig.newInstance(this).setType(9).setFrom(this.mFrom).setCallFrom(this.jMP).setStatisticFrom(this.statisticFrom).setForumId(this.fNd).setForumName(this.mForumName).setAntiData(antiData).setPrefixData(postPrefixData).setForumDir(str3, str2).setFrsTabInfo(this.nLM).setVideoInfo(this.mVideoInfo);
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
        this.nLP.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dSw() {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void fY(List<PendantData> list) {
        this.nLP.fY(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25032) {
                String stringExtra = intent.getStringExtra("music_resource");
                String stringExtra2 = intent.getStringExtra("music_id");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    String Ui = com.baidu.tieba.video.editvideo.model.a.dSM().Ui(stringExtra);
                    if (this.nLP != null && !TextUtils.isEmpty(Ui)) {
                        this.nLP.gG(Ui, stringExtra2);
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
    public void Ue(String str) {
        try {
            new z(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.bt(this, str);
        } catch (Exception e) {
            cKi();
            this.nLS = false;
        }
    }

    private void Uf(String str) {
        try {
            new z(this).saveImage(str);
            com.baidu.tieba.video.editvideo.b.c.bt(this, str);
        } catch (Exception e) {
            cKi();
            this.nLS = false;
        }
    }

    private void N(Bitmap bitmap) {
        if (this.nLP == null || this.nLQ == null) {
            cKi();
            this.nLS = false;
        } else if (this.MD) {
            this.MD = false;
        } else {
            if (!TextUtils.isEmpty(this.nLP.getText())) {
                bitmap = this.nLP.F(bitmap);
            }
            if (bitmap != null) {
                this.nLQ.b(bitmap, c.nKl);
            }
        }
    }
}
