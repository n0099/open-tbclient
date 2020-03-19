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
/* loaded from: classes13.dex */
public class i implements Handler.Callback, com.baidu.tieba.video.d {
    private String gPr;
    private BaseFragmentActivity gsB;
    private final CustomMessageListener kBr;
    private FrsTabInfoData kOH;
    private VideoFileInfo kPI;
    private String kPJ;
    private AlbumVideoCompressingDialogView kPK;
    private VideoConvertUtil kPL;
    private boolean kPM;
    private com.baidu.tieba.k.h kjC;
    private String kyd;
    private String mForumId;
    private String mForumName;
    private Handler mMainThreadHandler;
    private boolean kBi = false;
    private boolean kBj = false;
    private boolean kBk = false;
    private int kPN = -1;

    public i(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.kjC = lVar.cht();
        }
        if (this.kjC != null) {
            this.kjC.cgV();
        }
        this.kBr = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    intent.putExtra(PostWriteCallBackData.GENERAL_TAB_ID, ((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId());
                    i.this.gsB.setResult(-1, intent);
                    i.this.gsB.finish();
                }
            }
        };
        this.gsB = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.kyd = str3;
        this.kPL = new VideoConvertUtil(baseFragmentActivity);
        this.kPL.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.kBr);
    }

    public void a(FrsTabInfoData frsTabInfoData) {
        this.kOH = frsTabInfoData;
    }

    public void a(VideoFileInfo videoFileInfo, String str) {
        this.kPI = videoFileInfo;
        this.gPr = str;
        if (this.kPI != null && this.gsB != null) {
            if (this.kPI.videoDuration > KeepJobService.JOB_CHECK_PERIODIC) {
                cRb();
            } else if (this.kPL == null || !this.kPL.isConvertRunning()) {
                String str2 = this.kPI.videoPath;
                if (TextUtils.isEmpty(str2)) {
                    com.baidu.adp.lib.util.l.showToast(this.gsB, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    Eo(107);
                } else if (!new File(str2).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.gsB, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str2));
                    Eo(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.kPI != null) {
                        this.kPJ = this.kPI.videoPath;
                        tv(false);
                        Eo(102);
                    }
                } else if (VideoConvertUtil.JT(str2) >= 1500000) {
                    if (VideoConvertUtil.cPB()) {
                        this.kPJ = new File(VideoConvertUtil.kwI, "tieba_" + VideoConvertUtil.JS(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.kPL.setConvertType(1);
                        this.kPL.eG(str2, this.kPJ);
                        cQW();
                        this.kBj = false;
                        this.kBk = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.kPI;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.kPJ = new File(VideoConvertUtil.kwI, "tieba_" + VideoConvertUtil.JS(str2) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.kPL.setConvertType(2);
                            this.kPL.eG(str2, this.kPJ);
                            cQW();
                            this.kBj = false;
                            this.kBk = false;
                            return;
                        }
                        this.kPJ = videoFileInfo2.videoPath;
                        tv(false);
                        Eo(102);
                    }
                }
            }
        }
    }

    private void cRb() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.gsB).jV(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.i.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.gsB.getPageContext());
        a.fI(false);
        a.aEG();
    }

    private void cQW() {
        RelativeLayout relativeLayout = (RelativeLayout) this.gsB.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.kPK == null) {
                this.kPK = new AlbumVideoCompressingDialogView(this.gsB);
            }
            if (this.kPK.getParent() == null) {
                relativeLayout.addView(this.kPK);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kPK.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.kPK.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.kPK.setPercent(0);
        this.kPM = true;
    }

    private void tv(boolean z) {
        VideoFileInfo KQ = KQ(this.kPJ);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kPJ);
        videoInfo.setVideoDuration(KQ.videoDuration / 1000);
        videoInfo.setVideoWidth(KQ.videoWidth);
        videoInfo.setVideoHeight(KQ.videoHeight);
        videoInfo.setVideoLength(new File(KQ.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.gsB, this.gPr, this.mForumName, this.mForumId, this.kyd, videoInfo);
        editVideoActivityConfig.setProZone(this.kPN);
        editVideoActivityConfig.setFrsTabInfo(this.kOH);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.kBj = false;
        this.kPJ = null;
        if (this.kjC != null) {
            this.kjC.cgY();
        }
    }

    public static VideoFileInfo KQ(String str) {
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
    public void cPx() {
    }

    @Override // com.baidu.tieba.video.d
    public void Dy(int i) {
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
                if (this.kPK != null && this.kPK.isShowing()) {
                    this.kPK.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.kBk) {
                    com.baidu.adp.lib.util.l.showToast(this.gsB, (int) R.string.mv_local_video_compress_failed);
                    Eo(103);
                }
                this.kPM = false;
                this.kBj = false;
                cQX();
                break;
            case 3:
                this.kPM = false;
                this.kBj = true;
                if (!StringUtils.isNull(this.kPJ) && (file = new File(this.kPJ)) != null) {
                    this.kPJ = this.kPJ.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.kPJ));
                }
                cQX();
                if (!this.kBi) {
                    tv(true);
                    if (this.kjC != null) {
                        this.kjC.cgY();
                        break;
                    }
                }
                break;
            case 4:
                this.kPM = false;
                this.kBj = false;
                cQX();
                Eo(104);
                break;
            case 5:
                this.kPM = false;
                com.baidu.adp.lib.util.l.showToast(this.gsB, (int) R.string.mv_local_video_compress_failed);
                if (this.kPL != null && this.kPL.isConvertRunning()) {
                    cQY();
                }
                Eo(105);
                break;
        }
        return true;
    }

    private void cQX() {
        RelativeLayout relativeLayout = (RelativeLayout) this.gsB.findViewById(R.id.parent);
        if (relativeLayout != null && this.kPK.getParent() != null) {
            relativeLayout.removeView(this.kPK);
        }
    }

    private void cQY() {
        if (this.kPL != null) {
            this.kPL.abortConvert();
        }
        this.kBk = true;
        if (this.kPJ != null) {
            File file = new File(this.kPJ);
            if (file.exists()) {
                file.delete();
            }
        }
        cQX();
        this.kPJ = null;
    }

    public void onStart() {
        this.kBi = false;
    }

    public void onStop() {
        this.kBi = true;
    }

    public void onResume() {
        if (this.kBj && !TextUtils.isEmpty(this.kPJ) && new File(this.kPJ).exists()) {
            tv(true);
            Eo(101);
        }
        if (this.kjC != null) {
            this.kjC.Fb("album");
        }
    }

    public void onDestroy() {
        if (this.kPL != null) {
            this.kPL.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.kjC != null) {
            this.kjC.Fc("album");
        }
        MessageManager.getInstance().unRegisterListener(this.kBr);
    }

    private void Eo(int i) {
        if (this.kjC != null) {
            this.kjC.aQ(i, "album");
        }
    }

    public boolean cVg() {
        return this.kPM;
    }

    public void setProfessionZone(int i) {
        this.kPN = i;
    }
}
