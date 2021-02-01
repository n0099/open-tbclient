package com.baidu.tieba.write.write.video;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.tieba.video.b;
import com.baidu.tieba.video.c;
import com.baidu.tieba.write.write.WriteActivity;
import java.io.File;
/* loaded from: classes8.dex */
public class a {
    private TbPageContext eUY;
    private PreviewVideoView onC;
    private LinearLayout onD;
    private TextView onE;
    private TextView onF;
    private TextView onG;
    private b onH;
    private com.baidu.tieba.c.b onI;
    private VideoInfo onJ;
    private EditVideoData onK;
    private int onL = 0;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.video.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.onG) {
                if (view == a.this.onC.onw) {
                    if (a.this.eUY.getPageActivity() instanceof WriteActivity) {
                        a.this.onDestroy();
                        ((WriteActivity) a.this.eUY.getPageActivity()).aD(true, false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                        return;
                    }
                    return;
                } else if (a.this.onL != 1) {
                    a.this.dZS();
                    return;
                } else {
                    return;
                }
            }
            a.this.dZQ();
        }
    };

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.eUY = tbPageContext;
        this.onC = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.onC.setOnClickListener(this.onClickListener);
        this.onD = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.onE = (TextView) view.findViewById(R.id.write_video_state_text);
        this.onF = (TextView) view.findViewById(R.id.write_video_percent);
        this.onG = (TextView) view.findViewById(R.id.write_video_retry);
        this.onG.setOnClickListener(this.onClickListener);
        buo();
    }

    public void onStart() {
        this.onC.dZO();
    }

    public void onResume() {
        if (this.onK != null && this.onK.isLegal()) {
            this.onC.Vt(this.onK.finalPath);
        }
    }

    public void onPause() {
        this.onC.stopVideo();
    }

    public void onStop() {
        this.onC.dZP();
    }

    public void onDestroy() {
        if (this.onH != null) {
            this.onH.yU(true);
        }
        if (this.onI != null) {
            this.onI.cancel();
        }
    }

    public boolean isVisible() {
        return this.onC != null && this.onC.getVisibility() == 0;
    }

    public void dZQ() {
        if (this.onK != null) {
            bWt();
            dE(1, 10);
            this.onI = (com.baidu.tieba.c.b) MessageManager.getInstance().runTask(2921466, com.baidu.tieba.c.b.class, this.onH).getData();
            if (this.onI != null) {
                this.onI.start();
            } else {
                dE(3, 0);
            }
        }
    }

    public void a(VideoInfo videoInfo, boolean z) {
        if (videoInfo == null) {
            this.onK = null;
        } else {
            this.onK = videoInfo.getEditVideoData();
        }
        this.onJ = videoInfo;
        if (this.onK != null && this.onK.isLegal()) {
            this.onD.setVisibility(0);
            this.onC.setVisibility(0);
            this.onC.setVideoInfo(this.onK);
            if (z) {
                this.onC.bf(1.0f);
                return;
            }
            return;
        }
        this.onD.setVisibility(8);
        this.onC.setVisibility(8);
        this.onC.reset();
        if (this.onH != null) {
            this.onH.yU(true);
        }
        if (this.onI != null) {
            this.onI.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE(int i, int i2) {
        this.onF.setText(String.format(this.eUY.getString(R.string.video_mix_percent), Integer.valueOf(i2)));
        if (i != this.onL) {
            this.onL = i;
            ap.setViewTextColor(this.onE, this.onL == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
            if (i == 1) {
                this.onE.setText(this.eUY.getString(R.string.video_mixing));
                this.onF.setVisibility(0);
                this.onG.setVisibility(8);
            } else if (i == 3) {
                this.onE.setText(this.eUY.getString(R.string.video_mix_failed));
                this.onF.setVisibility(8);
                this.onG.setVisibility(0);
            } else {
                this.onE.setText(this.eUY.getString(R.string.video_mix_success));
                this.onF.setVisibility(8);
                this.onG.setVisibility(8);
            }
        }
        this.onC.bf(i2 / 100.0f);
    }

    private void bWt() {
        if (this.onH == null) {
            this.onH = new b((WriteActivity) this.eUY.getPageActivity(), this.onK) { // from class: com.baidu.tieba.write.write.video.a.2
                @Override // com.baidu.tieba.video.b
                public void onCancel() {
                    super.onCancel();
                }

                @Override // com.baidu.tieba.video.b
                public void dRP() {
                    a.this.eUY.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dE(1, 50);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void cb(int i, String str) {
                    super.cb(i, str);
                    a.this.eUY.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dE(3, 0);
                            a.this.dZR();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void dRQ() {
                    a.this.eUY.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dE(1, 100);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void cc(int i, String str) {
                    super.cc(i, str);
                    a.this.eUY.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dE(3, 0);
                            a.this.dZR();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void a(VideoInfo videoInfo) {
                    String str;
                    super.a(videoInfo);
                    String videoPath = videoInfo.getVideoPath();
                    if (au.isEmpty(videoPath) || !videoPath.contains(c.nKm)) {
                        str = videoPath;
                    } else {
                        File file = new File(videoPath);
                        String str2 = c.nKn + file.getName();
                        o.copyFile(file.getAbsolutePath(), str2);
                        str = str2;
                    }
                    try {
                        a.this.bu(a.this.eUY.getPageActivity(), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.onK.finalPath = str;
                    a.this.onJ.setVideoPath(str);
                    a.this.onJ.setThumbPath(this.coverPath);
                    a.this.onC.Vt(str);
                    a.this.eUY.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dE(2, 100);
                            if (a.this.eUY != null && (a.this.eUY.getPageActivity() instanceof WriteActivity)) {
                                ((WriteActivity) a.this.eUY.getPageActivity()).dJR();
                            }
                        }
                    });
                }
            };
        } else {
            this.onH.a(this.onK);
        }
        this.onH.yU(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZR() {
        if (this.eUY != null && (this.eUY.getPageActivity() instanceof WriteActivity)) {
            ((WriteActivity) this.eUY.getPageActivity()).Eo(this.eUY.getString(R.string.write_video_mix_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    new z(context).saveVideo(str);
                    Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                    intent.setData(Uri.fromFile(new File(str)));
                    context.sendBroadcast(intent);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZS() {
        WriteActivity writeActivity;
        WriteData dav;
        if (this.eUY != null && (this.eUY.getPageActivity() instanceof WriteActivity) && (dav = (writeActivity = (WriteActivity) this.eUY.getPageActivity()).dav()) != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(this.onJ);
            videoInfo.setVideoPath(this.onK.originPath);
            videoInfo.getEditVideoData().finalPath = null;
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.eUY.getPageActivity(), writeActivity.getCallFrom(), dav.getForumName(), dav.getForumId(), "", videoInfo);
            editVideoActivityConfig.setProZone(dav.getProZone());
            editVideoActivityConfig.setStatisticFrom(dav.getStatisticFrom());
            editVideoActivityConfig.setFrsTabInfo(writeActivity.getFrsTabInfoData());
            editVideoActivityConfig.setFrom(writeActivity.getFrom());
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT);
            AntiData antiData = new AntiData();
            antiData.voice_message = writeActivity.fDL;
            antiData.setIfVoice(writeActivity.okz);
            editVideoActivityConfig.setExtraData(antiData, writeActivity.mPrefixData, dav.getFirstDir(), dav.getSecondDir());
            editVideoActivityConfig.getIntent().setFlags(536870912);
            editVideoActivityConfig.getIntent().setFlags(67108864);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        }
    }

    public void buo() {
        this.onC.buo();
        ap.setViewTextColor(this.onE, this.onL == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
        ap.setViewTextColor(this.onF, R.color.CAM_X0109);
        ap.setViewTextColor(this.onG, R.color.CAM_X0302);
    }
}
