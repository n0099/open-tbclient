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
    private String iVV;
    private c iZd;
    private LocalVideoModel iZe;
    private VideoConvertUtil iZf;
    private String iZg;
    private LocalVideoCompressingDialogView iZk;
    private String mForumId;
    private String mForumName;
    private boolean iZh = false;
    private boolean iZi = false;
    private boolean iZj = false;
    private CustomMessageListener iZl = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.iZd != null) {
                    LocalVideoActivity.this.iZd.DH(str);
                }
            }
        }
    };
    private CustomMessageListener iZm = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.iZe != null) {
                LocalVideoActivity.this.iZe.ckr();
            }
        }
    };
    private b.a iZn = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void ee(List<d> list) {
            if (LocalVideoActivity.this.iZd != null) {
                LocalVideoActivity.this.iZd.ef(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.iZd != null) {
                if (view != LocalVideoActivity.this.iZd.cku()) {
                    if (view == LocalVideoActivity.this.iZd.ckv()) {
                        if (!LocalVideoActivity.this.iZd.cks()) {
                            if (LocalVideoActivity.this.iZd.ckz() == null || LocalVideoActivity.this.iZd.ckz().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil ckn = LocalVideoActivity.this.ckn();
                                if (!ckn.isConvertRunning()) {
                                    String cky = LocalVideoActivity.this.iZd.cky();
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
                                            d ckz = LocalVideoActivity.this.iZd.ckz();
                                            if (ckz != null) {
                                                LocalVideoActivity.this.iZd.beJ();
                                                LocalVideoActivity.this.iZg = ckz.getVideoPath();
                                                LocalVideoActivity.this.qC(false);
                                                return;
                                            }
                                            return;
                                        } else if (Dr >= 1500000) {
                                            if (LocalVideoActivity.this.ciM()) {
                                                File file = new File(com.baidu.tieba.video.e.iUu, "tieba_" + e.Dq(cky) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.iZg = file.getAbsolutePath();
                                                ckn.setConvertType(1);
                                                ckn.ec(cky, LocalVideoActivity.this.iZg);
                                                LocalVideoActivity.this.cko();
                                                LocalVideoActivity.this.iZi = false;
                                                LocalVideoActivity.this.iZj = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d ckz2 = LocalVideoActivity.this.iZd.ckz();
                                            if (ckz2 != null) {
                                                if (ckz2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.iZd.beJ();
                                                    LocalVideoActivity.this.iZg = ckz2.getVideoPath();
                                                    LocalVideoActivity.this.qC(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.iUu, "tieba_" + e.Dq(cky) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.iZg = file2.getAbsolutePath();
                                                ckn.setConvertType(2);
                                                ckn.ec(cky, LocalVideoActivity.this.iZg);
                                                LocalVideoActivity.this.cko();
                                                LocalVideoActivity.this.iZi = false;
                                                LocalVideoActivity.this.iZj = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.iZd.ckt();
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
    private Handler iZo = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.iZo.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.iZk != null && LocalVideoActivity.this.iZk.isShowing()) {
                        LocalVideoActivity.this.iZk.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.iZo.sendMessageDelayed(LocalVideoActivity.this.iZo.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.iZj) {
                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.iZi = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.iZg) && (file = new File(LocalVideoActivity.this.iZg)) != null) {
                        LocalVideoActivity.this.iZg = LocalVideoActivity.this.iZg.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.iZg));
                    }
                    LocalVideoActivity.this.ckp();
                    if (!LocalVideoActivity.this.iZh && LocalVideoActivity.this.iZd.ckz() != null) {
                        d DK = e.DK(LocalVideoActivity.this.iZg);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.iZg);
                        videoInfo.setVideoDuration(((int) DK.getDuration()) / 1000);
                        videoInfo.setVideoWidth(DK.getVideoWidth());
                        videoInfo.setVideoHeight(DK.getVideoHeight());
                        videoInfo.setVideoLength(new File(DK.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.iVV, videoInfo)));
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
            LocalVideoActivity.this.iZi = false;
            LocalVideoActivity.this.ckp();
        }
    };
    private com.baidu.tieba.video.d iZp = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void ciI() {
        }

        @Override // com.baidu.tieba.video.d
        public void Aj(int i) {
            LocalVideoActivity.this.iZo.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.iZo.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.iZo.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.iZo.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.iZo.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener iZq = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
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
        if (this.iZf == null) {
            this.iZf = new VideoConvertUtil(this);
            this.iZf.a(this.iZp);
        }
        return this.iZf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cko() {
        this.iZd.beJ();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null) {
            if (this.iZk == null) {
                this.iZk = new LocalVideoCompressingDialogView(this);
            }
            if (this.iZk.getParent() == null) {
                relativeLayout.addView(this.iZk);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iZk.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.iZk.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.iZk.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckp() {
        this.iZd.ckw();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null && this.iZk.getParent() != null) {
            relativeLayout.removeView(this.iZk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckq() {
        ckn().abortConvert();
        this.iZj = true;
        if (this.iZg != null) {
            File file = new File(this.iZg);
            if (file.exists()) {
                file.delete();
            }
        }
        ckp();
        this.iZg = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ciM() {
        return VideoConvertUtil.ciM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qC(boolean z) {
        d DK = e.DK(this.iZg);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.iZg);
        videoInfo.setVideoDuration(((int) DK.getDuration()) / 1000);
        videoInfo.setVideoWidth(DK.getVideoWidth());
        videoInfo.setVideoHeight(DK.getVideoHeight());
        videoInfo.setVideoLength(new File(DK.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.iVV, videoInfo)));
        this.iZi = false;
        this.iZg = null;
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
            this.iVV = getIntent().getStringExtra("video_title");
        }
        this.iZd = new c(this, this.mOnClickListener);
        this.iZe = new LocalVideoModel(this);
        this.iZe.a(this.iZn);
        this.iZe.ckr();
        registerListener(this.iZm);
        registerListener(this.iZl);
        registerListener(this.iZq);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.iZh = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.iZh = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iZd != null) {
            this.iZd.ckx();
        }
        if (this.iZi && !TextUtils.isEmpty(this.iZg) && new File(this.iZg).exists()) {
            qC(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.iZd != null) {
            this.iZd.beK();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.iZd.beK();
        if (this.iZf != null) {
            this.iZf.destroy();
        }
        if (this.iZo != null) {
            this.iZo.removeMessages(5);
        }
    }
}
