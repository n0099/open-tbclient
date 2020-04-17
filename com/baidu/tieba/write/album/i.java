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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.k.l;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import java.io.File;
/* loaded from: classes2.dex */
public class i implements Handler.Callback, com.baidu.tieba.video.d {
    private BaseFragmentActivity gCG;
    private String hzq;
    private com.baidu.tieba.k.h kTI;
    private String lis;
    private final CustomMessageListener llK;
    private FrsTabInfoData lxY;
    private VideoFileInfo lza;
    private String lzb;
    private AlbumVideoCompressingDialogView lzc;
    private VideoConvertUtil lzd;
    private boolean lze;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private boolean llB = false;
    private boolean llC = false;
    private boolean llD = false;
    private int lzf = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.kTI = lVar.csa();
        }
        if (this.kTI != null) {
            this.kTI.crC();
        }
        this.llK = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    intent.putExtra(PostWriteCallBackData.GENERAL_TAB_ID, ((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId());
                    i.this.gCG.setResult(-1, intent);
                    i.this.gCG.finish();
                }
            }
        };
        this.gCG = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.lis = str3;
        this.lzd = new VideoConvertUtil(baseFragmentActivity);
        this.lzd.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.llK);
    }

    public void a(FrsTabInfoData frsTabInfoData) {
        this.lxY = frsTabInfoData;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.lza = videoFileInfo;
        this.hzq = str;
        this.mFrom = str2;
        if (this.lza != null && this.gCG != null) {
            if (this.lza.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                dbY();
            } else if (this.lzd == null || !this.lzd.isConvertRunning()) {
                String str3 = this.lza.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    com.baidu.adp.lib.util.l.showToast(this.gCG, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    EP(107);
                } else if (!new File(str3).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.gCG, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    EP(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.lza != null) {
                        this.lzb = this.lza.videoPath;
                        uw(false);
                        EP(102);
                    }
                } else if (VideoConvertUtil.LC(str3) >= 1500000) {
                    if (VideoConvertUtil.dax()) {
                        this.lzb = new File(VideoConvertUtil.lgV, "tieba_" + VideoConvertUtil.LB(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.lzd.setConvertType(1);
                        this.lzd.eV(str3, this.lzb);
                        dbT();
                        this.llC = false;
                        this.llD = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.lza;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.lzb = new File(VideoConvertUtil.lgV, "tieba_" + VideoConvertUtil.LB(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.lzd.setConvertType(2);
                            this.lzd.eV(str3, this.lzb);
                            dbT();
                            this.llC = false;
                            this.llD = false;
                            return;
                        }
                        this.lzb = videoFileInfo2.videoPath;
                        uw(false);
                        EP(102);
                    }
                }
            }
        }
    }

    private void dbY() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.gCG).kc(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.gCG.getPageContext());
        a.gF(false);
        a.aMU();
    }

    private void dbT() {
        RelativeLayout relativeLayout = (RelativeLayout) this.gCG.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.lzc == null) {
                this.lzc = new AlbumVideoCompressingDialogView(this.gCG);
            }
            if (this.lzc.getParent() == null) {
                relativeLayout.addView(this.lzc);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lzc.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.lzc.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.lzc.setPercent(0);
        this.lze = true;
    }

    private void uw(boolean z) {
        VideoFileInfo Mu = Mu(this.lzb);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.lzb);
        videoInfo.setVideoDuration(Mu.videoDuration / 1000);
        videoInfo.setVideoWidth(Mu.videoWidth);
        videoInfo.setVideoHeight(Mu.videoHeight);
        videoInfo.setVideoLength(new File(Mu.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.gCG, this.hzq, this.mForumName, this.mForumId, this.lis, videoInfo);
        editVideoActivityConfig.setProZone(this.lzf);
        editVideoActivityConfig.setFrsTabInfo(this.lxY);
        editVideoActivityConfig.setFrom(this.mFrom);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.llC = false;
        this.lzb = null;
        if (this.kTI != null) {
            this.kTI.crF();
        }
    }

    public static VideoFileInfo Mu(String str) {
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
    public void dat() {
    }

    @Override // com.baidu.tieba.video.d
    public void Ec(int i) {
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
                if (this.lzc != null && this.lzc.isShowing()) {
                    this.lzc.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.llD) {
                    com.baidu.adp.lib.util.l.showToast(this.gCG, (int) R.string.mv_local_video_compress_failed);
                    EP(103);
                }
                this.lze = false;
                this.llC = false;
                dbU();
                break;
            case 3:
                this.lze = false;
                this.llC = true;
                if (!StringUtils.isNull(this.lzb) && (file = new File(this.lzb)) != null) {
                    this.lzb = this.lzb.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.lzb));
                }
                dbU();
                if (!this.llB) {
                    uw(true);
                    if (this.kTI != null) {
                        this.kTI.crF();
                        break;
                    }
                }
                break;
            case 4:
                this.lze = false;
                this.llC = false;
                dbU();
                EP(104);
                break;
            case 5:
                this.lze = false;
                com.baidu.adp.lib.util.l.showToast(this.gCG, (int) R.string.mv_local_video_compress_failed);
                if (this.lzd != null && this.lzd.isConvertRunning()) {
                    dbV();
                }
                EP(105);
                break;
        }
        return true;
    }

    private void dbU() {
        RelativeLayout relativeLayout = (RelativeLayout) this.gCG.findViewById(R.id.parent);
        if (relativeLayout != null && this.lzc.getParent() != null) {
            relativeLayout.removeView(this.lzc);
        }
    }

    private void dbV() {
        if (this.lzd != null) {
            this.lzd.abortConvert();
        }
        this.llD = true;
        if (this.lzb != null) {
            File file = new File(this.lzb);
            if (file.exists()) {
                file.delete();
            }
        }
        dbU();
        this.lzb = null;
    }

    public void onStart() {
        this.llB = false;
    }

    public void onStop() {
        this.llB = true;
    }

    public void onResume() {
        if (this.llC && !TextUtils.isEmpty(this.lzb) && new File(this.lzb).exists()) {
            uw(true);
            EP(101);
        }
        if (this.kTI != null) {
            this.kTI.GI("album");
        }
    }

    public void onDestroy() {
        if (this.lzd != null) {
            this.lzd.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.kTI != null) {
            this.kTI.GJ("album");
        }
        MessageManager.getInstance().unRegisterListener(this.llK);
    }

    private void EP(int i) {
        if (this.kTI != null) {
            this.kTI.bf(i, "album");
        }
    }

    public boolean dfC() {
        return this.lze;
    }

    public void setProfessionZone(int i) {
        this.lzf = i;
    }
}
