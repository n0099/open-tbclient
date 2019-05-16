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
import com.baidu.tieba.R;
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
    private boolean AK;
    private String ald;
    private String eAB;
    private String fOa;
    private com.baidu.tbadk.core.view.b fgL;
    private h iZR;
    private int joS;
    private String joT;
    private List<VideoTitleData> joU;
    private com.baidu.tieba.video.editvideo.view.a joV;
    private SelectCoverModel joW;
    private SelectMusicModel joX;
    private String joY;
    private String joZ;
    private boolean jpa;
    private com.baidu.tieba.video.editvideo.b.a jpb;
    private HttpMessageListener jpc;
    private CustomMessageListener jpd;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.iZR = lVar.bMk();
        }
        this.jpc = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.joU = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.jpd = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.eAB = getIntent().getStringExtra("forum_id");
        this.joS = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.joT = getIntent().getStringExtra("video_title");
        this.fOa = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.ald = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.ald) && !new File(this.ald).exists()) {
            finishPage();
        }
        new File(c.jno).mkdirs();
        this.joW = new SelectCoverModel(getPageContext(), this, this.iZR);
        this.joX = new SelectMusicModel(getPageContext(), this);
        this.jpb = new com.baidu.tieba.video.editvideo.b.a(this);
        this.jpb.a(this);
        this.joV = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.iZR);
        this.joV.setData(this.ald);
        this.joV.ay(getIntent());
        this.joV.a(this.jpb);
        this.joV.setGenMaskCoverListener(this);
        this.joW.crQ();
        this.joX.crR();
        this.fgL = new com.baidu.tbadk.core.view.b(getPageContext());
        this.fgL.it(R.string.mixing);
        registerListener(this.jpd);
        crm();
        registerListener(this.jpc);
        crl();
        TiebaStatic.log("c12303");
    }

    private void crk() {
        this.AK = true;
        this.joZ = null;
        this.joY = null;
        bpD();
    }

    public void crl() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.eAB)) {
            httpMessage.addParam("forum_id", this.eAB);
        }
        sendMessage(httpMessage);
    }

    private void crm() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.joV.getRootView());
        if (this.joV != null) {
            this.joV.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.joV != null) {
            this.joV.onPause();
        }
        if (this.jpb.crv()) {
            this.jpb.crw();
        }
        this.jpa = false;
        this.AK = true;
        crk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.joV != null) {
            this.joV.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.crL().crM();
        com.baidu.tieba.video.editvideo.model.b.crO().crP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.joV != null) {
            this.joV.release();
        }
        if (this.joW != null) {
            this.joW.cancelLoadData();
        }
        if (this.joX != null) {
            this.joX.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.joV != null) {
            this.joV.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        bpD();
        this.jpa = false;
        if (this.joV != null && this.joV.csd() != null) {
            this.joV.csd().pause();
            this.joV.csd().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void crn() {
        if (this.joV == null || this.joW == null || this.joX == null) {
            bpD();
            this.jpa = false;
        } else if (!j.jS()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.jpa) {
            this.jpa = true;
            this.AK = false;
            this.joZ = null;
            this.joY = null;
            this.joV.onPause();
            this.fgL.ef(true);
            crp();
        }
    }

    private void bpD() {
        if (this.fgL != null) {
            this.fgL.ef(false);
        }
    }

    private void cro() {
        if (this.AK) {
            this.AK = false;
        } else if (this.joV.csk()) {
            this.joX.e(this.ald, this.joV.csi(), c.jnn + "video_" + System.currentTimeMillis() + ".mp4", this.joV.isMute() ? false : true);
        } else if (this.joV.isMute()) {
            this.joX.e(this.ald, null, c.jnn + "video_" + System.currentTimeMillis() + ".mp4", this.joV.isMute() ? false : true);
        } else {
            t(this.ald, -4399, "");
        }
    }

    private void crp() {
        if (this.AK) {
            this.AK = false;
            return;
        }
        String text = this.joV.getText();
        if (TextUtils.isEmpty(text)) {
            this.joW.bp(this.ald, this.joV.getCurrentPosition());
        } else {
            this.joW.BJ(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void crq() {
        File file;
        this.AK = false;
        if (this.joV.csk() || this.joV.isMute()) {
            this.jpa = false;
            this.fgL.ef(true);
            this.joV.onPause();
            if (this.joZ != null) {
                t(this.joZ, -4399, "");
            } else {
                cro();
            }
        } else if (this.jpb.cru()) {
            this.jpa = false;
            this.joV.onPause();
            this.fgL.ef(true);
            ER(this.ald);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.bQ(new File(this.ald).getAbsolutePath(), c.jno + file.getName());
                ET(c.jno + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bXw() {
        if (this.joV == null || this.joW == null) {
            bpD();
            this.jpa = false;
        } else if (this.AK) {
            this.AK = false;
        } else {
            this.joW.bp(this.ald, this.joV.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void BH(String str) {
        if (this.AK) {
            this.AK = false;
        } else if (this.jpa) {
            showToast(str);
            bpD();
            this.jpa = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void H(Bitmap bitmap) {
        this.joV.csd().L(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void EP(String str) {
        if (this.AK) {
            this.AK = false;
            return;
        }
        this.joY = str;
        cro();
    }

    private void crr() {
        if (this.AK) {
            this.AK = false;
        } else if (!TextUtils.isEmpty(this.joY) && !TextUtils.isEmpty(this.joZ)) {
            this.mVideoInfo.setVideoPath(this.joZ);
            this.mVideoInfo.setThumbPath(this.joY);
            if (this.joV.csk() && !TextUtils.isEmpty(this.joV.csj())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.joV.csj());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.fOa, this.eAB, this.mForumName, this.joT, 13003, this.mVideoInfo, this.mVideoTitleData, this.joU);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            writeVideoActivityConfig.setProZone(this.joS);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            bpD();
            this.jpa = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(R.string.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(R.string.music_cloud)));
        this.joV.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
        if (this.AK) {
            this.AK = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.mixing_fail);
            bpD();
            this.joV.onResume();
            this.jpa = false;
            if (this.iZR != null) {
                this.iZR.ax(i, str2);
            }
        } else if (this.jpb.cru()) {
            ER(str);
        } else {
            ES(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void crs() {
        this.joZ = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void em(List<PendantData> list) {
        this.joV.em(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String EW = com.baidu.tieba.video.editvideo.model.a.crL().EW(stringExtra);
                if (this.joV != null && !TextUtils.isEmpty(EW)) {
                    this.joV.es(EW, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void EQ(String str) {
        ES(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aK(int i, String str) {
        if (this.iZR != null) {
            this.iZR.ax(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aL(int i, String str) {
        if (this.iZR != null) {
            this.iZR.ax(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void d(Bitmap bitmap, boolean z) {
        I(bitmap);
    }

    private void ER(String str) {
        this.joV.csg();
        this.joV.csh();
        this.joV.csd().releaseSource();
        this.jpb.EV(str);
    }

    private void ES(String str) {
        File file;
        this.joZ = str;
        if (this.jpa) {
            crr();
            return;
        }
        String str2 = c.jno + file.getName();
        m.bQ(new File(this.joZ).getAbsolutePath(), str2);
        ET(str2);
        bpD();
        finishPage();
    }

    private void ET(String str) {
        try {
            new w(this).nF(str);
            com.baidu.tieba.video.editvideo.b.c.aK(this, str);
        } catch (Exception e) {
            bpD();
            this.jpa = false;
        }
    }

    private void I(Bitmap bitmap) {
        if (this.joV == null || this.joW == null) {
            bpD();
            this.jpa = false;
        } else if (this.AK) {
            this.AK = false;
        } else {
            if (!TextUtils.isEmpty(this.joV.getText())) {
                bitmap = this.joV.B(bitmap);
            }
            if (bitmap != null) {
                this.joW.b(bitmap, c.jnm);
            }
        }
    }
}
