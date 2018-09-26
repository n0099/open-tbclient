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
import com.baidu.tieba.e;
import com.baidu.tieba.j.l;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import java.io.File;
/* loaded from: classes3.dex */
public class i implements Handler.Callback, com.baidu.tieba.video.d {
    private BaseFragmentActivity byH;
    private String dOX;
    private com.baidu.tieba.j.h gWF;
    private VideoFileInfo hDe;
    private String hDf;
    private AlbumVideoCompressingDialogView hDg;
    private VideoConvertUtil hDh;
    private boolean hDi;
    private String hlc;
    private final CustomMessageListener hoA;
    private boolean hor = false;
    private boolean hos = false;
    private boolean hot = false;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.gWF = lVar.aYk();
        }
        if (this.gWF != null) {
            this.gWF.aXP();
        }
        this.hoA = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.byH.setResult(-1, intent);
                    i.this.byH.finish();
                }
            }
        };
        this.byH = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.hlc = str3;
        this.hDh = new VideoConvertUtil(baseFragmentActivity);
        this.hDh.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.hoA);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hDe = videoFileInfo;
        this.dOX = str;
        if (this.hDe != null && this.byH != null) {
            if (this.hDe.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                bEF();
            } else if (this.hDh == null || !this.hDh.isConvertRunning()) {
                String str2 = this.hDe.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.byH, e.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    vV(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.byH, e.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    vV(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hDe != null) {
                        this.hDf = this.hDe.videoPath;
                        nr(false);
                        vV(102);
                    }
                } else if (VideoConvertUtil.vo(str2) >= 1500000) {
                    if (VideoConvertUtil.bCY()) {
                        this.hDf = new File(VideoConvertUtil.hjB, "tieba_" + VideoConvertUtil.vn(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hDh.setConvertType(1);
                        this.hDh.cA(str2, this.hDf);
                        bEA();
                        this.hos = false;
                        this.hot = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hDe;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hDf = new File(VideoConvertUtil.hjB, "tieba_" + VideoConvertUtil.vn(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hDh.setConvertType(2);
                            this.hDh.cA(str2, this.hDf);
                            bEA();
                            this.hos = false;
                            this.hot = false;
                            return;
                        }
                        this.hDf = videoFileInfo2.videoPath;
                        nr(false);
                        vV(102);
                    }
                }
            }
        }
    }

    private void bEF() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.byH).co(e.j.mv_local_video_too_long).a(e.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.byH.getPageContext());
        a.aF(false);
        a.yl();
    }

    private void bEA() {
        RelativeLayout relativeLayout = (RelativeLayout) this.byH.findViewById(e.g.parent);
        if (relativeLayout != null) {
            if (this.hDg == null) {
                this.hDg = new AlbumVideoCompressingDialogView(this.byH);
            }
            if (this.hDg.getParent() == null) {
                relativeLayout.addView(this.hDg);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hDg.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hDg.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hDg.setPercent(0);
        this.hDi = true;
    }

    private void nr(boolean z) {
        VideoFileInfo wq = wq(this.hDf);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hDf);
        videoInfo.setVideoDuration(wq.videoDuration / 1000);
        videoInfo.setVideoWidth(wq.videoWidth);
        videoInfo.setVideoHeight(wq.videoHeight);
        videoInfo.setVideoLength(new File(wq.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this.byH, this.dOX, this.mForumName, this.mForumId, this.hlc, videoInfo)));
        this.hos = false;
        this.hDf = null;
        if (this.gWF != null) {
            this.gWF.aXS();
        }
    }

    public static VideoFileInfo wq(String str) {
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
    public void bCU() {
    }

    @Override // com.baidu.tieba.video.d
    public void uY(int i) {
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
                if (this.hDg != null && this.hDg.isShowing()) {
                    this.hDg.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.hot) {
                    com.baidu.adp.lib.util.l.showToast(this.byH, e.j.mv_local_video_compress_failed);
                    vV(103);
                }
                this.hDi = false;
                this.hos = false;
                bEB();
                break;
            case 3:
                this.hDi = false;
                this.hos = true;
                if (!StringUtils.isNull(this.hDf) && (file = new File(this.hDf)) != null) {
                    this.hDf = this.hDf.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hDf));
                }
                bEB();
                if (!this.hor) {
                    nr(true);
                    if (this.gWF != null) {
                        this.gWF.aXS();
                        break;
                    }
                }
                break;
            case 4:
                this.hDi = false;
                this.hos = false;
                bEB();
                vV(104);
                break;
            case 5:
                this.hDi = false;
                com.baidu.adp.lib.util.l.showToast(this.byH, e.j.mv_local_video_compress_failed);
                if (this.hDh != null && this.hDh.isConvertRunning()) {
                    bEC();
                }
                vV(105);
                break;
        }
        return true;
    }

    private void bEB() {
        RelativeLayout relativeLayout = (RelativeLayout) this.byH.findViewById(e.g.parent);
        if (relativeLayout != null && this.hDg.getParent() != null) {
            relativeLayout.removeView(this.hDg);
        }
    }

    private void bEC() {
        if (this.hDh != null) {
            this.hDh.abortConvert();
        }
        this.hot = true;
        if (this.hDf != null) {
            File file = new File(this.hDf);
            if (file.exists()) {
                file.delete();
            }
        }
        bEB();
        this.hDf = null;
    }

    public void onStart() {
        this.hor = false;
    }

    public void onStop() {
        this.hor = true;
    }

    public void onResume() {
        if (this.hos && !TextUtils.isEmpty(this.hDf) && new File(this.hDf).exists()) {
            nr(true);
            vV(101);
        }
        if (this.gWF != null) {
            this.gWF.qX("album");
        }
    }

    public void onDestroy() {
        if (this.hDh != null) {
            this.hDh.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.gWF != null) {
            this.gWF.qY("album");
        }
        MessageManager.getInstance().unRegisterListener(this.hoA);
    }

    private void vV(int i) {
        if (this.gWF != null) {
            this.gWF.ac(i, "album");
        }
    }

    public boolean bJi() {
        return this.hDi;
    }
}
