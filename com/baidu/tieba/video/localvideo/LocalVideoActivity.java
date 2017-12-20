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
    private String gRb;
    private c gUn;
    private LocalVideoModel gUo;
    private f gUp;
    private String gUq;
    private com.baidu.tieba.video.commonview.a gUu;
    private String mForumId;
    private String mForumName;
    private boolean gUr = false;
    private boolean gUs = false;
    private boolean gUt = false;
    private CustomMessageListener gUv = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.gUn != null) {
                    LocalVideoActivity.this.gUn.um(str);
                }
            }
        }
    };
    private CustomMessageListener gUw = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.gUo != null) {
                LocalVideoActivity.this.gUo.bCH();
            }
        }
    };
    private b.a gUx = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dP(List<d> list) {
            if (LocalVideoActivity.this.gUn != null) {
                LocalVideoActivity.this.gUn.dQ(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.gUn != null) {
                if (view != LocalVideoActivity.this.gUn.bCK()) {
                    if (view == LocalVideoActivity.this.gUn.bCL()) {
                        if (!LocalVideoActivity.this.gUn.bCI()) {
                            if (LocalVideoActivity.this.gUn.bCP() == null || LocalVideoActivity.this.gUn.bCP().getDuration() <= 600000) {
                                f bCD = LocalVideoActivity.this.bCD();
                                if (!bCD.isConvertRunning()) {
                                    String bCO = LocalVideoActivity.this.gUn.bCO();
                                    if (TextUtils.isEmpty(bCO)) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bCO));
                                        return;
                                    } else if (!new File(bCO).exists()) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bCO));
                                        return;
                                    } else {
                                        int tV = e.tV(bCO);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bCP = LocalVideoActivity.this.gUn.bCP();
                                            if (bCP != null) {
                                                LocalVideoActivity.this.gUn.amK();
                                                LocalVideoActivity.this.gUq = bCP.getVideoPath();
                                                LocalVideoActivity.this.nG(false);
                                                return;
                                            }
                                            return;
                                        } else if (tV >= 1500000) {
                                            if (LocalVideoActivity.this.bBj()) {
                                                File file = new File(com.baidu.tieba.video.d.gPG, "tieba_" + e.tU(bCO) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.gUq = file.getAbsolutePath();
                                                bCD.setConvertType(1);
                                                bCD.cm(bCO, LocalVideoActivity.this.gUq);
                                                LocalVideoActivity.this.bCE();
                                                LocalVideoActivity.this.gUs = false;
                                                LocalVideoActivity.this.gUt = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bCP2 = LocalVideoActivity.this.gUn.bCP();
                                            if (bCP2 != null) {
                                                if (bCP2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.gUn.amK();
                                                    LocalVideoActivity.this.gUq = bCP2.getVideoPath();
                                                    LocalVideoActivity.this.nG(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.d.gPG, "tieba_" + e.tU(bCO) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.gUq = file2.getAbsolutePath();
                                                bCD.setConvertType(2);
                                                bCD.cm(bCO, LocalVideoActivity.this.gUq);
                                                LocalVideoActivity.this.bCE();
                                                LocalVideoActivity.this.gUs = false;
                                                LocalVideoActivity.this.gUt = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.gUn.bCJ();
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
    private Handler gUy = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.gUy.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.gUu != null && LocalVideoActivity.this.gUu.isShowing()) {
                        LocalVideoActivity.this.gUu.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.gUy.sendMessageDelayed(LocalVideoActivity.this.gUy.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.gUt) {
                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.gUs = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.gUq) && (file = new File(LocalVideoActivity.this.gUq)) != null) {
                        LocalVideoActivity.this.gUq = LocalVideoActivity.this.gUq.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.gUq));
                    }
                    LocalVideoActivity.this.bCF();
                    if (!LocalVideoActivity.this.gUr && LocalVideoActivity.this.gUn.bCP() != null) {
                        d up = e.up(LocalVideoActivity.this.gUq);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.gUq);
                        videoInfo.setVideoDuration(((int) up.getDuration()) / 1000);
                        videoInfo.setVideoWidth(up.getVideoWidth());
                        videoInfo.setVideoHeight(up.getVideoHeight());
                        videoInfo.setVideoLength(new File(up.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.gRb, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                    f bCD = LocalVideoActivity.this.bCD();
                    if (bCD != null && bCD.isConvertRunning()) {
                        LocalVideoActivity.this.bCG();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.gUs = false;
            LocalVideoActivity.this.bCF();
        }
    };
    private com.baidu.tieba.video.c gUz = new com.baidu.tieba.video.c() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.c
        public void bBh() {
        }

        @Override // com.baidu.tieba.video.c
        public void vn(int i) {
            LocalVideoActivity.this.gUy.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertSuccess() {
            LocalVideoActivity.this.gUy.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertFailed() {
            LocalVideoActivity.this.gUy.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.gUy.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertAborted() {
            LocalVideoActivity.this.gUy.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener gUA = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public f bCD() {
        if (this.gUp == null) {
            this.gUp = new f(this);
            this.gUp.a(this.gUz);
        }
        return this.gUp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCE() {
        this.gUn.amK();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null) {
            if (this.gUu == null) {
                this.gUu = new com.baidu.tieba.video.commonview.a(this);
            }
            if (this.gUu.getParent() == null) {
                relativeLayout.addView(this.gUu);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gUu.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.gUu.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.gUu.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCF() {
        this.gUn.bCM();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null && this.gUu.getParent() != null) {
            relativeLayout.removeView(this.gUu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCG() {
        bCD().abortConvert();
        this.gUt = true;
        if (this.gUq != null) {
            File file = new File(this.gUq);
            if (file.exists()) {
                file.delete();
            }
        }
        bCF();
        this.gUq = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bBj() {
        return f.bBj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nG(boolean z) {
        d up = e.up(this.gUq);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.gUq);
        videoInfo.setVideoDuration(((int) up.getDuration()) / 1000);
        videoInfo.setVideoWidth(up.getVideoWidth());
        videoInfo.setVideoHeight(up.getVideoHeight());
        videoInfo.setVideoLength(new File(up.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.gRb, videoInfo)));
        this.gUs = false;
        this.gUq = null;
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
            this.gRb = getIntent().getStringExtra("video_title");
        }
        this.gUn = new c(this, this.mOnClickListener);
        this.gUo = new LocalVideoModel(this);
        this.gUo.a(this.gUx);
        this.gUo.bCH();
        registerListener(this.gUw);
        registerListener(this.gUv);
        registerListener(this.gUA);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gUr = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gUr = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gUn != null) {
            this.gUn.bCN();
        }
        if (this.gUs && !TextUtils.isEmpty(this.gUq) && new File(this.gUq).exists()) {
            nG(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gUn != null) {
            this.gUn.amL();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gUn.amL();
        if (this.gUp != null) {
            this.gUp.destroy();
        }
        if (this.gUy != null) {
            this.gUy.removeMessages(5);
        }
    }
}
