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
    private boolean ajv;
    private String bTi;
    private String cZL;
    private com.baidu.tbadk.core.view.b dWT;
    private h hca;
    private String hpF;
    private List<VideoTitleData> hpG;
    private com.baidu.tieba.video.editvideo.view.a hpH;
    private SelectCoverModel hpI;
    private SelectMusicModel hpJ;
    private String hpK;
    private String hpL;
    private boolean hpM;
    private com.baidu.tieba.video.editvideo.b.a hpN;
    private String hpO;
    private HttpMessageListener hpP;
    private CustomMessageListener hpQ;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.hca = kVar.aXg();
        }
        this.hpP = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.hpG = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.hpQ = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.cZL = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.hpF = getIntent().getStringExtra("video_title");
        this.hpO = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.bTi = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.bTi) && !new File(this.bTi).exists()) {
            finishPage();
        }
        new File(com.baidu.tieba.video.b.hoc).mkdirs();
        this.hpI = new SelectCoverModel(getPageContext(), this, this.hca);
        this.hpJ = new SelectMusicModel(getPageContext(), this);
        this.hpN = new com.baidu.tieba.video.editvideo.b.a(this);
        this.hpN.a(this);
        this.hpH = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.g.root_layout), this.hca);
        this.hpH.setData(this.bTi);
        this.hpH.ab(getIntent());
        this.hpH.a(this.hpN);
        this.hpH.setGenMaskCoverListener(this);
        this.hpI.bBN();
        this.hpJ.bBO();
        this.dWT = new com.baidu.tbadk.core.view.b(getPageContext());
        this.dWT.ga(d.j.mixing);
        registerListener(this.hpQ);
        bBj();
        registerListener(this.hpP);
        bBi();
        TiebaStatic.log("c12303");
    }

    private void bBh() {
        this.ajv = true;
        this.hpL = null;
        this.hpK = null;
        azU();
    }

    public void bBi() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.cZL)) {
            httpMessage.addParam("forum_id", this.cZL);
        }
        sendMessage(httpMessage);
    }

    private void bBj() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.hpH.getRootView());
        if (this.hpH != null) {
            this.hpH.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hpH != null) {
            this.hpH.onPause();
        }
        if (this.hpN.bBs()) {
            this.hpN.bBt();
        }
        this.hpM = false;
        this.ajv = true;
        bBh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hpH != null) {
            this.hpH.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bBI().bBJ();
        com.baidu.tieba.video.editvideo.model.b.bBL().bBM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hpH != null) {
            this.hpH.release();
        }
        if (this.hpI != null) {
            this.hpI.cancelLoadData();
        }
        if (this.hpJ != null) {
            this.hpJ.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hpH != null) {
            this.hpH.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        azU();
        this.hpM = false;
        com.baidu.tbadk.core.util.k.s(new File(com.baidu.tieba.video.b.hob));
        if (this.hpH != null && this.hpH.bCa() != null) {
            this.hpH.bCa().pause();
            this.hpH.bCa().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBk() {
        if (this.hpH != null && this.hpI != null && this.hpJ != null) {
            if (!j.oJ()) {
                getPageContext().showToast(d.j.no_network);
            } else if (!this.hpM) {
                this.hpM = true;
                this.ajv = false;
                this.hpL = null;
                this.hpK = null;
                this.hpH.onPause();
                this.dWT.bq(true);
                bBm();
            }
        }
    }

    private void azU() {
        if (this.dWT != null) {
            this.dWT.bq(false);
        }
    }

    private void bBl() {
        if (this.ajv) {
            this.ajv = false;
        } else if (this.hpH.bCh()) {
            this.hpJ.c(this.bTi, this.hpH.bCf(), com.baidu.tieba.video.b.hob + "video_" + System.currentTimeMillis() + ".mp4", this.hpH.isMute() ? false : true);
        } else if (this.hpH.isMute()) {
            this.hpJ.c(this.bTi, null, com.baidu.tieba.video.b.hob + "video_" + System.currentTimeMillis() + ".mp4", this.hpH.isMute() ? false : true);
        } else {
            n(this.bTi, -4399, "");
        }
    }

    private void bBm() {
        if (this.ajv) {
            this.ajv = false;
            return;
        }
        String text = this.hpH.getText();
        if (TextUtils.isEmpty(text)) {
            this.hpI.aL(this.bTi, this.hpH.getCurrentPosition());
        } else {
            this.hpI.qR(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBn() {
        File file;
        this.ajv = false;
        if (this.hpH.bCh() || this.hpH.isMute()) {
            this.hpM = false;
            this.dWT.bq(true);
            this.hpH.onPause();
            if (this.hpL != null) {
                n(this.hpL, -4399, "");
            } else {
                bBl();
            }
        } else if (this.hpN.bBr()) {
            this.hpM = false;
            this.hpH.onPause();
            this.dWT.bq(true);
            tH(this.bTi);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.k.Y(new File(this.bTi).getAbsolutePath(), com.baidu.tieba.video.b.hoc + file.getName());
                tJ(com.baidu.tieba.video.b.hoc + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bhS() {
        if (this.hpH == null || this.hpI == null) {
            azU();
            this.hpM = false;
        } else if (this.ajv) {
            this.ajv = false;
        } else {
            this.hpI.aL(this.bTi, this.hpH.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void qP(String str) {
        if (this.ajv) {
            this.ajv = false;
        } else if (this.hpM) {
            showToast(str);
            azU();
            this.hpM = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void v(Bitmap bitmap) {
        this.hpH.bCa().z(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void tF(String str) {
        if (this.ajv) {
            this.ajv = false;
            return;
        }
        this.hpK = str;
        bBl();
    }

    private void bBo() {
        if (this.ajv) {
            this.ajv = false;
        } else if (!TextUtils.isEmpty(this.hpK) && !TextUtils.isEmpty(this.hpL)) {
            this.mVideoInfo.setVideoPath(this.hpL);
            this.mVideoInfo.setThumbPath(this.hpK);
            if (this.hpH.bCh() && !TextUtils.isEmpty(this.hpH.bCg())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.hpH.bCg());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.hpO, this.cZL, this.mForumName, this.hpF, 13003, this.mVideoInfo, this.mVideoTitleData, this.hpG);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            azU();
            this.hpM = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.j.music_cloud)));
        this.hpH.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
        if (this.ajv) {
            this.ajv = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.j.mixing_fail);
            azU();
            this.hpH.onResume();
            this.hpM = false;
            if (this.hca != null) {
                this.hca.W(i, str2);
            }
        } else if (this.hpN.bBr()) {
            tH(str);
        } else {
            tI(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBp() {
        this.hpL = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dI(List<PendantData> list) {
        this.hpH.dI(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String tN = com.baidu.tieba.video.editvideo.model.a.bBI().tN(stringExtra);
                if (this.hpH != null && !TextUtils.isEmpty(tN)) {
                    this.hpH.ck(tN, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void tG(String str) {
        tI(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aj(int i, String str) {
        if (this.hca != null) {
            this.hca.W(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ak(int i, String str) {
        if (this.hca != null) {
            this.hca.W(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        w(bitmap);
    }

    private void tH(String str) {
        this.hpH.bCd();
        this.hpH.bCe();
        this.hpH.bCa().releaseSource();
        this.hpN.tL(str);
    }

    private void tI(String str) {
        File file;
        this.hpL = str;
        if (this.hpM) {
            bBo();
            return;
        }
        String str2 = com.baidu.tieba.video.b.hoc + file.getName();
        com.baidu.tbadk.core.util.k.Y(new File(this.hpL).getAbsolutePath(), str2);
        tJ(str2);
        azU();
        finishPage();
    }

    private void tJ(String str) {
        try {
            new w(this).eg(str);
            c.at(this, str);
        } catch (Exception e) {
        }
    }

    private void w(Bitmap bitmap) {
        if (this.hpH == null || this.hpI == null) {
            azU();
        } else if (this.ajv) {
            this.ajv = false;
        } else {
            if (!TextUtils.isEmpty(this.hpH.getText())) {
                bitmap = this.hpH.p(bitmap);
            }
            if (bitmap != null) {
                this.hpI.b(bitmap, com.baidu.tieba.video.b.hoa);
            }
        }
    }
}
