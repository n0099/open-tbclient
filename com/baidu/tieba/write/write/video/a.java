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
import com.baidu.tbadk.core.util.as;
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
/* loaded from: classes3.dex */
public class a {
    private TbPageContext dVN;
    private PreviewVideoView mFa;
    private LinearLayout mFb;
    private TextView mFc;
    private TextView mFe;
    private TextView mFf;
    private b mFg;
    private com.baidu.tieba.c.b mFh;
    private VideoInfo mFi;
    private EditVideoData mFj;
    private int mFk = 0;
    private View.OnClickListener eve = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.video.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.mFf) {
                if (view == a.this.mFa.mEU) {
                    if (a.this.dVN.getPageActivity() instanceof WriteActivity) {
                        a.this.onDestroy();
                        ((WriteActivity) a.this.dVN.getPageActivity()).wB(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                        return;
                    }
                    return;
                } else if (a.this.mFk != 1) {
                    a.this.dxK();
                    return;
                } else {
                    return;
                }
            }
            a.this.dxI();
        }
    };

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.dVN = tbPageContext;
        this.mFa = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.mFa.setOnClickListener(this.eve);
        this.mFb = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.mFc = (TextView) view.findViewById(R.id.write_video_state_text);
        this.mFe = (TextView) view.findViewById(R.id.write_video_percent);
        this.mFf = (TextView) view.findViewById(R.id.write_video_retry);
        this.mFf.setOnClickListener(this.eve);
        changeSkin();
    }

    public void onStart() {
        this.mFa.dxG();
    }

    public void onResume() {
        if (this.mFj != null && this.mFj.isLegal()) {
            this.mFa.Qb(this.mFj.finalPath);
        }
    }

    public void onPause() {
        this.mFa.cef();
    }

    public void onStop() {
        this.mFa.dxH();
    }

    public void onDestroy() {
        if (this.mFg != null) {
            this.mFg.vJ(true);
        }
        if (this.mFh != null) {
            this.mFh.cancel();
        }
    }

    public boolean isVisible() {
        return this.mFa != null && this.mFa.getVisibility() == 0;
    }

    public void dxI() {
        if (this.mFj != null) {
            bBE();
            dq(1, 10);
            this.mFh = (com.baidu.tieba.c.b) MessageManager.getInstance().runTask(2921466, com.baidu.tieba.c.b.class, this.mFg).getData();
            if (this.mFh != null) {
                this.mFh.start();
            } else {
                dq(3, 0);
            }
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        if (videoInfo == null) {
            this.mFj = null;
        } else {
            this.mFj = videoInfo.getEditVideoData();
        }
        this.mFi = videoInfo;
        if (this.mFj != null && this.mFj.isLegal()) {
            this.mFb.setVisibility(0);
            this.mFa.setVisibility(0);
            this.mFa.setVideoInfo(this.mFj);
            return;
        }
        this.mFb.setVisibility(8);
        this.mFa.setVisibility(8);
        this.mFa.reset();
        if (this.mFg != null) {
            this.mFg.vJ(true);
        }
        if (this.mFh != null) {
            this.mFh.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dq(int i, int i2) {
        this.mFe.setText(String.format(this.dVN.getString(R.string.video_mix_percent), Integer.valueOf(i2)));
        if (i != this.mFk) {
            this.mFk = i;
            ao.setViewTextColor(this.mFc, this.mFk == 3 ? R.color.cp_cont_h : R.color.cp_cont_j);
            if (i == 1) {
                this.mFc.setText(this.dVN.getString(R.string.video_mixing));
                this.mFe.setVisibility(0);
                this.mFf.setVisibility(8);
            } else if (i == 3) {
                this.mFc.setText(this.dVN.getString(R.string.video_mix_failed));
                this.mFe.setVisibility(8);
                this.mFf.setVisibility(0);
            } else {
                this.mFc.setText(this.dVN.getString(R.string.video_mix_success));
                this.mFe.setVisibility(8);
                this.mFf.setVisibility(8);
            }
        }
        this.mFa.aC(i2 / 100.0f);
    }

    private void bBE() {
        if (this.mFg == null) {
            this.mFg = new b((WriteActivity) this.dVN.getPageActivity(), this.mFj) { // from class: com.baidu.tieba.write.write.video.a.2
                @Override // com.baidu.tieba.video.b
                public void onCancel() {
                    super.onCancel();
                }

                @Override // com.baidu.tieba.video.b
                public void dps() {
                    a.this.dVN.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dq(1, 50);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bF(int i, String str) {
                    super.bF(i, str);
                    a.this.dVN.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dq(3, 0);
                            a.this.dxJ();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void dpt() {
                    a.this.dVN.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dq(1, 100);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bG(int i, String str) {
                    super.bG(i, str);
                    a.this.dVN.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dq(3, 0);
                            a.this.dxJ();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void a(VideoInfo videoInfo) {
                    String str;
                    super.a(videoInfo);
                    String videoPath = videoInfo.getVideoPath();
                    if (as.isEmpty(videoPath) || !videoPath.contains(c.mbP)) {
                        str = videoPath;
                    } else {
                        File file = new File(videoPath);
                        String str2 = c.mbQ + file.getName();
                        n.copyFile(file.getAbsolutePath(), str2);
                        str = str2;
                    }
                    try {
                        a.this.aZ(a.this.dVN.getPageActivity(), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.mFj.finalPath = str;
                    a.this.mFi.setVideoPath(str);
                    a.this.mFi.setThumbPath(this.coverPath);
                    a.this.mFa.Qb(str);
                    a.this.dVN.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dq(2, 100);
                            if (a.this.dVN != null && (a.this.dVN.getPageActivity() instanceof WriteActivity)) {
                                ((WriteActivity) a.this.dVN.getPageActivity()).dhM();
                            }
                        }
                    });
                }
            };
        } else {
            this.mFg.a(this.mFj);
        }
        this.mFg.vJ(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxJ() {
        if (this.dVN != null && (this.dVN.getPageActivity() instanceof WriteActivity)) {
            ((WriteActivity) this.dVN.getPageActivity()).PW(this.dVN.getString(R.string.write_video_mix_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(Context context, String str) {
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
    public void dxK() {
        WriteActivity writeActivity;
        WriteData dhF;
        if (this.dVN != null && (this.dVN.getPageActivity() instanceof WriteActivity) && (dhF = (writeActivity = (WriteActivity) this.dVN.getPageActivity()).dhF()) != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(this.mFi);
            videoInfo.setVideoPath(this.mFj.originPath);
            videoInfo.getEditVideoData().finalPath = null;
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.dVN.getPageActivity(), writeActivity.getCallFrom(), dhF.getForumName(), dhF.getForumId(), "", videoInfo);
            editVideoActivityConfig.setProZone(dhF.getProZone());
            editVideoActivityConfig.setFrsTabInfo(writeActivity.dwY());
            editVideoActivityConfig.setFrom(writeActivity.getFrom());
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT);
            AntiData antiData = new AntiData();
            antiData.voice_message = writeActivity.eBU;
            antiData.setIfVoice(writeActivity.mCk);
            editVideoActivityConfig.setExtraData(antiData, writeActivity.mPrefixData, dhF.getFirstDir(), dhF.getSecondDir());
            editVideoActivityConfig.getIntent().setFlags(536870912);
            editVideoActivityConfig.getIntent().setFlags(67108864);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        }
    }

    public void changeSkin() {
        this.mFa.changeSkin();
        ao.setViewTextColor(this.mFc, this.mFk == 3 ? R.color.cp_cont_h : R.color.cp_cont_j);
        ao.setViewTextColor(this.mFe, R.color.cp_cont_d);
        ao.setViewTextColor(this.mFf, R.color.cp_link_tip_a);
    }
}
