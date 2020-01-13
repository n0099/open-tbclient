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
    private h kgF;
    private int kvh;
    private String kvi;
    private List<VideoTitleData> kvj;
    private com.baidu.tieba.video.editvideo.view.a kvk;
    private SelectCoverModel kvl;
    private SelectMusicModel kvm;
    private String kvn;
    private boolean kvo;
    private com.baidu.tieba.video.editvideo.b.a kvp;
    private HttpMessageListener kvq;
    private CustomMessageListener kvr;
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
            this.kgF = lVar.cfr();
        }
        this.kvq = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.kvj = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.kvr = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.kvh = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.kvi = getIntent().getStringExtra("video_title");
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
        new File(c.ktK).mkdirs();
        this.kvl = new SelectCoverModel(getPageContext(), this, this.kgF);
        this.kvm = new SelectMusicModel(getPageContext(), this);
        this.kvp = new com.baidu.tieba.video.editvideo.b.a(this);
        this.kvp.a(this);
        this.kvk = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.kgF);
        this.kvk.setData(this.mVideoPath);
        this.kvk.aA(getIntent());
        this.kvk.a(this.kvp);
        this.kvk.setGenMaskCoverListener(this);
        this.kvl.cOG();
        this.kvm.cOH();
        this.gMs = new com.baidu.tbadk.core.view.a(getPageContext());
        this.gMs.setTipString(R.string.mixing);
        registerListener(this.kvr);
        cOe();
        registerListener(this.kvq);
        cOd();
        TiebaStatic.log("c12303");
    }

    private void cOc() {
        this.ro = true;
        this.kvn = null;
        this.mCoverPath = null;
        bIj();
    }

    public void cOd() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.fKa)) {
            httpMessage.addParam("forum_id", this.fKa);
        }
        sendMessage(httpMessage);
    }

    private void cOe() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.kvk.getRootView());
        if (this.kvk != null) {
            this.kvk.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.kvk != null) {
            this.kvk.onPause();
        }
        if (this.kvp.cOm()) {
            this.kvp.interruptProcess();
        }
        this.kvo = false;
        this.ro = true;
        cOc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kvk != null) {
            this.kvk.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.cOB().cOC();
        com.baidu.tieba.video.editvideo.model.b.cOE().cOF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kvk != null) {
            this.kvk.release();
        }
        if (this.kvl != null) {
            this.kvl.cancelLoadData();
        }
        if (this.kvm != null) {
            this.kvm.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kvk != null) {
            this.kvk.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        bIj();
        this.kvo = false;
        if (this.kvk != null && this.kvk.cOR() != null) {
            this.kvk.cOR().pause();
            this.kvk.cOR().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.kvk == null || this.kvl == null || this.kvm == null) {
            bIj();
            this.kvo = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.kvo) {
            this.kvo = true;
            this.ro = false;
            this.kvn = null;
            this.mCoverPath = null;
            this.kvk.onPause();
            this.gMs.setDialogVisiable(true);
            cOg();
        }
    }

    private void bIj() {
        if (this.gMs != null) {
            this.gMs.setDialogVisiable(false);
        }
    }

    private void cOf() {
        if (this.ro) {
            this.ro = false;
        } else if (this.kvk.cOY()) {
            this.kvm.h(this.mVideoPath, this.kvk.cOW(), c.ktJ + "video_" + System.currentTimeMillis() + ".mp4", this.kvk.isMute() ? false : true);
        } else if (this.kvk.isMute()) {
            this.kvm.h(this.mVideoPath, null, c.ktJ + "video_" + System.currentTimeMillis() + ".mp4", this.kvk.isMute() ? false : true);
        } else {
            u(this.mVideoPath, -4399, "");
        }
    }

    private void cOg() {
        if (this.ro) {
            this.ro = false;
            return;
        }
        String text = this.kvk.getText();
        if (TextUtils.isEmpty(text)) {
            this.kvl.bx(this.mVideoPath, this.kvk.getCurrentPosition());
        } else {
            this.kvl.Gm(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cOh() {
        File file;
        this.ro = false;
        if (this.kvk.cOY() || this.kvk.isMute()) {
            this.kvo = false;
            this.gMs.setDialogVisiable(true);
            this.kvk.onPause();
            if (this.kvn != null) {
                u(this.kvn, -4399, "");
            } else {
                cOf();
            }
        } else if (this.kvp.cOl()) {
            this.kvo = false;
            this.kvk.onPause();
            this.gMs.setDialogVisiable(true);
            JI(this.mVideoPath);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.copyFile(new File(this.mVideoPath).getAbsolutePath(), c.ktK + file.getName());
                JK(c.ktK + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void csU() {
        if (this.kvk == null || this.kvl == null) {
            bIj();
            this.kvo = false;
        } else if (this.ro) {
            this.ro = false;
        } else {
            this.kvl.bx(this.mVideoPath, this.kvk.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Gj(String str) {
        if (this.ro) {
            this.ro = false;
        } else if (this.kvo) {
            showToast(str);
            bIj();
            this.kvo = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void G(Bitmap bitmap) {
        this.kvk.cOR().K(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void JH(String str) {
        if (this.ro) {
            this.ro = false;
            return;
        }
        this.mCoverPath = str;
        cOf();
    }

    private void cOi() {
        if (this.ro) {
            this.ro = false;
        } else if (!TextUtils.isEmpty(this.mCoverPath) && !TextUtils.isEmpty(this.kvn)) {
            this.mVideoInfo.setVideoPath(this.kvn);
            this.mVideoInfo.setThumbPath(this.mCoverPath);
            if (this.kvk.cOY() && !TextUtils.isEmpty(this.kvk.cOX())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.kvk.cOX());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.gLX, this.fKa, this.mForumName, this.kvi, RequestResponseCode.REQUEST_WRITE_NEW, this.mVideoInfo, this.mVideoTitleData, this.kvj);
            if (!StringUtils.isNull(this.asg)) {
                writeVideoActivityConfig.addFromType(this.asg);
            }
            writeVideoActivityConfig.setProZone(this.kvh);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
            bIj();
            this.kvo = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(R.string.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(R.string.music_cloud)));
        this.kvk.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
        if (this.ro) {
            this.ro = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.mixing_fail);
            bIj();
            this.kvk.onResume();
            this.kvo = false;
            if (this.kgF != null) {
                this.kgF.aR(i, str2);
            }
        } else if (this.kvp.cOl()) {
            JI(str);
        } else {
            JJ(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cOj() {
        this.kvn = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void et(List<PendantData> list) {
        this.kvk.et(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String JN = com.baidu.tieba.video.editvideo.model.a.cOB().JN(stringExtra);
                if (this.kvk != null && !TextUtils.isEmpty(JN)) {
                    this.kvk.eB(JN, stringExtra2);
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
        if (this.kgF != null) {
            this.kgF.aR(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void onGenFilterVideoRecordError(int i, String str) {
        if (this.kgF != null) {
            this.kgF.aR(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        H(bitmap);
    }

    private void JI(String str) {
        this.kvk.cOU();
        this.kvk.cOV();
        this.kvk.cOR().releaseSource();
        this.kvp.JM(str);
    }

    private void JJ(String str) {
        File file;
        this.kvn = str;
        if (this.kvo) {
            cOi();
            return;
        }
        String str2 = c.ktK + file.getName();
        m.copyFile(new File(this.kvn).getAbsolutePath(), str2);
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
            this.kvo = false;
        }
    }

    private void H(Bitmap bitmap) {
        if (this.kvk == null || this.kvl == null) {
            bIj();
            this.kvo = false;
        } else if (this.ro) {
            this.ro = false;
        } else {
            if (!TextUtils.isEmpty(this.kvk.getText())) {
                bitmap = this.kvk.z(bitmap);
            }
            if (bitmap != null) {
                this.kvl.b(bitmap, c.ktI);
            }
        }
    }
}
