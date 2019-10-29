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
/* loaded from: classes5.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private c jBG;
    private LocalVideoModel jBH;
    private VideoConvertUtil jBI;
    private String jBJ;
    private LocalVideoCompressingDialogView jBN;
    private String jyA;
    private String mForumId;
    private String mForumName;
    private boolean jBK = false;
    private boolean jBL = false;
    private boolean jBM = false;
    private CustomMessageListener jBO = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.jBG != null) {
                    LocalVideoActivity.this.jBG.EW(str);
                }
            }
        }
    };
    private CustomMessageListener jBP = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.jBH != null) {
                LocalVideoActivity.this.jBH.cug();
            }
        }
    };
    private b.a jBQ = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void eD(List<d> list) {
            if (LocalVideoActivity.this.jBG != null) {
                LocalVideoActivity.this.jBG.eE(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.jBG != null) {
                if (view != LocalVideoActivity.this.jBG.cuj()) {
                    if (view == LocalVideoActivity.this.jBG.cuk()) {
                        if (!LocalVideoActivity.this.jBG.cuh()) {
                            if (LocalVideoActivity.this.jBG.cuo() == null || LocalVideoActivity.this.jBG.cuo().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil cuc = LocalVideoActivity.this.cuc();
                                if (!cuc.isConvertRunning()) {
                                    String cun = LocalVideoActivity.this.jBG.cun();
                                    if (TextUtils.isEmpty(cun)) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, cun));
                                        return;
                                    } else if (!new File(cun).exists()) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, cun));
                                        return;
                                    } else {
                                        int EG = e.EG(cun);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d cuo = LocalVideoActivity.this.jBG.cuo();
                                            if (cuo != null) {
                                                LocalVideoActivity.this.jBG.bmi();
                                                LocalVideoActivity.this.jBJ = cuo.getVideoPath();
                                                LocalVideoActivity.this.rs(false);
                                                return;
                                            }
                                            return;
                                        } else if (EG >= 1500000) {
                                            if (LocalVideoActivity.this.csC()) {
                                                File file = new File(com.baidu.tieba.video.e.jwZ, "tieba_" + e.EF(cun) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.jBJ = file.getAbsolutePath();
                                                cuc.setConvertType(1);
                                                cuc.ee(cun, LocalVideoActivity.this.jBJ);
                                                LocalVideoActivity.this.cud();
                                                LocalVideoActivity.this.jBL = false;
                                                LocalVideoActivity.this.jBM = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d cuo2 = LocalVideoActivity.this.jBG.cuo();
                                            if (cuo2 != null) {
                                                if (cuo2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.jBG.bmi();
                                                    LocalVideoActivity.this.jBJ = cuo2.getVideoPath();
                                                    LocalVideoActivity.this.rs(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.jwZ, "tieba_" + e.EF(cun) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.jBJ = file2.getAbsolutePath();
                                                cuc.setConvertType(2);
                                                cuc.ee(cun, LocalVideoActivity.this.jBJ);
                                                LocalVideoActivity.this.cud();
                                                LocalVideoActivity.this.jBL = false;
                                                LocalVideoActivity.this.jBM = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.jBG.cui();
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
    private Handler jBR = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.jBR.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.jBN != null && LocalVideoActivity.this.jBN.isShowing()) {
                        LocalVideoActivity.this.jBN.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.jBR.sendMessageDelayed(LocalVideoActivity.this.jBR.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.jBM) {
                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.jBL = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.jBJ) && (file = new File(LocalVideoActivity.this.jBJ)) != null) {
                        LocalVideoActivity.this.jBJ = LocalVideoActivity.this.jBJ.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.jBJ));
                    }
                    LocalVideoActivity.this.cue();
                    if (!LocalVideoActivity.this.jBK && LocalVideoActivity.this.jBG.cuo() != null) {
                        d Fa = e.Fa(LocalVideoActivity.this.jBJ);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.jBJ);
                        videoInfo.setVideoDuration(((int) Fa.getDuration()) / 1000);
                        videoInfo.setVideoWidth(Fa.getVideoWidth());
                        videoInfo.setVideoHeight(Fa.getVideoHeight());
                        videoInfo.setVideoLength(new File(Fa.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.jyA, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                    VideoConvertUtil cuc = LocalVideoActivity.this.cuc();
                    if (cuc != null && cuc.isConvertRunning()) {
                        LocalVideoActivity.this.cuf();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.jBL = false;
            LocalVideoActivity.this.cue();
        }
    };
    private com.baidu.tieba.video.d jBS = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void csy() {
        }

        @Override // com.baidu.tieba.video.d
        public void AK(int i) {
            LocalVideoActivity.this.jBR.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.jBR.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.jBR.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.jBR.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.jBR.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener jBT = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil cuc() {
        if (this.jBI == null) {
            this.jBI = new VideoConvertUtil(this);
            this.jBI.a(this.jBS);
        }
        return this.jBI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cud() {
        this.jBG.bmi();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.jBN == null) {
                this.jBN = new LocalVideoCompressingDialogView(this);
            }
            if (this.jBN.getParent() == null) {
                relativeLayout.addView(this.jBN);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jBN.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.jBN.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.jBN.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cue() {
        this.jBG.cul();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.jBN.getParent() != null) {
            relativeLayout.removeView(this.jBN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuf() {
        cuc().abortConvert();
        this.jBM = true;
        if (this.jBJ != null) {
            File file = new File(this.jBJ);
            if (file.exists()) {
                file.delete();
            }
        }
        cue();
        this.jBJ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean csC() {
        return VideoConvertUtil.csC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rs(boolean z) {
        d Fa = e.Fa(this.jBJ);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jBJ);
        videoInfo.setVideoDuration(((int) Fa.getDuration()) / 1000);
        videoInfo.setVideoWidth(Fa.getVideoWidth());
        videoInfo.setVideoHeight(Fa.getVideoHeight());
        videoInfo.setVideoLength(new File(Fa.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.jyA, videoInfo)));
        this.jBL = false;
        this.jBJ = null;
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
            this.jyA = getIntent().getStringExtra("video_title");
        }
        this.jBG = new c(this, this.mOnClickListener);
        this.jBH = new LocalVideoModel(this);
        this.jBH.a(this.jBQ);
        this.jBH.cug();
        registerListener(this.jBP);
        registerListener(this.jBO);
        registerListener(this.jBT);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.jBK = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.jBK = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jBG != null) {
            this.jBG.cum();
        }
        if (this.jBL && !TextUtils.isEmpty(this.jBJ) && new File(this.jBJ).exists()) {
            rs(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jBG != null) {
            this.jBG.bmj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jBG.bmj();
        if (this.jBI != null) {
            this.jBI.destroy();
        }
        if (this.jBR != null) {
            this.jBR.removeMessages(5);
        }
    }
}
