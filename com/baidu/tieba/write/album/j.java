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
import com.baidu.tieba.l.l;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import java.io.File;
/* loaded from: classes3.dex */
public class j implements Handler.Callback, com.baidu.tieba.video.d {
    private BaseFragmentActivity imj;
    private String jlN;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private com.baidu.tieba.l.h mZc;
    private VideoFileInfo nHW;
    private String nHX;
    private AlbumVideoCompressingDialogView nHY;
    private VideoConvertUtil nHZ;
    private FrsTabInfoData nHd;
    private boolean nIa;
    private String noy;
    private final CustomMessageListener nrU;
    private boolean nrL = false;
    private boolean nrM = false;
    private boolean nrN = false;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";
    private int nIb = -1;

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mZc = lVar.ddQ();
        }
        if (this.mZc != null) {
            this.mZc.ddz();
        }
        this.nrU = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    j.this.imj.setResult(-1, intent);
                    j.this.imj.finish();
                }
            }
        };
        this.imj = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.noy = str3;
        this.nHZ = new VideoConvertUtil(baseFragmentActivity);
        this.nHZ.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.nrU);
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.nHd = frsTabInfoData;
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.antiData = antiData;
        this.prefixData = postPrefixData;
        this.firstDir = str;
        this.secondDir = str2;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.nHW = videoFileInfo;
        this.jlN = str;
        this.mFrom = str2;
        if (this.nHW != null && this.imj != null) {
            if (this.nHW.videoDuration > 600000) {
                dPS();
            } else if (this.nHZ == null || !this.nHZ.isConvertRunning()) {
                String str3 = this.nHW.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    com.baidu.adp.lib.util.l.showToast(this.imj, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    LS(107);
                } else if (!new File(str3).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.imj, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    LS(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.nHW != null) {
                        this.nHX = this.nHW.videoPath;
                        ye(false);
                        LS(102);
                    }
                } else if (VideoConvertUtil.Tq(str3) >= 1500000) {
                    if (VideoConvertUtil.dOs()) {
                        this.nHX = new File(VideoConvertUtil.nmZ, "tieba_" + VideoConvertUtil.Tp(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.nHZ.setConvertType(1);
                        this.nHZ.gv(str3, this.nHX);
                        dPN();
                        this.nrM = false;
                        this.nrN = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.nHW;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.nHX = new File(VideoConvertUtil.nmZ, "tieba_" + VideoConvertUtil.Tp(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.nHZ.setConvertType(2);
                            this.nHZ.gv(str3, this.nHX);
                            dPN();
                            this.nrM = false;
                            this.nrN = false;
                            return;
                        }
                        this.nHX = videoFileInfo2.videoPath;
                        ye(false);
                        LS(102);
                    }
                }
            }
        }
    }

    private void dPS() {
        com.baidu.tbadk.core.dialog.a a2 = new com.baidu.tbadk.core.dialog.a(this.imj).or(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.j.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a2.b(this.imj.getPageContext());
        a2.iX(false);
        a2.bog();
    }

    private void dPN() {
        RelativeLayout relativeLayout = (RelativeLayout) this.imj.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.nHY == null) {
                this.nHY = new AlbumVideoCompressingDialogView(this.imj);
            }
            if (this.nHY.getParent() == null) {
                relativeLayout.addView(this.nHY);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nHY.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.nHY.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.nHY.setPercent(0);
        this.nIa = true;
    }

    private void ye(boolean z) {
        VideoFileInfo Ur = Ur(this.nHX);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nHX);
        videoInfo.setVideoDuration(Ur.videoDuration / 1000);
        videoInfo.setVideoWidth(Ur.videoWidth);
        videoInfo.setVideoHeight(Ur.videoHeight);
        videoInfo.setVideoLength(new File(Ur.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.imj, this.jlN, this.mForumName, this.mForumId, this.noy, videoInfo);
        editVideoActivityConfig.setProZone(this.nIb);
        editVideoActivityConfig.setFrsTabInfo(this.nHd);
        editVideoActivityConfig.setFrom(this.mFrom);
        editVideoActivityConfig.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.nrM = false;
        this.nHX = null;
        if (this.mZc != null) {
            this.mZc.ddC();
        }
    }

    public static VideoFileInfo Ur(String str) {
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
    public void dOn() {
    }

    @Override // com.baidu.tieba.video.d
    public void Lb(int i) {
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
                if (this.nHY != null && this.nHY.isShowing()) {
                    this.nHY.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.nrN) {
                    com.baidu.adp.lib.util.l.showToast(this.imj, R.string.mv_local_video_compress_failed);
                    LS(103);
                }
                this.nIa = false;
                this.nrM = false;
                dPO();
                break;
            case 3:
                this.nIa = false;
                this.nrM = true;
                if (!StringUtils.isNull(this.nHX) && (file = new File(this.nHX)) != null) {
                    this.nHX = this.nHX.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.nHX));
                }
                dPO();
                if (!this.nrL) {
                    ye(true);
                    if (this.mZc != null) {
                        this.mZc.ddC();
                        break;
                    }
                }
                break;
            case 4:
                this.nIa = false;
                this.nrM = false;
                dPO();
                LS(104);
                break;
            case 5:
                this.nIa = false;
                com.baidu.adp.lib.util.l.showToast(this.imj, R.string.mv_local_video_compress_failed);
                if (this.nHZ != null && this.nHZ.isConvertRunning()) {
                    dPP();
                }
                LS(105);
                break;
        }
        return true;
    }

    private void dPO() {
        RelativeLayout relativeLayout = (RelativeLayout) this.imj.findViewById(R.id.parent);
        if (relativeLayout != null && this.nHY.getParent() != null) {
            relativeLayout.removeView(this.nHY);
        }
    }

    private void dPP() {
        if (this.nHZ != null) {
            this.nHZ.abortConvert();
        }
        this.nrN = true;
        if (this.nHX != null) {
            File file = new File(this.nHX);
            if (file.exists()) {
                file.delete();
            }
        }
        dPO();
        this.nHX = null;
    }

    public void onStart() {
        this.nrL = false;
    }

    public void onStop() {
        this.nrL = true;
    }

    public void onResume() {
        if (this.nrM && !TextUtils.isEmpty(this.nHX) && new File(this.nHX).exists()) {
            ye(true);
            LS(101);
        }
        if (this.mZc != null) {
            this.mZc.Oh("album");
        }
    }

    public void onDestroy() {
        if (this.nHZ != null) {
            this.nHZ.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.mZc != null) {
            this.mZc.Oi("album");
        }
        MessageManager.getInstance().unRegisterListener(this.nrU);
    }

    private void LS(int i) {
        if (this.mZc != null) {
            this.mZc.bE(i, "album");
        }
    }

    public boolean dTE() {
        return this.nIa;
    }

    public void setProfessionZone(int i) {
        this.nIb = i;
    }
}
