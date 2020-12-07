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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.l.h;
import com.baidu.tieba.l.l;
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
import java.util.HashMap;
import java.util.List;
/* loaded from: classes23.dex */
public class EditVideoActivity extends BaseActivity implements a, b, MaskVideoView.b {
    private boolean Nj;
    private String brs;
    private String fFV;
    private com.baidu.tbadk.core.view.a jzK;
    private String jzq;
    private int lSO;
    private String mCoverPath;
    private String mForumName;
    private String mFrom;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;
    private List<VideoTitleData> nCA;
    private com.baidu.tieba.video.editvideo.view.a nCB;
    private SelectCoverModel nCC;
    private SelectMusicModel nCD;
    private boolean nCE;
    private com.baidu.tieba.video.editvideo.b.a nCF;
    private com.baidu.tieba.video.editvideo.view.b nCG;
    private com.baidu.tieba.video.b nCH;
    private HttpMessageListener nCI;
    private CustomMessageListener nCJ;
    private int nCx;
    private FrsTabInfoData nCy;
    private String nCz;
    private h nnb;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.nnb = lVar.djb();
        }
        this.nCI = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.nCA = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.nCJ = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
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
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
            this.nCH.originPath = this.mVideoPath;
        }
        this.nCB.setData(this.mVideoPath);
        dUf();
        this.brs = getIntent().getStringExtra("from_type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_edit_video);
        this.fFV = getIntent().getStringExtra("forum_id");
        this.lSO = getIntent().getIntExtra("key_write_level", -1);
        this.nCx = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.nCz = getIntent().getStringExtra("video_title");
        this.jzq = getIntent().getStringExtra("KEY_CALL_FROM");
        this.brs = getIntent().getStringExtra("from_type");
        this.mFrom = getIntent().getStringExtra("from");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.nCy = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.nAY).mkdirs();
        this.nCC = new SelectCoverModel(getPageContext(), this, this.nnb);
        this.nCD = new SelectMusicModel(getPageContext(), this);
        this.nCF = new com.baidu.tieba.video.editvideo.b.a(this);
        this.nCB = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.nnb);
        this.nCB.setData(this.mVideoPath);
        this.nCB.am(getIntent());
        this.nCB.a(this.nCF);
        this.nCB.setGenMaskCoverListener(this);
        this.nCC.dUF();
        this.nCD.dUG();
        this.jzK = new com.baidu.tbadk.core.view.a(getPageContext());
        this.jzK.setTipString(R.string.mixing);
        registerListener(this.nCJ);
        dUi();
        registerListener(this.nCI);
        dUh();
        TiebaStatic.log("c12303");
        this.nCH = new com.baidu.tieba.video.b(this, this.mVideoPath, this.mCoverPath) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
            @Override // com.baidu.tieba.video.b
            public void onCancel() {
                super.onCancel();
                EditVideoActivity.this.cJL();
            }

            @Override // com.baidu.tieba.video.b
            public void dTD() {
                EditVideoActivity.this.nCB.dUV();
                EditVideoActivity.this.nCB.dUW();
                EditVideoActivity.this.nCB.dUS().releaseSource();
            }

            @Override // com.baidu.tieba.video.b
            public void bT(int i, String str) {
                super.bT(i, str);
                EditVideoActivity.this.cJL();
            }

            @Override // com.baidu.tieba.video.b
            public void dTE() {
            }

            @Override // com.baidu.tieba.video.b
            public void bU(int i, String str) {
                super.bU(i, str);
                EditVideoActivity.this.cJL();
            }

            @Override // com.baidu.tieba.video.b
            public void a(final VideoInfo videoInfo) {
                super.a(videoInfo);
                if (EditVideoActivity.this.nCE) {
                    if (EditVideoActivity.this.jzq == null || !EditVideoActivity.this.jzq.equals("1") || TextUtils.isEmpty(videoInfo.getVideoPath())) {
                        return;
                    }
                    n.a(new String[]{videoInfo.getThumbPath(), videoInfo.getVideoPath()}, new n.b() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2.1
                        @Override // com.baidu.tbadk.core.util.n.b
                        public void C(HashMap<String, String> hashMap) {
                            EditVideoActivity.this.mVideoInfo.setVideoPath(videoInfo.getVideoPath());
                            EditVideoActivity.this.mVideoInfo.setThumbPath(videoInfo.getThumbPath());
                            if (hashMap != null) {
                                EditVideoActivity.this.mVideoInfo.setThumbUriStr(hashMap.get(videoInfo.getThumbPath()));
                                EditVideoActivity.this.mVideoInfo.setVideoUriStr(hashMap.get(videoInfo.getVideoPath()));
                            }
                            if (EditVideoActivity.this.nCB.dUZ() && !TextUtils.isEmpty(EditVideoActivity.this.nCB.dUY())) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(EditVideoActivity.this.nCB.dUY());
                                EditVideoActivity.this.mVideoInfo.setMusicListInfo(arrayList);
                            }
                            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(EditVideoActivity.this.getPageContext().getPageActivity(), EditVideoActivity.this.jzq, EditVideoActivity.this.fFV, EditVideoActivity.this.mForumName, EditVideoActivity.this.nCz, RequestResponseCode.REQUEST_WRITE_NEW, EditVideoActivity.this.mVideoInfo, EditVideoActivity.this.mVideoTitleData, EditVideoActivity.this.nCA);
                            if (!StringUtils.isNull(EditVideoActivity.this.brs)) {
                                writeVideoActivityConfig.addFromType(EditVideoActivity.this.brs);
                            }
                            writeVideoActivityConfig.setProZone(EditVideoActivity.this.nCx);
                            writeVideoActivityConfig.setFrom(EditVideoActivity.this.mFrom);
                            writeVideoActivityConfig.setFrsTabInfo(EditVideoActivity.this.nCy);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
                        }
                    });
                    return;
                }
                File file = new File(videoInfo.getVideoPath());
                String str = c.nAY + file.getName();
                if (!str.equals(file.getAbsolutePath())) {
                    n.copyFile(file.getAbsolutePath(), str);
                }
                EditVideoActivity.this.UI(str);
                EditVideoActivity.this.finishPage();
            }
        };
        this.nCG = new com.baidu.tieba.video.editvideo.view.b(this.nCH);
        dUf();
    }

    private void dUf() {
        if (this.mVideoInfo != null && this.mVideoInfo.getEditVideoData() != null && this.nCB != null) {
            com.baidu.tieba.video.editvideo.data.a US = this.nCB.US(this.mVideoInfo.getEditVideoData().filterName);
            if (US != null) {
                if (this.nCF != null) {
                    this.nCF.b(US);
                }
                this.nCB.c(US);
            }
            this.nCB.gD(this.mVideoInfo.getEditVideoData().musicPath, this.mVideoInfo.getEditVideoData().musicId);
            this.nCB.yH(!this.mVideoInfo.getEditVideoData().isMute);
        }
    }

    public String boB() {
        return this.brs;
    }

    private void dUg() {
        if (this.nCG != null) {
            this.nCG.cancel();
        }
        this.Nj = true;
        this.mCoverPath = null;
        cJL();
    }

    public void dUh() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.fFV)) {
            httpMessage.addParam("forum_id", this.fFV);
        }
        sendMessage(httpMessage);
    }

    private void dUi() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.nCB.getRootView());
        if (this.nCB != null) {
            this.nCB.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.nCB != null) {
            this.nCB.onPause();
            this.nCB.dUV();
            this.nCB.dUW();
            this.nCB.dUS().releaseSource();
        }
        if (this.nCF.dUn()) {
            this.nCF.dUo();
        }
        this.nCE = false;
        this.Nj = true;
        if (this.nCG != null) {
            this.nCG.cancel();
        }
        dUg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nCB != null) {
            this.nCB.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.dUA().dUB();
        com.baidu.tieba.video.editvideo.model.b.dUD().dUE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nCB != null) {
            this.nCB.release();
        }
        if (this.nCC != null) {
            this.nCC.cancelLoadData();
        }
        if (this.nCD != null) {
            this.nCD.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.nCB != null) {
            this.nCB.RU();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        cJL();
        this.nCE = false;
        if (this.nCG != null) {
            this.nCG.cancel();
        }
        if (this.nCB != null && this.nCB.dUS() != null) {
            this.nCB.dUS().pause();
            this.nCB.dUS().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.nCB == null || this.nCC == null || this.nCD == null) {
            cJL();
            this.nCE = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.nCE) {
            this.nCE = true;
            this.Nj = false;
            if (this.nCG != null) {
                this.nCG.cancel();
            }
            this.mCoverPath = null;
            this.nCB.onPause();
            this.jzK.setDialogVisiable(true);
            dUj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJL() {
        if (this.jzK != null) {
            this.jzK.setDialogVisiable(false);
        }
    }

    private void dUj() {
        if (this.Nj) {
            this.Nj = false;
            return;
        }
        String text = this.nCB.getText();
        if (TextUtils.isEmpty(text)) {
            this.nCC.bP(this.mVideoPath, this.nCB.getCurrentPosition());
        } else {
            this.nCC.QR(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bAB() {
        this.Nj = false;
        this.nCE = false;
        this.nCH.yC(false);
        this.nCH.coverPath = this.mCoverPath;
        this.nCH.originPath = this.mVideoPath;
        this.nCH.musicPath = this.nCB.dUX();
        this.nCH.isMute = this.nCB.isMute();
        this.nCH.filterName = this.nCF.dUm();
        this.nCG.dVc();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dxz() {
        if (this.nCB == null || this.nCC == null) {
            cJL();
            this.nCE = false;
        } else if (this.Nj) {
            this.Nj = false;
        } else {
            this.nCC.bP(this.mVideoPath, this.nCB.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void QP(String str) {
        if (this.Nj) {
            this.Nj = false;
        } else if (this.nCE) {
            showToast(str);
            cJL();
            this.nCE = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void M(Bitmap bitmap) {
        this.nCB.dUS().Q(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void UH(String str) {
        String str2;
        String str3;
        AntiData antiData;
        PostPrefixData postPrefixData;
        PostPrefixData postPrefixData2;
        if (this.Nj) {
            this.Nj = false;
            return;
        }
        this.mCoverPath = str;
        UJ(this.mCoverPath);
        if (this.jzq != null && this.jzq.equals("1")) {
            if (this.nCG != null) {
                this.nCH.yC(false);
                this.nCH.coverPath = this.mCoverPath;
                this.nCH.originPath = this.mVideoPath;
                this.nCH.musicPath = this.nCB.dUX();
                this.nCH.isMute = this.nCB.isMute();
                this.nCH.filterName = this.nCF.dUm();
                this.nCG.dVc();
                return;
            }
            return;
        }
        cJL();
        AntiData antiData2 = null;
        if (getIntent() == null) {
            str2 = "";
            str3 = "";
            antiData = null;
            postPrefixData = null;
        } else {
            Serializable serializableExtra = getIntent().getSerializableExtra("anti_data");
            if (serializableExtra instanceof AntiData) {
                antiData2 = (AntiData) serializableExtra;
            }
            Serializable serializableExtra2 = getIntent().getSerializableExtra("prefix_data");
            if (!(serializableExtra2 instanceof PostPrefixData)) {
                postPrefixData2 = null;
            } else {
                postPrefixData2 = (PostPrefixData) serializableExtra2;
            }
            String stringExtra = getIntent().getStringExtra("forum_first_dir");
            str2 = getIntent().getStringExtra("forum_second_dir");
            str3 = stringExtra;
            antiData = antiData2;
            postPrefixData = postPrefixData2;
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 9, this.fFV, this.mForumName, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.jzq);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.nCx);
        writeActivityConfig.setFrsTabInfo(this.nCy);
        writeActivityConfig.setVideoInfo(this.mVideoInfo);
        writeActivityConfig.setForumLevel(this.lSO);
        EditVideoData editVideoData = new EditVideoData();
        editVideoData.coverPath = this.mCoverPath;
        editVideoData.originPath = this.mVideoPath;
        editVideoData.musicPath = this.nCB.dUX();
        editVideoData.musicId = this.nCB.dUY();
        editVideoData.isMute = this.nCB.isMute();
        editVideoData.filterName = this.nCF.dUm();
        this.mVideoInfo.setEditVideoData(editVideoData);
        writeActivityConfig.getIntent().setFlags(536870912);
        writeActivityConfig.getIntent().setFlags(67108864);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(R.string.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(R.string.music_cloud)));
        this.nCB.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dUk() {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void gf(List<PendantData> list) {
        this.nCB.gf(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25032) {
                String stringExtra = intent.getStringExtra("music_resource");
                String stringExtra2 = intent.getStringExtra("music_id");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    String UM = com.baidu.tieba.video.editvideo.model.a.dUA().UM(stringExtra);
                    if (this.nCB != null && !TextUtils.isEmpty(UM)) {
                        this.nCB.gE(UM, stringExtra2);
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
    public void UI(String str) {
        try {
            new z(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.bp(this, str);
        } catch (Exception e) {
            cJL();
            this.nCE = false;
        }
    }

    private void UJ(String str) {
        try {
            new z(this).saveImage(str);
            com.baidu.tieba.video.editvideo.b.c.bp(this, str);
        } catch (Exception e) {
            cJL();
            this.nCE = false;
        }
    }

    private void N(Bitmap bitmap) {
        if (this.nCB == null || this.nCC == null) {
            cJL();
            this.nCE = false;
        } else if (this.Nj) {
            this.Nj = false;
        } else {
            if (!TextUtils.isEmpty(this.nCB.getText())) {
                bitmap = this.nCB.F(bitmap);
            }
            if (bitmap != null) {
                this.nCC.b(bitmap, c.nAW);
            }
        }
    }
}
