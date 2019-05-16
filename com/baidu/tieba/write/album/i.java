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
    private BaseFragmentActivity djr;
    private String fOa;
    private com.baidu.tieba.j.h iZR;
    private VideoFileInfo jHh;
    private String jHi;
    private AlbumVideoCompressingDialogView jHj;
    private VideoConvertUtil jHk;
    private boolean jHl;
    private String joT;
    private final CustomMessageListener jsm;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;
    private boolean jsd = false;
    private boolean jse = false;
    private boolean jsf = false;
    private int jHm = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.iZR = lVar.bMk();
        }
        if (this.iZR != null) {
            this.iZR.bLO();
        }
        this.jsm = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.djr.setResult(-1, intent);
                    i.this.djr.finish();
                }
            }
        };
        this.djr = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.joT = str3;
        this.jHk = new VideoConvertUtil(baseFragmentActivity);
        this.jHk.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.jsm);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.jHh = videoFileInfo;
        this.fOa = str;
        if (this.jHh != null && this.djr != null) {
            if (this.jHh.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                csw();
            } else if (this.jHk == null || !this.jHk.isConvertRunning()) {
                String str2 = this.jHh.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.djr, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    Cr(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.djr, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    Cr(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.jHh != null) {
                        this.jHi = this.jHh.videoPath;
                        rr(false);
                        Cr(102);
                    }
                } else if (VideoConvertUtil.EN(str2) >= 1500000) {
                    if (VideoConvertUtil.cqP()) {
                        this.jHi = new File(VideoConvertUtil.jns, "tieba_" + VideoConvertUtil.EM(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.jHk.setConvertType(1);
                        this.jHk.eq(str2, this.jHi);
                        csr();
                        this.jse = false;
                        this.jsf = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.jHh;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.jHi = new File(VideoConvertUtil.jns, "tieba_" + VideoConvertUtil.EM(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.jHk.setConvertType(2);
                            this.jHk.eq(str2, this.jHi);
                            csr();
                            this.jse = false;
                            this.jsf = false;
                            return;
                        }
                        this.jHi = videoFileInfo2.videoPath;
                        rr(false);
                        Cr(102);
                    }
                }
            }
        }
    }

    private void csw() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.djr).hn(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.djr.getPageContext());
        a.dN(false);
        a.afG();
    }

    private void csr() {
        RelativeLayout relativeLayout = (RelativeLayout) this.djr.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.jHj == null) {
                this.jHj = new AlbumVideoCompressingDialogView(this.djr);
            }
            if (this.jHj.getParent() == null) {
                relativeLayout.addView(this.jHj);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jHj.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.jHj.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.jHj.setPercent(0);
        this.jHl = true;
    }

    private void rr(boolean z) {
        VideoFileInfo FM = FM(this.jHi);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jHi);
        videoInfo.setVideoDuration(FM.videoDuration / 1000);
        videoInfo.setVideoWidth(FM.videoWidth);
        videoInfo.setVideoHeight(FM.videoHeight);
        videoInfo.setVideoLength(new File(FM.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.djr, this.fOa, this.mForumName, this.mForumId, this.joT, videoInfo);
        editVideoActivityConfig.setProZone(this.jHm);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        this.jse = false;
        this.jHi = null;
        if (this.iZR != null) {
            this.iZR.bLR();
        }
    }

    public static VideoFileInfo FM(String str) {
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
    public void cqL() {
    }

    @Override // com.baidu.tieba.video.d
    public void Br(int i) {
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
                if (this.jHj != null && this.jHj.isShowing()) {
                    this.jHj.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.jsf) {
                    com.baidu.adp.lib.util.l.showToast(this.djr, (int) R.string.mv_local_video_compress_failed);
                    Cr(103);
                }
                this.jHl = false;
                this.jse = false;
                css();
                break;
            case 3:
                this.jHl = false;
                this.jse = true;
                if (!StringUtils.isNull(this.jHi) && (file = new File(this.jHi)) != null) {
                    this.jHi = this.jHi.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.jHi));
                }
                css();
                if (!this.jsd) {
                    rr(true);
                    if (this.iZR != null) {
                        this.iZR.bLR();
                        break;
                    }
                }
                break;
            case 4:
                this.jHl = false;
                this.jse = false;
                css();
                Cr(104);
                break;
            case 5:
                this.jHl = false;
                com.baidu.adp.lib.util.l.showToast(this.djr, (int) R.string.mv_local_video_compress_failed);
                if (this.jHk != null && this.jHk.isConvertRunning()) {
                    cst();
                }
                Cr(105);
                break;
        }
        return true;
    }

    private void css() {
        RelativeLayout relativeLayout = (RelativeLayout) this.djr.findViewById(R.id.parent);
        if (relativeLayout != null && this.jHj.getParent() != null) {
            relativeLayout.removeView(this.jHj);
        }
    }

    private void cst() {
        if (this.jHk != null) {
            this.jHk.abortConvert();
        }
        this.jsf = true;
        if (this.jHi != null) {
            File file = new File(this.jHi);
            if (file.exists()) {
                file.delete();
            }
        }
        css();
        this.jHi = null;
    }

    public void onStart() {
        this.jsd = false;
    }

    public void onStop() {
        this.jsd = true;
    }

    public void onResume() {
        if (this.jse && !TextUtils.isEmpty(this.jHi) && new File(this.jHi).exists()) {
            rr(true);
            Cr(101);
        }
        if (this.iZR != null) {
            this.iZR.Al("album");
        }
    }

    public void onDestroy() {
        if (this.jHk != null) {
            this.jHk.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.iZR != null) {
            this.iZR.Am("album");
        }
        MessageManager.getInstance().unRegisterListener(this.jsm);
    }

    private void Cr(int i) {
        if (this.iZR != null) {
            this.iZR.aw(i, "album");
        }
    }

    public boolean cxu() {
        return this.jHl;
    }

    public void setProfessionZone(int i) {
        this.jHm = i;
    }
}
