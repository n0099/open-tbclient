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
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.write.video.AlbumVideoCompressingDialogView;
import java.io.File;
/* loaded from: classes2.dex */
public class i implements Handler.Callback, com.baidu.tieba.video.d {
    private BaseFragmentActivity gCM;
    private String hzw;
    private com.baidu.tieba.k.h kTM;
    private String liw;
    private final CustomMessageListener llO;
    private FrsTabInfoData lyc;
    private VideoFileInfo lze;
    private String lzf;
    private AlbumVideoCompressingDialogView lzg;
    private VideoConvertUtil lzh;
    private boolean lzi;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private boolean llF = false;
    private boolean llG = false;
    private boolean llH = false;
    private int lzj = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.kTM = lVar.crY();
        }
        if (this.kTM != null) {
            this.kTM.crA();
        }
        this.llO = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    intent.putExtra(PostWriteCallBackData.GENERAL_TAB_ID, ((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId());
                    i.this.gCM.setResult(-1, intent);
                    i.this.gCM.finish();
                }
            }
        };
        this.gCM = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.liw = str3;
        this.lzh = new VideoConvertUtil(baseFragmentActivity);
        this.lzh.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.llO);
    }

    public void a(FrsTabInfoData frsTabInfoData) {
        this.lyc = frsTabInfoData;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.lze = videoFileInfo;
        this.hzw = str;
        this.mFrom = str2;
        if (this.lze != null && this.gCM != null) {
            if (this.lze.videoDuration > 600000) {
                dbW();
            } else if (this.lzh == null || !this.lzh.isConvertRunning()) {
                String str3 = this.lze.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    com.baidu.adp.lib.util.l.showToast(this.gCM, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    EP(107);
                } else if (!new File(str3).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.gCM, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    EP(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.lze != null) {
                        this.lzf = this.lze.videoPath;
                        uw(false);
                        EP(102);
                    }
                } else if (VideoConvertUtil.LF(str3) >= 1500000) {
                    if (VideoConvertUtil.dav()) {
                        this.lzf = new File(VideoConvertUtil.lgZ, "tieba_" + VideoConvertUtil.LE(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.lzh.setConvertType(1);
                        this.lzh.eV(str3, this.lzf);
                        dbR();
                        this.llG = false;
                        this.llH = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.lze;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.lzf = new File(VideoConvertUtil.lgZ, "tieba_" + VideoConvertUtil.LE(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.lzh.setConvertType(2);
                            this.lzh.eV(str3, this.lzf);
                            dbR();
                            this.llG = false;
                            this.llH = false;
                            return;
                        }
                        this.lzf = videoFileInfo2.videoPath;
                        uw(false);
                        EP(102);
                    }
                }
            }
        }
    }

    private void dbW() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.gCM).kc(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.gCM.getPageContext());
        a.gF(false);
        a.aMS();
    }

    private void dbR() {
        RelativeLayout relativeLayout = (RelativeLayout) this.gCM.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.lzg == null) {
                this.lzg = new AlbumVideoCompressingDialogView(this.gCM);
            }
            if (this.lzg.getParent() == null) {
                relativeLayout.addView(this.lzg);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lzg.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.lzg.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.lzg.setPercent(0);
        this.lzi = true;
    }

    private void uw(boolean z) {
        VideoFileInfo Mx = Mx(this.lzf);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.lzf);
        videoInfo.setVideoDuration(Mx.videoDuration / 1000);
        videoInfo.setVideoWidth(Mx.videoWidth);
        videoInfo.setVideoHeight(Mx.videoHeight);
        videoInfo.setVideoLength(new File(Mx.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.gCM, this.hzw, this.mForumName, this.mForumId, this.liw, videoInfo);
        editVideoActivityConfig.setProZone(this.lzj);
        editVideoActivityConfig.setFrsTabInfo(this.lyc);
        editVideoActivityConfig.setFrom(this.mFrom);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.llG = false;
        this.lzf = null;
        if (this.kTM != null) {
            this.kTM.crD();
        }
    }

    public static VideoFileInfo Mx(String str) {
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
    public void dar() {
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
                if (this.lzg != null && this.lzg.isShowing()) {
                    this.lzg.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.llH) {
                    com.baidu.adp.lib.util.l.showToast(this.gCM, (int) R.string.mv_local_video_compress_failed);
                    EP(103);
                }
                this.lzi = false;
                this.llG = false;
                dbS();
                break;
            case 3:
                this.lzi = false;
                this.llG = true;
                if (!StringUtils.isNull(this.lzf) && (file = new File(this.lzf)) != null) {
                    this.lzf = this.lzf.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.lzf));
                }
                dbS();
                if (!this.llF) {
                    uw(true);
                    if (this.kTM != null) {
                        this.kTM.crD();
                        break;
                    }
                }
                break;
            case 4:
                this.lzi = false;
                this.llG = false;
                dbS();
                EP(104);
                break;
            case 5:
                this.lzi = false;
                com.baidu.adp.lib.util.l.showToast(this.gCM, (int) R.string.mv_local_video_compress_failed);
                if (this.lzh != null && this.lzh.isConvertRunning()) {
                    dbT();
                }
                EP(105);
                break;
        }
        return true;
    }

    private void dbS() {
        RelativeLayout relativeLayout = (RelativeLayout) this.gCM.findViewById(R.id.parent);
        if (relativeLayout != null && this.lzg.getParent() != null) {
            relativeLayout.removeView(this.lzg);
        }
    }

    private void dbT() {
        if (this.lzh != null) {
            this.lzh.abortConvert();
        }
        this.llH = true;
        if (this.lzf != null) {
            File file = new File(this.lzf);
            if (file.exists()) {
                file.delete();
            }
        }
        dbS();
        this.lzf = null;
    }

    public void onStart() {
        this.llF = false;
    }

    public void onStop() {
        this.llF = true;
    }

    public void onResume() {
        if (this.llG && !TextUtils.isEmpty(this.lzf) && new File(this.lzf).exists()) {
            uw(true);
            EP(101);
        }
        if (this.kTM != null) {
            this.kTM.GL("album");
        }
    }

    public void onDestroy() {
        if (this.lzh != null) {
            this.lzh.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.kTM != null) {
            this.kTM.GM("album");
        }
        MessageManager.getInstance().unRegisterListener(this.llO);
    }

    private void EP(int i) {
        if (this.kTM != null) {
            this.kTM.bf(i, "album");
        }
    }

    public boolean dfA() {
        return this.lzi;
    }

    public void setProfessionZone(int i) {
        this.lzj = i;
    }
}
