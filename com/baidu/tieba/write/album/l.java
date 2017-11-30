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
import com.baidu.sapi2.SapiSafeFacade;
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
    private Handler aZv;
    private BaseFragmentActivity eHo;
    private com.baidu.tieba.i.h gAg;
    private String gOt;
    private boolean gRI = false;
    private boolean gRJ = false;
    private boolean gRK = false;
    private final CustomMessageListener gRR;
    private VideoFileInfo hdJ;
    private String hdK;
    private com.baidu.tieba.write.video.a hdL;
    private com.baidu.tieba.video.f hdM;
    private boolean hdN;
    private String mForumId;
    private String mForumName;

    public l(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gAg = kVar.aOb();
        }
        if (this.gAg != null) {
            this.gAg.aNJ();
        }
        this.gRR = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    l.this.eHo.setResult(-1, intent);
                    l.this.eHo.finish();
                }
            }
        };
        this.eHo = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.gOt = str3;
        this.hdM = new com.baidu.tieba.video.f(baseFragmentActivity);
        this.hdM.a(this);
        this.aZv = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.gRR);
    }

    public void d(VideoFileInfo videoFileInfo) {
        this.hdJ = videoFileInfo;
        if (this.hdJ != null && this.eHo != null) {
            if (this.hdJ.videoDuration > 600000) {
                bCe();
            } else if (this.hdM == null || !this.hdM.isConvertRunning()) {
                String str = this.hdJ.videoPath;
                if (TextUtils.isEmpty(str)) {
                    com.baidu.adp.lib.util.l.showToast(this.eHo, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str));
                    vM(SapiSafeFacade.SAPIWEBVIEW_LOGIN);
                } else if (!new File(str).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.eHo, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str));
                    vM(SapiSafeFacade.SAPIWEBVIEW_MODIFY_PWD);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hdJ != null) {
                        this.hdK = this.hdJ.videoPath;
                        nE(false);
                        vM(SapiSafeFacade.SAPIWEBVIEW_BACK);
                    }
                } else if (com.baidu.tieba.video.f.tQ(str) >= 1500000) {
                    if (com.baidu.tieba.video.f.bAD()) {
                        this.hdK = new File(com.baidu.tieba.video.f.gMY, "tieba_" + com.baidu.tieba.video.f.tP(str) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hdM.setConvertType(1);
                        this.hdM.cl(str, this.hdK);
                        bBZ();
                        this.gRJ = false;
                        this.gRK = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hdJ;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hdK = new File(com.baidu.tieba.video.f.gMY, "tieba_" + com.baidu.tieba.video.f.tP(str) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hdM.setConvertType(2);
                            this.hdM.cl(str, this.hdK);
                            bBZ();
                            this.gRJ = false;
                            this.gRK = false;
                            return;
                        }
                        this.hdK = videoFileInfo2.videoPath;
                        nE(false);
                        vM(SapiSafeFacade.SAPIWEBVIEW_BACK);
                    }
                }
            }
        }
    }

    private void bCe() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.eHo).cc(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.l.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.eHo.getPageContext());
        a.ap(false);
        a.tk();
    }

    private void bBZ() {
        RelativeLayout relativeLayout = (RelativeLayout) this.eHo.findViewById(d.g.parent);
        if (relativeLayout != null) {
            if (this.hdL == null) {
                this.hdL = new com.baidu.tieba.write.video.a(this.eHo);
            }
            if (this.hdL.getParent() == null) {
                relativeLayout.addView(this.hdL);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hdL.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hdL.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hdL.setPercent(0);
        this.hdN = true;
    }

    private void nE(boolean z) {
        VideoFileInfo uC = uC(this.hdK);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hdK);
        videoInfo.setVideoDuration(uC.videoDuration / 1000);
        videoInfo.setVideoWidth(uC.videoWidth);
        videoInfo.setVideoHeight(uC.videoHeight);
        videoInfo.setVideoLength(new File(uC.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this.eHo, this.mForumName, this.mForumId, this.gOt, videoInfo)));
        this.gRJ = false;
        this.hdK = null;
        if (this.gAg != null) {
            this.gAg.aNM();
        }
    }

    public static VideoFileInfo uC(String str) {
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
    public void bAB() {
    }

    @Override // com.baidu.tieba.video.c
    public void vc(int i) {
        this.aZv.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertSuccess() {
        this.aZv.sendEmptyMessage(3);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertFailed() {
        this.aZv.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertProgress(int i) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        this.aZv.sendMessage(obtain);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertAborted() {
        this.aZv.sendEmptyMessage(4);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        File file;
        this.aZv.removeMessages(5);
        switch (message.what) {
            case 1:
                this.aZv.removeMessages(1);
                if (this.hdL != null && this.hdL.isShowing()) {
                    this.hdL.setPercent(message.arg1);
                }
                this.aZv.sendMessageDelayed(this.aZv.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.gRK) {
                    com.baidu.adp.lib.util.l.showToast(this.eHo, d.j.mv_local_video_compress_failed);
                    vM(SapiSafeFacade.SAPIWEBVIEW_FINISH);
                }
                this.hdN = false;
                this.gRJ = false;
                bCa();
                break;
            case 3:
                this.hdN = false;
                this.gRJ = true;
                if (!StringUtils.isNull(this.hdK) && (file = new File(this.hdK)) != null) {
                    this.hdK = this.hdK.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hdK));
                }
                bCa();
                if (!this.gRI) {
                    nE(true);
                    if (this.gAg != null) {
                        this.gAg.aNM();
                        break;
                    }
                }
                break;
            case 4:
                this.hdN = false;
                this.gRJ = false;
                bCa();
                vM(SapiSafeFacade.SAPIWEBVIEW_AUTHORIZATION);
                break;
            case 5:
                this.hdN = false;
                com.baidu.adp.lib.util.l.showToast(this.eHo, d.j.mv_local_video_compress_failed);
                if (this.hdM != null && this.hdM.isConvertRunning()) {
                    bCb();
                }
                vM(105);
                break;
        }
        return true;
    }

    private void bCa() {
        RelativeLayout relativeLayout = (RelativeLayout) this.eHo.findViewById(d.g.parent);
        if (relativeLayout != null && this.hdL.getParent() != null) {
            relativeLayout.removeView(this.hdL);
        }
    }

    private void bCb() {
        if (this.hdM != null) {
            this.hdM.abortConvert();
        }
        this.gRK = true;
        if (this.hdK != null) {
            File file = new File(this.hdK);
            if (file.exists()) {
                file.delete();
            }
        }
        bCa();
        this.hdK = null;
    }

    public void onStart() {
        this.gRI = false;
    }

    public void onStop() {
        this.gRI = true;
    }

    public void onResume() {
        if (this.gRJ && !TextUtils.isEmpty(this.hdK) && new File(this.hdK).exists()) {
            nE(true);
            vM(101);
        }
        if (this.gAg != null) {
            this.gAg.oX("album");
        }
    }

    public void onDestroy() {
        if (this.hdM != null) {
            this.hdM.destroy();
        }
        if (this.aZv != null) {
            this.aZv.removeMessages(5);
        }
        if (this.gAg != null) {
            this.gAg.oY("album");
        }
        MessageManager.getInstance().unRegisterListener(this.gRR);
    }

    private void vM(int i) {
        if (this.gAg != null) {
            this.gAg.R(i, "album");
        }
    }

    public boolean bFS() {
        return this.hdN;
    }
}
