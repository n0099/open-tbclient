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
    private String kwk;
    private c kzj;
    private LocalVideoModel kzk;
    private VideoConvertUtil kzl;
    private String kzm;
    private LocalVideoCompressingDialogView kzq;
    private String mForumId;
    private String mForumName;
    private boolean kzn = false;
    private boolean kzo = false;
    private boolean kzp = false;
    private CustomMessageListener kzr = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.kzj != null) {
                    LocalVideoActivity.this.kzj.Kh(str);
                }
            }
        }
    };
    private CustomMessageListener kzs = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.kzk != null) {
                LocalVideoActivity.this.kzk.cQC();
            }
        }
    };
    private b.a kzt = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void eq(List<d> list) {
            if (LocalVideoActivity.this.kzj != null) {
                LocalVideoActivity.this.kzj.er(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.kzj != null) {
                if (view != LocalVideoActivity.this.kzj.cQF()) {
                    if (view == LocalVideoActivity.this.kzj.cQG()) {
                        if (!LocalVideoActivity.this.kzj.cQD()) {
                            if (LocalVideoActivity.this.kzj.cQJ() == null || LocalVideoActivity.this.kzj.cQJ().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil cQy = LocalVideoActivity.this.cQy();
                                if (!cQy.isConvertRunning()) {
                                    String cQI = LocalVideoActivity.this.kzj.cQI();
                                    if (TextUtils.isEmpty(cQI)) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, cQI));
                                        return;
                                    } else if (!new File(cQI).exists()) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, cQI));
                                        return;
                                    } else {
                                        int JS = e.JS(cQI);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d cQJ = LocalVideoActivity.this.kzj.cQJ();
                                            if (cQJ != null) {
                                                LocalVideoActivity.this.kzj.bGh();
                                                LocalVideoActivity.this.kzm = cQJ.getVideoPath();
                                                LocalVideoActivity.this.tp(false);
                                                return;
                                            }
                                            return;
                                        } else if (JS >= 1500000) {
                                            if (LocalVideoActivity.this.cPe()) {
                                                File file = new File(com.baidu.tieba.video.e.kuQ, "tieba_" + e.JR(cQI) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.kzm = file.getAbsolutePath();
                                                cQy.setConvertType(1);
                                                cQy.eI(cQI, LocalVideoActivity.this.kzm);
                                                LocalVideoActivity.this.cQz();
                                                LocalVideoActivity.this.kzo = false;
                                                LocalVideoActivity.this.kzp = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d cQJ2 = LocalVideoActivity.this.kzj.cQJ();
                                            if (cQJ2 != null) {
                                                if (cQJ2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.kzj.bGh();
                                                    LocalVideoActivity.this.kzm = cQJ2.getVideoPath();
                                                    LocalVideoActivity.this.tp(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.kuQ, "tieba_" + e.JR(cQI) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.kzm = file2.getAbsolutePath();
                                                cQy.setConvertType(2);
                                                cQy.eI(cQI, LocalVideoActivity.this.kzm);
                                                LocalVideoActivity.this.cQz();
                                                LocalVideoActivity.this.kzo = false;
                                                LocalVideoActivity.this.kzp = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.kzj.cQE();
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
    private Handler kzu = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.kzu.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.kzq != null && LocalVideoActivity.this.kzq.isShowing()) {
                        LocalVideoActivity.this.kzq.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.kzu.sendMessageDelayed(LocalVideoActivity.this.kzu.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.kzp) {
                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.kzo = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.kzm) && (file = new File(LocalVideoActivity.this.kzm)) != null) {
                        LocalVideoActivity.this.kzm = LocalVideoActivity.this.kzm.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.kzm));
                    }
                    LocalVideoActivity.this.cQA();
                    if (!LocalVideoActivity.this.kzn && LocalVideoActivity.this.kzj.cQJ() != null) {
                        d Kj = e.Kj(LocalVideoActivity.this.kzm);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.kzm);
                        videoInfo.setVideoDuration(((int) Kj.getDuration()) / 1000);
                        videoInfo.setVideoWidth(Kj.getVideoWidth());
                        videoInfo.setVideoHeight(Kj.getVideoHeight());
                        videoInfo.setVideoLength(new File(Kj.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.kwk, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                    VideoConvertUtil cQy = LocalVideoActivity.this.cQy();
                    if (cQy != null && cQy.isConvertRunning()) {
                        LocalVideoActivity.this.cQB();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.kzo = false;
            LocalVideoActivity.this.cQA();
        }
    };
    private com.baidu.tieba.video.d kzv = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void cPa() {
        }

        @Override // com.baidu.tieba.video.d
        public void Dq(int i) {
            LocalVideoActivity.this.kzu.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.kzu.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.kzu.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.kzu.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.kzu.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener kzw = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil cQy() {
        if (this.kzl == null) {
            this.kzl = new VideoConvertUtil(this);
            this.kzl.a(this.kzv);
        }
        return this.kzl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQz() {
        this.kzj.bGh();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.kzq == null) {
                this.kzq = new LocalVideoCompressingDialogView(this);
            }
            if (this.kzq.getParent() == null) {
                relativeLayout.addView(this.kzq);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kzq.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.kzq.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.kzq.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQA() {
        this.kzj.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.kzq.getParent() != null) {
            relativeLayout.removeView(this.kzq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQB() {
        cQy().abortConvert();
        this.kzp = true;
        if (this.kzm != null) {
            File file = new File(this.kzm);
            if (file.exists()) {
                file.delete();
            }
        }
        cQA();
        this.kzm = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cPe() {
        return VideoConvertUtil.cPe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tp(boolean z) {
        d Kj = e.Kj(this.kzm);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kzm);
        videoInfo.setVideoDuration(((int) Kj.getDuration()) / 1000);
        videoInfo.setVideoWidth(Kj.getVideoWidth());
        videoInfo.setVideoHeight(Kj.getVideoHeight());
        videoInfo.setVideoLength(new File(Kj.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.kwk, videoInfo)));
        this.kzo = false;
        this.kzm = null;
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
            this.kwk = getIntent().getStringExtra("video_title");
        }
        this.kzj = new c(this, this.mOnClickListener);
        this.kzk = new LocalVideoModel(this);
        this.kzk.a(this.kzt);
        this.kzk.cQC();
        registerListener(this.kzs);
        registerListener(this.kzr);
        registerListener(this.kzw);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.kzn = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.kzn = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kzj != null) {
            this.kzj.cQH();
        }
        if (this.kzo && !TextUtils.isEmpty(this.kzm) && new File(this.kzm).exists()) {
            tp(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.kzj != null) {
            this.kzj.bGi();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kzj.bGi();
        if (this.kzl != null) {
            this.kzl.destroy();
        }
        if (this.kzu != null) {
            this.kzu.removeMessages(5);
        }
    }
}
