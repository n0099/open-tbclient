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
    private BaseFragmentActivity iJr;
    private String jLR;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private String nGH;
    private FrsTabInfoData nYF;
    private String nZA;
    private AlbumVideoCompressingDialogView nZE;
    private VideoConvertUtil nZF;
    private boolean nZG;
    private final CustomMessageListener nZI;
    private VideoFileInfo nZz;
    private com.baidu.tieba.l.g nsO;
    private int statisticFrom;
    private boolean nZB = false;
    private boolean nZC = false;
    private boolean nZD = false;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";
    private int nZH = -1;

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.nsO = kVar.diQ();
        }
        if (this.nsO != null) {
            this.nsO.diz();
        }
        this.nZI = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    j.this.iJr.setResult(-1, intent);
                    j.this.iJr.finish();
                }
            }
        };
        this.iJr = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.nGH = str3;
        this.nZF = new VideoConvertUtil(baseFragmentActivity);
        this.nZF.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.nZI);
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.nYF = frsTabInfoData;
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.antiData = antiData;
        this.prefixData = postPrefixData;
        this.firstDir = str;
        this.secondDir = str2;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.nZz = videoFileInfo;
        this.jLR = str;
        this.mFrom = str2;
        if (this.nZz != null && this.iJr != null) {
            if (this.nZz.videoDuration > 600000) {
                dYD();
            } else if (this.nZF == null || !this.nZF.isConvertRunning()) {
                String str3 = this.nZz.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    l.showToast(this.iJr, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    Mx(107);
                } else if (!new File(str3).exists()) {
                    l.showToast(this.iJr, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    Mx(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.nZz != null) {
                        this.nZA = this.nZz.videoPath;
                        zl(false);
                        Mx(102);
                    }
                } else if (VideoConvertUtil.Ul(str3) >= 1500000) {
                    if (VideoConvertUtil.dTD()) {
                        this.nZA = new File(VideoConvertUtil.nFs, "tieba_" + VideoConvertUtil.Uk(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.nZF.setConvertType(1);
                        this.nZF.gx(str3, this.nZA);
                        dYE();
                        this.nZC = false;
                        this.nZD = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.nZz;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.nZA = new File(VideoConvertUtil.nFs, "tieba_" + VideoConvertUtil.Uk(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.nZF.setConvertType(2);
                            this.nZF.gx(str3, this.nZA);
                            dYE();
                            this.nZC = false;
                            this.nZD = false;
                            return;
                        }
                        this.nZA = videoFileInfo2.videoPath;
                        zl(false);
                        Mx(102);
                    }
                }
            }
        }
    }

    private void dYD() {
        com.baidu.tbadk.core.dialog.a a2 = new com.baidu.tbadk.core.dialog.a(this.iJr).oZ(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.j.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a2.b(this.iJr.getPageContext());
        a2.jI(false);
        a2.btY();
    }

    private void dYE() {
        RelativeLayout relativeLayout = (RelativeLayout) this.iJr.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.nZE == null) {
                this.nZE = new AlbumVideoCompressingDialogView(this.iJr);
            }
            if (this.nZE.getParent() == null) {
                relativeLayout.addView(this.nZE);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nZE.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.nZE.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.nZE.setPercent(0);
        this.nZG = true;
    }

    private void zl(boolean z) {
        VideoFileInfo Vk = Vk(this.nZA);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nZA);
        videoInfo.setVideoDuration(Vk.videoDuration / 1000);
        videoInfo.setVideoWidth(Vk.videoWidth);
        videoInfo.setVideoHeight(Vk.videoHeight);
        videoInfo.setVideoLength(new File(Vk.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.iJr, this.jLR, this.mForumName, this.mForumId, this.nGH, videoInfo);
        editVideoActivityConfig.setProZone(this.nZH);
        editVideoActivityConfig.setStatisticFrom(this.statisticFrom);
        editVideoActivityConfig.setFrsTabInfo(this.nYF);
        editVideoActivityConfig.setFrom(this.mFrom);
        editVideoActivityConfig.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.nZC = false;
        this.nZA = null;
        if (this.nsO != null) {
            this.nsO.diC();
        }
    }

    public static VideoFileInfo Vk(String str) {
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
    public void dTy() {
    }

    @Override // com.baidu.tieba.video.d
    public void LH(int i) {
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
                if (this.nZE != null && this.nZE.isShowing()) {
                    this.nZE.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), AppStatusRules.DEFAULT_GRANULARITY);
                break;
            case 2:
                if (!this.nZD) {
                    l.showToast(this.iJr, R.string.mv_local_video_compress_failed);
                    Mx(103);
                }
                this.nZG = false;
                this.nZC = false;
                dYF();
                break;
            case 3:
                this.nZG = false;
                this.nZC = true;
                if (!StringUtils.isNull(this.nZA) && (file = new File(this.nZA)) != null) {
                    this.nZA = this.nZA.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.nZA));
                }
                dYF();
                if (!this.nZB) {
                    zl(true);
                    if (this.nsO != null) {
                        this.nsO.diC();
                        break;
                    }
                }
                break;
            case 4:
                this.nZG = false;
                this.nZC = false;
                dYF();
                Mx(104);
                break;
            case 5:
                this.nZG = false;
                l.showToast(this.iJr, R.string.mv_local_video_compress_failed);
                if (this.nZF != null && this.nZF.isConvertRunning()) {
                    dYG();
                }
                Mx(105);
                break;
        }
        return true;
    }

    private void dYF() {
        RelativeLayout relativeLayout = (RelativeLayout) this.iJr.findViewById(R.id.parent);
        if (relativeLayout != null && this.nZE.getParent() != null) {
            relativeLayout.removeView(this.nZE);
        }
    }

    private void dYG() {
        if (this.nZF != null) {
            this.nZF.abortConvert();
        }
        this.nZD = true;
        if (this.nZA != null) {
            File file = new File(this.nZA);
            if (file.exists()) {
                file.delete();
            }
        }
        dYF();
        this.nZA = null;
    }

    public void onStart() {
        this.nZB = false;
    }

    public void onStop() {
        this.nZB = true;
    }

    public void onResume() {
        if (this.nZC && !TextUtils.isEmpty(this.nZA) && new File(this.nZA).exists()) {
            zl(true);
            Mx(101);
        }
        if (this.nsO != null) {
            this.nsO.OV("album");
        }
    }

    public void onDestroy() {
        if (this.nZF != null) {
            this.nZF.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.nsO != null) {
            this.nsO.OW("album");
        }
        MessageManager.getInstance().unRegisterListener(this.nZI);
    }

    private void Mx(int i) {
        if (this.nsO != null) {
            this.nsO.bE(i, "album");
        }
    }

    public boolean dYH() {
        return this.nZG;
    }

    public void setProfessionZone(int i) {
        this.nZH = i;
    }

    public void setStatisticFrom(int i) {
        this.statisticFrom = i;
    }
}
