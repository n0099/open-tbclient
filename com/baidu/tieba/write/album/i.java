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
    private BaseFragmentActivity dlh;
    private String fTQ;
    private VideoFileInfo jPv;
    private String jPw;
    private AlbumVideoCompressingDialogView jPx;
    private VideoConvertUtil jPy;
    private boolean jPz;
    private com.baidu.tieba.j.h jhv;
    private String jwm;
    private final CustomMessageListener jzF;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;
    private boolean jzw = false;
    private boolean jzx = false;
    private boolean jzy = false;
    private int jPA = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.jhv = lVar.bPk();
        }
        if (this.jhv != null) {
            this.jhv.bOO();
        }
        this.jzF = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.dlh.setResult(-1, intent);
                    i.this.dlh.finish();
                }
            }
        };
        this.dlh = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.jwm = str3;
        this.jPy = new VideoConvertUtil(baseFragmentActivity);
        this.jPy.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.jzF);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.jPv = videoFileInfo;
        this.fTQ = str;
        if (this.jPv != null && this.dlh != null) {
            if (this.jPv.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                cvG();
            } else if (this.jPy == null || !this.jPy.isConvertRunning()) {
                String str2 = this.jPv.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.dlh, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    Da(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.dlh, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    Da(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.jPv != null) {
                        this.jPw = this.jPv.videoPath;
                        rG(false);
                        Da(102);
                    }
                } else if (VideoConvertUtil.FE(str2) >= 1500000) {
                    if (VideoConvertUtil.ctZ()) {
                        this.jPw = new File(VideoConvertUtil.juL, "tieba_" + VideoConvertUtil.FD(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.jPy.setConvertType(1);
                        this.jPy.er(str2, this.jPw);
                        cvB();
                        this.jzx = false;
                        this.jzy = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.jPv;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.jPw = new File(VideoConvertUtil.juL, "tieba_" + VideoConvertUtil.FD(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.jPy.setConvertType(2);
                            this.jPy.er(str2, this.jPw);
                            cvB();
                            this.jzx = false;
                            this.jzy = false;
                            return;
                        }
                        this.jPw = videoFileInfo2.videoPath;
                        rG(false);
                        Da(102);
                    }
                }
            }
        }
    }

    private void cvG() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.dlh).ht(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.dlh.getPageContext());
        a.dR(false);
        a.agK();
    }

    private void cvB() {
        RelativeLayout relativeLayout = (RelativeLayout) this.dlh.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.jPx == null) {
                this.jPx = new AlbumVideoCompressingDialogView(this.dlh);
            }
            if (this.jPx.getParent() == null) {
                relativeLayout.addView(this.jPx);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jPx.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.jPx.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.jPx.setPercent(0);
        this.jPz = true;
    }

    private void rG(boolean z) {
        VideoFileInfo GJ = GJ(this.jPw);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jPw);
        videoInfo.setVideoDuration(GJ.videoDuration / 1000);
        videoInfo.setVideoWidth(GJ.videoWidth);
        videoInfo.setVideoHeight(GJ.videoHeight);
        videoInfo.setVideoLength(new File(GJ.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.dlh, this.fTQ, this.mForumName, this.mForumId, this.jwm, videoInfo);
        editVideoActivityConfig.setProZone(this.jPA);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        this.jzx = false;
        this.jPw = null;
        if (this.jhv != null) {
            this.jhv.bOR();
        }
    }

    public static VideoFileInfo GJ(String str) {
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
    public void ctV() {
    }

    @Override // com.baidu.tieba.video.d
    public void Ca(int i) {
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
                if (this.jPx != null && this.jPx.isShowing()) {
                    this.jPx.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.jzy) {
                    com.baidu.adp.lib.util.l.showToast(this.dlh, (int) R.string.mv_local_video_compress_failed);
                    Da(103);
                }
                this.jPz = false;
                this.jzx = false;
                cvC();
                break;
            case 3:
                this.jPz = false;
                this.jzx = true;
                if (!StringUtils.isNull(this.jPw) && (file = new File(this.jPw)) != null) {
                    this.jPw = this.jPw.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.jPw));
                }
                cvC();
                if (!this.jzw) {
                    rG(true);
                    if (this.jhv != null) {
                        this.jhv.bOR();
                        break;
                    }
                }
                break;
            case 4:
                this.jPz = false;
                this.jzx = false;
                cvC();
                Da(104);
                break;
            case 5:
                this.jPz = false;
                com.baidu.adp.lib.util.l.showToast(this.dlh, (int) R.string.mv_local_video_compress_failed);
                if (this.jPy != null && this.jPy.isConvertRunning()) {
                    cvD();
                }
                Da(105);
                break;
        }
        return true;
    }

    private void cvC() {
        RelativeLayout relativeLayout = (RelativeLayout) this.dlh.findViewById(R.id.parent);
        if (relativeLayout != null && this.jPx.getParent() != null) {
            relativeLayout.removeView(this.jPx);
        }
    }

    private void cvD() {
        if (this.jPy != null) {
            this.jPy.abortConvert();
        }
        this.jzy = true;
        if (this.jPw != null) {
            File file = new File(this.jPw);
            if (file.exists()) {
                file.delete();
            }
        }
        cvC();
        this.jPw = null;
    }

    public void onStart() {
        this.jzw = false;
    }

    public void onStop() {
        this.jzw = true;
    }

    public void onResume() {
        if (this.jzx && !TextUtils.isEmpty(this.jPw) && new File(this.jPw).exists()) {
            rG(true);
            Da(101);
        }
        if (this.jhv != null) {
            this.jhv.AZ("album");
        }
    }

    public void onDestroy() {
        if (this.jPy != null) {
            this.jPy.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.jhv != null) {
            this.jhv.Ba("album");
        }
        MessageManager.getInstance().unRegisterListener(this.jzF);
    }

    private void Da(int i) {
        if (this.jhv != null) {
            this.jhv.aw(i, "album");
        }
    }

    public boolean cAR() {
        return this.jPz;
    }

    public void setProfessionZone(int i) {
        this.jPA = i;
    }
}
