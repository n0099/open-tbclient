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
import com.baidu.tieba.j.l;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import java.io.File;
/* loaded from: classes3.dex */
public class i implements Handler.Callback, com.baidu.tieba.video.d {
    private String fUk;
    private BaseFragmentActivity fxV;
    private final CustomMessageListener jBc;
    private VideoFileInfo jOL;
    private String jOM;
    private AlbumVideoCompressingDialogView jON;
    private VideoConvertUtil jOO;
    private boolean jOP;
    private com.baidu.tieba.j.h jiP;
    private String jxJ;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;
    private boolean jAT = false;
    private boolean jAU = false;
    private boolean jAV = false;
    private int jOQ = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.jiP = lVar.bMW();
        }
        if (this.jiP != null) {
            this.jiP.bMz();
        }
        this.jBc = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    i.this.fxV.setResult(-1, intent);
                    i.this.fxV.finish();
                }
            }
        };
        this.fxV = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.jxJ = str3;
        this.jOO = new VideoConvertUtil(baseFragmentActivity);
        this.jOO.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.jBc);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.jOL = videoFileInfo;
        this.fUk = str;
        if (this.jOL != null && this.fxV != null) {
            if (this.jOL.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                cug();
            } else if (this.jOO == null || !this.jOO.isConvertRunning()) {
                String str2 = this.jOL.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.fxV, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    Bz(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.fxV, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    Bz(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.jOL != null) {
                        this.jOM = this.jOL.videoPath;
                        rs(false);
                        Bz(102);
                    }
                } else if (VideoConvertUtil.EG(str2) >= 1500000) {
                    if (VideoConvertUtil.csA()) {
                        this.jOM = new File(VideoConvertUtil.jwi, "tieba_" + VideoConvertUtil.EF(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.jOO.setConvertType(1);
                        this.jOO.ee(str2, this.jOM);
                        cub();
                        this.jAU = false;
                        this.jAV = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.jOL;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.jOM = new File(VideoConvertUtil.jwi, "tieba_" + VideoConvertUtil.EF(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.jOO.setConvertType(2);
                            this.jOO.ee(str2, this.jOM);
                            cub();
                            this.jAU = false;
                            this.jAV = false;
                            return;
                        }
                        this.jOM = videoFileInfo2.videoPath;
                        rs(false);
                        Bz(102);
                    }
                }
            }
        }
    }

    private void cug() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.fxV).hS(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.fxV.getPageContext());
        a.eh(false);
        a.akM();
    }

    private void cub() {
        RelativeLayout relativeLayout = (RelativeLayout) this.fxV.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.jON == null) {
                this.jON = new AlbumVideoCompressingDialogView(this.fxV);
            }
            if (this.jON.getParent() == null) {
                relativeLayout.addView(this.jON);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jON.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.jON.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.jON.setPercent(0);
        this.jOP = true;
    }

    private void rs(boolean z) {
        VideoFileInfo FA = FA(this.jOM);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jOM);
        videoInfo.setVideoDuration(FA.videoDuration / 1000);
        videoInfo.setVideoWidth(FA.videoWidth);
        videoInfo.setVideoHeight(FA.videoHeight);
        videoInfo.setVideoLength(new File(FA.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.fxV, this.fUk, this.mForumName, this.mForumId, this.jxJ, videoInfo);
        editVideoActivityConfig.setProZone(this.jOQ);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.jAU = false;
        this.jOM = null;
        if (this.jiP != null) {
            this.jiP.bMC();
        }
    }

    public static VideoFileInfo FA(String str) {
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
                videoFileInfo.videoDuration = com.baidu.adp.lib.g.b.toInt(mediaMetadataRetriever.extractMetadata(9), 0);
                videoFileInfo.mimeType = mediaMetadataRetriever.extractMetadata(12);
                videoFileInfo.videoWidth = com.baidu.adp.lib.g.b.toInt(mediaMetadataRetriever.extractMetadata(18), 0);
                videoFileInfo.videoHeight = com.baidu.adp.lib.g.b.toInt(mediaMetadataRetriever.extractMetadata(19), 0);
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
    public void csw() {
    }

    @Override // com.baidu.tieba.video.d
    public void AJ(int i) {
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
                if (this.jON != null && this.jON.isShowing()) {
                    this.jON.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.jAV) {
                    com.baidu.adp.lib.util.l.showToast(this.fxV, (int) R.string.mv_local_video_compress_failed);
                    Bz(103);
                }
                this.jOP = false;
                this.jAU = false;
                cuc();
                break;
            case 3:
                this.jOP = false;
                this.jAU = true;
                if (!StringUtils.isNull(this.jOM) && (file = new File(this.jOM)) != null) {
                    this.jOM = this.jOM.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.jOM));
                }
                cuc();
                if (!this.jAT) {
                    rs(true);
                    if (this.jiP != null) {
                        this.jiP.bMC();
                        break;
                    }
                }
                break;
            case 4:
                this.jOP = false;
                this.jAU = false;
                cuc();
                Bz(104);
                break;
            case 5:
                this.jOP = false;
                com.baidu.adp.lib.util.l.showToast(this.fxV, (int) R.string.mv_local_video_compress_failed);
                if (this.jOO != null && this.jOO.isConvertRunning()) {
                    cud();
                }
                Bz(105);
                break;
        }
        return true;
    }

    private void cuc() {
        RelativeLayout relativeLayout = (RelativeLayout) this.fxV.findViewById(R.id.parent);
        if (relativeLayout != null && this.jON.getParent() != null) {
            relativeLayout.removeView(this.jON);
        }
    }

    private void cud() {
        if (this.jOO != null) {
            this.jOO.abortConvert();
        }
        this.jAV = true;
        if (this.jOM != null) {
            File file = new File(this.jOM);
            if (file.exists()) {
                file.delete();
            }
        }
        cuc();
        this.jOM = null;
    }

    public void onStart() {
        this.jAT = false;
    }

    public void onStop() {
        this.jAT = true;
    }

    public void onResume() {
        if (this.jAU && !TextUtils.isEmpty(this.jOM) && new File(this.jOM).exists()) {
            rs(true);
            Bz(101);
        }
        if (this.jiP != null) {
            this.jiP.zS("album");
        }
    }

    public void onDestroy() {
        if (this.jOO != null) {
            this.jOO.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.jiP != null) {
            this.jiP.zT("album");
        }
        MessageManager.getInstance().unRegisterListener(this.jBc);
    }

    private void Bz(int i) {
        if (this.jiP != null) {
            this.jiP.av(i, "album");
        }
    }

    public boolean cyn() {
        return this.jOP;
    }

    public void setProfessionZone(int i) {
        this.jOQ = i;
    }
}
