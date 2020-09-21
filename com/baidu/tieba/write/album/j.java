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
    private BaseFragmentActivity hEa;
    private String iDT;
    private String mFg;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private final CustomMessageListener mIJ;
    private Handler mMainThreadHandler;
    private FrsTabInfoData mXJ;
    private VideoFileInfo mYC;
    private String mYD;
    private AlbumVideoCompressingDialogView mYE;
    private VideoConvertUtil mYF;
    private boolean mYG;
    private com.baidu.tieba.k.h mpU;
    private boolean mIz = false;
    private boolean mIA = false;
    private boolean mIB = false;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";
    private int mYH = -1;

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mpU = lVar.cVa();
        }
        if (this.mpU != null) {
            this.mpU.cUJ();
        }
        this.mIJ = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    j.this.hEa.setResult(-1, intent);
                    j.this.hEa.finish();
                }
            }
        };
        this.hEa = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.mFg = str3;
        this.mYF = new VideoConvertUtil(baseFragmentActivity);
        this.mYF.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.mIJ);
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.mXJ = frsTabInfoData;
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.antiData = antiData;
        this.prefixData = postPrefixData;
        this.firstDir = str;
        this.secondDir = str2;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.mYC = videoFileInfo;
        this.iDT = str;
        this.mFrom = str2;
        if (this.mYC != null && this.hEa != null) {
            if (this.mYC.videoDuration > 600000) {
                dGx();
            } else if (this.mYF == null || !this.mYF.isConvertRunning()) {
                String str3 = this.mYC.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    com.baidu.adp.lib.util.l.showToast(this.hEa, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    Ke(107);
                } else if (!new File(str3).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.hEa, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    Ke(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.mYC != null) {
                        this.mYD = this.mYC.videoPath;
                        wQ(false);
                        Ke(102);
                    }
                } else if (VideoConvertUtil.Sb(str3) >= 1500000) {
                    if (VideoConvertUtil.dEX()) {
                        this.mYD = new File(VideoConvertUtil.mDI, "tieba_" + VideoConvertUtil.Sa(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.mYF.setConvertType(1);
                        this.mYF.gj(str3, this.mYD);
                        dGs();
                        this.mIA = false;
                        this.mIB = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.mYC;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.mYD = new File(VideoConvertUtil.mDI, "tieba_" + VideoConvertUtil.Sa(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.mYF.setConvertType(2);
                            this.mYF.gj(str3, this.mYD);
                            dGs();
                            this.mIA = false;
                            this.mIB = false;
                            return;
                        }
                        this.mYD = videoFileInfo2.videoPath;
                        wQ(false);
                        Ke(102);
                    }
                }
            }
        }
    }

    private void dGx() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hEa).nD(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.j.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hEa.getPageContext());
        a.ie(false);
        a.bia();
    }

    private void dGs() {
        RelativeLayout relativeLayout = (RelativeLayout) this.hEa.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.mYE == null) {
                this.mYE = new AlbumVideoCompressingDialogView(this.hEa);
            }
            if (this.mYE.getParent() == null) {
                relativeLayout.addView(this.mYE);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mYE.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.mYE.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.mYE.setPercent(0);
        this.mYG = true;
    }

    private void wQ(boolean z) {
        VideoFileInfo Tc = Tc(this.mYD);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.mYD);
        videoInfo.setVideoDuration(Tc.videoDuration / 1000);
        videoInfo.setVideoWidth(Tc.videoWidth);
        videoInfo.setVideoHeight(Tc.videoHeight);
        videoInfo.setVideoLength(new File(Tc.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.hEa, this.iDT, this.mForumName, this.mForumId, this.mFg, videoInfo);
        editVideoActivityConfig.setProZone(this.mYH);
        editVideoActivityConfig.setFrsTabInfo(this.mXJ);
        editVideoActivityConfig.setFrom(this.mFrom);
        editVideoActivityConfig.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.mIA = false;
        this.mYD = null;
        if (this.mpU != null) {
            this.mpU.cUM();
        }
    }

    public static VideoFileInfo Tc(String str) {
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
    public void dES() {
    }

    @Override // com.baidu.tieba.video.d
    public void Jn(int i) {
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
                if (this.mYE != null && this.mYE.isShowing()) {
                    this.mYE.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.mIB) {
                    com.baidu.adp.lib.util.l.showToast(this.hEa, R.string.mv_local_video_compress_failed);
                    Ke(103);
                }
                this.mYG = false;
                this.mIA = false;
                dGt();
                break;
            case 3:
                this.mYG = false;
                this.mIA = true;
                if (!StringUtils.isNull(this.mYD) && (file = new File(this.mYD)) != null) {
                    this.mYD = this.mYD.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.mYD));
                }
                dGt();
                if (!this.mIz) {
                    wQ(true);
                    if (this.mpU != null) {
                        this.mpU.cUM();
                        break;
                    }
                }
                break;
            case 4:
                this.mYG = false;
                this.mIA = false;
                dGt();
                Ke(104);
                break;
            case 5:
                this.mYG = false;
                com.baidu.adp.lib.util.l.showToast(this.hEa, R.string.mv_local_video_compress_failed);
                if (this.mYF != null && this.mYF.isConvertRunning()) {
                    dGu();
                }
                Ke(105);
                break;
        }
        return true;
    }

    private void dGt() {
        RelativeLayout relativeLayout = (RelativeLayout) this.hEa.findViewById(R.id.parent);
        if (relativeLayout != null && this.mYE.getParent() != null) {
            relativeLayout.removeView(this.mYE);
        }
    }

    private void dGu() {
        if (this.mYF != null) {
            this.mYF.abortConvert();
        }
        this.mIB = true;
        if (this.mYD != null) {
            File file = new File(this.mYD);
            if (file.exists()) {
                file.delete();
            }
        }
        dGt();
        this.mYD = null;
    }

    public void onStart() {
        this.mIz = false;
    }

    public void onStop() {
        this.mIz = true;
    }

    public void onResume() {
        if (this.mIA && !TextUtils.isEmpty(this.mYD) && new File(this.mYD).exists()) {
            wQ(true);
            Ke(101);
        }
        if (this.mpU != null) {
            this.mpU.Nh("album");
        }
    }

    public void onDestroy() {
        if (this.mYF != null) {
            this.mYF.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.mpU != null) {
            this.mpU.Ni("album");
        }
        MessageManager.getInstance().unRegisterListener(this.mIJ);
    }

    private void Ke(int i) {
        if (this.mpU != null) {
            this.mpU.br(i, "album");
        }
    }

    public boolean dKl() {
        return this.mYG;
    }

    public void setProfessionZone(int i) {
        this.mYH = i;
    }
}
