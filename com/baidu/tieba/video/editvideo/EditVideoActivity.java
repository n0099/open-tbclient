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
    private boolean AQ;
    private String alH;
    private String eFF;
    private String fTQ;
    private com.baidu.tbadk.core.view.b fmn;
    private h jhv;
    private int jwl;
    private String jwm;
    private List<VideoTitleData> jwn;
    private com.baidu.tieba.video.editvideo.view.a jwo;
    private SelectCoverModel jwp;
    private SelectMusicModel jwq;
    private String jwr;
    private String jws;
    private boolean jwt;
    private com.baidu.tieba.video.editvideo.b.a jwu;
    private HttpMessageListener jwv;
    private CustomMessageListener jww;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.jhv = lVar.bPk();
        }
        this.jwv = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.jwn = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.jww = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.eFF = getIntent().getStringExtra("forum_id");
        this.jwl = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.jwm = getIntent().getStringExtra("video_title");
        this.fTQ = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.alH = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.alH) && !new File(this.alH).exists()) {
            finishPage();
        }
        new File(c.juH).mkdirs();
        this.jwp = new SelectCoverModel(getPageContext(), this, this.jhv);
        this.jwq = new SelectMusicModel(getPageContext(), this);
        this.jwu = new com.baidu.tieba.video.editvideo.b.a(this);
        this.jwu.a(this);
        this.jwo = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.jhv);
        this.jwo.setData(this.alH);
        this.jwo.aA(getIntent());
        this.jwo.a(this.jwu);
        this.jwo.setGenMaskCoverListener(this);
        this.jwp.cva();
        this.jwq.cvb();
        this.fmn = new com.baidu.tbadk.core.view.b(getPageContext());
        this.fmn.iz(R.string.mixing);
        registerListener(this.jww);
        cuw();
        registerListener(this.jwv);
        cuv();
        TiebaStatic.log("c12303");
    }

    private void cuu() {
        this.AQ = true;
        this.jws = null;
        this.jwr = null;
        brW();
    }

    public void cuv() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.eFF)) {
            httpMessage.addParam("forum_id", this.eFF);
        }
        sendMessage(httpMessage);
    }

    private void cuw() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jwo.getRootView());
        if (this.jwo != null) {
            this.jwo.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jwo != null) {
            this.jwo.onPause();
        }
        if (this.jwu.cuF()) {
            this.jwu.cuG();
        }
        this.jwt = false;
        this.AQ = true;
        cuu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jwo != null) {
            this.jwo.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.cuV().cuW();
        com.baidu.tieba.video.editvideo.model.b.cuY().cuZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jwo != null) {
            this.jwo.release();
        }
        if (this.jwp != null) {
            this.jwp.cancelLoadData();
        }
        if (this.jwq != null) {
            this.jwq.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jwo != null) {
            this.jwo.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        brW();
        this.jwt = false;
        if (this.jwo != null && this.jwo.cvn() != null) {
            this.jwo.cvn().pause();
            this.jwo.cvn().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cux() {
        if (this.jwo == null || this.jwp == null || this.jwq == null) {
            brW();
            this.jwt = false;
        } else if (!j.kc()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.jwt) {
            this.jwt = true;
            this.AQ = false;
            this.jws = null;
            this.jwr = null;
            this.jwo.onPause();
            this.fmn.ej(true);
            cuz();
        }
    }

    private void brW() {
        if (this.fmn != null) {
            this.fmn.ej(false);
        }
    }

    private void cuy() {
        if (this.AQ) {
            this.AQ = false;
        } else if (this.jwo.cvu()) {
            this.jwq.e(this.alH, this.jwo.cvs(), c.juG + "video_" + System.currentTimeMillis() + ".mp4", this.jwo.isMute() ? false : true);
        } else if (this.jwo.isMute()) {
            this.jwq.e(this.alH, null, c.juG + "video_" + System.currentTimeMillis() + ".mp4", this.jwo.isMute() ? false : true);
        } else {
            t(this.alH, -4399, "");
        }
    }

    private void cuz() {
        if (this.AQ) {
            this.AQ = false;
            return;
        }
        String text = this.jwo.getText();
        if (TextUtils.isEmpty(text)) {
            this.jwp.bq(this.alH, this.jwo.getCurrentPosition());
        } else {
            this.jwp.Cz(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cuA() {
        File file;
        this.AQ = false;
        if (this.jwo.cvu() || this.jwo.isMute()) {
            this.jwt = false;
            this.fmn.ej(true);
            this.jwo.onPause();
            if (this.jws != null) {
                t(this.jws, -4399, "");
            } else {
                cuy();
            }
        } else if (this.jwu.cuE()) {
            this.jwt = false;
            this.jwo.onPause();
            this.fmn.ej(true);
            FI(this.alH);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.bQ(new File(this.alH).getAbsolutePath(), c.juH + file.getName());
                FK(c.juH + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void caH() {
        if (this.jwo == null || this.jwp == null) {
            brW();
            this.jwt = false;
        } else if (this.AQ) {
            this.AQ = false;
        } else {
            this.jwp.bq(this.alH, this.jwo.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Cw(String str) {
        if (this.AQ) {
            this.AQ = false;
        } else if (this.jwt) {
            showToast(str);
            brW();
            this.jwt = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void H(Bitmap bitmap) {
        this.jwo.cvn().L(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void FG(String str) {
        if (this.AQ) {
            this.AQ = false;
            return;
        }
        this.jwr = str;
        cuy();
    }

    private void cuB() {
        if (this.AQ) {
            this.AQ = false;
        } else if (!TextUtils.isEmpty(this.jwr) && !TextUtils.isEmpty(this.jws)) {
            this.mVideoInfo.setVideoPath(this.jws);
            this.mVideoInfo.setThumbPath(this.jwr);
            if (this.jwo.cvu() && !TextUtils.isEmpty(this.jwo.cvt())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.jwo.cvt());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.fTQ, this.eFF, this.mForumName, this.jwm, 13003, this.mVideoInfo, this.mVideoTitleData, this.jwn);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            writeVideoActivityConfig.setProZone(this.jwl);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            brW();
            this.jwt = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(R.string.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(R.string.music_cloud)));
        this.jwo.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
        if (this.AQ) {
            this.AQ = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.mixing_fail);
            brW();
            this.jwo.onResume();
            this.jwt = false;
            if (this.jhv != null) {
                this.jhv.ax(i, str2);
            }
        } else if (this.jwu.cuE()) {
            FI(str);
        } else {
            FJ(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cuC() {
        this.jws = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void eo(List<PendantData> list) {
        this.jwo.eo(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String FN = com.baidu.tieba.video.editvideo.model.a.cuV().FN(stringExtra);
                if (this.jwo != null && !TextUtils.isEmpty(FN)) {
                    this.jwo.et(FN, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void FH(String str) {
        FJ(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aK(int i, String str) {
        if (this.jhv != null) {
            this.jhv.ax(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aL(int i, String str) {
        if (this.jhv != null) {
            this.jhv.ax(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void d(Bitmap bitmap, boolean z) {
        I(bitmap);
    }

    private void FI(String str) {
        this.jwo.cvq();
        this.jwo.cvr();
        this.jwo.cvn().releaseSource();
        this.jwu.FM(str);
    }

    private void FJ(String str) {
        File file;
        this.jws = str;
        if (this.jwt) {
            cuB();
            return;
        }
        String str2 = c.juH + file.getName();
        m.bQ(new File(this.jws).getAbsolutePath(), str2);
        FK(str2);
        brW();
        finishPage();
    }

    private void FK(String str) {
        try {
            new w(this).nQ(str);
            com.baidu.tieba.video.editvideo.b.c.aL(this, str);
        } catch (Exception e) {
            brW();
            this.jwt = false;
        }
    }

    private void I(Bitmap bitmap) {
        if (this.jwo == null || this.jwp == null) {
            brW();
            this.jwt = false;
        } else if (this.AQ) {
            this.AQ = false;
        } else {
            if (!TextUtils.isEmpty(this.jwo.getText())) {
                bitmap = this.jwo.B(bitmap);
            }
            if (bitmap != null) {
                this.jwp.b(bitmap, c.juF);
            }
        }
    }
}
