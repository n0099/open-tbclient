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
import com.baidu.tieba.e;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.video.commonview.LocalVideoCompressingDialogView;
import com.baidu.tieba.video.localvideo.b;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String hlc;
    private c hon;
    private LocalVideoModel hoo;
    private VideoConvertUtil hop;
    private String hoq;
    private LocalVideoCompressingDialogView hou;
    private String mForumId;
    private String mForumName;
    private boolean hor = false;
    private boolean hos = false;
    private boolean hot = false;
    private CustomMessageListener hov = new CustomMessageListener(2016328) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.hon != null) {
                    LocalVideoActivity.this.hon.vF(str);
                }
            }
        }
    };
    private CustomMessageListener how = new CustomMessageListener(2016329) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.hoo != null) {
                LocalVideoActivity.this.hoo.bED();
            }
        }
    };
    private b.a hox = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dJ(List<d> list) {
            if (LocalVideoActivity.this.hon != null) {
                LocalVideoActivity.this.hon.dK(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.hon != null) {
                if (view != LocalVideoActivity.this.hon.bEG()) {
                    if (view == LocalVideoActivity.this.hon.bEH()) {
                        if (!LocalVideoActivity.this.hon.bEE()) {
                            if (LocalVideoActivity.this.hon.bEL() == null || LocalVideoActivity.this.hon.bEL().getDuration() <= KeepJobService.JOB_CHECK_PERIODIC) {
                                VideoConvertUtil bEz = LocalVideoActivity.this.bEz();
                                if (!bEz.isConvertRunning()) {
                                    String bEK = LocalVideoActivity.this.hon.bEK();
                                    if (TextUtils.isEmpty(bEK)) {
                                        l.showToast(LocalVideoActivity.this, e.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bEK));
                                        return;
                                    } else if (!new File(bEK).exists()) {
                                        l.showToast(LocalVideoActivity.this, e.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, bEK));
                                        return;
                                    } else {
                                        int vo = e.vo(bEK);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bEL = LocalVideoActivity.this.hon.bEL();
                                            if (bEL != null) {
                                                LocalVideoActivity.this.hon.ayn();
                                                LocalVideoActivity.this.hoq = bEL.getVideoPath();
                                                LocalVideoActivity.this.nr(false);
                                                return;
                                            }
                                            return;
                                        } else if (vo >= 1500000) {
                                            if (LocalVideoActivity.this.bCY()) {
                                                File file = new File(com.baidu.tieba.video.e.hjB, "tieba_" + e.vn(bEK) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hoq = file.getAbsolutePath();
                                                bEz.setConvertType(1);
                                                bEz.cA(bEK, LocalVideoActivity.this.hoq);
                                                LocalVideoActivity.this.bEA();
                                                LocalVideoActivity.this.hos = false;
                                                LocalVideoActivity.this.hot = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bEL2 = LocalVideoActivity.this.hon.bEL();
                                            if (bEL2 != null) {
                                                if (bEL2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.hon.ayn();
                                                    LocalVideoActivity.this.hoq = bEL2.getVideoPath();
                                                    LocalVideoActivity.this.nr(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.hjB, "tieba_" + e.vn(bEK) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.hoq = file2.getAbsolutePath();
                                                bEz.setConvertType(2);
                                                bEz.cA(bEK, LocalVideoActivity.this.hoq);
                                                LocalVideoActivity.this.bEA();
                                                LocalVideoActivity.this.hos = false;
                                                LocalVideoActivity.this.hot = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.hon.bEF();
                            return;
                        }
                        l.showToast(LocalVideoActivity.this, e.j.show_video_file_error);
                        return;
                    }
                    return;
                }
                LocalVideoActivity.this.finish();
            }
        }
    };
    private Handler hoy = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.hoy.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.hou != null && LocalVideoActivity.this.hou.isShowing()) {
                        LocalVideoActivity.this.hou.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.hoy.sendMessageDelayed(LocalVideoActivity.this.hoy.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.hot) {
                        l.showToast(LocalVideoActivity.this, e.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.hos = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.hoq) && (file = new File(LocalVideoActivity.this.hoq)) != null) {
                        LocalVideoActivity.this.hoq = LocalVideoActivity.this.hoq.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.hoq));
                    }
                    LocalVideoActivity.this.bEB();
                    if (!LocalVideoActivity.this.hor && LocalVideoActivity.this.hon.bEL() != null) {
                        d vI = e.vI(LocalVideoActivity.this.hoq);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.hoq);
                        videoInfo.setVideoDuration(((int) vI.getDuration()) / 1000);
                        videoInfo.setVideoWidth(vI.getVideoWidth());
                        videoInfo.setVideoHeight(vI.getVideoHeight());
                        videoInfo.setVideoLength(new File(vI.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.hlc, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, e.j.mv_local_video_compress_failed);
                    VideoConvertUtil bEz = LocalVideoActivity.this.bEz();
                    if (bEz != null && bEz.isConvertRunning()) {
                        LocalVideoActivity.this.bEC();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.hos = false;
            LocalVideoActivity.this.bEB();
        }
    };
    private com.baidu.tieba.video.d hoz = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void bCU() {
        }

        @Override // com.baidu.tieba.video.d
        public void uY(int i) {
            LocalVideoActivity.this.hoy.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.hoy.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.hoy.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.hoy.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.hoy.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener hoA = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil bEz() {
        if (this.hop == null) {
            this.hop = new VideoConvertUtil(this);
            this.hop.a(this.hoz);
        }
        return this.hop;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEA() {
        this.hon.ayn();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.container);
        if (relativeLayout != null) {
            if (this.hou == null) {
                this.hou = new LocalVideoCompressingDialogView(this);
            }
            if (this.hou.getParent() == null) {
                relativeLayout.addView(this.hou);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hou.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.hou.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hou.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEB() {
        this.hon.bEI();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.container);
        if (relativeLayout != null && this.hou.getParent() != null) {
            relativeLayout.removeView(this.hou);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEC() {
        bEz().abortConvert();
        this.hot = true;
        if (this.hoq != null) {
            File file = new File(this.hoq);
            if (file.exists()) {
                file.delete();
            }
        }
        bEB();
        this.hoq = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bCY() {
        return VideoConvertUtil.bCY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(boolean z) {
        d vI = e.vI(this.hoq);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hoq);
        videoInfo.setVideoDuration(((int) vI.getDuration()) / 1000);
        videoInfo.setVideoWidth(vI.getVideoWidth());
        videoInfo.setVideoHeight(vI.getVideoHeight());
        videoInfo.setVideoLength(new File(vI.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.hlc, videoInfo)));
        this.hos = false;
        this.hoq = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(e.h.local_video_activity);
        if (getIntent() != null) {
            this.mForumId = getIntent().getStringExtra("forum_id");
            this.mForumName = getIntent().getStringExtra("forum_name");
            this.hlc = getIntent().getStringExtra("video_title");
        }
        this.hon = new c(this, this.mOnClickListener);
        this.hoo = new LocalVideoModel(this);
        this.hoo.a(this.hox);
        this.hoo.bED();
        registerListener(this.how);
        registerListener(this.hov);
        registerListener(this.hoA);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.hor = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hor = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hon != null) {
            this.hon.bEJ();
        }
        if (this.hos && !TextUtils.isEmpty(this.hoq) && new File(this.hoq).exists()) {
            nr(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hon != null) {
            this.hon.ayo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.hon.ayo();
        if (this.hop != null) {
            this.hop.destroy();
        }
        if (this.hoy != null) {
            this.hoy.removeMessages(5);
        }
    }
}
