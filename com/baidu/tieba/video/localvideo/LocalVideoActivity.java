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
    private String gDD;
    private g gDM;
    private com.baidu.tieba.video.commonview.a gDQ;
    private c gFZ;
    private LocalVideoModel gGa;
    private String gGb;
    private String mForumId;
    private String mForumName;
    private boolean gDN = false;
    private boolean gDO = false;
    private boolean gDP = false;
    private CustomMessageListener gGc = new CustomMessageListener(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (LocalVideoActivity.this.gFZ != null) {
                    LocalVideoActivity.this.gFZ.tq(str);
                }
            }
        }
    };
    private CustomMessageListener gGd = new CustomMessageListener(CmdConfigCustom.CMD_MOTU_REFRESH_VIDEO) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (LocalVideoActivity.this.gGa != null) {
                LocalVideoActivity.this.gGa.bzs();
            }
        }
    };
    private b.a gGe = new b.a() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.3
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dC(List<d> list) {
            if (LocalVideoActivity.this.gFZ != null) {
                LocalVideoActivity.this.gFZ.dD(list);
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LocalVideoActivity.this.gFZ != null) {
                if (view != LocalVideoActivity.this.gFZ.bzv()) {
                    if (view == LocalVideoActivity.this.gFZ.bzw()) {
                        if (!LocalVideoActivity.this.gFZ.bzt()) {
                            if (LocalVideoActivity.this.gFZ.bzA() == null || LocalVideoActivity.this.gFZ.bzA().getDuration() <= 600000) {
                                g byD = LocalVideoActivity.this.byD();
                                if (!byD.isConvertRunning()) {
                                    String bzz = LocalVideoActivity.this.gFZ.bzz();
                                    if (TextUtils.isEmpty(bzz)) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bzz));
                                        return;
                                    } else if (!new File(bzz).exists()) {
                                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_video_not_exist);
                                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, bzz));
                                        return;
                                    } else {
                                        int tt = e.tt(bzz);
                                        if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                                            d bzA = LocalVideoActivity.this.gFZ.bzA();
                                            if (bzA != null) {
                                                LocalVideoActivity.this.gFZ.aks();
                                                LocalVideoActivity.this.gGb = bzA.getVideoPath();
                                                LocalVideoActivity.this.mX(false);
                                                return;
                                            }
                                            return;
                                        } else if (tt >= 1500000) {
                                            if (LocalVideoActivity.this.bzr()) {
                                                File file = new File(com.baidu.tieba.video.c.gCx, "tieba_" + e.tw(bzz) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.gGb = file.getAbsolutePath();
                                                byD.setConvertType(1);
                                                byD.ch(bzz, LocalVideoActivity.this.gGb);
                                                LocalVideoActivity.this.bzq();
                                                LocalVideoActivity.this.gDO = false;
                                                LocalVideoActivity.this.gDP = false;
                                                return;
                                            }
                                            return;
                                        } else {
                                            d bzA2 = LocalVideoActivity.this.gFZ.bzA();
                                            if (bzA2 != null) {
                                                if (bzA2.getDuration() >= 15000) {
                                                    LocalVideoActivity.this.gFZ.aks();
                                                    LocalVideoActivity.this.gGb = bzA2.getVideoPath();
                                                    LocalVideoActivity.this.mX(false);
                                                    return;
                                                }
                                                File file2 = new File(com.baidu.tieba.video.c.gCx, "tieba_" + e.tw(bzz) + "_tiebaconverting.mp4");
                                                LocalVideoActivity.this.gGb = file2.getAbsolutePath();
                                                byD.setConvertType(2);
                                                byD.ch(bzz, LocalVideoActivity.this.gGb);
                                                LocalVideoActivity.this.bzq();
                                                LocalVideoActivity.this.gDO = false;
                                                LocalVideoActivity.this.gDP = false;
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                }
                                return;
                            }
                            LocalVideoActivity.this.gFZ.bzu();
                            return;
                        }
                        l.showToast(LocalVideoActivity.this, d.j.show_video_file_error);
                        return;
                    }
                    return;
                }
                LocalVideoActivity.this.finish();
            }
        }
    };
    private Handler gDR = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.5
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File file;
            super.handleMessage(message);
            LocalVideoActivity.this.gDR.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (LocalVideoActivity.this.gDQ != null && LocalVideoActivity.this.gDQ.isShowing()) {
                        LocalVideoActivity.this.gDQ.setPercent(message.arg1);
                    }
                    LocalVideoActivity.this.gDR.sendMessageDelayed(LocalVideoActivity.this.gDR.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!LocalVideoActivity.this.gDP) {
                        l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                        break;
                    }
                    break;
                case 3:
                    LocalVideoActivity.this.gDO = true;
                    if (!StringUtils.isNull(LocalVideoActivity.this.gGb) && (file = new File(LocalVideoActivity.this.gGb)) != null) {
                        LocalVideoActivity.this.gGb = LocalVideoActivity.this.gGb.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(LocalVideoActivity.this.gGb));
                    }
                    LocalVideoActivity.this.byB();
                    if (!LocalVideoActivity.this.gDN && LocalVideoActivity.this.gFZ.bzA() != null) {
                        d tv2 = e.tv(LocalVideoActivity.this.gGb);
                        VideoInfo videoInfo = new VideoInfo();
                        videoInfo.setVideoPath(LocalVideoActivity.this.gGb);
                        videoInfo.setVideoDuration(((int) tv2.getDuration()) / 1000);
                        videoInfo.setVideoWidth(tv2.getVideoWidth());
                        videoInfo.setVideoHeight(tv2.getVideoHeight());
                        videoInfo.setVideoLength(new File(tv2.getVideoPath()).length());
                        videoInfo.setVideoType(2);
                        videoInfo.setIsCompressedVideo(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(LocalVideoActivity.this, LocalVideoActivity.this.mForumName, LocalVideoActivity.this.mForumId, LocalVideoActivity.this.gDD, videoInfo)));
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    l.showToast(LocalVideoActivity.this, d.j.mv_local_video_compress_failed);
                    g byD = LocalVideoActivity.this.byD();
                    if (byD != null && byD.isConvertRunning()) {
                        LocalVideoActivity.this.byC();
                        return;
                    }
                    return;
                default:
                    return;
            }
            LocalVideoActivity.this.gDO = false;
            LocalVideoActivity.this.byB();
        }
    };
    private f gDS = new f() { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.6
        @Override // com.baidu.tieba.video.localvideo.f
        public void byN() {
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void uM(int i) {
            LocalVideoActivity.this.gDR.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertSuccess() {
            LocalVideoActivity.this.gDR.sendEmptyMessage(3);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertFailed() {
            LocalVideoActivity.this.gDR.sendEmptyMessage(2);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertProgress(int i) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = i;
            LocalVideoActivity.this.gDR.sendMessage(obtain);
        }

        @Override // com.baidu.tieba.video.localvideo.f
        public void onConvertAborted() {
            LocalVideoActivity.this.gDR.sendEmptyMessage(4);
        }
    };
    private final CustomMessageListener gGf = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.localvideo.LocalVideoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                LocalVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public g byD() {
        if (this.gDM == null) {
            this.gDM = new g(this);
            this.gDM.a(this.gDS);
        }
        return this.gDM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzq() {
        this.gFZ.aks();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null) {
            if (this.gDQ == null) {
                this.gDQ = new com.baidu.tieba.video.commonview.a(this);
            }
            if (this.gDQ.getParent() == null) {
                relativeLayout.addView(this.gDQ);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gDQ.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.addRule(13);
                this.gDQ.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.gDQ.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byB() {
        this.gFZ.bzx();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.container);
        if (relativeLayout != null && this.gDQ.getParent() != null) {
            relativeLayout.removeView(this.gDQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byC() {
        byD().abortConvert();
        this.gDP = true;
        if (this.gGb != null) {
            File file = new File(this.gGb);
            if (file.exists()) {
                file.delete();
            }
        }
        byB();
        this.gGb = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzr() {
        File file = new File(com.baidu.tieba.video.c.gCx);
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
    public void mX(boolean z) {
        d tv2 = e.tv(this.gGb);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.gGb);
        videoInfo.setVideoDuration(((int) tv2.getDuration()) / 1000);
        videoInfo.setVideoWidth(tv2.getVideoWidth());
        videoInfo.setVideoHeight(tv2.getVideoHeight());
        videoInfo.setVideoLength(new File(tv2.getVideoPath()).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, this.mForumName, this.mForumId, this.gDD, videoInfo)));
        this.gDO = false;
        this.gGb = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(d.h.local_video_activity);
        if (getIntent() != null) {
            this.mForumId = getIntent().getStringExtra("forum_id");
            this.mForumName = getIntent().getStringExtra("forum_name");
            this.gDD = getIntent().getStringExtra("video_title");
        }
        this.gFZ = new c(this, this.mOnClickListener);
        this.gGa = new LocalVideoModel(this);
        this.gGa.a(this.gGe);
        this.gGa.bzs();
        registerListener(this.gGd);
        registerListener(this.gGc);
        registerListener(this.gGf);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gDN = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gDN = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gFZ != null) {
            this.gFZ.bzy();
        }
        if (this.gDO && !TextUtils.isEmpty(this.gGb) && new File(this.gGb).exists()) {
            mX(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gFZ != null) {
            this.gFZ.akt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.gFZ.akt();
        if (this.gDM != null) {
            this.gDM.destroy();
        }
        if (this.gDR != null) {
            this.gDR.removeMessages(5);
        }
    }
}
