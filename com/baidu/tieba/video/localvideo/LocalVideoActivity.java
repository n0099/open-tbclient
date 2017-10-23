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
import com.baidu.tieba.video.localvideo.b;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String guL;
    private g guT;
    private com.baidu.tieba.video.commonview.a guX;
    private c gwv;
    private LocalVideoModel gww;
    private String gwx;
    private String mForumId;
    private String mForumName;
    private boolean guU = false;
    private boolean guV = false;
    private boolean guW = false;
    private CustomMessageListener gwy = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.gwv != null) {
                    LocalVideoActivity.this.gwv.sE(str);
                }
            }
        }
    };
    private CustomMessageListener gwz = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.gww != null) {
                LocalVideoActivity.this.gww.bwg();
            }
        }
    };
    private b.a gwA = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dA(List<d> list) {
            if (LocalVideoActivity.this.gwv != null) {
                LocalVideoActivity.this.gwv.dB(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.gwv != null) {
                if (view != LocalVideoActivity.this.gwv.bwi()) {
                    if (view == LocalVideoActivity.this.gwv.bwj()) {
                        if (LocalVideoActivity.this.gwv.bwn() == null || LocalVideoActivity.this.gwv.bwn().getDuration() <= 600000) {
                            g bvA = LocalVideoActivity.this.bvA();
                            if (!bvA.isConvertRunning()) {
                                String bwm = LocalVideoActivity.this.gwv.bwm();
                                if (TextUtils.isEmpty(bwm)) {
                                    l.showToast(LocalVideoActivity.this, d.l.mv_local_video_video_not_exist);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bwm));
                                    return;
                                } else if (!new File(bwm).exists()) {
                                    l.showToast(LocalVideoActivity.this, d.l.mv_local_video_video_not_exist);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bwm));
                                    return;
                                } else {
                                    int sH = e.sH(bwm);
                                    if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                        d bwn = LocalVideoActivity.this.gwv.bwn();
                                        if (bwn != null) {
                                            LocalVideoActivity.this.gwv.aik();
                                            LocalVideoActivity.this.gwx = bwn.getVideoPath();
                                            LocalVideoActivity.this.nc(false);
                                            return;
                                        }
                                        return;
                                    } else if (sH >= 1500000) {
                                        if (LocalVideoActivity.this.bwf()) {
                                            File file = new File(com.baidu.tieba.video.c.gtK, "tieba_" + e.sK(bwm) + "_tiebaconverting.mp4");
                                            LocalVideoActivity.this.gwx = file.getAbsolutePath();
                                            bvA.setConvertType(1);
                                            bvA.ck(bwm, LocalVideoActivity.this.gwx);
                                            LocalVideoActivity.this.bwe();
                                            LocalVideoActivity.this.guV = false;
                                            LocalVideoActivity.this.guW = false;
                                            return;
                                        }
                                        return;
                                    } else {
                                        d bwn2 = LocalVideoActivity.this.gwv.bwn();
                                        if (bwn2 != null) {
                                            if (bwn2.getDuration() >= 15000) {
                                                LocalVideoActivity.this.gwv.aik();
                                                LocalVideoActivity.this.gwx = bwn2.getVideoPath();
                                                LocalVideoActivity.this.nc(false);
                                                return;
                                            }
                                            File file2 = new File(com.baidu.tieba.video.c.gtK, "tieba_" + e.sK(bwm) + "_tiebaconverting.mp4");
                                            LocalVideoActivity.this.gwx = file2.getAbsolutePath();
                                            bvA.setConvertType(2);
                                            bvA.ck(bwm, LocalVideoActivity.this.gwx);
                                            LocalVideoActivity.this.bwe();
                                            LocalVideoActivity.this.guV = false;
                                            LocalVideoActivity.this.guW = false;
                                            return;
                                        }
                                        return;
                                    }
                                }
                            }
                            return;
                        }
                        LocalVideoActivity.this.gwv.bwh();
                        return;
                    }
                    return;
                }
                LocalVideoActivity.this.finish();
            }
        }
    };
    private Handler guY = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.guY.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.guX != null && LocalVideoActivity.this.guX.isShowing()) {
                        LocalVideoActivity.this.guX.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.guY.sendMessageDelayed(LocalVideoActivity.this.guY.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.guW) {
                        l.showToast(LocalVideoActivity.this, d.l.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.guV = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.gwx) && (file = new File(LocalVideoActivity.this.gwx)) != null) {
                        LocalVideoActivity.this.gwx = LocalVideoActivity.this.gwx.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.gwx));
                    }
                    LocalVideoActivity.this.bvy();
                    if (!LocalVideoActivity.this.guU && LocalVideoActivity.this.gwv.bwn() != null) {
                        d sJ = e.sJ(LocalVideoActivity.this.gwx);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.gwx);
                        videoInfo.setVideoDuration(((int) sJ.getDuration()) / 1000);
                        videoInfo.setVideoWidth(sJ.getVideoWidth());
                        videoInfo.setVideoHeight(sJ.getVideoHeight());
                        videoInfo.setVideoLength(new File(sJ.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.guL, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.l.mv_local_video_compress_failed);
                    g bvA = LocalVideoActivity.this.bvA();
                    if (bvA != null && bvA.isConvertRunning()) {
                        LocalVideoActivity.this.bvz();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.guV = false;
            LocalVideoActivity.this.bvy();
        }
    };
    private f guZ = new f() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.localvideo.f
        public void bvI() {
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void uv(int i) {
            LocalVideoActivity.this.guY.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertSuccess() {
            LocalVideoActivity.this.guY.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertFailed() {
            LocalVideoActivity.this.guY.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.guY.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertAborted() {
            LocalVideoActivity.this.guY.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener gwB = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public g bvA() {
        if (this.guT == null) {
            this.guT = new g(this);
            this.guT.a(this.guZ);
        }
        return this.guT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwe() {
        this.gwv.aik();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.h.container);
        if (relativeLayout != null) {
            if (this.guX == null) {
                this.guX = new com.baidu.tieba.video.commonview.a(this);
            }
            if (this.guX.getParent() == null) {
                relativeLayout.addView(this.guX);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.guX.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.guX.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.guX.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvy() {
        this.gwv.bwk();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.h.container);
        if (relativeLayout != null && this.guX.getParent() != null) {
            relativeLayout.removeView(this.guX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvz() {
        bvA().abortConvert();
        this.guW = true;
        if (this.gwx != null) {
            File file = new File(this.gwx);
            if (file.exists()) {
                file.delete();
            }
        }
        bvy();
        this.gwx = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bwf() {
        File file = new File(com.baidu.tieba.video.c.gtK);
        if (file != null) {
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.exists() && file.isDirectory()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nc(boolean z) {
        d sJ = e.sJ(this.gwx);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.gwx);
        videoInfo.setVideoDuration(((int) sJ.getDuration()) / 1000);
        videoInfo.setVideoWidth(sJ.getVideoWidth());
        videoInfo.setVideoHeight(sJ.getVideoHeight());
        videoInfo.setVideoLength(new File(sJ.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, this.mForumName, this.mForumId, this.guL, videoInfo)));
        this.guV = false;
        this.gwx = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.j.local_video_activity);
        if (getIntent() != null) {
            this.mForumId = getIntent().getStringExtra("forum_id");
            this.mForumName = getIntent().getStringExtra("forum_name");
            this.guL = getIntent().getStringExtra("video_title");
        }
        this.gwv = new c(this, this.mOnClickListener);
        this.gww = new LocalVideoModel(this);
        this.gww.a(this.gwA);
        this.gww.bwg();
        registerListener(this.gwz);
        registerListener(this.gwy);
        registerListener(this.gwB);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.guU = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.guU = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gwv != null) {
            this.gwv.bwl();
        }
        if (this.guV && !TextUtils.isEmpty(this.gwx) && new File(this.gwx).exists()) {
            nc(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gwv != null) {
            this.gwv.ail();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gwv.ail();
        if (this.guT != null) {
            this.guT.destroy();
        }
        if (this.guY != null) {
            this.guY.removeMessages(5);
        }
    }
}
