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
    private c jBO;
    private LocalVideoModel jBP;
    private VideoConvertUtil jBQ;
    private String jBR;
    private LocalVideoCompressingDialogView jBV;
    private String jyI;
    private String mForumId;
    private String mForumName;
    private boolean jBS = false;
    private boolean jBT = false;
    private boolean jBU = false;
    private CustomMessageListener jBW = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.jBO != null) {
                    LocalVideoActivity.this.jBO.Gu(str);
                }
            }
        }
    };
    private CustomMessageListener jBX = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.jBP != null) {
                LocalVideoActivity.this.jBP.cws();
            }
        }
    };
    private b.a jBY = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void eq(List<d> list) {
            if (LocalVideoActivity.this.jBO != null) {
                LocalVideoActivity.this.jBO.er(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.jBO != null) {
                if (view != LocalVideoActivity.this.jBO.cwv()) {
                    if (view == LocalVideoActivity.this.jBO.cww()) {
                        if (!LocalVideoActivity.this.jBO.cwt()) {
                            if (LocalVideoActivity.this.jBO.cwA() == null || LocalVideoActivity.this.jBO.cwA().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil cwo = LocalVideoActivity.this.cwo();
                                if (!cwo.isConvertRunning()) {
                                    String cwz = LocalVideoActivity.this.jBO.cwz();
                                    if (TextUtils.isEmpty(cwz)) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, cwz));
                                        return;
                                    } else if (!new File(cwz).exists()) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, cwz));
                                        return;
                                    } else {
                                        int Ge = e.Ge(cwz);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d cwA = LocalVideoActivity.this.jBO.cwA();
                                            if (cwA != null) {
                                                LocalVideoActivity.this.jBO.bpd();
                                                LocalVideoActivity.this.jBR = cwA.getVideoPath();
                                                LocalVideoActivity.this.rJ(false);
                                                return;
                                            }
                                            return;
                                        } else if (Ge >= 1500000) {
                                            if (LocalVideoActivity.this.cuN()) {
                                                File file = new File(com.baidu.tieba.video.e.jxh, "tieba_" + e.Gd(cwz) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.jBR = file.getAbsolutePath();
                                                cwo.setConvertType(1);
                                                cwo.es(cwz, LocalVideoActivity.this.jBR);
                                                LocalVideoActivity.this.cwp();
                                                LocalVideoActivity.this.jBT = false;
                                                LocalVideoActivity.this.jBU = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d cwA2 = LocalVideoActivity.this.jBO.cwA();
                                            if (cwA2 != null) {
                                                if (cwA2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.jBO.bpd();
                                                    LocalVideoActivity.this.jBR = cwA2.getVideoPath();
                                                    LocalVideoActivity.this.rJ(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.jxh, "tieba_" + e.Gd(cwz) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.jBR = file2.getAbsolutePath();
                                                cwo.setConvertType(2);
                                                cwo.es(cwz, LocalVideoActivity.this.jBR);
                                                LocalVideoActivity.this.cwp();
                                                LocalVideoActivity.this.jBT = false;
                                                LocalVideoActivity.this.jBU = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.jBO.cwu();
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
    private Handler jBZ = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.jBZ.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.jBV != null && LocalVideoActivity.this.jBV.isShowing()) {
                        LocalVideoActivity.this.jBV.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.jBZ.sendMessageDelayed(LocalVideoActivity.this.jBZ.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.jBU) {
                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.jBT = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.jBR) && (file = new File(LocalVideoActivity.this.jBR)) != null) {
                        LocalVideoActivity.this.jBR = LocalVideoActivity.this.jBR.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.jBR));
                    }
                    LocalVideoActivity.this.cwq();
                    if (!LocalVideoActivity.this.jBS && LocalVideoActivity.this.jBO.cwA() != null) {
                        d Gy = e.Gy(LocalVideoActivity.this.jBR);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.jBR);
                        videoInfo.setVideoDuration(((int) Gy.getDuration()) / 1000);
                        videoInfo.setVideoWidth(Gy.getVideoWidth());
                        videoInfo.setVideoHeight(Gy.getVideoHeight());
                        videoInfo.setVideoLength(new File(Gy.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.jyI, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                    VideoConvertUtil cwo = LocalVideoActivity.this.cwo();
                    if (cwo != null && cwo.isConvertRunning()) {
                        LocalVideoActivity.this.cwr();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.jBT = false;
            LocalVideoActivity.this.cwq();
        }
    };
    private com.baidu.tieba.video.d jCa = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void cuJ() {
        }

        @Override // com.baidu.tieba.video.d
        public void Ce(int i) {
            LocalVideoActivity.this.jBZ.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.jBZ.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.jBZ.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.jBZ.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.jBZ.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener jCb = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil cwo() {
        if (this.jBQ == null) {
            this.jBQ = new VideoConvertUtil(this);
            this.jBQ.a(this.jCa);
        }
        return this.jBQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwp() {
        this.jBO.bpd();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.jBV == null) {
                this.jBV = new LocalVideoCompressingDialogView(this);
            }
            if (this.jBV.getParent() == null) {
                relativeLayout.addView(this.jBV);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jBV.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.jBV.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.jBV.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwq() {
        this.jBO.cwx();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.jBV.getParent() != null) {
            relativeLayout.removeView(this.jBV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwr() {
        cwo().abortConvert();
        this.jBU = true;
        if (this.jBR != null) {
            File file = new File(this.jBR);
            if (file.exists()) {
                file.delete();
            }
        }
        cwq();
        this.jBR = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cuN() {
        return VideoConvertUtil.cuN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rJ(boolean z) {
        d Gy = e.Gy(this.jBR);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jBR);
        videoInfo.setVideoDuration(((int) Gy.getDuration()) / 1000);
        videoInfo.setVideoWidth(Gy.getVideoWidth());
        videoInfo.setVideoHeight(Gy.getVideoHeight());
        videoInfo.setVideoLength(new File(Gy.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.jyI, videoInfo)));
        this.jBT = false;
        this.jBR = null;
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
            this.jyI = getIntent().getStringExtra("video_title");
        }
        this.jBO = new c(this, this.mOnClickListener);
        this.jBP = new LocalVideoModel(this);
        this.jBP.a(this.jBY);
        this.jBP.cws();
        registerListener(this.jBX);
        registerListener(this.jBW);
        registerListener(this.jCb);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.jBS = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.jBS = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jBO != null) {
            this.jBO.cwy();
        }
        if (this.jBT && !TextUtils.isEmpty(this.jBR) && new File(this.jBR).exists()) {
            rJ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jBO != null) {
            this.jBO.bpe();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jBO.bpe();
        if (this.jBQ != null) {
            this.jBQ.destroy();
        }
        if (this.jBZ != null) {
            this.jBZ.removeMessages(5);
        }
    }
}
