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
    private boolean AJ;
    private String ald;
    private String eAC;
    private String fOd;
    private com.baidu.tbadk.core.view.b fgM;
    private h iZX;
    private int joX;
    private String joY;
    private List<VideoTitleData> joZ;
    private com.baidu.tieba.video.editvideo.view.a jpa;
    private SelectCoverModel jpb;
    private SelectMusicModel jpc;
    private String jpd;
    private String jpe;
    private boolean jpf;
    private com.baidu.tieba.video.editvideo.b.a jpg;
    private HttpMessageListener jph;
    private CustomMessageListener jpi;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.iZX = lVar.bMo();
        }
        this.jph = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.joZ = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.jpi = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.eAC = getIntent().getStringExtra("forum_id");
        this.joX = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.joY = getIntent().getStringExtra("video_title");
        this.fOd = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.ald = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.ald) && !new File(this.ald).exists()) {
            finishPage();
        }
        new File(c.jnt).mkdirs();
        this.jpb = new SelectCoverModel(getPageContext(), this, this.iZX);
        this.jpc = new SelectMusicModel(getPageContext(), this);
        this.jpg = new com.baidu.tieba.video.editvideo.b.a(this);
        this.jpg.a(this);
        this.jpa = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.iZX);
        this.jpa.setData(this.ald);
        this.jpa.ay(getIntent());
        this.jpa.a(this.jpg);
        this.jpa.setGenMaskCoverListener(this);
        this.jpb.crR();
        this.jpc.crS();
        this.fgM = new com.baidu.tbadk.core.view.b(getPageContext());
        this.fgM.it(R.string.mixing);
        registerListener(this.jpi);
        crp();
        registerListener(this.jph);
        cro();
        TiebaStatic.log("c12303");
    }

    private void crn() {
        this.AJ = true;
        this.jpe = null;
        this.jpd = null;
        bpI();
    }

    public void cro() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.eAC)) {
            httpMessage.addParam("forum_id", this.eAC);
        }
        sendMessage(httpMessage);
    }

    private void crp() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jpa.getRootView());
        if (this.jpa != null) {
            this.jpa.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jpa != null) {
            this.jpa.onPause();
        }
        if (this.jpg.cry()) {
            this.jpg.crz();
        }
        this.jpf = false;
        this.AJ = true;
        crn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jpa != null) {
            this.jpa.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.crM().crN();
        com.baidu.tieba.video.editvideo.model.b.crP().crQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jpa != null) {
            this.jpa.release();
        }
        if (this.jpb != null) {
            this.jpb.cancelLoadData();
        }
        if (this.jpc != null) {
            this.jpc.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jpa != null) {
            this.jpa.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        bpI();
        this.jpf = false;
        if (this.jpa != null && this.jpa.cse() != null) {
            this.jpa.cse().pause();
            this.jpa.cse().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void crq() {
        if (this.jpa == null || this.jpb == null || this.jpc == null) {
            bpI();
            this.jpf = false;
        } else if (!j.jS()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.jpf) {
            this.jpf = true;
            this.AJ = false;
            this.jpe = null;
            this.jpd = null;
            this.jpa.onPause();
            this.fgM.ef(true);
            crs();
        }
    }

    private void bpI() {
        if (this.fgM != null) {
            this.fgM.ef(false);
        }
    }

    private void crr() {
        if (this.AJ) {
            this.AJ = false;
        } else if (this.jpa.csl()) {
            this.jpc.e(this.ald, this.jpa.csj(), c.jns + "video_" + System.currentTimeMillis() + ".mp4", this.jpa.isMute() ? false : true);
        } else if (this.jpa.isMute()) {
            this.jpc.e(this.ald, null, c.jns + "video_" + System.currentTimeMillis() + ".mp4", this.jpa.isMute() ? false : true);
        } else {
            t(this.ald, -4399, "");
        }
    }

    private void crs() {
        if (this.AJ) {
            this.AJ = false;
            return;
        }
        String text = this.jpa.getText();
        if (TextUtils.isEmpty(text)) {
            this.jpb.bp(this.ald, this.jpa.getCurrentPosition());
        } else {
            this.jpb.BL(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void crt() {
        File file;
        this.AJ = false;
        if (this.jpa.csl() || this.jpa.isMute()) {
            this.jpf = false;
            this.fgM.ef(true);
            this.jpa.onPause();
            if (this.jpe != null) {
                t(this.jpe, -4399, "");
            } else {
                crr();
            }
        } else if (this.jpg.crx()) {
            this.jpf = false;
            this.jpa.onPause();
            this.fgM.ef(true);
            ET(this.ald);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.bQ(new File(this.ald).getAbsolutePath(), c.jnt + file.getName());
                EV(c.jnt + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bXA() {
        if (this.jpa == null || this.jpb == null) {
            bpI();
            this.jpf = false;
        } else if (this.AJ) {
            this.AJ = false;
        } else {
            this.jpb.bp(this.ald, this.jpa.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void BJ(String str) {
        if (this.AJ) {
            this.AJ = false;
        } else if (this.jpf) {
            showToast(str);
            bpI();
            this.jpf = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void H(Bitmap bitmap) {
        this.jpa.cse().L(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void ER(String str) {
        if (this.AJ) {
            this.AJ = false;
            return;
        }
        this.jpd = str;
        crr();
    }

    private void cru() {
        if (this.AJ) {
            this.AJ = false;
        } else if (!TextUtils.isEmpty(this.jpd) && !TextUtils.isEmpty(this.jpe)) {
            this.mVideoInfo.setVideoPath(this.jpe);
            this.mVideoInfo.setThumbPath(this.jpd);
            if (this.jpa.csl() && !TextUtils.isEmpty(this.jpa.csk())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.jpa.csk());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.fOd, this.eAC, this.mForumName, this.joY, 13003, this.mVideoInfo, this.mVideoTitleData, this.joZ);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            writeVideoActivityConfig.setProZone(this.joX);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            bpI();
            this.jpf = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(R.string.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(R.string.music_cloud)));
        this.jpa.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
        if (this.AJ) {
            this.AJ = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.mixing_fail);
            bpI();
            this.jpa.onResume();
            this.jpf = false;
            if (this.iZX != null) {
                this.iZX.ax(i, str2);
            }
        } else if (this.jpg.crx()) {
            ET(str);
        } else {
            EU(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void crv() {
        this.jpe = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void em(List<PendantData> list) {
        this.jpa.em(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String EY = com.baidu.tieba.video.editvideo.model.a.crM().EY(stringExtra);
                if (this.jpa != null && !TextUtils.isEmpty(EY)) {
                    this.jpa.es(EY, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ES(String str) {
        EU(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aK(int i, String str) {
        if (this.iZX != null) {
            this.iZX.ax(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aL(int i, String str) {
        if (this.iZX != null) {
            this.iZX.ax(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void d(Bitmap bitmap, boolean z) {
        I(bitmap);
    }

    private void ET(String str) {
        this.jpa.csh();
        this.jpa.csi();
        this.jpa.cse().releaseSource();
        this.jpg.EX(str);
    }

    private void EU(String str) {
        File file;
        this.jpe = str;
        if (this.jpf) {
            cru();
            return;
        }
        String str2 = c.jnt + file.getName();
        m.bQ(new File(this.jpe).getAbsolutePath(), str2);
        EV(str2);
        bpI();
        finishPage();
    }

    private void EV(String str) {
        try {
            new w(this).nE(str);
            com.baidu.tieba.video.editvideo.b.c.aK(this, str);
        } catch (Exception e) {
            bpI();
            this.jpf = false;
        }
    }

    private void I(Bitmap bitmap) {
        if (this.jpa == null || this.jpb == null) {
            bpI();
            this.jpf = false;
        } else if (this.AJ) {
            this.AJ = false;
        } else {
            if (!TextUtils.isEmpty(this.jpa.getText())) {
                bitmap = this.jpa.B(bitmap);
            }
            if (bitmap != null) {
                this.jpb.b(bitmap, c.jnr);
            }
        }
    }
}
