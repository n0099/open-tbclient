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
    private String hpF;
    private c hsU;
    private LocalVideoModel hsV;
    private f hsW;
    private String hsX;
    private com.baidu.tieba.video.commonview.a htb;
    private String mForumId;
    private String mForumName;
    private boolean hsY = false;
    private boolean hsZ = false;
    private boolean hta = false;
    private CustomMessageListener htc = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.hsU != null) {
                    LocalVideoActivity.this.hsU.tU(str);
                }
            }
        }
    };
    private CustomMessageListener htd = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.hsV != null) {
                LocalVideoActivity.this.hsV.bCr();
            }
        }
    };
    private b.a hte = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dK(List<d> list) {
            if (LocalVideoActivity.this.hsU != null) {
                LocalVideoActivity.this.hsU.dL(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.hsU != null) {
                if (view != LocalVideoActivity.this.hsU.bCu()) {
                    if (view == LocalVideoActivity.this.hsU.bCv()) {
                        if (!LocalVideoActivity.this.hsU.bCs()) {
                            if (LocalVideoActivity.this.hsU.bCz() == null || LocalVideoActivity.this.hsU.bCz().getDuration() <= 600000) {
                                f bCn = LocalVideoActivity.this.bCn();
                                if (!bCn.isConvertRunning()) {
                                    String bCy = LocalVideoActivity.this.hsU.bCy();
                                    if (TextUtils.isEmpty(bCy)) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bCy));
                                        return;
                                    } else if (!new File(bCy).exists()) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bCy));
                                        return;
                                    } else {
                                        int tD = e.tD(bCy);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bCz = LocalVideoActivity.this.hsU.bCz();
                                            if (bCz != null) {
                                                LocalVideoActivity.this.hsU.awy();
                                                LocalVideoActivity.this.hsX = bCz.getVideoPath();
                                                LocalVideoActivity.this.nr(false);
                                                return;
                                            }
                                            return;
                                        } else if (tD >= 1500000) {
                                            if (LocalVideoActivity.this.bAU()) {
                                                File file = new File(com.baidu.tieba.video.d.hog, "tieba_" + e.tC(bCy) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hsX = file.getAbsolutePath();
                                                bCn.setConvertType(1);
                                                bCn.ci(bCy, LocalVideoActivity.this.hsX);
                                                LocalVideoActivity.this.bCo();
                                                LocalVideoActivity.this.hsZ = false;
                                                LocalVideoActivity.this.hta = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bCz2 = LocalVideoActivity.this.hsU.bCz();
                                            if (bCz2 != null) {
                                                if (bCz2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.hsU.awy();
                                                    LocalVideoActivity.this.hsX = bCz2.getVideoPath();
                                                    LocalVideoActivity.this.nr(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.d.hog, "tieba_" + e.tC(bCy) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hsX = file2.getAbsolutePath();
                                                bCn.setConvertType(2);
                                                bCn.ci(bCy, LocalVideoActivity.this.hsX);
                                                LocalVideoActivity.this.bCo();
                                                LocalVideoActivity.this.hsZ = false;
                                                LocalVideoActivity.this.hta = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.hsU.bCt();
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
    private Handler htf = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.htf.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.htb != null && LocalVideoActivity.this.htb.isShowing()) {
                        LocalVideoActivity.this.htb.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.htf.sendMessageDelayed(LocalVideoActivity.this.htf.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.hta) {
                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.hsZ = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.hsX) && (file = new File(LocalVideoActivity.this.hsX)) != null) {
                        LocalVideoActivity.this.hsX = LocalVideoActivity.this.hsX.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.hsX));
                    }
                    LocalVideoActivity.this.bCp();
                    if (!LocalVideoActivity.this.hsY && LocalVideoActivity.this.hsU.bCz() != null) {
                        d tX = e.tX(LocalVideoActivity.this.hsX);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.hsX);
                        videoInfo.setVideoDuration(((int) tX.getDuration()) / 1000);
                        videoInfo.setVideoWidth(tX.getVideoWidth());
                        videoInfo.setVideoHeight(tX.getVideoHeight());
                        videoInfo.setVideoLength(new File(tX.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.hpF, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                    f bCn = LocalVideoActivity.this.bCn();
                    if (bCn != null && bCn.isConvertRunning()) {
                        LocalVideoActivity.this.bCq();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.hsZ = false;
            LocalVideoActivity.this.bCp();
        }
    };
    private com.baidu.tieba.video.c htg = new com.baidu.tieba.video.c() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.c
        public void bAQ() {
        }

        @Override // com.baidu.tieba.video.c
        public void wD(int i) {
            LocalVideoActivity.this.htf.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertSuccess() {
            LocalVideoActivity.this.htf.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertFailed() {
            LocalVideoActivity.this.htf.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.htf.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertAborted() {
            LocalVideoActivity.this.htf.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener hth = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public f bCn() {
        if (this.hsW == null) {
            this.hsW = new f(this);
            this.hsW.a(this.htg);
        }
        return this.hsW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCo() {
        this.hsU.awy();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null) {
            if (this.htb == null) {
                this.htb = new com.baidu.tieba.video.commonview.a(this);
            }
            if (this.htb.getParent() == null) {
                relativeLayout.addView(this.htb);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.htb.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.htb.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.htb.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCp() {
        this.hsU.bCw();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null && this.htb.getParent() != null) {
            relativeLayout.removeView(this.htb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCq() {
        bCn().abortConvert();
        this.hta = true;
        if (this.hsX != null) {
            File file = new File(this.hsX);
            if (file.exists()) {
                file.delete();
            }
        }
        bCp();
        this.hsX = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAU() {
        return f.bAU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(boolean z) {
        d tX = e.tX(this.hsX);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hsX);
        videoInfo.setVideoDuration(((int) tX.getDuration()) / 1000);
        videoInfo.setVideoWidth(tX.getVideoWidth());
        videoInfo.setVideoHeight(tX.getVideoHeight());
        videoInfo.setVideoLength(new File(tX.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.hpF, videoInfo)));
        this.hsZ = false;
        this.hsX = null;
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
            this.hpF = getIntent().getStringExtra("video_title");
        }
        this.hsU = new c(this, this.mOnClickListener);
        this.hsV = new LocalVideoModel(this);
        this.hsV.a(this.hte);
        this.hsV.bCr();
        registerListener(this.htd);
        registerListener(this.htc);
        registerListener(this.hth);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.hsY = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hsY = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hsU != null) {
            this.hsU.bCx();
        }
        if (this.hsZ && !TextUtils.isEmpty(this.hsX) && new File(this.hsX).exists()) {
            nr(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hsU != null) {
            this.hsU.awz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hsU.awz();
        if (this.hsW != null) {
            this.hsW.destroy();
        }
        if (this.htf != null) {
            this.htf.removeMessages(5);
        }
    }
}
