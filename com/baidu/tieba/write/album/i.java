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
import com.baidu.tieba.j.l;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import java.io.File;
/* loaded from: classes3.dex */
public class i implements Handler.Callback, com.baidu.tieba.video.d {
    private BaseFragmentActivity bsO;
    private String dHW;
    private com.baidu.tieba.j.h gOY;
    private String hdj;
    private boolean hgA = false;
    private boolean hgB = false;
    private boolean hgC = false;
    private final CustomMessageListener hgJ;
    private VideoFileInfo hvh;
    private String hvi;
    private AlbumVideoCompressingDialogView hvj;
    private VideoConvertUtil hvk;
    private boolean hvl;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.gOY = lVar.aWa();
        }
        if (this.gOY != null) {
            this.gOY.aVF();
        }
        this.hgJ = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.bsO.setResult(-1, intent);
                    i.this.bsO.finish();
                }
            }
        };
        this.bsO = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.hdj = str3;
        this.hvk = new VideoConvertUtil(baseFragmentActivity);
        this.hvk.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.hgJ);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hvh = videoFileInfo;
        this.dHW = str;
        if (this.hvh != null && this.bsO != null) {
            if (this.hvh.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                bBO();
            } else if (this.hvk == null || !this.hvk.isConvertRunning()) {
                String str2 = this.hvh.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.bsO, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    vv(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.bsO, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    vv(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hvh != null) {
                        this.hvi = this.hvh.videoPath;
                        mU(false);
                        vv(102);
                    }
                } else if (VideoConvertUtil.uB(str2) >= 1500000) {
                    if (VideoConvertUtil.bAh()) {
                        this.hvi = new File(VideoConvertUtil.hbI, "tieba_" + VideoConvertUtil.uA(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hvk.setConvertType(1);
                        this.hvk.cq(str2, this.hvi);
                        bBJ();
                        this.hgB = false;
                        this.hgC = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hvh;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hvi = new File(VideoConvertUtil.hbI, "tieba_" + VideoConvertUtil.uA(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hvk.setConvertType(2);
                            this.hvk.cq(str2, this.hvi);
                            bBJ();
                            this.hgB = false;
                            this.hgC = false;
                            return;
                        }
                        this.hvi = videoFileInfo2.videoPath;
                        mU(false);
                        vv(102);
                    }
                }
            }
        }
    }

    private void bBO() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.bsO).ce(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.bsO.getPageContext());
        a.av(false);
        a.xf();
    }

    private void bBJ() {
        RelativeLayout relativeLayout = (RelativeLayout) this.bsO.findViewById(d.g.parent);
        if (relativeLayout != null) {
            if (this.hvj == null) {
                this.hvj = new AlbumVideoCompressingDialogView(this.bsO);
            }
            if (this.hvj.getParent() == null) {
                relativeLayout.addView(this.hvj);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hvj.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hvj.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hvj.setPercent(0);
        this.hvl = true;
    }

    private void mU(boolean z) {
        VideoFileInfo vD = vD(this.hvi);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hvi);
        videoInfo.setVideoDuration(vD.videoDuration / 1000);
        videoInfo.setVideoWidth(vD.videoWidth);
        videoInfo.setVideoHeight(vD.videoHeight);
        videoInfo.setVideoLength(new File(vD.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this.bsO, this.dHW, this.mForumName, this.mForumId, this.hdj, videoInfo)));
        this.hgB = false;
        this.hvi = null;
        if (this.gOY != null) {
            this.gOY.aVI();
        }
    }

    public static VideoFileInfo vD(String str) {
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

    @Override // com.baidu.tieba.video.d
    public void bAd() {
    }

    @Override // com.baidu.tieba.video.d
    public void uy(int i) {
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
                if (this.hvj != null && this.hvj.isShowing()) {
                    this.hvj.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.hgC) {
                    com.baidu.adp.lib.util.l.showToast(this.bsO, d.j.mv_local_video_compress_failed);
                    vv(103);
                }
                this.hvl = false;
                this.hgB = false;
                bBK();
                break;
            case 3:
                this.hvl = false;
                this.hgB = true;
                if (!StringUtils.isNull(this.hvi) && (file = new File(this.hvi)) != null) {
                    this.hvi = this.hvi.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hvi));
                }
                bBK();
                if (!this.hgA) {
                    mU(true);
                    if (this.gOY != null) {
                        this.gOY.aVI();
                        break;
                    }
                }
                break;
            case 4:
                this.hvl = false;
                this.hgB = false;
                bBK();
                vv(104);
                break;
            case 5:
                this.hvl = false;
                com.baidu.adp.lib.util.l.showToast(this.bsO, d.j.mv_local_video_compress_failed);
                if (this.hvk != null && this.hvk.isConvertRunning()) {
                    bBL();
                }
                vv(105);
                break;
        }
        return true;
    }

    private void bBK() {
        RelativeLayout relativeLayout = (RelativeLayout) this.bsO.findViewById(d.g.parent);
        if (relativeLayout != null && this.hvj.getParent() != null) {
            relativeLayout.removeView(this.hvj);
        }
    }

    private void bBL() {
        if (this.hvk != null) {
            this.hvk.abortConvert();
        }
        this.hgC = true;
        if (this.hvi != null) {
            File file = new File(this.hvi);
            if (file.exists()) {
                file.delete();
            }
        }
        bBK();
        this.hvi = null;
    }

    public void onStart() {
        this.hgA = false;
    }

    public void onStop() {
        this.hgA = true;
    }

    public void onResume() {
        if (this.hgB && !TextUtils.isEmpty(this.hvi) && new File(this.hvi).exists()) {
            mU(true);
            vv(101);
        }
        if (this.gOY != null) {
            this.gOY.qq("album");
        }
    }

    public void onDestroy() {
        if (this.hvk != null) {
            this.hvk.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.gOY != null) {
            this.gOY.qr("album");
        }
        MessageManager.getInstance().unRegisterListener(this.hgJ);
    }

    private void vv(int i) {
        if (this.gOY != null) {
            this.gOY.ac(i, "album");
        }
    }

    public boolean bGo() {
        return this.hvl;
    }
}
