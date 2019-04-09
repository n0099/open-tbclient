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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.j.h;
import com.baidu.tieba.j.l;
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
import java.util.List;
/* loaded from: classes5.dex */
public class EditVideoActivity extends BaseActivity implements a, b, b.a, MaskVideoView.b {
    private boolean Dc;
    private String akR;
    private com.baidu.tbadk.core.view.b eQD;
    private String ekN;
    private String fxi;
    private h iGY;
    private int iVV;
    private String iVW;
    private List<VideoTitleData> iVX;
    private com.baidu.tieba.video.editvideo.view.a iVY;
    private SelectCoverModel iVZ;
    private SelectMusicModel iWa;
    private String iWb;
    private String iWc;
    private boolean iWd;
    private com.baidu.tieba.video.editvideo.b.a iWe;
    private HttpMessageListener iWf;
    private CustomMessageListener iWg;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.iGY = lVar.bEz();
        }
        this.iWf = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.iVX = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.iWg = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        setContentView(d.h.activity_edit_video);
        this.ekN = getIntent().getStringExtra("forum_id");
        this.iVV = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.iVW = getIntent().getStringExtra("video_title");
        this.fxi = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.akR = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.akR) && !new File(this.akR).exists()) {
            finishPage();
        }
        new File(c.iUr).mkdirs();
        this.iVZ = new SelectCoverModel(getPageContext(), this, this.iGY);
        this.iWa = new SelectMusicModel(getPageContext(), this);
        this.iWe = new com.baidu.tieba.video.editvideo.b.a(this);
        this.iWe.a(this);
        this.iVY = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.g.root_layout), this.iGY);
        this.iVY.setData(this.akR);
        this.iVY.av(getIntent());
        this.iVY.a(this.iWe);
        this.iVY.setGenMaskCoverListener(this);
        this.iVZ.cjN();
        this.iWa.cjO();
        this.eQD = new com.baidu.tbadk.core.view.b(getPageContext());
        this.eQD.hF(d.j.mixing);
        registerListener(this.iWg);
        cjj();
        registerListener(this.iWf);
        cji();
        TiebaStatic.log("c12303");
    }

    private void cjh() {
        this.Dc = true;
        this.iWc = null;
        this.iWb = null;
        bin();
    }

    public void cji() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.ekN)) {
            httpMessage.addParam("forum_id", this.ekN);
        }
        sendMessage(httpMessage);
    }

    private void cjj() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iVY.getRootView());
        if (this.iVY != null) {
            this.iVY.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.iVY != null) {
            this.iVY.onPause();
        }
        if (this.iWe.cjs()) {
            this.iWe.cjt();
        }
        this.iWd = false;
        this.Dc = true;
        cjh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iVY != null) {
            this.iVY.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.cjI().cjJ();
        com.baidu.tieba.video.editvideo.model.b.cjL().cjM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iVY != null) {
            this.iVY.release();
        }
        if (this.iVZ != null) {
            this.iVZ.cancelLoadData();
        }
        if (this.iWa != null) {
            this.iWa.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.iVY != null) {
            this.iVY.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        bin();
        this.iWd = false;
        if (this.iVY != null && this.iVY.cka() != null) {
            this.iVY.cka().pause();
            this.iVY.cka().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cjk() {
        if (this.iVY == null || this.iVZ == null || this.iWa == null) {
            bin();
            this.iWd = false;
        } else if (!j.kY()) {
            getPageContext().showToast(d.j.no_network);
        } else if (!this.iWd) {
            this.iWd = true;
            this.Dc = false;
            this.iWc = null;
            this.iWb = null;
            this.iVY.onPause();
            this.eQD.dJ(true);
            cjm();
        }
    }

    private void bin() {
        if (this.eQD != null) {
            this.eQD.dJ(false);
        }
    }

    private void cjl() {
        if (this.Dc) {
            this.Dc = false;
        } else if (this.iVY.ckh()) {
            this.iWa.e(this.akR, this.iVY.ckf(), c.iUq + "video_" + System.currentTimeMillis() + ".mp4", this.iVY.isMute() ? false : true);
        } else if (this.iVY.isMute()) {
            this.iWa.e(this.akR, null, c.iUq + "video_" + System.currentTimeMillis() + ".mp4", this.iVY.isMute() ? false : true);
        } else {
            p(this.akR, -4399, "");
        }
    }

    private void cjm() {
        if (this.Dc) {
            this.Dc = false;
            return;
        }
        String text = this.iVY.getText();
        if (TextUtils.isEmpty(text)) {
            this.iVZ.bt(this.akR, this.iVY.getCurrentPosition());
        } else {
            this.iVZ.At(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cjn() {
        File file;
        this.Dc = false;
        if (this.iVY.ckh() || this.iVY.isMute()) {
            this.iWd = false;
            this.eQD.dJ(true);
            this.iVY.onPause();
            if (this.iWc != null) {
                p(this.iWc, -4399, "");
            } else {
                cjl();
            }
        } else if (this.iWe.cjr()) {
            this.iWd = false;
            this.iVY.onPause();
            this.eQD.dJ(true);
            Dv(this.akR);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.bG(new File(this.akR).getAbsolutePath(), c.iUr + file.getName());
                Dx(c.iUr + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bPD() {
        if (this.iVY == null || this.iVZ == null) {
            bin();
            this.iWd = false;
        } else if (this.Dc) {
            this.Dc = false;
        } else {
            this.iVZ.bt(this.akR, this.iVY.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Ar(String str) {
        if (this.Dc) {
            this.Dc = false;
        } else if (this.iWd) {
            showToast(str);
            bin();
            this.iWd = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void G(Bitmap bitmap) {
        this.iVY.cka().K(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Dt(String str) {
        if (this.Dc) {
            this.Dc = false;
            return;
        }
        this.iWb = str;
        cjl();
    }

    private void cjo() {
        if (this.Dc) {
            this.Dc = false;
        } else if (!TextUtils.isEmpty(this.iWb) && !TextUtils.isEmpty(this.iWc)) {
            this.mVideoInfo.setVideoPath(this.iWc);
            this.mVideoInfo.setThumbPath(this.iWb);
            if (this.iVY.ckh() && !TextUtils.isEmpty(this.iVY.ckg())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.iVY.ckg());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.fxi, this.ekN, this.mForumName, this.iVW, 13003, this.mVideoInfo, this.mVideoTitleData, this.iVX);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            writeVideoActivityConfig.setProZone(this.iVV);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            bin();
            this.iWd = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.j.music_cloud)));
        this.iVY.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void p(String str, int i, String str2) {
        if (this.Dc) {
            this.Dc = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.j.mixing_fail);
            bin();
            this.iVY.onResume();
            this.iWd = false;
            if (this.iGY != null) {
                this.iGY.au(i, str2);
            }
        } else if (this.iWe.cjr()) {
            Dv(str);
        } else {
            Dw(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cjp() {
        this.iWc = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void ec(List<PendantData> list) {
        this.iVY.ec(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String DA = com.baidu.tieba.video.editvideo.model.a.cjI().DA(stringExtra);
                if (this.iVY != null && !TextUtils.isEmpty(DA)) {
                    this.iVY.ef(DA, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void Du(String str) {
        Dw(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aH(int i, String str) {
        if (this.iGY != null) {
            this.iGY.au(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aI(int i, String str) {
        if (this.iGY != null) {
            this.iGY.au(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        H(bitmap);
    }

    private void Dv(String str) {
        this.iVY.ckd();
        this.iVY.cke();
        this.iVY.cka().releaseSource();
        this.iWe.Dz(str);
    }

    private void Dw(String str) {
        File file;
        this.iWc = str;
        if (this.iWd) {
            cjo();
            return;
        }
        String str2 = c.iUr + file.getName();
        m.bG(new File(this.iWc).getAbsolutePath(), str2);
        Dx(str2);
        bin();
        finishPage();
    }

    private void Dx(String str) {
        try {
            new w(this).mx(str);
            com.baidu.tieba.video.editvideo.b.c.aW(this, str);
        } catch (Exception e) {
            bin();
            this.iWd = false;
        }
    }

    private void H(Bitmap bitmap) {
        if (this.iVY == null || this.iVZ == null) {
            bin();
            this.iWd = false;
        } else if (this.Dc) {
            this.Dc = false;
        } else {
            if (!TextUtils.isEmpty(this.iVY.getText())) {
                bitmap = this.iVY.A(bitmap);
            }
            if (bitmap != null) {
                this.iVZ.b(bitmap, c.iUp);
            }
        }
    }
}
