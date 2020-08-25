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
    private TbPageContext efn;
    private PreviewVideoView mYa;
    private LinearLayout mYb;
    private TextView mYc;
    private TextView mYd;
    private TextView mYe;
    private b mYf;
    private com.baidu.tieba.c.b mYg;
    private VideoInfo mYh;
    private EditVideoData mYi;
    private int mYj = 0;
    private View.OnClickListener eFC = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.video.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.mYe) {
                if (view == a.this.mYa.mXU) {
                    if (a.this.efn.getPageActivity() instanceof WriteActivity) {
                        a.this.onDestroy();
                        ((WriteActivity) a.this.efn.getPageActivity()).xr(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                        return;
                    }
                    return;
                } else if (a.this.mYj != 1) {
                    a.this.dJx();
                    return;
                } else {
                    return;
                }
            }
            a.this.dJv();
        }
    };

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.efn = tbPageContext;
        this.mYa = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.mYa.setOnClickListener(this.eFC);
        this.mYb = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.mYc = (TextView) view.findViewById(R.id.write_video_state_text);
        this.mYd = (TextView) view.findViewById(R.id.write_video_percent);
        this.mYe = (TextView) view.findViewById(R.id.write_video_retry);
        this.mYe.setOnClickListener(this.eFC);
        changeSkin();
    }

    public void onStart() {
        this.mYa.dJt();
    }

    public void onResume() {
        if (this.mYi != null && this.mYi.isLegal()) {
            this.mYa.Ta(this.mYi.finalPath);
        }
    }

    public void onPause() {
        this.mYa.coJ();
    }

    public void onStop() {
        this.mYa.dJu();
    }

    public void onDestroy() {
        if (this.mYf != null) {
            this.mYf.wy(true);
        }
        if (this.mYg != null) {
            this.mYg.cancel();
        }
    }

    public boolean isVisible() {
        return this.mYa != null && this.mYa.getVisibility() == 0;
    }

    public void dJv() {
        if (this.mYi != null) {
            bKY();
            dy(1, 10);
            this.mYg = (com.baidu.tieba.c.b) MessageManager.getInstance().runTask(2921466, com.baidu.tieba.c.b.class, this.mYf).getData();
            if (this.mYg != null) {
                this.mYg.start();
            } else {
                dy(3, 0);
            }
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        if (videoInfo == null) {
            this.mYi = null;
        } else {
            this.mYi = videoInfo.getEditVideoData();
        }
        this.mYh = videoInfo;
        if (this.mYi != null && this.mYi.isLegal()) {
            this.mYb.setVisibility(0);
            this.mYa.setVisibility(0);
            this.mYa.setVideoInfo(this.mYi);
            return;
        }
        this.mYb.setVisibility(8);
        this.mYa.setVisibility(8);
        this.mYa.reset();
        if (this.mYf != null) {
            this.mYf.wy(true);
        }
        if (this.mYg != null) {
            this.mYg.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dy(int i, int i2) {
        this.mYd.setText(String.format(this.efn.getString(R.string.video_mix_percent), Integer.valueOf(i2)));
        if (i != this.mYj) {
            this.mYj = i;
            ap.setViewTextColor(this.mYc, this.mYj == 3 ? R.color.cp_cont_h : R.color.cp_cont_j);
            if (i == 1) {
                this.mYc.setText(this.efn.getString(R.string.video_mixing));
                this.mYd.setVisibility(0);
                this.mYe.setVisibility(8);
            } else if (i == 3) {
                this.mYc.setText(this.efn.getString(R.string.video_mix_failed));
                this.mYd.setVisibility(8);
                this.mYe.setVisibility(0);
            } else {
                this.mYc.setText(this.efn.getString(R.string.video_mix_success));
                this.mYd.setVisibility(8);
                this.mYe.setVisibility(8);
            }
        }
        this.mYa.aI(i2 / 100.0f);
    }

    private void bKY() {
        if (this.mYf == null) {
            this.mYf = new b((WriteActivity) this.efn.getPageActivity(), this.mYi) { // from class: com.baidu.tieba.write.write.video.a.2
                @Override // com.baidu.tieba.video.b
                public void onCancel() {
                    super.onCancel();
                }

                @Override // com.baidu.tieba.video.b
                public void dAN() {
                    a.this.efn.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dy(1, 50);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bD(int i, String str) {
                    super.bD(i, str);
                    a.this.efn.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dy(3, 0);
                            a.this.dJw();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void dAO() {
                    a.this.efn.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dy(1, 100);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bE(int i, String str) {
                    super.bE(i, str);
                    a.this.efn.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dy(3, 0);
                            a.this.dJw();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void a(VideoInfo videoInfo) {
                    String str;
                    super.a(videoInfo);
                    String videoPath = videoInfo.getVideoPath();
                    if (at.isEmpty(videoPath) || !videoPath.contains(c.mtA)) {
                        str = videoPath;
                    } else {
                        File file = new File(videoPath);
                        String str2 = c.mtB + file.getName();
                        n.copyFile(file.getAbsolutePath(), str2);
                        str = str2;
                    }
                    try {
                        a.this.be(a.this.efn.getPageActivity(), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.mYi.finalPath = str;
                    a.this.mYh.setVideoPath(str);
                    a.this.mYh.setThumbPath(this.coverPath);
                    a.this.mYa.Ta(str);
                    a.this.efn.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dy(2, 100);
                            if (a.this.efn != null && (a.this.efn.getPageActivity() instanceof WriteActivity)) {
                                ((WriteActivity) a.this.efn.getPageActivity()).dth();
                            }
                        }
                    });
                }
            };
        } else {
            this.mYf.a(this.mYi);
        }
        this.mYf.wy(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJw() {
        if (this.efn != null && (this.efn.getPageActivity() instanceof WriteActivity)) {
            ((WriteActivity) this.efn.getPageActivity()).SU(this.efn.getString(R.string.write_video_mix_fail));
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
    public void dJx() {
        WriteActivity writeActivity;
        WriteData cKZ;
        if (this.efn != null && (this.efn.getPageActivity() instanceof WriteActivity) && (cKZ = (writeActivity = (WriteActivity) this.efn.getPageActivity()).cKZ()) != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(this.mYh);
            videoInfo.setVideoPath(this.mYi.originPath);
            videoInfo.getEditVideoData().finalPath = null;
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.efn.getPageActivity(), writeActivity.getCallFrom(), cKZ.getForumName(), cKZ.getForumId(), "", videoInfo);
            editVideoActivityConfig.setProZone(cKZ.getProZone());
            editVideoActivityConfig.setFrsTabInfo(writeActivity.dII());
            editVideoActivityConfig.setFrom(writeActivity.getFrom());
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT);
            AntiData antiData = new AntiData();
            antiData.voice_message = writeActivity.eMt;
            antiData.setIfVoice(writeActivity.mUZ);
            editVideoActivityConfig.setExtraData(antiData, writeActivity.mPrefixData, cKZ.getFirstDir(), cKZ.getSecondDir());
            editVideoActivityConfig.getIntent().setFlags(536870912);
            editVideoActivityConfig.getIntent().setFlags(67108864);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        }
    }

    public void changeSkin() {
        this.mYa.changeSkin();
        ap.setViewTextColor(this.mYc, this.mYj == 3 ? R.color.cp_cont_h : R.color.cp_cont_j);
        ap.setViewTextColor(this.mYd, R.color.cp_cont_d);
        ap.setViewTextColor(this.mYe, R.color.cp_link_tip_a);
    }
}
