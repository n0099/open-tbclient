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
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.video.commonview.LocalVideoCompressingDialogView;
import com.baidu.tieba.video.localvideo.b;
import java.io.File;
import java.util.List;
/* loaded from: classes23.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String mForumId;
    private String mForumName;
    private String mUT;
    private c mYd;
    private LocalVideoModel mYe;
    private VideoConvertUtil mYf;
    private String mYg;
    private LocalVideoCompressingDialogView mYk;
    private boolean mYh = false;
    private boolean mYi = false;
    private boolean mYj = false;
    private CustomMessageListener mYl = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.mYd != null) {
                    LocalVideoActivity.this.mYd.Tg(str);
                }
            }
        }
    };
    private CustomMessageListener mYm = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.mYe != null) {
                LocalVideoActivity.this.mYe.dKh();
            }
        }
    };
    private b.a mYn = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void fB(List<d> list) {
            if (LocalVideoActivity.this.mYd != null) {
                LocalVideoActivity.this.mYd.fC(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.mYd != null) {
                if (view != LocalVideoActivity.this.mYd.dKk()) {
                    if (view == LocalVideoActivity.this.mYd.dKl()) {
                        if (!LocalVideoActivity.this.mYd.dKi()) {
                            if (LocalVideoActivity.this.mYd.dKo() == null || LocalVideoActivity.this.mYd.dKo().getDuration() <= 600000) {
                                VideoConvertUtil dKd = LocalVideoActivity.this.dKd();
                                if (!dKd.isConvertRunning()) {
                                    String dKn = LocalVideoActivity.this.mYd.dKn();
                                    if (TextUtils.isEmpty(dKn)) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dKn));
                                        return;
                                    } else if (!new File(dKn).exists()) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dKn));
                                        return;
                                    } else {
                                        int SP = e.SP(dKn);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d dKo = LocalVideoActivity.this.mYd.dKo();
                                            if (dKo != null) {
                                                LocalVideoActivity.this.mYd.pauseVideo();
                                                LocalVideoActivity.this.mYg = dKo.getVideoPath();
                                                LocalVideoActivity.this.xx(false);
                                                return;
                                            }
                                            return;
                                        } else if (SP >= 1500000) {
                                            if (LocalVideoActivity.this.dIJ()) {
                                                File file = new File(com.baidu.tieba.video.e.mTv, "tieba_" + e.SO(dKn) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.mYg = file.getAbsolutePath();
                                                dKd.setConvertType(1);
                                                dKd.gq(dKn, LocalVideoActivity.this.mYg);
                                                LocalVideoActivity.this.dKe();
                                                LocalVideoActivity.this.mYi = false;
                                                LocalVideoActivity.this.mYj = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d dKo2 = LocalVideoActivity.this.mYd.dKo();
                                            if (dKo2 != null) {
                                                if (dKo2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.mYd.pauseVideo();
                                                    LocalVideoActivity.this.mYg = dKo2.getVideoPath();
                                                    LocalVideoActivity.this.xx(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.mTv, "tieba_" + e.SO(dKn) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.mYg = file2.getAbsolutePath();
                                                dKd.setConvertType(2);
                                                dKd.gq(dKn, LocalVideoActivity.this.mYg);
                                                LocalVideoActivity.this.dKe();
                                                LocalVideoActivity.this.mYi = false;
                                                LocalVideoActivity.this.mYj = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.mYd.dKj();
                            return;
                        }
                        l.showToast(LocalVideoActivity.this, R.string.show_video_file_error);
                        return;
                    }
                    return;
                }
                LocalVideoActivity.this.finish();
            }
        }
    };
    private Handler mYo = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.mYo.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.mYk != null && LocalVideoActivity.this.mYk.isShowing()) {
                        LocalVideoActivity.this.mYk.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.mYo.sendMessageDelayed(LocalVideoActivity.this.mYo.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.mYj) {
                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.mYi = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.mYg) && (file = new File(LocalVideoActivity.this.mYg)) != null) {
                        LocalVideoActivity.this.mYg = LocalVideoActivity.this.mYg.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.mYg));
                    }
                    LocalVideoActivity.this.dKf();
                    if (!LocalVideoActivity.this.mYh && LocalVideoActivity.this.mYd.dKo() != null) {
                        d Tj = e.Tj(LocalVideoActivity.this.mYg);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.mYg);
                        videoInfo.setVideoDuration(((int) Tj.getDuration()) / 1000);
                        videoInfo.setVideoWidth(Tj.getVideoWidth());
                        videoInfo.setVideoHeight(Tj.getVideoHeight());
                        videoInfo.setVideoLength(new File(Tj.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.mUT, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                    VideoConvertUtil dKd = LocalVideoActivity.this.dKd();
                    if (dKd != null && dKd.isConvertRunning()) {
                        LocalVideoActivity.this.dKg();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.mYi = false;
            LocalVideoActivity.this.dKf();
        }
    };
    private com.baidu.tieba.video.d mYp = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void dIE() {
        }

        @Override // com.baidu.tieba.video.d
        public void JT(int i) {
            LocalVideoActivity.this.mYo.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.mYo.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.mYo.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.mYo.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.mYo.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener mYq = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil dKd() {
        if (this.mYf == null) {
            this.mYf = new VideoConvertUtil(this);
            this.mYf.a(this.mYp);
        }
        return this.mYf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dKe() {
        this.mYd.pauseVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.mYk == null) {
                this.mYk = new LocalVideoCompressingDialogView(this);
            }
            if (this.mYk.getParent() == null) {
                relativeLayout.addView(this.mYk);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mYk.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.mYk.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.mYk.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dKf() {
        this.mYd.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.mYk.getParent() != null) {
            relativeLayout.removeView(this.mYk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dKg() {
        dKd().abortConvert();
        this.mYj = true;
        if (this.mYg != null) {
            File file = new File(this.mYg);
            if (file.exists()) {
                file.delete();
            }
        }
        dKf();
        this.mYg = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dIJ() {
        return VideoConvertUtil.dIJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xx(boolean z) {
        d Tj = e.Tj(this.mYg);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.mYg);
        videoInfo.setVideoDuration(((int) Tj.getDuration()) / 1000);
        videoInfo.setVideoWidth(Tj.getVideoWidth());
        videoInfo.setVideoHeight(Tj.getVideoHeight());
        videoInfo.setVideoLength(new File(Tj.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.mUT, videoInfo)));
        this.mYi = false;
        this.mYg = null;
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
            this.mUT = getIntent().getStringExtra("video_title");
        }
        this.mYd = new c(this, this.mOnClickListener);
        this.mYe = new LocalVideoModel(this);
        this.mYe.a(this.mYn);
        this.mYe.dKh();
        registerListener(this.mYm);
        registerListener(this.mYl);
        registerListener(this.mYq);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mYh = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mYh = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mYd != null) {
            this.mYd.dKm();
        }
        if (this.mYi && !TextUtils.isEmpty(this.mYg) && new File(this.mYg).exists()) {
            xx(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.mYd != null) {
            this.mYd.cvu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mYd.cvu();
        if (this.mYf != null) {
            this.mYf.destroy();
        }
        if (this.mYo != null) {
            this.mYo.removeMessages(5);
        }
    }
}
