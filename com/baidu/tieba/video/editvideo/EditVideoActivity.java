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
/* loaded from: classes8.dex */
public class EditVideoActivity extends BaseActivity implements a, b, b.a, MaskVideoView.b {
    private String asg;
    private String fKa;
    private String gLX;
    private com.baidu.tbadk.core.view.a gMs;
    private h kgK;
    private int kvm;
    private String kvn;
    private List<VideoTitleData> kvo;
    private com.baidu.tieba.video.editvideo.view.a kvp;
    private SelectCoverModel kvq;
    private SelectMusicModel kvr;
    private String kvs;
    private boolean kvt;
    private com.baidu.tieba.video.editvideo.b.a kvu;
    private HttpMessageListener kvv;
    private CustomMessageListener kvw;
    private String mCoverPath;
    private String mForumName;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;
    private boolean ro;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.kgK = lVar.cfr();
        }
        this.kvv = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.kvo = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.kvw = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.fKa = getIntent().getStringExtra("forum_id");
        this.kvm = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.kvn = getIntent().getStringExtra("video_title");
        this.gLX = getIntent().getStringExtra("KEY_CALL_FROM");
        this.asg = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.ktP).mkdirs();
        this.kvq = new SelectCoverModel(getPageContext(), this, this.kgK);
        this.kvr = new SelectMusicModel(getPageContext(), this);
        this.kvu = new com.baidu.tieba.video.editvideo.b.a(this);
        this.kvu.a(this);
        this.kvp = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.kgK);
        this.kvp.setData(this.mVideoPath);
        this.kvp.aA(getIntent());
        this.kvp.a(this.kvu);
        this.kvp.setGenMaskCoverListener(this);
        this.kvq.cOI();
        this.kvr.cOJ();
        this.gMs = new com.baidu.tbadk.core.view.a(getPageContext());
        this.gMs.setTipString(R.string.mixing);
        registerListener(this.kvw);
        cOg();
        registerListener(this.kvv);
        cOf();
        TiebaStatic.log("c12303");
    }

    private void cOe() {
        this.ro = true;
        this.kvs = null;
        this.mCoverPath = null;
        bIj();
    }

    public void cOf() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.fKa)) {
            httpMessage.addParam("forum_id", this.fKa);
        }
        sendMessage(httpMessage);
    }

    private void cOg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.kvp.getRootView());
        if (this.kvp != null) {
            this.kvp.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.kvp != null) {
            this.kvp.onPause();
        }
        if (this.kvu.cOo()) {
            this.kvu.interruptProcess();
        }
        this.kvt = false;
        this.ro = true;
        cOe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kvp != null) {
            this.kvp.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.cOD().cOE();
        com.baidu.tieba.video.editvideo.model.b.cOG().cOH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kvp != null) {
            this.kvp.release();
        }
        if (this.kvq != null) {
            this.kvq.cancelLoadData();
        }
        if (this.kvr != null) {
            this.kvr.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kvp != null) {
            this.kvp.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        bIj();
        this.kvt = false;
        if (this.kvp != null && this.kvp.cOT() != null) {
            this.kvp.cOT().pause();
            this.kvp.cOT().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.kvp == null || this.kvq == null || this.kvr == null) {
            bIj();
            this.kvt = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.kvt) {
            this.kvt = true;
            this.ro = false;
            this.kvs = null;
            this.mCoverPath = null;
            this.kvp.onPause();
            this.gMs.setDialogVisiable(true);
            cOi();
        }
    }

    private void bIj() {
        if (this.gMs != null) {
            this.gMs.setDialogVisiable(false);
        }
    }

    private void cOh() {
        if (this.ro) {
            this.ro = false;
        } else if (this.kvp.cPa()) {
            this.kvr.h(this.mVideoPath, this.kvp.cOY(), c.ktO + "video_" + System.currentTimeMillis() + ".mp4", this.kvp.isMute() ? false : true);
        } else if (this.kvp.isMute()) {
            this.kvr.h(this.mVideoPath, null, c.ktO + "video_" + System.currentTimeMillis() + ".mp4", this.kvp.isMute() ? false : true);
        } else {
            u(this.mVideoPath, -4399, "");
        }
    }

    private void cOi() {
        if (this.ro) {
            this.ro = false;
            return;
        }
        String text = this.kvp.getText();
        if (TextUtils.isEmpty(text)) {
            this.kvq.bx(this.mVideoPath, this.kvp.getCurrentPosition());
        } else {
            this.kvq.Gm(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cOj() {
        File file;
        this.ro = false;
        if (this.kvp.cPa() || this.kvp.isMute()) {
            this.kvt = false;
            this.gMs.setDialogVisiable(true);
            this.kvp.onPause();
            if (this.kvs != null) {
                u(this.kvs, -4399, "");
            } else {
                cOh();
            }
        } else if (this.kvu.cOn()) {
            this.kvt = false;
            this.kvp.onPause();
            this.gMs.setDialogVisiable(true);
            JI(this.mVideoPath);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.copyFile(new File(this.mVideoPath).getAbsolutePath(), c.ktP + file.getName());
                JK(c.ktP + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void csW() {
        if (this.kvp == null || this.kvq == null) {
            bIj();
            this.kvt = false;
        } else if (this.ro) {
            this.ro = false;
        } else {
            this.kvq.bx(this.mVideoPath, this.kvp.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Gj(String str) {
        if (this.ro) {
            this.ro = false;
        } else if (this.kvt) {
            showToast(str);
            bIj();
            this.kvt = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void G(Bitmap bitmap) {
        this.kvp.cOT().K(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void JH(String str) {
        if (this.ro) {
            this.ro = false;
            return;
        }
        this.mCoverPath = str;
        cOh();
    }

    private void cOk() {
        if (this.ro) {
            this.ro = false;
        } else if (!TextUtils.isEmpty(this.mCoverPath) && !TextUtils.isEmpty(this.kvs)) {
            this.mVideoInfo.setVideoPath(this.kvs);
            this.mVideoInfo.setThumbPath(this.mCoverPath);
            if (this.kvp.cPa() && !TextUtils.isEmpty(this.kvp.cOZ())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.kvp.cOZ());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.gLX, this.fKa, this.mForumName, this.kvn, RequestResponseCode.REQUEST_WRITE_NEW, this.mVideoInfo, this.mVideoTitleData, this.kvo);
            if (!StringUtils.isNull(this.asg)) {
                writeVideoActivityConfig.addFromType(this.asg);
            }
            writeVideoActivityConfig.setProZone(this.kvm);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
            bIj();
            this.kvt = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(R.string.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(R.string.music_cloud)));
        this.kvp.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
        if (this.ro) {
            this.ro = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.mixing_fail);
            bIj();
            this.kvp.onResume();
            this.kvt = false;
            if (this.kgK != null) {
                this.kgK.aR(i, str2);
            }
        } else if (this.kvu.cOn()) {
            JI(str);
        } else {
            JJ(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cOl() {
        this.kvs = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void et(List<PendantData> list) {
        this.kvp.et(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String JN = com.baidu.tieba.video.editvideo.model.a.cOD().JN(stringExtra);
                if (this.kvp != null && !TextUtils.isEmpty(JN)) {
                    this.kvp.eB(JN, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void onGenFilterVideoSuccess(String str) {
        JJ(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void onGenFilterVideoFail(int i, String str) {
        if (this.kgK != null) {
            this.kgK.aR(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void onGenFilterVideoRecordError(int i, String str) {
        if (this.kgK != null) {
            this.kgK.aR(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        H(bitmap);
    }

    private void JI(String str) {
        this.kvp.cOW();
        this.kvp.cOX();
        this.kvp.cOT().releaseSource();
        this.kvu.JM(str);
    }

    private void JJ(String str) {
        File file;
        this.kvs = str;
        if (this.kvt) {
            cOk();
            return;
        }
        String str2 = c.ktP + file.getName();
        m.copyFile(new File(this.kvs).getAbsolutePath(), str2);
        JK(str2);
        bIj();
        finishPage();
    }

    private void JK(String str) {
        try {
            new w(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.bp(this, str);
        } catch (Exception e) {
            bIj();
            this.kvt = false;
        }
    }

    private void H(Bitmap bitmap) {
        if (this.kvp == null || this.kvq == null) {
            bIj();
            this.kvt = false;
        } else if (this.ro) {
            this.ro = false;
        } else {
            if (!TextUtils.isEmpty(this.kvp.getText())) {
                bitmap = this.kvp.z(bitmap);
            }
            if (bitmap != null) {
                this.kvq.b(bitmap, c.ktN);
            }
        }
    }
}
