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
import com.baidu.tieba.video.f;
import com.baidu.tieba.video.localvideo.b;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String hph;
    private com.baidu.tieba.video.commonview.a hsD;
    private c hsw;
    private LocalVideoModel hsx;
    private f hsy;
    private String hsz;
    private String mForumId;
    private String mForumName;
    private boolean hsA = false;
    private boolean hsB = false;
    private boolean hsC = false;
    private CustomMessageListener hsE = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.hsw != null) {
                    LocalVideoActivity.this.hsw.tU(str);
                }
            }
        }
    };
    private CustomMessageListener hsF = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.hsx != null) {
                LocalVideoActivity.this.hsx.bCm();
            }
        }
    };
    private b.a hsG = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dK(List<d> list) {
            if (LocalVideoActivity.this.hsw != null) {
                LocalVideoActivity.this.hsw.dL(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.hsw != null) {
                if (view != LocalVideoActivity.this.hsw.bCp()) {
                    if (view == LocalVideoActivity.this.hsw.bCq()) {
                        if (!LocalVideoActivity.this.hsw.bCn()) {
                            if (LocalVideoActivity.this.hsw.bCu() == null || LocalVideoActivity.this.hsw.bCu().getDuration() <= 600000) {
                                f bCi = LocalVideoActivity.this.bCi();
                                if (!bCi.isConvertRunning()) {
                                    String bCt = LocalVideoActivity.this.hsw.bCt();
                                    if (TextUtils.isEmpty(bCt)) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bCt));
                                        return;
                                    } else if (!new File(bCt).exists()) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bCt));
                                        return;
                                    } else {
                                        int tD = e.tD(bCt);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bCu = LocalVideoActivity.this.hsw.bCu();
                                            if (bCu != null) {
                                                LocalVideoActivity.this.hsw.aww();
                                                LocalVideoActivity.this.hsz = bCu.getVideoPath();
                                                LocalVideoActivity.this.nm(false);
                                                return;
                                            }
                                            return;
                                        } else if (tD >= 1500000) {
                                            if (LocalVideoActivity.this.bAP()) {
                                                File file = new File(com.baidu.tieba.video.d.hnI, "tieba_" + e.tC(bCt) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hsz = file.getAbsolutePath();
                                                bCi.setConvertType(1);
                                                bCi.ci(bCt, LocalVideoActivity.this.hsz);
                                                LocalVideoActivity.this.bCj();
                                                LocalVideoActivity.this.hsB = false;
                                                LocalVideoActivity.this.hsC = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bCu2 = LocalVideoActivity.this.hsw.bCu();
                                            if (bCu2 != null) {
                                                if (bCu2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.hsw.aww();
                                                    LocalVideoActivity.this.hsz = bCu2.getVideoPath();
                                                    LocalVideoActivity.this.nm(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.d.hnI, "tieba_" + e.tC(bCt) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hsz = file2.getAbsolutePath();
                                                bCi.setConvertType(2);
                                                bCi.ci(bCt, LocalVideoActivity.this.hsz);
                                                LocalVideoActivity.this.bCj();
                                                LocalVideoActivity.this.hsB = false;
                                                LocalVideoActivity.this.hsC = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.hsw.bCo();
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
    private Handler hsH = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.hsH.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.hsD != null && LocalVideoActivity.this.hsD.isShowing()) {
                        LocalVideoActivity.this.hsD.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.hsH.sendMessageDelayed(LocalVideoActivity.this.hsH.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.hsC) {
                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.hsB = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.hsz) && (file = new File(LocalVideoActivity.this.hsz)) != null) {
                        LocalVideoActivity.this.hsz = LocalVideoActivity.this.hsz.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.hsz));
                    }
                    LocalVideoActivity.this.bCk();
                    if (!LocalVideoActivity.this.hsA && LocalVideoActivity.this.hsw.bCu() != null) {
                        d tX = e.tX(LocalVideoActivity.this.hsz);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.hsz);
                        videoInfo.setVideoDuration(((int) tX.getDuration()) / 1000);
                        videoInfo.setVideoWidth(tX.getVideoWidth());
                        videoInfo.setVideoHeight(tX.getVideoHeight());
                        videoInfo.setVideoLength(new File(tX.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.hph, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                    f bCi = LocalVideoActivity.this.bCi();
                    if (bCi != null && bCi.isConvertRunning()) {
                        LocalVideoActivity.this.bCl();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.hsB = false;
            LocalVideoActivity.this.bCk();
        }
    };
    private com.baidu.tieba.video.c hsI = new com.baidu.tieba.video.c() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.c
        public void bAL() {
        }

        @Override // com.baidu.tieba.video.c
        public void wD(int i) {
            LocalVideoActivity.this.hsH.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertSuccess() {
            LocalVideoActivity.this.hsH.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertFailed() {
            LocalVideoActivity.this.hsH.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.hsH.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertAborted() {
            LocalVideoActivity.this.hsH.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener hsJ = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public f bCi() {
        if (this.hsy == null) {
            this.hsy = new f(this);
            this.hsy.a(this.hsI);
        }
        return this.hsy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCj() {
        this.hsw.aww();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null) {
            if (this.hsD == null) {
                this.hsD = new com.baidu.tieba.video.commonview.a(this);
            }
            if (this.hsD.getParent() == null) {
                relativeLayout.addView(this.hsD);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsD.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.hsD.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hsD.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCk() {
        this.hsw.bCr();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null && this.hsD.getParent() != null) {
            relativeLayout.removeView(this.hsD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCl() {
        bCi().abortConvert();
        this.hsC = true;
        if (this.hsz != null) {
            File file = new File(this.hsz);
            if (file.exists()) {
                file.delete();
            }
        }
        bCk();
        this.hsz = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAP() {
        return f.bAP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nm(boolean z) {
        d tX = e.tX(this.hsz);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hsz);
        videoInfo.setVideoDuration(((int) tX.getDuration()) / 1000);
        videoInfo.setVideoWidth(tX.getVideoWidth());
        videoInfo.setVideoHeight(tX.getVideoHeight());
        videoInfo.setVideoLength(new File(tX.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.hph, videoInfo)));
        this.hsB = false;
        this.hsz = null;
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
            this.hph = getIntent().getStringExtra("video_title");
        }
        this.hsw = new c(this, this.mOnClickListener);
        this.hsx = new LocalVideoModel(this);
        this.hsx.a(this.hsG);
        this.hsx.bCm();
        registerListener(this.hsF);
        registerListener(this.hsE);
        registerListener(this.hsJ);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.hsA = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hsA = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hsw != null) {
            this.hsw.bCs();
        }
        if (this.hsB && !TextUtils.isEmpty(this.hsz) && new File(this.hsz).exists()) {
            nm(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hsw != null) {
            this.hsw.awx();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hsw.awx();
        if (this.hsy != null) {
            this.hsy.destroy();
        }
        if (this.hsH != null) {
            this.hsH.removeMessages(5);
        }
    }
}
