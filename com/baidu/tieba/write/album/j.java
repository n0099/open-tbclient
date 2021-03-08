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
/* loaded from: classes7.dex */
public class j implements Handler.Callback, com.baidu.tieba.video.d {
    private BaseFragmentActivity iMq;
    private String jOM;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private com.baidu.tieba.l.g nAz;
    private String nOs;
    private FrsTabInfoData ogN;
    private VideoFileInfo ohH;
    private String ohI;
    private AlbumVideoCompressingDialogView ohM;
    private VideoConvertUtil ohN;
    private boolean ohO;
    private final CustomMessageListener ohQ;
    private int statisticFrom;
    private boolean ohJ = false;
    private boolean ohK = false;
    private boolean ohL = false;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";
    private int ohP = -1;

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.nAz = kVar.dho();
        }
        if (this.nAz != null) {
            this.nAz.dgX();
        }
        this.ohQ = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    j.this.iMq.setResult(-1, intent);
                    j.this.iMq.finish();
                }
            }
        };
        this.iMq = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.nOs = str3;
        this.ohN = new VideoConvertUtil(baseFragmentActivity);
        this.ohN.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.ohQ);
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.ogN = frsTabInfoData;
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.antiData = antiData;
        this.prefixData = postPrefixData;
        this.firstDir = str;
        this.secondDir = str2;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.ohH = videoFileInfo;
        this.jOM = str;
        this.mFrom = str2;
        if (this.ohH != null && this.iMq != null) {
            if (this.ohH.videoDuration > 600000) {
                dXp();
            } else if (this.ohN == null || !this.ohN.isConvertRunning()) {
                String str3 = this.ohH.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    l.showToast(this.iMq, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    Lq(107);
                } else if (!new File(str3).exists()) {
                    l.showToast(this.iMq, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    Lq(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.ohH != null) {
                        this.ohI = this.ohH.videoPath;
                        zC(false);
                        Lq(102);
                    }
                } else if (VideoConvertUtil.Uu(str3) >= 1500000) {
                    if (VideoConvertUtil.dSm()) {
                        this.ohI = new File(VideoConvertUtil.nNd, "tieba_" + VideoConvertUtil.Ut(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.ohN.setConvertType(1);
                        this.ohN.gE(str3, this.ohI);
                        dXq();
                        this.ohK = false;
                        this.ohL = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.ohH;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.ohI = new File(VideoConvertUtil.nNd, "tieba_" + VideoConvertUtil.Ut(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.ohN.setConvertType(2);
                            this.ohN.gE(str3, this.ohI);
                            dXq();
                            this.ohK = false;
                            this.ohL = false;
                            return;
                        }
                        this.ohI = videoFileInfo2.videoPath;
                        zC(false);
                        Lq(102);
                    }
                }
            }
        }
    }

    private void dXp() {
        com.baidu.tbadk.core.dialog.a a2 = new com.baidu.tbadk.core.dialog.a(this.iMq).nx(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.j.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a2.b(this.iMq.getPageContext());
        a2.jG(false);
        a2.bqz();
    }

    private void dXq() {
        RelativeLayout relativeLayout = (RelativeLayout) this.iMq.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.ohM == null) {
                this.ohM = new AlbumVideoCompressingDialogView(this.iMq);
            }
            if (this.ohM.getParent() == null) {
                relativeLayout.addView(this.ohM);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ohM.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.ohM.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.ohM.setPercent(0);
        this.ohO = true;
    }

    private void zC(boolean z) {
        VideoFileInfo Vu = Vu(this.ohI);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.ohI);
        videoInfo.setVideoDuration(Vu.videoDuration / 1000);
        videoInfo.setVideoWidth(Vu.videoWidth);
        videoInfo.setVideoHeight(Vu.videoHeight);
        videoInfo.setVideoLength(new File(Vu.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.iMq, this.jOM, this.mForumName, this.mForumId, this.nOs, videoInfo);
        editVideoActivityConfig.setProZone(this.ohP);
        editVideoActivityConfig.setStatisticFrom(this.statisticFrom);
        editVideoActivityConfig.setFrsTabInfo(this.ogN);
        editVideoActivityConfig.setFrom(this.mFrom);
        editVideoActivityConfig.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.ohK = false;
        this.ohI = null;
        if (this.nAz != null) {
            this.nAz.dha();
        }
    }

    public static VideoFileInfo Vu(String str) {
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
    public void dSh() {
    }

    @Override // com.baidu.tieba.video.d
    public void Kz(int i) {
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
                if (this.ohM != null && this.ohM.isShowing()) {
                    this.ohM.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), AppStatusRules.DEFAULT_GRANULARITY);
                break;
            case 2:
                if (!this.ohL) {
                    l.showToast(this.iMq, R.string.mv_local_video_compress_failed);
                    Lq(103);
                }
                this.ohO = false;
                this.ohK = false;
                dXr();
                break;
            case 3:
                this.ohO = false;
                this.ohK = true;
                if (!StringUtils.isNull(this.ohI) && (file = new File(this.ohI)) != null) {
                    this.ohI = this.ohI.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.ohI));
                }
                dXr();
                if (!this.ohJ) {
                    zC(true);
                    if (this.nAz != null) {
                        this.nAz.dha();
                        break;
                    }
                }
                break;
            case 4:
                this.ohO = false;
                this.ohK = false;
                dXr();
                Lq(104);
                break;
            case 5:
                this.ohO = false;
                l.showToast(this.iMq, R.string.mv_local_video_compress_failed);
                if (this.ohN != null && this.ohN.isConvertRunning()) {
                    dXs();
                }
                Lq(105);
                break;
        }
        return true;
    }

    private void dXr() {
        RelativeLayout relativeLayout = (RelativeLayout) this.iMq.findViewById(R.id.parent);
        if (relativeLayout != null && this.ohM.getParent() != null) {
            relativeLayout.removeView(this.ohM);
        }
    }

    private void dXs() {
        if (this.ohN != null) {
            this.ohN.abortConvert();
        }
        this.ohL = true;
        if (this.ohI != null) {
            File file = new File(this.ohI);
            if (file.exists()) {
                file.delete();
            }
        }
        dXr();
        this.ohI = null;
    }

    public void onStart() {
        this.ohJ = false;
    }

    public void onStop() {
        this.ohJ = true;
    }

    public void onResume() {
        if (this.ohK && !TextUtils.isEmpty(this.ohI) && new File(this.ohI).exists()) {
            zC(true);
            Lq(101);
        }
        if (this.nAz != null) {
            this.nAz.OJ("album");
        }
    }

    public void onDestroy() {
        if (this.ohN != null) {
            this.ohN.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.nAz != null) {
            this.nAz.OK("album");
        }
        MessageManager.getInstance().unRegisterListener(this.ohQ);
    }

    private void Lq(int i) {
        if (this.nAz != null) {
            this.nAz.bL(i, "album");
        }
    }

    public boolean dXt() {
        return this.ohO;
    }

    public void setProfessionZone(int i) {
        this.ohP = i;
    }

    public void setStatisticFrom(int i) {
        this.statisticFrom = i;
    }
}
