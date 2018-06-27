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
    private BaseFragmentActivity bsf;
    private com.baidu.tieba.j.h gOa;
    private String hbW;
    private String hcf;
    private boolean hfl = false;
    private boolean hfm = false;
    private boolean hfn = false;
    private final CustomMessageListener hfu;
    private VideoFileInfo hub;
    private String huc;
    private AlbumVideoCompressingDialogView hud;
    private VideoConvertUtil hue;
    private boolean huf;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gOa = kVar.aXF();
        }
        if (this.gOa != null) {
            this.gOa.aXm();
        }
        this.hfu = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.bsf.setResult(-1, intent);
                    i.this.bsf.finish();
                }
            }
        };
        this.bsf = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.hbW = str3;
        this.hue = new VideoConvertUtil(baseFragmentActivity);
        this.hue.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.hfu);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hub = videoFileInfo;
        this.hcf = str;
        if (this.hub != null && this.bsf != null) {
            if (this.hub.videoDuration > 600000) {
                bDd();
            } else if (this.hue == null || !this.hue.isConvertRunning()) {
                String str2 = this.hub.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    l.showToast(this.bsf, d.k.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    vw(107);
                } else if (!new File(str2).exists()) {
                    l.showToast(this.bsf, d.k.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    vw(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hub != null) {
                        this.huc = this.hub.videoPath;
                        ni(false);
                        vw(102);
                    }
                } else if (VideoConvertUtil.uD(str2) >= 1500000) {
                    if (VideoConvertUtil.bBA()) {
                        this.huc = new File(VideoConvertUtil.hav, "tieba_" + VideoConvertUtil.uC(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hue.setConvertType(1);
                        this.hue.ct(str2, this.huc);
                        bCY();
                        this.hfm = false;
                        this.hfn = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hub;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.huc = new File(VideoConvertUtil.hav, "tieba_" + VideoConvertUtil.uC(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hue.setConvertType(2);
                            this.hue.ct(str2, this.huc);
                            bCY();
                            this.hfm = false;
                            this.hfn = false;
                            return;
                        }
                        this.huc = videoFileInfo2.videoPath;
                        ni(false);
                        vw(102);
                    }
                }
            }
        }
    }

    private void bDd() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.bsf).cc(d.k.mv_local_video_too_long).a(d.k.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.bsf.getPageContext());
        a.ax(false);
        a.xn();
    }

    private void bCY() {
        RelativeLayout relativeLayout = (RelativeLayout) this.bsf.findViewById(d.g.parent);
        if (relativeLayout != null) {
            if (this.hud == null) {
                this.hud = new AlbumVideoCompressingDialogView(this.bsf);
            }
            if (this.hud.getParent() == null) {
                relativeLayout.addView(this.hud);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hud.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hud.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hud.setPercent(0);
        this.huf = true;
    }

    private void ni(boolean z) {
        VideoFileInfo vC = vC(this.huc);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.huc);
        videoInfo.setVideoDuration(vC.videoDuration / 1000);
        videoInfo.setVideoWidth(vC.videoWidth);
        videoInfo.setVideoHeight(vC.videoHeight);
        videoInfo.setVideoLength(new File(vC.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this.bsf, this.hcf, this.mForumName, this.mForumId, this.hbW, videoInfo)));
        this.hfm = false;
        this.huc = null;
        if (this.gOa != null) {
            this.gOa.aXp();
        }
    }

    public static VideoFileInfo vC(String str) {
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
    public void bBw() {
    }

    @Override // com.baidu.tieba.video.c
    public void uz(int i) {
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
                if (this.hud != null && this.hud.isShowing()) {
                    this.hud.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.hfn) {
                    l.showToast(this.bsf, d.k.mv_local_video_compress_failed);
                    vw(103);
                }
                this.huf = false;
                this.hfm = false;
                bCZ();
                break;
            case 3:
                this.huf = false;
                this.hfm = true;
                if (!StringUtils.isNull(this.huc) && (file = new File(this.huc)) != null) {
                    this.huc = this.huc.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.huc));
                }
                bCZ();
                if (!this.hfl) {
                    ni(true);
                    if (this.gOa != null) {
                        this.gOa.aXp();
                        break;
                    }
                }
                break;
            case 4:
                this.huf = false;
                this.hfm = false;
                bCZ();
                vw(104);
                break;
            case 5:
                this.huf = false;
                l.showToast(this.bsf, d.k.mv_local_video_compress_failed);
                if (this.hue != null && this.hue.isConvertRunning()) {
                    bDa();
                }
                vw(105);
                break;
        }
        return true;
    }

    private void bCZ() {
        RelativeLayout relativeLayout = (RelativeLayout) this.bsf.findViewById(d.g.parent);
        if (relativeLayout != null && this.hud.getParent() != null) {
            relativeLayout.removeView(this.hud);
        }
    }

    private void bDa() {
        if (this.hue != null) {
            this.hue.abortConvert();
        }
        this.hfn = true;
        if (this.huc != null) {
            File file = new File(this.huc);
            if (file.exists()) {
                file.delete();
            }
        }
        bCZ();
        this.huc = null;
    }

    public void onStart() {
        this.hfl = false;
    }

    public void onStop() {
        this.hfl = true;
    }

    public void onResume() {
        if (this.hfm && !TextUtils.isEmpty(this.huc) && new File(this.huc).exists()) {
            ni(true);
            vw(101);
        }
        if (this.gOa != null) {
            this.gOa.qx("album");
        }
    }

    public void onDestroy() {
        if (this.hue != null) {
            this.hue.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.gOa != null) {
            this.gOa.qy("album");
        }
        MessageManager.getInstance().unRegisterListener(this.hfu);
    }

    private void vw(int i) {
        if (this.gOa != null) {
            this.gOa.aa(i, "album");
        }
    }

    public boolean bHD() {
        return this.huf;
    }
}
