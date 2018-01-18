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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
    private String hnL;
    private c hqZ;
    private LocalVideoModel hra;
    private f hrb;
    private String hrc;
    private com.baidu.tieba.video.commonview.a hrg;
    private String mForumId;
    private String mForumName;
    private boolean hrd = false;
    private boolean hre = false;
    private boolean hrf = false;
    private CustomMessageListener hrh = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.hqZ != null) {
                    LocalVideoActivity.this.hqZ.tI(str);
                }
            }
        }
    };
    private CustomMessageListener hri = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.hra != null) {
                LocalVideoActivity.this.hra.bBC();
            }
        }
    };
    private b.a hrj = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dE(List<d> list) {
            if (LocalVideoActivity.this.hqZ != null) {
                LocalVideoActivity.this.hqZ.dF(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.hqZ != null) {
                if (view != LocalVideoActivity.this.hqZ.bBF()) {
                    if (view == LocalVideoActivity.this.hqZ.bBG()) {
                        if (!LocalVideoActivity.this.hqZ.bBD()) {
                            if (LocalVideoActivity.this.hqZ.bBK() == null || LocalVideoActivity.this.hqZ.bBK().getDuration() <= 600000) {
                                f bBy = LocalVideoActivity.this.bBy();
                                if (!bBy.isConvertRunning()) {
                                    String bBJ = LocalVideoActivity.this.hqZ.bBJ();
                                    if (TextUtils.isEmpty(bBJ)) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bBJ));
                                        return;
                                    } else if (!new File(bBJ).exists()) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bBJ));
                                        return;
                                    } else {
                                        int tr = e.tr(bBJ);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bBK = LocalVideoActivity.this.hqZ.bBK();
                                            if (bBK != null) {
                                                LocalVideoActivity.this.hqZ.avv();
                                                LocalVideoActivity.this.hrc = bBK.getVideoPath();
                                                LocalVideoActivity.this.nc(false);
                                                return;
                                            }
                                            return;
                                        } else if (tr >= 1500000) {
                                            if (LocalVideoActivity.this.bAe()) {
                                                File file = new File(com.baidu.tieba.video.d.hmm, "tieba_" + e.tq(bBJ) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hrc = file.getAbsolutePath();
                                                bBy.setConvertType(1);
                                                bBy.ch(bBJ, LocalVideoActivity.this.hrc);
                                                LocalVideoActivity.this.bBz();
                                                LocalVideoActivity.this.hre = false;
                                                LocalVideoActivity.this.hrf = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bBK2 = LocalVideoActivity.this.hqZ.bBK();
                                            if (bBK2 != null) {
                                                if (bBK2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.hqZ.avv();
                                                    LocalVideoActivity.this.hrc = bBK2.getVideoPath();
                                                    LocalVideoActivity.this.nc(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.d.hmm, "tieba_" + e.tq(bBJ) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hrc = file2.getAbsolutePath();
                                                bBy.setConvertType(2);
                                                bBy.ch(bBJ, LocalVideoActivity.this.hrc);
                                                LocalVideoActivity.this.bBz();
                                                LocalVideoActivity.this.hre = false;
                                                LocalVideoActivity.this.hrf = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.hqZ.bBE();
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
    private Handler hrk = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.hrk.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.hrg != null && LocalVideoActivity.this.hrg.isShowing()) {
                        LocalVideoActivity.this.hrg.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.hrk.sendMessageDelayed(LocalVideoActivity.this.hrk.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.hrf) {
                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.hre = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.hrc) && (file = new File(LocalVideoActivity.this.hrc)) != null) {
                        LocalVideoActivity.this.hrc = LocalVideoActivity.this.hrc.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.hrc));
                    }
                    LocalVideoActivity.this.bBA();
                    if (!LocalVideoActivity.this.hrd && LocalVideoActivity.this.hqZ.bBK() != null) {
                        d tL = e.tL(LocalVideoActivity.this.hrc);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.hrc);
                        videoInfo.setVideoDuration(((int) tL.getDuration()) / 1000);
                        videoInfo.setVideoWidth(tL.getVideoWidth());
                        videoInfo.setVideoHeight(tL.getVideoHeight());
                        videoInfo.setVideoLength(new File(tL.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.hnL, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                    f bBy = LocalVideoActivity.this.bBy();
                    if (bBy != null && bBy.isConvertRunning()) {
                        LocalVideoActivity.this.bBB();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.hre = false;
            LocalVideoActivity.this.bBA();
        }
    };
    private com.baidu.tieba.video.c hrl = new com.baidu.tieba.video.c() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.c
        public void bAa() {
        }

        @Override // com.baidu.tieba.video.c
        public void wD(int i) {
            LocalVideoActivity.this.hrk.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertSuccess() {
            LocalVideoActivity.this.hrk.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertFailed() {
            LocalVideoActivity.this.hrk.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.hrk.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertAborted() {
            LocalVideoActivity.this.hrk.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener hrm = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public f bBy() {
        if (this.hrb == null) {
            this.hrb = new f(this);
            this.hrb.a(this.hrl);
        }
        return this.hrb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBz() {
        this.hqZ.avv();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null) {
            if (this.hrg == null) {
                this.hrg = new com.baidu.tieba.video.commonview.a(this);
            }
            if (this.hrg.getParent() == null) {
                relativeLayout.addView(this.hrg);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hrg.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.hrg.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hrg.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBA() {
        this.hqZ.bBH();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null && this.hrg.getParent() != null) {
            relativeLayout.removeView(this.hrg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBB() {
        bBy().abortConvert();
        this.hrf = true;
        if (this.hrc != null) {
            File file = new File(this.hrc);
            if (file.exists()) {
                file.delete();
            }
        }
        bBA();
        this.hrc = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAe() {
        return f.bAe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nc(boolean z) {
        d tL = e.tL(this.hrc);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hrc);
        videoInfo.setVideoDuration(((int) tL.getDuration()) / 1000);
        videoInfo.setVideoWidth(tL.getVideoWidth());
        videoInfo.setVideoHeight(tL.getVideoHeight());
        videoInfo.setVideoLength(new File(tL.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.hnL, videoInfo)));
        this.hre = false;
        this.hrc = null;
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
            this.hnL = getIntent().getStringExtra("video_title");
        }
        this.hqZ = new c(this, this.mOnClickListener);
        this.hra = new LocalVideoModel(this);
        this.hra.a(this.hrj);
        this.hra.bBC();
        registerListener(this.hri);
        registerListener(this.hrh);
        registerListener(this.hrm);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.hrd = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hrd = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hqZ != null) {
            this.hqZ.bBI();
        }
        if (this.hre && !TextUtils.isEmpty(this.hrc) && new File(this.hrc).exists()) {
            nc(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hqZ != null) {
            this.hqZ.avw();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hqZ.avw();
        if (this.hrb != null) {
            this.hrb.destroy();
        }
        if (this.hrk != null) {
            this.hrk.removeMessages(5);
        }
    }
}
