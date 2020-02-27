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
import com.baidu.tieba.k.l;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import java.io.File;
/* loaded from: classes13.dex */
public class i implements Handler.Callback, com.baidu.tieba.video.d {
    private String gNW;
    private BaseFragmentActivity grC;
    private VideoFileInfo kNK;
    private String kNL;
    private AlbumVideoCompressingDialogView kNM;
    private VideoConvertUtil kNN;
    private boolean kNO;
    private com.baidu.tieba.k.h khL;
    private String kwk;
    private final CustomMessageListener kzw;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;
    private boolean kzn = false;
    private boolean kzo = false;
    private boolean kzp = false;
    private int kNP = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.khL = lVar.cgW();
        }
        if (this.khL != null) {
            this.khL.cgy();
        }
        this.kzw = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    i.this.grC.setResult(-1, intent);
                    i.this.grC.finish();
                }
            }
        };
        this.grC = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.kwk = str3;
        this.kNN = new VideoConvertUtil(baseFragmentActivity);
        this.kNN.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.kzw);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.kNK = videoFileInfo;
        this.gNW = str;
        if (this.kNK != null && this.grC != null) {
            if (this.kNK.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                cQE();
            } else if (this.kNN == null || !this.kNN.isConvertRunning()) {
                String str2 = this.kNK.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.grC, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    Eg(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.grC, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    Eg(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.kNK != null) {
                        this.kNL = this.kNK.videoPath;
                        tp(false);
                        Eg(102);
                    }
                } else if (VideoConvertUtil.JS(str2) >= 1500000) {
                    if (VideoConvertUtil.cPe()) {
                        this.kNL = new File(VideoConvertUtil.kuQ, "tieba_" + VideoConvertUtil.JR(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.kNN.setConvertType(1);
                        this.kNN.eI(str2, this.kNL);
                        cQz();
                        this.kzo = false;
                        this.kzp = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.kNK;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.kNL = new File(VideoConvertUtil.kuQ, "tieba_" + VideoConvertUtil.JR(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.kNN.setConvertType(2);
                            this.kNN.eI(str2, this.kNL);
                            cQz();
                            this.kzo = false;
                            this.kzp = false;
                            return;
                        }
                        this.kNL = videoFileInfo2.videoPath;
                        tp(false);
                        Eg(102);
                    }
                }
            }
        }
    }

    private void cQE() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.grC).jV(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.grC.getPageContext());
        a.fH(false);
        a.aEA();
    }

    private void cQz() {
        RelativeLayout relativeLayout = (RelativeLayout) this.grC.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.kNM == null) {
                this.kNM = new AlbumVideoCompressingDialogView(this.grC);
            }
            if (this.kNM.getParent() == null) {
                relativeLayout.addView(this.kNM);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kNM.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.kNM.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.kNM.setPercent(0);
        this.kNO = true;
    }

    private void tp(boolean z) {
        VideoFileInfo KP = KP(this.kNL);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kNL);
        videoInfo.setVideoDuration(KP.videoDuration / 1000);
        videoInfo.setVideoWidth(KP.videoWidth);
        videoInfo.setVideoHeight(KP.videoHeight);
        videoInfo.setVideoLength(new File(KP.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.grC, this.gNW, this.mForumName, this.mForumId, this.kwk, videoInfo);
        editVideoActivityConfig.setProZone(this.kNP);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.kzo = false;
        this.kNL = null;
        if (this.khL != null) {
            this.khL.cgB();
        }
    }

    public static VideoFileInfo KP(String str) {
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
    public void cPa() {
    }

    @Override // com.baidu.tieba.video.d
    public void Dq(int i) {
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
                if (this.kNM != null && this.kNM.isShowing()) {
                    this.kNM.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.kzp) {
                    com.baidu.adp.lib.util.l.showToast(this.grC, (int) R.string.mv_local_video_compress_failed);
                    Eg(103);
                }
                this.kNO = false;
                this.kzo = false;
                cQA();
                break;
            case 3:
                this.kNO = false;
                this.kzo = true;
                if (!StringUtils.isNull(this.kNL) && (file = new File(this.kNL)) != null) {
                    this.kNL = this.kNL.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.kNL));
                }
                cQA();
                if (!this.kzn) {
                    tp(true);
                    if (this.khL != null) {
                        this.khL.cgB();
                        break;
                    }
                }
                break;
            case 4:
                this.kNO = false;
                this.kzo = false;
                cQA();
                Eg(104);
                break;
            case 5:
                this.kNO = false;
                com.baidu.adp.lib.util.l.showToast(this.grC, (int) R.string.mv_local_video_compress_failed);
                if (this.kNN != null && this.kNN.isConvertRunning()) {
                    cQB();
                }
                Eg(105);
                break;
        }
        return true;
    }

    private void cQA() {
        RelativeLayout relativeLayout = (RelativeLayout) this.grC.findViewById(R.id.parent);
        if (relativeLayout != null && this.kNM.getParent() != null) {
            relativeLayout.removeView(this.kNM);
        }
    }

    private void cQB() {
        if (this.kNN != null) {
            this.kNN.abortConvert();
        }
        this.kzp = true;
        if (this.kNL != null) {
            File file = new File(this.kNL);
            if (file.exists()) {
                file.delete();
            }
        }
        cQA();
        this.kNL = null;
    }

    public void onStart() {
        this.kzn = false;
    }

    public void onStop() {
        this.kzn = true;
    }

    public void onResume() {
        if (this.kzo && !TextUtils.isEmpty(this.kNL) && new File(this.kNL).exists()) {
            tp(true);
            Eg(101);
        }
        if (this.khL != null) {
            this.khL.Fa("album");
        }
    }

    public void onDestroy() {
        if (this.kNN != null) {
            this.kNN.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.khL != null) {
            this.khL.Fb("album");
        }
        MessageManager.getInstance().unRegisterListener(this.kzw);
    }

    private void Eg(int i) {
        if (this.khL != null) {
            this.khL.aQ(i, "album");
        }
    }

    public boolean cUI() {
        return this.kNO;
    }

    public void setProfessionZone(int i) {
        this.kNP = i;
    }
}
