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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.video.commonview.LocalVideoCompressingDialogView;
import com.baidu.tieba.video.localvideo.b;
import java.io.File;
import java.util.List;
/* loaded from: classes7.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String krF;
    private c kuG;
    private LocalVideoModel kuH;
    private VideoConvertUtil kuI;
    private String kuJ;
    private LocalVideoCompressingDialogView kuN;
    private String mForumId;
    private String mForumName;
    private boolean kuK = false;
    private boolean kuL = false;
    private boolean kuM = false;
    private CustomMessageListener kuO = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.kuG != null) {
                    LocalVideoActivity.this.kuG.JK(str);
                }
            }
        }
    };
    private CustomMessageListener kuP = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.kuH != null) {
                LocalVideoActivity.this.kuH.cOe();
            }
        }
    };
    private b.a kuQ = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void ev(List<d> list) {
            if (LocalVideoActivity.this.kuG != null) {
                LocalVideoActivity.this.kuG.ew(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.kuG != null) {
                if (view != LocalVideoActivity.this.kuG.cOh()) {
                    if (view == LocalVideoActivity.this.kuG.cOi()) {
                        if (!LocalVideoActivity.this.kuG.cOf()) {
                            if (LocalVideoActivity.this.kuG.cOl() == null || LocalVideoActivity.this.kuG.cOl().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil cOa = LocalVideoActivity.this.cOa();
                                if (!cOa.isConvertRunning()) {
                                    String cOk = LocalVideoActivity.this.kuG.cOk();
                                    if (TextUtils.isEmpty(cOk)) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, cOk));
                                        return;
                                    } else if (!new File(cOk).exists()) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, cOk));
                                        return;
                                    } else {
                                        int Jv = e.Jv(cOk);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d cOl = LocalVideoActivity.this.kuG.cOl();
                                            if (cOl != null) {
                                                LocalVideoActivity.this.kuG.bDD();
                                                LocalVideoActivity.this.kuJ = cOl.getVideoPath();
                                                LocalVideoActivity.this.sZ(false);
                                                return;
                                            }
                                            return;
                                        } else if (Jv >= 1500000) {
                                            if (LocalVideoActivity.this.cMC()) {
                                                File file = new File(com.baidu.tieba.video.e.kql, "tieba_" + e.Ju(cOk) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.kuJ = file.getAbsolutePath();
                                                cOa.setConvertType(1);
                                                cOa.ex(cOk, LocalVideoActivity.this.kuJ);
                                                LocalVideoActivity.this.cOb();
                                                LocalVideoActivity.this.kuL = false;
                                                LocalVideoActivity.this.kuM = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d cOl2 = LocalVideoActivity.this.kuG.cOl();
                                            if (cOl2 != null) {
                                                if (cOl2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.kuG.bDD();
                                                    LocalVideoActivity.this.kuJ = cOl2.getVideoPath();
                                                    LocalVideoActivity.this.sZ(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.kql, "tieba_" + e.Ju(cOk) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.kuJ = file2.getAbsolutePath();
                                                cOa.setConvertType(2);
                                                cOa.ex(cOk, LocalVideoActivity.this.kuJ);
                                                LocalVideoActivity.this.cOb();
                                                LocalVideoActivity.this.kuL = false;
                                                LocalVideoActivity.this.kuM = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.kuG.cOg();
                            return;
                        }
                        l.showToast(LocalVideoActivity.this, (int) R.string.show_video_file_error);
                        return;
                    }
                    return;
                }
                LocalVideoActivity.this.finish();
            }
        }
    };
    private Handler kuR = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.kuR.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.kuN != null && LocalVideoActivity.this.kuN.isShowing()) {
                        LocalVideoActivity.this.kuN.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.kuR.sendMessageDelayed(LocalVideoActivity.this.kuR.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.kuM) {
                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.kuL = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.kuJ) && (file = new File(LocalVideoActivity.this.kuJ)) != null) {
                        LocalVideoActivity.this.kuJ = LocalVideoActivity.this.kuJ.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.kuJ));
                    }
                    LocalVideoActivity.this.cOc();
                    if (!LocalVideoActivity.this.kuK && LocalVideoActivity.this.kuG.cOl() != null) {
                        d JM = e.JM(LocalVideoActivity.this.kuJ);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.kuJ);
                        videoInfo.setVideoDuration(((int) JM.getDuration()) / 1000);
                        videoInfo.setVideoWidth(JM.getVideoWidth());
                        videoInfo.setVideoHeight(JM.getVideoHeight());
                        videoInfo.setVideoLength(new File(JM.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.krF, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                    VideoConvertUtil cOa = LocalVideoActivity.this.cOa();
                    if (cOa != null && cOa.isConvertRunning()) {
                        LocalVideoActivity.this.cOd();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.kuL = false;
            LocalVideoActivity.this.cOc();
        }
    };
    private com.baidu.tieba.video.d kuS = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void cMy() {
        }

        @Override // com.baidu.tieba.video.d
        public void De(int i) {
            LocalVideoActivity.this.kuR.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.kuR.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.kuR.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.kuR.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.kuR.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener kuT = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil cOa() {
        if (this.kuI == null) {
            this.kuI = new VideoConvertUtil(this);
            this.kuI.a(this.kuS);
        }
        return this.kuI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOb() {
        this.kuG.bDD();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.kuN == null) {
                this.kuN = new LocalVideoCompressingDialogView(this);
            }
            if (this.kuN.getParent() == null) {
                relativeLayout.addView(this.kuN);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kuN.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.kuN.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.kuN.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOc() {
        this.kuG.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.kuN.getParent() != null) {
            relativeLayout.removeView(this.kuN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOd() {
        cOa().abortConvert();
        this.kuM = true;
        if (this.kuJ != null) {
            File file = new File(this.kuJ);
            if (file.exists()) {
                file.delete();
            }
        }
        cOc();
        this.kuJ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cMC() {
        return VideoConvertUtil.cMC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sZ(boolean z) {
        d JM = e.JM(this.kuJ);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kuJ);
        videoInfo.setVideoDuration(((int) JM.getDuration()) / 1000);
        videoInfo.setVideoWidth(JM.getVideoWidth());
        videoInfo.setVideoHeight(JM.getVideoHeight());
        videoInfo.setVideoLength(new File(JM.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.krF, videoInfo)));
        this.kuL = false;
        this.kuJ = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.local_video_activity);
        if (getIntent() != null) {
            this.mForumId = getIntent().getStringExtra("forum_id");
            this.mForumName = getIntent().getStringExtra("forum_name");
            this.krF = getIntent().getStringExtra("video_title");
        }
        this.kuG = new c(this, this.mOnClickListener);
        this.kuH = new LocalVideoModel(this);
        this.kuH.a(this.kuQ);
        this.kuH.cOe();
        registerListener(this.kuP);
        registerListener(this.kuO);
        registerListener(this.kuT);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.kuK = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.kuK = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kuG != null) {
            this.kuG.cOj();
        }
        if (this.kuL && !TextUtils.isEmpty(this.kuJ) && new File(this.kuJ).exists()) {
            sZ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.kuG != null) {
            this.kuG.bDE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kuG.bDE();
        if (this.kuI != null) {
            this.kuI.destroy();
        }
        if (this.kuR != null) {
            this.kuR.removeMessages(5);
        }
    }
}
