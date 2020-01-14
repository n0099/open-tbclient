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
/* loaded from: classes8.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String kvn;
    private c kyo;
    private LocalVideoModel kyp;
    private VideoConvertUtil kyq;
    private String kyr;
    private LocalVideoCompressingDialogView kyv;
    private String mForumId;
    private String mForumName;
    private boolean kys = false;
    private boolean kyt = false;
    private boolean kyu = false;
    private CustomMessageListener kyw = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.kyo != null) {
                    LocalVideoActivity.this.kyo.JU(str);
                }
            }
        }
    };
    private CustomMessageListener kyx = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.kyp != null) {
                LocalVideoActivity.this.kyp.cPj();
            }
        }
    };
    private b.a kyy = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void ev(List<d> list) {
            if (LocalVideoActivity.this.kyo != null) {
                LocalVideoActivity.this.kyo.ew(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.kyo != null) {
                if (view != LocalVideoActivity.this.kyo.cPm()) {
                    if (view == LocalVideoActivity.this.kyo.cPn()) {
                        if (!LocalVideoActivity.this.kyo.cPk()) {
                            if (LocalVideoActivity.this.kyo.cPq() == null || LocalVideoActivity.this.kyo.cPq().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil cPf = LocalVideoActivity.this.cPf();
                                if (!cPf.isConvertRunning()) {
                                    String cPp = LocalVideoActivity.this.kyo.cPp();
                                    if (TextUtils.isEmpty(cPp)) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, cPp));
                                        return;
                                    } else if (!new File(cPp).exists()) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, cPp));
                                        return;
                                    } else {
                                        int JF = e.JF(cPp);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d cPq = LocalVideoActivity.this.kyo.cPq();
                                            if (cPq != null) {
                                                LocalVideoActivity.this.kyo.bEF();
                                                LocalVideoActivity.this.kyr = cPq.getVideoPath();
                                                LocalVideoActivity.this.tl(false);
                                                return;
                                            }
                                            return;
                                        } else if (JF >= 1500000) {
                                            if (LocalVideoActivity.this.cNJ()) {
                                                File file = new File(com.baidu.tieba.video.e.ktT, "tieba_" + e.JE(cPp) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.kyr = file.getAbsolutePath();
                                                cPf.setConvertType(1);
                                                cPf.ez(cPp, LocalVideoActivity.this.kyr);
                                                LocalVideoActivity.this.cPg();
                                                LocalVideoActivity.this.kyt = false;
                                                LocalVideoActivity.this.kyu = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d cPq2 = LocalVideoActivity.this.kyo.cPq();
                                            if (cPq2 != null) {
                                                if (cPq2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.kyo.bEF();
                                                    LocalVideoActivity.this.kyr = cPq2.getVideoPath();
                                                    LocalVideoActivity.this.tl(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.ktT, "tieba_" + e.JE(cPp) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.kyr = file2.getAbsolutePath();
                                                cPf.setConvertType(2);
                                                cPf.ez(cPp, LocalVideoActivity.this.kyr);
                                                LocalVideoActivity.this.cPg();
                                                LocalVideoActivity.this.kyt = false;
                                                LocalVideoActivity.this.kyu = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.kyo.cPl();
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
    private Handler kyz = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.kyz.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.kyv != null && LocalVideoActivity.this.kyv.isShowing()) {
                        LocalVideoActivity.this.kyv.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.kyz.sendMessageDelayed(LocalVideoActivity.this.kyz.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.kyu) {
                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.kyt = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.kyr) && (file = new File(LocalVideoActivity.this.kyr)) != null) {
                        LocalVideoActivity.this.kyr = LocalVideoActivity.this.kyr.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.kyr));
                    }
                    LocalVideoActivity.this.cPh();
                    if (!LocalVideoActivity.this.kys && LocalVideoActivity.this.kyo.cPq() != null) {
                        d JW = e.JW(LocalVideoActivity.this.kyr);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.kyr);
                        videoInfo.setVideoDuration(((int) JW.getDuration()) / 1000);
                        videoInfo.setVideoWidth(JW.getVideoWidth());
                        videoInfo.setVideoHeight(JW.getVideoHeight());
                        videoInfo.setVideoLength(new File(JW.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.kvn, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                    VideoConvertUtil cPf = LocalVideoActivity.this.cPf();
                    if (cPf != null && cPf.isConvertRunning()) {
                        LocalVideoActivity.this.cPi();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.kyt = false;
            LocalVideoActivity.this.cPh();
        }
    };
    private com.baidu.tieba.video.d kyA = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void cNF() {
        }

        @Override // com.baidu.tieba.video.d
        public void Dk(int i) {
            LocalVideoActivity.this.kyz.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.kyz.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.kyz.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.kyz.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.kyz.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener kyB = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil cPf() {
        if (this.kyq == null) {
            this.kyq = new VideoConvertUtil(this);
            this.kyq.a(this.kyA);
        }
        return this.kyq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPg() {
        this.kyo.bEF();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.kyv == null) {
                this.kyv = new LocalVideoCompressingDialogView(this);
            }
            if (this.kyv.getParent() == null) {
                relativeLayout.addView(this.kyv);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kyv.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.kyv.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.kyv.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPh() {
        this.kyo.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.kyv.getParent() != null) {
            relativeLayout.removeView(this.kyv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPi() {
        cPf().abortConvert();
        this.kyu = true;
        if (this.kyr != null) {
            File file = new File(this.kyr);
            if (file.exists()) {
                file.delete();
            }
        }
        cPh();
        this.kyr = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cNJ() {
        return VideoConvertUtil.cNJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl(boolean z) {
        d JW = e.JW(this.kyr);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kyr);
        videoInfo.setVideoDuration(((int) JW.getDuration()) / 1000);
        videoInfo.setVideoWidth(JW.getVideoWidth());
        videoInfo.setVideoHeight(JW.getVideoHeight());
        videoInfo.setVideoLength(new File(JW.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.kvn, videoInfo)));
        this.kyt = false;
        this.kyr = null;
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
            this.kvn = getIntent().getStringExtra("video_title");
        }
        this.kyo = new c(this, this.mOnClickListener);
        this.kyp = new LocalVideoModel(this);
        this.kyp.a(this.kyy);
        this.kyp.cPj();
        registerListener(this.kyx);
        registerListener(this.kyw);
        registerListener(this.kyB);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.kys = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.kys = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kyo != null) {
            this.kyo.cPo();
        }
        if (this.kyt && !TextUtils.isEmpty(this.kyr) && new File(this.kyr).exists()) {
            tl(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.kyo != null) {
            this.kyo.bEG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kyo.bEG();
        if (this.kyq != null) {
            this.kyq.destroy();
        }
        if (this.kyz != null) {
            this.kyz.removeMessages(5);
        }
    }
}
