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
    private BaseFragmentActivity iKt;
    private String jMP;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private String nLN;
    private com.baidu.tieba.l.g nxU;
    private FrsTabInfoData oeh;
    private VideoFileInfo ofb;
    private String ofc;
    private AlbumVideoCompressingDialogView ofh;
    private VideoConvertUtil ofi;
    private boolean ofj;
    private final CustomMessageListener ofl;
    private int statisticFrom;
    private boolean ofd = false;
    private boolean ofe = false;
    private boolean ofg = false;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";
    private int ofk = -1;

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.nxU = kVar.dgY();
        }
        if (this.nxU != null) {
            this.nxU.dgH();
        }
        this.ofl = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    j.this.iKt.setResult(-1, intent);
                    j.this.iKt.finish();
                }
            }
        };
        this.iKt = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.nLN = str3;
        this.ofi = new VideoConvertUtil(baseFragmentActivity);
        this.ofi.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.ofl);
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.oeh = frsTabInfoData;
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.antiData = antiData;
        this.prefixData = postPrefixData;
        this.firstDir = str;
        this.secondDir = str2;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.ofb = videoFileInfo;
        this.jMP = str;
        this.mFrom = str2;
        if (this.ofb != null && this.iKt != null) {
            if (this.ofb.videoDuration > 600000) {
                dWZ();
            } else if (this.ofi == null || !this.ofi.isConvertRunning()) {
                String str3 = this.ofb.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    l.showToast(this.iKt, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    Ll(107);
                } else if (!new File(str3).exists()) {
                    l.showToast(this.iKt, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    Ll(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.ofb != null) {
                        this.ofc = this.ofb.videoPath;
                        zD(false);
                        Ll(102);
                    }
                } else if (VideoConvertUtil.Ub(str3) >= 1500000) {
                    if (VideoConvertUtil.dRW()) {
                        this.ofc = new File(VideoConvertUtil.nKy, "tieba_" + VideoConvertUtil.Ua(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.ofi.setConvertType(1);
                        this.ofi.gC(str3, this.ofc);
                        dXa();
                        this.ofe = false;
                        this.ofg = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.ofb;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.ofc = new File(VideoConvertUtil.nKy, "tieba_" + VideoConvertUtil.Ua(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.ofi.setConvertType(2);
                            this.ofi.gC(str3, this.ofc);
                            dXa();
                            this.ofe = false;
                            this.ofg = false;
                            return;
                        }
                        this.ofc = videoFileInfo2.videoPath;
                        zD(false);
                        Ll(102);
                    }
                }
            }
        }
    }

    private void dWZ() {
        com.baidu.tbadk.core.dialog.a a2 = new com.baidu.tbadk.core.dialog.a(this.iKt).nw(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.j.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a2.b(this.iKt.getPageContext());
        a2.jG(false);
        a2.bqx();
    }

    private void dXa() {
        RelativeLayout relativeLayout = (RelativeLayout) this.iKt.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.ofh == null) {
                this.ofh = new AlbumVideoCompressingDialogView(this.iKt);
            }
            if (this.ofh.getParent() == null) {
                relativeLayout.addView(this.ofh);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ofh.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.ofh.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.ofh.setPercent(0);
        this.ofj = true;
    }

    private void zD(boolean z) {
        VideoFileInfo Vb = Vb(this.ofc);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.ofc);
        videoInfo.setVideoDuration(Vb.videoDuration / 1000);
        videoInfo.setVideoWidth(Vb.videoWidth);
        videoInfo.setVideoHeight(Vb.videoHeight);
        videoInfo.setVideoLength(new File(Vb.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.iKt, this.jMP, this.mForumName, this.mForumId, this.nLN, videoInfo);
        editVideoActivityConfig.setProZone(this.ofk);
        editVideoActivityConfig.setStatisticFrom(this.statisticFrom);
        editVideoActivityConfig.setFrsTabInfo(this.oeh);
        editVideoActivityConfig.setFrom(this.mFrom);
        editVideoActivityConfig.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.ofe = false;
        this.ofc = null;
        if (this.nxU != null) {
            this.nxU.dgK();
        }
    }

    public static VideoFileInfo Vb(String str) {
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
    public void dRR() {
    }

    @Override // com.baidu.tieba.video.d
    public void Ku(int i) {
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
                if (this.ofh != null && this.ofh.isShowing()) {
                    this.ofh.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), AppStatusRules.DEFAULT_GRANULARITY);
                break;
            case 2:
                if (!this.ofg) {
                    l.showToast(this.iKt, R.string.mv_local_video_compress_failed);
                    Ll(103);
                }
                this.ofj = false;
                this.ofe = false;
                dXb();
                break;
            case 3:
                this.ofj = false;
                this.ofe = true;
                if (!StringUtils.isNull(this.ofc) && (file = new File(this.ofc)) != null) {
                    this.ofc = this.ofc.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.ofc));
                }
                dXb();
                if (!this.ofd) {
                    zD(true);
                    if (this.nxU != null) {
                        this.nxU.dgK();
                        break;
                    }
                }
                break;
            case 4:
                this.ofj = false;
                this.ofe = false;
                dXb();
                Ll(104);
                break;
            case 5:
                this.ofj = false;
                l.showToast(this.iKt, R.string.mv_local_video_compress_failed);
                if (this.ofi != null && this.ofi.isConvertRunning()) {
                    dXc();
                }
                Ll(105);
                break;
        }
        return true;
    }

    private void dXb() {
        RelativeLayout relativeLayout = (RelativeLayout) this.iKt.findViewById(R.id.parent);
        if (relativeLayout != null && this.ofh.getParent() != null) {
            relativeLayout.removeView(this.ofh);
        }
    }

    private void dXc() {
        if (this.ofi != null) {
            this.ofi.abortConvert();
        }
        this.ofg = true;
        if (this.ofc != null) {
            File file = new File(this.ofc);
            if (file.exists()) {
                file.delete();
            }
        }
        dXb();
        this.ofc = null;
    }

    public void onStart() {
        this.ofd = false;
    }

    public void onStop() {
        this.ofd = true;
    }

    public void onResume() {
        if (this.ofe && !TextUtils.isEmpty(this.ofc) && new File(this.ofc).exists()) {
            zD(true);
            Ll(101);
        }
        if (this.nxU != null) {
            this.nxU.OC("album");
        }
    }

    public void onDestroy() {
        if (this.ofi != null) {
            this.ofi.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.nxU != null) {
            this.nxU.OD("album");
        }
        MessageManager.getInstance().unRegisterListener(this.ofl);
    }

    private void Ll(int i) {
        if (this.nxU != null) {
            this.nxU.bL(i, "album");
        }
    }

    public boolean dXd() {
        return this.ofj;
    }

    public void setProfessionZone(int i) {
        this.ofk = i;
    }

    public void setStatisticFrom(int i) {
        this.statisticFrom = i;
    }
}
