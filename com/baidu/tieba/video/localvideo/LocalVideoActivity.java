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
/* loaded from: classes22.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String mForumId;
    private String mForumName;
    private String noy;
    private c nrH;
    private LocalVideoModel nrI;
    private VideoConvertUtil nrJ;
    private String nrK;
    private LocalVideoCompressingDialogView nrO;
    private boolean nrL = false;
    private boolean nrM = false;
    private boolean nrN = false;
    private CustomMessageListener nrP = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.nrH != null) {
                    LocalVideoActivity.this.nrH.TH(str);
                }
            }
        }
    };
    private CustomMessageListener nrQ = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.nrI != null) {
                LocalVideoActivity.this.nrI.dPQ();
            }
        }
    };
    private b.a nrR = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void fS(List<d> list) {
            if (LocalVideoActivity.this.nrH != null) {
                LocalVideoActivity.this.nrH.fT(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.nrH != null) {
                if (view != LocalVideoActivity.this.nrH.dPT()) {
                    if (view == LocalVideoActivity.this.nrH.dPU()) {
                        if (!LocalVideoActivity.this.nrH.dPR()) {
                            if (LocalVideoActivity.this.nrH.dPX() == null || LocalVideoActivity.this.nrH.dPX().getDuration() <= 600000) {
                                VideoConvertUtil dPM = LocalVideoActivity.this.dPM();
                                if (!dPM.isConvertRunning()) {
                                    String dPW = LocalVideoActivity.this.nrH.dPW();
                                    if (TextUtils.isEmpty(dPW)) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dPW));
                                        return;
                                    } else if (!new File(dPW).exists()) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dPW));
                                        return;
                                    } else {
                                        int Tq = e.Tq(dPW);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d dPX = LocalVideoActivity.this.nrH.dPX();
                                            if (dPX != null) {
                                                LocalVideoActivity.this.nrH.pauseVideo();
                                                LocalVideoActivity.this.nrK = dPX.getVideoPath();
                                                LocalVideoActivity.this.ye(false);
                                                return;
                                            }
                                            return;
                                        } else if (Tq >= 1500000) {
                                            if (LocalVideoActivity.this.dOs()) {
                                                File file = new File(com.baidu.tieba.video.e.nmZ, "tieba_" + e.Tp(dPW) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.nrK = file.getAbsolutePath();
                                                dPM.setConvertType(1);
                                                dPM.gv(dPW, LocalVideoActivity.this.nrK);
                                                LocalVideoActivity.this.dPN();
                                                LocalVideoActivity.this.nrM = false;
                                                LocalVideoActivity.this.nrN = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d dPX2 = LocalVideoActivity.this.nrH.dPX();
                                            if (dPX2 != null) {
                                                if (dPX2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.nrH.pauseVideo();
                                                    LocalVideoActivity.this.nrK = dPX2.getVideoPath();
                                                    LocalVideoActivity.this.ye(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.nmZ, "tieba_" + e.Tp(dPW) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.nrK = file2.getAbsolutePath();
                                                dPM.setConvertType(2);
                                                dPM.gv(dPW, LocalVideoActivity.this.nrK);
                                                LocalVideoActivity.this.dPN();
                                                LocalVideoActivity.this.nrM = false;
                                                LocalVideoActivity.this.nrN = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.nrH.dPS();
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
    private Handler nrS = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.nrS.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.nrO != null && LocalVideoActivity.this.nrO.isShowing()) {
                        LocalVideoActivity.this.nrO.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.nrS.sendMessageDelayed(LocalVideoActivity.this.nrS.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.nrN) {
                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.nrM = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.nrK) && (file = new File(LocalVideoActivity.this.nrK)) != null) {
                        LocalVideoActivity.this.nrK = LocalVideoActivity.this.nrK.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.nrK));
                    }
                    LocalVideoActivity.this.dPO();
                    if (!LocalVideoActivity.this.nrL && LocalVideoActivity.this.nrH.dPX() != null) {
                        d TK = e.TK(LocalVideoActivity.this.nrK);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.nrK);
                        videoInfo.setVideoDuration(((int) TK.getDuration()) / 1000);
                        videoInfo.setVideoWidth(TK.getVideoWidth());
                        videoInfo.setVideoHeight(TK.getVideoHeight());
                        videoInfo.setVideoLength(new File(TK.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.noy, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                    VideoConvertUtil dPM = LocalVideoActivity.this.dPM();
                    if (dPM != null && dPM.isConvertRunning()) {
                        LocalVideoActivity.this.dPP();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.nrM = false;
            LocalVideoActivity.this.dPO();
        }
    };
    private com.baidu.tieba.video.d nrT = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void dOn() {
        }

        @Override // com.baidu.tieba.video.d
        public void Lb(int i) {
            LocalVideoActivity.this.nrS.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.nrS.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.nrS.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.nrS.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.nrS.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener nrU = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil dPM() {
        if (this.nrJ == null) {
            this.nrJ = new VideoConvertUtil(this);
            this.nrJ.a(this.nrT);
        }
        return this.nrJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPN() {
        this.nrH.pauseVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.nrO == null) {
                this.nrO = new LocalVideoCompressingDialogView(this);
            }
            if (this.nrO.getParent() == null) {
                relativeLayout.addView(this.nrO);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nrO.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.nrO.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.nrO.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPO() {
        this.nrH.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.nrO.getParent() != null) {
            relativeLayout.removeView(this.nrO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPP() {
        dPM().abortConvert();
        this.nrN = true;
        if (this.nrK != null) {
            File file = new File(this.nrK);
            if (file.exists()) {
                file.delete();
            }
        }
        dPO();
        this.nrK = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dOs() {
        return VideoConvertUtil.dOs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ye(boolean z) {
        d TK = e.TK(this.nrK);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nrK);
        videoInfo.setVideoDuration(((int) TK.getDuration()) / 1000);
        videoInfo.setVideoWidth(TK.getVideoWidth());
        videoInfo.setVideoHeight(TK.getVideoHeight());
        videoInfo.setVideoLength(new File(TK.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.noy, videoInfo)));
        this.nrM = false;
        this.nrK = null;
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
            this.noy = getIntent().getStringExtra("video_title");
        }
        this.nrH = new c(this, this.mOnClickListener);
        this.nrI = new LocalVideoModel(this);
        this.nrI.a(this.nrR);
        this.nrI.dPQ();
        registerListener(this.nrQ);
        registerListener(this.nrP);
        registerListener(this.nrU);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.nrL = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.nrL = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nrH != null) {
            this.nrH.dPV();
        }
        if (this.nrM && !TextUtils.isEmpty(this.nrK) && new File(this.nrK).exists()) {
            ye(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.nrH != null) {
            this.nrH.cAF();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.nrH.cAF();
        if (this.nrJ != null) {
            this.nrJ.destroy();
        }
        if (this.nrS != null) {
            this.nrS.removeMessages(5);
        }
    }
}
