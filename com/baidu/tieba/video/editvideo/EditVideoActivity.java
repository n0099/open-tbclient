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
import com.baidu.tieba.k.h;
import com.baidu.tieba.k.l;
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
/* loaded from: classes17.dex */
public class EditVideoActivity extends BaseActivity implements a, b, MaskVideoView.b {
    private boolean LJ;
    private String bex;
    private String eVx;
    private com.baidu.tbadk.core.view.a iwR;
    private String iwx;
    private int kOs;
    private String mCoverPath;
    private String mForumName;
    private String mFrom;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;
    private h mgu;
    private com.baidu.tieba.video.editvideo.b.a mvA;
    private com.baidu.tieba.video.editvideo.view.b mvB;
    private com.baidu.tieba.video.b mvC;
    private HttpMessageListener mvD;
    private CustomMessageListener mvE;
    private int mvs;
    private FrsTabInfoData mvt;
    private String mvu;
    private List<VideoTitleData> mvv;
    private com.baidu.tieba.video.editvideo.view.a mvw;
    private SelectCoverModel mvx;
    private SelectMusicModel mvy;
    private boolean mvz;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mgu = lVar.cRu();
        }
        this.mvD = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.mvv = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.mvE = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
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
            this.mvC.originPath = this.mVideoPath;
        }
        this.mvw.setData(this.mVideoPath);
        dBy();
        this.bex = getIntent().getStringExtra("from_type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_edit_video);
        this.eVx = getIntent().getStringExtra("forum_id");
        this.kOs = getIntent().getIntExtra("key_write_level", -1);
        this.mvs = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.mvu = getIntent().getStringExtra("video_title");
        this.iwx = getIntent().getStringExtra("KEY_CALL_FROM");
        this.bex = getIntent().getStringExtra("from_type");
        this.mFrom = getIntent().getStringExtra("from");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.mvt = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.mtT).mkdirs();
        this.mvx = new SelectCoverModel(getPageContext(), this, this.mgu);
        this.mvy = new SelectMusicModel(getPageContext(), this);
        this.mvA = new com.baidu.tieba.video.editvideo.b.a(this);
        this.mvw = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.mgu);
        this.mvw.setData(this.mVideoPath);
        this.mvw.ap(getIntent());
        this.mvw.a(this.mvA);
        this.mvw.setGenMaskCoverListener(this);
        this.mvx.dBY();
        this.mvy.dBZ();
        this.iwR = new com.baidu.tbadk.core.view.a(getPageContext());
        this.iwR.setTipString(R.string.mixing);
        registerListener(this.mvE);
        dBB();
        registerListener(this.mvD);
        dBA();
        TiebaStatic.log("c12303");
        this.mvC = new com.baidu.tieba.video.b(this, this.mVideoPath, this.mCoverPath) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
            @Override // com.baidu.tieba.video.b
            public void onCancel() {
                super.onCancel();
                EditVideoActivity.this.csz();
            }

            @Override // com.baidu.tieba.video.b
            public void dAW() {
                EditVideoActivity.this.mvw.dCm();
                EditVideoActivity.this.mvw.dCn();
                EditVideoActivity.this.mvw.dCj().releaseSource();
            }

            @Override // com.baidu.tieba.video.b
            public void bC(int i, String str) {
                super.bC(i, str);
                EditVideoActivity.this.csz();
            }

            @Override // com.baidu.tieba.video.b
            public void dAX() {
            }

            @Override // com.baidu.tieba.video.b
            public void bD(int i, String str) {
                super.bD(i, str);
                EditVideoActivity.this.csz();
            }

            @Override // com.baidu.tieba.video.b
            public void a(final VideoInfo videoInfo) {
                super.a(videoInfo);
                if (EditVideoActivity.this.mvz) {
                    if (EditVideoActivity.this.iwx == null || !EditVideoActivity.this.iwx.equals("1") || TextUtils.isEmpty(videoInfo.getVideoPath())) {
                        return;
                    }
                    n.a(new String[]{videoInfo.getThumbPath(), videoInfo.getVideoPath()}, new n.b() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2.1
                        @Override // com.baidu.tbadk.core.util.n.b
                        public void B(HashMap<String, String> hashMap) {
                            EditVideoActivity.this.mVideoInfo.setVideoPath(videoInfo.getVideoPath());
                            EditVideoActivity.this.mVideoInfo.setThumbPath(videoInfo.getThumbPath());
                            if (hashMap != null) {
                                EditVideoActivity.this.mVideoInfo.setThumbUriStr(hashMap.get(videoInfo.getThumbPath()));
                                EditVideoActivity.this.mVideoInfo.setVideoUriStr(hashMap.get(videoInfo.getVideoPath()));
                            }
                            if (EditVideoActivity.this.mvw.dCq() && !TextUtils.isEmpty(EditVideoActivity.this.mvw.dCp())) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(EditVideoActivity.this.mvw.dCp());
                                EditVideoActivity.this.mVideoInfo.setMusicListInfo(arrayList);
                            }
                            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(EditVideoActivity.this.getPageContext().getPageActivity(), EditVideoActivity.this.iwx, EditVideoActivity.this.eVx, EditVideoActivity.this.mForumName, EditVideoActivity.this.mvu, RequestResponseCode.REQUEST_WRITE_NEW, EditVideoActivity.this.mVideoInfo, EditVideoActivity.this.mVideoTitleData, EditVideoActivity.this.mvv);
                            if (!StringUtils.isNull(EditVideoActivity.this.bex)) {
                                writeVideoActivityConfig.addFromType(EditVideoActivity.this.bex);
                            }
                            writeVideoActivityConfig.setProZone(EditVideoActivity.this.mvs);
                            writeVideoActivityConfig.setFrom(EditVideoActivity.this.mFrom);
                            writeVideoActivityConfig.setFrsTabInfo(EditVideoActivity.this.mvt);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
                        }
                    });
                    return;
                }
                File file = new File(videoInfo.getVideoPath());
                String str = c.mtT + file.getName();
                if (!str.equals(file.getAbsolutePath())) {
                    n.copyFile(file.getAbsolutePath(), str);
                }
                EditVideoActivity.this.RE(str);
                EditVideoActivity.this.finishPage();
            }
        };
        this.mvB = new com.baidu.tieba.video.editvideo.view.b(this.mvC);
        dBy();
    }

    private void dBy() {
        if (this.mVideoInfo != null && this.mVideoInfo.getEditVideoData() != null && this.mvw != null) {
            com.baidu.tieba.video.editvideo.data.a RO = this.mvw.RO(this.mVideoInfo.getEditVideoData().filterName);
            if (RO != null) {
                if (this.mvA != null) {
                    this.mvA.b(RO);
                }
                this.mvw.c(RO);
            }
            this.mvw.ga(this.mVideoInfo.getEditVideoData().musicPath, this.mVideoInfo.getEditVideoData().musicId);
            this.mvw.wF(!this.mVideoInfo.getEditVideoData().isMute);
        }
    }

    public String beq() {
        return this.bex;
    }

    private void dBz() {
        if (this.mvB != null) {
            this.mvB.cancel();
        }
        this.LJ = true;
        this.mCoverPath = null;
        csz();
    }

    public void dBA() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.eVx)) {
            httpMessage.addParam("forum_id", this.eVx);
        }
        sendMessage(httpMessage);
    }

    private void dBB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mvw.getRootView());
        if (this.mvw != null) {
            this.mvw.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.mvw != null) {
            this.mvw.onPause();
            this.mvw.dCm();
            this.mvw.dCn();
            this.mvw.dCj().releaseSource();
        }
        if (this.mvA.dBG()) {
            this.mvA.dBH();
        }
        this.mvz = false;
        this.LJ = true;
        if (this.mvB != null) {
            this.mvB.cancel();
        }
        dBz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mvw != null) {
            this.mvw.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.dBT().dBU();
        com.baidu.tieba.video.editvideo.model.b.dBW().dBX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mvw != null) {
            this.mvw.release();
        }
        if (this.mvx != null) {
            this.mvx.cancelLoadData();
        }
        if (this.mvy != null) {
            this.mvy.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mvw != null) {
            this.mvw.Nv();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        csz();
        this.mvz = false;
        if (this.mvB != null) {
            this.mvB.cancel();
        }
        if (this.mvw != null && this.mvw.dCj() != null) {
            this.mvw.dCj().pause();
            this.mvw.dCj().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.mvw == null || this.mvx == null || this.mvy == null) {
            csz();
            this.mvz = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.mvz) {
            this.mvz = true;
            this.LJ = false;
            if (this.mvB != null) {
                this.mvB.cancel();
            }
            this.mCoverPath = null;
            this.mvw.onPause();
            this.iwR.setDialogVisiable(true);
            dBC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csz() {
        if (this.iwR != null) {
            this.iwR.setDialogVisiable(false);
        }
    }

    private void dBC() {
        if (this.LJ) {
            this.LJ = false;
            return;
        }
        String text = this.mvw.getText();
        if (TextUtils.isEmpty(text)) {
            this.mvx.bJ(this.mVideoPath, this.mvw.getCurrentPosition());
        } else {
            this.mvx.Oi(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bpP() {
        this.LJ = false;
        this.mvz = false;
        this.mvC.wA(false);
        this.mvC.coverPath = this.mCoverPath;
        this.mvC.originPath = this.mVideoPath;
        this.mvC.musicPath = this.mvw.dCo();
        this.mvC.isMute = this.mvw.isMute();
        this.mvC.filterName = this.mvA.dBF();
        this.mvB.dCt();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dfL() {
        if (this.mvw == null || this.mvx == null) {
            csz();
            this.mvz = false;
        } else if (this.LJ) {
            this.LJ = false;
        } else {
            this.mvx.bJ(this.mVideoPath, this.mvw.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Og(String str) {
        if (this.LJ) {
            this.LJ = false;
        } else if (this.mvz) {
            showToast(str);
            csz();
            this.mvz = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void N(Bitmap bitmap) {
        this.mvw.dCj().R(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void RD(String str) {
        String str2;
        String str3;
        AntiData antiData;
        PostPrefixData postPrefixData;
        PostPrefixData postPrefixData2;
        if (this.LJ) {
            this.LJ = false;
            return;
        }
        this.mCoverPath = str;
        RF(this.mCoverPath);
        if (this.iwx != null && this.iwx.equals("1")) {
            if (this.mvB != null) {
                this.mvC.wA(false);
                this.mvC.coverPath = this.mCoverPath;
                this.mvC.originPath = this.mVideoPath;
                this.mvC.musicPath = this.mvw.dCo();
                this.mvC.isMute = this.mvw.isMute();
                this.mvC.filterName = this.mvA.dBF();
                this.mvB.dCt();
                return;
            }
            return;
        }
        csz();
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
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 9, this.eVx, this.mForumName, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.iwx);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.mvs);
        writeActivityConfig.setFrsTabInfo(this.mvt);
        writeActivityConfig.setVideoInfo(this.mVideoInfo);
        writeActivityConfig.setForumLevel(this.kOs);
        EditVideoData editVideoData = new EditVideoData();
        editVideoData.coverPath = this.mCoverPath;
        editVideoData.originPath = this.mVideoPath;
        editVideoData.musicPath = this.mvw.dCo();
        editVideoData.musicId = this.mvw.dCp();
        editVideoData.isMute = this.mvw.isMute();
        editVideoData.filterName = this.mvA.dBF();
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
        this.mvw.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void s(String str, int i, String str2) {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dBD() {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void fo(List<PendantData> list) {
        this.mvw.fo(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25032) {
                String stringExtra = intent.getStringExtra("music_resource");
                String stringExtra2 = intent.getStringExtra("music_id");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    String RI = com.baidu.tieba.video.editvideo.model.a.dBT().RI(stringExtra);
                    if (this.mvw != null && !TextUtils.isEmpty(RI)) {
                        this.mvw.gb(RI, stringExtra2);
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
    public void RE(String str) {
        try {
            new z(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.bd(this, str);
        } catch (Exception e) {
            csz();
            this.mvz = false;
        }
    }

    private void RF(String str) {
        try {
            new z(this).saveImage(str);
            com.baidu.tieba.video.editvideo.b.c.bd(this, str);
        } catch (Exception e) {
            csz();
            this.mvz = false;
        }
    }

    private void O(Bitmap bitmap) {
        if (this.mvw == null || this.mvx == null) {
            csz();
            this.mvz = false;
        } else if (this.LJ) {
            this.LJ = false;
        } else {
            if (!TextUtils.isEmpty(this.mvw.getText())) {
                bitmap = this.mvw.G(bitmap);
            }
            if (bitmap != null) {
                this.mvx.b(bitmap, c.mtR);
            }
        }
    }
}
