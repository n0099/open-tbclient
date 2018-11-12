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
    private BaseFragmentActivity bIb;
    private String dYg;
    private VideoFileInfo hMc;
    private String hMd;
    private AlbumVideoCompressingDialogView hMe;
    private VideoConvertUtil hMf;
    private boolean hMg;
    private com.baidu.tieba.j.h hfy;
    private String hub;
    private boolean hxq = false;
    private boolean hxr = false;
    private boolean hxs = false;
    private final CustomMessageListener hxz;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.hfy = lVar.baV();
        }
        if (this.hfy != null) {
            this.hfy.baz();
        }
        this.hxz = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    i.this.bIb.setResult(-1, intent);
                    i.this.bIb.finish();
                }
            }
        };
        this.bIb = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.hub = str3;
        this.hMf = new VideoConvertUtil(baseFragmentActivity);
        this.hMf.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.hxz);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hMc = videoFileInfo;
        this.dYg = str;
        if (this.hMc != null && this.bIb != null) {
            if (this.hMc.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                bHr();
            } else if (this.hMf == null || !this.hMf.isConvertRunning()) {
                String str2 = this.hMc.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.bIb, e.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    wL(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.bIb, e.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    wL(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hMc != null) {
                        this.hMd = this.hMc.videoPath;
                        nW(false);
                        wL(102);
                    }
                } else if (VideoConvertUtil.vV(str2) >= 1500000) {
                    if (VideoConvertUtil.bFL()) {
                        this.hMd = new File(VideoConvertUtil.hsB, "tieba_" + VideoConvertUtil.vU(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hMf.setConvertType(1);
                        this.hMf.cL(str2, this.hMd);
                        bHm();
                        this.hxr = false;
                        this.hxs = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hMc;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hMd = new File(VideoConvertUtil.hsB, "tieba_" + VideoConvertUtil.vU(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hMf.setConvertType(2);
                            this.hMf.cL(str2, this.hMd);
                            bHm();
                            this.hxr = false;
                            this.hxs = false;
                            return;
                        }
                        this.hMd = videoFileInfo2.videoPath;
                        nW(false);
                        wL(102);
                    }
                }
            }
        }
    }

    private void bHr() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.bIb).cM(e.j.mv_local_video_too_long).a(e.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.bIb.getPageContext());
        a.bf(false);
        a.AB();
    }

    private void bHm() {
        RelativeLayout relativeLayout = (RelativeLayout) this.bIb.findViewById(e.g.parent);
        if (relativeLayout != null) {
            if (this.hMe == null) {
                this.hMe = new AlbumVideoCompressingDialogView(this.bIb);
            }
            if (this.hMe.getParent() == null) {
                relativeLayout.addView(this.hMe);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hMe.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hMe.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hMe.setPercent(0);
        this.hMg = true;
    }

    private void nW(boolean z) {
        VideoFileInfo wW = wW(this.hMd);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hMd);
        videoInfo.setVideoDuration(wW.videoDuration / 1000);
        videoInfo.setVideoWidth(wW.videoWidth);
        videoInfo.setVideoHeight(wW.videoHeight);
        videoInfo.setVideoLength(new File(wW.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this.bIb, this.dYg, this.mForumName, this.mForumId, this.hub, videoInfo)));
        this.hxr = false;
        this.hMd = null;
        if (this.hfy != null) {
            this.hfy.baC();
        }
    }

    public static VideoFileInfo wW(String str) {
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
    public void bFH() {
    }

    @Override // com.baidu.tieba.video.d
    public void vO(int i) {
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
                if (this.hMe != null && this.hMe.isShowing()) {
                    this.hMe.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.hxs) {
                    com.baidu.adp.lib.util.l.showToast(this.bIb, e.j.mv_local_video_compress_failed);
                    wL(103);
                }
                this.hMg = false;
                this.hxr = false;
                bHn();
                break;
            case 3:
                this.hMg = false;
                this.hxr = true;
                if (!StringUtils.isNull(this.hMd) && (file = new File(this.hMd)) != null) {
                    this.hMd = this.hMd.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hMd));
                }
                bHn();
                if (!this.hxq) {
                    nW(true);
                    if (this.hfy != null) {
                        this.hfy.baC();
                        break;
                    }
                }
                break;
            case 4:
                this.hMg = false;
                this.hxr = false;
                bHn();
                wL(104);
                break;
            case 5:
                this.hMg = false;
                com.baidu.adp.lib.util.l.showToast(this.bIb, e.j.mv_local_video_compress_failed);
                if (this.hMf != null && this.hMf.isConvertRunning()) {
                    bHo();
                }
                wL(105);
                break;
        }
        return true;
    }

    private void bHn() {
        RelativeLayout relativeLayout = (RelativeLayout) this.bIb.findViewById(e.g.parent);
        if (relativeLayout != null && this.hMe.getParent() != null) {
            relativeLayout.removeView(this.hMe);
        }
    }

    private void bHo() {
        if (this.hMf != null) {
            this.hMf.abortConvert();
        }
        this.hxs = true;
        if (this.hMd != null) {
            File file = new File(this.hMd);
            if (file.exists()) {
                file.delete();
            }
        }
        bHn();
        this.hMd = null;
    }

    public void onStart() {
        this.hxq = false;
    }

    public void onStop() {
        this.hxq = true;
    }

    public void onResume() {
        if (this.hxr && !TextUtils.isEmpty(this.hMd) && new File(this.hMd).exists()) {
            nW(true);
            wL(101);
        }
        if (this.hfy != null) {
            this.hfy.ry(ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
    }

    public void onDestroy() {
        if (this.hMf != null) {
            this.hMf.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.hfy != null) {
            this.hfy.rz(ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
        MessageManager.getInstance().unRegisterListener(this.hxz);
    }

    private void wL(int i) {
        if (this.hfy != null) {
            this.hfy.Y(i, ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
    }

    public boolean bLT() {
        return this.hMg;
    }
}
