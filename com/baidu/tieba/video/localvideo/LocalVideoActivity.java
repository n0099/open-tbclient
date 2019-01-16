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
    private String hFF;
    private c hIQ;
    private LocalVideoModel hIR;
    private VideoConvertUtil hIS;
    private String hIT;
    private LocalVideoCompressingDialogView hIX;
    private String mForumId;
    private String mForumName;
    private boolean hIU = false;
    private boolean hIV = false;
    private boolean hIW = false;
    private CustomMessageListener hIY = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.hIQ != null) {
                    LocalVideoActivity.this.hIQ.xh(str);
                }
            }
        }
    };
    private CustomMessageListener hIZ = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.hIR != null) {
                LocalVideoActivity.this.hIR.bKS();
            }
        }
    };
    private b.a hJa = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void eb(List<d> list) {
            if (LocalVideoActivity.this.hIQ != null) {
                LocalVideoActivity.this.hIQ.ec(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.hIQ != null) {
                if (view != LocalVideoActivity.this.hIQ.bKV()) {
                    if (view == LocalVideoActivity.this.hIQ.bKW()) {
                        if (!LocalVideoActivity.this.hIQ.bKT()) {
                            if (LocalVideoActivity.this.hIQ.bLa() == null || LocalVideoActivity.this.hIQ.bLa().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil bKO = LocalVideoActivity.this.bKO();
                                if (!bKO.isConvertRunning()) {
                                    String bKZ = LocalVideoActivity.this.hIQ.bKZ();
                                    if (TextUtils.isEmpty(bKZ)) {
                                        l.showToast(LocalVideoActivity.this, e.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bKZ));
                                        return;
                                    } else if (!new File(bKZ).exists()) {
                                        l.showToast(LocalVideoActivity.this, e.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bKZ));
                                        return;
                                    } else {
                                        int wR = e.wR(bKZ);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bLa = LocalVideoActivity.this.hIQ.bLa();
                                            if (bLa != null) {
                                                LocalVideoActivity.this.hIQ.aEc();
                                                LocalVideoActivity.this.hIT = bLa.getVideoPath();
                                                LocalVideoActivity.this.oc(false);
                                                return;
                                            }
                                            return;
                                        } else if (wR >= 1500000) {
                                            if (LocalVideoActivity.this.bJo()) {
                                                File file = new File(com.baidu.tieba.video.e.hEf, "tieba_" + e.wQ(bKZ) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hIT = file.getAbsolutePath();
                                                bKO.setConvertType(1);
                                                bKO.cS(bKZ, LocalVideoActivity.this.hIT);
                                                LocalVideoActivity.this.bKP();
                                                LocalVideoActivity.this.hIV = false;
                                                LocalVideoActivity.this.hIW = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bLa2 = LocalVideoActivity.this.hIQ.bLa();
                                            if (bLa2 != null) {
                                                if (bLa2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.hIQ.aEc();
                                                    LocalVideoActivity.this.hIT = bLa2.getVideoPath();
                                                    LocalVideoActivity.this.oc(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.hEf, "tieba_" + e.wQ(bKZ) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hIT = file2.getAbsolutePath();
                                                bKO.setConvertType(2);
                                                bKO.cS(bKZ, LocalVideoActivity.this.hIT);
                                                LocalVideoActivity.this.bKP();
                                                LocalVideoActivity.this.hIV = false;
                                                LocalVideoActivity.this.hIW = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.hIQ.bKU();
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
    private Handler hJb = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.hJb.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.hIX != null && LocalVideoActivity.this.hIX.isShowing()) {
                        LocalVideoActivity.this.hIX.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.hJb.sendMessageDelayed(LocalVideoActivity.this.hJb.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.hIW) {
                        l.showToast(LocalVideoActivity.this, e.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.hIV = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.hIT) && (file = new File(LocalVideoActivity.this.hIT)) != null) {
                        LocalVideoActivity.this.hIT = LocalVideoActivity.this.hIT.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.hIT));
                    }
                    LocalVideoActivity.this.bKQ();
                    if (!LocalVideoActivity.this.hIU && LocalVideoActivity.this.hIQ.bLa() != null) {
                        d xk = e.xk(LocalVideoActivity.this.hIT);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.hIT);
                        videoInfo.setVideoDuration(((int) xk.getDuration()) / 1000);
                        videoInfo.setVideoWidth(xk.getVideoWidth());
                        videoInfo.setVideoHeight(xk.getVideoHeight());
                        videoInfo.setVideoLength(new File(xk.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.hFF, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, e.j.mv_local_video_compress_failed);
                    VideoConvertUtil bKO = LocalVideoActivity.this.bKO();
                    if (bKO != null && bKO.isConvertRunning()) {
                        LocalVideoActivity.this.bKR();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.hIV = false;
            LocalVideoActivity.this.bKQ();
        }
    };
    private com.baidu.tieba.video.d hJc = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void bJk() {
        }

        @Override // com.baidu.tieba.video.d
        public void wB(int i) {
            LocalVideoActivity.this.hJb.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.hJb.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.hJb.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.hJb.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.hJb.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener hJd = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil bKO() {
        if (this.hIS == null) {
            this.hIS = new VideoConvertUtil(this);
            this.hIS.a(this.hJc);
        }
        return this.hIS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKP() {
        this.hIQ.aEc();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.container);
        if (relativeLayout != null) {
            if (this.hIX == null) {
                this.hIX = new LocalVideoCompressingDialogView(this);
            }
            if (this.hIX.getParent() == null) {
                relativeLayout.addView(this.hIX);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hIX.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.hIX.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hIX.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKQ() {
        this.hIQ.bKX();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.container);
        if (relativeLayout != null && this.hIX.getParent() != null) {
            relativeLayout.removeView(this.hIX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKR() {
        bKO().abortConvert();
        this.hIW = true;
        if (this.hIT != null) {
            File file = new File(this.hIT);
            if (file.exists()) {
                file.delete();
            }
        }
        bKQ();
        this.hIT = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJo() {
        return VideoConvertUtil.bJo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oc(boolean z) {
        d xk = e.xk(this.hIT);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hIT);
        videoInfo.setVideoDuration(((int) xk.getDuration()) / 1000);
        videoInfo.setVideoWidth(xk.getVideoWidth());
        videoInfo.setVideoHeight(xk.getVideoHeight());
        videoInfo.setVideoLength(new File(xk.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.hFF, videoInfo)));
        this.hIV = false;
        this.hIT = null;
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
            this.hFF = getIntent().getStringExtra("video_title");
        }
        this.hIQ = new c(this, this.mOnClickListener);
        this.hIR = new LocalVideoModel(this);
        this.hIR.a(this.hJa);
        this.hIR.bKS();
        registerListener(this.hIZ);
        registerListener(this.hIY);
        registerListener(this.hJd);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.hIU = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hIU = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hIQ != null) {
            this.hIQ.bKY();
        }
        if (this.hIV && !TextUtils.isEmpty(this.hIT) && new File(this.hIT).exists()) {
            oc(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hIQ != null) {
            this.hIQ.aEd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hIQ.aEd();
        if (this.hIS != null) {
            this.hIS.destroy();
        }
        if (this.hJb != null) {
            this.hJb.removeMessages(5);
        }
    }
}
