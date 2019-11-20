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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private c jAP;
    private LocalVideoModel jAQ;
    private VideoConvertUtil jAR;
    private String jAS;
    private LocalVideoCompressingDialogView jAW;
    private String jxJ;
    private String mForumId;
    private String mForumName;
    private boolean jAT = false;
    private boolean jAU = false;
    private boolean jAV = false;
    private CustomMessageListener jAX = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.jAP != null) {
                    LocalVideoActivity.this.jAP.EW(str);
                }
            }
        }
    };
    private CustomMessageListener jAY = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.jAQ != null) {
                LocalVideoActivity.this.jAQ.cue();
            }
        }
    };
    private b.a jAZ = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void eD(List<d> list) {
            if (LocalVideoActivity.this.jAP != null) {
                LocalVideoActivity.this.jAP.eE(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.jAP != null) {
                if (view != LocalVideoActivity.this.jAP.cuh()) {
                    if (view == LocalVideoActivity.this.jAP.cui()) {
                        if (!LocalVideoActivity.this.jAP.cuf()) {
                            if (LocalVideoActivity.this.jAP.cum() == null || LocalVideoActivity.this.jAP.cum().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil cua = LocalVideoActivity.this.cua();
                                if (!cua.isConvertRunning()) {
                                    String cul = LocalVideoActivity.this.jAP.cul();
                                    if (TextUtils.isEmpty(cul)) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, cul));
                                        return;
                                    } else if (!new File(cul).exists()) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, cul));
                                        return;
                                    } else {
                                        int EG = e.EG(cul);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d cum = LocalVideoActivity.this.jAP.cum();
                                            if (cum != null) {
                                                LocalVideoActivity.this.jAP.bmg();
                                                LocalVideoActivity.this.jAS = cum.getVideoPath();
                                                LocalVideoActivity.this.rs(false);
                                                return;
                                            }
                                            return;
                                        } else if (EG >= 1500000) {
                                            if (LocalVideoActivity.this.csA()) {
                                                File file = new File(com.baidu.tieba.video.e.jwi, "tieba_" + e.EF(cul) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.jAS = file.getAbsolutePath();
                                                cua.setConvertType(1);
                                                cua.ee(cul, LocalVideoActivity.this.jAS);
                                                LocalVideoActivity.this.cub();
                                                LocalVideoActivity.this.jAU = false;
                                                LocalVideoActivity.this.jAV = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d cum2 = LocalVideoActivity.this.jAP.cum();
                                            if (cum2 != null) {
                                                if (cum2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.jAP.bmg();
                                                    LocalVideoActivity.this.jAS = cum2.getVideoPath();
                                                    LocalVideoActivity.this.rs(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.jwi, "tieba_" + e.EF(cul) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.jAS = file2.getAbsolutePath();
                                                cua.setConvertType(2);
                                                cua.ee(cul, LocalVideoActivity.this.jAS);
                                                LocalVideoActivity.this.cub();
                                                LocalVideoActivity.this.jAU = false;
                                                LocalVideoActivity.this.jAV = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.jAP.cug();
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
    private Handler jBa = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.jBa.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.jAW != null && LocalVideoActivity.this.jAW.isShowing()) {
                        LocalVideoActivity.this.jAW.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.jBa.sendMessageDelayed(LocalVideoActivity.this.jBa.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.jAV) {
                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.jAU = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.jAS) && (file = new File(LocalVideoActivity.this.jAS)) != null) {
                        LocalVideoActivity.this.jAS = LocalVideoActivity.this.jAS.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.jAS));
                    }
                    LocalVideoActivity.this.cuc();
                    if (!LocalVideoActivity.this.jAT && LocalVideoActivity.this.jAP.cum() != null) {
                        d Fa = e.Fa(LocalVideoActivity.this.jAS);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.jAS);
                        videoInfo.setVideoDuration(((int) Fa.getDuration()) / 1000);
                        videoInfo.setVideoWidth(Fa.getVideoWidth());
                        videoInfo.setVideoHeight(Fa.getVideoHeight());
                        videoInfo.setVideoLength(new File(Fa.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.jxJ, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                    VideoConvertUtil cua = LocalVideoActivity.this.cua();
                    if (cua != null && cua.isConvertRunning()) {
                        LocalVideoActivity.this.cud();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.jAU = false;
            LocalVideoActivity.this.cuc();
        }
    };
    private com.baidu.tieba.video.d jBb = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void csw() {
        }

        @Override // com.baidu.tieba.video.d
        public void AJ(int i) {
            LocalVideoActivity.this.jBa.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.jBa.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.jBa.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.jBa.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.jBa.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener jBc = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil cua() {
        if (this.jAR == null) {
            this.jAR = new VideoConvertUtil(this);
            this.jAR.a(this.jBb);
        }
        return this.jAR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cub() {
        this.jAP.bmg();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.jAW == null) {
                this.jAW = new LocalVideoCompressingDialogView(this);
            }
            if (this.jAW.getParent() == null) {
                relativeLayout.addView(this.jAW);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jAW.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.jAW.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.jAW.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuc() {
        this.jAP.cuj();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.jAW.getParent() != null) {
            relativeLayout.removeView(this.jAW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cud() {
        cua().abortConvert();
        this.jAV = true;
        if (this.jAS != null) {
            File file = new File(this.jAS);
            if (file.exists()) {
                file.delete();
            }
        }
        cuc();
        this.jAS = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean csA() {
        return VideoConvertUtil.csA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rs(boolean z) {
        d Fa = e.Fa(this.jAS);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jAS);
        videoInfo.setVideoDuration(((int) Fa.getDuration()) / 1000);
        videoInfo.setVideoWidth(Fa.getVideoWidth());
        videoInfo.setVideoHeight(Fa.getVideoHeight());
        videoInfo.setVideoLength(new File(Fa.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.jxJ, videoInfo)));
        this.jAU = false;
        this.jAS = null;
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
            this.jxJ = getIntent().getStringExtra("video_title");
        }
        this.jAP = new c(this, this.mOnClickListener);
        this.jAQ = new LocalVideoModel(this);
        this.jAQ.a(this.jAZ);
        this.jAQ.cue();
        registerListener(this.jAY);
        registerListener(this.jAX);
        registerListener(this.jBc);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.jAT = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.jAT = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jAP != null) {
            this.jAP.cuk();
        }
        if (this.jAU && !TextUtils.isEmpty(this.jAS) && new File(this.jAS).exists()) {
            rs(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jAP != null) {
            this.jAP.bmh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jAP.bmh();
        if (this.jAR != null) {
            this.jAR.destroy();
        }
        if (this.jBa != null) {
            this.jBa.removeMessages(5);
        }
    }
}
