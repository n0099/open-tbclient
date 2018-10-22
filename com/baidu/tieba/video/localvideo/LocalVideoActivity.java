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
    private String hss;
    private c hvD;
    private LocalVideoModel hvE;
    private VideoConvertUtil hvF;
    private String hvG;
    private LocalVideoCompressingDialogView hvK;
    private String mForumId;
    private String mForumName;
    private boolean hvH = false;
    private boolean hvI = false;
    private boolean hvJ = false;
    private CustomMessageListener hvL = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.hvD != null) {
                    LocalVideoActivity.this.hvD.wg(str);
                }
            }
        }
    };
    private CustomMessageListener hvM = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.hvE != null) {
                LocalVideoActivity.this.hvE.bHQ();
            }
        }
    };
    private b.a hvN = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dX(List<d> list) {
            if (LocalVideoActivity.this.hvD != null) {
                LocalVideoActivity.this.hvD.dY(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.hvD != null) {
                if (view != LocalVideoActivity.this.hvD.bHT()) {
                    if (view == LocalVideoActivity.this.hvD.bHU()) {
                        if (!LocalVideoActivity.this.hvD.bHR()) {
                            if (LocalVideoActivity.this.hvD.bHY() == null || LocalVideoActivity.this.hvD.bHY().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil bHM = LocalVideoActivity.this.bHM();
                                if (!bHM.isConvertRunning()) {
                                    String bHX = LocalVideoActivity.this.hvD.bHX();
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
                                            d bHY = LocalVideoActivity.this.hvD.bHY();
                                            if (bHY != null) {
                                                LocalVideoActivity.this.hvD.aBJ();
                                                LocalVideoActivity.this.hvG = bHY.getVideoPath();
                                                LocalVideoActivity.this.nI(false);
                                                return;
                                            }
                                            return;
                                        } else if (vQ >= 1500000) {
                                            if (LocalVideoActivity.this.bGm()) {
                                                File file = new File(com.baidu.tieba.video.e.hqS, "tieba_" + e.vP(bHX) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hvG = file.getAbsolutePath();
                                                bHM.setConvertType(1);
                                                bHM.cL(bHX, LocalVideoActivity.this.hvG);
                                                LocalVideoActivity.this.bHN();
                                                LocalVideoActivity.this.hvI = false;
                                                LocalVideoActivity.this.hvJ = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bHY2 = LocalVideoActivity.this.hvD.bHY();
                                            if (bHY2 != null) {
                                                if (bHY2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.hvD.aBJ();
                                                    LocalVideoActivity.this.hvG = bHY2.getVideoPath();
                                                    LocalVideoActivity.this.nI(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.hqS, "tieba_" + e.vP(bHX) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hvG = file2.getAbsolutePath();
                                                bHM.setConvertType(2);
                                                bHM.cL(bHX, LocalVideoActivity.this.hvG);
                                                LocalVideoActivity.this.bHN();
                                                LocalVideoActivity.this.hvI = false;
                                                LocalVideoActivity.this.hvJ = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.hvD.bHS();
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
    private Handler hvO = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.hvO.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.hvK != null && LocalVideoActivity.this.hvK.isShowing()) {
                        LocalVideoActivity.this.hvK.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.hvO.sendMessageDelayed(LocalVideoActivity.this.hvO.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.hvJ) {
                        l.showToast(LocalVideoActivity.this, e.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.hvI = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.hvG) && (file = new File(LocalVideoActivity.this.hvG)) != null) {
                        LocalVideoActivity.this.hvG = LocalVideoActivity.this.hvG.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.hvG));
                    }
                    LocalVideoActivity.this.bHO();
                    if (!LocalVideoActivity.this.hvH && LocalVideoActivity.this.hvD.bHY() != null) {
                        d wj = e.wj(LocalVideoActivity.this.hvG);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.hvG);
                        videoInfo.setVideoDuration(((int) wj.getDuration()) / 1000);
                        videoInfo.setVideoWidth(wj.getVideoWidth());
                        videoInfo.setVideoHeight(wj.getVideoHeight());
                        videoInfo.setVideoLength(new File(wj.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.hss, videoInfo)));
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
            LocalVideoActivity.this.hvI = false;
            LocalVideoActivity.this.bHO();
        }
    };
    private com.baidu.tieba.video.d hvP = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void bGi() {
        }

        @Override // com.baidu.tieba.video.d
        public void vv(int i) {
            LocalVideoActivity.this.hvO.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.hvO.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.hvO.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.hvO.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.hvO.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener hvQ = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
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
        if (this.hvF == null) {
            this.hvF = new VideoConvertUtil(this);
            this.hvF.a(this.hvP);
        }
        return this.hvF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHN() {
        this.hvD.aBJ();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.container);
        if (relativeLayout != null) {
            if (this.hvK == null) {
                this.hvK = new LocalVideoCompressingDialogView(this);
            }
            if (this.hvK.getParent() == null) {
                relativeLayout.addView(this.hvK);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hvK.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.hvK.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hvK.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHO() {
        this.hvD.bHV();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.container);
        if (relativeLayout != null && this.hvK.getParent() != null) {
            relativeLayout.removeView(this.hvK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHP() {
        bHM().abortConvert();
        this.hvJ = true;
        if (this.hvG != null) {
            File file = new File(this.hvG);
            if (file.exists()) {
                file.delete();
            }
        }
        bHO();
        this.hvG = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bGm() {
        return VideoConvertUtil.bGm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nI(boolean z) {
        d wj = e.wj(this.hvG);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hvG);
        videoInfo.setVideoDuration(((int) wj.getDuration()) / 1000);
        videoInfo.setVideoWidth(wj.getVideoWidth());
        videoInfo.setVideoHeight(wj.getVideoHeight());
        videoInfo.setVideoLength(new File(wj.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.hss, videoInfo)));
        this.hvI = false;
        this.hvG = null;
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
            this.hss = getIntent().getStringExtra("video_title");
        }
        this.hvD = new c(this, this.mOnClickListener);
        this.hvE = new LocalVideoModel(this);
        this.hvE.a(this.hvN);
        this.hvE.bHQ();
        registerListener(this.hvM);
        registerListener(this.hvL);
        registerListener(this.hvQ);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.hvH = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hvH = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hvD != null) {
            this.hvD.bHW();
        }
        if (this.hvI && !TextUtils.isEmpty(this.hvG) && new File(this.hvG).exists()) {
            nI(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hvD != null) {
            this.hvD.aBK();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hvD.aBK();
        if (this.hvF != null) {
            this.hvF.destroy();
        }
        if (this.hvO != null) {
            this.hvO.removeMessages(5);
        }
    }
}
