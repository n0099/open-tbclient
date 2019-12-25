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
/* loaded from: classes10.dex */
public class i implements Handler.Callback, com.baidu.tieba.video.d {
    private String gIK;
    private BaseFragmentActivity gms;
    private AlbumVideoCompressingDialogView kJA;
    private VideoConvertUtil kJB;
    private boolean kJC;
    private VideoFileInfo kJy;
    private String kJz;
    private com.baidu.tieba.j.h kdc;
    private String krF;
    private final CustomMessageListener kuT;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;
    private boolean kuK = false;
    private boolean kuL = false;
    private boolean kuM = false;
    private int kJD = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.kdc = lVar.cei();
        }
        if (this.kdc != null) {
            this.kdc.cdL();
        }
        this.kuT = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    i.this.gms.setResult(-1, intent);
                    i.this.gms.finish();
                }
            }
        };
        this.gms = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.krF = str3;
        this.kJB = new VideoConvertUtil(baseFragmentActivity);
        this.kJB.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.kuT);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.kJy = videoFileInfo;
        this.gIK = str;
        if (this.kJy != null && this.gms != null) {
            if (this.kJy.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                cOg();
            } else if (this.kJB == null || !this.kJB.isConvertRunning()) {
                String str2 = this.kJy.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.gms, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    DW(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.gms, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    DW(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.kJy != null) {
                        this.kJz = this.kJy.videoPath;
                        sZ(false);
                        DW(102);
                    }
                } else if (VideoConvertUtil.Jv(str2) >= 1500000) {
                    if (VideoConvertUtil.cMC()) {
                        this.kJz = new File(VideoConvertUtil.kql, "tieba_" + VideoConvertUtil.Ju(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.kJB.setConvertType(1);
                        this.kJB.ex(str2, this.kJz);
                        cOb();
                        this.kuL = false;
                        this.kuM = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.kJy;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.kJz = new File(VideoConvertUtil.kql, "tieba_" + VideoConvertUtil.Ju(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.kJB.setConvertType(2);
                            this.kJB.ex(str2, this.kJz);
                            cOb();
                            this.kuL = false;
                            this.kuM = false;
                            return;
                        }
                        this.kJz = videoFileInfo2.videoPath;
                        sZ(false);
                        DW(102);
                    }
                }
            }
        }
    }

    private void cOg() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.gms).jE(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.gms.getPageContext());
        a.fv(false);
        a.aBW();
    }

    private void cOb() {
        RelativeLayout relativeLayout = (RelativeLayout) this.gms.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.kJA == null) {
                this.kJA = new AlbumVideoCompressingDialogView(this.gms);
            }
            if (this.kJA.getParent() == null) {
                relativeLayout.addView(this.kJA);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kJA.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.kJA.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.kJA.setPercent(0);
        this.kJC = true;
    }

    private void sZ(boolean z) {
        VideoFileInfo Ks = Ks(this.kJz);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kJz);
        videoInfo.setVideoDuration(Ks.videoDuration / 1000);
        videoInfo.setVideoWidth(Ks.videoWidth);
        videoInfo.setVideoHeight(Ks.videoHeight);
        videoInfo.setVideoLength(new File(Ks.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.gms, this.gIK, this.mForumName, this.mForumId, this.krF, videoInfo);
        editVideoActivityConfig.setProZone(this.kJD);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.kuL = false;
        this.kJz = null;
        if (this.kdc != null) {
            this.kdc.cdO();
        }
    }

    public static VideoFileInfo Ks(String str) {
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
    public void cMy() {
    }

    @Override // com.baidu.tieba.video.d
    public void De(int i) {
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
                if (this.kJA != null && this.kJA.isShowing()) {
                    this.kJA.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.kuM) {
                    com.baidu.adp.lib.util.l.showToast(this.gms, (int) R.string.mv_local_video_compress_failed);
                    DW(103);
                }
                this.kJC = false;
                this.kuL = false;
                cOc();
                break;
            case 3:
                this.kJC = false;
                this.kuL = true;
                if (!StringUtils.isNull(this.kJz) && (file = new File(this.kJz)) != null) {
                    this.kJz = this.kJz.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.kJz));
                }
                cOc();
                if (!this.kuK) {
                    sZ(true);
                    if (this.kdc != null) {
                        this.kdc.cdO();
                        break;
                    }
                }
                break;
            case 4:
                this.kJC = false;
                this.kuL = false;
                cOc();
                DW(104);
                break;
            case 5:
                this.kJC = false;
                com.baidu.adp.lib.util.l.showToast(this.gms, (int) R.string.mv_local_video_compress_failed);
                if (this.kJB != null && this.kJB.isConvertRunning()) {
                    cOd();
                }
                DW(105);
                break;
        }
        return true;
    }

    private void cOc() {
        RelativeLayout relativeLayout = (RelativeLayout) this.gms.findViewById(R.id.parent);
        if (relativeLayout != null && this.kJA.getParent() != null) {
            relativeLayout.removeView(this.kJA);
        }
    }

    private void cOd() {
        if (this.kJB != null) {
            this.kJB.abortConvert();
        }
        this.kuM = true;
        if (this.kJz != null) {
            File file = new File(this.kJz);
            if (file.exists()) {
                file.delete();
            }
        }
        cOc();
        this.kJz = null;
    }

    public void onStart() {
        this.kuK = false;
    }

    public void onStop() {
        this.kuK = true;
    }

    public void onResume() {
        if (this.kuL && !TextUtils.isEmpty(this.kJz) && new File(this.kJz).exists()) {
            sZ(true);
            DW(101);
        }
        if (this.kdc != null) {
            this.kdc.EA("album");
        }
    }

    public void onDestroy() {
        if (this.kJB != null) {
            this.kJB.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.kdc != null) {
            this.kdc.EB("album");
        }
        MessageManager.getInstance().unRegisterListener(this.kuT);
    }

    private void DW(int i) {
        if (this.kdc != null) {
            this.kdc.aK(i, "album");
        }
    }

    public boolean cSp() {
        return this.kJC;
    }

    public void setProfessionZone(int i) {
        this.kJD = i;
    }
}
