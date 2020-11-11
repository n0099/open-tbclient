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
    private String nnp;
    private c nqA;
    private LocalVideoModel nqB;
    private VideoConvertUtil nqC;
    private String nqD;
    private LocalVideoCompressingDialogView nqH;
    private boolean nqE = false;
    private boolean nqF = false;
    private boolean nqG = false;
    private CustomMessageListener nqI = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.nqA != null) {
                    LocalVideoActivity.this.nqA.TW(str);
                }
            }
        }
    };
    private CustomMessageListener nqJ = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.nqB != null) {
                LocalVideoActivity.this.nqB.dPR();
            }
        }
    };
    private b.a nqK = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void fS(List<d> list) {
            if (LocalVideoActivity.this.nqA != null) {
                LocalVideoActivity.this.nqA.fT(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.nqA != null) {
                if (view != LocalVideoActivity.this.nqA.dPU()) {
                    if (view == LocalVideoActivity.this.nqA.dPV()) {
                        if (!LocalVideoActivity.this.nqA.dPS()) {
                            if (LocalVideoActivity.this.nqA.dPY() == null || LocalVideoActivity.this.nqA.dPY().getDuration() <= 600000) {
                                VideoConvertUtil dPN = LocalVideoActivity.this.dPN();
                                if (!dPN.isConvertRunning()) {
                                    String dPX = LocalVideoActivity.this.nqA.dPX();
                                    if (TextUtils.isEmpty(dPX)) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dPX));
                                        return;
                                    } else if (!new File(dPX).exists()) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dPX));
                                        return;
                                    } else {
                                        int TF = e.TF(dPX);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d dPY = LocalVideoActivity.this.nqA.dPY();
                                            if (dPY != null) {
                                                LocalVideoActivity.this.nqA.pauseVideo();
                                                LocalVideoActivity.this.nqD = dPY.getVideoPath();
                                                LocalVideoActivity.this.xX(false);
                                                return;
                                            }
                                            return;
                                        } else if (TF >= 1500000) {
                                            if (LocalVideoActivity.this.dOt()) {
                                                File file = new File(com.baidu.tieba.video.e.nlS, "tieba_" + e.TE(dPX) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.nqD = file.getAbsolutePath();
                                                dPN.setConvertType(1);
                                                dPN.gv(dPX, LocalVideoActivity.this.nqD);
                                                LocalVideoActivity.this.dPO();
                                                LocalVideoActivity.this.nqF = false;
                                                LocalVideoActivity.this.nqG = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d dPY2 = LocalVideoActivity.this.nqA.dPY();
                                            if (dPY2 != null) {
                                                if (dPY2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.nqA.pauseVideo();
                                                    LocalVideoActivity.this.nqD = dPY2.getVideoPath();
                                                    LocalVideoActivity.this.xX(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.nlS, "tieba_" + e.TE(dPX) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.nqD = file2.getAbsolutePath();
                                                dPN.setConvertType(2);
                                                dPN.gv(dPX, LocalVideoActivity.this.nqD);
                                                LocalVideoActivity.this.dPO();
                                                LocalVideoActivity.this.nqF = false;
                                                LocalVideoActivity.this.nqG = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.nqA.dPT();
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
    private Handler nqL = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.nqL.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.nqH != null && LocalVideoActivity.this.nqH.isShowing()) {
                        LocalVideoActivity.this.nqH.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.nqL.sendMessageDelayed(LocalVideoActivity.this.nqL.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.nqG) {
                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.nqF = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.nqD) && (file = new File(LocalVideoActivity.this.nqD)) != null) {
                        LocalVideoActivity.this.nqD = LocalVideoActivity.this.nqD.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.nqD));
                    }
                    LocalVideoActivity.this.dPP();
                    if (!LocalVideoActivity.this.nqE && LocalVideoActivity.this.nqA.dPY() != null) {
                        d TZ = e.TZ(LocalVideoActivity.this.nqD);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.nqD);
                        videoInfo.setVideoDuration(((int) TZ.getDuration()) / 1000);
                        videoInfo.setVideoWidth(TZ.getVideoWidth());
                        videoInfo.setVideoHeight(TZ.getVideoHeight());
                        videoInfo.setVideoLength(new File(TZ.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.nnp, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                    VideoConvertUtil dPN = LocalVideoActivity.this.dPN();
                    if (dPN != null && dPN.isConvertRunning()) {
                        LocalVideoActivity.this.dPQ();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.nqF = false;
            LocalVideoActivity.this.dPP();
        }
    };
    private com.baidu.tieba.video.d nqM = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void dOo() {
        }

        @Override // com.baidu.tieba.video.d
        public void Ky(int i) {
            LocalVideoActivity.this.nqL.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.nqL.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.nqL.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.nqL.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.nqL.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener nqN = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil dPN() {
        if (this.nqC == null) {
            this.nqC = new VideoConvertUtil(this);
            this.nqC.a(this.nqM);
        }
        return this.nqC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPO() {
        this.nqA.pauseVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.nqH == null) {
                this.nqH = new LocalVideoCompressingDialogView(this);
            }
            if (this.nqH.getParent() == null) {
                relativeLayout.addView(this.nqH);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nqH.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.nqH.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.nqH.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPP() {
        this.nqA.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.nqH.getParent() != null) {
            relativeLayout.removeView(this.nqH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPQ() {
        dPN().abortConvert();
        this.nqG = true;
        if (this.nqD != null) {
            File file = new File(this.nqD);
            if (file.exists()) {
                file.delete();
            }
        }
        dPP();
        this.nqD = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dOt() {
        return VideoConvertUtil.dOt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xX(boolean z) {
        d TZ = e.TZ(this.nqD);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nqD);
        videoInfo.setVideoDuration(((int) TZ.getDuration()) / 1000);
        videoInfo.setVideoWidth(TZ.getVideoWidth());
        videoInfo.setVideoHeight(TZ.getVideoHeight());
        videoInfo.setVideoLength(new File(TZ.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.nnp, videoInfo)));
        this.nqF = false;
        this.nqD = null;
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
            this.nnp = getIntent().getStringExtra("video_title");
        }
        this.nqA = new c(this, this.mOnClickListener);
        this.nqB = new LocalVideoModel(this);
        this.nqB.a(this.nqK);
        this.nqB.dPR();
        registerListener(this.nqJ);
        registerListener(this.nqI);
        registerListener(this.nqN);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.nqE = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.nqE = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nqA != null) {
            this.nqA.dPW();
        }
        if (this.nqF && !TextUtils.isEmpty(this.nqD) && new File(this.nqD).exists()) {
            xX(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.nqA != null) {
            this.nqA.cBc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.nqA.cBc();
        if (this.nqC != null) {
            this.nqC.destroy();
        }
        if (this.nqL != null) {
            this.nqL.removeMessages(5);
        }
    }
}
