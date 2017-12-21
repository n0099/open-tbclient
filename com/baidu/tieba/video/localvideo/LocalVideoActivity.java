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
    private String gRg;
    private c gUs;
    private LocalVideoModel gUt;
    private f gUu;
    private String gUv;
    private com.baidu.tieba.video.commonview.a gUz;
    private String mForumId;
    private String mForumName;
    private boolean gUw = false;
    private boolean gUx = false;
    private boolean gUy = false;
    private CustomMessageListener gUA = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.gUs != null) {
                    LocalVideoActivity.this.gUs.um(str);
                }
            }
        }
    };
    private CustomMessageListener gUB = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.gUt != null) {
                LocalVideoActivity.this.gUt.bCI();
            }
        }
    };
    private b.a gUC = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dP(List<d> list) {
            if (LocalVideoActivity.this.gUs != null) {
                LocalVideoActivity.this.gUs.dQ(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.gUs != null) {
                if (view != LocalVideoActivity.this.gUs.bCL()) {
                    if (view == LocalVideoActivity.this.gUs.bCM()) {
                        if (!LocalVideoActivity.this.gUs.bCJ()) {
                            if (LocalVideoActivity.this.gUs.bCQ() == null || LocalVideoActivity.this.gUs.bCQ().getDuration() <= 600000) {
                                f bCE = LocalVideoActivity.this.bCE();
                                if (!bCE.isConvertRunning()) {
                                    String bCP = LocalVideoActivity.this.gUs.bCP();
                                    if (TextUtils.isEmpty(bCP)) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bCP));
                                        return;
                                    } else if (!new File(bCP).exists()) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bCP));
                                        return;
                                    } else {
                                        int tV = e.tV(bCP);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bCQ = LocalVideoActivity.this.gUs.bCQ();
                                            if (bCQ != null) {
                                                LocalVideoActivity.this.gUs.amL();
                                                LocalVideoActivity.this.gUv = bCQ.getVideoPath();
                                                LocalVideoActivity.this.nG(false);
                                                return;
                                            }
                                            return;
                                        } else if (tV >= 1500000) {
                                            if (LocalVideoActivity.this.bBk()) {
                                                File file = new File(com.baidu.tieba.video.d.gPL, "tieba_" + e.tU(bCP) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.gUv = file.getAbsolutePath();
                                                bCE.setConvertType(1);
                                                bCE.cm(bCP, LocalVideoActivity.this.gUv);
                                                LocalVideoActivity.this.bCF();
                                                LocalVideoActivity.this.gUx = false;
                                                LocalVideoActivity.this.gUy = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bCQ2 = LocalVideoActivity.this.gUs.bCQ();
                                            if (bCQ2 != null) {
                                                if (bCQ2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.gUs.amL();
                                                    LocalVideoActivity.this.gUv = bCQ2.getVideoPath();
                                                    LocalVideoActivity.this.nG(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.d.gPL, "tieba_" + e.tU(bCP) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.gUv = file2.getAbsolutePath();
                                                bCE.setConvertType(2);
                                                bCE.cm(bCP, LocalVideoActivity.this.gUv);
                                                LocalVideoActivity.this.bCF();
                                                LocalVideoActivity.this.gUx = false;
                                                LocalVideoActivity.this.gUy = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.gUs.bCK();
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
    private Handler gUD = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.gUD.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.gUz != null && LocalVideoActivity.this.gUz.isShowing()) {
                        LocalVideoActivity.this.gUz.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.gUD.sendMessageDelayed(LocalVideoActivity.this.gUD.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.gUy) {
                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.gUx = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.gUv) && (file = new File(LocalVideoActivity.this.gUv)) != null) {
                        LocalVideoActivity.this.gUv = LocalVideoActivity.this.gUv.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.gUv));
                    }
                    LocalVideoActivity.this.bCG();
                    if (!LocalVideoActivity.this.gUw && LocalVideoActivity.this.gUs.bCQ() != null) {
                        d up = e.up(LocalVideoActivity.this.gUv);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.gUv);
                        videoInfo.setVideoDuration(((int) up.getDuration()) / 1000);
                        videoInfo.setVideoWidth(up.getVideoWidth());
                        videoInfo.setVideoHeight(up.getVideoHeight());
                        videoInfo.setVideoLength(new File(up.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.gRg, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                    f bCE = LocalVideoActivity.this.bCE();
                    if (bCE != null && bCE.isConvertRunning()) {
                        LocalVideoActivity.this.bCH();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.gUx = false;
            LocalVideoActivity.this.bCG();
        }
    };
    private com.baidu.tieba.video.c gUE = new com.baidu.tieba.video.c() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.c
        public void bBi() {
        }

        @Override // com.baidu.tieba.video.c
        public void vn(int i) {
            LocalVideoActivity.this.gUD.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertSuccess() {
            LocalVideoActivity.this.gUD.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertFailed() {
            LocalVideoActivity.this.gUD.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.gUD.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertAborted() {
            LocalVideoActivity.this.gUD.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener gUF = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public f bCE() {
        if (this.gUu == null) {
            this.gUu = new f(this);
            this.gUu.a(this.gUE);
        }
        return this.gUu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCF() {
        this.gUs.amL();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null) {
            if (this.gUz == null) {
                this.gUz = new com.baidu.tieba.video.commonview.a(this);
            }
            if (this.gUz.getParent() == null) {
                relativeLayout.addView(this.gUz);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gUz.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.gUz.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.gUz.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCG() {
        this.gUs.bCN();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null && this.gUz.getParent() != null) {
            relativeLayout.removeView(this.gUz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCH() {
        bCE().abortConvert();
        this.gUy = true;
        if (this.gUv != null) {
            File file = new File(this.gUv);
            if (file.exists()) {
                file.delete();
            }
        }
        bCG();
        this.gUv = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bBk() {
        return f.bBk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nG(boolean z) {
        d up = e.up(this.gUv);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.gUv);
        videoInfo.setVideoDuration(((int) up.getDuration()) / 1000);
        videoInfo.setVideoWidth(up.getVideoWidth());
        videoInfo.setVideoHeight(up.getVideoHeight());
        videoInfo.setVideoLength(new File(up.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.gRg, videoInfo)));
        this.gUx = false;
        this.gUv = null;
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
            this.gRg = getIntent().getStringExtra("video_title");
        }
        this.gUs = new c(this, this.mOnClickListener);
        this.gUt = new LocalVideoModel(this);
        this.gUt.a(this.gUC);
        this.gUt.bCI();
        registerListener(this.gUB);
        registerListener(this.gUA);
        registerListener(this.gUF);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gUw = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gUw = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gUs != null) {
            this.gUs.bCO();
        }
        if (this.gUx && !TextUtils.isEmpty(this.gUv) && new File(this.gUv).exists()) {
            nG(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gUs != null) {
            this.gUs.amM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gUs.amM();
        if (this.gUu != null) {
            this.gUu.destroy();
        }
        if (this.gUD != null) {
            this.gUD.removeMessages(5);
        }
    }
}
