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
    private Handler aZB;
    private BaseFragmentActivity eIw;
    private com.baidu.tieba.i.h gCU;
    private String gRg;
    private String gRp;
    private final CustomMessageListener gUF;
    private boolean gUw = false;
    private boolean gUx = false;
    private boolean gUy = false;
    private VideoFileInfo hgE;
    private String hgF;
    private com.baidu.tieba.write.video.a hgG;
    private com.baidu.tieba.video.f hgH;
    private boolean hgI;
    private String mForumId;
    private String mForumName;

    public l(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gCU = kVar.aOk();
        }
        if (this.gCU != null) {
            this.gCU.aNS();
        }
        this.gUF = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    l.this.eIw.setResult(-1, intent);
                    l.this.eIw.finish();
                }
            }
        };
        this.eIw = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.gRg = str3;
        this.hgH = new com.baidu.tieba.video.f(baseFragmentActivity);
        this.hgH.a(this);
        this.aZB = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.gUF);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hgE = videoFileInfo;
        this.gRp = str;
        if (this.hgE != null && this.eIw != null) {
            if (this.hgE.videoDuration > 600000) {
                bCK();
            } else if (this.hgH == null || !this.hgH.isConvertRunning()) {
                String str2 = this.hgE.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.eIw, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    vY(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.eIw, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    vY(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hgE != null) {
                        this.hgF = this.hgE.videoPath;
                        nG(false);
                        vY(102);
                    }
                } else if (com.baidu.tieba.video.f.tV(str2) >= 1500000) {
                    if (com.baidu.tieba.video.f.bBk()) {
                        this.hgF = new File(com.baidu.tieba.video.f.gPL, "tieba_" + com.baidu.tieba.video.f.tU(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hgH.setConvertType(1);
                        this.hgH.cm(str2, this.hgF);
                        bCF();
                        this.gUx = false;
                        this.gUy = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hgE;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hgF = new File(com.baidu.tieba.video.f.gPL, "tieba_" + com.baidu.tieba.video.f.tU(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hgH.setConvertType(2);
                            this.hgH.cm(str2, this.hgF);
                            bCF();
                            this.gUx = false;
                            this.gUy = false;
                            return;
                        }
                        this.hgF = videoFileInfo2.videoPath;
                        nG(false);
                        vY(102);
                    }
                }
            }
        }
    }

    private void bCK() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.eIw).cc(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.l.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.eIw.getPageContext());
        a.ap(false);
        a.th();
    }

    private void bCF() {
        RelativeLayout relativeLayout = (RelativeLayout) this.eIw.findViewById(d.g.parent);
        if (relativeLayout != null) {
            if (this.hgG == null) {
                this.hgG = new com.baidu.tieba.write.video.a(this.eIw);
            }
            if (this.hgG.getParent() == null) {
                relativeLayout.addView(this.hgG);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hgG.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hgG.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hgG.setPercent(0);
        this.hgI = true;
    }

    private void nG(boolean z) {
        VideoFileInfo uH = uH(this.hgF);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hgF);
        videoInfo.setVideoDuration(uH.videoDuration / 1000);
        videoInfo.setVideoWidth(uH.videoWidth);
        videoInfo.setVideoHeight(uH.videoHeight);
        videoInfo.setVideoLength(new File(uH.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this.eIw, this.gRp, this.mForumName, this.mForumId, this.gRg, videoInfo)));
        this.gUx = false;
        this.hgF = null;
        if (this.gCU != null) {
            this.gCU.aNV();
        }
    }

    public static VideoFileInfo uH(String str) {
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

    @Override // com.baidu.tieba.video.c
    public void bBi() {
    }

    @Override // com.baidu.tieba.video.c
    public void vn(int i) {
        this.aZB.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertSuccess() {
        this.aZB.sendEmptyMessage(3);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertFailed() {
        this.aZB.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertProgress(int i) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        this.aZB.sendMessage(obtain);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertAborted() {
        this.aZB.sendEmptyMessage(4);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        File file;
        this.aZB.removeMessages(5);
        switch (message.what) {
            case 1:
                this.aZB.removeMessages(1);
                if (this.hgG != null && this.hgG.isShowing()) {
                    this.hgG.setPercent(message.arg1);
                }
                this.aZB.sendMessageDelayed(this.aZB.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.gUy) {
                    com.baidu.adp.lib.util.l.showToast(this.eIw, d.j.mv_local_video_compress_failed);
                    vY(103);
                }
                this.hgI = false;
                this.gUx = false;
                bCG();
                break;
            case 3:
                this.hgI = false;
                this.gUx = true;
                if (!StringUtils.isNull(this.hgF) && (file = new File(this.hgF)) != null) {
                    this.hgF = this.hgF.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hgF));
                }
                bCG();
                if (!this.gUw) {
                    nG(true);
                    if (this.gCU != null) {
                        this.gCU.aNV();
                        break;
                    }
                }
                break;
            case 4:
                this.hgI = false;
                this.gUx = false;
                bCG();
                vY(104);
                break;
            case 5:
                this.hgI = false;
                com.baidu.adp.lib.util.l.showToast(this.eIw, d.j.mv_local_video_compress_failed);
                if (this.hgH != null && this.hgH.isConvertRunning()) {
                    bCH();
                }
                vY(105);
                break;
        }
        return true;
    }

    private void bCG() {
        RelativeLayout relativeLayout = (RelativeLayout) this.eIw.findViewById(d.g.parent);
        if (relativeLayout != null && this.hgG.getParent() != null) {
            relativeLayout.removeView(this.hgG);
        }
    }

    private void bCH() {
        if (this.hgH != null) {
            this.hgH.abortConvert();
        }
        this.gUy = true;
        if (this.hgF != null) {
            File file = new File(this.hgF);
            if (file.exists()) {
                file.delete();
            }
        }
        bCG();
        this.hgF = null;
    }

    public void onStart() {
        this.gUw = false;
    }

    public void onStop() {
        this.gUw = true;
    }

    public void onResume() {
        if (this.gUx && !TextUtils.isEmpty(this.hgF) && new File(this.hgF).exists()) {
            nG(true);
            vY(101);
        }
        if (this.gCU != null) {
            this.gCU.oX("album");
        }
    }

    public void onDestroy() {
        if (this.hgH != null) {
            this.hgH.destroy();
        }
        if (this.aZB != null) {
            this.aZB.removeMessages(5);
        }
        if (this.gCU != null) {
            this.gCU.oY("album");
        }
        MessageManager.getInstance().unRegisterListener(this.gUF);
    }

    private void vY(int i) {
        if (this.gCU != null) {
            this.gCU.R(i, "album");
        }
    }

    public boolean bGE() {
        return this.hgI;
    }
}
