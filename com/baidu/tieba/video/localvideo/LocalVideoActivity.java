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
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.video.commonview.LocalVideoCompressingDialogView;
import com.baidu.tieba.video.localvideo.b;
import java.io.File;
import java.util.List;
/* loaded from: classes10.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private c kBe;
    private LocalVideoModel kBf;
    private VideoConvertUtil kBg;
    private String kBh;
    private LocalVideoCompressingDialogView kBl;
    private String kyd;
    private String mForumId;
    private String mForumName;
    private boolean kBi = false;
    private boolean kBj = false;
    private boolean kBk = false;
    private CustomMessageListener kBm = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.kBe != null) {
                    LocalVideoActivity.this.kBe.Ki(str);
                }
            }
        }
    };
    private CustomMessageListener kBn = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.kBf != null) {
                LocalVideoActivity.this.kBf.cQZ();
            }
        }
    };
    private b.a kBo = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void eq(List<d> list) {
            if (LocalVideoActivity.this.kBe != null) {
                LocalVideoActivity.this.kBe.er(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.kBe != null) {
                if (view != LocalVideoActivity.this.kBe.cRc()) {
                    if (view == LocalVideoActivity.this.kBe.cRd()) {
                        if (!LocalVideoActivity.this.kBe.cRa()) {
                            if (LocalVideoActivity.this.kBe.cRg() == null || LocalVideoActivity.this.kBe.cRg().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil cQV = LocalVideoActivity.this.cQV();
                                if (!cQV.isConvertRunning()) {
                                    String cRf = LocalVideoActivity.this.kBe.cRf();
                                    if (TextUtils.isEmpty(cRf)) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, cRf));
                                        return;
                                    } else if (!new File(cRf).exists()) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, cRf));
                                        return;
                                    } else {
                                        int JT = e.JT(cRf);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d cRg = LocalVideoActivity.this.kBe.cRg();
                                            if (cRg != null) {
                                                LocalVideoActivity.this.kBe.bGw();
                                                LocalVideoActivity.this.kBh = cRg.getVideoPath();
                                                LocalVideoActivity.this.tv(false);
                                                return;
                                            }
                                            return;
                                        } else if (JT >= 1500000) {
                                            if (LocalVideoActivity.this.cPB()) {
                                                File file = new File(com.baidu.tieba.video.e.kwI, "tieba_" + e.JS(cRf) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.kBh = file.getAbsolutePath();
                                                cQV.setConvertType(1);
                                                cQV.eG(cRf, LocalVideoActivity.this.kBh);
                                                LocalVideoActivity.this.cQW();
                                                LocalVideoActivity.this.kBj = false;
                                                LocalVideoActivity.this.kBk = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d cRg2 = LocalVideoActivity.this.kBe.cRg();
                                            if (cRg2 != null) {
                                                if (cRg2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.kBe.bGw();
                                                    LocalVideoActivity.this.kBh = cRg2.getVideoPath();
                                                    LocalVideoActivity.this.tv(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.kwI, "tieba_" + e.JS(cRf) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.kBh = file2.getAbsolutePath();
                                                cQV.setConvertType(2);
                                                cQV.eG(cRf, LocalVideoActivity.this.kBh);
                                                LocalVideoActivity.this.cQW();
                                                LocalVideoActivity.this.kBj = false;
                                                LocalVideoActivity.this.kBk = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.kBe.cRb();
                            return;
                        }
                        l.showToast(LocalVideoActivity.this, (int) R.string.show_video_file_error);
                        return;
                    }
                    return;
                }
                LocalVideoActivity.this.finish();
            }
        }
    };
    private Handler kBp = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.kBp.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.kBl != null && LocalVideoActivity.this.kBl.isShowing()) {
                        LocalVideoActivity.this.kBl.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.kBp.sendMessageDelayed(LocalVideoActivity.this.kBp.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.kBk) {
                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.kBj = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.kBh) && (file = new File(LocalVideoActivity.this.kBh)) != null) {
                        LocalVideoActivity.this.kBh = LocalVideoActivity.this.kBh.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.kBh));
                    }
                    LocalVideoActivity.this.cQX();
                    if (!LocalVideoActivity.this.kBi && LocalVideoActivity.this.kBe.cRg() != null) {
                        d Kk = e.Kk(LocalVideoActivity.this.kBh);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.kBh);
                        videoInfo.setVideoDuration(((int) Kk.getDuration()) / 1000);
                        videoInfo.setVideoWidth(Kk.getVideoWidth());
                        videoInfo.setVideoHeight(Kk.getVideoHeight());
                        videoInfo.setVideoLength(new File(Kk.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.kyd, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                    VideoConvertUtil cQV = LocalVideoActivity.this.cQV();
                    if (cQV != null && cQV.isConvertRunning()) {
                        LocalVideoActivity.this.cQY();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.kBj = false;
            LocalVideoActivity.this.cQX();
        }
    };
    private com.baidu.tieba.video.d kBq = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void cPx() {
        }

        @Override // com.baidu.tieba.video.d
        public void Dy(int i) {
            LocalVideoActivity.this.kBp.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.kBp.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.kBp.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.kBp.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.kBp.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener kBr = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil cQV() {
        if (this.kBg == null) {
            this.kBg = new VideoConvertUtil(this);
            this.kBg.a(this.kBq);
        }
        return this.kBg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQW() {
        this.kBe.bGw();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.kBl == null) {
                this.kBl = new LocalVideoCompressingDialogView(this);
            }
            if (this.kBl.getParent() == null) {
                relativeLayout.addView(this.kBl);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kBl.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.kBl.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.kBl.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQX() {
        this.kBe.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.kBl.getParent() != null) {
            relativeLayout.removeView(this.kBl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQY() {
        cQV().abortConvert();
        this.kBk = true;
        if (this.kBh != null) {
            File file = new File(this.kBh);
            if (file.exists()) {
                file.delete();
            }
        }
        cQX();
        this.kBh = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cPB() {
        return VideoConvertUtil.cPB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tv(boolean z) {
        d Kk = e.Kk(this.kBh);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kBh);
        videoInfo.setVideoDuration(((int) Kk.getDuration()) / 1000);
        videoInfo.setVideoWidth(Kk.getVideoWidth());
        videoInfo.setVideoHeight(Kk.getVideoHeight());
        videoInfo.setVideoLength(new File(Kk.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.kyd, videoInfo)));
        this.kBj = false;
        this.kBh = null;
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
            this.kyd = getIntent().getStringExtra("video_title");
        }
        this.kBe = new c(this, this.mOnClickListener);
        this.kBf = new LocalVideoModel(this);
        this.kBf.a(this.kBo);
        this.kBf.cQZ();
        registerListener(this.kBn);
        registerListener(this.kBm);
        registerListener(this.kBr);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.kBi = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.kBi = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kBe != null) {
            this.kBe.cRe();
        }
        if (this.kBj && !TextUtils.isEmpty(this.kBh) && new File(this.kBh).exists()) {
            tv(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.kBe != null) {
            this.kBe.bGx();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kBe.bGx();
        if (this.kBg != null) {
            this.kBg.destroy();
        }
        if (this.kBp != null) {
            this.kBp.removeMessages(5);
        }
    }
}
