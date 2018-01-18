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
    private BaseFragmentActivity fws;
    private com.baidu.tieba.i.h gZj;
    private VideoFileInfo hEn;
    private String hEo;
    private com.baidu.tieba.write.video.a hEp;
    private com.baidu.tieba.video.f hEq;
    private boolean hEr;
    private String hnL;
    private String hnU;
    private boolean hrd = false;
    private boolean hre = false;
    private boolean hrf = false;
    private final CustomMessageListener hrm;
    private String mForumId;
    private String mForumName;

    public l(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gZj = kVar.aVs();
        }
        if (this.gZj != null) {
            this.gZj.aUZ();
        }
        this.hrm = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    l.this.fws.setResult(-1, intent);
                    l.this.fws.finish();
                }
            }
        };
        this.fws = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.hnL = str3;
        this.hEq = new com.baidu.tieba.video.f(baseFragmentActivity);
        this.hEq.a(this);
        this.Ga = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.hrm);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hEn = videoFileInfo;
        this.hnU = str;
        if (this.hEn != null && this.fws != null) {
            if (this.hEn.videoDuration > 600000) {
                bBE();
            } else if (this.hEq == null || !this.hEq.isConvertRunning()) {
                String str2 = this.hEn.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.fws, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    xs(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.fws, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    xs(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hEn != null) {
                        this.hEo = this.hEn.videoPath;
                        nc(false);
                        xs(102);
                    }
                } else if (com.baidu.tieba.video.f.tr(str2) >= 1500000) {
                    if (com.baidu.tieba.video.f.bAe()) {
                        this.hEo = new File(com.baidu.tieba.video.f.hmm, "tieba_" + com.baidu.tieba.video.f.tq(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hEq.setConvertType(1);
                        this.hEq.ch(str2, this.hEo);
                        bBz();
                        this.hre = false;
                        this.hrf = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hEn;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hEo = new File(com.baidu.tieba.video.f.hmm, "tieba_" + com.baidu.tieba.video.f.tq(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hEq.setConvertType(2);
                            this.hEq.ch(str2, this.hEo);
                            bBz();
                            this.hre = false;
                            this.hrf = false;
                            return;
                        }
                        this.hEo = videoFileInfo2.videoPath;
                        nc(false);
                        xs(102);
                    }
                }
            }
        }
    }

    private void bBE() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.fws).fa(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.l.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.fws.getPageContext());
        a.aW(false);
        a.AA();
    }

    private void bBz() {
        RelativeLayout relativeLayout = (RelativeLayout) this.fws.findViewById(d.g.parent);
        if (relativeLayout != null) {
            if (this.hEp == null) {
                this.hEp = new com.baidu.tieba.write.video.a(this.fws);
            }
            if (this.hEp.getParent() == null) {
                relativeLayout.addView(this.hEp);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hEp.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hEp.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hEp.setPercent(0);
        this.hEr = true;
    }

    private void nc(boolean z) {
        VideoFileInfo uf = uf(this.hEo);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hEo);
        videoInfo.setVideoDuration(uf.videoDuration / 1000);
        videoInfo.setVideoWidth(uf.videoWidth);
        videoInfo.setVideoHeight(uf.videoHeight);
        videoInfo.setVideoLength(new File(uf.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this.fws, this.hnU, this.mForumName, this.mForumId, this.hnL, videoInfo)));
        this.hre = false;
        this.hEo = null;
        if (this.gZj != null) {
            this.gZj.aVc();
        }
    }

    public static VideoFileInfo uf(String str) {
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
    public void bAa() {
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
                if (this.hEp != null && this.hEp.isShowing()) {
                    this.hEp.setPercent(message.arg1);
                }
                this.Ga.sendMessageDelayed(this.Ga.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.hrf) {
                    com.baidu.adp.lib.util.l.showToast(this.fws, d.j.mv_local_video_compress_failed);
                    xs(103);
                }
                this.hEr = false;
                this.hre = false;
                bBA();
                break;
            case 3:
                this.hEr = false;
                this.hre = true;
                if (!StringUtils.isNull(this.hEo) && (file = new File(this.hEo)) != null) {
                    this.hEo = this.hEo.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hEo));
                }
                bBA();
                if (!this.hrd) {
                    nc(true);
                    if (this.gZj != null) {
                        this.gZj.aVc();
                        break;
                    }
                }
                break;
            case 4:
                this.hEr = false;
                this.hre = false;
                bBA();
                xs(104);
                break;
            case 5:
                this.hEr = false;
                com.baidu.adp.lib.util.l.showToast(this.fws, d.j.mv_local_video_compress_failed);
                if (this.hEq != null && this.hEq.isConvertRunning()) {
                    bBB();
                }
                xs(105);
                break;
        }
        return true;
    }

    private void bBA() {
        RelativeLayout relativeLayout = (RelativeLayout) this.fws.findViewById(d.g.parent);
        if (relativeLayout != null && this.hEp.getParent() != null) {
            relativeLayout.removeView(this.hEp);
        }
    }

    private void bBB() {
        if (this.hEq != null) {
            this.hEq.abortConvert();
        }
        this.hrf = true;
        if (this.hEo != null) {
            File file = new File(this.hEo);
            if (file.exists()) {
                file.delete();
            }
        }
        bBA();
        this.hEo = null;
    }

    public void onStart() {
        this.hrd = false;
    }

    public void onStop() {
        this.hrd = true;
    }

    public void onResume() {
        if (this.hre && !TextUtils.isEmpty(this.hEo) && new File(this.hEo).exists()) {
            nc(true);
            xs(101);
        }
        if (this.gZj != null) {
            this.gZj.pk("album");
        }
    }

    public void onDestroy() {
        if (this.hEq != null) {
            this.hEq.destroy();
        }
        if (this.Ga != null) {
            this.Ga.removeMessages(5);
        }
        if (this.gZj != null) {
            this.gZj.pl("album");
        }
        MessageManager.getInstance().unRegisterListener(this.hrm);
    }

    private void xs(int i) {
        if (this.gZj != null) {
            this.gZj.S(i, "album");
        }
    }

    public boolean bFR() {
        return this.hEr;
    }
}
