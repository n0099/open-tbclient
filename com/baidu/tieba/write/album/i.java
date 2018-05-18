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
    private BaseFragmentActivity biB;
    private String gMp;
    private String gMy;
    private boolean gPE = false;
    private boolean gPF = false;
    private boolean gPG = false;
    private final CustomMessageListener gPN;
    private com.baidu.tieba.j.h gyx;
    private VideoFileInfo hdW;
    private String hdX;
    private AlbumVideoCompressingDialogView hdY;
    private VideoConvertUtil hdZ;
    private boolean hea;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.gyx = kVar.aSb();
        }
        if (this.gyx != null) {
            this.gyx.aRI();
        }
        this.gPN = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.biB.setResult(-1, intent);
                    i.this.biB.finish();
                }
            }
        };
        this.biB = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.gMp = str3;
        this.hdZ = new VideoConvertUtil(baseFragmentActivity);
        this.hdZ.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.gPN);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hdW = videoFileInfo;
        this.gMy = str;
        if (this.hdW != null && this.biB != null) {
            if (this.hdW.videoDuration > 600000) {
                bxw();
            } else if (this.hdZ == null || !this.hdZ.isConvertRunning()) {
                String str2 = this.hdW.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    l.showToast(this.biB, d.k.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    uV(107);
                } else if (!new File(str2).exists()) {
                    l.showToast(this.biB, d.k.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    uV(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hdW != null) {
                        this.hdX = this.hdW.videoPath;
                        mU(false);
                        uV(102);
                    }
                } else if (VideoConvertUtil.tN(str2) >= 1500000) {
                    if (VideoConvertUtil.bvT()) {
                        this.hdX = new File(VideoConvertUtil.gKO, "tieba_" + VideoConvertUtil.tM(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hdZ.setConvertType(1);
                        this.hdZ.ch(str2, this.hdX);
                        bxr();
                        this.gPF = false;
                        this.gPG = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hdW;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hdX = new File(VideoConvertUtil.gKO, "tieba_" + VideoConvertUtil.tM(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hdZ.setConvertType(2);
                            this.hdZ.ch(str2, this.hdX);
                            bxr();
                            this.gPF = false;
                            this.gPG = false;
                            return;
                        }
                        this.hdX = videoFileInfo2.videoPath;
                        mU(false);
                        uV(102);
                    }
                }
            }
        }
    }

    private void bxw() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.biB).bZ(d.k.mv_local_video_too_long).a(d.k.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.biB.getPageContext());
        a.as(false);
        a.tC();
    }

    private void bxr() {
        RelativeLayout relativeLayout = (RelativeLayout) this.biB.findViewById(d.g.parent);
        if (relativeLayout != null) {
            if (this.hdY == null) {
                this.hdY = new AlbumVideoCompressingDialogView(this.biB);
            }
            if (this.hdY.getParent() == null) {
                relativeLayout.addView(this.hdY);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hdY.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hdY.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hdY.setPercent(0);
        this.hea = true;
    }

    private void mU(boolean z) {
        VideoFileInfo uM = uM(this.hdX);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hdX);
        videoInfo.setVideoDuration(uM.videoDuration / 1000);
        videoInfo.setVideoWidth(uM.videoWidth);
        videoInfo.setVideoHeight(uM.videoHeight);
        videoInfo.setVideoLength(new File(uM.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this.biB, this.gMy, this.mForumName, this.mForumId, this.gMp, videoInfo)));
        this.gPF = false;
        this.hdX = null;
        if (this.gyx != null) {
            this.gyx.aRL();
        }
    }

    public static VideoFileInfo uM(String str) {
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
    public void bvP() {
    }

    @Override // com.baidu.tieba.video.c
    public void ue(int i) {
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
                if (this.hdY != null && this.hdY.isShowing()) {
                    this.hdY.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.gPG) {
                    l.showToast(this.biB, d.k.mv_local_video_compress_failed);
                    uV(103);
                }
                this.hea = false;
                this.gPF = false;
                bxs();
                break;
            case 3:
                this.hea = false;
                this.gPF = true;
                if (!StringUtils.isNull(this.hdX) && (file = new File(this.hdX)) != null) {
                    this.hdX = this.hdX.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hdX));
                }
                bxs();
                if (!this.gPE) {
                    mU(true);
                    if (this.gyx != null) {
                        this.gyx.aRL();
                        break;
                    }
                }
                break;
            case 4:
                this.hea = false;
                this.gPF = false;
                bxs();
                uV(104);
                break;
            case 5:
                this.hea = false;
                l.showToast(this.biB, d.k.mv_local_video_compress_failed);
                if (this.hdZ != null && this.hdZ.isConvertRunning()) {
                    bxt();
                }
                uV(105);
                break;
        }
        return true;
    }

    private void bxs() {
        RelativeLayout relativeLayout = (RelativeLayout) this.biB.findViewById(d.g.parent);
        if (relativeLayout != null && this.hdY.getParent() != null) {
            relativeLayout.removeView(this.hdY);
        }
    }

    private void bxt() {
        if (this.hdZ != null) {
            this.hdZ.abortConvert();
        }
        this.gPG = true;
        if (this.hdX != null) {
            File file = new File(this.hdX);
            if (file.exists()) {
                file.delete();
            }
        }
        bxs();
        this.hdX = null;
    }

    public void onStart() {
        this.gPE = false;
    }

    public void onStop() {
        this.gPE = true;
    }

    public void onResume() {
        if (this.gPF && !TextUtils.isEmpty(this.hdX) && new File(this.hdX).exists()) {
            mU(true);
            uV(101);
        }
        if (this.gyx != null) {
            this.gyx.pJ("album");
        }
    }

    public void onDestroy() {
        if (this.hdZ != null) {
            this.hdZ.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.gyx != null) {
            this.gyx.pK("album");
        }
        MessageManager.getInstance().unRegisterListener(this.gPN);
    }

    private void uV(int i) {
        if (this.gyx != null) {
            this.gyx.ad(i, "album");
        }
    }

    public boolean bBW() {
        return this.hea;
    }
}
