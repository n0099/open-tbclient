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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.j.l;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import java.io.File;
/* loaded from: classes11.dex */
public class i implements Handler.Callback, com.baidu.tieba.video.d {
    private String gLX;
    private BaseFragmentActivity gpB;
    private VideoFileInfo kNe;
    private String kNf;
    private AlbumVideoCompressingDialogView kNg;
    private VideoConvertUtil kNh;
    private boolean kNi;
    private com.baidu.tieba.j.h kgK;
    private String kvn;
    private final CustomMessageListener kyB;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;
    private boolean kys = false;
    private boolean kyt = false;
    private boolean kyu = false;
    private int kNj = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.kgK = lVar.cfr();
        }
        if (this.kgK != null) {
            this.kgK.ceU();
        }
        this.kyB = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    i.this.gpB.setResult(-1, intent);
                    i.this.gpB.finish();
                }
            }
        };
        this.gpB = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.kvn = str3;
        this.kNh = new VideoConvertUtil(baseFragmentActivity);
        this.kNh.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.kyB);
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.kNe = videoFileInfo;
        this.gLX = str;
        if (this.kNe != null && this.gpB != null) {
            if (this.kNe.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                cPl();
            } else if (this.kNh == null || !this.kNh.isConvertRunning()) {
                String str2 = this.kNe.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.gpB, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    Eb(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.gpB, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    Eb(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.kNe != null) {
                        this.kNf = this.kNe.videoPath;
                        tl(false);
                        Eb(102);
                    }
                } else if (VideoConvertUtil.JF(str2) >= 1500000) {
                    if (VideoConvertUtil.cNJ()) {
                        this.kNf = new File(VideoConvertUtil.ktT, "tieba_" + VideoConvertUtil.JE(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.kNh.setConvertType(1);
                        this.kNh.ez(str2, this.kNf);
                        cPg();
                        this.kyt = false;
                        this.kyu = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.kNe;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.kNf = new File(VideoConvertUtil.ktT, "tieba_" + VideoConvertUtil.JE(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.kNh.setConvertType(2);
                            this.kNh.ez(str2, this.kNf);
                            cPg();
                            this.kyt = false;
                            this.kyu = false;
                            return;
                        }
                        this.kNf = videoFileInfo2.videoPath;
                        tl(false);
                        Eb(102);
                    }
                }
            }
        }
    }

    private void cPl() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.gpB).jE(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.gpB.getPageContext());
        a.fA(false);
        a.aCp();
    }

    private void cPg() {
        RelativeLayout relativeLayout = (RelativeLayout) this.gpB.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.kNg == null) {
                this.kNg = new AlbumVideoCompressingDialogView(this.gpB);
            }
            if (this.kNg.getParent() == null) {
                relativeLayout.addView(this.kNg);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kNg.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.kNg.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.kNg.setPercent(0);
        this.kNi = true;
    }

    private void tl(boolean z) {
        VideoFileInfo KC = KC(this.kNf);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kNf);
        videoInfo.setVideoDuration(KC.videoDuration / 1000);
        videoInfo.setVideoWidth(KC.videoWidth);
        videoInfo.setVideoHeight(KC.videoHeight);
        videoInfo.setVideoLength(new File(KC.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.gpB, this.gLX, this.mForumName, this.mForumId, this.kvn, videoInfo);
        editVideoActivityConfig.setProZone(this.kNj);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.kyt = false;
        this.kNf = null;
        if (this.kgK != null) {
            this.kgK.ceX();
        }
    }

    public static VideoFileInfo KC(String str) {
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
                videoFileInfo.videoDuration = com.baidu.adp.lib.f.b.toInt(mediaMetadataRetriever.extractMetadata(9), 0);
                videoFileInfo.mimeType = mediaMetadataRetriever.extractMetadata(12);
                videoFileInfo.videoWidth = com.baidu.adp.lib.f.b.toInt(mediaMetadataRetriever.extractMetadata(18), 0);
                videoFileInfo.videoHeight = com.baidu.adp.lib.f.b.toInt(mediaMetadataRetriever.extractMetadata(19), 0);
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
    public void cNF() {
    }

    @Override // com.baidu.tieba.video.d
    public void Dk(int i) {
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
                if (this.kNg != null && this.kNg.isShowing()) {
                    this.kNg.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.kyu) {
                    com.baidu.adp.lib.util.l.showToast(this.gpB, (int) R.string.mv_local_video_compress_failed);
                    Eb(103);
                }
                this.kNi = false;
                this.kyt = false;
                cPh();
                break;
            case 3:
                this.kNi = false;
                this.kyt = true;
                if (!StringUtils.isNull(this.kNf) && (file = new File(this.kNf)) != null) {
                    this.kNf = this.kNf.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.kNf));
                }
                cPh();
                if (!this.kys) {
                    tl(true);
                    if (this.kgK != null) {
                        this.kgK.ceX();
                        break;
                    }
                }
                break;
            case 4:
                this.kNi = false;
                this.kyt = false;
                cPh();
                Eb(104);
                break;
            case 5:
                this.kNi = false;
                com.baidu.adp.lib.util.l.showToast(this.gpB, (int) R.string.mv_local_video_compress_failed);
                if (this.kNh != null && this.kNh.isConvertRunning()) {
                    cPi();
                }
                Eb(105);
                break;
        }
        return true;
    }

    private void cPh() {
        RelativeLayout relativeLayout = (RelativeLayout) this.gpB.findViewById(R.id.parent);
        if (relativeLayout != null && this.kNg.getParent() != null) {
            relativeLayout.removeView(this.kNg);
        }
    }

    private void cPi() {
        if (this.kNh != null) {
            this.kNh.abortConvert();
        }
        this.kyu = true;
        if (this.kNf != null) {
            File file = new File(this.kNf);
            if (file.exists()) {
                file.delete();
            }
        }
        cPh();
        this.kNf = null;
    }

    public void onStart() {
        this.kys = false;
    }

    public void onStop() {
        this.kys = true;
    }

    public void onResume() {
        if (this.kyt && !TextUtils.isEmpty(this.kNf) && new File(this.kNf).exists()) {
            tl(true);
            Eb(101);
        }
        if (this.kgK != null) {
            this.kgK.EK("album");
        }
    }

    public void onDestroy() {
        if (this.kNh != null) {
            this.kNh.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.kgK != null) {
            this.kgK.EL("album");
        }
        MessageManager.getInstance().unRegisterListener(this.kyB);
    }

    private void Eb(int i) {
        if (this.kgK != null) {
            this.kgK.aQ(i, "album");
        }
    }

    public boolean cTu() {
        return this.kNi;
    }

    public void setProfessionZone(int i) {
        this.kNj = i;
    }
}
