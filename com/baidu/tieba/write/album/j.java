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
    private String iim;
    private com.baidu.tieba.k.h lOv;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private String mdr;
    private final CustomMessageListener mgR;
    private FrsTabInfoData mvg;
    private VideoFileInfo mwa;
    private String mwb;
    private AlbumVideoCompressingDialogView mwc;
    private VideoConvertUtil mwd;
    private boolean mwe;
    private boolean mgI = false;
    private boolean mgJ = false;
    private boolean mgK = false;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";
    private int mwf = -1;

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.lOv = lVar.cGE();
        }
        if (this.lOv != null) {
            this.lOv.cGn();
        }
        this.mgR = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.j.2
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
        this.mdr = str3;
        this.mwd = new VideoConvertUtil(baseFragmentActivity);
        this.mwd.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.mgR);
    }

    public void a(FrsTabInfoData frsTabInfoData) {
        this.mvg = frsTabInfoData;
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.antiData = antiData;
        this.prefixData = postPrefixData;
        this.firstDir = str;
        this.secondDir = str2;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.mwa = videoFileInfo;
        this.iim = str;
        this.mFrom = str2;
        if (this.mwa != null && this.hjZ != null) {
            if (this.mwa.videoDuration > 600000) {
                dqZ();
            } else if (this.mwd == null || !this.mwd.isConvertRunning()) {
                String str3 = this.mwa.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    com.baidu.adp.lib.util.l.showToast(this.hjZ, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    Hd(107);
                } else if (!new File(str3).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.hjZ, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    Hd(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.mwa != null) {
                        this.mwb = this.mwa.videoPath;
                        vQ(false);
                        Hd(102);
                    }
                } else if (VideoConvertUtil.OD(str3) >= 1500000) {
                    if (VideoConvertUtil.dpz()) {
                        this.mwb = new File(VideoConvertUtil.mbU, "tieba_" + VideoConvertUtil.OC(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.mwd.setConvertType(1);
                        this.mwd.fF(str3, this.mwb);
                        dqU();
                        this.mgJ = false;
                        this.mgK = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.mwa;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.mwb = new File(VideoConvertUtil.mbU, "tieba_" + VideoConvertUtil.OC(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.mwd.setConvertType(2);
                            this.mwd.fF(str3, this.mwb);
                            dqU();
                            this.mgJ = false;
                            this.mgK = false;
                            return;
                        }
                        this.mwb = videoFileInfo2.videoPath;
                        vQ(false);
                        Hd(102);
                    }
                }
            }
        }
    }

    private void dqZ() {
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

    private void dqU() {
        RelativeLayout relativeLayout = (RelativeLayout) this.hjZ.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.mwc == null) {
                this.mwc = new AlbumVideoCompressingDialogView(this.hjZ);
            }
            if (this.mwc.getParent() == null) {
                relativeLayout.addView(this.mwc);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mwc.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.mwc.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.mwc.setPercent(0);
        this.mwe = true;
    }

    private void vQ(boolean z) {
        VideoFileInfo PE = PE(this.mwb);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.mwb);
        videoInfo.setVideoDuration(PE.videoDuration / 1000);
        videoInfo.setVideoWidth(PE.videoWidth);
        videoInfo.setVideoHeight(PE.videoHeight);
        videoInfo.setVideoLength(new File(PE.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.hjZ, this.iim, this.mForumName, this.mForumId, this.mdr, videoInfo);
        editVideoActivityConfig.setProZone(this.mwf);
        editVideoActivityConfig.setFrsTabInfo(this.mvg);
        editVideoActivityConfig.setFrom(this.mFrom);
        editVideoActivityConfig.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.mgJ = false;
        this.mwb = null;
        if (this.lOv != null) {
            this.lOv.cGq();
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
    public void dpu() {
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
                if (this.mwc != null && this.mwc.isShowing()) {
                    this.mwc.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.mgK) {
                    com.baidu.adp.lib.util.l.showToast(this.hjZ, R.string.mv_local_video_compress_failed);
                    Hd(103);
                }
                this.mwe = false;
                this.mgJ = false;
                dqV();
                break;
            case 3:
                this.mwe = false;
                this.mgJ = true;
                if (!StringUtils.isNull(this.mwb) && (file = new File(this.mwb)) != null) {
                    this.mwb = this.mwb.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.mwb));
                }
                dqV();
                if (!this.mgI) {
                    vQ(true);
                    if (this.lOv != null) {
                        this.lOv.cGq();
                        break;
                    }
                }
                break;
            case 4:
                this.mwe = false;
                this.mgJ = false;
                dqV();
                Hd(104);
                break;
            case 5:
                this.mwe = false;
                com.baidu.adp.lib.util.l.showToast(this.hjZ, R.string.mv_local_video_compress_failed);
                if (this.mwd != null && this.mwd.isConvertRunning()) {
                    dqW();
                }
                Hd(105);
                break;
        }
        return true;
    }

    private void dqV() {
        RelativeLayout relativeLayout = (RelativeLayout) this.hjZ.findViewById(R.id.parent);
        if (relativeLayout != null && this.mwc.getParent() != null) {
            relativeLayout.removeView(this.mwc);
        }
    }

    private void dqW() {
        if (this.mwd != null) {
            this.mwd.abortConvert();
        }
        this.mgK = true;
        if (this.mwb != null) {
            File file = new File(this.mwb);
            if (file.exists()) {
                file.delete();
            }
        }
        dqV();
        this.mwb = null;
    }

    public void onStart() {
        this.mgI = false;
    }

    public void onStop() {
        this.mgI = true;
    }

    public void onResume() {
        if (this.mgJ && !TextUtils.isEmpty(this.mwb) && new File(this.mwb).exists()) {
            vQ(true);
            Hd(101);
        }
        if (this.lOv != null) {
            this.lOv.JM("album");
        }
    }

    public void onDestroy() {
        if (this.mwd != null) {
            this.mwd.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.lOv != null) {
            this.lOv.JN("album");
        }
        MessageManager.getInstance().unRegisterListener(this.mgR);
    }

    private void Hd(int i) {
        if (this.lOv != null) {
            this.lOv.bq(i, "album");
        }
    }

    public boolean duM() {
        return this.mwe;
    }

    public void setProfessionZone(int i) {
        this.mwf = i;
    }
}
