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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.video.commonview.LocalVideoCompressingDialogView;
import com.baidu.tieba.video.localvideo.b;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String gLp;
    private c gOA;
    private LocalVideoModel gOB;
    private VideoConvertUtil gOC;
    private String gOD;
    private LocalVideoCompressingDialogView gOH;
    private String mForumId;
    private String mForumName;
    private boolean gOE = false;
    private boolean gOF = false;
    private boolean gOG = false;
    private CustomMessageListener gOI = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.gOA != null) {
                    LocalVideoActivity.this.gOA.ub(str);
                }
            }
        }
    };
    private CustomMessageListener gOJ = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.gOB != null) {
                LocalVideoActivity.this.gOB.bxw();
            }
        }
    };
    private b.a gOK = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dB(List<d> list) {
            if (LocalVideoActivity.this.gOA != null) {
                LocalVideoActivity.this.gOA.dC(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (LocalVideoActivity.this.gOA != null) {
                if (view2 != LocalVideoActivity.this.gOA.bxz()) {
                    if (view2 == LocalVideoActivity.this.gOA.bxA()) {
                        if (!LocalVideoActivity.this.gOA.bxx()) {
                            if (LocalVideoActivity.this.gOA.bxE() == null || LocalVideoActivity.this.gOA.bxE().getDuration() <= 600000) {
                                VideoConvertUtil bxs = LocalVideoActivity.this.bxs();
                                if (!bxs.isConvertRunning()) {
                                    String bxD = LocalVideoActivity.this.gOA.bxD();
                                    if (TextUtils.isEmpty(bxD)) {
                                        l.showToast(LocalVideoActivity.this, d.k.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bxD));
                                        return;
                                    } else if (!new File(bxD).exists()) {
                                        l.showToast(LocalVideoActivity.this, d.k.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bxD));
                                        return;
                                    } else {
                                        int tK = e.tK(bxD);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bxE = LocalVideoActivity.this.gOA.bxE();
                                            if (bxE != null) {
                                                LocalVideoActivity.this.gOA.aqR();
                                                LocalVideoActivity.this.gOD = bxE.getVideoPath();
                                                LocalVideoActivity.this.mT(false);
                                                return;
                                            }
                                            return;
                                        } else if (tK >= 1500000) {
                                            if (LocalVideoActivity.this.bvV()) {
                                                File file = new File(com.baidu.tieba.video.d.gJO, "tieba_" + e.tJ(bxD) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.gOD = file.getAbsolutePath();
                                                bxs.setConvertType(1);
                                                bxs.ch(bxD, LocalVideoActivity.this.gOD);
                                                LocalVideoActivity.this.bxt();
                                                LocalVideoActivity.this.gOF = false;
                                                LocalVideoActivity.this.gOG = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bxE2 = LocalVideoActivity.this.gOA.bxE();
                                            if (bxE2 != null) {
                                                if (bxE2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.gOA.aqR();
                                                    LocalVideoActivity.this.gOD = bxE2.getVideoPath();
                                                    LocalVideoActivity.this.mT(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.d.gJO, "tieba_" + e.tJ(bxD) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.gOD = file2.getAbsolutePath();
                                                bxs.setConvertType(2);
                                                bxs.ch(bxD, LocalVideoActivity.this.gOD);
                                                LocalVideoActivity.this.bxt();
                                                LocalVideoActivity.this.gOF = false;
                                                LocalVideoActivity.this.gOG = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.gOA.bxy();
                            return;
                        }
                        l.showToast(LocalVideoActivity.this, d.k.show_video_file_error);
                        return;
                    }
                    return;
                }
                LocalVideoActivity.this.finish();
            }
        }
    };
    private Handler gOL = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.gOL.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.gOH != null && LocalVideoActivity.this.gOH.isShowing()) {
                        LocalVideoActivity.this.gOH.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.gOL.sendMessageDelayed(LocalVideoActivity.this.gOL.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.gOG) {
                        l.showToast(LocalVideoActivity.this, d.k.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.gOF = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.gOD) && (file = new File(LocalVideoActivity.this.gOD)) != null) {
                        LocalVideoActivity.this.gOD = LocalVideoActivity.this.gOD.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.gOD));
                    }
                    LocalVideoActivity.this.bxu();
                    if (!LocalVideoActivity.this.gOE && LocalVideoActivity.this.gOA.bxE() != null) {
                        d ue = e.ue(LocalVideoActivity.this.gOD);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.gOD);
                        videoInfo.setVideoDuration(((int) ue.getDuration()) / 1000);
                        videoInfo.setVideoWidth(ue.getVideoWidth());
                        videoInfo.setVideoHeight(ue.getVideoHeight());
                        videoInfo.setVideoLength(new File(ue.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.gLp, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.k.mv_local_video_compress_failed);
                    VideoConvertUtil bxs = LocalVideoActivity.this.bxs();
                    if (bxs != null && bxs.isConvertRunning()) {
                        LocalVideoActivity.this.bxv();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.gOF = false;
            LocalVideoActivity.this.bxu();
        }
    };
    private com.baidu.tieba.video.c gOM = new com.baidu.tieba.video.c() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.c
        public void bvR() {
        }

        @Override // com.baidu.tieba.video.c
        public void uf(int i) {
            LocalVideoActivity.this.gOL.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertSuccess() {
            LocalVideoActivity.this.gOL.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertFailed() {
            LocalVideoActivity.this.gOL.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.gOL.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertAborted() {
            LocalVideoActivity.this.gOL.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener gON = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil bxs() {
        if (this.gOC == null) {
            this.gOC = new VideoConvertUtil(this);
            this.gOC.a(this.gOM);
        }
        return this.gOC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxt() {
        this.gOA.aqR();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null) {
            if (this.gOH == null) {
                this.gOH = new LocalVideoCompressingDialogView(this);
            }
            if (this.gOH.getParent() == null) {
                relativeLayout.addView(this.gOH);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gOH.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.gOH.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.gOH.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxu() {
        this.gOA.bxB();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null && this.gOH.getParent() != null) {
            relativeLayout.removeView(this.gOH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxv() {
        bxs().abortConvert();
        this.gOG = true;
        if (this.gOD != null) {
            File file = new File(this.gOD);
            if (file.exists()) {
                file.delete();
            }
        }
        bxu();
        this.gOD = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bvV() {
        return VideoConvertUtil.bvV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mT(boolean z) {
        d ue = e.ue(this.gOD);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.gOD);
        videoInfo.setVideoDuration(((int) ue.getDuration()) / 1000);
        videoInfo.setVideoWidth(ue.getVideoWidth());
        videoInfo.setVideoHeight(ue.getVideoHeight());
        videoInfo.setVideoLength(new File(ue.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.gLp, videoInfo)));
        this.gOF = false;
        this.gOD = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.i.local_video_activity);
        if (getIntent() != null) {
            this.mForumId = getIntent().getStringExtra("forum_id");
            this.mForumName = getIntent().getStringExtra("forum_name");
            this.gLp = getIntent().getStringExtra("video_title");
        }
        this.gOA = new c(this, this.mOnClickListener);
        this.gOB = new LocalVideoModel(this);
        this.gOB.a(this.gOK);
        this.gOB.bxw();
        registerListener(this.gOJ);
        registerListener(this.gOI);
        registerListener(this.gON);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gOE = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gOE = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gOA != null) {
            this.gOA.bxC();
        }
        if (this.gOF && !TextUtils.isEmpty(this.gOD) && new File(this.gOD).exists()) {
            mT(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gOA != null) {
            this.gOA.aqS();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gOA.aqS();
        if (this.gOC != null) {
            this.gOC.destroy();
        }
        if (this.gOL != null) {
            this.gOL.removeMessages(5);
        }
    }
}
