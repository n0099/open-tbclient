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
    private BaseFragmentActivity djs;
    private String fOb;
    private com.baidu.tieba.j.h iZT;
    private VideoFileInfo jHi;
    private String jHj;
    private AlbumVideoCompressingDialogView jHk;
    private VideoConvertUtil jHl;
    private boolean jHm;
    private String joU;
    private final CustomMessageListener jsn;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;
    private boolean jse = false;
    private boolean jsf = false;
    private boolean jsg = false;
    private int jHn = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.iZT = lVar.bMn();
        }
        if (this.iZT != null) {
            this.iZT.bLR();
        }
        this.jsn = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.djs.setResult(-1, intent);
                    i.this.djs.finish();
                }
            }
        };
        this.djs = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.joU = str3;
        this.jHl = new VideoConvertUtil(baseFragmentActivity);
        this.jHl.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.jsn);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.jHi = videoFileInfo;
        this.fOb = str;
        if (this.jHi != null && this.djs != null) {
            if (this.jHi.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                csy();
            } else if (this.jHl == null || !this.jHl.isConvertRunning()) {
                String str2 = this.jHi.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.djs, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    Cr(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.djs, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    Cr(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.jHi != null) {
                        this.jHj = this.jHi.videoPath;
                        rr(false);
                        Cr(102);
                    }
                } else if (VideoConvertUtil.EN(str2) >= 1500000) {
                    if (VideoConvertUtil.cqR()) {
                        this.jHj = new File(VideoConvertUtil.jnt, "tieba_" + VideoConvertUtil.EM(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.jHl.setConvertType(1);
                        this.jHl.eq(str2, this.jHj);
                        cst();
                        this.jsf = false;
                        this.jsg = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.jHi;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.jHj = new File(VideoConvertUtil.jnt, "tieba_" + VideoConvertUtil.EM(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.jHl.setConvertType(2);
                            this.jHl.eq(str2, this.jHj);
                            cst();
                            this.jsf = false;
                            this.jsg = false;
                            return;
                        }
                        this.jHj = videoFileInfo2.videoPath;
                        rr(false);
                        Cr(102);
                    }
                }
            }
        }
    }

    private void csy() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.djs).hn(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.djs.getPageContext());
        a.dN(false);
        a.afG();
    }

    private void cst() {
        RelativeLayout relativeLayout = (RelativeLayout) this.djs.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.jHk == null) {
                this.jHk = new AlbumVideoCompressingDialogView(this.djs);
            }
            if (this.jHk.getParent() == null) {
                relativeLayout.addView(this.jHk);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jHk.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.jHk.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.jHk.setPercent(0);
        this.jHm = true;
    }

    private void rr(boolean z) {
        VideoFileInfo FM = FM(this.jHj);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jHj);
        videoInfo.setVideoDuration(FM.videoDuration / 1000);
        videoInfo.setVideoWidth(FM.videoWidth);
        videoInfo.setVideoHeight(FM.videoHeight);
        videoInfo.setVideoLength(new File(FM.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.djs, this.fOb, this.mForumName, this.mForumId, this.joU, videoInfo);
        editVideoActivityConfig.setProZone(this.jHn);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        this.jsf = false;
        this.jHj = null;
        if (this.iZT != null) {
            this.iZT.bLU();
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
    public void cqN() {
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
                if (this.jHk != null && this.jHk.isShowing()) {
                    this.jHk.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.jsg) {
                    com.baidu.adp.lib.util.l.showToast(this.djs, (int) R.string.mv_local_video_compress_failed);
                    Cr(103);
                }
                this.jHm = false;
                this.jsf = false;
                csu();
                break;
            case 3:
                this.jHm = false;
                this.jsf = true;
                if (!StringUtils.isNull(this.jHj) && (file = new File(this.jHj)) != null) {
                    this.jHj = this.jHj.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.jHj));
                }
                csu();
                if (!this.jse) {
                    rr(true);
                    if (this.iZT != null) {
                        this.iZT.bLU();
                        break;
                    }
                }
                break;
            case 4:
                this.jHm = false;
                this.jsf = false;
                csu();
                Cr(104);
                break;
            case 5:
                this.jHm = false;
                com.baidu.adp.lib.util.l.showToast(this.djs, (int) R.string.mv_local_video_compress_failed);
                if (this.jHl != null && this.jHl.isConvertRunning()) {
                    csv();
                }
                Cr(105);
                break;
        }
        return true;
    }

    private void csu() {
        RelativeLayout relativeLayout = (RelativeLayout) this.djs.findViewById(R.id.parent);
        if (relativeLayout != null && this.jHk.getParent() != null) {
            relativeLayout.removeView(this.jHk);
        }
    }

    private void csv() {
        if (this.jHl != null) {
            this.jHl.abortConvert();
        }
        this.jsg = true;
        if (this.jHj != null) {
            File file = new File(this.jHj);
            if (file.exists()) {
                file.delete();
            }
        }
        csu();
        this.jHj = null;
    }

    public void onStart() {
        this.jse = false;
    }

    public void onStop() {
        this.jse = true;
    }

    public void onResume() {
        if (this.jsf && !TextUtils.isEmpty(this.jHj) && new File(this.jHj).exists()) {
            rr(true);
            Cr(101);
        }
        if (this.iZT != null) {
            this.iZT.Al("album");
        }
    }

    public void onDestroy() {
        if (this.jHl != null) {
            this.jHl.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.iZT != null) {
            this.iZT.Am("album");
        }
        MessageManager.getInstance().unRegisterListener(this.jsn);
    }

    private void Cr(int i) {
        if (this.iZT != null) {
            this.iZT.aw(i, "album");
        }
    }

    public boolean cxw() {
        return this.jHm;
    }

    public void setProfessionZone(int i) {
        this.jHn = i;
    }
}
