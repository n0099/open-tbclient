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
    private String hsr;
    private c hvC;
    private LocalVideoModel hvD;
    private VideoConvertUtil hvE;
    private String hvF;
    private LocalVideoCompressingDialogView hvJ;
    private String mForumId;
    private String mForumName;
    private boolean hvG = false;
    private boolean hvH = false;
    private boolean hvI = false;
    private CustomMessageListener hvK = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.hvC != null) {
                    LocalVideoActivity.this.hvC.wg(str);
                }
            }
        }
    };
    private CustomMessageListener hvL = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.hvD != null) {
                LocalVideoActivity.this.hvD.bHQ();
            }
        }
    };
    private b.a hvM = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dX(List<d> list) {
            if (LocalVideoActivity.this.hvC != null) {
                LocalVideoActivity.this.hvC.dY(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.hvC != null) {
                if (view != LocalVideoActivity.this.hvC.bHT()) {
                    if (view == LocalVideoActivity.this.hvC.bHU()) {
                        if (!LocalVideoActivity.this.hvC.bHR()) {
                            if (LocalVideoActivity.this.hvC.bHY() == null || LocalVideoActivity.this.hvC.bHY().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil bHM = LocalVideoActivity.this.bHM();
                                if (!bHM.isConvertRunning()) {
                                    String bHX = LocalVideoActivity.this.hvC.bHX();
                                    if (TextUtils.isEmpty(bHX)) {
                                        l.showToast(LocalVideoActivity.this, e.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bHX));
                                        return;
                                    } else if (!new File(bHX).exists()) {
                                        l.showToast(LocalVideoActivity.this, e.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bHX));
                                        return;
                                    } else {
                                        int vQ = e.vQ(bHX);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bHY = LocalVideoActivity.this.hvC.bHY();
                                            if (bHY != null) {
                                                LocalVideoActivity.this.hvC.aBI();
                                                LocalVideoActivity.this.hvF = bHY.getVideoPath();
                                                LocalVideoActivity.this.nI(false);
                                                return;
                                            }
                                            return;
                                        } else if (vQ >= 1500000) {
                                            if (LocalVideoActivity.this.bGm()) {
                                                File file = new File(com.baidu.tieba.video.e.hqR, "tieba_" + e.vP(bHX) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hvF = file.getAbsolutePath();
                                                bHM.setConvertType(1);
                                                bHM.cL(bHX, LocalVideoActivity.this.hvF);
                                                LocalVideoActivity.this.bHN();
                                                LocalVideoActivity.this.hvH = false;
                                                LocalVideoActivity.this.hvI = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bHY2 = LocalVideoActivity.this.hvC.bHY();
                                            if (bHY2 != null) {
                                                if (bHY2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.hvC.aBI();
                                                    LocalVideoActivity.this.hvF = bHY2.getVideoPath();
                                                    LocalVideoActivity.this.nI(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.hqR, "tieba_" + e.vP(bHX) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hvF = file2.getAbsolutePath();
                                                bHM.setConvertType(2);
                                                bHM.cL(bHX, LocalVideoActivity.this.hvF);
                                                LocalVideoActivity.this.bHN();
                                                LocalVideoActivity.this.hvH = false;
                                                LocalVideoActivity.this.hvI = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.hvC.bHS();
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
    private Handler hvN = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.hvN.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.hvJ != null && LocalVideoActivity.this.hvJ.isShowing()) {
                        LocalVideoActivity.this.hvJ.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.hvN.sendMessageDelayed(LocalVideoActivity.this.hvN.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.hvI) {
                        l.showToast(LocalVideoActivity.this, e.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.hvH = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.hvF) && (file = new File(LocalVideoActivity.this.hvF)) != null) {
                        LocalVideoActivity.this.hvF = LocalVideoActivity.this.hvF.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.hvF));
                    }
                    LocalVideoActivity.this.bHO();
                    if (!LocalVideoActivity.this.hvG && LocalVideoActivity.this.hvC.bHY() != null) {
                        d wj = e.wj(LocalVideoActivity.this.hvF);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.hvF);
                        videoInfo.setVideoDuration(((int) wj.getDuration()) / 1000);
                        videoInfo.setVideoWidth(wj.getVideoWidth());
                        videoInfo.setVideoHeight(wj.getVideoHeight());
                        videoInfo.setVideoLength(new File(wj.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.hsr, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, e.j.mv_local_video_compress_failed);
                    VideoConvertUtil bHM = LocalVideoActivity.this.bHM();
                    if (bHM != null && bHM.isConvertRunning()) {
                        LocalVideoActivity.this.bHP();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.hvH = false;
            LocalVideoActivity.this.bHO();
        }
    };
    private com.baidu.tieba.video.d hvO = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void bGi() {
        }

        @Override // com.baidu.tieba.video.d
        public void vv(int i) {
            LocalVideoActivity.this.hvN.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.hvN.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.hvN.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.hvN.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.hvN.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener hvP = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil bHM() {
        if (this.hvE == null) {
            this.hvE = new VideoConvertUtil(this);
            this.hvE.a(this.hvO);
        }
        return this.hvE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHN() {
        this.hvC.aBI();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.container);
        if (relativeLayout != null) {
            if (this.hvJ == null) {
                this.hvJ = new LocalVideoCompressingDialogView(this);
            }
            if (this.hvJ.getParent() == null) {
                relativeLayout.addView(this.hvJ);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hvJ.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.hvJ.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hvJ.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHO() {
        this.hvC.bHV();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.container);
        if (relativeLayout != null && this.hvJ.getParent() != null) {
            relativeLayout.removeView(this.hvJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHP() {
        bHM().abortConvert();
        this.hvI = true;
        if (this.hvF != null) {
            File file = new File(this.hvF);
            if (file.exists()) {
                file.delete();
            }
        }
        bHO();
        this.hvF = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bGm() {
        return VideoConvertUtil.bGm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nI(boolean z) {
        d wj = e.wj(this.hvF);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hvF);
        videoInfo.setVideoDuration(((int) wj.getDuration()) / 1000);
        videoInfo.setVideoWidth(wj.getVideoWidth());
        videoInfo.setVideoHeight(wj.getVideoHeight());
        videoInfo.setVideoLength(new File(wj.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.hsr, videoInfo)));
        this.hvH = false;
        this.hvF = null;
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
            this.hsr = getIntent().getStringExtra("video_title");
        }
        this.hvC = new c(this, this.mOnClickListener);
        this.hvD = new LocalVideoModel(this);
        this.hvD.a(this.hvM);
        this.hvD.bHQ();
        registerListener(this.hvL);
        registerListener(this.hvK);
        registerListener(this.hvP);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.hvG = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hvG = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hvC != null) {
            this.hvC.bHW();
        }
        if (this.hvH && !TextUtils.isEmpty(this.hvF) && new File(this.hvF).exists()) {
            nI(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hvC != null) {
            this.hvC.aBJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hvC.aBJ();
        if (this.hvE != null) {
            this.hvE.destroy();
        }
        if (this.hvN != null) {
            this.hvN.removeMessages(5);
        }
    }
}
