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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.File;
/* loaded from: classes2.dex */
public class l implements Handler.Callback, com.baidu.tieba.video.c {
    private Handler FU;
    private BaseFragmentActivity fAr;
    private VideoFileInfo hGq;
    private String hGr;
    private com.baidu.tieba.write.video.a hGs;
    private com.baidu.tieba.video.f hGt;
    private boolean hGu;
    private com.baidu.tieba.i.h hca;
    private String hpF;
    private String hpO;
    private boolean hsY = false;
    private boolean hsZ = false;
    private boolean hta = false;
    private final CustomMessageListener hth;
    private String mForumId;
    private String mForumName;

    public l(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.hca = kVar.aXg();
        }
        if (this.hca != null) {
            this.hca.aWN();
        }
        this.hth = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.write.album.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(AlbumActivityConfig.FINISH_SELF, true);
                    l.this.fAr.setResult(-1, intent);
                    l.this.fAr.finish();
                }
            }
        };
        this.fAr = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.hpF = str3;
        this.hGt = new com.baidu.tieba.video.f(baseFragmentActivity);
        this.hGt.a(this);
        this.FU = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.hth);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.hGq = videoFileInfo;
        this.hpO = str;
        if (this.hGq != null && this.fAr != null) {
            if (this.hGq.videoDuration > 600000) {
                bCt();
            } else if (this.hGt == null || !this.hGt.isConvertRunning()) {
                String str2 = this.hGq.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.fAr, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    xs(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.fAr, d.j.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016328, str2));
                    xs(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.hGq != null) {
                        this.hGr = this.hGq.videoPath;
                        nr(false);
                        xs(102);
                    }
                } else if (com.baidu.tieba.video.f.tD(str2) >= 1500000) {
                    if (com.baidu.tieba.video.f.bAU()) {
                        this.hGr = new File(com.baidu.tieba.video.f.hog, "tieba_" + com.baidu.tieba.video.f.tC(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.hGt.setConvertType(1);
                        this.hGt.ci(str2, this.hGr);
                        bCo();
                        this.hsZ = false;
                        this.hta = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.hGq;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.hGr = new File(com.baidu.tieba.video.f.hog, "tieba_" + com.baidu.tieba.video.f.tC(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.hGt.setConvertType(2);
                            this.hGt.ci(str2, this.hGr);
                            bCo();
                            this.hsZ = false;
                            this.hta = false;
                            return;
                        }
                        this.hGr = videoFileInfo2.videoPath;
                        nr(false);
                        xs(102);
                    }
                }
            }
        }
    }

    private void bCt() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.fAr).fa(d.j.mv_local_video_too_long).a(d.j.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.l.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.fAr.getPageContext());
        a.ba(false);
        a.AV();
    }

    private void bCo() {
        RelativeLayout relativeLayout = (RelativeLayout) this.fAr.findViewById(d.g.parent);
        if (relativeLayout != null) {
            if (this.hGs == null) {
                this.hGs = new com.baidu.tieba.write.video.a(this.fAr);
            }
            if (this.hGs.getParent() == null) {
                relativeLayout.addView(this.hGs);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hGs.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.hGs.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.hGs.setPercent(0);
        this.hGu = true;
    }

    private void nr(boolean z) {
        VideoFileInfo ut = ut(this.hGr);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hGr);
        videoInfo.setVideoDuration(ut.videoDuration / 1000);
        videoInfo.setVideoWidth(ut.videoWidth);
        videoInfo.setVideoHeight(ut.videoHeight);
        videoInfo.setVideoLength(new File(ut.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditVideoActivityConfig(this.fAr, this.hpO, this.mForumName, this.mForumId, this.hpF, videoInfo)));
        this.hsZ = false;
        this.hGr = null;
        if (this.hca != null) {
            this.hca.aWQ();
        }
    }

    public static VideoFileInfo ut(String str) {
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
    public void bAQ() {
    }

    @Override // com.baidu.tieba.video.c
    public void wD(int i) {
        this.FU.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertSuccess() {
        this.FU.sendEmptyMessage(3);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertFailed() {
        this.FU.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertProgress(int i) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        this.FU.sendMessage(obtain);
    }

    @Override // com.baidu.tieba.video.c
    public void onConvertAborted() {
        this.FU.sendEmptyMessage(4);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        File file;
        this.FU.removeMessages(5);
        switch (message.what) {
            case 1:
                this.FU.removeMessages(1);
                if (this.hGs != null && this.hGs.isShowing()) {
                    this.hGs.setPercent(message.arg1);
                }
                this.FU.sendMessageDelayed(this.FU.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.hta) {
                    com.baidu.adp.lib.util.l.showToast(this.fAr, d.j.mv_local_video_compress_failed);
                    xs(103);
                }
                this.hGu = false;
                this.hsZ = false;
                bCp();
                break;
            case 3:
                this.hGu = false;
                this.hsZ = true;
                if (!StringUtils.isNull(this.hGr) && (file = new File(this.hGr)) != null) {
                    this.hGr = this.hGr.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.hGr));
                }
                bCp();
                if (!this.hsY) {
                    nr(true);
                    if (this.hca != null) {
                        this.hca.aWQ();
                        break;
                    }
                }
                break;
            case 4:
                this.hGu = false;
                this.hsZ = false;
                bCp();
                xs(104);
                break;
            case 5:
                this.hGu = false;
                com.baidu.adp.lib.util.l.showToast(this.fAr, d.j.mv_local_video_compress_failed);
                if (this.hGt != null && this.hGt.isConvertRunning()) {
                    bCq();
                }
                xs(105);
                break;
        }
        return true;
    }

    private void bCp() {
        RelativeLayout relativeLayout = (RelativeLayout) this.fAr.findViewById(d.g.parent);
        if (relativeLayout != null && this.hGs.getParent() != null) {
            relativeLayout.removeView(this.hGs);
        }
    }

    private void bCq() {
        if (this.hGt != null) {
            this.hGt.abortConvert();
        }
        this.hta = true;
        if (this.hGr != null) {
            File file = new File(this.hGr);
            if (file.exists()) {
                file.delete();
            }
        }
        bCp();
        this.hGr = null;
    }

    public void onStart() {
        this.hsY = false;
    }

    public void onStop() {
        this.hsY = true;
    }

    public void onResume() {
        if (this.hsZ && !TextUtils.isEmpty(this.hGr) && new File(this.hGr).exists()) {
            nr(true);
            xs(101);
        }
        if (this.hca != null) {
            this.hca.pA("album");
        }
    }

    public void onDestroy() {
        if (this.hGt != null) {
            this.hGt.destroy();
        }
        if (this.FU != null) {
            this.FU.removeMessages(5);
        }
        if (this.hca != null) {
            this.hca.pB("album");
        }
        MessageManager.getInstance().unRegisterListener(this.hth);
    }

    private void xs(int i) {
        if (this.hca != null) {
            this.hca.V(i, "album");
        }
    }

    public boolean bGL() {
        return this.hGu;
    }
}
