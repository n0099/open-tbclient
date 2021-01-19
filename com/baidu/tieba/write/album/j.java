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
    private String nCd;
    private VideoFileInfo nUV;
    private String nUW;
    private FrsTabInfoData nUb;
    private AlbumVideoCompressingDialogView nVa;
    private VideoConvertUtil nVb;
    private boolean nVc;
    private final CustomMessageListener nVe;
    private com.baidu.tieba.l.g noi;
    private int statisticFrom;
    private boolean nUX = false;
    private boolean nUY = false;
    private boolean nUZ = false;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";
    private int nVd = -1;

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.noi = kVar.deY();
        }
        if (this.noi != null) {
            this.noi.deH();
        }
        this.nVe = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.j.2
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
        this.nCd = str3;
        this.nVb = new VideoConvertUtil(baseFragmentActivity);
        this.nVb.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.nVe);
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.nUb = frsTabInfoData;
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.antiData = antiData;
        this.prefixData = postPrefixData;
        this.firstDir = str;
        this.secondDir = str2;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.nUV = videoFileInfo;
        this.jHl = str;
        this.mFrom = str2;
        if (this.nUV != null && this.iEK != null) {
            if (this.nUV.videoDuration > 600000) {
                dUL();
            } else if (this.nVb == null || !this.nVb.isConvertRunning()) {
                String str3 = this.nUV.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    l.showToast(this.iEK, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    KQ(107);
                } else if (!new File(str3).exists()) {
                    l.showToast(this.iEK, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    KQ(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.nUV != null) {
                        this.nUW = this.nUV.videoPath;
                        zh(false);
                        KQ(102);
                    }
                } else if (VideoConvertUtil.Te(str3) >= 1500000) {
                    if (VideoConvertUtil.dPL()) {
                        this.nUW = new File(VideoConvertUtil.nAO, "tieba_" + VideoConvertUtil.Td(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.nVb.setConvertType(1);
                        this.nVb.gw(str3, this.nUW);
                        dUM();
                        this.nUY = false;
                        this.nUZ = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.nUV;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.nUW = new File(VideoConvertUtil.nAO, "tieba_" + VideoConvertUtil.Td(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.nVb.setConvertType(2);
                            this.nVb.gw(str3, this.nUW);
                            dUM();
                            this.nUY = false;
                            this.nUZ = false;
                            return;
                        }
                        this.nUW = videoFileInfo2.videoPath;
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
            if (this.nVa == null) {
                this.nVa = new AlbumVideoCompressingDialogView(this.iEK);
            }
            if (this.nVa.getParent() == null) {
                relativeLayout.addView(this.nVa);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nVa.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.nVa.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.nVa.setPercent(0);
        this.nVc = true;
    }

    private void zh(boolean z) {
        VideoFileInfo Ud = Ud(this.nUW);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nUW);
        videoInfo.setVideoDuration(Ud.videoDuration / 1000);
        videoInfo.setVideoWidth(Ud.videoWidth);
        videoInfo.setVideoHeight(Ud.videoHeight);
        videoInfo.setVideoLength(new File(Ud.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.iEK, this.jHl, this.mForumName, this.mForumId, this.nCd, videoInfo);
        editVideoActivityConfig.setProZone(this.nVd);
        editVideoActivityConfig.setStatisticFrom(this.statisticFrom);
        editVideoActivityConfig.setFrsTabInfo(this.nUb);
        editVideoActivityConfig.setFrom(this.mFrom);
        editVideoActivityConfig.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.nUY = false;
        this.nUW = null;
        if (this.noi != null) {
            this.noi.deK();
        }
    }

    public static VideoFileInfo Ud(String str) {
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
                if (this.nVa != null && this.nVa.isShowing()) {
                    this.nVa.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), AppStatusRules.DEFAULT_GRANULARITY);
                break;
            case 2:
                if (!this.nUZ) {
                    l.showToast(this.iEK, R.string.mv_local_video_compress_failed);
                    KQ(103);
                }
                this.nVc = false;
                this.nUY = false;
                dUN();
                break;
            case 3:
                this.nVc = false;
                this.nUY = true;
                if (!StringUtils.isNull(this.nUW) && (file = new File(this.nUW)) != null) {
                    this.nUW = this.nUW.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.nUW));
                }
                dUN();
                if (!this.nUX) {
                    zh(true);
                    if (this.noi != null) {
                        this.noi.deK();
                        break;
                    }
                }
                break;
            case 4:
                this.nVc = false;
                this.nUY = false;
                dUN();
                KQ(104);
                break;
            case 5:
                this.nVc = false;
                l.showToast(this.iEK, R.string.mv_local_video_compress_failed);
                if (this.nVb != null && this.nVb.isConvertRunning()) {
                    dUO();
                }
                KQ(105);
                break;
        }
        return true;
    }

    private void dUN() {
        RelativeLayout relativeLayout = (RelativeLayout) this.iEK.findViewById(R.id.parent);
        if (relativeLayout != null && this.nVa.getParent() != null) {
            relativeLayout.removeView(this.nVa);
        }
    }

    private void dUO() {
        if (this.nVb != null) {
            this.nVb.abortConvert();
        }
        this.nUZ = true;
        if (this.nUW != null) {
            File file = new File(this.nUW);
            if (file.exists()) {
                file.delete();
            }
        }
        dUN();
        this.nUW = null;
    }

    public void onStart() {
        this.nUX = false;
    }

    public void onStop() {
        this.nUX = true;
    }

    public void onResume() {
        if (this.nUY && !TextUtils.isEmpty(this.nUW) && new File(this.nUW).exists()) {
            zh(true);
            KQ(101);
        }
        if (this.noi != null) {
            this.noi.NO("album");
        }
    }

    public void onDestroy() {
        if (this.nVb != null) {
            this.nVb.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.noi != null) {
            this.noi.NP("album");
        }
        MessageManager.getInstance().unRegisterListener(this.nVe);
    }

    private void KQ(int i) {
        if (this.noi != null) {
            this.noi.bF(i, "album");
        }
    }

    public boolean dUP() {
        return this.nVc;
    }

    public void setProfessionZone(int i) {
        this.nVd = i;
    }

    public void setStatisticFrom(int i) {
        this.statisticFrom = i;
    }
}
