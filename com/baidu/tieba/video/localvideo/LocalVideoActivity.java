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
    private String kwm;
    private c kzl;
    private LocalVideoModel kzm;
    private VideoConvertUtil kzn;
    private String kzo;
    private LocalVideoCompressingDialogView kzs;
    private String mForumId;
    private String mForumName;
    private boolean kzp = false;
    private boolean kzq = false;
    private boolean kzr = false;
    private CustomMessageListener kzt = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.kzl != null) {
                    LocalVideoActivity.this.kzl.Kh(str);
                }
            }
        }
    };
    private CustomMessageListener kzu = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.kzm != null) {
                LocalVideoActivity.this.kzm.cQE();
            }
        }
    };
    private b.a kzv = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void eq(List<d> list) {
            if (LocalVideoActivity.this.kzl != null) {
                LocalVideoActivity.this.kzl.er(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.kzl != null) {
                if (view != LocalVideoActivity.this.kzl.cQH()) {
                    if (view == LocalVideoActivity.this.kzl.cQI()) {
                        if (!LocalVideoActivity.this.kzl.cQF()) {
                            if (LocalVideoActivity.this.kzl.cQL() == null || LocalVideoActivity.this.kzl.cQL().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil cQA = LocalVideoActivity.this.cQA();
                                if (!cQA.isConvertRunning()) {
                                    String cQK = LocalVideoActivity.this.kzl.cQK();
                                    if (TextUtils.isEmpty(cQK)) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, cQK));
                                        return;
                                    } else if (!new File(cQK).exists()) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, cQK));
                                        return;
                                    } else {
                                        int JS = e.JS(cQK);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d cQL = LocalVideoActivity.this.kzl.cQL();
                                            if (cQL != null) {
                                                LocalVideoActivity.this.kzl.bGj();
                                                LocalVideoActivity.this.kzo = cQL.getVideoPath();
                                                LocalVideoActivity.this.tp(false);
                                                return;
                                            }
                                            return;
                                        } else if (JS >= 1500000) {
                                            if (LocalVideoActivity.this.cPg()) {
                                                File file = new File(com.baidu.tieba.video.e.kuS, "tieba_" + e.JR(cQK) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.kzo = file.getAbsolutePath();
                                                cQA.setConvertType(1);
                                                cQA.eI(cQK, LocalVideoActivity.this.kzo);
                                                LocalVideoActivity.this.cQB();
                                                LocalVideoActivity.this.kzq = false;
                                                LocalVideoActivity.this.kzr = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d cQL2 = LocalVideoActivity.this.kzl.cQL();
                                            if (cQL2 != null) {
                                                if (cQL2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.kzl.bGj();
                                                    LocalVideoActivity.this.kzo = cQL2.getVideoPath();
                                                    LocalVideoActivity.this.tp(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.kuS, "tieba_" + e.JR(cQK) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.kzo = file2.getAbsolutePath();
                                                cQA.setConvertType(2);
                                                cQA.eI(cQK, LocalVideoActivity.this.kzo);
                                                LocalVideoActivity.this.cQB();
                                                LocalVideoActivity.this.kzq = false;
                                                LocalVideoActivity.this.kzr = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.kzl.cQG();
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
    private Handler kzw = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.kzw.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.kzs != null && LocalVideoActivity.this.kzs.isShowing()) {
                        LocalVideoActivity.this.kzs.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.kzw.sendMessageDelayed(LocalVideoActivity.this.kzw.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.kzr) {
                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.kzq = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.kzo) && (file = new File(LocalVideoActivity.this.kzo)) != null) {
                        LocalVideoActivity.this.kzo = LocalVideoActivity.this.kzo.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.kzo));
                    }
                    LocalVideoActivity.this.cQC();
                    if (!LocalVideoActivity.this.kzp && LocalVideoActivity.this.kzl.cQL() != null) {
                        d Kj = e.Kj(LocalVideoActivity.this.kzo);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.kzo);
                        videoInfo.setVideoDuration(((int) Kj.getDuration()) / 1000);
                        videoInfo.setVideoWidth(Kj.getVideoWidth());
                        videoInfo.setVideoHeight(Kj.getVideoHeight());
                        videoInfo.setVideoLength(new File(Kj.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.kwm, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                    VideoConvertUtil cQA = LocalVideoActivity.this.cQA();
                    if (cQA != null && cQA.isConvertRunning()) {
                        LocalVideoActivity.this.cQD();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.kzq = false;
            LocalVideoActivity.this.cQC();
        }
    };
    private com.baidu.tieba.video.d kzx = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void cPc() {
        }

        @Override // com.baidu.tieba.video.d
        public void Dq(int i) {
            LocalVideoActivity.this.kzw.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.kzw.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.kzw.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.kzw.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.kzw.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener kzy = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil cQA() {
        if (this.kzn == null) {
            this.kzn = new VideoConvertUtil(this);
            this.kzn.a(this.kzx);
        }
        return this.kzn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQB() {
        this.kzl.bGj();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.kzs == null) {
                this.kzs = new LocalVideoCompressingDialogView(this);
            }
            if (this.kzs.getParent() == null) {
                relativeLayout.addView(this.kzs);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kzs.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.kzs.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.kzs.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQC() {
        this.kzl.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.kzs.getParent() != null) {
            relativeLayout.removeView(this.kzs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQD() {
        cQA().abortConvert();
        this.kzr = true;
        if (this.kzo != null) {
            File file = new File(this.kzo);
            if (file.exists()) {
                file.delete();
            }
        }
        cQC();
        this.kzo = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cPg() {
        return VideoConvertUtil.cPg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tp(boolean z) {
        d Kj = e.Kj(this.kzo);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kzo);
        videoInfo.setVideoDuration(((int) Kj.getDuration()) / 1000);
        videoInfo.setVideoWidth(Kj.getVideoWidth());
        videoInfo.setVideoHeight(Kj.getVideoHeight());
        videoInfo.setVideoLength(new File(Kj.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.kwm, videoInfo)));
        this.kzq = false;
        this.kzo = null;
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
            this.kwm = getIntent().getStringExtra("video_title");
        }
        this.kzl = new c(this, this.mOnClickListener);
        this.kzm = new LocalVideoModel(this);
        this.kzm.a(this.kzv);
        this.kzm.cQE();
        registerListener(this.kzu);
        registerListener(this.kzt);
        registerListener(this.kzy);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.kzp = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.kzp = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kzl != null) {
            this.kzl.cQJ();
        }
        if (this.kzq && !TextUtils.isEmpty(this.kzo) && new File(this.kzo).exists()) {
            tp(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.kzl != null) {
            this.kzl.bGk();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kzl.bGk();
        if (this.kzn != null) {
            this.kzn.destroy();
        }
        if (this.kzw != null) {
            this.kzw.removeMessages(5);
        }
    }
}
