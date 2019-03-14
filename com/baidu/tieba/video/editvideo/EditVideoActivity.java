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
/* loaded from: classes5.dex */
public class EditVideoActivity extends BaseActivity implements a, b, b.a, MaskVideoView.b {
    private boolean Dc;
    private String akM;
    private com.baidu.tbadk.core.view.b eQQ;
    private String ela;
    private String fxu;
    private h iHn;
    private int iWg;
    private String iWh;
    private List<VideoTitleData> iWi;
    private com.baidu.tieba.video.editvideo.view.a iWj;
    private SelectCoverModel iWk;
    private SelectMusicModel iWl;
    private String iWm;
    private String iWn;
    private boolean iWo;
    private com.baidu.tieba.video.editvideo.b.a iWp;
    private HttpMessageListener iWq;
    private CustomMessageListener iWr;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.iHn = lVar.bEC();
        }
        this.iWq = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.iWi = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.iWr = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.ela = getIntent().getStringExtra("forum_id");
        this.iWg = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.iWh = getIntent().getStringExtra("video_title");
        this.fxu = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.akM = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.akM) && !new File(this.akM).exists()) {
            finishPage();
        }
        new File(c.iUC).mkdirs();
        this.iWk = new SelectCoverModel(getPageContext(), this, this.iHn);
        this.iWl = new SelectMusicModel(getPageContext(), this);
        this.iWp = new com.baidu.tieba.video.editvideo.b.a(this);
        this.iWp.a(this);
        this.iWj = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(d.g.root_layout), this.iHn);
        this.iWj.setData(this.akM);
        this.iWj.av(getIntent());
        this.iWj.a(this.iWp);
        this.iWj.setGenMaskCoverListener(this);
        this.iWk.cjP();
        this.iWl.cjQ();
        this.eQQ = new com.baidu.tbadk.core.view.b(getPageContext());
        this.eQQ.hG(d.j.mixing);
        registerListener(this.iWr);
        cjl();
        registerListener(this.iWq);
        cjk();
        TiebaStatic.log("c12303");
    }

    private void cjj() {
        this.Dc = true;
        this.iWn = null;
        this.iWm = null;
        bip();
    }

    public void cjk() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.ela)) {
            httpMessage.addParam("forum_id", this.ela);
        }
        sendMessage(httpMessage);
    }

    private void cjl() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iWj.getRootView());
        if (this.iWj != null) {
            this.iWj.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.iWj != null) {
            this.iWj.onPause();
        }
        if (this.iWp.cju()) {
            this.iWp.cjv();
        }
        this.iWo = false;
        this.Dc = true;
        cjj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iWj != null) {
            this.iWj.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.cjK().cjL();
        com.baidu.tieba.video.editvideo.model.b.cjN().cjO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iWj != null) {
            this.iWj.release();
        }
        if (this.iWk != null) {
            this.iWk.cancelLoadData();
        }
        if (this.iWl != null) {
            this.iWl.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.iWj != null) {
            this.iWj.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        bip();
        this.iWo = false;
        if (this.iWj != null && this.iWj.ckc() != null) {
            this.iWj.ckc().pause();
            this.iWj.ckc().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cjm() {
        if (this.iWj == null || this.iWk == null || this.iWl == null) {
            bip();
            this.iWo = false;
        } else if (!j.kY()) {
            getPageContext().showToast(d.j.no_network);
        } else if (!this.iWo) {
            this.iWo = true;
            this.Dc = false;
            this.iWn = null;
            this.iWm = null;
            this.iWj.onPause();
            this.eQQ.dJ(true);
            cjo();
        }
    }

    private void bip() {
        if (this.eQQ != null) {
            this.eQQ.dJ(false);
        }
    }

    private void cjn() {
        if (this.Dc) {
            this.Dc = false;
        } else if (this.iWj.ckj()) {
            this.iWl.e(this.akM, this.iWj.ckh(), c.iUB + "video_" + System.currentTimeMillis() + ".mp4", this.iWj.isMute() ? false : true);
        } else if (this.iWj.isMute()) {
            this.iWl.e(this.akM, null, c.iUB + "video_" + System.currentTimeMillis() + ".mp4", this.iWj.isMute() ? false : true);
        } else {
            p(this.akM, -4399, "");
        }
    }

    private void cjo() {
        if (this.Dc) {
            this.Dc = false;
            return;
        }
        String text = this.iWj.getText();
        if (TextUtils.isEmpty(text)) {
            this.iWk.bt(this.akM, this.iWj.getCurrentPosition());
        } else {
            this.iWk.Au(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cjp() {
        File file;
        this.Dc = false;
        if (this.iWj.ckj() || this.iWj.isMute()) {
            this.iWo = false;
            this.eQQ.dJ(true);
            this.iWj.onPause();
            if (this.iWn != null) {
                p(this.iWn, -4399, "");
            } else {
                cjn();
            }
        } else if (this.iWp.cjt()) {
            this.iWo = false;
            this.iWj.onPause();
            this.eQQ.dJ(true);
            Dw(this.akM);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.bG(new File(this.akM).getAbsolutePath(), c.iUC + file.getName());
                Dy(c.iUC + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bPG() {
        if (this.iWj == null || this.iWk == null) {
            bip();
            this.iWo = false;
        } else if (this.Dc) {
            this.Dc = false;
        } else {
            this.iWk.bt(this.akM, this.iWj.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void As(String str) {
        if (this.Dc) {
            this.Dc = false;
        } else if (this.iWo) {
            showToast(str);
            bip();
            this.iWo = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void G(Bitmap bitmap) {
        this.iWj.ckc().K(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Du(String str) {
        if (this.Dc) {
            this.Dc = false;
            return;
        }
        this.iWm = str;
        cjn();
    }

    private void cjq() {
        if (this.Dc) {
            this.Dc = false;
        } else if (!TextUtils.isEmpty(this.iWm) && !TextUtils.isEmpty(this.iWn)) {
            this.mVideoInfo.setVideoPath(this.iWn);
            this.mVideoInfo.setThumbPath(this.iWm);
            if (this.iWj.ckj() && !TextUtils.isEmpty(this.iWj.cki())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.iWj.cki());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.fxu, this.ela, this.mForumName, this.iWh, 13003, this.mVideoInfo, this.mVideoTitleData, this.iWi);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            writeVideoActivityConfig.setProZone(this.iWg);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            bip();
            this.iWo = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(d.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(d.j.music_cloud)));
        this.iWj.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void p(String str, int i, String str2) {
        if (this.Dc) {
            this.Dc = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(d.j.mixing_fail);
            bip();
            this.iWj.onResume();
            this.iWo = false;
            if (this.iHn != null) {
                this.iHn.as(i, str2);
            }
        } else if (this.iWp.cjt()) {
            Dw(str);
        } else {
            Dx(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cjr() {
        this.iWn = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void ef(List<PendantData> list) {
        this.iWj.ef(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String DB = com.baidu.tieba.video.editvideo.model.a.cjK().DB(stringExtra);
                if (this.iWj != null && !TextUtils.isEmpty(DB)) {
                    this.iWj.ed(DB, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void Dv(String str) {
        Dx(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aF(int i, String str) {
        if (this.iHn != null) {
            this.iHn.as(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aG(int i, String str) {
        if (this.iHn != null) {
            this.iHn.as(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        H(bitmap);
    }

    private void Dw(String str) {
        this.iWj.ckf();
        this.iWj.ckg();
        this.iWj.ckc().releaseSource();
        this.iWp.DA(str);
    }

    private void Dx(String str) {
        File file;
        this.iWn = str;
        if (this.iWo) {
            cjq();
            return;
        }
        String str2 = c.iUC + file.getName();
        m.bG(new File(this.iWn).getAbsolutePath(), str2);
        Dy(str2);
        bip();
        finishPage();
    }

    private void Dy(String str) {
        try {
            new w(this).mw(str);
            com.baidu.tieba.video.editvideo.b.c.aW(this, str);
        } catch (Exception e) {
            bip();
            this.iWo = false;
        }
    }

    private void H(Bitmap bitmap) {
        if (this.iWj == null || this.iWk == null) {
            bip();
            this.iWo = false;
        } else if (this.Dc) {
            this.Dc = false;
        } else {
            if (!TextUtils.isEmpty(this.iWj.getText())) {
                bitmap = this.iWj.A(bitmap);
            }
            if (bitmap != null) {
                this.iWk.b(bitmap, c.iUA);
            }
        }
    }
}
