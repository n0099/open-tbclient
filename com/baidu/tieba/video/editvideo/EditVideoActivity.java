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
    private String awr;
    private String emb;
    private String gNY;
    private com.baidu.tbadk.core.view.a gOt;
    private h khN;
    private int kwl;
    private String kwm;
    private List<VideoTitleData> kwn;
    private com.baidu.tieba.video.editvideo.view.a kwo;
    private SelectCoverModel kwp;
    private SelectMusicModel kwq;
    private String kwr;
    private boolean kws;
    private com.baidu.tieba.video.editvideo.b.a kwt;
    private HttpMessageListener kwu;
    private CustomMessageListener kwv;
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
            this.khN = lVar.cgY();
        }
        this.kwu = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.kwn = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.kwv = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.emb = getIntent().getStringExtra("forum_id");
        this.kwl = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.kwm = getIntent().getStringExtra("video_title");
        this.gNY = getIntent().getStringExtra("KEY_CALL_FROM");
        this.awr = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.kuO).mkdirs();
        this.kwp = new SelectCoverModel(getPageContext(), this, this.khN);
        this.kwq = new SelectMusicModel(getPageContext(), this);
        this.kwt = new com.baidu.tieba.video.editvideo.b.a(this);
        this.kwt.a(this);
        this.kwo = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.khN);
        this.kwo.setData(this.mVideoPath);
        this.kwo.aA(getIntent());
        this.kwo.a(this.kwt);
        this.kwo.setGenMaskCoverListener(this);
        this.kwp.cQd();
        this.kwq.cQe();
        this.gOt = new com.baidu.tbadk.core.view.a(getPageContext());
        this.gOt.setTipString(R.string.mixing);
        registerListener(this.kwv);
        cPD();
        registerListener(this.kwu);
        cPC();
        TiebaStatic.log("c12303");
    }

    private void cPB() {
        this.rp = true;
        this.kwr = null;
        this.mCoverPath = null;
        bJN();
    }

    public void cPC() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.emb)) {
            httpMessage.addParam("forum_id", this.emb);
        }
        sendMessage(httpMessage);
    }

    private void cPD() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.kwo.getRootView());
        if (this.kwo != null) {
            this.kwo.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.kwo != null) {
            this.kwo.onPause();
        }
        if (this.kwt.cPM()) {
            this.kwt.interruptProcess();
        }
        this.kws = false;
        this.rp = true;
        cPB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kwo != null) {
            this.kwo.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.cPY().cPZ();
        com.baidu.tieba.video.editvideo.model.b.cQb().cQc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kwo != null) {
            this.kwo.release();
        }
        if (this.kwp != null) {
            this.kwp.cancelLoadData();
        }
        if (this.kwq != null) {
            this.kwq.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kwo != null) {
            this.kwo.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        bJN();
        this.kws = false;
        if (this.kwo != null && this.kwo.cQo() != null) {
            this.kwo.cQo().pause();
            this.kwo.cQo().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.kwo == null || this.kwp == null || this.kwq == null) {
            bJN();
            this.kws = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.kws) {
            this.kws = true;
            this.rp = false;
            this.kwr = null;
            this.mCoverPath = null;
            this.kwo.onPause();
            this.gOt.setDialogVisiable(true);
            cPF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJN() {
        if (this.gOt != null) {
            this.gOt.setDialogVisiable(false);
        }
    }

    private void cPE() {
        if (this.rp) {
            this.rp = false;
        } else if (this.kwo.cQv()) {
            this.kwq.h(this.mVideoPath, this.kwo.cQt(), c.kuN + "video_" + System.currentTimeMillis() + ".mp4", this.kwo.isMute() ? false : true);
        } else if (this.kwo.isMute()) {
            this.kwq.h(this.mVideoPath, null, c.kuN + "video_" + System.currentTimeMillis() + ".mp4", this.kwo.isMute() ? false : true);
        } else {
            v(this.mVideoPath, -4399, "");
        }
    }

    private void cPF() {
        if (this.rp) {
            this.rp = false;
            return;
        }
        String text = this.kwo.getText();
        if (TextUtils.isEmpty(text)) {
            this.kwp.bw(this.mVideoPath, this.kwo.getCurrentPosition());
        } else {
            this.kwp.GA(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cPG() {
        File file;
        this.rp = false;
        if (this.kwo.cQv() || this.kwo.isMute()) {
            this.kws = false;
            this.gOt.setDialogVisiable(true);
            this.kwo.onPause();
            if (this.kwr != null) {
                v(this.kwr, -4399, "");
            } else {
                cPE();
            }
        } else if (this.kwt.cPL()) {
            this.kws = false;
            this.kwo.onPause();
            this.gOt.setDialogVisiable(true);
            JV(this.mVideoPath);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.copyFile(new File(this.mVideoPath).getAbsolutePath(), c.kuO + file.getName());
                JX(c.kuO + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cur() {
        if (this.kwo == null || this.kwp == null) {
            bJN();
            this.kws = false;
        } else if (this.rp) {
            this.rp = false;
        } else {
            this.kwp.bw(this.mVideoPath, this.kwo.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Gy(String str) {
        if (this.rp) {
            this.rp = false;
        } else if (this.kws) {
            showToast(str);
            bJN();
            this.kws = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void G(Bitmap bitmap) {
        this.kwo.cQo().K(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void JU(String str) {
        if (this.rp) {
            this.rp = false;
            return;
        }
        this.mCoverPath = str;
        cPE();
    }

    private void cPH() {
        if (this.rp) {
            this.rp = false;
        } else if (!TextUtils.isEmpty(this.mCoverPath) && !TextUtils.isEmpty(this.kwr)) {
            this.mVideoInfo.setVideoPath(this.kwr);
            this.mVideoInfo.setThumbPath(this.mCoverPath);
            if (this.kwo.cQv() && !TextUtils.isEmpty(this.kwo.cQu())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.kwo.cQu());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.gNY, this.emb, this.mForumName, this.kwm, RequestResponseCode.REQUEST_WRITE_NEW, this.mVideoInfo, this.mVideoTitleData, this.kwn);
            if (!StringUtils.isNull(this.awr)) {
                writeVideoActivityConfig.addFromType(this.awr);
            }
            writeVideoActivityConfig.setProZone(this.kwl);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
            bJN();
            this.kws = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(R.string.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(R.string.music_cloud)));
        this.kwo.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
        if (this.rp) {
            this.rp = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.mixing_fail);
            bJN();
            this.kwo.onResume();
            this.kws = false;
            if (this.khN != null) {
                this.khN.aR(i, str2);
            }
        } else if (this.kwt.cPL()) {
            JV(str);
        } else {
            JW(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cPI() {
        this.kwr = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void ep(List<PendantData> list) {
        this.kwo.ep(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String Ka = com.baidu.tieba.video.editvideo.model.a.cPY().Ka(stringExtra);
                if (this.kwo != null && !TextUtils.isEmpty(Ka)) {
                    this.kwo.eK(Ka, stringExtra2);
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
        if (this.khN != null) {
            this.khN.aR(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void onGenFilterVideoRecordError(int i, String str) {
        if (this.khN != null) {
            this.khN.aR(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void cPJ() {
        e.gx().post(new Runnable() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
            @Override // java.lang.Runnable
            public void run() {
                EditVideoActivity.this.bJN();
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
        this.kwo.cQr();
        this.kwo.cQs();
        this.kwo.cQo().releaseSource();
        this.kwt.JZ(str);
    }

    private void JW(String str) {
        File file;
        this.kwr = str;
        if (this.kws) {
            cPH();
            return;
        }
        String str2 = c.kuO + file.getName();
        m.copyFile(new File(this.kwr).getAbsolutePath(), str2);
        JX(str2);
        bJN();
        finishPage();
    }

    private void JX(String str) {
        try {
            new w(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.bp(this, str);
        } catch (Exception e) {
            bJN();
            this.kws = false;
        }
    }

    private void H(Bitmap bitmap) {
        if (this.kwo == null || this.kwp == null) {
            bJN();
            this.kws = false;
        } else if (this.rp) {
            this.rp = false;
        } else {
            if (!TextUtils.isEmpty(this.kwo.getText())) {
                bitmap = this.kwo.z(bitmap);
            }
            if (bitmap != null) {
                this.kwp.b(bitmap, c.kuM);
            }
        }
    }
}
