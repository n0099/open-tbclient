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
    private String bev;
    private String eVt;
    private com.baidu.tbadk.core.view.a iwL;
    private String iwr;
    private int kOl;
    private String mCoverPath;
    private String mForumName;
    private String mFrom;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;
    private h mgf;
    private int mva;
    private FrsTabInfoData mvb;
    private String mvc;
    private List<VideoTitleData> mvd;
    private com.baidu.tieba.video.editvideo.view.a mve;
    private SelectCoverModel mvf;
    private SelectMusicModel mvg;
    private boolean mvh;
    private com.baidu.tieba.video.editvideo.b.a mvi;
    private com.baidu.tieba.video.editvideo.view.b mvj;
    private com.baidu.tieba.video.b mvk;
    private HttpMessageListener mvl;
    private CustomMessageListener mvm;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mgf = lVar.cRt();
        }
        this.mvl = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.mvd = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.mvm = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
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
            this.mvk.originPath = this.mVideoPath;
        }
        this.mve.setData(this.mVideoPath);
        dBp();
        this.bev = getIntent().getStringExtra("from_type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_edit_video);
        this.eVt = getIntent().getStringExtra("forum_id");
        this.kOl = getIntent().getIntExtra("key_write_level", -1);
        this.mva = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.mvc = getIntent().getStringExtra("video_title");
        this.iwr = getIntent().getStringExtra("KEY_CALL_FROM");
        this.bev = getIntent().getStringExtra("from_type");
        this.mFrom = getIntent().getStringExtra("from");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.mvb = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.mtB).mkdirs();
        this.mvf = new SelectCoverModel(getPageContext(), this, this.mgf);
        this.mvg = new SelectMusicModel(getPageContext(), this);
        this.mvi = new com.baidu.tieba.video.editvideo.b.a(this);
        this.mve = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.mgf);
        this.mve.setData(this.mVideoPath);
        this.mve.ap(getIntent());
        this.mve.a(this.mvi);
        this.mve.setGenMaskCoverListener(this);
        this.mvf.dBP();
        this.mvg.dBQ();
        this.iwL = new com.baidu.tbadk.core.view.a(getPageContext());
        this.iwL.setTipString(R.string.mixing);
        registerListener(this.mvm);
        dBs();
        registerListener(this.mvl);
        dBr();
        TiebaStatic.log("c12303");
        this.mvk = new com.baidu.tieba.video.b(this, this.mVideoPath, this.mCoverPath) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
            @Override // com.baidu.tieba.video.b
            public void onCancel() {
                super.onCancel();
                EditVideoActivity.this.csy();
            }

            @Override // com.baidu.tieba.video.b
            public void dAN() {
                EditVideoActivity.this.mve.dCd();
                EditVideoActivity.this.mve.dCe();
                EditVideoActivity.this.mve.dCa().releaseSource();
            }

            @Override // com.baidu.tieba.video.b
            public void bD(int i, String str) {
                super.bD(i, str);
                EditVideoActivity.this.csy();
            }

            @Override // com.baidu.tieba.video.b
            public void dAO() {
            }

            @Override // com.baidu.tieba.video.b
            public void bE(int i, String str) {
                super.bE(i, str);
                EditVideoActivity.this.csy();
            }

            @Override // com.baidu.tieba.video.b
            public void a(final VideoInfo videoInfo) {
                super.a(videoInfo);
                if (EditVideoActivity.this.mvh) {
                    if (EditVideoActivity.this.iwr == null || !EditVideoActivity.this.iwr.equals("1") || TextUtils.isEmpty(videoInfo.getVideoPath())) {
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
                            if (EditVideoActivity.this.mve.dCh() && !TextUtils.isEmpty(EditVideoActivity.this.mve.dCg())) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(EditVideoActivity.this.mve.dCg());
                                EditVideoActivity.this.mVideoInfo.setMusicListInfo(arrayList);
                            }
                            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(EditVideoActivity.this.getPageContext().getPageActivity(), EditVideoActivity.this.iwr, EditVideoActivity.this.eVt, EditVideoActivity.this.mForumName, EditVideoActivity.this.mvc, RequestResponseCode.REQUEST_WRITE_NEW, EditVideoActivity.this.mVideoInfo, EditVideoActivity.this.mVideoTitleData, EditVideoActivity.this.mvd);
                            if (!StringUtils.isNull(EditVideoActivity.this.bev)) {
                                writeVideoActivityConfig.addFromType(EditVideoActivity.this.bev);
                            }
                            writeVideoActivityConfig.setProZone(EditVideoActivity.this.mva);
                            writeVideoActivityConfig.setFrom(EditVideoActivity.this.mFrom);
                            writeVideoActivityConfig.setFrsTabInfo(EditVideoActivity.this.mvb);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
                        }
                    });
                    return;
                }
                File file = new File(videoInfo.getVideoPath());
                String str = c.mtB + file.getName();
                if (!str.equals(file.getAbsolutePath())) {
                    n.copyFile(file.getAbsolutePath(), str);
                }
                EditVideoActivity.this.RE(str);
                EditVideoActivity.this.finishPage();
            }
        };
        this.mvj = new com.baidu.tieba.video.editvideo.view.b(this.mvk);
        dBp();
    }

    private void dBp() {
        if (this.mVideoInfo != null && this.mVideoInfo.getEditVideoData() != null && this.mve != null) {
            com.baidu.tieba.video.editvideo.data.a RO = this.mve.RO(this.mVideoInfo.getEditVideoData().filterName);
            if (RO != null) {
                if (this.mvi != null) {
                    this.mvi.b(RO);
                }
                this.mve.c(RO);
            }
            this.mve.fZ(this.mVideoInfo.getEditVideoData().musicPath, this.mVideoInfo.getEditVideoData().musicId);
            this.mve.wD(!this.mVideoInfo.getEditVideoData().isMute);
        }
    }

    public String beq() {
        return this.bev;
    }

    private void dBq() {
        if (this.mvj != null) {
            this.mvj.cancel();
        }
        this.LJ = true;
        this.mCoverPath = null;
        csy();
    }

    public void dBr() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.eVt)) {
            httpMessage.addParam("forum_id", this.eVt);
        }
        sendMessage(httpMessage);
    }

    private void dBs() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mve.getRootView());
        if (this.mve != null) {
            this.mve.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.mve != null) {
            this.mve.onPause();
            this.mve.dCd();
            this.mve.dCe();
            this.mve.dCa().releaseSource();
        }
        if (this.mvi.dBx()) {
            this.mvi.dBy();
        }
        this.mvh = false;
        this.LJ = true;
        if (this.mvj != null) {
            this.mvj.cancel();
        }
        dBq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mve != null) {
            this.mve.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.dBK().dBL();
        com.baidu.tieba.video.editvideo.model.b.dBN().dBO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mve != null) {
            this.mve.release();
        }
        if (this.mvf != null) {
            this.mvf.cancelLoadData();
        }
        if (this.mvg != null) {
            this.mvg.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mve != null) {
            this.mve.Nv();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        csy();
        this.mvh = false;
        if (this.mvj != null) {
            this.mvj.cancel();
        }
        if (this.mve != null && this.mve.dCa() != null) {
            this.mve.dCa().pause();
            this.mve.dCa().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.mve == null || this.mvf == null || this.mvg == null) {
            csy();
            this.mvh = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.mvh) {
            this.mvh = true;
            this.LJ = false;
            if (this.mvj != null) {
                this.mvj.cancel();
            }
            this.mCoverPath = null;
            this.mve.onPause();
            this.iwL.setDialogVisiable(true);
            dBt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csy() {
        if (this.iwL != null) {
            this.iwL.setDialogVisiable(false);
        }
    }

    private void dBt() {
        if (this.LJ) {
            this.LJ = false;
            return;
        }
        String text = this.mve.getText();
        if (TextUtils.isEmpty(text)) {
            this.mvf.bJ(this.mVideoPath, this.mve.getCurrentPosition());
        } else {
            this.mvf.Oh(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bpO() {
        this.LJ = false;
        this.mvh = false;
        this.mvk.wy(false);
        this.mvk.coverPath = this.mCoverPath;
        this.mvk.originPath = this.mVideoPath;
        this.mvk.musicPath = this.mve.dCf();
        this.mvk.isMute = this.mve.isMute();
        this.mvk.filterName = this.mvi.dBw();
        this.mvj.dCk();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dfK() {
        if (this.mve == null || this.mvf == null) {
            csy();
            this.mvh = false;
        } else if (this.LJ) {
            this.LJ = false;
        } else {
            this.mvf.bJ(this.mVideoPath, this.mve.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Of(String str) {
        if (this.LJ) {
            this.LJ = false;
        } else if (this.mvh) {
            showToast(str);
            csy();
            this.mvh = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void N(Bitmap bitmap) {
        this.mve.dCa().R(bitmap);
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
        if (this.iwr != null && this.iwr.equals("1")) {
            if (this.mvj != null) {
                this.mvk.wy(false);
                this.mvk.coverPath = this.mCoverPath;
                this.mvk.originPath = this.mVideoPath;
                this.mvk.musicPath = this.mve.dCf();
                this.mvk.isMute = this.mve.isMute();
                this.mvk.filterName = this.mvi.dBw();
                this.mvj.dCk();
                return;
            }
            return;
        }
        csy();
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
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 9, this.eVt, this.mForumName, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.iwr);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.mva);
        writeActivityConfig.setFrsTabInfo(this.mvb);
        writeActivityConfig.setVideoInfo(this.mVideoInfo);
        writeActivityConfig.setForumLevel(this.kOl);
        EditVideoData editVideoData = new EditVideoData();
        editVideoData.coverPath = this.mCoverPath;
        editVideoData.originPath = this.mVideoPath;
        editVideoData.musicPath = this.mve.dCf();
        editVideoData.musicId = this.mve.dCg();
        editVideoData.isMute = this.mve.isMute();
        editVideoData.filterName = this.mvi.dBw();
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
        this.mve.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dBu() {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void fo(List<PendantData> list) {
        this.mve.fo(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25032) {
                String stringExtra = intent.getStringExtra("music_resource");
                String stringExtra2 = intent.getStringExtra("music_id");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    String RI = com.baidu.tieba.video.editvideo.model.a.dBK().RI(stringExtra);
                    if (this.mve != null && !TextUtils.isEmpty(RI)) {
                        this.mve.ga(RI, stringExtra2);
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
            csy();
            this.mvh = false;
        }
    }

    private void RF(String str) {
        try {
            new z(this).saveImage(str);
            com.baidu.tieba.video.editvideo.b.c.bd(this, str);
        } catch (Exception e) {
            csy();
            this.mvh = false;
        }
    }

    private void O(Bitmap bitmap) {
        if (this.mve == null || this.mvf == null) {
            csy();
            this.mvh = false;
        } else if (this.LJ) {
            this.LJ = false;
        } else {
            if (!TextUtils.isEmpty(this.mve.getText())) {
                bitmap = this.mve.G(bitmap);
            }
            if (bitmap != null) {
                this.mvf.b(bitmap, c.mtz);
            }
        }
    }
}
