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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.j.k;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import java.io.File;
/* loaded from: classes3.dex */
public class i implements Handler.Callback, com.baidu.tieba.video.c {
    private BaseFragmentActivity bqF;
    private com.baidu.tieba.j.h gJZ;
    private String gXR;
    private String gYa;
    private boolean hbg = false;
    private boolean hbh = false;
    private boolean hbi = false;
    private final CustomMessageListener hbp;
    private VideoFileInfo hpR;
    private String hpS;
    private AlbumVideoCompressingDialogView hpT;
    private VideoConvertUtil hpU;
    private boolean hpV;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gJZ = kVar.aWY();
        }
        if (this.gJZ != null) {
            this.gJZ.aWF();
        }
        this.hbp = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.bqF.setResult(-1, intent);
                    i.this.bqF.finish();
                }
            }
        };
        this.bqF = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.gXR = str3;
        this.hpU = new VideoConvertUtil(baseFragmentActivity);
        this.hpU.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.hbp);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hpR = videoFileInfo;
        this.gYa = str;
        if (this.hpR != null && this.bqF != null) {
            if (this.hpR.videoDuration > 600000) {
                bCD();
            } else if (this.hpU == null || !this.hpU.isConvertRunning()) {
                String str2 = this.hpR.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    l.showToast(this.bqF, d.k.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    vn(107);
                } else if (!new File(str2).exists()) {
                    l.showToast(this.bqF, d.k.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    vn(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hpR != null) {
                        this.hpS = this.hpR.videoPath;
                        na(false);
                        vn(102);
                    }
                } else if (VideoConvertUtil.uH(str2) >= 1500000) {
                    if (VideoConvertUtil.bBa()) {
                        this.hpS = new File(VideoConvertUtil.gWq, "tieba_" + VideoConvertUtil.uG(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hpU.setConvertType(1);
                        this.hpU.cp(str2, this.hpS);
                        bCy();
                        this.hbh = false;
                        this.hbi = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hpR;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hpS = new File(VideoConvertUtil.gWq, "tieba_" + VideoConvertUtil.uG(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hpU.setConvertType(2);
                            this.hpU.cp(str2, this.hpS);
                            bCy();
                            this.hbh = false;
                            this.hbi = false;
                            return;
                        }
                        this.hpS = videoFileInfo2.videoPath;
                        na(false);
                        vn(102);
                    }
                }
            }
        }
    }

    private void bCD() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.bqF).cb(d.k.mv_local_video_too_long).a(d.k.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.bqF.getPageContext());
        a.av(false);
        a.xa();
    }

    private void bCy() {
        RelativeLayout relativeLayout = (RelativeLayout) this.bqF.findViewById(d.g.parent);
        if (relativeLayout != null) {
            if (this.hpT == null) {
                this.hpT = new AlbumVideoCompressingDialogView(this.bqF);
            }
            if (this.hpT.getParent() == null) {
                relativeLayout.addView(this.hpT);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hpT.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hpT.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hpT.setPercent(0);
        this.hpV = true;
    }

    private void na(boolean z) {
        VideoFileInfo vG = vG(this.hpS);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hpS);
        videoInfo.setVideoDuration(vG.videoDuration / 1000);
        videoInfo.setVideoWidth(vG.videoWidth);
        videoInfo.setVideoHeight(vG.videoHeight);
        videoInfo.setVideoLength(new File(vG.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this.bqF, this.gYa, this.mForumName, this.mForumId, this.gXR, videoInfo)));
        this.hbh = false;
        this.hpS = null;
        if (this.gJZ != null) {
            this.gJZ.aWI();
        }
    }

    public static VideoFileInfo vG(String str) {
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
                videoFileInfo.videoDuration = com.baidu.adp.lib.g.b.g(mediaMetadataRetriever.extractMetadata(9), 0);
                videoFileInfo.mimeType = mediaMetadataRetriever.extractMetadata(12);
                videoFileInfo.videoWidth = com.baidu.adp.lib.g.b.g(mediaMetadataRetriever.extractMetadata(18), 0);
                videoFileInfo.videoHeight = com.baidu.adp.lib.g.b.g(mediaMetadataRetriever.extractMetadata(19), 0);
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

    @Override // com.baidu.tieba.video.c
    public void bAW() {
    }

    @Override // com.baidu.tieba.video.c
    public void ur(int i) {
        this.mMainThreadHandler.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertSuccess() {
        this.mMainThreadHandler.sendEmptyMessage(3);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertFailed() {
        this.mMainThreadHandler.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertProgress(int i) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        this.mMainThreadHandler.sendMessage(obtain);
    }

    @Override // com.baidu.tieba.video.c
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
                if (this.hpT != null && this.hpT.isShowing()) {
                    this.hpT.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.hbi) {
                    l.showToast(this.bqF, d.k.mv_local_video_compress_failed);
                    vn(103);
                }
                this.hpV = false;
                this.hbh = false;
                bCz();
                break;
            case 3:
                this.hpV = false;
                this.hbh = true;
                if (!StringUtils.isNull(this.hpS) && (file = new File(this.hpS)) != null) {
                    this.hpS = this.hpS.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hpS));
                }
                bCz();
                if (!this.hbg) {
                    na(true);
                    if (this.gJZ != null) {
                        this.gJZ.aWI();
                        break;
                    }
                }
                break;
            case 4:
                this.hpV = false;
                this.hbh = false;
                bCz();
                vn(104);
                break;
            case 5:
                this.hpV = false;
                l.showToast(this.bqF, d.k.mv_local_video_compress_failed);
                if (this.hpU != null && this.hpU.isConvertRunning()) {
                    bCA();
                }
                vn(105);
                break;
        }
        return true;
    }

    private void bCz() {
        RelativeLayout relativeLayout = (RelativeLayout) this.bqF.findViewById(d.g.parent);
        if (relativeLayout != null && this.hpT.getParent() != null) {
            relativeLayout.removeView(this.hpT);
        }
    }

    private void bCA() {
        if (this.hpU != null) {
            this.hpU.abortConvert();
        }
        this.hbi = true;
        if (this.hpS != null) {
            File file = new File(this.hpS);
            if (file.exists()) {
                file.delete();
            }
        }
        bCz();
        this.hpS = null;
    }

    public void onStart() {
        this.hbg = false;
    }

    public void onStop() {
        this.hbg = true;
    }

    public void onResume() {
        if (this.hbh && !TextUtils.isEmpty(this.hpS) && new File(this.hpS).exists()) {
            na(true);
            vn(101);
        }
        if (this.gJZ != null) {
            this.gJZ.qx("album");
        }
    }

    public void onDestroy() {
        if (this.hpU != null) {
            this.hpU.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.gJZ != null) {
            this.gJZ.qy("album");
        }
        MessageManager.getInstance().unRegisterListener(this.hbp);
    }

    private void vn(int i) {
        if (this.gJZ != null) {
            this.gJZ.ad(i, "album");
        }
    }

    public boolean bHc() {
        return this.hpV;
    }
}
