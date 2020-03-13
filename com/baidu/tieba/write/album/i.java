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
    private String gOk;
    private BaseFragmentActivity grR;
    private VideoFileInfo kNY;
    private String kNZ;
    private AlbumVideoCompressingDialogView kOa;
    private VideoConvertUtil kOb;
    private boolean kOc;
    private com.baidu.tieba.k.h khZ;
    private String kwy;
    private final CustomMessageListener kzK;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;
    private boolean kzB = false;
    private boolean kzC = false;
    private boolean kzD = false;
    private int kOd = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.khZ = lVar.cgZ();
        }
        if (this.khZ != null) {
            this.khZ.cgB();
        }
        this.kzK = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    i.this.grR.setResult(-1, intent);
                    i.this.grR.finish();
                }
            }
        };
        this.grR = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.kwy = str3;
        this.kOb = new VideoConvertUtil(baseFragmentActivity);
        this.kOb.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.kzK);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.kNY = videoFileInfo;
        this.gOk = str;
        if (this.kNY != null && this.grR != null) {
            if (this.kNY.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                cQH();
            } else if (this.kOb == null || !this.kOb.isConvertRunning()) {
                String str2 = this.kNY.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.grR, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    Eg(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.grR, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    Eg(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.kNY != null) {
                        this.kNZ = this.kNY.videoPath;
                        tp(false);
                        Eg(102);
                    }
                } else if (VideoConvertUtil.JT(str2) >= 1500000) {
                    if (VideoConvertUtil.cPh()) {
                        this.kNZ = new File(VideoConvertUtil.kve, "tieba_" + VideoConvertUtil.JS(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.kOb.setConvertType(1);
                        this.kOb.eI(str2, this.kNZ);
                        cQC();
                        this.kzC = false;
                        this.kzD = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.kNY;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.kNZ = new File(VideoConvertUtil.kve, "tieba_" + VideoConvertUtil.JS(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.kOb.setConvertType(2);
                            this.kOb.eI(str2, this.kNZ);
                            cQC();
                            this.kzC = false;
                            this.kzD = false;
                            return;
                        }
                        this.kNZ = videoFileInfo2.videoPath;
                        tp(false);
                        Eg(102);
                    }
                }
            }
        }
    }

    private void cQH() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.grR).jV(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.grR.getPageContext());
        a.fH(false);
        a.aEC();
    }

    private void cQC() {
        RelativeLayout relativeLayout = (RelativeLayout) this.grR.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.kOa == null) {
                this.kOa = new AlbumVideoCompressingDialogView(this.grR);
            }
            if (this.kOa.getParent() == null) {
                relativeLayout.addView(this.kOa);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kOa.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.kOa.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.kOa.setPercent(0);
        this.kOc = true;
    }

    private void tp(boolean z) {
        VideoFileInfo KQ = KQ(this.kNZ);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kNZ);
        videoInfo.setVideoDuration(KQ.videoDuration / 1000);
        videoInfo.setVideoWidth(KQ.videoWidth);
        videoInfo.setVideoHeight(KQ.videoHeight);
        videoInfo.setVideoLength(new File(KQ.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.grR, this.gOk, this.mForumName, this.mForumId, this.kwy, videoInfo);
        editVideoActivityConfig.setProZone(this.kOd);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.kzC = false;
        this.kNZ = null;
        if (this.khZ != null) {
            this.khZ.cgE();
        }
    }

    public static VideoFileInfo KQ(String str) {
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
    public void cPd() {
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
                if (this.kOa != null && this.kOa.isShowing()) {
                    this.kOa.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.kzD) {
                    com.baidu.adp.lib.util.l.showToast(this.grR, (int) R.string.mv_local_video_compress_failed);
                    Eg(103);
                }
                this.kOc = false;
                this.kzC = false;
                cQD();
                break;
            case 3:
                this.kOc = false;
                this.kzC = true;
                if (!StringUtils.isNull(this.kNZ) && (file = new File(this.kNZ)) != null) {
                    this.kNZ = this.kNZ.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.kNZ));
                }
                cQD();
                if (!this.kzB) {
                    tp(true);
                    if (this.khZ != null) {
                        this.khZ.cgE();
                        break;
                    }
                }
                break;
            case 4:
                this.kOc = false;
                this.kzC = false;
                cQD();
                Eg(104);
                break;
            case 5:
                this.kOc = false;
                com.baidu.adp.lib.util.l.showToast(this.grR, (int) R.string.mv_local_video_compress_failed);
                if (this.kOb != null && this.kOb.isConvertRunning()) {
                    cQE();
                }
                Eg(105);
                break;
        }
        return true;
    }

    private void cQD() {
        RelativeLayout relativeLayout = (RelativeLayout) this.grR.findViewById(R.id.parent);
        if (relativeLayout != null && this.kOa.getParent() != null) {
            relativeLayout.removeView(this.kOa);
        }
    }

    private void cQE() {
        if (this.kOb != null) {
            this.kOb.abortConvert();
        }
        this.kzD = true;
        if (this.kNZ != null) {
            File file = new File(this.kNZ);
            if (file.exists()) {
                file.delete();
            }
        }
        cQD();
        this.kNZ = null;
    }

    public void onStart() {
        this.kzB = false;
    }

    public void onStop() {
        this.kzB = true;
    }

    public void onResume() {
        if (this.kzC && !TextUtils.isEmpty(this.kNZ) && new File(this.kNZ).exists()) {
            tp(true);
            Eg(101);
        }
        if (this.khZ != null) {
            this.khZ.Fb("album");
        }
    }

    public void onDestroy() {
        if (this.kOb != null) {
            this.kOb.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.khZ != null) {
            this.khZ.Fc("album");
        }
        MessageManager.getInstance().unRegisterListener(this.kzK);
    }

    private void Eg(int i) {
        if (this.khZ != null) {
            this.khZ.aQ(i, "album");
        }
    }

    public boolean cUL() {
        return this.kOc;
    }

    public void setProfessionZone(int i) {
        this.kOd = i;
    }
}
