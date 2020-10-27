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
    private BaseFragmentActivity ifx;
    private String jff;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private com.baidu.tieba.k.h mSh;
    private VideoFileInfo nAB;
    private String nAC;
    private AlbumVideoCompressingDialogView nAD;
    private VideoConvertUtil nAE;
    private boolean nAF;
    private String nht;
    private final CustomMessageListener nkQ;
    private FrsTabInfoData nzI;
    private boolean nkH = false;
    private boolean nkI = false;
    private boolean nkJ = false;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";
    private int nAG = -1;

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mSh = lVar.dbR();
        }
        if (this.mSh != null) {
            this.mSh.dbA();
        }
        this.nkQ = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    j.this.ifx.setResult(-1, intent);
                    j.this.ifx.finish();
                }
            }
        };
        this.ifx = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.nht = str3;
        this.nAE = new VideoConvertUtil(baseFragmentActivity);
        this.nAE.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.nkQ);
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.nzI = frsTabInfoData;
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.antiData = antiData;
        this.prefixData = postPrefixData;
        this.firstDir = str;
        this.secondDir = str2;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.nAB = videoFileInfo;
        this.jff = str;
        this.mFrom = str2;
        if (this.nAB != null && this.ifx != null) {
            if (this.nAB.videoDuration > 600000) {
                dNr();
            } else if (this.nAE == null || !this.nAE.isConvertRunning()) {
                String str3 = this.nAB.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    com.baidu.adp.lib.util.l.showToast(this.ifx, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    Lc(107);
                } else if (!new File(str3).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.ifx, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    Lc(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.nAB != null) {
                        this.nAC = this.nAB.videoPath;
                        xO(false);
                        Lc(102);
                    }
                } else if (VideoConvertUtil.To(str3) >= 1500000) {
                    if (VideoConvertUtil.dLR()) {
                        this.nAC = new File(VideoConvertUtil.nfW, "tieba_" + VideoConvertUtil.Tn(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.nAE.setConvertType(1);
                        this.nAE.gv(str3, this.nAC);
                        dNm();
                        this.nkI = false;
                        this.nkJ = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.nAB;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.nAC = new File(VideoConvertUtil.nfW, "tieba_" + VideoConvertUtil.Tn(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.nAE.setConvertType(2);
                            this.nAE.gv(str3, this.nAC);
                            dNm();
                            this.nkI = false;
                            this.nkJ = false;
                            return;
                        }
                        this.nAC = videoFileInfo2.videoPath;
                        xO(false);
                        Lc(102);
                    }
                }
            }
        }
    }

    private void dNr() {
        com.baidu.tbadk.core.dialog.a a2 = new com.baidu.tbadk.core.dialog.a(this.ifx).ol(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.j.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a2.b(this.ifx.getPageContext());
        a2.iN(false);
        a2.bmC();
    }

    private void dNm() {
        RelativeLayout relativeLayout = (RelativeLayout) this.ifx.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.nAD == null) {
                this.nAD = new AlbumVideoCompressingDialogView(this.ifx);
            }
            if (this.nAD.getParent() == null) {
                relativeLayout.addView(this.nAD);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nAD.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.nAD.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.nAD.setPercent(0);
        this.nAF = true;
    }

    private void xO(boolean z) {
        VideoFileInfo Up = Up(this.nAC);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nAC);
        videoInfo.setVideoDuration(Up.videoDuration / 1000);
        videoInfo.setVideoWidth(Up.videoWidth);
        videoInfo.setVideoHeight(Up.videoHeight);
        videoInfo.setVideoLength(new File(Up.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.ifx, this.jff, this.mForumName, this.mForumId, this.nht, videoInfo);
        editVideoActivityConfig.setProZone(this.nAG);
        editVideoActivityConfig.setFrsTabInfo(this.nzI);
        editVideoActivityConfig.setFrom(this.mFrom);
        editVideoActivityConfig.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.nkI = false;
        this.nAC = null;
        if (this.mSh != null) {
            this.mSh.dbD();
        }
    }

    public static VideoFileInfo Up(String str) {
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
    public void dLM() {
    }

    @Override // com.baidu.tieba.video.d
    public void Kl(int i) {
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
                if (this.nAD != null && this.nAD.isShowing()) {
                    this.nAD.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.nkJ) {
                    com.baidu.adp.lib.util.l.showToast(this.ifx, R.string.mv_local_video_compress_failed);
                    Lc(103);
                }
                this.nAF = false;
                this.nkI = false;
                dNn();
                break;
            case 3:
                this.nAF = false;
                this.nkI = true;
                if (!StringUtils.isNull(this.nAC) && (file = new File(this.nAC)) != null) {
                    this.nAC = this.nAC.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.nAC));
                }
                dNn();
                if (!this.nkH) {
                    xO(true);
                    if (this.mSh != null) {
                        this.mSh.dbD();
                        break;
                    }
                }
                break;
            case 4:
                this.nAF = false;
                this.nkI = false;
                dNn();
                Lc(104);
                break;
            case 5:
                this.nAF = false;
                com.baidu.adp.lib.util.l.showToast(this.ifx, R.string.mv_local_video_compress_failed);
                if (this.nAE != null && this.nAE.isConvertRunning()) {
                    dNo();
                }
                Lc(105);
                break;
        }
        return true;
    }

    private void dNn() {
        RelativeLayout relativeLayout = (RelativeLayout) this.ifx.findViewById(R.id.parent);
        if (relativeLayout != null && this.nAD.getParent() != null) {
            relativeLayout.removeView(this.nAD);
        }
    }

    private void dNo() {
        if (this.nAE != null) {
            this.nAE.abortConvert();
        }
        this.nkJ = true;
        if (this.nAC != null) {
            File file = new File(this.nAC);
            if (file.exists()) {
                file.delete();
            }
        }
        dNn();
        this.nAC = null;
    }

    public void onStart() {
        this.nkH = false;
    }

    public void onStop() {
        this.nkH = true;
    }

    public void onResume() {
        if (this.nkI && !TextUtils.isEmpty(this.nAC) && new File(this.nAC).exists()) {
            xO(true);
            Lc(101);
        }
        if (this.mSh != null) {
            this.mSh.Ou("album");
        }
    }

    public void onDestroy() {
        if (this.nAE != null) {
            this.nAE.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.mSh != null) {
            this.mSh.Ov("album");
        }
        MessageManager.getInstance().unRegisterListener(this.nkQ);
    }

    private void Lc(int i) {
        if (this.mSh != null) {
            this.mSh.bC(i, "album");
        }
    }

    public boolean dRf() {
        return this.nAF;
    }

    public void setProfessionZone(int i) {
        this.nAG = i;
    }
}
