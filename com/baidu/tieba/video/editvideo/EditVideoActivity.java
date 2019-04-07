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
    private String akQ;
    private com.baidu.tbadk.core.view.b eQC;
    private String ekM;
    private String fxi;
    private h iGX;
    private int iVU;
    private String iVV;
    private List<VideoTitleData> iVW;
    private com.baidu.tieba.video.editvideo.view.a iVX;
    private SelectCoverModel iVY;
    private SelectMusicModel iVZ;
    private String iWa;
    private String iWb;
    private boolean iWc;
    private com.baidu.tieba.video.editvideo.b.a iWd;
    private HttpMessageListener iWe;
    private CustomMessageListener iWf;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.iGX = lVar.bEz();
        }
        this.iWe = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.iVW = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.iWf = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.ekM = getIntent().getStringExtra("forum_id");
        this.iVU = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.iVV = getIntent().getStringExtra("video_title");
        this.fxi = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.akQ = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.akQ) && !new File(this.akQ).exists()) {
            finishPage();
        }
        new File(c.iUq).mkdirs();
        this.iVY = new SelectCoverModel(getPageContext(), this, this.iGX);
        this.iVZ = new SelectMusicModel(getPageContext(), this);
        this.iWd = new com.baidu.tieba.video.editvideo.b.a(this);
        this.iWd.a(this);
        this.iVX = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.g.root_layout), this.iGX);
        this.iVX.setData(this.akQ);
        this.iVX.av(getIntent());
        this.iVX.a(this.iWd);
        this.iVX.setGenMaskCoverListener(this);
        this.iVY.cjN();
        this.iVZ.cjO();
        this.eQC = new com.baidu.tbadk.core.view.b(getPageContext());
        this.eQC.hF(d.j.mixing);
        registerListener(this.iWf);
        cjj();
        registerListener(this.iWe);
        cji();
        TiebaStatic.log("c12303");
    }

    private void cjh() {
        this.Dc = true;
        this.iWb = null;
        this.iWa = null;
        bin();
    }

    public void cji() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.ekM)) {
            httpMessage.addParam("forum_id", this.ekM);
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
        getLayoutMode().onModeChanged(this.iVX.getRootView());
        if (this.iVX != null) {
            this.iVX.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.iVX != null) {
            this.iVX.onPause();
        }
        if (this.iWd.cjs()) {
            this.iWd.cjt();
        }
        this.iWc = false;
        this.Dc = true;
        cjh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iVX != null) {
            this.iVX.onResume();
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
        if (this.iVX != null) {
            this.iVX.release();
        }
        if (this.iVY != null) {
            this.iVY.cancelLoadData();
        }
        if (this.iVZ != null) {
            this.iVZ.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.iVX != null) {
            this.iVX.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        bin();
        this.iWc = false;
        if (this.iVX != null && this.iVX.cka() != null) {
            this.iVX.cka().pause();
            this.iVX.cka().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cjk() {
        if (this.iVX == null || this.iVY == null || this.iVZ == null) {
            bin();
            this.iWc = false;
        } else if (!j.kY()) {
            getPageContext().showToast(d.j.no_network);
        } else if (!this.iWc) {
            this.iWc = true;
            this.Dc = false;
            this.iWb = null;
            this.iWa = null;
            this.iVX.onPause();
            this.eQC.dJ(true);
            cjm();
        }
    }

    private void bin() {
        if (this.eQC != null) {
            this.eQC.dJ(false);
        }
    }

    private void cjl() {
        if (this.Dc) {
            this.Dc = false;
        } else if (this.iVX.ckh()) {
            this.iVZ.e(this.akQ, this.iVX.ckf(), c.iUp + "video_" + System.currentTimeMillis() + ".mp4", this.iVX.isMute() ? false : true);
        } else if (this.iVX.isMute()) {
            this.iVZ.e(this.akQ, null, c.iUp + "video_" + System.currentTimeMillis() + ".mp4", this.iVX.isMute() ? false : true);
        } else {
            p(this.akQ, -4399, "");
        }
    }

    private void cjm() {
        if (this.Dc) {
            this.Dc = false;
            return;
        }
        String text = this.iVX.getText();
        if (TextUtils.isEmpty(text)) {
            this.iVY.bt(this.akQ, this.iVX.getCurrentPosition());
        } else {
            this.iVY.At(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cjn() {
        File file;
        this.Dc = false;
        if (this.iVX.ckh() || this.iVX.isMute()) {
            this.iWc = false;
            this.eQC.dJ(true);
            this.iVX.onPause();
            if (this.iWb != null) {
                p(this.iWb, -4399, "");
            } else {
                cjl();
            }
        } else if (this.iWd.cjr()) {
            this.iWc = false;
            this.iVX.onPause();
            this.eQC.dJ(true);
            Dv(this.akQ);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.bG(new File(this.akQ).getAbsolutePath(), c.iUq + file.getName());
                Dx(c.iUq + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bPD() {
        if (this.iVX == null || this.iVY == null) {
            bin();
            this.iWc = false;
        } else if (this.Dc) {
            this.Dc = false;
        } else {
            this.iVY.bt(this.akQ, this.iVX.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Ar(String str) {
        if (this.Dc) {
            this.Dc = false;
        } else if (this.iWc) {
            showToast(str);
            bin();
            this.iWc = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void G(Bitmap bitmap) {
        this.iVX.cka().K(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Dt(String str) {
        if (this.Dc) {
            this.Dc = false;
            return;
        }
        this.iWa = str;
        cjl();
    }

    private void cjo() {
        if (this.Dc) {
            this.Dc = false;
        } else if (!TextUtils.isEmpty(this.iWa) && !TextUtils.isEmpty(this.iWb)) {
            this.mVideoInfo.setVideoPath(this.iWb);
            this.mVideoInfo.setThumbPath(this.iWa);
            if (this.iVX.ckh() && !TextUtils.isEmpty(this.iVX.ckg())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.iVX.ckg());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.fxi, this.ekM, this.mForumName, this.iVV, 13003, this.mVideoInfo, this.mVideoTitleData, this.iVW);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            writeVideoActivityConfig.setProZone(this.iVU);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            bin();
            this.iWc = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.j.music_cloud)));
        this.iVX.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void p(String str, int i, String str2) {
        if (this.Dc) {
            this.Dc = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.j.mixing_fail);
            bin();
            this.iVX.onResume();
            this.iWc = false;
            if (this.iGX != null) {
                this.iGX.au(i, str2);
            }
        } else if (this.iWd.cjr()) {
            Dv(str);
        } else {
            Dw(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cjp() {
        this.iWb = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void ec(List<PendantData> list) {
        this.iVX.ec(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String DA = com.baidu.tieba.video.editvideo.model.a.cjI().DA(stringExtra);
                if (this.iVX != null && !TextUtils.isEmpty(DA)) {
                    this.iVX.ef(DA, stringExtra2);
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
        if (this.iGX != null) {
            this.iGX.au(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aI(int i, String str) {
        if (this.iGX != null) {
            this.iGX.au(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        H(bitmap);
    }

    private void Dv(String str) {
        this.iVX.ckd();
        this.iVX.cke();
        this.iVX.cka().releaseSource();
        this.iWd.Dz(str);
    }

    private void Dw(String str) {
        File file;
        this.iWb = str;
        if (this.iWc) {
            cjo();
            return;
        }
        String str2 = c.iUq + file.getName();
        m.bG(new File(this.iWb).getAbsolutePath(), str2);
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
            this.iWc = false;
        }
    }

    private void H(Bitmap bitmap) {
        if (this.iVX == null || this.iVY == null) {
            bin();
            this.iWc = false;
        } else if (this.Dc) {
            this.Dc = false;
        } else {
            if (!TextUtils.isEmpty(this.iVX.getText())) {
                bitmap = this.iVX.A(bitmap);
            }
            if (bitmap != null) {
                this.iVY.b(bitmap, c.iUo);
            }
        }
    }
}
