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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.f;
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
/* loaded from: classes2.dex */
public class EditVideoActivity extends BaseActivity implements a, b, b.a, MaskVideoView.b {
    private String bnE;
    private String cBR;
    private String dHS;
    private com.baidu.tbadk.core.view.a deF;
    private h gPa;
    private String hdk;
    private List<VideoTitleData> hdl;
    private com.baidu.tieba.video.editvideo.view.a hdm;
    private SelectCoverModel hdn;
    private SelectMusicModel hdo;
    private String hdp;
    private String hdq;
    private boolean hdr;
    private com.baidu.tieba.video.editvideo.b.a hds;
    private HttpMessageListener hdt;
    private CustomMessageListener hdu;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;
    private boolean zU;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.gPa = lVar.aVW();
        }
        this.hdt = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.hdl = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.hdu = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        setContentView(f.h.activity_edit_video);
        this.cBR = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.hdk = getIntent().getStringExtra("video_title");
        this.dHS = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.bnE = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.bnE) && !new File(this.bnE).exists()) {
            finishPage();
        }
        new File(c.hbF).mkdirs();
        this.hdn = new SelectCoverModel(getPageContext(), this, this.gPa);
        this.hdo = new SelectMusicModel(getPageContext(), this);
        this.hds = new com.baidu.tieba.video.editvideo.b.a(this);
        this.hds.a(this);
        this.hdm = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(f.g.root_layout), this.gPa);
        this.hdm.setData(this.bnE);
        this.hdm.aa(getIntent());
        this.hdm.a(this.hds);
        this.hdm.setGenMaskCoverListener(this);
        this.hdn.bBk();
        this.hdo.bBl();
        this.deF = new com.baidu.tbadk.core.view.a(getPageContext());
        this.deF.df(f.j.mixing);
        registerListener(this.hdu);
        bAG();
        registerListener(this.hdt);
        bAF();
        TiebaStatic.log("c12303");
    }

    private void bAE() {
        this.zU = true;
        this.hdq = null;
        this.hdp = null;
        aAe();
    }

    public void bAF() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.cBR)) {
            httpMessage.addParam("forum_id", this.cBR);
        }
        sendMessage(httpMessage);
    }

    private void bAG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.hdm.getRootView());
        if (this.hdm != null) {
            this.hdm.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hdm != null) {
            this.hdm.onPause();
        }
        if (this.hds.bAP()) {
            this.hds.bAQ();
        }
        this.hdr = false;
        this.zU = true;
        bAE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hdm != null) {
            this.hdm.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bBf().bBg();
        com.baidu.tieba.video.editvideo.model.b.bBi().bBj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hdm != null) {
            this.hdm.release();
        }
        if (this.hdn != null) {
            this.hdn.cancelLoadData();
        }
        if (this.hdo != null) {
            this.hdo.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hdm != null) {
            this.hdm.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        aAe();
        this.hdr = false;
        if (this.hdm != null && this.hdm.bBx() != null) {
            this.hdm.bBx().pause();
            this.hdm.bBx().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bAH() {
        if (this.hdm == null || this.hdn == null || this.hdo == null) {
            aAe();
            this.hdr = false;
        } else if (!j.jE()) {
            getPageContext().showToast(f.j.no_network);
        } else if (!this.hdr) {
            this.hdr = true;
            this.zU = false;
            this.hdq = null;
            this.hdp = null;
            this.hdm.onPause();
            this.deF.aN(true);
            bAJ();
        }
    }

    private void aAe() {
        if (this.deF != null) {
            this.deF.aN(false);
        }
    }

    private void bAI() {
        if (this.zU) {
            this.zU = false;
        } else if (this.hdm.bBE()) {
            this.hdo.c(this.bnE, this.hdm.bBC(), c.hbE + "video_" + System.currentTimeMillis() + ".mp4", this.hdm.isMute() ? false : true);
        } else if (this.hdm.isMute()) {
            this.hdo.c(this.bnE, null, c.hbE + "video_" + System.currentTimeMillis() + ".mp4", this.hdm.isMute() ? false : true);
        } else {
            m(this.bnE, -4399, "");
        }
    }

    private void bAJ() {
        if (this.zU) {
            this.zU = false;
            return;
        }
        String text = this.hdm.getText();
        if (TextUtils.isEmpty(text)) {
            this.hdn.aM(this.bnE, this.hdm.getCurrentPosition());
        } else {
            this.hdn.rM(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bAK() {
        File file;
        this.zU = false;
        if (this.hdm.bBE() || this.hdm.isMute()) {
            this.hdr = false;
            this.deF.aN(true);
            this.hdm.onPause();
            if (this.hdq != null) {
                m(this.hdq, -4399, "");
            } else {
                bAI();
            }
        } else if (this.hds.bAO()) {
            this.hdr = false;
            this.hdm.onPause();
            this.deF.aN(true);
            uJ(this.bnE);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.l.ab(new File(this.bnE).getAbsolutePath(), c.hbF + file.getName());
                uL(c.hbF + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bgM() {
        if (this.hdm == null || this.hdn == null) {
            aAe();
            this.hdr = false;
        } else if (this.zU) {
            this.zU = false;
        } else {
            this.hdn.aM(this.bnE, this.hdm.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void rK(String str) {
        if (this.zU) {
            this.zU = false;
        } else if (this.hdr) {
            showToast(str);
            aAe();
            this.hdr = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void x(Bitmap bitmap) {
        this.hdm.bBx().B(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void uH(String str) {
        if (this.zU) {
            this.zU = false;
            return;
        }
        this.hdp = str;
        bAI();
    }

    private void bAL() {
        if (this.zU) {
            this.zU = false;
        } else if (!TextUtils.isEmpty(this.hdp) && !TextUtils.isEmpty(this.hdq)) {
            this.mVideoInfo.setVideoPath(this.hdq);
            this.mVideoInfo.setThumbPath(this.hdp);
            if (this.hdm.bBE() && !TextUtils.isEmpty(this.hdm.bBD())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.hdm.bBD());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.dHS, this.cBR, this.mForumName, this.hdk, 13003, this.mVideoInfo, this.mVideoTitleData, this.hdl);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            aAe();
            this.hdr = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(f.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(f.j.music_cloud)));
        this.hdm.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void m(String str, int i, String str2) {
        if (this.zU) {
            this.zU = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(f.j.mixing_fail);
            aAe();
            this.hdm.onResume();
            this.hdr = false;
            if (this.gPa != null) {
                this.gPa.ad(i, str2);
            }
        } else if (this.hds.bAO()) {
            uJ(str);
        } else {
            uK(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bAM() {
        this.hdq = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dG(List<PendantData> list) {
        this.hdm.dG(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String uP = com.baidu.tieba.video.editvideo.model.a.bBf().uP(stringExtra);
                if (this.hdm != null && !TextUtils.isEmpty(uP)) {
                    this.hdm.cs(uP, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void uI(String str) {
        uK(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ap(int i, String str) {
        if (this.gPa != null) {
            this.gPa.ad(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aq(int i, String str) {
        if (this.gPa != null) {
            this.gPa.ad(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        y(bitmap);
    }

    private void uJ(String str) {
        this.hdm.bBA();
        this.hdm.bBB();
        this.hdm.bBx().releaseSource();
        this.hds.uN(str);
    }

    private void uK(String str) {
        File file;
        this.hdq = str;
        if (this.hdr) {
            bAL();
            return;
        }
        String str2 = c.hbF + file.getName();
        com.baidu.tbadk.core.util.l.ab(new File(this.hdq).getAbsolutePath(), str2);
        uL(str2);
        aAe();
        finishPage();
    }

    private void uL(String str) {
        try {
            new x(this).ez(str);
            com.baidu.tieba.video.editvideo.b.c.as(this, str);
        } catch (Exception e) {
            aAe();
            this.hdr = false;
        }
    }

    private void y(Bitmap bitmap) {
        if (this.hdm == null || this.hdn == null) {
            aAe();
            this.hdr = false;
        } else if (this.zU) {
            this.zU = false;
        } else {
            if (!TextUtils.isEmpty(this.hdm.getText())) {
                bitmap = this.hdm.r(bitmap);
            }
            if (bitmap != null) {
                this.hdn.b(bitmap, c.hbD);
            }
        }
    }
}
