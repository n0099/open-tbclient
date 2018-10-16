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
import com.baidu.searchbox.ng.ai.apps.media.chooser.action.ChooseVideoAction;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.e;
import com.baidu.tieba.j.l;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import java.io.File;
/* loaded from: classes3.dex */
public class i implements Handler.Callback, com.baidu.tieba.video.d {
    private BaseFragmentActivity bHp;
    private String dWS;
    private VideoFileInfo hKr;
    private String hKs;
    private AlbumVideoCompressingDialogView hKt;
    private VideoConvertUtil hKu;
    private boolean hKv;
    private com.baidu.tieba.j.h hea;
    private String hsr;
    private boolean hvG = false;
    private boolean hvH = false;
    private boolean hvI = false;
    private final CustomMessageListener hvP;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.hea = lVar.bbw();
        }
        if (this.hea != null) {
            this.hea.bbc();
        }
        this.hvP = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.bHp.setResult(-1, intent);
                    i.this.bHp.finish();
                }
            }
        };
        this.bHp = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.hsr = str3;
        this.hKu = new VideoConvertUtil(baseFragmentActivity);
        this.hKu.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.hvP);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hKr = videoFileInfo;
        this.dWS = str;
        if (this.hKr != null && this.bHp != null) {
            if (this.hKr.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                bHS();
            } else if (this.hKu == null || !this.hKu.isConvertRunning()) {
                String str2 = this.hKr.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.bHp, e.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    ws(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.bHp, e.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    ws(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hKr != null) {
                        this.hKs = this.hKr.videoPath;
                        nI(false);
                        ws(102);
                    }
                } else if (VideoConvertUtil.vQ(str2) >= 1500000) {
                    if (VideoConvertUtil.bGm()) {
                        this.hKs = new File(VideoConvertUtil.hqR, "tieba_" + VideoConvertUtil.vP(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hKu.setConvertType(1);
                        this.hKu.cL(str2, this.hKs);
                        bHN();
                        this.hvH = false;
                        this.hvI = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hKr;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hKs = new File(VideoConvertUtil.hqR, "tieba_" + VideoConvertUtil.vP(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hKu.setConvertType(2);
                            this.hKu.cL(str2, this.hKs);
                            bHN();
                            this.hvH = false;
                            this.hvI = false;
                            return;
                        }
                        this.hKs = videoFileInfo2.videoPath;
                        nI(false);
                        ws(102);
                    }
                }
            }
        }
    }

    private void bHS() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.bHp).cy(e.j.mv_local_video_too_long).a(e.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.bHp.getPageContext());
        a.aP(false);
        a.Au();
    }

    private void bHN() {
        RelativeLayout relativeLayout = (RelativeLayout) this.bHp.findViewById(e.g.parent);
        if (relativeLayout != null) {
            if (this.hKt == null) {
                this.hKt = new AlbumVideoCompressingDialogView(this.bHp);
            }
            if (this.hKt.getParent() == null) {
                relativeLayout.addView(this.hKt);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hKt.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hKt.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hKt.setPercent(0);
        this.hKv = true;
    }

    private void nI(boolean z) {
        VideoFileInfo wR = wR(this.hKs);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hKs);
        videoInfo.setVideoDuration(wR.videoDuration / 1000);
        videoInfo.setVideoWidth(wR.videoWidth);
        videoInfo.setVideoHeight(wR.videoHeight);
        videoInfo.setVideoLength(new File(wR.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this.bHp, this.dWS, this.mForumName, this.mForumId, this.hsr, videoInfo)));
        this.hvH = false;
        this.hKs = null;
        if (this.hea != null) {
            this.hea.bbf();
        }
    }

    public static VideoFileInfo wR(String str) {
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
                videoFileInfo.videoDuration = com.baidu.adp.lib.g.b.l(mediaMetadataRetriever.extractMetadata(9), 0);
                videoFileInfo.mimeType = mediaMetadataRetriever.extractMetadata(12);
                videoFileInfo.videoWidth = com.baidu.adp.lib.g.b.l(mediaMetadataRetriever.extractMetadata(18), 0);
                videoFileInfo.videoHeight = com.baidu.adp.lib.g.b.l(mediaMetadataRetriever.extractMetadata(19), 0);
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
    public void bGi() {
    }

    @Override // com.baidu.tieba.video.d
    public void vv(int i) {
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
                if (this.hKt != null && this.hKt.isShowing()) {
                    this.hKt.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.hvI) {
                    com.baidu.adp.lib.util.l.showToast(this.bHp, e.j.mv_local_video_compress_failed);
                    ws(103);
                }
                this.hKv = false;
                this.hvH = false;
                bHO();
                break;
            case 3:
                this.hKv = false;
                this.hvH = true;
                if (!StringUtils.isNull(this.hKs) && (file = new File(this.hKs)) != null) {
                    this.hKs = this.hKs.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hKs));
                }
                bHO();
                if (!this.hvG) {
                    nI(true);
                    if (this.hea != null) {
                        this.hea.bbf();
                        break;
                    }
                }
                break;
            case 4:
                this.hKv = false;
                this.hvH = false;
                bHO();
                ws(104);
                break;
            case 5:
                this.hKv = false;
                com.baidu.adp.lib.util.l.showToast(this.bHp, e.j.mv_local_video_compress_failed);
                if (this.hKu != null && this.hKu.isConvertRunning()) {
                    bHP();
                }
                ws(105);
                break;
        }
        return true;
    }

    private void bHO() {
        RelativeLayout relativeLayout = (RelativeLayout) this.bHp.findViewById(e.g.parent);
        if (relativeLayout != null && this.hKt.getParent() != null) {
            relativeLayout.removeView(this.hKt);
        }
    }

    private void bHP() {
        if (this.hKu != null) {
            this.hKu.abortConvert();
        }
        this.hvI = true;
        if (this.hKs != null) {
            File file = new File(this.hKs);
            if (file.exists()) {
                file.delete();
            }
        }
        bHO();
        this.hKs = null;
    }

    public void onStart() {
        this.hvG = false;
    }

    public void onStop() {
        this.hvG = true;
    }

    public void onResume() {
        if (this.hvH && !TextUtils.isEmpty(this.hKs) && new File(this.hKs).exists()) {
            nI(true);
            ws(101);
        }
        if (this.hea != null) {
            this.hea.rx(ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
    }

    public void onDestroy() {
        if (this.hKu != null) {
            this.hKu.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.hea != null) {
            this.hea.ry(ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
        MessageManager.getInstance().unRegisterListener(this.hvP);
    }

    private void ws(int i) {
        if (this.hea != null) {
            this.hea.ac(i, ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
    }

    public boolean bMu() {
        return this.hKv;
    }
}
