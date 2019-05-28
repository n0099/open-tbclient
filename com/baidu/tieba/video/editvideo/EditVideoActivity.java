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
    private String eAC;
    private String fOb;
    private com.baidu.tbadk.core.view.b fgM;
    private h iZT;
    private int joT;
    private String joU;
    private List<VideoTitleData> joV;
    private com.baidu.tieba.video.editvideo.view.a joW;
    private SelectCoverModel joX;
    private SelectMusicModel joY;
    private String joZ;
    private String jpa;
    private boolean jpb;
    private com.baidu.tieba.video.editvideo.b.a jpc;
    private HttpMessageListener jpd;
    private CustomMessageListener jpe;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.iZT = lVar.bMn();
        }
        this.jpd = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.joV = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.jpe = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.joT = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.joU = getIntent().getStringExtra("video_title");
        this.fOb = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.ald = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.ald) && !new File(this.ald).exists()) {
            finishPage();
        }
        new File(c.jnp).mkdirs();
        this.joX = new SelectCoverModel(getPageContext(), this, this.iZT);
        this.joY = new SelectMusicModel(getPageContext(), this);
        this.jpc = new com.baidu.tieba.video.editvideo.b.a(this);
        this.jpc.a(this);
        this.joW = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.iZT);
        this.joW.setData(this.ald);
        this.joW.ay(getIntent());
        this.joW.a(this.jpc);
        this.joW.setGenMaskCoverListener(this);
        this.joX.crS();
        this.joY.crT();
        this.fgM = new com.baidu.tbadk.core.view.b(getPageContext());
        this.fgM.it(R.string.mixing);
        registerListener(this.jpe);
        cro();
        registerListener(this.jpd);
        crn();
        TiebaStatic.log("c12303");
    }

    private void crm() {
        this.AK = true;
        this.jpa = null;
        this.joZ = null;
        bpG();
    }

    public void crn() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.eAC)) {
            httpMessage.addParam("forum_id", this.eAC);
        }
        sendMessage(httpMessage);
    }

    private void cro() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.joW.getRootView());
        if (this.joW != null) {
            this.joW.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.joW != null) {
            this.joW.onPause();
        }
        if (this.jpc.crx()) {
            this.jpc.cry();
        }
        this.jpb = false;
        this.AK = true;
        crm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.joW != null) {
            this.joW.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.crN().crO();
        com.baidu.tieba.video.editvideo.model.b.crQ().crR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.joW != null) {
            this.joW.release();
        }
        if (this.joX != null) {
            this.joX.cancelLoadData();
        }
        if (this.joY != null) {
            this.joY.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.joW != null) {
            this.joW.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        bpG();
        this.jpb = false;
        if (this.joW != null && this.joW.csf() != null) {
            this.joW.csf().pause();
            this.joW.csf().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void crp() {
        if (this.joW == null || this.joX == null || this.joY == null) {
            bpG();
            this.jpb = false;
        } else if (!j.jS()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.jpb) {
            this.jpb = true;
            this.AK = false;
            this.jpa = null;
            this.joZ = null;
            this.joW.onPause();
            this.fgM.ef(true);
            crr();
        }
    }

    private void bpG() {
        if (this.fgM != null) {
            this.fgM.ef(false);
        }
    }

    private void crq() {
        if (this.AK) {
            this.AK = false;
        } else if (this.joW.csm()) {
            this.joY.e(this.ald, this.joW.csk(), c.jno + "video_" + System.currentTimeMillis() + ".mp4", this.joW.isMute() ? false : true);
        } else if (this.joW.isMute()) {
            this.joY.e(this.ald, null, c.jno + "video_" + System.currentTimeMillis() + ".mp4", this.joW.isMute() ? false : true);
        } else {
            t(this.ald, -4399, "");
        }
    }

    private void crr() {
        if (this.AK) {
            this.AK = false;
            return;
        }
        String text = this.joW.getText();
        if (TextUtils.isEmpty(text)) {
            this.joX.bp(this.ald, this.joW.getCurrentPosition());
        } else {
            this.joX.BJ(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void crs() {
        File file;
        this.AK = false;
        if (this.joW.csm() || this.joW.isMute()) {
            this.jpb = false;
            this.fgM.ef(true);
            this.joW.onPause();
            if (this.jpa != null) {
                t(this.jpa, -4399, "");
            } else {
                crq();
            }
        } else if (this.jpc.crw()) {
            this.jpb = false;
            this.joW.onPause();
            this.fgM.ef(true);
            ER(this.ald);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.bQ(new File(this.ald).getAbsolutePath(), c.jnp + file.getName());
                ET(c.jnp + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bXz() {
        if (this.joW == null || this.joX == null) {
            bpG();
            this.jpb = false;
        } else if (this.AK) {
            this.AK = false;
        } else {
            this.joX.bp(this.ald, this.joW.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void BH(String str) {
        if (this.AK) {
            this.AK = false;
        } else if (this.jpb) {
            showToast(str);
            bpG();
            this.jpb = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void H(Bitmap bitmap) {
        this.joW.csf().L(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void EP(String str) {
        if (this.AK) {
            this.AK = false;
            return;
        }
        this.joZ = str;
        crq();
    }

    private void crt() {
        if (this.AK) {
            this.AK = false;
        } else if (!TextUtils.isEmpty(this.joZ) && !TextUtils.isEmpty(this.jpa)) {
            this.mVideoInfo.setVideoPath(this.jpa);
            this.mVideoInfo.setThumbPath(this.joZ);
            if (this.joW.csm() && !TextUtils.isEmpty(this.joW.csl())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.joW.csl());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.fOb, this.eAC, this.mForumName, this.joU, 13003, this.mVideoInfo, this.mVideoTitleData, this.joV);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            writeVideoActivityConfig.setProZone(this.joT);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            bpG();
            this.jpb = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(R.string.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(R.string.music_cloud)));
        this.joW.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
        if (this.AK) {
            this.AK = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.mixing_fail);
            bpG();
            this.joW.onResume();
            this.jpb = false;
            if (this.iZT != null) {
                this.iZT.ax(i, str2);
            }
        } else if (this.jpc.crw()) {
            ER(str);
        } else {
            ES(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cru() {
        this.jpa = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void em(List<PendantData> list) {
        this.joW.em(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String EW = com.baidu.tieba.video.editvideo.model.a.crN().EW(stringExtra);
                if (this.joW != null && !TextUtils.isEmpty(EW)) {
                    this.joW.es(EW, stringExtra2);
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
        if (this.iZT != null) {
            this.iZT.ax(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aL(int i, String str) {
        if (this.iZT != null) {
            this.iZT.ax(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void d(Bitmap bitmap, boolean z) {
        I(bitmap);
    }

    private void ER(String str) {
        this.joW.csi();
        this.joW.csj();
        this.joW.csf().releaseSource();
        this.jpc.EV(str);
    }

    private void ES(String str) {
        File file;
        this.jpa = str;
        if (this.jpb) {
            crt();
            return;
        }
        String str2 = c.jnp + file.getName();
        m.bQ(new File(this.jpa).getAbsolutePath(), str2);
        ET(str2);
        bpG();
        finishPage();
    }

    private void ET(String str) {
        try {
            new w(this).nF(str);
            com.baidu.tieba.video.editvideo.b.c.aK(this, str);
        } catch (Exception e) {
            bpG();
            this.jpb = false;
        }
    }

    private void I(Bitmap bitmap) {
        if (this.joW == null || this.joX == null) {
            bpG();
            this.jpb = false;
        } else if (this.AK) {
            this.AK = false;
        } else {
            if (!TextUtils.isEmpty(this.joW.getText())) {
                bitmap = this.joW.B(bitmap);
            }
            if (bitmap != null) {
                this.joX.b(bitmap, c.jnn);
            }
        }
    }
}
