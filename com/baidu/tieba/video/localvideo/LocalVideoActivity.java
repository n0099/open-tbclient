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
    private String nCB;
    private c nFK;
    private LocalVideoModel nFL;
    private VideoConvertUtil nFM;
    private String nFN;
    private LocalVideoCompressingDialogView nFR;
    private boolean nFO = false;
    private boolean nFP = false;
    private boolean nFQ = false;
    private CustomMessageListener nFS = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.nFK != null) {
                    LocalVideoActivity.this.nFK.UW(str);
                }
            }
        }
    };
    private CustomMessageListener nFT = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.nFL != null) {
                LocalVideoActivity.this.nFL.dVl();
            }
        }
    };
    private b.a nFU = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void gg(List<d> list) {
            if (LocalVideoActivity.this.nFK != null) {
                LocalVideoActivity.this.nFK.gh(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.nFK != null) {
                if (view != LocalVideoActivity.this.nFK.dVo()) {
                    if (view == LocalVideoActivity.this.nFK.dVp()) {
                        if (!LocalVideoActivity.this.nFK.dVm()) {
                            if (LocalVideoActivity.this.nFK.dVs() == null || LocalVideoActivity.this.nFK.dVs().getDuration() <= 600000) {
                                VideoConvertUtil dVh = LocalVideoActivity.this.dVh();
                                if (!dVh.isConvertRunning()) {
                                    String dVr = LocalVideoActivity.this.nFK.dVr();
                                    if (TextUtils.isEmpty(dVr)) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dVr));
                                        return;
                                    } else if (!new File(dVr).exists()) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dVr));
                                        return;
                                    } else {
                                        int UF = e.UF(dVr);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d dVs = LocalVideoActivity.this.nFK.dVs();
                                            if (dVs != null) {
                                                LocalVideoActivity.this.nFK.pauseVideo();
                                                LocalVideoActivity.this.nFN = dVs.getVideoPath();
                                                LocalVideoActivity.this.yJ(false);
                                                return;
                                            }
                                            return;
                                        } else if (UF >= 1500000) {
                                            if (LocalVideoActivity.this.dTL()) {
                                                File file = new File(com.baidu.tieba.video.e.nBe, "tieba_" + e.UE(dVr) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.nFN = file.getAbsolutePath();
                                                dVh.setConvertType(1);
                                                dVh.gA(dVr, LocalVideoActivity.this.nFN);
                                                LocalVideoActivity.this.dVi();
                                                LocalVideoActivity.this.nFP = false;
                                                LocalVideoActivity.this.nFQ = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d dVs2 = LocalVideoActivity.this.nFK.dVs();
                                            if (dVs2 != null) {
                                                if (dVs2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.nFK.pauseVideo();
                                                    LocalVideoActivity.this.nFN = dVs2.getVideoPath();
                                                    LocalVideoActivity.this.yJ(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.nBe, "tieba_" + e.UE(dVr) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.nFN = file2.getAbsolutePath();
                                                dVh.setConvertType(2);
                                                dVh.gA(dVr, LocalVideoActivity.this.nFN);
                                                LocalVideoActivity.this.dVi();
                                                LocalVideoActivity.this.nFP = false;
                                                LocalVideoActivity.this.nFQ = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.nFK.dVn();
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
    private Handler nFV = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.nFV.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.nFR != null && LocalVideoActivity.this.nFR.isShowing()) {
                        LocalVideoActivity.this.nFR.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.nFV.sendMessageDelayed(LocalVideoActivity.this.nFV.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.nFQ) {
                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.nFP = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.nFN) && (file = new File(LocalVideoActivity.this.nFN)) != null) {
                        LocalVideoActivity.this.nFN = LocalVideoActivity.this.nFN.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.nFN));
                    }
                    LocalVideoActivity.this.dVj();
                    if (!LocalVideoActivity.this.nFO && LocalVideoActivity.this.nFK.dVs() != null) {
                        d UZ = e.UZ(LocalVideoActivity.this.nFN);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.nFN);
                        videoInfo.setVideoDuration(((int) UZ.getDuration()) / 1000);
                        videoInfo.setVideoWidth(UZ.getVideoWidth());
                        videoInfo.setVideoHeight(UZ.getVideoHeight());
                        videoInfo.setVideoLength(new File(UZ.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.nCB, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                    VideoConvertUtil dVh = LocalVideoActivity.this.dVh();
                    if (dVh != null && dVh.isConvertRunning()) {
                        LocalVideoActivity.this.dVk();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.nFP = false;
            LocalVideoActivity.this.dVj();
        }
    };
    private com.baidu.tieba.video.d nFW = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void dTG() {
        }

        @Override // com.baidu.tieba.video.d
        public void LT(int i) {
            LocalVideoActivity.this.nFV.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.nFV.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.nFV.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.nFV.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.nFV.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener nFX = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil dVh() {
        if (this.nFM == null) {
            this.nFM = new VideoConvertUtil(this);
            this.nFM.a(this.nFW);
        }
        return this.nFM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVi() {
        this.nFK.pauseVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.nFR == null) {
                this.nFR = new LocalVideoCompressingDialogView(this);
            }
            if (this.nFR.getParent() == null) {
                relativeLayout.addView(this.nFR);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nFR.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.nFR.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.nFR.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVj() {
        this.nFK.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.nFR.getParent() != null) {
            relativeLayout.removeView(this.nFR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVk() {
        dVh().abortConvert();
        this.nFQ = true;
        if (this.nFN != null) {
            File file = new File(this.nFN);
            if (file.exists()) {
                file.delete();
            }
        }
        dVj();
        this.nFN = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dTL() {
        return VideoConvertUtil.dTL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yJ(boolean z) {
        d UZ = e.UZ(this.nFN);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nFN);
        videoInfo.setVideoDuration(((int) UZ.getDuration()) / 1000);
        videoInfo.setVideoWidth(UZ.getVideoWidth());
        videoInfo.setVideoHeight(UZ.getVideoHeight());
        videoInfo.setVideoLength(new File(UZ.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.nCB, videoInfo)));
        this.nFP = false;
        this.nFN = null;
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
            this.nCB = getIntent().getStringExtra("video_title");
        }
        this.nFK = new c(this, this.mOnClickListener);
        this.nFL = new LocalVideoModel(this);
        this.nFL.a(this.nFU);
        this.nFL.dVl();
        registerListener(this.nFT);
        registerListener(this.nFS);
        registerListener(this.nFX);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.nFO = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.nFO = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nFK != null) {
            this.nFK.dVq();
        }
        if (this.nFP && !TextUtils.isEmpty(this.nFN) && new File(this.nFN).exists()) {
            yJ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.nFK != null) {
            this.nFK.cEW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.nFK.cEW();
        if (this.nFM != null) {
            this.nFM.destroy();
        }
        if (this.nFV != null) {
            this.nFV.removeMessages(5);
        }
    }
}
