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
    private boolean Mo;
    private String bnW;
    private String fyR;
    private String jld;
    private com.baidu.tbadk.core.view.a jlx;
    private int lEG;
    private String mCoverPath;
    private String mForumName;
    private String mFrom;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;
    private h mYk;
    private int nnn;
    private FrsTabInfoData nno;
    private String nnp;
    private List<VideoTitleData> nnq;
    private com.baidu.tieba.video.editvideo.view.a nnr;
    private SelectCoverModel nns;
    private SelectMusicModel nnt;
    private boolean nnu;
    private com.baidu.tieba.video.editvideo.b.a nnv;
    private com.baidu.tieba.video.editvideo.view.b nnw;
    private com.baidu.tieba.video.b nnx;
    private HttpMessageListener nny;
    private CustomMessageListener nnz;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mYk = lVar.det();
        }
        this.nny = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.nnq = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.nnz = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
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
            this.nnx.originPath = this.mVideoPath;
        }
        this.nnr.setData(this.mVideoPath);
        dOO();
        this.bnW = getIntent().getStringExtra("from_type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_edit_video);
        this.fyR = getIntent().getStringExtra("forum_id");
        this.lEG = getIntent().getIntExtra("key_write_level", -1);
        this.nnn = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.nnp = getIntent().getStringExtra("video_title");
        this.jld = getIntent().getStringExtra("KEY_CALL_FROM");
        this.bnW = getIntent().getStringExtra("from_type");
        this.mFrom = getIntent().getStringExtra("from");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.nno = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.nlO).mkdirs();
        this.nns = new SelectCoverModel(getPageContext(), this, this.mYk);
        this.nnt = new SelectMusicModel(getPageContext(), this);
        this.nnv = new com.baidu.tieba.video.editvideo.b.a(this);
        this.nnr = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.mYk);
        this.nnr.setData(this.mVideoPath);
        this.nnr.am(getIntent());
        this.nnr.a(this.nnv);
        this.nnr.setGenMaskCoverListener(this);
        this.nns.dPo();
        this.nnt.dPp();
        this.jlx = new com.baidu.tbadk.core.view.a(getPageContext());
        this.jlx.setTipString(R.string.mixing);
        registerListener(this.nnz);
        dOR();
        registerListener(this.nny);
        dOQ();
        TiebaStatic.log("c12303");
        this.nnx = new com.baidu.tieba.video.b(this, this.mVideoPath, this.mCoverPath) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
            @Override // com.baidu.tieba.video.b
            public void onCancel() {
                super.onCancel();
                EditVideoActivity.this.cET();
            }

            @Override // com.baidu.tieba.video.b
            public void dOm() {
                EditVideoActivity.this.nnr.dPC();
                EditVideoActivity.this.nnr.dPD();
                EditVideoActivity.this.nnr.dPz().releaseSource();
            }

            @Override // com.baidu.tieba.video.b
            public void bV(int i, String str) {
                super.bV(i, str);
                EditVideoActivity.this.cET();
            }

            @Override // com.baidu.tieba.video.b
            public void dOn() {
            }

            @Override // com.baidu.tieba.video.b
            public void bW(int i, String str) {
                super.bW(i, str);
                EditVideoActivity.this.cET();
            }

            @Override // com.baidu.tieba.video.b
            public void a(final VideoInfo videoInfo) {
                super.a(videoInfo);
                if (EditVideoActivity.this.nnu) {
                    if (EditVideoActivity.this.jld == null || !EditVideoActivity.this.jld.equals("1") || TextUtils.isEmpty(videoInfo.getVideoPath())) {
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
                            if (EditVideoActivity.this.nnr.dPG() && !TextUtils.isEmpty(EditVideoActivity.this.nnr.dPF())) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(EditVideoActivity.this.nnr.dPF());
                                EditVideoActivity.this.mVideoInfo.setMusicListInfo(arrayList);
                            }
                            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(EditVideoActivity.this.getPageContext().getPageActivity(), EditVideoActivity.this.jld, EditVideoActivity.this.fyR, EditVideoActivity.this.mForumName, EditVideoActivity.this.nnp, RequestResponseCode.REQUEST_WRITE_NEW, EditVideoActivity.this.mVideoInfo, EditVideoActivity.this.mVideoTitleData, EditVideoActivity.this.nnq);
                            if (!StringUtils.isNull(EditVideoActivity.this.bnW)) {
                                writeVideoActivityConfig.addFromType(EditVideoActivity.this.bnW);
                            }
                            writeVideoActivityConfig.setProZone(EditVideoActivity.this.nnn);
                            writeVideoActivityConfig.setFrom(EditVideoActivity.this.mFrom);
                            writeVideoActivityConfig.setFrsTabInfo(EditVideoActivity.this.nno);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
                        }
                    });
                    return;
                }
                File file = new File(videoInfo.getVideoPath());
                String str = c.nlO + file.getName();
                if (!str.equals(file.getAbsolutePath())) {
                    n.copyFile(file.getAbsolutePath(), str);
                }
                EditVideoActivity.this.TI(str);
                EditVideoActivity.this.finishPage();
            }
        };
        this.nnw = new com.baidu.tieba.video.editvideo.view.b(this.nnx);
        dOO();
    }

    private void dOO() {
        if (this.mVideoInfo != null && this.mVideoInfo.getEditVideoData() != null && this.nnr != null) {
            com.baidu.tieba.video.editvideo.data.a TS = this.nnr.TS(this.mVideoInfo.getEditVideoData().filterName);
            if (TS != null) {
                if (this.nnv != null) {
                    this.nnv.b(TS);
                }
                this.nnr.c(TS);
            }
            this.nnr.gy(this.mVideoInfo.getEditVideoData().musicPath, this.mVideoInfo.getEditVideoData().musicId);
            this.nnr.xV(!this.mVideoInfo.getEditVideoData().isMute);
        }
    }

    public String bmm() {
        return this.bnW;
    }

    private void dOP() {
        if (this.nnw != null) {
            this.nnw.cancel();
        }
        this.Mo = true;
        this.mCoverPath = null;
        cET();
    }

    public void dOQ() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.fyR)) {
            httpMessage.addParam("forum_id", this.fyR);
        }
        sendMessage(httpMessage);
    }

    private void dOR() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.nnr.getRootView());
        if (this.nnr != null) {
            this.nnr.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.nnr != null) {
            this.nnr.onPause();
            this.nnr.dPC();
            this.nnr.dPD();
            this.nnr.dPz().releaseSource();
        }
        if (this.nnv.dOW()) {
            this.nnv.dOX();
        }
        this.nnu = false;
        this.Mo = true;
        if (this.nnw != null) {
            this.nnw.cancel();
        }
        dOP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nnr != null) {
            this.nnr.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.dPj().dPk();
        com.baidu.tieba.video.editvideo.model.b.dPm().dPn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nnr != null) {
            this.nnr.release();
        }
        if (this.nns != null) {
            this.nns.cancelLoadData();
        }
        if (this.nnt != null) {
            this.nnt.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.nnr != null) {
            this.nnr.Qj();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        cET();
        this.nnu = false;
        if (this.nnw != null) {
            this.nnw.cancel();
        }
        if (this.nnr != null && this.nnr.dPz() != null) {
            this.nnr.dPz().pause();
            this.nnr.dPz().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.nnr == null || this.nns == null || this.nnt == null) {
            cET();
            this.nnu = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.nnu) {
            this.nnu = true;
            this.Mo = false;
            if (this.nnw != null) {
                this.nnw.cancel();
            }
            this.mCoverPath = null;
            this.nnr.onPause();
            this.jlx.setDialogVisiable(true);
            dOS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cET() {
        if (this.jlx != null) {
            this.jlx.setDialogVisiable(false);
        }
    }

    private void dOS() {
        if (this.Mo) {
            this.Mo = false;
            return;
        }
        String text = this.nnr.getText();
        if (TextUtils.isEmpty(text)) {
            this.nns.bN(this.mVideoPath, this.nnr.getCurrentPosition());
        } else {
            this.nns.Qn(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bxL() {
        this.Mo = false;
        this.nnu = false;
        this.nnx.xQ(false);
        this.nnx.coverPath = this.mCoverPath;
        this.nnx.originPath = this.mVideoPath;
        this.nnx.musicPath = this.nnr.dPE();
        this.nnx.isMute = this.nnr.isMute();
        this.nnx.filterName = this.nnv.dOV();
        this.nnw.dPJ();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dsH() {
        if (this.nnr == null || this.nns == null) {
            cET();
            this.nnu = false;
        } else if (this.Mo) {
            this.Mo = false;
        } else {
            this.nns.bN(this.mVideoPath, this.nnr.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Ql(String str) {
        if (this.Mo) {
            this.Mo = false;
        } else if (this.nnu) {
            showToast(str);
            cET();
            this.nnu = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void M(Bitmap bitmap) {
        this.nnr.dPz().Q(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void TH(String str) {
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
        TJ(this.mCoverPath);
        if (this.jld != null && this.jld.equals("1")) {
            if (this.nnw != null) {
                this.nnx.xQ(false);
                this.nnx.coverPath = this.mCoverPath;
                this.nnx.originPath = this.mVideoPath;
                this.nnx.musicPath = this.nnr.dPE();
                this.nnx.isMute = this.nnr.isMute();
                this.nnx.filterName = this.nnv.dOV();
                this.nnw.dPJ();
                return;
            }
            return;
        }
        cET();
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
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 9, this.fyR, this.mForumName, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.jld);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.nnn);
        writeActivityConfig.setFrsTabInfo(this.nno);
        writeActivityConfig.setVideoInfo(this.mVideoInfo);
        writeActivityConfig.setForumLevel(this.lEG);
        EditVideoData editVideoData = new EditVideoData();
        editVideoData.coverPath = this.mCoverPath;
        editVideoData.originPath = this.mVideoPath;
        editVideoData.musicPath = this.nnr.dPE();
        editVideoData.musicId = this.nnr.dPF();
        editVideoData.isMute = this.nnr.isMute();
        editVideoData.filterName = this.nnv.dOV();
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
        this.nnr.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dOT() {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void fR(List<PendantData> list) {
        this.nnr.fR(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25032) {
                String stringExtra = intent.getStringExtra("music_resource");
                String stringExtra2 = intent.getStringExtra("music_id");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    String TM = com.baidu.tieba.video.editvideo.model.a.dPj().TM(stringExtra);
                    if (this.nnr != null && !TextUtils.isEmpty(TM)) {
                        this.nnr.gz(TM, stringExtra2);
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
    public void TI(String str) {
        try {
            new z(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.bo(this, str);
        } catch (Exception e) {
            cET();
            this.nnu = false;
        }
    }

    private void TJ(String str) {
        try {
            new z(this).saveImage(str);
            com.baidu.tieba.video.editvideo.b.c.bo(this, str);
        } catch (Exception e) {
            cET();
            this.nnu = false;
        }
    }

    private void N(Bitmap bitmap) {
        if (this.nnr == null || this.nns == null) {
            cET();
            this.nnu = false;
        } else if (this.Mo) {
            this.Mo = false;
        } else {
            if (!TextUtils.isEmpty(this.nnr.getText())) {
                bitmap = this.nnr.F(bitmap);
            }
            if (bitmap != null) {
                this.nns.b(bitmap, c.nlM);
            }
        }
    }
}
