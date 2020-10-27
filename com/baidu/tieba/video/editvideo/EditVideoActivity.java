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
    private String bmC;
    private String fsZ;
    private String jff;
    private com.baidu.tbadk.core.view.a jfz;
    private int lyK;
    private String mCoverPath;
    private String mForumName;
    private String mFrom;
    private h mSh;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;
    private com.baidu.tieba.video.editvideo.view.b nhA;
    private com.baidu.tieba.video.b nhB;
    private HttpMessageListener nhC;
    private CustomMessageListener nhD;
    private int nhr;
    private FrsTabInfoData nhs;
    private String nht;
    private List<VideoTitleData> nhu;
    private com.baidu.tieba.video.editvideo.view.a nhv;
    private SelectCoverModel nhw;
    private SelectMusicModel nhx;
    private boolean nhy;
    private com.baidu.tieba.video.editvideo.b.a nhz;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mSh = lVar.dbR();
        }
        this.nhC = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.nhu = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.nhD = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
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
            this.nhB.originPath = this.mVideoPath;
        }
        this.nhv.setData(this.mVideoPath);
        dMm();
        this.bmC = getIntent().getStringExtra("from_type");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_edit_video);
        this.fsZ = getIntent().getStringExtra("forum_id");
        this.lyK = getIntent().getIntExtra("key_write_level", -1);
        this.nhr = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.nht = getIntent().getStringExtra("video_title");
        this.jff = getIntent().getStringExtra("KEY_CALL_FROM");
        this.bmC = getIntent().getStringExtra("from_type");
        this.mFrom = getIntent().getStringExtra("from");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.nhs = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.nfS).mkdirs();
        this.nhw = new SelectCoverModel(getPageContext(), this, this.mSh);
        this.nhx = new SelectMusicModel(getPageContext(), this);
        this.nhz = new com.baidu.tieba.video.editvideo.b.a(this);
        this.nhv = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.mSh);
        this.nhv.setData(this.mVideoPath);
        this.nhv.am(getIntent());
        this.nhv.a(this.nhz);
        this.nhv.setGenMaskCoverListener(this);
        this.nhw.dMM();
        this.nhx.dMN();
        this.jfz = new com.baidu.tbadk.core.view.a(getPageContext());
        this.jfz.setTipString(R.string.mixing);
        registerListener(this.nhD);
        dMp();
        registerListener(this.nhC);
        dMo();
        TiebaStatic.log("c12303");
        this.nhB = new com.baidu.tieba.video.b(this, this.mVideoPath, this.mCoverPath) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
            @Override // com.baidu.tieba.video.b
            public void onCancel() {
                super.onCancel();
                EditVideoActivity.this.cCs();
            }

            @Override // com.baidu.tieba.video.b
            public void dLK() {
                EditVideoActivity.this.nhv.dNa();
                EditVideoActivity.this.nhv.dNb();
                EditVideoActivity.this.nhv.dMX().releaseSource();
            }

            @Override // com.baidu.tieba.video.b
            public void bR(int i, String str) {
                super.bR(i, str);
                EditVideoActivity.this.cCs();
            }

            @Override // com.baidu.tieba.video.b
            public void dLL() {
            }

            @Override // com.baidu.tieba.video.b
            public void bS(int i, String str) {
                super.bS(i, str);
                EditVideoActivity.this.cCs();
            }

            @Override // com.baidu.tieba.video.b
            public void a(final VideoInfo videoInfo) {
                super.a(videoInfo);
                if (EditVideoActivity.this.nhy) {
                    if (EditVideoActivity.this.jff == null || !EditVideoActivity.this.jff.equals("1") || TextUtils.isEmpty(videoInfo.getVideoPath())) {
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
                            if (EditVideoActivity.this.nhv.dNe() && !TextUtils.isEmpty(EditVideoActivity.this.nhv.dNd())) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(EditVideoActivity.this.nhv.dNd());
                                EditVideoActivity.this.mVideoInfo.setMusicListInfo(arrayList);
                            }
                            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(EditVideoActivity.this.getPageContext().getPageActivity(), EditVideoActivity.this.jff, EditVideoActivity.this.fsZ, EditVideoActivity.this.mForumName, EditVideoActivity.this.nht, RequestResponseCode.REQUEST_WRITE_NEW, EditVideoActivity.this.mVideoInfo, EditVideoActivity.this.mVideoTitleData, EditVideoActivity.this.nhu);
                            if (!StringUtils.isNull(EditVideoActivity.this.bmC)) {
                                writeVideoActivityConfig.addFromType(EditVideoActivity.this.bmC);
                            }
                            writeVideoActivityConfig.setProZone(EditVideoActivity.this.nhr);
                            writeVideoActivityConfig.setFrom(EditVideoActivity.this.mFrom);
                            writeVideoActivityConfig.setFrsTabInfo(EditVideoActivity.this.nhs);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
                        }
                    });
                    return;
                }
                File file = new File(videoInfo.getVideoPath());
                String str = c.nfS + file.getName();
                if (!str.equals(file.getAbsolutePath())) {
                    n.copyFile(file.getAbsolutePath(), str);
                }
                EditVideoActivity.this.Tr(str);
                EditVideoActivity.this.finishPage();
            }
        };
        this.nhA = new com.baidu.tieba.video.editvideo.view.b(this.nhB);
        dMm();
    }

    private void dMm() {
        if (this.mVideoInfo != null && this.mVideoInfo.getEditVideoData() != null && this.nhv != null) {
            com.baidu.tieba.video.editvideo.data.a TB = this.nhv.TB(this.mVideoInfo.getEditVideoData().filterName);
            if (TB != null) {
                if (this.nhz != null) {
                    this.nhz.b(TB);
                }
                this.nhv.c(TB);
            }
            this.nhv.gy(this.mVideoInfo.getEditVideoData().musicPath, this.mVideoInfo.getEditVideoData().musicId);
            this.nhv.xM(!this.mVideoInfo.getEditVideoData().isMute);
        }
    }

    public String bjM() {
        return this.bmC;
    }

    private void dMn() {
        if (this.nhA != null) {
            this.nhA.cancel();
        }
        this.Mo = true;
        this.mCoverPath = null;
        cCs();
    }

    public void dMo() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.fsZ)) {
            httpMessage.addParam("forum_id", this.fsZ);
        }
        sendMessage(httpMessage);
    }

    private void dMp() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.nhv.getRootView());
        if (this.nhv != null) {
            this.nhv.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.nhv != null) {
            this.nhv.onPause();
            this.nhv.dNa();
            this.nhv.dNb();
            this.nhv.dMX().releaseSource();
        }
        if (this.nhz.dMu()) {
            this.nhz.dMv();
        }
        this.nhy = false;
        this.Mo = true;
        if (this.nhA != null) {
            this.nhA.cancel();
        }
        dMn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nhv != null) {
            this.nhv.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.dMH().dMI();
        com.baidu.tieba.video.editvideo.model.b.dMK().dML();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nhv != null) {
            this.nhv.release();
        }
        if (this.nhw != null) {
            this.nhw.cancelLoadData();
        }
        if (this.nhx != null) {
            this.nhx.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.nhv != null) {
            this.nhv.PJ();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        cCs();
        this.nhy = false;
        if (this.nhA != null) {
            this.nhA.cancel();
        }
        if (this.nhv != null && this.nhv.dMX() != null) {
            this.nhv.dMX().pause();
            this.nhv.dMX().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.nhv == null || this.nhw == null || this.nhx == null) {
            cCs();
            this.nhy = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.nhy) {
            this.nhy = true;
            this.Mo = false;
            if (this.nhA != null) {
                this.nhA.cancel();
            }
            this.mCoverPath = null;
            this.nhv.onPause();
            this.jfz.setDialogVisiable(true);
            dMq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCs() {
        if (this.jfz != null) {
            this.jfz.setDialogVisiable(false);
        }
    }

    private void dMq() {
        if (this.Mo) {
            this.Mo = false;
            return;
        }
        String text = this.nhv.getText();
        if (TextUtils.isEmpty(text)) {
            this.nhw.bL(this.mVideoPath, this.nhv.getCurrentPosition());
        } else {
            this.nhw.PW(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bvm() {
        this.Mo = false;
        this.nhy = false;
        this.nhB.xH(false);
        this.nhB.coverPath = this.mCoverPath;
        this.nhB.originPath = this.mVideoPath;
        this.nhB.musicPath = this.nhv.dNc();
        this.nhB.isMute = this.nhv.isMute();
        this.nhB.filterName = this.nhz.dMt();
        this.nhA.dNh();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dqf() {
        if (this.nhv == null || this.nhw == null) {
            cCs();
            this.nhy = false;
        } else if (this.Mo) {
            this.Mo = false;
        } else {
            this.nhw.bL(this.mVideoPath, this.nhv.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void PU(String str) {
        if (this.Mo) {
            this.Mo = false;
        } else if (this.nhy) {
            showToast(str);
            cCs();
            this.nhy = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void M(Bitmap bitmap) {
        this.nhv.dMX().Q(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Tq(String str) {
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
        Ts(this.mCoverPath);
        if (this.jff != null && this.jff.equals("1")) {
            if (this.nhA != null) {
                this.nhB.xH(false);
                this.nhB.coverPath = this.mCoverPath;
                this.nhB.originPath = this.mVideoPath;
                this.nhB.musicPath = this.nhv.dNc();
                this.nhB.isMute = this.nhv.isMute();
                this.nhB.filterName = this.nhz.dMt();
                this.nhA.dNh();
                return;
            }
            return;
        }
        cCs();
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
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this, 9, this.fsZ, this.mForumName, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", this.mFrom);
        writeActivityConfig.setCallFrom(this.jff);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.nhr);
        writeActivityConfig.setFrsTabInfo(this.nhs);
        writeActivityConfig.setVideoInfo(this.mVideoInfo);
        writeActivityConfig.setForumLevel(this.lyK);
        EditVideoData editVideoData = new EditVideoData();
        editVideoData.coverPath = this.mCoverPath;
        editVideoData.originPath = this.mVideoPath;
        editVideoData.musicPath = this.nhv.dNc();
        editVideoData.musicId = this.nhv.dNd();
        editVideoData.isMute = this.nhv.isMute();
        editVideoData.filterName = this.nhz.dMt();
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
        this.nhv.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dMr() {
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void fJ(List<PendantData> list) {
        this.nhv.fJ(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 25032) {
                String stringExtra = intent.getStringExtra("music_resource");
                String stringExtra2 = intent.getStringExtra("music_id");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                    String Tv = com.baidu.tieba.video.editvideo.model.a.dMH().Tv(stringExtra);
                    if (this.nhv != null && !TextUtils.isEmpty(Tv)) {
                        this.nhv.gz(Tv, stringExtra2);
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
    public void Tr(String str) {
        try {
            new z(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.bo(this, str);
        } catch (Exception e) {
            cCs();
            this.nhy = false;
        }
    }

    private void Ts(String str) {
        try {
            new z(this).saveImage(str);
            com.baidu.tieba.video.editvideo.b.c.bo(this, str);
        } catch (Exception e) {
            cCs();
            this.nhy = false;
        }
    }

    private void N(Bitmap bitmap) {
        if (this.nhv == null || this.nhw == null) {
            cCs();
            this.nhy = false;
        } else if (this.Mo) {
            this.Mo = false;
        } else {
            if (!TextUtils.isEmpty(this.nhv.getText())) {
                bitmap = this.nhv.F(bitmap);
            }
            if (bitmap != null) {
                this.nhw.b(bitmap, c.nfQ);
            }
        }
    }
}
