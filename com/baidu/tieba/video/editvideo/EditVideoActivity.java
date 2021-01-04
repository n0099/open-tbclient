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
    private int lYc;
    private String mCoverPath;
    private String mForumName;
    private String mFrom;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;
    private int nGG;
    private FrsTabInfoData nGH;
    private String nGI;
    private List<VideoTitleData> nGJ;
    private com.baidu.tieba.video.editvideo.view.a nGK;
    private SelectCoverModel nGL;
    private SelectMusicModel nGM;
    private boolean nGN;
    private com.baidu.tieba.video.editvideo.b.a nGO;
    private com.baidu.tieba.video.editvideo.view.b nGP;
    private com.baidu.tieba.video.b nGQ;
    private HttpMessageListener nGR;
    private CustomMessageListener nGS;
    private g nsP;
    private int statisticFrom;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.nsP = kVar.diP();
        }
        this.nGR = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.nGJ = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.nGS = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
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
            this.nGQ.originPath = this.mVideoPath;
        }
        this.nGK.setData(this.mVideoPath);
        dTX();
        this.bvZ = getIntent().getStringExtra("from_type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_edit_video);
        this.fPy = getIntent().getStringExtra("forum_id");
        this.lYc = getIntent().getIntExtra("key_write_level", -1);
        this.nGG = getIntent().getIntExtra(EditVideoActivityConfig.KEY_PRO_ZONE, -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.nGI = getIntent().getStringExtra("video_title");
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
            this.nGH = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.nFi).mkdirs();
        this.nGL = new SelectCoverModel(getPageContext(), this, this.nsP);
        this.nGM = new SelectMusicModel(getPageContext(), this);
        this.nGO = new com.baidu.tieba.video.editvideo.b.a(this);
        this.nGK = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.nsP);
        this.nGK.setData(this.mVideoPath);
        this.nGK.am(getIntent());
        this.nGK.a(this.nGO);
        this.nGK.setGenMaskCoverListener(this);
        this.nGL.dUx();
        this.nGM.dUy();
        this.jMl = new com.baidu.tbadk.core.view.a(getPageContext());
        this.jMl.setTipString(R.string.mixing);
        registerListener(this.nGS);
        dUa();
        registerListener(this.nGR);
        dTZ();
        TiebaStatic.log("c12303");
        this.nGQ = new com.baidu.tieba.video.b(this, this.mVideoPath, this.mCoverPath) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
            @Override // com.baidu.tieba.video.b
            public void onCancel() {
                super.onCancel();
                EditVideoActivity.this.cMM();
            }

            @Override // com.baidu.tieba.video.b
            public void dTv() {
                EditVideoActivity.this.nGK.dUN();
                EditVideoActivity.this.nGK.dUO();
                EditVideoActivity.this.nGK.dUK().releaseSource();
            }

            @Override // com.baidu.tieba.video.b
            public void bT(int i, String str) {
                super.bT(i, str);
                EditVideoActivity.this.cMM();
            }

            @Override // com.baidu.tieba.video.b
            public void dTw() {
            }

            @Override // com.baidu.tieba.video.b
            public void bU(int i, String str) {
                super.bU(i, str);
                EditVideoActivity.this.cMM();
            }

            @Override // com.baidu.tieba.video.b
            public void a(VideoInfo videoInfo) {
                super.a(videoInfo);
                if (!EditVideoActivity.this.nGN) {
                    File file = new File(videoInfo.getVideoPath());
                    String str = c.nFi + file.getName();
                    if (!str.equals(file.getAbsolutePath())) {
                        n.copyFile(file.getAbsolutePath(), str);
                    }
                    EditVideoActivity.this.Up(str);
                    EditVideoActivity.this.finishPage();
                }
            }
        };
        this.nGP = new com.baidu.tieba.video.editvideo.view.b(this.nGQ);
        dTX();
    }

    private void dTX() {
        if (this.mVideoInfo != null && this.mVideoInfo.getEditVideoData() != null && this.nGK != null) {
            com.baidu.tieba.video.editvideo.data.a Uz = this.nGK.Uz(this.mVideoInfo.getEditVideoData().filterName);
            if (Uz != null) {
                if (this.nGO != null) {
                    this.nGO.b(Uz);
                }
                this.nGK.c(Uz);
            }
            this.nGK.gA(this.mVideoInfo.getEditVideoData().musicPath, this.mVideoInfo.getEditVideoData().musicId);
            this.nGK.yK(!this.mVideoInfo.getEditVideoData().isMute);
        }
    }

    public String brc() {
        return this.bvZ;
    }

    private void dTY() {
        if (this.nGP != null) {
            this.nGP.cancel();
        }
        this.MH = true;
        this.mCoverPath = null;
        cMM();
    }

    public void dTZ() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.fPy)) {
            httpMessage.addParam("forum_id", this.fPy);
        }
        sendMessage(httpMessage);
    }

    private void dUa() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.nGK.getRootView());
        if (this.nGK != null) {
            this.nGK.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.nGK != null) {
            this.nGK.onPause();
            this.nGK.dUN();
            this.nGK.dUO();
            this.nGK.dUK().releaseSource();
        }
        if (this.nGO.dUf()) {
            this.nGO.dUg();
        }
        this.nGN = false;
        this.MH = true;
        if (this.nGP != null) {
            this.nGP.cancel();
        }
        dTY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nGK != null) {
            this.nGK.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.dUs().dUt();
        com.baidu.tieba.video.editvideo.model.b.dUv().dUw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nGK != null) {
            this.nGK.release();
        }
        if (this.nGL != null) {
            this.nGL.cancelLoadData();
        }
        if (this.nGM != null) {
            this.nGM.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.nGK != null) {
            this.nGK.SY();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        cMM();
        this.nGN = false;
        if (this.nGP != null) {
            this.nGP.cancel();
        }
        if (this.nGK != null && this.nGK.dUK() != null) {
            this.nGK.dUK().pause();
            this.nGK.dUK().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.nGK == null || this.nGL == null || this.nGM == null) {
            cMM();
            this.nGN = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.nGN) {
            this.nGN = true;
            this.MH = false;
            if (this.nGP != null) {
                this.nGP.cancel();
            }
            this.mCoverPath = null;
            this.nGK.onPause();
            this.jMl.setDialogVisiable(true);
            dUb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMM() {
        if (this.jMl != null) {
            this.jMl.setDialogVisiable(false);
        }
    }

    private void dUb() {
        if (this.MH) {
            this.MH = false;
            return;
        }
        String text = this.nGK.getText();
        if (TextUtils.isEmpty(text)) {
            this.nGL.bW(this.mVideoPath, this.nGK.getCurrentPosition());
        } else {
            this.nGL.Qx(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bCV() {
        this.MH = false;
        this.nGN = false;
        this.nGQ.yF(false);
        this.nGQ.coverPath = this.mCoverPath;
        this.nGQ.originPath = this.mVideoPath;
        this.nGQ.musicPath = this.nGK.dUP();
        this.nGQ.isMute = this.nGK.isMute();
        this.nGQ.filterName = this.nGO.dUe();
        this.nGP.dUT();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dxp() {
        if (this.nGK == null || this.nGL == null) {
            cMM();
            this.nGN = false;
        } else if (this.MH) {
            this.MH = false;
        } else {
            this.nGL.bW(this.mVideoPath, this.nGK.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Qv(String str) {
        if (this.MH) {
            this.MH = false;
        } else if (this.nGN) {
            showToast(str);
            cMM();
            this.nGN = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void N(Bitmap bitmap) {
        this.nGK.dUK().R(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Uo(String str) {
        String str2;
        String str3;
        AntiData antiData;
        PostPrefixData postPrefixData;
        if (this.MH) {
            this.MH = false;
            return;
        }
        this.mCoverPath = str;
        Uq(this.mCoverPath);
        cMM();
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
            editVideoData.musicPath = this.nGK.dUP();
            editVideoData.musicId = this.nGK.dUQ();
            editVideoData.isMute = this.nGK.isMute();
            editVideoData.filterName = this.nGO.dUe();
            this.mVideoInfo.setEditVideoData(editVideoData);
            WriteActivityConfig videoInfo = WriteActivityConfig.newInstance(this).setType(9).setFrom(this.mFrom).setCallFrom(this.jLR).setStatisticFrom(this.statisticFrom).setForumId(this.fPy).setForumName(this.mForumName).setAntiData(antiData).setPrefixData(postPrefixData).setForumDir(str3, str2).setFrsTabInfo(this.nGH).setVideoInfo(this.mVideoInfo);
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
        this.nGK.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dUc() {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void ga(List<PendantData> list) {
        this.nGK.ga(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25032) {
                String stringExtra = intent.getStringExtra("music_resource");
                String stringExtra2 = intent.getStringExtra("music_id");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    String Ut = com.baidu.tieba.video.editvideo.model.a.dUs().Ut(stringExtra);
                    if (this.nGK != null && !TextUtils.isEmpty(Ut)) {
                        this.nGK.gB(Ut, stringExtra2);
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
    public void Up(String str) {
        try {
            new y(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.bu(this, str);
        } catch (Exception e) {
            cMM();
            this.nGN = false;
        }
    }

    private void Uq(String str) {
        try {
            new y(this).saveImage(str);
            com.baidu.tieba.video.editvideo.b.c.bu(this, str);
        } catch (Exception e) {
            cMM();
            this.nGN = false;
        }
    }

    private void O(Bitmap bitmap) {
        if (this.nGK == null || this.nGL == null) {
            cMM();
            this.nGN = false;
        } else if (this.MH) {
            this.MH = false;
        } else {
            if (!TextUtils.isEmpty(this.nGK.getText())) {
                bitmap = this.nGK.G(bitmap);
            }
            if (bitmap != null) {
                this.nGL.b(bitmap, c.nFg);
            }
        }
    }
}
