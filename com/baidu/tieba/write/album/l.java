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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.File;
/* loaded from: classes2.dex */
public class l implements Handler.Callback, com.baidu.tieba.video.c {
    private Handler FZ;
    private BaseFragmentActivity fAn;
    private VideoFileInfo hGf;
    private String hGg;
    private com.baidu.tieba.write.video.a hGh;
    private com.baidu.tieba.video.f hGi;
    private boolean hGj;
    private com.baidu.tieba.i.h hbR;
    private String hpD;
    private String hpu;
    private boolean hsN = false;
    private boolean hsO = false;
    private boolean hsP = false;
    private final CustomMessageListener hsW;
    private String mForumId;
    private String mForumName;

    public l(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.hbR = kVar.aXg();
        }
        if (this.hbR != null) {
            this.hbR.aWN();
        }
        this.hsW = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    l.this.fAn.setResult(-1, intent);
                    l.this.fAn.finish();
                }
            }
        };
        this.fAn = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.hpu = str3;
        this.hGi = new com.baidu.tieba.video.f(baseFragmentActivity);
        this.hGi.a(this);
        this.FZ = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.hsW);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hGf = videoFileInfo;
        this.hpD = str;
        if (this.hGf != null && this.fAn != null) {
            if (this.hGf.videoDuration > 600000) {
                bCp();
            } else if (this.hGi == null || !this.hGi.isConvertRunning()) {
                String str2 = this.hGf.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.fAn, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    xr(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.fAn, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    xr(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hGf != null) {
                        this.hGg = this.hGf.videoPath;
                        nm(false);
                        xr(102);
                    }
                } else if (com.baidu.tieba.video.f.tD(str2) >= 1500000) {
                    if (com.baidu.tieba.video.f.bAQ()) {
                        this.hGg = new File(com.baidu.tieba.video.f.hnV, "tieba_" + com.baidu.tieba.video.f.tC(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hGi.setConvertType(1);
                        this.hGi.ci(str2, this.hGg);
                        bCk();
                        this.hsO = false;
                        this.hsP = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hGf;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hGg = new File(com.baidu.tieba.video.f.hnV, "tieba_" + com.baidu.tieba.video.f.tC(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hGi.setConvertType(2);
                            this.hGi.ci(str2, this.hGg);
                            bCk();
                            this.hsO = false;
                            this.hsP = false;
                            return;
                        }
                        this.hGg = videoFileInfo2.videoPath;
                        nm(false);
                        xr(102);
                    }
                }
            }
        }
    }

    private void bCp() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.fAn).fa(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.l.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.fAn.getPageContext());
        a.ba(false);
        a.AU();
    }

    private void bCk() {
        RelativeLayout relativeLayout = (RelativeLayout) this.fAn.findViewById(d.g.parent);
        if (relativeLayout != null) {
            if (this.hGh == null) {
                this.hGh = new com.baidu.tieba.write.video.a(this.fAn);
            }
            if (this.hGh.getParent() == null) {
                relativeLayout.addView(this.hGh);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hGh.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hGh.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hGh.setPercent(0);
        this.hGj = true;
    }

    private void nm(boolean z) {
        VideoFileInfo ut = ut(this.hGg);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hGg);
        videoInfo.setVideoDuration(ut.videoDuration / 1000);
        videoInfo.setVideoWidth(ut.videoWidth);
        videoInfo.setVideoHeight(ut.videoHeight);
        videoInfo.setVideoLength(new File(ut.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this.fAn, this.hpD, this.mForumName, this.mForumId, this.hpu, videoInfo)));
        this.hsO = false;
        this.hGg = null;
        if (this.hbR != null) {
            this.hbR.aWQ();
        }
    }

    public static VideoFileInfo ut(String str) {
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
                videoFileInfo.videoDuration = com.baidu.adp.lib.g.b.h(mediaMetadataRetriever.extractMetadata(9), 0);
                videoFileInfo.mimeType = mediaMetadataRetriever.extractMetadata(12);
                videoFileInfo.videoWidth = com.baidu.adp.lib.g.b.h(mediaMetadataRetriever.extractMetadata(18), 0);
                videoFileInfo.videoHeight = com.baidu.adp.lib.g.b.h(mediaMetadataRetriever.extractMetadata(19), 0);
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
    public void bAM() {
    }

    @Override // com.baidu.tieba.video.c
    public void wC(int i) {
        this.FZ.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertSuccess() {
        this.FZ.sendEmptyMessage(3);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertFailed() {
        this.FZ.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertProgress(int i) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        this.FZ.sendMessage(obtain);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertAborted() {
        this.FZ.sendEmptyMessage(4);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        File file;
        this.FZ.removeMessages(5);
        switch (message.what) {
            case 1:
                this.FZ.removeMessages(1);
                if (this.hGh != null && this.hGh.isShowing()) {
                    this.hGh.setPercent(message.arg1);
                }
                this.FZ.sendMessageDelayed(this.FZ.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.hsP) {
                    com.baidu.adp.lib.util.l.showToast(this.fAn, d.j.mv_local_video_compress_failed);
                    xr(103);
                }
                this.hGj = false;
                this.hsO = false;
                bCl();
                break;
            case 3:
                this.hGj = false;
                this.hsO = true;
                if (!StringUtils.isNull(this.hGg) && (file = new File(this.hGg)) != null) {
                    this.hGg = this.hGg.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hGg));
                }
                bCl();
                if (!this.hsN) {
                    nm(true);
                    if (this.hbR != null) {
                        this.hbR.aWQ();
                        break;
                    }
                }
                break;
            case 4:
                this.hGj = false;
                this.hsO = false;
                bCl();
                xr(104);
                break;
            case 5:
                this.hGj = false;
                com.baidu.adp.lib.util.l.showToast(this.fAn, d.j.mv_local_video_compress_failed);
                if (this.hGi != null && this.hGi.isConvertRunning()) {
                    bCm();
                }
                xr(105);
                break;
        }
        return true;
    }

    private void bCl() {
        RelativeLayout relativeLayout = (RelativeLayout) this.fAn.findViewById(d.g.parent);
        if (relativeLayout != null && this.hGh.getParent() != null) {
            relativeLayout.removeView(this.hGh);
        }
    }

    private void bCm() {
        if (this.hGi != null) {
            this.hGi.abortConvert();
        }
        this.hsP = true;
        if (this.hGg != null) {
            File file = new File(this.hGg);
            if (file.exists()) {
                file.delete();
            }
        }
        bCl();
        this.hGg = null;
    }

    public void onStart() {
        this.hsN = false;
    }

    public void onStop() {
        this.hsN = true;
    }

    public void onResume() {
        if (this.hsO && !TextUtils.isEmpty(this.hGg) && new File(this.hGg).exists()) {
            nm(true);
            xr(101);
        }
        if (this.hbR != null) {
            this.hbR.pA("album");
        }
    }

    public void onDestroy() {
        if (this.hGi != null) {
            this.hGi.destroy();
        }
        if (this.FZ != null) {
            this.FZ.removeMessages(5);
        }
        if (this.hbR != null) {
            this.hbR.pB("album");
        }
        MessageManager.getInstance().unRegisterListener(this.hsW);
    }

    private void xr(int i) {
        if (this.hbR != null) {
            this.hbR.V(i, "album");
        }
    }

    public boolean bGH() {
        return this.hGj;
    }
}
