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
    private String hFG;
    private c hIR;
    private LocalVideoModel hIS;
    private VideoConvertUtil hIT;
    private String hIU;
    private LocalVideoCompressingDialogView hIY;
    private String mForumId;
    private String mForumName;
    private boolean hIV = false;
    private boolean hIW = false;
    private boolean hIX = false;
    private CustomMessageListener hIZ = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.hIR != null) {
                    LocalVideoActivity.this.hIR.xh(str);
                }
            }
        }
    };
    private CustomMessageListener hJa = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.hIS != null) {
                LocalVideoActivity.this.hIS.bKS();
            }
        }
    };
    private b.a hJb = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void eb(List<d> list) {
            if (LocalVideoActivity.this.hIR != null) {
                LocalVideoActivity.this.hIR.ec(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.hIR != null) {
                if (view != LocalVideoActivity.this.hIR.bKV()) {
                    if (view == LocalVideoActivity.this.hIR.bKW()) {
                        if (!LocalVideoActivity.this.hIR.bKT()) {
                            if (LocalVideoActivity.this.hIR.bLa() == null || LocalVideoActivity.this.hIR.bLa().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil bKO = LocalVideoActivity.this.bKO();
                                if (!bKO.isConvertRunning()) {
                                    String bKZ = LocalVideoActivity.this.hIR.bKZ();
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
                                            d bLa = LocalVideoActivity.this.hIR.bLa();
                                            if (bLa != null) {
                                                LocalVideoActivity.this.hIR.aEc();
                                                LocalVideoActivity.this.hIU = bLa.getVideoPath();
                                                LocalVideoActivity.this.oc(false);
                                                return;
                                            }
                                            return;
                                        } else if (wR >= 1500000) {
                                            if (LocalVideoActivity.this.bJo()) {
                                                File file = new File(com.baidu.tieba.video.e.hEg, "tieba_" + e.wQ(bKZ) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hIU = file.getAbsolutePath();
                                                bKO.setConvertType(1);
                                                bKO.cS(bKZ, LocalVideoActivity.this.hIU);
                                                LocalVideoActivity.this.bKP();
                                                LocalVideoActivity.this.hIW = false;
                                                LocalVideoActivity.this.hIX = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bLa2 = LocalVideoActivity.this.hIR.bLa();
                                            if (bLa2 != null) {
                                                if (bLa2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.hIR.aEc();
                                                    LocalVideoActivity.this.hIU = bLa2.getVideoPath();
                                                    LocalVideoActivity.this.oc(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.hEg, "tieba_" + e.wQ(bKZ) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hIU = file2.getAbsolutePath();
                                                bKO.setConvertType(2);
                                                bKO.cS(bKZ, LocalVideoActivity.this.hIU);
                                                LocalVideoActivity.this.bKP();
                                                LocalVideoActivity.this.hIW = false;
                                                LocalVideoActivity.this.hIX = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.hIR.bKU();
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
    private Handler hJc = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.hJc.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.hIY != null && LocalVideoActivity.this.hIY.isShowing()) {
                        LocalVideoActivity.this.hIY.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.hJc.sendMessageDelayed(LocalVideoActivity.this.hJc.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.hIX) {
                        l.showToast(LocalVideoActivity.this, e.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.hIW = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.hIU) && (file = new File(LocalVideoActivity.this.hIU)) != null) {
                        LocalVideoActivity.this.hIU = LocalVideoActivity.this.hIU.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.hIU));
                    }
                    LocalVideoActivity.this.bKQ();
                    if (!LocalVideoActivity.this.hIV && LocalVideoActivity.this.hIR.bLa() != null) {
                        d xk = e.xk(LocalVideoActivity.this.hIU);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.hIU);
                        videoInfo.setVideoDuration(((int) xk.getDuration()) / 1000);
                        videoInfo.setVideoWidth(xk.getVideoWidth());
                        videoInfo.setVideoHeight(xk.getVideoHeight());
                        videoInfo.setVideoLength(new File(xk.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.hFG, videoInfo)));
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
            LocalVideoActivity.this.hIW = false;
            LocalVideoActivity.this.bKQ();
        }
    };
    private com.baidu.tieba.video.d hJd = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void bJk() {
        }

        @Override // com.baidu.tieba.video.d
        public void wB(int i) {
            LocalVideoActivity.this.hJc.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.hJc.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.hJc.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.hJc.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.hJc.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener hJe = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
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
        if (this.hIT == null) {
            this.hIT = new VideoConvertUtil(this);
            this.hIT.a(this.hJd);
        }
        return this.hIT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKP() {
        this.hIR.aEc();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.container);
        if (relativeLayout != null) {
            if (this.hIY == null) {
                this.hIY = new LocalVideoCompressingDialogView(this);
            }
            if (this.hIY.getParent() == null) {
                relativeLayout.addView(this.hIY);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hIY.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.hIY.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hIY.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKQ() {
        this.hIR.bKX();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.container);
        if (relativeLayout != null && this.hIY.getParent() != null) {
            relativeLayout.removeView(this.hIY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKR() {
        bKO().abortConvert();
        this.hIX = true;
        if (this.hIU != null) {
            File file = new File(this.hIU);
            if (file.exists()) {
                file.delete();
            }
        }
        bKQ();
        this.hIU = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJo() {
        return VideoConvertUtil.bJo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oc(boolean z) {
        d xk = e.xk(this.hIU);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hIU);
        videoInfo.setVideoDuration(((int) xk.getDuration()) / 1000);
        videoInfo.setVideoWidth(xk.getVideoWidth());
        videoInfo.setVideoHeight(xk.getVideoHeight());
        videoInfo.setVideoLength(new File(xk.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.hFG, videoInfo)));
        this.hIW = false;
        this.hIU = null;
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
            this.hFG = getIntent().getStringExtra("video_title");
        }
        this.hIR = new c(this, this.mOnClickListener);
        this.hIS = new LocalVideoModel(this);
        this.hIS.a(this.hJb);
        this.hIS.bKS();
        registerListener(this.hJa);
        registerListener(this.hIZ);
        registerListener(this.hJe);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.hIV = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hIV = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hIR != null) {
            this.hIR.bKY();
        }
        if (this.hIW && !TextUtils.isEmpty(this.hIU) && new File(this.hIU).exists()) {
            oc(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hIR != null) {
            this.hIR.aEd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hIR.aEd();
        if (this.hIT != null) {
            this.hIT.destroy();
        }
        if (this.hJc != null) {
            this.hJc.removeMessages(5);
        }
    }
}
