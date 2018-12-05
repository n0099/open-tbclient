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
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.e;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.video.commonview.LocalVideoCompressingDialogView;
import com.baidu.tieba.video.localvideo.b;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String hBn;
    private VideoConvertUtil hEA;
    private String hEB;
    private LocalVideoCompressingDialogView hEF;
    private c hEy;
    private LocalVideoModel hEz;
    private String mForumId;
    private String mForumName;
    private boolean hEC = false;
    private boolean hED = false;
    private boolean hEE = false;
    private CustomMessageListener hEG = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.hEy != null) {
                    LocalVideoActivity.this.hEy.wO(str);
                }
            }
        }
    };
    private CustomMessageListener hEH = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.hEz != null) {
                LocalVideoActivity.this.hEz.bJu();
            }
        }
    };
    private b.a hEI = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dZ(List<d> list) {
            if (LocalVideoActivity.this.hEy != null) {
                LocalVideoActivity.this.hEy.ea(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.hEy != null) {
                if (view != LocalVideoActivity.this.hEy.bJx()) {
                    if (view == LocalVideoActivity.this.hEy.bJy()) {
                        if (!LocalVideoActivity.this.hEy.bJv()) {
                            if (LocalVideoActivity.this.hEy.bJC() == null || LocalVideoActivity.this.hEy.bJC().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil bJq = LocalVideoActivity.this.bJq();
                                if (!bJq.isConvertRunning()) {
                                    String bJB = LocalVideoActivity.this.hEy.bJB();
                                    if (TextUtils.isEmpty(bJB)) {
                                        l.showToast(LocalVideoActivity.this, e.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bJB));
                                        return;
                                    } else if (!new File(bJB).exists()) {
                                        l.showToast(LocalVideoActivity.this, e.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bJB));
                                        return;
                                    } else {
                                        int wy = e.wy(bJB);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bJC = LocalVideoActivity.this.hEy.bJC();
                                            if (bJC != null) {
                                                LocalVideoActivity.this.hEy.aCQ();
                                                LocalVideoActivity.this.hEB = bJC.getVideoPath();
                                                LocalVideoActivity.this.nY(false);
                                                return;
                                            }
                                            return;
                                        } else if (wy >= 1500000) {
                                            if (LocalVideoActivity.this.bHQ()) {
                                                File file = new File(com.baidu.tieba.video.e.hzN, "tieba_" + e.wx(bJB) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hEB = file.getAbsolutePath();
                                                bJq.setConvertType(1);
                                                bJq.cQ(bJB, LocalVideoActivity.this.hEB);
                                                LocalVideoActivity.this.bJr();
                                                LocalVideoActivity.this.hED = false;
                                                LocalVideoActivity.this.hEE = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bJC2 = LocalVideoActivity.this.hEy.bJC();
                                            if (bJC2 != null) {
                                                if (bJC2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.hEy.aCQ();
                                                    LocalVideoActivity.this.hEB = bJC2.getVideoPath();
                                                    LocalVideoActivity.this.nY(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.hzN, "tieba_" + e.wx(bJB) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hEB = file2.getAbsolutePath();
                                                bJq.setConvertType(2);
                                                bJq.cQ(bJB, LocalVideoActivity.this.hEB);
                                                LocalVideoActivity.this.bJr();
                                                LocalVideoActivity.this.hED = false;
                                                LocalVideoActivity.this.hEE = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.hEy.bJw();
                            return;
                        }
                        l.showToast(LocalVideoActivity.this, e.j.show_video_file_error);
                        return;
                    }
                    return;
                }
                LocalVideoActivity.this.finish();
            }
        }
    };
    private Handler hEJ = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.hEJ.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.hEF != null && LocalVideoActivity.this.hEF.isShowing()) {
                        LocalVideoActivity.this.hEF.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.hEJ.sendMessageDelayed(LocalVideoActivity.this.hEJ.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.hEE) {
                        l.showToast(LocalVideoActivity.this, e.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.hED = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.hEB) && (file = new File(LocalVideoActivity.this.hEB)) != null) {
                        LocalVideoActivity.this.hEB = LocalVideoActivity.this.hEB.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.hEB));
                    }
                    LocalVideoActivity.this.bJs();
                    if (!LocalVideoActivity.this.hEC && LocalVideoActivity.this.hEy.bJC() != null) {
                        d wR = e.wR(LocalVideoActivity.this.hEB);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.hEB);
                        videoInfo.setVideoDuration(((int) wR.getDuration()) / 1000);
                        videoInfo.setVideoWidth(wR.getVideoWidth());
                        videoInfo.setVideoHeight(wR.getVideoHeight());
                        videoInfo.setVideoLength(new File(wR.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.hBn, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, e.j.mv_local_video_compress_failed);
                    VideoConvertUtil bJq = LocalVideoActivity.this.bJq();
                    if (bJq != null && bJq.isConvertRunning()) {
                        LocalVideoActivity.this.bJt();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.hED = false;
            LocalVideoActivity.this.bJs();
        }
    };
    private com.baidu.tieba.video.d hEK = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void bHM() {
        }

        @Override // com.baidu.tieba.video.d
        public void wl(int i) {
            LocalVideoActivity.this.hEJ.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.hEJ.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.hEJ.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.hEJ.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.hEJ.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener hEL = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil bJq() {
        if (this.hEA == null) {
            this.hEA = new VideoConvertUtil(this);
            this.hEA.a(this.hEK);
        }
        return this.hEA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJr() {
        this.hEy.aCQ();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.container);
        if (relativeLayout != null) {
            if (this.hEF == null) {
                this.hEF = new LocalVideoCompressingDialogView(this);
            }
            if (this.hEF.getParent() == null) {
                relativeLayout.addView(this.hEF);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hEF.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.hEF.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hEF.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJs() {
        this.hEy.bJz();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.container);
        if (relativeLayout != null && this.hEF.getParent() != null) {
            relativeLayout.removeView(this.hEF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJt() {
        bJq().abortConvert();
        this.hEE = true;
        if (this.hEB != null) {
            File file = new File(this.hEB);
            if (file.exists()) {
                file.delete();
            }
        }
        bJs();
        this.hEB = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bHQ() {
        return VideoConvertUtil.bHQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nY(boolean z) {
        d wR = e.wR(this.hEB);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hEB);
        videoInfo.setVideoDuration(((int) wR.getDuration()) / 1000);
        videoInfo.setVideoWidth(wR.getVideoWidth());
        videoInfo.setVideoHeight(wR.getVideoHeight());
        videoInfo.setVideoLength(new File(wR.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.hBn, videoInfo)));
        this.hED = false;
        this.hEB = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(e.h.local_video_activity);
        if (getIntent() != null) {
            this.mForumId = getIntent().getStringExtra("forum_id");
            this.mForumName = getIntent().getStringExtra("forum_name");
            this.hBn = getIntent().getStringExtra("video_title");
        }
        this.hEy = new c(this, this.mOnClickListener);
        this.hEz = new LocalVideoModel(this);
        this.hEz.a(this.hEI);
        this.hEz.bJu();
        registerListener(this.hEH);
        registerListener(this.hEG);
        registerListener(this.hEL);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.hEC = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hEC = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hEy != null) {
            this.hEy.bJA();
        }
        if (this.hED && !TextUtils.isEmpty(this.hEB) && new File(this.hEB).exists()) {
            nY(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hEy != null) {
            this.hEy.aCR();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hEy.aCR();
        if (this.hEA != null) {
            this.hEA.destroy();
        }
        if (this.hEJ != null) {
            this.hEJ.removeMessages(5);
        }
    }
}
