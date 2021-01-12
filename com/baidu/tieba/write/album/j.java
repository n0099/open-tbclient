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
    private BaseFragmentActivity iEK;
    private String jHl;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private String nCc;
    private VideoFileInfo nUU;
    private String nUV;
    private AlbumVideoCompressingDialogView nUZ;
    private FrsTabInfoData nUa;
    private VideoConvertUtil nVa;
    private boolean nVb;
    private final CustomMessageListener nVd;
    private com.baidu.tieba.l.g noh;
    private int statisticFrom;
    private boolean nUW = false;
    private boolean nUX = false;
    private boolean nUY = false;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";
    private int nVc = -1;

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.noh = kVar.deY();
        }
        if (this.noh != null) {
            this.noh.deH();
        }
        this.nVd = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    j.this.iEK.setResult(-1, intent);
                    j.this.iEK.finish();
                }
            }
        };
        this.iEK = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.nCc = str3;
        this.nVa = new VideoConvertUtil(baseFragmentActivity);
        this.nVa.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.nVd);
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.nUa = frsTabInfoData;
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.antiData = antiData;
        this.prefixData = postPrefixData;
        this.firstDir = str;
        this.secondDir = str2;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.nUU = videoFileInfo;
        this.jHl = str;
        this.mFrom = str2;
        if (this.nUU != null && this.iEK != null) {
            if (this.nUU.videoDuration > 600000) {
                dUL();
            } else if (this.nVa == null || !this.nVa.isConvertRunning()) {
                String str3 = this.nUU.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    l.showToast(this.iEK, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    KQ(107);
                } else if (!new File(str3).exists()) {
                    l.showToast(this.iEK, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    KQ(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.nUU != null) {
                        this.nUV = this.nUU.videoPath;
                        zh(false);
                        KQ(102);
                    }
                } else if (VideoConvertUtil.Td(str3) >= 1500000) {
                    if (VideoConvertUtil.dPL()) {
                        this.nUV = new File(VideoConvertUtil.nAN, "tieba_" + VideoConvertUtil.Tc(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.nVa.setConvertType(1);
                        this.nVa.gw(str3, this.nUV);
                        dUM();
                        this.nUX = false;
                        this.nUY = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.nUU;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.nUV = new File(VideoConvertUtil.nAN, "tieba_" + VideoConvertUtil.Tc(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.nVa.setConvertType(2);
                            this.nVa.gw(str3, this.nUV);
                            dUM();
                            this.nUX = false;
                            this.nUY = false;
                            return;
                        }
                        this.nUV = videoFileInfo2.videoPath;
                        zh(false);
                        KQ(102);
                    }
                }
            }
        }
    }

    private void dUL() {
        com.baidu.tbadk.core.dialog.a a2 = new com.baidu.tbadk.core.dialog.a(this.iEK).nt(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.j.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a2.b(this.iEK.getPageContext());
        a2.jE(false);
        a2.bqe();
    }

    private void dUM() {
        RelativeLayout relativeLayout = (RelativeLayout) this.iEK.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.nUZ == null) {
                this.nUZ = new AlbumVideoCompressingDialogView(this.iEK);
            }
            if (this.nUZ.getParent() == null) {
                relativeLayout.addView(this.nUZ);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nUZ.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.nUZ.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.nUZ.setPercent(0);
        this.nVb = true;
    }

    private void zh(boolean z) {
        VideoFileInfo Uc = Uc(this.nUV);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nUV);
        videoInfo.setVideoDuration(Uc.videoDuration / 1000);
        videoInfo.setVideoWidth(Uc.videoWidth);
        videoInfo.setVideoHeight(Uc.videoHeight);
        videoInfo.setVideoLength(new File(Uc.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.iEK, this.jHl, this.mForumName, this.mForumId, this.nCc, videoInfo);
        editVideoActivityConfig.setProZone(this.nVc);
        editVideoActivityConfig.setStatisticFrom(this.statisticFrom);
        editVideoActivityConfig.setFrsTabInfo(this.nUa);
        editVideoActivityConfig.setFrom(this.mFrom);
        editVideoActivityConfig.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.nUX = false;
        this.nUV = null;
        if (this.noh != null) {
            this.noh.deK();
        }
    }

    public static VideoFileInfo Uc(String str) {
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
    public void dPG() {
    }

    @Override // com.baidu.tieba.video.d
    public void Ka(int i) {
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
                if (this.nUZ != null && this.nUZ.isShowing()) {
                    this.nUZ.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), AppStatusRules.DEFAULT_GRANULARITY);
                break;
            case 2:
                if (!this.nUY) {
                    l.showToast(this.iEK, R.string.mv_local_video_compress_failed);
                    KQ(103);
                }
                this.nVb = false;
                this.nUX = false;
                dUN();
                break;
            case 3:
                this.nVb = false;
                this.nUX = true;
                if (!StringUtils.isNull(this.nUV) && (file = new File(this.nUV)) != null) {
                    this.nUV = this.nUV.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.nUV));
                }
                dUN();
                if (!this.nUW) {
                    zh(true);
                    if (this.noh != null) {
                        this.noh.deK();
                        break;
                    }
                }
                break;
            case 4:
                this.nVb = false;
                this.nUX = false;
                dUN();
                KQ(104);
                break;
            case 5:
                this.nVb = false;
                l.showToast(this.iEK, R.string.mv_local_video_compress_failed);
                if (this.nVa != null && this.nVa.isConvertRunning()) {
                    dUO();
                }
                KQ(105);
                break;
        }
        return true;
    }

    private void dUN() {
        RelativeLayout relativeLayout = (RelativeLayout) this.iEK.findViewById(R.id.parent);
        if (relativeLayout != null && this.nUZ.getParent() != null) {
            relativeLayout.removeView(this.nUZ);
        }
    }

    private void dUO() {
        if (this.nVa != null) {
            this.nVa.abortConvert();
        }
        this.nUY = true;
        if (this.nUV != null) {
            File file = new File(this.nUV);
            if (file.exists()) {
                file.delete();
            }
        }
        dUN();
        this.nUV = null;
    }

    public void onStart() {
        this.nUW = false;
    }

    public void onStop() {
        this.nUW = true;
    }

    public void onResume() {
        if (this.nUX && !TextUtils.isEmpty(this.nUV) && new File(this.nUV).exists()) {
            zh(true);
            KQ(101);
        }
        if (this.noh != null) {
            this.noh.NN("album");
        }
    }

    public void onDestroy() {
        if (this.nVa != null) {
            this.nVa.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.noh != null) {
            this.noh.NO("album");
        }
        MessageManager.getInstance().unRegisterListener(this.nVd);
    }

    private void KQ(int i) {
        if (this.noh != null) {
            this.noh.bF(i, "album");
        }
    }

    public boolean dUP() {
        return this.nVb;
    }

    public void setProfessionZone(int i) {
        this.nVc = i;
    }

    public void setStatisticFrom(int i) {
        this.statisticFrom = i;
    }
}
