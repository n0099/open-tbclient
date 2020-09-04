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
    private String mvu;
    private c myG;
    private LocalVideoModel myH;
    private VideoConvertUtil myI;
    private String myJ;
    private LocalVideoCompressingDialogView myN;
    private boolean myK = false;
    private boolean myL = false;
    private boolean myM = false;
    private CustomMessageListener myO = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.myG != null) {
                    LocalVideoActivity.this.myG.RS(str);
                }
            }
        }
    };
    private CustomMessageListener myP = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.myH != null) {
                LocalVideoActivity.this.myH.dCB();
            }
        }
    };
    private b.a myQ = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void fp(List<d> list) {
            if (LocalVideoActivity.this.myG != null) {
                LocalVideoActivity.this.myG.fq(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.myG != null) {
                if (view != LocalVideoActivity.this.myG.dCE()) {
                    if (view == LocalVideoActivity.this.myG.dCF()) {
                        if (!LocalVideoActivity.this.myG.dCC()) {
                            if (LocalVideoActivity.this.myG.dCI() == null || LocalVideoActivity.this.myG.dCI().getDuration() <= 600000) {
                                VideoConvertUtil dCx = LocalVideoActivity.this.dCx();
                                if (!dCx.isConvertRunning()) {
                                    String dCH = LocalVideoActivity.this.myG.dCH();
                                    if (TextUtils.isEmpty(dCH)) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dCH));
                                        return;
                                    } else if (!new File(dCH).exists()) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dCH));
                                        return;
                                    } else {
                                        int RB = e.RB(dCH);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d dCI = LocalVideoActivity.this.myG.dCI();
                                            if (dCI != null) {
                                                LocalVideoActivity.this.myG.coJ();
                                                LocalVideoActivity.this.myJ = dCI.getVideoPath();
                                                LocalVideoActivity.this.wH(false);
                                                return;
                                            }
                                            return;
                                        } else if (RB >= 1500000) {
                                            if (LocalVideoActivity.this.dBd()) {
                                                File file = new File(com.baidu.tieba.video.e.mtX, "tieba_" + e.RA(dCH) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.myJ = file.getAbsolutePath();
                                                dCx.setConvertType(1);
                                                dCx.fX(dCH, LocalVideoActivity.this.myJ);
                                                LocalVideoActivity.this.dCy();
                                                LocalVideoActivity.this.myL = false;
                                                LocalVideoActivity.this.myM = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d dCI2 = LocalVideoActivity.this.myG.dCI();
                                            if (dCI2 != null) {
                                                if (dCI2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.myG.coJ();
                                                    LocalVideoActivity.this.myJ = dCI2.getVideoPath();
                                                    LocalVideoActivity.this.wH(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.mtX, "tieba_" + e.RA(dCH) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.myJ = file2.getAbsolutePath();
                                                dCx.setConvertType(2);
                                                dCx.fX(dCH, LocalVideoActivity.this.myJ);
                                                LocalVideoActivity.this.dCy();
                                                LocalVideoActivity.this.myL = false;
                                                LocalVideoActivity.this.myM = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.myG.dCD();
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
    private Handler myR = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.myR.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.myN != null && LocalVideoActivity.this.myN.isShowing()) {
                        LocalVideoActivity.this.myN.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.myR.sendMessageDelayed(LocalVideoActivity.this.myR.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.myM) {
                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.myL = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.myJ) && (file = new File(LocalVideoActivity.this.myJ)) != null) {
                        LocalVideoActivity.this.myJ = LocalVideoActivity.this.myJ.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.myJ));
                    }
                    LocalVideoActivity.this.dCz();
                    if (!LocalVideoActivity.this.myK && LocalVideoActivity.this.myG.dCI() != null) {
                        d RV = e.RV(LocalVideoActivity.this.myJ);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.myJ);
                        videoInfo.setVideoDuration(((int) RV.getDuration()) / 1000);
                        videoInfo.setVideoWidth(RV.getVideoWidth());
                        videoInfo.setVideoHeight(RV.getVideoHeight());
                        videoInfo.setVideoLength(new File(RV.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.mvu, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                    VideoConvertUtil dCx = LocalVideoActivity.this.dCx();
                    if (dCx != null && dCx.isConvertRunning()) {
                        LocalVideoActivity.this.dCA();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.myL = false;
            LocalVideoActivity.this.dCz();
        }
    };
    private com.baidu.tieba.video.d myS = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void dAY() {
        }

        @Override // com.baidu.tieba.video.d
        public void IJ(int i) {
            LocalVideoActivity.this.myR.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.myR.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.myR.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.myR.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.myR.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener myT = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil dCx() {
        if (this.myI == null) {
            this.myI = new VideoConvertUtil(this);
            this.myI.a(this.myS);
        }
        return this.myI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCy() {
        this.myG.coJ();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.myN == null) {
                this.myN = new LocalVideoCompressingDialogView(this);
            }
            if (this.myN.getParent() == null) {
                relativeLayout.addView(this.myN);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.myN.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.myN.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.myN.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCz() {
        this.myG.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.myN.getParent() != null) {
            relativeLayout.removeView(this.myN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCA() {
        dCx().abortConvert();
        this.myM = true;
        if (this.myJ != null) {
            File file = new File(this.myJ);
            if (file.exists()) {
                file.delete();
            }
        }
        dCz();
        this.myJ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dBd() {
        return VideoConvertUtil.dBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wH(boolean z) {
        d RV = e.RV(this.myJ);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.myJ);
        videoInfo.setVideoDuration(((int) RV.getDuration()) / 1000);
        videoInfo.setVideoWidth(RV.getVideoWidth());
        videoInfo.setVideoHeight(RV.getVideoHeight());
        videoInfo.setVideoLength(new File(RV.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.mvu, videoInfo)));
        this.myL = false;
        this.myJ = null;
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
            this.mvu = getIntent().getStringExtra("video_title");
        }
        this.myG = new c(this, this.mOnClickListener);
        this.myH = new LocalVideoModel(this);
        this.myH.a(this.myQ);
        this.myH.dCB();
        registerListener(this.myP);
        registerListener(this.myO);
        registerListener(this.myT);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.myK = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.myK = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.myG != null) {
            this.myG.dCG();
        }
        if (this.myL && !TextUtils.isEmpty(this.myJ) && new File(this.myJ).exists()) {
            wH(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.myG != null) {
            this.myG.coK();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.myG.coK();
        if (this.myI != null) {
            this.myI.destroy();
        }
        if (this.myR != null) {
            this.myR.removeMessages(5);
        }
    }
}
