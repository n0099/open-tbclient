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
    private Handler FU;
    private BaseFragmentActivity fAb;
    private VideoFileInfo hFS;
    private String hFT;
    private com.baidu.tieba.write.video.a hFU;
    private com.baidu.tieba.video.f hFV;
    private boolean hFW;
    private com.baidu.tieba.i.h hbC;
    private String hph;
    private String hpq;
    private boolean hsA = false;
    private boolean hsB = false;
    private boolean hsC = false;
    private final CustomMessageListener hsJ;
    private String mForumId;
    private String mForumName;

    public l(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.hbC = kVar.aXf();
        }
        if (this.hbC != null) {
            this.hbC.aWM();
        }
        this.hsJ = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    l.this.fAb.setResult(-1, intent);
                    l.this.fAb.finish();
                }
            }
        };
        this.fAb = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.hph = str3;
        this.hFV = new com.baidu.tieba.video.f(baseFragmentActivity);
        this.hFV.a(this);
        this.FU = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.hsJ);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hFS = videoFileInfo;
        this.hpq = str;
        if (this.hFS != null && this.fAb != null) {
            if (this.hFS.videoDuration > 600000) {
                bCo();
            } else if (this.hFV == null || !this.hFV.isConvertRunning()) {
                String str2 = this.hFS.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.fAb, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    xs(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.fAb, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    xs(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hFS != null) {
                        this.hFT = this.hFS.videoPath;
                        nm(false);
                        xs(102);
                    }
                } else if (com.baidu.tieba.video.f.tD(str2) >= 1500000) {
                    if (com.baidu.tieba.video.f.bAP()) {
                        this.hFT = new File(com.baidu.tieba.video.f.hnI, "tieba_" + com.baidu.tieba.video.f.tC(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hFV.setConvertType(1);
                        this.hFV.ci(str2, this.hFT);
                        bCj();
                        this.hsB = false;
                        this.hsC = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hFS;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hFT = new File(com.baidu.tieba.video.f.hnI, "tieba_" + com.baidu.tieba.video.f.tC(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hFV.setConvertType(2);
                            this.hFV.ci(str2, this.hFT);
                            bCj();
                            this.hsB = false;
                            this.hsC = false;
                            return;
                        }
                        this.hFT = videoFileInfo2.videoPath;
                        nm(false);
                        xs(102);
                    }
                }
            }
        }
    }

    private void bCo() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.fAb).fa(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.l.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.fAb.getPageContext());
        a.ba(false);
        a.AU();
    }

    private void bCj() {
        RelativeLayout relativeLayout = (RelativeLayout) this.fAb.findViewById(d.g.parent);
        if (relativeLayout != null) {
            if (this.hFU == null) {
                this.hFU = new com.baidu.tieba.write.video.a(this.fAb);
            }
            if (this.hFU.getParent() == null) {
                relativeLayout.addView(this.hFU);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hFU.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hFU.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hFU.setPercent(0);
        this.hFW = true;
    }

    private void nm(boolean z) {
        VideoFileInfo ut = ut(this.hFT);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hFT);
        videoInfo.setVideoDuration(ut.videoDuration / 1000);
        videoInfo.setVideoWidth(ut.videoWidth);
        videoInfo.setVideoHeight(ut.videoHeight);
        videoInfo.setVideoLength(new File(ut.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this.fAb, this.hpq, this.mForumName, this.mForumId, this.hph, videoInfo)));
        this.hsB = false;
        this.hFT = null;
        if (this.hbC != null) {
            this.hbC.aWP();
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
    public void bAL() {
    }

    @Override // com.baidu.tieba.video.c
    public void wD(int i) {
        this.FU.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertSuccess() {
        this.FU.sendEmptyMessage(3);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertFailed() {
        this.FU.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertProgress(int i) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        this.FU.sendMessage(obtain);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertAborted() {
        this.FU.sendEmptyMessage(4);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        File file;
        this.FU.removeMessages(5);
        switch (message.what) {
            case 1:
                this.FU.removeMessages(1);
                if (this.hFU != null && this.hFU.isShowing()) {
                    this.hFU.setPercent(message.arg1);
                }
                this.FU.sendMessageDelayed(this.FU.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.hsC) {
                    com.baidu.adp.lib.util.l.showToast(this.fAb, d.j.mv_local_video_compress_failed);
                    xs(103);
                }
                this.hFW = false;
                this.hsB = false;
                bCk();
                break;
            case 3:
                this.hFW = false;
                this.hsB = true;
                if (!StringUtils.isNull(this.hFT) && (file = new File(this.hFT)) != null) {
                    this.hFT = this.hFT.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hFT));
                }
                bCk();
                if (!this.hsA) {
                    nm(true);
                    if (this.hbC != null) {
                        this.hbC.aWP();
                        break;
                    }
                }
                break;
            case 4:
                this.hFW = false;
                this.hsB = false;
                bCk();
                xs(104);
                break;
            case 5:
                this.hFW = false;
                com.baidu.adp.lib.util.l.showToast(this.fAb, d.j.mv_local_video_compress_failed);
                if (this.hFV != null && this.hFV.isConvertRunning()) {
                    bCl();
                }
                xs(105);
                break;
        }
        return true;
    }

    private void bCk() {
        RelativeLayout relativeLayout = (RelativeLayout) this.fAb.findViewById(d.g.parent);
        if (relativeLayout != null && this.hFU.getParent() != null) {
            relativeLayout.removeView(this.hFU);
        }
    }

    private void bCl() {
        if (this.hFV != null) {
            this.hFV.abortConvert();
        }
        this.hsC = true;
        if (this.hFT != null) {
            File file = new File(this.hFT);
            if (file.exists()) {
                file.delete();
            }
        }
        bCk();
        this.hFT = null;
    }

    public void onStart() {
        this.hsA = false;
    }

    public void onStop() {
        this.hsA = true;
    }

    public void onResume() {
        if (this.hsB && !TextUtils.isEmpty(this.hFT) && new File(this.hFT).exists()) {
            nm(true);
            xs(101);
        }
        if (this.hbC != null) {
            this.hbC.pA("album");
        }
    }

    public void onDestroy() {
        if (this.hFV != null) {
            this.hFV.destroy();
        }
        if (this.FU != null) {
            this.FU.removeMessages(5);
        }
        if (this.hbC != null) {
            this.hbC.pB("album");
        }
        MessageManager.getInstance().unRegisterListener(this.hsJ);
    }

    private void xs(int i) {
        if (this.hbC != null) {
            this.hbC.V(i, "album");
        }
    }

    public boolean bGG() {
        return this.hFW;
    }
}
