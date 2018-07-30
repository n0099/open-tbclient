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
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.video.commonview.LocalVideoCompressingDialogView;
import com.baidu.tieba.video.localvideo.b;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String hdj;
    private LocalVideoCompressingDialogView hgD;
    private c hgw;
    private LocalVideoModel hgx;
    private VideoConvertUtil hgy;
    private String hgz;
    private String mForumId;
    private String mForumName;
    private boolean hgA = false;
    private boolean hgB = false;
    private boolean hgC = false;
    private CustomMessageListener hgE = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.hgw != null) {
                    LocalVideoActivity.this.hgw.uS(str);
                }
            }
        }
    };
    private CustomMessageListener hgF = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.hgx != null) {
                LocalVideoActivity.this.hgx.bBM();
            }
        }
    };
    private b.a hgG = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dI(List<d> list) {
            if (LocalVideoActivity.this.hgw != null) {
                LocalVideoActivity.this.hgw.dJ(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.hgw != null) {
                if (view != LocalVideoActivity.this.hgw.bBP()) {
                    if (view == LocalVideoActivity.this.hgw.bBQ()) {
                        if (!LocalVideoActivity.this.hgw.bBN()) {
                            if (LocalVideoActivity.this.hgw.bBU() == null || LocalVideoActivity.this.hgw.bBU().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil bBI = LocalVideoActivity.this.bBI();
                                if (!bBI.isConvertRunning()) {
                                    String bBT = LocalVideoActivity.this.hgw.bBT();
                                    if (TextUtils.isEmpty(bBT)) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bBT));
                                        return;
                                    } else if (!new File(bBT).exists()) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bBT));
                                        return;
                                    } else {
                                        int uB = e.uB(bBT);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bBU = LocalVideoActivity.this.hgw.bBU();
                                            if (bBU != null) {
                                                LocalVideoActivity.this.hgw.awe();
                                                LocalVideoActivity.this.hgz = bBU.getVideoPath();
                                                LocalVideoActivity.this.mU(false);
                                                return;
                                            }
                                            return;
                                        } else if (uB >= 1500000) {
                                            if (LocalVideoActivity.this.bAh()) {
                                                File file = new File(com.baidu.tieba.video.e.hbI, "tieba_" + e.uA(bBT) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hgz = file.getAbsolutePath();
                                                bBI.setConvertType(1);
                                                bBI.cq(bBT, LocalVideoActivity.this.hgz);
                                                LocalVideoActivity.this.bBJ();
                                                LocalVideoActivity.this.hgB = false;
                                                LocalVideoActivity.this.hgC = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bBU2 = LocalVideoActivity.this.hgw.bBU();
                                            if (bBU2 != null) {
                                                if (bBU2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.hgw.awe();
                                                    LocalVideoActivity.this.hgz = bBU2.getVideoPath();
                                                    LocalVideoActivity.this.mU(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.hbI, "tieba_" + e.uA(bBT) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hgz = file2.getAbsolutePath();
                                                bBI.setConvertType(2);
                                                bBI.cq(bBT, LocalVideoActivity.this.hgz);
                                                LocalVideoActivity.this.bBJ();
                                                LocalVideoActivity.this.hgB = false;
                                                LocalVideoActivity.this.hgC = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.hgw.bBO();
                            return;
                        }
                        l.showToast(LocalVideoActivity.this, d.j.show_video_file_error);
                        return;
                    }
                    return;
                }
                LocalVideoActivity.this.finish();
            }
        }
    };
    private Handler hgH = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.hgH.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.hgD != null && LocalVideoActivity.this.hgD.isShowing()) {
                        LocalVideoActivity.this.hgD.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.hgH.sendMessageDelayed(LocalVideoActivity.this.hgH.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.hgC) {
                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.hgB = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.hgz) && (file = new File(LocalVideoActivity.this.hgz)) != null) {
                        LocalVideoActivity.this.hgz = LocalVideoActivity.this.hgz.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.hgz));
                    }
                    LocalVideoActivity.this.bBK();
                    if (!LocalVideoActivity.this.hgA && LocalVideoActivity.this.hgw.bBU() != null) {
                        d uV = e.uV(LocalVideoActivity.this.hgz);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.hgz);
                        videoInfo.setVideoDuration(((int) uV.getDuration()) / 1000);
                        videoInfo.setVideoWidth(uV.getVideoWidth());
                        videoInfo.setVideoHeight(uV.getVideoHeight());
                        videoInfo.setVideoLength(new File(uV.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.hdj, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                    VideoConvertUtil bBI = LocalVideoActivity.this.bBI();
                    if (bBI != null && bBI.isConvertRunning()) {
                        LocalVideoActivity.this.bBL();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.hgB = false;
            LocalVideoActivity.this.bBK();
        }
    };
    private com.baidu.tieba.video.d hgI = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void bAd() {
        }

        @Override // com.baidu.tieba.video.d
        public void uy(int i) {
            LocalVideoActivity.this.hgH.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.hgH.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.hgH.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.hgH.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.hgH.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener hgJ = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil bBI() {
        if (this.hgy == null) {
            this.hgy = new VideoConvertUtil(this);
            this.hgy.a(this.hgI);
        }
        return this.hgy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBJ() {
        this.hgw.awe();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null) {
            if (this.hgD == null) {
                this.hgD = new LocalVideoCompressingDialogView(this);
            }
            if (this.hgD.getParent() == null) {
                relativeLayout.addView(this.hgD);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hgD.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.hgD.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hgD.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBK() {
        this.hgw.bBR();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null && this.hgD.getParent() != null) {
            relativeLayout.removeView(this.hgD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBL() {
        bBI().abortConvert();
        this.hgC = true;
        if (this.hgz != null) {
            File file = new File(this.hgz);
            if (file.exists()) {
                file.delete();
            }
        }
        bBK();
        this.hgz = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAh() {
        return VideoConvertUtil.bAh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mU(boolean z) {
        d uV = e.uV(this.hgz);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hgz);
        videoInfo.setVideoDuration(((int) uV.getDuration()) / 1000);
        videoInfo.setVideoWidth(uV.getVideoWidth());
        videoInfo.setVideoHeight(uV.getVideoHeight());
        videoInfo.setVideoLength(new File(uV.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.hdj, videoInfo)));
        this.hgB = false;
        this.hgz = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.local_video_activity);
        if (getIntent() != null) {
            this.mForumId = getIntent().getStringExtra("forum_id");
            this.mForumName = getIntent().getStringExtra("forum_name");
            this.hdj = getIntent().getStringExtra("video_title");
        }
        this.hgw = new c(this, this.mOnClickListener);
        this.hgx = new LocalVideoModel(this);
        this.hgx.a(this.hgG);
        this.hgx.bBM();
        registerListener(this.hgF);
        registerListener(this.hgE);
        registerListener(this.hgJ);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.hgA = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hgA = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hgw != null) {
            this.hgw.bBS();
        }
        if (this.hgB && !TextUtils.isEmpty(this.hgz) && new File(this.hgz).exists()) {
            mU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hgw != null) {
            this.hgw.awf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hgw.awf();
        if (this.hgy != null) {
            this.hgy.destroy();
        }
        if (this.hgH != null) {
            this.hgH.removeMessages(5);
        }
    }
}
