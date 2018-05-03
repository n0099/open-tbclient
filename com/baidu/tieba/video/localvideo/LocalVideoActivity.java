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
    private String gLm;
    private String gOA;
    private LocalVideoCompressingDialogView gOE;
    private c gOx;
    private LocalVideoModel gOy;
    private VideoConvertUtil gOz;
    private String mForumId;
    private String mForumName;
    private boolean gOB = false;
    private boolean gOC = false;
    private boolean gOD = false;
    private CustomMessageListener gOF = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.gOx != null) {
                    LocalVideoActivity.this.gOx.ub(str);
                }
            }
        }
    };
    private CustomMessageListener gOG = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.gOy != null) {
                LocalVideoActivity.this.gOy.bxw();
            }
        }
    };
    private b.a gOH = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dB(List<d> list) {
            if (LocalVideoActivity.this.gOx != null) {
                LocalVideoActivity.this.gOx.dC(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (LocalVideoActivity.this.gOx != null) {
                if (view2 != LocalVideoActivity.this.gOx.bxz()) {
                    if (view2 == LocalVideoActivity.this.gOx.bxA()) {
                        if (!LocalVideoActivity.this.gOx.bxx()) {
                            if (LocalVideoActivity.this.gOx.bxE() == null || LocalVideoActivity.this.gOx.bxE().getDuration() <= 600000) {
                                VideoConvertUtil bxs = LocalVideoActivity.this.bxs();
                                if (!bxs.isConvertRunning()) {
                                    String bxD = LocalVideoActivity.this.gOx.bxD();
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
                                            d bxE = LocalVideoActivity.this.gOx.bxE();
                                            if (bxE != null) {
                                                LocalVideoActivity.this.gOx.aqR();
                                                LocalVideoActivity.this.gOA = bxE.getVideoPath();
                                                LocalVideoActivity.this.mT(false);
                                                return;
                                            }
                                            return;
                                        } else if (tK >= 1500000) {
                                            if (LocalVideoActivity.this.bvV()) {
                                                File file = new File(com.baidu.tieba.video.d.gJL, "tieba_" + e.tJ(bxD) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.gOA = file.getAbsolutePath();
                                                bxs.setConvertType(1);
                                                bxs.ch(bxD, LocalVideoActivity.this.gOA);
                                                LocalVideoActivity.this.bxt();
                                                LocalVideoActivity.this.gOC = false;
                                                LocalVideoActivity.this.gOD = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bxE2 = LocalVideoActivity.this.gOx.bxE();
                                            if (bxE2 != null) {
                                                if (bxE2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.gOx.aqR();
                                                    LocalVideoActivity.this.gOA = bxE2.getVideoPath();
                                                    LocalVideoActivity.this.mT(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.d.gJL, "tieba_" + e.tJ(bxD) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.gOA = file2.getAbsolutePath();
                                                bxs.setConvertType(2);
                                                bxs.ch(bxD, LocalVideoActivity.this.gOA);
                                                LocalVideoActivity.this.bxt();
                                                LocalVideoActivity.this.gOC = false;
                                                LocalVideoActivity.this.gOD = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.gOx.bxy();
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
    private Handler gOI = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.gOI.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.gOE != null && LocalVideoActivity.this.gOE.isShowing()) {
                        LocalVideoActivity.this.gOE.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.gOI.sendMessageDelayed(LocalVideoActivity.this.gOI.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.gOD) {
                        l.showToast(LocalVideoActivity.this, d.k.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.gOC = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.gOA) && (file = new File(LocalVideoActivity.this.gOA)) != null) {
                        LocalVideoActivity.this.gOA = LocalVideoActivity.this.gOA.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.gOA));
                    }
                    LocalVideoActivity.this.bxu();
                    if (!LocalVideoActivity.this.gOB && LocalVideoActivity.this.gOx.bxE() != null) {
                        d ue = e.ue(LocalVideoActivity.this.gOA);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.gOA);
                        videoInfo.setVideoDuration(((int) ue.getDuration()) / 1000);
                        videoInfo.setVideoWidth(ue.getVideoWidth());
                        videoInfo.setVideoHeight(ue.getVideoHeight());
                        videoInfo.setVideoLength(new File(ue.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.gLm, videoInfo)));
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
            LocalVideoActivity.this.gOC = false;
            LocalVideoActivity.this.bxu();
        }
    };
    private com.baidu.tieba.video.c gOJ = new com.baidu.tieba.video.c() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.c
        public void bvR() {
        }

        @Override // com.baidu.tieba.video.c
        public void uf(int i) {
            LocalVideoActivity.this.gOI.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertSuccess() {
            LocalVideoActivity.this.gOI.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertFailed() {
            LocalVideoActivity.this.gOI.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.gOI.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertAborted() {
            LocalVideoActivity.this.gOI.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener gOK = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
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
        if (this.gOz == null) {
            this.gOz = new VideoConvertUtil(this);
            this.gOz.a(this.gOJ);
        }
        return this.gOz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxt() {
        this.gOx.aqR();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null) {
            if (this.gOE == null) {
                this.gOE = new LocalVideoCompressingDialogView(this);
            }
            if (this.gOE.getParent() == null) {
                relativeLayout.addView(this.gOE);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gOE.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.gOE.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.gOE.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxu() {
        this.gOx.bxB();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null && this.gOE.getParent() != null) {
            relativeLayout.removeView(this.gOE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxv() {
        bxs().abortConvert();
        this.gOD = true;
        if (this.gOA != null) {
            File file = new File(this.gOA);
            if (file.exists()) {
                file.delete();
            }
        }
        bxu();
        this.gOA = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bvV() {
        return VideoConvertUtil.bvV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mT(boolean z) {
        d ue = e.ue(this.gOA);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.gOA);
        videoInfo.setVideoDuration(((int) ue.getDuration()) / 1000);
        videoInfo.setVideoWidth(ue.getVideoWidth());
        videoInfo.setVideoHeight(ue.getVideoHeight());
        videoInfo.setVideoLength(new File(ue.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.gLm, videoInfo)));
        this.gOC = false;
        this.gOA = null;
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
            this.gLm = getIntent().getStringExtra("video_title");
        }
        this.gOx = new c(this, this.mOnClickListener);
        this.gOy = new LocalVideoModel(this);
        this.gOy.a(this.gOH);
        this.gOy.bxw();
        registerListener(this.gOG);
        registerListener(this.gOF);
        registerListener(this.gOK);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gOB = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gOB = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gOx != null) {
            this.gOx.bxC();
        }
        if (this.gOC && !TextUtils.isEmpty(this.gOA) && new File(this.gOA).exists()) {
            mT(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gOx != null) {
            this.gOx.aqS();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gOx.aqS();
        if (this.gOz != null) {
            this.gOz.destroy();
        }
        if (this.gOI != null) {
            this.gOI.removeMessages(5);
        }
    }
}
