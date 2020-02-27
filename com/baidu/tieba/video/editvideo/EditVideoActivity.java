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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.k.h;
import com.baidu.tieba.k.l;
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
/* loaded from: classes10.dex */
public class EditVideoActivity extends BaseActivity implements a, b, b.a, MaskVideoView.b {
    private String awq;
    private String ema;
    private String gNW;
    private com.baidu.tbadk.core.view.a gOr;
    private h khL;
    private int kwj;
    private String kwk;
    private List<VideoTitleData> kwl;
    private com.baidu.tieba.video.editvideo.view.a kwm;
    private SelectCoverModel kwn;
    private SelectMusicModel kwo;
    private String kwp;
    private boolean kwq;
    private com.baidu.tieba.video.editvideo.b.a kwr;
    private HttpMessageListener kws;
    private CustomMessageListener kwt;
    private String mCoverPath;
    private String mForumName;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;
    private boolean rp;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.khL = lVar.cgW();
        }
        this.kws = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.kwl = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.kwt = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.ema = getIntent().getStringExtra("forum_id");
        this.kwj = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.kwk = getIntent().getStringExtra("video_title");
        this.gNW = getIntent().getStringExtra("KEY_CALL_FROM");
        this.awq = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.kuM).mkdirs();
        this.kwn = new SelectCoverModel(getPageContext(), this, this.khL);
        this.kwo = new SelectMusicModel(getPageContext(), this);
        this.kwr = new com.baidu.tieba.video.editvideo.b.a(this);
        this.kwr.a(this);
        this.kwm = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.khL);
        this.kwm.setData(this.mVideoPath);
        this.kwm.aA(getIntent());
        this.kwm.a(this.kwr);
        this.kwm.setGenMaskCoverListener(this);
        this.kwn.cQb();
        this.kwo.cQc();
        this.gOr = new com.baidu.tbadk.core.view.a(getPageContext());
        this.gOr.setTipString(R.string.mixing);
        registerListener(this.kwt);
        cPB();
        registerListener(this.kws);
        cPA();
        TiebaStatic.log("c12303");
    }

    private void cPz() {
        this.rp = true;
        this.kwp = null;
        this.mCoverPath = null;
        bJL();
    }

    public void cPA() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.ema)) {
            httpMessage.addParam("forum_id", this.ema);
        }
        sendMessage(httpMessage);
    }

    private void cPB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.kwm.getRootView());
        if (this.kwm != null) {
            this.kwm.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.kwm != null) {
            this.kwm.onPause();
        }
        if (this.kwr.cPK()) {
            this.kwr.interruptProcess();
        }
        this.kwq = false;
        this.rp = true;
        cPz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kwm != null) {
            this.kwm.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.cPW().cPX();
        com.baidu.tieba.video.editvideo.model.b.cPZ().cQa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kwm != null) {
            this.kwm.release();
        }
        if (this.kwn != null) {
            this.kwn.cancelLoadData();
        }
        if (this.kwo != null) {
            this.kwo.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kwm != null) {
            this.kwm.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        bJL();
        this.kwq = false;
        if (this.kwm != null && this.kwm.cQm() != null) {
            this.kwm.cQm().pause();
            this.kwm.cQm().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.kwm == null || this.kwn == null || this.kwo == null) {
            bJL();
            this.kwq = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.kwq) {
            this.kwq = true;
            this.rp = false;
            this.kwp = null;
            this.mCoverPath = null;
            this.kwm.onPause();
            this.gOr.setDialogVisiable(true);
            cPD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJL() {
        if (this.gOr != null) {
            this.gOr.setDialogVisiable(false);
        }
    }

    private void cPC() {
        if (this.rp) {
            this.rp = false;
        } else if (this.kwm.cQt()) {
            this.kwo.h(this.mVideoPath, this.kwm.cQr(), c.kuL + "video_" + System.currentTimeMillis() + ".mp4", this.kwm.isMute() ? false : true);
        } else if (this.kwm.isMute()) {
            this.kwo.h(this.mVideoPath, null, c.kuL + "video_" + System.currentTimeMillis() + ".mp4", this.kwm.isMute() ? false : true);
        } else {
            v(this.mVideoPath, -4399, "");
        }
    }

    private void cPD() {
        if (this.rp) {
            this.rp = false;
            return;
        }
        String text = this.kwm.getText();
        if (TextUtils.isEmpty(text)) {
            this.kwn.bw(this.mVideoPath, this.kwm.getCurrentPosition());
        } else {
            this.kwn.GA(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cPE() {
        File file;
        this.rp = false;
        if (this.kwm.cQt() || this.kwm.isMute()) {
            this.kwq = false;
            this.gOr.setDialogVisiable(true);
            this.kwm.onPause();
            if (this.kwp != null) {
                v(this.kwp, -4399, "");
            } else {
                cPC();
            }
        } else if (this.kwr.cPJ()) {
            this.kwq = false;
            this.kwm.onPause();
            this.gOr.setDialogVisiable(true);
            JV(this.mVideoPath);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.copyFile(new File(this.mVideoPath).getAbsolutePath(), c.kuM + file.getName());
                JX(c.kuM + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cup() {
        if (this.kwm == null || this.kwn == null) {
            bJL();
            this.kwq = false;
        } else if (this.rp) {
            this.rp = false;
        } else {
            this.kwn.bw(this.mVideoPath, this.kwm.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Gy(String str) {
        if (this.rp) {
            this.rp = false;
        } else if (this.kwq) {
            showToast(str);
            bJL();
            this.kwq = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void G(Bitmap bitmap) {
        this.kwm.cQm().K(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void JU(String str) {
        if (this.rp) {
            this.rp = false;
            return;
        }
        this.mCoverPath = str;
        cPC();
    }

    private void cPF() {
        if (this.rp) {
            this.rp = false;
        } else if (!TextUtils.isEmpty(this.mCoverPath) && !TextUtils.isEmpty(this.kwp)) {
            this.mVideoInfo.setVideoPath(this.kwp);
            this.mVideoInfo.setThumbPath(this.mCoverPath);
            if (this.kwm.cQt() && !TextUtils.isEmpty(this.kwm.cQs())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.kwm.cQs());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.gNW, this.ema, this.mForumName, this.kwk, RequestResponseCode.REQUEST_WRITE_NEW, this.mVideoInfo, this.mVideoTitleData, this.kwl);
            if (!StringUtils.isNull(this.awq)) {
                writeVideoActivityConfig.addFromType(this.awq);
            }
            writeVideoActivityConfig.setProZone(this.kwj);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
            bJL();
            this.kwq = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(R.string.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(R.string.music_cloud)));
        this.kwm.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
        if (this.rp) {
            this.rp = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.mixing_fail);
            bJL();
            this.kwm.onResume();
            this.kwq = false;
            if (this.khL != null) {
                this.khL.aR(i, str2);
            }
        } else if (this.kwr.cPJ()) {
            JV(str);
        } else {
            JW(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cPG() {
        this.kwp = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void ep(List<PendantData> list) {
        this.kwm.ep(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String Ka = com.baidu.tieba.video.editvideo.model.a.cPW().Ka(stringExtra);
                if (this.kwm != null && !TextUtils.isEmpty(Ka)) {
                    this.kwm.eK(Ka, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void onGenFilterVideoSuccess(String str) {
        JW(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void onGenFilterVideoFail(int i, String str) {
        if (this.khL != null) {
            this.khL.aR(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void onGenFilterVideoRecordError(int i, String str) {
        if (this.khL != null) {
            this.khL.aR(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void cPH() {
        e.gx().post(new Runnable() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
            @Override // java.lang.Runnable
            public void run() {
                EditVideoActivity.this.bJL();
                EditVideoActivity.this.showToast(R.string.mix_fail);
                EditVideoActivity.this.finishPage();
            }
        });
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        H(bitmap);
    }

    private void JV(String str) {
        this.kwm.cQp();
        this.kwm.cQq();
        this.kwm.cQm().releaseSource();
        this.kwr.JZ(str);
    }

    private void JW(String str) {
        File file;
        this.kwp = str;
        if (this.kwq) {
            cPF();
            return;
        }
        String str2 = c.kuM + file.getName();
        m.copyFile(new File(this.kwp).getAbsolutePath(), str2);
        JX(str2);
        bJL();
        finishPage();
    }

    private void JX(String str) {
        try {
            new w(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.bp(this, str);
        } catch (Exception e) {
            bJL();
            this.kwq = false;
        }
    }

    private void H(Bitmap bitmap) {
        if (this.kwm == null || this.kwn == null) {
            bJL();
            this.kwq = false;
        } else if (this.rp) {
            this.rp = false;
        } else {
            if (!TextUtils.isEmpty(this.kwm.getText())) {
                bitmap = this.kwm.z(bitmap);
            }
            if (bitmap != null) {
                this.kwn.b(bitmap, c.kuK);
            }
        }
    }
}
