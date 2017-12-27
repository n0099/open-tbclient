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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.File;
/* loaded from: classes2.dex */
public class l implements Handler.Callback, com.baidu.tieba.video.c {
    private Handler Ga;
    private BaseFragmentActivity fuS;
    private boolean hBA = false;
    private boolean hBB = false;
    private boolean hBC = false;
    private final CustomMessageListener hBJ;
    private VideoFileInfo hOF;
    private String hOG;
    private com.baidu.tieba.write.video.a hOH;
    private com.baidu.tieba.video.f hOI;
    private boolean hOJ;
    private com.baidu.tieba.i.h hjJ;
    private String hyi;
    private String hyr;
    private String mForumId;
    private String mForumName;

    public l(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.hjJ = kVar.aVn();
        }
        if (this.hjJ != null) {
            this.hjJ.aUU();
        }
        this.hBJ = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    l.this.fuS.setResult(-1, intent);
                    l.this.fuS.finish();
                }
            }
        };
        this.fuS = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.hyi = str3;
        this.hOI = new com.baidu.tieba.video.f(baseFragmentActivity);
        this.hOI.a(this);
        this.Ga = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.hBJ);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hOF = videoFileInfo;
        this.hyr = str;
        if (this.hOF != null && this.fuS != null) {
            if (this.hOF.videoDuration > 600000) {
                bIh();
            } else if (this.hOI == null || !this.hOI.isConvertRunning()) {
                String str2 = this.hOF.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.fuS, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    yP(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.fuS, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    yP(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hOF != null) {
                        this.hOG = this.hOF.videoPath;
                        oa(false);
                        yP(102);
                    }
                } else if (com.baidu.tieba.video.f.tW(str2) >= 1500000) {
                    if (com.baidu.tieba.video.f.bGH()) {
                        this.hOG = new File(com.baidu.tieba.video.f.hwJ, "tieba_" + com.baidu.tieba.video.f.tV(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hOI.setConvertType(1);
                        this.hOI.cn(str2, this.hOG);
                        bIc();
                        this.hBB = false;
                        this.hBC = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hOF;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hOG = new File(com.baidu.tieba.video.f.hwJ, "tieba_" + com.baidu.tieba.video.f.tV(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hOI.setConvertType(2);
                            this.hOI.cn(str2, this.hOG);
                            bIc();
                            this.hBB = false;
                            this.hBC = false;
                            return;
                        }
                        this.hOG = videoFileInfo2.videoPath;
                        oa(false);
                        yP(102);
                    }
                }
            }
        }
    }

    private void bIh() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.fuS).fc(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.l.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.fuS.getPageContext());
        a.aW(false);
        a.AI();
    }

    private void bIc() {
        RelativeLayout relativeLayout = (RelativeLayout) this.fuS.findViewById(d.g.parent);
        if (relativeLayout != null) {
            if (this.hOH == null) {
                this.hOH = new com.baidu.tieba.write.video.a(this.fuS);
            }
            if (this.hOH.getParent() == null) {
                relativeLayout.addView(this.hOH);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hOH.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hOH.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hOH.setPercent(0);
        this.hOJ = true;
    }

    private void oa(boolean z) {
        VideoFileInfo uK = uK(this.hOG);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hOG);
        videoInfo.setVideoDuration(uK.videoDuration / 1000);
        videoInfo.setVideoWidth(uK.videoWidth);
        videoInfo.setVideoHeight(uK.videoHeight);
        videoInfo.setVideoLength(new File(uK.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this.fuS, this.hyr, this.mForumName, this.mForumId, this.hyi, videoInfo)));
        this.hBB = false;
        this.hOG = null;
        if (this.hjJ != null) {
            this.hjJ.aUX();
        }
    }

    public static VideoFileInfo uK(String str) {
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
                videoFileInfo.videoDuration = com.baidu.adp.lib.g.b.h(mediaMetadataRetriever.extractMetadata(9), 0);
                videoFileInfo.mimeType = mediaMetadataRetriever.extractMetadata(12);
                videoFileInfo.videoWidth = com.baidu.adp.lib.g.b.h(mediaMetadataRetriever.extractMetadata(18), 0);
                videoFileInfo.videoHeight = com.baidu.adp.lib.g.b.h(mediaMetadataRetriever.extractMetadata(19), 0);
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
    public void bGD() {
    }

    @Override // com.baidu.tieba.video.c
    public void yb(int i) {
        this.Ga.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertSuccess() {
        this.Ga.sendEmptyMessage(3);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertFailed() {
        this.Ga.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertProgress(int i) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        this.Ga.sendMessage(obtain);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertAborted() {
        this.Ga.sendEmptyMessage(4);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        File file;
        this.Ga.removeMessages(5);
        switch (message.what) {
            case 1:
                this.Ga.removeMessages(1);
                if (this.hOH != null && this.hOH.isShowing()) {
                    this.hOH.setPercent(message.arg1);
                }
                this.Ga.sendMessageDelayed(this.Ga.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.hBC) {
                    com.baidu.adp.lib.util.l.showToast(this.fuS, d.j.mv_local_video_compress_failed);
                    yP(103);
                }
                this.hOJ = false;
                this.hBB = false;
                bId();
                break;
            case 3:
                this.hOJ = false;
                this.hBB = true;
                if (!StringUtils.isNull(this.hOG) && (file = new File(this.hOG)) != null) {
                    this.hOG = this.hOG.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hOG));
                }
                bId();
                if (!this.hBA) {
                    oa(true);
                    if (this.hjJ != null) {
                        this.hjJ.aUX();
                        break;
                    }
                }
                break;
            case 4:
                this.hOJ = false;
                this.hBB = false;
                bId();
                yP(104);
                break;
            case 5:
                this.hOJ = false;
                com.baidu.adp.lib.util.l.showToast(this.fuS, d.j.mv_local_video_compress_failed);
                if (this.hOI != null && this.hOI.isConvertRunning()) {
                    bIe();
                }
                yP(105);
                break;
        }
        return true;
    }

    private void bId() {
        RelativeLayout relativeLayout = (RelativeLayout) this.fuS.findViewById(d.g.parent);
        if (relativeLayout != null && this.hOH.getParent() != null) {
            relativeLayout.removeView(this.hOH);
        }
    }

    private void bIe() {
        if (this.hOI != null) {
            this.hOI.abortConvert();
        }
        this.hBC = true;
        if (this.hOG != null) {
            File file = new File(this.hOG);
            if (file.exists()) {
                file.delete();
            }
        }
        bId();
        this.hOG = null;
    }

    public void onStart() {
        this.hBA = false;
    }

    public void onStop() {
        this.hBA = true;
    }

    public void onResume() {
        if (this.hBB && !TextUtils.isEmpty(this.hOG) && new File(this.hOG).exists()) {
            oa(true);
            yP(101);
        }
        if (this.hjJ != null) {
            this.hjJ.ph("album");
        }
    }

    public void onDestroy() {
        if (this.hOI != null) {
            this.hOI.destroy();
        }
        if (this.Ga != null) {
            this.Ga.removeMessages(5);
        }
        if (this.hjJ != null) {
            this.hjJ.pi("album");
        }
        MessageManager.getInstance().unRegisterListener(this.hBJ);
    }

    private void yP(int i) {
        if (this.hjJ != null) {
            this.hjJ.Q(i, "album");
        }
    }

    public boolean bMr() {
        return this.hOJ;
    }
}
