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
    private PreviewVideoView mEY;
    private LinearLayout mEZ;
    private TextView mFa;
    private TextView mFb;
    private TextView mFc;
    private b mFe;
    private com.baidu.tieba.c.b mFf;
    private VideoInfo mFg;
    private EditVideoData mFh;
    private int mFi = 0;
    private View.OnClickListener eve = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.video.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.mFc) {
                if (view == a.this.mEY.mES) {
                    if (a.this.dVN.getPageActivity() instanceof WriteActivity) {
                        a.this.onDestroy();
                        ((WriteActivity) a.this.dVN.getPageActivity()).wB(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                        return;
                    }
                    return;
                } else if (a.this.mFi != 1) {
                    a.this.dxJ();
                    return;
                } else {
                    return;
                }
            }
            a.this.dxH();
        }
    };

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.dVN = tbPageContext;
        this.mEY = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.mEY.setOnClickListener(this.eve);
        this.mEZ = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.mFa = (TextView) view.findViewById(R.id.write_video_state_text);
        this.mFb = (TextView) view.findViewById(R.id.write_video_percent);
        this.mFc = (TextView) view.findViewById(R.id.write_video_retry);
        this.mFc.setOnClickListener(this.eve);
        changeSkin();
    }

    public void onStart() {
        this.mEY.dxF();
    }

    public void onResume() {
        if (this.mFh != null && this.mFh.isLegal()) {
            this.mEY.Qb(this.mFh.finalPath);
        }
    }

    public void onPause() {
        this.mEY.cef();
    }

    public void onStop() {
        this.mEY.dxG();
    }

    public void onDestroy() {
        if (this.mFe != null) {
            this.mFe.vJ(true);
        }
        if (this.mFf != null) {
            this.mFf.cancel();
        }
    }

    public boolean isVisible() {
        return this.mEY != null && this.mEY.getVisibility() == 0;
    }

    public void dxH() {
        if (this.mFh != null) {
            bBE();
            dq(1, 10);
            this.mFf = (com.baidu.tieba.c.b) MessageManager.getInstance().runTask(2921466, com.baidu.tieba.c.b.class, this.mFe).getData();
            if (this.mFf != null) {
                this.mFf.start();
            } else {
                dq(3, 0);
            }
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        if (videoInfo == null) {
            this.mFh = null;
        } else {
            this.mFh = videoInfo.getEditVideoData();
        }
        this.mFg = videoInfo;
        if (this.mFh != null && this.mFh.isLegal()) {
            this.mEZ.setVisibility(0);
            this.mEY.setVisibility(0);
            this.mEY.setVideoInfo(this.mFh);
            return;
        }
        this.mEZ.setVisibility(8);
        this.mEY.setVisibility(8);
        this.mEY.reset();
        if (this.mFe != null) {
            this.mFe.vJ(true);
        }
        if (this.mFf != null) {
            this.mFf.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dq(int i, int i2) {
        this.mFb.setText(String.format(this.dVN.getString(R.string.video_mix_percent), Integer.valueOf(i2)));
        if (i != this.mFi) {
            this.mFi = i;
            ao.setViewTextColor(this.mFa, this.mFi == 3 ? R.color.cp_cont_h : R.color.cp_cont_j);
            if (i == 1) {
                this.mFa.setText(this.dVN.getString(R.string.video_mixing));
                this.mFb.setVisibility(0);
                this.mFc.setVisibility(8);
            } else if (i == 3) {
                this.mFa.setText(this.dVN.getString(R.string.video_mix_failed));
                this.mFb.setVisibility(8);
                this.mFc.setVisibility(0);
            } else {
                this.mFa.setText(this.dVN.getString(R.string.video_mix_success));
                this.mFb.setVisibility(8);
                this.mFc.setVisibility(8);
            }
        }
        this.mEY.aC(i2 / 100.0f);
    }

    private void bBE() {
        if (this.mFe == null) {
            this.mFe = new b((WriteActivity) this.dVN.getPageActivity(), this.mFh) { // from class: com.baidu.tieba.write.write.video.a.2
                @Override // com.baidu.tieba.video.b
                public void onCancel() {
                    super.onCancel();
                }

                @Override // com.baidu.tieba.video.b
                public void dpr() {
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
                            a.this.dxI();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void dps() {
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
                            a.this.dxI();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void a(VideoInfo videoInfo) {
                    String str;
                    super.a(videoInfo);
                    String videoPath = videoInfo.getVideoPath();
                    if (as.isEmpty(videoPath) || !videoPath.contains(c.mbN)) {
                        str = videoPath;
                    } else {
                        File file = new File(videoPath);
                        String str2 = c.mbO + file.getName();
                        n.copyFile(file.getAbsolutePath(), str2);
                        str = str2;
                    }
                    try {
                        a.this.aZ(a.this.dVN.getPageActivity(), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.mFh.finalPath = str;
                    a.this.mFg.setVideoPath(str);
                    a.this.mFg.setThumbPath(this.coverPath);
                    a.this.mEY.Qb(str);
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
            this.mFe.a(this.mFh);
        }
        this.mFe.vJ(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxI() {
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
    public void dxJ() {
        WriteActivity writeActivity;
        WriteData dhF;
        if (this.dVN != null && (this.dVN.getPageActivity() instanceof WriteActivity) && (dhF = (writeActivity = (WriteActivity) this.dVN.getPageActivity()).dhF()) != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(this.mFg);
            videoInfo.setVideoPath(this.mFh.originPath);
            videoInfo.getEditVideoData().finalPath = null;
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.dVN.getPageActivity(), writeActivity.getCallFrom(), dhF.getForumName(), dhF.getForumId(), "", videoInfo);
            editVideoActivityConfig.setProZone(dhF.getProZone());
            editVideoActivityConfig.setFrsTabInfo(writeActivity.dwX());
            editVideoActivityConfig.setFrom(writeActivity.getFrom());
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT);
            AntiData antiData = new AntiData();
            antiData.voice_message = writeActivity.eBU;
            antiData.setIfVoice(writeActivity.mCi);
            editVideoActivityConfig.setExtraData(antiData, writeActivity.mPrefixData, dhF.getFirstDir(), dhF.getSecondDir());
            editVideoActivityConfig.getIntent().setFlags(536870912);
            editVideoActivityConfig.getIntent().setFlags(67108864);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        }
    }

    public void changeSkin() {
        this.mEY.changeSkin();
        ao.setViewTextColor(this.mFa, this.mFi == 3 ? R.color.cp_cont_h : R.color.cp_cont_j);
        ao.setViewTextColor(this.mFb, R.color.cp_cont_d);
        ao.setViewTextColor(this.mFc, R.color.cp_link_tip_a);
    }
}
