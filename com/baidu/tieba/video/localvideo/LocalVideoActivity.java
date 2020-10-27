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
/* loaded from: classes23.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String mForumId;
    private String mForumName;
    private String nht;
    private c nkD;
    private LocalVideoModel nkE;
    private VideoConvertUtil nkF;
    private String nkG;
    private LocalVideoCompressingDialogView nkK;
    private boolean nkH = false;
    private boolean nkI = false;
    private boolean nkJ = false;
    private CustomMessageListener nkL = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.nkD != null) {
                    LocalVideoActivity.this.nkD.TF(str);
                }
            }
        }
    };
    private CustomMessageListener nkM = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.nkE != null) {
                LocalVideoActivity.this.nkE.dNp();
            }
        }
    };
    private b.a nkN = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void fK(List<d> list) {
            if (LocalVideoActivity.this.nkD != null) {
                LocalVideoActivity.this.nkD.fL(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.nkD != null) {
                if (view != LocalVideoActivity.this.nkD.dNs()) {
                    if (view == LocalVideoActivity.this.nkD.dNt()) {
                        if (!LocalVideoActivity.this.nkD.dNq()) {
                            if (LocalVideoActivity.this.nkD.dNw() == null || LocalVideoActivity.this.nkD.dNw().getDuration() <= 600000) {
                                VideoConvertUtil dNl = LocalVideoActivity.this.dNl();
                                if (!dNl.isConvertRunning()) {
                                    String dNv = LocalVideoActivity.this.nkD.dNv();
                                    if (TextUtils.isEmpty(dNv)) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dNv));
                                        return;
                                    } else if (!new File(dNv).exists()) {
                                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dNv));
                                        return;
                                    } else {
                                        int To = e.To(dNv);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d dNw = LocalVideoActivity.this.nkD.dNw();
                                            if (dNw != null) {
                                                LocalVideoActivity.this.nkD.pauseVideo();
                                                LocalVideoActivity.this.nkG = dNw.getVideoPath();
                                                LocalVideoActivity.this.xO(false);
                                                return;
                                            }
                                            return;
                                        } else if (To >= 1500000) {
                                            if (LocalVideoActivity.this.dLR()) {
                                                File file = new File(com.baidu.tieba.video.e.nfW, "tieba_" + e.Tn(dNv) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.nkG = file.getAbsolutePath();
                                                dNl.setConvertType(1);
                                                dNl.gv(dNv, LocalVideoActivity.this.nkG);
                                                LocalVideoActivity.this.dNm();
                                                LocalVideoActivity.this.nkI = false;
                                                LocalVideoActivity.this.nkJ = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d dNw2 = LocalVideoActivity.this.nkD.dNw();
                                            if (dNw2 != null) {
                                                if (dNw2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.nkD.pauseVideo();
                                                    LocalVideoActivity.this.nkG = dNw2.getVideoPath();
                                                    LocalVideoActivity.this.xO(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.e.nfW, "tieba_" + e.Tn(dNv) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.nkG = file2.getAbsolutePath();
                                                dNl.setConvertType(2);
                                                dNl.gv(dNv, LocalVideoActivity.this.nkG);
                                                LocalVideoActivity.this.dNm();
                                                LocalVideoActivity.this.nkI = false;
                                                LocalVideoActivity.this.nkJ = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.nkD.dNr();
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
    private Handler nkO = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.nkO.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.nkK != null && LocalVideoActivity.this.nkK.isShowing()) {
                        LocalVideoActivity.this.nkK.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.nkO.sendMessageDelayed(LocalVideoActivity.this.nkO.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.nkJ) {
                        l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.nkI = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.nkG) && (file = new File(LocalVideoActivity.this.nkG)) != null) {
                        LocalVideoActivity.this.nkG = LocalVideoActivity.this.nkG.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.nkG));
                    }
                    LocalVideoActivity.this.dNn();
                    if (!LocalVideoActivity.this.nkH && LocalVideoActivity.this.nkD.dNw() != null) {
                        d TI = e.TI(LocalVideoActivity.this.nkG);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.nkG);
                        videoInfo.setVideoDuration(((int) TI.getDuration()) / 1000);
                        videoInfo.setVideoWidth(TI.getVideoWidth());
                        videoInfo.setVideoHeight(TI.getVideoHeight());
                        videoInfo.setVideoLength(new File(TI.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.nht, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, R.string.mv_local_video_compress_failed);
                    VideoConvertUtil dNl = LocalVideoActivity.this.dNl();
                    if (dNl != null && dNl.isConvertRunning()) {
                        LocalVideoActivity.this.dNo();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.nkI = false;
            LocalVideoActivity.this.dNn();
        }
    };
    private com.baidu.tieba.video.d nkP = new com.baidu.tieba.video.d() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.d
        public void dLM() {
        }

        @Override // com.baidu.tieba.video.d
        public void Kl(int i) {
            LocalVideoActivity.this.nkO.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertSuccess() {
            LocalVideoActivity.this.nkO.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertFailed() {
            LocalVideoActivity.this.nkO.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.nkO.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.d
        public void onConvertAborted() {
            LocalVideoActivity.this.nkO.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener nkQ = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil dNl() {
        if (this.nkF == null) {
            this.nkF = new VideoConvertUtil(this);
            this.nkF.a(this.nkP);
        }
        return this.nkF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNm() {
        this.nkD.pauseVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.nkK == null) {
                this.nkK = new LocalVideoCompressingDialogView(this);
            }
            if (this.nkK.getParent() == null) {
                relativeLayout.addView(this.nkK);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nkK.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.nkK.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.nkK.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNn() {
        this.nkD.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.nkK.getParent() != null) {
            relativeLayout.removeView(this.nkK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNo() {
        dNl().abortConvert();
        this.nkJ = true;
        if (this.nkG != null) {
            File file = new File(this.nkG);
            if (file.exists()) {
                file.delete();
            }
        }
        dNn();
        this.nkG = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dLR() {
        return VideoConvertUtil.dLR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xO(boolean z) {
        d TI = e.TI(this.nkG);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nkG);
        videoInfo.setVideoDuration(((int) TI.getDuration()) / 1000);
        videoInfo.setVideoWidth(TI.getVideoWidth());
        videoInfo.setVideoHeight(TI.getVideoHeight());
        videoInfo.setVideoLength(new File(TI.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.nht, videoInfo)));
        this.nkI = false;
        this.nkG = null;
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
            this.nht = getIntent().getStringExtra("video_title");
        }
        this.nkD = new c(this, this.mOnClickListener);
        this.nkE = new LocalVideoModel(this);
        this.nkE.a(this.nkN);
        this.nkE.dNp();
        registerListener(this.nkM);
        registerListener(this.nkL);
        registerListener(this.nkQ);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.nkH = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.nkH = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nkD != null) {
            this.nkD.dNu();
        }
        if (this.nkI && !TextUtils.isEmpty(this.nkG) && new File(this.nkG).exists()) {
            xO(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.nkD != null) {
            this.nkD.cyB();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.nkD.cyB();
        if (this.nkF != null) {
            this.nkF.destroy();
        }
        if (this.nkO != null) {
            this.nkO.removeMessages(5);
        }
    }
}
