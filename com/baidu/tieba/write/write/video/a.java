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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.tieba.video.b;
import com.baidu.tieba.video.c;
import com.baidu.tieba.write.write.WriteActivity;
import java.io.File;
/* loaded from: classes7.dex */
public class a {
    private TbPageContext eSJ;
    private PreviewVideoView odK;
    private LinearLayout odL;
    private TextView odM;
    private TextView odN;
    private TextView odO;
    private b odP;
    private com.baidu.tieba.c.b odQ;
    private VideoInfo odR;
    private EditVideoData odS;
    private int odT = 0;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.video.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.odO) {
                if (view == a.this.odK.odE) {
                    if (a.this.eSJ.getPageActivity() instanceof WriteActivity) {
                        a.this.onDestroy();
                        ((WriteActivity) a.this.eSJ.getPageActivity()).aD(true, false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                        return;
                    }
                    return;
                } else if (a.this.odT != 1) {
                    a.this.dXH();
                    return;
                } else {
                    return;
                }
            }
            a.this.dXF();
        }
    };

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.eSJ = tbPageContext;
        this.odK = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.odK.setOnClickListener(this.onClickListener);
        this.odL = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.odM = (TextView) view.findViewById(R.id.write_video_state_text);
        this.odN = (TextView) view.findViewById(R.id.write_video_percent);
        this.odO = (TextView) view.findViewById(R.id.write_video_retry);
        this.odO.setOnClickListener(this.onClickListener);
        btU();
    }

    public void onStart() {
        this.odK.dXD();
    }

    public void onResume() {
        if (this.odS != null && this.odS.isLegal()) {
            this.odK.Uv(this.odS.finalPath);
        }
    }

    public void onPause() {
        this.odK.stopVideo();
    }

    public void onStop() {
        this.odK.dXE();
    }

    public void onDestroy() {
        if (this.odP != null) {
            this.odP.yB(true);
        }
        if (this.odQ != null) {
            this.odQ.cancel();
        }
    }

    public boolean isVisible() {
        return this.odK != null && this.odK.getVisibility() == 0;
    }

    public void dXF() {
        if (this.odS != null) {
            bVP();
            dH(1, 10);
            this.odQ = (com.baidu.tieba.c.b) MessageManager.getInstance().runTask(2921466, com.baidu.tieba.c.b.class, this.odP).getData();
            if (this.odQ != null) {
                this.odQ.start();
            } else {
                dH(3, 0);
            }
        }
    }

    public void a(VideoInfo videoInfo, boolean z) {
        if (videoInfo == null) {
            this.odS = null;
        } else {
            this.odS = videoInfo.getEditVideoData();
        }
        this.odR = videoInfo;
        if (this.odS != null && this.odS.isLegal()) {
            this.odL.setVisibility(0);
            this.odK.setVisibility(0);
            this.odK.setVideoInfo(this.odS);
            if (z) {
                this.odK.bc(1.0f);
                return;
            }
            return;
        }
        this.odL.setVisibility(8);
        this.odK.setVisibility(8);
        this.odK.reset();
        if (this.odP != null) {
            this.odP.yB(true);
        }
        if (this.odQ != null) {
            this.odQ.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dH(int i, int i2) {
        this.odN.setText(String.format(this.eSJ.getString(R.string.video_mix_percent), Integer.valueOf(i2)));
        if (i != this.odT) {
            this.odT = i;
            ao.setViewTextColor(this.odM, this.odT == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
            if (i == 1) {
                this.odM.setText(this.eSJ.getString(R.string.video_mixing));
                this.odN.setVisibility(0);
                this.odO.setVisibility(8);
            } else if (i == 3) {
                this.odM.setText(this.eSJ.getString(R.string.video_mix_failed));
                this.odN.setVisibility(8);
                this.odO.setVisibility(0);
            } else {
                this.odM.setText(this.eSJ.getString(R.string.video_mix_success));
                this.odN.setVisibility(8);
                this.odO.setVisibility(8);
            }
        }
        this.odK.bc(i2 / 100.0f);
    }

    private void bVP() {
        if (this.odP == null) {
            this.odP = new b((WriteActivity) this.eSJ.getPageActivity(), this.odS) { // from class: com.baidu.tieba.write.write.video.a.2
                @Override // com.baidu.tieba.video.b
                public void onCancel() {
                    super.onCancel();
                }

                @Override // com.baidu.tieba.video.b
                public void dPE() {
                    a.this.eSJ.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dH(1, 50);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bU(int i, String str) {
                    super.bU(i, str);
                    a.this.eSJ.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dH(3, 0);
                            a.this.dXG();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void dPF() {
                    a.this.eSJ.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dH(1, 100);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bV(int i, String str) {
                    super.bV(i, str);
                    a.this.eSJ.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dH(3, 0);
                            a.this.dXG();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void a(VideoInfo videoInfo) {
                    String str;
                    super.a(videoInfo);
                    String videoPath = videoInfo.getVideoPath();
                    if (at.isEmpty(videoPath) || !videoPath.contains(c.nAC)) {
                        str = videoPath;
                    } else {
                        File file = new File(videoPath);
                        String str2 = c.nAD + file.getName();
                        n.copyFile(file.getAbsolutePath(), str2);
                        str = str2;
                    }
                    try {
                        a.this.bv(a.this.eSJ.getPageActivity(), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.odS.finalPath = str;
                    a.this.odR.setVideoPath(str);
                    a.this.odR.setThumbPath(this.coverPath);
                    a.this.odK.Uv(str);
                    a.this.eSJ.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dH(2, 100);
                            if (a.this.eSJ != null && (a.this.eSJ.getPageActivity() instanceof WriteActivity)) {
                                ((WriteActivity) a.this.eSJ.getPageActivity()).dHG();
                            }
                        }
                    });
                }
            };
        } else {
            this.odP.a(this.odS);
        }
        this.odP.yB(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXG() {
        if (this.eSJ != null && (this.eSJ.getPageActivity() instanceof WriteActivity)) {
            ((WriteActivity) this.eSJ.getPageActivity()).DR(this.eSJ.getString(R.string.write_video_mix_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    new y(context).saveVideo(str);
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
    public void dXH() {
        WriteActivity writeActivity;
        WriteData cYx;
        if (this.eSJ != null && (this.eSJ.getPageActivity() instanceof WriteActivity) && (cYx = (writeActivity = (WriteActivity) this.eSJ.getPageActivity()).cYx()) != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(this.odR);
            videoInfo.setVideoPath(this.odS.originPath);
            videoInfo.getEditVideoData().finalPath = null;
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.eSJ.getPageActivity(), writeActivity.getCallFrom(), cYx.getForumName(), cYx.getForumId(), "", videoInfo);
            editVideoActivityConfig.setProZone(cYx.getProZone());
            editVideoActivityConfig.setStatisticFrom(cYx.getStatisticFrom());
            editVideoActivityConfig.setFrsTabInfo(writeActivity.getFrsTabInfoData());
            editVideoActivityConfig.setFrom(writeActivity.getFrom());
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT);
            AntiData antiData = new AntiData();
            antiData.voice_message = writeActivity.fBw;
            antiData.setIfVoice(writeActivity.oaE);
            editVideoActivityConfig.setExtraData(antiData, writeActivity.mPrefixData, cYx.getFirstDir(), cYx.getSecondDir());
            editVideoActivityConfig.getIntent().setFlags(536870912);
            editVideoActivityConfig.getIntent().setFlags(67108864);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        }
    }

    public void btU() {
        this.odK.btU();
        ao.setViewTextColor(this.odM, this.odT == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
        ao.setViewTextColor(this.odN, R.color.CAM_X0109);
        ao.setViewTextColor(this.odO, R.color.CAM_X0302);
    }
}
