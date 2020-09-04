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
    private TbPageContext efr;
    private EditVideoData mYA;
    private PreviewVideoView mYs;
    private LinearLayout mYt;
    private TextView mYu;
    private TextView mYv;
    private TextView mYw;
    private b mYx;
    private com.baidu.tieba.c.b mYy;
    private VideoInfo mYz;
    private int mYB = 0;
    private View.OnClickListener eFG = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.video.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.mYw) {
                if (view == a.this.mYs.mYm) {
                    if (a.this.efr.getPageActivity() instanceof WriteActivity) {
                        a.this.onDestroy();
                        ((WriteActivity) a.this.efr.getPageActivity()).xt(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                        return;
                    }
                    return;
                } else if (a.this.mYB != 1) {
                    a.this.dJG();
                    return;
                } else {
                    return;
                }
            }
            a.this.dJE();
        }
    };

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.efr = tbPageContext;
        this.mYs = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.mYs.setOnClickListener(this.eFG);
        this.mYt = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.mYu = (TextView) view.findViewById(R.id.write_video_state_text);
        this.mYv = (TextView) view.findViewById(R.id.write_video_percent);
        this.mYw = (TextView) view.findViewById(R.id.write_video_retry);
        this.mYw.setOnClickListener(this.eFG);
        changeSkin();
    }

    public void onStart() {
        this.mYs.dJC();
    }

    public void onResume() {
        if (this.mYA != null && this.mYA.isLegal()) {
            this.mYs.Ta(this.mYA.finalPath);
        }
    }

    public void onPause() {
        this.mYs.coK();
    }

    public void onStop() {
        this.mYs.dJD();
    }

    public void onDestroy() {
        if (this.mYx != null) {
            this.mYx.wA(true);
        }
        if (this.mYy != null) {
            this.mYy.cancel();
        }
    }

    public boolean isVisible() {
        return this.mYs != null && this.mYs.getVisibility() == 0;
    }

    public void dJE() {
        if (this.mYA != null) {
            bKZ();
            dy(1, 10);
            this.mYy = (com.baidu.tieba.c.b) MessageManager.getInstance().runTask(2921466, com.baidu.tieba.c.b.class, this.mYx).getData();
            if (this.mYy != null) {
                this.mYy.start();
            } else {
                dy(3, 0);
            }
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        if (videoInfo == null) {
            this.mYA = null;
        } else {
            this.mYA = videoInfo.getEditVideoData();
        }
        this.mYz = videoInfo;
        if (this.mYA != null && this.mYA.isLegal()) {
            this.mYt.setVisibility(0);
            this.mYs.setVisibility(0);
            this.mYs.setVideoInfo(this.mYA);
            return;
        }
        this.mYt.setVisibility(8);
        this.mYs.setVisibility(8);
        this.mYs.reset();
        if (this.mYx != null) {
            this.mYx.wA(true);
        }
        if (this.mYy != null) {
            this.mYy.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dy(int i, int i2) {
        this.mYv.setText(String.format(this.efr.getString(R.string.video_mix_percent), Integer.valueOf(i2)));
        if (i != this.mYB) {
            this.mYB = i;
            ap.setViewTextColor(this.mYu, this.mYB == 3 ? R.color.cp_cont_h : R.color.cp_cont_j);
            if (i == 1) {
                this.mYu.setText(this.efr.getString(R.string.video_mixing));
                this.mYv.setVisibility(0);
                this.mYw.setVisibility(8);
            } else if (i == 3) {
                this.mYu.setText(this.efr.getString(R.string.video_mix_failed));
                this.mYv.setVisibility(8);
                this.mYw.setVisibility(0);
            } else {
                this.mYu.setText(this.efr.getString(R.string.video_mix_success));
                this.mYv.setVisibility(8);
                this.mYw.setVisibility(8);
            }
        }
        this.mYs.aI(i2 / 100.0f);
    }

    private void bKZ() {
        if (this.mYx == null) {
            this.mYx = new b((WriteActivity) this.efr.getPageActivity(), this.mYA) { // from class: com.baidu.tieba.write.write.video.a.2
                @Override // com.baidu.tieba.video.b
                public void onCancel() {
                    super.onCancel();
                }

                @Override // com.baidu.tieba.video.b
                public void dAW() {
                    a.this.efr.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dy(1, 50);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bC(int i, String str) {
                    super.bC(i, str);
                    a.this.efr.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dy(3, 0);
                            a.this.dJF();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void dAX() {
                    a.this.efr.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dy(1, 100);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bD(int i, String str) {
                    super.bD(i, str);
                    a.this.efr.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dy(3, 0);
                            a.this.dJF();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void a(VideoInfo videoInfo) {
                    String str;
                    super.a(videoInfo);
                    String videoPath = videoInfo.getVideoPath();
                    if (at.isEmpty(videoPath) || !videoPath.contains(c.mtS)) {
                        str = videoPath;
                    } else {
                        File file = new File(videoPath);
                        String str2 = c.mtT + file.getName();
                        n.copyFile(file.getAbsolutePath(), str2);
                        str = str2;
                    }
                    try {
                        a.this.be(a.this.efr.getPageActivity(), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.mYA.finalPath = str;
                    a.this.mYz.setVideoPath(str);
                    a.this.mYz.setThumbPath(this.coverPath);
                    a.this.mYs.Ta(str);
                    a.this.efr.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dy(2, 100);
                            if (a.this.efr != null && (a.this.efr.getPageActivity() instanceof WriteActivity)) {
                                ((WriteActivity) a.this.efr.getPageActivity()).dtm();
                            }
                        }
                    });
                }
            };
        } else {
            this.mYx.a(this.mYA);
        }
        this.mYx.wA(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJF() {
        if (this.efr != null && (this.efr.getPageActivity() instanceof WriteActivity)) {
            ((WriteActivity) this.efr.getPageActivity()).SU(this.efr.getString(R.string.write_video_mix_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(Context context, String str) {
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
    public void dJG() {
        WriteActivity writeActivity;
        WriteData cLa;
        if (this.efr != null && (this.efr.getPageActivity() instanceof WriteActivity) && (cLa = (writeActivity = (WriteActivity) this.efr.getPageActivity()).cLa()) != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(this.mYz);
            videoInfo.setVideoPath(this.mYA.originPath);
            videoInfo.getEditVideoData().finalPath = null;
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.efr.getPageActivity(), writeActivity.getCallFrom(), cLa.getForumName(), cLa.getForumId(), "", videoInfo);
            editVideoActivityConfig.setProZone(cLa.getProZone());
            editVideoActivityConfig.setFrsTabInfo(writeActivity.dIR());
            editVideoActivityConfig.setFrom(writeActivity.getFrom());
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT);
            AntiData antiData = new AntiData();
            antiData.voice_message = writeActivity.eMx;
            antiData.setIfVoice(writeActivity.mVr);
            editVideoActivityConfig.setExtraData(antiData, writeActivity.mPrefixData, cLa.getFirstDir(), cLa.getSecondDir());
            editVideoActivityConfig.getIntent().setFlags(536870912);
            editVideoActivityConfig.getIntent().setFlags(67108864);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        }
    }

    public void changeSkin() {
        this.mYs.changeSkin();
        ap.setViewTextColor(this.mYu, this.mYB == 3 ? R.color.cp_cont_h : R.color.cp_cont_j);
        ap.setViewTextColor(this.mYv, R.color.cp_cont_d);
        ap.setViewTextColor(this.mYw, R.color.cp_link_tip_a);
    }
}
