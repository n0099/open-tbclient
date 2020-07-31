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
/* loaded from: classes17.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String mForumId;
    private String mForumName;
    private String mdp;
    private c mgC;
    private LocalVideoModel mgD;
    private VideoConvertUtil mgE;
    private String mgF;
    private LocalVideoCompressingDialogView mgJ;
    private boolean mgG = false;
    private boolean mgH = false;
    private boolean mgI = false;
    private CustomMessageListener mgK = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.mgC != null) {
                    LocalVideoActivity.this.mgC.OU(str);
                }
            }
        }
    };
    private CustomMessageListener mgL = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.mgD != null) {
                LocalVideoActivity.this.mgD.dqW();
            }
        }
    };
    private b.a mgM = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void fh(List<d> list) {
            if (LocalVideoActivity.this.mgC != null) {
                LocalVideoActivity.this.mgC.fi(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.mgC != null) {
                if (view != LocalVideoActivity.this.mgC.dqZ()) {
                    if (view == LocalVideoActivity.this.mgC.dra()) {
                        if (!LocalVideoActivity.this.mgC.dqX()) {
                            if (LocalVideoActivity.this.mgC.drd() == null || LocalVideoActivity.this.mgC.drd().getDuration() <= 600000) {
                                VideoConvertUtil dqS = LocalVideoActivity.this.dqS();
                                if (!dqS.isConvertRunning()) {
                                    String drc = LocalVideoActivity.this.mgC.drc();
                                    if (TextUtils.isEmpty(drc)) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, drc));
                                        return;
                                    } else if (!new File(drc).exists()) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, drc));
                                        return;
                                    } else {
                                        int OD = e.OD(drc);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d drd = LocalVideoActivity.this.mgC.drd();
                                            if (drd != null) {
                                                LocalVideoActivity.this.mgC.cee();
                                                LocalVideoActivity.this.mgF = drd.getVideoPath();
                                                LocalVideoActivity.this.vQ(false);
                                                return;
                                            }
                                            return;
                                        } else if (OD >= 1500000) {
                                            if (LocalVideoActivity.this.dpy()) {
                                                File file = new File(com.baidu.tieba.video.e.mbS, "tieba_" + e.OC(drc) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.mgF = file.getAbsolutePath();
                                                dqS.setConvertType(1);
                                                dqS.fF(drc, LocalVideoActivity.this.mgF);
                                                LocalVideoActivity.this.dqT();
                                                LocalVideoActivity.this.mgH = false;
                                                LocalVideoActivity.this.mgI = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d drd2 = LocalVideoActivity.this.mgC.drd();
                                            if (drd2 != null) {
                                                if (drd2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.mgC.cee();
                                                    LocalVideoActivity.this.mgF = drd2.getVideoPath();
                                                    LocalVideoActivity.this.vQ(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.mbS, "tieba_" + e.OC(drc) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.mgF = file2.getAbsolutePath();
                                                dqS.setConvertType(2);
                                                dqS.fF(drc, LocalVideoActivity.this.mgF);
                                                LocalVideoActivity.this.dqT();
                                                LocalVideoActivity.this.mgH = false;
                                                LocalVideoActivity.this.mgI = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.mgC.dqY();
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
    private Handler mgN = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.mgN.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.mgJ != null && LocalVideoActivity.this.mgJ.isShowing()) {
                        LocalVideoActivity.this.mgJ.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.mgN.sendMessageDelayed(LocalVideoActivity.this.mgN.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.mgI) {
                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.mgH = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.mgF) && (file = new File(LocalVideoActivity.this.mgF)) != null) {
                        LocalVideoActivity.this.mgF = LocalVideoActivity.this.mgF.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.mgF));
                    }
                    LocalVideoActivity.this.dqU();
                    if (!LocalVideoActivity.this.mgG && LocalVideoActivity.this.mgC.drd() != null) {
                        d OX = e.OX(LocalVideoActivity.this.mgF);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.mgF);
                        videoInfo.setVideoDuration(((int) OX.getDuration()) / 1000);
                        videoInfo.setVideoWidth(OX.getVideoWidth());
                        videoInfo.setVideoHeight(OX.getVideoHeight());
                        videoInfo.setVideoLength(new File(OX.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.mdp, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                    VideoConvertUtil dqS = LocalVideoActivity.this.dqS();
                    if (dqS != null && dqS.isConvertRunning()) {
                        LocalVideoActivity.this.dqV();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.mgH = false;
            LocalVideoActivity.this.dqU();
        }
    };
    private com.baidu.tieba.video.d mgO = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void dpt() {
        }

        @Override // com.baidu.tieba.video.d
        public void Gn(int i) {
            LocalVideoActivity.this.mgN.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.mgN.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.mgN.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.mgN.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.mgN.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener mgP = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil dqS() {
        if (this.mgE == null) {
            this.mgE = new VideoConvertUtil(this);
            this.mgE.a(this.mgO);
        }
        return this.mgE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqT() {
        this.mgC.cee();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.mgJ == null) {
                this.mgJ = new LocalVideoCompressingDialogView(this);
            }
            if (this.mgJ.getParent() == null) {
                relativeLayout.addView(this.mgJ);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mgJ.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.mgJ.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.mgJ.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqU() {
        this.mgC.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.mgJ.getParent() != null) {
            relativeLayout.removeView(this.mgJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqV() {
        dqS().abortConvert();
        this.mgI = true;
        if (this.mgF != null) {
            File file = new File(this.mgF);
            if (file.exists()) {
                file.delete();
            }
        }
        dqU();
        this.mgF = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dpy() {
        return VideoConvertUtil.dpy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vQ(boolean z) {
        d OX = e.OX(this.mgF);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.mgF);
        videoInfo.setVideoDuration(((int) OX.getDuration()) / 1000);
        videoInfo.setVideoWidth(OX.getVideoWidth());
        videoInfo.setVideoHeight(OX.getVideoHeight());
        videoInfo.setVideoLength(new File(OX.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.mdp, videoInfo)));
        this.mgH = false;
        this.mgF = null;
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
            this.mdp = getIntent().getStringExtra("video_title");
        }
        this.mgC = new c(this, this.mOnClickListener);
        this.mgD = new LocalVideoModel(this);
        this.mgD.a(this.mgM);
        this.mgD.dqW();
        registerListener(this.mgL);
        registerListener(this.mgK);
        registerListener(this.mgP);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mgG = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mgG = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mgC != null) {
            this.mgC.drb();
        }
        if (this.mgH && !TextUtils.isEmpty(this.mgF) && new File(this.mgF).exists()) {
            vQ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.mgC != null) {
            this.mgC.cef();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mgC.cef();
        if (this.mgE != null) {
            this.mgE.destroy();
        }
        if (this.mgN != null) {
            this.mgN.removeMessages(5);
        }
    }
}
