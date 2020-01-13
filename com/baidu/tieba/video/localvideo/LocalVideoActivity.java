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
    private String kvi;
    private c kyj;
    private LocalVideoModel kyk;
    private VideoConvertUtil kyl;
    private String kym;
    private LocalVideoCompressingDialogView kyq;
    private String mForumId;
    private String mForumName;
    private boolean kyn = false;
    private boolean kyo = false;
    private boolean kyp = false;
    private CustomMessageListener kyr = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.kyj != null) {
                    LocalVideoActivity.this.kyj.JU(str);
                }
            }
        }
    };
    private CustomMessageListener kys = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.kyk != null) {
                LocalVideoActivity.this.kyk.cPh();
            }
        }
    };
    private b.a kyt = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void ev(List<d> list) {
            if (LocalVideoActivity.this.kyj != null) {
                LocalVideoActivity.this.kyj.ew(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.kyj != null) {
                if (view != LocalVideoActivity.this.kyj.cPk()) {
                    if (view == LocalVideoActivity.this.kyj.cPl()) {
                        if (!LocalVideoActivity.this.kyj.cPi()) {
                            if (LocalVideoActivity.this.kyj.cPo() == null || LocalVideoActivity.this.kyj.cPo().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil cPd = LocalVideoActivity.this.cPd();
                                if (!cPd.isConvertRunning()) {
                                    String cPn = LocalVideoActivity.this.kyj.cPn();
                                    if (TextUtils.isEmpty(cPn)) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, cPn));
                                        return;
                                    } else if (!new File(cPn).exists()) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, cPn));
                                        return;
                                    } else {
                                        int JF = e.JF(cPn);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d cPo = LocalVideoActivity.this.kyj.cPo();
                                            if (cPo != null) {
                                                LocalVideoActivity.this.kyj.bEF();
                                                LocalVideoActivity.this.kym = cPo.getVideoPath();
                                                LocalVideoActivity.this.tl(false);
                                                return;
                                            }
                                            return;
                                        } else if (JF >= 1500000) {
                                            if (LocalVideoActivity.this.cNH()) {
                                                File file = new File(com.baidu.tieba.video.e.ktO, "tieba_" + e.JE(cPn) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.kym = file.getAbsolutePath();
                                                cPd.setConvertType(1);
                                                cPd.ez(cPn, LocalVideoActivity.this.kym);
                                                LocalVideoActivity.this.cPe();
                                                LocalVideoActivity.this.kyo = false;
                                                LocalVideoActivity.this.kyp = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d cPo2 = LocalVideoActivity.this.kyj.cPo();
                                            if (cPo2 != null) {
                                                if (cPo2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.kyj.bEF();
                                                    LocalVideoActivity.this.kym = cPo2.getVideoPath();
                                                    LocalVideoActivity.this.tl(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.ktO, "tieba_" + e.JE(cPn) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.kym = file2.getAbsolutePath();
                                                cPd.setConvertType(2);
                                                cPd.ez(cPn, LocalVideoActivity.this.kym);
                                                LocalVideoActivity.this.cPe();
                                                LocalVideoActivity.this.kyo = false;
                                                LocalVideoActivity.this.kyp = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.kyj.cPj();
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
    private Handler kyu = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.kyu.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.kyq != null && LocalVideoActivity.this.kyq.isShowing()) {
                        LocalVideoActivity.this.kyq.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.kyu.sendMessageDelayed(LocalVideoActivity.this.kyu.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.kyp) {
                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.kyo = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.kym) && (file = new File(LocalVideoActivity.this.kym)) != null) {
                        LocalVideoActivity.this.kym = LocalVideoActivity.this.kym.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.kym));
                    }
                    LocalVideoActivity.this.cPf();
                    if (!LocalVideoActivity.this.kyn && LocalVideoActivity.this.kyj.cPo() != null) {
                        d JW = e.JW(LocalVideoActivity.this.kym);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.kym);
                        videoInfo.setVideoDuration(((int) JW.getDuration()) / 1000);
                        videoInfo.setVideoWidth(JW.getVideoWidth());
                        videoInfo.setVideoHeight(JW.getVideoHeight());
                        videoInfo.setVideoLength(new File(JW.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.kvi, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                    VideoConvertUtil cPd = LocalVideoActivity.this.cPd();
                    if (cPd != null && cPd.isConvertRunning()) {
                        LocalVideoActivity.this.cPg();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.kyo = false;
            LocalVideoActivity.this.cPf();
        }
    };
    private com.baidu.tieba.video.d kyv = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void cND() {
        }

        @Override // com.baidu.tieba.video.d
        public void Dk(int i) {
            LocalVideoActivity.this.kyu.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.kyu.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.kyu.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.kyu.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.kyu.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener kyw = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil cPd() {
        if (this.kyl == null) {
            this.kyl = new VideoConvertUtil(this);
            this.kyl.a(this.kyv);
        }
        return this.kyl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPe() {
        this.kyj.bEF();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.kyq == null) {
                this.kyq = new LocalVideoCompressingDialogView(this);
            }
            if (this.kyq.getParent() == null) {
                relativeLayout.addView(this.kyq);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kyq.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.kyq.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.kyq.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPf() {
        this.kyj.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.kyq.getParent() != null) {
            relativeLayout.removeView(this.kyq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPg() {
        cPd().abortConvert();
        this.kyp = true;
        if (this.kym != null) {
            File file = new File(this.kym);
            if (file.exists()) {
                file.delete();
            }
        }
        cPf();
        this.kym = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cNH() {
        return VideoConvertUtil.cNH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl(boolean z) {
        d JW = e.JW(this.kym);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kym);
        videoInfo.setVideoDuration(((int) JW.getDuration()) / 1000);
        videoInfo.setVideoWidth(JW.getVideoWidth());
        videoInfo.setVideoHeight(JW.getVideoHeight());
        videoInfo.setVideoLength(new File(JW.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.kvi, videoInfo)));
        this.kyo = false;
        this.kym = null;
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
            this.kvi = getIntent().getStringExtra("video_title");
        }
        this.kyj = new c(this, this.mOnClickListener);
        this.kyk = new LocalVideoModel(this);
        this.kyk.a(this.kyt);
        this.kyk.cPh();
        registerListener(this.kys);
        registerListener(this.kyr);
        registerListener(this.kyw);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.kyn = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.kyn = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kyj != null) {
            this.kyj.cPm();
        }
        if (this.kyo && !TextUtils.isEmpty(this.kym) && new File(this.kym).exists()) {
            tl(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.kyj != null) {
            this.kyj.bEG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.kyj.bEG();
        if (this.kyl != null) {
            this.kyl.destroy();
        }
        if (this.kyu != null) {
            this.kyu.removeMessages(5);
        }
    }
}
