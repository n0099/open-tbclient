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
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.tieba.video.b;
import com.baidu.tieba.video.c;
import com.baidu.tieba.write.write.WriteActivity;
import java.io.File;
/* loaded from: classes3.dex */
public class a {
    private TbPageContext eGu;
    private PreviewVideoView nRJ;
    private LinearLayout nRK;
    private TextView nRL;
    private TextView nRM;
    private TextView nRN;
    private b nRO;
    private com.baidu.tieba.d.b nRP;
    private VideoInfo nRQ;
    private EditVideoData nRR;
    private int nRS = 0;
    private View.OnClickListener fhp = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.video.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.nRN) {
                if (view == a.this.nRJ.nRE) {
                    if (a.this.eGu.getPageActivity() instanceof WriteActivity) {
                        a.this.onDestroy();
                        ((WriteActivity) a.this.eGu.getPageActivity()).yQ(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                        return;
                    }
                    return;
                } else if (a.this.nRS != 1) {
                    a.this.dWX();
                    return;
                } else {
                    return;
                }
            }
            a.this.dWV();
        }
    };

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.eGu = tbPageContext;
        this.nRJ = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.nRJ.setOnClickListener(this.fhp);
        this.nRK = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.nRL = (TextView) view.findViewById(R.id.write_video_state_text);
        this.nRM = (TextView) view.findViewById(R.id.write_video_percent);
        this.nRN = (TextView) view.findViewById(R.id.write_video_retry);
        this.nRN.setOnClickListener(this.fhp);
        changeSkin();
    }

    public void onStart() {
        this.nRJ.dWT();
    }

    public void onResume() {
        if (this.nRR != null && this.nRR.isLegal()) {
            this.nRJ.UO(this.nRR.finalPath);
        }
    }

    public void onPause() {
        this.nRJ.cAF();
    }

    public void onStop() {
        this.nRJ.dWU();
    }

    public void onDestroy() {
        if (this.nRO != null) {
            this.nRO.xX(true);
        }
        if (this.nRP != null) {
            this.nRP.cancel();
        }
    }

    public boolean isVisible() {
        return this.nRJ != null && this.nRJ.getVisibility() == 0;
    }

    public void dWV() {
        if (this.nRR != null) {
            bTq();
            dH(1, 10);
            this.nRP = (com.baidu.tieba.d.b) MessageManager.getInstance().runTask(2921466, com.baidu.tieba.d.b.class, this.nRO).getData();
            if (this.nRP != null) {
                this.nRP.start();
            } else {
                dH(3, 0);
            }
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        if (videoInfo == null) {
            this.nRR = null;
        } else {
            this.nRR = videoInfo.getEditVideoData();
        }
        this.nRQ = videoInfo;
        if (this.nRR != null && this.nRR.isLegal()) {
            this.nRK.setVisibility(0);
            this.nRJ.setVisibility(0);
            this.nRJ.setVideoInfo(this.nRR);
            return;
        }
        this.nRK.setVisibility(8);
        this.nRJ.setVisibility(8);
        this.nRJ.reset();
        if (this.nRO != null) {
            this.nRO.xX(true);
        }
        if (this.nRP != null) {
            this.nRP.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dH(int i, int i2) {
        this.nRM.setText(String.format(this.eGu.getString(R.string.video_mix_percent), Integer.valueOf(i2)));
        if (i != this.nRS) {
            this.nRS = i;
            ap.setViewTextColor(this.nRL, this.nRS == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
            if (i == 1) {
                this.nRL.setText(this.eGu.getString(R.string.video_mixing));
                this.nRM.setVisibility(0);
                this.nRN.setVisibility(8);
            } else if (i == 3) {
                this.nRL.setText(this.eGu.getString(R.string.video_mix_failed));
                this.nRM.setVisibility(8);
                this.nRN.setVisibility(0);
            } else {
                this.nRL.setText(this.eGu.getString(R.string.video_mix_success));
                this.nRM.setVisibility(8);
                this.nRN.setVisibility(8);
            }
        }
        this.nRJ.aZ(i2 / 100.0f);
    }

    private void bTq() {
        if (this.nRO == null) {
            this.nRO = new b((WriteActivity) this.eGu.getPageActivity(), this.nRR) { // from class: com.baidu.tieba.write.write.video.a.2
                @Override // com.baidu.tieba.video.b
                public void onCancel() {
                    super.onCancel();
                }

                @Override // com.baidu.tieba.video.b
                public void dOl() {
                    a.this.eGu.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dH(1, 50);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bT(int i, String str) {
                    super.bT(i, str);
                    a.this.eGu.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dH(3, 0);
                            a.this.dWW();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void dOm() {
                    a.this.eGu.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dH(1, 100);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bU(int i, String str) {
                    super.bU(i, str);
                    a.this.eGu.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dH(3, 0);
                            a.this.dWW();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void a(VideoInfo videoInfo) {
                    String str;
                    super.a(videoInfo);
                    String videoPath = videoInfo.getVideoPath();
                    if (au.isEmpty(videoPath) || !videoPath.contains(c.nmU)) {
                        str = videoPath;
                    } else {
                        File file = new File(videoPath);
                        String str2 = c.nmV + file.getName();
                        n.copyFile(file.getAbsolutePath(), str2);
                        str = str2;
                    }
                    try {
                        a.this.bm(a.this.eGu.getPageActivity(), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.nRR.finalPath = str;
                    a.this.nRQ.setVideoPath(str);
                    a.this.nRQ.setThumbPath(this.coverPath);
                    a.this.nRJ.UO(str);
                    a.this.eGu.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dH(2, 100);
                            if (a.this.eGu != null && (a.this.eGu.getPageActivity() instanceof WriteActivity)) {
                                ((WriteActivity) a.this.eGu.getPageActivity()).dGr();
                            }
                        }
                    });
                }
            };
        } else {
            this.nRO.a(this.nRR);
        }
        this.nRO.xX(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWW() {
        if (this.eGu != null && (this.eGu.getPageActivity() instanceof WriteActivity)) {
            ((WriteActivity) this.eGu.getPageActivity()).Er(this.eGu.getString(R.string.write_video_mix_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(Context context, String str) {
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
    public void dWX() {
        WriteActivity writeActivity;
        WriteData cXs;
        if (this.eGu != null && (this.eGu.getPageActivity() instanceof WriteActivity) && (cXs = (writeActivity = (WriteActivity) this.eGu.getPageActivity()).cXs()) != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(this.nRQ);
            videoInfo.setVideoPath(this.nRR.originPath);
            videoInfo.getEditVideoData().finalPath = null;
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.eGu.getPageActivity(), writeActivity.getCallFrom(), cXs.getForumName(), cXs.getForumId(), "", videoInfo);
            editVideoActivityConfig.setProZone(cXs.getProZone());
            editVideoActivityConfig.setFrsTabInfo(writeActivity.dWh());
            editVideoActivityConfig.setFrom(writeActivity.getFrom());
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT);
            AntiData antiData = new AntiData();
            antiData.voice_message = writeActivity.foT;
            antiData.setIfVoice(writeActivity.nOF);
            editVideoActivityConfig.setExtraData(antiData, writeActivity.mPrefixData, cXs.getFirstDir(), cXs.getSecondDir());
            editVideoActivityConfig.getIntent().setFlags(536870912);
            editVideoActivityConfig.getIntent().setFlags(67108864);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        }
    }

    public void changeSkin() {
        this.nRJ.changeSkin();
        ap.setViewTextColor(this.nRL, this.nRS == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
        ap.setViewTextColor(this.nRM, R.color.CAM_X0109);
        ap.setViewTextColor(this.nRN, R.color.CAM_X0302);
    }
}
