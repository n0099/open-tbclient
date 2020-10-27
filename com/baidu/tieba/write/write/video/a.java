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
import com.baidu.tbadk.core.util.at;
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
    private TbPageContext eCn;
    private PreviewVideoView nKm;
    private LinearLayout nKn;
    private TextView nKo;
    private TextView nKp;
    private TextView nKq;
    private b nKr;
    private com.baidu.tieba.c.b nKs;
    private VideoInfo nKt;
    private EditVideoData nKu;
    private int nKv = 0;
    private View.OnClickListener fcr = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.video.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.nKq) {
                if (view == a.this.nKm.nKh) {
                    if (a.this.eCn.getPageActivity() instanceof WriteActivity) {
                        a.this.onDestroy();
                        ((WriteActivity) a.this.eCn.getPageActivity()).yA(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                        return;
                    }
                    return;
                } else if (a.this.nKv != 1) {
                    a.this.dUy();
                    return;
                } else {
                    return;
                }
            }
            a.this.dUw();
        }
    };

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.eCn = tbPageContext;
        this.nKm = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.nKm.setOnClickListener(this.fcr);
        this.nKn = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.nKo = (TextView) view.findViewById(R.id.write_video_state_text);
        this.nKp = (TextView) view.findViewById(R.id.write_video_percent);
        this.nKq = (TextView) view.findViewById(R.id.write_video_retry);
        this.nKq.setOnClickListener(this.fcr);
        changeSkin();
    }

    public void onStart() {
        this.nKm.dUu();
    }

    public void onResume() {
        if (this.nKu != null && this.nKu.isLegal()) {
            this.nKm.UM(this.nKu.finalPath);
        }
    }

    public void onPause() {
        this.nKm.cyB();
    }

    public void onStop() {
        this.nKm.dUv();
    }

    public void onDestroy() {
        if (this.nKr != null) {
            this.nKr.xH(true);
        }
        if (this.nKs != null) {
            this.nKs.cancel();
        }
    }

    public boolean isVisible() {
        return this.nKm != null && this.nKm.getVisibility() == 0;
    }

    public void dUw() {
        if (this.nKu != null) {
            bRy();
            dE(1, 10);
            this.nKs = (com.baidu.tieba.c.b) MessageManager.getInstance().runTask(2921466, com.baidu.tieba.c.b.class, this.nKr).getData();
            if (this.nKs != null) {
                this.nKs.start();
            } else {
                dE(3, 0);
            }
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        if (videoInfo == null) {
            this.nKu = null;
        } else {
            this.nKu = videoInfo.getEditVideoData();
        }
        this.nKt = videoInfo;
        if (this.nKu != null && this.nKu.isLegal()) {
            this.nKn.setVisibility(0);
            this.nKm.setVisibility(0);
            this.nKm.setVideoInfo(this.nKu);
            return;
        }
        this.nKn.setVisibility(8);
        this.nKm.setVisibility(8);
        this.nKm.reset();
        if (this.nKr != null) {
            this.nKr.xH(true);
        }
        if (this.nKs != null) {
            this.nKs.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE(int i, int i2) {
        this.nKp.setText(String.format(this.eCn.getString(R.string.video_mix_percent), Integer.valueOf(i2)));
        if (i != this.nKv) {
            this.nKv = i;
            ap.setViewTextColor(this.nKo, this.nKv == 3 ? R.color.cp_cont_h : R.color.cp_cont_j);
            if (i == 1) {
                this.nKo.setText(this.eCn.getString(R.string.video_mixing));
                this.nKp.setVisibility(0);
                this.nKq.setVisibility(8);
            } else if (i == 3) {
                this.nKo.setText(this.eCn.getString(R.string.video_mix_failed));
                this.nKp.setVisibility(8);
                this.nKq.setVisibility(0);
            } else {
                this.nKo.setText(this.eCn.getString(R.string.video_mix_success));
                this.nKp.setVisibility(8);
                this.nKq.setVisibility(8);
            }
        }
        this.nKm.aQ(i2 / 100.0f);
    }

    private void bRy() {
        if (this.nKr == null) {
            this.nKr = new b((WriteActivity) this.eCn.getPageActivity(), this.nKu) { // from class: com.baidu.tieba.write.write.video.a.2
                @Override // com.baidu.tieba.video.b
                public void onCancel() {
                    super.onCancel();
                }

                @Override // com.baidu.tieba.video.b
                public void dLK() {
                    a.this.eCn.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dE(1, 50);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bR(int i, String str) {
                    super.bR(i, str);
                    a.this.eCn.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dE(3, 0);
                            a.this.dUx();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void dLL() {
                    a.this.eCn.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dE(1, 100);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bS(int i, String str) {
                    super.bS(i, str);
                    a.this.eCn.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dE(3, 0);
                            a.this.dUx();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void a(VideoInfo videoInfo) {
                    String str;
                    super.a(videoInfo);
                    String videoPath = videoInfo.getVideoPath();
                    if (at.isEmpty(videoPath) || !videoPath.contains(c.nfR)) {
                        str = videoPath;
                    } else {
                        File file = new File(videoPath);
                        String str2 = c.nfS + file.getName();
                        n.copyFile(file.getAbsolutePath(), str2);
                        str = str2;
                    }
                    try {
                        a.this.bp(a.this.eCn.getPageActivity(), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.nKu.finalPath = str;
                    a.this.nKt.setVideoPath(str);
                    a.this.nKt.setThumbPath(this.coverPath);
                    a.this.nKm.UM(str);
                    a.this.eCn.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dE(2, 100);
                            if (a.this.eCn != null && (a.this.eCn.getPageActivity() instanceof WriteActivity)) {
                                ((WriteActivity) a.this.eCn.getPageActivity()).dDY();
                            }
                        }
                    });
                }
            };
        } else {
            this.nKr.a(this.nKu);
        }
        this.nKr.xH(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUx() {
        if (this.eCn != null && (this.eCn.getPageActivity() instanceof WriteActivity)) {
            ((WriteActivity) this.eCn.getPageActivity()).EC(this.eCn.getString(R.string.write_video_mix_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(Context context, String str) {
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
    public void dUy() {
        WriteActivity writeActivity;
        WriteData cVv;
        if (this.eCn != null && (this.eCn.getPageActivity() instanceof WriteActivity) && (cVv = (writeActivity = (WriteActivity) this.eCn.getPageActivity()).cVv()) != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(this.nKt);
            videoInfo.setVideoPath(this.nKu.originPath);
            videoInfo.getEditVideoData().finalPath = null;
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.eCn.getPageActivity(), writeActivity.getCallFrom(), cVv.getForumName(), cVv.getForumId(), "", videoInfo);
            editVideoActivityConfig.setProZone(cVv.getProZone());
            editVideoActivityConfig.setFrsTabInfo(writeActivity.dTI());
            editVideoActivityConfig.setFrom(writeActivity.getFrom());
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT);
            AntiData antiData = new AntiData();
            antiData.voice_message = writeActivity.fjU;
            antiData.setIfVoice(writeActivity.nHj);
            editVideoActivityConfig.setExtraData(antiData, writeActivity.mPrefixData, cVv.getFirstDir(), cVv.getSecondDir());
            editVideoActivityConfig.getIntent().setFlags(536870912);
            editVideoActivityConfig.getIntent().setFlags(67108864);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        }
    }

    public void changeSkin() {
        this.nKm.changeSkin();
        ap.setViewTextColor(this.nKo, this.nKv == 3 ? R.color.cp_cont_h : R.color.cp_cont_j);
        ap.setViewTextColor(this.nKp, R.color.cp_cont_d);
        ap.setViewTextColor(this.nKq, R.color.cp_link_tip_a);
    }
}
