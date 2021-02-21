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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tieba.l.k;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import com.kwad.sdk.collector.AppStatusRules;
import java.io.File;
/* loaded from: classes8.dex */
public class j implements Handler.Callback, com.baidu.tieba.video.d {
    private BaseFragmentActivity iKH;
    private String jNd;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private String nMn;
    private com.baidu.tieba.l.g nyu;
    private FrsTabInfoData oeH;
    private VideoFileInfo ofC;
    private String ofD;
    private AlbumVideoCompressingDialogView ofH;
    private VideoConvertUtil ofI;
    private boolean ofJ;
    private final CustomMessageListener ofL;
    private int statisticFrom;
    private boolean ofE = false;
    private boolean ofF = false;
    private boolean ofG = false;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";
    private int ofK = -1;

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.nyu = kVar.dhf();
        }
        if (this.nyu != null) {
            this.nyu.dgO();
        }
        this.ofL = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    j.this.iKH.setResult(-1, intent);
                    j.this.iKH.finish();
                }
            }
        };
        this.iKH = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.nMn = str3;
        this.ofI = new VideoConvertUtil(baseFragmentActivity);
        this.ofI.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.ofL);
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.oeH = frsTabInfoData;
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.antiData = antiData;
        this.prefixData = postPrefixData;
        this.firstDir = str;
        this.secondDir = str2;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.ofC = videoFileInfo;
        this.jNd = str;
        this.mFrom = str2;
        if (this.ofC != null && this.iKH != null) {
            if (this.ofC.videoDuration > 600000) {
                dXh();
            } else if (this.ofI == null || !this.ofI.isConvertRunning()) {
                String str3 = this.ofC.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    l.showToast(this.iKH, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    Lm(107);
                } else if (!new File(str3).exists()) {
                    l.showToast(this.iKH, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    Lm(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.ofC != null) {
                        this.ofD = this.ofC.videoPath;
                        zD(false);
                        Lm(102);
                    }
                } else if (VideoConvertUtil.Un(str3) >= 1500000) {
                    if (VideoConvertUtil.dSe()) {
                        this.ofD = new File(VideoConvertUtil.nKY, "tieba_" + VideoConvertUtil.Um(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.ofI.setConvertType(1);
                        this.ofI.gE(str3, this.ofD);
                        dXi();
                        this.ofF = false;
                        this.ofG = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.ofC;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.ofD = new File(VideoConvertUtil.nKY, "tieba_" + VideoConvertUtil.Um(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.ofI.setConvertType(2);
                            this.ofI.gE(str3, this.ofD);
                            dXi();
                            this.ofF = false;
                            this.ofG = false;
                            return;
                        }
                        this.ofD = videoFileInfo2.videoPath;
                        zD(false);
                        Lm(102);
                    }
                }
            }
        }
    }

    private void dXh() {
        com.baidu.tbadk.core.dialog.a a2 = new com.baidu.tbadk.core.dialog.a(this.iKH).nw(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.j.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a2.b(this.iKH.getPageContext());
        a2.jG(false);
        a2.bqx();
    }

    private void dXi() {
        RelativeLayout relativeLayout = (RelativeLayout) this.iKH.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.ofH == null) {
                this.ofH = new AlbumVideoCompressingDialogView(this.iKH);
            }
            if (this.ofH.getParent() == null) {
                relativeLayout.addView(this.ofH);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ofH.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.ofH.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.ofH.setPercent(0);
        this.ofJ = true;
    }

    private void zD(boolean z) {
        VideoFileInfo Vn = Vn(this.ofD);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.ofD);
        videoInfo.setVideoDuration(Vn.videoDuration / 1000);
        videoInfo.setVideoWidth(Vn.videoWidth);
        videoInfo.setVideoHeight(Vn.videoHeight);
        videoInfo.setVideoLength(new File(Vn.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.iKH, this.jNd, this.mForumName, this.mForumId, this.nMn, videoInfo);
        editVideoActivityConfig.setProZone(this.ofK);
        editVideoActivityConfig.setStatisticFrom(this.statisticFrom);
        editVideoActivityConfig.setFrsTabInfo(this.oeH);
        editVideoActivityConfig.setFrom(this.mFrom);
        editVideoActivityConfig.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.ofF = false;
        this.ofD = null;
        if (this.nyu != null) {
            this.nyu.dgR();
        }
    }

    public static VideoFileInfo Vn(String str) {
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
    public void dRZ() {
    }

    @Override // com.baidu.tieba.video.d
    public void Ku(int i) {
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
                if (this.ofH != null && this.ofH.isShowing()) {
                    this.ofH.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), AppStatusRules.DEFAULT_GRANULARITY);
                break;
            case 2:
                if (!this.ofG) {
                    l.showToast(this.iKH, R.string.mv_local_video_compress_failed);
                    Lm(103);
                }
                this.ofJ = false;
                this.ofF = false;
                dXj();
                break;
            case 3:
                this.ofJ = false;
                this.ofF = true;
                if (!StringUtils.isNull(this.ofD) && (file = new File(this.ofD)) != null) {
                    this.ofD = this.ofD.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.ofD));
                }
                dXj();
                if (!this.ofE) {
                    zD(true);
                    if (this.nyu != null) {
                        this.nyu.dgR();
                        break;
                    }
                }
                break;
            case 4:
                this.ofJ = false;
                this.ofF = false;
                dXj();
                Lm(104);
                break;
            case 5:
                this.ofJ = false;
                l.showToast(this.iKH, R.string.mv_local_video_compress_failed);
                if (this.ofI != null && this.ofI.isConvertRunning()) {
                    dXk();
                }
                Lm(105);
                break;
        }
        return true;
    }

    private void dXj() {
        RelativeLayout relativeLayout = (RelativeLayout) this.iKH.findViewById(R.id.parent);
        if (relativeLayout != null && this.ofH.getParent() != null) {
            relativeLayout.removeView(this.ofH);
        }
    }

    private void dXk() {
        if (this.ofI != null) {
            this.ofI.abortConvert();
        }
        this.ofG = true;
        if (this.ofD != null) {
            File file = new File(this.ofD);
            if (file.exists()) {
                file.delete();
            }
        }
        dXj();
        this.ofD = null;
    }

    public void onStart() {
        this.ofE = false;
    }

    public void onStop() {
        this.ofE = true;
    }

    public void onResume() {
        if (this.ofF && !TextUtils.isEmpty(this.ofD) && new File(this.ofD).exists()) {
            zD(true);
            Lm(101);
        }
        if (this.nyu != null) {
            this.nyu.OD("album");
        }
    }

    public void onDestroy() {
        if (this.ofI != null) {
            this.ofI.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.nyu != null) {
            this.nyu.OE("album");
        }
        MessageManager.getInstance().unRegisterListener(this.ofL);
    }

    private void Lm(int i) {
        if (this.nyu != null) {
            this.nyu.bL(i, "album");
        }
    }

    public boolean dXl() {
        return this.ofJ;
    }

    public void setProfessionZone(int i) {
        this.ofK = i;
    }

    public void setStatisticFrom(int i) {
        this.statisticFrom = i;
    }
}
