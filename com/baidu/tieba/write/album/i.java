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
import com.baidu.searchbox.ng.ai.apps.media.chooser.action.ChooseVideoAction;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.e;
import com.baidu.tieba.j.l;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import java.io.File;
/* loaded from: classes3.dex */
public class i implements Handler.Callback, com.baidu.tieba.video.d {
    private BaseFragmentActivity bLQ;
    private String eeJ;
    private String hBn;
    private boolean hEC = false;
    private boolean hED = false;
    private boolean hEE = false;
    private final CustomMessageListener hEL;
    private VideoFileInfo hTn;
    private String hTo;
    private AlbumVideoCompressingDialogView hTp;
    private VideoConvertUtil hTq;
    private boolean hTr;
    private com.baidu.tieba.j.h hms;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.hms = lVar.bcL();
        }
        if (this.hms != null) {
            this.hms.bcp();
        }
        this.hEL = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.bLQ.setResult(-1, intent);
                    i.this.bLQ.finish();
                }
            }
        };
        this.bLQ = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.hBn = str3;
        this.hTq = new VideoConvertUtil(baseFragmentActivity);
        this.hTq.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.hEL);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hTn = videoFileInfo;
        this.eeJ = str;
        if (this.hTn != null && this.bLQ != null) {
            if (this.hTn.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                bJv();
            } else if (this.hTq == null || !this.hTq.isConvertRunning()) {
                String str2 = this.hTn.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.bLQ, e.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    xi(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.bLQ, e.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    xi(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hTn != null) {
                        this.hTo = this.hTn.videoPath;
                        nY(false);
                        xi(102);
                    }
                } else if (VideoConvertUtil.wy(str2) >= 1500000) {
                    if (VideoConvertUtil.bHP()) {
                        this.hTo = new File(VideoConvertUtil.hzN, "tieba_" + VideoConvertUtil.wx(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hTq.setConvertType(1);
                        this.hTq.cQ(str2, this.hTo);
                        bJq();
                        this.hED = false;
                        this.hEE = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hTn;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hTo = new File(VideoConvertUtil.hzN, "tieba_" + VideoConvertUtil.wx(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hTq.setConvertType(2);
                            this.hTq.cQ(str2, this.hTo);
                            bJq();
                            this.hED = false;
                            this.hEE = false;
                            return;
                        }
                        this.hTo = videoFileInfo2.videoPath;
                        nY(false);
                        xi(102);
                    }
                }
            }
        }
    }

    private void bJv() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.bLQ).da(e.j.mv_local_video_too_long).a(e.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.bLQ.getPageContext());
        a.bg(false);
        a.BF();
    }

    private void bJq() {
        RelativeLayout relativeLayout = (RelativeLayout) this.bLQ.findViewById(e.g.parent);
        if (relativeLayout != null) {
            if (this.hTp == null) {
                this.hTp = new AlbumVideoCompressingDialogView(this.bLQ);
            }
            if (this.hTp.getParent() == null) {
                relativeLayout.addView(this.hTp);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hTp.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hTp.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hTp.setPercent(0);
        this.hTr = true;
    }

    private void nY(boolean z) {
        VideoFileInfo xz = xz(this.hTo);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hTo);
        videoInfo.setVideoDuration(xz.videoDuration / 1000);
        videoInfo.setVideoWidth(xz.videoWidth);
        videoInfo.setVideoHeight(xz.videoHeight);
        videoInfo.setVideoLength(new File(xz.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this.bLQ, this.eeJ, this.mForumName, this.mForumId, this.hBn, videoInfo)));
        this.hED = false;
        this.hTo = null;
        if (this.hms != null) {
            this.hms.bcs();
        }
    }

    public static VideoFileInfo xz(String str) {
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
    public void bHL() {
    }

    @Override // com.baidu.tieba.video.d
    public void wl(int i) {
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
                if (this.hTp != null && this.hTp.isShowing()) {
                    this.hTp.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.hEE) {
                    com.baidu.adp.lib.util.l.showToast(this.bLQ, e.j.mv_local_video_compress_failed);
                    xi(103);
                }
                this.hTr = false;
                this.hED = false;
                bJr();
                break;
            case 3:
                this.hTr = false;
                this.hED = true;
                if (!StringUtils.isNull(this.hTo) && (file = new File(this.hTo)) != null) {
                    this.hTo = this.hTo.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hTo));
                }
                bJr();
                if (!this.hEC) {
                    nY(true);
                    if (this.hms != null) {
                        this.hms.bcs();
                        break;
                    }
                }
                break;
            case 4:
                this.hTr = false;
                this.hED = false;
                bJr();
                xi(104);
                break;
            case 5:
                this.hTr = false;
                com.baidu.adp.lib.util.l.showToast(this.bLQ, e.j.mv_local_video_compress_failed);
                if (this.hTq != null && this.hTq.isConvertRunning()) {
                    bJs();
                }
                xi(105);
                break;
        }
        return true;
    }

    private void bJr() {
        RelativeLayout relativeLayout = (RelativeLayout) this.bLQ.findViewById(e.g.parent);
        if (relativeLayout != null && this.hTp.getParent() != null) {
            relativeLayout.removeView(this.hTp);
        }
    }

    private void bJs() {
        if (this.hTq != null) {
            this.hTq.abortConvert();
        }
        this.hEE = true;
        if (this.hTo != null) {
            File file = new File(this.hTo);
            if (file.exists()) {
                file.delete();
            }
        }
        bJr();
        this.hTo = null;
    }

    public void onStart() {
        this.hEC = false;
    }

    public void onStop() {
        this.hEC = true;
    }

    public void onResume() {
        if (this.hED && !TextUtils.isEmpty(this.hTo) && new File(this.hTo).exists()) {
            nY(true);
            xi(101);
        }
        if (this.hms != null) {
            this.hms.sa(ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
    }

    public void onDestroy() {
        if (this.hTq != null) {
            this.hTq.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.hms != null) {
            this.hms.sb(ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
        MessageManager.getInstance().unRegisterListener(this.hEL);
    }

    private void xi(int i) {
        if (this.hms != null) {
            this.hms.Y(i, ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
    }

    public boolean bNY() {
        return this.hTr;
    }
}
