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
    private BaseFragmentActivity cYJ;
    private String fxi;
    private com.baidu.tieba.j.h iGX;
    private String iVV;
    private final CustomMessageListener iZq;
    private VideoFileInfo joe;
    private String jof;
    private AlbumVideoCompressingDialogView jog;
    private VideoConvertUtil joh;
    private boolean joi;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;
    private boolean iZh = false;
    private boolean iZi = false;
    private boolean iZj = false;
    private int joj = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.iGX = lVar.bEz();
        }
        if (this.iGX != null) {
            this.iGX.bEd();
        }
        this.iZq = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.cYJ.setResult(-1, intent);
                    i.this.cYJ.finish();
                }
            }
        };
        this.cYJ = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.iVV = str3;
        this.joh = new VideoConvertUtil(baseFragmentActivity);
        this.joh.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.iZq);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.joe = videoFileInfo;
        this.fxi = str;
        if (this.joe != null && this.cYJ != null) {
            if (this.joe.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                ckt();
            } else if (this.joh == null || !this.joh.isConvertRunning()) {
                String str2 = this.joe.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.cYJ, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    Bi(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.cYJ, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    Bi(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.joe != null) {
                        this.jof = this.joe.videoPath;
                        qC(false);
                        Bi(102);
                    }
                } else if (VideoConvertUtil.Dr(str2) >= 1500000) {
                    if (VideoConvertUtil.ciM()) {
                        this.jof = new File(VideoConvertUtil.iUu, "tieba_" + VideoConvertUtil.Dq(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.joh.setConvertType(1);
                        this.joh.ec(str2, this.jof);
                        cko();
                        this.iZi = false;
                        this.iZj = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.joe;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.jof = new File(VideoConvertUtil.iUu, "tieba_" + VideoConvertUtil.Dq(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.joh.setConvertType(2);
                            this.joh.ec(str2, this.jof);
                            cko();
                            this.iZi = false;
                            this.iZj = false;
                            return;
                        }
                        this.jof = videoFileInfo2.videoPath;
                        qC(false);
                        Bi(102);
                    }
                }
            }
        }
    }

    private void ckt() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.cYJ).gB(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.cYJ.getPageContext());
        a.dr(false);
        a.aaW();
    }

    private void cko() {
        RelativeLayout relativeLayout = (RelativeLayout) this.cYJ.findViewById(d.g.parent);
        if (relativeLayout != null) {
            if (this.jog == null) {
                this.jog = new AlbumVideoCompressingDialogView(this.cYJ);
            }
            if (this.jog.getParent() == null) {
                relativeLayout.addView(this.jog);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jog.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.jog.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.jog.setPercent(0);
        this.joi = true;
    }

    private void qC(boolean z) {
        VideoFileInfo Eq = Eq(this.jof);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jof);
        videoInfo.setVideoDuration(Eq.videoDuration / 1000);
        videoInfo.setVideoWidth(Eq.videoWidth);
        videoInfo.setVideoHeight(Eq.videoHeight);
        videoInfo.setVideoLength(new File(Eq.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.cYJ, this.fxi, this.mForumName, this.mForumId, this.iVV, videoInfo);
        editVideoActivityConfig.setProZone(this.joj);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        this.iZi = false;
        this.jof = null;
        if (this.iGX != null) {
            this.iGX.bEg();
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
                if (this.jog != null && this.jog.isShowing()) {
                    this.jog.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.iZj) {
                    com.baidu.adp.lib.util.l.showToast(this.cYJ, d.j.mv_local_video_compress_failed);
                    Bi(103);
                }
                this.joi = false;
                this.iZi = false;
                ckp();
                break;
            case 3:
                this.joi = false;
                this.iZi = true;
                if (!StringUtils.isNull(this.jof) && (file = new File(this.jof)) != null) {
                    this.jof = this.jof.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.jof));
                }
                ckp();
                if (!this.iZh) {
                    qC(true);
                    if (this.iGX != null) {
                        this.iGX.bEg();
                        break;
                    }
                }
                break;
            case 4:
                this.joi = false;
                this.iZi = false;
                ckp();
                Bi(104);
                break;
            case 5:
                this.joi = false;
                com.baidu.adp.lib.util.l.showToast(this.cYJ, d.j.mv_local_video_compress_failed);
                if (this.joh != null && this.joh.isConvertRunning()) {
                    ckq();
                }
                Bi(105);
                break;
        }
        return true;
    }

    private void ckp() {
        RelativeLayout relativeLayout = (RelativeLayout) this.cYJ.findViewById(d.g.parent);
        if (relativeLayout != null && this.jog.getParent() != null) {
            relativeLayout.removeView(this.jog);
        }
    }

    private void ckq() {
        if (this.joh != null) {
            this.joh.abortConvert();
        }
        this.iZj = true;
        if (this.jof != null) {
            File file = new File(this.jof);
            if (file.exists()) {
                file.delete();
            }
        }
        ckp();
        this.jof = null;
    }

    public void onStart() {
        this.iZh = false;
    }

    public void onStop() {
        this.iZh = true;
    }

    public void onResume() {
        if (this.iZi && !TextUtils.isEmpty(this.jof) && new File(this.jof).exists()) {
            qC(true);
            Bi(101);
        }
        if (this.iGX != null) {
            this.iGX.yV("album");
        }
    }

    public void onDestroy() {
        if (this.joh != null) {
            this.joh.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.iGX != null) {
            this.iGX.yW("album");
        }
        MessageManager.getInstance().unRegisterListener(this.iZq);
    }

    private void Bi(int i) {
        if (this.iGX != null) {
            this.iGX.at(i, "album");
        }
    }

    public boolean cpp() {
        return this.joi;
    }

    public void setProfessionZone(int i) {
        this.joj = i;
    }
}
