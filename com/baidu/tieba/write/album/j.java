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
    private BaseFragmentActivity hjZ;
    private String iik;
    private com.baidu.tieba.k.h lOt;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private String mdp;
    private final CustomMessageListener mgP;
    private VideoFileInfo mvY;
    private String mvZ;
    private FrsTabInfoData mve;
    private AlbumVideoCompressingDialogView mwa;
    private VideoConvertUtil mwb;
    private boolean mwc;
    private boolean mgG = false;
    private boolean mgH = false;
    private boolean mgI = false;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";
    private int mwd = -1;

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.lOt = lVar.cGE();
        }
        if (this.lOt != null) {
            this.lOt.cGn();
        }
        this.mgP = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    j.this.hjZ.setResult(-1, intent);
                    j.this.hjZ.finish();
                }
            }
        };
        this.hjZ = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.mdp = str3;
        this.mwb = new VideoConvertUtil(baseFragmentActivity);
        this.mwb.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.mgP);
    }

    public void a(FrsTabInfoData frsTabInfoData) {
        this.mve = frsTabInfoData;
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.antiData = antiData;
        this.prefixData = postPrefixData;
        this.firstDir = str;
        this.secondDir = str2;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.mvY = videoFileInfo;
        this.iik = str;
        this.mFrom = str2;
        if (this.mvY != null && this.hjZ != null) {
            if (this.mvY.videoDuration > 600000) {
                dqY();
            } else if (this.mwb == null || !this.mwb.isConvertRunning()) {
                String str3 = this.mvY.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    com.baidu.adp.lib.util.l.showToast(this.hjZ, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    Hd(107);
                } else if (!new File(str3).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.hjZ, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    Hd(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.mvY != null) {
                        this.mvZ = this.mvY.videoPath;
                        vQ(false);
                        Hd(102);
                    }
                } else if (VideoConvertUtil.OD(str3) >= 1500000) {
                    if (VideoConvertUtil.dpy()) {
                        this.mvZ = new File(VideoConvertUtil.mbS, "tieba_" + VideoConvertUtil.OC(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.mwb.setConvertType(1);
                        this.mwb.fF(str3, this.mvZ);
                        dqT();
                        this.mgH = false;
                        this.mgI = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.mvY;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.mvZ = new File(VideoConvertUtil.mbS, "tieba_" + VideoConvertUtil.OC(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.mwb.setConvertType(2);
                            this.mwb.fF(str3, this.mvZ);
                            dqT();
                            this.mgH = false;
                            this.mgI = false;
                            return;
                        }
                        this.mvZ = videoFileInfo2.videoPath;
                        vQ(false);
                        Hd(102);
                    }
                }
            }
        }
    }

    private void dqY() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hjZ).lm(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.j.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hjZ.getPageContext());
        a.hK(false);
        a.aYL();
    }

    private void dqT() {
        RelativeLayout relativeLayout = (RelativeLayout) this.hjZ.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.mwa == null) {
                this.mwa = new AlbumVideoCompressingDialogView(this.hjZ);
            }
            if (this.mwa.getParent() == null) {
                relativeLayout.addView(this.mwa);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mwa.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.mwa.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.mwa.setPercent(0);
        this.mwc = true;
    }

    private void vQ(boolean z) {
        VideoFileInfo PE = PE(this.mvZ);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.mvZ);
        videoInfo.setVideoDuration(PE.videoDuration / 1000);
        videoInfo.setVideoWidth(PE.videoWidth);
        videoInfo.setVideoHeight(PE.videoHeight);
        videoInfo.setVideoLength(new File(PE.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.hjZ, this.iik, this.mForumName, this.mForumId, this.mdp, videoInfo);
        editVideoActivityConfig.setProZone(this.mwd);
        editVideoActivityConfig.setFrsTabInfo(this.mve);
        editVideoActivityConfig.setFrom(this.mFrom);
        editVideoActivityConfig.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.mgH = false;
        this.mvZ = null;
        if (this.lOt != null) {
            this.lOt.cGq();
        }
    }

    public static VideoFileInfo PE(String str) {
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
    public void dpt() {
    }

    @Override // com.baidu.tieba.video.d
    public void Gn(int i) {
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
                if (this.mwa != null && this.mwa.isShowing()) {
                    this.mwa.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.mgI) {
                    com.baidu.adp.lib.util.l.showToast(this.hjZ, R.string.mv_local_video_compress_failed);
                    Hd(103);
                }
                this.mwc = false;
                this.mgH = false;
                dqU();
                break;
            case 3:
                this.mwc = false;
                this.mgH = true;
                if (!StringUtils.isNull(this.mvZ) && (file = new File(this.mvZ)) != null) {
                    this.mvZ = this.mvZ.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.mvZ));
                }
                dqU();
                if (!this.mgG) {
                    vQ(true);
                    if (this.lOt != null) {
                        this.lOt.cGq();
                        break;
                    }
                }
                break;
            case 4:
                this.mwc = false;
                this.mgH = false;
                dqU();
                Hd(104);
                break;
            case 5:
                this.mwc = false;
                com.baidu.adp.lib.util.l.showToast(this.hjZ, R.string.mv_local_video_compress_failed);
                if (this.mwb != null && this.mwb.isConvertRunning()) {
                    dqV();
                }
                Hd(105);
                break;
        }
        return true;
    }

    private void dqU() {
        RelativeLayout relativeLayout = (RelativeLayout) this.hjZ.findViewById(R.id.parent);
        if (relativeLayout != null && this.mwa.getParent() != null) {
            relativeLayout.removeView(this.mwa);
        }
    }

    private void dqV() {
        if (this.mwb != null) {
            this.mwb.abortConvert();
        }
        this.mgI = true;
        if (this.mvZ != null) {
            File file = new File(this.mvZ);
            if (file.exists()) {
                file.delete();
            }
        }
        dqU();
        this.mvZ = null;
    }

    public void onStart() {
        this.mgG = false;
    }

    public void onStop() {
        this.mgG = true;
    }

    public void onResume() {
        if (this.mgH && !TextUtils.isEmpty(this.mvZ) && new File(this.mvZ).exists()) {
            vQ(true);
            Hd(101);
        }
        if (this.lOt != null) {
            this.lOt.JM("album");
        }
    }

    public void onDestroy() {
        if (this.mwb != null) {
            this.mwb.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.lOt != null) {
            this.lOt.JN("album");
        }
        MessageManager.getInstance().unRegisterListener(this.mgP);
    }

    private void Hd(int i) {
        if (this.lOt != null) {
            this.lOt.bq(i, "album");
        }
    }

    public boolean duL() {
        return this.mwc;
    }

    public void setProfessionZone(int i) {
        this.mwd = i;
    }
}
