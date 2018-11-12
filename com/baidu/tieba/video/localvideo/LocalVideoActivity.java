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
    private String hub;
    private c hxm;
    private LocalVideoModel hxn;
    private VideoConvertUtil hxo;
    private String hxp;
    private LocalVideoCompressingDialogView hxt;
    private String mForumId;
    private String mForumName;
    private boolean hxq = false;
    private boolean hxr = false;
    private boolean hxs = false;
    private CustomMessageListener hxu = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.hxm != null) {
                    LocalVideoActivity.this.hxm.wl(str);
                }
            }
        }
    };
    private CustomMessageListener hxv = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.hxn != null) {
                LocalVideoActivity.this.hxn.bHp();
            }
        }
    };
    private b.a hxw = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dV(List<d> list) {
            if (LocalVideoActivity.this.hxm != null) {
                LocalVideoActivity.this.hxm.dW(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.hxm != null) {
                if (view != LocalVideoActivity.this.hxm.bHs()) {
                    if (view == LocalVideoActivity.this.hxm.bHt()) {
                        if (!LocalVideoActivity.this.hxm.bHq()) {
                            if (LocalVideoActivity.this.hxm.bHx() == null || LocalVideoActivity.this.hxm.bHx().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil bHl = LocalVideoActivity.this.bHl();
                                if (!bHl.isConvertRunning()) {
                                    String bHw = LocalVideoActivity.this.hxm.bHw();
                                    if (TextUtils.isEmpty(bHw)) {
                                        l.showToast(LocalVideoActivity.this, e.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bHw));
                                        return;
                                    } else if (!new File(bHw).exists()) {
                                        l.showToast(LocalVideoActivity.this, e.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bHw));
                                        return;
                                    } else {
                                        int vV = e.vV(bHw);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bHx = LocalVideoActivity.this.hxm.bHx();
                                            if (bHx != null) {
                                                LocalVideoActivity.this.hxm.aBg();
                                                LocalVideoActivity.this.hxp = bHx.getVideoPath();
                                                LocalVideoActivity.this.nW(false);
                                                return;
                                            }
                                            return;
                                        } else if (vV >= 1500000) {
                                            if (LocalVideoActivity.this.bFL()) {
                                                File file = new File(com.baidu.tieba.video.e.hsB, "tieba_" + e.vU(bHw) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hxp = file.getAbsolutePath();
                                                bHl.setConvertType(1);
                                                bHl.cL(bHw, LocalVideoActivity.this.hxp);
                                                LocalVideoActivity.this.bHm();
                                                LocalVideoActivity.this.hxr = false;
                                                LocalVideoActivity.this.hxs = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bHx2 = LocalVideoActivity.this.hxm.bHx();
                                            if (bHx2 != null) {
                                                if (bHx2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.hxm.aBg();
                                                    LocalVideoActivity.this.hxp = bHx2.getVideoPath();
                                                    LocalVideoActivity.this.nW(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.hsB, "tieba_" + e.vU(bHw) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hxp = file2.getAbsolutePath();
                                                bHl.setConvertType(2);
                                                bHl.cL(bHw, LocalVideoActivity.this.hxp);
                                                LocalVideoActivity.this.bHm();
                                                LocalVideoActivity.this.hxr = false;
                                                LocalVideoActivity.this.hxs = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.hxm.bHr();
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
    private Handler hxx = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.hxx.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.hxt != null && LocalVideoActivity.this.hxt.isShowing()) {
                        LocalVideoActivity.this.hxt.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.hxx.sendMessageDelayed(LocalVideoActivity.this.hxx.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.hxs) {
                        l.showToast(LocalVideoActivity.this, e.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.hxr = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.hxp) && (file = new File(LocalVideoActivity.this.hxp)) != null) {
                        LocalVideoActivity.this.hxp = LocalVideoActivity.this.hxp.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.hxp));
                    }
                    LocalVideoActivity.this.bHn();
                    if (!LocalVideoActivity.this.hxq && LocalVideoActivity.this.hxm.bHx() != null) {
                        d wo = e.wo(LocalVideoActivity.this.hxp);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.hxp);
                        videoInfo.setVideoDuration(((int) wo.getDuration()) / 1000);
                        videoInfo.setVideoWidth(wo.getVideoWidth());
                        videoInfo.setVideoHeight(wo.getVideoHeight());
                        videoInfo.setVideoLength(new File(wo.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.hub, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, e.j.mv_local_video_compress_failed);
                    VideoConvertUtil bHl = LocalVideoActivity.this.bHl();
                    if (bHl != null && bHl.isConvertRunning()) {
                        LocalVideoActivity.this.bHo();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.hxr = false;
            LocalVideoActivity.this.bHn();
        }
    };
    private com.baidu.tieba.video.d hxy = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void bFH() {
        }

        @Override // com.baidu.tieba.video.d
        public void vO(int i) {
            LocalVideoActivity.this.hxx.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.hxx.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.hxx.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.hxx.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.hxx.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener hxz = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil bHl() {
        if (this.hxo == null) {
            this.hxo = new VideoConvertUtil(this);
            this.hxo.a(this.hxy);
        }
        return this.hxo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHm() {
        this.hxm.aBg();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.container);
        if (relativeLayout != null) {
            if (this.hxt == null) {
                this.hxt = new LocalVideoCompressingDialogView(this);
            }
            if (this.hxt.getParent() == null) {
                relativeLayout.addView(this.hxt);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hxt.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.hxt.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hxt.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHn() {
        this.hxm.bHu();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.container);
        if (relativeLayout != null && this.hxt.getParent() != null) {
            relativeLayout.removeView(this.hxt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHo() {
        bHl().abortConvert();
        this.hxs = true;
        if (this.hxp != null) {
            File file = new File(this.hxp);
            if (file.exists()) {
                file.delete();
            }
        }
        bHn();
        this.hxp = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bFL() {
        return VideoConvertUtil.bFL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nW(boolean z) {
        d wo = e.wo(this.hxp);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hxp);
        videoInfo.setVideoDuration(((int) wo.getDuration()) / 1000);
        videoInfo.setVideoWidth(wo.getVideoWidth());
        videoInfo.setVideoHeight(wo.getVideoHeight());
        videoInfo.setVideoLength(new File(wo.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.hub, videoInfo)));
        this.hxr = false;
        this.hxp = null;
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
            this.hub = getIntent().getStringExtra("video_title");
        }
        this.hxm = new c(this, this.mOnClickListener);
        this.hxn = new LocalVideoModel(this);
        this.hxn.a(this.hxw);
        this.hxn.bHp();
        registerListener(this.hxv);
        registerListener(this.hxu);
        registerListener(this.hxz);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.hxq = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hxq = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hxm != null) {
            this.hxm.bHv();
        }
        if (this.hxr && !TextUtils.isEmpty(this.hxp) && new File(this.hxp).exists()) {
            nW(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hxm != null) {
            this.hxm.aBh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hxm.aBh();
        if (this.hxo != null) {
            this.hxo.destroy();
        }
        if (this.hxx != null) {
            this.hxx.removeMessages(5);
        }
    }
}
