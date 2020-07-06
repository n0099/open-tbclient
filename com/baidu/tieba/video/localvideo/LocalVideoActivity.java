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
    private String lVZ;
    private c lZl;
    private LocalVideoModel lZm;
    private VideoConvertUtil lZn;
    private String lZo;
    private LocalVideoCompressingDialogView lZs;
    private String mForumId;
    private String mForumName;
    private boolean lZp = false;
    private boolean lZq = false;
    private boolean lZr = false;
    private CustomMessageListener lZt = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.lZl != null) {
                    LocalVideoActivity.this.lZl.Om(str);
                }
            }
        }
    };
    private CustomMessageListener lZu = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.lZm != null) {
                LocalVideoActivity.this.lZm.dnN();
            }
        }
    };
    private b.a lZv = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void fb(List<d> list) {
            if (LocalVideoActivity.this.lZl != null) {
                LocalVideoActivity.this.lZl.fc(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.lZl != null) {
                if (view != LocalVideoActivity.this.lZl.dnQ()) {
                    if (view == LocalVideoActivity.this.lZl.dnR()) {
                        if (!LocalVideoActivity.this.lZl.dnO()) {
                            if (LocalVideoActivity.this.lZl.dnU() == null || LocalVideoActivity.this.lZl.dnU().getDuration() <= 600000) {
                                VideoConvertUtil dnJ = LocalVideoActivity.this.dnJ();
                                if (!dnJ.isConvertRunning()) {
                                    String dnT = LocalVideoActivity.this.lZl.dnT();
                                    if (TextUtils.isEmpty(dnT)) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dnT));
                                        return;
                                    } else if (!new File(dnT).exists()) {
                                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, dnT));
                                        return;
                                    } else {
                                        int NV = e.NV(dnT);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d dnU = LocalVideoActivity.this.lZl.dnU();
                                            if (dnU != null) {
                                                LocalVideoActivity.this.lZl.caG();
                                                LocalVideoActivity.this.lZo = dnU.getVideoPath();
                                                LocalVideoActivity.this.vm(false);
                                                return;
                                            }
                                            return;
                                        } else if (NV >= 1500000) {
                                            if (LocalVideoActivity.this.dmn()) {
                                                File file = new File(f.lUC, "tieba_" + e.NU(dnT) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.lZo = file.getAbsolutePath();
                                                dnJ.setConvertType(1);
                                                dnJ.fD(dnT, LocalVideoActivity.this.lZo);
                                                LocalVideoActivity.this.dnK();
                                                LocalVideoActivity.this.lZq = false;
                                                LocalVideoActivity.this.lZr = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d dnU2 = LocalVideoActivity.this.lZl.dnU();
                                            if (dnU2 != null) {
                                                if (dnU2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.lZl.caG();
                                                    LocalVideoActivity.this.lZo = dnU2.getVideoPath();
                                                    LocalVideoActivity.this.vm(false);
                                                    return;
                                                }
                                                File file2 = new File(f.lUC, "tieba_" + e.NU(dnT) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.lZo = file2.getAbsolutePath();
                                                dnJ.setConvertType(2);
                                                dnJ.fD(dnT, LocalVideoActivity.this.lZo);
                                                LocalVideoActivity.this.dnK();
                                                LocalVideoActivity.this.lZq = false;
                                                LocalVideoActivity.this.lZr = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.lZl.dnP();
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
    private Handler lZw = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.lZw.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.lZs != null && LocalVideoActivity.this.lZs.isShowing()) {
                        LocalVideoActivity.this.lZs.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.lZw.sendMessageDelayed(LocalVideoActivity.this.lZw.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.lZr) {
                        l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.lZq = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.lZo) && (file = new File(LocalVideoActivity.this.lZo)) != null) {
                        LocalVideoActivity.this.lZo = LocalVideoActivity.this.lZo.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.lZo));
                    }
                    LocalVideoActivity.this.dnL();
                    if (!LocalVideoActivity.this.lZp && LocalVideoActivity.this.lZl.dnU() != null) {
                        d Op = e.Op(LocalVideoActivity.this.lZo);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.lZo);
                        videoInfo.setVideoDuration(((int) Op.getDuration()) / 1000);
                        videoInfo.setVideoWidth(Op.getVideoWidth());
                        videoInfo.setVideoHeight(Op.getVideoHeight());
                        videoInfo.setVideoLength(new File(Op.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, "1", LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.lVZ, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, (int) R.string.mv_local_video_compress_failed);
                    VideoConvertUtil dnJ = LocalVideoActivity.this.dnJ();
                    if (dnJ != null && dnJ.isConvertRunning()) {
                        LocalVideoActivity.this.dnM();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.lZq = false;
            LocalVideoActivity.this.dnL();
        }
    };
    private com.baidu.tieba.video.e lZx = new com.baidu.tieba.video.e() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.e
        public void dmj() {
        }

        @Override // com.baidu.tieba.video.e
        public void FR(int i) {
            LocalVideoActivity.this.lZw.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.e
        public void onConvertSuccess() {
            LocalVideoActivity.this.lZw.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.e
        public void onConvertFailed() {
            LocalVideoActivity.this.lZw.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.e
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.lZw.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.e
        public void onConvertAborted() {
            LocalVideoActivity.this.lZw.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener lZy = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public VideoConvertUtil dnJ() {
        if (this.lZn == null) {
            this.lZn = new VideoConvertUtil(this);
            this.lZn.a(this.lZx);
        }
        return this.lZn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnK() {
        this.lZl.caG();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null) {
            if (this.lZs == null) {
                this.lZs = new LocalVideoCompressingDialogView(this);
            }
            if (this.lZs.getParent() == null) {
                relativeLayout.addView(this.lZs);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lZs.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.lZs.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.lZs.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnL() {
        this.lZl.startVideo();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container);
        if (relativeLayout != null && this.lZs.getParent() != null) {
            relativeLayout.removeView(this.lZs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnM() {
        dnJ().abortConvert();
        this.lZr = true;
        if (this.lZo != null) {
            File file = new File(this.lZo);
            if (file.exists()) {
                file.delete();
            }
        }
        dnL();
        this.lZo = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dmn() {
        return VideoConvertUtil.dmn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vm(boolean z) {
        d Op = e.Op(this.lZo);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.lZo);
        videoInfo.setVideoDuration(((int) Op.getDuration()) / 1000);
        videoInfo.setVideoWidth(Op.getVideoWidth());
        videoInfo.setVideoHeight(Op.getVideoHeight());
        videoInfo.setVideoLength(new File(Op.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, "1", this.mForumName, this.mForumId, this.lVZ, videoInfo)));
        this.lZq = false;
        this.lZo = null;
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
            this.lVZ = getIntent().getStringExtra("video_title");
        }
        this.lZl = new c(this, this.mOnClickListener);
        this.lZm = new LocalVideoModel(this);
        this.lZm.a(this.lZv);
        this.lZm.dnN();
        registerListener(this.lZu);
        registerListener(this.lZt);
        registerListener(this.lZy);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.lZp = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.lZp = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lZl != null) {
            this.lZl.dnS();
        }
        if (this.lZq && !TextUtils.isEmpty(this.lZo) && new File(this.lZo).exists()) {
            vm(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.lZl != null) {
            this.lZl.caH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.lZl.caH();
        if (this.lZn != null) {
            this.lZn.destroy();
        }
        if (this.lZw != null) {
            this.lZw.removeMessages(5);
        }
    }
}
