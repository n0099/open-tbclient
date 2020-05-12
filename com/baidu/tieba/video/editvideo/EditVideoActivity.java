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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.k.h;
import com.baidu.tieba.k.l;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.video.c;
import com.baidu.tieba.video.editvideo.b.b;
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
public class EditVideoActivity extends BaseActivity implements a, b, b.a, MaskVideoView.b {
    private boolean Ks;
    private String aQl;
    private String eQk;
    private com.baidu.tbadk.core.view.a hzR;
    private String hzw;
    private h kTM;
    private SelectMusicModel liA;
    private String liB;
    private boolean liC;
    private com.baidu.tieba.video.editvideo.b.a liD;
    private HttpMessageListener liE;
    private CustomMessageListener liF;
    private int liu;
    private FrsTabInfoData liv;
    private String liw;
    private List<VideoTitleData> lix;
    private com.baidu.tieba.video.editvideo.view.a liy;
    private SelectCoverModel liz;
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
            this.kTM = lVar.crY();
        }
        this.liE = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.lix = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.liF = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    EditVideoActivity.this.finishPage();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.activity_edit_video);
        this.eQk = getIntent().getStringExtra("forum_id");
        this.liu = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.liw = getIntent().getStringExtra("video_title");
        this.hzw = getIntent().getStringExtra("KEY_CALL_FROM");
        this.aQl = getIntent().getStringExtra("from_type");
        this.mFrom = getIntent().getStringExtra("from");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.liv = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.lgV).mkdirs();
        this.liz = new SelectCoverModel(getPageContext(), this, this.kTM);
        this.liA = new SelectMusicModel(getPageContext(), this);
        this.liD = new com.baidu.tieba.video.editvideo.b.a(this);
        this.liD.a(this);
        this.liy = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.kTM);
        this.liy.setData(this.mVideoPath);
        this.liy.am(getIntent());
        this.liy.a(this.liD);
        this.liy.setGenMaskCoverListener(this);
        this.liz.dbt();
        this.liA.dbu();
        this.hzR = new com.baidu.tbadk.core.view.a(getPageContext());
        this.hzR.setTipString(R.string.mixing);
        registerListener(this.liF);
        daS();
        registerListener(this.liE);
        daR();
        TiebaStatic.log("c12303");
    }

    private void daQ() {
        this.Ks = true;
        this.liB = null;
        this.mCoverPath = null;
        bUx();
    }

    public void daR() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.eQk)) {
            httpMessage.addParam("forum_id", this.eQk);
        }
        sendMessage(httpMessage);
    }

    private void daS() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.liy.getRootView());
        if (this.liy != null) {
            this.liy.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.liy != null) {
            this.liy.onPause();
        }
        if (this.liD.dbb()) {
            this.liD.dbc();
        }
        this.liC = false;
        this.Ks = true;
        daQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.liy != null) {
            this.liy.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.dbo().dbp();
        com.baidu.tieba.video.editvideo.model.b.dbr().dbs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.liy != null) {
            this.liy.release();
        }
        if (this.liz != null) {
            this.liz.cancelLoadData();
        }
        if (this.liA != null) {
            this.liA.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.liy != null) {
            this.liy.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        bUx();
        this.liC = false;
        if (this.liy != null && this.liy.dbE() != null) {
            this.liy.dbE().pause();
            this.liy.dbE().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.liy == null || this.liz == null || this.liA == null) {
            bUx();
            this.liC = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.liC) {
            this.liC = true;
            this.Ks = false;
            this.liB = null;
            this.mCoverPath = null;
            this.liy.onPause();
            this.hzR.setDialogVisiable(true);
            daU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUx() {
        if (this.hzR != null) {
            this.hzR.setDialogVisiable(false);
        }
    }

    private void daT() {
        if (this.Ks) {
            this.Ks = false;
        } else if (this.liy.dbL()) {
            this.liA.h(this.mVideoPath, this.liy.dbJ(), c.lgU + "video_" + System.currentTimeMillis() + ".mp4", this.liy.isMute() ? false : true);
        } else if (this.liy.isMute()) {
            this.liA.h(this.mVideoPath, null, c.lgU + "video_" + System.currentTimeMillis() + ".mp4", this.liy.isMute() ? false : true);
        } else {
            v(this.mVideoPath, -4399, "");
        }
    }

    private void daU() {
        if (this.Ks) {
            this.Ks = false;
            return;
        }
        String text = this.liy.getText();
        if (TextUtils.isEmpty(text)) {
            this.liz.bG(this.mVideoPath, this.liy.getCurrentPosition());
        } else {
            this.liz.Il(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void daV() {
        File file;
        this.Ks = false;
        if (this.liy.dbL() || this.liy.isMute()) {
            this.liC = false;
            this.hzR.setDialogVisiable(true);
            this.liy.onPause();
            if (this.liB != null) {
                v(this.liB, -4399, "");
            } else {
                daT();
            }
        } else if (this.liD.dba()) {
            this.liC = false;
            this.liy.onPause();
            this.hzR.setDialogVisiable(true);
            LJ(this.mVideoPath);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.copyFile(new File(this.mVideoPath).getAbsolutePath(), c.lgV + file.getName());
                LL(c.lgV + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cFq() {
        if (this.liy == null || this.liz == null) {
            bUx();
            this.liC = false;
        } else if (this.Ks) {
            this.Ks = false;
        } else {
            this.liz.bG(this.mVideoPath, this.liy.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Ij(String str) {
        if (this.Ks) {
            this.Ks = false;
        } else if (this.liC) {
            showToast(str);
            bUx();
            this.liC = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void I(Bitmap bitmap) {
        this.liy.dbE().M(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void LH(String str) {
        if (this.Ks) {
            this.Ks = false;
            return;
        }
        this.mCoverPath = str;
        daT();
    }

    private void daW() {
        if (this.Ks) {
            this.Ks = false;
        } else if (TextUtils.isEmpty(this.mCoverPath) || TextUtils.isEmpty(this.liB)) {
        } else {
            m.a(new String[]{this.mCoverPath, this.liB}, new m.b() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
                @Override // com.baidu.tbadk.core.util.m.b
                public void C(HashMap<String, String> hashMap) {
                    EditVideoActivity.this.mVideoInfo.setVideoPath(EditVideoActivity.this.liB);
                    EditVideoActivity.this.mVideoInfo.setThumbPath(EditVideoActivity.this.mCoverPath);
                    if (hashMap != null) {
                        EditVideoActivity.this.mVideoInfo.setThumbUriStr(hashMap.get(EditVideoActivity.this.mCoverPath));
                        EditVideoActivity.this.mVideoInfo.setVideoUriStr(hashMap.get(EditVideoActivity.this.liB));
                    }
                    if (EditVideoActivity.this.liy.dbL() && !TextUtils.isEmpty(EditVideoActivity.this.liy.dbK())) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(EditVideoActivity.this.liy.dbK());
                        EditVideoActivity.this.mVideoInfo.setMusicListInfo(arrayList);
                    }
                    WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(EditVideoActivity.this.getPageContext().getPageActivity(), EditVideoActivity.this.hzw, EditVideoActivity.this.eQk, EditVideoActivity.this.mForumName, EditVideoActivity.this.liw, RequestResponseCode.REQUEST_WRITE_NEW, EditVideoActivity.this.mVideoInfo, EditVideoActivity.this.mVideoTitleData, EditVideoActivity.this.lix);
                    if (!StringUtils.isNull(EditVideoActivity.this.aQl)) {
                        writeVideoActivityConfig.addFromType(EditVideoActivity.this.aQl);
                    }
                    writeVideoActivityConfig.setProZone(EditVideoActivity.this.liu);
                    writeVideoActivityConfig.setFrom(EditVideoActivity.this.mFrom);
                    writeVideoActivityConfig.setFrsTabInfo(EditVideoActivity.this.liv);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
                    EditVideoActivity.this.bUx();
                    EditVideoActivity.this.liC = false;
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(R.string.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(R.string.music_cloud)));
        this.liy.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
        if (this.Ks) {
            this.Ks = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.mixing_fail);
            bUx();
            this.liy.onResume();
            this.liC = false;
            if (this.kTM != null) {
                this.kTM.bg(i, str2);
            }
        } else if (this.liD.dba()) {
            LJ(str);
        } else {
            LK(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void daX() {
        this.liB = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void eE(List<PendantData> list) {
        this.liy.eE(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String LO = com.baidu.tieba.video.editvideo.model.a.dbo().LO(stringExtra);
                if (this.liy != null && !TextUtils.isEmpty(LO)) {
                    this.liy.eX(LO, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void LI(String str) {
        LK(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bu(int i, String str) {
        if (this.kTM != null) {
            this.kTM.bg(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bv(int i, String str) {
        if (this.kTM != null) {
            this.kTM.bg(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void daY() {
        e.lb().post(new Runnable() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.4
            @Override // java.lang.Runnable
            public void run() {
                EditVideoActivity.this.bUx();
                EditVideoActivity.this.showToast(R.string.mix_fail);
                EditVideoActivity.this.finishPage();
            }
        });
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        J(bitmap);
    }

    private void LJ(String str) {
        this.liy.dbH();
        this.liy.dbI();
        this.liy.dbE().releaseSource();
        this.liD.LN(str);
    }

    private void LK(String str) {
        File file;
        this.liB = str;
        if (this.liC) {
            daW();
            return;
        }
        String str2 = c.lgV + file.getName();
        m.copyFile(new File(this.liB).getAbsolutePath(), str2);
        LL(str2);
        bUx();
        finishPage();
    }

    private void LL(String str) {
        try {
            new w(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.aY(this, str);
        } catch (Exception e) {
            bUx();
            this.liC = false;
        }
    }

    private void J(Bitmap bitmap) {
        if (this.liy == null || this.liz == null) {
            bUx();
            this.liC = false;
        } else if (this.Ks) {
            this.Ks = false;
        } else {
            if (!TextUtils.isEmpty(this.liy.getText())) {
                bitmap = this.liy.B(bitmap);
            }
            if (bitmap != null) {
                this.liz.b(bitmap, c.lgT);
            }
        }
    }
}
