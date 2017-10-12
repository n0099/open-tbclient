package com.baidu.tieba.video.localvideo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.localvideo.b;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String guZ;
    private g gvh;
    private com.baidu.tieba.video.commonview.a gvl;
    private c gwJ;
    private LocalVideoModel gwK;
    private String gwL;
    private String mForumId;
    private String mForumName;
    private boolean gvi = false;
    private boolean gvj = false;
    private boolean gvk = false;
    private CustomMessageListener gwM = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.gwJ != null) {
                    LocalVideoActivity.this.gwJ.sF(str);
                }
            }
        }
    };
    private CustomMessageListener gwN = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.gwK != null) {
                LocalVideoActivity.this.gwK.bwo();
            }
        }
    };
    private b.a gwO = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dA(List<d> list) {
            if (LocalVideoActivity.this.gwJ != null) {
                LocalVideoActivity.this.gwJ.dB(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.gwJ != null) {
                if (view != LocalVideoActivity.this.gwJ.bwq()) {
                    if (view == LocalVideoActivity.this.gwJ.bwr()) {
                        if (LocalVideoActivity.this.gwJ.bwv() == null || LocalVideoActivity.this.gwJ.bwv().getDuration() <= 600000) {
                            g bvI = LocalVideoActivity.this.bvI();
                            if (!bvI.isConvertRunning()) {
                                String bwu = LocalVideoActivity.this.gwJ.bwu();
                                if (TextUtils.isEmpty(bwu)) {
                                    l.showToast(LocalVideoActivity.this, d.l.mv_local_video_video_not_exist);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bwu));
                                    return;
                                } else if (!new File(bwu).exists()) {
                                    l.showToast(LocalVideoActivity.this, d.l.mv_local_video_video_not_exist);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bwu));
                                    return;
                                } else {
                                    int sI = e.sI(bwu);
                                    if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                        d bwv = LocalVideoActivity.this.gwJ.bwv();
                                        if (bwv != null) {
                                            LocalVideoActivity.this.gwJ.aip();
                                            LocalVideoActivity.this.gwL = bwv.getVideoPath();
                                            LocalVideoActivity.this.nd(false);
                                            return;
                                        }
                                        return;
                                    } else if (sI >= 1500000) {
                                        if (LocalVideoActivity.this.bwn()) {
                                            File file = new File(com.baidu.tieba.video.c.gtY, "tieba_" + e.sL(bwu) + "_tiebaconverting.mp4");
                                            LocalVideoActivity.this.gwL = file.getAbsolutePath();
                                            bvI.setConvertType(1);
                                            bvI.cl(bwu, LocalVideoActivity.this.gwL);
                                            LocalVideoActivity.this.bwm();
                                            LocalVideoActivity.this.gvj = false;
                                            LocalVideoActivity.this.gvk = false;
                                            return;
                                        }
                                        return;
                                    } else {
                                        d bwv2 = LocalVideoActivity.this.gwJ.bwv();
                                        if (bwv2 != null) {
                                            if (bwv2.getDuration() >= 15000) {
                                                LocalVideoActivity.this.gwJ.aip();
                                                LocalVideoActivity.this.gwL = bwv2.getVideoPath();
                                                LocalVideoActivity.this.nd(false);
                                                return;
                                            }
                                            File file2 = new File(com.baidu.tieba.video.c.gtY, "tieba_" + e.sL(bwu) + "_tiebaconverting.mp4");
                                            LocalVideoActivity.this.gwL = file2.getAbsolutePath();
                                            bvI.setConvertType(2);
                                            bvI.cl(bwu, LocalVideoActivity.this.gwL);
                                            LocalVideoActivity.this.bwm();
                                            LocalVideoActivity.this.gvj = false;
                                            LocalVideoActivity.this.gvk = false;
                                            return;
                                        }
                                        return;
                                    }
                                }
                            }
                            return;
                        }
                        LocalVideoActivity.this.gwJ.bwp();
                        return;
                    }
                    return;
                }
                LocalVideoActivity.this.finish();
            }
        }
    };
    private Handler gvm = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.gvm.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.gvl != null && LocalVideoActivity.this.gvl.isShowing()) {
                        LocalVideoActivity.this.gvl.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.gvm.sendMessageDelayed(LocalVideoActivity.this.gvm.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.gvk) {
                        l.showToast(LocalVideoActivity.this, d.l.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.gvj = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.gwL) && (file = new File(LocalVideoActivity.this.gwL)) != null) {
                        LocalVideoActivity.this.gwL = LocalVideoActivity.this.gwL.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.gwL));
                    }
                    LocalVideoActivity.this.bvG();
                    if (!LocalVideoActivity.this.gvi && LocalVideoActivity.this.gwJ.bwv() != null) {
                        d sK = e.sK(LocalVideoActivity.this.gwL);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.gwL);
                        videoInfo.setVideoDuration(((int) sK.getDuration()) / 1000);
                        videoInfo.setVideoWidth(sK.getVideoWidth());
                        videoInfo.setVideoHeight(sK.getVideoHeight());
                        videoInfo.setVideoLength(new File(sK.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.guZ, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.l.mv_local_video_compress_failed);
                    g bvI = LocalVideoActivity.this.bvI();
                    if (bvI != null && bvI.isConvertRunning()) {
                        LocalVideoActivity.this.bvH();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.gvj = false;
            LocalVideoActivity.this.bvG();
        }
    };
    private f gvn = new f() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.localvideo.f
        public void bvQ() {
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void uw(int i) {
            LocalVideoActivity.this.gvm.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertSuccess() {
            LocalVideoActivity.this.gvm.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertFailed() {
            LocalVideoActivity.this.gvm.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.gvm.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertAborted() {
            LocalVideoActivity.this.gvm.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener gwP = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public g bvI() {
        if (this.gvh == null) {
            this.gvh = new g(this);
            this.gvh.a(this.gvn);
        }
        return this.gvh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwm() {
        this.gwJ.aip();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.h.container);
        if (relativeLayout != null) {
            if (this.gvl == null) {
                this.gvl = new com.baidu.tieba.video.commonview.a(this);
            }
            if (this.gvl.getParent() == null) {
                relativeLayout.addView(this.gvl);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gvl.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.gvl.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.gvl.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvG() {
        this.gwJ.bws();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.h.container);
        if (relativeLayout != null && this.gvl.getParent() != null) {
            relativeLayout.removeView(this.gvl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvH() {
        bvI().abortConvert();
        this.gvk = true;
        if (this.gwL != null) {
            File file = new File(this.gwL);
            if (file.exists()) {
                file.delete();
            }
        }
        bvG();
        this.gwL = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bwn() {
        File file = new File(com.baidu.tieba.video.c.gtY);
        if (file != null) {
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.exists() && file.isDirectory()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nd(boolean z) {
        d sK = e.sK(this.gwL);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.gwL);
        videoInfo.setVideoDuration(((int) sK.getDuration()) / 1000);
        videoInfo.setVideoWidth(sK.getVideoWidth());
        videoInfo.setVideoHeight(sK.getVideoHeight());
        videoInfo.setVideoLength(new File(sK.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, this.mForumName, this.mForumId, this.guZ, videoInfo)));
        this.gvj = false;
        this.gwL = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.j.local_video_activity);
        if (getIntent() != null) {
            this.mForumId = getIntent().getStringExtra("forum_id");
            this.mForumName = getIntent().getStringExtra("forum_name");
            this.guZ = getIntent().getStringExtra("video_title");
        }
        this.gwJ = new c(this, this.mOnClickListener);
        this.gwK = new LocalVideoModel(this);
        this.gwK.a(this.gwO);
        this.gwK.bwo();
        registerListener(this.gwN);
        registerListener(this.gwM);
        registerListener(this.gwP);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gvi = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gvi = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gwJ != null) {
            this.gwJ.bwt();
        }
        if (this.gvj && !TextUtils.isEmpty(this.gwL) && new File(this.gwL).exists()) {
            nd(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gwJ != null) {
            this.gwJ.aiq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gwJ.aiq();
        if (this.gvh != null) {
            this.gvh.destroy();
        }
        if (this.gvm != null) {
            this.gvm.removeMessages(5);
        }
    }
}
