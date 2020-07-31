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
import com.baidu.tbadk.core.util.y;
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
    private boolean Le;
    private String aZb;
    private String eKO;
    private com.baidu.tbadk.core.view.a iiF;
    private String iik;
    private h lOt;
    private String mCoverPath;
    private String mForumName;
    private String mFrom;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;
    private int mdn;
    private FrsTabInfoData mdo;
    private String mdp;
    private List<VideoTitleData> mdq;
    private com.baidu.tieba.video.editvideo.view.a mdr;
    private SelectCoverModel mds;
    private SelectMusicModel mdt;
    private boolean mdu;
    private com.baidu.tieba.video.editvideo.b.a mdv;
    private com.baidu.tieba.video.editvideo.view.b mdw;
    private com.baidu.tieba.video.b mdx;
    private HttpMessageListener mdy;
    private CustomMessageListener mdz;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.lOt = lVar.cGE();
        }
        this.mdy = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.mdq = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.mdz = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
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
            this.mdx.originPath = this.mVideoPath;
        }
        this.mdr.setData(this.mVideoPath);
        dpT();
        this.aZb = getIntent().getStringExtra("from_type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_edit_video);
        this.eKO = getIntent().getStringExtra("forum_id");
        this.mdn = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.mdp = getIntent().getStringExtra("video_title");
        this.iik = getIntent().getStringExtra("KEY_CALL_FROM");
        this.aZb = getIntent().getStringExtra("from_type");
        this.mFrom = getIntent().getStringExtra("from");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.mdo = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.mbO).mkdirs();
        this.mds = new SelectCoverModel(getPageContext(), this, this.lOt);
        this.mdt = new SelectMusicModel(getPageContext(), this);
        this.mdv = new com.baidu.tieba.video.editvideo.b.a(this);
        this.mdr = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.lOt);
        this.mdr.setData(this.mVideoPath);
        this.mdr.an(getIntent());
        this.mdr.a(this.mdv);
        this.mdr.setGenMaskCoverListener(this);
        this.mds.dqt();
        this.mdt.dqu();
        this.iiF = new com.baidu.tbadk.core.view.a(getPageContext());
        this.iiF.setTipString(R.string.mixing);
        registerListener(this.mdz);
        dpW();
        registerListener(this.mdy);
        dpV();
        TiebaStatic.log("c12303");
        this.mdx = new com.baidu.tieba.video.b(this, this.mVideoPath, this.mCoverPath) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
            @Override // com.baidu.tieba.video.b
            public void onCancel() {
                super.onCancel();
                EditVideoActivity.this.chU();
            }

            @Override // com.baidu.tieba.video.b
            public void dpr() {
                EditVideoActivity.this.mdr.dqH();
                EditVideoActivity.this.mdr.dqI();
                EditVideoActivity.this.mdr.dqE().releaseSource();
            }

            @Override // com.baidu.tieba.video.b
            public void bF(int i, String str) {
                super.bF(i, str);
                EditVideoActivity.this.chU();
            }

            @Override // com.baidu.tieba.video.b
            public void dps() {
            }

            @Override // com.baidu.tieba.video.b
            public void bG(int i, String str) {
                super.bG(i, str);
                EditVideoActivity.this.chU();
            }

            @Override // com.baidu.tieba.video.b
            public void a(final VideoInfo videoInfo) {
                super.a(videoInfo);
                if (EditVideoActivity.this.mdu) {
                    if (EditVideoActivity.this.iik == null || !EditVideoActivity.this.iik.equals("1") || TextUtils.isEmpty(videoInfo.getVideoPath())) {
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
                            if (EditVideoActivity.this.mdr.dqL() && !TextUtils.isEmpty(EditVideoActivity.this.mdr.dqK())) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(EditVideoActivity.this.mdr.dqK());
                                EditVideoActivity.this.mVideoInfo.setMusicListInfo(arrayList);
                            }
                            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(EditVideoActivity.this.getPageContext().getPageActivity(), EditVideoActivity.this.iik, EditVideoActivity.this.eKO, EditVideoActivity.this.mForumName, EditVideoActivity.this.mdp, RequestResponseCode.REQUEST_WRITE_NEW, EditVideoActivity.this.mVideoInfo, EditVideoActivity.this.mVideoTitleData, EditVideoActivity.this.mdq);
                            if (!StringUtils.isNull(EditVideoActivity.this.aZb)) {
                                writeVideoActivityConfig.addFromType(EditVideoActivity.this.aZb);
                            }
                            writeVideoActivityConfig.setProZone(EditVideoActivity.this.mdn);
                            writeVideoActivityConfig.setFrom(EditVideoActivity.this.mFrom);
                            writeVideoActivityConfig.setFrsTabInfo(EditVideoActivity.this.mdo);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
                        }
                    });
                    return;
                }
                File file = new File(videoInfo.getVideoPath());
                String str = c.mbO + file.getName();
                if (!str.equals(file.getAbsolutePath())) {
                    n.copyFile(file.getAbsolutePath(), str);
                }
                EditVideoActivity.this.OG(str);
                EditVideoActivity.this.finishPage();
            }
        };
        this.mdw = new com.baidu.tieba.video.editvideo.view.b(this.mdx);
        dpT();
    }

    private void dpT() {
        if (this.mVideoInfo != null && this.mVideoInfo.getEditVideoData() != null && this.mdr != null) {
            com.baidu.tieba.video.editvideo.data.a OQ = this.mdr.OQ(this.mVideoInfo.getEditVideoData().filterName);
            if (OQ != null) {
                if (this.mdv != null) {
                    this.mdv.b(OQ);
                }
                this.mdr.c(OQ);
            }
            this.mdr.fI(this.mVideoInfo.getEditVideoData().musicPath, this.mVideoInfo.getEditVideoData().musicId);
            this.mdr.vO(!this.mVideoInfo.getEditVideoData().isMute);
        }
    }

    public String aVX() {
        return this.aZb;
    }

    private void dpU() {
        if (this.mdw != null) {
            this.mdw.cancel();
        }
        this.Le = true;
        this.mCoverPath = null;
        chU();
    }

    public void dpV() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.eKO)) {
            httpMessage.addParam("forum_id", this.eKO);
        }
        sendMessage(httpMessage);
    }

    private void dpW() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mdr.getRootView());
        if (this.mdr != null) {
            this.mdr.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.mdr != null) {
            this.mdr.onPause();
            this.mdr.dqH();
            this.mdr.dqI();
            this.mdr.dqE().releaseSource();
        }
        if (this.mdv.dqb()) {
            this.mdv.dqc();
        }
        this.mdu = false;
        this.Le = true;
        if (this.mdw != null) {
            this.mdw.cancel();
        }
        dpU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mdr != null) {
            this.mdr.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.dqo().dqp();
        com.baidu.tieba.video.editvideo.model.b.dqr().dqs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mdr != null) {
            this.mdr.release();
        }
        if (this.mds != null) {
            this.mds.cancelLoadData();
        }
        if (this.mdt != null) {
            this.mdt.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mdr != null) {
            this.mdr.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        chU();
        this.mdu = false;
        if (this.mdw != null) {
            this.mdw.cancel();
        }
        if (this.mdr != null && this.mdr.dqE() != null) {
            this.mdr.dqE().pause();
            this.mdr.dqE().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.mdr == null || this.mds == null || this.mdt == null) {
            chU();
            this.mdu = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.mdu) {
            this.mdu = true;
            this.Le = false;
            if (this.mdw != null) {
                this.mdw.cancel();
            }
            this.mCoverPath = null;
            this.mdr.onPause();
            this.iiF.setDialogVisiable(true);
            dpX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chU() {
        if (this.iiF != null) {
            this.iiF.setDialogVisiable(false);
        }
    }

    private void dpX() {
        if (this.Le) {
            this.Le = false;
            return;
        }
        String text = this.mdr.getText();
        if (TextUtils.isEmpty(text)) {
            this.mds.bE(this.mVideoPath, this.mdr.getCurrentPosition());
        } else {
            this.mds.Lo(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bhc() {
        this.Le = false;
        this.mdu = false;
        this.mdx.vJ(false);
        this.mdx.coverPath = this.mCoverPath;
        this.mdx.originPath = this.mVideoPath;
        this.mdx.musicPath = this.mdr.dqJ();
        this.mdx.isMute = this.mdr.isMute();
        this.mdx.filterName = this.mdv.dqa();
        this.mdw.dqO();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cUN() {
        if (this.mdr == null || this.mds == null) {
            chU();
            this.mdu = false;
        } else if (this.Le) {
            this.Le = false;
        } else {
            this.mds.bE(this.mVideoPath, this.mdr.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Lm(String str) {
        if (this.Le) {
            this.Le = false;
        } else if (this.mdu) {
            showToast(str);
            chU();
            this.mdu = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void N(Bitmap bitmap) {
        this.mdr.dqE().R(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void OF(String str) {
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
        OH(this.mCoverPath);
        if (this.iik != null && this.iik.equals("1")) {
            if (this.mdw != null) {
                this.mdx.vJ(false);
                this.mdx.coverPath = this.mCoverPath;
                this.mdx.originPath = this.mVideoPath;
                this.mdx.musicPath = this.mdr.dqJ();
                this.mdx.isMute = this.mdr.isMute();
                this.mdx.filterName = this.mdv.dqa();
                this.mdw.dqO();
                return;
            }
            return;
        }
        chU();
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
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 9, this.eKO, this.mForumName, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.iik);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.mdn);
        writeActivityConfig.setFrsTabInfo(this.mdo);
        writeActivityConfig.setVideoInfo(this.mVideoInfo);
        EditVideoData editVideoData = new EditVideoData();
        editVideoData.coverPath = this.mCoverPath;
        editVideoData.originPath = this.mVideoPath;
        editVideoData.musicPath = this.mdr.dqJ();
        editVideoData.musicId = this.mdr.dqK();
        editVideoData.isMute = this.mdr.isMute();
        editVideoData.filterName = this.mdv.dqa();
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
        this.mdr.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dpY() {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void fg(List<PendantData> list) {
        this.mdr.fg(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25032) {
                String stringExtra = intent.getStringExtra("music_resource");
                String stringExtra2 = intent.getStringExtra("music_id");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    String OK = com.baidu.tieba.video.editvideo.model.a.dqo().OK(stringExtra);
                    if (this.mdr != null && !TextUtils.isEmpty(OK)) {
                        this.mdr.fJ(OK, stringExtra2);
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
    public void OG(String str) {
        try {
            new y(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.aY(this, str);
        } catch (Exception e) {
            chU();
            this.mdu = false;
        }
    }

    private void OH(String str) {
        try {
            new y(this).saveImage(str);
            com.baidu.tieba.video.editvideo.b.c.aY(this, str);
        } catch (Exception e) {
            chU();
            this.mdu = false;
        }
    }

    private void O(Bitmap bitmap) {
        if (this.mdr == null || this.mds == null) {
            chU();
            this.mdu = false;
        } else if (this.Le) {
            this.Le = false;
        } else {
            if (!TextUtils.isEmpty(this.mdr.getText())) {
                bitmap = this.mdr.G(bitmap);
            }
            if (bitmap != null) {
                this.mds.b(bitmap, c.mbM);
            }
        }
    }
}
