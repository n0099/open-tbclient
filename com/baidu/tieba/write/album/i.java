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
    private String fVb;
    private BaseFragmentActivity fyM;
    private final CustomMessageListener jBT;
    private VideoFileInfo jPC;
    private String jPD;
    private AlbumVideoCompressingDialogView jPE;
    private VideoConvertUtil jPF;
    private boolean jPG;
    private com.baidu.tieba.j.h jjG;
    private String jyA;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;
    private boolean jBK = false;
    private boolean jBL = false;
    private boolean jBM = false;
    private int jPH = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.jjG = lVar.bMY();
        }
        if (this.jjG != null) {
            this.jjG.bMB();
        }
        this.jBT = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    i.this.fyM.setResult(-1, intent);
                    i.this.fyM.finish();
                }
            }
        };
        this.fyM = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.jyA = str3;
        this.jPF = new VideoConvertUtil(baseFragmentActivity);
        this.jPF.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.jBT);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.jPC = videoFileInfo;
        this.fVb = str;
        if (this.jPC != null && this.fyM != null) {
            if (this.jPC.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                cui();
            } else if (this.jPF == null || !this.jPF.isConvertRunning()) {
                String str2 = this.jPC.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.fyM, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    BA(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.fyM, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    BA(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.jPC != null) {
                        this.jPD = this.jPC.videoPath;
                        rs(false);
                        BA(102);
                    }
                } else if (VideoConvertUtil.EG(str2) >= 1500000) {
                    if (VideoConvertUtil.csC()) {
                        this.jPD = new File(VideoConvertUtil.jwZ, "tieba_" + VideoConvertUtil.EF(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.jPF.setConvertType(1);
                        this.jPF.ee(str2, this.jPD);
                        cud();
                        this.jBL = false;
                        this.jBM = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.jPC;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.jPD = new File(VideoConvertUtil.jwZ, "tieba_" + VideoConvertUtil.EF(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.jPF.setConvertType(2);
                            this.jPF.ee(str2, this.jPD);
                            cud();
                            this.jBL = false;
                            this.jBM = false;
                            return;
                        }
                        this.jPD = videoFileInfo2.videoPath;
                        rs(false);
                        BA(102);
                    }
                }
            }
        }
    }

    private void cui() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.fyM).hT(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.fyM.getPageContext());
        a.eh(false);
        a.akO();
    }

    private void cud() {
        RelativeLayout relativeLayout = (RelativeLayout) this.fyM.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.jPE == null) {
                this.jPE = new AlbumVideoCompressingDialogView(this.fyM);
            }
            if (this.jPE.getParent() == null) {
                relativeLayout.addView(this.jPE);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jPE.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.jPE.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.jPE.setPercent(0);
        this.jPG = true;
    }

    private void rs(boolean z) {
        VideoFileInfo FA = FA(this.jPD);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jPD);
        videoInfo.setVideoDuration(FA.videoDuration / 1000);
        videoInfo.setVideoWidth(FA.videoWidth);
        videoInfo.setVideoHeight(FA.videoHeight);
        videoInfo.setVideoLength(new File(FA.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.fyM, this.fVb, this.mForumName, this.mForumId, this.jyA, videoInfo);
        editVideoActivityConfig.setProZone(this.jPH);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.jBL = false;
        this.jPD = null;
        if (this.jjG != null) {
            this.jjG.bME();
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
    public void csy() {
    }

    @Override // com.baidu.tieba.video.d
    public void AK(int i) {
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
                if (this.jPE != null && this.jPE.isShowing()) {
                    this.jPE.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.jBM) {
                    com.baidu.adp.lib.util.l.showToast(this.fyM, (int) R.string.mv_local_video_compress_failed);
                    BA(103);
                }
                this.jPG = false;
                this.jBL = false;
                cue();
                break;
            case 3:
                this.jPG = false;
                this.jBL = true;
                if (!StringUtils.isNull(this.jPD) && (file = new File(this.jPD)) != null) {
                    this.jPD = this.jPD.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.jPD));
                }
                cue();
                if (!this.jBK) {
                    rs(true);
                    if (this.jjG != null) {
                        this.jjG.bME();
                        break;
                    }
                }
                break;
            case 4:
                this.jPG = false;
                this.jBL = false;
                cue();
                BA(104);
                break;
            case 5:
                this.jPG = false;
                com.baidu.adp.lib.util.l.showToast(this.fyM, (int) R.string.mv_local_video_compress_failed);
                if (this.jPF != null && this.jPF.isConvertRunning()) {
                    cuf();
                }
                BA(105);
                break;
        }
        return true;
    }

    private void cue() {
        RelativeLayout relativeLayout = (RelativeLayout) this.fyM.findViewById(R.id.parent);
        if (relativeLayout != null && this.jPE.getParent() != null) {
            relativeLayout.removeView(this.jPE);
        }
    }

    private void cuf() {
        if (this.jPF != null) {
            this.jPF.abortConvert();
        }
        this.jBM = true;
        if (this.jPD != null) {
            File file = new File(this.jPD);
            if (file.exists()) {
                file.delete();
            }
        }
        cue();
        this.jPD = null;
    }

    public void onStart() {
        this.jBK = false;
    }

    public void onStop() {
        this.jBK = true;
    }

    public void onResume() {
        if (this.jBL && !TextUtils.isEmpty(this.jPD) && new File(this.jPD).exists()) {
            rs(true);
            BA(101);
        }
        if (this.jjG != null) {
            this.jjG.zS("album");
        }
    }

    public void onDestroy() {
        if (this.jPF != null) {
            this.jPF.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.jjG != null) {
            this.jjG.zT("album");
        }
        MessageManager.getInstance().unRegisterListener(this.jBT);
    }

    private void BA(int i) {
        if (this.jjG != null) {
            this.jjG.aw(i, "album");
        }
    }

    public boolean cyp() {
        return this.jPG;
    }

    public void setProfessionZone(int i) {
        this.jPH = i;
    }
}
