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
    private boolean CZ;
    private String cQb;
    private String dWT;
    private d dsB;
    private h heb;
    private com.baidu.tieba.video.editvideo.b.a hsA;
    private HttpMessageListener hsB;
    private CustomMessageListener hsC;
    private String hss;
    private List<VideoTitleData> hst;
    private com.baidu.tieba.video.editvideo.view.a hsu;
    private SelectCoverModel hsv;
    private SelectMusicModel hsw;
    private String hsx;
    private String hsy;
    private boolean hsz;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.heb = lVar.bbw();
        }
        this.hsB = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.hst = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.hsC = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.cQb = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.hss = getIntent().getStringExtra("video_title");
        this.dWT = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.hqO).mkdirs();
        this.hsv = new SelectCoverModel(getPageContext(), this, this.heb);
        this.hsw = new SelectMusicModel(getPageContext(), this);
        this.hsA = new com.baidu.tieba.video.editvideo.b.a(this);
        this.hsA.a(this);
        this.hsu = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(e.g.root_layout), this.heb);
        this.hsu.setData(this.mVideoPath);
        this.hsu.ae(getIntent());
        this.hsu.a(this.hsA);
        this.hsu.setGenMaskCoverListener(this);
        this.hsv.bHn();
        this.hsw.bHo();
        this.dsB = new d(getPageContext());
        this.dsB.dA(e.j.mixing);
        registerListener(this.hsC);
        bGJ();
        registerListener(this.hsB);
        bGI();
        TiebaStatic.log("c12303");
    }

    private void bGH() {
        this.CZ = true;
        this.hsy = null;
        this.hsx = null;
        aFG();
    }

    public void bGI() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.cQb)) {
            httpMessage.addParam("forum_id", this.cQb);
        }
        sendMessage(httpMessage);
    }

    private void bGJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.hsu.getRootView());
        if (this.hsu != null) {
            this.hsu.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hsu != null) {
            this.hsu.onPause();
        }
        if (this.hsA.bGS()) {
            this.hsA.bGT();
        }
        this.hsz = false;
        this.CZ = true;
        bGH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hsu != null) {
            this.hsu.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bHi().bHj();
        com.baidu.tieba.video.editvideo.model.b.bHl().bHm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hsu != null) {
            this.hsu.release();
        }
        if (this.hsv != null) {
            this.hsv.cancelLoadData();
        }
        if (this.hsw != null) {
            this.hsw.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hsu != null) {
            this.hsu.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        aFG();
        this.hsz = false;
        if (this.hsu != null && this.hsu.bHA() != null) {
            this.hsu.bHA().pause();
            this.hsu.bHA().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bGK() {
        if (this.hsu == null || this.hsv == null || this.hsw == null) {
            aFG();
            this.hsz = false;
        } else if (!j.kX()) {
            getPageContext().showToast(e.j.no_network);
        } else if (!this.hsz) {
            this.hsz = true;
            this.CZ = false;
            this.hsy = null;
            this.hsx = null;
            this.hsu.onPause();
            this.dsB.bj(true);
            bGM();
        }
    }

    private void aFG() {
        if (this.dsB != null) {
            this.dsB.bj(false);
        }
    }

    private void bGL() {
        if (this.CZ) {
            this.CZ = false;
        } else if (this.hsu.bHH()) {
            this.hsw.d(this.mVideoPath, this.hsu.bHF(), c.hqN + "video_" + System.currentTimeMillis() + ".mp4", this.hsu.isMute() ? false : true);
        } else if (this.hsu.isMute()) {
            this.hsw.d(this.mVideoPath, null, c.hqN + "video_" + System.currentTimeMillis() + ".mp4", this.hsu.isMute() ? false : true);
        } else {
            m(this.mVideoPath, -4399, "");
        }
    }

    private void bGM() {
        if (this.CZ) {
            this.CZ = false;
            return;
        }
        String text = this.hsu.getText();
        if (TextUtils.isEmpty(text)) {
            this.hsv.aV(this.mVideoPath, this.hsu.getCurrentPosition());
        } else {
            this.hsv.sT(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bGN() {
        File file;
        this.CZ = false;
        if (this.hsu.bHH() || this.hsu.isMute()) {
            this.hsz = false;
            this.dsB.bj(true);
            this.hsu.onPause();
            if (this.hsy != null) {
                m(this.hsy, -4399, "");
            } else {
                bGL();
            }
        } else if (this.hsA.bGR()) {
            this.hsz = false;
            this.hsu.onPause();
            this.dsB.bj(true);
            vU(this.mVideoPath);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.l.copyFile(new File(this.mVideoPath).getAbsolutePath(), c.hqO + file.getName());
                vW(c.hqO + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bmz() {
        if (this.hsu == null || this.hsv == null) {
            aFG();
            this.hsz = false;
        } else if (this.CZ) {
            this.CZ = false;
        } else {
            this.hsv.aV(this.mVideoPath, this.hsu.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void sR(String str) {
        if (this.CZ) {
            this.CZ = false;
        } else if (this.hsz) {
            showToast(str);
            aFG();
            this.hsz = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void y(Bitmap bitmap) {
        this.hsu.bHA().C(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void vS(String str) {
        if (this.CZ) {
            this.CZ = false;
            return;
        }
        this.hsx = str;
        bGL();
    }

    private void bGO() {
        if (this.CZ) {
            this.CZ = false;
        } else if (!TextUtils.isEmpty(this.hsx) && !TextUtils.isEmpty(this.hsy)) {
            this.mVideoInfo.setVideoPath(this.hsy);
            this.mVideoInfo.setThumbPath(this.hsx);
            if (this.hsu.bHH() && !TextUtils.isEmpty(this.hsu.bHG())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.hsu.bHG());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.dWT, this.cQb, this.mForumName, this.hss, 13003, this.mVideoInfo, this.mVideoTitleData, this.hst);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            aFG();
            this.hsz = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(e.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(e.j.music_cloud)));
        this.hsu.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void m(String str, int i, String str2) {
        if (this.CZ) {
            this.CZ = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(e.j.mixing_fail);
            aFG();
            this.hsu.onResume();
            this.hsz = false;
            if (this.heb != null) {
                this.heb.ad(i, str2);
            }
        } else if (this.hsA.bGR()) {
            vU(str);
        } else {
            vV(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bGP() {
        this.hsy = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dV(List<PendantData> list) {
        this.hsu.dV(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String vZ = com.baidu.tieba.video.editvideo.model.a.bHi().vZ(stringExtra);
                if (this.hsu != null && !TextUtils.isEmpty(vZ)) {
                    this.hsu.cN(vZ, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void vT(String str) {
        vV(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aq(int i, String str) {
        if (this.heb != null) {
            this.heb.ad(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ar(int i, String str) {
        if (this.heb != null) {
            this.heb.ad(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        z(bitmap);
    }

    private void vU(String str) {
        this.hsu.bHD();
        this.hsu.bHE();
        this.hsu.bHA().releaseSource();
        this.hsA.vY(str);
    }

    private void vV(String str) {
        File file;
        this.hsy = str;
        if (this.hsz) {
            bGO();
            return;
        }
        String str2 = c.hqO + file.getName();
        com.baidu.tbadk.core.util.l.copyFile(new File(this.hsy).getAbsolutePath(), str2);
        vW(str2);
        aFG();
        finishPage();
    }

    private void vW(String str) {
        try {
            new w(this).fg(str);
            com.baidu.tieba.video.editvideo.b.c.aK(this, str);
        } catch (Exception e) {
            aFG();
            this.hsz = false;
        }
    }

    private void z(Bitmap bitmap) {
        if (this.hsu == null || this.hsv == null) {
            aFG();
            this.hsz = false;
        } else if (this.CZ) {
            this.CZ = false;
        } else {
            if (!TextUtils.isEmpty(this.hsu.getText())) {
                bitmap = this.hsu.s(bitmap);
            }
            if (bitmap != null) {
                this.hsv.b(bitmap, c.hqM);
            }
        }
    }
}
