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
/* loaded from: classes2.dex */
public class EditVideoActivity extends BaseActivity implements a, b, b.a, MaskVideoView.b {
    private boolean Cp;
    private String btt;
    private String cHI;
    private String dOX;
    private d dkx;
    private h gWF;
    private String hlc;
    private List<VideoTitleData> hld;
    private com.baidu.tieba.video.editvideo.view.a hle;
    private SelectCoverModel hlf;
    private SelectMusicModel hlg;
    private String hlh;
    private String hli;
    private boolean hlj;
    private com.baidu.tieba.video.editvideo.b.a hlk;
    private HttpMessageListener hll;
    private CustomMessageListener hlm;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.gWF = lVar.aYk();
        }
        this.hll = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.hld = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.hlm = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.cHI = getIntent().getStringExtra("forum_id");
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.hlc = getIntent().getStringExtra("video_title");
        this.dOX = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.btt = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.btt) && !new File(this.btt).exists()) {
            finishPage();
        }
        new File(c.hjx).mkdirs();
        this.hlf = new SelectCoverModel(getPageContext(), this, this.gWF);
        this.hlg = new SelectMusicModel(getPageContext(), this);
        this.hlk = new com.baidu.tieba.video.editvideo.b.a(this);
        this.hlk.a(this);
        this.hle = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(e.g.root_layout), this.gWF);
        this.hle.setData(this.btt);
        this.hle.aa(getIntent());
        this.hle.a(this.hlk);
        this.hle.setGenMaskCoverListener(this);
        this.hlf.bDZ();
        this.hlg.bEa();
        this.dkx = new d(getPageContext());
        this.dkx.dq(e.j.mixing);
        registerListener(this.hlm);
        bDv();
        registerListener(this.hll);
        bDu();
        TiebaStatic.log("c12303");
    }

    private void bDt() {
        this.Cp = true;
        this.hli = null;
        this.hlh = null;
        aCn();
    }

    public void bDu() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.cHI)) {
            httpMessage.addParam("forum_id", this.cHI);
        }
        sendMessage(httpMessage);
    }

    private void bDv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.hle.getRootView());
        if (this.hle != null) {
            this.hle.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hle != null) {
            this.hle.onPause();
        }
        if (this.hlk.bDE()) {
            this.hlk.bDF();
        }
        this.hlj = false;
        this.Cp = true;
        bDt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hle != null) {
            this.hle.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.bDU().bDV();
        com.baidu.tieba.video.editvideo.model.b.bDX().bDY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hle != null) {
            this.hle.release();
        }
        if (this.hlf != null) {
            this.hlf.cancelLoadData();
        }
        if (this.hlg != null) {
            this.hlg.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hle != null) {
            this.hle.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        aCn();
        this.hlj = false;
        if (this.hle != null && this.hle.bEm() != null) {
            this.hle.bEm().pause();
            this.hle.bEm().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bDw() {
        if (this.hle == null || this.hlf == null || this.hlg == null) {
            aCn();
            this.hlj = false;
        } else if (!j.kK()) {
            getPageContext().showToast(e.j.no_network);
        } else if (!this.hlj) {
            this.hlj = true;
            this.Cp = false;
            this.hli = null;
            this.hlh = null;
            this.hle.onPause();
            this.dkx.aZ(true);
            bDy();
        }
    }

    private void aCn() {
        if (this.dkx != null) {
            this.dkx.aZ(false);
        }
    }

    private void bDx() {
        if (this.Cp) {
            this.Cp = false;
        } else if (this.hle.bEt()) {
            this.hlg.c(this.btt, this.hle.bEr(), c.hjw + "video_" + System.currentTimeMillis() + ".mp4", this.hle.isMute() ? false : true);
        } else if (this.hle.isMute()) {
            this.hlg.c(this.btt, null, c.hjw + "video_" + System.currentTimeMillis() + ".mp4", this.hle.isMute() ? false : true);
        } else {
            m(this.btt, -4399, "");
        }
    }

    private void bDy() {
        if (this.Cp) {
            this.Cp = false;
            return;
        }
        String text = this.hle.getText();
        if (TextUtils.isEmpty(text)) {
            this.hlf.aR(this.btt, this.hle.getCurrentPosition());
        } else {
            this.hlf.st(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bDz() {
        File file;
        this.Cp = false;
        if (this.hle.bEt() || this.hle.isMute()) {
            this.hlj = false;
            this.dkx.aZ(true);
            this.hle.onPause();
            if (this.hli != null) {
                m(this.hli, -4399, "");
            } else {
                bDx();
            }
        } else if (this.hlk.bDD()) {
            this.hlj = false;
            this.hle.onPause();
            this.dkx.aZ(true);
            vs(this.btt);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                com.baidu.tbadk.core.util.l.ai(new File(this.btt).getAbsolutePath(), c.hjx + file.getName());
                vu(c.hjx + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bjn() {
        if (this.hle == null || this.hlf == null) {
            aCn();
            this.hlj = false;
        } else if (this.Cp) {
            this.Cp = false;
        } else {
            this.hlf.aR(this.btt, this.hle.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void sq(String str) {
        if (this.Cp) {
            this.Cp = false;
        } else if (this.hlj) {
            showToast(str);
            aCn();
            this.hlj = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void y(Bitmap bitmap) {
        this.hle.bEm().C(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void vq(String str) {
        if (this.Cp) {
            this.Cp = false;
            return;
        }
        this.hlh = str;
        bDx();
    }

    private void bDA() {
        if (this.Cp) {
            this.Cp = false;
        } else if (!TextUtils.isEmpty(this.hlh) && !TextUtils.isEmpty(this.hli)) {
            this.mVideoInfo.setVideoPath(this.hli);
            this.mVideoInfo.setThumbPath(this.hlh);
            if (this.hle.bEt() && !TextUtils.isEmpty(this.hle.bEs())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.hle.bEs());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.dOX, this.cHI, this.mForumName, this.hlc, 13003, this.mVideoInfo, this.mVideoTitleData, this.hld);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            aCn();
            this.hlj = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(e.j.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(e.j.music_cloud)));
        this.hle.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void m(String str, int i, String str2) {
        if (this.Cp) {
            this.Cp = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(e.j.mixing_fail);
            aCn();
            this.hle.onResume();
            this.hlj = false;
            if (this.gWF != null) {
                this.gWF.ad(i, str2);
            }
        } else if (this.hlk.bDD()) {
            vs(str);
        } else {
            vt(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void bDB() {
        this.hli = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void dH(List<PendantData> list) {
        this.hle.dH(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String vy = com.baidu.tieba.video.editvideo.model.a.bDU().vy(stringExtra);
                if (this.hle != null && !TextUtils.isEmpty(vy)) {
                    this.hle.cC(vy, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void vr(String str) {
        vt(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aq(int i, String str) {
        if (this.gWF != null) {
            this.gWF.ad(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void ar(int i, String str) {
        if (this.gWF != null) {
            this.gWF.ad(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        z(bitmap);
    }

    private void vs(String str) {
        this.hle.bEp();
        this.hle.bEq();
        this.hle.bEm().releaseSource();
        this.hlk.vw(str);
    }

    private void vt(String str) {
        File file;
        this.hli = str;
        if (this.hlj) {
            bDA();
            return;
        }
        String str2 = c.hjx + file.getName();
        com.baidu.tbadk.core.util.l.ai(new File(this.hli).getAbsolutePath(), str2);
        vu(str2);
        aCn();
        finishPage();
    }

    private void vu(String str) {
        try {
            new w(this).eR(str);
            com.baidu.tieba.video.editvideo.b.c.aI(this, str);
        } catch (Exception e) {
            aCn();
            this.hlj = false;
        }
    }

    private void z(Bitmap bitmap) {
        if (this.hle == null || this.hlf == null) {
            aCn();
            this.hlj = false;
        } else if (this.Cp) {
            this.Cp = false;
        } else {
            if (!TextUtils.isEmpty(this.hle.getText())) {
                bitmap = this.hle.s(bitmap);
            }
            if (bitmap != null) {
                this.hlf.b(bitmap, c.hjv);
            }
        }
    }
}
