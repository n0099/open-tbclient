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
    private Handler aZx;
    private BaseFragmentActivity eIs;
    private com.baidu.tieba.i.h gCP;
    private String gRb;
    private String gRk;
    private final CustomMessageListener gUA;
    private boolean gUr = false;
    private boolean gUs = false;
    private boolean gUt = false;
    private String hgA;
    private com.baidu.tieba.write.video.a hgB;
    private com.baidu.tieba.video.f hgC;
    private boolean hgD;
    private VideoFileInfo hgz;
    private String mForumId;
    private String mForumName;

    public l(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gCP = kVar.aOk();
        }
        if (this.gCP != null) {
            this.gCP.aNS();
        }
        this.gUA = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    l.this.eIs.setResult(-1, intent);
                    l.this.eIs.finish();
                }
            }
        };
        this.eIs = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.gRb = str3;
        this.hgC = new com.baidu.tieba.video.f(baseFragmentActivity);
        this.hgC.a(this);
        this.aZx = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.gUA);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hgz = videoFileInfo;
        this.gRk = str;
        if (this.hgz != null && this.eIs != null) {
            if (this.hgz.videoDuration > 600000) {
                bCK();
            } else if (this.hgC == null || !this.hgC.isConvertRunning()) {
                String str2 = this.hgz.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.eIs, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    vY(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.eIs, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    vY(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hgz != null) {
                        this.hgA = this.hgz.videoPath;
                        nG(false);
                        vY(102);
                    }
                } else if (com.baidu.tieba.video.f.tV(str2) >= 1500000) {
                    if (com.baidu.tieba.video.f.bBk()) {
                        this.hgA = new File(com.baidu.tieba.video.f.gPG, "tieba_" + com.baidu.tieba.video.f.tU(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hgC.setConvertType(1);
                        this.hgC.cm(str2, this.hgA);
                        bCF();
                        this.gUs = false;
                        this.gUt = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hgz;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hgA = new File(com.baidu.tieba.video.f.gPG, "tieba_" + com.baidu.tieba.video.f.tU(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hgC.setConvertType(2);
                            this.hgC.cm(str2, this.hgA);
                            bCF();
                            this.gUs = false;
                            this.gUt = false;
                            return;
                        }
                        this.hgA = videoFileInfo2.videoPath;
                        nG(false);
                        vY(102);
                    }
                }
            }
        }
    }

    private void bCK() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.eIs).cc(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.l.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.eIs.getPageContext());
        a.ap(false);
        a.th();
    }

    private void bCF() {
        RelativeLayout relativeLayout = (RelativeLayout) this.eIs.findViewById(d.g.parent);
        if (relativeLayout != null) {
            if (this.hgB == null) {
                this.hgB = new com.baidu.tieba.write.video.a(this.eIs);
            }
            if (this.hgB.getParent() == null) {
                relativeLayout.addView(this.hgB);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hgB.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hgB.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hgB.setPercent(0);
        this.hgD = true;
    }

    private void nG(boolean z) {
        VideoFileInfo uH = uH(this.hgA);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hgA);
        videoInfo.setVideoDuration(uH.videoDuration / 1000);
        videoInfo.setVideoWidth(uH.videoWidth);
        videoInfo.setVideoHeight(uH.videoHeight);
        videoInfo.setVideoLength(new File(uH.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this.eIs, this.gRk, this.mForumName, this.mForumId, this.gRb, videoInfo)));
        this.gUs = false;
        this.hgA = null;
        if (this.gCP != null) {
            this.gCP.aNV();
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
        this.aZx.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertSuccess() {
        this.aZx.sendEmptyMessage(3);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertFailed() {
        this.aZx.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertProgress(int i) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        this.aZx.sendMessage(obtain);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertAborted() {
        this.aZx.sendEmptyMessage(4);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        File file;
        this.aZx.removeMessages(5);
        switch (message.what) {
            case 1:
                this.aZx.removeMessages(1);
                if (this.hgB != null && this.hgB.isShowing()) {
                    this.hgB.setPercent(message.arg1);
                }
                this.aZx.sendMessageDelayed(this.aZx.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.gUt) {
                    com.baidu.adp.lib.util.l.showToast(this.eIs, d.j.mv_local_video_compress_failed);
                    vY(103);
                }
                this.hgD = false;
                this.gUs = false;
                bCG();
                break;
            case 3:
                this.hgD = false;
                this.gUs = true;
                if (!StringUtils.isNull(this.hgA) && (file = new File(this.hgA)) != null) {
                    this.hgA = this.hgA.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hgA));
                }
                bCG();
                if (!this.gUr) {
                    nG(true);
                    if (this.gCP != null) {
                        this.gCP.aNV();
                        break;
                    }
                }
                break;
            case 4:
                this.hgD = false;
                this.gUs = false;
                bCG();
                vY(104);
                break;
            case 5:
                this.hgD = false;
                com.baidu.adp.lib.util.l.showToast(this.eIs, d.j.mv_local_video_compress_failed);
                if (this.hgC != null && this.hgC.isConvertRunning()) {
                    bCH();
                }
                vY(105);
                break;
        }
        return true;
    }

    private void bCG() {
        RelativeLayout relativeLayout = (RelativeLayout) this.eIs.findViewById(d.g.parent);
        if (relativeLayout != null && this.hgB.getParent() != null) {
            relativeLayout.removeView(this.hgB);
        }
    }

    private void bCH() {
        if (this.hgC != null) {
            this.hgC.abortConvert();
        }
        this.gUt = true;
        if (this.hgA != null) {
            File file = new File(this.hgA);
            if (file.exists()) {
                file.delete();
            }
        }
        bCG();
        this.hgA = null;
    }

    public void onStart() {
        this.gUr = false;
    }

    public void onStop() {
        this.gUr = true;
    }

    public void onResume() {
        if (this.gUs && !TextUtils.isEmpty(this.hgA) && new File(this.hgA).exists()) {
            nG(true);
            vY(101);
        }
        if (this.gCP != null) {
            this.gCP.oX("album");
        }
    }

    public void onDestroy() {
        if (this.hgC != null) {
            this.hgC.destroy();
        }
        if (this.aZx != null) {
            this.aZx.removeMessages(5);
        }
        if (this.gCP != null) {
            this.gCP.oY("album");
        }
        MessageManager.getInstance().unRegisterListener(this.gUA);
    }

    private void vY(int i) {
        if (this.gCP != null) {
            this.gCP.R(i, "album");
        }
    }

    public boolean bGE() {
        return this.hgD;
    }
}
