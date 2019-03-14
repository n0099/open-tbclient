package com.baidu.tieba.write.album;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.j.l;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import java.io.File;
/* loaded from: classes3.dex */
public class i implements Handler.Callback, com.baidu.tieba.video.d {
    private BaseFragmentActivity cYG;
    private String fxu;
    private com.baidu.tieba.j.h iHn;
    private String iWh;
    private final CustomMessageListener iZC;
    private boolean iZt = false;
    private boolean iZu = false;
    private boolean iZv = false;
    private VideoFileInfo joq;
    private String jor;
    private AlbumVideoCompressingDialogView jos;
    private VideoConvertUtil jot;
    private boolean jou;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.iHn = lVar.bEC();
        }
        if (this.iHn != null) {
            this.iHn.bEg();
        }
        this.iZC = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.cYG.setResult(-1, intent);
                    i.this.cYG.finish();
                }
            }
        };
        this.cYG = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.iWh = str3;
        this.jot = new VideoConvertUtil(baseFragmentActivity);
        this.jot.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.iZC);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.joq = videoFileInfo;
        this.fxu = str;
        if (this.joq != null && this.cYG != null) {
            if (this.joq.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                ckv();
            } else if (this.jot == null || !this.jot.isConvertRunning()) {
                String str2 = this.joq.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.cYG, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    Bm(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.cYG, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    Bm(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.joq != null) {
                        this.jor = this.joq.videoPath;
                        qC(false);
                        Bm(102);
                    }
                } else if (VideoConvertUtil.Ds(str2) >= 1500000) {
                    if (VideoConvertUtil.ciO()) {
                        this.jor = new File(VideoConvertUtil.iUG, "tieba_" + VideoConvertUtil.Dr(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.jot.setConvertType(1);
                        this.jot.eb(str2, this.jor);
                        ckq();
                        this.iZu = false;
                        this.iZv = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.joq;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.jor = new File(VideoConvertUtil.iUG, "tieba_" + VideoConvertUtil.Dr(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.jot.setConvertType(2);
                            this.jot.eb(str2, this.jor);
                            ckq();
                            this.iZu = false;
                            this.iZv = false;
                            return;
                        }
                        this.jor = videoFileInfo2.videoPath;
                        qC(false);
                        Bm(102);
                    }
                }
            }
        }
    }

    private void ckv() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.cYG).gC(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.cYG.getPageContext());
        a.dr(false);
        a.aaZ();
    }

    private void ckq() {
        RelativeLayout relativeLayout = (RelativeLayout) this.cYG.findViewById(d.g.parent);
        if (relativeLayout != null) {
            if (this.jos == null) {
                this.jos = new AlbumVideoCompressingDialogView(this.cYG);
            }
            if (this.jos.getParent() == null) {
                relativeLayout.addView(this.jos);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jos.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.jos.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.jos.setPercent(0);
        this.jou = true;
    }

    private void qC(boolean z) {
        VideoFileInfo Er = Er(this.jor);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jor);
        videoInfo.setVideoDuration(Er.videoDuration / 1000);
        videoInfo.setVideoWidth(Er.videoWidth);
        videoInfo.setVideoHeight(Er.videoHeight);
        videoInfo.setVideoLength(new File(Er.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this.cYG, this.fxu, this.mForumName, this.mForumId, this.iWh, videoInfo)));
        this.iZu = false;
        this.jor = null;
        if (this.iHn != null) {
            this.iHn.bEj();
        }
    }

    public static VideoFileInfo Er(String str) {
        File file = new File(str);
        if (file == null || !file.exists() || !file.isFile()) {
            return null;
        }
        VideoFileInfo videoFileInfo = new VideoFileInfo();
        videoFileInfo.videoPath = str;
        videoFileInfo.lastModified = file.lastModified();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                videoFileInfo.videoDuration = com.baidu.adp.lib.g.b.l(mediaMetadataRetriever.extractMetadata(9), 0);
                videoFileInfo.mimeType = mediaMetadataRetriever.extractMetadata(12);
                videoFileInfo.videoWidth = com.baidu.adp.lib.g.b.l(mediaMetadataRetriever.extractMetadata(18), 0);
                videoFileInfo.videoHeight = com.baidu.adp.lib.g.b.l(mediaMetadataRetriever.extractMetadata(19), 0);
                try {
                    mediaMetadataRetriever.release();
                    return videoFileInfo;
                } catch (Exception e) {
                    e.printStackTrace();
                    return videoFileInfo;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    mediaMetadataRetriever.release();
                    return videoFileInfo;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return videoFileInfo;
                }
            }
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    @Override // com.baidu.tieba.video.d
    public void ciK() {
    }

    @Override // com.baidu.tieba.video.d
    public void An(int i) {
        this.mMainThreadHandler.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.d
    public void onConvertSuccess() {
        this.mMainThreadHandler.sendEmptyMessage(3);
    }

    @Override // com.baidu.tieba.video.d
    public void onConvertFailed() {
        this.mMainThreadHandler.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.d
    public void onConvertProgress(int i) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        this.mMainThreadHandler.sendMessage(obtain);
    }

    @Override // com.baidu.tieba.video.d
    public void onConvertAborted() {
        this.mMainThreadHandler.sendEmptyMessage(4);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        File file;
        this.mMainThreadHandler.removeMessages(5);
        switch (message.what) {
            case 1:
                this.mMainThreadHandler.removeMessages(1);
                if (this.jos != null && this.jos.isShowing()) {
                    this.jos.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.iZv) {
                    com.baidu.adp.lib.util.l.showToast(this.cYG, d.j.mv_local_video_compress_failed);
                    Bm(103);
                }
                this.jou = false;
                this.iZu = false;
                ckr();
                break;
            case 3:
                this.jou = false;
                this.iZu = true;
                if (!StringUtils.isNull(this.jor) && (file = new File(this.jor)) != null) {
                    this.jor = this.jor.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.jor));
                }
                ckr();
                if (!this.iZt) {
                    qC(true);
                    if (this.iHn != null) {
                        this.iHn.bEj();
                        break;
                    }
                }
                break;
            case 4:
                this.jou = false;
                this.iZu = false;
                ckr();
                Bm(104);
                break;
            case 5:
                this.jou = false;
                com.baidu.adp.lib.util.l.showToast(this.cYG, d.j.mv_local_video_compress_failed);
                if (this.jot != null && this.jot.isConvertRunning()) {
                    cks();
                }
                Bm(105);
                break;
        }
        return true;
    }

    private void ckr() {
        RelativeLayout relativeLayout = (RelativeLayout) this.cYG.findViewById(d.g.parent);
        if (relativeLayout != null && this.jos.getParent() != null) {
            relativeLayout.removeView(this.jos);
        }
    }

    private void cks() {
        if (this.jot != null) {
            this.jot.abortConvert();
        }
        this.iZv = true;
        if (this.jor != null) {
            File file = new File(this.jor);
            if (file.exists()) {
                file.delete();
            }
        }
        ckr();
        this.jor = null;
    }

    public void onStart() {
        this.iZt = false;
    }

    public void onStop() {
        this.iZt = true;
    }

    public void onResume() {
        if (this.iZu && !TextUtils.isEmpty(this.jor) && new File(this.jor).exists()) {
            qC(true);
            Bm(101);
        }
        if (this.iHn != null) {
            this.iHn.yW("album");
        }
    }

    public void onDestroy() {
        if (this.jot != null) {
            this.jot.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.iHn != null) {
            this.iHn.yX("album");
        }
        MessageManager.getInstance().unRegisterListener(this.iZC);
    }

    private void Bm(int i) {
        if (this.iHn != null) {
            this.iHn.ar(i, "album");
        }
    }

    public boolean cpr() {
        return this.jou;
    }
}
