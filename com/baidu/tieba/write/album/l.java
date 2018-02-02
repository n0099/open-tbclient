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
    private BaseFragmentActivity fwN;
    private com.baidu.tieba.i.h gZD;
    private VideoFileInfo hEH;
    private String hEI;
    private com.baidu.tieba.write.video.a hEJ;
    private com.baidu.tieba.video.f hEK;
    private boolean hEL;
    private String hof;
    private String hoo;
    private final CustomMessageListener hrG;
    private boolean hrx = false;
    private boolean hry = false;
    private boolean hrz = false;
    private String mForumId;
    private String mForumName;

    public l(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gZD = kVar.aVx();
        }
        if (this.gZD != null) {
            this.gZD.aVe();
        }
        this.hrG = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    l.this.fwN.setResult(-1, intent);
                    l.this.fwN.finish();
                }
            }
        };
        this.fwN = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.hof = str3;
        this.hEK = new com.baidu.tieba.video.f(baseFragmentActivity);
        this.hEK.a(this);
        this.Ga = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.hrG);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hEH = videoFileInfo;
        this.hoo = str;
        if (this.hEH != null && this.fwN != null) {
            if (this.hEH.videoDuration > 600000) {
                bBG();
            } else if (this.hEK == null || !this.hEK.isConvertRunning()) {
                String str2 = this.hEH.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.fwN, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    xs(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.fwN, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    xs(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hEH != null) {
                        this.hEI = this.hEH.videoPath;
                        nf(false);
                        xs(102);
                    }
                } else if (com.baidu.tieba.video.f.tz(str2) >= 1500000) {
                    if (com.baidu.tieba.video.f.bAg()) {
                        this.hEI = new File(com.baidu.tieba.video.f.hmG, "tieba_" + com.baidu.tieba.video.f.ty(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hEK.setConvertType(1);
                        this.hEK.cg(str2, this.hEI);
                        bBB();
                        this.hry = false;
                        this.hrz = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hEH;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hEI = new File(com.baidu.tieba.video.f.hmG, "tieba_" + com.baidu.tieba.video.f.ty(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hEK.setConvertType(2);
                            this.hEK.cg(str2, this.hEI);
                            bBB();
                            this.hry = false;
                            this.hrz = false;
                            return;
                        }
                        this.hEI = videoFileInfo2.videoPath;
                        nf(false);
                        xs(102);
                    }
                }
            }
        }
    }

    private void bBG() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.fwN).fa(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.l.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.fwN.getPageContext());
        a.aX(false);
        a.AB();
    }

    private void bBB() {
        RelativeLayout relativeLayout = (RelativeLayout) this.fwN.findViewById(d.g.parent);
        if (relativeLayout != null) {
            if (this.hEJ == null) {
                this.hEJ = new com.baidu.tieba.write.video.a(this.fwN);
            }
            if (this.hEJ.getParent() == null) {
                relativeLayout.addView(this.hEJ);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hEJ.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hEJ.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hEJ.setPercent(0);
        this.hEL = true;
    }

    private void nf(boolean z) {
        VideoFileInfo un = un(this.hEI);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hEI);
        videoInfo.setVideoDuration(un.videoDuration / 1000);
        videoInfo.setVideoWidth(un.videoWidth);
        videoInfo.setVideoHeight(un.videoHeight);
        videoInfo.setVideoLength(new File(un.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this.fwN, this.hoo, this.mForumName, this.mForumId, this.hof, videoInfo)));
        this.hry = false;
        this.hEI = null;
        if (this.gZD != null) {
            this.gZD.aVh();
        }
    }

    public static VideoFileInfo un(String str) {
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
    public void bAc() {
    }

    @Override // com.baidu.tieba.video.c
    public void wD(int i) {
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
                if (this.hEJ != null && this.hEJ.isShowing()) {
                    this.hEJ.setPercent(message.arg1);
                }
                this.Ga.sendMessageDelayed(this.Ga.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.hrz) {
                    com.baidu.adp.lib.util.l.showToast(this.fwN, d.j.mv_local_video_compress_failed);
                    xs(103);
                }
                this.hEL = false;
                this.hry = false;
                bBC();
                break;
            case 3:
                this.hEL = false;
                this.hry = true;
                if (!StringUtils.isNull(this.hEI) && (file = new File(this.hEI)) != null) {
                    this.hEI = this.hEI.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hEI));
                }
                bBC();
                if (!this.hrx) {
                    nf(true);
                    if (this.gZD != null) {
                        this.gZD.aVh();
                        break;
                    }
                }
                break;
            case 4:
                this.hEL = false;
                this.hry = false;
                bBC();
                xs(104);
                break;
            case 5:
                this.hEL = false;
                com.baidu.adp.lib.util.l.showToast(this.fwN, d.j.mv_local_video_compress_failed);
                if (this.hEK != null && this.hEK.isConvertRunning()) {
                    bBD();
                }
                xs(105);
                break;
        }
        return true;
    }

    private void bBC() {
        RelativeLayout relativeLayout = (RelativeLayout) this.fwN.findViewById(d.g.parent);
        if (relativeLayout != null && this.hEJ.getParent() != null) {
            relativeLayout.removeView(this.hEJ);
        }
    }

    private void bBD() {
        if (this.hEK != null) {
            this.hEK.abortConvert();
        }
        this.hrz = true;
        if (this.hEI != null) {
            File file = new File(this.hEI);
            if (file.exists()) {
                file.delete();
            }
        }
        bBC();
        this.hEI = null;
    }

    public void onStart() {
        this.hrx = false;
    }

    public void onStop() {
        this.hrx = true;
    }

    public void onResume() {
        if (this.hry && !TextUtils.isEmpty(this.hEI) && new File(this.hEI).exists()) {
            nf(true);
            xs(101);
        }
        if (this.gZD != null) {
            this.gZD.ps("album");
        }
    }

    public void onDestroy() {
        if (this.hEK != null) {
            this.hEK.destroy();
        }
        if (this.Ga != null) {
            this.Ga.removeMessages(5);
        }
        if (this.gZD != null) {
            this.gZD.pt("album");
        }
        MessageManager.getInstance().unRegisterListener(this.hrG);
    }

    private void xs(int i) {
        if (this.gZD != null) {
            this.gZD.U(i, "album");
        }
    }

    public boolean bFT() {
        return this.hEL;
    }
}
