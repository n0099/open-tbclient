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
import com.baidu.tbadk.core.view.d;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.e;
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
    private boolean Dd;
    private String cXO;
    private d dAf;
    private String eeJ;
    private String hBn;
    private List<VideoTitleData> hBo;
    private com.baidu.tieba.video.editvideo.view.a hBp;
    private SelectCoverModel hBq;
    private SelectMusicModel hBr;
    private String hBs;
    private String hBt;
    private boolean hBu;
    private com.baidu.tieba.video.editvideo.b.a hBv;
    private HttpMessageListener hBw;
    private CustomMessageListener hBx;
    private h hms;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.hms = lVar.bcM();
        }
        this.hBw = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.hBo = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.hBx = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        setContentView(e.h.activity_edit_video);
        this.cXO = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.hBn = getIntent().getStringExtra("video_title");
        this.eeJ = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.hzJ).mkdirs();
        this.hBq = new SelectCoverModel(getPageContext(), this, this.hms);
        this.hBr = new SelectMusicModel(getPageContext(), this);
        this.hBv = new com.baidu.tieba.video.editvideo.b.a(this);
        this.hBv.a(this);
        this.hBp = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(e.g.root_layout), this.hms);
        this.hBp.setData(this.mVideoPath);
        this.hBp.ae(getIntent());
        this.hBp.a(this.hBv);
        this.hBp.setGenMaskCoverListener(this);
        this.hBq.bIR();
        this.hBr.bIS();
        this.dAf = new d(getPageContext());
        this.dAf.ec(e.j.mixing);
        registerListener(this.hBx);
        bIn();
        registerListener(this.hBw);
        bIm();
        TiebaStatic.log("c12303");
    }

    private void bIl() {
        this.Dd = true;
        this.hBt = null;
        this.hBs = null;
        aGO();
    }

    public void bIm() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.cXO)) {
            httpMessage.addParam("forum_id", this.cXO);
        }
        sendMessage(httpMessage);
    }

    private void bIn() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.hBp.getRootView());
        if (this.hBp != null) {
            this.hBp.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hBp != null) {
            this.hBp.onPause();
        }
        if (this.hBv.bIw()) {
            this.hBv.bIx();
        }
        this.hBu = false;
        this.Dd = true;
        bIl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hBp != null) {
            this.hBp.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bIM().bIN();
        com.baidu.tieba.video.editvideo.model.b.bIP().bIQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hBp != null) {
            this.hBp.release();
        }
        if (this.hBq != null) {
            this.hBq.cancelLoadData();
        }
        if (this.hBr != null) {
            this.hBr.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hBp != null) {
            this.hBp.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        aGO();
        this.hBu = false;
        if (this.hBp != null && this.hBp.bJe() != null) {
            this.hBp.bJe().pause();
            this.hBp.bJe().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bIo() {
        if (this.hBp == null || this.hBq == null || this.hBr == null) {
            aGO();
            this.hBu = false;
        } else if (!j.kV()) {
            getPageContext().showToast(e.j.no_network);
        } else if (!this.hBu) {
            this.hBu = true;
            this.Dd = false;
            this.hBt = null;
            this.hBs = null;
            this.hBp.onPause();
            this.dAf.bA(true);
            bIq();
        }
    }

    private void aGO() {
        if (this.dAf != null) {
            this.dAf.bA(false);
        }
    }

    private void bIp() {
        if (this.Dd) {
            this.Dd = false;
        } else if (this.hBp.bJl()) {
            this.hBr.d(this.mVideoPath, this.hBp.bJj(), c.hzI + "video_" + System.currentTimeMillis() + ".mp4", this.hBp.isMute() ? false : true);
        } else if (this.hBp.isMute()) {
            this.hBr.d(this.mVideoPath, null, c.hzI + "video_" + System.currentTimeMillis() + ".mp4", this.hBp.isMute() ? false : true);
        } else {
            m(this.mVideoPath, -4399, "");
        }
    }

    private void bIq() {
        if (this.Dd) {
            this.Dd = false;
            return;
        }
        String text = this.hBp.getText();
        if (TextUtils.isEmpty(text)) {
            this.hBq.aW(this.mVideoPath, this.hBp.getCurrentPosition());
        } else {
            this.hBq.tw(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bIr() {
        File file;
        this.Dd = false;
        if (this.hBp.bJl() || this.hBp.isMute()) {
            this.hBu = false;
            this.dAf.bA(true);
            this.hBp.onPause();
            if (this.hBt != null) {
                m(this.hBt, -4399, "");
            } else {
                bIp();
            }
        } else if (this.hBv.bIv()) {
            this.hBu = false;
            this.hBp.onPause();
            this.dAf.bA(true);
            wC(this.mVideoPath);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.l.copyFile(new File(this.mVideoPath).getAbsolutePath(), c.hzJ + file.getName());
                wE(c.hzJ + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bnO() {
        if (this.hBp == null || this.hBq == null) {
            aGO();
            this.hBu = false;
        } else if (this.Dd) {
            this.Dd = false;
        } else {
            this.hBq.aW(this.mVideoPath, this.hBp.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void tu(String str) {
        if (this.Dd) {
            this.Dd = false;
        } else if (this.hBu) {
            showToast(str);
            aGO();
            this.hBu = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void y(Bitmap bitmap) {
        this.hBp.bJe().C(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void wA(String str) {
        if (this.Dd) {
            this.Dd = false;
            return;
        }
        this.hBs = str;
        bIp();
    }

    private void bIs() {
        if (this.Dd) {
            this.Dd = false;
        } else if (!TextUtils.isEmpty(this.hBs) && !TextUtils.isEmpty(this.hBt)) {
            this.mVideoInfo.setVideoPath(this.hBt);
            this.mVideoInfo.setThumbPath(this.hBs);
            if (this.hBp.bJl() && !TextUtils.isEmpty(this.hBp.bJk())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.hBp.bJk());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.eeJ, this.cXO, this.mForumName, this.hBn, 13003, this.mVideoInfo, this.mVideoTitleData, this.hBo);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            aGO();
            this.hBu = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(e.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(e.j.music_cloud)));
        this.hBp.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void m(String str, int i, String str2) {
        if (this.Dd) {
            this.Dd = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(e.j.mixing_fail);
            aGO();
            this.hBp.onResume();
            this.hBu = false;
            if (this.hms != null) {
                this.hms.Z(i, str2);
            }
        } else if (this.hBv.bIv()) {
            wC(str);
        } else {
            wD(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bIt() {
        this.hBt = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dX(List<PendantData> list) {
        this.hBp.dX(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String wH = com.baidu.tieba.video.editvideo.model.a.bIM().wH(stringExtra);
                if (this.hBp != null && !TextUtils.isEmpty(wH)) {
                    this.hBp.cS(wH, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void wB(String str) {
        wD(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void am(int i, String str) {
        if (this.hms != null) {
            this.hms.Z(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void an(int i, String str) {
        if (this.hms != null) {
            this.hms.Z(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        z(bitmap);
    }

    private void wC(String str) {
        this.hBp.bJh();
        this.hBp.bJi();
        this.hBp.bJe().releaseSource();
        this.hBv.wG(str);
    }

    private void wD(String str) {
        File file;
        this.hBt = str;
        if (this.hBu) {
            bIs();
            return;
        }
        String str2 = c.hzJ + file.getName();
        com.baidu.tbadk.core.util.l.copyFile(new File(this.hBt).getAbsolutePath(), str2);
        wE(str2);
        aGO();
        finishPage();
    }

    private void wE(String str) {
        try {
            new w(this).fy(str);
            com.baidu.tieba.video.editvideo.b.c.aL(this, str);
        } catch (Exception e) {
            aGO();
            this.hBu = false;
        }
    }

    private void z(Bitmap bitmap) {
        if (this.hBp == null || this.hBq == null) {
            aGO();
            this.hBu = false;
        } else if (this.Dd) {
            this.Dd = false;
        } else {
            if (!TextUtils.isEmpty(this.hBp.getText())) {
                bitmap = this.hBp.s(bitmap);
            }
            if (bitmap != null) {
                this.hBq.b(bitmap, c.hzH);
            }
        }
    }
}
