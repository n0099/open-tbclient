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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.k.l;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import java.io.File;
/* loaded from: classes2.dex */
public class i implements Handler.Callback, com.baidu.tieba.video.d {
    private BaseFragmentActivity gRG;
    private String hOW;
    private String lCq;
    private final CustomMessageListener lFH;
    private FrsTabInfoData lSC;
    private VideoFileInfo lTE;
    private String lTF;
    private AlbumVideoCompressingDialogView lTG;
    private VideoConvertUtil lTH;
    private boolean lTI;
    private com.baidu.tieba.k.h lnq;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private boolean lFy = false;
    private boolean lFz = false;
    private boolean lFA = false;
    private int lTJ = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.lnq = lVar.cyS();
        }
        if (this.lnq != null) {
            this.lnq.cyu();
        }
        this.lFH = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    intent.putExtra(PostWriteCallBackData.GENERAL_TAB_ID, ((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId());
                    i.this.gRG.setResult(-1, intent);
                    i.this.gRG.finish();
                }
            }
        };
        this.gRG = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.lCq = str3;
        this.lTH = new VideoConvertUtil(baseFragmentActivity);
        this.lTH.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.lFH);
    }

    public void a(FrsTabInfoData frsTabInfoData) {
        this.lSC = frsTabInfoData;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.lTE = videoFileInfo;
        this.hOW = str;
        this.mFrom = str2;
        if (this.lTE != null && this.gRG != null) {
            if (this.lTE.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                djz();
            } else if (this.lTH == null || !this.lTH.isConvertRunning()) {
                String str3 = this.lTE.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    com.baidu.adp.lib.util.l.showToast(this.gRG, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    FE(107);
                } else if (!new File(str3).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.gRG, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    FE(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.lTE != null) {
                        this.lTF = this.lTE.videoPath;
                        uU(false);
                        FE(102);
                    }
                } else if (VideoConvertUtil.Nt(str3) >= 1500000) {
                    if (VideoConvertUtil.dhY()) {
                        this.lTF = new File(VideoConvertUtil.lAT, "tieba_" + VideoConvertUtil.Ns(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.lTH.setConvertType(1);
                        this.lTH.fw(str3, this.lTF);
                        dju();
                        this.lFz = false;
                        this.lFA = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.lTE;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.lTF = new File(VideoConvertUtil.lAT, "tieba_" + VideoConvertUtil.Ns(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.lTH.setConvertType(2);
                            this.lTH.fw(str3, this.lTF);
                            dju();
                            this.lFz = false;
                            this.lFA = false;
                            return;
                        }
                        this.lTF = videoFileInfo2.videoPath;
                        uU(false);
                        FE(102);
                    }
                }
            }
        }
    }

    private void djz() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.gRG).kE(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.gRG.getPageContext());
        a.gX(false);
        a.aST();
    }

    private void dju() {
        RelativeLayout relativeLayout = (RelativeLayout) this.gRG.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.lTG == null) {
                this.lTG = new AlbumVideoCompressingDialogView(this.gRG);
            }
            if (this.lTG.getParent() == null) {
                relativeLayout.addView(this.lTG);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lTG.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.lTG.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.lTG.setPercent(0);
        this.lTI = true;
    }

    private void uU(boolean z) {
        VideoFileInfo Ol = Ol(this.lTF);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.lTF);
        videoInfo.setVideoDuration(Ol.videoDuration / 1000);
        videoInfo.setVideoWidth(Ol.videoWidth);
        videoInfo.setVideoHeight(Ol.videoHeight);
        videoInfo.setVideoLength(new File(Ol.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.gRG, this.hOW, this.mForumName, this.mForumId, this.lCq, videoInfo);
        editVideoActivityConfig.setProZone(this.lTJ);
        editVideoActivityConfig.setFrsTabInfo(this.lSC);
        editVideoActivityConfig.setFrom(this.mFrom);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.lFz = false;
        this.lTF = null;
        if (this.lnq != null) {
            this.lnq.cyx();
        }
    }

    public static VideoFileInfo Ol(String str) {
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
                videoFileInfo.videoDuration = com.baidu.adp.lib.f.b.toInt(mediaMetadataRetriever.extractMetadata(9), 0);
                videoFileInfo.mimeType = mediaMetadataRetriever.extractMetadata(12);
                videoFileInfo.videoWidth = com.baidu.adp.lib.f.b.toInt(mediaMetadataRetriever.extractMetadata(18), 0);
                videoFileInfo.videoHeight = com.baidu.adp.lib.f.b.toInt(mediaMetadataRetriever.extractMetadata(19), 0);
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
    public void dhU() {
    }

    @Override // com.baidu.tieba.video.d
    public void EP(int i) {
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
                if (this.lTG != null && this.lTG.isShowing()) {
                    this.lTG.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.lFA) {
                    com.baidu.adp.lib.util.l.showToast(this.gRG, (int) R.string.mv_local_video_compress_failed);
                    FE(103);
                }
                this.lTI = false;
                this.lFz = false;
                djv();
                break;
            case 3:
                this.lTI = false;
                this.lFz = true;
                if (!StringUtils.isNull(this.lTF) && (file = new File(this.lTF)) != null) {
                    this.lTF = this.lTF.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.lTF));
                }
                djv();
                if (!this.lFy) {
                    uU(true);
                    if (this.lnq != null) {
                        this.lnq.cyx();
                        break;
                    }
                }
                break;
            case 4:
                this.lTI = false;
                this.lFz = false;
                djv();
                FE(104);
                break;
            case 5:
                this.lTI = false;
                com.baidu.adp.lib.util.l.showToast(this.gRG, (int) R.string.mv_local_video_compress_failed);
                if (this.lTH != null && this.lTH.isConvertRunning()) {
                    djw();
                }
                FE(105);
                break;
        }
        return true;
    }

    private void djv() {
        RelativeLayout relativeLayout = (RelativeLayout) this.gRG.findViewById(R.id.parent);
        if (relativeLayout != null && this.lTG.getParent() != null) {
            relativeLayout.removeView(this.lTG);
        }
    }

    private void djw() {
        if (this.lTH != null) {
            this.lTH.abortConvert();
        }
        this.lFA = true;
        if (this.lTF != null) {
            File file = new File(this.lTF);
            if (file.exists()) {
                file.delete();
            }
        }
        djv();
        this.lTF = null;
    }

    public void onStart() {
        this.lFy = false;
    }

    public void onStop() {
        this.lFy = true;
    }

    public void onResume() {
        if (this.lFz && !TextUtils.isEmpty(this.lTF) && new File(this.lTF).exists()) {
            uU(true);
            FE(101);
        }
        if (this.lnq != null) {
            this.lnq.Iv("album");
        }
    }

    public void onDestroy() {
        if (this.lTH != null) {
            this.lTH.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.lnq != null) {
            this.lnq.Iw("album");
        }
        MessageManager.getInstance().unRegisterListener(this.lFH);
    }

    private void FE(int i) {
        if (this.lnq != null) {
            this.lnq.bk(i, "album");
        }
    }

    public boolean dng() {
        return this.lTI;
    }

    public void setProfessionZone(int i) {
        this.lTJ = i;
    }
}
