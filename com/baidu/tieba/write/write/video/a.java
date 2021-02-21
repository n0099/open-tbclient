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
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.z;
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
    private TbPageContext eUY;
    private PreviewVideoView ooc;
    private LinearLayout ood;
    private TextView ooe;
    private TextView oof;
    private TextView oog;
    private b ooh;
    private com.baidu.tieba.c.b ooi;
    private VideoInfo ooj;
    private EditVideoData ook;
    private int ool = 0;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.video.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.oog) {
                if (view == a.this.ooc.onW) {
                    if (a.this.eUY.getPageActivity() instanceof WriteActivity) {
                        a.this.onDestroy();
                        ((WriteActivity) a.this.eUY.getPageActivity()).aD(true, false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                        return;
                    }
                    return;
                } else if (a.this.ool != 1) {
                    a.this.eaa();
                    return;
                } else {
                    return;
                }
            }
            a.this.dZY();
        }
    };

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.eUY = tbPageContext;
        this.ooc = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.ooc.setOnClickListener(this.onClickListener);
        this.ood = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.ooe = (TextView) view.findViewById(R.id.write_video_state_text);
        this.oof = (TextView) view.findViewById(R.id.write_video_percent);
        this.oog = (TextView) view.findViewById(R.id.write_video_retry);
        this.oog.setOnClickListener(this.onClickListener);
        buo();
    }

    public void onStart() {
        this.ooc.dZW();
    }

    public void onResume() {
        if (this.ook != null && this.ook.isLegal()) {
            this.ooc.VF(this.ook.finalPath);
        }
    }

    public void onPause() {
        this.ooc.stopVideo();
    }

    public void onStop() {
        this.ooc.dZX();
    }

    public void onDestroy() {
        if (this.ooh != null) {
            this.ooh.yU(true);
        }
        if (this.ooi != null) {
            this.ooi.cancel();
        }
    }

    public boolean isVisible() {
        return this.ooc != null && this.ooc.getVisibility() == 0;
    }

    public void dZY() {
        if (this.ook != null) {
            bWA();
            dF(1, 10);
            this.ooi = (com.baidu.tieba.c.b) MessageManager.getInstance().runTask(2921466, com.baidu.tieba.c.b.class, this.ooh).getData();
            if (this.ooi != null) {
                this.ooi.start();
            } else {
                dF(3, 0);
            }
        }
    }

    public void a(VideoInfo videoInfo, boolean z) {
        if (videoInfo == null) {
            this.ook = null;
        } else {
            this.ook = videoInfo.getEditVideoData();
        }
        this.ooj = videoInfo;
        if (this.ook != null && this.ook.isLegal()) {
            this.ood.setVisibility(0);
            this.ooc.setVisibility(0);
            this.ooc.setVideoInfo(this.ook);
            if (z) {
                this.ooc.bf(1.0f);
                return;
            }
            return;
        }
        this.ood.setVisibility(8);
        this.ooc.setVisibility(8);
        this.ooc.reset();
        if (this.ooh != null) {
            this.ooh.yU(true);
        }
        if (this.ooi != null) {
            this.ooi.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dF(int i, int i2) {
        this.oof.setText(String.format(this.eUY.getString(R.string.video_mix_percent), Integer.valueOf(i2)));
        if (i != this.ool) {
            this.ool = i;
            ap.setViewTextColor(this.ooe, this.ool == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
            if (i == 1) {
                this.ooe.setText(this.eUY.getString(R.string.video_mixing));
                this.oof.setVisibility(0);
                this.oog.setVisibility(8);
            } else if (i == 3) {
                this.ooe.setText(this.eUY.getString(R.string.video_mix_failed));
                this.oof.setVisibility(8);
                this.oog.setVisibility(0);
            } else {
                this.ooe.setText(this.eUY.getString(R.string.video_mix_success));
                this.oof.setVisibility(8);
                this.oog.setVisibility(8);
            }
        }
        this.ooc.bf(i2 / 100.0f);
    }

    private void bWA() {
        if (this.ooh == null) {
            this.ooh = new b((WriteActivity) this.eUY.getPageActivity(), this.ook) { // from class: com.baidu.tieba.write.write.video.a.2
                @Override // com.baidu.tieba.video.b
                public void onCancel() {
                    super.onCancel();
                }

                @Override // com.baidu.tieba.video.b
                public void dRX() {
                    a.this.eUY.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dF(1, 50);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void cb(int i, String str) {
                    super.cb(i, str);
                    a.this.eUY.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dF(3, 0);
                            a.this.dZZ();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void dRY() {
                    a.this.eUY.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dF(1, 100);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void cc(int i, String str) {
                    super.cc(i, str);
                    a.this.eUY.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dF(3, 0);
                            a.this.dZZ();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void a(VideoInfo videoInfo) {
                    String str;
                    super.a(videoInfo);
                    String videoPath = videoInfo.getVideoPath();
                    if (au.isEmpty(videoPath) || !videoPath.contains(c.nKM)) {
                        str = videoPath;
                    } else {
                        File file = new File(videoPath);
                        String str2 = c.nKN + file.getName();
                        o.copyFile(file.getAbsolutePath(), str2);
                        str = str2;
                    }
                    try {
                        a.this.bt(a.this.eUY.getPageActivity(), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.ook.finalPath = str;
                    a.this.ooj.setVideoPath(str);
                    a.this.ooj.setThumbPath(this.coverPath);
                    a.this.ooc.VF(str);
                    a.this.eUY.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dF(2, 100);
                            if (a.this.eUY != null && (a.this.eUY.getPageActivity() instanceof WriteActivity)) {
                                ((WriteActivity) a.this.eUY.getPageActivity()).dJZ();
                            }
                        }
                    });
                }
            };
        } else {
            this.ooh.a(this.ook);
        }
        this.ooh.yU(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZZ() {
        if (this.eUY != null && (this.eUY.getPageActivity() instanceof WriteActivity)) {
            ((WriteActivity) this.eUY.getPageActivity()).Em(this.eUY.getString(R.string.write_video_mix_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(Context context, String str) {
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
    public void eaa() {
        WriteActivity writeActivity;
        WriteData daC;
        if (this.eUY != null && (this.eUY.getPageActivity() instanceof WriteActivity) && (daC = (writeActivity = (WriteActivity) this.eUY.getPageActivity()).daC()) != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(this.ooj);
            videoInfo.setVideoPath(this.ook.originPath);
            videoInfo.getEditVideoData().finalPath = null;
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.eUY.getPageActivity(), writeActivity.getCallFrom(), daC.getForumName(), daC.getForumId(), "", videoInfo);
            editVideoActivityConfig.setProZone(daC.getProZone());
            editVideoActivityConfig.setStatisticFrom(daC.getStatisticFrom());
            editVideoActivityConfig.setFrsTabInfo(writeActivity.getFrsTabInfoData());
            editVideoActivityConfig.setFrom(writeActivity.getFrom());
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT);
            AntiData antiData = new AntiData();
            antiData.voice_message = writeActivity.fDL;
            antiData.setIfVoice(writeActivity.okZ);
            editVideoActivityConfig.setExtraData(antiData, writeActivity.mPrefixData, daC.getFirstDir(), daC.getSecondDir());
            editVideoActivityConfig.getIntent().setFlags(536870912);
            editVideoActivityConfig.getIntent().setFlags(67108864);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        }
    }

    public void buo() {
        this.ooc.buo();
        ap.setViewTextColor(this.ooe, this.ool == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
        ap.setViewTextColor(this.oof, R.color.CAM_X0109);
        ap.setViewTextColor(this.oog, R.color.CAM_X0302);
    }
}
