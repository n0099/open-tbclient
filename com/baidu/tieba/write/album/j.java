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
    private BaseFragmentActivity ixe;
    private String jzs;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private String nCB;
    private final CustomMessageListener nFX;
    private FrsTabInfoData nVl;
    private VideoFileInfo nWe;
    private String nWf;
    private AlbumVideoCompressingDialogView nWg;
    private VideoConvertUtil nWh;
    private boolean nWi;
    private com.baidu.tieba.l.h nnd;
    private boolean nFO = false;
    private boolean nFP = false;
    private boolean nFQ = false;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";
    private int nWj = -1;

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.nnd = lVar.djc();
        }
        if (this.nnd != null) {
            this.nnd.diL();
        }
        this.nFX = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    j.this.ixe.setResult(-1, intent);
                    j.this.ixe.finish();
                }
            }
        };
        this.ixe = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.nCB = str3;
        this.nWh = new VideoConvertUtil(baseFragmentActivity);
        this.nWh.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.nFX);
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.nVl = frsTabInfoData;
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.antiData = antiData;
        this.prefixData = postPrefixData;
        this.firstDir = str;
        this.secondDir = str2;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.nWe = videoFileInfo;
        this.jzs = str;
        this.mFrom = str2;
        if (this.nWe != null && this.ixe != null) {
            if (this.nWe.videoDuration > 600000) {
                dVn();
            } else if (this.nWh == null || !this.nWh.isConvertRunning()) {
                String str3 = this.nWe.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    com.baidu.adp.lib.util.l.showToast(this.ixe, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    MK(107);
                } else if (!new File(str3).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.ixe, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    MK(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.nWe != null) {
                        this.nWf = this.nWe.videoPath;
                        yJ(false);
                        MK(102);
                    }
                } else if (VideoConvertUtil.UF(str3) >= 1500000) {
                    if (VideoConvertUtil.dTL()) {
                        this.nWf = new File(VideoConvertUtil.nBe, "tieba_" + VideoConvertUtil.UE(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.nWh.setConvertType(1);
                        this.nWh.gA(str3, this.nWf);
                        dVi();
                        this.nFP = false;
                        this.nFQ = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.nWe;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.nWf = new File(VideoConvertUtil.nBe, "tieba_" + VideoConvertUtil.UE(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.nWh.setConvertType(2);
                            this.nWh.gA(str3, this.nWf);
                            dVi();
                            this.nFP = false;
                            this.nFQ = false;
                            return;
                        }
                        this.nWf = videoFileInfo2.videoPath;
                        yJ(false);
                        MK(102);
                    }
                }
            }
        }
    }

    private void dVn() {
        com.baidu.tbadk.core.dialog.a a2 = new com.baidu.tbadk.core.dialog.a(this.ixe).oP(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.j.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a2.b(this.ixe.getPageContext());
        a2.jm(false);
        a2.brv();
    }

    private void dVi() {
        RelativeLayout relativeLayout = (RelativeLayout) this.ixe.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.nWg == null) {
                this.nWg = new AlbumVideoCompressingDialogView(this.ixe);
            }
            if (this.nWg.getParent() == null) {
                relativeLayout.addView(this.nWg);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nWg.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.nWg.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.nWg.setPercent(0);
        this.nWi = true;
    }

    private void yJ(boolean z) {
        VideoFileInfo VG = VG(this.nWf);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nWf);
        videoInfo.setVideoDuration(VG.videoDuration / 1000);
        videoInfo.setVideoWidth(VG.videoWidth);
        videoInfo.setVideoHeight(VG.videoHeight);
        videoInfo.setVideoLength(new File(VG.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.ixe, this.jzs, this.mForumName, this.mForumId, this.nCB, videoInfo);
        editVideoActivityConfig.setProZone(this.nWj);
        editVideoActivityConfig.setFrsTabInfo(this.nVl);
        editVideoActivityConfig.setFrom(this.mFrom);
        editVideoActivityConfig.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.nFP = false;
        this.nWf = null;
        if (this.nnd != null) {
            this.nnd.diO();
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
    public void dTG() {
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
                if (this.nWg != null && this.nWg.isShowing()) {
                    this.nWg.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.nFQ) {
                    com.baidu.adp.lib.util.l.showToast(this.ixe, R.string.mv_local_video_compress_failed);
                    MK(103);
                }
                this.nWi = false;
                this.nFP = false;
                dVj();
                break;
            case 3:
                this.nWi = false;
                this.nFP = true;
                if (!StringUtils.isNull(this.nWf) && (file = new File(this.nWf)) != null) {
                    this.nWf = this.nWf.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.nWf));
                }
                dVj();
                if (!this.nFO) {
                    yJ(true);
                    if (this.nnd != null) {
                        this.nnd.diO();
                        break;
                    }
                }
                break;
            case 4:
                this.nWi = false;
                this.nFP = false;
                dVj();
                MK(104);
                break;
            case 5:
                this.nWi = false;
                com.baidu.adp.lib.util.l.showToast(this.ixe, R.string.mv_local_video_compress_failed);
                if (this.nWh != null && this.nWh.isConvertRunning()) {
                    dVk();
                }
                MK(105);
                break;
        }
        return true;
    }

    private void dVj() {
        RelativeLayout relativeLayout = (RelativeLayout) this.ixe.findViewById(R.id.parent);
        if (relativeLayout != null && this.nWg.getParent() != null) {
            relativeLayout.removeView(this.nWg);
        }
    }

    private void dVk() {
        if (this.nWh != null) {
            this.nWh.abortConvert();
        }
        this.nFQ = true;
        if (this.nWf != null) {
            File file = new File(this.nWf);
            if (file.exists()) {
                file.delete();
            }
        }
        dVj();
        this.nWf = null;
    }

    public void onStart() {
        this.nFO = false;
    }

    public void onStop() {
        this.nFO = true;
    }

    public void onResume() {
        if (this.nFP && !TextUtils.isEmpty(this.nWf) && new File(this.nWf).exists()) {
            yJ(true);
            MK(101);
        }
        if (this.nnd != null) {
            this.nnd.Po("album");
        }
    }

    public void onDestroy() {
        if (this.nWh != null) {
            this.nWh.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.nnd != null) {
            this.nnd.Pp("album");
        }
        MessageManager.getInstance().unRegisterListener(this.nFX);
    }

    private void MK(int i) {
        if (this.nnd != null) {
            this.nnd.bE(i, "album");
        }
    }

    public boolean dYZ() {
        return this.nWi;
    }

    public void setProfessionZone(int i) {
        this.nWj = i;
    }
}
