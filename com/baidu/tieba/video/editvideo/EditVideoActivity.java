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
/* loaded from: classes22.dex */
public class EditVideoActivity extends BaseActivity implements a, b, MaskVideoView.b {
    private boolean LX;
    private String bhq;
    private String eYo;
    private String iDT;
    private com.baidu.tbadk.core.view.a iEn;
    private int kWT;
    private String mCoverPath;
    private int mFe;
    private FrsTabInfoData mFf;
    private String mFg;
    private List<VideoTitleData> mFh;
    private com.baidu.tieba.video.editvideo.view.a mFi;
    private SelectCoverModel mFj;
    private SelectMusicModel mFk;
    private boolean mFl;
    private com.baidu.tieba.video.editvideo.b.a mFm;
    private com.baidu.tieba.video.editvideo.view.b mFn;
    private com.baidu.tieba.video.b mFo;
    private String mForumName;
    private HttpMessageListener mFp;
    private CustomMessageListener mFq;
    private String mFrom;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;
    private h mpU;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mpU = lVar.cVa();
        }
        this.mFp = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.mFh = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.mFq = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
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
            this.mFo.originPath = this.mVideoPath;
        }
        this.mFi.setData(this.mVideoPath);
        dFs();
        this.bhq = getIntent().getStringExtra("from_type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_edit_video);
        this.eYo = getIntent().getStringExtra("forum_id");
        this.kWT = getIntent().getIntExtra("key_write_level", -1);
        this.mFe = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.mFg = getIntent().getStringExtra("video_title");
        this.iDT = getIntent().getStringExtra("KEY_CALL_FROM");
        this.bhq = getIntent().getStringExtra("from_type");
        this.mFrom = getIntent().getStringExtra("from");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.mFf = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.mDE).mkdirs();
        this.mFj = new SelectCoverModel(getPageContext(), this, this.mpU);
        this.mFk = new SelectMusicModel(getPageContext(), this);
        this.mFm = new com.baidu.tieba.video.editvideo.b.a(this);
        this.mFi = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.mpU);
        this.mFi.setData(this.mVideoPath);
        this.mFi.ao(getIntent());
        this.mFi.a(this.mFm);
        this.mFi.setGenMaskCoverListener(this);
        this.mFj.dFS();
        this.mFk.dFT();
        this.iEn = new com.baidu.tbadk.core.view.a(getPageContext());
        this.iEn.setTipString(R.string.mixing);
        registerListener(this.mFq);
        dFv();
        registerListener(this.mFp);
        dFu();
        TiebaStatic.log("c12303");
        this.mFo = new com.baidu.tieba.video.b(this, this.mVideoPath, this.mCoverPath) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
            @Override // com.baidu.tieba.video.b
            public void onCancel() {
                super.onCancel();
                EditVideoActivity.this.cvO();
            }

            @Override // com.baidu.tieba.video.b
            public void dEQ() {
                EditVideoActivity.this.mFi.dGg();
                EditVideoActivity.this.mFi.dGh();
                EditVideoActivity.this.mFi.dGd().releaseSource();
            }

            @Override // com.baidu.tieba.video.b
            public void bG(int i, String str) {
                super.bG(i, str);
                EditVideoActivity.this.cvO();
            }

            @Override // com.baidu.tieba.video.b
            public void dER() {
            }

            @Override // com.baidu.tieba.video.b
            public void bH(int i, String str) {
                super.bH(i, str);
                EditVideoActivity.this.cvO();
            }

            @Override // com.baidu.tieba.video.b
            public void a(final VideoInfo videoInfo) {
                super.a(videoInfo);
                if (EditVideoActivity.this.mFl) {
                    if (EditVideoActivity.this.iDT == null || !EditVideoActivity.this.iDT.equals("1") || TextUtils.isEmpty(videoInfo.getVideoPath())) {
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
                            if (EditVideoActivity.this.mFi.dGk() && !TextUtils.isEmpty(EditVideoActivity.this.mFi.dGj())) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(EditVideoActivity.this.mFi.dGj());
                                EditVideoActivity.this.mVideoInfo.setMusicListInfo(arrayList);
                            }
                            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(EditVideoActivity.this.getPageContext().getPageActivity(), EditVideoActivity.this.iDT, EditVideoActivity.this.eYo, EditVideoActivity.this.mForumName, EditVideoActivity.this.mFg, RequestResponseCode.REQUEST_WRITE_NEW, EditVideoActivity.this.mVideoInfo, EditVideoActivity.this.mVideoTitleData, EditVideoActivity.this.mFh);
                            if (!StringUtils.isNull(EditVideoActivity.this.bhq)) {
                                writeVideoActivityConfig.addFromType(EditVideoActivity.this.bhq);
                            }
                            writeVideoActivityConfig.setProZone(EditVideoActivity.this.mFe);
                            writeVideoActivityConfig.setFrom(EditVideoActivity.this.mFrom);
                            writeVideoActivityConfig.setFrsTabInfo(EditVideoActivity.this.mFf);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
                        }
                    });
                    return;
                }
                File file = new File(videoInfo.getVideoPath());
                String str = c.mDE + file.getName();
                if (!str.equals(file.getAbsolutePath())) {
                    n.copyFile(file.getAbsolutePath(), str);
                }
                EditVideoActivity.this.Se(str);
                EditVideoActivity.this.finishPage();
            }
        };
        this.mFn = new com.baidu.tieba.video.editvideo.view.b(this.mFo);
        dFs();
    }

    private void dFs() {
        if (this.mVideoInfo != null && this.mVideoInfo.getEditVideoData() != null && this.mFi != null) {
            com.baidu.tieba.video.editvideo.data.a So = this.mFi.So(this.mVideoInfo.getEditVideoData().filterName);
            if (So != null) {
                if (this.mFm != null) {
                    this.mFm.b(So);
                }
                this.mFi.c(So);
            }
            this.mFi.gm(this.mVideoInfo.getEditVideoData().musicPath, this.mVideoInfo.getEditVideoData().musicId);
            this.mFi.wO(!this.mVideoInfo.getEditVideoData().isMute);
        }
    }

    public String bfk() {
        return this.bhq;
    }

    private void dFt() {
        if (this.mFn != null) {
            this.mFn.cancel();
        }
        this.LX = true;
        this.mCoverPath = null;
        cvO();
    }

    public void dFu() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.eYo)) {
            httpMessage.addParam("forum_id", this.eYo);
        }
        sendMessage(httpMessage);
    }

    private void dFv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mFi.getRootView());
        if (this.mFi != null) {
            this.mFi.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.mFi != null) {
            this.mFi.onPause();
            this.mFi.dGg();
            this.mFi.dGh();
            this.mFi.dGd().releaseSource();
        }
        if (this.mFm.dFA()) {
            this.mFm.dFB();
        }
        this.mFl = false;
        this.LX = true;
        if (this.mFn != null) {
            this.mFn.cancel();
        }
        dFt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mFi != null) {
            this.mFi.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.dFN().dFO();
        com.baidu.tieba.video.editvideo.model.b.dFQ().dFR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mFi != null) {
            this.mFi.release();
        }
        if (this.mFj != null) {
            this.mFj.cancelLoadData();
        }
        if (this.mFk != null) {
            this.mFk.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mFi != null) {
            this.mFi.NY();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        cvO();
        this.mFl = false;
        if (this.mFn != null) {
            this.mFn.cancel();
        }
        if (this.mFi != null && this.mFi.dGd() != null) {
            this.mFi.dGd().pause();
            this.mFi.dGd().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.mFi == null || this.mFj == null || this.mFk == null) {
            cvO();
            this.mFl = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.mFl) {
            this.mFl = true;
            this.LX = false;
            if (this.mFn != null) {
                this.mFn.cancel();
            }
            this.mCoverPath = null;
            this.mFi.onPause();
            this.iEn.setDialogVisiable(true);
            dFw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvO() {
        if (this.iEn != null) {
            this.iEn.setDialogVisiable(false);
        }
    }

    private void dFw() {
        if (this.LX) {
            this.LX = false;
            return;
        }
        String text = this.mFi.getText();
        if (TextUtils.isEmpty(text)) {
            this.mFj.bJ(this.mVideoPath, this.mFi.getCurrentPosition());
        } else {
            this.mFj.OJ(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bqJ() {
        this.LX = false;
        this.mFl = false;
        this.mFo.wJ(false);
        this.mFo.coverPath = this.mCoverPath;
        this.mFo.originPath = this.mVideoPath;
        this.mFo.musicPath = this.mFi.dGi();
        this.mFo.isMute = this.mFi.isMute();
        this.mFo.filterName = this.mFm.dFz();
        this.mFn.dGn();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void djo() {
        if (this.mFi == null || this.mFj == null) {
            cvO();
            this.mFl = false;
        } else if (this.LX) {
            this.LX = false;
        } else {
            this.mFj.bJ(this.mVideoPath, this.mFi.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void OH(String str) {
        if (this.LX) {
            this.LX = false;
        } else if (this.mFl) {
            showToast(str);
            cvO();
            this.mFl = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void M(Bitmap bitmap) {
        this.mFi.dGd().Q(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Sd(String str) {
        String str2;
        String str3;
        AntiData antiData;
        PostPrefixData postPrefixData;
        PostPrefixData postPrefixData2;
        if (this.LX) {
            this.LX = false;
            return;
        }
        this.mCoverPath = str;
        Sf(this.mCoverPath);
        if (this.iDT != null && this.iDT.equals("1")) {
            if (this.mFn != null) {
                this.mFo.wJ(false);
                this.mFo.coverPath = this.mCoverPath;
                this.mFo.originPath = this.mVideoPath;
                this.mFo.musicPath = this.mFi.dGi();
                this.mFo.isMute = this.mFi.isMute();
                this.mFo.filterName = this.mFm.dFz();
                this.mFn.dGn();
                return;
            }
            return;
        }
        cvO();
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
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 9, this.eYo, this.mForumName, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.iDT);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.mFe);
        writeActivityConfig.setFrsTabInfo(this.mFf);
        writeActivityConfig.setVideoInfo(this.mVideoInfo);
        writeActivityConfig.setForumLevel(this.kWT);
        EditVideoData editVideoData = new EditVideoData();
        editVideoData.coverPath = this.mCoverPath;
        editVideoData.originPath = this.mVideoPath;
        editVideoData.musicPath = this.mFi.dGi();
        editVideoData.musicId = this.mFi.dGj();
        editVideoData.isMute = this.mFi.isMute();
        editVideoData.filterName = this.mFm.dFz();
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
        this.mFi.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void s(String str, int i, String str2) {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dFx() {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void fx(List<PendantData> list) {
        this.mFi.fx(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25032) {
                String stringExtra = intent.getStringExtra("music_resource");
                String stringExtra2 = intent.getStringExtra("music_id");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    String Si = com.baidu.tieba.video.editvideo.model.a.dFN().Si(stringExtra);
                    if (this.mFi != null && !TextUtils.isEmpty(Si)) {
                        this.mFi.gn(Si, stringExtra2);
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
    public void Se(String str) {
        try {
            new z(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.bj(this, str);
        } catch (Exception e) {
            cvO();
            this.mFl = false;
        }
    }

    private void Sf(String str) {
        try {
            new z(this).saveImage(str);
            com.baidu.tieba.video.editvideo.b.c.bj(this, str);
        } catch (Exception e) {
            cvO();
            this.mFl = false;
        }
    }

    private void N(Bitmap bitmap) {
        if (this.mFi == null || this.mFj == null) {
            cvO();
            this.mFl = false;
        } else if (this.LX) {
            this.LX = false;
        } else {
            if (!TextUtils.isEmpty(this.mFi.getText())) {
                bitmap = this.mFi.F(bitmap);
            }
            if (bitmap != null) {
                this.mFj.b(bitmap, c.mDC);
            }
        }
    }
}
