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
    private BaseFragmentActivity bMH;
    private String eih;
    private String hFG;
    private boolean hIV = false;
    private boolean hIW = false;
    private boolean hIX = false;
    private final CustomMessageListener hJe;
    private VideoFileInfo hXG;
    private String hXH;
    private AlbumVideoCompressingDialogView hXI;
    private VideoConvertUtil hXJ;
    private boolean hXK;
    private com.baidu.tieba.j.h hqM;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.hqM = lVar.bdZ();
        }
        if (this.hqM != null) {
            this.hqM.bdD();
        }
        this.hJe = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.bMH.setResult(-1, intent);
                    i.this.bMH.finish();
                }
            }
        };
        this.bMH = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.hFG = str3;
        this.hXJ = new VideoConvertUtil(baseFragmentActivity);
        this.hXJ.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.hJe);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hXG = videoFileInfo;
        this.eih = str;
        if (this.hXG != null && this.bMH != null) {
            if (this.hXG.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                bKU();
            } else if (this.hXJ == null || !this.hXJ.isConvertRunning()) {
                String str2 = this.hXG.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.bMH, e.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    xx(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.bMH, e.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    xx(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hXG != null) {
                        this.hXH = this.hXG.videoPath;
                        oc(false);
                        xx(102);
                    }
                } else if (VideoConvertUtil.wR(str2) >= 1500000) {
                    if (VideoConvertUtil.bJo()) {
                        this.hXH = new File(VideoConvertUtil.hEg, "tieba_" + VideoConvertUtil.wQ(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hXJ.setConvertType(1);
                        this.hXJ.cS(str2, this.hXH);
                        bKP();
                        this.hIW = false;
                        this.hIX = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hXG;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hXH = new File(VideoConvertUtil.hEg, "tieba_" + VideoConvertUtil.wQ(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hXJ.setConvertType(2);
                            this.hXJ.cS(str2, this.hXH);
                            bKP();
                            this.hIW = false;
                            this.hIX = false;
                            return;
                        }
                        this.hXH = videoFileInfo2.videoPath;
                        oc(false);
                        xx(102);
                    }
                }
            }
        }
    }

    private void bKU() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.bMH).da(e.j.mv_local_video_too_long).a(e.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.bMH.getPageContext());
        a.bh(false);
        a.BS();
    }

    private void bKP() {
        RelativeLayout relativeLayout = (RelativeLayout) this.bMH.findViewById(e.g.parent);
        if (relativeLayout != null) {
            if (this.hXI == null) {
                this.hXI = new AlbumVideoCompressingDialogView(this.bMH);
            }
            if (this.hXI.getParent() == null) {
                relativeLayout.addView(this.hXI);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hXI.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hXI.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hXI.setPercent(0);
        this.hXK = true;
    }

    private void oc(boolean z) {
        VideoFileInfo xS = xS(this.hXH);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hXH);
        videoInfo.setVideoDuration(xS.videoDuration / 1000);
        videoInfo.setVideoWidth(xS.videoWidth);
        videoInfo.setVideoHeight(xS.videoHeight);
        videoInfo.setVideoLength(new File(xS.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this.bMH, this.eih, this.mForumName, this.mForumId, this.hFG, videoInfo)));
        this.hIW = false;
        this.hXH = null;
        if (this.hqM != null) {
            this.hqM.bdG();
        }
    }

    public static VideoFileInfo xS(String str) {
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
    public void bJk() {
    }

    @Override // com.baidu.tieba.video.d
    public void wB(int i) {
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
                if (this.hXI != null && this.hXI.isShowing()) {
                    this.hXI.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.hIX) {
                    com.baidu.adp.lib.util.l.showToast(this.bMH, e.j.mv_local_video_compress_failed);
                    xx(103);
                }
                this.hXK = false;
                this.hIW = false;
                bKQ();
                break;
            case 3:
                this.hXK = false;
                this.hIW = true;
                if (!StringUtils.isNull(this.hXH) && (file = new File(this.hXH)) != null) {
                    this.hXH = this.hXH.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hXH));
                }
                bKQ();
                if (!this.hIV) {
                    oc(true);
                    if (this.hqM != null) {
                        this.hqM.bdG();
                        break;
                    }
                }
                break;
            case 4:
                this.hXK = false;
                this.hIW = false;
                bKQ();
                xx(104);
                break;
            case 5:
                this.hXK = false;
                com.baidu.adp.lib.util.l.showToast(this.bMH, e.j.mv_local_video_compress_failed);
                if (this.hXJ != null && this.hXJ.isConvertRunning()) {
                    bKR();
                }
                xx(105);
                break;
        }
        return true;
    }

    private void bKQ() {
        RelativeLayout relativeLayout = (RelativeLayout) this.bMH.findViewById(e.g.parent);
        if (relativeLayout != null && this.hXI.getParent() != null) {
            relativeLayout.removeView(this.hXI);
        }
    }

    private void bKR() {
        if (this.hXJ != null) {
            this.hXJ.abortConvert();
        }
        this.hIX = true;
        if (this.hXH != null) {
            File file = new File(this.hXH);
            if (file.exists()) {
                file.delete();
            }
        }
        bKQ();
        this.hXH = null;
    }

    public void onStart() {
        this.hIV = false;
    }

    public void onStop() {
        this.hIV = true;
    }

    public void onResume() {
        if (this.hIW && !TextUtils.isEmpty(this.hXH) && new File(this.hXH).exists()) {
            oc(true);
            xx(101);
        }
        if (this.hqM != null) {
            this.hqM.su(ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
    }

    public void onDestroy() {
        if (this.hXJ != null) {
            this.hXJ.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.hqM != null) {
            this.hqM.sv(ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
        MessageManager.getInstance().unRegisterListener(this.hJe);
    }

    private void xx(int i) {
        if (this.hqM != null) {
            this.hqM.ab(i, ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
    }

    public boolean bPx() {
        return this.hXK;
    }
}
