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
    private String jvf;
    private c jyl;
    private LocalVideoModel jym;
    private VideoConvertUtil jyn;
    private String jyo;
    private LocalVideoCompressingDialogView jys;
    private String mForumId;
    private String mForumName;
    private boolean jyp = false;
    private boolean jyq = false;
    private boolean jyr = false;
    private CustomMessageListener jyt = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.jyl != null) {
                    LocalVideoActivity.this.jyl.FT(str);
                }
            }
        }
    };
    private CustomMessageListener jyu = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.jym != null) {
                LocalVideoActivity.this.jym.cvi();
            }
        }
    };
    private b.a jyv = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void er(List<d> list) {
            if (LocalVideoActivity.this.jyl != null) {
                LocalVideoActivity.this.jyl.es(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.jyl != null) {
                if (view != LocalVideoActivity.this.jyl.cvl()) {
                    if (view == LocalVideoActivity.this.jyl.cvm()) {
                        if (!LocalVideoActivity.this.jyl.cvj()) {
                            if (LocalVideoActivity.this.jyl.cvq() == null || LocalVideoActivity.this.jyl.cvq().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil cve = LocalVideoActivity.this.cve();
                                if (!cve.isConvertRunning()) {
                                    String cvp = LocalVideoActivity.this.jyl.cvp();
                                    if (TextUtils.isEmpty(cvp)) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, cvp));
                                        return;
                                    } else if (!new File(cvp).exists()) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, cvp));
                                        return;
                                    } else {
                                        int FD = e.FD(cvp);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d cvq = LocalVideoActivity.this.jyl.cvq();
                                            if (cvq != null) {
                                                LocalVideoActivity.this.jyl.bof();
                                                LocalVideoActivity.this.jyo = cvq.getVideoPath();
                                                LocalVideoActivity.this.rF(false);
                                                return;
                                            }
                                            return;
                                        } else if (FD >= 1500000) {
                                            if (LocalVideoActivity.this.ctD()) {
                                                File file = new File(com.baidu.tieba.video.e.jtE, "tieba_" + e.FC(cvp) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.jyo = file.getAbsolutePath();
                                                cve.setConvertType(1);
                                                cve.er(cvp, LocalVideoActivity.this.jyo);
                                                LocalVideoActivity.this.cvf();
                                                LocalVideoActivity.this.jyq = false;
                                                LocalVideoActivity.this.jyr = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d cvq2 = LocalVideoActivity.this.jyl.cvq();
                                            if (cvq2 != null) {
                                                if (cvq2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.jyl.bof();
                                                    LocalVideoActivity.this.jyo = cvq2.getVideoPath();
                                                    LocalVideoActivity.this.rF(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.jtE, "tieba_" + e.FC(cvp) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.jyo = file2.getAbsolutePath();
                                                cve.setConvertType(2);
                                                cve.er(cvp, LocalVideoActivity.this.jyo);
                                                LocalVideoActivity.this.cvf();
                                                LocalVideoActivity.this.jyq = false;
                                                LocalVideoActivity.this.jyr = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.jyl.cvk();
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
    private Handler jyw = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.jyw.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.jys != null && LocalVideoActivity.this.jys.isShowing()) {
                        LocalVideoActivity.this.jys.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.jyw.sendMessageDelayed(LocalVideoActivity.this.jyw.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.jyr) {
                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.jyq = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.jyo) && (file = new File(LocalVideoActivity.this.jyo)) != null) {
                        LocalVideoActivity.this.jyo = LocalVideoActivity.this.jyo.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.jyo));
                    }
                    LocalVideoActivity.this.cvg();
                    if (!LocalVideoActivity.this.jyp && LocalVideoActivity.this.jyl.cvq() != null) {
                        d FX = e.FX(LocalVideoActivity.this.jyo);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.jyo);
                        videoInfo.setVideoDuration(((int) FX.getDuration()) / 1000);
                        videoInfo.setVideoWidth(FX.getVideoWidth());
                        videoInfo.setVideoHeight(FX.getVideoHeight());
                        videoInfo.setVideoLength(new File(FX.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.jvf, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                    VideoConvertUtil cve = LocalVideoActivity.this.cve();
                    if (cve != null && cve.isConvertRunning()) {
                        LocalVideoActivity.this.cvh();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.jyq = false;
            LocalVideoActivity.this.cvg();
        }
    };
    private com.baidu.tieba.video.d jyx = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void ctz() {
        }

        @Override // com.baidu.tieba.video.d
        public void BY(int i) {
            LocalVideoActivity.this.jyw.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.jyw.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.jyw.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.jyw.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.jyw.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener jyy = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil cve() {
        if (this.jyn == null) {
            this.jyn = new VideoConvertUtil(this);
            this.jyn.a(this.jyx);
        }
        return this.jyn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvf() {
        this.jyl.bof();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.jys == null) {
                this.jys = new LocalVideoCompressingDialogView(this);
            }
            if (this.jys.getParent() == null) {
                relativeLayout.addView(this.jys);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jys.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.jys.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.jys.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvg() {
        this.jyl.cvn();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.jys.getParent() != null) {
            relativeLayout.removeView(this.jys);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvh() {
        cve().abortConvert();
        this.jyr = true;
        if (this.jyo != null) {
            File file = new File(this.jyo);
            if (file.exists()) {
                file.delete();
            }
        }
        cvg();
        this.jyo = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ctD() {
        return VideoConvertUtil.ctD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rF(boolean z) {
        d FX = e.FX(this.jyo);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jyo);
        videoInfo.setVideoDuration(((int) FX.getDuration()) / 1000);
        videoInfo.setVideoWidth(FX.getVideoWidth());
        videoInfo.setVideoHeight(FX.getVideoHeight());
        videoInfo.setVideoLength(new File(FX.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.jvf, videoInfo)));
        this.jyq = false;
        this.jyo = null;
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
            this.jvf = getIntent().getStringExtra("video_title");
        }
        this.jyl = new c(this, this.mOnClickListener);
        this.jym = new LocalVideoModel(this);
        this.jym.a(this.jyv);
        this.jym.cvi();
        registerListener(this.jyu);
        registerListener(this.jyt);
        registerListener(this.jyy);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.jyp = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.jyp = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jyl != null) {
            this.jyl.cvo();
        }
        if (this.jyq && !TextUtils.isEmpty(this.jyo) && new File(this.jyo).exists()) {
            rF(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jyl != null) {
            this.jyl.bog();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jyl.bog();
        if (this.jyn != null) {
            this.jyn.destroy();
        }
        if (this.jyw != null) {
            this.jyw.removeMessages(5);
        }
    }
}
