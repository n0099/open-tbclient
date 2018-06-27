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
    private String hbW;
    private c hfh;
    private LocalVideoModel hfi;
    private VideoConvertUtil hfj;
    private String hfk;
    private LocalVideoCompressingDialogView hfo;
    private String mForumId;
    private String mForumName;
    private boolean hfl = false;
    private boolean hfm = false;
    private boolean hfn = false;
    private CustomMessageListener hfp = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.hfh != null) {
                    LocalVideoActivity.this.hfh.uU(str);
                }
            }
        }
    };
    private CustomMessageListener hfq = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.hfi != null) {
                LocalVideoActivity.this.hfi.bDb();
            }
        }
    };
    private b.a hfr = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dM(List<d> list) {
            if (LocalVideoActivity.this.hfh != null) {
                LocalVideoActivity.this.hfh.dN(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.hfh != null) {
                if (view != LocalVideoActivity.this.hfh.bDe()) {
                    if (view == LocalVideoActivity.this.hfh.bDf()) {
                        if (!LocalVideoActivity.this.hfh.bDc()) {
                            if (LocalVideoActivity.this.hfh.bDj() == null || LocalVideoActivity.this.hfh.bDj().getDuration() <= 600000) {
                                VideoConvertUtil bCX = LocalVideoActivity.this.bCX();
                                if (!bCX.isConvertRunning()) {
                                    String bDi = LocalVideoActivity.this.hfh.bDi();
                                    if (TextUtils.isEmpty(bDi)) {
                                        l.showToast(LocalVideoActivity.this, d.k.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bDi));
                                        return;
                                    } else if (!new File(bDi).exists()) {
                                        l.showToast(LocalVideoActivity.this, d.k.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bDi));
                                        return;
                                    } else {
                                        int uD = e.uD(bDi);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bDj = LocalVideoActivity.this.hfh.bDj();
                                            if (bDj != null) {
                                                LocalVideoActivity.this.hfh.avz();
                                                LocalVideoActivity.this.hfk = bDj.getVideoPath();
                                                LocalVideoActivity.this.ni(false);
                                                return;
                                            }
                                            return;
                                        } else if (uD >= 1500000) {
                                            if (LocalVideoActivity.this.bBA()) {
                                                File file = new File(com.baidu.tieba.video.d.hav, "tieba_" + e.uC(bDi) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hfk = file.getAbsolutePath();
                                                bCX.setConvertType(1);
                                                bCX.ct(bDi, LocalVideoActivity.this.hfk);
                                                LocalVideoActivity.this.bCY();
                                                LocalVideoActivity.this.hfm = false;
                                                LocalVideoActivity.this.hfn = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bDj2 = LocalVideoActivity.this.hfh.bDj();
                                            if (bDj2 != null) {
                                                if (bDj2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.hfh.avz();
                                                    LocalVideoActivity.this.hfk = bDj2.getVideoPath();
                                                    LocalVideoActivity.this.ni(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.d.hav, "tieba_" + e.uC(bDi) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hfk = file2.getAbsolutePath();
                                                bCX.setConvertType(2);
                                                bCX.ct(bDi, LocalVideoActivity.this.hfk);
                                                LocalVideoActivity.this.bCY();
                                                LocalVideoActivity.this.hfm = false;
                                                LocalVideoActivity.this.hfn = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.hfh.bDd();
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
    private Handler hfs = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.hfs.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.hfo != null && LocalVideoActivity.this.hfo.isShowing()) {
                        LocalVideoActivity.this.hfo.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.hfs.sendMessageDelayed(LocalVideoActivity.this.hfs.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.hfn) {
                        l.showToast(LocalVideoActivity.this, d.k.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.hfm = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.hfk) && (file = new File(LocalVideoActivity.this.hfk)) != null) {
                        LocalVideoActivity.this.hfk = LocalVideoActivity.this.hfk.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.hfk));
                    }
                    LocalVideoActivity.this.bCZ();
                    if (!LocalVideoActivity.this.hfl && LocalVideoActivity.this.hfh.bDj() != null) {
                        d uX = e.uX(LocalVideoActivity.this.hfk);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.hfk);
                        videoInfo.setVideoDuration(((int) uX.getDuration()) / 1000);
                        videoInfo.setVideoWidth(uX.getVideoWidth());
                        videoInfo.setVideoHeight(uX.getVideoHeight());
                        videoInfo.setVideoLength(new File(uX.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.hbW, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.k.mv_local_video_compress_failed);
                    VideoConvertUtil bCX = LocalVideoActivity.this.bCX();
                    if (bCX != null && bCX.isConvertRunning()) {
                        LocalVideoActivity.this.bDa();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.hfm = false;
            LocalVideoActivity.this.bCZ();
        }
    };
    private com.baidu.tieba.video.c hft = new com.baidu.tieba.video.c() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.c
        public void bBw() {
        }

        @Override // com.baidu.tieba.video.c
        public void uz(int i) {
            LocalVideoActivity.this.hfs.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertSuccess() {
            LocalVideoActivity.this.hfs.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertFailed() {
            LocalVideoActivity.this.hfs.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.hfs.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertAborted() {
            LocalVideoActivity.this.hfs.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener hfu = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil bCX() {
        if (this.hfj == null) {
            this.hfj = new VideoConvertUtil(this);
            this.hfj.a(this.hft);
        }
        return this.hfj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCY() {
        this.hfh.avz();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null) {
            if (this.hfo == null) {
                this.hfo = new LocalVideoCompressingDialogView(this);
            }
            if (this.hfo.getParent() == null) {
                relativeLayout.addView(this.hfo);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hfo.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.hfo.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hfo.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCZ() {
        this.hfh.bDg();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null && this.hfo.getParent() != null) {
            relativeLayout.removeView(this.hfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDa() {
        bCX().abortConvert();
        this.hfn = true;
        if (this.hfk != null) {
            File file = new File(this.hfk);
            if (file.exists()) {
                file.delete();
            }
        }
        bCZ();
        this.hfk = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bBA() {
        return VideoConvertUtil.bBA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ni(boolean z) {
        d uX = e.uX(this.hfk);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hfk);
        videoInfo.setVideoDuration(((int) uX.getDuration()) / 1000);
        videoInfo.setVideoWidth(uX.getVideoWidth());
        videoInfo.setVideoHeight(uX.getVideoHeight());
        videoInfo.setVideoLength(new File(uX.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.hbW, videoInfo)));
        this.hfm = false;
        this.hfk = null;
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
            this.hbW = getIntent().getStringExtra("video_title");
        }
        this.hfh = new c(this, this.mOnClickListener);
        this.hfi = new LocalVideoModel(this);
        this.hfi.a(this.hfr);
        this.hfi.bDb();
        registerListener(this.hfq);
        registerListener(this.hfp);
        registerListener(this.hfu);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.hfl = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hfl = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hfh != null) {
            this.hfh.bDh();
        }
        if (this.hfm && !TextUtils.isEmpty(this.hfk) && new File(this.hfk).exists()) {
            ni(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hfh != null) {
            this.hfh.avA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hfh.avA();
        if (this.hfj != null) {
            this.hfj.destroy();
        }
        if (this.hfs != null) {
            this.hfs.removeMessages(5);
        }
    }
}
