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
    private String bRe;
    private String cWM;
    private com.baidu.tbadk.core.view.b dST;
    private h gZj;
    private String hnL;
    private List<VideoTitleData> hnM;
    private com.baidu.tieba.video.editvideo.view.a hnN;
    private SelectCoverModel hnO;
    private SelectMusicModel hnP;
    private String hnQ;
    private String hnR;
    private boolean hnS;
    private com.baidu.tieba.video.editvideo.b.a hnT;
    private String hnU;
    private HttpMessageListener hnV;
    private CustomMessageListener hnW;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gZj = kVar.aVs();
        }
        this.hnV = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.hnM = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.hnW = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.cWM = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.hnL = getIntent().getStringExtra("video_title");
        this.hnU = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.bRe = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.bRe) && !new File(this.bRe).exists()) {
            finishPage();
        }
        new File(com.baidu.tieba.video.b.hmi).mkdirs();
        this.hnO = new SelectCoverModel(getPageContext(), this, this.gZj);
        this.hnP = new SelectMusicModel(getPageContext(), this);
        this.hnT = new com.baidu.tieba.video.editvideo.b.a(this);
        this.hnT.a(this);
        this.hnN = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.g.root_layout), this.gZj);
        this.hnN.setData(this.bRe);
        this.hnN.ad(getIntent());
        this.hnN.a(this.hnT);
        this.hnN.setGenMaskCoverListener(this);
        this.hnO.bAY();
        this.hnP.bAZ();
        this.dST = new com.baidu.tbadk.core.view.b(getPageContext());
        this.dST.fY(d.j.mixing);
        registerListener(this.hnW);
        bAt();
        registerListener(this.hnV);
        bAs();
        TiebaStatic.log("c12303");
    }

    private void bAr() {
        this.ajz = true;
        this.hnR = null;
        this.hnQ = null;
        ayM();
    }

    public void bAs() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.cWM)) {
            httpMessage.addParam("forum_id", this.cWM);
        }
        sendMessage(httpMessage);
    }

    private void bAt() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().aM(i == 1);
        getLayoutMode().aM(this.hnN.getRootView());
        if (this.hnN != null) {
            this.hnN.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hnN != null) {
            this.hnN.onPause();
        }
        if (this.hnT.bAC()) {
            this.hnT.bAD();
        }
        this.hnS = false;
        this.ajz = true;
        bAr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hnN != null) {
            this.hnN.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bAT().bAU();
        com.baidu.tieba.video.editvideo.model.b.bAW().bAX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hnN != null) {
            this.hnN.release();
        }
        if (this.hnO != null) {
            this.hnO.cancelLoadData();
        }
        if (this.hnP != null) {
            this.hnP.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hnN != null) {
            this.hnN.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        ayM();
        this.hnS = false;
        com.baidu.tbadk.core.util.k.s(new File(com.baidu.tieba.video.b.hmh));
        if (this.hnN != null && this.hnN.bBl() != null) {
            this.hnN.bBl().pause();
            this.hnN.bBl().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bAu() {
        if (this.hnN != null && this.hnO != null && this.hnP != null) {
            if (!j.oI()) {
                getPageContext().showToast(d.j.no_network);
            } else if (!this.hnS) {
                this.hnS = true;
                this.ajz = false;
                this.hnR = null;
                this.hnQ = null;
                this.hnN.onPause();
                this.dST.bm(true);
                bAw();
            }
        }
    }

    private void ayM() {
        if (this.dST != null) {
            this.dST.bm(false);
        }
    }

    private void bAv() {
        if (this.ajz) {
            this.ajz = false;
        } else if (this.hnN.bBs()) {
            this.hnP.c(this.bRe, this.hnN.bBq(), com.baidu.tieba.video.b.hmh + "video_" + System.currentTimeMillis() + ".mp4", this.hnN.isMute() ? false : true);
        } else if (this.hnN.isMute()) {
            this.hnP.c(this.bRe, null, com.baidu.tieba.video.b.hmh + "video_" + System.currentTimeMillis() + ".mp4", this.hnN.isMute() ? false : true);
        } else {
            n(this.bRe, -4399, "");
        }
    }

    private void bAw() {
        if (this.ajz) {
            this.ajz = false;
            return;
        }
        String text = this.hnN.getText();
        if (TextUtils.isEmpty(text)) {
            this.hnO.aK(this.bRe, this.hnN.getCurrentPosition());
        } else {
            this.hnO.qD(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bAx() {
        File file;
        this.ajz = false;
        if (this.hnN.bBs() || this.hnN.isMute()) {
            this.hnS = false;
            this.dST.bm(true);
            this.hnN.onPause();
            if (this.hnR != null) {
                n(this.hnR, -4399, "");
            } else {
                bAv();
            }
        } else if (this.hnT.bAB()) {
            this.hnS = false;
            this.hnN.onPause();
            this.dST.bm(true);
            tv(this.bRe);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.k.Y(new File(this.bRe).getAbsolutePath(), com.baidu.tieba.video.b.hmi + file.getName());
                tx(com.baidu.tieba.video.b.hmi + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bgx() {
        if (this.hnN == null || this.hnO == null) {
            ayM();
            this.hnS = false;
        } else if (this.ajz) {
            this.ajz = false;
        } else {
            this.hnO.aK(this.bRe, this.hnN.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void qB(String str) {
        if (this.ajz) {
            this.ajz = false;
        } else if (this.hnS) {
            showToast(str);
            ayM();
            this.hnS = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void s(Bitmap bitmap) {
        this.hnN.bBl().w(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void tt(String str) {
        if (this.ajz) {
            this.ajz = false;
            return;
        }
        this.hnQ = str;
        bAv();
    }

    private void bAy() {
        if (this.ajz) {
            this.ajz = false;
        } else if (!TextUtils.isEmpty(this.hnQ) && !TextUtils.isEmpty(this.hnR)) {
            this.mVideoInfo.setVideoPath(this.hnR);
            this.mVideoInfo.setThumbPath(this.hnQ);
            if (this.hnN.bBs() && !TextUtils.isEmpty(this.hnN.bBr())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.hnN.bBr());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.hnU, this.cWM, this.mForumName, this.hnL, 13003, this.mVideoInfo, this.mVideoTitleData, this.hnM);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
            ayM();
            this.hnS = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.j.music_cloud)));
        this.hnN.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
        if (this.ajz) {
            this.ajz = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.j.mixing_fail);
            ayM();
            this.hnN.onResume();
            this.hnS = false;
            if (this.gZj != null) {
                this.gZj.T(i, str2);
            }
        } else if (this.hnT.bAB()) {
            tv(str);
        } else {
            tw(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bAz() {
        this.hnR = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dC(List<PendantData> list) {
        this.hnN.dC(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String tB = com.baidu.tieba.video.editvideo.model.a.bAT().tB(stringExtra);
                if (this.hnN != null && !TextUtils.isEmpty(tB)) {
                    this.hnN.cj(tB, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void tu(String str) {
        tw(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aj(int i, String str) {
        if (this.gZj != null) {
            this.gZj.T(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ak(int i, String str) {
        if (this.gZj != null) {
            this.gZj.T(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        t(bitmap);
    }

    private void tv(String str) {
        this.hnN.bBo();
        this.hnN.bBp();
        this.hnN.bBl().releaseSource();
        this.hnT.tz(str);
    }

    private void tw(String str) {
        File file;
        this.hnR = str;
        if (this.hnS) {
            bAy();
            return;
        }
        String str2 = com.baidu.tieba.video.b.hmi + file.getName();
        com.baidu.tbadk.core.util.k.Y(new File(this.hnR).getAbsolutePath(), str2);
        tx(str2);
        ayM();
        finishPage();
    }

    private void tx(String str) {
        try {
            new w(this).dP(str);
            c.ap(this, str);
        } catch (Exception e) {
        }
    }

    private void t(Bitmap bitmap) {
        if (this.hnN == null || this.hnO == null) {
            ayM();
        } else if (this.ajz) {
            this.ajz = false;
        } else {
            if (!TextUtils.isEmpty(this.hnN.getText())) {
                bitmap = this.hnN.m(bitmap);
            }
            if (bitmap != null) {
                this.hnO.b(bitmap, com.baidu.tieba.video.b.hmg);
            }
        }
    }
}
