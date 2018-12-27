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
    private String hEy;
    private c hHJ;
    private LocalVideoModel hHK;
    private VideoConvertUtil hHL;
    private String hHM;
    private LocalVideoCompressingDialogView hHQ;
    private String mForumId;
    private String mForumName;
    private boolean hHN = false;
    private boolean hHO = false;
    private boolean hHP = false;
    private CustomMessageListener hHR = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.hHJ != null) {
                    LocalVideoActivity.this.hHJ.wR(str);
                }
            }
        }
    };
    private CustomMessageListener hHS = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.hHK != null) {
                LocalVideoActivity.this.hHK.bKj();
            }
        }
    };
    private b.a hHT = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void ea(List<d> list) {
            if (LocalVideoActivity.this.hHJ != null) {
                LocalVideoActivity.this.hHJ.eb(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.hHJ != null) {
                if (view != LocalVideoActivity.this.hHJ.bKm()) {
                    if (view == LocalVideoActivity.this.hHJ.bKn()) {
                        if (!LocalVideoActivity.this.hHJ.bKk()) {
                            if (LocalVideoActivity.this.hHJ.bKr() == null || LocalVideoActivity.this.hHJ.bKr().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil bKf = LocalVideoActivity.this.bKf();
                                if (!bKf.isConvertRunning()) {
                                    String bKq = LocalVideoActivity.this.hHJ.bKq();
                                    if (TextUtils.isEmpty(bKq)) {
                                        l.showToast(LocalVideoActivity.this, e.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bKq));
                                        return;
                                    } else if (!new File(bKq).exists()) {
                                        l.showToast(LocalVideoActivity.this, e.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bKq));
                                        return;
                                    } else {
                                        int wB = e.wB(bKq);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bKr = LocalVideoActivity.this.hHJ.bKr();
                                            if (bKr != null) {
                                                LocalVideoActivity.this.hHJ.aDF();
                                                LocalVideoActivity.this.hHM = bKr.getVideoPath();
                                                LocalVideoActivity.this.ob(false);
                                                return;
                                            }
                                            return;
                                        } else if (wB >= 1500000) {
                                            if (LocalVideoActivity.this.bIF()) {
                                                File file = new File(com.baidu.tieba.video.e.hCY, "tieba_" + e.wA(bKq) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hHM = file.getAbsolutePath();
                                                bKf.setConvertType(1);
                                                bKf.cQ(bKq, LocalVideoActivity.this.hHM);
                                                LocalVideoActivity.this.bKg();
                                                LocalVideoActivity.this.hHO = false;
                                                LocalVideoActivity.this.hHP = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bKr2 = LocalVideoActivity.this.hHJ.bKr();
                                            if (bKr2 != null) {
                                                if (bKr2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.hHJ.aDF();
                                                    LocalVideoActivity.this.hHM = bKr2.getVideoPath();
                                                    LocalVideoActivity.this.ob(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.hCY, "tieba_" + e.wA(bKq) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hHM = file2.getAbsolutePath();
                                                bKf.setConvertType(2);
                                                bKf.cQ(bKq, LocalVideoActivity.this.hHM);
                                                LocalVideoActivity.this.bKg();
                                                LocalVideoActivity.this.hHO = false;
                                                LocalVideoActivity.this.hHP = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.hHJ.bKl();
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
    private Handler hHU = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.hHU.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.hHQ != null && LocalVideoActivity.this.hHQ.isShowing()) {
                        LocalVideoActivity.this.hHQ.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.hHU.sendMessageDelayed(LocalVideoActivity.this.hHU.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.hHP) {
                        l.showToast(LocalVideoActivity.this, e.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.hHO = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.hHM) && (file = new File(LocalVideoActivity.this.hHM)) != null) {
                        LocalVideoActivity.this.hHM = LocalVideoActivity.this.hHM.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.hHM));
                    }
                    LocalVideoActivity.this.bKh();
                    if (!LocalVideoActivity.this.hHN && LocalVideoActivity.this.hHJ.bKr() != null) {
                        d wU = e.wU(LocalVideoActivity.this.hHM);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.hHM);
                        videoInfo.setVideoDuration(((int) wU.getDuration()) / 1000);
                        videoInfo.setVideoWidth(wU.getVideoWidth());
                        videoInfo.setVideoHeight(wU.getVideoHeight());
                        videoInfo.setVideoLength(new File(wU.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.hEy, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, e.j.mv_local_video_compress_failed);
                    VideoConvertUtil bKf = LocalVideoActivity.this.bKf();
                    if (bKf != null && bKf.isConvertRunning()) {
                        LocalVideoActivity.this.bKi();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.hHO = false;
            LocalVideoActivity.this.bKh();
        }
    };
    private com.baidu.tieba.video.d hHV = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void bIB() {
        }

        @Override // com.baidu.tieba.video.d
        public void wy(int i) {
            LocalVideoActivity.this.hHU.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.hHU.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.hHU.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.hHU.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.hHU.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener hHW = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil bKf() {
        if (this.hHL == null) {
            this.hHL = new VideoConvertUtil(this);
            this.hHL.a(this.hHV);
        }
        return this.hHL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKg() {
        this.hHJ.aDF();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.container);
        if (relativeLayout != null) {
            if (this.hHQ == null) {
                this.hHQ = new LocalVideoCompressingDialogView(this);
            }
            if (this.hHQ.getParent() == null) {
                relativeLayout.addView(this.hHQ);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hHQ.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.hHQ.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hHQ.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKh() {
        this.hHJ.bKo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.container);
        if (relativeLayout != null && this.hHQ.getParent() != null) {
            relativeLayout.removeView(this.hHQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKi() {
        bKf().abortConvert();
        this.hHP = true;
        if (this.hHM != null) {
            File file = new File(this.hHM);
            if (file.exists()) {
                file.delete();
            }
        }
        bKh();
        this.hHM = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIF() {
        return VideoConvertUtil.bIF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ob(boolean z) {
        d wU = e.wU(this.hHM);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hHM);
        videoInfo.setVideoDuration(((int) wU.getDuration()) / 1000);
        videoInfo.setVideoWidth(wU.getVideoWidth());
        videoInfo.setVideoHeight(wU.getVideoHeight());
        videoInfo.setVideoLength(new File(wU.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.hEy, videoInfo)));
        this.hHO = false;
        this.hHM = null;
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
            this.hEy = getIntent().getStringExtra("video_title");
        }
        this.hHJ = new c(this, this.mOnClickListener);
        this.hHK = new LocalVideoModel(this);
        this.hHK.a(this.hHT);
        this.hHK.bKj();
        registerListener(this.hHS);
        registerListener(this.hHR);
        registerListener(this.hHW);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.hHN = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hHN = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hHJ != null) {
            this.hHJ.bKp();
        }
        if (this.hHO && !TextUtils.isEmpty(this.hHM) && new File(this.hHM).exists()) {
            ob(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hHJ != null) {
            this.hHJ.aDG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hHJ.aDG();
        if (this.hHL != null) {
            this.hHL.destroy();
        }
        if (this.hHU != null) {
            this.hHU.removeMessages(5);
        }
    }
}
