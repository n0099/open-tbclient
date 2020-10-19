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
    private TbPageContext etO;
    private PreviewVideoView nxO;
    private LinearLayout nxP;
    private TextView nxQ;
    private TextView nxR;
    private TextView nxS;
    private b nxT;
    private com.baidu.tieba.c.b nxU;
    private VideoInfo nxV;
    private EditVideoData nxW;
    private int nxX = 0;
    private View.OnClickListener eTU = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.video.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.nxS) {
                if (view == a.this.nxO.nxJ) {
                    if (a.this.etO.getPageActivity() instanceof WriteActivity) {
                        a.this.onDestroy();
                        ((WriteActivity) a.this.etO.getPageActivity()).yj(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                        return;
                    }
                    return;
                } else if (a.this.nxX != 1) {
                    a.this.dRq();
                    return;
                } else {
                    return;
                }
            }
            a.this.dRo();
        }
    };

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.etO = tbPageContext;
        this.nxO = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.nxO.setOnClickListener(this.eTU);
        this.nxP = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.nxQ = (TextView) view.findViewById(R.id.write_video_state_text);
        this.nxR = (TextView) view.findViewById(R.id.write_video_percent);
        this.nxS = (TextView) view.findViewById(R.id.write_video_retry);
        this.nxS.setOnClickListener(this.eTU);
        changeSkin();
    }

    public void onStart() {
        this.nxO.dRm();
    }

    public void onResume() {
        if (this.nxW != null && this.nxW.isLegal()) {
            this.nxO.Un(this.nxW.finalPath);
        }
    }

    public void onPause() {
        this.nxO.cvu();
    }

    public void onStop() {
        this.nxO.dRn();
    }

    public void onDestroy() {
        if (this.nxT != null) {
            this.nxT.xq(true);
        }
        if (this.nxU != null) {
            this.nxU.cancel();
        }
    }

    public boolean isVisible() {
        return this.nxO != null && this.nxO.getVisibility() == 0;
    }

    public void dRo() {
        if (this.nxW != null) {
            bOT();
            dC(1, 10);
            this.nxU = (com.baidu.tieba.c.b) MessageManager.getInstance().runTask(2921466, com.baidu.tieba.c.b.class, this.nxT).getData();
            if (this.nxU != null) {
                this.nxU.start();
            } else {
                dC(3, 0);
            }
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        if (videoInfo == null) {
            this.nxW = null;
        } else {
            this.nxW = videoInfo.getEditVideoData();
        }
        this.nxV = videoInfo;
        if (this.nxW != null && this.nxW.isLegal()) {
            this.nxP.setVisibility(0);
            this.nxO.setVisibility(0);
            this.nxO.setVideoInfo(this.nxW);
            return;
        }
        this.nxP.setVisibility(8);
        this.nxO.setVisibility(8);
        this.nxO.reset();
        if (this.nxT != null) {
            this.nxT.xq(true);
        }
        if (this.nxU != null) {
            this.nxU.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dC(int i, int i2) {
        this.nxR.setText(String.format(this.etO.getString(R.string.video_mix_percent), Integer.valueOf(i2)));
        if (i != this.nxX) {
            this.nxX = i;
            ap.setViewTextColor(this.nxQ, this.nxX == 3 ? R.color.cp_cont_h : R.color.cp_cont_j);
            if (i == 1) {
                this.nxQ.setText(this.etO.getString(R.string.video_mixing));
                this.nxR.setVisibility(0);
                this.nxS.setVisibility(8);
            } else if (i == 3) {
                this.nxQ.setText(this.etO.getString(R.string.video_mix_failed));
                this.nxR.setVisibility(8);
                this.nxS.setVisibility(0);
            } else {
                this.nxQ.setText(this.etO.getString(R.string.video_mix_success));
                this.nxR.setVisibility(8);
                this.nxS.setVisibility(8);
            }
        }
        this.nxO.aO(i2 / 100.0f);
    }

    private void bOT() {
        if (this.nxT == null) {
            this.nxT = new b((WriteActivity) this.etO.getPageActivity(), this.nxW) { // from class: com.baidu.tieba.write.write.video.a.2
                @Override // com.baidu.tieba.video.b
                public void onCancel() {
                    super.onCancel();
                }

                @Override // com.baidu.tieba.video.b
                public void dIC() {
                    a.this.etO.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dC(1, 50);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bQ(int i, String str) {
                    super.bQ(i, str);
                    a.this.etO.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dC(3, 0);
                            a.this.dRp();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void dID() {
                    a.this.etO.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dC(1, 100);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bR(int i, String str) {
                    super.bR(i, str);
                    a.this.etO.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dC(3, 0);
                            a.this.dRp();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void a(VideoInfo videoInfo) {
                    String str;
                    super.a(videoInfo);
                    String videoPath = videoInfo.getVideoPath();
                    if (at.isEmpty(videoPath) || !videoPath.contains(c.mTq)) {
                        str = videoPath;
                    } else {
                        File file = new File(videoPath);
                        String str2 = c.mTr + file.getName();
                        n.copyFile(file.getAbsolutePath(), str2);
                        str = str2;
                    }
                    try {
                        a.this.bn(a.this.etO.getPageActivity(), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.nxW.finalPath = str;
                    a.this.nxV.setVideoPath(str);
                    a.this.nxV.setThumbPath(this.coverPath);
                    a.this.nxO.Un(str);
                    a.this.etO.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dC(2, 100);
                            if (a.this.etO != null && (a.this.etO.getPageActivity() instanceof WriteActivity)) {
                                ((WriteActivity) a.this.etO.getPageActivity()).dAQ();
                            }
                        }
                    });
                }
            };
        } else {
            this.nxT.a(this.nxW);
        }
        this.nxT.xq(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRp() {
        if (this.etO != null && (this.etO.getPageActivity() instanceof WriteActivity)) {
            ((WriteActivity) this.etO.getPageActivity()).Ej(this.etO.getString(R.string.write_video_mix_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bn(Context context, String str) {
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
    public void dRq() {
        WriteActivity writeActivity;
        WriteData cSo;
        if (this.etO != null && (this.etO.getPageActivity() instanceof WriteActivity) && (cSo = (writeActivity = (WriteActivity) this.etO.getPageActivity()).cSo()) != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(this.nxV);
            videoInfo.setVideoPath(this.nxW.originPath);
            videoInfo.getEditVideoData().finalPath = null;
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.etO.getPageActivity(), writeActivity.getCallFrom(), cSo.getForumName(), cSo.getForumId(), "", videoInfo);
            editVideoActivityConfig.setProZone(cSo.getProZone());
            editVideoActivityConfig.setFrsTabInfo(writeActivity.dQA());
            editVideoActivityConfig.setFrom(writeActivity.getFrom());
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT);
            AntiData antiData = new AntiData();
            antiData.voice_message = writeActivity.fbv;
            antiData.setIfVoice(writeActivity.nuL);
            editVideoActivityConfig.setExtraData(antiData, writeActivity.mPrefixData, cSo.getFirstDir(), cSo.getSecondDir());
            editVideoActivityConfig.getIntent().setFlags(536870912);
            editVideoActivityConfig.getIntent().setFlags(67108864);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        }
    }

    public void changeSkin() {
        this.nxO.changeSkin();
        ap.setViewTextColor(this.nxQ, this.nxX == 3 ? R.color.cp_cont_h : R.color.cp_cont_j);
        ap.setViewTextColor(this.nxR, R.color.cp_cont_d);
        ap.setViewTextColor(this.nxS, R.color.cp_link_tip_a);
    }
}
