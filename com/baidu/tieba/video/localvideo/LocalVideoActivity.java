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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.localvideo.b;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class LocalVideoActivity extends BaseActivity<LocalVideoActivity> {
    private String gva;
    private g gvi;
    private com.baidu.tieba.video.commonview.a gvm;
    private c gwK;
    private LocalVideoModel gwL;
    private String gwM;
    private String mForumId;
    private String mForumName;
    private boolean gvj = false;
    private boolean gvk = false;
    private boolean gvl = false;
    private CustomMessageListener gwN = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.gwK != null) {
                    LocalVideoActivity.this.gwK.sF(str);
                }
            }
        }
    };
    private CustomMessageListener gwO = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.gwL != null) {
                LocalVideoActivity.this.gwL.bwp();
            }
        }
    };
    private b.a gwP = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dA(List<d> list) {
            if (LocalVideoActivity.this.gwK != null) {
                LocalVideoActivity.this.gwK.dB(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.gwK != null) {
                if (view != LocalVideoActivity.this.gwK.bwr()) {
                    if (view == LocalVideoActivity.this.gwK.bws()) {
                        if (LocalVideoActivity.this.gwK.bww() == null || LocalVideoActivity.this.gwK.bww().getDuration() <= 600000) {
                            g bvJ = LocalVideoActivity.this.bvJ();
                            if (!bvJ.isConvertRunning()) {
                                String bwv = LocalVideoActivity.this.gwK.bwv();
                                if (TextUtils.isEmpty(bwv)) {
                                    l.showToast(LocalVideoActivity.this, d.l.mv_local_video_video_not_exist);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bwv));
                                    return;
                                } else if (!new File(bwv).exists()) {
                                    l.showToast(LocalVideoActivity.this, d.l.mv_local_video_video_not_exist);
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bwv));
                                    return;
                                } else {
                                    int sI = e.sI(bwv);
                                    if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                        d bww = LocalVideoActivity.this.gwK.bww();
                                        if (bww != null) {
                                            LocalVideoActivity.this.gwK.aip();
                                            LocalVideoActivity.this.gwM = bww.getVideoPath();
                                            LocalVideoActivity.this.nd(false);
                                            return;
                                        }
                                        return;
                                    } else if (sI >= 1500000) {
                                        if (LocalVideoActivity.this.bwo()) {
                                            File file = new File(com.baidu.tieba.video.c.gtZ, "tieba_" + e.sL(bwv) + "_tiebaconverting.mp4");
                                            LocalVideoActivity.this.gwM = file.getAbsolutePath();
                                            bvJ.setConvertType(1);
                                            bvJ.cl(bwv, LocalVideoActivity.this.gwM);
                                            LocalVideoActivity.this.bwn();
                                            LocalVideoActivity.this.gvk = false;
                                            LocalVideoActivity.this.gvl = false;
                                            return;
                                        }
                                        return;
                                    } else {
                                        d bww2 = LocalVideoActivity.this.gwK.bww();
                                        if (bww2 != null) {
                                            if (bww2.getDuration() >= 15000) {
                                                LocalVideoActivity.this.gwK.aip();
                                                LocalVideoActivity.this.gwM = bww2.getVideoPath();
                                                LocalVideoActivity.this.nd(false);
                                                return;
                                            }
                                            File file2 = new File(com.baidu.tieba.video.c.gtZ, "tieba_" + e.sL(bwv) + "_tiebaconverting.mp4");
                                            LocalVideoActivity.this.gwM = file2.getAbsolutePath();
                                            bvJ.setConvertType(2);
                                            bvJ.cl(bwv, LocalVideoActivity.this.gwM);
                                            LocalVideoActivity.this.bwn();
                                            LocalVideoActivity.this.gvk = false;
                                            LocalVideoActivity.this.gvl = false;
                                            return;
                                        }
                                        return;
                                    }
                                }
                            }
                            return;
                        }
                        LocalVideoActivity.this.gwK.bwq();
                        return;
                    }
                    return;
                }
                LocalVideoActivity.this.finish();
            }
        }
    };
    private Handler gvn = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.gvn.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.gvm != null && LocalVideoActivity.this.gvm.isShowing()) {
                        LocalVideoActivity.this.gvm.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.gvn.sendMessageDelayed(LocalVideoActivity.this.gvn.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.gvl) {
                        l.showToast(LocalVideoActivity.this, d.l.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.gvk = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.gwM) && (file = new File(LocalVideoActivity.this.gwM)) != null) {
                        LocalVideoActivity.this.gwM = LocalVideoActivity.this.gwM.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.gwM));
                    }
                    LocalVideoActivity.this.bvH();
                    if (!LocalVideoActivity.this.gvj && LocalVideoActivity.this.gwK.bww() != null) {
                        d sK = e.sK(LocalVideoActivity.this.gwM);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.gwM);
                        videoInfo.setVideoDuration(((int) sK.getDuration()) / 1000);
                        videoInfo.setVideoWidth(sK.getVideoWidth());
                        videoInfo.setVideoHeight(sK.getVideoHeight());
                        videoInfo.setVideoLength(new File(sK.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.gva, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.l.mv_local_video_compress_failed);
                    g bvJ = LocalVideoActivity.this.bvJ();
                    if (bvJ != null && bvJ.isConvertRunning()) {
                        LocalVideoActivity.this.bvI();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.gvk = false;
            LocalVideoActivity.this.bvH();
        }
    };
    private f gvo = new f() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.localvideo.f
        public void bvR() {
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void uw(int i) {
            LocalVideoActivity.this.gvn.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertSuccess() {
            LocalVideoActivity.this.gvn.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertFailed() {
            LocalVideoActivity.this.gvn.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.gvn.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertAborted() {
            LocalVideoActivity.this.gvn.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener gwQ = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public g bvJ() {
        if (this.gvi == null) {
            this.gvi = new g(this);
            this.gvi.a(this.gvo);
        }
        return this.gvi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwn() {
        this.gwK.aip();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.h.container);
        if (relativeLayout != null) {
            if (this.gvm == null) {
                this.gvm = new com.baidu.tieba.video.commonview.a(this);
            }
            if (this.gvm.getParent() == null) {
                relativeLayout.addView(this.gvm);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gvm.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.gvm.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.gvm.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvH() {
        this.gwK.bwt();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.h.container);
        if (relativeLayout != null && this.gvm.getParent() != null) {
            relativeLayout.removeView(this.gvm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvI() {
        bvJ().abortConvert();
        this.gvl = true;
        if (this.gwM != null) {
            File file = new File(this.gwM);
            if (file.exists()) {
                file.delete();
            }
        }
        bvH();
        this.gwM = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bwo() {
        File file = new File(com.baidu.tieba.video.c.gtZ);
        if (file != null) {
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.exists() && file.isDirectory()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nd(boolean z) {
        d sK = e.sK(this.gwM);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.gwM);
        videoInfo.setVideoDuration(((int) sK.getDuration()) / 1000);
        videoInfo.setVideoWidth(sK.getVideoWidth());
        videoInfo.setVideoHeight(sK.getVideoHeight());
        videoInfo.setVideoLength(new File(sK.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, this.mForumName, this.mForumId, this.gva, videoInfo)));
        this.gvk = false;
        this.gwM = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.j.local_video_activity);
        if (getIntent() != null) {
            this.mForumId = getIntent().getStringExtra("forum_id");
            this.mForumName = getIntent().getStringExtra("forum_name");
            this.gva = getIntent().getStringExtra("video_title");
        }
        this.gwK = new c(this, this.mOnClickListener);
        this.gwL = new LocalVideoModel(this);
        this.gwL.a(this.gwP);
        this.gwL.bwp();
        registerListener(this.gwO);
        registerListener(this.gwN);
        registerListener(this.gwQ);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gvj = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gvj = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gwK != null) {
            this.gwK.bwu();
        }
        if (this.gvk && !TextUtils.isEmpty(this.gwM) && new File(this.gwM).exists()) {
            nd(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gwK != null) {
            this.gwK.aiq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gwK.aiq();
        if (this.gvi != null) {
            this.gvi.destroy();
        }
        if (this.gvn != null) {
            this.gvn.removeMessages(5);
        }
    }
}
