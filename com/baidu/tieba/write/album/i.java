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
    private com.baidu.tieba.j.h iHv;
    private String iWp;
    private boolean iZB = false;
    private boolean iZC = false;
    private boolean iZD = false;
    private final CustomMessageListener iZK;
    private AlbumVideoCompressingDialogView joA;
    private VideoConvertUtil joB;
    private boolean joC;
    private VideoFileInfo joy;
    private String joz;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.iHv = lVar.bED();
        }
        if (this.iHv != null) {
            this.iHv.bEh();
        }
        this.iZK = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
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
        this.iWp = str3;
        this.joB = new VideoConvertUtil(baseFragmentActivity);
        this.joB.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.iZK);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.joy = videoFileInfo;
        this.fxv = str;
        if (this.joy != null && this.cYK != null) {
            if (this.joy.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                cks();
            } else if (this.joB == null || !this.joB.isConvertRunning()) {
                String str2 = this.joy.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.cYK, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    Bm(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.cYK, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    Bm(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.joy != null) {
                        this.joz = this.joy.videoPath;
                        qC(false);
                        Bm(102);
                    }
                } else if (VideoConvertUtil.Du(str2) >= 1500000) {
                    if (VideoConvertUtil.ciL()) {
                        this.joz = new File(VideoConvertUtil.iUO, "tieba_" + VideoConvertUtil.Dt(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.joB.setConvertType(1);
                        this.joB.ec(str2, this.joz);
                        ckn();
                        this.iZC = false;
                        this.iZD = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.joy;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.joz = new File(VideoConvertUtil.iUO, "tieba_" + VideoConvertUtil.Dt(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.joB.setConvertType(2);
                            this.joB.ec(str2, this.joz);
                            ckn();
                            this.iZC = false;
                            this.iZD = false;
                            return;
                        }
                        this.joz = videoFileInfo2.videoPath;
                        qC(false);
                        Bm(102);
                    }
                }
            }
        }
    }

    private void cks() {
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

    private void ckn() {
        RelativeLayout relativeLayout = (RelativeLayout) this.cYK.findViewById(d.g.parent);
        if (relativeLayout != null) {
            if (this.joA == null) {
                this.joA = new AlbumVideoCompressingDialogView(this.cYK);
            }
            if (this.joA.getParent() == null) {
                relativeLayout.addView(this.joA);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.joA.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.joA.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.joA.setPercent(0);
        this.joC = true;
    }

    private void qC(boolean z) {
        VideoFileInfo Et = Et(this.joz);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.joz);
        videoInfo.setVideoDuration(Et.videoDuration / 1000);
        videoInfo.setVideoWidth(Et.videoWidth);
        videoInfo.setVideoHeight(Et.videoHeight);
        videoInfo.setVideoLength(new File(Et.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this.cYK, this.fxv, this.mForumName, this.mForumId, this.iWp, videoInfo)));
        this.iZC = false;
        this.joz = null;
        if (this.iHv != null) {
            this.iHv.bEk();
        }
    }

    public static VideoFileInfo Et(String str) {
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
    public void ciH() {
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
                if (this.joA != null && this.joA.isShowing()) {
                    this.joA.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.iZD) {
                    com.baidu.adp.lib.util.l.showToast(this.cYK, d.j.mv_local_video_compress_failed);
                    Bm(103);
                }
                this.joC = false;
                this.iZC = false;
                cko();
                break;
            case 3:
                this.joC = false;
                this.iZC = true;
                if (!StringUtils.isNull(this.joz) && (file = new File(this.joz)) != null) {
                    this.joz = this.joz.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.joz));
                }
                cko();
                if (!this.iZB) {
                    qC(true);
                    if (this.iHv != null) {
                        this.iHv.bEk();
                        break;
                    }
                }
                break;
            case 4:
                this.joC = false;
                this.iZC = false;
                cko();
                Bm(104);
                break;
            case 5:
                this.joC = false;
                com.baidu.adp.lib.util.l.showToast(this.cYK, d.j.mv_local_video_compress_failed);
                if (this.joB != null && this.joB.isConvertRunning()) {
                    ckp();
                }
                Bm(105);
                break;
        }
        return true;
    }

    private void cko() {
        RelativeLayout relativeLayout = (RelativeLayout) this.cYK.findViewById(d.g.parent);
        if (relativeLayout != null && this.joA.getParent() != null) {
            relativeLayout.removeView(this.joA);
        }
    }

    private void ckp() {
        if (this.joB != null) {
            this.joB.abortConvert();
        }
        this.iZD = true;
        if (this.joz != null) {
            File file = new File(this.joz);
            if (file.exists()) {
                file.delete();
            }
        }
        cko();
        this.joz = null;
    }

    public void onStart() {
        this.iZB = false;
    }

    public void onStop() {
        this.iZB = true;
    }

    public void onResume() {
        if (this.iZC && !TextUtils.isEmpty(this.joz) && new File(this.joz).exists()) {
            qC(true);
            Bm(101);
        }
        if (this.iHv != null) {
            this.iHv.yY("album");
        }
    }

    public void onDestroy() {
        if (this.joB != null) {
            this.joB.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.iHv != null) {
            this.iHv.yZ("album");
        }
        MessageManager.getInstance().unRegisterListener(this.iZK);
    }

    private void Bm(int i) {
        if (this.iHv != null) {
            this.iHv.ar(i, "album");
        }
    }

    public boolean cpo() {
        return this.joC;
    }
}
