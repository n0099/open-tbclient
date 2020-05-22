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
    private String lBh;
    private c lEl;
    private LocalVideoModel lEm;
    private VideoConvertUtil lEn;
    private String lEo;
    private LocalVideoCompressingDialogView lEs;
    private String mForumId;
    private String mForumName;
    private boolean lEp = false;
    private boolean lEq = false;
    private boolean lEr = false;
    private CustomMessageListener lEt = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.lEl != null) {
                    LocalVideoActivity.this.lEl.NI(str);
                }
            }
        }
    };
    private CustomMessageListener lEu = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.lEm != null) {
                LocalVideoActivity.this.lEm.dji();
            }
        }
    };
    private b.a lEv = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void eM(List<d> list) {
            if (LocalVideoActivity.this.lEl != null) {
                LocalVideoActivity.this.lEl.eN(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.lEl != null) {
                if (view != LocalVideoActivity.this.lEl.djl()) {
                    if (view == LocalVideoActivity.this.lEl.djm()) {
                        if (!LocalVideoActivity.this.lEl.djj()) {
                            if (LocalVideoActivity.this.lEl.djp() == null || LocalVideoActivity.this.lEl.djp().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil dje = LocalVideoActivity.this.dje();
                                if (!dje.isConvertRunning()) {
                                    String djo = LocalVideoActivity.this.lEl.djo();
                                    if (TextUtils.isEmpty(djo)) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, djo));
                                        return;
                                    } else if (!new File(djo).exists()) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, djo));
                                        return;
                                    } else {
                                        int Ns = e.Ns(djo);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d djp = LocalVideoActivity.this.lEl.djp();
                                            if (djp != null) {
                                                LocalVideoActivity.this.lEl.bXs();
                                                LocalVideoActivity.this.lEo = djp.getVideoPath();
                                                LocalVideoActivity.this.uU(false);
                                                return;
                                            }
                                            return;
                                        } else if (Ns >= 1500000) {
                                            if (LocalVideoActivity.this.dhJ()) {
                                                File file = new File(com.baidu.tieba.video.e.lzK, "tieba_" + e.Nr(djo) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.lEo = file.getAbsolutePath();
                                                dje.setConvertType(1);
                                                dje.fw(djo, LocalVideoActivity.this.lEo);
                                                LocalVideoActivity.this.djf();
                                                LocalVideoActivity.this.lEq = false;
                                                LocalVideoActivity.this.lEr = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d djp2 = LocalVideoActivity.this.lEl.djp();
                                            if (djp2 != null) {
                                                if (djp2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.lEl.bXs();
                                                    LocalVideoActivity.this.lEo = djp2.getVideoPath();
                                                    LocalVideoActivity.this.uU(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.lzK, "tieba_" + e.Nr(djo) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.lEo = file2.getAbsolutePath();
                                                dje.setConvertType(2);
                                                dje.fw(djo, LocalVideoActivity.this.lEo);
                                                LocalVideoActivity.this.djf();
                                                LocalVideoActivity.this.lEq = false;
                                                LocalVideoActivity.this.lEr = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.lEl.djk();
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
    private Handler lEw = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.lEw.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.lEs != null && LocalVideoActivity.this.lEs.isShowing()) {
                        LocalVideoActivity.this.lEs.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.lEw.sendMessageDelayed(LocalVideoActivity.this.lEw.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.lEr) {
                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.lEq = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.lEo) && (file = new File(LocalVideoActivity.this.lEo)) != null) {
                        LocalVideoActivity.this.lEo = LocalVideoActivity.this.lEo.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.lEo));
                    }
                    LocalVideoActivity.this.djg();
                    if (!LocalVideoActivity.this.lEp && LocalVideoActivity.this.lEl.djp() != null) {
                        d NL = e.NL(LocalVideoActivity.this.lEo);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.lEo);
                        videoInfo.setVideoDuration(((int) NL.getDuration()) / 1000);
                        videoInfo.setVideoWidth(NL.getVideoWidth());
                        videoInfo.setVideoHeight(NL.getVideoHeight());
                        videoInfo.setVideoLength(new File(NL.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.lBh, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                    VideoConvertUtil dje = LocalVideoActivity.this.dje();
                    if (dje != null && dje.isConvertRunning()) {
                        LocalVideoActivity.this.djh();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.lEq = false;
            LocalVideoActivity.this.djg();
        }
    };
    private com.baidu.tieba.video.d lEx = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void dhF() {
        }

        @Override // com.baidu.tieba.video.d
        public void EN(int i) {
            LocalVideoActivity.this.lEw.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.lEw.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.lEw.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.lEw.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.lEw.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener lEy = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil dje() {
        if (this.lEn == null) {
            this.lEn = new VideoConvertUtil(this);
            this.lEn.a(this.lEx);
        }
        return this.lEn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djf() {
        this.lEl.bXs();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.lEs == null) {
                this.lEs = new LocalVideoCompressingDialogView(this);
            }
            if (this.lEs.getParent() == null) {
                relativeLayout.addView(this.lEs);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lEs.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.lEs.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.lEs.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djg() {
        this.lEl.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.lEs.getParent() != null) {
            relativeLayout.removeView(this.lEs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djh() {
        dje().abortConvert();
        this.lEr = true;
        if (this.lEo != null) {
            File file = new File(this.lEo);
            if (file.exists()) {
                file.delete();
            }
        }
        djg();
        this.lEo = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dhJ() {
        return VideoConvertUtil.dhJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uU(boolean z) {
        d NL = e.NL(this.lEo);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.lEo);
        videoInfo.setVideoDuration(((int) NL.getDuration()) / 1000);
        videoInfo.setVideoWidth(NL.getVideoWidth());
        videoInfo.setVideoHeight(NL.getVideoHeight());
        videoInfo.setVideoLength(new File(NL.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.lBh, videoInfo)));
        this.lEq = false;
        this.lEo = null;
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
            this.lBh = getIntent().getStringExtra("video_title");
        }
        this.lEl = new c(this, this.mOnClickListener);
        this.lEm = new LocalVideoModel(this);
        this.lEm.a(this.lEv);
        this.lEm.dji();
        registerListener(this.lEu);
        registerListener(this.lEt);
        registerListener(this.lEy);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.lEp = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.lEp = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lEl != null) {
            this.lEl.djn();
        }
        if (this.lEq && !TextUtils.isEmpty(this.lEo) && new File(this.lEo).exists()) {
            uU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.lEl != null) {
            this.lEl.bXt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.lEl.bXt();
        if (this.lEn != null) {
            this.lEn.destroy();
        }
        if (this.lEw != null) {
            this.lEw.removeMessages(5);
        }
    }
}
