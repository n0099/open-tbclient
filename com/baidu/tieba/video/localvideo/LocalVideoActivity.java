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
    private String gXR;
    private c hbc;
    private LocalVideoModel hbd;
    private VideoConvertUtil hbe;
    private String hbf;
    private LocalVideoCompressingDialogView hbj;
    private String mForumId;
    private String mForumName;
    private boolean hbg = false;
    private boolean hbh = false;
    private boolean hbi = false;
    private CustomMessageListener hbk = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.hbc != null) {
                    LocalVideoActivity.this.hbc.uY(str);
                }
            }
        }
    };
    private CustomMessageListener hbl = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.hbd != null) {
                LocalVideoActivity.this.hbd.bCB();
            }
        }
    };
    private b.a hbm = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dJ(List<d> list) {
            if (LocalVideoActivity.this.hbc != null) {
                LocalVideoActivity.this.hbc.dK(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.hbc != null) {
                if (view != LocalVideoActivity.this.hbc.bCE()) {
                    if (view == LocalVideoActivity.this.hbc.bCF()) {
                        if (!LocalVideoActivity.this.hbc.bCC()) {
                            if (LocalVideoActivity.this.hbc.bCJ() == null || LocalVideoActivity.this.hbc.bCJ().getDuration() <= 600000) {
                                VideoConvertUtil bCx = LocalVideoActivity.this.bCx();
                                if (!bCx.isConvertRunning()) {
                                    String bCI = LocalVideoActivity.this.hbc.bCI();
                                    if (TextUtils.isEmpty(bCI)) {
                                        l.showToast(LocalVideoActivity.this, d.k.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bCI));
                                        return;
                                    } else if (!new File(bCI).exists()) {
                                        l.showToast(LocalVideoActivity.this, d.k.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bCI));
                                        return;
                                    } else {
                                        int uH = e.uH(bCI);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bCJ = LocalVideoActivity.this.hbc.bCJ();
                                            if (bCJ != null) {
                                                LocalVideoActivity.this.hbc.auV();
                                                LocalVideoActivity.this.hbf = bCJ.getVideoPath();
                                                LocalVideoActivity.this.na(false);
                                                return;
                                            }
                                            return;
                                        } else if (uH >= 1500000) {
                                            if (LocalVideoActivity.this.bBa()) {
                                                File file = new File(com.baidu.tieba.video.d.gWq, "tieba_" + e.uG(bCI) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hbf = file.getAbsolutePath();
                                                bCx.setConvertType(1);
                                                bCx.cp(bCI, LocalVideoActivity.this.hbf);
                                                LocalVideoActivity.this.bCy();
                                                LocalVideoActivity.this.hbh = false;
                                                LocalVideoActivity.this.hbi = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bCJ2 = LocalVideoActivity.this.hbc.bCJ();
                                            if (bCJ2 != null) {
                                                if (bCJ2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.hbc.auV();
                                                    LocalVideoActivity.this.hbf = bCJ2.getVideoPath();
                                                    LocalVideoActivity.this.na(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.d.gWq, "tieba_" + e.uG(bCI) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hbf = file2.getAbsolutePath();
                                                bCx.setConvertType(2);
                                                bCx.cp(bCI, LocalVideoActivity.this.hbf);
                                                LocalVideoActivity.this.bCy();
                                                LocalVideoActivity.this.hbh = false;
                                                LocalVideoActivity.this.hbi = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.hbc.bCD();
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
    private Handler hbn = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.hbn.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.hbj != null && LocalVideoActivity.this.hbj.isShowing()) {
                        LocalVideoActivity.this.hbj.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.hbn.sendMessageDelayed(LocalVideoActivity.this.hbn.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.hbi) {
                        l.showToast(LocalVideoActivity.this, d.k.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.hbh = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.hbf) && (file = new File(LocalVideoActivity.this.hbf)) != null) {
                        LocalVideoActivity.this.hbf = LocalVideoActivity.this.hbf.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.hbf));
                    }
                    LocalVideoActivity.this.bCz();
                    if (!LocalVideoActivity.this.hbg && LocalVideoActivity.this.hbc.bCJ() != null) {
                        d vb = e.vb(LocalVideoActivity.this.hbf);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.hbf);
                        videoInfo.setVideoDuration(((int) vb.getDuration()) / 1000);
                        videoInfo.setVideoWidth(vb.getVideoWidth());
                        videoInfo.setVideoHeight(vb.getVideoHeight());
                        videoInfo.setVideoLength(new File(vb.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.gXR, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.k.mv_local_video_compress_failed);
                    VideoConvertUtil bCx = LocalVideoActivity.this.bCx();
                    if (bCx != null && bCx.isConvertRunning()) {
                        LocalVideoActivity.this.bCA();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.hbh = false;
            LocalVideoActivity.this.bCz();
        }
    };
    private com.baidu.tieba.video.c hbo = new com.baidu.tieba.video.c() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.c
        public void bAW() {
        }

        @Override // com.baidu.tieba.video.c
        public void ur(int i) {
            LocalVideoActivity.this.hbn.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertSuccess() {
            LocalVideoActivity.this.hbn.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertFailed() {
            LocalVideoActivity.this.hbn.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.hbn.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertAborted() {
            LocalVideoActivity.this.hbn.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener hbp = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil bCx() {
        if (this.hbe == null) {
            this.hbe = new VideoConvertUtil(this);
            this.hbe.a(this.hbo);
        }
        return this.hbe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCy() {
        this.hbc.auV();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null) {
            if (this.hbj == null) {
                this.hbj = new LocalVideoCompressingDialogView(this);
            }
            if (this.hbj.getParent() == null) {
                relativeLayout.addView(this.hbj);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hbj.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.hbj.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hbj.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCz() {
        this.hbc.bCG();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null && this.hbj.getParent() != null) {
            relativeLayout.removeView(this.hbj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCA() {
        bCx().abortConvert();
        this.hbi = true;
        if (this.hbf != null) {
            File file = new File(this.hbf);
            if (file.exists()) {
                file.delete();
            }
        }
        bCz();
        this.hbf = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bBa() {
        return VideoConvertUtil.bBa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na(boolean z) {
        d vb = e.vb(this.hbf);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hbf);
        videoInfo.setVideoDuration(((int) vb.getDuration()) / 1000);
        videoInfo.setVideoWidth(vb.getVideoWidth());
        videoInfo.setVideoHeight(vb.getVideoHeight());
        videoInfo.setVideoLength(new File(vb.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.gXR, videoInfo)));
        this.hbh = false;
        this.hbf = null;
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
            this.gXR = getIntent().getStringExtra("video_title");
        }
        this.hbc = new c(this, this.mOnClickListener);
        this.hbd = new LocalVideoModel(this);
        this.hbd.a(this.hbm);
        this.hbd.bCB();
        registerListener(this.hbl);
        registerListener(this.hbk);
        registerListener(this.hbp);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.hbg = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hbg = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hbc != null) {
            this.hbc.bCH();
        }
        if (this.hbh && !TextUtils.isEmpty(this.hbf) && new File(this.hbf).exists()) {
            na(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hbc != null) {
            this.hbc.auW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hbc.auW();
        if (this.hbe != null) {
            this.hbe.destroy();
        }
        if (this.hbn != null) {
            this.hbn.removeMessages(5);
        }
    }
}
