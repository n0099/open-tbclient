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
    private String nCz;
    private c nFI;
    private LocalVideoModel nFJ;
    private VideoConvertUtil nFK;
    private String nFL;
    private LocalVideoCompressingDialogView nFP;
    private boolean nFM = false;
    private boolean nFN = false;
    private boolean nFO = false;
    private CustomMessageListener nFQ = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.nFI != null) {
                    LocalVideoActivity.this.nFI.UW(str);
                }
            }
        }
    };
    private CustomMessageListener nFR = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.nFJ != null) {
                LocalVideoActivity.this.nFJ.dVk();
            }
        }
    };
    private b.a nFS = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void gg(List<d> list) {
            if (LocalVideoActivity.this.nFI != null) {
                LocalVideoActivity.this.nFI.gh(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.nFI != null) {
                if (view != LocalVideoActivity.this.nFI.dVn()) {
                    if (view == LocalVideoActivity.this.nFI.dVo()) {
                        if (!LocalVideoActivity.this.nFI.dVl()) {
                            if (LocalVideoActivity.this.nFI.dVr() == null || LocalVideoActivity.this.nFI.dVr().getDuration() <= 600000) {
                                VideoConvertUtil dVg = LocalVideoActivity.this.dVg();
                                if (!dVg.isConvertRunning()) {
                                    String dVq = LocalVideoActivity.this.nFI.dVq();
                                    if (TextUtils.isEmpty(dVq)) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dVq));
                                        return;
                                    } else if (!new File(dVq).exists()) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dVq));
                                        return;
                                    } else {
                                        int UF = e.UF(dVq);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d dVr = LocalVideoActivity.this.nFI.dVr();
                                            if (dVr != null) {
                                                LocalVideoActivity.this.nFI.pauseVideo();
                                                LocalVideoActivity.this.nFL = dVr.getVideoPath();
                                                LocalVideoActivity.this.yJ(false);
                                                return;
                                            }
                                            return;
                                        } else if (UF >= 1500000) {
                                            if (LocalVideoActivity.this.dTK()) {
                                                File file = new File(com.baidu.tieba.video.e.nBc, "tieba_" + e.UE(dVq) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.nFL = file.getAbsolutePath();
                                                dVg.setConvertType(1);
                                                dVg.gA(dVq, LocalVideoActivity.this.nFL);
                                                LocalVideoActivity.this.dVh();
                                                LocalVideoActivity.this.nFN = false;
                                                LocalVideoActivity.this.nFO = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d dVr2 = LocalVideoActivity.this.nFI.dVr();
                                            if (dVr2 != null) {
                                                if (dVr2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.nFI.pauseVideo();
                                                    LocalVideoActivity.this.nFL = dVr2.getVideoPath();
                                                    LocalVideoActivity.this.yJ(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.nBc, "tieba_" + e.UE(dVq) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.nFL = file2.getAbsolutePath();
                                                dVg.setConvertType(2);
                                                dVg.gA(dVq, LocalVideoActivity.this.nFL);
                                                LocalVideoActivity.this.dVh();
                                                LocalVideoActivity.this.nFN = false;
                                                LocalVideoActivity.this.nFO = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.nFI.dVm();
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
    private Handler nFT = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.nFT.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.nFP != null && LocalVideoActivity.this.nFP.isShowing()) {
                        LocalVideoActivity.this.nFP.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.nFT.sendMessageDelayed(LocalVideoActivity.this.nFT.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.nFO) {
                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.nFN = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.nFL) && (file = new File(LocalVideoActivity.this.nFL)) != null) {
                        LocalVideoActivity.this.nFL = LocalVideoActivity.this.nFL.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.nFL));
                    }
                    LocalVideoActivity.this.dVi();
                    if (!LocalVideoActivity.this.nFM && LocalVideoActivity.this.nFI.dVr() != null) {
                        d UZ = e.UZ(LocalVideoActivity.this.nFL);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.nFL);
                        videoInfo.setVideoDuration(((int) UZ.getDuration()) / 1000);
                        videoInfo.setVideoWidth(UZ.getVideoWidth());
                        videoInfo.setVideoHeight(UZ.getVideoHeight());
                        videoInfo.setVideoLength(new File(UZ.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.nCz, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                    VideoConvertUtil dVg = LocalVideoActivity.this.dVg();
                    if (dVg != null && dVg.isConvertRunning()) {
                        LocalVideoActivity.this.dVj();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.nFN = false;
            LocalVideoActivity.this.dVi();
        }
    };
    private com.baidu.tieba.video.d nFU = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void dTF() {
        }

        @Override // com.baidu.tieba.video.d
        public void LT(int i) {
            LocalVideoActivity.this.nFT.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.nFT.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.nFT.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.nFT.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.nFT.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener nFV = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil dVg() {
        if (this.nFK == null) {
            this.nFK = new VideoConvertUtil(this);
            this.nFK.a(this.nFU);
        }
        return this.nFK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVh() {
        this.nFI.pauseVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.nFP == null) {
                this.nFP = new LocalVideoCompressingDialogView(this);
            }
            if (this.nFP.getParent() == null) {
                relativeLayout.addView(this.nFP);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nFP.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.nFP.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.nFP.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVi() {
        this.nFI.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.nFP.getParent() != null) {
            relativeLayout.removeView(this.nFP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVj() {
        dVg().abortConvert();
        this.nFO = true;
        if (this.nFL != null) {
            File file = new File(this.nFL);
            if (file.exists()) {
                file.delete();
            }
        }
        dVi();
        this.nFL = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dTK() {
        return VideoConvertUtil.dTK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yJ(boolean z) {
        d UZ = e.UZ(this.nFL);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nFL);
        videoInfo.setVideoDuration(((int) UZ.getDuration()) / 1000);
        videoInfo.setVideoWidth(UZ.getVideoWidth());
        videoInfo.setVideoHeight(UZ.getVideoHeight());
        videoInfo.setVideoLength(new File(UZ.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.nCz, videoInfo)));
        this.nFN = false;
        this.nFL = null;
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
            this.nCz = getIntent().getStringExtra("video_title");
        }
        this.nFI = new c(this, this.mOnClickListener);
        this.nFJ = new LocalVideoModel(this);
        this.nFJ.a(this.nFS);
        this.nFJ.dVk();
        registerListener(this.nFR);
        registerListener(this.nFQ);
        registerListener(this.nFV);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.nFM = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.nFM = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nFI != null) {
            this.nFI.dVp();
        }
        if (this.nFN && !TextUtils.isEmpty(this.nFL) && new File(this.nFL).exists()) {
            yJ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.nFI != null) {
            this.nFI.cEV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.nFI.cEV();
        if (this.nFK != null) {
            this.nFK.destroy();
        }
        if (this.nFT != null) {
            this.nFT.removeMessages(5);
        }
    }
}
