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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.tieba.video.b;
import com.baidu.tieba.video.d;
import com.baidu.tieba.write.write.WriteActivity;
import java.io.File;
/* loaded from: classes2.dex */
public class a {
    private TbPageContext dPv;
    private PreviewVideoView mwU;
    private LinearLayout mwV;
    private TextView mwW;
    private TextView mwX;
    private TextView mwY;
    private b mwZ;
    private com.baidu.tieba.c.b mxa;
    private VideoInfo mxb;
    private EditVideoData mxc;
    private int mxd = 0;
    private View.OnClickListener eoP = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.video.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.mwY) {
                if (view == a.this.mwU.mwO) {
                    if (a.this.dPv.getPageActivity() instanceof WriteActivity) {
                        a.this.onDestroy();
                        ((WriteActivity) a.this.dPv.getPageActivity()).vW(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                        return;
                    }
                    return;
                } else if (a.this.mxd != 1) {
                    a.this.dux();
                    return;
                } else {
                    return;
                }
            }
            a.this.duv();
        }
    };

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.dPv = tbPageContext;
        this.mwU = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.mwU.setOnClickListener(this.eoP);
        this.mwV = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.mwW = (TextView) view.findViewById(R.id.write_video_state_text);
        this.mwX = (TextView) view.findViewById(R.id.write_video_percent);
        this.mwY = (TextView) view.findViewById(R.id.write_video_retry);
        this.mwY.setOnClickListener(this.eoP);
        aYi();
    }

    public void onStart() {
        this.mwU.dut();
    }

    public void onResume() {
        if (this.mxc != null && this.mxc.isLegal()) {
            this.mwU.Pq(this.mxc.finalPath);
        }
    }

    public void onPause() {
        this.mwU.caH();
    }

    public void onStop() {
        this.mwU.duu();
    }

    public void onDestroy() {
        if (this.mwZ != null) {
            this.mwZ.vf(true);
        }
        if (this.mxa != null) {
            this.mxa.cancel();
        }
    }

    public boolean isVisible() {
        return this.mwU != null && this.mwU.getVisibility() == 0;
    }

    public void duv() {
        if (this.mxc != null) {
            byq();
            m36do(1, 10);
            this.mxa = (com.baidu.tieba.c.b) MessageManager.getInstance().runTask(2921466, com.baidu.tieba.c.b.class, this.mwZ).getData();
            if (this.mxa != null) {
                this.mxa.start();
            } else {
                m36do(3, 0);
            }
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        if (videoInfo == null) {
            this.mxc = null;
        } else {
            this.mxc = videoInfo.getEditVideoData();
        }
        this.mxb = videoInfo;
        if (this.mxc != null && this.mxc.isLegal()) {
            this.mwV.setVisibility(0);
            this.mwU.setVisibility(0);
            this.mwU.setVideoInfo(this.mxc);
            return;
        }
        this.mwV.setVisibility(8);
        this.mwU.setVisibility(8);
        this.mwU.reset();
        if (this.mwZ != null) {
            this.mwZ.vf(true);
        }
        if (this.mxa != null) {
            this.mxa.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m36do(int i, int i2) {
        this.mwX.setText(String.format(this.dPv.getString(R.string.video_mix_percent), Integer.valueOf(i2)));
        if (i != this.mxd) {
            this.mxd = i;
            an.setViewTextColor(this.mwW, this.mxd == 3 ? R.color.cp_cont_h : R.color.cp_cont_j);
            if (i == 1) {
                this.mwW.setText(this.dPv.getString(R.string.video_mixing));
                this.mwX.setVisibility(0);
                this.mwY.setVisibility(8);
            } else if (i == 3) {
                this.mwW.setText(this.dPv.getString(R.string.video_mix_failed));
                this.mwX.setVisibility(8);
                this.mwY.setVisibility(0);
            } else {
                this.mwW.setText(this.dPv.getString(R.string.video_mix_success));
                this.mwX.setVisibility(8);
                this.mwY.setVisibility(8);
            }
        }
        this.mwU.aD(i2 / 100.0f);
    }

    private void byq() {
        if (this.mwZ == null) {
            this.mwZ = new b((WriteActivity) this.dPv.getPageActivity(), this.mxc) { // from class: com.baidu.tieba.write.write.video.a.2
                @Override // com.baidu.tieba.video.b
                public void onCancel() {
                    super.onCancel();
                }

                @Override // com.baidu.tieba.video.b
                public void dmh() {
                    a.this.dPv.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.m36do(1, 50);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bE(int i, String str) {
                    super.bE(i, str);
                    a.this.dPv.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.m36do(3, 0);
                            a.this.duw();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void dmi() {
                    a.this.dPv.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.m36do(1, 100);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bF(int i, String str) {
                    super.bF(i, str);
                    a.this.dPv.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.m36do(3, 0);
                            a.this.duw();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void a(VideoInfo videoInfo) {
                    String str;
                    super.a(videoInfo);
                    String videoPath = videoInfo.getVideoPath();
                    if (ar.isEmpty(videoPath) || !videoPath.contains(d.lUx)) {
                        str = videoPath;
                    } else {
                        File file = new File(videoPath);
                        String str2 = d.lUy + file.getName();
                        n.copyFile(file.getAbsolutePath(), str2);
                        str = str2;
                    }
                    try {
                        a.this.ba(a.this.dPv.getPageActivity(), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.mxc.finalPath = str;
                    a.this.mxb.setVideoPath(str);
                    a.this.mxb.setThumbPath(this.coverPath);
                    a.this.mwU.Pq(str);
                    a.this.dPv.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.m36do(2, 100);
                            if (a.this.dPv != null && (a.this.dPv.getPageActivity() instanceof WriteActivity)) {
                                ((WriteActivity) a.this.dPv.getPageActivity()).deD();
                            }
                        }
                    });
                }
            };
        } else {
            this.mwZ.a(this.mxc);
        }
        this.mwZ.vf(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duw() {
        if (this.dPv != null && (this.dPv.getPageActivity() instanceof WriteActivity)) {
            ((WriteActivity) this.dPv.getPageActivity()).Pl(this.dPv.getString(R.string.write_video_mix_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    new x(context).saveVideo(str);
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
    public void dux() {
        WriteActivity writeActivity;
        WriteData dew;
        if (this.dPv != null && (this.dPv.getPageActivity() instanceof WriteActivity) && (dew = (writeActivity = (WriteActivity) this.dPv.getPageActivity()).dew()) != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(this.mxb);
            videoInfo.setVideoPath(this.mxc.originPath);
            videoInfo.getEditVideoData().finalPath = null;
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.dPv.getPageActivity(), writeActivity.getCallFrom(), dew.getForumName(), dew.getForumId(), "", videoInfo);
            editVideoActivityConfig.setProZone(dew.getProZone());
            editVideoActivityConfig.setFrsTabInfo(writeActivity.dtL());
            editVideoActivityConfig.setFrom(writeActivity.getFrom());
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT);
            AntiData antiData = new AntiData();
            antiData.voice_message = writeActivity.evB;
            antiData.setIfVoice(writeActivity.mui);
            editVideoActivityConfig.setExtraData(antiData, writeActivity.mPrefixData, dew.getFirstDir(), dew.getSecondDir());
            editVideoActivityConfig.getIntent().setFlags(536870912);
            editVideoActivityConfig.getIntent().setFlags(67108864);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        }
    }

    public void aYi() {
        this.mwU.aYi();
        an.setViewTextColor(this.mwW, this.mxd == 3 ? R.color.cp_cont_h : R.color.cp_cont_j);
        an.setViewTextColor(this.mwX, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.mwY, (int) R.color.cp_link_tip_a);
    }
}
