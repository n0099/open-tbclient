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
    private String iWh;
    private c iZp;
    private LocalVideoModel iZq;
    private VideoConvertUtil iZr;
    private String iZs;
    private LocalVideoCompressingDialogView iZw;
    private String mForumId;
    private String mForumName;
    private boolean iZt = false;
    private boolean iZu = false;
    private boolean iZv = false;
    private CustomMessageListener iZx = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.iZp != null) {
                    LocalVideoActivity.this.iZp.DI(str);
                }
            }
        }
    };
    private CustomMessageListener iZy = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.iZq != null) {
                LocalVideoActivity.this.iZq.ckt();
            }
        }
    };
    private b.a iZz = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void eh(List<d> list) {
            if (LocalVideoActivity.this.iZp != null) {
                LocalVideoActivity.this.iZp.ei(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.iZp != null) {
                if (view != LocalVideoActivity.this.iZp.ckw()) {
                    if (view == LocalVideoActivity.this.iZp.ckx()) {
                        if (!LocalVideoActivity.this.iZp.cku()) {
                            if (LocalVideoActivity.this.iZp.ckB() == null || LocalVideoActivity.this.iZp.ckB().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil ckp = LocalVideoActivity.this.ckp();
                                if (!ckp.isConvertRunning()) {
                                    String ckA = LocalVideoActivity.this.iZp.ckA();
                                    if (TextUtils.isEmpty(ckA)) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, ckA));
                                        return;
                                    } else if (!new File(ckA).exists()) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, ckA));
                                        return;
                                    } else {
                                        int Ds = e.Ds(ckA);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d ckB = LocalVideoActivity.this.iZp.ckB();
                                            if (ckB != null) {
                                                LocalVideoActivity.this.iZp.beL();
                                                LocalVideoActivity.this.iZs = ckB.getVideoPath();
                                                LocalVideoActivity.this.qC(false);
                                                return;
                                            }
                                            return;
                                        } else if (Ds >= 1500000) {
                                            if (LocalVideoActivity.this.ciO()) {
                                                File file = new File(com.baidu.tieba.video.e.iUG, "tieba_" + e.Dr(ckA) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.iZs = file.getAbsolutePath();
                                                ckp.setConvertType(1);
                                                ckp.eb(ckA, LocalVideoActivity.this.iZs);
                                                LocalVideoActivity.this.ckq();
                                                LocalVideoActivity.this.iZu = false;
                                                LocalVideoActivity.this.iZv = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d ckB2 = LocalVideoActivity.this.iZp.ckB();
                                            if (ckB2 != null) {
                                                if (ckB2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.iZp.beL();
                                                    LocalVideoActivity.this.iZs = ckB2.getVideoPath();
                                                    LocalVideoActivity.this.qC(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.iUG, "tieba_" + e.Dr(ckA) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.iZs = file2.getAbsolutePath();
                                                ckp.setConvertType(2);
                                                ckp.eb(ckA, LocalVideoActivity.this.iZs);
                                                LocalVideoActivity.this.ckq();
                                                LocalVideoActivity.this.iZu = false;
                                                LocalVideoActivity.this.iZv = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.iZp.ckv();
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
    private Handler iZA = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.iZA.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.iZw != null && LocalVideoActivity.this.iZw.isShowing()) {
                        LocalVideoActivity.this.iZw.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.iZA.sendMessageDelayed(LocalVideoActivity.this.iZA.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.iZv) {
                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.iZu = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.iZs) && (file = new File(LocalVideoActivity.this.iZs)) != null) {
                        LocalVideoActivity.this.iZs = LocalVideoActivity.this.iZs.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.iZs));
                    }
                    LocalVideoActivity.this.ckr();
                    if (!LocalVideoActivity.this.iZt && LocalVideoActivity.this.iZp.ckB() != null) {
                        d DL = e.DL(LocalVideoActivity.this.iZs);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.iZs);
                        videoInfo.setVideoDuration(((int) DL.getDuration()) / 1000);
                        videoInfo.setVideoWidth(DL.getVideoWidth());
                        videoInfo.setVideoHeight(DL.getVideoHeight());
                        videoInfo.setVideoLength(new File(DL.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.iWh, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                    VideoConvertUtil ckp = LocalVideoActivity.this.ckp();
                    if (ckp != null && ckp.isConvertRunning()) {
                        LocalVideoActivity.this.cks();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.iZu = false;
            LocalVideoActivity.this.ckr();
        }
    };
    private com.baidu.tieba.video.d iZB = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void ciK() {
        }

        @Override // com.baidu.tieba.video.d
        public void An(int i) {
            LocalVideoActivity.this.iZA.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.iZA.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.iZA.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.iZA.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.iZA.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener iZC = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil ckp() {
        if (this.iZr == null) {
            this.iZr = new VideoConvertUtil(this);
            this.iZr.a(this.iZB);
        }
        return this.iZr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckq() {
        this.iZp.beL();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null) {
            if (this.iZw == null) {
                this.iZw = new LocalVideoCompressingDialogView(this);
            }
            if (this.iZw.getParent() == null) {
                relativeLayout.addView(this.iZw);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iZw.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.iZw.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.iZw.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckr() {
        this.iZp.cky();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null && this.iZw.getParent() != null) {
            relativeLayout.removeView(this.iZw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cks() {
        ckp().abortConvert();
        this.iZv = true;
        if (this.iZs != null) {
            File file = new File(this.iZs);
            if (file.exists()) {
                file.delete();
            }
        }
        ckr();
        this.iZs = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ciO() {
        return VideoConvertUtil.ciO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qC(boolean z) {
        d DL = e.DL(this.iZs);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.iZs);
        videoInfo.setVideoDuration(((int) DL.getDuration()) / 1000);
        videoInfo.setVideoWidth(DL.getVideoWidth());
        videoInfo.setVideoHeight(DL.getVideoHeight());
        videoInfo.setVideoLength(new File(DL.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.iWh, videoInfo)));
        this.iZu = false;
        this.iZs = null;
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
            this.iWh = getIntent().getStringExtra("video_title");
        }
        this.iZp = new c(this, this.mOnClickListener);
        this.iZq = new LocalVideoModel(this);
        this.iZq.a(this.iZz);
        this.iZq.ckt();
        registerListener(this.iZy);
        registerListener(this.iZx);
        registerListener(this.iZC);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.iZt = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.iZt = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iZp != null) {
            this.iZp.ckz();
        }
        if (this.iZu && !TextUtils.isEmpty(this.iZs) && new File(this.iZs).exists()) {
            qC(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.iZp != null) {
            this.iZp.beM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.iZp.beM();
        if (this.iZr != null) {
            this.iZr.destroy();
        }
        if (this.iZA != null) {
            this.iZA.removeMessages(5);
        }
    }
}
