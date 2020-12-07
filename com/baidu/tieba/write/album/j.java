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
import com.baidu.tieba.l.l;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import java.io.File;
/* loaded from: classes3.dex */
public class j implements Handler.Callback, com.baidu.tieba.video.d {
    private BaseFragmentActivity ixc;
    private String jzq;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private String nCz;
    private final CustomMessageListener nFV;
    private FrsTabInfoData nVj;
    private VideoFileInfo nWc;
    private String nWd;
    private AlbumVideoCompressingDialogView nWe;
    private VideoConvertUtil nWf;
    private boolean nWg;
    private com.baidu.tieba.l.h nnb;
    private boolean nFM = false;
    private boolean nFN = false;
    private boolean nFO = false;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";
    private int nWh = -1;

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.nnb = lVar.djb();
        }
        if (this.nnb != null) {
            this.nnb.diK();
        }
        this.nFV = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    j.this.ixc.setResult(-1, intent);
                    j.this.ixc.finish();
                }
            }
        };
        this.ixc = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.nCz = str3;
        this.nWf = new VideoConvertUtil(baseFragmentActivity);
        this.nWf.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.nFV);
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.nVj = frsTabInfoData;
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.antiData = antiData;
        this.prefixData = postPrefixData;
        this.firstDir = str;
        this.secondDir = str2;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.nWc = videoFileInfo;
        this.jzq = str;
        this.mFrom = str2;
        if (this.nWc != null && this.ixc != null) {
            if (this.nWc.videoDuration > 600000) {
                dVm();
            } else if (this.nWf == null || !this.nWf.isConvertRunning()) {
                String str3 = this.nWc.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    com.baidu.adp.lib.util.l.showToast(this.ixc, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    MK(107);
                } else if (!new File(str3).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.ixc, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    MK(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.nWc != null) {
                        this.nWd = this.nWc.videoPath;
                        yJ(false);
                        MK(102);
                    }
                } else if (VideoConvertUtil.UF(str3) >= 1500000) {
                    if (VideoConvertUtil.dTK()) {
                        this.nWd = new File(VideoConvertUtil.nBc, "tieba_" + VideoConvertUtil.UE(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.nWf.setConvertType(1);
                        this.nWf.gA(str3, this.nWd);
                        dVh();
                        this.nFN = false;
                        this.nFO = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.nWc;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.nWd = new File(VideoConvertUtil.nBc, "tieba_" + VideoConvertUtil.UE(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.nWf.setConvertType(2);
                            this.nWf.gA(str3, this.nWd);
                            dVh();
                            this.nFN = false;
                            this.nFO = false;
                            return;
                        }
                        this.nWd = videoFileInfo2.videoPath;
                        yJ(false);
                        MK(102);
                    }
                }
            }
        }
    }

    private void dVm() {
        com.baidu.tbadk.core.dialog.a a2 = new com.baidu.tbadk.core.dialog.a(this.ixc).oP(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.j.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a2.b(this.ixc.getPageContext());
        a2.jm(false);
        a2.brv();
    }

    private void dVh() {
        RelativeLayout relativeLayout = (RelativeLayout) this.ixc.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.nWe == null) {
                this.nWe = new AlbumVideoCompressingDialogView(this.ixc);
            }
            if (this.nWe.getParent() == null) {
                relativeLayout.addView(this.nWe);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nWe.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.nWe.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.nWe.setPercent(0);
        this.nWg = true;
    }

    private void yJ(boolean z) {
        VideoFileInfo VG = VG(this.nWd);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nWd);
        videoInfo.setVideoDuration(VG.videoDuration / 1000);
        videoInfo.setVideoWidth(VG.videoWidth);
        videoInfo.setVideoHeight(VG.videoHeight);
        videoInfo.setVideoLength(new File(VG.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.ixc, this.jzq, this.mForumName, this.mForumId, this.nCz, videoInfo);
        editVideoActivityConfig.setProZone(this.nWh);
        editVideoActivityConfig.setFrsTabInfo(this.nVj);
        editVideoActivityConfig.setFrom(this.mFrom);
        editVideoActivityConfig.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.nFN = false;
        this.nWd = null;
        if (this.nnb != null) {
            this.nnb.diN();
        }
    }

    public static VideoFileInfo VG(String str) {
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
    public void dTF() {
    }

    @Override // com.baidu.tieba.video.d
    public void LT(int i) {
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
                if (this.nWe != null && this.nWe.isShowing()) {
                    this.nWe.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.nFO) {
                    com.baidu.adp.lib.util.l.showToast(this.ixc, R.string.mv_local_video_compress_failed);
                    MK(103);
                }
                this.nWg = false;
                this.nFN = false;
                dVi();
                break;
            case 3:
                this.nWg = false;
                this.nFN = true;
                if (!StringUtils.isNull(this.nWd) && (file = new File(this.nWd)) != null) {
                    this.nWd = this.nWd.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.nWd));
                }
                dVi();
                if (!this.nFM) {
                    yJ(true);
                    if (this.nnb != null) {
                        this.nnb.diN();
                        break;
                    }
                }
                break;
            case 4:
                this.nWg = false;
                this.nFN = false;
                dVi();
                MK(104);
                break;
            case 5:
                this.nWg = false;
                com.baidu.adp.lib.util.l.showToast(this.ixc, R.string.mv_local_video_compress_failed);
                if (this.nWf != null && this.nWf.isConvertRunning()) {
                    dVj();
                }
                MK(105);
                break;
        }
        return true;
    }

    private void dVi() {
        RelativeLayout relativeLayout = (RelativeLayout) this.ixc.findViewById(R.id.parent);
        if (relativeLayout != null && this.nWe.getParent() != null) {
            relativeLayout.removeView(this.nWe);
        }
    }

    private void dVj() {
        if (this.nWf != null) {
            this.nWf.abortConvert();
        }
        this.nFO = true;
        if (this.nWd != null) {
            File file = new File(this.nWd);
            if (file.exists()) {
                file.delete();
            }
        }
        dVi();
        this.nWd = null;
    }

    public void onStart() {
        this.nFM = false;
    }

    public void onStop() {
        this.nFM = true;
    }

    public void onResume() {
        if (this.nFN && !TextUtils.isEmpty(this.nWd) && new File(this.nWd).exists()) {
            yJ(true);
            MK(101);
        }
        if (this.nnb != null) {
            this.nnb.Po("album");
        }
    }

    public void onDestroy() {
        if (this.nWf != null) {
            this.nWf.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.nnb != null) {
            this.nnb.Pp("album");
        }
        MessageManager.getInstance().unRegisterListener(this.nFV);
    }

    private void MK(int i) {
        if (this.nnb != null) {
            this.nnb.bE(i, "album");
        }
    }

    public boolean dYY() {
        return this.nWg;
    }

    public void setProfessionZone(int i) {
        this.nWh = i;
    }
}
