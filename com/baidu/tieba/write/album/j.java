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
/* loaded from: classes3.dex */
public class j implements Handler.Callback, com.baidu.tieba.video.d {
    private BaseFragmentActivity hwW;
    private String iwx;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private FrsTabInfoData mNM;
    private VideoFileInfo mOF;
    private String mOG;
    private AlbumVideoCompressingDialogView mOH;
    private VideoConvertUtil mOI;
    private boolean mOJ;
    private com.baidu.tieba.k.h mgu;
    private String mvu;
    private final CustomMessageListener myT;
    private boolean myK = false;
    private boolean myL = false;
    private boolean myM = false;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";
    private int mOK = -1;

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mgu = lVar.cRu();
        }
        if (this.mgu != null) {
            this.mgu.cRd();
        }
        this.myT = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    j.this.hwW.setResult(-1, intent);
                    j.this.hwW.finish();
                }
            }
        };
        this.hwW = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.mvu = str3;
        this.mOI = new VideoConvertUtil(baseFragmentActivity);
        this.mOI.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.myT);
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.mNM = frsTabInfoData;
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.antiData = antiData;
        this.prefixData = postPrefixData;
        this.firstDir = str;
        this.secondDir = str2;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.mOF = videoFileInfo;
        this.iwx = str;
        this.mFrom = str2;
        if (this.mOF != null && this.hwW != null) {
            if (this.mOF.videoDuration > 600000) {
                dCD();
            } else if (this.mOI == null || !this.mOI.isConvertRunning()) {
                String str3 = this.mOF.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    com.baidu.adp.lib.util.l.showToast(this.hwW, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    JA(107);
                } else if (!new File(str3).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.hwW, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    JA(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.mOF != null) {
                        this.mOG = this.mOF.videoPath;
                        wH(false);
                        JA(102);
                    }
                } else if (VideoConvertUtil.RB(str3) >= 1500000) {
                    if (VideoConvertUtil.dBd()) {
                        this.mOG = new File(VideoConvertUtil.mtX, "tieba_" + VideoConvertUtil.RA(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.mOI.setConvertType(1);
                        this.mOI.fX(str3, this.mOG);
                        dCy();
                        this.myL = false;
                        this.myM = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.mOF;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.mOG = new File(VideoConvertUtil.mtX, "tieba_" + VideoConvertUtil.RA(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.mOI.setConvertType(2);
                            this.mOI.fX(str3, this.mOG);
                            dCy();
                            this.myL = false;
                            this.myM = false;
                            return;
                        }
                        this.mOG = videoFileInfo2.videoPath;
                        wH(false);
                        JA(102);
                    }
                }
            }
        }
    }

    private void dCD() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hwW).ns(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.j.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hwW.getPageContext());
        a.ih(false);
        a.bhg();
    }

    private void dCy() {
        RelativeLayout relativeLayout = (RelativeLayout) this.hwW.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.mOH == null) {
                this.mOH = new AlbumVideoCompressingDialogView(this.hwW);
            }
            if (this.mOH.getParent() == null) {
                relativeLayout.addView(this.mOH);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mOH.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.mOH.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.mOH.setPercent(0);
        this.mOJ = true;
    }

    private void wH(boolean z) {
        VideoFileInfo SC = SC(this.mOG);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.mOG);
        videoInfo.setVideoDuration(SC.videoDuration / 1000);
        videoInfo.setVideoWidth(SC.videoWidth);
        videoInfo.setVideoHeight(SC.videoHeight);
        videoInfo.setVideoLength(new File(SC.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.hwW, this.iwx, this.mForumName, this.mForumId, this.mvu, videoInfo);
        editVideoActivityConfig.setProZone(this.mOK);
        editVideoActivityConfig.setFrsTabInfo(this.mNM);
        editVideoActivityConfig.setFrom(this.mFrom);
        editVideoActivityConfig.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.myL = false;
        this.mOG = null;
        if (this.mgu != null) {
            this.mgu.cRg();
        }
    }

    public static VideoFileInfo SC(String str) {
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
    public void dAY() {
    }

    @Override // com.baidu.tieba.video.d
    public void IJ(int i) {
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
                if (this.mOH != null && this.mOH.isShowing()) {
                    this.mOH.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.myM) {
                    com.baidu.adp.lib.util.l.showToast(this.hwW, R.string.mv_local_video_compress_failed);
                    JA(103);
                }
                this.mOJ = false;
                this.myL = false;
                dCz();
                break;
            case 3:
                this.mOJ = false;
                this.myL = true;
                if (!StringUtils.isNull(this.mOG) && (file = new File(this.mOG)) != null) {
                    this.mOG = this.mOG.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.mOG));
                }
                dCz();
                if (!this.myK) {
                    wH(true);
                    if (this.mgu != null) {
                        this.mgu.cRg();
                        break;
                    }
                }
                break;
            case 4:
                this.mOJ = false;
                this.myL = false;
                dCz();
                JA(104);
                break;
            case 5:
                this.mOJ = false;
                com.baidu.adp.lib.util.l.showToast(this.hwW, R.string.mv_local_video_compress_failed);
                if (this.mOI != null && this.mOI.isConvertRunning()) {
                    dCA();
                }
                JA(105);
                break;
        }
        return true;
    }

    private void dCz() {
        RelativeLayout relativeLayout = (RelativeLayout) this.hwW.findViewById(R.id.parent);
        if (relativeLayout != null && this.mOH.getParent() != null) {
            relativeLayout.removeView(this.mOH);
        }
    }

    private void dCA() {
        if (this.mOI != null) {
            this.mOI.abortConvert();
        }
        this.myM = true;
        if (this.mOG != null) {
            File file = new File(this.mOG);
            if (file.exists()) {
                file.delete();
            }
        }
        dCz();
        this.mOG = null;
    }

    public void onStart() {
        this.myK = false;
    }

    public void onStop() {
        this.myK = true;
    }

    public void onResume() {
        if (this.myL && !TextUtils.isEmpty(this.mOG) && new File(this.mOG).exists()) {
            wH(true);
            JA(101);
        }
        if (this.mgu != null) {
            this.mgu.MF("album");
        }
    }

    public void onDestroy() {
        if (this.mOI != null) {
            this.mOI.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.mgu != null) {
            this.mgu.MG("album");
        }
        MessageManager.getInstance().unRegisterListener(this.myT);
    }

    private void JA(int i) {
        if (this.mgu != null) {
            this.mgu.bn(i, "album");
        }
    }

    public boolean dGr() {
        return this.mOJ;
    }

    public void setProfessionZone(int i) {
        this.mOK = i;
    }
}
