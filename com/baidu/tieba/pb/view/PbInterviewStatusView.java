package com.baidu.tieba.pb.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String arh;
    private TextView glR;
    private ImageView glS;
    private FrameLayout glT;
    private TextView glU;
    private ImageView glV;
    private ImageView glW;
    private View glX;
    private Animation glY;
    private com.baidu.tbadk.core.dialog.a glZ;
    private CountDownTimer gma;
    private CountDownTimer gmb;
    private CountDownTimer gmc;
    private boolean gmd;
    private boolean gme;
    private a gmf;
    private View mRootView;

    /* loaded from: classes6.dex */
    public interface a {
        void O(boolean z);
    }

    public void setCallback(a aVar) {
        this.gmf = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.glZ = null;
        this.gma = null;
        this.gmb = null;
        this.gmc = null;
        this.gmd = true;
        this.gme = false;
        this.arh = null;
        this.gmf = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.glZ = null;
        this.gma = null;
        this.gmb = null;
        this.gmc = null;
        this.gmd = true;
        this.gme = false;
        this.arh = null;
        this.gmf = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.glZ = null;
        this.gma = null;
        this.gmb = null;
        this.gmc = null;
        this.gmd = true;
        this.gme = false;
        this.arh = null;
        this.gmf = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(e.h.pb_interview_status, (ViewGroup) this, true);
        this.glR = (TextView) this.mRootView.findViewById(e.g.interview_live_status_btn);
        this.glT = (FrameLayout) this.mRootView.findViewById(e.g.count_container);
        this.glS = (ImageView) this.mRootView.findViewById(e.g.interview_mic);
        this.glW = (ImageView) this.mRootView.findViewById(e.g.interview_arrow);
        this.glU = (TextView) this.mRootView.findViewById(e.g.count_text);
        this.glV = (ImageView) this.mRootView.findViewById(e.g.count_bg);
        this.glX = this.mRootView.findViewById(e.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        al.j(this.mRootView, e.d.cp_link_tip_a);
        al.h(this.glR, e.d.cp_cont_g);
        al.i(this.glV, e.f.icon_interview_loding);
        al.h(this.glU, e.d.cp_cont_g);
        al.i(this.glS, e.f.icon_interview_mic);
        al.i(this.glW, e.f.icon_arrow_tip_white);
        al.j(this.glX, e.d.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.arh = dVar.bgk().zn().yg();
        if (StringUtils.isNull(this.arh)) {
            this.arh = dVar.bgk().zn().getTaskId();
        }
        this.gmd = !"from_interview_live".equals(pbActivity.bil());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final com.baidu.tieba.pb.data.d dVar) {
        int Ai = dVar.bgk().Ai();
        switch (Ai) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.bgk().zn().zi()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.gma = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.gmf != null) {
                        this.gmf.O(false);
                    }
                } else {
                    TiebaStatic.log(new am("c11105").aA(VideoPlayActivityConfig.OBJ_ID, this.arh));
                    this.mRootView.setVisibility(0);
                    if (this.gmf != null) {
                        this.gmf.O(true);
                    }
                    this.glR.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_before_start));
                    this.glR.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0210e.fontsize24));
                    this.glS.setVisibility(8);
                    this.glW.setVisibility(8);
                    this.glX.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.glV, as(pbActivity), null);
                    if (this.gmb != null) {
                        this.gmb.cancel();
                    }
                    this.gmb = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.glU.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new am("c11106").aA(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.arh));
                            PbInterviewStatusView.this.gmd = false;
                            PbInterviewStatusView.this.glR.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_start));
                            PbInterviewStatusView.this.glR.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0210e.fontsize24));
                            PbInterviewStatusView.this.glS.setVisibility(0);
                            PbInterviewStatusView.this.glX.setVisibility(8);
                            PbInterviewStatusView.this.glW.setVisibility(0);
                            PbInterviewStatusView.this.glT.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.gme = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.gmf != null) {
                    this.gmf.O(true);
                }
                this.glS.setVisibility(8);
                this.glW.setVisibility(8);
                this.glT.setVisibility(8);
                this.glX.setVisibility(0);
                this.glR.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0210e.fontsize28));
                al.j(this.mRootView, e.d.cp_bg_line_e);
                al.h(this.glR, e.d.cp_cont_f);
                al.j(this.glX, e.d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (Ai == 2) {
                    this.glR.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_in_process));
                    if (this.gmd) {
                        ar(pbActivity);
                        return;
                    }
                    return;
                }
                this.glR.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void ar(final PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(e.h.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(e.g.transfer_count_down);
            View findViewById = inflate.findViewById(e.g.line_left);
            View findViewById2 = inflate.findViewById(e.g.line_right);
            al.i((ImageView) inflate.findViewById(e.g.pop_live), e.f.pic_pop_live_n);
            al.h((TextView) inflate.findViewById(e.g.transfer_tip_txt), e.d.cp_cont_b);
            al.h((TextView) inflate.findViewById(e.g.transfer_tip_txt_1), e.d.cp_cont_b);
            al.j(findViewById, e.d.cp_bg_line_a);
            al.j(findViewById2, e.d.cp_bg_line_a);
            al.h(textView, e.d.cp_cont_f);
            this.glZ = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.glZ.G(inflate);
            this.glZ.a((String) null, (a.b) null);
            this.glZ.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.gmc != null) {
                        PbInterviewStatusView.this.gmc.cancel();
                    }
                    if (PbInterviewStatusView.this.glZ != null) {
                        PbInterviewStatusView.this.glZ.dismiss();
                    }
                }
            });
            this.glZ.bf(false);
            this.glZ.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.glZ != null) {
                        PbInterviewStatusView.this.glZ.BF();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.gmc = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.glZ != null) {
                        PbInterviewStatusView.this.glZ.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bik();
                    }
                }
            }.start();
        }
    }

    private Animation as(PbActivity pbActivity) {
        if (this.glY == null) {
            this.glY = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), e.a.rotate_anim);
            this.glY.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.glY.setInterpolator(new LinearInterpolator());
            this.glY.setFillAfter(true);
        }
        return this.glY;
    }

    public boolean getIndicateStatus() {
        return this.gme;
    }

    public void clearStatus() {
        if (this.gma != null) {
            this.gma.cancel();
            this.gma = null;
        }
        if (this.gmb != null) {
            this.gmb.cancel();
            this.gmb = null;
        }
        if (this.gmc != null) {
            this.gmc.cancel();
            this.gmc = null;
        }
        if (this.glZ != null) {
            this.glZ.dismiss();
            this.glZ = null;
        }
    }
}
