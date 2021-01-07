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
import com.baidu.tbadk.core.util.at;
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
/* loaded from: classes8.dex */
public class a {
    private TbPageContext eXu;
    private PreviewVideoView oip;
    private LinearLayout oiq;
    private TextView oir;
    private TextView ois;
    private TextView oit;
    private b oiu;
    private com.baidu.tieba.c.b oiv;
    private VideoInfo oiw;
    private EditVideoData oix;
    private int oiy = 0;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.video.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.oit) {
                if (view == a.this.oip.oij) {
                    if (a.this.eXu.getPageActivity() instanceof WriteActivity) {
                        a.this.onDestroy();
                        ((WriteActivity) a.this.eXu.getPageActivity()).aD(true, false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                        return;
                    }
                    return;
                } else if (a.this.oiy != 1) {
                    a.this.ebz();
                    return;
                } else {
                    return;
                }
            }
            a.this.ebx();
        }
    };

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.eXu = tbPageContext;
        this.oip = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.oip.setOnClickListener(this.onClickListener);
        this.oiq = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.oir = (TextView) view.findViewById(R.id.write_video_state_text);
        this.ois = (TextView) view.findViewById(R.id.write_video_percent);
        this.oit = (TextView) view.findViewById(R.id.write_video_retry);
        this.oit.setOnClickListener(this.onClickListener);
        bxO();
    }

    public void onStart() {
        this.oip.ebv();
    }

    public void onResume() {
        if (this.oix != null && this.oix.isLegal()) {
            this.oip.VC(this.oix.finalPath);
        }
    }

    public void onPause() {
        this.oip.stopVideo();
    }

    public void onStop() {
        this.oip.ebw();
    }

    public void onDestroy() {
        if (this.oiu != null) {
            this.oiu.yF(true);
        }
        if (this.oiv != null) {
            this.oiv.cancel();
        }
    }

    public boolean isVisible() {
        return this.oip != null && this.oip.getVisibility() == 0;
    }

    public void ebx() {
        if (this.oix != null) {
            bZH();
            dH(1, 10);
            this.oiv = (com.baidu.tieba.c.b) MessageManager.getInstance().runTask(2921466, com.baidu.tieba.c.b.class, this.oiu).getData();
            if (this.oiv != null) {
                this.oiv.start();
            } else {
                dH(3, 0);
            }
        }
    }

    public void a(VideoInfo videoInfo, boolean z) {
        if (videoInfo == null) {
            this.oix = null;
        } else {
            this.oix = videoInfo.getEditVideoData();
        }
        this.oiw = videoInfo;
        if (this.oix != null && this.oix.isLegal()) {
            this.oiq.setVisibility(0);
            this.oip.setVisibility(0);
            this.oip.setVideoInfo(this.oix);
            if (z) {
                this.oip.bc(1.0f);
                return;
            }
            return;
        }
        this.oiq.setVisibility(8);
        this.oip.setVisibility(8);
        this.oip.reset();
        if (this.oiu != null) {
            this.oiu.yF(true);
        }
        if (this.oiv != null) {
            this.oiv.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dH(int i, int i2) {
        this.ois.setText(String.format(this.eXu.getString(R.string.video_mix_percent), Integer.valueOf(i2)));
        if (i != this.oiy) {
            this.oiy = i;
            ao.setViewTextColor(this.oir, this.oiy == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
            if (i == 1) {
                this.oir.setText(this.eXu.getString(R.string.video_mixing));
                this.ois.setVisibility(0);
                this.oit.setVisibility(8);
            } else if (i == 3) {
                this.oir.setText(this.eXu.getString(R.string.video_mix_failed));
                this.ois.setVisibility(8);
                this.oit.setVisibility(0);
            } else {
                this.oir.setText(this.eXu.getString(R.string.video_mix_success));
                this.ois.setVisibility(8);
                this.oit.setVisibility(8);
            }
        }
        this.oip.bc(i2 / 100.0f);
    }

    private void bZH() {
        if (this.oiu == null) {
            this.oiu = new b((WriteActivity) this.eXu.getPageActivity(), this.oix) { // from class: com.baidu.tieba.write.write.video.a.2
                @Override // com.baidu.tieba.video.b
                public void onCancel() {
                    super.onCancel();
                }

                @Override // com.baidu.tieba.video.b
                public void dTw() {
                    a.this.eXu.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dH(1, 50);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bT(int i, String str) {
                    super.bT(i, str);
                    a.this.eXu.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dH(3, 0);
                            a.this.eby();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void dTx() {
                    a.this.eXu.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dH(1, 100);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bU(int i, String str) {
                    super.bU(i, str);
                    a.this.eXu.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dH(3, 0);
                            a.this.eby();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void a(VideoInfo videoInfo) {
                    String str;
                    super.a(videoInfo);
                    String videoPath = videoInfo.getVideoPath();
                    if (at.isEmpty(videoPath) || !videoPath.contains(c.nFg)) {
                        str = videoPath;
                    } else {
                        File file = new File(videoPath);
                        String str2 = c.nFh + file.getName();
                        n.copyFile(file.getAbsolutePath(), str2);
                        str = str2;
                    }
                    try {
                        a.this.bv(a.this.eXu.getPageActivity(), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.oix.finalPath = str;
                    a.this.oiw.setVideoPath(str);
                    a.this.oiw.setThumbPath(this.coverPath);
                    a.this.oip.VC(str);
                    a.this.eXu.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dH(2, 100);
                            if (a.this.eXu != null && (a.this.eXu.getPageActivity() instanceof WriteActivity)) {
                                ((WriteActivity) a.this.eXu.getPageActivity()).dLy();
                            }
                        }
                    });
                }
            };
        } else {
            this.oiu.a(this.oix);
        }
        this.oiu.yF(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eby() {
        if (this.eXu != null && (this.eXu.getPageActivity() instanceof WriteActivity)) {
            ((WriteActivity) this.eXu.getPageActivity()).Fc(this.eXu.getString(R.string.write_video_mix_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv(Context context, String str) {
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
    public void ebz() {
        WriteActivity writeActivity;
        WriteData dcp;
        if (this.eXu != null && (this.eXu.getPageActivity() instanceof WriteActivity) && (dcp = (writeActivity = (WriteActivity) this.eXu.getPageActivity()).dcp()) != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(this.oiw);
            videoInfo.setVideoPath(this.oix.originPath);
            videoInfo.getEditVideoData().finalPath = null;
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.eXu.getPageActivity(), writeActivity.getCallFrom(), dcp.getForumName(), dcp.getForumId(), "", videoInfo);
            editVideoActivityConfig.setProZone(dcp.getProZone());
            editVideoActivityConfig.setStatisticFrom(dcp.getStatisticFrom());
            editVideoActivityConfig.setFrsTabInfo(writeActivity.getFrsTabInfoData());
            editVideoActivityConfig.setFrom(writeActivity.getFrom());
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT);
            AntiData antiData = new AntiData();
            antiData.voice_message = writeActivity.fGe;
            antiData.setIfVoice(writeActivity.ofl);
            editVideoActivityConfig.setExtraData(antiData, writeActivity.mPrefixData, dcp.getFirstDir(), dcp.getSecondDir());
            editVideoActivityConfig.getIntent().setFlags(536870912);
            editVideoActivityConfig.getIntent().setFlags(67108864);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        }
    }

    public void bxO() {
        this.oip.bxO();
        ao.setViewTextColor(this.oir, this.oiy == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
        ao.setViewTextColor(this.ois, R.color.CAM_X0109);
        ao.setViewTextColor(this.oit, R.color.CAM_X0302);
    }
}
