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
    private String gOt;
    private c gRE;
    private LocalVideoModel gRF;
    private f gRG;
    private String gRH;
    private com.baidu.tieba.video.commonview.a gRL;
    private String mForumId;
    private String mForumName;
    private boolean gRI = false;
    private boolean gRJ = false;
    private boolean gRK = false;
    private CustomMessageListener gRM = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.gRE != null) {
                    LocalVideoActivity.this.gRE.uh(str);
                }
            }
        }
    };
    private CustomMessageListener gRN = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.gRF != null) {
                LocalVideoActivity.this.gRF.bCc();
            }
        }
    };
    private b.a gRO = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dQ(List<d> list) {
            if (LocalVideoActivity.this.gRE != null) {
                LocalVideoActivity.this.gRE.dR(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.gRE != null) {
                if (view != LocalVideoActivity.this.gRE.bCf()) {
                    if (view == LocalVideoActivity.this.gRE.bCg()) {
                        if (!LocalVideoActivity.this.gRE.bCd()) {
                            if (LocalVideoActivity.this.gRE.bCk() == null || LocalVideoActivity.this.gRE.bCk().getDuration() <= 600000) {
                                f bBY = LocalVideoActivity.this.bBY();
                                if (!bBY.isConvertRunning()) {
                                    String bCj = LocalVideoActivity.this.gRE.bCj();
                                    if (TextUtils.isEmpty(bCj)) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bCj));
                                        return;
                                    } else if (!new File(bCj).exists()) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bCj));
                                        return;
                                    } else {
                                        int tQ = e.tQ(bCj);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bCk = LocalVideoActivity.this.gRE.bCk();
                                            if (bCk != null) {
                                                LocalVideoActivity.this.gRE.amC();
                                                LocalVideoActivity.this.gRH = bCk.getVideoPath();
                                                LocalVideoActivity.this.nE(false);
                                                return;
                                            }
                                            return;
                                        } else if (tQ >= 1500000) {
                                            if (LocalVideoActivity.this.bAD()) {
                                                File file = new File(com.baidu.tieba.video.d.gMY, "tieba_" + e.tP(bCj) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.gRH = file.getAbsolutePath();
                                                bBY.setConvertType(1);
                                                bBY.cl(bCj, LocalVideoActivity.this.gRH);
                                                LocalVideoActivity.this.bBZ();
                                                LocalVideoActivity.this.gRJ = false;
                                                LocalVideoActivity.this.gRK = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bCk2 = LocalVideoActivity.this.gRE.bCk();
                                            if (bCk2 != null) {
                                                if (bCk2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.gRE.amC();
                                                    LocalVideoActivity.this.gRH = bCk2.getVideoPath();
                                                    LocalVideoActivity.this.nE(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.d.gMY, "tieba_" + e.tP(bCj) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.gRH = file2.getAbsolutePath();
                                                bBY.setConvertType(2);
                                                bBY.cl(bCj, LocalVideoActivity.this.gRH);
                                                LocalVideoActivity.this.bBZ();
                                                LocalVideoActivity.this.gRJ = false;
                                                LocalVideoActivity.this.gRK = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.gRE.bCe();
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
    private Handler gRP = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.gRP.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.gRL != null && LocalVideoActivity.this.gRL.isShowing()) {
                        LocalVideoActivity.this.gRL.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.gRP.sendMessageDelayed(LocalVideoActivity.this.gRP.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.gRK) {
                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.gRJ = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.gRH) && (file = new File(LocalVideoActivity.this.gRH)) != null) {
                        LocalVideoActivity.this.gRH = LocalVideoActivity.this.gRH.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.gRH));
                    }
                    LocalVideoActivity.this.bCa();
                    if (!LocalVideoActivity.this.gRI && LocalVideoActivity.this.gRE.bCk() != null) {
                        d uk = e.uk(LocalVideoActivity.this.gRH);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.gRH);
                        videoInfo.setVideoDuration(((int) uk.getDuration()) / 1000);
                        videoInfo.setVideoWidth(uk.getVideoWidth());
                        videoInfo.setVideoHeight(uk.getVideoHeight());
                        videoInfo.setVideoLength(new File(uk.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.gOt, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                    f bBY = LocalVideoActivity.this.bBY();
                    if (bBY != null && bBY.isConvertRunning()) {
                        LocalVideoActivity.this.bCb();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.gRJ = false;
            LocalVideoActivity.this.bCa();
        }
    };
    private com.baidu.tieba.video.c gRQ = new com.baidu.tieba.video.c() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.c
        public void bAB() {
        }

        @Override // com.baidu.tieba.video.c
        public void vc(int i) {
            LocalVideoActivity.this.gRP.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertSuccess() {
            LocalVideoActivity.this.gRP.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertFailed() {
            LocalVideoActivity.this.gRP.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.gRP.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertAborted() {
            LocalVideoActivity.this.gRP.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener gRR = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public f bBY() {
        if (this.gRG == null) {
            this.gRG = new f(this);
            this.gRG.a(this.gRQ);
        }
        return this.gRG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBZ() {
        this.gRE.amC();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null) {
            if (this.gRL == null) {
                this.gRL = new com.baidu.tieba.video.commonview.a(this);
            }
            if (this.gRL.getParent() == null) {
                relativeLayout.addView(this.gRL);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gRL.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.gRL.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.gRL.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCa() {
        this.gRE.bCh();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null && this.gRL.getParent() != null) {
            relativeLayout.removeView(this.gRL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCb() {
        bBY().abortConvert();
        this.gRK = true;
        if (this.gRH != null) {
            File file = new File(this.gRH);
            if (file.exists()) {
                file.delete();
            }
        }
        bCa();
        this.gRH = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAD() {
        return f.bAD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nE(boolean z) {
        d uk = e.uk(this.gRH);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.gRH);
        videoInfo.setVideoDuration(((int) uk.getDuration()) / 1000);
        videoInfo.setVideoWidth(uk.getVideoWidth());
        videoInfo.setVideoHeight(uk.getVideoHeight());
        videoInfo.setVideoLength(new File(uk.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, this.mForumName, this.mForumId, this.gOt, videoInfo)));
        this.gRJ = false;
        this.gRH = null;
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
            this.gOt = getIntent().getStringExtra("video_title");
        }
        this.gRE = new c(this, this.mOnClickListener);
        this.gRF = new LocalVideoModel(this);
        this.gRF.a(this.gRO);
        this.gRF.bCc();
        registerListener(this.gRN);
        registerListener(this.gRM);
        registerListener(this.gRR);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gRI = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gRI = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gRE != null) {
            this.gRE.bCi();
        }
        if (this.gRJ && !TextUtils.isEmpty(this.gRH) && new File(this.gRH).exists()) {
            nE(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gRE != null) {
            this.gRE.amD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gRE.amD();
        if (this.gRG != null) {
            this.gRG.destroy();
        }
        if (this.gRP != null) {
            this.gRP.removeMessages(5);
        }
    }
}
