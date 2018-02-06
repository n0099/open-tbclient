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
    private boolean ajB;
    private String bTr;
    private String cZU;
    private com.baidu.tbadk.core.view.b dWZ;
    private h hbR;
    private String hpA;
    private boolean hpB;
    private com.baidu.tieba.video.editvideo.b.a hpC;
    private String hpD;
    private HttpMessageListener hpE;
    private CustomMessageListener hpF;
    private String hpu;
    private List<VideoTitleData> hpv;
    private com.baidu.tieba.video.editvideo.view.a hpw;
    private SelectCoverModel hpx;
    private SelectMusicModel hpy;
    private String hpz;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.hbR = kVar.aXg();
        }
        this.hpE = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.hpv = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.hpF = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.cZU = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.hpu = getIntent().getStringExtra("video_title");
        this.hpD = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.bTr = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.bTr) && !new File(this.bTr).exists()) {
            finishPage();
        }
        new File(com.baidu.tieba.video.b.hnR).mkdirs();
        this.hpx = new SelectCoverModel(getPageContext(), this, this.hbR);
        this.hpy = new SelectMusicModel(getPageContext(), this);
        this.hpC = new com.baidu.tieba.video.editvideo.b.a(this);
        this.hpC.a(this);
        this.hpw = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.g.root_layout), this.hbR);
        this.hpw.setData(this.bTr);
        this.hpw.ab(getIntent());
        this.hpw.a(this.hpC);
        this.hpw.setGenMaskCoverListener(this);
        this.hpx.bBJ();
        this.hpy.bBK();
        this.dWZ = new com.baidu.tbadk.core.view.b(getPageContext());
        this.dWZ.ga(d.j.mixing);
        registerListener(this.hpF);
        bBf();
        registerListener(this.hpE);
        bBe();
        TiebaStatic.log("c12303");
    }

    private void bBd() {
        this.ajB = true;
        this.hpA = null;
        this.hpz = null;
        azT();
    }

    public void bBe() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.cZU)) {
            httpMessage.addParam("forum_id", this.cZU);
        }
        sendMessage(httpMessage);
    }

    private void bBf() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.hpw.getRootView());
        if (this.hpw != null) {
            this.hpw.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hpw != null) {
            this.hpw.onPause();
        }
        if (this.hpC.bBo()) {
            this.hpC.bBp();
        }
        this.hpB = false;
        this.ajB = true;
        bBd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hpw != null) {
            this.hpw.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bBE().bBF();
        com.baidu.tieba.video.editvideo.model.b.bBH().bBI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hpw != null) {
            this.hpw.release();
        }
        if (this.hpx != null) {
            this.hpx.cancelLoadData();
        }
        if (this.hpy != null) {
            this.hpy.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hpw != null) {
            this.hpw.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        azT();
        this.hpB = false;
        com.baidu.tbadk.core.util.k.s(new File(com.baidu.tieba.video.b.hnQ));
        if (this.hpw != null && this.hpw.bBW() != null) {
            this.hpw.bBW().pause();
            this.hpw.bBW().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBg() {
        if (this.hpw != null && this.hpx != null && this.hpy != null) {
            if (!j.oJ()) {
                getPageContext().showToast(d.j.no_network);
            } else if (!this.hpB) {
                this.hpB = true;
                this.ajB = false;
                this.hpA = null;
                this.hpz = null;
                this.hpw.onPause();
                this.dWZ.bq(true);
                bBi();
            }
        }
    }

    private void azT() {
        if (this.dWZ != null) {
            this.dWZ.bq(false);
        }
    }

    private void bBh() {
        if (this.ajB) {
            this.ajB = false;
        } else if (this.hpw.bCd()) {
            this.hpy.c(this.bTr, this.hpw.bCb(), com.baidu.tieba.video.b.hnQ + "video_" + System.currentTimeMillis() + ".mp4", this.hpw.isMute() ? false : true);
        } else if (this.hpw.isMute()) {
            this.hpy.c(this.bTr, null, com.baidu.tieba.video.b.hnQ + "video_" + System.currentTimeMillis() + ".mp4", this.hpw.isMute() ? false : true);
        } else {
            n(this.bTr, -4399, "");
        }
    }

    private void bBi() {
        if (this.ajB) {
            this.ajB = false;
            return;
        }
        String text = this.hpw.getText();
        if (TextUtils.isEmpty(text)) {
            this.hpx.aL(this.bTr, this.hpw.getCurrentPosition());
        } else {
            this.hpx.qR(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBj() {
        File file;
        this.ajB = false;
        if (this.hpw.bCd() || this.hpw.isMute()) {
            this.hpB = false;
            this.dWZ.bq(true);
            this.hpw.onPause();
            if (this.hpA != null) {
                n(this.hpA, -4399, "");
            } else {
                bBh();
            }
        } else if (this.hpC.bBn()) {
            this.hpB = false;
            this.hpw.onPause();
            this.dWZ.bq(true);
            tH(this.bTr);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.k.Y(new File(this.bTr).getAbsolutePath(), com.baidu.tieba.video.b.hnR + file.getName());
                tJ(com.baidu.tieba.video.b.hnR + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bhS() {
        if (this.hpw == null || this.hpx == null) {
            azT();
            this.hpB = false;
        } else if (this.ajB) {
            this.ajB = false;
        } else {
            this.hpx.aL(this.bTr, this.hpw.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void qP(String str) {
        if (this.ajB) {
            this.ajB = false;
        } else if (this.hpB) {
            showToast(str);
            azT();
            this.hpB = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void v(Bitmap bitmap) {
        this.hpw.bBW().z(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void tF(String str) {
        if (this.ajB) {
            this.ajB = false;
            return;
        }
        this.hpz = str;
        bBh();
    }

    private void bBk() {
        if (this.ajB) {
            this.ajB = false;
        } else if (!TextUtils.isEmpty(this.hpz) && !TextUtils.isEmpty(this.hpA)) {
            this.mVideoInfo.setVideoPath(this.hpA);
            this.mVideoInfo.setThumbPath(this.hpz);
            if (this.hpw.bCd() && !TextUtils.isEmpty(this.hpw.bCc())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.hpw.bCc());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.hpD, this.cZU, this.mForumName, this.hpu, 13003, this.mVideoInfo, this.mVideoTitleData, this.hpv);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            azT();
            this.hpB = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.j.music_cloud)));
        this.hpw.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
        if (this.ajB) {
            this.ajB = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.j.mixing_fail);
            azT();
            this.hpw.onResume();
            this.hpB = false;
            if (this.hbR != null) {
                this.hbR.W(i, str2);
            }
        } else if (this.hpC.bBn()) {
            tH(str);
        } else {
            tI(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBl() {
        this.hpA = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dI(List<PendantData> list) {
        this.hpw.dI(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String tN = com.baidu.tieba.video.editvideo.model.a.bBE().tN(stringExtra);
                if (this.hpw != null && !TextUtils.isEmpty(tN)) {
                    this.hpw.ck(tN, stringExtra2);
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
        if (this.hbR != null) {
            this.hbR.W(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ak(int i, String str) {
        if (this.hbR != null) {
            this.hbR.W(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        w(bitmap);
    }

    private void tH(String str) {
        this.hpw.bBZ();
        this.hpw.bCa();
        this.hpw.bBW().releaseSource();
        this.hpC.tL(str);
    }

    private void tI(String str) {
        File file;
        this.hpA = str;
        if (this.hpB) {
            bBk();
            return;
        }
        String str2 = com.baidu.tieba.video.b.hnR + file.getName();
        com.baidu.tbadk.core.util.k.Y(new File(this.hpA).getAbsolutePath(), str2);
        tJ(str2);
        azT();
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
        if (this.hpw == null || this.hpx == null) {
            azT();
        } else if (this.ajB) {
            this.ajB = false;
        } else {
            if (!TextUtils.isEmpty(this.hpw.getText())) {
                bitmap = this.hpw.p(bitmap);
            }
            if (bitmap != null) {
                this.hpx.b(bitmap, com.baidu.tieba.video.b.hnP);
            }
        }
    }
}
