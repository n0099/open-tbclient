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
    private String aAn;
    private String bdg;
    private com.baidu.tbadk.core.view.a fnG;
    private h gAg;
    private boolean gOA;
    private com.baidu.tieba.video.editvideo.b.a gOB;
    private HttpMessageListener gOC;
    private CustomMessageListener gOD;
    private String gOt;
    private List<VideoTitleData> gOu;
    private com.baidu.tieba.video.editvideo.view.a gOv;
    private SelectCoverModel gOw;
    private SelectMusicModel gOx;
    private String gOy;
    private String gOz;
    private String mForumName;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;
    private boolean vo;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gAg = kVar.aOb();
        }
        this.gOC = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.gOu = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.gOD = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.aAn = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.gOt = getIntent().getStringExtra("video_title");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.bdg = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.bdg) && !new File(this.bdg).exists()) {
            finishPage();
        }
        new File(com.baidu.tieba.video.b.gMU).mkdirs();
        this.gOw = new SelectCoverModel(getPageContext(), this, this.gAg);
        this.gOx = new SelectMusicModel(getPageContext(), this);
        this.gOB = new com.baidu.tieba.video.editvideo.b.a(this);
        this.gOB.a(this);
        this.gOv = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.g.root_layout), this.gAg);
        this.gOv.setData(this.bdg);
        this.gOv.ad(getIntent());
        this.gOv.a(this.gOB);
        this.gOv.setGenMaskCoverListener(this);
        this.gOw.bBx();
        this.gOx.bBy();
        this.fnG = new com.baidu.tbadk.core.view.a(getPageContext());
        this.fnG.db(d.j.mixing);
        registerListener(this.gOD);
        bAS();
        registerListener(this.gOC);
        bAR();
        TiebaStatic.log("c12303");
    }

    private void bAQ() {
        this.vo = true;
        this.gOz = null;
        this.gOy = null;
        aqr();
    }

    public void bAR() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.aAn)) {
            httpMessage.addParam("forum_id", this.aAn);
        }
        sendMessage(httpMessage);
    }

    private void bAS() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.gOv.getRootView());
        if (this.gOv != null) {
            this.gOv.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gOv != null) {
            this.gOv.onPause();
        }
        if (this.gOB.bBb()) {
            this.gOB.bBc();
        }
        this.gOA = false;
        this.vo = true;
        bAQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gOv != null) {
            this.gOv.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bBs().bBt();
        com.baidu.tieba.video.editvideo.model.b.bBv().bBw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gOv != null) {
            this.gOv.release();
        }
        if (this.gOw != null) {
            this.gOw.cancelLoadData();
        }
        if (this.gOx != null) {
            this.gOx.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gOv != null) {
            this.gOv.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        aqr();
        this.gOA = false;
        com.baidu.tbadk.core.util.k.r(new File(com.baidu.tieba.video.b.gMT));
        if (this.gOv != null && this.gOv.bBL() != null) {
            this.gOv.bBL().pause();
            this.gOv.bBL().releaseSource();
        }
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bAT() {
        if (this.gOv != null && this.gOw != null && this.gOx != null) {
            if (!j.hh()) {
                getPageContext().showToast(d.j.no_network);
            } else if (!this.gOA) {
                this.gOA = true;
                this.vo = false;
                this.gOz = null;
                this.gOy = null;
                this.gOv.onPause();
                this.fnG.aE(true);
                bAV();
            }
        }
    }

    private void aqr() {
        if (this.fnG != null) {
            this.fnG.aE(false);
        }
    }

    private void bAU() {
        if (this.vo) {
            this.vo = false;
        } else if (this.gOv.bBS()) {
            this.gOx.c(this.bdg, this.gOv.bBQ(), com.baidu.tieba.video.b.gMT + "video_" + System.currentTimeMillis() + ".mp4", this.gOv.isMute() ? false : true);
        } else if (this.gOv.isMute()) {
            this.gOx.c(this.bdg, null, com.baidu.tieba.video.b.gMT + "video_" + System.currentTimeMillis() + ".mp4", this.gOv.isMute() ? false : true);
        } else {
            n(this.bdg, -4399, "");
        }
    }

    private void bAV() {
        if (this.vo) {
            this.vo = false;
            return;
        }
        String text = this.gOv.getText();
        if (TextUtils.isEmpty(text)) {
            this.gOw.aH(this.bdg, this.gOv.getCurrentPosition());
        } else {
            this.gOw.qq(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bAW() {
        File file;
        this.vo = false;
        if (this.gOv.bBS() || this.gOv.isMute()) {
            this.gOA = false;
            this.fnG.aE(true);
            this.gOv.onPause();
            if (this.gOz != null) {
                n(this.gOz, -4399, "");
            } else {
                bAU();
            }
        } else if (this.gOB.bBa()) {
            this.gOA = false;
            this.gOv.onPause();
            this.fnG.aE(true);
            tU(this.bdg);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.k.Z(new File(this.bdg).getAbsolutePath(), com.baidu.tieba.video.b.gMU + file.getName());
                tW(com.baidu.tieba.video.b.gMU + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void aYY() {
        if (this.gOv == null || this.gOw == null) {
            aqr();
            this.gOA = false;
        } else if (this.vo) {
            this.vo = false;
        } else {
            this.gOw.aH(this.bdg, this.gOv.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void qo(String str) {
        if (this.vo) {
            this.vo = false;
        } else if (this.gOA) {
            showToast(str);
            aqr();
            this.gOA = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void r(Bitmap bitmap) {
        this.gOv.bBL().v(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void tS(String str) {
        if (this.vo) {
            this.vo = false;
            return;
        }
        this.gOy = str;
        bAU();
    }

    private void bAX() {
        if (this.vo) {
            this.vo = false;
        } else if (!TextUtils.isEmpty(this.gOy) && !TextUtils.isEmpty(this.gOz)) {
            this.mVideoInfo.setVideoPath(this.gOz);
            tW(this.gOz);
            this.mVideoInfo.setThumbPath(this.gOy);
            if (this.gOv.bBS() && !TextUtils.isEmpty(this.gOv.bBR())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.gOv.bBR());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.aAn, this.mForumName, this.gOt, 13003, this.mVideoInfo, this.mVideoTitleData, this.gOu)));
            aqr();
            this.gOA = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.j.music_cloud)));
        this.gOv.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
        if (this.vo) {
            this.vo = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.j.mixing_fail);
            aqr();
            this.gOv.onResume();
            this.gOA = false;
            if (this.gAg != null) {
                this.gAg.S(i, str2);
            }
        } else if (this.gOB.bBa()) {
            tU(str);
        } else {
            tV(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bAY() {
        this.gOz = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dO(List<PendantData> list) {
        this.gOv.dO(list);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String ua = com.baidu.tieba.video.editvideo.model.a.bBs().ua(stringExtra);
                if (this.gOv != null && !TextUtils.isEmpty(ua)) {
                    this.gOv.cn(ua, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void tT(String str) {
        tV(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aj(int i, String str) {
        if (this.gAg != null) {
            this.gAg.S(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ak(int i, String str) {
        if (this.gAg != null) {
            this.gAg.S(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        s(bitmap);
    }

    private void tU(String str) {
        this.gOv.bBO();
        this.gOv.bBP();
        this.gOv.bBL().releaseSource();
        this.gOB.tY(str);
    }

    private void tV(String str) {
        File file;
        this.gOz = str;
        if (this.gOA) {
            bAX();
            return;
        }
        String str2 = com.baidu.tieba.video.b.gMU + file.getName();
        com.baidu.tbadk.core.util.k.Z(new File(this.gOz).getAbsolutePath(), str2);
        tW(str2);
        aqr();
        finishPage();
    }

    private void tW(String str) {
        try {
            new w(this).dI(str);
            c.ao(this, str);
        } catch (Exception e) {
        }
    }

    private void s(Bitmap bitmap) {
        if (this.gOv == null || this.gOw == null) {
            aqr();
        } else if (this.vo) {
            this.vo = false;
        } else {
            if (!TextUtils.isEmpty(this.gOv.getText())) {
                bitmap = this.gOv.j(bitmap);
            }
            if (bitmap != null) {
                this.gOw.b(bitmap, com.baidu.tieba.video.b.gMS);
            }
        }
    }
}
