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
    private TbPageContext ehG;
    private PreviewVideoView nir;
    private LinearLayout nis;
    private TextView nit;
    private TextView niu;
    private TextView niv;
    private b niw;
    private com.baidu.tieba.c.b nix;
    private VideoInfo niy;
    private EditVideoData niz;
    private int niA = 0;
    private View.OnClickListener eHN = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.video.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.niv) {
                if (view == a.this.nir.nil) {
                    if (a.this.ehG.getPageActivity() instanceof WriteActivity) {
                        a.this.onDestroy();
                        ((WriteActivity) a.this.ehG.getPageActivity()).xC(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001373));
                        return;
                    }
                    return;
                } else if (a.this.niA != 1) {
                    a.this.dNE();
                    return;
                } else {
                    return;
                }
            }
            a.this.dNC();
        }
    };

    public a(TbPageContext<WriteActivity> tbPageContext, View view) {
        this.ehG = tbPageContext;
        this.nir = (PreviewVideoView) view.findViewById(R.id.write_video_preview);
        this.nir.setOnClickListener(this.eHN);
        this.nis = (LinearLayout) view.findViewById(R.id.write_video_mix_state_layout);
        this.nit = (TextView) view.findViewById(R.id.write_video_state_text);
        this.niu = (TextView) view.findViewById(R.id.write_video_percent);
        this.niv = (TextView) view.findViewById(R.id.write_video_retry);
        this.niv.setOnClickListener(this.eHN);
        changeSkin();
    }

    public void onStart() {
        this.nir.dNA();
    }

    public void onResume() {
        if (this.niz != null && this.niz.isLegal()) {
            this.nir.Tz(this.niz.finalPath);
        }
    }

    public void onPause() {
        this.nir.crX();
    }

    public void onStop() {
        this.nir.dNB();
    }

    public void onDestroy() {
        if (this.niw != null) {
            this.niw.wJ(true);
        }
        if (this.nix != null) {
            this.nix.cancel();
        }
    }

    public boolean isVisible() {
        return this.nir != null && this.nir.getVisibility() == 0;
    }

    public void dNC() {
        if (this.niz != null) {
            bMj();
            dC(1, 10);
            this.nix = (com.baidu.tieba.c.b) MessageManager.getInstance().runTask(2921466, com.baidu.tieba.c.b.class, this.niw).getData();
            if (this.nix != null) {
                this.nix.start();
            } else {
                dC(3, 0);
            }
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        if (videoInfo == null) {
            this.niz = null;
        } else {
            this.niz = videoInfo.getEditVideoData();
        }
        this.niy = videoInfo;
        if (this.niz != null && this.niz.isLegal()) {
            this.nis.setVisibility(0);
            this.nir.setVisibility(0);
            this.nir.setVideoInfo(this.niz);
            return;
        }
        this.nis.setVisibility(8);
        this.nir.setVisibility(8);
        this.nir.reset();
        if (this.niw != null) {
            this.niw.wJ(true);
        }
        if (this.nix != null) {
            this.nix.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dC(int i, int i2) {
        this.niu.setText(String.format(this.ehG.getString(R.string.video_mix_percent), Integer.valueOf(i2)));
        if (i != this.niA) {
            this.niA = i;
            ap.setViewTextColor(this.nit, this.niA == 3 ? R.color.cp_cont_h : R.color.cp_cont_j);
            if (i == 1) {
                this.nit.setText(this.ehG.getString(R.string.video_mixing));
                this.niu.setVisibility(0);
                this.niv.setVisibility(8);
            } else if (i == 3) {
                this.nit.setText(this.ehG.getString(R.string.video_mix_failed));
                this.niu.setVisibility(8);
                this.niv.setVisibility(0);
            } else {
                this.nit.setText(this.ehG.getString(R.string.video_mix_success));
                this.niu.setVisibility(8);
                this.niv.setVisibility(8);
            }
        }
        this.nir.aI(i2 / 100.0f);
    }

    private void bMj() {
        if (this.niw == null) {
            this.niw = new b((WriteActivity) this.ehG.getPageActivity(), this.niz) { // from class: com.baidu.tieba.write.write.video.a.2
                @Override // com.baidu.tieba.video.b
                public void onCancel() {
                    super.onCancel();
                }

                @Override // com.baidu.tieba.video.b
                public void dEQ() {
                    a.this.ehG.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dC(1, 50);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bG(int i, String str) {
                    super.bG(i, str);
                    a.this.ehG.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dC(3, 0);
                            a.this.dND();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void dER() {
                    a.this.ehG.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dC(1, 100);
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void bH(int i, String str) {
                    super.bH(i, str);
                    a.this.ehG.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dC(3, 0);
                            a.this.dND();
                        }
                    });
                }

                @Override // com.baidu.tieba.video.b
                public void a(VideoInfo videoInfo) {
                    String str;
                    super.a(videoInfo);
                    String videoPath = videoInfo.getVideoPath();
                    if (at.isEmpty(videoPath) || !videoPath.contains(c.mDD)) {
                        str = videoPath;
                    } else {
                        File file = new File(videoPath);
                        String str2 = c.mDE + file.getName();
                        n.copyFile(file.getAbsolutePath(), str2);
                        str = str2;
                    }
                    try {
                        a.this.bk(a.this.ehG.getPageActivity(), str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a.this.niz.finalPath = str;
                    a.this.niy.setVideoPath(str);
                    a.this.niy.setThumbPath(this.coverPath);
                    a.this.nir.Tz(str);
                    a.this.ehG.getPageActivity().runOnUiThread(new Runnable() { // from class: com.baidu.tieba.write.write.video.a.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.dC(2, 100);
                            if (a.this.ehG != null && (a.this.ehG.getPageActivity() instanceof WriteActivity)) {
                                ((WriteActivity) a.this.ehG.getPageActivity()).dxf();
                            }
                        }
                    });
                }
            };
        } else {
            this.niw.a(this.niz);
        }
        this.niw.wJ(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dND() {
        if (this.ehG != null && (this.ehG.getPageActivity() instanceof WriteActivity)) {
            ((WriteActivity) this.ehG.getPageActivity()).Dy(this.ehG.getString(R.string.write_video_mix_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(Context context, String str) {
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
    public void dNE() {
        WriteActivity writeActivity;
        WriteData cOG;
        if (this.ehG != null && (this.ehG.getPageActivity() instanceof WriteActivity) && (cOG = (writeActivity = (WriteActivity) this.ehG.getPageActivity()).cOG()) != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(this.niy);
            videoInfo.setVideoPath(this.niz.originPath);
            videoInfo.getEditVideoData().finalPath = null;
            EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this.ehG.getPageActivity(), writeActivity.getCallFrom(), cOG.getForumName(), cOG.getForumId(), "", videoInfo);
            editVideoActivityConfig.setProZone(cOG.getProZone());
            editVideoActivityConfig.setFrsTabInfo(writeActivity.dMO());
            editVideoActivityConfig.setFrom(writeActivity.getFrom());
            editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT);
            AntiData antiData = new AntiData();
            antiData.voice_message = writeActivity.ePo;
            antiData.setIfVoice(writeActivity.nfm);
            editVideoActivityConfig.setExtraData(antiData, writeActivity.mPrefixData, cOG.getFirstDir(), cOG.getSecondDir());
            editVideoActivityConfig.getIntent().setFlags(536870912);
            editVideoActivityConfig.getIntent().setFlags(67108864);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        }
    }

    public void changeSkin() {
        this.nir.changeSkin();
        ap.setViewTextColor(this.nit, this.niA == 3 ? R.color.cp_cont_h : R.color.cp_cont_j);
        ap.setViewTextColor(this.niu, R.color.cp_cont_d);
        ap.setViewTextColor(this.niv, R.color.cp_link_tip_a);
    }
}
