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
    private PreviewVideoView oiq;
    private LinearLayout oir;
    private TextView ois;
    private TextView oit;
    private TextView oiu;
    private b oiv;
    private com.baidu.tieba.c.b oiw;
    private VideoInfo oix;
    private EditVideoData oiy;
    private int oiz = 0;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.video.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.oiu) {
                if (view == a.this.oiq.oik) {
                    if (a.this.eXu.getPageActivity() instanceof WriteActivity) {
                        a.this.onDestroy();
                        ((WriteActivity) a.this.eXu.getPageActivity()).aD(true, false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                        return;
                    }
                    return;
                } else if (a.this.oiz != 1) {
                    a.this.eby();
                    return;
                } else {
                    return;
                }
            }
            a.this.ebw();
        }
    };

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.eXu = tbPageContext;
        this.oiq = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.oiq.setOnClickListener(this.onClickListener);
        this.oir = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.ois = (TextView) view.findViewById(R.id.write_video_state_text);
        this.oit = (TextView) view.findViewById(R.id.write_video_percent);
        this.oiu = (TextView) view.findViewById(R.id.write_video_retry);
        this.oiu.setOnClickListener(this.onClickListener);
        bxN();
    }

    public void onStart() {
        this.oiq.ebu();
    }

    public void onResume() {
        if (this.oiy != null && this.oiy.isLegal()) {
            this.oiq.VD(this.oiy.finalPath);
        }
    }

    public void onPause() {
        this.oiq.stopVideo();
    }

    public void onStop() {
        this.oiq.ebv();
    }

    public void onDestroy() {
        if (this.oiv != null) {
            this.oiv.yF(true);
        }
        if (this.oiw != null) {
            this.oiw.cancel();
        }
    }

    public boolean isVisible() {
        return this.oiq != null && this.oiq.getVisibility() == 0;
    }

    public void ebw() {
        if (this.oiy != null) {
            bZG();
            dH(1, 10);
            this.oiw = (com.baidu.tieba.c.b) MessageManager.getInstance().runTask(2921466, com.baidu.tieba.c.b.class, this.oiv).getData();
            if (this.oiw != null) {
                this.oiw.start();
            } else {
                dH(3, 0);
            }
        }
    }

    public void a(VideoInfo videoInfo, boolean z) {
        if (videoInfo == null) {
            this.oiy = null;
        } else {
            this.oiy = videoInfo.getEditVideoData();
        }
        this.oix = videoInfo;
        if (this.oiy != null && this.oiy.isLegal()) {
            this.oir.setVisibility(0);
            this.oiq.setVisibility(0);
            this.oiq.setVideoInfo(this.oiy);
            if (z) {
                this.oiq.bc(1.0f);
                return;
            }
            return;
        }
        this.oir.setVisibility(8);
        this.oiq.setVisibility(8);
        this.oiq.reset();
        if (this.oiv != null) {
            this.oiv.yF(true);
        }
        if (this.oiw != null) {
            this.oiw.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dH(int i, int i2) {
        this.oit.setText(String.format(this.eXu.getString(R.string.video_mix_percent), Integer.valueOf(i2)));
        if (i != this.oiz) {
            this.oiz = i;
            ao.setViewTextColor(this.ois, this.oiz == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
            if (i == 1) {
                this.ois.setText(this.eXu.getString(R.string.video_mixing));
                this.oit.setVisibility(0);
                this.oiu.setVisibility(8);
            } else if (i == 3) {
                this.ois.setText(this.eXu.getString(R.string.video_mix_failed));
                this.oit.setVisibility(8);
                this.oiu.setVisibility(0);
            } else {
                this.ois.setText(this.eXu.getString(R.string.video_mix_success));
                this.oit.setVisibility(8);
                this.oiu.setVisibility(8);
            }
        }
        this.oiq.bc(i2 / 100.0f);
    }

    private void bZG() {
        if (this.oiv == null) {
            this.oiv = new b((WriteActivity) this.eXu.getPageActivity(), this.oiy) { // from class: com.baidu.tieba.write.write.video.a.2
                @Override // com.baidu.tieba.video.b
                public void onCancel() {
                    super.onCancel();
                }

                @Override // com.baidu.tieba.video.b
                public void dTv() {
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
                            a.this.ebx();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void dTw() {
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
                            a.this.ebx();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void a(VideoInfo videoInfo) {
                    String str;
                    super.a(videoInfo);
                    String videoPath = videoInfo.getVideoPath();
                    if (at.isEmpty(videoPath) || !videoPath.contains(c.nFh)) {
                        str = videoPath;
                    } else {
                        File file = new File(videoPath);
                        String str2 = c.nFi + file.getName();
                        n.copyFile(file.getAbsolutePath(), str2);
                        str = str2;
                    }
                    try {
                        a.this.bv(a.this.eXu.getPageActivity(), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.oiy.finalPath = str;
                    a.this.oix.setVideoPath(str);
                    a.this.oix.setThumbPath(this.coverPath);
                    a.this.oiq.VD(str);
                    a.this.eXu.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dH(2, 100);
                            if (a.this.eXu != null && (a.this.eXu.getPageActivity() instanceof WriteActivity)) {
                                ((WriteActivity) a.this.eXu.getPageActivity()).dLx();
                            }
                        }
                    });
                }
            };
        } else {
            this.oiv.a(this.oiy);
        }
        this.oiv.yF(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebx() {
        if (this.eXu != null && (this.eXu.getPageActivity() instanceof WriteActivity)) {
            ((WriteActivity) this.eXu.getPageActivity()).Fd(this.eXu.getString(R.string.write_video_mix_fail));
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
    public void eby() {
        WriteActivity writeActivity;
        WriteData dco;
        if (this.eXu != null && (this.eXu.getPageActivity() instanceof WriteActivity) && (dco = (writeActivity = (WriteActivity) this.eXu.getPageActivity()).dco()) != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(this.oix);
            videoInfo.setVideoPath(this.oiy.originPath);
            videoInfo.getEditVideoData().finalPath = null;
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.eXu.getPageActivity(), writeActivity.getCallFrom(), dco.getForumName(), dco.getForumId(), "", videoInfo);
            editVideoActivityConfig.setProZone(dco.getProZone());
            editVideoActivityConfig.setStatisticFrom(dco.getStatisticFrom());
            editVideoActivityConfig.setFrsTabInfo(writeActivity.getFrsTabInfoData());
            editVideoActivityConfig.setFrom(writeActivity.getFrom());
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT);
            AntiData antiData = new AntiData();
            antiData.voice_message = writeActivity.fGe;
            antiData.setIfVoice(writeActivity.ofm);
            editVideoActivityConfig.setExtraData(antiData, writeActivity.mPrefixData, dco.getFirstDir(), dco.getSecondDir());
            editVideoActivityConfig.getIntent().setFlags(536870912);
            editVideoActivityConfig.getIntent().setFlags(67108864);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        }
    }

    public void bxN() {
        this.oiq.bxN();
        ao.setViewTextColor(this.ois, this.oiz == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
        ao.setViewTextColor(this.oit, R.color.CAM_X0109);
        ao.setViewTextColor(this.oiu, R.color.CAM_X0302);
    }
}
