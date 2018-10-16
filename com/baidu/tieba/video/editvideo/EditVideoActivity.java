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
    private String dWS;
    private d dsB;
    private h hea;
    private HttpMessageListener hsA;
    private CustomMessageListener hsB;
    private String hsr;
    private List<VideoTitleData> hss;
    private com.baidu.tieba.video.editvideo.view.a hst;
    private SelectCoverModel hsu;
    private SelectMusicModel hsv;
    private String hsw;
    private String hsx;
    private boolean hsy;
    private com.baidu.tieba.video.editvideo.b.a hsz;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.hea = lVar.bbw();
        }
        this.hsA = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.hss = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.hsB = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.hsr = getIntent().getStringExtra("video_title");
        this.dWS = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.hqN).mkdirs();
        this.hsu = new SelectCoverModel(getPageContext(), this, this.hea);
        this.hsv = new SelectMusicModel(getPageContext(), this);
        this.hsz = new com.baidu.tieba.video.editvideo.b.a(this);
        this.hsz.a(this);
        this.hst = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(e.g.root_layout), this.hea);
        this.hst.setData(this.mVideoPath);
        this.hst.ae(getIntent());
        this.hst.a(this.hsz);
        this.hst.setGenMaskCoverListener(this);
        this.hsu.bHn();
        this.hsv.bHo();
        this.dsB = new d(getPageContext());
        this.dsB.dA(e.j.mixing);
        registerListener(this.hsB);
        bGJ();
        registerListener(this.hsA);
        bGI();
        TiebaStatic.log("c12303");
    }

    private void bGH() {
        this.CZ = true;
        this.hsx = null;
        this.hsw = null;
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
        getLayoutMode().onModeChanged(this.hst.getRootView());
        if (this.hst != null) {
            this.hst.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hst != null) {
            this.hst.onPause();
        }
        if (this.hsz.bGS()) {
            this.hsz.bGT();
        }
        this.hsy = false;
        this.CZ = true;
        bGH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hst != null) {
            this.hst.onResume();
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
        if (this.hst != null) {
            this.hst.release();
        }
        if (this.hsu != null) {
            this.hsu.cancelLoadData();
        }
        if (this.hsv != null) {
            this.hsv.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hst != null) {
            this.hst.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        aFG();
        this.hsy = false;
        if (this.hst != null && this.hst.bHA() != null) {
            this.hst.bHA().pause();
            this.hst.bHA().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bGK() {
        if (this.hst == null || this.hsu == null || this.hsv == null) {
            aFG();
            this.hsy = false;
        } else if (!j.kX()) {
            getPageContext().showToast(e.j.no_network);
        } else if (!this.hsy) {
            this.hsy = true;
            this.CZ = false;
            this.hsx = null;
            this.hsw = null;
            this.hst.onPause();
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
        } else if (this.hst.bHH()) {
            this.hsv.d(this.mVideoPath, this.hst.bHF(), c.hqM + "video_" + System.currentTimeMillis() + ".mp4", this.hst.isMute() ? false : true);
        } else if (this.hst.isMute()) {
            this.hsv.d(this.mVideoPath, null, c.hqM + "video_" + System.currentTimeMillis() + ".mp4", this.hst.isMute() ? false : true);
        } else {
            m(this.mVideoPath, -4399, "");
        }
    }

    private void bGM() {
        if (this.CZ) {
            this.CZ = false;
            return;
        }
        String text = this.hst.getText();
        if (TextUtils.isEmpty(text)) {
            this.hsu.aV(this.mVideoPath, this.hst.getCurrentPosition());
        } else {
            this.hsu.sT(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bGN() {
        File file;
        this.CZ = false;
        if (this.hst.bHH() || this.hst.isMute()) {
            this.hsy = false;
            this.dsB.bj(true);
            this.hst.onPause();
            if (this.hsx != null) {
                m(this.hsx, -4399, "");
            } else {
                bGL();
            }
        } else if (this.hsz.bGR()) {
            this.hsy = false;
            this.hst.onPause();
            this.dsB.bj(true);
            vU(this.mVideoPath);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.l.copyFile(new File(this.mVideoPath).getAbsolutePath(), c.hqN + file.getName());
                vW(c.hqN + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bmz() {
        if (this.hst == null || this.hsu == null) {
            aFG();
            this.hsy = false;
        } else if (this.CZ) {
            this.CZ = false;
        } else {
            this.hsu.aV(this.mVideoPath, this.hst.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void sR(String str) {
        if (this.CZ) {
            this.CZ = false;
        } else if (this.hsy) {
            showToast(str);
            aFG();
            this.hsy = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void y(Bitmap bitmap) {
        this.hst.bHA().C(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void vS(String str) {
        if (this.CZ) {
            this.CZ = false;
            return;
        }
        this.hsw = str;
        bGL();
    }

    private void bGO() {
        if (this.CZ) {
            this.CZ = false;
        } else if (!TextUtils.isEmpty(this.hsw) && !TextUtils.isEmpty(this.hsx)) {
            this.mVideoInfo.setVideoPath(this.hsx);
            this.mVideoInfo.setThumbPath(this.hsw);
            if (this.hst.bHH() && !TextUtils.isEmpty(this.hst.bHG())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.hst.bHG());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.dWS, this.cQb, this.mForumName, this.hsr, 13003, this.mVideoInfo, this.mVideoTitleData, this.hss);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            aFG();
            this.hsy = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(e.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(e.j.music_cloud)));
        this.hst.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void m(String str, int i, String str2) {
        if (this.CZ) {
            this.CZ = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(e.j.mixing_fail);
            aFG();
            this.hst.onResume();
            this.hsy = false;
            if (this.hea != null) {
                this.hea.ad(i, str2);
            }
        } else if (this.hsz.bGR()) {
            vU(str);
        } else {
            vV(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bGP() {
        this.hsx = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dV(List<PendantData> list) {
        this.hst.dV(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String vZ = com.baidu.tieba.video.editvideo.model.a.bHi().vZ(stringExtra);
                if (this.hst != null && !TextUtils.isEmpty(vZ)) {
                    this.hst.cN(vZ, stringExtra2);
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
        if (this.hea != null) {
            this.hea.ad(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ar(int i, String str) {
        if (this.hea != null) {
            this.hea.ad(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        z(bitmap);
    }

    private void vU(String str) {
        this.hst.bHD();
        this.hst.bHE();
        this.hst.bHA().releaseSource();
        this.hsz.vY(str);
    }

    private void vV(String str) {
        File file;
        this.hsx = str;
        if (this.hsy) {
            bGO();
            return;
        }
        String str2 = c.hqN + file.getName();
        com.baidu.tbadk.core.util.l.copyFile(new File(this.hsx).getAbsolutePath(), str2);
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
            this.hsy = false;
        }
    }

    private void z(Bitmap bitmap) {
        if (this.hst == null || this.hsu == null) {
            aFG();
            this.hsy = false;
        } else if (this.CZ) {
            this.CZ = false;
        } else {
            if (!TextUtils.isEmpty(this.hst.getText())) {
                bitmap = this.hst.s(bitmap);
            }
            if (bitmap != null) {
                this.hsu.b(bitmap, c.hqL);
            }
        }
    }
}
