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
/* loaded from: classes22.dex */
public class EditVideoActivity extends BaseActivity implements a, b, MaskVideoView.b {
    private boolean Mo;
    private String bml;
    private String fyg;
    private String jlN;
    private com.baidu.tbadk.core.view.a jmh;
    private int lEX;
    private String mCoverPath;
    private String mForumName;
    private String mFrom;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;
    private h mZc;
    private com.baidu.tieba.video.editvideo.view.a noA;
    private SelectCoverModel noB;
    private SelectMusicModel noC;
    private boolean noD;
    private com.baidu.tieba.video.editvideo.b.a noE;
    private com.baidu.tieba.video.editvideo.view.b noF;
    private com.baidu.tieba.video.b noG;
    private HttpMessageListener noH;
    private CustomMessageListener noI;
    private int nov;
    private FrsTabInfoData nox;
    private String noy;
    private List<VideoTitleData> noz;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mZc = lVar.ddQ();
        }
        this.noH = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.noz = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.noI = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
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
            this.noG.originPath = this.mVideoPath;
        }
        this.noA.setData(this.mVideoPath);
        dON();
        this.bml = getIntent().getStringExtra("from_type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_edit_video);
        this.fyg = getIntent().getStringExtra("forum_id");
        this.lEX = getIntent().getIntExtra("key_write_level", -1);
        this.nov = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.noy = getIntent().getStringExtra("video_title");
        this.jlN = getIntent().getStringExtra("KEY_CALL_FROM");
        this.bml = getIntent().getStringExtra("from_type");
        this.mFrom = getIntent().getStringExtra("from");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.nox = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.nmV).mkdirs();
        this.noB = new SelectCoverModel(getPageContext(), this, this.mZc);
        this.noC = new SelectMusicModel(getPageContext(), this);
        this.noE = new com.baidu.tieba.video.editvideo.b.a(this);
        this.noA = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.mZc);
        this.noA.setData(this.mVideoPath);
        this.noA.am(getIntent());
        this.noA.a(this.noE);
        this.noA.setGenMaskCoverListener(this);
        this.noB.dPn();
        this.noC.dPo();
        this.jmh = new com.baidu.tbadk.core.view.a(getPageContext());
        this.jmh.setTipString(R.string.mixing);
        registerListener(this.noI);
        dOQ();
        registerListener(this.noH);
        dOP();
        TiebaStatic.log("c12303");
        this.noG = new com.baidu.tieba.video.b(this, this.mVideoPath, this.mCoverPath) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
            @Override // com.baidu.tieba.video.b
            public void onCancel() {
                super.onCancel();
                EditVideoActivity.this.cEy();
            }

            @Override // com.baidu.tieba.video.b
            public void dOl() {
                EditVideoActivity.this.noA.dPB();
                EditVideoActivity.this.noA.dPC();
                EditVideoActivity.this.noA.dPy().releaseSource();
            }

            @Override // com.baidu.tieba.video.b
            public void bT(int i, String str) {
                super.bT(i, str);
                EditVideoActivity.this.cEy();
            }

            @Override // com.baidu.tieba.video.b
            public void dOm() {
            }

            @Override // com.baidu.tieba.video.b
            public void bU(int i, String str) {
                super.bU(i, str);
                EditVideoActivity.this.cEy();
            }

            @Override // com.baidu.tieba.video.b
            public void a(final VideoInfo videoInfo) {
                super.a(videoInfo);
                if (EditVideoActivity.this.noD) {
                    if (EditVideoActivity.this.jlN == null || !EditVideoActivity.this.jlN.equals("1") || TextUtils.isEmpty(videoInfo.getVideoPath())) {
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
                            if (EditVideoActivity.this.noA.dPF() && !TextUtils.isEmpty(EditVideoActivity.this.noA.dPE())) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(EditVideoActivity.this.noA.dPE());
                                EditVideoActivity.this.mVideoInfo.setMusicListInfo(arrayList);
                            }
                            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(EditVideoActivity.this.getPageContext().getPageActivity(), EditVideoActivity.this.jlN, EditVideoActivity.this.fyg, EditVideoActivity.this.mForumName, EditVideoActivity.this.noy, RequestResponseCode.REQUEST_WRITE_NEW, EditVideoActivity.this.mVideoInfo, EditVideoActivity.this.mVideoTitleData, EditVideoActivity.this.noz);
                            if (!StringUtils.isNull(EditVideoActivity.this.bml)) {
                                writeVideoActivityConfig.addFromType(EditVideoActivity.this.bml);
                            }
                            writeVideoActivityConfig.setProZone(EditVideoActivity.this.nov);
                            writeVideoActivityConfig.setFrom(EditVideoActivity.this.mFrom);
                            writeVideoActivityConfig.setFrsTabInfo(EditVideoActivity.this.nox);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
                        }
                    });
                    return;
                }
                File file = new File(videoInfo.getVideoPath());
                String str = c.nmV + file.getName();
                if (!str.equals(file.getAbsolutePath())) {
                    n.copyFile(file.getAbsolutePath(), str);
                }
                EditVideoActivity.this.Tt(str);
                EditVideoActivity.this.finishPage();
            }
        };
        this.noF = new com.baidu.tieba.video.editvideo.view.b(this.noG);
        dON();
    }

    private void dON() {
        if (this.mVideoInfo != null && this.mVideoInfo.getEditVideoData() != null && this.noA != null) {
            com.baidu.tieba.video.editvideo.data.a TD = this.noA.TD(this.mVideoInfo.getEditVideoData().filterName);
            if (TD != null) {
                if (this.noE != null) {
                    this.noE.b(TD);
                }
                this.noA.c(TD);
            }
            this.noA.gy(this.mVideoInfo.getEditVideoData().musicPath, this.mVideoInfo.getEditVideoData().musicId);
            this.noA.yc(!this.mVideoInfo.getEditVideoData().isMute);
        }
    }

    public String blo() {
        return this.bml;
    }

    private void dOO() {
        if (this.noF != null) {
            this.noF.cancel();
        }
        this.Mo = true;
        this.mCoverPath = null;
        cEy();
    }

    public void dOP() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.fyg)) {
            httpMessage.addParam("forum_id", this.fyg);
        }
        sendMessage(httpMessage);
    }

    private void dOQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.noA.getRootView());
        if (this.noA != null) {
            this.noA.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.noA != null) {
            this.noA.onPause();
            this.noA.dPB();
            this.noA.dPC();
            this.noA.dPy().releaseSource();
        }
        if (this.noE.dOV()) {
            this.noE.dOW();
        }
        this.noD = false;
        this.Mo = true;
        if (this.noF != null) {
            this.noF.cancel();
        }
        dOO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.noA != null) {
            this.noA.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.dPi().dPj();
        com.baidu.tieba.video.editvideo.model.b.dPl().dPm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.noA != null) {
            this.noA.release();
        }
        if (this.noB != null) {
            this.noB.cancelLoadData();
        }
        if (this.noC != null) {
            this.noC.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.noA != null) {
            this.noA.PA();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        cEy();
        this.noD = false;
        if (this.noF != null) {
            this.noF.cancel();
        }
        if (this.noA != null && this.noA.dPy() != null) {
            this.noA.dPy().pause();
            this.noA.dPy().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.noA == null || this.noB == null || this.noC == null) {
            cEy();
            this.noD = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.noD) {
            this.noD = true;
            this.Mo = false;
            if (this.noF != null) {
                this.noF.cancel();
            }
            this.mCoverPath = null;
            this.noA.onPause();
            this.jmh.setDialogVisiable(true);
            dOR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEy() {
        if (this.jmh != null) {
            this.jmh.setDialogVisiable(false);
        }
    }

    private void dOR() {
        if (this.Mo) {
            this.Mo = false;
            return;
        }
        String text = this.noA.getText();
        if (TextUtils.isEmpty(text)) {
            this.noB.bM(this.mVideoPath, this.noA.getCurrentPosition());
        } else {
            this.noB.PI(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bxb() {
        this.Mo = false;
        this.noD = false;
        this.noG.xX(false);
        this.noG.coverPath = this.mCoverPath;
        this.noG.originPath = this.mVideoPath;
        this.noG.musicPath = this.noA.dPD();
        this.noG.isMute = this.noA.isMute();
        this.noG.filterName = this.noE.dOU();
        this.noF.dPI();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dsh() {
        if (this.noA == null || this.noB == null) {
            cEy();
            this.noD = false;
        } else if (this.Mo) {
            this.Mo = false;
        } else {
            this.noB.bM(this.mVideoPath, this.noA.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void PG(String str) {
        if (this.Mo) {
            this.Mo = false;
        } else if (this.noD) {
            showToast(str);
            cEy();
            this.noD = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void M(Bitmap bitmap) {
        this.noA.dPy().Q(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Ts(String str) {
        String str2;
        String str3;
        AntiData antiData;
        PostPrefixData postPrefixData;
        PostPrefixData postPrefixData2;
        if (this.Mo) {
            this.Mo = false;
            return;
        }
        this.mCoverPath = str;
        Tu(this.mCoverPath);
        if (this.jlN != null && this.jlN.equals("1")) {
            if (this.noF != null) {
                this.noG.xX(false);
                this.noG.coverPath = this.mCoverPath;
                this.noG.originPath = this.mVideoPath;
                this.noG.musicPath = this.noA.dPD();
                this.noG.isMute = this.noA.isMute();
                this.noG.filterName = this.noE.dOU();
                this.noF.dPI();
                return;
            }
            return;
        }
        cEy();
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
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 9, this.fyg, this.mForumName, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.jlN);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.nov);
        writeActivityConfig.setFrsTabInfo(this.nox);
        writeActivityConfig.setVideoInfo(this.mVideoInfo);
        writeActivityConfig.setForumLevel(this.lEX);
        EditVideoData editVideoData = new EditVideoData();
        editVideoData.coverPath = this.mCoverPath;
        editVideoData.originPath = this.mVideoPath;
        editVideoData.musicPath = this.noA.dPD();
        editVideoData.musicId = this.noA.dPE();
        editVideoData.isMute = this.noA.isMute();
        editVideoData.filterName = this.noE.dOU();
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
        this.noA.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dOS() {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void fR(List<PendantData> list) {
        this.noA.fR(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25032) {
                String stringExtra = intent.getStringExtra("music_resource");
                String stringExtra2 = intent.getStringExtra("music_id");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    String Tx = com.baidu.tieba.video.editvideo.model.a.dPi().Tx(stringExtra);
                    if (this.noA != null && !TextUtils.isEmpty(Tx)) {
                        this.noA.gz(Tx, stringExtra2);
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
    public void Tt(String str) {
        try {
            new z(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.bl(this, str);
        } catch (Exception e) {
            cEy();
            this.noD = false;
        }
    }

    private void Tu(String str) {
        try {
            new z(this).saveImage(str);
            com.baidu.tieba.video.editvideo.b.c.bl(this, str);
        } catch (Exception e) {
            cEy();
            this.noD = false;
        }
    }

    private void N(Bitmap bitmap) {
        if (this.noA == null || this.noB == null) {
            cEy();
            this.noD = false;
        } else if (this.Mo) {
            this.Mo = false;
        } else {
            if (!TextUtils.isEmpty(this.noA.getText())) {
                bitmap = this.noA.F(bitmap);
            }
            if (bitmap != null) {
                this.noB.b(bitmap, c.nmT);
            }
        }
    }
}
