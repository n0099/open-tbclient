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
/* loaded from: classes7.dex */
public class a {
    private TbPageContext eWx;
    private PreviewVideoView oqi;
    private LinearLayout oqj;
    private TextView oqk;
    private TextView oql;
    private TextView oqm;
    private b oqn;
    private com.baidu.tieba.c.b oqo;
    private VideoInfo oqp;
    private EditVideoData oqq;
    private int oqr = 0;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.video.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.oqm) {
                if (view == a.this.oqi.oqc) {
                    if (a.this.eWx.getPageActivity() instanceof WriteActivity) {
                        a.this.onDestroy();
                        ((WriteActivity) a.this.eWx.getPageActivity()).aD(true, false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                        return;
                    }
                    return;
                } else if (a.this.oqr != 1) {
                    a.this.eai();
                    return;
                } else {
                    return;
                }
            }
            a.this.eag();
        }
    };

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.eWx = tbPageContext;
        this.oqi = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.oqi.setOnClickListener(this.onClickListener);
        this.oqj = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.oqk = (TextView) view.findViewById(R.id.write_video_state_text);
        this.oql = (TextView) view.findViewById(R.id.write_video_percent);
        this.oqm = (TextView) view.findViewById(R.id.write_video_retry);
        this.oqm.setOnClickListener(this.onClickListener);
        bur();
    }

    public void onStart() {
        this.oqi.eae();
    }

    public void onResume() {
        if (this.oqq != null && this.oqq.isLegal()) {
            this.oqi.VM(this.oqq.finalPath);
        }
    }

    public void onPause() {
        this.oqi.stopVideo();
    }

    public void onStop() {
        this.oqi.eaf();
    }

    public void onDestroy() {
        if (this.oqn != null) {
            this.oqn.yT(true);
        }
        if (this.oqo != null) {
            this.oqo.cancel();
        }
    }

    public boolean isVisible() {
        return this.oqi != null && this.oqi.getVisibility() == 0;
    }

    public void eag() {
        if (this.oqq != null) {
            bWG();
            dF(1, 10);
            this.oqo = (com.baidu.tieba.c.b) MessageManager.getInstance().runTask(2921466, com.baidu.tieba.c.b.class, this.oqn).getData();
            if (this.oqo != null) {
                this.oqo.start();
            } else {
                dF(3, 0);
            }
        }
    }

    public void a(VideoInfo videoInfo, boolean z) {
        if (videoInfo == null) {
            this.oqq = null;
        } else {
            this.oqq = videoInfo.getEditVideoData();
        }
        this.oqp = videoInfo;
        if (this.oqq != null && this.oqq.isLegal()) {
            this.oqj.setVisibility(0);
            this.oqi.setVisibility(0);
            this.oqi.setVideoInfo(this.oqq);
            if (z) {
                this.oqi.bj(1.0f);
                return;
            }
            return;
        }
        this.oqj.setVisibility(8);
        this.oqi.setVisibility(8);
        this.oqi.reset();
        if (this.oqn != null) {
            this.oqn.yT(true);
        }
        if (this.oqo != null) {
            this.oqo.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dF(int i, int i2) {
        this.oql.setText(String.format(this.eWx.getString(R.string.video_mix_percent), Integer.valueOf(i2)));
        if (i != this.oqr) {
            this.oqr = i;
            ap.setViewTextColor(this.oqk, this.oqr == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
            if (i == 1) {
                this.oqk.setText(this.eWx.getString(R.string.video_mixing));
                this.oql.setVisibility(0);
                this.oqm.setVisibility(8);
            } else if (i == 3) {
                this.oqk.setText(this.eWx.getString(R.string.video_mix_failed));
                this.oql.setVisibility(8);
                this.oqm.setVisibility(0);
            } else {
                this.oqk.setText(this.eWx.getString(R.string.video_mix_success));
                this.oql.setVisibility(8);
                this.oqm.setVisibility(8);
            }
        }
        this.oqi.bj(i2 / 100.0f);
    }

    private void bWG() {
        if (this.oqn == null) {
            this.oqn = new b((WriteActivity) this.eWx.getPageActivity(), this.oqq) { // from class: com.baidu.tieba.write.write.video.a.2
                @Override // com.baidu.tieba.video.b
                public void onCancel() {
                    super.onCancel();
                }

                @Override // com.baidu.tieba.video.b
                public void dSf() {
                    a.this.eWx.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dF(1, 50);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void cb(int i, String str) {
                    super.cb(i, str);
                    a.this.eWx.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dF(3, 0);
                            a.this.eah();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void dSg() {
                    a.this.eWx.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dF(1, 100);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void cc(int i, String str) {
                    super.cc(i, str);
                    a.this.eWx.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dF(3, 0);
                            a.this.eah();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void a(VideoInfo videoInfo) {
                    String str;
                    super.a(videoInfo);
                    String videoPath = videoInfo.getVideoPath();
                    if (au.isEmpty(videoPath) || !videoPath.contains(c.nMR)) {
                        str = videoPath;
                    } else {
                        File file = new File(videoPath);
                        String str2 = c.nMS + file.getName();
                        o.copyFile(file.getAbsolutePath(), str2);
                        str = str2;
                    }
                    try {
                        a.this.bt(a.this.eWx.getPageActivity(), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.oqq.finalPath = str;
                    a.this.oqp.setVideoPath(str);
                    a.this.oqp.setThumbPath(this.coverPath);
                    a.this.oqi.VM(str);
                    a.this.eWx.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dF(2, 100);
                            if (a.this.eWx != null && (a.this.eWx.getPageActivity() instanceof WriteActivity)) {
                                ((WriteActivity) a.this.eWx.getPageActivity()).dKh();
                            }
                        }
                    });
                }
            };
        } else {
            this.oqn.a(this.oqq);
        }
        this.oqn.yT(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eah() {
        if (this.eWx != null && (this.eWx.getPageActivity() instanceof WriteActivity)) {
            ((WriteActivity) this.eWx.getPageActivity()).Et(this.eWx.getString(R.string.write_video_mix_fail));
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
    public void eai() {
        WriteActivity writeActivity;
        WriteData daL;
        if (this.eWx != null && (this.eWx.getPageActivity() instanceof WriteActivity) && (daL = (writeActivity = (WriteActivity) this.eWx.getPageActivity()).daL()) != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(this.oqp);
            videoInfo.setVideoPath(this.oqq.originPath);
            videoInfo.getEditVideoData().finalPath = null;
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.eWx.getPageActivity(), writeActivity.getCallFrom(), daL.getForumName(), daL.getForumId(), "", videoInfo);
            editVideoActivityConfig.setProZone(daL.getProZone());
            editVideoActivityConfig.setStatisticFrom(daL.getStatisticFrom());
            editVideoActivityConfig.setFrsTabInfo(writeActivity.getFrsTabInfoData());
            editVideoActivityConfig.setFrom(writeActivity.getFrom());
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT);
            AntiData antiData = new AntiData();
            antiData.voice_message = writeActivity.fFk;
            antiData.setIfVoice(writeActivity.onf);
            editVideoActivityConfig.setExtraData(antiData, writeActivity.mPrefixData, daL.getFirstDir(), daL.getSecondDir());
            editVideoActivityConfig.getIntent().setFlags(536870912);
            editVideoActivityConfig.getIntent().setFlags(67108864);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        }
    }

    public void bur() {
        this.oqi.bur();
        ap.setViewTextColor(this.oqk, this.oqr == 3 ? R.color.CAM_X0301 : R.color.CAM_X0107);
        ap.setViewTextColor(this.oql, R.color.CAM_X0109);
        ap.setViewTextColor(this.oqm, R.color.CAM_X0302);
    }
}
