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
    private BaseFragmentActivity dmS;
    private String fVH;
    private final CustomMessageListener jCb;
    private VideoFileInfo jRQ;
    private String jRR;
    private AlbumVideoCompressingDialogView jRS;
    private VideoConvertUtil jRT;
    private boolean jRU;
    private com.baidu.tieba.j.h jjR;
    private String jyI;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;
    private boolean jBS = false;
    private boolean jBT = false;
    private boolean jBU = false;
    private int jRV = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.jjR = lVar.bPY();
        }
        if (this.jjR != null) {
            this.jjR.bPB();
        }
        this.jCb = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.dmS.setResult(-1, intent);
                    i.this.dmS.finish();
                }
            }
        };
        this.dmS = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.jyI = str3;
        this.jRT = new VideoConvertUtil(baseFragmentActivity);
        this.jRT.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.jCb);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.jRQ = videoFileInfo;
        this.fVH = str;
        if (this.jRQ != null && this.dmS != null) {
            if (this.jRQ.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                cwu();
            } else if (this.jRT == null || !this.jRT.isConvertRunning()) {
                String str2 = this.jRQ.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.dmS, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    De(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.dmS, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    De(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.jRQ != null) {
                        this.jRR = this.jRQ.videoPath;
                        rJ(false);
                        De(102);
                    }
                } else if (VideoConvertUtil.Ge(str2) >= 1500000) {
                    if (VideoConvertUtil.cuN()) {
                        this.jRR = new File(VideoConvertUtil.jxh, "tieba_" + VideoConvertUtil.Gd(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.jRT.setConvertType(1);
                        this.jRT.es(str2, this.jRR);
                        cwp();
                        this.jBT = false;
                        this.jBU = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.jRQ;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.jRR = new File(VideoConvertUtil.jxh, "tieba_" + VideoConvertUtil.Gd(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.jRT.setConvertType(2);
                            this.jRT.es(str2, this.jRR);
                            cwp();
                            this.jBT = false;
                            this.jBU = false;
                            return;
                        }
                        this.jRR = videoFileInfo2.videoPath;
                        rJ(false);
                        De(102);
                    }
                }
            }
        }
    }

    private void cwu() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.dmS).hu(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.dmS.getPageContext());
        a.dR(false);
        a.agO();
    }

    private void cwp() {
        RelativeLayout relativeLayout = (RelativeLayout) this.dmS.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.jRS == null) {
                this.jRS = new AlbumVideoCompressingDialogView(this.dmS);
            }
            if (this.jRS.getParent() == null) {
                relativeLayout.addView(this.jRS);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jRS.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.jRS.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.jRS.setPercent(0);
        this.jRU = true;
    }

    private void rJ(boolean z) {
        VideoFileInfo Hj = Hj(this.jRR);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jRR);
        videoInfo.setVideoDuration(Hj.videoDuration / 1000);
        videoInfo.setVideoWidth(Hj.videoWidth);
        videoInfo.setVideoHeight(Hj.videoHeight);
        videoInfo.setVideoLength(new File(Hj.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.dmS, this.fVH, this.mForumName, this.mForumId, this.jyI, videoInfo);
        editVideoActivityConfig.setProZone(this.jRV);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        this.jBT = false;
        this.jRR = null;
        if (this.jjR != null) {
            this.jjR.bPE();
        }
    }

    public static VideoFileInfo Hj(String str) {
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
    public void cuJ() {
    }

    @Override // com.baidu.tieba.video.d
    public void Ce(int i) {
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
                if (this.jRS != null && this.jRS.isShowing()) {
                    this.jRS.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.jBU) {
                    com.baidu.adp.lib.util.l.showToast(this.dmS, (int) R.string.mv_local_video_compress_failed);
                    De(103);
                }
                this.jRU = false;
                this.jBT = false;
                cwq();
                break;
            case 3:
                this.jRU = false;
                this.jBT = true;
                if (!StringUtils.isNull(this.jRR) && (file = new File(this.jRR)) != null) {
                    this.jRR = this.jRR.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.jRR));
                }
                cwq();
                if (!this.jBS) {
                    rJ(true);
                    if (this.jjR != null) {
                        this.jjR.bPE();
                        break;
                    }
                }
                break;
            case 4:
                this.jRU = false;
                this.jBT = false;
                cwq();
                De(104);
                break;
            case 5:
                this.jRU = false;
                com.baidu.adp.lib.util.l.showToast(this.dmS, (int) R.string.mv_local_video_compress_failed);
                if (this.jRT != null && this.jRT.isConvertRunning()) {
                    cwr();
                }
                De(105);
                break;
        }
        return true;
    }

    private void cwq() {
        RelativeLayout relativeLayout = (RelativeLayout) this.dmS.findViewById(R.id.parent);
        if (relativeLayout != null && this.jRS.getParent() != null) {
            relativeLayout.removeView(this.jRS);
        }
    }

    private void cwr() {
        if (this.jRT != null) {
            this.jRT.abortConvert();
        }
        this.jBU = true;
        if (this.jRR != null) {
            File file = new File(this.jRR);
            if (file.exists()) {
                file.delete();
            }
        }
        cwq();
        this.jRR = null;
    }

    public void onStart() {
        this.jBS = false;
    }

    public void onStop() {
        this.jBS = true;
    }

    public void onResume() {
        if (this.jBT && !TextUtils.isEmpty(this.jRR) && new File(this.jRR).exists()) {
            rJ(true);
            De(101);
        }
        if (this.jjR != null) {
            this.jjR.By("album");
        }
    }

    public void onDestroy() {
        if (this.jRT != null) {
            this.jRT.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.jjR != null) {
            this.jjR.Bz("album");
        }
        MessageManager.getInstance().unRegisterListener(this.jCb);
    }

    private void De(int i) {
        if (this.jjR != null) {
            this.jjR.aw(i, "album");
        }
    }

    public boolean cBF() {
        return this.jRU;
    }

    public void setProfessionZone(int i) {
        this.jRV = i;
    }
}
