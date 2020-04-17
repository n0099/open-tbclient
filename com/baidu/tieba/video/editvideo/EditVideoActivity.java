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
    private boolean Kp;
    private String aQf;
    private String eQf;
    private com.baidu.tbadk.core.view.a hzL;
    private String hzq;
    private h kTI;
    private HttpMessageListener liA;
    private CustomMessageListener liB;
    private int liq;
    private FrsTabInfoData lir;
    private String lis;
    private List<VideoTitleData> lit;
    private com.baidu.tieba.video.editvideo.view.a liu;
    private SelectCoverModel liv;
    private SelectMusicModel liw;
    private String lix;
    private boolean liy;
    private com.baidu.tieba.video.editvideo.b.a liz;
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
            this.kTI = lVar.csa();
        }
        this.liA = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.lit = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.liB = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.eQf = getIntent().getStringExtra("forum_id");
        this.liq = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.lis = getIntent().getStringExtra("video_title");
        this.hzq = getIntent().getStringExtra("KEY_CALL_FROM");
        this.aQf = getIntent().getStringExtra("from_type");
        this.mFrom = getIntent().getStringExtra("from");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.lir = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.lgR).mkdirs();
        this.liv = new SelectCoverModel(getPageContext(), this, this.kTI);
        this.liw = new SelectMusicModel(getPageContext(), this);
        this.liz = new com.baidu.tieba.video.editvideo.b.a(this);
        this.liz.a(this);
        this.liu = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.kTI);
        this.liu.setData(this.mVideoPath);
        this.liu.az(getIntent());
        this.liu.a(this.liz);
        this.liu.setGenMaskCoverListener(this);
        this.liv.dbv();
        this.liw.dbw();
        this.hzL = new com.baidu.tbadk.core.view.a(getPageContext());
        this.hzL.setTipString(R.string.mixing);
        registerListener(this.liB);
        daU();
        registerListener(this.liA);
        daT();
        TiebaStatic.log("c12303");
    }

    private void daS() {
        this.Kp = true;
        this.lix = null;
        this.mCoverPath = null;
        bUy();
    }

    public void daT() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.eQf)) {
            httpMessage.addParam("forum_id", this.eQf);
        }
        sendMessage(httpMessage);
    }

    private void daU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.liu.getRootView());
        if (this.liu != null) {
            this.liu.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.liu != null) {
            this.liu.onPause();
        }
        if (this.liz.dbd()) {
            this.liz.dbe();
        }
        this.liy = false;
        this.Kp = true;
        daS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.liu != null) {
            this.liu.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.dbq().dbr();
        com.baidu.tieba.video.editvideo.model.b.dbt().dbu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.liu != null) {
            this.liu.release();
        }
        if (this.liv != null) {
            this.liv.cancelLoadData();
        }
        if (this.liw != null) {
            this.liw.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.liu != null) {
            this.liu.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        bUy();
        this.liy = false;
        if (this.liu != null && this.liu.dbG() != null) {
            this.liu.dbG().pause();
            this.liu.dbG().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.liu == null || this.liv == null || this.liw == null) {
            bUy();
            this.liy = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.liy) {
            this.liy = true;
            this.Kp = false;
            this.lix = null;
            this.mCoverPath = null;
            this.liu.onPause();
            this.hzL.setDialogVisiable(true);
            daW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUy() {
        if (this.hzL != null) {
            this.hzL.setDialogVisiable(false);
        }
    }

    private void daV() {
        if (this.Kp) {
            this.Kp = false;
        } else if (this.liu.dbN()) {
            this.liw.h(this.mVideoPath, this.liu.dbL(), c.lgQ + "video_" + System.currentTimeMillis() + ".mp4", this.liu.isMute() ? false : true);
        } else if (this.liu.isMute()) {
            this.liw.h(this.mVideoPath, null, c.lgQ + "video_" + System.currentTimeMillis() + ".mp4", this.liu.isMute() ? false : true);
        } else {
            v(this.mVideoPath, -4399, "");
        }
    }

    private void daW() {
        if (this.Kp) {
            this.Kp = false;
            return;
        }
        String text = this.liu.getText();
        if (TextUtils.isEmpty(text)) {
            this.liv.bG(this.mVideoPath, this.liu.getCurrentPosition());
        } else {
            this.liv.Ii(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void daX() {
        File file;
        this.Kp = false;
        if (this.liu.dbN() || this.liu.isMute()) {
            this.liy = false;
            this.hzL.setDialogVisiable(true);
            this.liu.onPause();
            if (this.lix != null) {
                v(this.lix, -4399, "");
            } else {
                daV();
            }
        } else if (this.liz.dbc()) {
            this.liy = false;
            this.liu.onPause();
            this.hzL.setDialogVisiable(true);
            LG(this.mVideoPath);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.copyFile(new File(this.mVideoPath).getAbsolutePath(), c.lgR + file.getName());
                LI(c.lgR + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cFs() {
        if (this.liu == null || this.liv == null) {
            bUy();
            this.liy = false;
        } else if (this.Kp) {
            this.Kp = false;
        } else {
            this.liv.bG(this.mVideoPath, this.liu.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Ig(String str) {
        if (this.Kp) {
            this.Kp = false;
        } else if (this.liy) {
            showToast(str);
            bUy();
            this.liy = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void I(Bitmap bitmap) {
        this.liu.dbG().M(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void LE(String str) {
        if (this.Kp) {
            this.Kp = false;
            return;
        }
        this.mCoverPath = str;
        daV();
    }

    private void daY() {
        if (this.Kp) {
            this.Kp = false;
        } else if (TextUtils.isEmpty(this.mCoverPath) || TextUtils.isEmpty(this.lix)) {
        } else {
            m.a(new String[]{this.mCoverPath, this.lix}, new m.b() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
                @Override // com.baidu.tbadk.core.util.m.b
                public void C(HashMap<String, String> hashMap) {
                    EditVideoActivity.this.mVideoInfo.setVideoPath(EditVideoActivity.this.lix);
                    EditVideoActivity.this.mVideoInfo.setThumbPath(EditVideoActivity.this.mCoverPath);
                    if (hashMap != null) {
                        EditVideoActivity.this.mVideoInfo.setThumbUriStr(hashMap.get(EditVideoActivity.this.mCoverPath));
                        EditVideoActivity.this.mVideoInfo.setVideoUriStr(hashMap.get(EditVideoActivity.this.lix));
                    }
                    if (EditVideoActivity.this.liu.dbN() && !TextUtils.isEmpty(EditVideoActivity.this.liu.dbM())) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(EditVideoActivity.this.liu.dbM());
                        EditVideoActivity.this.mVideoInfo.setMusicListInfo(arrayList);
                    }
                    WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(EditVideoActivity.this.getPageContext().getPageActivity(), EditVideoActivity.this.hzq, EditVideoActivity.this.eQf, EditVideoActivity.this.mForumName, EditVideoActivity.this.lis, RequestResponseCode.REQUEST_WRITE_NEW, EditVideoActivity.this.mVideoInfo, EditVideoActivity.this.mVideoTitleData, EditVideoActivity.this.lit);
                    if (!StringUtils.isNull(EditVideoActivity.this.aQf)) {
                        writeVideoActivityConfig.addFromType(EditVideoActivity.this.aQf);
                    }
                    writeVideoActivityConfig.setProZone(EditVideoActivity.this.liq);
                    writeVideoActivityConfig.setFrom(EditVideoActivity.this.mFrom);
                    writeVideoActivityConfig.setFrsTabInfo(EditVideoActivity.this.lir);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
                    EditVideoActivity.this.bUy();
                    EditVideoActivity.this.liy = false;
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
        this.liu.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
        if (this.Kp) {
            this.Kp = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.mixing_fail);
            bUy();
            this.liu.onResume();
            this.liy = false;
            if (this.kTI != null) {
                this.kTI.bg(i, str2);
            }
        } else if (this.liz.dbc()) {
            LG(str);
        } else {
            LH(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void daZ() {
        this.lix = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void eE(List<PendantData> list) {
        this.liu.eE(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String LL = com.baidu.tieba.video.editvideo.model.a.dbq().LL(stringExtra);
                if (this.liu != null && !TextUtils.isEmpty(LL)) {
                    this.liu.eX(LL, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void LF(String str) {
        LH(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bu(int i, String str) {
        if (this.kTI != null) {
            this.kTI.bg(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void bv(int i, String str) {
        if (this.kTI != null) {
            this.kTI.bg(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void dba() {
        e.lb().post(new Runnable() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.4
            @Override // java.lang.Runnable
            public void run() {
                EditVideoActivity.this.bUy();
                EditVideoActivity.this.showToast(R.string.mix_fail);
                EditVideoActivity.this.finishPage();
            }
        });
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        J(bitmap);
    }

    private void LG(String str) {
        this.liu.dbJ();
        this.liu.dbK();
        this.liu.dbG().releaseSource();
        this.liz.LK(str);
    }

    private void LH(String str) {
        File file;
        this.lix = str;
        if (this.liy) {
            daY();
            return;
        }
        String str2 = c.lgR + file.getName();
        m.copyFile(new File(this.lix).getAbsolutePath(), str2);
        LI(str2);
        bUy();
        finishPage();
    }

    private void LI(String str) {
        try {
            new w(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.bk(this, str);
        } catch (Exception e) {
            bUy();
            this.liy = false;
        }
    }

    private void J(Bitmap bitmap) {
        if (this.liu == null || this.liv == null) {
            bUy();
            this.liy = false;
        } else if (this.Kp) {
            this.Kp = false;
        } else {
            if (!TextUtils.isEmpty(this.liu.getText())) {
                bitmap = this.liu.B(bitmap);
            }
            if (bitmap != null) {
                this.liv.b(bitmap, c.lgP);
            }
        }
    }
}
