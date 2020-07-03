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
    private PreviewVideoView mwR;
    private LinearLayout mwS;
    private TextView mwT;
    private TextView mwU;
    private TextView mwV;
    private b mwW;
    private com.baidu.tieba.c.b mwX;
    private VideoInfo mwY;
    private EditVideoData mwZ;
    private int mxa = 0;
    private View.OnClickListener eoP = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.video.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.mwV) {
                if (view == a.this.mwR.mwL) {
                    if (a.this.dPv.getPageActivity() instanceof WriteActivity) {
                        a.this.onDestroy();
                        ((WriteActivity) a.this.dPv.getPageActivity()).vW(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                        return;
                    }
                    return;
                } else if (a.this.mxa != 1) {
                    a.this.dut();
                    return;
                } else {
                    return;
                }
            }
            a.this.dur();
        }
    };

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.dPv = tbPageContext;
        this.mwR = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.mwR.setOnClickListener(this.eoP);
        this.mwS = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.mwT = (TextView) view.findViewById(R.id.write_video_state_text);
        this.mwU = (TextView) view.findViewById(R.id.write_video_percent);
        this.mwV = (TextView) view.findViewById(R.id.write_video_retry);
        this.mwV.setOnClickListener(this.eoP);
        aYi();
    }

    public void onStart() {
        this.mwR.dup();
    }

    public void onResume() {
        if (this.mwZ != null && this.mwZ.isLegal()) {
            this.mwR.Pp(this.mwZ.finalPath);
        }
    }

    public void onPause() {
        this.mwR.caG();
    }

    public void onStop() {
        this.mwR.duq();
    }

    public void onDestroy() {
        if (this.mwW != null) {
            this.mwW.vf(true);
        }
        if (this.mwX != null) {
            this.mwX.cancel();
        }
    }

    public boolean isVisible() {
        return this.mwR != null && this.mwR.getVisibility() == 0;
    }

    public void dur() {
        if (this.mwZ != null) {
            byp();
            m36do(1, 10);
            this.mwX = (com.baidu.tieba.c.b) MessageManager.getInstance().runTask(2921466, com.baidu.tieba.c.b.class, this.mwW).getData();
            if (this.mwX != null) {
                this.mwX.start();
            } else {
                m36do(3, 0);
            }
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        if (videoInfo == null) {
            this.mwZ = null;
        } else {
            this.mwZ = videoInfo.getEditVideoData();
        }
        this.mwY = videoInfo;
        if (this.mwZ != null && this.mwZ.isLegal()) {
            this.mwS.setVisibility(0);
            this.mwR.setVisibility(0);
            this.mwR.setVideoInfo(this.mwZ);
            return;
        }
        this.mwS.setVisibility(8);
        this.mwR.setVisibility(8);
        this.mwR.reset();
        if (this.mwW != null) {
            this.mwW.vf(true);
        }
        if (this.mwX != null) {
            this.mwX.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m36do(int i, int i2) {
        this.mwU.setText(String.format(this.dPv.getString(R.string.video_mix_percent), Integer.valueOf(i2)));
        if (i != this.mxa) {
            this.mxa = i;
            an.setViewTextColor(this.mwT, this.mxa == 3 ? R.color.cp_cont_h : R.color.cp_cont_j);
            if (i == 1) {
                this.mwT.setText(this.dPv.getString(R.string.video_mixing));
                this.mwU.setVisibility(0);
                this.mwV.setVisibility(8);
            } else if (i == 3) {
                this.mwT.setText(this.dPv.getString(R.string.video_mix_failed));
                this.mwU.setVisibility(8);
                this.mwV.setVisibility(0);
            } else {
                this.mwT.setText(this.dPv.getString(R.string.video_mix_success));
                this.mwU.setVisibility(8);
                this.mwV.setVisibility(8);
            }
        }
        this.mwR.aD(i2 / 100.0f);
    }

    private void byp() {
        if (this.mwW == null) {
            this.mwW = new b((WriteActivity) this.dPv.getPageActivity(), this.mwZ) { // from class: com.baidu.tieba.write.write.video.a.2
                @Override // com.baidu.tieba.video.b
                public void onCancel() {
                    super.onCancel();
                }

                @Override // com.baidu.tieba.video.b
                public void dmd() {
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
                            a.this.dus();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void dme() {
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
                            a.this.dus();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void a(VideoInfo videoInfo) {
                    String str;
                    super.a(videoInfo);
                    String videoPath = videoInfo.getVideoPath();
                    if (ar.isEmpty(videoPath) || !videoPath.contains(d.lUu)) {
                        str = videoPath;
                    } else {
                        File file = new File(videoPath);
                        String str2 = d.lUv + file.getName();
                        n.copyFile(file.getAbsolutePath(), str2);
                        str = str2;
                    }
                    try {
                        a.this.ba(a.this.dPv.getPageActivity(), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.mwZ.finalPath = str;
                    a.this.mwY.setVideoPath(str);
                    a.this.mwY.setThumbPath(this.coverPath);
                    a.this.mwR.Pp(str);
                    a.this.dPv.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.m36do(2, 100);
                            if (a.this.dPv != null && (a.this.dPv.getPageActivity() instanceof WriteActivity)) {
                                ((WriteActivity) a.this.dPv.getPageActivity()).deC();
                            }
                        }
                    });
                }
            };
        } else {
            this.mwW.a(this.mwZ);
        }
        this.mwW.vf(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dus() {
        if (this.dPv != null && (this.dPv.getPageActivity() instanceof WriteActivity)) {
            ((WriteActivity) this.dPv.getPageActivity()).Pk(this.dPv.getString(R.string.write_video_mix_fail));
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
    public void dut() {
        WriteActivity writeActivity;
        WriteData dev;
        if (this.dPv != null && (this.dPv.getPageActivity() instanceof WriteActivity) && (dev = (writeActivity = (WriteActivity) this.dPv.getPageActivity()).dev()) != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(this.mwY);
            videoInfo.setVideoPath(this.mwZ.originPath);
            videoInfo.getEditVideoData().finalPath = null;
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.dPv.getPageActivity(), writeActivity.getCallFrom(), dev.getForumName(), dev.getForumId(), "", videoInfo);
            editVideoActivityConfig.setProZone(dev.getProZone());
            editVideoActivityConfig.setFrsTabInfo(writeActivity.dtH());
            editVideoActivityConfig.setFrom(writeActivity.getFrom());
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT);
            AntiData antiData = new AntiData();
            antiData.voice_message = writeActivity.evB;
            antiData.setIfVoice(writeActivity.muf);
            editVideoActivityConfig.setExtraData(antiData, writeActivity.mPrefixData, dev.getFirstDir(), dev.getSecondDir());
            editVideoActivityConfig.getIntent().setFlags(536870912);
            editVideoActivityConfig.getIntent().setFlags(67108864);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        }
    }

    public void aYi() {
        this.mwR.aYi();
        an.setViewTextColor(this.mwT, this.mxa == 3 ? R.color.cp_cont_h : R.color.cp_cont_j);
        an.setViewTextColor(this.mwU, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.mwV, (int) R.color.cp_link_tip_a);
    }
}
