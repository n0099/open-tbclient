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
import com.baidu.adp.lib.f.e;
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
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.k.h;
import com.baidu.tieba.k.l;
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
/* loaded from: classes10.dex */
public class EditVideoActivity extends BaseActivity implements a, b, b.a, MaskVideoView.b {
    private String awC;
    private String emF;
    private com.baidu.tbadk.core.view.a gPM;
    private String gPr;
    private h kjC;
    private int kyb;
    private FrsTabInfoData kyc;
    private String kyd;
    private List<VideoTitleData> kye;
    private com.baidu.tieba.video.editvideo.view.a kyf;
    private SelectCoverModel kyg;
    private SelectMusicModel kyh;
    private String kyi;
    private boolean kyj;
    private com.baidu.tieba.video.editvideo.b.a kyk;
    private HttpMessageListener kyl;
    private CustomMessageListener kym;
    private String mCoverPath;
    private String mForumName;
    private VideoInfo mVideoInfo;
    private String mVideoPath;
    private VideoTitleData mVideoTitleData;
    private boolean rp;

    public EditVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.kjC = lVar.cht();
        }
        this.kyl = new HttpMessageListener(1003376) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetVideoActivityMessage) {
                    ResponseGetVideoActivityMessage responseGetVideoActivityMessage = (ResponseGetVideoActivityMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() == 0) {
                        EditVideoActivity.this.mVideoTitleData = responseGetVideoActivityMessage.getVideoTitleData();
                        EditVideoActivity.this.kye = responseGetVideoActivityMessage.getAllVideoTitleList();
                    }
                }
            }
        };
        this.kym = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.2
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
        this.emF = getIntent().getStringExtra("forum_id");
        this.kyb = getIntent().getIntExtra("pro_zone", -1);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.kyd = getIntent().getStringExtra("video_title");
        this.gPr = getIntent().getStringExtra("KEY_CALL_FROM");
        this.awC = getIntent().getStringExtra("from_type");
        Serializable serializableExtra = getIntent().getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
        if (serializableExtra instanceof VideoInfo) {
            this.mVideoInfo = (VideoInfo) serializableExtra;
            this.mVideoPath = this.mVideoInfo.getVideoPath();
        }
        if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
            this.kyc = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
        }
        if (!TextUtils.isEmpty(this.mVideoPath) && !new File(this.mVideoPath).exists()) {
            finishPage();
        }
        new File(c.kwE).mkdirs();
        this.kyg = new SelectCoverModel(getPageContext(), this, this.kjC);
        this.kyh = new SelectMusicModel(getPageContext(), this);
        this.kyk = new com.baidu.tieba.video.editvideo.b.a(this);
        this.kyk.a(this);
        this.kyf = new com.baidu.tieba.video.editvideo.view.a(getPageContext(), this, findViewById(R.id.root_layout), this.kjC);
        this.kyf.setData(this.mVideoPath);
        this.kyf.aA(getIntent());
        this.kyf.a(this.kyk);
        this.kyf.setGenMaskCoverListener(this);
        this.kyg.cQy();
        this.kyh.cQz();
        this.gPM = new com.baidu.tbadk.core.view.a(getPageContext());
        this.gPM.setTipString(R.string.mixing);
        registerListener(this.kym);
        cPY();
        registerListener(this.kyl);
        cPX();
        TiebaStatic.log("c12303");
    }

    private void cPW() {
        this.rp = true;
        this.kyi = null;
        this.mCoverPath = null;
        bKb();
    }

    public void cPX() {
        HttpMessage httpMessage = new HttpMessage(1003376);
        if (!StringUtils.isNull(this.emF)) {
            httpMessage.addParam("forum_id", this.emF);
        }
        sendMessage(httpMessage);
    }

    private void cPY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003376, TbConfig.SERVER_ADDRESS + TbConfig.GET_VIDEO_ACTIVITY);
        tbHttpMessageTask.setResponsedClass(ResponseGetVideoActivityMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.kyf.getRootView());
        if (this.kyf != null) {
            this.kyf.onChangeSkinType(getPageContext(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.kyf != null) {
            this.kyf.onPause();
        }
        if (this.kyk.cQh()) {
            this.kyk.interruptProcess();
        }
        this.kyj = false;
        this.rp = true;
        cPW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kyf != null) {
            this.kyf.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.baidu.tieba.video.editvideo.model.a.cQt().cQu();
        com.baidu.tieba.video.editvideo.model.b.cQw().cQx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kyf != null) {
            this.kyf.release();
        }
        if (this.kyg != null) {
            this.kyg.cancelLoadData();
        }
        if (this.kyh != null) {
            this.kyh.cancelLoadData();
        }
        MessageManager.getInstance().unRegisterTask(1003376);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kyf != null) {
            this.kyf.showDialog();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void finishPage() {
        bKb();
        this.kyj = false;
        if (this.kyf != null && this.kyf.cQJ() != null) {
            this.kyf.cQJ().pause();
            this.kyf.cQJ().releaseSource();
        }
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void onNext() {
        if (this.kyf == null || this.kyg == null || this.kyh == null) {
            bKb();
            this.kyj = false;
        } else if (!j.isNetWorkAvailable()) {
            getPageContext().showToast(R.string.no_network);
        } else if (!this.kyj) {
            this.kyj = true;
            this.rp = false;
            this.kyi = null;
            this.mCoverPath = null;
            this.kyf.onPause();
            this.gPM.setDialogVisiable(true);
            cQa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKb() {
        if (this.gPM != null) {
            this.gPM.setDialogVisiable(false);
        }
    }

    private void cPZ() {
        if (this.rp) {
            this.rp = false;
        } else if (this.kyf.cQQ()) {
            this.kyh.h(this.mVideoPath, this.kyf.cQO(), c.kwD + "video_" + System.currentTimeMillis() + ".mp4", this.kyf.isMute() ? false : true);
        } else if (this.kyf.isMute()) {
            this.kyh.h(this.mVideoPath, null, c.kwD + "video_" + System.currentTimeMillis() + ".mp4", this.kyf.isMute() ? false : true);
        } else {
            v(this.mVideoPath, -4399, "");
        }
    }

    private void cQa() {
        if (this.rp) {
            this.rp = false;
            return;
        }
        String text = this.kyf.getText();
        if (TextUtils.isEmpty(text)) {
            this.kyg.bw(this.mVideoPath, this.kyf.getCurrentPosition());
        } else {
            this.kyg.GB(text);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cQb() {
        File file;
        this.rp = false;
        if (this.kyf.cQQ() || this.kyf.isMute()) {
            this.kyj = false;
            this.gPM.setDialogVisiable(true);
            this.kyf.onPause();
            if (this.kyi != null) {
                v(this.kyi, -4399, "");
            } else {
                cPZ();
            }
        } else if (this.kyk.cQg()) {
            this.kyj = false;
            this.kyf.onPause();
            this.gPM.setDialogVisiable(true);
            JW(this.mVideoPath);
        } else {
            if (this.mVideoInfo.getVideoType() == 1 || (this.mVideoInfo.getVideoType() == 2 && this.mVideoInfo.isCompressedVideo())) {
                m.copyFile(new File(this.mVideoPath).getAbsolutePath(), c.kwE + file.getName());
                JY(c.kwE + file.getName());
            }
            finishPage();
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cuL() {
        if (this.kyf == null || this.kyg == null) {
            bKb();
            this.kyj = false;
        } else if (this.rp) {
            this.rp = false;
        } else {
            this.kyg.bw(this.mVideoPath, this.kyf.getCurrentPosition());
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void Gz(String str) {
        if (this.rp) {
            this.rp = false;
        } else if (this.kyj) {
            showToast(str);
            bKb();
            this.kyj = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void G(Bitmap bitmap) {
        this.kyf.cQJ().K(bitmap);
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void JV(String str) {
        if (this.rp) {
            this.rp = false;
            return;
        }
        this.mCoverPath = str;
        cPZ();
    }

    private void cQc() {
        if (this.rp) {
            this.rp = false;
        } else if (!TextUtils.isEmpty(this.mCoverPath) && !TextUtils.isEmpty(this.kyi)) {
            this.mVideoInfo.setVideoPath(this.kyi);
            this.mVideoInfo.setThumbPath(this.mCoverPath);
            if (this.kyf.cQQ() && !TextUtils.isEmpty(this.kyf.cQP())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.kyf.cQP());
                this.mVideoInfo.setMusicListInfo(arrayList);
            }
            WriteVideoActivityConfig writeVideoActivityConfig = new WriteVideoActivityConfig(getPageContext().getPageActivity(), this.gPr, this.emF, this.mForumName, this.kyd, RequestResponseCode.REQUEST_WRITE_NEW, this.mVideoInfo, this.mVideoTitleData, this.kye);
            if (!StringUtils.isNull(this.awC)) {
                writeVideoActivityConfig.addFromType(this.awC);
            }
            writeVideoActivityConfig.setProZone(this.kyb);
            writeVideoActivityConfig.setFrsTabInfo(this.kyc);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVideoActivityConfig));
            bKb();
            this.kyj = false;
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, new MusicData("-100", 1, getPageContext().getString(R.string.music_normal)));
        list.add(1, new MusicData("-200", 2, getPageContext().getString(R.string.music_cloud)));
        this.kyf.setMusicData(list);
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
        if (this.rp) {
            this.rp = false;
        } else if (TextUtils.isEmpty(str)) {
            showToast(R.string.mixing_fail);
            bKb();
            this.kyf.onResume();
            this.kyj = false;
            if (this.kjC != null) {
                this.kjC.aR(i, str2);
            }
        } else if (this.kyk.cQg()) {
            JW(str);
        } else {
            JX(str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void cQd() {
        this.kyi = null;
    }

    @Override // com.baidu.tieba.video.editvideo.a
    public void ep(List<PendantData> list) {
        this.kyf.ep(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String Kb = com.baidu.tieba.video.editvideo.model.a.cQt().Kb(stringExtra);
                if (this.kyf != null && !TextUtils.isEmpty(Kb)) {
                    this.kyf.eI(Kb, stringExtra2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void onGenFilterVideoSuccess(String str) {
        JX(str);
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void onGenFilterVideoFail(int i, String str) {
        if (this.kjC != null) {
            this.kjC.aR(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void onGenFilterVideoRecordError(int i, String str) {
        if (this.kjC != null) {
            this.kjC.aR(i, str);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b.b.a
    public void cQe() {
        e.gx().post(new Runnable() { // from class: com.baidu.tieba.video.editvideo.EditVideoActivity.3
            @Override // java.lang.Runnable
            public void run() {
                EditVideoActivity.this.bKb();
                EditVideoActivity.this.showToast(R.string.mix_fail);
                EditVideoActivity.this.finishPage();
            }
        });
    }

    @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
    public void c(Bitmap bitmap, boolean z) {
        H(bitmap);
    }

    private void JW(String str) {
        this.kyf.cQM();
        this.kyf.cQN();
        this.kyf.cQJ().releaseSource();
        this.kyk.Ka(str);
    }

    private void JX(String str) {
        File file;
        this.kyi = str;
        if (this.kyj) {
            cQc();
            return;
        }
        String str2 = c.kwE + file.getName();
        m.copyFile(new File(this.kyi).getAbsolutePath(), str2);
        JY(str2);
        bKb();
        finishPage();
    }

    private void JY(String str) {
        try {
            new w(this).saveVideo(str);
            com.baidu.tieba.video.editvideo.b.c.bp(this, str);
        } catch (Exception e) {
            bKb();
            this.kyj = false;
        }
    }

    private void H(Bitmap bitmap) {
        if (this.kyf == null || this.kyg == null) {
            bKb();
            this.kyj = false;
        } else if (this.rp) {
            this.rp = false;
        } else {
            if (!TextUtils.isEmpty(this.kyf.getText())) {
                bitmap = this.kyf.z(bitmap);
            }
            if (bitmap != null) {
                this.kyg.b(bitmap, c.kwC);
            }
        }
    }
}
