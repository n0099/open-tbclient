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
    private String gMp;
    private c gPA;
    private LocalVideoModel gPB;
    private VideoConvertUtil gPC;
    private String gPD;
    private LocalVideoCompressingDialogView gPH;
    private String mForumId;
    private String mForumName;
    private boolean gPE = false;
    private boolean gPF = false;
    private boolean gPG = false;
    private CustomMessageListener gPI = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.gPA != null) {
                    LocalVideoActivity.this.gPA.ue(str);
                }
            }
        }
    };
    private CustomMessageListener gPJ = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.gPB != null) {
                LocalVideoActivity.this.gPB.bxu();
            }
        }
    };
    private b.a gPK = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dE(List<d> list) {
            if (LocalVideoActivity.this.gPA != null) {
                LocalVideoActivity.this.gPA.dF(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (LocalVideoActivity.this.gPA != null) {
                if (view2 != LocalVideoActivity.this.gPA.bxx()) {
                    if (view2 == LocalVideoActivity.this.gPA.bxy()) {
                        if (!LocalVideoActivity.this.gPA.bxv()) {
                            if (LocalVideoActivity.this.gPA.bxC() == null || LocalVideoActivity.this.gPA.bxC().getDuration() <= 600000) {
                                VideoConvertUtil bxq = LocalVideoActivity.this.bxq();
                                if (!bxq.isConvertRunning()) {
                                    String bxB = LocalVideoActivity.this.gPA.bxB();
                                    if (TextUtils.isEmpty(bxB)) {
                                        l.showToast(LocalVideoActivity.this, d.k.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bxB));
                                        return;
                                    } else if (!new File(bxB).exists()) {
                                        l.showToast(LocalVideoActivity.this, d.k.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bxB));
                                        return;
                                    } else {
                                        int tN = e.tN(bxB);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bxC = LocalVideoActivity.this.gPA.bxC();
                                            if (bxC != null) {
                                                LocalVideoActivity.this.gPA.aqQ();
                                                LocalVideoActivity.this.gPD = bxC.getVideoPath();
                                                LocalVideoActivity.this.mU(false);
                                                return;
                                            }
                                            return;
                                        } else if (tN >= 1500000) {
                                            if (LocalVideoActivity.this.bvT()) {
                                                File file = new File(com.baidu.tieba.video.d.gKO, "tieba_" + e.tM(bxB) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.gPD = file.getAbsolutePath();
                                                bxq.setConvertType(1);
                                                bxq.ch(bxB, LocalVideoActivity.this.gPD);
                                                LocalVideoActivity.this.bxr();
                                                LocalVideoActivity.this.gPF = false;
                                                LocalVideoActivity.this.gPG = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bxC2 = LocalVideoActivity.this.gPA.bxC();
                                            if (bxC2 != null) {
                                                if (bxC2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.gPA.aqQ();
                                                    LocalVideoActivity.this.gPD = bxC2.getVideoPath();
                                                    LocalVideoActivity.this.mU(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.d.gKO, "tieba_" + e.tM(bxB) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.gPD = file2.getAbsolutePath();
                                                bxq.setConvertType(2);
                                                bxq.ch(bxB, LocalVideoActivity.this.gPD);
                                                LocalVideoActivity.this.bxr();
                                                LocalVideoActivity.this.gPF = false;
                                                LocalVideoActivity.this.gPG = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.gPA.bxw();
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
    private Handler gPL = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.gPL.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.gPH != null && LocalVideoActivity.this.gPH.isShowing()) {
                        LocalVideoActivity.this.gPH.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.gPL.sendMessageDelayed(LocalVideoActivity.this.gPL.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.gPG) {
                        l.showToast(LocalVideoActivity.this, d.k.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.gPF = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.gPD) && (file = new File(LocalVideoActivity.this.gPD)) != null) {
                        LocalVideoActivity.this.gPD = LocalVideoActivity.this.gPD.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.gPD));
                    }
                    LocalVideoActivity.this.bxs();
                    if (!LocalVideoActivity.this.gPE && LocalVideoActivity.this.gPA.bxC() != null) {
                        d uh = e.uh(LocalVideoActivity.this.gPD);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.gPD);
                        videoInfo.setVideoDuration(((int) uh.getDuration()) / 1000);
                        videoInfo.setVideoWidth(uh.getVideoWidth());
                        videoInfo.setVideoHeight(uh.getVideoHeight());
                        videoInfo.setVideoLength(new File(uh.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.gMp, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.k.mv_local_video_compress_failed);
                    VideoConvertUtil bxq = LocalVideoActivity.this.bxq();
                    if (bxq != null && bxq.isConvertRunning()) {
                        LocalVideoActivity.this.bxt();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.gPF = false;
            LocalVideoActivity.this.bxs();
        }
    };
    private com.baidu.tieba.video.c gPM = new com.baidu.tieba.video.c() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.c
        public void bvP() {
        }

        @Override // com.baidu.tieba.video.c
        public void ue(int i) {
            LocalVideoActivity.this.gPL.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertSuccess() {
            LocalVideoActivity.this.gPL.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertFailed() {
            LocalVideoActivity.this.gPL.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.gPL.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertAborted() {
            LocalVideoActivity.this.gPL.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener gPN = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil bxq() {
        if (this.gPC == null) {
            this.gPC = new VideoConvertUtil(this);
            this.gPC.a(this.gPM);
        }
        return this.gPC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxr() {
        this.gPA.aqQ();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null) {
            if (this.gPH == null) {
                this.gPH = new LocalVideoCompressingDialogView(this);
            }
            if (this.gPH.getParent() == null) {
                relativeLayout.addView(this.gPH);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gPH.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.gPH.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.gPH.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxs() {
        this.gPA.bxz();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null && this.gPH.getParent() != null) {
            relativeLayout.removeView(this.gPH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxt() {
        bxq().abortConvert();
        this.gPG = true;
        if (this.gPD != null) {
            File file = new File(this.gPD);
            if (file.exists()) {
                file.delete();
            }
        }
        bxs();
        this.gPD = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bvT() {
        return VideoConvertUtil.bvT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mU(boolean z) {
        d uh = e.uh(this.gPD);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.gPD);
        videoInfo.setVideoDuration(((int) uh.getDuration()) / 1000);
        videoInfo.setVideoWidth(uh.getVideoWidth());
        videoInfo.setVideoHeight(uh.getVideoHeight());
        videoInfo.setVideoLength(new File(uh.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.gMp, videoInfo)));
        this.gPF = false;
        this.gPD = null;
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
            this.gMp = getIntent().getStringExtra("video_title");
        }
        this.gPA = new c(this, this.mOnClickListener);
        this.gPB = new LocalVideoModel(this);
        this.gPB.a(this.gPK);
        this.gPB.bxu();
        registerListener(this.gPJ);
        registerListener(this.gPI);
        registerListener(this.gPN);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gPE = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gPE = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gPA != null) {
            this.gPA.bxA();
        }
        if (this.gPF && !TextUtils.isEmpty(this.gPD) && new File(this.gPD).exists()) {
            mU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gPA != null) {
            this.gPA.aqR();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gPA.aqR();
        if (this.gPC != null) {
            this.gPC.destroy();
        }
        if (this.gPL != null) {
            this.gPL.removeMessages(5);
        }
    }
}
