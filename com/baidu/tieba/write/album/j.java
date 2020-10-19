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
    private BaseFragmentActivity hSW;
    private String iSJ;
    private com.baidu.tieba.k.h mFB;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private String mUT;
    private final CustomMessageListener mYq;
    private FrsTabInfoData nnh;
    private VideoFileInfo noa;
    private String nob;
    private AlbumVideoCompressingDialogView noc;
    private VideoConvertUtil nod;
    private boolean noe;
    private boolean mYh = false;
    private boolean mYi = false;
    private boolean mYj = false;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";
    private int nof = -1;

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mFB = lVar.cYJ();
        }
        if (this.mFB != null) {
            this.mFB.cYs();
        }
        this.mYq = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    j.this.hSW.setResult(-1, intent);
                    j.this.hSW.finish();
                }
            }
        };
        this.hSW = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.mUT = str3;
        this.nod = new VideoConvertUtil(baseFragmentActivity);
        this.nod.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.mYq);
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.nnh = frsTabInfoData;
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.antiData = antiData;
        this.prefixData = postPrefixData;
        this.firstDir = str;
        this.secondDir = str2;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.noa = videoFileInfo;
        this.iSJ = str;
        this.mFrom = str2;
        if (this.noa != null && this.hSW != null) {
            if (this.noa.videoDuration > 600000) {
                dKj();
            } else if (this.nod == null || !this.nod.isConvertRunning()) {
                String str3 = this.noa.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    com.baidu.adp.lib.util.l.showToast(this.hSW, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    KK(107);
                } else if (!new File(str3).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.hSW, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    KK(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.noa != null) {
                        this.nob = this.noa.videoPath;
                        xx(false);
                        KK(102);
                    }
                } else if (VideoConvertUtil.SP(str3) >= 1500000) {
                    if (VideoConvertUtil.dIJ()) {
                        this.nob = new File(VideoConvertUtil.mTv, "tieba_" + VideoConvertUtil.SO(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.nod.setConvertType(1);
                        this.nod.gq(str3, this.nob);
                        dKe();
                        this.mYi = false;
                        this.mYj = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.noa;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.nob = new File(VideoConvertUtil.mTv, "tieba_" + VideoConvertUtil.SO(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.nod.setConvertType(2);
                            this.nod.gq(str3, this.nob);
                            dKe();
                            this.mYi = false;
                            this.mYj = false;
                            return;
                        }
                        this.nob = videoFileInfo2.videoPath;
                        xx(false);
                        KK(102);
                    }
                }
            }
        }
    }

    private void dKj() {
        com.baidu.tbadk.core.dialog.a a2 = new com.baidu.tbadk.core.dialog.a(this.hSW).oa(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.j.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a2.b(this.hSW.getPageContext());
        a2.iA(false);
        a2.bkJ();
    }

    private void dKe() {
        RelativeLayout relativeLayout = (RelativeLayout) this.hSW.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.noc == null) {
                this.noc = new AlbumVideoCompressingDialogView(this.hSW);
            }
            if (this.noc.getParent() == null) {
                relativeLayout.addView(this.noc);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.noc.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.noc.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.noc.setPercent(0);
        this.noe = true;
    }

    private void xx(boolean z) {
        VideoFileInfo TQ = TQ(this.nob);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nob);
        videoInfo.setVideoDuration(TQ.videoDuration / 1000);
        videoInfo.setVideoWidth(TQ.videoWidth);
        videoInfo.setVideoHeight(TQ.videoHeight);
        videoInfo.setVideoLength(new File(TQ.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.hSW, this.iSJ, this.mForumName, this.mForumId, this.mUT, videoInfo);
        editVideoActivityConfig.setProZone(this.nof);
        editVideoActivityConfig.setFrsTabInfo(this.nnh);
        editVideoActivityConfig.setFrom(this.mFrom);
        editVideoActivityConfig.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.mYi = false;
        this.nob = null;
        if (this.mFB != null) {
            this.mFB.cYv();
        }
    }

    public static VideoFileInfo TQ(String str) {
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
    public void dIE() {
    }

    @Override // com.baidu.tieba.video.d
    public void JT(int i) {
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
                if (this.noc != null && this.noc.isShowing()) {
                    this.noc.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.mYj) {
                    com.baidu.adp.lib.util.l.showToast(this.hSW, R.string.mv_local_video_compress_failed);
                    KK(103);
                }
                this.noe = false;
                this.mYi = false;
                dKf();
                break;
            case 3:
                this.noe = false;
                this.mYi = true;
                if (!StringUtils.isNull(this.nob) && (file = new File(this.nob)) != null) {
                    this.nob = this.nob.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.nob));
                }
                dKf();
                if (!this.mYh) {
                    xx(true);
                    if (this.mFB != null) {
                        this.mFB.cYv();
                        break;
                    }
                }
                break;
            case 4:
                this.noe = false;
                this.mYi = false;
                dKf();
                KK(104);
                break;
            case 5:
                this.noe = false;
                com.baidu.adp.lib.util.l.showToast(this.hSW, R.string.mv_local_video_compress_failed);
                if (this.nod != null && this.nod.isConvertRunning()) {
                    dKg();
                }
                KK(105);
                break;
        }
        return true;
    }

    private void dKf() {
        RelativeLayout relativeLayout = (RelativeLayout) this.hSW.findViewById(R.id.parent);
        if (relativeLayout != null && this.noc.getParent() != null) {
            relativeLayout.removeView(this.noc);
        }
    }

    private void dKg() {
        if (this.nod != null) {
            this.nod.abortConvert();
        }
        this.mYj = true;
        if (this.nob != null) {
            File file = new File(this.nob);
            if (file.exists()) {
                file.delete();
            }
        }
        dKf();
        this.nob = null;
    }

    public void onStart() {
        this.mYh = false;
    }

    public void onStop() {
        this.mYh = true;
    }

    public void onResume() {
        if (this.mYi && !TextUtils.isEmpty(this.nob) && new File(this.nob).exists()) {
            xx(true);
            KK(101);
        }
        if (this.mFB != null) {
            this.mFB.NW("album");
        }
    }

    public void onDestroy() {
        if (this.nod != null) {
            this.nod.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.mFB != null) {
            this.mFB.NX("album");
        }
        MessageManager.getInstance().unRegisterListener(this.mYq);
    }

    private void KK(int i) {
        if (this.mFB != null) {
            this.mFB.bB(i, "album");
        }
    }

    public boolean dNX() {
        return this.noe;
    }

    public void setProfessionZone(int i) {
        this.nof = i;
    }
}
