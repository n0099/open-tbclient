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
    private String hpu;
    private c hsJ;
    private LocalVideoModel hsK;
    private f hsL;
    private String hsM;
    private com.baidu.tieba.video.commonview.a hsQ;
    private String mForumId;
    private String mForumName;
    private boolean hsN = false;
    private boolean hsO = false;
    private boolean hsP = false;
    private CustomMessageListener hsR = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.hsJ != null) {
                    LocalVideoActivity.this.hsJ.tU(str);
                }
            }
        }
    };
    private CustomMessageListener hsS = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.hsK != null) {
                LocalVideoActivity.this.hsK.bCn();
            }
        }
    };
    private b.a hsT = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dK(List<d> list) {
            if (LocalVideoActivity.this.hsJ != null) {
                LocalVideoActivity.this.hsJ.dL(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.hsJ != null) {
                if (view != LocalVideoActivity.this.hsJ.bCq()) {
                    if (view == LocalVideoActivity.this.hsJ.bCr()) {
                        if (!LocalVideoActivity.this.hsJ.bCo()) {
                            if (LocalVideoActivity.this.hsJ.bCv() == null || LocalVideoActivity.this.hsJ.bCv().getDuration() <= 600000) {
                                f bCj = LocalVideoActivity.this.bCj();
                                if (!bCj.isConvertRunning()) {
                                    String bCu = LocalVideoActivity.this.hsJ.bCu();
                                    if (TextUtils.isEmpty(bCu)) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bCu));
                                        return;
                                    } else if (!new File(bCu).exists()) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bCu));
                                        return;
                                    } else {
                                        int tD = e.tD(bCu);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bCv = LocalVideoActivity.this.hsJ.bCv();
                                            if (bCv != null) {
                                                LocalVideoActivity.this.hsJ.awx();
                                                LocalVideoActivity.this.hsM = bCv.getVideoPath();
                                                LocalVideoActivity.this.nm(false);
                                                return;
                                            }
                                            return;
                                        } else if (tD >= 1500000) {
                                            if (LocalVideoActivity.this.bAQ()) {
                                                File file = new File(com.baidu.tieba.video.d.hnV, "tieba_" + e.tC(bCu) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hsM = file.getAbsolutePath();
                                                bCj.setConvertType(1);
                                                bCj.ci(bCu, LocalVideoActivity.this.hsM);
                                                LocalVideoActivity.this.bCk();
                                                LocalVideoActivity.this.hsO = false;
                                                LocalVideoActivity.this.hsP = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bCv2 = LocalVideoActivity.this.hsJ.bCv();
                                            if (bCv2 != null) {
                                                if (bCv2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.hsJ.awx();
                                                    LocalVideoActivity.this.hsM = bCv2.getVideoPath();
                                                    LocalVideoActivity.this.nm(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.d.hnV, "tieba_" + e.tC(bCu) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hsM = file2.getAbsolutePath();
                                                bCj.setConvertType(2);
                                                bCj.ci(bCu, LocalVideoActivity.this.hsM);
                                                LocalVideoActivity.this.bCk();
                                                LocalVideoActivity.this.hsO = false;
                                                LocalVideoActivity.this.hsP = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.hsJ.bCp();
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
    private Handler hsU = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.hsU.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.hsQ != null && LocalVideoActivity.this.hsQ.isShowing()) {
                        LocalVideoActivity.this.hsQ.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.hsU.sendMessageDelayed(LocalVideoActivity.this.hsU.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.hsP) {
                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.hsO = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.hsM) && (file = new File(LocalVideoActivity.this.hsM)) != null) {
                        LocalVideoActivity.this.hsM = LocalVideoActivity.this.hsM.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.hsM));
                    }
                    LocalVideoActivity.this.bCl();
                    if (!LocalVideoActivity.this.hsN && LocalVideoActivity.this.hsJ.bCv() != null) {
                        d tX = e.tX(LocalVideoActivity.this.hsM);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.hsM);
                        videoInfo.setVideoDuration(((int) tX.getDuration()) / 1000);
                        videoInfo.setVideoWidth(tX.getVideoWidth());
                        videoInfo.setVideoHeight(tX.getVideoHeight());
                        videoInfo.setVideoLength(new File(tX.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.hpu, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                    f bCj = LocalVideoActivity.this.bCj();
                    if (bCj != null && bCj.isConvertRunning()) {
                        LocalVideoActivity.this.bCm();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.hsO = false;
            LocalVideoActivity.this.bCl();
        }
    };
    private com.baidu.tieba.video.c hsV = new com.baidu.tieba.video.c() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.c
        public void bAM() {
        }

        @Override // com.baidu.tieba.video.c
        public void wC(int i) {
            LocalVideoActivity.this.hsU.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertSuccess() {
            LocalVideoActivity.this.hsU.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertFailed() {
            LocalVideoActivity.this.hsU.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.hsU.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertAborted() {
            LocalVideoActivity.this.hsU.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener hsW = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public f bCj() {
        if (this.hsL == null) {
            this.hsL = new f(this);
            this.hsL.a(this.hsV);
        }
        return this.hsL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCk() {
        this.hsJ.awx();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null) {
            if (this.hsQ == null) {
                this.hsQ = new com.baidu.tieba.video.commonview.a(this);
            }
            if (this.hsQ.getParent() == null) {
                relativeLayout.addView(this.hsQ);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsQ.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.hsQ.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hsQ.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCl() {
        this.hsJ.bCs();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null && this.hsQ.getParent() != null) {
            relativeLayout.removeView(this.hsQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCm() {
        bCj().abortConvert();
        this.hsP = true;
        if (this.hsM != null) {
            File file = new File(this.hsM);
            if (file.exists()) {
                file.delete();
            }
        }
        bCl();
        this.hsM = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAQ() {
        return f.bAQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nm(boolean z) {
        d tX = e.tX(this.hsM);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hsM);
        videoInfo.setVideoDuration(((int) tX.getDuration()) / 1000);
        videoInfo.setVideoWidth(tX.getVideoWidth());
        videoInfo.setVideoHeight(tX.getVideoHeight());
        videoInfo.setVideoLength(new File(tX.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.hpu, videoInfo)));
        this.hsO = false;
        this.hsM = null;
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
            this.hpu = getIntent().getStringExtra("video_title");
        }
        this.hsJ = new c(this, this.mOnClickListener);
        this.hsK = new LocalVideoModel(this);
        this.hsK.a(this.hsT);
        this.hsK.bCn();
        registerListener(this.hsS);
        registerListener(this.hsR);
        registerListener(this.hsW);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.hsN = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hsN = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hsJ != null) {
            this.hsJ.bCt();
        }
        if (this.hsO && !TextUtils.isEmpty(this.hsM) && new File(this.hsM).exists()) {
            nm(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hsJ != null) {
            this.hsJ.awy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hsJ.awy();
        if (this.hsL != null) {
            this.hsL.destroy();
        }
        if (this.hsU != null) {
            this.hsU.removeMessages(5);
        }
    }
}
