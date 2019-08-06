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
import com.baidu.tieba.R;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.video.commonview.LocalVideoCompressingDialogView;
import com.baidu.tieba.video.localvideo.b;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String jwm;
    private c jzs;
    private LocalVideoModel jzt;
    private VideoConvertUtil jzu;
    private String jzv;
    private LocalVideoCompressingDialogView jzz;
    private String mForumId;
    private String mForumName;
    private boolean jzw = false;
    private boolean jzx = false;
    private boolean jzy = false;
    private CustomMessageListener jzA = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.jzs != null) {
                    LocalVideoActivity.this.jzs.FU(str);
                }
            }
        }
    };
    private CustomMessageListener jzB = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.jzt != null) {
                LocalVideoActivity.this.jzt.cvE();
            }
        }
    };
    private b.a jzC = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void eq(List<d> list) {
            if (LocalVideoActivity.this.jzs != null) {
                LocalVideoActivity.this.jzs.er(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.jzs != null) {
                if (view != LocalVideoActivity.this.jzs.cvH()) {
                    if (view == LocalVideoActivity.this.jzs.cvI()) {
                        if (!LocalVideoActivity.this.jzs.cvF()) {
                            if (LocalVideoActivity.this.jzs.cvM() == null || LocalVideoActivity.this.jzs.cvM().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil cvA = LocalVideoActivity.this.cvA();
                                if (!cvA.isConvertRunning()) {
                                    String cvL = LocalVideoActivity.this.jzs.cvL();
                                    if (TextUtils.isEmpty(cvL)) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, cvL));
                                        return;
                                    } else if (!new File(cvL).exists()) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, cvL));
                                        return;
                                    } else {
                                        int FE = e.FE(cvL);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d cvM = LocalVideoActivity.this.jzs.cvM();
                                            if (cvM != null) {
                                                LocalVideoActivity.this.jzs.bos();
                                                LocalVideoActivity.this.jzv = cvM.getVideoPath();
                                                LocalVideoActivity.this.rG(false);
                                                return;
                                            }
                                            return;
                                        } else if (FE >= 1500000) {
                                            if (LocalVideoActivity.this.ctZ()) {
                                                File file = new File(com.baidu.tieba.video.e.juL, "tieba_" + e.FD(cvL) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.jzv = file.getAbsolutePath();
                                                cvA.setConvertType(1);
                                                cvA.er(cvL, LocalVideoActivity.this.jzv);
                                                LocalVideoActivity.this.cvB();
                                                LocalVideoActivity.this.jzx = false;
                                                LocalVideoActivity.this.jzy = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d cvM2 = LocalVideoActivity.this.jzs.cvM();
                                            if (cvM2 != null) {
                                                if (cvM2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.jzs.bos();
                                                    LocalVideoActivity.this.jzv = cvM2.getVideoPath();
                                                    LocalVideoActivity.this.rG(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.juL, "tieba_" + e.FD(cvL) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.jzv = file2.getAbsolutePath();
                                                cvA.setConvertType(2);
                                                cvA.er(cvL, LocalVideoActivity.this.jzv);
                                                LocalVideoActivity.this.cvB();
                                                LocalVideoActivity.this.jzx = false;
                                                LocalVideoActivity.this.jzy = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.jzs.cvG();
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
    private Handler jzD = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.jzD.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.jzz != null && LocalVideoActivity.this.jzz.isShowing()) {
                        LocalVideoActivity.this.jzz.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.jzD.sendMessageDelayed(LocalVideoActivity.this.jzD.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.jzy) {
                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.jzx = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.jzv) && (file = new File(LocalVideoActivity.this.jzv)) != null) {
                        LocalVideoActivity.this.jzv = LocalVideoActivity.this.jzv.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.jzv));
                    }
                    LocalVideoActivity.this.cvC();
                    if (!LocalVideoActivity.this.jzw && LocalVideoActivity.this.jzs.cvM() != null) {
                        d FY = e.FY(LocalVideoActivity.this.jzv);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.jzv);
                        videoInfo.setVideoDuration(((int) FY.getDuration()) / 1000);
                        videoInfo.setVideoWidth(FY.getVideoWidth());
                        videoInfo.setVideoHeight(FY.getVideoHeight());
                        videoInfo.setVideoLength(new File(FY.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.jwm, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                    VideoConvertUtil cvA = LocalVideoActivity.this.cvA();
                    if (cvA != null && cvA.isConvertRunning()) {
                        LocalVideoActivity.this.cvD();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.jzx = false;
            LocalVideoActivity.this.cvC();
        }
    };
    private com.baidu.tieba.video.d jzE = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void ctV() {
        }

        @Override // com.baidu.tieba.video.d
        public void Ca(int i) {
            LocalVideoActivity.this.jzD.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.jzD.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.jzD.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.jzD.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.jzD.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener jzF = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil cvA() {
        if (this.jzu == null) {
            this.jzu = new VideoConvertUtil(this);
            this.jzu.a(this.jzE);
        }
        return this.jzu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvB() {
        this.jzs.bos();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.jzz == null) {
                this.jzz = new LocalVideoCompressingDialogView(this);
            }
            if (this.jzz.getParent() == null) {
                relativeLayout.addView(this.jzz);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jzz.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.jzz.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.jzz.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvC() {
        this.jzs.cvJ();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.jzz.getParent() != null) {
            relativeLayout.removeView(this.jzz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvD() {
        cvA().abortConvert();
        this.jzy = true;
        if (this.jzv != null) {
            File file = new File(this.jzv);
            if (file.exists()) {
                file.delete();
            }
        }
        cvC();
        this.jzv = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ctZ() {
        return VideoConvertUtil.ctZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rG(boolean z) {
        d FY = e.FY(this.jzv);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jzv);
        videoInfo.setVideoDuration(((int) FY.getDuration()) / 1000);
        videoInfo.setVideoWidth(FY.getVideoWidth());
        videoInfo.setVideoHeight(FY.getVideoHeight());
        videoInfo.setVideoLength(new File(FY.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.jwm, videoInfo)));
        this.jzx = false;
        this.jzv = null;
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
            this.jwm = getIntent().getStringExtra("video_title");
        }
        this.jzs = new c(this, this.mOnClickListener);
        this.jzt = new LocalVideoModel(this);
        this.jzt.a(this.jzC);
        this.jzt.cvE();
        registerListener(this.jzB);
        registerListener(this.jzA);
        registerListener(this.jzF);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.jzw = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.jzw = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jzs != null) {
            this.jzs.cvK();
        }
        if (this.jzx && !TextUtils.isEmpty(this.jzv) && new File(this.jzv).exists()) {
            rG(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jzs != null) {
            this.jzs.bot();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jzs.bot();
        if (this.jzu != null) {
            this.jzu.destroy();
        }
        if (this.jzD != null) {
            this.jzD.removeMessages(5);
        }
    }
}
