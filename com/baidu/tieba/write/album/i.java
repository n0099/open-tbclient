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
    private String gNY;
    private BaseFragmentActivity grE;
    private VideoFileInfo kNM;
    private String kNN;
    private AlbumVideoCompressingDialogView kNO;
    private VideoConvertUtil kNP;
    private boolean kNQ;
    private com.baidu.tieba.k.h khN;
    private String kwm;
    private final CustomMessageListener kzy;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;
    private boolean kzp = false;
    private boolean kzq = false;
    private boolean kzr = false;
    private int kNR = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.khN = lVar.cgY();
        }
        if (this.khN != null) {
            this.khN.cgA();
        }
        this.kzy = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    i.this.grE.setResult(-1, intent);
                    i.this.grE.finish();
                }
            }
        };
        this.grE = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.kwm = str3;
        this.kNP = new VideoConvertUtil(baseFragmentActivity);
        this.kNP.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.kzy);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.kNM = videoFileInfo;
        this.gNY = str;
        if (this.kNM != null && this.grE != null) {
            if (this.kNM.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                cQG();
            } else if (this.kNP == null || !this.kNP.isConvertRunning()) {
                String str2 = this.kNM.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.grE, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    Eg(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.grE, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    Eg(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.kNM != null) {
                        this.kNN = this.kNM.videoPath;
                        tp(false);
                        Eg(102);
                    }
                } else if (VideoConvertUtil.JS(str2) >= 1500000) {
                    if (VideoConvertUtil.cPg()) {
                        this.kNN = new File(VideoConvertUtil.kuS, "tieba_" + VideoConvertUtil.JR(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.kNP.setConvertType(1);
                        this.kNP.eI(str2, this.kNN);
                        cQB();
                        this.kzq = false;
                        this.kzr = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.kNM;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.kNN = new File(VideoConvertUtil.kuS, "tieba_" + VideoConvertUtil.JR(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.kNP.setConvertType(2);
                            this.kNP.eI(str2, this.kNN);
                            cQB();
                            this.kzq = false;
                            this.kzr = false;
                            return;
                        }
                        this.kNN = videoFileInfo2.videoPath;
                        tp(false);
                        Eg(102);
                    }
                }
            }
        }
    }

    private void cQG() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.grE).jV(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.grE.getPageContext());
        a.fH(false);
        a.aEC();
    }

    private void cQB() {
        RelativeLayout relativeLayout = (RelativeLayout) this.grE.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.kNO == null) {
                this.kNO = new AlbumVideoCompressingDialogView(this.grE);
            }
            if (this.kNO.getParent() == null) {
                relativeLayout.addView(this.kNO);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kNO.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.kNO.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.kNO.setPercent(0);
        this.kNQ = true;
    }

    private void tp(boolean z) {
        VideoFileInfo KP = KP(this.kNN);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kNN);
        videoInfo.setVideoDuration(KP.videoDuration / 1000);
        videoInfo.setVideoWidth(KP.videoWidth);
        videoInfo.setVideoHeight(KP.videoHeight);
        videoInfo.setVideoLength(new File(KP.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.grE, this.gNY, this.mForumName, this.mForumId, this.kwm, videoInfo);
        editVideoActivityConfig.setProZone(this.kNR);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.kzq = false;
        this.kNN = null;
        if (this.khN != null) {
            this.khN.cgD();
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
    public void cPc() {
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
                if (this.kNO != null && this.kNO.isShowing()) {
                    this.kNO.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.kzr) {
                    com.baidu.adp.lib.util.l.showToast(this.grE, (int) R.string.mv_local_video_compress_failed);
                    Eg(103);
                }
                this.kNQ = false;
                this.kzq = false;
                cQC();
                break;
            case 3:
                this.kNQ = false;
                this.kzq = true;
                if (!StringUtils.isNull(this.kNN) && (file = new File(this.kNN)) != null) {
                    this.kNN = this.kNN.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.kNN));
                }
                cQC();
                if (!this.kzp) {
                    tp(true);
                    if (this.khN != null) {
                        this.khN.cgD();
                        break;
                    }
                }
                break;
            case 4:
                this.kNQ = false;
                this.kzq = false;
                cQC();
                Eg(104);
                break;
            case 5:
                this.kNQ = false;
                com.baidu.adp.lib.util.l.showToast(this.grE, (int) R.string.mv_local_video_compress_failed);
                if (this.kNP != null && this.kNP.isConvertRunning()) {
                    cQD();
                }
                Eg(105);
                break;
        }
        return true;
    }

    private void cQC() {
        RelativeLayout relativeLayout = (RelativeLayout) this.grE.findViewById(R.id.parent);
        if (relativeLayout != null && this.kNO.getParent() != null) {
            relativeLayout.removeView(this.kNO);
        }
    }

    private void cQD() {
        if (this.kNP != null) {
            this.kNP.abortConvert();
        }
        this.kzr = true;
        if (this.kNN != null) {
            File file = new File(this.kNN);
            if (file.exists()) {
                file.delete();
            }
        }
        cQC();
        this.kNN = null;
    }

    public void onStart() {
        this.kzp = false;
    }

    public void onStop() {
        this.kzp = true;
    }

    public void onResume() {
        if (this.kzq && !TextUtils.isEmpty(this.kNN) && new File(this.kNN).exists()) {
            tp(true);
            Eg(101);
        }
        if (this.khN != null) {
            this.khN.Fa("album");
        }
    }

    public void onDestroy() {
        if (this.kNP != null) {
            this.kNP.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.khN != null) {
            this.khN.Fb("album");
        }
        MessageManager.getInstance().unRegisterListener(this.kzy);
    }

    private void Eg(int i) {
        if (this.khN != null) {
            this.khN.aQ(i, "album");
        }
    }

    public boolean cUK() {
        return this.kNQ;
    }

    public void setProfessionZone(int i) {
        this.kNR = i;
    }
}
