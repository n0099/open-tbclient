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
/* loaded from: classes23.dex */
public class EditVideoActivity extends BaseActivity implements a, b, MaskVideoView.b {
    private boolean Mn;
    private String blg;
    private String fkA;
    private String iSJ;
    private com.baidu.tbadk.core.view.a iTd;
    private int lmg;
    private String mCoverPath;
    private h mFB;
    private String mForumName;
    private String mFrom;
    private int mUR;
    private FrsTabInfoData mUS;
    private String mUT;
    private List<VideoTitleData> mUU;
    private com.baidu.tieba.video.editvideo.view.a mUV;
    private SelectCoverModel mUW;
    private SelectMusicModel mUX;
    private boolean mUY;
    private com.baidu.tieba.video.editvideo.b.a mUZ;
    private com.baidu.tieba.video.editvideo.view.b mVa;
    private com.baidu.tieba.video.b mVb;
    private HttpMessageListener mVc;
    private CustomMessageListener mVd;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mFB = lVar.cYJ();
        }
        this.mVc = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.mUU = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.mVd = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
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
            this.mVb.originPath = this.mVideoPath;
        }
        this.mUV.setData(this.mVideoPath);
        dJe();
        this.blg = getIntent().getStringExtra("from_type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_edit_video);
        this.fkA = getIntent().getStringExtra("forum_id");
        this.lmg = getIntent().getIntExtra("key_write_level", -1);
        this.mUR = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.mUT = getIntent().getStringExtra("video_title");
        this.iSJ = getIntent().getStringExtra("KEY_CALL_FROM");
        this.blg = getIntent().getStringExtra("from_type");
        this.mFrom = getIntent().getStringExtra("from");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.mUS = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.mTr).mkdirs();
        this.mUW = new SelectCoverModel(getPageContext(), this, this.mFB);
        this.mUX = new SelectMusicModel(getPageContext(), this);
        this.mUZ = new com.baidu.tieba.video.editvideo.b.a(this);
        this.mUV = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.mFB);
        this.mUV.setData(this.mVideoPath);
        this.mUV.am(getIntent());
        this.mUV.a(this.mUZ);
        this.mUV.setGenMaskCoverListener(this);
        this.mUW.dJE();
        this.mUX.dJF();
        this.iTd = new com.baidu.tbadk.core.view.a(getPageContext());
        this.iTd.setTipString(R.string.mixing);
        registerListener(this.mVd);
        dJh();
        registerListener(this.mVc);
        dJg();
        TiebaStatic.log("c12303");
        this.mVb = new com.baidu.tieba.video.b(this, this.mVideoPath, this.mCoverPath) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
            @Override // com.baidu.tieba.video.b
            public void onCancel() {
                super.onCancel();
                EditVideoActivity.this.czl();
            }

            @Override // com.baidu.tieba.video.b
            public void dIC() {
                EditVideoActivity.this.mUV.dJS();
                EditVideoActivity.this.mUV.dJT();
                EditVideoActivity.this.mUV.dJP().releaseSource();
            }

            @Override // com.baidu.tieba.video.b
            public void bQ(int i, String str) {
                super.bQ(i, str);
                EditVideoActivity.this.czl();
            }

            @Override // com.baidu.tieba.video.b
            public void dID() {
            }

            @Override // com.baidu.tieba.video.b
            public void bR(int i, String str) {
                super.bR(i, str);
                EditVideoActivity.this.czl();
            }

            @Override // com.baidu.tieba.video.b
            public void a(final VideoInfo videoInfo) {
                super.a(videoInfo);
                if (EditVideoActivity.this.mUY) {
                    if (EditVideoActivity.this.iSJ == null || !EditVideoActivity.this.iSJ.equals("1") || TextUtils.isEmpty(videoInfo.getVideoPath())) {
                        return;
                    }
                    n.a(new String[]{videoInfo.getThumbPath(), videoInfo.getVideoPath()}, new n.b() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2.1
                        @Override // com.baidu.tbadk.core.util.n.b
                        public void D(HashMap<String, String> hashMap) {
                            EditVideoActivity.this.mVideoInfo.setVideoPath(videoInfo.getVideoPath());
                            EditVideoActivity.this.mVideoInfo.setThumbPath(videoInfo.getThumbPath());
                            if (hashMap != null) {
                                EditVideoActivity.this.mVideoInfo.setThumbUriStr(hashMap.get(videoInfo.getThumbPath()));
                                EditVideoActivity.this.mVideoInfo.setVideoUriStr(hashMap.get(videoInfo.getVideoPath()));
                            }
                            if (EditVideoActivity.this.mUV.dJW() && !TextUtils.isEmpty(EditVideoActivity.this.mUV.dJV())) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(EditVideoActivity.this.mUV.dJV());
                                EditVideoActivity.this.mVideoInfo.setMusicListInfo(arrayList);
                            }
                            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(EditVideoActivity.this.getPageContext().getPageActivity(), EditVideoActivity.this.iSJ, EditVideoActivity.this.fkA, EditVideoActivity.this.mForumName, EditVideoActivity.this.mUT, RequestResponseCode.REQUEST_WRITE_NEW, EditVideoActivity.this.mVideoInfo, EditVideoActivity.this.mVideoTitleData, EditVideoActivity.this.mUU);
                            if (!StringUtils.isNull(EditVideoActivity.this.blg)) {
                                writeVideoActivityConfig.addFromType(EditVideoActivity.this.blg);
                            }
                            writeVideoActivityConfig.setProZone(EditVideoActivity.this.mUR);
                            writeVideoActivityConfig.setFrom(EditVideoActivity.this.mFrom);
                            writeVideoActivityConfig.setFrsTabInfo(EditVideoActivity.this.mUS);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
                        }
                    });
                    return;
                }
                File file = new File(videoInfo.getVideoPath());
                String str = c.mTr + file.getName();
                if (!str.equals(file.getAbsolutePath())) {
                    n.copyFile(file.getAbsolutePath(), str);
                }
                EditVideoActivity.this.SS(str);
                EditVideoActivity.this.finishPage();
            }
        };
        this.mVa = new com.baidu.tieba.video.editvideo.view.b(this.mVb);
        dJe();
    }

    private void dJe() {
        if (this.mVideoInfo != null && this.mVideoInfo.getEditVideoData() != null && this.mUV != null) {
            com.baidu.tieba.video.editvideo.data.a Tc = this.mUV.Tc(this.mVideoInfo.getEditVideoData().filterName);
            if (Tc != null) {
                if (this.mUZ != null) {
                    this.mUZ.b(Tc);
                }
                this.mUV.c(Tc);
            }
            this.mUV.gt(this.mVideoInfo.getEditVideoData().musicPath, this.mVideoInfo.getEditVideoData().musicId);
            this.mUV.xv(!this.mVideoInfo.getEditVideoData().isMute);
        }
    }

    public String bhT() {
        return this.blg;
    }

    private void dJf() {
        if (this.mVa != null) {
            this.mVa.cancel();
        }
        this.Mn = true;
        this.mCoverPath = null;
        czl();
    }

    public void dJg() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.fkA)) {
            httpMessage.addParam("forum_id", this.fkA);
        }
        sendMessage(httpMessage);
    }

    private void dJh() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mUV.getRootView());
        if (this.mUV != null) {
            this.mUV.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.mUV != null) {
            this.mUV.onPause();
            this.mUV.dJS();
            this.mUV.dJT();
            this.mUV.dJP().releaseSource();
        }
        if (this.mUZ.dJm()) {
            this.mUZ.dJn();
        }
        this.mUY = false;
        this.Mn = true;
        if (this.mVa != null) {
            this.mVa.cancel();
        }
        dJf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mUV != null) {
            this.mUV.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.dJz().dJA();
        com.baidu.tieba.video.editvideo.model.b.dJC().dJD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mUV != null) {
            this.mUV.release();
        }
        if (this.mUW != null) {
            this.mUW.cancelLoadData();
        }
        if (this.mUX != null) {
            this.mUX.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mUV != null) {
            this.mUV.Pd();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        czl();
        this.mUY = false;
        if (this.mVa != null) {
            this.mVa.cancel();
        }
        if (this.mUV != null && this.mUV.dJP() != null) {
            this.mUV.dJP().pause();
            this.mUV.dJP().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.mUV == null || this.mUW == null || this.mUX == null) {
            czl();
            this.mUY = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.mUY) {
            this.mUY = true;
            this.Mn = false;
            if (this.mVa != null) {
                this.mVa.cancel();
            }
            this.mCoverPath = null;
            this.mUV.onPause();
            this.iTd.setDialogVisiable(true);
            dJi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czl() {
        if (this.iTd != null) {
            this.iTd.setDialogVisiable(false);
        }
    }

    private void dJi() {
        if (this.Mn) {
            this.Mn = false;
            return;
        }
        String text = this.mUV.getText();
        if (TextUtils.isEmpty(text)) {
            this.mUW.bK(this.mVideoPath, this.mUV.getCurrentPosition());
        } else {
            this.mUW.Py(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void btt() {
        this.Mn = false;
        this.mUY = false;
        this.mVb.xq(false);
        this.mVb.coverPath = this.mCoverPath;
        this.mVb.originPath = this.mVideoPath;
        this.mVb.musicPath = this.mUV.dJU();
        this.mVb.isMute = this.mUV.isMute();
        this.mVb.filterName = this.mUZ.dJl();
        this.mVa.dJZ();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dmX() {
        if (this.mUV == null || this.mUW == null) {
            czl();
            this.mUY = false;
        } else if (this.Mn) {
            this.Mn = false;
        } else {
            this.mUW.bK(this.mVideoPath, this.mUV.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Pw(String str) {
        if (this.Mn) {
            this.Mn = false;
        } else if (this.mUY) {
            showToast(str);
            czl();
            this.mUY = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void M(Bitmap bitmap) {
        this.mUV.dJP().Q(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void SR(String str) {
        String str2;
        String str3;
        AntiData antiData;
        PostPrefixData postPrefixData;
        PostPrefixData postPrefixData2;
        if (this.Mn) {
            this.Mn = false;
            return;
        }
        this.mCoverPath = str;
        ST(this.mCoverPath);
        if (this.iSJ != null && this.iSJ.equals("1")) {
            if (this.mVa != null) {
                this.mVb.xq(false);
                this.mVb.coverPath = this.mCoverPath;
                this.mVb.originPath = this.mVideoPath;
                this.mVb.musicPath = this.mUV.dJU();
                this.mVb.isMute = this.mUV.isMute();
                this.mVb.filterName = this.mUZ.dJl();
                this.mVa.dJZ();
                return;
            }
            return;
        }
        czl();
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
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 9, this.fkA, this.mForumName, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.iSJ);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.mUR);
        writeActivityConfig.setFrsTabInfo(this.mUS);
        writeActivityConfig.setVideoInfo(this.mVideoInfo);
        writeActivityConfig.setForumLevel(this.lmg);
        EditVideoData editVideoData = new EditVideoData();
        editVideoData.coverPath = this.mCoverPath;
        editVideoData.originPath = this.mVideoPath;
        editVideoData.musicPath = this.mUV.dJU();
        editVideoData.musicId = this.mUV.dJV();
        editVideoData.isMute = this.mUV.isMute();
        editVideoData.filterName = this.mUZ.dJl();
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
        this.mUV.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dJj() {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void fA(List<PendantData> list) {
        this.mUV.fA(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25032) {
                String stringExtra = intent.getStringExtra("music_resource");
                String stringExtra2 = intent.getStringExtra("music_id");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    String SW = com.baidu.tieba.video.editvideo.model.a.dJz().SW(stringExtra);
                    if (this.mUV != null && !TextUtils.isEmpty(SW)) {
                        this.mUV.gu(SW, stringExtra2);
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
    public void SS(String str) {
        try {
            new z(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.bm(this, str);
        } catch (Exception e) {
            czl();
            this.mUY = false;
        }
    }

    private void ST(String str) {
        try {
            new z(this).saveImage(str);
            com.baidu.tieba.video.editvideo.b.c.bm(this, str);
        } catch (Exception e) {
            czl();
            this.mUY = false;
        }
    }

    private void N(Bitmap bitmap) {
        if (this.mUV == null || this.mUW == null) {
            czl();
            this.mUY = false;
        } else if (this.Mn) {
            this.Mn = false;
        } else {
            if (!TextUtils.isEmpty(this.mUV.getText())) {
                bitmap = this.mUV.F(bitmap);
            }
            if (bitmap != null) {
                this.mUW.b(bitmap, c.mTp);
            }
        }
    }
}
