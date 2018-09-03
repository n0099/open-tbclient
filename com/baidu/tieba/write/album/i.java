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
import com.baidu.tieba.f;
import com.baidu.tieba.j.l;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import java.io.File;
/* loaded from: classes3.dex */
public class i implements Handler.Callback, com.baidu.tieba.video.d {
    private BaseFragmentActivity bsQ;
    private String dHS;
    private com.baidu.tieba.j.h gPa;
    private String hdk;
    private boolean hgB = false;
    private boolean hgC = false;
    private boolean hgD = false;
    private final CustomMessageListener hgK;
    private VideoFileInfo hvj;
    private String hvk;
    private AlbumVideoCompressingDialogView hvl;
    private VideoConvertUtil hvm;
    private boolean hvn;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.gPa = lVar.aVW();
        }
        if (this.gPa != null) {
            this.gPa.aVB();
        }
        this.hgK = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.bsQ.setResult(-1, intent);
                    i.this.bsQ.finish();
                }
            }
        };
        this.bsQ = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.hdk = str3;
        this.hvm = new VideoConvertUtil(baseFragmentActivity);
        this.hvm.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.hgK);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hvj = videoFileInfo;
        this.dHS = str;
        if (this.hvj != null && this.bsQ != null) {
            if (this.hvj.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                bBQ();
            } else if (this.hvm == null || !this.hvm.isConvertRunning()) {
                String str2 = this.hvj.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.bsQ, f.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    vv(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.bsQ, f.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    vv(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hvj != null) {
                        this.hvk = this.hvj.videoPath;
                        mU(false);
                        vv(102);
                    }
                } else if (VideoConvertUtil.uF(str2) >= 1500000) {
                    if (VideoConvertUtil.bAj()) {
                        this.hvk = new File(VideoConvertUtil.hbJ, "tieba_" + VideoConvertUtil.uE(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hvm.setConvertType(1);
                        this.hvm.cq(str2, this.hvk);
                        bBL();
                        this.hgC = false;
                        this.hgD = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hvj;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hvk = new File(VideoConvertUtil.hbJ, "tieba_" + VideoConvertUtil.uE(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hvm.setConvertType(2);
                            this.hvm.cq(str2, this.hvk);
                            bBL();
                            this.hgC = false;
                            this.hgD = false;
                            return;
                        }
                        this.hvk = videoFileInfo2.videoPath;
                        mU(false);
                        vv(102);
                    }
                }
            }
        }
    }

    private void bBQ() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.bsQ).ce(f.j.mv_local_video_too_long).a(f.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.bsQ.getPageContext());
        a.aw(false);
        a.xe();
    }

    private void bBL() {
        RelativeLayout relativeLayout = (RelativeLayout) this.bsQ.findViewById(f.g.parent);
        if (relativeLayout != null) {
            if (this.hvl == null) {
                this.hvl = new AlbumVideoCompressingDialogView(this.bsQ);
            }
            if (this.hvl.getParent() == null) {
                relativeLayout.addView(this.hvl);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hvl.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hvl.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hvl.setPercent(0);
        this.hvn = true;
    }

    private void mU(boolean z) {
        VideoFileInfo vH = vH(this.hvk);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hvk);
        videoInfo.setVideoDuration(vH.videoDuration / 1000);
        videoInfo.setVideoWidth(vH.videoWidth);
        videoInfo.setVideoHeight(vH.videoHeight);
        videoInfo.setVideoLength(new File(vH.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this.bsQ, this.dHS, this.mForumName, this.mForumId, this.hdk, videoInfo)));
        this.hgC = false;
        this.hvk = null;
        if (this.gPa != null) {
            this.gPa.aVE();
        }
    }

    public static VideoFileInfo vH(String str) {
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
    public void bAf() {
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
                if (this.hvl != null && this.hvl.isShowing()) {
                    this.hvl.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.hgD) {
                    com.baidu.adp.lib.util.l.showToast(this.bsQ, f.j.mv_local_video_compress_failed);
                    vv(103);
                }
                this.hvn = false;
                this.hgC = false;
                bBM();
                break;
            case 3:
                this.hvn = false;
                this.hgC = true;
                if (!StringUtils.isNull(this.hvk) && (file = new File(this.hvk)) != null) {
                    this.hvk = this.hvk.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hvk));
                }
                bBM();
                if (!this.hgB) {
                    mU(true);
                    if (this.gPa != null) {
                        this.gPa.aVE();
                        break;
                    }
                }
                break;
            case 4:
                this.hvn = false;
                this.hgC = false;
                bBM();
                vv(104);
                break;
            case 5:
                this.hvn = false;
                com.baidu.adp.lib.util.l.showToast(this.bsQ, f.j.mv_local_video_compress_failed);
                if (this.hvm != null && this.hvm.isConvertRunning()) {
                    bBN();
                }
                vv(105);
                break;
        }
        return true;
    }

    private void bBM() {
        RelativeLayout relativeLayout = (RelativeLayout) this.bsQ.findViewById(f.g.parent);
        if (relativeLayout != null && this.hvl.getParent() != null) {
            relativeLayout.removeView(this.hvl);
        }
    }

    private void bBN() {
        if (this.hvm != null) {
            this.hvm.abortConvert();
        }
        this.hgD = true;
        if (this.hvk != null) {
            File file = new File(this.hvk);
            if (file.exists()) {
                file.delete();
            }
        }
        bBM();
        this.hvk = null;
    }

    public void onStart() {
        this.hgB = false;
    }

    public void onStop() {
        this.hgB = true;
    }

    public void onResume() {
        if (this.hgC && !TextUtils.isEmpty(this.hvk) && new File(this.hvk).exists()) {
            mU(true);
            vv(101);
        }
        if (this.gPa != null) {
            this.gPa.qs("album");
        }
    }

    public void onDestroy() {
        if (this.hvm != null) {
            this.hvm.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.gPa != null) {
            this.gPa.qt("album");
        }
        MessageManager.getInstance().unRegisterListener(this.hgK);
    }

    private void vv(int i) {
        if (this.gPa != null) {
            this.gPa.ac(i, "album");
        }
    }

    public boolean bGs() {
        return this.hvn;
    }
}
