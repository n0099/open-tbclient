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
import com.baidu.tieba.f;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.video.commonview.LocalVideoCompressingDialogView;
import com.baidu.tieba.video.localvideo.b;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String hdk;
    private String hgA;
    private LocalVideoCompressingDialogView hgE;
    private c hgx;
    private LocalVideoModel hgy;
    private VideoConvertUtil hgz;
    private String mForumId;
    private String mForumName;
    private boolean hgB = false;
    private boolean hgC = false;
    private boolean hgD = false;
    private CustomMessageListener hgF = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.hgx != null) {
                    LocalVideoActivity.this.hgx.uW(str);
                }
            }
        }
    };
    private CustomMessageListener hgG = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.hgy != null) {
                LocalVideoActivity.this.hgy.bBO();
            }
        }
    };
    private b.a hgH = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dI(List<d> list) {
            if (LocalVideoActivity.this.hgx != null) {
                LocalVideoActivity.this.hgx.dJ(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.hgx != null) {
                if (view != LocalVideoActivity.this.hgx.bBR()) {
                    if (view == LocalVideoActivity.this.hgx.bBS()) {
                        if (!LocalVideoActivity.this.hgx.bBP()) {
                            if (LocalVideoActivity.this.hgx.bBW() == null || LocalVideoActivity.this.hgx.bBW().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil bBK = LocalVideoActivity.this.bBK();
                                if (!bBK.isConvertRunning()) {
                                    String bBV = LocalVideoActivity.this.hgx.bBV();
                                    if (TextUtils.isEmpty(bBV)) {
                                        l.showToast(LocalVideoActivity.this, f.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bBV));
                                        return;
                                    } else if (!new File(bBV).exists()) {
                                        l.showToast(LocalVideoActivity.this, f.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bBV));
                                        return;
                                    } else {
                                        int uF = e.uF(bBV);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bBW = LocalVideoActivity.this.hgx.bBW();
                                            if (bBW != null) {
                                                LocalVideoActivity.this.hgx.awd();
                                                LocalVideoActivity.this.hgA = bBW.getVideoPath();
                                                LocalVideoActivity.this.mU(false);
                                                return;
                                            }
                                            return;
                                        } else if (uF >= 1500000) {
                                            if (LocalVideoActivity.this.bAj()) {
                                                File file = new File(com.baidu.tieba.video.e.hbJ, "tieba_" + e.uE(bBV) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hgA = file.getAbsolutePath();
                                                bBK.setConvertType(1);
                                                bBK.cq(bBV, LocalVideoActivity.this.hgA);
                                                LocalVideoActivity.this.bBL();
                                                LocalVideoActivity.this.hgC = false;
                                                LocalVideoActivity.this.hgD = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bBW2 = LocalVideoActivity.this.hgx.bBW();
                                            if (bBW2 != null) {
                                                if (bBW2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.hgx.awd();
                                                    LocalVideoActivity.this.hgA = bBW2.getVideoPath();
                                                    LocalVideoActivity.this.mU(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.hbJ, "tieba_" + e.uE(bBV) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hgA = file2.getAbsolutePath();
                                                bBK.setConvertType(2);
                                                bBK.cq(bBV, LocalVideoActivity.this.hgA);
                                                LocalVideoActivity.this.bBL();
                                                LocalVideoActivity.this.hgC = false;
                                                LocalVideoActivity.this.hgD = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.hgx.bBQ();
                            return;
                        }
                        l.showToast(LocalVideoActivity.this, f.j.show_video_file_error);
                        return;
                    }
                    return;
                }
                LocalVideoActivity.this.finish();
            }
        }
    };
    private Handler hgI = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.hgI.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.hgE != null && LocalVideoActivity.this.hgE.isShowing()) {
                        LocalVideoActivity.this.hgE.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.hgI.sendMessageDelayed(LocalVideoActivity.this.hgI.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.hgD) {
                        l.showToast(LocalVideoActivity.this, f.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.hgC = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.hgA) && (file = new File(LocalVideoActivity.this.hgA)) != null) {
                        LocalVideoActivity.this.hgA = LocalVideoActivity.this.hgA.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.hgA));
                    }
                    LocalVideoActivity.this.bBM();
                    if (!LocalVideoActivity.this.hgB && LocalVideoActivity.this.hgx.bBW() != null) {
                        d uZ = e.uZ(LocalVideoActivity.this.hgA);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.hgA);
                        videoInfo.setVideoDuration(((int) uZ.getDuration()) / 1000);
                        videoInfo.setVideoWidth(uZ.getVideoWidth());
                        videoInfo.setVideoHeight(uZ.getVideoHeight());
                        videoInfo.setVideoLength(new File(uZ.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.hdk, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, f.j.mv_local_video_compress_failed);
                    VideoConvertUtil bBK = LocalVideoActivity.this.bBK();
                    if (bBK != null && bBK.isConvertRunning()) {
                        LocalVideoActivity.this.bBN();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.hgC = false;
            LocalVideoActivity.this.bBM();
        }
    };
    private com.baidu.tieba.video.d hgJ = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void bAf() {
        }

        @Override // com.baidu.tieba.video.d
        public void uy(int i) {
            LocalVideoActivity.this.hgI.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.hgI.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.hgI.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.hgI.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.hgI.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener hgK = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil bBK() {
        if (this.hgz == null) {
            this.hgz = new VideoConvertUtil(this);
            this.hgz.a(this.hgJ);
        }
        return this.hgz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBL() {
        this.hgx.awd();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(f.g.container);
        if (relativeLayout != null) {
            if (this.hgE == null) {
                this.hgE = new LocalVideoCompressingDialogView(this);
            }
            if (this.hgE.getParent() == null) {
                relativeLayout.addView(this.hgE);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hgE.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.hgE.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hgE.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBM() {
        this.hgx.bBT();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(f.g.container);
        if (relativeLayout != null && this.hgE.getParent() != null) {
            relativeLayout.removeView(this.hgE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBN() {
        bBK().abortConvert();
        this.hgD = true;
        if (this.hgA != null) {
            File file = new File(this.hgA);
            if (file.exists()) {
                file.delete();
            }
        }
        bBM();
        this.hgA = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAj() {
        return VideoConvertUtil.bAj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mU(boolean z) {
        d uZ = e.uZ(this.hgA);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hgA);
        videoInfo.setVideoDuration(((int) uZ.getDuration()) / 1000);
        videoInfo.setVideoWidth(uZ.getVideoWidth());
        videoInfo.setVideoHeight(uZ.getVideoHeight());
        videoInfo.setVideoLength(new File(uZ.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.hdk, videoInfo)));
        this.hgC = false;
        this.hgA = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(f.h.local_video_activity);
        if (getIntent() != null) {
            this.mForumId = getIntent().getStringExtra("forum_id");
            this.mForumName = getIntent().getStringExtra("forum_name");
            this.hdk = getIntent().getStringExtra("video_title");
        }
        this.hgx = new c(this, this.mOnClickListener);
        this.hgy = new LocalVideoModel(this);
        this.hgy.a(this.hgH);
        this.hgy.bBO();
        registerListener(this.hgG);
        registerListener(this.hgF);
        registerListener(this.hgK);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.hgB = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hgB = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hgx != null) {
            this.hgx.bBU();
        }
        if (this.hgC && !TextUtils.isEmpty(this.hgA) && new File(this.hgA).exists()) {
            mU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hgx != null) {
            this.hgx.awe();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hgx.awe();
        if (this.hgz != null) {
            this.hgz.destroy();
        }
        if (this.hgI != null) {
            this.hgI.removeMessages(5);
        }
    }
}
