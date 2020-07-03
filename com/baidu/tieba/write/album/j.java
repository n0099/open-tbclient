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
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.k.l;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import java.io.File;
/* loaded from: classes2.dex */
public class j implements Handler.Callback, com.baidu.tieba.video.e {
    private BaseFragmentActivity hep;
    private String ici;
    private com.baidu.tieba.k.h lHf;
    private String lVW;
    private final CustomMessageListener lZv;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private VideoFileInfo mnV;
    private String mnW;
    private AlbumVideoCompressingDialogView mnX;
    private VideoConvertUtil mnY;
    private boolean mnZ;
    private FrsTabInfoData mnb;
    private boolean lZm = false;
    private boolean lZn = false;
    private boolean lZo = false;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";
    private int moa = -1;

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.lHf = lVar.cCP();
        }
        if (this.lHf != null) {
            this.lHf.cCr();
        }
        this.lZv = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    j.this.hep.setResult(-1, intent);
                    j.this.hep.finish();
                }
            }
        };
        this.hep = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.lVW = str3;
        this.mnY = new VideoConvertUtil(baseFragmentActivity);
        this.mnY.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.lZv);
    }

    public void a(FrsTabInfoData frsTabInfoData) {
        this.mnb = frsTabInfoData;
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.antiData = antiData;
        this.prefixData = postPrefixData;
        this.firstDir = str;
        this.secondDir = str2;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.mnV = videoFileInfo;
        this.ici = str;
        this.mFrom = str2;
        if (this.mnV != null && this.hep != null) {
            if (this.mnV.videoDuration > 600000) {
                dnL();
            } else if (this.mnY == null || !this.mnY.isConvertRunning()) {
                String str3 = this.mnV.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    com.baidu.adp.lib.util.l.showToast(this.hep, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    GI(107);
                } else if (!new File(str3).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.hep, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    GI(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.mnV != null) {
                        this.mnW = this.mnV.videoPath;
                        vm(false);
                        GI(102);
                    }
                } else if (VideoConvertUtil.NU(str3) >= 1500000) {
                    if (VideoConvertUtil.dmj()) {
                        this.mnW = new File(VideoConvertUtil.lUz, "tieba_" + VideoConvertUtil.NT(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.mnY.setConvertType(1);
                        this.mnY.fD(str3, this.mnW);
                        dnG();
                        this.lZn = false;
                        this.lZo = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.mnV;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.mnW = new File(VideoConvertUtil.lUz, "tieba_" + VideoConvertUtil.NT(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.mnY.setConvertType(2);
                            this.mnY.fD(str3, this.mnW);
                            dnG();
                            this.lZn = false;
                            this.lZo = false;
                            return;
                        }
                        this.mnW = videoFileInfo2.videoPath;
                        vm(false);
                        GI(102);
                    }
                }
            }
        }
    }

    private void dnL() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hep).kS(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.j.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hep.getPageContext());
        a.hg(false);
        a.aUN();
    }

    private void dnG() {
        RelativeLayout relativeLayout = (RelativeLayout) this.hep.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.mnX == null) {
                this.mnX = new AlbumVideoCompressingDialogView(this.hep);
            }
            if (this.mnX.getParent() == null) {
                relativeLayout.addView(this.mnX);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mnX.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.mnX.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.mnX.setPercent(0);
        this.mnZ = true;
    }

    private void vm(boolean z) {
        VideoFileInfo OS = OS(this.mnW);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.mnW);
        videoInfo.setVideoDuration(OS.videoDuration / 1000);
        videoInfo.setVideoWidth(OS.videoWidth);
        videoInfo.setVideoHeight(OS.videoHeight);
        videoInfo.setVideoLength(new File(OS.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.hep, this.ici, this.mForumName, this.mForumId, this.lVW, videoInfo);
        editVideoActivityConfig.setProZone(this.moa);
        editVideoActivityConfig.setFrsTabInfo(this.mnb);
        editVideoActivityConfig.setFrom(this.mFrom);
        editVideoActivityConfig.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.lZn = false;
        this.mnW = null;
        if (this.lHf != null) {
            this.lHf.cCu();
        }
    }

    public static VideoFileInfo OS(String str) {
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

    @Override // com.baidu.tieba.video.e
    public void dmf() {
    }

    @Override // com.baidu.tieba.video.e
    public void FR(int i) {
        this.mMainThreadHandler.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.e
    public void onConvertSuccess() {
        this.mMainThreadHandler.sendEmptyMessage(3);
    }

    @Override // com.baidu.tieba.video.e
    public void onConvertFailed() {
        this.mMainThreadHandler.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.e
    public void onConvertProgress(int i) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        this.mMainThreadHandler.sendMessage(obtain);
    }

    @Override // com.baidu.tieba.video.e
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
                if (this.mnX != null && this.mnX.isShowing()) {
                    this.mnX.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.lZo) {
                    com.baidu.adp.lib.util.l.showToast(this.hep, (int) R.string.mv_local_video_compress_failed);
                    GI(103);
                }
                this.mnZ = false;
                this.lZn = false;
                dnH();
                break;
            case 3:
                this.mnZ = false;
                this.lZn = true;
                if (!StringUtils.isNull(this.mnW) && (file = new File(this.mnW)) != null) {
                    this.mnW = this.mnW.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.mnW));
                }
                dnH();
                if (!this.lZm) {
                    vm(true);
                    if (this.lHf != null) {
                        this.lHf.cCu();
                        break;
                    }
                }
                break;
            case 4:
                this.mnZ = false;
                this.lZn = false;
                dnH();
                GI(104);
                break;
            case 5:
                this.mnZ = false;
                com.baidu.adp.lib.util.l.showToast(this.hep, (int) R.string.mv_local_video_compress_failed);
                if (this.mnY != null && this.mnY.isConvertRunning()) {
                    dnI();
                }
                GI(105);
                break;
        }
        return true;
    }

    private void dnH() {
        RelativeLayout relativeLayout = (RelativeLayout) this.hep.findViewById(R.id.parent);
        if (relativeLayout != null && this.mnX.getParent() != null) {
            relativeLayout.removeView(this.mnX);
        }
    }

    private void dnI() {
        if (this.mnY != null) {
            this.mnY.abortConvert();
        }
        this.lZo = true;
        if (this.mnW != null) {
            File file = new File(this.mnW);
            if (file.exists()) {
                file.delete();
            }
        }
        dnH();
        this.mnW = null;
    }

    public void onStart() {
        this.lZm = false;
    }

    public void onStop() {
        this.lZm = true;
    }

    public void onResume() {
        if (this.lZn && !TextUtils.isEmpty(this.mnW) && new File(this.mnW).exists()) {
            vm(true);
            GI(101);
        }
        if (this.lHf != null) {
            this.lHf.IX("album");
        }
    }

    public void onDestroy() {
        if (this.mnY != null) {
            this.mnY.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.lHf != null) {
            this.lHf.IY("album");
        }
        MessageManager.getInstance().unRegisterListener(this.lZv);
    }

    private void GI(int i) {
        if (this.lHf != null) {
            this.lHf.bo(i, "album");
        }
    }

    public boolean drv() {
        return this.mnZ;
    }

    public void setProfessionZone(int i) {
        this.moa = i;
    }
}
