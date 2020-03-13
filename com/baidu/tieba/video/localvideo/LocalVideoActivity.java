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
    private String kwy;
    private String kzA;
    private LocalVideoCompressingDialogView kzE;
    private c kzx;
    private LocalVideoModel kzy;
    private VideoConvertUtil kzz;
    private String mForumId;
    private String mForumName;
    private boolean kzB = false;
    private boolean kzC = false;
    private boolean kzD = false;
    private CustomMessageListener kzF = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.kzx != null) {
                    LocalVideoActivity.this.kzx.Ki(str);
                }
            }
        }
    };
    private CustomMessageListener kzG = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.kzy != null) {
                LocalVideoActivity.this.kzy.cQF();
            }
        }
    };
    private b.a kzH = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void eq(List<d> list) {
            if (LocalVideoActivity.this.kzx != null) {
                LocalVideoActivity.this.kzx.er(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.kzx != null) {
                if (view != LocalVideoActivity.this.kzx.cQI()) {
                    if (view == LocalVideoActivity.this.kzx.cQJ()) {
                        if (!LocalVideoActivity.this.kzx.cQG()) {
                            if (LocalVideoActivity.this.kzx.cQM() == null || LocalVideoActivity.this.kzx.cQM().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil cQB = LocalVideoActivity.this.cQB();
                                if (!cQB.isConvertRunning()) {
                                    String cQL = LocalVideoActivity.this.kzx.cQL();
                                    if (TextUtils.isEmpty(cQL)) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, cQL));
                                        return;
                                    } else if (!new File(cQL).exists()) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, cQL));
                                        return;
                                    } else {
                                        int JT = e.JT(cQL);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d cQM = LocalVideoActivity.this.kzx.cQM();
                                            if (cQM != null) {
                                                LocalVideoActivity.this.kzx.bGk();
                                                LocalVideoActivity.this.kzA = cQM.getVideoPath();
                                                LocalVideoActivity.this.tp(false);
                                                return;
                                            }
                                            return;
                                        } else if (JT >= 1500000) {
                                            if (LocalVideoActivity.this.cPh()) {
                                                File file = new File(com.baidu.tieba.video.e.kve, "tieba_" + e.JS(cQL) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.kzA = file.getAbsolutePath();
                                                cQB.setConvertType(1);
                                                cQB.eI(cQL, LocalVideoActivity.this.kzA);
                                                LocalVideoActivity.this.cQC();
                                                LocalVideoActivity.this.kzC = false;
                                                LocalVideoActivity.this.kzD = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d cQM2 = LocalVideoActivity.this.kzx.cQM();
                                            if (cQM2 != null) {
                                                if (cQM2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.kzx.bGk();
                                                    LocalVideoActivity.this.kzA = cQM2.getVideoPath();
                                                    LocalVideoActivity.this.tp(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.kve, "tieba_" + e.JS(cQL) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.kzA = file2.getAbsolutePath();
                                                cQB.setConvertType(2);
                                                cQB.eI(cQL, LocalVideoActivity.this.kzA);
                                                LocalVideoActivity.this.cQC();
                                                LocalVideoActivity.this.kzC = false;
                                                LocalVideoActivity.this.kzD = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.kzx.cQH();
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
    private Handler kzI = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.kzI.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.kzE != null && LocalVideoActivity.this.kzE.isShowing()) {
                        LocalVideoActivity.this.kzE.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.kzI.sendMessageDelayed(LocalVideoActivity.this.kzI.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.kzD) {
                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.kzC = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.kzA) && (file = new File(LocalVideoActivity.this.kzA)) != null) {
                        LocalVideoActivity.this.kzA = LocalVideoActivity.this.kzA.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.kzA));
                    }
                    LocalVideoActivity.this.cQD();
                    if (!LocalVideoActivity.this.kzB && LocalVideoActivity.this.kzx.cQM() != null) {
                        d Kk = e.Kk(LocalVideoActivity.this.kzA);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.kzA);
                        videoInfo.setVideoDuration(((int) Kk.getDuration()) / 1000);
                        videoInfo.setVideoWidth(Kk.getVideoWidth());
                        videoInfo.setVideoHeight(Kk.getVideoHeight());
                        videoInfo.setVideoLength(new File(Kk.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.kwy, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                    VideoConvertUtil cQB = LocalVideoActivity.this.cQB();
                    if (cQB != null && cQB.isConvertRunning()) {
                        LocalVideoActivity.this.cQE();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.kzC = false;
            LocalVideoActivity.this.cQD();
        }
    };
    private com.baidu.tieba.video.d kzJ = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void cPd() {
        }

        @Override // com.baidu.tieba.video.d
        public void Dq(int i) {
            LocalVideoActivity.this.kzI.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.kzI.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.kzI.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.kzI.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.kzI.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener kzK = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil cQB() {
        if (this.kzz == null) {
            this.kzz = new VideoConvertUtil(this);
            this.kzz.a(this.kzJ);
        }
        return this.kzz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQC() {
        this.kzx.bGk();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.kzE == null) {
                this.kzE = new LocalVideoCompressingDialogView(this);
            }
            if (this.kzE.getParent() == null) {
                relativeLayout.addView(this.kzE);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kzE.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.kzE.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.kzE.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQD() {
        this.kzx.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.kzE.getParent() != null) {
            relativeLayout.removeView(this.kzE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQE() {
        cQB().abortConvert();
        this.kzD = true;
        if (this.kzA != null) {
            File file = new File(this.kzA);
            if (file.exists()) {
                file.delete();
            }
        }
        cQD();
        this.kzA = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cPh() {
        return VideoConvertUtil.cPh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tp(boolean z) {
        d Kk = e.Kk(this.kzA);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kzA);
        videoInfo.setVideoDuration(((int) Kk.getDuration()) / 1000);
        videoInfo.setVideoWidth(Kk.getVideoWidth());
        videoInfo.setVideoHeight(Kk.getVideoHeight());
        videoInfo.setVideoLength(new File(Kk.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.kwy, videoInfo)));
        this.kzC = false;
        this.kzA = null;
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
            this.kwy = getIntent().getStringExtra("video_title");
        }
        this.kzx = new c(this, this.mOnClickListener);
        this.kzy = new LocalVideoModel(this);
        this.kzy.a(this.kzH);
        this.kzy.cQF();
        registerListener(this.kzG);
        registerListener(this.kzF);
        registerListener(this.kzK);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.kzB = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.kzB = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kzx != null) {
            this.kzx.cQK();
        }
        if (this.kzC && !TextUtils.isEmpty(this.kzA) && new File(this.kzA).exists()) {
            tp(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.kzx != null) {
            this.kzx.bGl();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kzx.bGl();
        if (this.kzz != null) {
            this.kzz.destroy();
        }
        if (this.kzI != null) {
            this.kzI.removeMessages(5);
        }
    }
}
