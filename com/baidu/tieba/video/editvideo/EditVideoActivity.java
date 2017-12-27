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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.i.h;
import com.baidu.tieba.i.k;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.video.editvideo.b.b;
import com.baidu.tieba.video.editvideo.b.c;
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
    private boolean ajz;
    private String bQX;
    private String cSk;
    private com.baidu.tbadk.core.view.b dOk;
    private h hjJ;
    private String hyi;
    private List<VideoTitleData> hyj;
    private com.baidu.tieba.video.editvideo.view.a hyk;
    private SelectCoverModel hyl;
    private SelectMusicModel hym;
    private String hyn;
    private String hyo;
    private boolean hyp;
    private com.baidu.tieba.video.editvideo.b.a hyq;
    private String hyr;
    private HttpMessageListener hys;
    private CustomMessageListener hyt;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.hjJ = kVar.aVn();
        }
        this.hys = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.hyj = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.hyt = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.cSk = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.hyi = getIntent().getStringExtra("video_title");
        this.hyr = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.bQX = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.bQX) && !new File(this.bQX).exists()) {
            finishPage();
        }
        new File(com.baidu.tieba.video.b.hwF).mkdirs();
        this.hyl = new SelectCoverModel(getPageContext(), this, this.hjJ);
        this.hym = new SelectMusicModel(getPageContext(), this);
        this.hyq = new com.baidu.tieba.video.editvideo.b.a(this);
        this.hyq.a(this);
        this.hyk = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.g.root_layout), this.hjJ);
        this.hyk.setData(this.bQX);
        this.hyk.ae(getIntent());
        this.hyk.a(this.hyq);
        this.hyk.setGenMaskCoverListener(this);
        this.hyl.bHB();
        this.hym.bHC();
        this.dOk = new com.baidu.tbadk.core.view.b(getPageContext());
        this.dOk.ga(d.j.mixing);
        registerListener(this.hyt);
        bGW();
        registerListener(this.hys);
        bGV();
        TiebaStatic.log("c12303");
    }

    private void bGU() {
        this.ajz = true;
        this.hyo = null;
        this.hyn = null;
        axJ();
    }

    public void bGV() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.cSk)) {
            httpMessage.addParam("forum_id", this.cSk);
        }
        sendMessage(httpMessage);
    }

    private void bGW() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().aM(i == 1);
        getLayoutMode().aM(this.hyk.getRootView());
        if (this.hyk != null) {
            this.hyk.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hyk != null) {
            this.hyk.onPause();
        }
        if (this.hyq.bHf()) {
            this.hyq.bHg();
        }
        this.hyp = false;
        this.ajz = true;
        bGU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hyk != null) {
            this.hyk.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bHw().bHx();
        com.baidu.tieba.video.editvideo.model.b.bHz().bHA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hyk != null) {
            this.hyk.release();
        }
        if (this.hyl != null) {
            this.hyl.cancelLoadData();
        }
        if (this.hym != null) {
            this.hym.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hyk != null) {
            this.hyk.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        axJ();
        this.hyp = false;
        com.baidu.tbadk.core.util.k.s(new File(com.baidu.tieba.video.b.hwE));
        if (this.hyk != null && this.hyk.bHO() != null) {
            this.hyk.bHO().pause();
            this.hyk.bHO().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bGX() {
        if (this.hyk != null && this.hyl != null && this.hym != null) {
            if (!j.oI()) {
                getPageContext().showToast(d.j.no_network);
            } else if (!this.hyp) {
                this.hyp = true;
                this.ajz = false;
                this.hyo = null;
                this.hyn = null;
                this.hyk.onPause();
                this.dOk.bm(true);
                bGZ();
            }
        }
    }

    private void axJ() {
        if (this.dOk != null) {
            this.dOk.bm(false);
        }
    }

    private void bGY() {
        if (this.ajz) {
            this.ajz = false;
        } else if (this.hyk.bHV()) {
            this.hym.c(this.bQX, this.hyk.bHT(), com.baidu.tieba.video.b.hwE + "video_" + System.currentTimeMillis() + ".mp4", this.hyk.isMute() ? false : true);
        } else if (this.hyk.isMute()) {
            this.hym.c(this.bQX, null, com.baidu.tieba.video.b.hwE + "video_" + System.currentTimeMillis() + ".mp4", this.hyk.isMute() ? false : true);
        } else {
            n(this.bQX, -4399, "");
        }
    }

    private void bGZ() {
        if (this.ajz) {
            this.ajz = false;
            return;
        }
        String text = this.hyk.getText();
        if (TextUtils.isEmpty(text)) {
            this.hyl.aI(this.bQX, this.hyk.getCurrentPosition());
        } else {
            this.hyl.qB(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bHa() {
        File file;
        this.ajz = false;
        if (this.hyk.bHV() || this.hyk.isMute()) {
            this.hyp = false;
            this.dOk.bm(true);
            this.hyk.onPause();
            if (this.hyo != null) {
                n(this.hyo, -4399, "");
            } else {
                bGY();
            }
        } else if (this.hyq.bHe()) {
            this.hyp = false;
            this.hyk.onPause();
            this.dOk.bm(true);
            ua(this.bQX);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.k.Y(new File(this.bQX).getAbsolutePath(), com.baidu.tieba.video.b.hwF + file.getName());
                uc(com.baidu.tieba.video.b.hwF + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bgw() {
        if (this.hyk == null || this.hyl == null) {
            axJ();
            this.hyp = false;
        } else if (this.ajz) {
            this.ajz = false;
        } else {
            this.hyl.aI(this.bQX, this.hyk.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void qz(String str) {
        if (this.ajz) {
            this.ajz = false;
        } else if (this.hyp) {
            showToast(str);
            axJ();
            this.hyp = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void s(Bitmap bitmap) {
        this.hyk.bHO().w(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void tY(String str) {
        if (this.ajz) {
            this.ajz = false;
            return;
        }
        this.hyn = str;
        bGY();
    }

    private void bHb() {
        if (this.ajz) {
            this.ajz = false;
        } else if (!TextUtils.isEmpty(this.hyn) && !TextUtils.isEmpty(this.hyo)) {
            this.mVideoInfo.setVideoPath(this.hyo);
            this.mVideoInfo.setThumbPath(this.hyn);
            if (this.hyk.bHV() && !TextUtils.isEmpty(this.hyk.bHU())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.hyk.bHU());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.hyr, this.cSk, this.mForumName, this.hyi, 13003, this.mVideoInfo, this.mVideoTitleData, this.hyj);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
            axJ();
            this.hyp = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.j.music_cloud)));
        this.hyk.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
        if (this.ajz) {
            this.ajz = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.j.mixing_fail);
            axJ();
            this.hyk.onResume();
            this.hyp = false;
            if (this.hjJ != null) {
                this.hjJ.R(i, str2);
            }
        } else if (this.hyq.bHe()) {
            ua(str);
        } else {
            ub(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bHc() {
        this.hyo = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dT(List<PendantData> list) {
        this.hyk.dT(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String ug = com.baidu.tieba.video.editvideo.model.a.bHw().ug(stringExtra);
                if (this.hyk != null && !TextUtils.isEmpty(ug)) {
                    this.hyk.cp(ug, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void tZ(String str) {
        ub(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ai(int i, String str) {
        if (this.hjJ != null) {
            this.hjJ.R(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aj(int i, String str) {
        if (this.hjJ != null) {
            this.hjJ.R(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        t(bitmap);
    }

    private void ua(String str) {
        this.hyk.bHR();
        this.hyk.bHS();
        this.hyk.bHO().releaseSource();
        this.hyq.ue(str);
    }

    private void ub(String str) {
        File file;
        this.hyo = str;
        if (this.hyp) {
            bHb();
            return;
        }
        String str2 = com.baidu.tieba.video.b.hwF + file.getName();
        com.baidu.tbadk.core.util.k.Y(new File(this.hyo).getAbsolutePath(), str2);
        uc(str2);
        axJ();
        finishPage();
    }

    private void uc(String str) {
        try {
            new w(this).dP(str);
            c.aq(this, str);
        } catch (Exception e) {
        }
    }

    private void t(Bitmap bitmap) {
        if (this.hyk == null || this.hyl == null) {
            axJ();
        } else if (this.ajz) {
            this.ajz = false;
        } else {
            if (!TextUtils.isEmpty(this.hyk.getText())) {
                bitmap = this.hyk.m(bitmap);
            }
            if (bitmap != null) {
                this.hyl.b(bitmap, com.baidu.tieba.video.b.hwD);
            }
        }
    }
}
