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
    private String lCq;
    private LocalVideoCompressingDialogView lFB;
    private c lFu;
    private LocalVideoModel lFv;
    private VideoConvertUtil lFw;
    private String lFx;
    private String mForumId;
    private String mForumName;
    private boolean lFy = false;
    private boolean lFz = false;
    private boolean lFA = false;
    private CustomMessageListener lFC = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.lFu != null) {
                    LocalVideoActivity.this.lFu.NJ(str);
                }
            }
        }
    };
    private CustomMessageListener lFD = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.lFv != null) {
                LocalVideoActivity.this.lFv.djx();
            }
        }
    };
    private b.a lFE = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void eO(List<d> list) {
            if (LocalVideoActivity.this.lFu != null) {
                LocalVideoActivity.this.lFu.eP(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.lFu != null) {
                if (view != LocalVideoActivity.this.lFu.djA()) {
                    if (view == LocalVideoActivity.this.lFu.djB()) {
                        if (!LocalVideoActivity.this.lFu.djy()) {
                            if (LocalVideoActivity.this.lFu.djE() == null || LocalVideoActivity.this.lFu.djE().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil djt = LocalVideoActivity.this.djt();
                                if (!djt.isConvertRunning()) {
                                    String djD = LocalVideoActivity.this.lFu.djD();
                                    if (TextUtils.isEmpty(djD)) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, djD));
                                        return;
                                    } else if (!new File(djD).exists()) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, djD));
                                        return;
                                    } else {
                                        int Nt = e.Nt(djD);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d djE = LocalVideoActivity.this.lFu.djE();
                                            if (djE != null) {
                                                LocalVideoActivity.this.lFu.bXu();
                                                LocalVideoActivity.this.lFx = djE.getVideoPath();
                                                LocalVideoActivity.this.uU(false);
                                                return;
                                            }
                                            return;
                                        } else if (Nt >= 1500000) {
                                            if (LocalVideoActivity.this.dhY()) {
                                                File file = new File(com.baidu.tieba.video.e.lAT, "tieba_" + e.Ns(djD) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.lFx = file.getAbsolutePath();
                                                djt.setConvertType(1);
                                                djt.fw(djD, LocalVideoActivity.this.lFx);
                                                LocalVideoActivity.this.dju();
                                                LocalVideoActivity.this.lFz = false;
                                                LocalVideoActivity.this.lFA = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d djE2 = LocalVideoActivity.this.lFu.djE();
                                            if (djE2 != null) {
                                                if (djE2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.lFu.bXu();
                                                    LocalVideoActivity.this.lFx = djE2.getVideoPath();
                                                    LocalVideoActivity.this.uU(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.lAT, "tieba_" + e.Ns(djD) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.lFx = file2.getAbsolutePath();
                                                djt.setConvertType(2);
                                                djt.fw(djD, LocalVideoActivity.this.lFx);
                                                LocalVideoActivity.this.dju();
                                                LocalVideoActivity.this.lFz = false;
                                                LocalVideoActivity.this.lFA = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.lFu.djz();
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
    private Handler lFF = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.lFF.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.lFB != null && LocalVideoActivity.this.lFB.isShowing()) {
                        LocalVideoActivity.this.lFB.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.lFF.sendMessageDelayed(LocalVideoActivity.this.lFF.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.lFA) {
                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.lFz = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.lFx) && (file = new File(LocalVideoActivity.this.lFx)) != null) {
                        LocalVideoActivity.this.lFx = LocalVideoActivity.this.lFx.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.lFx));
                    }
                    LocalVideoActivity.this.djv();
                    if (!LocalVideoActivity.this.lFy && LocalVideoActivity.this.lFu.djE() != null) {
                        d NM = e.NM(LocalVideoActivity.this.lFx);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.lFx);
                        videoInfo.setVideoDuration(((int) NM.getDuration()) / 1000);
                        videoInfo.setVideoWidth(NM.getVideoWidth());
                        videoInfo.setVideoHeight(NM.getVideoHeight());
                        videoInfo.setVideoLength(new File(NM.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.lCq, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                    VideoConvertUtil djt = LocalVideoActivity.this.djt();
                    if (djt != null && djt.isConvertRunning()) {
                        LocalVideoActivity.this.djw();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.lFz = false;
            LocalVideoActivity.this.djv();
        }
    };
    private com.baidu.tieba.video.d lFG = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void dhU() {
        }

        @Override // com.baidu.tieba.video.d
        public void EP(int i) {
            LocalVideoActivity.this.lFF.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.lFF.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.lFF.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.lFF.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.lFF.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener lFH = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil djt() {
        if (this.lFw == null) {
            this.lFw = new VideoConvertUtil(this);
            this.lFw.a(this.lFG);
        }
        return this.lFw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dju() {
        this.lFu.bXu();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.lFB == null) {
                this.lFB = new LocalVideoCompressingDialogView(this);
            }
            if (this.lFB.getParent() == null) {
                relativeLayout.addView(this.lFB);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lFB.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.lFB.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.lFB.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djv() {
        this.lFu.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.lFB.getParent() != null) {
            relativeLayout.removeView(this.lFB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djw() {
        djt().abortConvert();
        this.lFA = true;
        if (this.lFx != null) {
            File file = new File(this.lFx);
            if (file.exists()) {
                file.delete();
            }
        }
        djv();
        this.lFx = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dhY() {
        return VideoConvertUtil.dhY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uU(boolean z) {
        d NM = e.NM(this.lFx);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.lFx);
        videoInfo.setVideoDuration(((int) NM.getDuration()) / 1000);
        videoInfo.setVideoWidth(NM.getVideoWidth());
        videoInfo.setVideoHeight(NM.getVideoHeight());
        videoInfo.setVideoLength(new File(NM.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.lCq, videoInfo)));
        this.lFz = false;
        this.lFx = null;
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
            this.lCq = getIntent().getStringExtra("video_title");
        }
        this.lFu = new c(this, this.mOnClickListener);
        this.lFv = new LocalVideoModel(this);
        this.lFv.a(this.lFE);
        this.lFv.djx();
        registerListener(this.lFD);
        registerListener(this.lFC);
        registerListener(this.lFH);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.lFy = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.lFy = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lFu != null) {
            this.lFu.djC();
        }
        if (this.lFz && !TextUtils.isEmpty(this.lFx) && new File(this.lFx).exists()) {
            uU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.lFu != null) {
            this.lFu.bXv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.lFu.bXv();
        if (this.lFw != null) {
            this.lFw.destroy();
        }
        if (this.lFF != null) {
            this.lFF.removeMessages(5);
        }
    }
}
