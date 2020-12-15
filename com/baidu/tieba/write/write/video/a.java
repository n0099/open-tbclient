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
    private TbPageContext eNx;
    private PreviewVideoView ogJ;
    private LinearLayout ogK;
    private TextView ogL;
    private TextView ogM;
    private TextView ogN;
    private b ogO;
    private com.baidu.tieba.d.b ogP;
    private VideoInfo ogQ;
    private EditVideoData ogR;
    private int ogS = 0;
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.video.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.ogN) {
                if (view == a.this.ogJ.ogE) {
                    if (a.this.eNx.getPageActivity() instanceof WriteActivity) {
                        a.this.onDestroy();
                        ((WriteActivity) a.this.eNx.getPageActivity()).aC(true, false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                        return;
                    }
                    return;
                } else if (a.this.ogS != 1) {
                    a.this.ecC();
                    return;
                } else {
                    return;
                }
            }
            a.this.ecA();
        }
    };

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.eNx = tbPageContext;
        this.ogJ = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.ogJ.setOnClickListener(this.foP);
        this.ogK = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.ogL = (TextView) view.findViewById(R.id.write_video_state_text);
        this.ogM = (TextView) view.findViewById(R.id.write_video_percent);
        this.ogN = (TextView) view.findViewById(R.id.write_video_retry);
        this.ogN.setOnClickListener(this.foP);
        bvs();
    }

    public void onStart() {
        this.ogJ.ecy();
    }

    public void onResume() {
        if (this.ogR != null && this.ogR.isLegal()) {
            this.ogJ.Wd(this.ogR.finalPath);
        }
    }

    public void onPause() {
        this.ogJ.cEW();
    }

    public void onStop() {
        this.ogJ.ecz();
    }

    public void onDestroy() {
        if (this.ogO != null) {
            this.ogO.yC(true);
        }
        if (this.ogP != null) {
            this.ogP.cancel();
        }
    }

    public boolean isVisible() {
        return this.ogJ != null && this.ogJ.getVisibility() == 0;
    }

    public void ecA() {
        if (this.ogR != null) {
            bXb();
            dM(1, 10);
            this.ogP = (com.baidu.tieba.d.b) MessageManager.getInstance().runTask(2921466, com.baidu.tieba.d.b.class, this.ogO).getData();
            if (this.ogP != null) {
                this.ogP.start();
            } else {
                dM(3, 0);
            }
        }
    }

    public void a(VideoInfo videoInfo, boolean z) {
        if (videoInfo == null) {
            this.ogR = null;
        } else {
            this.ogR = videoInfo.getEditVideoData();
        }
        this.ogQ = videoInfo;
        if (this.ogR != null && this.ogR.isLegal()) {
            this.ogK.setVisibility(0);
            this.ogJ.setVisibility(0);
            this.ogJ.setVideoInfo(this.ogR);
            if (z) {
                this.ogJ.ba(1.0f);
                return;
            }
            return;
        }
        this.ogK.setVisibility(8);
        this.ogJ.setVisibility(8);
        this.ogJ.reset();
        if (this.ogO != null) {
            this.ogO.yC(true);
        }
        if (this.ogP != null) {
            this.ogP.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dM(int i, int i2) {
        this.ogM.setText(String.format(this.eNx.getString(R.string.video_mix_percent), Integer.valueOf(i2)));
        if (i != this.ogS) {
            this.ogS = i;
            ap.setViewTextColor(this.ogL, this.ogS == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
            if (i == 1) {
                this.ogL.setText(this.eNx.getString(R.string.video_mixing));
                this.ogM.setVisibility(0);
                this.ogN.setVisibility(8);
            } else if (i == 3) {
                this.ogL.setText(this.eNx.getString(R.string.video_mix_failed));
                this.ogM.setVisibility(8);
                this.ogN.setVisibility(0);
            } else {
                this.ogL.setText(this.eNx.getString(R.string.video_mix_success));
                this.ogM.setVisibility(8);
                this.ogN.setVisibility(8);
            }
        }
        this.ogJ.ba(i2 / 100.0f);
    }

    private void bXb() {
        if (this.ogO == null) {
            this.ogO = new b((WriteActivity) this.eNx.getPageActivity(), this.ogR) { // from class: com.baidu.tieba.write.write.video.a.2
                @Override // com.baidu.tieba.video.b
                public void onCancel() {
                    super.onCancel();
                }

                @Override // com.baidu.tieba.video.b
                public void dTE() {
                    a.this.eNx.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dM(1, 50);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bT(int i, String str) {
                    super.bT(i, str);
                    a.this.eNx.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dM(3, 0);
                            a.this.ecB();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void dTF() {
                    a.this.eNx.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dM(1, 100);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bU(int i, String str) {
                    super.bU(i, str);
                    a.this.eNx.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dM(3, 0);
                            a.this.ecB();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void a(VideoInfo videoInfo) {
                    String str;
                    super.a(videoInfo);
                    String videoPath = videoInfo.getVideoPath();
                    if (au.isEmpty(videoPath) || !videoPath.contains(c.nAZ)) {
                        str = videoPath;
                    } else {
                        File file = new File(videoPath);
                        String str2 = c.nBa + file.getName();
                        n.copyFile(file.getAbsolutePath(), str2);
                        str = str2;
                    }
                    try {
                        a.this.bq(a.this.eNx.getPageActivity(), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.ogR.finalPath = str;
                    a.this.ogQ.setVideoPath(str);
                    a.this.ogQ.setThumbPath(this.coverPath);
                    a.this.ogJ.Wd(str);
                    a.this.eNx.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dM(2, 100);
                            if (a.this.eNx != null && (a.this.eNx.getPageActivity() instanceof WriteActivity)) {
                                ((WriteActivity) a.this.eNx.getPageActivity()).dLG();
                            }
                        }
                    });
                }
            };
        } else {
            this.ogO.a(this.ogR);
        }
        this.ogO.yC(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecB() {
        if (this.eNx != null && (this.eNx.getPageActivity() instanceof WriteActivity)) {
            ((WriteActivity) this.eNx.getPageActivity()).Ff(this.eNx.getString(R.string.write_video_mix_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(Context context, String str) {
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
    public void ecC() {
        WriteActivity writeActivity;
        WriteData dcE;
        if (this.eNx != null && (this.eNx.getPageActivity() instanceof WriteActivity) && (dcE = (writeActivity = (WriteActivity) this.eNx.getPageActivity()).dcE()) != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(this.ogQ);
            videoInfo.setVideoPath(this.ogR.originPath);
            videoInfo.getEditVideoData().finalPath = null;
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.eNx.getPageActivity(), writeActivity.getCallFrom(), dcE.getForumName(), dcE.getForumId(), "", videoInfo);
            editVideoActivityConfig.setProZone(dcE.getProZone());
            editVideoActivityConfig.setFrsTabInfo(writeActivity.ebF());
            editVideoActivityConfig.setFrom(writeActivity.getFrom());
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT);
            AntiData antiData = new AntiData();
            antiData.voice_message = writeActivity.fwy;
            antiData.setIfVoice(writeActivity.oda);
            editVideoActivityConfig.setExtraData(antiData, writeActivity.mPrefixData, dcE.getFirstDir(), dcE.getSecondDir());
            editVideoActivityConfig.getIntent().setFlags(536870912);
            editVideoActivityConfig.getIntent().setFlags(67108864);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        }
    }

    public void bvs() {
        this.ogJ.bvs();
        ap.setViewTextColor(this.ogL, this.ogS == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
        ap.setViewTextColor(this.ogM, R.color.CAM_X0109);
        ap.setViewTextColor(this.ogN, R.color.CAM_X0302);
    }
}
