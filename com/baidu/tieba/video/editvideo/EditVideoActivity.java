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
    private d dCS;
    private String daG;
    private String ehA;
    private com.baidu.tieba.video.editvideo.view.a hEA;
    private SelectCoverModel hEB;
    private SelectMusicModel hEC;
    private String hED;
    private String hEE;
    private boolean hEF;
    private com.baidu.tieba.video.editvideo.b.a hEG;
    private HttpMessageListener hEH;
    private CustomMessageListener hEI;
    private String hEy;
    private List<VideoTitleData> hEz;
    private h hpD;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.hpD = lVar.bdz();
        }
        this.hEH = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.hEz = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.hEI = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.daG = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.hEy = getIntent().getStringExtra("video_title");
        this.ehA = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.hCU).mkdirs();
        this.hEB = new SelectCoverModel(getPageContext(), this, this.hpD);
        this.hEC = new SelectMusicModel(getPageContext(), this);
        this.hEG = new com.baidu.tieba.video.editvideo.b.a(this);
        this.hEG.a(this);
        this.hEA = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(e.g.root_layout), this.hpD);
        this.hEA.setData(this.mVideoPath);
        this.hEA.ae(getIntent());
        this.hEA.a(this.hEG);
        this.hEA.setGenMaskCoverListener(this);
        this.hEB.bJG();
        this.hEC.bJH();
        this.dCS = new d(getPageContext());
        this.dCS.ec(e.j.mixing);
        registerListener(this.hEI);
        bJc();
        registerListener(this.hEH);
        bJb();
        TiebaStatic.log("c12303");
    }

    private void bJa() {
        this.Dd = true;
        this.hEE = null;
        this.hED = null;
        aHD();
    }

    public void bJb() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.daG)) {
            httpMessage.addParam("forum_id", this.daG);
        }
        sendMessage(httpMessage);
    }

    private void bJc() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.hEA.getRootView());
        if (this.hEA != null) {
            this.hEA.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hEA != null) {
            this.hEA.onPause();
        }
        if (this.hEG.bJl()) {
            this.hEG.bJm();
        }
        this.hEF = false;
        this.Dd = true;
        bJa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hEA != null) {
            this.hEA.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bJB().bJC();
        com.baidu.tieba.video.editvideo.model.b.bJE().bJF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hEA != null) {
            this.hEA.release();
        }
        if (this.hEB != null) {
            this.hEB.cancelLoadData();
        }
        if (this.hEC != null) {
            this.hEC.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hEA != null) {
            this.hEA.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        aHD();
        this.hEF = false;
        if (this.hEA != null && this.hEA.bJT() != null) {
            this.hEA.bJT().pause();
            this.hEA.bJT().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bJd() {
        if (this.hEA == null || this.hEB == null || this.hEC == null) {
            aHD();
            this.hEF = false;
        } else if (!j.kV()) {
            getPageContext().showToast(e.j.no_network);
        } else if (!this.hEF) {
            this.hEF = true;
            this.Dd = false;
            this.hEE = null;
            this.hED = null;
            this.hEA.onPause();
            this.dCS.bA(true);
            bJf();
        }
    }

    private void aHD() {
        if (this.dCS != null) {
            this.dCS.bA(false);
        }
    }

    private void bJe() {
        if (this.Dd) {
            this.Dd = false;
        } else if (this.hEA.bKa()) {
            this.hEC.d(this.mVideoPath, this.hEA.bJY(), c.hCT + "video_" + System.currentTimeMillis() + ".mp4", this.hEA.isMute() ? false : true);
        } else if (this.hEA.isMute()) {
            this.hEC.d(this.mVideoPath, null, c.hCT + "video_" + System.currentTimeMillis() + ".mp4", this.hEA.isMute() ? false : true);
        } else {
            m(this.mVideoPath, -4399, "");
        }
    }

    private void bJf() {
        if (this.Dd) {
            this.Dd = false;
            return;
        }
        String text = this.hEA.getText();
        if (TextUtils.isEmpty(text)) {
            this.hEB.aX(this.mVideoPath, this.hEA.getCurrentPosition());
        } else {
            this.hEB.tz(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bJg() {
        File file;
        this.Dd = false;
        if (this.hEA.bKa() || this.hEA.isMute()) {
            this.hEF = false;
            this.dCS.bA(true);
            this.hEA.onPause();
            if (this.hEE != null) {
                m(this.hEE, -4399, "");
            } else {
                bJe();
            }
        } else if (this.hEG.bJk()) {
            this.hEF = false;
            this.hEA.onPause();
            this.dCS.bA(true);
            wF(this.mVideoPath);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.l.copyFile(new File(this.mVideoPath).getAbsolutePath(), c.hCU + file.getName());
                wH(c.hCU + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void boz() {
        if (this.hEA == null || this.hEB == null) {
            aHD();
            this.hEF = false;
        } else if (this.Dd) {
            this.Dd = false;
        } else {
            this.hEB.aX(this.mVideoPath, this.hEA.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void tx(String str) {
        if (this.Dd) {
            this.Dd = false;
        } else if (this.hEF) {
            showToast(str);
            aHD();
            this.hEF = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void y(Bitmap bitmap) {
        this.hEA.bJT().C(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void wD(String str) {
        if (this.Dd) {
            this.Dd = false;
            return;
        }
        this.hED = str;
        bJe();
    }

    private void bJh() {
        if (this.Dd) {
            this.Dd = false;
        } else if (!TextUtils.isEmpty(this.hED) && !TextUtils.isEmpty(this.hEE)) {
            this.mVideoInfo.setVideoPath(this.hEE);
            this.mVideoInfo.setThumbPath(this.hED);
            if (this.hEA.bKa() && !TextUtils.isEmpty(this.hEA.bJZ())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.hEA.bJZ());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.ehA, this.daG, this.mForumName, this.hEy, 13003, this.mVideoInfo, this.mVideoTitleData, this.hEz);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            aHD();
            this.hEF = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(e.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(e.j.music_cloud)));
        this.hEA.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void m(String str, int i, String str2) {
        if (this.Dd) {
            this.Dd = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(e.j.mixing_fail);
            aHD();
            this.hEA.onResume();
            this.hEF = false;
            if (this.hpD != null) {
                this.hpD.aa(i, str2);
            }
        } else if (this.hEG.bJk()) {
            wF(str);
        } else {
            wG(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bJi() {
        this.hEE = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dY(List<PendantData> list) {
        this.hEA.dY(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String wK = com.baidu.tieba.video.editvideo.model.a.bJB().wK(stringExtra);
                if (this.hEA != null && !TextUtils.isEmpty(wK)) {
                    this.hEA.cS(wK, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void wE(String str) {
        wG(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void an(int i, String str) {
        if (this.hpD != null) {
            this.hpD.aa(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ao(int i, String str) {
        if (this.hpD != null) {
            this.hpD.aa(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        z(bitmap);
    }

    private void wF(String str) {
        this.hEA.bJW();
        this.hEA.bJX();
        this.hEA.bJT().releaseSource();
        this.hEG.wJ(str);
    }

    private void wG(String str) {
        File file;
        this.hEE = str;
        if (this.hEF) {
            bJh();
            return;
        }
        String str2 = c.hCU + file.getName();
        com.baidu.tbadk.core.util.l.copyFile(new File(this.hEE).getAbsolutePath(), str2);
        wH(str2);
        aHD();
        finishPage();
    }

    private void wH(String str) {
        try {
            new w(this).fy(str);
            com.baidu.tieba.video.editvideo.b.c.aL(this, str);
        } catch (Exception e) {
            aHD();
            this.hEF = false;
        }
    }

    private void z(Bitmap bitmap) {
        if (this.hEA == null || this.hEB == null) {
            aHD();
            this.hEF = false;
        } else if (this.Dd) {
            this.Dd = false;
        } else {
            if (!TextUtils.isEmpty(this.hEA.getText())) {
                bitmap = this.hEA.s(bitmap);
            }
            if (bitmap != null) {
                this.hEB.b(bitmap, c.hCS);
            }
        }
    }
}
