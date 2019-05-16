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
    private String joT;
    private c jrZ;
    private LocalVideoModel jsa;
    private VideoConvertUtil jsb;
    private String jsc;
    private LocalVideoCompressingDialogView jsg;
    private String mForumId;
    private String mForumName;
    private boolean jsd = false;
    private boolean jse = false;
    private boolean jsf = false;
    private CustomMessageListener jsh = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.jrZ != null) {
                    LocalVideoActivity.this.jrZ.Fd(str);
                }
            }
        }
    };
    private CustomMessageListener jsi = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.jsa != null) {
                LocalVideoActivity.this.jsa.csu();
            }
        }
    };
    private b.a jsj = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void eo(List<d> list) {
            if (LocalVideoActivity.this.jrZ != null) {
                LocalVideoActivity.this.jrZ.ep(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.jrZ != null) {
                if (view != LocalVideoActivity.this.jrZ.csx()) {
                    if (view == LocalVideoActivity.this.jrZ.csy()) {
                        if (!LocalVideoActivity.this.jrZ.csv()) {
                            if (LocalVideoActivity.this.jrZ.csC() == null || LocalVideoActivity.this.jrZ.csC().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil csq = LocalVideoActivity.this.csq();
                                if (!csq.isConvertRunning()) {
                                    String csB = LocalVideoActivity.this.jrZ.csB();
                                    if (TextUtils.isEmpty(csB)) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, csB));
                                        return;
                                    } else if (!new File(csB).exists()) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, csB));
                                        return;
                                    } else {
                                        int EN = e.EN(csB);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d csC = LocalVideoActivity.this.jrZ.csC();
                                            if (csC != null) {
                                                LocalVideoActivity.this.jrZ.bmb();
                                                LocalVideoActivity.this.jsc = csC.getVideoPath();
                                                LocalVideoActivity.this.rr(false);
                                                return;
                                            }
                                            return;
                                        } else if (EN >= 1500000) {
                                            if (LocalVideoActivity.this.cqP()) {
                                                File file = new File(com.baidu.tieba.video.e.jns, "tieba_" + e.EM(csB) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.jsc = file.getAbsolutePath();
                                                csq.setConvertType(1);
                                                csq.eq(csB, LocalVideoActivity.this.jsc);
                                                LocalVideoActivity.this.csr();
                                                LocalVideoActivity.this.jse = false;
                                                LocalVideoActivity.this.jsf = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d csC2 = LocalVideoActivity.this.jrZ.csC();
                                            if (csC2 != null) {
                                                if (csC2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.jrZ.bmb();
                                                    LocalVideoActivity.this.jsc = csC2.getVideoPath();
                                                    LocalVideoActivity.this.rr(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.jns, "tieba_" + e.EM(csB) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.jsc = file2.getAbsolutePath();
                                                csq.setConvertType(2);
                                                csq.eq(csB, LocalVideoActivity.this.jsc);
                                                LocalVideoActivity.this.csr();
                                                LocalVideoActivity.this.jse = false;
                                                LocalVideoActivity.this.jsf = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.jrZ.csw();
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
    private Handler jsk = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.jsk.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.jsg != null && LocalVideoActivity.this.jsg.isShowing()) {
                        LocalVideoActivity.this.jsg.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.jsk.sendMessageDelayed(LocalVideoActivity.this.jsk.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.jsf) {
                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.jse = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.jsc) && (file = new File(LocalVideoActivity.this.jsc)) != null) {
                        LocalVideoActivity.this.jsc = LocalVideoActivity.this.jsc.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.jsc));
                    }
                    LocalVideoActivity.this.css();
                    if (!LocalVideoActivity.this.jsd && LocalVideoActivity.this.jrZ.csC() != null) {
                        d Fg = e.Fg(LocalVideoActivity.this.jsc);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.jsc);
                        videoInfo.setVideoDuration(((int) Fg.getDuration()) / 1000);
                        videoInfo.setVideoWidth(Fg.getVideoWidth());
                        videoInfo.setVideoHeight(Fg.getVideoHeight());
                        videoInfo.setVideoLength(new File(Fg.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.joT, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                    VideoConvertUtil csq = LocalVideoActivity.this.csq();
                    if (csq != null && csq.isConvertRunning()) {
                        LocalVideoActivity.this.cst();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.jse = false;
            LocalVideoActivity.this.css();
        }
    };
    private com.baidu.tieba.video.d jsl = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void cqL() {
        }

        @Override // com.baidu.tieba.video.d
        public void Br(int i) {
            LocalVideoActivity.this.jsk.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.jsk.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.jsk.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.jsk.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.jsk.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener jsm = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil csq() {
        if (this.jsb == null) {
            this.jsb = new VideoConvertUtil(this);
            this.jsb.a(this.jsl);
        }
        return this.jsb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csr() {
        this.jrZ.bmb();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.jsg == null) {
                this.jsg = new LocalVideoCompressingDialogView(this);
            }
            if (this.jsg.getParent() == null) {
                relativeLayout.addView(this.jsg);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jsg.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.jsg.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.jsg.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void css() {
        this.jrZ.csz();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.jsg.getParent() != null) {
            relativeLayout.removeView(this.jsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cst() {
        csq().abortConvert();
        this.jsf = true;
        if (this.jsc != null) {
            File file = new File(this.jsc);
            if (file.exists()) {
                file.delete();
            }
        }
        css();
        this.jsc = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqP() {
        return VideoConvertUtil.cqP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rr(boolean z) {
        d Fg = e.Fg(this.jsc);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jsc);
        videoInfo.setVideoDuration(((int) Fg.getDuration()) / 1000);
        videoInfo.setVideoWidth(Fg.getVideoWidth());
        videoInfo.setVideoHeight(Fg.getVideoHeight());
        videoInfo.setVideoLength(new File(Fg.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.joT, videoInfo)));
        this.jse = false;
        this.jsc = null;
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
            this.joT = getIntent().getStringExtra("video_title");
        }
        this.jrZ = new c(this, this.mOnClickListener);
        this.jsa = new LocalVideoModel(this);
        this.jsa.a(this.jsj);
        this.jsa.csu();
        registerListener(this.jsi);
        registerListener(this.jsh);
        registerListener(this.jsm);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.jsd = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.jsd = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jrZ != null) {
            this.jrZ.csA();
        }
        if (this.jse && !TextUtils.isEmpty(this.jsc) && new File(this.jsc).exists()) {
            rr(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jrZ != null) {
            this.jrZ.bmc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jrZ.bmc();
        if (this.jsb != null) {
            this.jsb.destroy();
        }
        if (this.jsk != null) {
            this.jsk.removeMessages(5);
        }
    }
}
