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
    private BaseFragmentActivity epk;
    private String gLm;
    private String gLv;
    private boolean gOB = false;
    private boolean gOC = false;
    private boolean gOD = false;
    private final CustomMessageListener gOK;
    private com.baidu.tieba.j.h gxt;
    private VideoFileInfo hcS;
    private String hcT;
    private AlbumVideoCompressingDialogView hcU;
    private VideoConvertUtil hcV;
    private boolean hcW;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gxt = kVar.aSb();
        }
        if (this.gxt != null) {
            this.gxt.aRI();
        }
        this.gOK = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.epk.setResult(-1, intent);
                    i.this.epk.finish();
                }
            }
        };
        this.epk = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.gLm = str3;
        this.hcV = new VideoConvertUtil(baseFragmentActivity);
        this.hcV.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.gOK);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hcS = videoFileInfo;
        this.gLv = str;
        if (this.hcS != null && this.epk != null) {
            if (this.hcS.videoDuration > 600000) {
                bxy();
            } else if (this.hcV == null || !this.hcV.isConvertRunning()) {
                String str2 = this.hcS.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    l.showToast(this.epk, d.k.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    uW(107);
                } else if (!new File(str2).exists()) {
                    l.showToast(this.epk, d.k.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    uW(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hcS != null) {
                        this.hcT = this.hcS.videoPath;
                        mT(false);
                        uW(102);
                    }
                } else if (VideoConvertUtil.tK(str2) >= 1500000) {
                    if (VideoConvertUtil.bvV()) {
                        this.hcT = new File(VideoConvertUtil.gJL, "tieba_" + VideoConvertUtil.tJ(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hcV.setConvertType(1);
                        this.hcV.ch(str2, this.hcT);
                        bxt();
                        this.gOC = false;
                        this.gOD = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hcS;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hcT = new File(VideoConvertUtil.gJL, "tieba_" + VideoConvertUtil.tJ(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hcV.setConvertType(2);
                            this.hcV.ch(str2, this.hcT);
                            bxt();
                            this.gOC = false;
                            this.gOD = false;
                            return;
                        }
                        this.hcT = videoFileInfo2.videoPath;
                        mT(false);
                        uW(102);
                    }
                }
            }
        }
    }

    private void bxy() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.epk).bY(d.k.mv_local_video_too_long).a(d.k.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.epk.getPageContext());
        a.as(false);
        a.tD();
    }

    private void bxt() {
        RelativeLayout relativeLayout = (RelativeLayout) this.epk.findViewById(d.g.parent);
        if (relativeLayout != null) {
            if (this.hcU == null) {
                this.hcU = new AlbumVideoCompressingDialogView(this.epk);
            }
            if (this.hcU.getParent() == null) {
                relativeLayout.addView(this.hcU);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hcU.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hcU.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hcU.setPercent(0);
        this.hcW = true;
    }

    private void mT(boolean z) {
        VideoFileInfo uJ = uJ(this.hcT);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hcT);
        videoInfo.setVideoDuration(uJ.videoDuration / 1000);
        videoInfo.setVideoWidth(uJ.videoWidth);
        videoInfo.setVideoHeight(uJ.videoHeight);
        videoInfo.setVideoLength(new File(uJ.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this.epk, this.gLv, this.mForumName, this.mForumId, this.gLm, videoInfo)));
        this.gOC = false;
        this.hcT = null;
        if (this.gxt != null) {
            this.gxt.aRL();
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
                if (this.hcU != null && this.hcU.isShowing()) {
                    this.hcU.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.gOD) {
                    l.showToast(this.epk, d.k.mv_local_video_compress_failed);
                    uW(103);
                }
                this.hcW = false;
                this.gOC = false;
                bxu();
                break;
            case 3:
                this.hcW = false;
                this.gOC = true;
                if (!StringUtils.isNull(this.hcT) && (file = new File(this.hcT)) != null) {
                    this.hcT = this.hcT.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hcT));
                }
                bxu();
                if (!this.gOB) {
                    mT(true);
                    if (this.gxt != null) {
                        this.gxt.aRL();
                        break;
                    }
                }
                break;
            case 4:
                this.hcW = false;
                this.gOC = false;
                bxu();
                uW(104);
                break;
            case 5:
                this.hcW = false;
                l.showToast(this.epk, d.k.mv_local_video_compress_failed);
                if (this.hcV != null && this.hcV.isConvertRunning()) {
                    bxv();
                }
                uW(105);
                break;
        }
        return true;
    }

    private void bxu() {
        RelativeLayout relativeLayout = (RelativeLayout) this.epk.findViewById(d.g.parent);
        if (relativeLayout != null && this.hcU.getParent() != null) {
            relativeLayout.removeView(this.hcU);
        }
    }

    private void bxv() {
        if (this.hcV != null) {
            this.hcV.abortConvert();
        }
        this.gOD = true;
        if (this.hcT != null) {
            File file = new File(this.hcT);
            if (file.exists()) {
                file.delete();
            }
        }
        bxu();
        this.hcT = null;
    }

    public void onStart() {
        this.gOB = false;
    }

    public void onStop() {
        this.gOB = true;
    }

    public void onResume() {
        if (this.gOC && !TextUtils.isEmpty(this.hcT) && new File(this.hcT).exists()) {
            mT(true);
            uW(101);
        }
        if (this.gxt != null) {
            this.gxt.pG("album");
        }
    }

    public void onDestroy() {
        if (this.hcV != null) {
            this.hcV.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.gxt != null) {
            this.gxt.pH("album");
        }
        MessageManager.getInstance().unRegisterListener(this.gOK);
    }

    private void uW(int i) {
        if (this.gxt != null) {
            this.gxt.ad(i, "album");
        }
    }

    public boolean bBY() {
        return this.hcW;
    }
}
