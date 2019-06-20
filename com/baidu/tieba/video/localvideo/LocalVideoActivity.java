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
/* loaded from: classes5.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String joY;
    private c jsd;
    private LocalVideoModel jse;
    private VideoConvertUtil jsf;
    private String jsg;
    private LocalVideoCompressingDialogView jsk;
    private String mForumId;
    private String mForumName;
    private boolean jsh = false;
    private boolean jsi = false;
    private boolean jsj = false;
    private CustomMessageListener jsl = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.jsd != null) {
                    LocalVideoActivity.this.jsd.Ff(str);
                }
            }
        }
    };
    private CustomMessageListener jsm = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.jse != null) {
                LocalVideoActivity.this.jse.csv();
            }
        }
    };
    private b.a jsn = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void eo(List<d> list) {
            if (LocalVideoActivity.this.jsd != null) {
                LocalVideoActivity.this.jsd.ep(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.jsd != null) {
                if (view != LocalVideoActivity.this.jsd.csy()) {
                    if (view == LocalVideoActivity.this.jsd.csz()) {
                        if (!LocalVideoActivity.this.jsd.csw()) {
                            if (LocalVideoActivity.this.jsd.csD() == null || LocalVideoActivity.this.jsd.csD().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil csr = LocalVideoActivity.this.csr();
                                if (!csr.isConvertRunning()) {
                                    String csC = LocalVideoActivity.this.jsd.csC();
                                    if (TextUtils.isEmpty(csC)) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, csC));
                                        return;
                                    } else if (!new File(csC).exists()) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, csC));
                                        return;
                                    } else {
                                        int EP = e.EP(csC);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d csD = LocalVideoActivity.this.jsd.csD();
                                            if (csD != null) {
                                                LocalVideoActivity.this.jsd.bme();
                                                LocalVideoActivity.this.jsg = csD.getVideoPath();
                                                LocalVideoActivity.this.rs(false);
                                                return;
                                            }
                                            return;
                                        } else if (EP >= 1500000) {
                                            if (LocalVideoActivity.this.cqS()) {
                                                File file = new File(com.baidu.tieba.video.e.jnx, "tieba_" + e.EO(csC) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.jsg = file.getAbsolutePath();
                                                csr.setConvertType(1);
                                                csr.eq(csC, LocalVideoActivity.this.jsg);
                                                LocalVideoActivity.this.css();
                                                LocalVideoActivity.this.jsi = false;
                                                LocalVideoActivity.this.jsj = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d csD2 = LocalVideoActivity.this.jsd.csD();
                                            if (csD2 != null) {
                                                if (csD2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.jsd.bme();
                                                    LocalVideoActivity.this.jsg = csD2.getVideoPath();
                                                    LocalVideoActivity.this.rs(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.jnx, "tieba_" + e.EO(csC) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.jsg = file2.getAbsolutePath();
                                                csr.setConvertType(2);
                                                csr.eq(csC, LocalVideoActivity.this.jsg);
                                                LocalVideoActivity.this.css();
                                                LocalVideoActivity.this.jsi = false;
                                                LocalVideoActivity.this.jsj = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.jsd.csx();
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
    private Handler jso = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.jso.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.jsk != null && LocalVideoActivity.this.jsk.isShowing()) {
                        LocalVideoActivity.this.jsk.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.jso.sendMessageDelayed(LocalVideoActivity.this.jso.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.jsj) {
                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.jsi = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.jsg) && (file = new File(LocalVideoActivity.this.jsg)) != null) {
                        LocalVideoActivity.this.jsg = LocalVideoActivity.this.jsg.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.jsg));
                    }
                    LocalVideoActivity.this.cst();
                    if (!LocalVideoActivity.this.jsh && LocalVideoActivity.this.jsd.csD() != null) {
                        d Fi = e.Fi(LocalVideoActivity.this.jsg);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.jsg);
                        videoInfo.setVideoDuration(((int) Fi.getDuration()) / 1000);
                        videoInfo.setVideoWidth(Fi.getVideoWidth());
                        videoInfo.setVideoHeight(Fi.getVideoHeight());
                        videoInfo.setVideoLength(new File(Fi.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.joY, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                    VideoConvertUtil csr = LocalVideoActivity.this.csr();
                    if (csr != null && csr.isConvertRunning()) {
                        LocalVideoActivity.this.csu();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.jsi = false;
            LocalVideoActivity.this.cst();
        }
    };
    private com.baidu.tieba.video.d jsp = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void cqO() {
        }

        @Override // com.baidu.tieba.video.d
        public void Br(int i) {
            LocalVideoActivity.this.jso.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.jso.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.jso.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.jso.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.jso.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener jsq = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil csr() {
        if (this.jsf == null) {
            this.jsf = new VideoConvertUtil(this);
            this.jsf.a(this.jsp);
        }
        return this.jsf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void css() {
        this.jsd.bme();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.jsk == null) {
                this.jsk = new LocalVideoCompressingDialogView(this);
            }
            if (this.jsk.getParent() == null) {
                relativeLayout.addView(this.jsk);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jsk.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.jsk.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.jsk.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cst() {
        this.jsd.csA();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.jsk.getParent() != null) {
            relativeLayout.removeView(this.jsk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csu() {
        csr().abortConvert();
        this.jsj = true;
        if (this.jsg != null) {
            File file = new File(this.jsg);
            if (file.exists()) {
                file.delete();
            }
        }
        cst();
        this.jsg = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqS() {
        return VideoConvertUtil.cqS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rs(boolean z) {
        d Fi = e.Fi(this.jsg);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jsg);
        videoInfo.setVideoDuration(((int) Fi.getDuration()) / 1000);
        videoInfo.setVideoWidth(Fi.getVideoWidth());
        videoInfo.setVideoHeight(Fi.getVideoHeight());
        videoInfo.setVideoLength(new File(Fi.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.joY, videoInfo)));
        this.jsi = false;
        this.jsg = null;
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
            this.joY = getIntent().getStringExtra("video_title");
        }
        this.jsd = new c(this, this.mOnClickListener);
        this.jse = new LocalVideoModel(this);
        this.jse.a(this.jsn);
        this.jse.csv();
        registerListener(this.jsm);
        registerListener(this.jsl);
        registerListener(this.jsq);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.jsh = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.jsh = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jsd != null) {
            this.jsd.csB();
        }
        if (this.jsi && !TextUtils.isEmpty(this.jsg) && new File(this.jsg).exists()) {
            rs(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jsd != null) {
            this.jsd.bmf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jsd.bmf();
        if (this.jsf != null) {
            this.jsf.destroy();
        }
        if (this.jso != null) {
            this.jso.removeMessages(5);
        }
    }
}
