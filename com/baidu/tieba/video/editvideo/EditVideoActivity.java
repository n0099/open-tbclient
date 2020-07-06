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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.k.h;
import com.baidu.tieba.k.l;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.video.d;
import com.baidu.tieba.video.editvideo.b.c;
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
/* loaded from: classes10.dex */
public class EditVideoActivity extends BaseActivity implements a, b, MaskVideoView.b {
    private boolean Le;
    private String aZd;
    private String eEs;
    private com.baidu.tbadk.core.view.a icD;
    private String ici;
    private h lHf;
    private int lVX;
    private FrsTabInfoData lVY;
    private String lVZ;
    private List<VideoTitleData> lWa;
    private com.baidu.tieba.video.editvideo.view.a lWb;
    private SelectCoverModel lWc;
    private SelectMusicModel lWd;
    private boolean lWe;
    private com.baidu.tieba.video.editvideo.b.a lWf;
    private com.baidu.tieba.video.editvideo.view.b lWg;
    private com.baidu.tieba.video.b lWh;
    private HttpMessageListener lWi;
    private CustomMessageListener lWj;
    private String mCoverPath;
    private String mForumName;
    private String mFrom;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.lHf = lVar.cCQ();
        }
        this.lWi = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.lWa = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.lWj = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
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
            this.lWh.originPath = this.mVideoPath;
        }
        this.lWb.setData(this.mVideoPath);
        dmI();
        this.aZd = getIntent().getStringExtra("from_type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_edit_video);
        this.eEs = getIntent().getStringExtra("forum_id");
        this.lVX = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.lVZ = getIntent().getStringExtra("video_title");
        this.ici = getIntent().getStringExtra("KEY_CALL_FROM");
        this.aZd = getIntent().getStringExtra("from_type");
        this.mFrom = getIntent().getStringExtra("from");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.lVY = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(d.lUy).mkdirs();
        this.lWc = new SelectCoverModel(getPageContext(), this, this.lHf);
        this.lWd = new SelectMusicModel(getPageContext(), this);
        this.lWf = new com.baidu.tieba.video.editvideo.b.a(this);
        this.lWb = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.lHf);
        this.lWb.setData(this.mVideoPath);
        this.lWb.am(getIntent());
        this.lWb.a(this.lWf);
        this.lWb.setGenMaskCoverListener(this);
        this.lWc.dnj();
        this.lWd.dnk();
        this.icD = new com.baidu.tbadk.core.view.a(getPageContext());
        this.icD.setTipString(R.string.mixing);
        registerListener(this.lWj);
        dmL();
        registerListener(this.lWi);
        dmK();
        TiebaStatic.log("c12303");
        this.lWh = new com.baidu.tieba.video.b(this, this.mVideoPath, this.mCoverPath) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
            @Override // com.baidu.tieba.video.b
            public void onCancel() {
                super.onCancel();
                EditVideoActivity.this.cev();
            }

            @Override // com.baidu.tieba.video.b
            public void dmh() {
                EditVideoActivity.this.lWb.dny();
                EditVideoActivity.this.lWb.dnz();
                EditVideoActivity.this.lWb.dnv().releaseSource();
            }

            @Override // com.baidu.tieba.video.b
            public void bE(int i, String str) {
                super.bE(i, str);
                EditVideoActivity.this.cev();
            }

            @Override // com.baidu.tieba.video.b
            public void dmi() {
            }

            @Override // com.baidu.tieba.video.b
            public void bF(int i, String str) {
                super.bF(i, str);
                EditVideoActivity.this.cev();
            }

            @Override // com.baidu.tieba.video.b
            public void a(final VideoInfo videoInfo) {
                super.a(videoInfo);
                if (EditVideoActivity.this.lWe) {
                    if (EditVideoActivity.this.ici == null || !EditVideoActivity.this.ici.equals("1") || TextUtils.isEmpty(videoInfo.getVideoPath())) {
                        return;
                    }
                    n.a(new String[]{videoInfo.getThumbPath(), videoInfo.getVideoPath()}, new n.b() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2.1
                        @Override // com.baidu.tbadk.core.util.n.b
                        public void E(HashMap<String, String> hashMap) {
                            EditVideoActivity.this.mVideoInfo.setVideoPath(videoInfo.getVideoPath());
                            EditVideoActivity.this.mVideoInfo.setThumbPath(videoInfo.getThumbPath());
                            if (hashMap != null) {
                                EditVideoActivity.this.mVideoInfo.setThumbUriStr(hashMap.get(videoInfo.getThumbPath()));
                                EditVideoActivity.this.mVideoInfo.setVideoUriStr(hashMap.get(videoInfo.getVideoPath()));
                            }
                            if (EditVideoActivity.this.lWb.dnC() && !TextUtils.isEmpty(EditVideoActivity.this.lWb.dnB())) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(EditVideoActivity.this.lWb.dnB());
                                EditVideoActivity.this.mVideoInfo.setMusicListInfo(arrayList);
                            }
                            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(EditVideoActivity.this.getPageContext().getPageActivity(), EditVideoActivity.this.ici, EditVideoActivity.this.eEs, EditVideoActivity.this.mForumName, EditVideoActivity.this.lVZ, RequestResponseCode.REQUEST_WRITE_NEW, EditVideoActivity.this.mVideoInfo, EditVideoActivity.this.mVideoTitleData, EditVideoActivity.this.lWa);
                            if (!StringUtils.isNull(EditVideoActivity.this.aZd)) {
                                writeVideoActivityConfig.addFromType(EditVideoActivity.this.aZd);
                            }
                            writeVideoActivityConfig.setProZone(EditVideoActivity.this.lVX);
                            writeVideoActivityConfig.setFrom(EditVideoActivity.this.mFrom);
                            writeVideoActivityConfig.setFrsTabInfo(EditVideoActivity.this.lVY);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
                        }
                    });
                    return;
                }
                File file = new File(videoInfo.getVideoPath());
                String str = d.lUy + file.getName();
                if (!str.equals(file.getAbsolutePath())) {
                    n.copyFile(file.getAbsolutePath(), str);
                }
                EditVideoActivity.this.NY(str);
                EditVideoActivity.this.finishPage();
            }
        };
        this.lWg = new com.baidu.tieba.video.editvideo.view.b(this.lWh);
        dmI();
    }

    private void dmI() {
        if (this.mVideoInfo != null && this.mVideoInfo.getEditVideoData() != null && this.lWb != null) {
            com.baidu.tieba.video.editvideo.data.a Oi = this.lWb.Oi(this.mVideoInfo.getEditVideoData().filterName);
            if (Oi != null) {
                if (this.lWf != null) {
                    this.lWf.b(Oi);
                }
                this.lWb.c(Oi);
            }
            this.lWb.fG(this.mVideoInfo.getEditVideoData().musicPath, this.mVideoInfo.getEditVideoData().musicId);
            this.lWb.vk(!this.mVideoInfo.getEditVideoData().isMute);
        }
    }

    public String aSb() {
        return this.aZd;
    }

    private void dmJ() {
        if (this.lWg != null) {
            this.lWg.cancel();
        }
        this.Le = true;
        this.mCoverPath = null;
        cev();
    }

    public void dmK() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.eEs)) {
            httpMessage.addParam("forum_id", this.eEs);
        }
        sendMessage(httpMessage);
    }

    private void dmL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.lWb.getRootView());
        if (this.lWb != null) {
            this.lWb.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.lWb != null) {
            this.lWb.onPause();
            this.lWb.dny();
            this.lWb.dnz();
            this.lWb.dnv().releaseSource();
        }
        if (this.lWf.dmR()) {
            this.lWf.dmS();
        }
        this.lWe = false;
        this.Le = true;
        if (this.lWg != null) {
            this.lWg.cancel();
        }
        dmJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lWb != null) {
            this.lWb.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.dne().dnf();
        com.baidu.tieba.video.editvideo.model.b.dnh().dni();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lWb != null) {
            this.lWb.release();
        }
        if (this.lWc != null) {
            this.lWc.cancelLoadData();
        }
        if (this.lWd != null) {
            this.lWd.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.lWb != null) {
            this.lWb.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        cev();
        this.lWe = false;
        if (this.lWg != null) {
            this.lWg.cancel();
        }
        if (this.lWb != null && this.lWb.dnv() != null) {
            this.lWb.dnv().pause();
            this.lWb.dnv().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.lWb == null || this.lWc == null || this.lWd == null) {
            cev();
            this.lWe = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.lWe) {
            this.lWe = true;
            this.Le = false;
            if (this.lWg != null) {
                this.lWg.cancel();
            }
            this.mCoverPath = null;
            this.lWb.onPause();
            this.icD.setDialogVisiable(true);
            dmM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cev() {
        if (this.icD != null) {
            this.icD.setDialogVisiable(false);
        }
    }

    private void dmM() {
        if (this.Le) {
            this.Le = false;
            return;
        }
        String text = this.lWb.getText();
        if (TextUtils.isEmpty(text)) {
            this.lWc.bG(this.mVideoPath, this.lWb.getCurrentPosition());
        } else {
            this.lWc.KA(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dmN() {
        this.Le = false;
        this.lWe = false;
        this.lWh.vf(false);
        this.lWh.coverPath = this.mCoverPath;
        this.lWh.originPath = this.mVideoPath;
        this.lWh.musicPath = this.lWb.dnA();
        this.lWh.isMute = this.lWb.isMute();
        this.lWh.filterName = this.lWf.dmQ();
        this.lWg.dnF();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cQX() {
        if (this.lWb == null || this.lWc == null) {
            cev();
            this.lWe = false;
        } else if (this.Le) {
            this.Le = false;
        } else {
            this.lWc.bG(this.mVideoPath, this.lWb.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Ky(String str) {
        if (this.Le) {
            this.Le = false;
        } else if (this.lWe) {
            showToast(str);
            cev();
            this.lWe = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void K(Bitmap bitmap) {
        this.lWb.dnv().O(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void NX(String str) {
        String str2;
        String str3;
        AntiData antiData;
        PostPrefixData postPrefixData;
        PostPrefixData postPrefixData2;
        if (this.Le) {
            this.Le = false;
            return;
        }
        this.mCoverPath = str;
        NZ(this.mCoverPath);
        if (this.ici != null && this.ici.equals("1")) {
            if (this.lWg != null) {
                this.lWh.vf(false);
                this.lWh.coverPath = this.mCoverPath;
                this.lWh.originPath = this.mVideoPath;
                this.lWh.musicPath = this.lWb.dnA();
                this.lWh.isMute = this.lWb.isMute();
                this.lWh.filterName = this.lWf.dmQ();
                this.lWg.dnF();
                return;
            }
            return;
        }
        cev();
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
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 9, this.eEs, this.mForumName, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.ici);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.lVX);
        writeActivityConfig.setFrsTabInfo(this.lVY);
        writeActivityConfig.setVideoInfo(this.mVideoInfo);
        EditVideoData editVideoData = new EditVideoData();
        editVideoData.coverPath = this.mCoverPath;
        editVideoData.originPath = this.mVideoPath;
        editVideoData.musicPath = this.lWb.dnA();
        editVideoData.musicId = this.lWb.dnB();
        editVideoData.isMute = this.lWb.isMute();
        editVideoData.filterName = this.lWf.dmQ();
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
        this.lWb.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dmO() {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void fa(List<PendantData> list) {
        this.lWb.fa(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25032) {
                String stringExtra = intent.getStringExtra("music_resource");
                String stringExtra2 = intent.getStringExtra("music_id");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    String Oc = com.baidu.tieba.video.editvideo.model.a.dne().Oc(stringExtra);
                    if (this.lWb != null && !TextUtils.isEmpty(Oc)) {
                        this.lWb.fH(Oc, stringExtra2);
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
        L(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NY(String str) {
        try {
            new x(this).saveVideo(str);
            c.aZ(this, str);
        } catch (Exception e) {
            cev();
            this.lWe = false;
        }
    }

    private void NZ(String str) {
        try {
            new x(this).saveImage(str);
            c.aZ(this, str);
        } catch (Exception e) {
            cev();
            this.lWe = false;
        }
    }

    private void L(Bitmap bitmap) {
        if (this.lWb == null || this.lWc == null) {
            cev();
            this.lWe = false;
        } else if (this.Le) {
            this.Le = false;
        } else {
            if (!TextUtils.isEmpty(this.lWb.getText())) {
                bitmap = this.lWb.D(bitmap);
            }
            if (bitmap != null) {
                this.lWc.b(bitmap, d.lUw);
            }
        }
    }
}
