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
    private BaseFragmentActivity hwQ;
    private String iwr;
    private String mForumId;
    private String mForumName;
    private String mFrom;
    private Handler mMainThreadHandler;
    private FrsTabInfoData mNu;
    private VideoFileInfo mOn;
    private String mOo;
    private AlbumVideoCompressingDialogView mOp;
    private VideoConvertUtil mOq;
    private boolean mOr;
    private com.baidu.tieba.k.h mgf;
    private String mvc;
    private final CustomMessageListener myB;
    private boolean mys = false;
    private boolean myt = false;
    private boolean myu = false;
    private PostPrefixData prefixData = null;
    private AntiData antiData = null;
    private String firstDir = "";
    private String secondDir = "";
    private int mOs = -1;

    public j(BaseFragmentActivity baseFragmentActivity, String str, String str2, String str3) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        l lVar = runTask != null ? (l) runTask.getData() : null;
        if (lVar != null) {
            this.mgf = lVar.cRt();
        }
        if (this.mgf != null) {
            this.mgf.cRc();
        }
        this.myB = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.write.album.j.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra("finish_self", true);
                    j.this.hwQ.setResult(-1, intent);
                    j.this.hwQ.finish();
                }
            }
        };
        this.hwQ = baseFragmentActivity;
        this.mForumName = str;
        this.mForumId = str2;
        this.mvc = str3;
        this.mOq = new VideoConvertUtil(baseFragmentActivity);
        this.mOq.a(this);
        this.mMainThreadHandler = new Handler(Looper.getMainLooper(), this);
        MessageManager.getInstance().registerListener(this.myB);
    }

    public void b(FrsTabInfoData frsTabInfoData) {
        this.mNu = frsTabInfoData;
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        this.antiData = antiData;
        this.prefixData = postPrefixData;
        this.firstDir = str;
        this.secondDir = str2;
    }

    public void a(VideoFileInfo videoFileInfo, String str, String str2) {
        this.mOn = videoFileInfo;
        this.iwr = str;
        this.mFrom = str2;
        if (this.mOn != null && this.hwQ != null) {
            if (this.mOn.videoDuration > 600000) {
                dCu();
            } else if (this.mOq == null || !this.mOq.isConvertRunning()) {
                String str3 = this.mOn.videoPath;
                if (TextUtils.isEmpty(str3)) {
                    com.baidu.adp.lib.util.l.showToast(this.hwQ, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    JA(107);
                } else if (!new File(str3).exists()) {
                    com.baidu.adp.lib.util.l.showToast(this.hwQ, R.string.mv_local_video_video_not_exist);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REMOVE_NOT_EXSIT_VIDEO, str3));
                    JA(106);
                } else if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    if (this.mOn != null) {
                        this.mOo = this.mOn.videoPath;
                        wF(false);
                        JA(102);
                    }
                } else if (VideoConvertUtil.RB(str3) >= 1500000) {
                    if (VideoConvertUtil.dAU()) {
                        this.mOo = new File(VideoConvertUtil.mtF, "tieba_" + VideoConvertUtil.RA(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                        this.mOq.setConvertType(1);
                        this.mOq.fW(str3, this.mOo);
                        dCp();
                        this.myt = false;
                        this.myu = false;
                    }
                } else {
                    VideoFileInfo videoFileInfo2 = this.mOn;
                    if (videoFileInfo2 != null) {
                        if (videoFileInfo2.videoDuration < 15000) {
                            this.mOo = new File(VideoConvertUtil.mtF, "tieba_" + VideoConvertUtil.RA(str3) + "_tiebaconverting.mp4").getAbsolutePath();
                            this.mOq.setConvertType(2);
                            this.mOq.fW(str3, this.mOo);
                            dCp();
                            this.myt = false;
                            this.myu = false;
                            return;
                        }
                        this.mOo = videoFileInfo2.videoPath;
                        wF(false);
                        JA(102);
                    }
                }
            }
        }
    }

    private void dCu() {
        com.baidu.tbadk.core.dialog.a a = new com.baidu.tbadk.core.dialog.a(this.hwQ).ns(R.string.mv_local_video_too_long).a(R.string.group_create_private_isee, new a.b() { // from class: com.baidu.tieba.write.album.j.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        a.b(this.hwQ.getPageContext());
        a.ig(false);
        a.bhg();
    }

    private void dCp() {
        RelativeLayout relativeLayout = (RelativeLayout) this.hwQ.findViewById(R.id.parent);
        if (relativeLayout != null) {
            if (this.mOp == null) {
                this.mOp = new AlbumVideoCompressingDialogView(this.hwQ);
            }
            if (this.mOp.getParent() == null) {
                relativeLayout.addView(this.mOp);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mOp.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.addRule(13);
                this.mOp.setLayoutParams(layoutParams);
            } else {
                return;
            }
        }
        this.mOp.setPercent(0);
        this.mOr = true;
    }

    private void wF(boolean z) {
        VideoFileInfo SC = SC(this.mOo);
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.mOo);
        videoInfo.setVideoDuration(SC.videoDuration / 1000);
        videoInfo.setVideoWidth(SC.videoWidth);
        videoInfo.setVideoHeight(SC.videoHeight);
        videoInfo.setVideoLength(new File(SC.videoPath).length());
        videoInfo.setVideoType(2);
        videoInfo.setIsCompressedVideo(z);
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.hwQ, this.iwr, this.mForumName, this.mForumId, this.mvc, videoInfo);
        editVideoActivityConfig.setProZone(this.mOs);
        editVideoActivityConfig.setFrsTabInfo(this.mNu);
        editVideoActivityConfig.setFrom(this.mFrom);
        editVideoActivityConfig.setExtraData(this.antiData, this.prefixData, this.firstDir, this.secondDir);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.myt = false;
        this.mOo = null;
        if (this.mgf != null) {
            this.mgf.cRf();
        }
    }

    public static VideoFileInfo SC(String str) {
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
    public void dAP() {
    }

    @Override // com.baidu.tieba.video.d
    public void IJ(int i) {
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
                if (this.mOp != null && this.mOp.isShowing()) {
                    this.mOp.setPercent(message.arg1);
                }
                this.mMainThreadHandler.sendMessageDelayed(this.mMainThreadHandler.obtainMessage(5), 60000L);
                break;
            case 2:
                if (!this.myu) {
                    com.baidu.adp.lib.util.l.showToast(this.hwQ, R.string.mv_local_video_compress_failed);
                    JA(103);
                }
                this.mOr = false;
                this.myt = false;
                dCq();
                break;
            case 3:
                this.mOr = false;
                this.myt = true;
                if (!StringUtils.isNull(this.mOo) && (file = new File(this.mOo)) != null) {
                    this.mOo = this.mOo.replace("_tiebaconverting.mp4", ".mp4");
                    file.renameTo(new File(this.mOo));
                }
                dCq();
                if (!this.mys) {
                    wF(true);
                    if (this.mgf != null) {
                        this.mgf.cRf();
                        break;
                    }
                }
                break;
            case 4:
                this.mOr = false;
                this.myt = false;
                dCq();
                JA(104);
                break;
            case 5:
                this.mOr = false;
                com.baidu.adp.lib.util.l.showToast(this.hwQ, R.string.mv_local_video_compress_failed);
                if (this.mOq != null && this.mOq.isConvertRunning()) {
                    dCr();
                }
                JA(105);
                break;
        }
        return true;
    }

    private void dCq() {
        RelativeLayout relativeLayout = (RelativeLayout) this.hwQ.findViewById(R.id.parent);
        if (relativeLayout != null && this.mOp.getParent() != null) {
            relativeLayout.removeView(this.mOp);
        }
    }

    private void dCr() {
        if (this.mOq != null) {
            this.mOq.abortConvert();
        }
        this.myu = true;
        if (this.mOo != null) {
            File file = new File(this.mOo);
            if (file.exists()) {
                file.delete();
            }
        }
        dCq();
        this.mOo = null;
    }

    public void onStart() {
        this.mys = false;
    }

    public void onStop() {
        this.mys = true;
    }

    public void onResume() {
        if (this.myt && !TextUtils.isEmpty(this.mOo) && new File(this.mOo).exists()) {
            wF(true);
            JA(101);
        }
        if (this.mgf != null) {
            this.mgf.ME("album");
        }
    }

    public void onDestroy() {
        if (this.mOq != null) {
            this.mOq.destroy();
        }
        if (this.mMainThreadHandler != null) {
            this.mMainThreadHandler.removeMessages(5);
        }
        if (this.mgf != null) {
            this.mgf.MF("album");
        }
        MessageManager.getInstance().unRegisterListener(this.myB);
    }

    private void JA(int i) {
        if (this.mgf != null) {
            this.mgf.bo(i, "album");
        }
    }

    public boolean dGi() {
        return this.mOr;
    }

    public void setProfessionZone(int i) {
        this.mOs = i;
    }
}
