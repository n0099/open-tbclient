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
    private String mdr;
    private c mgE;
    private LocalVideoModel mgF;
    private VideoConvertUtil mgG;
    private String mgH;
    private LocalVideoCompressingDialogView mgL;
    private boolean mgI = false;
    private boolean mgJ = false;
    private boolean mgK = false;
    private CustomMessageListener mgM = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.mgE != null) {
                    LocalVideoActivity.this.mgE.OU(str);
                }
            }
        }
    };
    private CustomMessageListener mgN = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.mgF != null) {
                LocalVideoActivity.this.mgF.dqX();
            }
        }
    };
    private b.a mgO = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void fh(List<d> list) {
            if (LocalVideoActivity.this.mgE != null) {
                LocalVideoActivity.this.mgE.fi(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.mgE != null) {
                if (view != LocalVideoActivity.this.mgE.dra()) {
                    if (view == LocalVideoActivity.this.mgE.drb()) {
                        if (!LocalVideoActivity.this.mgE.dqY()) {
                            if (LocalVideoActivity.this.mgE.dre() == null || LocalVideoActivity.this.mgE.dre().getDuration() <= 600000) {
                                VideoConvertUtil dqT = LocalVideoActivity.this.dqT();
                                if (!dqT.isConvertRunning()) {
                                    String drd = LocalVideoActivity.this.mgE.drd();
                                    if (TextUtils.isEmpty(drd)) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, drd));
                                        return;
                                    } else if (!new File(drd).exists()) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, drd));
                                        return;
                                    } else {
                                        int OD = e.OD(drd);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d dre = LocalVideoActivity.this.mgE.dre();
                                            if (dre != null) {
                                                LocalVideoActivity.this.mgE.cee();
                                                LocalVideoActivity.this.mgH = dre.getVideoPath();
                                                LocalVideoActivity.this.vQ(false);
                                                return;
                                            }
                                            return;
                                        } else if (OD >= 1500000) {
                                            if (LocalVideoActivity.this.dpz()) {
                                                File file = new File(com.baidu.tieba.video.e.mbU, "tieba_" + e.OC(drd) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.mgH = file.getAbsolutePath();
                                                dqT.setConvertType(1);
                                                dqT.fF(drd, LocalVideoActivity.this.mgH);
                                                LocalVideoActivity.this.dqU();
                                                LocalVideoActivity.this.mgJ = false;
                                                LocalVideoActivity.this.mgK = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d dre2 = LocalVideoActivity.this.mgE.dre();
                                            if (dre2 != null) {
                                                if (dre2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.mgE.cee();
                                                    LocalVideoActivity.this.mgH = dre2.getVideoPath();
                                                    LocalVideoActivity.this.vQ(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.mbU, "tieba_" + e.OC(drd) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.mgH = file2.getAbsolutePath();
                                                dqT.setConvertType(2);
                                                dqT.fF(drd, LocalVideoActivity.this.mgH);
                                                LocalVideoActivity.this.dqU();
                                                LocalVideoActivity.this.mgJ = false;
                                                LocalVideoActivity.this.mgK = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.mgE.dqZ();
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
    private Handler mgP = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.mgP.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.mgL != null && LocalVideoActivity.this.mgL.isShowing()) {
                        LocalVideoActivity.this.mgL.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.mgP.sendMessageDelayed(LocalVideoActivity.this.mgP.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.mgK) {
                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.mgJ = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.mgH) && (file = new File(LocalVideoActivity.this.mgH)) != null) {
                        LocalVideoActivity.this.mgH = LocalVideoActivity.this.mgH.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.mgH));
                    }
                    LocalVideoActivity.this.dqV();
                    if (!LocalVideoActivity.this.mgI && LocalVideoActivity.this.mgE.dre() != null) {
                        d OX = e.OX(LocalVideoActivity.this.mgH);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.mgH);
                        videoInfo.setVideoDuration(((int) OX.getDuration()) / 1000);
                        videoInfo.setVideoWidth(OX.getVideoWidth());
                        videoInfo.setVideoHeight(OX.getVideoHeight());
                        videoInfo.setVideoLength(new File(OX.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.mdr, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                    VideoConvertUtil dqT = LocalVideoActivity.this.dqT();
                    if (dqT != null && dqT.isConvertRunning()) {
                        LocalVideoActivity.this.dqW();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.mgJ = false;
            LocalVideoActivity.this.dqV();
        }
    };
    private com.baidu.tieba.video.d mgQ = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void dpu() {
        }

        @Override // com.baidu.tieba.video.d
        public void Gn(int i) {
            LocalVideoActivity.this.mgP.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.mgP.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.mgP.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.mgP.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.mgP.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener mgR = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil dqT() {
        if (this.mgG == null) {
            this.mgG = new VideoConvertUtil(this);
            this.mgG.a(this.mgQ);
        }
        return this.mgG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqU() {
        this.mgE.cee();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.mgL == null) {
                this.mgL = new LocalVideoCompressingDialogView(this);
            }
            if (this.mgL.getParent() == null) {
                relativeLayout.addView(this.mgL);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mgL.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.mgL.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.mgL.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqV() {
        this.mgE.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.mgL.getParent() != null) {
            relativeLayout.removeView(this.mgL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqW() {
        dqT().abortConvert();
        this.mgK = true;
        if (this.mgH != null) {
            File file = new File(this.mgH);
            if (file.exists()) {
                file.delete();
            }
        }
        dqV();
        this.mgH = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dpz() {
        return VideoConvertUtil.dpz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vQ(boolean z) {
        d OX = e.OX(this.mgH);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.mgH);
        videoInfo.setVideoDuration(((int) OX.getDuration()) / 1000);
        videoInfo.setVideoWidth(OX.getVideoWidth());
        videoInfo.setVideoHeight(OX.getVideoHeight());
        videoInfo.setVideoLength(new File(OX.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.mdr, videoInfo)));
        this.mgJ = false;
        this.mgH = null;
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
            this.mdr = getIntent().getStringExtra("video_title");
        }
        this.mgE = new c(this, this.mOnClickListener);
        this.mgF = new LocalVideoModel(this);
        this.mgF.a(this.mgO);
        this.mgF.dqX();
        registerListener(this.mgN);
        registerListener(this.mgM);
        registerListener(this.mgR);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mgI = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mgI = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mgE != null) {
            this.mgE.drc();
        }
        if (this.mgJ && !TextUtils.isEmpty(this.mgH) && new File(this.mgH).exists()) {
            vQ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.mgE != null) {
            this.mgE.cef();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mgE.cef();
        if (this.mgG != null) {
            this.mgG.destroy();
        }
        if (this.mgP != null) {
            this.mgP.removeMessages(5);
        }
    }
}
