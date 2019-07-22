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
import com.baidu.tieba.R;
import com.baidu.tieba.j.l;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import java.io.File;
/* loaded from: classes3.dex */
public class i implements Handler.Callback, com.baidu.tieba.video.d {
    private BaseFragmentActivity dla;
    private String fTa;
    private VideoFileInfo jOo;
    private String jOp;
    private AlbumVideoCompressingDialogView jOq;
    private VideoConvertUtil jOr;
    private boolean jOs;
    private com.baidu.tieba.j.h jgo;
    private String jvf;
    private final CustomMessageListener jyy;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;
    private boolean jyp = false;
    private boolean jyq = false;
    private boolean jyr = false;
    private int jOt = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.jgo = lVar.bOW();
        }
        if (this.jgo != null) {
            this.jgo.bOA();
        }
        this.jyy = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.dla.setResult(-1, intent);
                    i.this.dla.finish();
                }
            }
        };
        this.dla = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.jvf = str3;
        this.jOr = new VideoConvertUtil(baseFragmentActivity);
        this.jOr.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.jyy);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.jOo = videoFileInfo;
        this.fTa = str;
        if (this.jOo != null && this.dla != null) {
            if (this.jOo.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                cvk();
            } else if (this.jOr == null || !this.jOr.isConvertRunning()) {
                String str2 = this.jOo.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.dla, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    CY(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.dla, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    CY(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.jOo != null) {
                        this.jOp = this.jOo.videoPath;
                        rF(false);
                        CY(102);
                    }
                } else if (VideoConvertUtil.FD(str2) >= 1500000) {
                    if (VideoConvertUtil.ctD()) {
                        this.jOp = new File(VideoConvertUtil.jtE, "tieba_" + VideoConvertUtil.FC(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.jOr.setConvertType(1);
                        this.jOr.er(str2, this.jOp);
                        cvf();
                        this.jyq = false;
                        this.jyr = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.jOo;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.jOp = new File(VideoConvertUtil.jtE, "tieba_" + VideoConvertUtil.FC(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.jOr.setConvertType(2);
                            this.jOr.er(str2, this.jOp);
                            cvf();
                            this.jyq = false;
                            this.jyr = false;
                            return;
                        }
                        this.jOp = videoFileInfo2.videoPath;
                        rF(false);
                        CY(102);
                    }
                }
            }
        }
    }

    private void cvk() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.dla).ht(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.dla.getPageContext());
        a.dR(false);
        a.agI();
    }

    private void cvf() {
        RelativeLayout relativeLayout = (RelativeLayout) this.dla.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.jOq == null) {
                this.jOq = new AlbumVideoCompressingDialogView(this.dla);
            }
            if (this.jOq.getParent() == null) {
                relativeLayout.addView(this.jOq);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jOq.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.jOq.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.jOq.setPercent(0);
        this.jOs = true;
    }

    private void rF(boolean z) {
        VideoFileInfo GI = GI(this.jOp);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jOp);
        videoInfo.setVideoDuration(GI.videoDuration / 1000);
        videoInfo.setVideoWidth(GI.videoWidth);
        videoInfo.setVideoHeight(GI.videoHeight);
        videoInfo.setVideoLength(new File(GI.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.dla, this.fTa, this.mForumName, this.mForumId, this.jvf, videoInfo);
        editVideoActivityConfig.setProZone(this.jOt);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        this.jyq = false;
        this.jOp = null;
        if (this.jgo != null) {
            this.jgo.bOD();
        }
    }

    public static VideoFileInfo GI(String str) {
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
                videoFileInfo.videoDuration = com.baidu.adp.lib.g.b.f(mediaMetadataRetriever.extractMetadata(9), 0);
                videoFileInfo.mimeType = mediaMetadataRetriever.extractMetadata(12);
                videoFileInfo.videoWidth = com.baidu.adp.lib.g.b.f(mediaMetadataRetriever.extractMetadata(18), 0);
                videoFileInfo.videoHeight = com.baidu.adp.lib.g.b.f(mediaMetadataRetriever.extractMetadata(19), 0);
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
    public void ctz() {
    }

    @Override // com.baidu.tieba.video.d
    public void BY(int i) {
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
                if (this.jOq != null && this.jOq.isShowing()) {
                    this.jOq.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.jyr) {
                    com.baidu.adp.lib.util.l.showToast(this.dla, (int) R.string.mv_local_video_compress_failed);
                    CY(103);
                }
                this.jOs = false;
                this.jyq = false;
                cvg();
                break;
            case 3:
                this.jOs = false;
                this.jyq = true;
                if (!StringUtils.isNull(this.jOp) && (file = new File(this.jOp)) != null) {
                    this.jOp = this.jOp.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.jOp));
                }
                cvg();
                if (!this.jyp) {
                    rF(true);
                    if (this.jgo != null) {
                        this.jgo.bOD();
                        break;
                    }
                }
                break;
            case 4:
                this.jOs = false;
                this.jyq = false;
                cvg();
                CY(104);
                break;
            case 5:
                this.jOs = false;
                com.baidu.adp.lib.util.l.showToast(this.dla, (int) R.string.mv_local_video_compress_failed);
                if (this.jOr != null && this.jOr.isConvertRunning()) {
                    cvh();
                }
                CY(105);
                break;
        }
        return true;
    }

    private void cvg() {
        RelativeLayout relativeLayout = (RelativeLayout) this.dla.findViewById(R.id.parent);
        if (relativeLayout != null && this.jOq.getParent() != null) {
            relativeLayout.removeView(this.jOq);
        }
    }

    private void cvh() {
        if (this.jOr != null) {
            this.jOr.abortConvert();
        }
        this.jyr = true;
        if (this.jOp != null) {
            File file = new File(this.jOp);
            if (file.exists()) {
                file.delete();
            }
        }
        cvg();
        this.jOp = null;
    }

    public void onStart() {
        this.jyp = false;
    }

    public void onStop() {
        this.jyp = true;
    }

    public void onResume() {
        if (this.jyq && !TextUtils.isEmpty(this.jOp) && new File(this.jOp).exists()) {
            rF(true);
            CY(101);
        }
        if (this.jgo != null) {
            this.jgo.AY("album");
        }
    }

    public void onDestroy() {
        if (this.jOr != null) {
            this.jOr.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.jgo != null) {
            this.jgo.AZ("album");
        }
        MessageManager.getInstance().unRegisterListener(this.jyy);
    }

    private void CY(int i) {
        if (this.jgo != null) {
            this.jgo.aw(i, "album");
        }
    }

    public boolean cAw() {
        return this.jOs;
    }

    public void setProfessionZone(int i) {
        this.jOt = i;
    }
}
