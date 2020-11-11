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
    private TbPageContext eIc;
    private PreviewVideoView nQg;
    private LinearLayout nQh;
    private TextView nQi;
    private TextView nQj;
    private TextView nQk;
    private b nQl;
    private com.baidu.tieba.c.b nQm;
    private VideoInfo nQn;
    private EditVideoData nQo;
    private int nQp = 0;
    private View.OnClickListener fii = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.video.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.nQk) {
                if (view == a.this.nQg.nQb) {
                    if (a.this.eIc.getPageActivity() instanceof WriteActivity) {
                        a.this.onDestroy();
                        ((WriteActivity) a.this.eIc.getPageActivity()).yJ(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                        return;
                    }
                    return;
                } else if (a.this.nQp != 1) {
                    a.this.dWY();
                    return;
                } else {
                    return;
                }
            }
            a.this.dWW();
        }
    };

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.eIc = tbPageContext;
        this.nQg = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.nQg.setOnClickListener(this.fii);
        this.nQh = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.nQi = (TextView) view.findViewById(R.id.write_video_state_text);
        this.nQj = (TextView) view.findViewById(R.id.write_video_percent);
        this.nQk = (TextView) view.findViewById(R.id.write_video_retry);
        this.nQk.setOnClickListener(this.fii);
        changeSkin();
    }

    public void onStart() {
        this.nQg.dWU();
    }

    public void onResume() {
        if (this.nQo != null && this.nQo.isLegal()) {
            this.nQg.Vd(this.nQo.finalPath);
        }
    }

    public void onPause() {
        this.nQg.cBc();
    }

    public void onStop() {
        this.nQg.dWV();
    }

    public void onDestroy() {
        if (this.nQl != null) {
            this.nQl.xQ(true);
        }
        if (this.nQm != null) {
            this.nQm.cancel();
        }
    }

    public boolean isVisible() {
        return this.nQg != null && this.nQg.getVisibility() == 0;
    }

    public void dWW() {
        if (this.nQo != null) {
            bTX();
            dG(1, 10);
            this.nQm = (com.baidu.tieba.c.b) MessageManager.getInstance().runTask(2921466, com.baidu.tieba.c.b.class, this.nQl).getData();
            if (this.nQm != null) {
                this.nQm.start();
            } else {
                dG(3, 0);
            }
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        if (videoInfo == null) {
            this.nQo = null;
        } else {
            this.nQo = videoInfo.getEditVideoData();
        }
        this.nQn = videoInfo;
        if (this.nQo != null && this.nQo.isLegal()) {
            this.nQh.setVisibility(0);
            this.nQg.setVisibility(0);
            this.nQg.setVideoInfo(this.nQo);
            return;
        }
        this.nQh.setVisibility(8);
        this.nQg.setVisibility(8);
        this.nQg.reset();
        if (this.nQl != null) {
            this.nQl.xQ(true);
        }
        if (this.nQm != null) {
            this.nQm.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dG(int i, int i2) {
        this.nQj.setText(String.format(this.eIc.getString(R.string.video_mix_percent), Integer.valueOf(i2)));
        if (i != this.nQp) {
            this.nQp = i;
            ap.setViewTextColor(this.nQi, this.nQp == 3 ? R.color.cp_cont_h : R.color.cp_cont_j);
            if (i == 1) {
                this.nQi.setText(this.eIc.getString(R.string.video_mixing));
                this.nQj.setVisibility(0);
                this.nQk.setVisibility(8);
            } else if (i == 3) {
                this.nQi.setText(this.eIc.getString(R.string.video_mix_failed));
                this.nQj.setVisibility(8);
                this.nQk.setVisibility(0);
            } else {
                this.nQi.setText(this.eIc.getString(R.string.video_mix_success));
                this.nQj.setVisibility(8);
                this.nQk.setVisibility(8);
            }
        }
        this.nQg.aS(i2 / 100.0f);
    }

    private void bTX() {
        if (this.nQl == null) {
            this.nQl = new b((WriteActivity) this.eIc.getPageActivity(), this.nQo) { // from class: com.baidu.tieba.write.write.video.a.2
                @Override // com.baidu.tieba.video.b
                public void onCancel() {
                    super.onCancel();
                }

                @Override // com.baidu.tieba.video.b
                public void dOm() {
                    a.this.eIc.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dG(1, 50);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bV(int i, String str) {
                    super.bV(i, str);
                    a.this.eIc.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dG(3, 0);
                            a.this.dWX();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void dOn() {
                    a.this.eIc.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dG(1, 100);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bW(int i, String str) {
                    super.bW(i, str);
                    a.this.eIc.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dG(3, 0);
                            a.this.dWX();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void a(VideoInfo videoInfo) {
                    String str;
                    super.a(videoInfo);
                    String videoPath = videoInfo.getVideoPath();
                    if (at.isEmpty(videoPath) || !videoPath.contains(c.nlN)) {
                        str = videoPath;
                    } else {
                        File file = new File(videoPath);
                        String str2 = c.nlO + file.getName();
                        n.copyFile(file.getAbsolutePath(), str2);
                        str = str2;
                    }
                    try {
                        a.this.bp(a.this.eIc.getPageActivity(), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.nQo.finalPath = str;
                    a.this.nQn.setVideoPath(str);
                    a.this.nQn.setThumbPath(this.coverPath);
                    a.this.nQg.Vd(str);
                    a.this.eIc.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dG(2, 100);
                            if (a.this.eIc != null && (a.this.eIc.getPageActivity() instanceof WriteActivity)) {
                                ((WriteActivity) a.this.eIc.getPageActivity()).dGA();
                            }
                        }
                    });
                }
            };
        } else {
            this.nQl.a(this.nQo);
        }
        this.nQl.xQ(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWX() {
        if (this.eIc != null && (this.eIc.getPageActivity() instanceof WriteActivity)) {
            ((WriteActivity) this.eIc.getPageActivity()).EQ(this.eIc.getString(R.string.write_video_mix_fail));
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
    public void dWY() {
        WriteActivity writeActivity;
        WriteData cXW;
        if (this.eIc != null && (this.eIc.getPageActivity() instanceof WriteActivity) && (cXW = (writeActivity = (WriteActivity) this.eIc.getPageActivity()).cXW()) != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(this.nQn);
            videoInfo.setVideoPath(this.nQo.originPath);
            videoInfo.getEditVideoData().finalPath = null;
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.eIc.getPageActivity(), writeActivity.getCallFrom(), cXW.getForumName(), cXW.getForumId(), "", videoInfo);
            editVideoActivityConfig.setProZone(cXW.getProZone());
            editVideoActivityConfig.setFrsTabInfo(writeActivity.dWi());
            editVideoActivityConfig.setFrom(writeActivity.getFrom());
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT);
            AntiData antiData = new AntiData();
            antiData.voice_message = writeActivity.fpM;
            antiData.setIfVoice(writeActivity.nNd);
            editVideoActivityConfig.setExtraData(antiData, writeActivity.mPrefixData, cXW.getFirstDir(), cXW.getSecondDir());
            editVideoActivityConfig.getIntent().setFlags(536870912);
            editVideoActivityConfig.getIntent().setFlags(67108864);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        }
    }

    public void changeSkin() {
        this.nQg.changeSkin();
        ap.setViewTextColor(this.nQi, this.nQp == 3 ? R.color.cp_cont_h : R.color.cp_cont_j);
        ap.setViewTextColor(this.nQj, R.color.cp_cont_d);
        ap.setViewTextColor(this.nQk, R.color.cp_link_tip_a);
    }
}
