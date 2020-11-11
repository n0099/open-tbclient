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
    private BaseFragmentActivity ilu;
    private String jld;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private com.baidu.tieba.k.h mYk;
    private FrsTabInfoData nFC;
    private VideoFileInfo nGv;
    private String nGw;
    private AlbumVideoCompressingDialogView nGx;
    private VideoConvertUtil nGy;
    private boolean nGz;
    private String nnp;
    private final CustomMessageListener nqN;
    private boolean nqE = false;
    private boolean nqF = false;
    private boolean nqG = false;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";
    private int nGA = -1;

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mYk = lVar.det();
        }
        if (this.mYk != null) {
            this.mYk.dec();
        }
        this.nqN = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    j.this.ilu.setResult(-1, intent);
                    j.this.ilu.finish();
                }
            }
        };
        this.ilu = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.nnp = str3;
        this.nGy = new VideoConvertUtil(baseFragmentActivity);
        this.nGy.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.nqN);
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.nFC = frsTabInfoData;
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.antiData = antiData;
        this.prefixData = postPrefixData;
        this.firstDir = str;
        this.secondDir = str2;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.nGv = videoFileInfo;
        this.jld = str;
        this.mFrom = str2;
        if (this.nGv != null && this.ilu != null) {
            if (this.nGv.videoDuration > 600000) {
                dPT();
            } else if (this.nGy == null || !this.nGy.isConvertRunning()) {
                String str3 = this.nGv.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    com.baidu.adp.lib.util.l.showToast(this.ilu, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    Lp(107);
                } else if (!new File(str3).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.ilu, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    Lp(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.nGv != null) {
                        this.nGw = this.nGv.videoPath;
                        xX(false);
                        Lp(102);
                    }
                } else if (VideoConvertUtil.TF(str3) >= 1500000) {
                    if (VideoConvertUtil.dOt()) {
                        this.nGw = new File(VideoConvertUtil.nlS, "tieba_" + VideoConvertUtil.TE(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.nGy.setConvertType(1);
                        this.nGy.gv(str3, this.nGw);
                        dPO();
                        this.nqF = false;
                        this.nqG = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.nGv;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.nGw = new File(VideoConvertUtil.nlS, "tieba_" + VideoConvertUtil.TE(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.nGy.setConvertType(2);
                            this.nGy.gv(str3, this.nGw);
                            dPO();
                            this.nqF = false;
                            this.nqG = false;
                            return;
                        }
                        this.nGw = videoFileInfo2.videoPath;
                        xX(false);
                        Lp(102);
                    }
                }
            }
        }
    }

    private void dPT() {
        com.baidu.tbadk.core.dialog.a a2 = new com.baidu.tbadk.core.dialog.a(this.ilu).ov(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.j.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a2.b(this.ilu.getPageContext());
        a2.iW(false);
        a2.bpc();
    }

    private void dPO() {
        RelativeLayout relativeLayout = (RelativeLayout) this.ilu.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.nGx == null) {
                this.nGx = new AlbumVideoCompressingDialogView(this.ilu);
            }
            if (this.nGx.getParent() == null) {
                relativeLayout.addView(this.nGx);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nGx.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.nGx.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.nGx.setPercent(0);
        this.nGz = true;
    }

    private void xX(boolean z) {
        VideoFileInfo UG = UG(this.nGw);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nGw);
        videoInfo.setVideoDuration(UG.videoDuration / 1000);
        videoInfo.setVideoWidth(UG.videoWidth);
        videoInfo.setVideoHeight(UG.videoHeight);
        videoInfo.setVideoLength(new File(UG.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.ilu, this.jld, this.mForumName, this.mForumId, this.nnp, videoInfo);
        editVideoActivityConfig.setProZone(this.nGA);
        editVideoActivityConfig.setFrsTabInfo(this.nFC);
        editVideoActivityConfig.setFrom(this.mFrom);
        editVideoActivityConfig.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.nqF = false;
        this.nGw = null;
        if (this.mYk != null) {
            this.mYk.def();
        }
    }

    public static VideoFileInfo UG(String str) {
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
    public void dOo() {
    }

    @Override // com.baidu.tieba.video.d
    public void Ky(int i) {
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
                if (this.nGx != null && this.nGx.isShowing()) {
                    this.nGx.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.nqG) {
                    com.baidu.adp.lib.util.l.showToast(this.ilu, R.string.mv_local_video_compress_failed);
                    Lp(103);
                }
                this.nGz = false;
                this.nqF = false;
                dPP();
                break;
            case 3:
                this.nGz = false;
                this.nqF = true;
                if (!StringUtils.isNull(this.nGw) && (file = new File(this.nGw)) != null) {
                    this.nGw = this.nGw.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.nGw));
                }
                dPP();
                if (!this.nqE) {
                    xX(true);
                    if (this.mYk != null) {
                        this.mYk.def();
                        break;
                    }
                }
                break;
            case 4:
                this.nGz = false;
                this.nqF = false;
                dPP();
                Lp(104);
                break;
            case 5:
                this.nGz = false;
                com.baidu.adp.lib.util.l.showToast(this.ilu, R.string.mv_local_video_compress_failed);
                if (this.nGy != null && this.nGy.isConvertRunning()) {
                    dPQ();
                }
                Lp(105);
                break;
        }
        return true;
    }

    private void dPP() {
        RelativeLayout relativeLayout = (RelativeLayout) this.ilu.findViewById(R.id.parent);
        if (relativeLayout != null && this.nGx.getParent() != null) {
            relativeLayout.removeView(this.nGx);
        }
    }

    private void dPQ() {
        if (this.nGy != null) {
            this.nGy.abortConvert();
        }
        this.nqG = true;
        if (this.nGw != null) {
            File file = new File(this.nGw);
            if (file.exists()) {
                file.delete();
            }
        }
        dPP();
        this.nGw = null;
    }

    public void onStart() {
        this.nqE = false;
    }

    public void onStop() {
        this.nqE = true;
    }

    public void onResume() {
        if (this.nqF && !TextUtils.isEmpty(this.nGw) && new File(this.nGw).exists()) {
            xX(true);
            Lp(101);
        }
        if (this.mYk != null) {
            this.mYk.OL("album");
        }
    }

    public void onDestroy() {
        if (this.nGy != null) {
            this.nGy.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.mYk != null) {
            this.mYk.OM("album");
        }
        MessageManager.getInstance().unRegisterListener(this.nqN);
    }

    private void Lp(int i) {
        if (this.mYk != null) {
            this.mYk.bG(i, "album");
        }
    }

    public boolean dTF() {
        return this.nGz;
    }

    public void setProfessionZone(int i) {
        this.nGA = i;
    }
}
