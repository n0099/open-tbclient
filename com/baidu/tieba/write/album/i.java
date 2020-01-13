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
/* loaded from: classes11.dex */
public class i implements Handler.Callback, com.baidu.tieba.video.d {
    private String gLX;
    private BaseFragmentActivity gpB;
    private VideoFileInfo kMZ;
    private String kNa;
    private AlbumVideoCompressingDialogView kNb;
    private VideoConvertUtil kNc;
    private boolean kNd;
    private com.baidu.tieba.j.h kgF;
    private String kvi;
    private final CustomMessageListener kyw;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;
    private boolean kyn = false;
    private boolean kyo = false;
    private boolean kyp = false;
    private int kNe = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.kgF = lVar.cfr();
        }
        if (this.kgF != null) {
            this.kgF.ceU();
        }
        this.kyw = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    i.this.gpB.setResult(-1, intent);
                    i.this.gpB.finish();
                }
            }
        };
        this.gpB = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.kvi = str3;
        this.kNc = new VideoConvertUtil(baseFragmentActivity);
        this.kNc.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.kyw);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.kMZ = videoFileInfo;
        this.gLX = str;
        if (this.kMZ != null && this.gpB != null) {
            if (this.kMZ.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                cPj();
            } else if (this.kNc == null || !this.kNc.isConvertRunning()) {
                String str2 = this.kMZ.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.gpB, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    Eb(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.gpB, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    Eb(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.kMZ != null) {
                        this.kNa = this.kMZ.videoPath;
                        tl(false);
                        Eb(102);
                    }
                } else if (VideoConvertUtil.JF(str2) >= 1500000) {
                    if (VideoConvertUtil.cNH()) {
                        this.kNa = new File(VideoConvertUtil.ktO, "tieba_" + VideoConvertUtil.JE(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.kNc.setConvertType(1);
                        this.kNc.ez(str2, this.kNa);
                        cPe();
                        this.kyo = false;
                        this.kyp = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.kMZ;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.kNa = new File(VideoConvertUtil.ktO, "tieba_" + VideoConvertUtil.JE(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.kNc.setConvertType(2);
                            this.kNc.ez(str2, this.kNa);
                            cPe();
                            this.kyo = false;
                            this.kyp = false;
                            return;
                        }
                        this.kNa = videoFileInfo2.videoPath;
                        tl(false);
                        Eb(102);
                    }
                }
            }
        }
    }

    private void cPj() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.gpB).jE(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.gpB.getPageContext());
        a.fA(false);
        a.aCp();
    }

    private void cPe() {
        RelativeLayout relativeLayout = (RelativeLayout) this.gpB.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.kNb == null) {
                this.kNb = new AlbumVideoCompressingDialogView(this.gpB);
            }
            if (this.kNb.getParent() == null) {
                relativeLayout.addView(this.kNb);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kNb.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.kNb.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.kNb.setPercent(0);
        this.kNd = true;
    }

    private void tl(boolean z) {
        VideoFileInfo KC = KC(this.kNa);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kNa);
        videoInfo.setVideoDuration(KC.videoDuration / 1000);
        videoInfo.setVideoWidth(KC.videoWidth);
        videoInfo.setVideoHeight(KC.videoHeight);
        videoInfo.setVideoLength(new File(KC.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.gpB, this.gLX, this.mForumName, this.mForumId, this.kvi, videoInfo);
        editVideoActivityConfig.setProZone(this.kNe);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.kyo = false;
        this.kNa = null;
        if (this.kgF != null) {
            this.kgF.ceX();
        }
    }

    public static VideoFileInfo KC(String str) {
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
    public void cND() {
    }

    @Override // com.baidu.tieba.video.d
    public void Dk(int i) {
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
                if (this.kNb != null && this.kNb.isShowing()) {
                    this.kNb.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.kyp) {
                    com.baidu.adp.lib.util.l.showToast(this.gpB, (int) R.string.mv_local_video_compress_failed);
                    Eb(103);
                }
                this.kNd = false;
                this.kyo = false;
                cPf();
                break;
            case 3:
                this.kNd = false;
                this.kyo = true;
                if (!StringUtils.isNull(this.kNa) && (file = new File(this.kNa)) != null) {
                    this.kNa = this.kNa.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.kNa));
                }
                cPf();
                if (!this.kyn) {
                    tl(true);
                    if (this.kgF != null) {
                        this.kgF.ceX();
                        break;
                    }
                }
                break;
            case 4:
                this.kNd = false;
                this.kyo = false;
                cPf();
                Eb(104);
                break;
            case 5:
                this.kNd = false;
                com.baidu.adp.lib.util.l.showToast(this.gpB, (int) R.string.mv_local_video_compress_failed);
                if (this.kNc != null && this.kNc.isConvertRunning()) {
                    cPg();
                }
                Eb(105);
                break;
        }
        return true;
    }

    private void cPf() {
        RelativeLayout relativeLayout = (RelativeLayout) this.gpB.findViewById(R.id.parent);
        if (relativeLayout != null && this.kNb.getParent() != null) {
            relativeLayout.removeView(this.kNb);
        }
    }

    private void cPg() {
        if (this.kNc != null) {
            this.kNc.abortConvert();
        }
        this.kyp = true;
        if (this.kNa != null) {
            File file = new File(this.kNa);
            if (file.exists()) {
                file.delete();
            }
        }
        cPf();
        this.kNa = null;
    }

    public void onStart() {
        this.kyn = false;
    }

    public void onStop() {
        this.kyn = true;
    }

    public void onResume() {
        if (this.kyo && !TextUtils.isEmpty(this.kNa) && new File(this.kNa).exists()) {
            tl(true);
            Eb(101);
        }
        if (this.kgF != null) {
            this.kgF.EK("album");
        }
    }

    public void onDestroy() {
        if (this.kNc != null) {
            this.kNc.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.kgF != null) {
            this.kgF.EL("album");
        }
        MessageManager.getInstance().unRegisterListener(this.kyw);
    }

    private void Eb(int i) {
        if (this.kgF != null) {
            this.kgF.aQ(i, "album");
        }
    }

    public boolean cTs() {
        return this.kNd;
    }

    public void setProfessionZone(int i) {
        this.kNe = i;
    }
}
