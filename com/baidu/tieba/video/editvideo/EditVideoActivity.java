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
/* loaded from: classes2.dex */
public class EditVideoActivity extends BaseActivity implements a, b, b.a, MaskVideoView.b {
    private String bnB;
    private String cBU;
    private String dHW;
    private com.baidu.tbadk.core.view.a deH;
    private h gOY;
    private String hdj;
    private List<VideoTitleData> hdk;
    private com.baidu.tieba.video.editvideo.view.a hdl;
    private SelectCoverModel hdm;
    private SelectMusicModel hdn;
    private String hdo;
    private String hdp;
    private boolean hdq;
    private com.baidu.tieba.video.editvideo.b.a hdr;
    private HttpMessageListener hds;
    private CustomMessageListener hdt;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;
    private boolean zT;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.gOY = lVar.aWa();
        }
        this.hds = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.hdk = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.hdt = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.cBU = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.hdj = getIntent().getStringExtra("video_title");
        this.dHW = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.bnB = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.bnB) && !new File(this.bnB).exists()) {
            finishPage();
        }
        new File(c.hbE).mkdirs();
        this.hdm = new SelectCoverModel(getPageContext(), this, this.gOY);
        this.hdn = new SelectMusicModel(getPageContext(), this);
        this.hdr = new com.baidu.tieba.video.editvideo.b.a(this);
        this.hdr.a(this);
        this.hdl = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.g.root_layout), this.gOY);
        this.hdl.setData(this.bnB);
        this.hdl.aa(getIntent());
        this.hdl.a(this.hdr);
        this.hdl.setGenMaskCoverListener(this);
        this.hdm.bBi();
        this.hdn.bBj();
        this.deH = new com.baidu.tbadk.core.view.a(getPageContext());
        this.deH.df(d.j.mixing);
        registerListener(this.hdt);
        bAE();
        registerListener(this.hds);
        bAD();
        TiebaStatic.log("c12303");
    }

    private void bAC() {
        this.zT = true;
        this.hdp = null;
        this.hdo = null;
        aAh();
    }

    public void bAD() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.cBU)) {
            httpMessage.addParam("forum_id", this.cBU);
        }
        sendMessage(httpMessage);
    }

    private void bAE() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.hdl.getRootView());
        if (this.hdl != null) {
            this.hdl.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hdl != null) {
            this.hdl.onPause();
        }
        if (this.hdr.bAN()) {
            this.hdr.bAO();
        }
        this.hdq = false;
        this.zT = true;
        bAC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hdl != null) {
            this.hdl.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bBd().bBe();
        com.baidu.tieba.video.editvideo.model.b.bBg().bBh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hdl != null) {
            this.hdl.release();
        }
        if (this.hdm != null) {
            this.hdm.cancelLoadData();
        }
        if (this.hdn != null) {
            this.hdn.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hdl != null) {
            this.hdl.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        aAh();
        this.hdq = false;
        if (this.hdl != null && this.hdl.bBv() != null) {
            this.hdl.bBv().pause();
            this.hdl.bBv().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bAF() {
        if (this.hdl == null || this.hdm == null || this.hdn == null) {
            aAh();
            this.hdq = false;
        } else if (!j.jE()) {
            getPageContext().showToast(d.j.no_network);
        } else if (!this.hdq) {
            this.hdq = true;
            this.zT = false;
            this.hdp = null;
            this.hdo = null;
            this.hdl.onPause();
            this.deH.aM(true);
            bAH();
        }
    }

    private void aAh() {
        if (this.deH != null) {
            this.deH.aM(false);
        }
    }

    private void bAG() {
        if (this.zT) {
            this.zT = false;
        } else if (this.hdl.bBC()) {
            this.hdn.c(this.bnB, this.hdl.bBA(), c.hbD + "video_" + System.currentTimeMillis() + ".mp4", this.hdl.isMute() ? false : true);
        } else if (this.hdl.isMute()) {
            this.hdn.c(this.bnB, null, c.hbD + "video_" + System.currentTimeMillis() + ".mp4", this.hdl.isMute() ? false : true);
        } else {
            n(this.bnB, -4399, "");
        }
    }

    private void bAH() {
        if (this.zT) {
            this.zT = false;
            return;
        }
        String text = this.hdl.getText();
        if (TextUtils.isEmpty(text)) {
            this.hdm.aM(this.bnB, this.hdl.getCurrentPosition());
        } else {
            this.hdm.rJ(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bAI() {
        File file;
        this.zT = false;
        if (this.hdl.bBC() || this.hdl.isMute()) {
            this.hdq = false;
            this.deH.aM(true);
            this.hdl.onPause();
            if (this.hdp != null) {
                n(this.hdp, -4399, "");
            } else {
                bAG();
            }
        } else if (this.hdr.bAM()) {
            this.hdq = false;
            this.hdl.onPause();
            this.deH.aM(true);
            uF(this.bnB);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.l.ab(new File(this.bnB).getAbsolutePath(), c.hbE + file.getName());
                uH(c.hbE + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bgR() {
        if (this.hdl == null || this.hdm == null) {
            aAh();
            this.hdq = false;
        } else if (this.zT) {
            this.zT = false;
        } else {
            this.hdm.aM(this.bnB, this.hdl.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void rH(String str) {
        if (this.zT) {
            this.zT = false;
        } else if (this.hdq) {
            showToast(str);
            aAh();
            this.hdq = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void x(Bitmap bitmap) {
        this.hdl.bBv().B(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void uD(String str) {
        if (this.zT) {
            this.zT = false;
            return;
        }
        this.hdo = str;
        bAG();
    }

    private void bAJ() {
        if (this.zT) {
            this.zT = false;
        } else if (!TextUtils.isEmpty(this.hdo) && !TextUtils.isEmpty(this.hdp)) {
            this.mVideoInfo.setVideoPath(this.hdp);
            this.mVideoInfo.setThumbPath(this.hdo);
            if (this.hdl.bBC() && !TextUtils.isEmpty(this.hdl.bBB())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.hdl.bBB());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.dHW, this.cBU, this.mForumName, this.hdj, 13003, this.mVideoInfo, this.mVideoTitleData, this.hdk);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            aAh();
            this.hdq = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.j.music_cloud)));
        this.hdl.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
        if (this.zT) {
            this.zT = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.j.mixing_fail);
            aAh();
            this.hdl.onResume();
            this.hdq = false;
            if (this.gOY != null) {
                this.gOY.ad(i, str2);
            }
        } else if (this.hdr.bAM()) {
            uF(str);
        } else {
            uG(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bAK() {
        this.hdp = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dG(List<PendantData> list) {
        this.hdl.dG(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String uL = com.baidu.tieba.video.editvideo.model.a.bBd().uL(stringExtra);
                if (this.hdl != null && !TextUtils.isEmpty(uL)) {
                    this.hdl.cs(uL, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void uE(String str) {
        uG(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ap(int i, String str) {
        if (this.gOY != null) {
            this.gOY.ad(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aq(int i, String str) {
        if (this.gOY != null) {
            this.gOY.ad(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        y(bitmap);
    }

    private void uF(String str) {
        this.hdl.bBy();
        this.hdl.bBz();
        this.hdl.bBv().releaseSource();
        this.hdr.uJ(str);
    }

    private void uG(String str) {
        File file;
        this.hdp = str;
        if (this.hdq) {
            bAJ();
            return;
        }
        String str2 = c.hbE + file.getName();
        com.baidu.tbadk.core.util.l.ab(new File(this.hdp).getAbsolutePath(), str2);
        uH(str2);
        aAh();
        finishPage();
    }

    private void uH(String str) {
        try {
            new x(this).ez(str);
            com.baidu.tieba.video.editvideo.b.c.as(this, str);
        } catch (Exception e) {
            aAh();
            this.hdq = false;
        }
    }

    private void y(Bitmap bitmap) {
        if (this.hdl == null || this.hdm == null) {
            aAh();
            this.hdq = false;
        } else if (this.zT) {
            this.zT = false;
        } else {
            if (!TextUtils.isEmpty(this.hdl.getText())) {
                bitmap = this.hdl.r(bitmap);
            }
            if (bitmap != null) {
                this.hdm.b(bitmap, c.hbC);
            }
        }
    }
}
