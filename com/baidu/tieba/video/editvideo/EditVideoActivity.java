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
    private d dDC;
    private String dbs;
    private String eih;
    private String hFG;
    private List<VideoTitleData> hFH;
    private com.baidu.tieba.video.editvideo.view.a hFI;
    private SelectCoverModel hFJ;
    private SelectMusicModel hFK;
    private String hFL;
    private String hFM;
    private boolean hFN;
    private com.baidu.tieba.video.editvideo.b.a hFO;
    private HttpMessageListener hFP;
    private CustomMessageListener hFQ;
    private h hqM;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.hqM = lVar.bdZ();
        }
        this.hFP = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.hFH = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.hFQ = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.dbs = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.hFG = getIntent().getStringExtra("video_title");
        this.eih = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.hEc).mkdirs();
        this.hFJ = new SelectCoverModel(getPageContext(), this, this.hqM);
        this.hFK = new SelectMusicModel(getPageContext(), this);
        this.hFO = new com.baidu.tieba.video.editvideo.b.a(this);
        this.hFO.a(this);
        this.hFI = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(e.g.root_layout), this.hqM);
        this.hFI.setData(this.mVideoPath);
        this.hFI.ae(getIntent());
        this.hFI.a(this.hFO);
        this.hFI.setGenMaskCoverListener(this);
        this.hFJ.bKp();
        this.hFK.bKq();
        this.dDC = new d(getPageContext());
        this.dDC.ec(e.j.mixing);
        registerListener(this.hFQ);
        bJL();
        registerListener(this.hFP);
        bJK();
        TiebaStatic.log("c12303");
    }

    private void bJJ() {
        this.Dd = true;
        this.hFM = null;
        this.hFL = null;
        aIa();
    }

    public void bJK() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.dbs)) {
            httpMessage.addParam("forum_id", this.dbs);
        }
        sendMessage(httpMessage);
    }

    private void bJL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.hFI.getRootView());
        if (this.hFI != null) {
            this.hFI.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hFI != null) {
            this.hFI.onPause();
        }
        if (this.hFO.bJU()) {
            this.hFO.bJV();
        }
        this.hFN = false;
        this.Dd = true;
        bJJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hFI != null) {
            this.hFI.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bKk().bKl();
        com.baidu.tieba.video.editvideo.model.b.bKn().bKo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hFI != null) {
            this.hFI.release();
        }
        if (this.hFJ != null) {
            this.hFJ.cancelLoadData();
        }
        if (this.hFK != null) {
            this.hFK.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hFI != null) {
            this.hFI.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        aIa();
        this.hFN = false;
        if (this.hFI != null && this.hFI.bKC() != null) {
            this.hFI.bKC().pause();
            this.hFI.bKC().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bJM() {
        if (this.hFI == null || this.hFJ == null || this.hFK == null) {
            aIa();
            this.hFN = false;
        } else if (!j.kV()) {
            getPageContext().showToast(e.j.no_network);
        } else if (!this.hFN) {
            this.hFN = true;
            this.Dd = false;
            this.hFM = null;
            this.hFL = null;
            this.hFI.onPause();
            this.dDC.bB(true);
            bJO();
        }
    }

    private void aIa() {
        if (this.dDC != null) {
            this.dDC.bB(false);
        }
    }

    private void bJN() {
        if (this.Dd) {
            this.Dd = false;
        } else if (this.hFI.bKJ()) {
            this.hFK.d(this.mVideoPath, this.hFI.bKH(), c.hEb + "video_" + System.currentTimeMillis() + ".mp4", this.hFI.isMute() ? false : true);
        } else if (this.hFI.isMute()) {
            this.hFK.d(this.mVideoPath, null, c.hEb + "video_" + System.currentTimeMillis() + ".mp4", this.hFI.isMute() ? false : true);
        } else {
            m(this.mVideoPath, -4399, "");
        }
    }

    private void bJO() {
        if (this.Dd) {
            this.Dd = false;
            return;
        }
        String text = this.hFI.getText();
        if (TextUtils.isEmpty(text)) {
            this.hFJ.aX(this.mVideoPath, this.hFI.getCurrentPosition());
        } else {
            this.hFJ.tP(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bJP() {
        File file;
        this.Dd = false;
        if (this.hFI.bKJ() || this.hFI.isMute()) {
            this.hFN = false;
            this.dDC.bB(true);
            this.hFI.onPause();
            if (this.hFM != null) {
                m(this.hFM, -4399, "");
            } else {
                bJN();
            }
        } else if (this.hFO.bJT()) {
            this.hFN = false;
            this.hFI.onPause();
            this.dDC.bB(true);
            wV(this.mVideoPath);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.l.copyFile(new File(this.mVideoPath).getAbsolutePath(), c.hEc + file.getName());
                wX(c.hEc + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bpi() {
        if (this.hFI == null || this.hFJ == null) {
            aIa();
            this.hFN = false;
        } else if (this.Dd) {
            this.Dd = false;
        } else {
            this.hFJ.aX(this.mVideoPath, this.hFI.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void tN(String str) {
        if (this.Dd) {
            this.Dd = false;
        } else if (this.hFN) {
            showToast(str);
            aIa();
            this.hFN = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void y(Bitmap bitmap) {
        this.hFI.bKC().C(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void wT(String str) {
        if (this.Dd) {
            this.Dd = false;
            return;
        }
        this.hFL = str;
        bJN();
    }

    private void bJQ() {
        if (this.Dd) {
            this.Dd = false;
        } else if (!TextUtils.isEmpty(this.hFL) && !TextUtils.isEmpty(this.hFM)) {
            this.mVideoInfo.setVideoPath(this.hFM);
            this.mVideoInfo.setThumbPath(this.hFL);
            if (this.hFI.bKJ() && !TextUtils.isEmpty(this.hFI.bKI())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.hFI.bKI());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.eih, this.dbs, this.mForumName, this.hFG, 13003, this.mVideoInfo, this.mVideoTitleData, this.hFH);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            aIa();
            this.hFN = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(e.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(e.j.music_cloud)));
        this.hFI.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void m(String str, int i, String str2) {
        if (this.Dd) {
            this.Dd = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(e.j.mixing_fail);
            aIa();
            this.hFI.onResume();
            this.hFN = false;
            if (this.hqM != null) {
                this.hqM.ac(i, str2);
            }
        } else if (this.hFO.bJT()) {
            wV(str);
        } else {
            wW(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bJR() {
        this.hFM = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dZ(List<PendantData> list) {
        this.hFI.dZ(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String xa = com.baidu.tieba.video.editvideo.model.a.bKk().xa(stringExtra);
                if (this.hFI != null && !TextUtils.isEmpty(xa)) {
                    this.hFI.cU(xa, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void wU(String str) {
        wW(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ap(int i, String str) {
        if (this.hqM != null) {
            this.hqM.ac(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aq(int i, String str) {
        if (this.hqM != null) {
            this.hqM.ac(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        z(bitmap);
    }

    private void wV(String str) {
        this.hFI.bKF();
        this.hFI.bKG();
        this.hFI.bKC().releaseSource();
        this.hFO.wZ(str);
    }

    private void wW(String str) {
        File file;
        this.hFM = str;
        if (this.hFN) {
            bJQ();
            return;
        }
        String str2 = c.hEc + file.getName();
        com.baidu.tbadk.core.util.l.copyFile(new File(this.hFM).getAbsolutePath(), str2);
        wX(str2);
        aIa();
        finishPage();
    }

    private void wX(String str) {
        try {
            new w(this).fL(str);
            com.baidu.tieba.video.editvideo.b.c.aJ(this, str);
        } catch (Exception e) {
            aIa();
            this.hFN = false;
        }
    }

    private void z(Bitmap bitmap) {
        if (this.hFI == null || this.hFJ == null) {
            aIa();
            this.hFN = false;
        } else if (this.Dd) {
            this.Dd = false;
        } else {
            if (!TextUtils.isEmpty(this.hFI.getText())) {
                bitmap = this.hFI.s(bitmap);
            }
            if (bitmap != null) {
                this.hFJ.b(bitmap, c.hEa);
            }
        }
    }
}
