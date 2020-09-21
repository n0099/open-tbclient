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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.video.commonview.LocalVideoCompressingDialogView;
import com.baidu.tieba.video.localvideo.b;
import java.io.File;
import java.util.List;
/* loaded from: classes22.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String mFg;
    private String mForumId;
    private String mForumName;
    private LocalVideoCompressingDialogView mIC;
    private c mIv;
    private LocalVideoModel mIw;
    private VideoConvertUtil mIx;
    private String mIy;
    private boolean mIz = false;
    private boolean mIA = false;
    private boolean mIB = false;
    private CustomMessageListener mIE = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.mIv != null) {
                    LocalVideoActivity.this.mIv.Ss(str);
                }
            }
        }
    };
    private CustomMessageListener mIF = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.mIw != null) {
                LocalVideoActivity.this.mIw.dGv();
            }
        }
    };
    private b.a mIG = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void fy(List<d> list) {
            if (LocalVideoActivity.this.mIv != null) {
                LocalVideoActivity.this.mIv.fz(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.mIv != null) {
                if (view != LocalVideoActivity.this.mIv.dGy()) {
                    if (view == LocalVideoActivity.this.mIv.dGz()) {
                        if (!LocalVideoActivity.this.mIv.dGw()) {
                            if (LocalVideoActivity.this.mIv.dGC() == null || LocalVideoActivity.this.mIv.dGC().getDuration() <= 600000) {
                                VideoConvertUtil dGr = LocalVideoActivity.this.dGr();
                                if (!dGr.isConvertRunning()) {
                                    String dGB = LocalVideoActivity.this.mIv.dGB();
                                    if (TextUtils.isEmpty(dGB)) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dGB));
                                        return;
                                    } else if (!new File(dGB).exists()) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dGB));
                                        return;
                                    } else {
                                        int Sb = e.Sb(dGB);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d dGC = LocalVideoActivity.this.mIv.dGC();
                                            if (dGC != null) {
                                                LocalVideoActivity.this.mIv.crW();
                                                LocalVideoActivity.this.mIy = dGC.getVideoPath();
                                                LocalVideoActivity.this.wQ(false);
                                                return;
                                            }
                                            return;
                                        } else if (Sb >= 1500000) {
                                            if (LocalVideoActivity.this.dEX()) {
                                                File file = new File(com.baidu.tieba.video.e.mDI, "tieba_" + e.Sa(dGB) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.mIy = file.getAbsolutePath();
                                                dGr.setConvertType(1);
                                                dGr.gj(dGB, LocalVideoActivity.this.mIy);
                                                LocalVideoActivity.this.dGs();
                                                LocalVideoActivity.this.mIA = false;
                                                LocalVideoActivity.this.mIB = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d dGC2 = LocalVideoActivity.this.mIv.dGC();
                                            if (dGC2 != null) {
                                                if (dGC2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.mIv.crW();
                                                    LocalVideoActivity.this.mIy = dGC2.getVideoPath();
                                                    LocalVideoActivity.this.wQ(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.mDI, "tieba_" + e.Sa(dGB) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.mIy = file2.getAbsolutePath();
                                                dGr.setConvertType(2);
                                                dGr.gj(dGB, LocalVideoActivity.this.mIy);
                                                LocalVideoActivity.this.dGs();
                                                LocalVideoActivity.this.mIA = false;
                                                LocalVideoActivity.this.mIB = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.mIv.dGx();
                            return;
                        }
                        l.showToast(LocalVideoActivity.this, R.string.show_video_file_error);
                        return;
                    }
                    return;
                }
                LocalVideoActivity.this.finish();
            }
        }
    };
    private Handler mIH = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.mIH.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.mIC != null && LocalVideoActivity.this.mIC.isShowing()) {
                        LocalVideoActivity.this.mIC.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.mIH.sendMessageDelayed(LocalVideoActivity.this.mIH.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.mIB) {
                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.mIA = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.mIy) && (file = new File(LocalVideoActivity.this.mIy)) != null) {
                        LocalVideoActivity.this.mIy = LocalVideoActivity.this.mIy.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.mIy));
                    }
                    LocalVideoActivity.this.dGt();
                    if (!LocalVideoActivity.this.mIz && LocalVideoActivity.this.mIv.dGC() != null) {
                        d Sv = e.Sv(LocalVideoActivity.this.mIy);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.mIy);
                        videoInfo.setVideoDuration(((int) Sv.getDuration()) / 1000);
                        videoInfo.setVideoWidth(Sv.getVideoWidth());
                        videoInfo.setVideoHeight(Sv.getVideoHeight());
                        videoInfo.setVideoLength(new File(Sv.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.mFg, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                    VideoConvertUtil dGr = LocalVideoActivity.this.dGr();
                    if (dGr != null && dGr.isConvertRunning()) {
                        LocalVideoActivity.this.dGu();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.mIA = false;
            LocalVideoActivity.this.dGt();
        }
    };
    private com.baidu.tieba.video.d mII = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void dES() {
        }

        @Override // com.baidu.tieba.video.d
        public void Jn(int i) {
            LocalVideoActivity.this.mIH.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.mIH.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.mIH.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.mIH.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.mIH.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener mIJ = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil dGr() {
        if (this.mIx == null) {
            this.mIx = new VideoConvertUtil(this);
            this.mIx.a(this.mII);
        }
        return this.mIx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGs() {
        this.mIv.crW();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.mIC == null) {
                this.mIC = new LocalVideoCompressingDialogView(this);
            }
            if (this.mIC.getParent() == null) {
                relativeLayout.addView(this.mIC);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mIC.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.mIC.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.mIC.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGt() {
        this.mIv.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.mIC.getParent() != null) {
            relativeLayout.removeView(this.mIC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGu() {
        dGr().abortConvert();
        this.mIB = true;
        if (this.mIy != null) {
            File file = new File(this.mIy);
            if (file.exists()) {
                file.delete();
            }
        }
        dGt();
        this.mIy = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dEX() {
        return VideoConvertUtil.dEX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wQ(boolean z) {
        d Sv = e.Sv(this.mIy);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.mIy);
        videoInfo.setVideoDuration(((int) Sv.getDuration()) / 1000);
        videoInfo.setVideoWidth(Sv.getVideoWidth());
        videoInfo.setVideoHeight(Sv.getVideoHeight());
        videoInfo.setVideoLength(new File(Sv.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.mFg, videoInfo)));
        this.mIA = false;
        this.mIy = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(R.layout.local_video_activity);
        if (getIntent() != null) {
            this.mForumId = getIntent().getStringExtra("forum_id");
            this.mForumName = getIntent().getStringExtra("forum_name");
            this.mFg = getIntent().getStringExtra("video_title");
        }
        this.mIv = new c(this, this.mOnClickListener);
        this.mIw = new LocalVideoModel(this);
        this.mIw.a(this.mIG);
        this.mIw.dGv();
        registerListener(this.mIF);
        registerListener(this.mIE);
        registerListener(this.mIJ);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mIz = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mIz = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mIv != null) {
            this.mIv.dGA();
        }
        if (this.mIA && !TextUtils.isEmpty(this.mIy) && new File(this.mIy).exists()) {
            wQ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.mIv != null) {
            this.mIv.crX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mIv.crX();
        if (this.mIx != null) {
            this.mIx.destroy();
        }
        if (this.mIH != null) {
            this.mIH.removeMessages(5);
        }
    }
}
