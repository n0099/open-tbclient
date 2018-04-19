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
    private BaseFragmentActivity epn;
    private String gLp;
    private String gLy;
    private boolean gOE = false;
    private boolean gOF = false;
    private boolean gOG = false;
    private final CustomMessageListener gON;
    private com.baidu.tieba.j.h gxw;
    private VideoFileInfo hcV;
    private String hcW;
    private AlbumVideoCompressingDialogView hcX;
    private VideoConvertUtil hcY;
    private boolean hcZ;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gxw = kVar.aSb();
        }
        if (this.gxw != null) {
            this.gxw.aRI();
        }
        this.gON = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.epn.setResult(-1, intent);
                    i.this.epn.finish();
                }
            }
        };
        this.epn = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.gLp = str3;
        this.hcY = new VideoConvertUtil(baseFragmentActivity);
        this.hcY.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.gON);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hcV = videoFileInfo;
        this.gLy = str;
        if (this.hcV != null && this.epn != null) {
            if (this.hcV.videoDuration > 600000) {
                bxy();
            } else if (this.hcY == null || !this.hcY.isConvertRunning()) {
                String str2 = this.hcV.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    l.showToast(this.epn, d.k.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    uW(107);
                } else if (!new File(str2).exists()) {
                    l.showToast(this.epn, d.k.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    uW(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hcV != null) {
                        this.hcW = this.hcV.videoPath;
                        mT(false);
                        uW(102);
                    }
                } else if (VideoConvertUtil.tK(str2) >= 1500000) {
                    if (VideoConvertUtil.bvV()) {
                        this.hcW = new File(VideoConvertUtil.gJO, "tieba_" + VideoConvertUtil.tJ(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hcY.setConvertType(1);
                        this.hcY.ch(str2, this.hcW);
                        bxt();
                        this.gOF = false;
                        this.gOG = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hcV;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hcW = new File(VideoConvertUtil.gJO, "tieba_" + VideoConvertUtil.tJ(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hcY.setConvertType(2);
                            this.hcY.ch(str2, this.hcW);
                            bxt();
                            this.gOF = false;
                            this.gOG = false;
                            return;
                        }
                        this.hcW = videoFileInfo2.videoPath;
                        mT(false);
                        uW(102);
                    }
                }
            }
        }
    }

    private void bxy() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.epn).bY(d.k.mv_local_video_too_long).a(d.k.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.epn.getPageContext());
        a.as(false);
        a.tD();
    }

    private void bxt() {
        RelativeLayout relativeLayout = (RelativeLayout) this.epn.findViewById(d.g.parent);
        if (relativeLayout != null) {
            if (this.hcX == null) {
                this.hcX = new AlbumVideoCompressingDialogView(this.epn);
            }
            if (this.hcX.getParent() == null) {
                relativeLayout.addView(this.hcX);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hcX.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hcX.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hcX.setPercent(0);
        this.hcZ = true;
    }

    private void mT(boolean z) {
        VideoFileInfo uJ = uJ(this.hcW);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hcW);
        videoInfo.setVideoDuration(uJ.videoDuration / 1000);
        videoInfo.setVideoWidth(uJ.videoWidth);
        videoInfo.setVideoHeight(uJ.videoHeight);
        videoInfo.setVideoLength(new File(uJ.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this.epn, this.gLy, this.mForumName, this.mForumId, this.gLp, videoInfo)));
        this.gOF = false;
        this.hcW = null;
        if (this.gxw != null) {
            this.gxw.aRL();
        }
    }

    public static VideoFileInfo uJ(String str) {
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
    public void bvR() {
    }

    @Override // com.baidu.tieba.video.c
    public void uf(int i) {
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
                if (this.hcX != null && this.hcX.isShowing()) {
                    this.hcX.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.gOG) {
                    l.showToast(this.epn, d.k.mv_local_video_compress_failed);
                    uW(103);
                }
                this.hcZ = false;
                this.gOF = false;
                bxu();
                break;
            case 3:
                this.hcZ = false;
                this.gOF = true;
                if (!StringUtils.isNull(this.hcW) && (file = new File(this.hcW)) != null) {
                    this.hcW = this.hcW.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hcW));
                }
                bxu();
                if (!this.gOE) {
                    mT(true);
                    if (this.gxw != null) {
                        this.gxw.aRL();
                        break;
                    }
                }
                break;
            case 4:
                this.hcZ = false;
                this.gOF = false;
                bxu();
                uW(104);
                break;
            case 5:
                this.hcZ = false;
                l.showToast(this.epn, d.k.mv_local_video_compress_failed);
                if (this.hcY != null && this.hcY.isConvertRunning()) {
                    bxv();
                }
                uW(105);
                break;
        }
        return true;
    }

    private void bxu() {
        RelativeLayout relativeLayout = (RelativeLayout) this.epn.findViewById(d.g.parent);
        if (relativeLayout != null && this.hcX.getParent() != null) {
            relativeLayout.removeView(this.hcX);
        }
    }

    private void bxv() {
        if (this.hcY != null) {
            this.hcY.abortConvert();
        }
        this.gOG = true;
        if (this.hcW != null) {
            File file = new File(this.hcW);
            if (file.exists()) {
                file.delete();
            }
        }
        bxu();
        this.hcW = null;
    }

    public void onStart() {
        this.gOE = false;
    }

    public void onStop() {
        this.gOE = true;
    }

    public void onResume() {
        if (this.gOF && !TextUtils.isEmpty(this.hcW) && new File(this.hcW).exists()) {
            mT(true);
            uW(101);
        }
        if (this.gxw != null) {
            this.gxw.pG("album");
        }
    }

    public void onDestroy() {
        if (this.hcY != null) {
            this.hcY.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.gxw != null) {
            this.gxw.pH("album");
        }
        MessageManager.getInstance().unRegisterListener(this.gON);
    }

    private void uW(int i) {
        if (this.gxw != null) {
            this.gxw.ad(i, "album");
        }
    }

    public boolean bBY() {
        return this.hcZ;
    }
}
