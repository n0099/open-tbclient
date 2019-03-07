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
    private BaseFragmentActivity cYK;
    private String fxv;
    private com.baidu.tieba.j.h iHu;
    private String iVV;
    private boolean iZh = false;
    private boolean iZi = false;
    private boolean iZj = false;
    private final CustomMessageListener iZq;
    private VideoFileInfo jof;
    private String jog;
    private AlbumVideoCompressingDialogView joh;
    private VideoConvertUtil joi;
    private boolean joj;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.iHu = lVar.bEC();
        }
        if (this.iHu != null) {
            this.iHu.bEg();
        }
        this.iZq = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.cYK.setResult(-1, intent);
                    i.this.cYK.finish();
                }
            }
        };
        this.cYK = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.iVV = str3;
        this.joi = new VideoConvertUtil(baseFragmentActivity);
        this.joi.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.iZq);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.jof = videoFileInfo;
        this.fxv = str;
        if (this.jof != null && this.cYK != null) {
            if (this.jof.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                cki();
            } else if (this.joi == null || !this.joi.isConvertRunning()) {
                String str2 = this.jof.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.cYK, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    Bl(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.cYK, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    Bl(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.jof != null) {
                        this.jog = this.jof.videoPath;
                        qC(false);
                        Bl(102);
                    }
                } else if (VideoConvertUtil.Dr(str2) >= 1500000) {
                    if (VideoConvertUtil.ciB()) {
                        this.jog = new File(VideoConvertUtil.iUu, "tieba_" + VideoConvertUtil.Dq(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.joi.setConvertType(1);
                        this.joi.ec(str2, this.jog);
                        ckd();
                        this.iZi = false;
                        this.iZj = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.jof;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.jog = new File(VideoConvertUtil.iUu, "tieba_" + VideoConvertUtil.Dq(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.joi.setConvertType(2);
                            this.joi.ec(str2, this.jog);
                            ckd();
                            this.iZi = false;
                            this.iZj = false;
                            return;
                        }
                        this.jog = videoFileInfo2.videoPath;
                        qC(false);
                        Bl(102);
                    }
                }
            }
        }
    }

    private void cki() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.cYK).gC(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.cYK.getPageContext());
        a.dr(false);
        a.aaZ();
    }

    private void ckd() {
        RelativeLayout relativeLayout = (RelativeLayout) this.cYK.findViewById(d.g.parent);
        if (relativeLayout != null) {
            if (this.joh == null) {
                this.joh = new AlbumVideoCompressingDialogView(this.cYK);
            }
            if (this.joh.getParent() == null) {
                relativeLayout.addView(this.joh);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.joh.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.joh.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.joh.setPercent(0);
        this.joj = true;
    }

    private void qC(boolean z) {
        VideoFileInfo Eq = Eq(this.jog);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jog);
        videoInfo.setVideoDuration(Eq.videoDuration / 1000);
        videoInfo.setVideoWidth(Eq.videoWidth);
        videoInfo.setVideoHeight(Eq.videoHeight);
        videoInfo.setVideoLength(new File(Eq.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this.cYK, this.fxv, this.mForumName, this.mForumId, this.iVV, videoInfo)));
        this.iZi = false;
        this.jog = null;
        if (this.iHu != null) {
            this.iHu.bEj();
        }
    }

    public static VideoFileInfo Eq(String str) {
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
    public void cix() {
    }

    @Override // com.baidu.tieba.video.d
    public void Am(int i) {
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
                if (this.joh != null && this.joh.isShowing()) {
                    this.joh.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.iZj) {
                    com.baidu.adp.lib.util.l.showToast(this.cYK, d.j.mv_local_video_compress_failed);
                    Bl(103);
                }
                this.joj = false;
                this.iZi = false;
                cke();
                break;
            case 3:
                this.joj = false;
                this.iZi = true;
                if (!StringUtils.isNull(this.jog) && (file = new File(this.jog)) != null) {
                    this.jog = this.jog.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.jog));
                }
                cke();
                if (!this.iZh) {
                    qC(true);
                    if (this.iHu != null) {
                        this.iHu.bEj();
                        break;
                    }
                }
                break;
            case 4:
                this.joj = false;
                this.iZi = false;
                cke();
                Bl(104);
                break;
            case 5:
                this.joj = false;
                com.baidu.adp.lib.util.l.showToast(this.cYK, d.j.mv_local_video_compress_failed);
                if (this.joi != null && this.joi.isConvertRunning()) {
                    ckf();
                }
                Bl(105);
                break;
        }
        return true;
    }

    private void cke() {
        RelativeLayout relativeLayout = (RelativeLayout) this.cYK.findViewById(d.g.parent);
        if (relativeLayout != null && this.joh.getParent() != null) {
            relativeLayout.removeView(this.joh);
        }
    }

    private void ckf() {
        if (this.joi != null) {
            this.joi.abortConvert();
        }
        this.iZj = true;
        if (this.jog != null) {
            File file = new File(this.jog);
            if (file.exists()) {
                file.delete();
            }
        }
        cke();
        this.jog = null;
    }

    public void onStart() {
        this.iZh = false;
    }

    public void onStop() {
        this.iZh = true;
    }

    public void onResume() {
        if (this.iZi && !TextUtils.isEmpty(this.jog) && new File(this.jog).exists()) {
            qC(true);
            Bl(101);
        }
        if (this.iHu != null) {
            this.iHu.yX("album");
        }
    }

    public void onDestroy() {
        if (this.joi != null) {
            this.joi.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.iHu != null) {
            this.iHu.yY("album");
        }
        MessageManager.getInstance().unRegisterListener(this.iZq);
    }

    private void Bl(int i) {
        if (this.iHu != null) {
            this.iHu.ar(i, "album");
        }
    }

    public boolean cpe() {
        return this.joj;
    }
}
