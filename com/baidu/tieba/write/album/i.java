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
    private String fxi;
    private com.baidu.tieba.j.h iGY;
    private String iVW;
    private final CustomMessageListener iZr;
    private VideoFileInfo jof;
    private String jog;
    private AlbumVideoCompressingDialogView joh;
    private VideoConvertUtil joi;
    private boolean joj;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;
    private boolean iZi = false;
    private boolean iZj = false;
    private boolean iZk = false;
    private int jok = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.iGY = lVar.bEz();
        }
        if (this.iGY != null) {
            this.iGY.bEd();
        }
        this.iZr = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
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
        this.iVW = str3;
        this.joi = new VideoConvertUtil(baseFragmentActivity);
        this.joi.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.iZr);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.jof = videoFileInfo;
        this.fxi = str;
        if (this.jof != null && this.cYK != null) {
            if (this.jof.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                ckt();
            } else if (this.joi == null || !this.joi.isConvertRunning()) {
                String str2 = this.jof.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.cYK, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    Bi(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.cYK, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    Bi(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.jof != null) {
                        this.jog = this.jof.videoPath;
                        qC(false);
                        Bi(102);
                    }
                } else if (VideoConvertUtil.Dr(str2) >= 1500000) {
                    if (VideoConvertUtil.ciM()) {
                        this.jog = new File(VideoConvertUtil.iUv, "tieba_" + VideoConvertUtil.Dq(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.joi.setConvertType(1);
                        this.joi.ec(str2, this.jog);
                        cko();
                        this.iZj = false;
                        this.iZk = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.jof;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.jog = new File(VideoConvertUtil.iUv, "tieba_" + VideoConvertUtil.Dq(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.joi.setConvertType(2);
                            this.joi.ec(str2, this.jog);
                            cko();
                            this.iZj = false;
                            this.iZk = false;
                            return;
                        }
                        this.jog = videoFileInfo2.videoPath;
                        qC(false);
                        Bi(102);
                    }
                }
            }
        }
    }

    private void ckt() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.cYK).gB(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.cYK.getPageContext());
        a.dr(false);
        a.aaW();
    }

    private void cko() {
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
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.cYK, this.fxi, this.mForumName, this.mForumId, this.iVW, videoInfo);
        editVideoActivityConfig.setProZone(this.jok);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        this.iZj = false;
        this.jog = null;
        if (this.iGY != null) {
            this.iGY.bEg();
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
    public void ciI() {
    }

    @Override // com.baidu.tieba.video.d
    public void Aj(int i) {
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
                if (!this.iZk) {
                    com.baidu.adp.lib.util.l.showToast(this.cYK, d.j.mv_local_video_compress_failed);
                    Bi(103);
                }
                this.joj = false;
                this.iZj = false;
                ckp();
                break;
            case 3:
                this.joj = false;
                this.iZj = true;
                if (!StringUtils.isNull(this.jog) && (file = new File(this.jog)) != null) {
                    this.jog = this.jog.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.jog));
                }
                ckp();
                if (!this.iZi) {
                    qC(true);
                    if (this.iGY != null) {
                        this.iGY.bEg();
                        break;
                    }
                }
                break;
            case 4:
                this.joj = false;
                this.iZj = false;
                ckp();
                Bi(104);
                break;
            case 5:
                this.joj = false;
                com.baidu.adp.lib.util.l.showToast(this.cYK, d.j.mv_local_video_compress_failed);
                if (this.joi != null && this.joi.isConvertRunning()) {
                    ckq();
                }
                Bi(105);
                break;
        }
        return true;
    }

    private void ckp() {
        RelativeLayout relativeLayout = (RelativeLayout) this.cYK.findViewById(d.g.parent);
        if (relativeLayout != null && this.joh.getParent() != null) {
            relativeLayout.removeView(this.joh);
        }
    }

    private void ckq() {
        if (this.joi != null) {
            this.joi.abortConvert();
        }
        this.iZk = true;
        if (this.jog != null) {
            File file = new File(this.jog);
            if (file.exists()) {
                file.delete();
            }
        }
        ckp();
        this.jog = null;
    }

    public void onStart() {
        this.iZi = false;
    }

    public void onStop() {
        this.iZi = true;
    }

    public void onResume() {
        if (this.iZj && !TextUtils.isEmpty(this.jog) && new File(this.jog).exists()) {
            qC(true);
            Bi(101);
        }
        if (this.iGY != null) {
            this.iGY.yV("album");
        }
    }

    public void onDestroy() {
        if (this.joi != null) {
            this.joi.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.iGY != null) {
            this.iGY.yW("album");
        }
        MessageManager.getInstance().unRegisterListener(this.iZr);
    }

    private void Bi(int i) {
        if (this.iGY != null) {
            this.iGY.at(i, "album");
        }
    }

    public boolean cpp() {
        return this.joj;
    }

    public void setProfessionZone(int i) {
        this.jok = i;
    }
}
