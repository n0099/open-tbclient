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
    private String nGI;
    private FrsTabInfoData nYG;
    private VideoFileInfo nZA;
    private String nZB;
    private AlbumVideoCompressingDialogView nZF;
    private VideoConvertUtil nZG;
    private boolean nZH;
    private final CustomMessageListener nZJ;
    private com.baidu.tieba.l.g nsP;
    private int statisticFrom;
    private boolean nZC = false;
    private boolean nZD = false;
    private boolean nZE = false;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";
    private int nZI = -1;

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.nsP = kVar.diP();
        }
        if (this.nsP != null) {
            this.nsP.diy();
        }
        this.nZJ = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.j.2
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
        this.nGI = str3;
        this.nZG = new VideoConvertUtil(baseFragmentActivity);
        this.nZG.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.nZJ);
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.nYG = frsTabInfoData;
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.antiData = antiData;
        this.prefixData = postPrefixData;
        this.firstDir = str;
        this.secondDir = str2;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.nZA = videoFileInfo;
        this.jLR = str;
        this.mFrom = str2;
        if (this.nZA != null && this.iJr != null) {
            if (this.nZA.videoDuration > 600000) {
                dYC();
            } else if (this.nZG == null || !this.nZG.isConvertRunning()) {
                String str3 = this.nZA.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    l.showToast(this.iJr, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    Mx(107);
                } else if (!new File(str3).exists()) {
                    l.showToast(this.iJr, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    Mx(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.nZA != null) {
                        this.nZB = this.nZA.videoPath;
                        zl(false);
                        Mx(102);
                    }
                } else if (VideoConvertUtil.Um(str3) >= 1500000) {
                    if (VideoConvertUtil.dTC()) {
                        this.nZB = new File(VideoConvertUtil.nFt, "tieba_" + VideoConvertUtil.Ul(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.nZG.setConvertType(1);
                        this.nZG.gx(str3, this.nZB);
                        dYD();
                        this.nZD = false;
                        this.nZE = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.nZA;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.nZB = new File(VideoConvertUtil.nFt, "tieba_" + VideoConvertUtil.Ul(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.nZG.setConvertType(2);
                            this.nZG.gx(str3, this.nZB);
                            dYD();
                            this.nZD = false;
                            this.nZE = false;
                            return;
                        }
                        this.nZB = videoFileInfo2.videoPath;
                        zl(false);
                        Mx(102);
                    }
                }
            }
        }
    }

    private void dYC() {
        com.baidu.tbadk.core.dialog.a a2 = new com.baidu.tbadk.core.dialog.a(this.iJr).oZ(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.j.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a2.b(this.iJr.getPageContext());
        a2.jI(false);
        a2.btX();
    }

    private void dYD() {
        RelativeLayout relativeLayout = (RelativeLayout) this.iJr.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.nZF == null) {
                this.nZF = new AlbumVideoCompressingDialogView(this.iJr);
            }
            if (this.nZF.getParent() == null) {
                relativeLayout.addView(this.nZF);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nZF.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.nZF.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.nZF.setPercent(0);
        this.nZH = true;
    }

    private void zl(boolean z) {
        VideoFileInfo Vl = Vl(this.nZB);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nZB);
        videoInfo.setVideoDuration(Vl.videoDuration / 1000);
        videoInfo.setVideoWidth(Vl.videoWidth);
        videoInfo.setVideoHeight(Vl.videoHeight);
        videoInfo.setVideoLength(new File(Vl.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.iJr, this.jLR, this.mForumName, this.mForumId, this.nGI, videoInfo);
        editVideoActivityConfig.setProZone(this.nZI);
        editVideoActivityConfig.setStatisticFrom(this.statisticFrom);
        editVideoActivityConfig.setFrsTabInfo(this.nYG);
        editVideoActivityConfig.setFrom(this.mFrom);
        editVideoActivityConfig.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.nZD = false;
        this.nZB = null;
        if (this.nsP != null) {
            this.nsP.diB();
        }
    }

    public static VideoFileInfo Vl(String str) {
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
    public void dTx() {
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
                if (this.nZF != null && this.nZF.isShowing()) {
                    this.nZF.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), AppStatusRules.DEFAULT_GRANULARITY);
                break;
            case 2:
                if (!this.nZE) {
                    l.showToast(this.iJr, R.string.mv_local_video_compress_failed);
                    Mx(103);
                }
                this.nZH = false;
                this.nZD = false;
                dYE();
                break;
            case 3:
                this.nZH = false;
                this.nZD = true;
                if (!StringUtils.isNull(this.nZB) && (file = new File(this.nZB)) != null) {
                    this.nZB = this.nZB.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.nZB));
                }
                dYE();
                if (!this.nZC) {
                    zl(true);
                    if (this.nsP != null) {
                        this.nsP.diB();
                        break;
                    }
                }
                break;
            case 4:
                this.nZH = false;
                this.nZD = false;
                dYE();
                Mx(104);
                break;
            case 5:
                this.nZH = false;
                l.showToast(this.iJr, R.string.mv_local_video_compress_failed);
                if (this.nZG != null && this.nZG.isConvertRunning()) {
                    dYF();
                }
                Mx(105);
                break;
        }
        return true;
    }

    private void dYE() {
        RelativeLayout relativeLayout = (RelativeLayout) this.iJr.findViewById(R.id.parent);
        if (relativeLayout != null && this.nZF.getParent() != null) {
            relativeLayout.removeView(this.nZF);
        }
    }

    private void dYF() {
        if (this.nZG != null) {
            this.nZG.abortConvert();
        }
        this.nZE = true;
        if (this.nZB != null) {
            File file = new File(this.nZB);
            if (file.exists()) {
                file.delete();
            }
        }
        dYE();
        this.nZB = null;
    }

    public void onStart() {
        this.nZC = false;
    }

    public void onStop() {
        this.nZC = true;
    }

    public void onResume() {
        if (this.nZD && !TextUtils.isEmpty(this.nZB) && new File(this.nZB).exists()) {
            zl(true);
            Mx(101);
        }
        if (this.nsP != null) {
            this.nsP.OW("album");
        }
    }

    public void onDestroy() {
        if (this.nZG != null) {
            this.nZG.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.nsP != null) {
            this.nsP.OX("album");
        }
        MessageManager.getInstance().unRegisterListener(this.nZJ);
    }

    private void Mx(int i) {
        if (this.nsP != null) {
            this.nsP.bE(i, "album");
        }
    }

    public boolean dYG() {
        return this.nZH;
    }

    public void setProfessionZone(int i) {
        this.nZI = i;
    }

    public void setStatisticFrom(int i) {
        this.statisticFrom = i;
    }
}
