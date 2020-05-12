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
/* loaded from: classes10.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String liw;
    private c llB;
    private LocalVideoModel llC;
    private VideoConvertUtil llD;
    private String llE;
    private LocalVideoCompressingDialogView llI;
    private String mForumId;
    private String mForumName;
    private boolean llF = false;
    private boolean llG = false;
    private boolean llH = false;
    private CustomMessageListener llJ = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.llB != null) {
                    LocalVideoActivity.this.llB.LV(str);
                }
            }
        }
    };
    private CustomMessageListener llK = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.llC != null) {
                LocalVideoActivity.this.llC.dbU();
            }
        }
    };
    private b.a llL = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void eF(List<d> list) {
            if (LocalVideoActivity.this.llB != null) {
                LocalVideoActivity.this.llB.eG(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.llB != null) {
                if (view != LocalVideoActivity.this.llB.dbX()) {
                    if (view == LocalVideoActivity.this.llB.dbY()) {
                        if (!LocalVideoActivity.this.llB.dbV()) {
                            if (LocalVideoActivity.this.llB.dcb() == null || LocalVideoActivity.this.llB.dcb().getDuration() <= 600000) {
                                VideoConvertUtil dbQ = LocalVideoActivity.this.dbQ();
                                if (!dbQ.isConvertRunning()) {
                                    String dca = LocalVideoActivity.this.llB.dca();
                                    if (TextUtils.isEmpty(dca)) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dca));
                                        return;
                                    } else if (!new File(dca).exists()) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dca));
                                        return;
                                    } else {
                                        int LF = e.LF(dca);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d dcb = LocalVideoActivity.this.llB.dcb();
                                            if (dcb != null) {
                                                LocalVideoActivity.this.llB.bQW();
                                                LocalVideoActivity.this.llE = dcb.getVideoPath();
                                                LocalVideoActivity.this.uw(false);
                                                return;
                                            }
                                            return;
                                        } else if (LF >= 1500000) {
                                            if (LocalVideoActivity.this.dav()) {
                                                File file = new File(com.baidu.tieba.video.e.lgZ, "tieba_" + e.LE(dca) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.llE = file.getAbsolutePath();
                                                dbQ.setConvertType(1);
                                                dbQ.eV(dca, LocalVideoActivity.this.llE);
                                                LocalVideoActivity.this.dbR();
                                                LocalVideoActivity.this.llG = false;
                                                LocalVideoActivity.this.llH = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d dcb2 = LocalVideoActivity.this.llB.dcb();
                                            if (dcb2 != null) {
                                                if (dcb2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.llB.bQW();
                                                    LocalVideoActivity.this.llE = dcb2.getVideoPath();
                                                    LocalVideoActivity.this.uw(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.lgZ, "tieba_" + e.LE(dca) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.llE = file2.getAbsolutePath();
                                                dbQ.setConvertType(2);
                                                dbQ.eV(dca, LocalVideoActivity.this.llE);
                                                LocalVideoActivity.this.dbR();
                                                LocalVideoActivity.this.llG = false;
                                                LocalVideoActivity.this.llH = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.llB.dbW();
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
    private Handler llM = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.llM.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.llI != null && LocalVideoActivity.this.llI.isShowing()) {
                        LocalVideoActivity.this.llI.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.llM.sendMessageDelayed(LocalVideoActivity.this.llM.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.llH) {
                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.llG = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.llE) && (file = new File(LocalVideoActivity.this.llE)) != null) {
                        LocalVideoActivity.this.llE = LocalVideoActivity.this.llE.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.llE));
                    }
                    LocalVideoActivity.this.dbS();
                    if (!LocalVideoActivity.this.llF && LocalVideoActivity.this.llB.dcb() != null) {
                        d LY = e.LY(LocalVideoActivity.this.llE);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.llE);
                        videoInfo.setVideoDuration(((int) LY.getDuration()) / 1000);
                        videoInfo.setVideoWidth(LY.getVideoWidth());
                        videoInfo.setVideoHeight(LY.getVideoHeight());
                        videoInfo.setVideoLength(new File(LY.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.liw, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                    VideoConvertUtil dbQ = LocalVideoActivity.this.dbQ();
                    if (dbQ != null && dbQ.isConvertRunning()) {
                        LocalVideoActivity.this.dbT();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.llG = false;
            LocalVideoActivity.this.dbS();
        }
    };
    private com.baidu.tieba.video.d llN = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void dar() {
        }

        @Override // com.baidu.tieba.video.d
        public void Ec(int i) {
            LocalVideoActivity.this.llM.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.llM.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.llM.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.llM.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.llM.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener llO = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil dbQ() {
        if (this.llD == null) {
            this.llD = new VideoConvertUtil(this);
            this.llD.a(this.llN);
        }
        return this.llD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbR() {
        this.llB.bQW();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.llI == null) {
                this.llI = new LocalVideoCompressingDialogView(this);
            }
            if (this.llI.getParent() == null) {
                relativeLayout.addView(this.llI);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.llI.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.llI.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.llI.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbS() {
        this.llB.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.llI.getParent() != null) {
            relativeLayout.removeView(this.llI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbT() {
        dbQ().abortConvert();
        this.llH = true;
        if (this.llE != null) {
            File file = new File(this.llE);
            if (file.exists()) {
                file.delete();
            }
        }
        dbS();
        this.llE = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dav() {
        return VideoConvertUtil.dav();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uw(boolean z) {
        d LY = e.LY(this.llE);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.llE);
        videoInfo.setVideoDuration(((int) LY.getDuration()) / 1000);
        videoInfo.setVideoWidth(LY.getVideoWidth());
        videoInfo.setVideoHeight(LY.getVideoHeight());
        videoInfo.setVideoLength(new File(LY.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.liw, videoInfo)));
        this.llG = false;
        this.llE = null;
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
            this.liw = getIntent().getStringExtra("video_title");
        }
        this.llB = new c(this, this.mOnClickListener);
        this.llC = new LocalVideoModel(this);
        this.llC.a(this.llL);
        this.llC.dbU();
        registerListener(this.llK);
        registerListener(this.llJ);
        registerListener(this.llO);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.llF = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.llF = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.llB != null) {
            this.llB.dbZ();
        }
        if (this.llG && !TextUtils.isEmpty(this.llE) && new File(this.llE).exists()) {
            uw(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.llB != null) {
            this.llB.bQX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.llB.bQX();
        if (this.llD != null) {
            this.llD.destroy();
        }
        if (this.llM != null) {
            this.llM.removeMessages(5);
        }
    }
}
