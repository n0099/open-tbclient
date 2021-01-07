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
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.y;
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
    private boolean MH;
    private String bvZ;
    private String fPy;
    private String jLR;
    private com.baidu.tbadk.core.view.a jMl;
    private int lYb;
    private String mCoverPath;
    private String mForumName;
    private String mFrom;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;
    private int nGF;
    private FrsTabInfoData nGG;
    private String nGH;
    private List<VideoTitleData> nGI;
    private com.baidu.tieba.video.editvideo.view.a nGJ;
    private SelectCoverModel nGK;
    private SelectMusicModel nGL;
    private boolean nGM;
    private com.baidu.tieba.video.editvideo.b.a nGN;
    private com.baidu.tieba.video.editvideo.view.b nGO;
    private com.baidu.tieba.video.b nGP;
    private HttpMessageListener nGQ;
    private CustomMessageListener nGR;
    private g nsO;
    private int statisticFrom;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.nsO = kVar.diQ();
        }
        this.nGQ = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.nGI = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.nGR = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
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
            this.nGP.originPath = this.mVideoPath;
        }
        this.nGJ.setData(this.mVideoPath);
        dTY();
        this.bvZ = getIntent().getStringExtra("from_type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_edit_video);
        this.fPy = getIntent().getStringExtra("forum_id");
        this.lYb = getIntent().getIntExtra("key_write_level", -1);
        this.nGF = getIntent().getIntExtra(EditVideoActivityConfig.KEY_PRO_ZONE, -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.nGH = getIntent().getStringExtra("video_title");
        this.jLR = getIntent().getStringExtra("KEY_CALL_FROM");
        this.statisticFrom = getIntent().getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0);
        this.bvZ = getIntent().getStringExtra("from_type");
        this.mFrom = getIntent().getStringExtra("from");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.nGG = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.nFh).mkdirs();
        this.nGK = new SelectCoverModel(getPageContext(), this, this.nsO);
        this.nGL = new SelectMusicModel(getPageContext(), this);
        this.nGN = new com.baidu.tieba.video.editvideo.b.a(this);
        this.nGJ = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.nsO);
        this.nGJ.setData(this.mVideoPath);
        this.nGJ.am(getIntent());
        this.nGJ.a(this.nGN);
        this.nGJ.setGenMaskCoverListener(this);
        this.nGK.dUy();
        this.nGL.dUz();
        this.jMl = new com.baidu.tbadk.core.view.a(getPageContext());
        this.jMl.setTipString(R.string.mixing);
        registerListener(this.nGR);
        dUb();
        registerListener(this.nGQ);
        dUa();
        TiebaStatic.log("c12303");
        this.nGP = new com.baidu.tieba.video.b(this, this.mVideoPath, this.mCoverPath) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
            @Override // com.baidu.tieba.video.b
            public void onCancel() {
                super.onCancel();
                EditVideoActivity.this.cMN();
            }

            @Override // com.baidu.tieba.video.b
            public void dTw() {
                EditVideoActivity.this.nGJ.dUO();
                EditVideoActivity.this.nGJ.dUP();
                EditVideoActivity.this.nGJ.dUL().releaseSource();
            }

            @Override // com.baidu.tieba.video.b
            public void bT(int i, String str) {
                super.bT(i, str);
                EditVideoActivity.this.cMN();
            }

            @Override // com.baidu.tieba.video.b
            public void dTx() {
            }

            @Override // com.baidu.tieba.video.b
            public void bU(int i, String str) {
                super.bU(i, str);
                EditVideoActivity.this.cMN();
            }

            @Override // com.baidu.tieba.video.b
            public void a(VideoInfo videoInfo) {
                super.a(videoInfo);
                if (!EditVideoActivity.this.nGM) {
                    File file = new File(videoInfo.getVideoPath());
                    String str = c.nFh + file.getName();
                    if (!str.equals(file.getAbsolutePath())) {
                        n.copyFile(file.getAbsolutePath(), str);
                    }
                    EditVideoActivity.this.Uo(str);
                    EditVideoActivity.this.finishPage();
                }
            }
        };
        this.nGO = new com.baidu.tieba.video.editvideo.view.b(this.nGP);
        dTY();
    }

    private void dTY() {
        if (this.mVideoInfo != null && this.mVideoInfo.getEditVideoData() != null && this.nGJ != null) {
            com.baidu.tieba.video.editvideo.data.a Uy = this.nGJ.Uy(this.mVideoInfo.getEditVideoData().filterName);
            if (Uy != null) {
                if (this.nGN != null) {
                    this.nGN.b(Uy);
                }
                this.nGJ.c(Uy);
            }
            this.nGJ.gA(this.mVideoInfo.getEditVideoData().musicPath, this.mVideoInfo.getEditVideoData().musicId);
            this.nGJ.yK(!this.mVideoInfo.getEditVideoData().isMute);
        }
    }

    public String brd() {
        return this.bvZ;
    }

    private void dTZ() {
        if (this.nGO != null) {
            this.nGO.cancel();
        }
        this.MH = true;
        this.mCoverPath = null;
        cMN();
    }

    public void dUa() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.fPy)) {
            httpMessage.addParam("forum_id", this.fPy);
        }
        sendMessage(httpMessage);
    }

    private void dUb() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.nGJ.getRootView());
        if (this.nGJ != null) {
            this.nGJ.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.nGJ != null) {
            this.nGJ.onPause();
            this.nGJ.dUO();
            this.nGJ.dUP();
            this.nGJ.dUL().releaseSource();
        }
        if (this.nGN.dUg()) {
            this.nGN.dUh();
        }
        this.nGM = false;
        this.MH = true;
        if (this.nGO != null) {
            this.nGO.cancel();
        }
        dTZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nGJ != null) {
            this.nGJ.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.dUt().dUu();
        com.baidu.tieba.video.editvideo.model.b.dUw().dUx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nGJ != null) {
            this.nGJ.release();
        }
        if (this.nGK != null) {
            this.nGK.cancelLoadData();
        }
        if (this.nGL != null) {
            this.nGL.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.nGJ != null) {
            this.nGJ.SY();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        cMN();
        this.nGM = false;
        if (this.nGO != null) {
            this.nGO.cancel();
        }
        if (this.nGJ != null && this.nGJ.dUL() != null) {
            this.nGJ.dUL().pause();
            this.nGJ.dUL().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.nGJ == null || this.nGK == null || this.nGL == null) {
            cMN();
            this.nGM = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.nGM) {
            this.nGM = true;
            this.MH = false;
            if (this.nGO != null) {
                this.nGO.cancel();
            }
            this.mCoverPath = null;
            this.nGJ.onPause();
            this.jMl.setDialogVisiable(true);
            dUc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMN() {
        if (this.jMl != null) {
            this.jMl.setDialogVisiable(false);
        }
    }

    private void dUc() {
        if (this.MH) {
            this.MH = false;
            return;
        }
        String text = this.nGJ.getText();
        if (TextUtils.isEmpty(text)) {
            this.nGK.bW(this.mVideoPath, this.nGJ.getCurrentPosition());
        } else {
            this.nGK.Qw(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bCW() {
        this.MH = false;
        this.nGM = false;
        this.nGP.yF(false);
        this.nGP.coverPath = this.mCoverPath;
        this.nGP.originPath = this.mVideoPath;
        this.nGP.musicPath = this.nGJ.dUQ();
        this.nGP.isMute = this.nGJ.isMute();
        this.nGP.filterName = this.nGN.dUf();
        this.nGO.dUU();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dxq() {
        if (this.nGJ == null || this.nGK == null) {
            cMN();
            this.nGM = false;
        } else if (this.MH) {
            this.MH = false;
        } else {
            this.nGK.bW(this.mVideoPath, this.nGJ.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Qu(String str) {
        if (this.MH) {
            this.MH = false;
        } else if (this.nGM) {
            showToast(str);
            cMN();
            this.nGM = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void N(Bitmap bitmap) {
        this.nGJ.dUL().R(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Un(String str) {
        String str2;
        String str3;
        AntiData antiData;
        PostPrefixData postPrefixData;
        if (this.MH) {
            this.MH = false;
            return;
        }
        this.mCoverPath = str;
        Up(this.mCoverPath);
        cMN();
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
            editVideoData.musicPath = this.nGJ.dUQ();
            editVideoData.musicId = this.nGJ.dUR();
            editVideoData.isMute = this.nGJ.isMute();
            editVideoData.filterName = this.nGN.dUf();
            this.mVideoInfo.setEditVideoData(editVideoData);
            WriteActivityConfig videoInfo = WriteActivityConfig.newInstance(this).setType(9).setFrom(this.mFrom).setCallFrom(this.jLR).setStatisticFrom(this.statisticFrom).setForumId(this.fPy).setForumName(this.mForumName).setAntiData(antiData).setPrefixData(postPrefixData).setForumDir(str3, str2).setFrsTabInfo(this.nGG).setVideoInfo(this.mVideoInfo);
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
        this.nGJ.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dUd() {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void ga(List<PendantData> list) {
        this.nGJ.ga(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25032) {
                String stringExtra = intent.getStringExtra("music_resource");
                String stringExtra2 = intent.getStringExtra("music_id");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    String Us = com.baidu.tieba.video.editvideo.model.a.dUt().Us(stringExtra);
                    if (this.nGJ != null && !TextUtils.isEmpty(Us)) {
                        this.nGJ.gB(Us, stringExtra2);
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
        O(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uo(String str) {
        try {
            new y(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.bu(this, str);
        } catch (Exception e) {
            cMN();
            this.nGM = false;
        }
    }

    private void Up(String str) {
        try {
            new y(this).saveImage(str);
            com.baidu.tieba.video.editvideo.b.c.bu(this, str);
        } catch (Exception e) {
            cMN();
            this.nGM = false;
        }
    }

    private void O(Bitmap bitmap) {
        if (this.nGJ == null || this.nGK == null) {
            cMN();
            this.nGM = false;
        } else if (this.MH) {
            this.MH = false;
        } else {
            if (!TextUtils.isEmpty(this.nGJ.getText())) {
                bitmap = this.nGJ.G(bitmap);
            }
            if (bitmap != null) {
                this.nGK.b(bitmap, c.nFf);
            }
        }
    }
}
