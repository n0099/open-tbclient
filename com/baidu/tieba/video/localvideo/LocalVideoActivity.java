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
    private com.baidu.tieba.video.commonview.a hBD;
    private c hBw;
    private LocalVideoModel hBx;
    private f hBy;
    private String hBz;
    private String hyi;
    private String mForumId;
    private String mForumName;
    private boolean hBA = false;
    private boolean hBB = false;
    private boolean hBC = false;
    private CustomMessageListener hBE = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.hBw != null) {
                    LocalVideoActivity.this.hBw.un(str);
                }
            }
        }
    };
    private CustomMessageListener hBF = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.hBx != null) {
                LocalVideoActivity.this.hBx.bIf();
            }
        }
    };
    private b.a hBG = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dV(List<d> list) {
            if (LocalVideoActivity.this.hBw != null) {
                LocalVideoActivity.this.hBw.dW(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.hBw != null) {
                if (view != LocalVideoActivity.this.hBw.bIi()) {
                    if (view == LocalVideoActivity.this.hBw.bIj()) {
                        if (!LocalVideoActivity.this.hBw.bIg()) {
                            if (LocalVideoActivity.this.hBw.bIn() == null || LocalVideoActivity.this.hBw.bIn().getDuration() <= 600000) {
                                f bIb = LocalVideoActivity.this.bIb();
                                if (!bIb.isConvertRunning()) {
                                    String bIm = LocalVideoActivity.this.hBw.bIm();
                                    if (TextUtils.isEmpty(bIm)) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bIm));
                                        return;
                                    } else if (!new File(bIm).exists()) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bIm));
                                        return;
                                    } else {
                                        int tW = e.tW(bIm);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bIn = LocalVideoActivity.this.hBw.bIn();
                                            if (bIn != null) {
                                                LocalVideoActivity.this.hBw.aus();
                                                LocalVideoActivity.this.hBz = bIn.getVideoPath();
                                                LocalVideoActivity.this.oa(false);
                                                return;
                                            }
                                            return;
                                        } else if (tW >= 1500000) {
                                            if (LocalVideoActivity.this.bGH()) {
                                                File file = new File(com.baidu.tieba.video.d.hwJ, "tieba_" + e.tV(bIm) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hBz = file.getAbsolutePath();
                                                bIb.setConvertType(1);
                                                bIb.cn(bIm, LocalVideoActivity.this.hBz);
                                                LocalVideoActivity.this.bIc();
                                                LocalVideoActivity.this.hBB = false;
                                                LocalVideoActivity.this.hBC = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bIn2 = LocalVideoActivity.this.hBw.bIn();
                                            if (bIn2 != null) {
                                                if (bIn2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.hBw.aus();
                                                    LocalVideoActivity.this.hBz = bIn2.getVideoPath();
                                                    LocalVideoActivity.this.oa(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.d.hwJ, "tieba_" + e.tV(bIm) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hBz = file2.getAbsolutePath();
                                                bIb.setConvertType(2);
                                                bIb.cn(bIm, LocalVideoActivity.this.hBz);
                                                LocalVideoActivity.this.bIc();
                                                LocalVideoActivity.this.hBB = false;
                                                LocalVideoActivity.this.hBC = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.hBw.bIh();
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
    private Handler hBH = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.hBH.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.hBD != null && LocalVideoActivity.this.hBD.isShowing()) {
                        LocalVideoActivity.this.hBD.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.hBH.sendMessageDelayed(LocalVideoActivity.this.hBH.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.hBC) {
                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.hBB = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.hBz) && (file = new File(LocalVideoActivity.this.hBz)) != null) {
                        LocalVideoActivity.this.hBz = LocalVideoActivity.this.hBz.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.hBz));
                    }
                    LocalVideoActivity.this.bId();
                    if (!LocalVideoActivity.this.hBA && LocalVideoActivity.this.hBw.bIn() != null) {
                        d uq = e.uq(LocalVideoActivity.this.hBz);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.hBz);
                        videoInfo.setVideoDuration(((int) uq.getDuration()) / 1000);
                        videoInfo.setVideoWidth(uq.getVideoWidth());
                        videoInfo.setVideoHeight(uq.getVideoHeight());
                        videoInfo.setVideoLength(new File(uq.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.hyi, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                    f bIb = LocalVideoActivity.this.bIb();
                    if (bIb != null && bIb.isConvertRunning()) {
                        LocalVideoActivity.this.bIe();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.hBB = false;
            LocalVideoActivity.this.bId();
        }
    };
    private com.baidu.tieba.video.c hBI = new com.baidu.tieba.video.c() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.c
        public void bGD() {
        }

        @Override // com.baidu.tieba.video.c
        public void yb(int i) {
            LocalVideoActivity.this.hBH.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertSuccess() {
            LocalVideoActivity.this.hBH.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertFailed() {
            LocalVideoActivity.this.hBH.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.hBH.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.c
        public void onConvertAborted() {
            LocalVideoActivity.this.hBH.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener hBJ = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public f bIb() {
        if (this.hBy == null) {
            this.hBy = new f(this);
            this.hBy.a(this.hBI);
        }
        return this.hBy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIc() {
        this.hBw.aus();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null) {
            if (this.hBD == null) {
                this.hBD = new com.baidu.tieba.video.commonview.a(this);
            }
            if (this.hBD.getParent() == null) {
                relativeLayout.addView(this.hBD);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hBD.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.hBD.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hBD.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bId() {
        this.hBw.bIk();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null && this.hBD.getParent() != null) {
            relativeLayout.removeView(this.hBD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIe() {
        bIb().abortConvert();
        this.hBC = true;
        if (this.hBz != null) {
            File file = new File(this.hBz);
            if (file.exists()) {
                file.delete();
            }
        }
        bId();
        this.hBz = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bGH() {
        return f.bGH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oa(boolean z) {
        d uq = e.uq(this.hBz);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hBz);
        videoInfo.setVideoDuration(((int) uq.getDuration()) / 1000);
        videoInfo.setVideoWidth(uq.getVideoWidth());
        videoInfo.setVideoHeight(uq.getVideoHeight());
        videoInfo.setVideoLength(new File(uq.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.hyi, videoInfo)));
        this.hBB = false;
        this.hBz = null;
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
            this.hyi = getIntent().getStringExtra("video_title");
        }
        this.hBw = new c(this, this.mOnClickListener);
        this.hBx = new LocalVideoModel(this);
        this.hBx.a(this.hBG);
        this.hBx.bIf();
        registerListener(this.hBF);
        registerListener(this.hBE);
        registerListener(this.hBJ);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.hBA = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hBA = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hBw != null) {
            this.hBw.bIl();
        }
        if (this.hBB && !TextUtils.isEmpty(this.hBz) && new File(this.hBz).exists()) {
            oa(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hBw != null) {
            this.hBw.aut();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hBw.aut();
        if (this.hBy != null) {
            this.hBy.destroy();
        }
        if (this.hBH != null) {
            this.hBH.removeMessages(5);
        }
    }
}
