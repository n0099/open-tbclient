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
    private BaseFragmentActivity gRv;
    private String hOj;
    private String lBh;
    private final CustomMessageListener lEy;
    private FrsTabInfoData lRr;
    private VideoFileInfo lSt;
    private String lSu;
    private AlbumVideoCompressingDialogView lSv;
    private VideoConvertUtil lSw;
    private boolean lSx;
    private com.baidu.tieba.k.h lmg;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private boolean lEp = false;
    private boolean lEq = false;
    private boolean lEr = false;
    private int lSy = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.lmg = lVar.cyB();
        }
        if (this.lmg != null) {
            this.lmg.cyd();
        }
        this.lEy = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    intent.putExtra(PostWriteCallBackData.GENERAL_TAB_ID, ((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId());
                    i.this.gRv.setResult(-1, intent);
                    i.this.gRv.finish();
                }
            }
        };
        this.gRv = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.lBh = str3;
        this.lSw = new VideoConvertUtil(baseFragmentActivity);
        this.lSw.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.lEy);
    }

    public void a(FrsTabInfoData frsTabInfoData) {
        this.lRr = frsTabInfoData;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.lSt = videoFileInfo;
        this.hOj = str;
        this.mFrom = str2;
        if (this.lSt != null && this.gRv != null) {
            if (this.lSt.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                djk();
            } else if (this.lSw == null || !this.lSw.isConvertRunning()) {
                String str3 = this.lSt.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    com.baidu.adp.lib.util.l.showToast(this.gRv, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    FC(107);
                } else if (!new File(str3).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.gRv, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    FC(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.lSt != null) {
                        this.lSu = this.lSt.videoPath;
                        uU(false);
                        FC(102);
                    }
                } else if (VideoConvertUtil.Ns(str3) >= 1500000) {
                    if (VideoConvertUtil.dhJ()) {
                        this.lSu = new File(VideoConvertUtil.lzK, "tieba_" + VideoConvertUtil.Nr(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.lSw.setConvertType(1);
                        this.lSw.fw(str3, this.lSu);
                        djf();
                        this.lEq = false;
                        this.lEr = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.lSt;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.lSu = new File(VideoConvertUtil.lzK, "tieba_" + VideoConvertUtil.Nr(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.lSw.setConvertType(2);
                            this.lSw.fw(str3, this.lSu);
                            djf();
                            this.lEq = false;
                            this.lEr = false;
                            return;
                        }
                        this.lSu = videoFileInfo2.videoPath;
                        uU(false);
                        FC(102);
                    }
                }
            }
        }
    }

    private void djk() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.gRv).kC(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.gRv.getPageContext());
        a.gX(false);
        a.aST();
    }

    private void djf() {
        RelativeLayout relativeLayout = (RelativeLayout) this.gRv.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.lSv == null) {
                this.lSv = new AlbumVideoCompressingDialogView(this.gRv);
            }
            if (this.lSv.getParent() == null) {
                relativeLayout.addView(this.lSv);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lSv.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.lSv.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.lSv.setPercent(0);
        this.lSx = true;
    }

    private void uU(boolean z) {
        VideoFileInfo Ok = Ok(this.lSu);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.lSu);
        videoInfo.setVideoDuration(Ok.videoDuration / 1000);
        videoInfo.setVideoWidth(Ok.videoWidth);
        videoInfo.setVideoHeight(Ok.videoHeight);
        videoInfo.setVideoLength(new File(Ok.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.gRv, this.hOj, this.mForumName, this.mForumId, this.lBh, videoInfo);
        editVideoActivityConfig.setProZone(this.lSy);
        editVideoActivityConfig.setFrsTabInfo(this.lRr);
        editVideoActivityConfig.setFrom(this.mFrom);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.lEq = false;
        this.lSu = null;
        if (this.lmg != null) {
            this.lmg.cyg();
        }
    }

    public static VideoFileInfo Ok(String str) {
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
    public void dhF() {
    }

    @Override // com.baidu.tieba.video.d
    public void EN(int i) {
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
                if (this.lSv != null && this.lSv.isShowing()) {
                    this.lSv.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.lEr) {
                    com.baidu.adp.lib.util.l.showToast(this.gRv, (int) R.string.mv_local_video_compress_failed);
                    FC(103);
                }
                this.lSx = false;
                this.lEq = false;
                djg();
                break;
            case 3:
                this.lSx = false;
                this.lEq = true;
                if (!StringUtils.isNull(this.lSu) && (file = new File(this.lSu)) != null) {
                    this.lSu = this.lSu.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.lSu));
                }
                djg();
                if (!this.lEp) {
                    uU(true);
                    if (this.lmg != null) {
                        this.lmg.cyg();
                        break;
                    }
                }
                break;
            case 4:
                this.lSx = false;
                this.lEq = false;
                djg();
                FC(104);
                break;
            case 5:
                this.lSx = false;
                com.baidu.adp.lib.util.l.showToast(this.gRv, (int) R.string.mv_local_video_compress_failed);
                if (this.lSw != null && this.lSw.isConvertRunning()) {
                    djh();
                }
                FC(105);
                break;
        }
        return true;
    }

    private void djg() {
        RelativeLayout relativeLayout = (RelativeLayout) this.gRv.findViewById(R.id.parent);
        if (relativeLayout != null && this.lSv.getParent() != null) {
            relativeLayout.removeView(this.lSv);
        }
    }

    private void djh() {
        if (this.lSw != null) {
            this.lSw.abortConvert();
        }
        this.lEr = true;
        if (this.lSu != null) {
            File file = new File(this.lSu);
            if (file.exists()) {
                file.delete();
            }
        }
        djg();
        this.lSu = null;
    }

    public void onStart() {
        this.lEp = false;
    }

    public void onStop() {
        this.lEp = true;
    }

    public void onResume() {
        if (this.lEq && !TextUtils.isEmpty(this.lSu) && new File(this.lSu).exists()) {
            uU(true);
            FC(101);
        }
        if (this.lmg != null) {
            this.lmg.Iu("album");
        }
    }

    public void onDestroy() {
        if (this.lSw != null) {
            this.lSw.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.lmg != null) {
            this.lmg.Iv("album");
        }
        MessageManager.getInstance().unRegisterListener(this.lEy);
    }

    private void FC(int i) {
        if (this.lmg != null) {
            this.lmg.bk(i, "album");
        }
    }

    public boolean dmQ() {
        return this.lSx;
    }

    public void setProfessionZone(int i) {
        this.lSy = i;
    }
}
