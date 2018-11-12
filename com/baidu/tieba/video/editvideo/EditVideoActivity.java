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
    private String cRh;
    private String dYg;
    private d dtG;
    private h hfy;
    private String hub;
    private List<VideoTitleData> huc;
    private com.baidu.tieba.video.editvideo.view.a hud;
    private SelectCoverModel hue;
    private SelectMusicModel huf;
    private String hug;
    private String huh;
    private boolean hui;
    private com.baidu.tieba.video.editvideo.b.a huj;
    private HttpMessageListener huk;
    private CustomMessageListener hul;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.hfy = lVar.baV();
        }
        this.huk = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.huc = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.hul = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.cRh = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.hub = getIntent().getStringExtra("video_title");
        this.dYg = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.hsx).mkdirs();
        this.hue = new SelectCoverModel(getPageContext(), this, this.hfy);
        this.huf = new SelectMusicModel(getPageContext(), this);
        this.huj = new com.baidu.tieba.video.editvideo.b.a(this);
        this.huj.a(this);
        this.hud = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(e.g.root_layout), this.hfy);
        this.hud.setData(this.mVideoPath);
        this.hud.ae(getIntent());
        this.hud.a(this.huj);
        this.hud.setGenMaskCoverListener(this);
        this.hue.bGM();
        this.huf.bGN();
        this.dtG = new d(getPageContext());
        this.dtG.dO(e.j.mixing);
        registerListener(this.hul);
        bGi();
        registerListener(this.huk);
        bGh();
        TiebaStatic.log("c12303");
    }

    private void bGg() {
        this.Dd = true;
        this.huh = null;
        this.hug = null;
        aFc();
    }

    public void bGh() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.cRh)) {
            httpMessage.addParam("forum_id", this.cRh);
        }
        sendMessage(httpMessage);
    }

    private void bGi() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.hud.getRootView());
        if (this.hud != null) {
            this.hud.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hud != null) {
            this.hud.onPause();
        }
        if (this.huj.bGr()) {
            this.huj.bGs();
        }
        this.hui = false;
        this.Dd = true;
        bGg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hud != null) {
            this.hud.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bGH().bGI();
        com.baidu.tieba.video.editvideo.model.b.bGK().bGL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hud != null) {
            this.hud.release();
        }
        if (this.hue != null) {
            this.hue.cancelLoadData();
        }
        if (this.huf != null) {
            this.huf.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hud != null) {
            this.hud.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        aFc();
        this.hui = false;
        if (this.hud != null && this.hud.bGZ() != null) {
            this.hud.bGZ().pause();
            this.hud.bGZ().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bGj() {
        if (this.hud == null || this.hue == null || this.huf == null) {
            aFc();
            this.hui = false;
        } else if (!j.kV()) {
            getPageContext().showToast(e.j.no_network);
        } else if (!this.hui) {
            this.hui = true;
            this.Dd = false;
            this.huh = null;
            this.hug = null;
            this.hud.onPause();
            this.dtG.bz(true);
            bGl();
        }
    }

    private void aFc() {
        if (this.dtG != null) {
            this.dtG.bz(false);
        }
    }

    private void bGk() {
        if (this.Dd) {
            this.Dd = false;
        } else if (this.hud.bHg()) {
            this.huf.d(this.mVideoPath, this.hud.bHe(), c.hsw + "video_" + System.currentTimeMillis() + ".mp4", this.hud.isMute() ? false : true);
        } else if (this.hud.isMute()) {
            this.huf.d(this.mVideoPath, null, c.hsw + "video_" + System.currentTimeMillis() + ".mp4", this.hud.isMute() ? false : true);
        } else {
            m(this.mVideoPath, -4399, "");
        }
    }

    private void bGl() {
        if (this.Dd) {
            this.Dd = false;
            return;
        }
        String text = this.hud.getText();
        if (TextUtils.isEmpty(text)) {
            this.hue.aV(this.mVideoPath, this.hud.getCurrentPosition());
        } else {
            this.hue.sU(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bGm() {
        File file;
        this.Dd = false;
        if (this.hud.bHg() || this.hud.isMute()) {
            this.hui = false;
            this.dtG.bz(true);
            this.hud.onPause();
            if (this.huh != null) {
                m(this.huh, -4399, "");
            } else {
                bGk();
            }
        } else if (this.huj.bGq()) {
            this.hui = false;
            this.hud.onPause();
            this.dtG.bz(true);
            vZ(this.mVideoPath);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.l.copyFile(new File(this.mVideoPath).getAbsolutePath(), c.hsx + file.getName());
                wb(c.hsx + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void blV() {
        if (this.hud == null || this.hue == null) {
            aFc();
            this.hui = false;
        } else if (this.Dd) {
            this.Dd = false;
        } else {
            this.hue.aV(this.mVideoPath, this.hud.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void sS(String str) {
        if (this.Dd) {
            this.Dd = false;
        } else if (this.hui) {
            showToast(str);
            aFc();
            this.hui = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void y(Bitmap bitmap) {
        this.hud.bGZ().C(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void vX(String str) {
        if (this.Dd) {
            this.Dd = false;
            return;
        }
        this.hug = str;
        bGk();
    }

    private void bGn() {
        if (this.Dd) {
            this.Dd = false;
        } else if (!TextUtils.isEmpty(this.hug) && !TextUtils.isEmpty(this.huh)) {
            this.mVideoInfo.setVideoPath(this.huh);
            this.mVideoInfo.setThumbPath(this.hug);
            if (this.hud.bHg() && !TextUtils.isEmpty(this.hud.bHf())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.hud.bHf());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.dYg, this.cRh, this.mForumName, this.hub, 13003, this.mVideoInfo, this.mVideoTitleData, this.huc);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            aFc();
            this.hui = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(e.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(e.j.music_cloud)));
        this.hud.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void m(String str, int i, String str2) {
        if (this.Dd) {
            this.Dd = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(e.j.mixing_fail);
            aFc();
            this.hud.onResume();
            this.hui = false;
            if (this.hfy != null) {
                this.hfy.Z(i, str2);
            }
        } else if (this.huj.bGq()) {
            vZ(str);
        } else {
            wa(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bGo() {
        this.huh = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dT(List<PendantData> list) {
        this.hud.dT(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String we = com.baidu.tieba.video.editvideo.model.a.bGH().we(stringExtra);
                if (this.hud != null && !TextUtils.isEmpty(we)) {
                    this.hud.cN(we, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void vY(String str) {
        wa(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void am(int i, String str) {
        if (this.hfy != null) {
            this.hfy.Z(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void an(int i, String str) {
        if (this.hfy != null) {
            this.hfy.Z(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        z(bitmap);
    }

    private void vZ(String str) {
        this.hud.bHc();
        this.hud.bHd();
        this.hud.bGZ().releaseSource();
        this.huj.wd(str);
    }

    private void wa(String str) {
        File file;
        this.huh = str;
        if (this.hui) {
            bGn();
            return;
        }
        String str2 = c.hsx + file.getName();
        com.baidu.tbadk.core.util.l.copyFile(new File(this.huh).getAbsolutePath(), str2);
        wb(str2);
        aFc();
        finishPage();
    }

    private void wb(String str) {
        try {
            new w(this).fg(str);
            com.baidu.tieba.video.editvideo.b.c.aI(this, str);
        } catch (Exception e) {
            aFc();
            this.hui = false;
        }
    }

    private void z(Bitmap bitmap) {
        if (this.hud == null || this.hue == null) {
            aFc();
            this.hui = false;
        } else if (this.Dd) {
            this.Dd = false;
        } else {
            if (!TextUtils.isEmpty(this.hud.getText())) {
                bitmap = this.hud.s(bitmap);
            }
            if (bitmap != null) {
                this.hue.b(bitmap, c.hsv);
            }
        }
    }
}
