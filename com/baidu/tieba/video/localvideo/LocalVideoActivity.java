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
import com.baidu.tieba.d;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.video.commonview.LocalVideoCompressingDialogView;
import com.baidu.tieba.video.localvideo.b;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String iVW;
    private c iZe;
    private LocalVideoModel iZf;
    private VideoConvertUtil iZg;
    private String iZh;
    private LocalVideoCompressingDialogView iZl;
    private String mForumId;
    private String mForumName;
    private boolean iZi = false;
    private boolean iZj = false;
    private boolean iZk = false;
    private CustomMessageListener iZm = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.iZe != null) {
                    LocalVideoActivity.this.iZe.DH(str);
                }
            }
        }
    };
    private CustomMessageListener iZn = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.iZf != null) {
                LocalVideoActivity.this.iZf.ckr();
            }
        }
    };
    private b.a iZo = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void ee(List<d> list) {
            if (LocalVideoActivity.this.iZe != null) {
                LocalVideoActivity.this.iZe.ef(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.iZe != null) {
                if (view != LocalVideoActivity.this.iZe.cku()) {
                    if (view == LocalVideoActivity.this.iZe.ckv()) {
                        if (!LocalVideoActivity.this.iZe.cks()) {
                            if (LocalVideoActivity.this.iZe.ckz() == null || LocalVideoActivity.this.iZe.ckz().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil ckn = LocalVideoActivity.this.ckn();
                                if (!ckn.isConvertRunning()) {
                                    String cky = LocalVideoActivity.this.iZe.cky();
                                    if (TextUtils.isEmpty(cky)) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, cky));
                                        return;
                                    } else if (!new File(cky).exists()) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, cky));
                                        return;
                                    } else {
                                        int Dr = e.Dr(cky);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d ckz = LocalVideoActivity.this.iZe.ckz();
                                            if (ckz != null) {
                                                LocalVideoActivity.this.iZe.beJ();
                                                LocalVideoActivity.this.iZh = ckz.getVideoPath();
                                                LocalVideoActivity.this.qC(false);
                                                return;
                                            }
                                            return;
                                        } else if (Dr >= 1500000) {
                                            if (LocalVideoActivity.this.ciM()) {
                                                File file = new File(com.baidu.tieba.video.e.iUv, "tieba_" + e.Dq(cky) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.iZh = file.getAbsolutePath();
                                                ckn.setConvertType(1);
                                                ckn.ec(cky, LocalVideoActivity.this.iZh);
                                                LocalVideoActivity.this.cko();
                                                LocalVideoActivity.this.iZj = false;
                                                LocalVideoActivity.this.iZk = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d ckz2 = LocalVideoActivity.this.iZe.ckz();
                                            if (ckz2 != null) {
                                                if (ckz2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.iZe.beJ();
                                                    LocalVideoActivity.this.iZh = ckz2.getVideoPath();
                                                    LocalVideoActivity.this.qC(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.iUv, "tieba_" + e.Dq(cky) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.iZh = file2.getAbsolutePath();
                                                ckn.setConvertType(2);
                                                ckn.ec(cky, LocalVideoActivity.this.iZh);
                                                LocalVideoActivity.this.cko();
                                                LocalVideoActivity.this.iZj = false;
                                                LocalVideoActivity.this.iZk = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.iZe.ckt();
                            return;
                        }
                        l.showToast(LocalVideoActivity.this, d.j.show_video_file_error);
                        return;
                    }
                    return;
                }
                LocalVideoActivity.this.finish();
            }
        }
    };
    private Handler iZp = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.iZp.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.iZl != null && LocalVideoActivity.this.iZl.isShowing()) {
                        LocalVideoActivity.this.iZl.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.iZp.sendMessageDelayed(LocalVideoActivity.this.iZp.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.iZk) {
                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.iZj = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.iZh) && (file = new File(LocalVideoActivity.this.iZh)) != null) {
                        LocalVideoActivity.this.iZh = LocalVideoActivity.this.iZh.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.iZh));
                    }
                    LocalVideoActivity.this.ckp();
                    if (!LocalVideoActivity.this.iZi && LocalVideoActivity.this.iZe.ckz() != null) {
                        d DK = e.DK(LocalVideoActivity.this.iZh);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.iZh);
                        videoInfo.setVideoDuration(((int) DK.getDuration()) / 1000);
                        videoInfo.setVideoWidth(DK.getVideoWidth());
                        videoInfo.setVideoHeight(DK.getVideoHeight());
                        videoInfo.setVideoLength(new File(DK.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.iVW, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                    VideoConvertUtil ckn = LocalVideoActivity.this.ckn();
                    if (ckn != null && ckn.isConvertRunning()) {
                        LocalVideoActivity.this.ckq();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.iZj = false;
            LocalVideoActivity.this.ckp();
        }
    };
    private com.baidu.tieba.video.d iZq = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void ciI() {
        }

        @Override // com.baidu.tieba.video.d
        public void Aj(int i) {
            LocalVideoActivity.this.iZp.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.iZp.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.iZp.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.iZp.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.iZp.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener iZr = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil ckn() {
        if (this.iZg == null) {
            this.iZg = new VideoConvertUtil(this);
            this.iZg.a(this.iZq);
        }
        return this.iZg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cko() {
        this.iZe.beJ();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null) {
            if (this.iZl == null) {
                this.iZl = new LocalVideoCompressingDialogView(this);
            }
            if (this.iZl.getParent() == null) {
                relativeLayout.addView(this.iZl);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iZl.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.iZl.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.iZl.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckp() {
        this.iZe.ckw();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null && this.iZl.getParent() != null) {
            relativeLayout.removeView(this.iZl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckq() {
        ckn().abortConvert();
        this.iZk = true;
        if (this.iZh != null) {
            File file = new File(this.iZh);
            if (file.exists()) {
                file.delete();
            }
        }
        ckp();
        this.iZh = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ciM() {
        return VideoConvertUtil.ciM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qC(boolean z) {
        d DK = e.DK(this.iZh);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.iZh);
        videoInfo.setVideoDuration(((int) DK.getDuration()) / 1000);
        videoInfo.setVideoWidth(DK.getVideoWidth());
        videoInfo.setVideoHeight(DK.getVideoHeight());
        videoInfo.setVideoLength(new File(DK.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.iVW, videoInfo)));
        this.iZj = false;
        this.iZh = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.local_video_activity);
        if (getIntent() != null) {
            this.mForumId = getIntent().getStringExtra("forum_id");
            this.mForumName = getIntent().getStringExtra("forum_name");
            this.iVW = getIntent().getStringExtra("video_title");
        }
        this.iZe = new c(this, this.mOnClickListener);
        this.iZf = new LocalVideoModel(this);
        this.iZf.a(this.iZo);
        this.iZf.ckr();
        registerListener(this.iZn);
        registerListener(this.iZm);
        registerListener(this.iZr);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.iZi = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.iZi = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iZe != null) {
            this.iZe.ckx();
        }
        if (this.iZj && !TextUtils.isEmpty(this.iZh) && new File(this.iZh).exists()) {
            qC(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.iZe != null) {
            this.iZe.beK();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.iZe.beK();
        if (this.iZg != null) {
            this.iZg.destroy();
        }
        if (this.iZp != null) {
            this.iZp.removeMessages(5);
        }
    }
}
