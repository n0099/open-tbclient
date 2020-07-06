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
/* loaded from: classes2.dex */
public class j implements Handler.Callback, com.baidu.tieba.video.e {
    private BaseFragmentActivity hep;
    private String ici;
    private com.baidu.tieba.k.h lHf;
    private String lVZ;
    private final CustomMessageListener lZy;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private VideoFileInfo mnY;
    private String mnZ;
    private FrsTabInfoData mne;
    private AlbumVideoCompressingDialogView moa;
    private VideoConvertUtil mob;
    private boolean moc;
    private boolean lZp = false;
    private boolean lZq = false;
    private boolean lZr = false;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";
    private int mod = -1;

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.lHf = lVar.cCQ();
        }
        if (this.lHf != null) {
            this.lHf.cCs();
        }
        this.lZy = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    j.this.hep.setResult(-1, intent);
                    j.this.hep.finish();
                }
            }
        };
        this.hep = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.lVZ = str3;
        this.mob = new VideoConvertUtil(baseFragmentActivity);
        this.mob.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.lZy);
    }

    public void a(FrsTabInfoData frsTabInfoData) {
        this.mne = frsTabInfoData;
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.antiData = antiData;
        this.prefixData = postPrefixData;
        this.firstDir = str;
        this.secondDir = str2;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.mnY = videoFileInfo;
        this.ici = str;
        this.mFrom = str2;
        if (this.mnY != null && this.hep != null) {
            if (this.mnY.videoDuration > 600000) {
                dnP();
            } else if (this.mob == null || !this.mob.isConvertRunning()) {
                String str3 = this.mnY.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    com.baidu.adp.lib.util.l.showToast(this.hep, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    GI(107);
                } else if (!new File(str3).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.hep, (int) R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    GI(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.mnY != null) {
                        this.mnZ = this.mnY.videoPath;
                        vm(false);
                        GI(102);
                    }
                } else if (VideoConvertUtil.NV(str3) >= 1500000) {
                    if (VideoConvertUtil.dmn()) {
                        this.mnZ = new File(VideoConvertUtil.lUC, "tieba_" + VideoConvertUtil.NU(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.mob.setConvertType(1);
                        this.mob.fD(str3, this.mnZ);
                        dnK();
                        this.lZq = false;
                        this.lZr = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.mnY;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.mnZ = new File(VideoConvertUtil.lUC, "tieba_" + VideoConvertUtil.NU(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.mob.setConvertType(2);
                            this.mob.fD(str3, this.mnZ);
                            dnK();
                            this.lZq = false;
                            this.lZr = false;
                            return;
                        }
                        this.mnZ = videoFileInfo2.videoPath;
                        vm(false);
                        GI(102);
                    }
                }
            }
        }
    }

    private void dnP() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hep).kS(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.j.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hep.getPageContext());
        a.hg(false);
        a.aUN();
    }

    private void dnK() {
        RelativeLayout relativeLayout = (RelativeLayout) this.hep.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.moa == null) {
                this.moa = new AlbumVideoCompressingDialogView(this.hep);
            }
            if (this.moa.getParent() == null) {
                relativeLayout.addView(this.moa);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.moa.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.moa.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.moa.setPercent(0);
        this.moc = true;
    }

    private void vm(boolean z) {
        VideoFileInfo OT = OT(this.mnZ);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.mnZ);
        videoInfo.setVideoDuration(OT.videoDuration / 1000);
        videoInfo.setVideoWidth(OT.videoWidth);
        videoInfo.setVideoHeight(OT.videoHeight);
        videoInfo.setVideoLength(new File(OT.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.hep, this.ici, this.mForumName, this.mForumId, this.lVZ, videoInfo);
        editVideoActivityConfig.setProZone(this.mod);
        editVideoActivityConfig.setFrsTabInfo(this.mne);
        editVideoActivityConfig.setFrom(this.mFrom);
        editVideoActivityConfig.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.lZq = false;
        this.mnZ = null;
        if (this.lHf != null) {
            this.lHf.cCv();
        }
    }

    public static VideoFileInfo OT(String str) {
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

    @Override // com.baidu.tieba.video.e
    public void dmj() {
    }

    @Override // com.baidu.tieba.video.e
    public void FR(int i) {
        this.mMainThreadHandler.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.e
    public void onConvertSuccess() {
        this.mMainThreadHandler.sendEmptyMessage(3);
    }

    @Override // com.baidu.tieba.video.e
    public void onConvertFailed() {
        this.mMainThreadHandler.sendEmptyMessage(2);
    }

    @Override // com.baidu.tieba.video.e
    public void onConvertProgress(int i) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        this.mMainThreadHandler.sendMessage(obtain);
    }

    @Override // com.baidu.tieba.video.e
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
                if (this.moa != null && this.moa.isShowing()) {
                    this.moa.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.lZr) {
                    com.baidu.adp.lib.util.l.showToast(this.hep, (int) R.string.mv_local_video_compress_failed);
                    GI(103);
                }
                this.moc = false;
                this.lZq = false;
                dnL();
                break;
            case 3:
                this.moc = false;
                this.lZq = true;
                if (!StringUtils.isNull(this.mnZ) && (file = new File(this.mnZ)) != null) {
                    this.mnZ = this.mnZ.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.mnZ));
                }
                dnL();
                if (!this.lZp) {
                    vm(true);
                    if (this.lHf != null) {
                        this.lHf.cCv();
                        break;
                    }
                }
                break;
            case 4:
                this.moc = false;
                this.lZq = false;
                dnL();
                GI(104);
                break;
            case 5:
                this.moc = false;
                com.baidu.adp.lib.util.l.showToast(this.hep, (int) R.string.mv_local_video_compress_failed);
                if (this.mob != null && this.mob.isConvertRunning()) {
                    dnM();
                }
                GI(105);
                break;
        }
        return true;
    }

    private void dnL() {
        RelativeLayout relativeLayout = (RelativeLayout) this.hep.findViewById(R.id.parent);
        if (relativeLayout != null && this.moa.getParent() != null) {
            relativeLayout.removeView(this.moa);
        }
    }

    private void dnM() {
        if (this.mob != null) {
            this.mob.abortConvert();
        }
        this.lZr = true;
        if (this.mnZ != null) {
            File file = new File(this.mnZ);
            if (file.exists()) {
                file.delete();
            }
        }
        dnL();
        this.mnZ = null;
    }

    public void onStart() {
        this.lZp = false;
    }

    public void onStop() {
        this.lZp = true;
    }

    public void onResume() {
        if (this.lZq && !TextUtils.isEmpty(this.mnZ) && new File(this.mnZ).exists()) {
            vm(true);
            GI(101);
        }
        if (this.lHf != null) {
            this.lHf.IX("album");
        }
    }

    public void onDestroy() {
        if (this.mob != null) {
            this.mob.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.lHf != null) {
            this.lHf.IY("album");
        }
        MessageManager.getInstance().unRegisterListener(this.lZy);
    }

    private void GI(int i) {
        if (this.lHf != null) {
            this.lHf.bo(i, "album");
        }
    }

    public boolean drz() {
        return this.moc;
    }

    public void setProfessionZone(int i) {
        this.mod = i;
    }
}
