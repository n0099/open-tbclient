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
/* loaded from: classes10.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String lis;
    private String llA;
    private LocalVideoCompressingDialogView llE;
    private c llx;
    private LocalVideoModel lly;
    private VideoConvertUtil llz;
    private String mForumId;
    private String mForumName;
    private boolean llB = false;
    private boolean llC = false;
    private boolean llD = false;
    private CustomMessageListener llF = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.llx != null) {
                    LocalVideoActivity.this.llx.LS(str);
                }
            }
        }
    };
    private CustomMessageListener llG = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.lly != null) {
                LocalVideoActivity.this.lly.dbW();
            }
        }
    };
    private b.a llH = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void eF(List<d> list) {
            if (LocalVideoActivity.this.llx != null) {
                LocalVideoActivity.this.llx.eG(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.llx != null) {
                if (view != LocalVideoActivity.this.llx.dbZ()) {
                    if (view == LocalVideoActivity.this.llx.dca()) {
                        if (!LocalVideoActivity.this.llx.dbX()) {
                            if (LocalVideoActivity.this.llx.dcd() == null || LocalVideoActivity.this.llx.dcd().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil dbS = LocalVideoActivity.this.dbS();
                                if (!dbS.isConvertRunning()) {
                                    String dcc = LocalVideoActivity.this.llx.dcc();
                                    if (TextUtils.isEmpty(dcc)) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dcc));
                                        return;
                                    } else if (!new File(dcc).exists()) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dcc));
                                        return;
                                    } else {
                                        int LC = e.LC(dcc);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d dcd = LocalVideoActivity.this.llx.dcd();
                                            if (dcd != null) {
                                                LocalVideoActivity.this.llx.bQX();
                                                LocalVideoActivity.this.llA = dcd.getVideoPath();
                                                LocalVideoActivity.this.uw(false);
                                                return;
                                            }
                                            return;
                                        } else if (LC >= 1500000) {
                                            if (LocalVideoActivity.this.dax()) {
                                                File file = new File(com.baidu.tieba.video.e.lgV, "tieba_" + e.LB(dcc) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.llA = file.getAbsolutePath();
                                                dbS.setConvertType(1);
                                                dbS.eV(dcc, LocalVideoActivity.this.llA);
                                                LocalVideoActivity.this.dbT();
                                                LocalVideoActivity.this.llC = false;
                                                LocalVideoActivity.this.llD = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d dcd2 = LocalVideoActivity.this.llx.dcd();
                                            if (dcd2 != null) {
                                                if (dcd2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.llx.bQX();
                                                    LocalVideoActivity.this.llA = dcd2.getVideoPath();
                                                    LocalVideoActivity.this.uw(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.lgV, "tieba_" + e.LB(dcc) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.llA = file2.getAbsolutePath();
                                                dbS.setConvertType(2);
                                                dbS.eV(dcc, LocalVideoActivity.this.llA);
                                                LocalVideoActivity.this.dbT();
                                                LocalVideoActivity.this.llC = false;
                                                LocalVideoActivity.this.llD = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.llx.dbY();
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
    private Handler llI = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.llI.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.llE != null && LocalVideoActivity.this.llE.isShowing()) {
                        LocalVideoActivity.this.llE.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.llI.sendMessageDelayed(LocalVideoActivity.this.llI.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.llD) {
                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.llC = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.llA) && (file = new File(LocalVideoActivity.this.llA)) != null) {
                        LocalVideoActivity.this.llA = LocalVideoActivity.this.llA.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.llA));
                    }
                    LocalVideoActivity.this.dbU();
                    if (!LocalVideoActivity.this.llB && LocalVideoActivity.this.llx.dcd() != null) {
                        d LV = e.LV(LocalVideoActivity.this.llA);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.llA);
                        videoInfo.setVideoDuration(((int) LV.getDuration()) / 1000);
                        videoInfo.setVideoWidth(LV.getVideoWidth());
                        videoInfo.setVideoHeight(LV.getVideoHeight());
                        videoInfo.setVideoLength(new File(LV.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.lis, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                    VideoConvertUtil dbS = LocalVideoActivity.this.dbS();
                    if (dbS != null && dbS.isConvertRunning()) {
                        LocalVideoActivity.this.dbV();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.llC = false;
            LocalVideoActivity.this.dbU();
        }
    };
    private com.baidu.tieba.video.d llJ = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void dat() {
        }

        @Override // com.baidu.tieba.video.d
        public void Ec(int i) {
            LocalVideoActivity.this.llI.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.llI.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.llI.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.llI.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.llI.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener llK = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil dbS() {
        if (this.llz == null) {
            this.llz = new VideoConvertUtil(this);
            this.llz.a(this.llJ);
        }
        return this.llz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbT() {
        this.llx.bQX();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.llE == null) {
                this.llE = new LocalVideoCompressingDialogView(this);
            }
            if (this.llE.getParent() == null) {
                relativeLayout.addView(this.llE);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.llE.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.llE.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.llE.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbU() {
        this.llx.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.llE.getParent() != null) {
            relativeLayout.removeView(this.llE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbV() {
        dbS().abortConvert();
        this.llD = true;
        if (this.llA != null) {
            File file = new File(this.llA);
            if (file.exists()) {
                file.delete();
            }
        }
        dbU();
        this.llA = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dax() {
        return VideoConvertUtil.dax();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uw(boolean z) {
        d LV = e.LV(this.llA);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.llA);
        videoInfo.setVideoDuration(((int) LV.getDuration()) / 1000);
        videoInfo.setVideoWidth(LV.getVideoWidth());
        videoInfo.setVideoHeight(LV.getVideoHeight());
        videoInfo.setVideoLength(new File(LV.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.lis, videoInfo)));
        this.llC = false;
        this.llA = null;
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
            this.lis = getIntent().getStringExtra("video_title");
        }
        this.llx = new c(this, this.mOnClickListener);
        this.lly = new LocalVideoModel(this);
        this.lly.a(this.llH);
        this.lly.dbW();
        registerListener(this.llG);
        registerListener(this.llF);
        registerListener(this.llK);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.llB = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.llB = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.llx != null) {
            this.llx.dcb();
        }
        if (this.llC && !TextUtils.isEmpty(this.llA) && new File(this.llA).exists()) {
            uw(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.llx != null) {
            this.llx.bQY();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.llx.bQY();
        if (this.llz != null) {
            this.llz.destroy();
        }
        if (this.llI != null) {
            this.llI.removeMessages(5);
        }
    }
}
