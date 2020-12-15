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
    private com.baidu.tbadk.core.view.a jzM;
    private String jzs;
    private int lSQ;
    private String mCoverPath;
    private String mForumName;
    private String mFrom;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;
    private FrsTabInfoData nCA;
    private String nCB;
    private List<VideoTitleData> nCC;
    private com.baidu.tieba.video.editvideo.view.a nCD;
    private SelectCoverModel nCE;
    private SelectMusicModel nCF;
    private boolean nCG;
    private com.baidu.tieba.video.editvideo.b.a nCH;
    private com.baidu.tieba.video.editvideo.view.b nCI;
    private com.baidu.tieba.video.b nCJ;
    private HttpMessageListener nCK;
    private CustomMessageListener nCL;
    private int nCz;
    private h nnd;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.nnd = lVar.djc();
        }
        this.nCK = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.nCC = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.nCL = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
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
            this.nCJ.originPath = this.mVideoPath;
        }
        this.nCD.setData(this.mVideoPath);
        dUg();
        this.brs = getIntent().getStringExtra("from_type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_edit_video);
        this.fFV = getIntent().getStringExtra("forum_id");
        this.lSQ = getIntent().getIntExtra("key_write_level", -1);
        this.nCz = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.nCB = getIntent().getStringExtra("video_title");
        this.jzs = getIntent().getStringExtra("KEY_CALL_FROM");
        this.brs = getIntent().getStringExtra("from_type");
        this.mFrom = getIntent().getStringExtra("from");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.nCA = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.nBa).mkdirs();
        this.nCE = new SelectCoverModel(getPageContext(), this, this.nnd);
        this.nCF = new SelectMusicModel(getPageContext(), this);
        this.nCH = new com.baidu.tieba.video.editvideo.b.a(this);
        this.nCD = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.nnd);
        this.nCD.setData(this.mVideoPath);
        this.nCD.am(getIntent());
        this.nCD.a(this.nCH);
        this.nCD.setGenMaskCoverListener(this);
        this.nCE.dUG();
        this.nCF.dUH();
        this.jzM = new com.baidu.tbadk.core.view.a(getPageContext());
        this.jzM.setTipString(R.string.mixing);
        registerListener(this.nCL);
        dUj();
        registerListener(this.nCK);
        dUi();
        TiebaStatic.log("c12303");
        this.nCJ = new com.baidu.tieba.video.b(this, this.mVideoPath, this.mCoverPath) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
            @Override // com.baidu.tieba.video.b
            public void onCancel() {
                super.onCancel();
                EditVideoActivity.this.cJM();
            }

            @Override // com.baidu.tieba.video.b
            public void dTE() {
                EditVideoActivity.this.nCD.dUW();
                EditVideoActivity.this.nCD.dUX();
                EditVideoActivity.this.nCD.dUT().releaseSource();
            }

            @Override // com.baidu.tieba.video.b
            public void bT(int i, String str) {
                super.bT(i, str);
                EditVideoActivity.this.cJM();
            }

            @Override // com.baidu.tieba.video.b
            public void dTF() {
            }

            @Override // com.baidu.tieba.video.b
            public void bU(int i, String str) {
                super.bU(i, str);
                EditVideoActivity.this.cJM();
            }

            @Override // com.baidu.tieba.video.b
            public void a(final VideoInfo videoInfo) {
                super.a(videoInfo);
                if (EditVideoActivity.this.nCG) {
                    if (EditVideoActivity.this.jzs == null || !EditVideoActivity.this.jzs.equals("1") || TextUtils.isEmpty(videoInfo.getVideoPath())) {
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
                            if (EditVideoActivity.this.nCD.dVa() && !TextUtils.isEmpty(EditVideoActivity.this.nCD.dUZ())) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(EditVideoActivity.this.nCD.dUZ());
                                EditVideoActivity.this.mVideoInfo.setMusicListInfo(arrayList);
                            }
                            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(EditVideoActivity.this.getPageContext().getPageActivity(), EditVideoActivity.this.jzs, EditVideoActivity.this.fFV, EditVideoActivity.this.mForumName, EditVideoActivity.this.nCB, RequestResponseCode.REQUEST_WRITE_NEW, EditVideoActivity.this.mVideoInfo, EditVideoActivity.this.mVideoTitleData, EditVideoActivity.this.nCC);
                            if (!StringUtils.isNull(EditVideoActivity.this.brs)) {
                                writeVideoActivityConfig.addFromType(EditVideoActivity.this.brs);
                            }
                            writeVideoActivityConfig.setProZone(EditVideoActivity.this.nCz);
                            writeVideoActivityConfig.setFrom(EditVideoActivity.this.mFrom);
                            writeVideoActivityConfig.setFrsTabInfo(EditVideoActivity.this.nCA);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
                        }
                    });
                    return;
                }
                File file = new File(videoInfo.getVideoPath());
                String str = c.nBa + file.getName();
                if (!str.equals(file.getAbsolutePath())) {
                    n.copyFile(file.getAbsolutePath(), str);
                }
                EditVideoActivity.this.UI(str);
                EditVideoActivity.this.finishPage();
            }
        };
        this.nCI = new com.baidu.tieba.video.editvideo.view.b(this.nCJ);
        dUg();
    }

    private void dUg() {
        if (this.mVideoInfo != null && this.mVideoInfo.getEditVideoData() != null && this.nCD != null) {
            com.baidu.tieba.video.editvideo.data.a US = this.nCD.US(this.mVideoInfo.getEditVideoData().filterName);
            if (US != null) {
                if (this.nCH != null) {
                    this.nCH.b(US);
                }
                this.nCD.c(US);
            }
            this.nCD.gD(this.mVideoInfo.getEditVideoData().musicPath, this.mVideoInfo.getEditVideoData().musicId);
            this.nCD.yH(!this.mVideoInfo.getEditVideoData().isMute);
        }
    }

    public String boB() {
        return this.brs;
    }

    private void dUh() {
        if (this.nCI != null) {
            this.nCI.cancel();
        }
        this.Nj = true;
        this.mCoverPath = null;
        cJM();
    }

    public void dUi() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.fFV)) {
            httpMessage.addParam("forum_id", this.fFV);
        }
        sendMessage(httpMessage);
    }

    private void dUj() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.nCD.getRootView());
        if (this.nCD != null) {
            this.nCD.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.nCD != null) {
            this.nCD.onPause();
            this.nCD.dUW();
            this.nCD.dUX();
            this.nCD.dUT().releaseSource();
        }
        if (this.nCH.dUo()) {
            this.nCH.dUp();
        }
        this.nCG = false;
        this.Nj = true;
        if (this.nCI != null) {
            this.nCI.cancel();
        }
        dUh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nCD != null) {
            this.nCD.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.dUB().dUC();
        com.baidu.tieba.video.editvideo.model.b.dUE().dUF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nCD != null) {
            this.nCD.release();
        }
        if (this.nCE != null) {
            this.nCE.cancelLoadData();
        }
        if (this.nCF != null) {
            this.nCF.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.nCD != null) {
            this.nCD.RU();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        cJM();
        this.nCG = false;
        if (this.nCI != null) {
            this.nCI.cancel();
        }
        if (this.nCD != null && this.nCD.dUT() != null) {
            this.nCD.dUT().pause();
            this.nCD.dUT().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.nCD == null || this.nCE == null || this.nCF == null) {
            cJM();
            this.nCG = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.nCG) {
            this.nCG = true;
            this.Nj = false;
            if (this.nCI != null) {
                this.nCI.cancel();
            }
            this.mCoverPath = null;
            this.nCD.onPause();
            this.jzM.setDialogVisiable(true);
            dUk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJM() {
        if (this.jzM != null) {
            this.jzM.setDialogVisiable(false);
        }
    }

    private void dUk() {
        if (this.Nj) {
            this.Nj = false;
            return;
        }
        String text = this.nCD.getText();
        if (TextUtils.isEmpty(text)) {
            this.nCE.bP(this.mVideoPath, this.nCD.getCurrentPosition());
        } else {
            this.nCE.QR(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bAB() {
        this.Nj = false;
        this.nCG = false;
        this.nCJ.yC(false);
        this.nCJ.coverPath = this.mCoverPath;
        this.nCJ.originPath = this.mVideoPath;
        this.nCJ.musicPath = this.nCD.dUY();
        this.nCJ.isMute = this.nCD.isMute();
        this.nCJ.filterName = this.nCH.dUn();
        this.nCI.dVd();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dxA() {
        if (this.nCD == null || this.nCE == null) {
            cJM();
            this.nCG = false;
        } else if (this.Nj) {
            this.Nj = false;
        } else {
            this.nCE.bP(this.mVideoPath, this.nCD.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void QP(String str) {
        if (this.Nj) {
            this.Nj = false;
        } else if (this.nCG) {
            showToast(str);
            cJM();
            this.nCG = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void M(Bitmap bitmap) {
        this.nCD.dUT().Q(bitmap);
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
        if (this.jzs != null && this.jzs.equals("1")) {
            if (this.nCI != null) {
                this.nCJ.yC(false);
                this.nCJ.coverPath = this.mCoverPath;
                this.nCJ.originPath = this.mVideoPath;
                this.nCJ.musicPath = this.nCD.dUY();
                this.nCJ.isMute = this.nCD.isMute();
                this.nCJ.filterName = this.nCH.dUn();
                this.nCI.dVd();
                return;
            }
            return;
        }
        cJM();
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
        writeActivityConfig.setCallFrom(this.jzs);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.nCz);
        writeActivityConfig.setFrsTabInfo(this.nCA);
        writeActivityConfig.setVideoInfo(this.mVideoInfo);
        writeActivityConfig.setForumLevel(this.lSQ);
        EditVideoData editVideoData = new EditVideoData();
        editVideoData.coverPath = this.mCoverPath;
        editVideoData.originPath = this.mVideoPath;
        editVideoData.musicPath = this.nCD.dUY();
        editVideoData.musicId = this.nCD.dUZ();
        editVideoData.isMute = this.nCD.isMute();
        editVideoData.filterName = this.nCH.dUn();
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
        this.nCD.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dUl() {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void gf(List<PendantData> list) {
        this.nCD.gf(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25032) {
                String stringExtra = intent.getStringExtra("music_resource");
                String stringExtra2 = intent.getStringExtra("music_id");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    String UM = com.baidu.tieba.video.editvideo.model.a.dUB().UM(stringExtra);
                    if (this.nCD != null && !TextUtils.isEmpty(UM)) {
                        this.nCD.gE(UM, stringExtra2);
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
            cJM();
            this.nCG = false;
        }
    }

    private void UJ(String str) {
        try {
            new z(this).saveImage(str);
            com.baidu.tieba.video.editvideo.b.c.bp(this, str);
        } catch (Exception e) {
            cJM();
            this.nCG = false;
        }
    }

    private void N(Bitmap bitmap) {
        if (this.nCD == null || this.nCE == null) {
            cJM();
            this.nCG = false;
        } else if (this.Nj) {
            this.Nj = false;
        } else {
            if (!TextUtils.isEmpty(this.nCD.getText())) {
                bitmap = this.nCD.F(bitmap);
            }
            if (bitmap != null) {
                this.nCE.b(bitmap, c.nAY);
            }
        }
    }
}
