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
/* loaded from: classes7.dex */
public class EditVideoActivity extends BaseActivity implements a, b, MaskVideoView.b {
    private boolean MF;
    private String brl;
    private String fKR;
    private com.baidu.tbadk.core.view.a jHF;
    private String jHl;
    private int lTx;
    private String mCoverPath;
    private String mForumName;
    private String mFrom;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;
    private int nCa;
    private FrsTabInfoData nCb;
    private String nCc;
    private List<VideoTitleData> nCd;
    private com.baidu.tieba.video.editvideo.view.a nCe;
    private SelectCoverModel nCf;
    private SelectMusicModel nCg;
    private boolean nCh;
    private com.baidu.tieba.video.editvideo.b.a nCi;
    private com.baidu.tieba.video.editvideo.view.b nCj;
    private com.baidu.tieba.video.b nCk;
    private HttpMessageListener nCl;
    private CustomMessageListener nCm;
    private g noh;
    private int statisticFrom;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.noh = kVar.deY();
        }
        this.nCl = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.nCd = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.nCm = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
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
            this.nCk.originPath = this.mVideoPath;
        }
        this.nCe.setData(this.mVideoPath);
        dQg();
        this.brl = getIntent().getStringExtra("from_type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_edit_video);
        this.fKR = getIntent().getStringExtra("forum_id");
        this.lTx = getIntent().getIntExtra("key_write_level", -1);
        this.nCa = getIntent().getIntExtra(EditVideoActivityConfig.KEY_PRO_ZONE, -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.nCc = getIntent().getStringExtra("video_title");
        this.jHl = getIntent().getStringExtra("KEY_CALL_FROM");
        this.statisticFrom = getIntent().getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0);
        this.brl = getIntent().getStringExtra("from_type");
        this.mFrom = getIntent().getStringExtra("from");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.nCb = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.nAC).mkdirs();
        this.nCf = new SelectCoverModel(getPageContext(), this, this.noh);
        this.nCg = new SelectMusicModel(getPageContext(), this);
        this.nCi = new com.baidu.tieba.video.editvideo.b.a(this);
        this.nCe = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.noh);
        this.nCe.setData(this.mVideoPath);
        this.nCe.am(getIntent());
        this.nCe.a(this.nCi);
        this.nCe.setGenMaskCoverListener(this);
        this.nCf.dQG();
        this.nCg.dQH();
        this.jHF = new com.baidu.tbadk.core.view.a(getPageContext());
        this.jHF.setTipString(R.string.mixing);
        registerListener(this.nCm);
        dQj();
        registerListener(this.nCl);
        dQi();
        TiebaStatic.log("c12303");
        this.nCk = new com.baidu.tieba.video.b(this, this.mVideoPath, this.mCoverPath) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
            @Override // com.baidu.tieba.video.b
            public void onCancel() {
                super.onCancel();
                EditVideoActivity.this.cIV();
            }

            @Override // com.baidu.tieba.video.b
            public void dPE() {
                EditVideoActivity.this.nCe.dQW();
                EditVideoActivity.this.nCe.dQX();
                EditVideoActivity.this.nCe.dQT().releaseSource();
            }

            @Override // com.baidu.tieba.video.b
            public void bU(int i, String str) {
                super.bU(i, str);
                EditVideoActivity.this.cIV();
            }

            @Override // com.baidu.tieba.video.b
            public void dPF() {
            }

            @Override // com.baidu.tieba.video.b
            public void bV(int i, String str) {
                super.bV(i, str);
                EditVideoActivity.this.cIV();
            }

            @Override // com.baidu.tieba.video.b
            public void a(VideoInfo videoInfo) {
                super.a(videoInfo);
                if (!EditVideoActivity.this.nCh) {
                    File file = new File(videoInfo.getVideoPath());
                    String str = c.nAC + file.getName();
                    if (!str.equals(file.getAbsolutePath())) {
                        n.copyFile(file.getAbsolutePath(), str);
                    }
                    EditVideoActivity.this.Tg(str);
                    EditVideoActivity.this.finishPage();
                }
            }
        };
        this.nCj = new com.baidu.tieba.video.editvideo.view.b(this.nCk);
        dQg();
    }

    private void dQg() {
        if (this.mVideoInfo != null && this.mVideoInfo.getEditVideoData() != null && this.nCe != null) {
            com.baidu.tieba.video.editvideo.data.a Tq = this.nCe.Tq(this.mVideoInfo.getEditVideoData().filterName);
            if (Tq != null) {
                if (this.nCi != null) {
                    this.nCi.b(Tq);
                }
                this.nCe.c(Tq);
            }
            this.nCe.gz(this.mVideoInfo.getEditVideoData().musicPath, this.mVideoInfo.getEditVideoData().musicId);
            this.nCe.yG(!this.mVideoInfo.getEditVideoData().isMute);
        }
    }

    public String bnj() {
        return this.brl;
    }

    private void dQh() {
        if (this.nCj != null) {
            this.nCj.cancel();
        }
        this.MF = true;
        this.mCoverPath = null;
        cIV();
    }

    public void dQi() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.fKR)) {
            httpMessage.addParam("forum_id", this.fKR);
        }
        sendMessage(httpMessage);
    }

    private void dQj() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.nCe.getRootView());
        if (this.nCe != null) {
            this.nCe.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.nCe != null) {
            this.nCe.onPause();
            this.nCe.dQW();
            this.nCe.dQX();
            this.nCe.dQT().releaseSource();
        }
        if (this.nCi.dQo()) {
            this.nCi.dQp();
        }
        this.nCh = false;
        this.MF = true;
        if (this.nCj != null) {
            this.nCj.cancel();
        }
        dQh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nCe != null) {
            this.nCe.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.dQB().dQC();
        com.baidu.tieba.video.editvideo.model.b.dQE().dQF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nCe != null) {
            this.nCe.release();
        }
        if (this.nCf != null) {
            this.nCf.cancelLoadData();
        }
        if (this.nCg != null) {
            this.nCg.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.nCe != null) {
            this.nCe.Pd();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        cIV();
        this.nCh = false;
        if (this.nCj != null) {
            this.nCj.cancel();
        }
        if (this.nCe != null && this.nCe.dQT() != null) {
            this.nCe.dQT().pause();
            this.nCe.dQT().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.nCe == null || this.nCf == null || this.nCg == null) {
            cIV();
            this.nCh = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.nCh) {
            this.nCh = true;
            this.MF = false;
            if (this.nCj != null) {
                this.nCj.cancel();
            }
            this.mCoverPath = null;
            this.nCe.onPause();
            this.jHF.setDialogVisiable(true);
            dQk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIV() {
        if (this.jHF != null) {
            this.jHF.setDialogVisiable(false);
        }
    }

    private void dQk() {
        if (this.MF) {
            this.MF = false;
            return;
        }
        String text = this.nCe.getText();
        if (TextUtils.isEmpty(text)) {
            this.nCf.bW(this.mVideoPath, this.nCe.getCurrentPosition());
        } else {
            this.nCf.Po(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bzc() {
        this.MF = false;
        this.nCh = false;
        this.nCk.yB(false);
        this.nCk.coverPath = this.mCoverPath;
        this.nCk.originPath = this.mVideoPath;
        this.nCk.musicPath = this.nCe.dQY();
        this.nCk.isMute = this.nCe.isMute();
        this.nCk.filterName = this.nCi.dQn();
        this.nCj.dRc();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dty() {
        if (this.nCe == null || this.nCf == null) {
            cIV();
            this.nCh = false;
        } else if (this.MF) {
            this.MF = false;
        } else {
            this.nCf.bW(this.mVideoPath, this.nCe.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Pm(String str) {
        if (this.MF) {
            this.MF = false;
        } else if (this.nCh) {
            showToast(str);
            cIV();
            this.nCh = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void N(Bitmap bitmap) {
        this.nCe.dQT().R(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Tf(String str) {
        String str2;
        String str3;
        AntiData antiData;
        PostPrefixData postPrefixData;
        if (this.MF) {
            this.MF = false;
            return;
        }
        this.mCoverPath = str;
        Th(this.mCoverPath);
        cIV();
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
            editVideoData.musicPath = this.nCe.dQY();
            editVideoData.musicId = this.nCe.dQZ();
            editVideoData.isMute = this.nCe.isMute();
            editVideoData.filterName = this.nCi.dQn();
            this.mVideoInfo.setEditVideoData(editVideoData);
            WriteActivityConfig videoInfo = WriteActivityConfig.newInstance(this).setType(9).setFrom(this.mFrom).setCallFrom(this.jHl).setStatisticFrom(this.statisticFrom).setForumId(this.fKR).setForumName(this.mForumName).setAntiData(antiData).setPrefixData(postPrefixData).setForumDir(str3, str2).setFrsTabInfo(this.nCb).setVideoInfo(this.mVideoInfo);
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
        this.nCe.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dQl() {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void ga(List<PendantData> list) {
        this.nCe.ga(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25032) {
                String stringExtra = intent.getStringExtra("music_resource");
                String stringExtra2 = intent.getStringExtra("music_id");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    String Tk = com.baidu.tieba.video.editvideo.model.a.dQB().Tk(stringExtra);
                    if (this.nCe != null && !TextUtils.isEmpty(Tk)) {
                        this.nCe.gA(Tk, stringExtra2);
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
    public void Tg(String str) {
        try {
            new y(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.bu(this, str);
        } catch (Exception e) {
            cIV();
            this.nCh = false;
        }
    }

    private void Th(String str) {
        try {
            new y(this).saveImage(str);
            com.baidu.tieba.video.editvideo.b.c.bu(this, str);
        } catch (Exception e) {
            cIV();
            this.nCh = false;
        }
    }

    private void O(Bitmap bitmap) {
        if (this.nCe == null || this.nCf == null) {
            cIV();
            this.nCh = false;
        } else if (this.MF) {
            this.MF = false;
        } else {
            if (!TextUtils.isEmpty(this.nCe.getText())) {
                bitmap = this.nCe.G(bitmap);
            }
            if (bitmap != null) {
                this.nCf.b(bitmap, c.nAA);
            }
        }
    }
}
