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
    private String bTf;
    private String cZI;
    private com.baidu.tbadk.core.view.b dWN;
    private h hbC;
    private String hph;
    private List<VideoTitleData> hpi;
    private com.baidu.tieba.video.editvideo.view.a hpj;
    private SelectCoverModel hpk;
    private SelectMusicModel hpl;
    private String hpm;
    private String hpn;
    private boolean hpo;
    private com.baidu.tieba.video.editvideo.b.a hpp;
    private String hpq;
    private HttpMessageListener hpr;
    private CustomMessageListener hps;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.hbC = kVar.aXf();
        }
        this.hpr = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.hpi = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.hps = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.cZI = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.hph = getIntent().getStringExtra("video_title");
        this.hpq = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.bTf = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.bTf) && !new File(this.bTf).exists()) {
            finishPage();
        }
        new File(com.baidu.tieba.video.b.hnE).mkdirs();
        this.hpk = new SelectCoverModel(getPageContext(), this, this.hbC);
        this.hpl = new SelectMusicModel(getPageContext(), this);
        this.hpp = new com.baidu.tieba.video.editvideo.b.a(this);
        this.hpp.a(this);
        this.hpj = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.g.root_layout), this.hbC);
        this.hpj.setData(this.bTf);
        this.hpj.ab(getIntent());
        this.hpj.a(this.hpp);
        this.hpj.setGenMaskCoverListener(this);
        this.hpk.bBI();
        this.hpl.bBJ();
        this.dWN = new com.baidu.tbadk.core.view.b(getPageContext());
        this.dWN.ga(d.j.mixing);
        registerListener(this.hps);
        bBe();
        registerListener(this.hpr);
        bBd();
        TiebaStatic.log("c12303");
    }

    private void bBc() {
        this.ajv = true;
        this.hpn = null;
        this.hpm = null;
        azS();
    }

    public void bBd() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.cZI)) {
            httpMessage.addParam("forum_id", this.cZI);
        }
        sendMessage(httpMessage);
    }

    private void bBe() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.hpj.getRootView());
        if (this.hpj != null) {
            this.hpj.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hpj != null) {
            this.hpj.onPause();
        }
        if (this.hpp.bBn()) {
            this.hpp.bBo();
        }
        this.hpo = false;
        this.ajv = true;
        bBc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hpj != null) {
            this.hpj.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bBD().bBE();
        com.baidu.tieba.video.editvideo.model.b.bBG().bBH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hpj != null) {
            this.hpj.release();
        }
        if (this.hpk != null) {
            this.hpk.cancelLoadData();
        }
        if (this.hpl != null) {
            this.hpl.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hpj != null) {
            this.hpj.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        azS();
        this.hpo = false;
        com.baidu.tbadk.core.util.k.s(new File(com.baidu.tieba.video.b.hnD));
        if (this.hpj != null && this.hpj.bBV() != null) {
            this.hpj.bBV().pause();
            this.hpj.bBV().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBf() {
        if (this.hpj != null && this.hpk != null && this.hpl != null) {
            if (!j.oJ()) {
                getPageContext().showToast(d.j.no_network);
            } else if (!this.hpo) {
                this.hpo = true;
                this.ajv = false;
                this.hpn = null;
                this.hpm = null;
                this.hpj.onPause();
                this.dWN.bq(true);
                bBh();
            }
        }
    }

    private void azS() {
        if (this.dWN != null) {
            this.dWN.bq(false);
        }
    }

    private void bBg() {
        if (this.ajv) {
            this.ajv = false;
        } else if (this.hpj.bCc()) {
            this.hpl.c(this.bTf, this.hpj.bCa(), com.baidu.tieba.video.b.hnD + "video_" + System.currentTimeMillis() + ".mp4", this.hpj.isMute() ? false : true);
        } else if (this.hpj.isMute()) {
            this.hpl.c(this.bTf, null, com.baidu.tieba.video.b.hnD + "video_" + System.currentTimeMillis() + ".mp4", this.hpj.isMute() ? false : true);
        } else {
            n(this.bTf, -4399, "");
        }
    }

    private void bBh() {
        if (this.ajv) {
            this.ajv = false;
            return;
        }
        String text = this.hpj.getText();
        if (TextUtils.isEmpty(text)) {
            this.hpk.aL(this.bTf, this.hpj.getCurrentPosition());
        } else {
            this.hpk.qR(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBi() {
        File file;
        this.ajv = false;
        if (this.hpj.bCc() || this.hpj.isMute()) {
            this.hpo = false;
            this.dWN.bq(true);
            this.hpj.onPause();
            if (this.hpn != null) {
                n(this.hpn, -4399, "");
            } else {
                bBg();
            }
        } else if (this.hpp.bBm()) {
            this.hpo = false;
            this.hpj.onPause();
            this.dWN.bq(true);
            tH(this.bTf);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.k.Y(new File(this.bTf).getAbsolutePath(), com.baidu.tieba.video.b.hnE + file.getName());
                tJ(com.baidu.tieba.video.b.hnE + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bhR() {
        if (this.hpj == null || this.hpk == null) {
            azS();
            this.hpo = false;
        } else if (this.ajv) {
            this.ajv = false;
        } else {
            this.hpk.aL(this.bTf, this.hpj.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void qP(String str) {
        if (this.ajv) {
            this.ajv = false;
        } else if (this.hpo) {
            showToast(str);
            azS();
            this.hpo = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void v(Bitmap bitmap) {
        this.hpj.bBV().z(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void tF(String str) {
        if (this.ajv) {
            this.ajv = false;
            return;
        }
        this.hpm = str;
        bBg();
    }

    private void bBj() {
        if (this.ajv) {
            this.ajv = false;
        } else if (!TextUtils.isEmpty(this.hpm) && !TextUtils.isEmpty(this.hpn)) {
            this.mVideoInfo.setVideoPath(this.hpn);
            this.mVideoInfo.setThumbPath(this.hpm);
            if (this.hpj.bCc() && !TextUtils.isEmpty(this.hpj.bCb())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.hpj.bCb());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.hpq, this.cZI, this.mForumName, this.hph, 13003, this.mVideoInfo, this.mVideoTitleData, this.hpi);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            azS();
            this.hpo = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.j.music_cloud)));
        this.hpj.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
        if (this.ajv) {
            this.ajv = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.j.mixing_fail);
            azS();
            this.hpj.onResume();
            this.hpo = false;
            if (this.hbC != null) {
                this.hbC.W(i, str2);
            }
        } else if (this.hpp.bBm()) {
            tH(str);
        } else {
            tI(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bBk() {
        this.hpn = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dI(List<PendantData> list) {
        this.hpj.dI(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String tN = com.baidu.tieba.video.editvideo.model.a.bBD().tN(stringExtra);
                if (this.hpj != null && !TextUtils.isEmpty(tN)) {
                    this.hpj.ck(tN, stringExtra2);
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
        if (this.hbC != null) {
            this.hbC.W(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ak(int i, String str) {
        if (this.hbC != null) {
            this.hbC.W(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        w(bitmap);
    }

    private void tH(String str) {
        this.hpj.bBY();
        this.hpj.bBZ();
        this.hpj.bBV().releaseSource();
        this.hpp.tL(str);
    }

    private void tI(String str) {
        File file;
        this.hpn = str;
        if (this.hpo) {
            bBj();
            return;
        }
        String str2 = com.baidu.tieba.video.b.hnE + file.getName();
        com.baidu.tbadk.core.util.k.Y(new File(this.hpn).getAbsolutePath(), str2);
        tJ(str2);
        azS();
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
        if (this.hpj == null || this.hpk == null) {
            azS();
        } else if (this.ajv) {
            this.ajv = false;
        } else {
            if (!TextUtils.isEmpty(this.hpj.getText())) {
                bitmap = this.hpj.p(bitmap);
            }
            if (bitmap != null) {
                this.hpk.b(bitmap, com.baidu.tieba.video.b.hnC);
            }
        }
    }
}
