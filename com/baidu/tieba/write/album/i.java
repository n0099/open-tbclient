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
    private BaseFragmentActivity bLT;
    private String ehA;
    private String hEy;
    private boolean hHN = false;
    private boolean hHO = false;
    private boolean hHP = false;
    private final CustomMessageListener hHW;
    private AlbumVideoCompressingDialogView hWA;
    private VideoConvertUtil hWB;
    private boolean hWC;
    private VideoFileInfo hWy;
    private String hWz;
    private com.baidu.tieba.j.h hpD;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.hpD = lVar.bdz();
        }
        if (this.hpD != null) {
            this.hpD.bdd();
        }
        this.hHW = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.bLT.setResult(-1, intent);
                    i.this.bLT.finish();
                }
            }
        };
        this.bLT = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.hEy = str3;
        this.hWB = new VideoConvertUtil(baseFragmentActivity);
        this.hWB.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.hHW);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hWy = videoFileInfo;
        this.ehA = str;
        if (this.hWy != null && this.bLT != null) {
            if (this.hWy.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                bKl();
            } else if (this.hWB == null || !this.hWB.isConvertRunning()) {
                String str2 = this.hWy.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.bLT, e.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    xv(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.bLT, e.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    xv(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hWy != null) {
                        this.hWz = this.hWy.videoPath;
                        ob(false);
                        xv(102);
                    }
                } else if (VideoConvertUtil.wB(str2) >= 1500000) {
                    if (VideoConvertUtil.bIF()) {
                        this.hWz = new File(VideoConvertUtil.hCY, "tieba_" + VideoConvertUtil.wA(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hWB.setConvertType(1);
                        this.hWB.cQ(str2, this.hWz);
                        bKg();
                        this.hHO = false;
                        this.hHP = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hWy;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hWz = new File(VideoConvertUtil.hCY, "tieba_" + VideoConvertUtil.wA(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hWB.setConvertType(2);
                            this.hWB.cQ(str2, this.hWz);
                            bKg();
                            this.hHO = false;
                            this.hHP = false;
                            return;
                        }
                        this.hWz = videoFileInfo2.videoPath;
                        ob(false);
                        xv(102);
                    }
                }
            }
        }
    }

    private void bKl() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.bLT).da(e.j.mv_local_video_too_long).a(e.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.bLT.getPageContext());
        a.bg(false);
        a.BF();
    }

    private void bKg() {
        RelativeLayout relativeLayout = (RelativeLayout) this.bLT.findViewById(e.g.parent);
        if (relativeLayout != null) {
            if (this.hWA == null) {
                this.hWA = new AlbumVideoCompressingDialogView(this.bLT);
            }
            if (this.hWA.getParent() == null) {
                relativeLayout.addView(this.hWA);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hWA.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hWA.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hWA.setPercent(0);
        this.hWC = true;
    }

    private void ob(boolean z) {
        VideoFileInfo xC = xC(this.hWz);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hWz);
        videoInfo.setVideoDuration(xC.videoDuration / 1000);
        videoInfo.setVideoWidth(xC.videoWidth);
        videoInfo.setVideoHeight(xC.videoHeight);
        videoInfo.setVideoLength(new File(xC.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this.bLT, this.ehA, this.mForumName, this.mForumId, this.hEy, videoInfo)));
        this.hHO = false;
        this.hWz = null;
        if (this.hpD != null) {
            this.hpD.bdg();
        }
    }

    public static VideoFileInfo xC(String str) {
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
    public void bIB() {
    }

    @Override // com.baidu.tieba.video.d
    public void wy(int i) {
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
                if (this.hWA != null && this.hWA.isShowing()) {
                    this.hWA.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.hHP) {
                    com.baidu.adp.lib.util.l.showToast(this.bLT, e.j.mv_local_video_compress_failed);
                    xv(103);
                }
                this.hWC = false;
                this.hHO = false;
                bKh();
                break;
            case 3:
                this.hWC = false;
                this.hHO = true;
                if (!StringUtils.isNull(this.hWz) && (file = new File(this.hWz)) != null) {
                    this.hWz = this.hWz.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hWz));
                }
                bKh();
                if (!this.hHN) {
                    ob(true);
                    if (this.hpD != null) {
                        this.hpD.bdg();
                        break;
                    }
                }
                break;
            case 4:
                this.hWC = false;
                this.hHO = false;
                bKh();
                xv(104);
                break;
            case 5:
                this.hWC = false;
                com.baidu.adp.lib.util.l.showToast(this.bLT, e.j.mv_local_video_compress_failed);
                if (this.hWB != null && this.hWB.isConvertRunning()) {
                    bKi();
                }
                xv(105);
                break;
        }
        return true;
    }

    private void bKh() {
        RelativeLayout relativeLayout = (RelativeLayout) this.bLT.findViewById(e.g.parent);
        if (relativeLayout != null && this.hWA.getParent() != null) {
            relativeLayout.removeView(this.hWA);
        }
    }

    private void bKi() {
        if (this.hWB != null) {
            this.hWB.abortConvert();
        }
        this.hHP = true;
        if (this.hWz != null) {
            File file = new File(this.hWz);
            if (file.exists()) {
                file.delete();
            }
        }
        bKh();
        this.hWz = null;
    }

    public void onStart() {
        this.hHN = false;
    }

    public void onStop() {
        this.hHN = true;
    }

    public void onResume() {
        if (this.hHO && !TextUtils.isEmpty(this.hWz) && new File(this.hWz).exists()) {
            ob(true);
            xv(101);
        }
        if (this.hpD != null) {
            this.hpD.sd(ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
    }

    public void onDestroy() {
        if (this.hWB != null) {
            this.hWB.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.hpD != null) {
            this.hpD.se(ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
        MessageManager.getInstance().unRegisterListener(this.hHW);
    }

    private void xv(int i) {
        if (this.hpD != null) {
            this.hpD.Z(i, ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
    }

    public boolean bOP() {
        return this.hWC;
    }
}
