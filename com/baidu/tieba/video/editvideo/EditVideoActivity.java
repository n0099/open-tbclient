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
/* loaded from: classes5.dex */
public class EditVideoActivity extends BaseActivity implements a, b, b.a, MaskVideoView.b {
    private boolean AQ;
    private String alH;
    private String eFy;
    private String fTa;
    private com.baidu.tbadk.core.view.b flO;
    private h jgo;
    private int jve;
    private String jvf;
    private List<VideoTitleData> jvg;
    private com.baidu.tieba.video.editvideo.view.a jvh;
    private SelectCoverModel jvi;
    private SelectMusicModel jvj;
    private String jvk;
    private String jvl;
    private boolean jvm;
    private com.baidu.tieba.video.editvideo.b.a jvn;
    private HttpMessageListener jvo;
    private CustomMessageListener jvp;
    private String mForumName;
    private String mFromType;
    private VideoInfo mVideoInfo;
    private VideoTitleData mVideoTitleData;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.jgo = lVar.bOW();
        }
        this.jvo = new HttpMessageListener(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.jvg = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.jvp = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.eFy = getIntent().getStringExtra("forum_id");
        this.jve = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.jvf = getIntent().getStringExtra("video_title");
        this.fTa = getIntent().getStringExtra("KEY_CALL_FROM");
        this.mFromType = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.alH = this.mVideoInfo.getVideoPath();
        }
        if (!TextUtils.isEmpty(this.alH) && !new File(this.alH).exists()) {
            finishPage();
        }
        new File(c.jtA).mkdirs();
        this.jvi = new SelectCoverModel(getPageContext(), this, this.jgo);
        this.jvj = new SelectMusicModel(getPageContext(), this);
        this.jvn = new com.baidu.tieba.video.editvideo.b.a(this);
        this.jvn.a(this);
        this.jvh = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.jgo);
        this.jvh.setData(this.alH);
        this.jvh.ay(getIntent());
        this.jvh.a(this.jvn);
        this.jvh.setGenMaskCoverListener(this);
        this.jvi.cuE();
        this.jvj.cuF();
        this.flO = new com.baidu.tbadk.core.view.b(getPageContext());
        this.flO.iz(R.string.mixing);
        registerListener(this.jvp);
        cua();
        registerListener(this.jvo);
        ctZ();
        TiebaStatic.log("c12303");
    }

    private void ctY() {
        this.AQ = true;
        this.jvl = null;
        this.jvk = null;
        brJ();
    }

    public void ctZ() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
        if (!StringUtils.isNull(this.eFy)) {
            httpMessage.addParam("forum_id", this.eFy);
        }
        sendMessage(httpMessage);
    }

    private void cua() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jvh.getRootView());
        if (this.jvh != null) {
            this.jvh.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jvh != null) {
            this.jvh.onPause();
        }
        if (this.jvn.cuj()) {
            this.jvn.cuk();
        }
        this.jvm = false;
        this.AQ = true;
        ctY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jvh != null) {
            this.jvh.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.cuz().cuA();
        com.baidu.tieba.video.editvideo.model.b.cuC().cuD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jvh != null) {
            this.jvh.release();
        }
        if (this.jvi != null) {
            this.jvi.cancelLoadData();
        }
        if (this.jvj != null) {
            this.jvj.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_VIDEO_ACTIVITY);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jvh != null) {
            this.jvh.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        brJ();
        this.jvm = false;
        if (this.jvh != null && this.jvh.cuR() != null) {
            this.jvh.cuR().pause();
            this.jvh.cuR().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cub() {
        if (this.jvh == null || this.jvi == null || this.jvj == null) {
            brJ();
            this.jvm = false;
        } else if (!j.kc()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.jvm) {
            this.jvm = true;
            this.AQ = false;
            this.jvl = null;
            this.jvk = null;
            this.jvh.onPause();
            this.flO.ej(true);
            cud();
        }
    }

    private void brJ() {
        if (this.flO != null) {
            this.flO.ej(false);
        }
    }

    private void cuc() {
        if (this.AQ) {
            this.AQ = false;
        } else if (this.jvh.cuY()) {
            this.jvj.e(this.alH, this.jvh.cuW(), c.jtz + "video_" + System.currentTimeMillis() + ".mp4", this.jvh.isMute() ? false : true);
        } else if (this.jvh.isMute()) {
            this.jvj.e(this.alH, null, c.jtz + "video_" + System.currentTimeMillis() + ".mp4", this.jvh.isMute() ? false : true);
        } else {
            t(this.alH, -4399, "");
        }
    }

    private void cud() {
        if (this.AQ) {
            this.AQ = false;
            return;
        }
        String text = this.jvh.getText();
        if (TextUtils.isEmpty(text)) {
            this.jvi.bq(this.alH, this.jvh.getCurrentPosition());
        } else {
            this.jvi.Cy(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cue() {
        File file;
        this.AQ = false;
        if (this.jvh.cuY() || this.jvh.isMute()) {
            this.jvm = false;
            this.flO.ej(true);
            this.jvh.onPause();
            if (this.jvl != null) {
                t(this.jvl, -4399, "");
            } else {
                cuc();
            }
        } else if (this.jvn.cui()) {
            this.jvm = false;
            this.jvh.onPause();
            this.flO.ej(true);
            FH(this.alH);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.bQ(new File(this.alH).getAbsolutePath(), c.jtA + file.getName());
                FJ(c.jtA + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cap() {
        if (this.jvh == null || this.jvi == null) {
            brJ();
            this.jvm = false;
        } else if (this.AQ) {
            this.AQ = false;
        } else {
            this.jvi.bq(this.alH, this.jvh.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Cv(String str) {
        if (this.AQ) {
            this.AQ = false;
        } else if (this.jvm) {
            showToast(str);
            brJ();
            this.jvm = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void H(Bitmap bitmap) {
        this.jvh.cuR().L(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void FF(String str) {
        if (this.AQ) {
            this.AQ = false;
            return;
        }
        this.jvk = str;
        cuc();
    }

    private void cuf() {
        if (this.AQ) {
            this.AQ = false;
        } else if (!TextUtils.isEmpty(this.jvk) && !TextUtils.isEmpty(this.jvl)) {
            this.mVideoInfo.setVideoPath(this.jvl);
            this.mVideoInfo.setThumbPath(this.jvk);
            if (this.jvh.cuY() && !TextUtils.isEmpty(this.jvh.cuX())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.jvh.cuX());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.fTa, this.eFy, this.mForumName, this.jvf, 13003, this.mVideoInfo, this.mVideoTitleData, this.jvg);
            if (!StringUtils.isNull(this.mFromType)) {
                writeVideoActivityConfig.addFromType(this.mFromType);
            }
            writeVideoActivityConfig.setProZone(this.jve);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVideoActivityConfig));
            brJ();
            this.jvm = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(R.string.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(R.string.music_cloud)));
        this.jvh.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
        if (this.AQ) {
            this.AQ = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.mixing_fail);
            brJ();
            this.jvh.onResume();
            this.jvm = false;
            if (this.jgo != null) {
                this.jgo.ax(i, str2);
            }
        } else if (this.jvn.cui()) {
            FH(str);
        } else {
            FI(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cug() {
        this.jvl = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void ep(List<PendantData> list) {
        this.jvh.ep(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String FM = com.baidu.tieba.video.editvideo.model.a.cuz().FM(stringExtra);
                if (this.jvh != null && !TextUtils.isEmpty(FM)) {
                    this.jvh.et(FM, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void FG(String str) {
        FI(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aK(int i, String str) {
        if (this.jgo != null) {
            this.jgo.ax(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void aL(int i, String str) {
        if (this.jgo != null) {
            this.jgo.ax(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void d(Bitmap bitmap, boolean z) {
        I(bitmap);
    }

    private void FH(String str) {
        this.jvh.cuU();
        this.jvh.cuV();
        this.jvh.cuR().releaseSource();
        this.jvn.FL(str);
    }

    private void FI(String str) {
        File file;
        this.jvl = str;
        if (this.jvm) {
            cuf();
            return;
        }
        String str2 = c.jtA + file.getName();
        m.bQ(new File(this.jvl).getAbsolutePath(), str2);
        FJ(str2);
        brJ();
        finishPage();
    }

    private void FJ(String str) {
        try {
            new w(this).nQ(str);
            com.baidu.tieba.video.editvideo.b.c.aL(this, str);
        } catch (Exception e) {
            brJ();
            this.jvm = false;
        }
    }

    private void I(Bitmap bitmap) {
        if (this.jvh == null || this.jvi == null) {
            brJ();
            this.jvm = false;
        } else if (this.AQ) {
            this.AQ = false;
        } else {
            if (!TextUtils.isEmpty(this.jvh.getText())) {
                bitmap = this.jvh.B(bitmap);
            }
            if (bitmap != null) {
                this.jvi.b(bitmap, c.jty);
            }
        }
    }
}
