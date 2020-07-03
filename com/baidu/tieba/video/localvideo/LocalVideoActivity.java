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
import com.baidu.tieba.video.f;
import com.baidu.tieba.video.localvideo.b;
import java.io.File;
import java.util.List;
/* loaded from: classes10.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String lVW;
    private c lZi;
    private LocalVideoModel lZj;
    private VideoConvertUtil lZk;
    private String lZl;
    private LocalVideoCompressingDialogView lZp;
    private String mForumId;
    private String mForumName;
    private boolean lZm = false;
    private boolean lZn = false;
    private boolean lZo = false;
    private CustomMessageListener lZq = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.lZi != null) {
                    LocalVideoActivity.this.lZi.Ol(str);
                }
            }
        }
    };
    private CustomMessageListener lZr = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.lZj != null) {
                LocalVideoActivity.this.lZj.dnJ();
            }
        }
    };
    private b.a lZs = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void fb(List<d> list) {
            if (LocalVideoActivity.this.lZi != null) {
                LocalVideoActivity.this.lZi.fc(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.lZi != null) {
                if (view != LocalVideoActivity.this.lZi.dnM()) {
                    if (view == LocalVideoActivity.this.lZi.dnN()) {
                        if (!LocalVideoActivity.this.lZi.dnK()) {
                            if (LocalVideoActivity.this.lZi.dnQ() == null || LocalVideoActivity.this.lZi.dnQ().getDuration() <= 600000) {
                                VideoConvertUtil dnF = LocalVideoActivity.this.dnF();
                                if (!dnF.isConvertRunning()) {
                                    String dnP = LocalVideoActivity.this.lZi.dnP();
                                    if (TextUtils.isEmpty(dnP)) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dnP));
                                        return;
                                    } else if (!new File(dnP).exists()) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dnP));
                                        return;
                                    } else {
                                        int NU = e.NU(dnP);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d dnQ = LocalVideoActivity.this.lZi.dnQ();
                                            if (dnQ != null) {
                                                LocalVideoActivity.this.lZi.caF();
                                                LocalVideoActivity.this.lZl = dnQ.getVideoPath();
                                                LocalVideoActivity.this.vm(false);
                                                return;
                                            }
                                            return;
                                        } else if (NU >= 1500000) {
                                            if (LocalVideoActivity.this.dmj()) {
                                                File file = new File(f.lUz, "tieba_" + e.NT(dnP) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.lZl = file.getAbsolutePath();
                                                dnF.setConvertType(1);
                                                dnF.fD(dnP, LocalVideoActivity.this.lZl);
                                                LocalVideoActivity.this.dnG();
                                                LocalVideoActivity.this.lZn = false;
                                                LocalVideoActivity.this.lZo = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d dnQ2 = LocalVideoActivity.this.lZi.dnQ();
                                            if (dnQ2 != null) {
                                                if (dnQ2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.lZi.caF();
                                                    LocalVideoActivity.this.lZl = dnQ2.getVideoPath();
                                                    LocalVideoActivity.this.vm(false);
                                                    return;
                                                }
                                                File file2 = new File(f.lUz, "tieba_" + e.NT(dnP) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.lZl = file2.getAbsolutePath();
                                                dnF.setConvertType(2);
                                                dnF.fD(dnP, LocalVideoActivity.this.lZl);
                                                LocalVideoActivity.this.dnG();
                                                LocalVideoActivity.this.lZn = false;
                                                LocalVideoActivity.this.lZo = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.lZi.dnL();
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
    private Handler lZt = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.lZt.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.lZp != null && LocalVideoActivity.this.lZp.isShowing()) {
                        LocalVideoActivity.this.lZp.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.lZt.sendMessageDelayed(LocalVideoActivity.this.lZt.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.lZo) {
                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.lZn = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.lZl) && (file = new File(LocalVideoActivity.this.lZl)) != null) {
                        LocalVideoActivity.this.lZl = LocalVideoActivity.this.lZl.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.lZl));
                    }
                    LocalVideoActivity.this.dnH();
                    if (!LocalVideoActivity.this.lZm && LocalVideoActivity.this.lZi.dnQ() != null) {
                        d Oo = e.Oo(LocalVideoActivity.this.lZl);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.lZl);
                        videoInfo.setVideoDuration(((int) Oo.getDuration()) / 1000);
                        videoInfo.setVideoWidth(Oo.getVideoWidth());
                        videoInfo.setVideoHeight(Oo.getVideoHeight());
                        videoInfo.setVideoLength(new File(Oo.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.lVW, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                    VideoConvertUtil dnF = LocalVideoActivity.this.dnF();
                    if (dnF != null && dnF.isConvertRunning()) {
                        LocalVideoActivity.this.dnI();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.lZn = false;
            LocalVideoActivity.this.dnH();
        }
    };
    private com.baidu.tieba.video.e lZu = new com.baidu.tieba.video.e() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.e
        public void dmf() {
        }

        @Override // com.baidu.tieba.video.e
        public void FR(int i) {
            LocalVideoActivity.this.lZt.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.e
        public void onConvertSuccess() {
            LocalVideoActivity.this.lZt.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.e
        public void onConvertFailed() {
            LocalVideoActivity.this.lZt.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.e
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.lZt.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.e
        public void onConvertAborted() {
            LocalVideoActivity.this.lZt.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener lZv = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil dnF() {
        if (this.lZk == null) {
            this.lZk = new VideoConvertUtil(this);
            this.lZk.a(this.lZu);
        }
        return this.lZk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnG() {
        this.lZi.caF();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.lZp == null) {
                this.lZp = new LocalVideoCompressingDialogView(this);
            }
            if (this.lZp.getParent() == null) {
                relativeLayout.addView(this.lZp);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lZp.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.lZp.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.lZp.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnH() {
        this.lZi.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.lZp.getParent() != null) {
            relativeLayout.removeView(this.lZp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnI() {
        dnF().abortConvert();
        this.lZo = true;
        if (this.lZl != null) {
            File file = new File(this.lZl);
            if (file.exists()) {
                file.delete();
            }
        }
        dnH();
        this.lZl = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dmj() {
        return VideoConvertUtil.dmj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vm(boolean z) {
        d Oo = e.Oo(this.lZl);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.lZl);
        videoInfo.setVideoDuration(((int) Oo.getDuration()) / 1000);
        videoInfo.setVideoWidth(Oo.getVideoWidth());
        videoInfo.setVideoHeight(Oo.getVideoHeight());
        videoInfo.setVideoLength(new File(Oo.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.lVW, videoInfo)));
        this.lZn = false;
        this.lZl = null;
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
            this.lVW = getIntent().getStringExtra("video_title");
        }
        this.lZi = new c(this, this.mOnClickListener);
        this.lZj = new LocalVideoModel(this);
        this.lZj.a(this.lZs);
        this.lZj.dnJ();
        registerListener(this.lZr);
        registerListener(this.lZq);
        registerListener(this.lZv);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.lZm = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.lZm = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lZi != null) {
            this.lZi.dnO();
        }
        if (this.lZn && !TextUtils.isEmpty(this.lZl) && new File(this.lZl).exists()) {
            vm(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.lZi != null) {
            this.lZi.caG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.lZi.caG();
        if (this.lZk != null) {
            this.lZk.destroy();
        }
        if (this.lZt != null) {
            this.lZt.removeMessages(5);
        }
    }
}
