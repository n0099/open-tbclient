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
    private String fOd;
    private com.baidu.tieba.j.h iZX;
    private VideoFileInfo jHl;
    private String jHm;
    private AlbumVideoCompressingDialogView jHn;
    private VideoConvertUtil jHo;
    private boolean jHp;
    private String joY;
    private final CustomMessageListener jsq;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;
    private boolean jsh = false;
    private boolean jsi = false;
    private boolean jsj = false;
    private int jHq = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.iZX = lVar.bMo();
        }
        if (this.iZX != null) {
            this.iZX.bLS();
        }
        this.jsq = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
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
        this.joY = str3;
        this.jHo = new VideoConvertUtil(baseFragmentActivity);
        this.jHo.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.jsq);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.jHl = videoFileInfo;
        this.fOd = str;
        if (this.jHl != null && this.djs != null) {
            if (this.jHl.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                csx();
            } else if (this.jHo == null || !this.jHo.isConvertRunning()) {
                String str2 = this.jHl.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.djs, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    Cr(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.djs, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    Cr(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.jHl != null) {
                        this.jHm = this.jHl.videoPath;
                        rs(false);
                        Cr(102);
                    }
                } else if (VideoConvertUtil.EP(str2) >= 1500000) {
                    if (VideoConvertUtil.cqS()) {
                        this.jHm = new File(VideoConvertUtil.jnx, "tieba_" + VideoConvertUtil.EO(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.jHo.setConvertType(1);
                        this.jHo.eq(str2, this.jHm);
                        css();
                        this.jsi = false;
                        this.jsj = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.jHl;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.jHm = new File(VideoConvertUtil.jnx, "tieba_" + VideoConvertUtil.EO(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.jHo.setConvertType(2);
                            this.jHo.eq(str2, this.jHm);
                            css();
                            this.jsi = false;
                            this.jsj = false;
                            return;
                        }
                        this.jHm = videoFileInfo2.videoPath;
                        rs(false);
                        Cr(102);
                    }
                }
            }
        }
    }

    private void csx() {
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

    private void css() {
        RelativeLayout relativeLayout = (RelativeLayout) this.djs.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.jHn == null) {
                this.jHn = new AlbumVideoCompressingDialogView(this.djs);
            }
            if (this.jHn.getParent() == null) {
                relativeLayout.addView(this.jHn);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jHn.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.jHn.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.jHn.setPercent(0);
        this.jHp = true;
    }

    private void rs(boolean z) {
        VideoFileInfo FO = FO(this.jHm);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jHm);
        videoInfo.setVideoDuration(FO.videoDuration / 1000);
        videoInfo.setVideoWidth(FO.videoWidth);
        videoInfo.setVideoHeight(FO.videoHeight);
        videoInfo.setVideoLength(new File(FO.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.djs, this.fOd, this.mForumName, this.mForumId, this.joY, videoInfo);
        editVideoActivityConfig.setProZone(this.jHq);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        this.jsi = false;
        this.jHm = null;
        if (this.iZX != null) {
            this.iZX.bLV();
        }
    }

    public static VideoFileInfo FO(String str) {
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
    public void cqO() {
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
                if (this.jHn != null && this.jHn.isShowing()) {
                    this.jHn.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.jsj) {
                    com.baidu.adp.lib.util.l.showToast(this.djs, (int) R.string.mv_local_video_compress_failed);
                    Cr(103);
                }
                this.jHp = false;
                this.jsi = false;
                cst();
                break;
            case 3:
                this.jHp = false;
                this.jsi = true;
                if (!StringUtils.isNull(this.jHm) && (file = new File(this.jHm)) != null) {
                    this.jHm = this.jHm.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.jHm));
                }
                cst();
                if (!this.jsh) {
                    rs(true);
                    if (this.iZX != null) {
                        this.iZX.bLV();
                        break;
                    }
                }
                break;
            case 4:
                this.jHp = false;
                this.jsi = false;
                cst();
                Cr(104);
                break;
            case 5:
                this.jHp = false;
                com.baidu.adp.lib.util.l.showToast(this.djs, (int) R.string.mv_local_video_compress_failed);
                if (this.jHo != null && this.jHo.isConvertRunning()) {
                    csu();
                }
                Cr(105);
                break;
        }
        return true;
    }

    private void cst() {
        RelativeLayout relativeLayout = (RelativeLayout) this.djs.findViewById(R.id.parent);
        if (relativeLayout != null && this.jHn.getParent() != null) {
            relativeLayout.removeView(this.jHn);
        }
    }

    private void csu() {
        if (this.jHo != null) {
            this.jHo.abortConvert();
        }
        this.jsj = true;
        if (this.jHm != null) {
            File file = new File(this.jHm);
            if (file.exists()) {
                file.delete();
            }
        }
        cst();
        this.jHm = null;
    }

    public void onStart() {
        this.jsh = false;
    }

    public void onStop() {
        this.jsh = true;
    }

    public void onResume() {
        if (this.jsi && !TextUtils.isEmpty(this.jHm) && new File(this.jHm).exists()) {
            rs(true);
            Cr(101);
        }
        if (this.iZX != null) {
            this.iZX.An("album");
        }
    }

    public void onDestroy() {
        if (this.jHo != null) {
            this.jHo.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.iZX != null) {
            this.iZX.Ao("album");
        }
        MessageManager.getInstance().unRegisterListener(this.jsq);
    }

    private void Cr(int i) {
        if (this.iZX != null) {
            this.iZX.aw(i, "album");
        }
    }

    public boolean cxv() {
        return this.jHp;
    }

    public void setProfessionZone(int i) {
        this.jHq = i;
    }
}
