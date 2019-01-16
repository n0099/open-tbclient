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
    private d dDB;
    private String dbr;
    private String eig;
    private String hFF;
    private List<VideoTitleData> hFG;
    private com.baidu.tieba.video.editvideo.view.a hFH;
    private SelectCoverModel hFI;
    private SelectMusicModel hFJ;
    private String hFK;
    private String hFL;
    private boolean hFM;
    private com.baidu.tieba.video.editvideo.b.a hFN;
    private HttpMessageListener hFO;
    private CustomMessageListener hFP;
    private h hqL;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.hqL = lVar.bdZ();
        }
        this.hFO = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.hFG = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.hFP = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.dbr = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.hFF = getIntent().getStringExtra("video_title");
        this.eig = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.hEb).mkdirs();
        this.hFI = new SelectCoverModel(getPageContext(), this, this.hqL);
        this.hFJ = new SelectMusicModel(getPageContext(), this);
        this.hFN = new com.baidu.tieba.video.editvideo.b.a(this);
        this.hFN.a(this);
        this.hFH = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(e.g.root_layout), this.hqL);
        this.hFH.setData(this.mVideoPath);
        this.hFH.ae(getIntent());
        this.hFH.a(this.hFN);
        this.hFH.setGenMaskCoverListener(this);
        this.hFI.bKp();
        this.hFJ.bKq();
        this.dDB = new d(getPageContext());
        this.dDB.ec(e.j.mixing);
        registerListener(this.hFP);
        bJL();
        registerListener(this.hFO);
        bJK();
        TiebaStatic.log("c12303");
    }

    private void bJJ() {
        this.Dd = true;
        this.hFL = null;
        this.hFK = null;
        aIa();
    }

    public void bJK() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.dbr)) {
            httpMessage.addParam("forum_id", this.dbr);
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
        getLayoutMode().onModeChanged(this.hFH.getRootView());
        if (this.hFH != null) {
            this.hFH.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hFH != null) {
            this.hFH.onPause();
        }
        if (this.hFN.bJU()) {
            this.hFN.bJV();
        }
        this.hFM = false;
        this.Dd = true;
        bJJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hFH != null) {
            this.hFH.onResume();
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
        if (this.hFH != null) {
            this.hFH.release();
        }
        if (this.hFI != null) {
            this.hFI.cancelLoadData();
        }
        if (this.hFJ != null) {
            this.hFJ.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hFH != null) {
            this.hFH.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        aIa();
        this.hFM = false;
        if (this.hFH != null && this.hFH.bKC() != null) {
            this.hFH.bKC().pause();
            this.hFH.bKC().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bJM() {
        if (this.hFH == null || this.hFI == null || this.hFJ == null) {
            aIa();
            this.hFM = false;
        } else if (!j.kV()) {
            getPageContext().showToast(e.j.no_network);
        } else if (!this.hFM) {
            this.hFM = true;
            this.Dd = false;
            this.hFL = null;
            this.hFK = null;
            this.hFH.onPause();
            this.dDB.bB(true);
            bJO();
        }
    }

    private void aIa() {
        if (this.dDB != null) {
            this.dDB.bB(false);
        }
    }

    private void bJN() {
        if (this.Dd) {
            this.Dd = false;
        } else if (this.hFH.bKJ()) {
            this.hFJ.d(this.mVideoPath, this.hFH.bKH(), c.hEa + "video_" + System.currentTimeMillis() + ".mp4", this.hFH.isMute() ? false : true);
        } else if (this.hFH.isMute()) {
            this.hFJ.d(this.mVideoPath, null, c.hEa + "video_" + System.currentTimeMillis() + ".mp4", this.hFH.isMute() ? false : true);
        } else {
            m(this.mVideoPath, -4399, "");
        }
    }

    private void bJO() {
        if (this.Dd) {
            this.Dd = false;
            return;
        }
        String text = this.hFH.getText();
        if (TextUtils.isEmpty(text)) {
            this.hFI.aX(this.mVideoPath, this.hFH.getCurrentPosition());
        } else {
            this.hFI.tP(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bJP() {
        File file;
        this.Dd = false;
        if (this.hFH.bKJ() || this.hFH.isMute()) {
            this.hFM = false;
            this.dDB.bB(true);
            this.hFH.onPause();
            if (this.hFL != null) {
                m(this.hFL, -4399, "");
            } else {
                bJN();
            }
        } else if (this.hFN.bJT()) {
            this.hFM = false;
            this.hFH.onPause();
            this.dDB.bB(true);
            wV(this.mVideoPath);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.l.copyFile(new File(this.mVideoPath).getAbsolutePath(), c.hEb + file.getName());
                wX(c.hEb + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bpi() {
        if (this.hFH == null || this.hFI == null) {
            aIa();
            this.hFM = false;
        } else if (this.Dd) {
            this.Dd = false;
        } else {
            this.hFI.aX(this.mVideoPath, this.hFH.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void tN(String str) {
        if (this.Dd) {
            this.Dd = false;
        } else if (this.hFM) {
            showToast(str);
            aIa();
            this.hFM = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void y(Bitmap bitmap) {
        this.hFH.bKC().C(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void wT(String str) {
        if (this.Dd) {
            this.Dd = false;
            return;
        }
        this.hFK = str;
        bJN();
    }

    private void bJQ() {
        if (this.Dd) {
            this.Dd = false;
        } else if (!TextUtils.isEmpty(this.hFK) && !TextUtils.isEmpty(this.hFL)) {
            this.mVideoInfo.setVideoPath(this.hFL);
            this.mVideoInfo.setThumbPath(this.hFK);
            if (this.hFH.bKJ() && !TextUtils.isEmpty(this.hFH.bKI())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.hFH.bKI());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.eig, this.dbr, this.mForumName, this.hFF, 13003, this.mVideoInfo, this.mVideoTitleData, this.hFG);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            aIa();
            this.hFM = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(e.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(e.j.music_cloud)));
        this.hFH.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void m(String str, int i, String str2) {
        if (this.Dd) {
            this.Dd = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(e.j.mixing_fail);
            aIa();
            this.hFH.onResume();
            this.hFM = false;
            if (this.hqL != null) {
                this.hqL.ac(i, str2);
            }
        } else if (this.hFN.bJT()) {
            wV(str);
        } else {
            wW(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bJR() {
        this.hFL = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dZ(List<PendantData> list) {
        this.hFH.dZ(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String xa = com.baidu.tieba.video.editvideo.model.a.bKk().xa(stringExtra);
                if (this.hFH != null && !TextUtils.isEmpty(xa)) {
                    this.hFH.cU(xa, stringExtra2);
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
        if (this.hqL != null) {
            this.hqL.ac(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aq(int i, String str) {
        if (this.hqL != null) {
            this.hqL.ac(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        z(bitmap);
    }

    private void wV(String str) {
        this.hFH.bKF();
        this.hFH.bKG();
        this.hFH.bKC().releaseSource();
        this.hFN.wZ(str);
    }

    private void wW(String str) {
        File file;
        this.hFL = str;
        if (this.hFM) {
            bJQ();
            return;
        }
        String str2 = c.hEb + file.getName();
        com.baidu.tbadk.core.util.l.copyFile(new File(this.hFL).getAbsolutePath(), str2);
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
            this.hFM = false;
        }
    }

    private void z(Bitmap bitmap) {
        if (this.hFH == null || this.hFI == null) {
            aIa();
            this.hFM = false;
        } else if (this.Dd) {
            this.Dd = false;
        } else {
            if (!TextUtils.isEmpty(this.hFH.getText())) {
                bitmap = this.hFH.s(bitmap);
            }
            if (bitmap != null) {
                this.hFI.b(bitmap, c.hDZ);
            }
        }
    }
}
