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
    private String hof;
    private com.baidu.tieba.video.commonview.a hrA;
    private c hrt;
    private LocalVideoModel hru;
    private f hrv;
    private String hrw;
    private String mForumId;
    private String mForumName;
    private boolean hrx = false;
    private boolean hry = false;
    private boolean hrz = false;
    private CustomMessageListener hrB = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.hrt != null) {
                    LocalVideoActivity.this.hrt.tP(str);
                }
            }
        }
    };
    private CustomMessageListener hrC = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.hru != null) {
                LocalVideoActivity.this.hru.bBE();
            }
        }
    };
    private b.a hrD = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dE(List<d> list) {
            if (LocalVideoActivity.this.hrt != null) {
                LocalVideoActivity.this.hrt.dF(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.hrt != null) {
                if (view != LocalVideoActivity.this.hrt.bBH()) {
                    if (view == LocalVideoActivity.this.hrt.bBI()) {
                        if (!LocalVideoActivity.this.hrt.bBF()) {
                            if (LocalVideoActivity.this.hrt.bBM() == null || LocalVideoActivity.this.hrt.bBM().getDuration() <= 600000) {
                                f bBA = LocalVideoActivity.this.bBA();
                                if (!bBA.isConvertRunning()) {
                                    String bBL = LocalVideoActivity.this.hrt.bBL();
                                    if (TextUtils.isEmpty(bBL)) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bBL));
                                        return;
                                    } else if (!new File(bBL).exists()) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bBL));
                                        return;
                                    } else {
                                        int ty = e.ty(bBL);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bBM = LocalVideoActivity.this.hrt.bBM();
                                            if (bBM != null) {
                                                LocalVideoActivity.this.hrt.avA();
                                                LocalVideoActivity.this.hrw = bBM.getVideoPath();
                                                LocalVideoActivity.this.ne(false);
                                                return;
                                            }
                                            return;
                                        } else if (ty >= 1500000) {
                                            if (LocalVideoActivity.this.bAg()) {
                                                File file = new File(com.baidu.tieba.video.d.hmG, "tieba_" + e.tx(bBL) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hrw = file.getAbsolutePath();
                                                bBA.setConvertType(1);
                                                bBA.cg(bBL, LocalVideoActivity.this.hrw);
                                                LocalVideoActivity.this.bBB();
                                                LocalVideoActivity.this.hry = false;
                                                LocalVideoActivity.this.hrz = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bBM2 = LocalVideoActivity.this.hrt.bBM();
                                            if (bBM2 != null) {
                                                if (bBM2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.hrt.avA();
                                                    LocalVideoActivity.this.hrw = bBM2.getVideoPath();
                                                    LocalVideoActivity.this.ne(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.d.hmG, "tieba_" + e.tx(bBL) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hrw = file2.getAbsolutePath();
                                                bBA.setConvertType(2);
                                                bBA.cg(bBL, LocalVideoActivity.this.hrw);
                                                LocalVideoActivity.this.bBB();
                                                LocalVideoActivity.this.hry = false;
                                                LocalVideoActivity.this.hrz = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.hrt.bBG();
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
    private Handler hrE = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.hrE.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.hrA != null && LocalVideoActivity.this.hrA.isShowing()) {
                        LocalVideoActivity.this.hrA.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.hrE.sendMessageDelayed(LocalVideoActivity.this.hrE.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.hrz) {
                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.hry = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.hrw) && (file = new File(LocalVideoActivity.this.hrw)) != null) {
                        LocalVideoActivity.this.hrw = LocalVideoActivity.this.hrw.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.hrw));
                    }
                    LocalVideoActivity.this.bBC();
                    if (!LocalVideoActivity.this.hrx && LocalVideoActivity.this.hrt.bBM() != null) {
                        d tS = e.tS(LocalVideoActivity.this.hrw);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.hrw);
                        videoInfo.setVideoDuration(((int) tS.getDuration()) / 1000);
                        videoInfo.setVideoWidth(tS.getVideoWidth());
                        videoInfo.setVideoHeight(tS.getVideoHeight());
                        videoInfo.setVideoLength(new File(tS.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.hof, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                    f bBA = LocalVideoActivity.this.bBA();
                    if (bBA != null && bBA.isConvertRunning()) {
                        LocalVideoActivity.this.bBD();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.hry = false;
            LocalVideoActivity.this.bBC();
        }
    };
    private com.baidu.tieba.video.c hrF = new com.baidu.tieba.video.c() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.c
        public void bAc() {
        }

        @Override // com.baidu.tieba.video.c
        public void wD(int i) {
            LocalVideoActivity.this.hrE.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertSuccess() {
            LocalVideoActivity.this.hrE.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertFailed() {
            LocalVideoActivity.this.hrE.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.hrE.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertAborted() {
            LocalVideoActivity.this.hrE.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener hrG = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public f bBA() {
        if (this.hrv == null) {
            this.hrv = new f(this);
            this.hrv.a(this.hrF);
        }
        return this.hrv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBB() {
        this.hrt.avA();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null) {
            if (this.hrA == null) {
                this.hrA = new com.baidu.tieba.video.commonview.a(this);
            }
            if (this.hrA.getParent() == null) {
                relativeLayout.addView(this.hrA);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hrA.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.hrA.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hrA.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBC() {
        this.hrt.bBJ();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null && this.hrA.getParent() != null) {
            relativeLayout.removeView(this.hrA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBD() {
        bBA().abortConvert();
        this.hrz = true;
        if (this.hrw != null) {
            File file = new File(this.hrw);
            if (file.exists()) {
                file.delete();
            }
        }
        bBC();
        this.hrw = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAg() {
        return f.bAg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ne(boolean z) {
        d tS = e.tS(this.hrw);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hrw);
        videoInfo.setVideoDuration(((int) tS.getDuration()) / 1000);
        videoInfo.setVideoWidth(tS.getVideoWidth());
        videoInfo.setVideoHeight(tS.getVideoHeight());
        videoInfo.setVideoLength(new File(tS.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.hof, videoInfo)));
        this.hry = false;
        this.hrw = null;
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
            this.hof = getIntent().getStringExtra("video_title");
        }
        this.hrt = new c(this, this.mOnClickListener);
        this.hru = new LocalVideoModel(this);
        this.hru.a(this.hrD);
        this.hru.bBE();
        registerListener(this.hrC);
        registerListener(this.hrB);
        registerListener(this.hrG);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.hrx = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hrx = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hrt != null) {
            this.hrt.bBK();
        }
        if (this.hry && !TextUtils.isEmpty(this.hrw) && new File(this.hrw).exists()) {
            ne(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hrt != null) {
            this.hrt.avB();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hrt.avB();
        if (this.hrv != null) {
            this.hrv.destroy();
        }
        if (this.hrE != null) {
            this.hrE.removeMessages(5);
        }
    }
}
