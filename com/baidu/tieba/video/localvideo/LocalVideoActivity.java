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
    private String gEL;
    private g gEU;
    private com.baidu.tieba.video.commonview.a gEY;
    private c gHh;
    private LocalVideoModel gHi;
    private String gHj;
    private String mForumId;
    private String mForumName;
    private boolean gEV = false;
    private boolean gEW = false;
    private boolean gEX = false;
    private CustomMessageListener gHk = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.gHh != null) {
                    LocalVideoActivity.this.gHh.tw(str);
                }
            }
        }
    };
    private CustomMessageListener gHl = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.gHi != null) {
                LocalVideoActivity.this.gHi.bzE();
            }
        }
    };
    private b.a gHm = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dD(List<d> list) {
            if (LocalVideoActivity.this.gHh != null) {
                LocalVideoActivity.this.gHh.dE(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.gHh != null) {
                if (view != LocalVideoActivity.this.gHh.bzH()) {
                    if (view == LocalVideoActivity.this.gHh.bzI()) {
                        if (!LocalVideoActivity.this.gHh.bzF()) {
                            if (LocalVideoActivity.this.gHh.bzM() == null || LocalVideoActivity.this.gHh.bzM().getDuration() <= 600000) {
                                g byP = LocalVideoActivity.this.byP();
                                if (!byP.isConvertRunning()) {
                                    String bzL = LocalVideoActivity.this.gHh.bzL();
                                    if (TextUtils.isEmpty(bzL)) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bzL));
                                        return;
                                    } else if (!new File(bzL).exists()) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bzL));
                                        return;
                                    } else {
                                        int tz = e.tz(bzL);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bzM = LocalVideoActivity.this.gHh.bzM();
                                            if (bzM != null) {
                                                LocalVideoActivity.this.gHh.akG();
                                                LocalVideoActivity.this.gHj = bzM.getVideoPath();
                                                LocalVideoActivity.this.nf(false);
                                                return;
                                            }
                                            return;
                                        } else if (tz >= 1500000) {
                                            if (LocalVideoActivity.this.bzD()) {
                                                File file = new File(com.baidu.tieba.video.c.gDF, "tieba_" + e.tC(bzL) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.gHj = file.getAbsolutePath();
                                                byP.setConvertType(1);
                                                byP.cl(bzL, LocalVideoActivity.this.gHj);
                                                LocalVideoActivity.this.bzC();
                                                LocalVideoActivity.this.gEW = false;
                                                LocalVideoActivity.this.gEX = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bzM2 = LocalVideoActivity.this.gHh.bzM();
                                            if (bzM2 != null) {
                                                if (bzM2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.gHh.akG();
                                                    LocalVideoActivity.this.gHj = bzM2.getVideoPath();
                                                    LocalVideoActivity.this.nf(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.c.gDF, "tieba_" + e.tC(bzL) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.gHj = file2.getAbsolutePath();
                                                byP.setConvertType(2);
                                                byP.cl(bzL, LocalVideoActivity.this.gHj);
                                                LocalVideoActivity.this.bzC();
                                                LocalVideoActivity.this.gEW = false;
                                                LocalVideoActivity.this.gEX = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.gHh.bzG();
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
    private Handler gEZ = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.gEZ.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.gEY != null && LocalVideoActivity.this.gEY.isShowing()) {
                        LocalVideoActivity.this.gEY.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.gEZ.sendMessageDelayed(LocalVideoActivity.this.gEZ.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.gEX) {
                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.gEW = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.gHj) && (file = new File(LocalVideoActivity.this.gHj)) != null) {
                        LocalVideoActivity.this.gHj = LocalVideoActivity.this.gHj.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.gHj));
                    }
                    LocalVideoActivity.this.byN();
                    if (!LocalVideoActivity.this.gEV && LocalVideoActivity.this.gHh.bzM() != null) {
                        d tB = e.tB(LocalVideoActivity.this.gHj);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.gHj);
                        videoInfo.setVideoDuration(((int) tB.getDuration()) / 1000);
                        videoInfo.setVideoWidth(tB.getVideoWidth());
                        videoInfo.setVideoHeight(tB.getVideoHeight());
                        videoInfo.setVideoLength(new File(tB.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.gEL, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                    g byP = LocalVideoActivity.this.byP();
                    if (byP != null && byP.isConvertRunning()) {
                        LocalVideoActivity.this.byO();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.gEW = false;
            LocalVideoActivity.this.byN();
        }
    };
    private f gFa = new f() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.localvideo.f
        public void byZ() {
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void uQ(int i) {
            LocalVideoActivity.this.gEZ.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertSuccess() {
            LocalVideoActivity.this.gEZ.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertFailed() {
            LocalVideoActivity.this.gEZ.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.gEZ.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertAborted() {
            LocalVideoActivity.this.gEZ.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener gHn = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public g byP() {
        if (this.gEU == null) {
            this.gEU = new g(this);
            this.gEU.a(this.gFa);
        }
        return this.gEU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzC() {
        this.gHh.akG();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null) {
            if (this.gEY == null) {
                this.gEY = new com.baidu.tieba.video.commonview.a(this);
            }
            if (this.gEY.getParent() == null) {
                relativeLayout.addView(this.gEY);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gEY.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.gEY.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.gEY.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byN() {
        this.gHh.bzJ();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null && this.gEY.getParent() != null) {
            relativeLayout.removeView(this.gEY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byO() {
        byP().abortConvert();
        this.gEX = true;
        if (this.gHj != null) {
            File file = new File(this.gHj);
            if (file.exists()) {
                file.delete();
            }
        }
        byN();
        this.gHj = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzD() {
        File file = new File(com.baidu.tieba.video.c.gDF);
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
    public void nf(boolean z) {
        d tB = e.tB(this.gHj);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.gHj);
        videoInfo.setVideoDuration(((int) tB.getDuration()) / 1000);
        videoInfo.setVideoWidth(tB.getVideoWidth());
        videoInfo.setVideoHeight(tB.getVideoHeight());
        videoInfo.setVideoLength(new File(tB.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, this.mForumName, this.mForumId, this.gEL, videoInfo)));
        this.gEW = false;
        this.gHj = null;
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
            this.gEL = getIntent().getStringExtra("video_title");
        }
        this.gHh = new c(this, this.mOnClickListener);
        this.gHi = new LocalVideoModel(this);
        this.gHi.a(this.gHm);
        this.gHi.bzE();
        registerListener(this.gHl);
        registerListener(this.gHk);
        registerListener(this.gHn);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gEV = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gEV = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gHh != null) {
            this.gHh.bzK();
        }
        if (this.gEW && !TextUtils.isEmpty(this.gHj) && new File(this.gHj).exists()) {
            nf(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gHh != null) {
            this.gHh.akH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gHh.akH();
        if (this.gEU != null) {
            this.gEU.destroy();
        }
        if (this.gEZ != null) {
            this.gEZ.removeMessages(5);
        }
    }
}
