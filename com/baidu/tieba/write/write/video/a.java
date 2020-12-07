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
    private PreviewVideoView ogH;
    private LinearLayout ogI;
    private TextView ogJ;
    private TextView ogK;
    private TextView ogL;
    private b ogM;
    private com.baidu.tieba.d.b ogN;
    private VideoInfo ogO;
    private EditVideoData ogP;
    private int ogQ = 0;
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.video.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.ogL) {
                if (view == a.this.ogH.ogC) {
                    if (a.this.eNx.getPageActivity() instanceof WriteActivity) {
                        a.this.onDestroy();
                        ((WriteActivity) a.this.eNx.getPageActivity()).aC(true, false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                        return;
                    }
                    return;
                } else if (a.this.ogQ != 1) {
                    a.this.ecB();
                    return;
                } else {
                    return;
                }
            }
            a.this.ecz();
        }
    };

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.eNx = tbPageContext;
        this.ogH = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.ogH.setOnClickListener(this.foP);
        this.ogI = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.ogJ = (TextView) view.findViewById(R.id.write_video_state_text);
        this.ogK = (TextView) view.findViewById(R.id.write_video_percent);
        this.ogL = (TextView) view.findViewById(R.id.write_video_retry);
        this.ogL.setOnClickListener(this.foP);
        bvs();
    }

    public void onStart() {
        this.ogH.ecx();
    }

    public void onResume() {
        if (this.ogP != null && this.ogP.isLegal()) {
            this.ogH.Wd(this.ogP.finalPath);
        }
    }

    public void onPause() {
        this.ogH.cEV();
    }

    public void onStop() {
        this.ogH.ecy();
    }

    public void onDestroy() {
        if (this.ogM != null) {
            this.ogM.yC(true);
        }
        if (this.ogN != null) {
            this.ogN.cancel();
        }
    }

    public boolean isVisible() {
        return this.ogH != null && this.ogH.getVisibility() == 0;
    }

    public void ecz() {
        if (this.ogP != null) {
            bXa();
            dM(1, 10);
            this.ogN = (com.baidu.tieba.d.b) MessageManager.getInstance().runTask(2921466, com.baidu.tieba.d.b.class, this.ogM).getData();
            if (this.ogN != null) {
                this.ogN.start();
            } else {
                dM(3, 0);
            }
        }
    }

    public void a(VideoInfo videoInfo, boolean z) {
        if (videoInfo == null) {
            this.ogP = null;
        } else {
            this.ogP = videoInfo.getEditVideoData();
        }
        this.ogO = videoInfo;
        if (this.ogP != null && this.ogP.isLegal()) {
            this.ogI.setVisibility(0);
            this.ogH.setVisibility(0);
            this.ogH.setVideoInfo(this.ogP);
            if (z) {
                this.ogH.ba(1.0f);
                return;
            }
            return;
        }
        this.ogI.setVisibility(8);
        this.ogH.setVisibility(8);
        this.ogH.reset();
        if (this.ogM != null) {
            this.ogM.yC(true);
        }
        if (this.ogN != null) {
            this.ogN.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dM(int i, int i2) {
        this.ogK.setText(String.format(this.eNx.getString(R.string.video_mix_percent), Integer.valueOf(i2)));
        if (i != this.ogQ) {
            this.ogQ = i;
            ap.setViewTextColor(this.ogJ, this.ogQ == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
            if (i == 1) {
                this.ogJ.setText(this.eNx.getString(R.string.video_mixing));
                this.ogK.setVisibility(0);
                this.ogL.setVisibility(8);
            } else if (i == 3) {
                this.ogJ.setText(this.eNx.getString(R.string.video_mix_failed));
                this.ogK.setVisibility(8);
                this.ogL.setVisibility(0);
            } else {
                this.ogJ.setText(this.eNx.getString(R.string.video_mix_success));
                this.ogK.setVisibility(8);
                this.ogL.setVisibility(8);
            }
        }
        this.ogH.ba(i2 / 100.0f);
    }

    private void bXa() {
        if (this.ogM == null) {
            this.ogM = new b((WriteActivity) this.eNx.getPageActivity(), this.ogP) { // from class: com.baidu.tieba.write.write.video.a.2
                @Override // com.baidu.tieba.video.b
                public void onCancel() {
                    super.onCancel();
                }

                @Override // com.baidu.tieba.video.b
                public void dTD() {
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
                            a.this.ecA();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void dTE() {
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
                            a.this.ecA();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void a(VideoInfo videoInfo) {
                    String str;
                    super.a(videoInfo);
                    String videoPath = videoInfo.getVideoPath();
                    if (au.isEmpty(videoPath) || !videoPath.contains(c.nAX)) {
                        str = videoPath;
                    } else {
                        File file = new File(videoPath);
                        String str2 = c.nAY + file.getName();
                        n.copyFile(file.getAbsolutePath(), str2);
                        str = str2;
                    }
                    try {
                        a.this.bq(a.this.eNx.getPageActivity(), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.ogP.finalPath = str;
                    a.this.ogO.setVideoPath(str);
                    a.this.ogO.setThumbPath(this.coverPath);
                    a.this.ogH.Wd(str);
                    a.this.eNx.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dM(2, 100);
                            if (a.this.eNx != null && (a.this.eNx.getPageActivity() instanceof WriteActivity)) {
                                ((WriteActivity) a.this.eNx.getPageActivity()).dLF();
                            }
                        }
                    });
                }
            };
        } else {
            this.ogM.a(this.ogP);
        }
        this.ogM.yC(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecA() {
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
    public void ecB() {
        WriteActivity writeActivity;
        WriteData dcD;
        if (this.eNx != null && (this.eNx.getPageActivity() instanceof WriteActivity) && (dcD = (writeActivity = (WriteActivity) this.eNx.getPageActivity()).dcD()) != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(this.ogO);
            videoInfo.setVideoPath(this.ogP.originPath);
            videoInfo.getEditVideoData().finalPath = null;
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.eNx.getPageActivity(), writeActivity.getCallFrom(), dcD.getForumName(), dcD.getForumId(), "", videoInfo);
            editVideoActivityConfig.setProZone(dcD.getProZone());
            editVideoActivityConfig.setFrsTabInfo(writeActivity.ebE());
            editVideoActivityConfig.setFrom(writeActivity.getFrom());
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT);
            AntiData antiData = new AntiData();
            antiData.voice_message = writeActivity.fwy;
            antiData.setIfVoice(writeActivity.ocY);
            editVideoActivityConfig.setExtraData(antiData, writeActivity.mPrefixData, dcD.getFirstDir(), dcD.getSecondDir());
            editVideoActivityConfig.getIntent().setFlags(536870912);
            editVideoActivityConfig.getIntent().setFlags(67108864);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        }
    }

    public void bvs() {
        this.ogH.bvs();
        ap.setViewTextColor(this.ogJ, this.ogQ == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
        ap.setViewTextColor(this.ogK, R.color.CAM_X0109);
        ap.setViewTextColor(this.ogL, R.color.CAM_X0302);
    }
}
