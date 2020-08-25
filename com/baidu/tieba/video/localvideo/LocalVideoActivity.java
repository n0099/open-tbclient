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
import com.baidu.tieba.video.localvideo.b;
import java.io.File;
import java.util.List;
/* loaded from: classes17.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String mForumId;
    private String mForumName;
    private String mvc;
    private c myo;
    private LocalVideoModel myp;
    private VideoConvertUtil myq;
    private String myr;
    private LocalVideoCompressingDialogView myv;
    private boolean mys = false;
    private boolean myt = false;
    private boolean myu = false;
    private CustomMessageListener myw = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.myo != null) {
                    LocalVideoActivity.this.myo.RS(str);
                }
            }
        }
    };
    private CustomMessageListener myx = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.myp != null) {
                LocalVideoActivity.this.myp.dCs();
            }
        }
    };
    private b.a myy = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void fp(List<d> list) {
            if (LocalVideoActivity.this.myo != null) {
                LocalVideoActivity.this.myo.fq(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.myo != null) {
                if (view != LocalVideoActivity.this.myo.dCv()) {
                    if (view == LocalVideoActivity.this.myo.dCw()) {
                        if (!LocalVideoActivity.this.myo.dCt()) {
                            if (LocalVideoActivity.this.myo.dCz() == null || LocalVideoActivity.this.myo.dCz().getDuration() <= 600000) {
                                VideoConvertUtil dCo = LocalVideoActivity.this.dCo();
                                if (!dCo.isConvertRunning()) {
                                    String dCy = LocalVideoActivity.this.myo.dCy();
                                    if (TextUtils.isEmpty(dCy)) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dCy));
                                        return;
                                    } else if (!new File(dCy).exists()) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dCy));
                                        return;
                                    } else {
                                        int RB = e.RB(dCy);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d dCz = LocalVideoActivity.this.myo.dCz();
                                            if (dCz != null) {
                                                LocalVideoActivity.this.myo.coI();
                                                LocalVideoActivity.this.myr = dCz.getVideoPath();
                                                LocalVideoActivity.this.wF(false);
                                                return;
                                            }
                                            return;
                                        } else if (RB >= 1500000) {
                                            if (LocalVideoActivity.this.dAU()) {
                                                File file = new File(com.baidu.tieba.video.e.mtF, "tieba_" + e.RA(dCy) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.myr = file.getAbsolutePath();
                                                dCo.setConvertType(1);
                                                dCo.fW(dCy, LocalVideoActivity.this.myr);
                                                LocalVideoActivity.this.dCp();
                                                LocalVideoActivity.this.myt = false;
                                                LocalVideoActivity.this.myu = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d dCz2 = LocalVideoActivity.this.myo.dCz();
                                            if (dCz2 != null) {
                                                if (dCz2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.myo.coI();
                                                    LocalVideoActivity.this.myr = dCz2.getVideoPath();
                                                    LocalVideoActivity.this.wF(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.mtF, "tieba_" + e.RA(dCy) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.myr = file2.getAbsolutePath();
                                                dCo.setConvertType(2);
                                                dCo.fW(dCy, LocalVideoActivity.this.myr);
                                                LocalVideoActivity.this.dCp();
                                                LocalVideoActivity.this.myt = false;
                                                LocalVideoActivity.this.myu = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.myo.dCu();
                            return;
                        }
                        l.showToast(LocalVideoActivity.this, R.string.show_video_file_error);
                        return;
                    }
                    return;
                }
                LocalVideoActivity.this.finish();
            }
        }
    };
    private Handler myz = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.myz.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.myv != null && LocalVideoActivity.this.myv.isShowing()) {
                        LocalVideoActivity.this.myv.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.myz.sendMessageDelayed(LocalVideoActivity.this.myz.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.myu) {
                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.myt = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.myr) && (file = new File(LocalVideoActivity.this.myr)) != null) {
                        LocalVideoActivity.this.myr = LocalVideoActivity.this.myr.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.myr));
                    }
                    LocalVideoActivity.this.dCq();
                    if (!LocalVideoActivity.this.mys && LocalVideoActivity.this.myo.dCz() != null) {
                        d RV = e.RV(LocalVideoActivity.this.myr);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.myr);
                        videoInfo.setVideoDuration(((int) RV.getDuration()) / 1000);
                        videoInfo.setVideoWidth(RV.getVideoWidth());
                        videoInfo.setVideoHeight(RV.getVideoHeight());
                        videoInfo.setVideoLength(new File(RV.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.mvc, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                    VideoConvertUtil dCo = LocalVideoActivity.this.dCo();
                    if (dCo != null && dCo.isConvertRunning()) {
                        LocalVideoActivity.this.dCr();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.myt = false;
            LocalVideoActivity.this.dCq();
        }
    };
    private com.baidu.tieba.video.d myA = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void dAP() {
        }

        @Override // com.baidu.tieba.video.d
        public void IJ(int i) {
            LocalVideoActivity.this.myz.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.myz.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.myz.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.myz.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.myz.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener myB = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil dCo() {
        if (this.myq == null) {
            this.myq = new VideoConvertUtil(this);
            this.myq.a(this.myA);
        }
        return this.myq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCp() {
        this.myo.coI();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.myv == null) {
                this.myv = new LocalVideoCompressingDialogView(this);
            }
            if (this.myv.getParent() == null) {
                relativeLayout.addView(this.myv);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.myv.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.myv.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.myv.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCq() {
        this.myo.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.myv.getParent() != null) {
            relativeLayout.removeView(this.myv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCr() {
        dCo().abortConvert();
        this.myu = true;
        if (this.myr != null) {
            File file = new File(this.myr);
            if (file.exists()) {
                file.delete();
            }
        }
        dCq();
        this.myr = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dAU() {
        return VideoConvertUtil.dAU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wF(boolean z) {
        d RV = e.RV(this.myr);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.myr);
        videoInfo.setVideoDuration(((int) RV.getDuration()) / 1000);
        videoInfo.setVideoWidth(RV.getVideoWidth());
        videoInfo.setVideoHeight(RV.getVideoHeight());
        videoInfo.setVideoLength(new File(RV.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.mvc, videoInfo)));
        this.myt = false;
        this.myr = null;
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
            this.mvc = getIntent().getStringExtra("video_title");
        }
        this.myo = new c(this, this.mOnClickListener);
        this.myp = new LocalVideoModel(this);
        this.myp.a(this.myy);
        this.myp.dCs();
        registerListener(this.myx);
        registerListener(this.myw);
        registerListener(this.myB);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mys = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mys = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.myo != null) {
            this.myo.dCx();
        }
        if (this.myt && !TextUtils.isEmpty(this.myr) && new File(this.myr).exists()) {
            wF(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.myo != null) {
            this.myo.coJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.myo.coJ();
        if (this.myq != null) {
            this.myq.destroy();
        }
        if (this.myz != null) {
            this.myz.removeMessages(5);
        }
    }
}
