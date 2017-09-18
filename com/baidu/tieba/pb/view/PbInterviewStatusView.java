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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String VU;
    private TextView faD;
    private ImageView faE;
    private FrameLayout faF;
    private TextView faG;
    private ImageView faH;
    private ImageView faI;
    private View faJ;
    private Animation faK;
    private com.baidu.tbadk.core.dialog.a faL;
    private CountDownTimer faM;
    private CountDownTimer faN;
    private CountDownTimer faO;
    private boolean faP;
    private boolean faQ;
    private a faR;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void p(boolean z);
    }

    public void setCallback(a aVar) {
        this.faR = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.faL = null;
        this.faM = null;
        this.faN = null;
        this.faO = null;
        this.faP = true;
        this.faQ = false;
        this.VU = null;
        this.faR = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.faL = null;
        this.faM = null;
        this.faN = null;
        this.faO = null;
        this.faP = true;
        this.faQ = false;
        this.VU = null;
        this.faR = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.faL = null;
        this.faM = null;
        this.faN = null;
        this.faO = null;
        this.faP = true;
        this.faQ = false;
        this.VU = null;
        this.faR = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.j.pb_interview_status, (ViewGroup) this, true);
        this.faD = (TextView) this.mRootView.findViewById(d.h.interview_live_status_btn);
        this.faF = (FrameLayout) this.mRootView.findViewById(d.h.count_container);
        this.faE = (ImageView) this.mRootView.findViewById(d.h.interview_mic);
        this.faI = (ImageView) this.mRootView.findViewById(d.h.interview_arrow);
        this.faG = (TextView) this.mRootView.findViewById(d.h.count_text);
        this.faH = (ImageView) this.mRootView.findViewById(d.h.count_bg);
        this.faJ = this.mRootView.findViewById(d.h.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        aj.k(this.mRootView, d.e.cp_link_tip_a);
        aj.i(this.faD, d.e.cp_cont_g);
        aj.j(this.faH, d.g.icon_interview_loding);
        aj.i(this.faG, d.e.cp_cont_g);
        aj.j(this.faE, d.g.icon_interview_mic);
        aj.j(this.faI, d.g.icon_arrow_tip_white);
        aj.k(this.faJ, d.e.cp_bg_line_c);
    }

    public void b(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.VU = fVar.aPi().ri().pC();
        if (StringUtils.isNull(this.VU)) {
            this.VU = fVar.aPi().ri().getTaskId();
        }
        this.faP = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aQS());
        c(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final com.baidu.tieba.pb.data.f fVar) {
        int sd = fVar.aPi().sd();
        switch (sd) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aPi().ri().rb()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.faM = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.faR != null) {
                        this.faR.p(false);
                    }
                } else {
                    TiebaStatic.log(new ak("c11105").ad("obj_id", this.VU));
                    this.mRootView.setVisibility(0);
                    if (this.faR != null) {
                        this.faR.p(true);
                    }
                    this.faD.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_before_start));
                    this.faD.setTextSize(0, k.f(pbActivity.getPageContext().getPageActivity(), d.f.fontsize24));
                    this.faE.setVisibility(8);
                    this.faI.setVisibility(8);
                    this.faJ.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.faH, an(pbActivity), (Animation.AnimationListener) null);
                    if (this.faN != null) {
                        this.faN.cancel();
                    }
                    this.faN = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.faG.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ak("c11106").ad("obj_id", PbInterviewStatusView.this.VU));
                            PbInterviewStatusView.this.faP = false;
                            PbInterviewStatusView.this.faD.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_start));
                            PbInterviewStatusView.this.faD.setTextSize(0, k.f(pbActivity.getPageContext().getPageActivity(), d.f.fontsize24));
                            PbInterviewStatusView.this.faE.setVisibility(0);
                            PbInterviewStatusView.this.faJ.setVisibility(8);
                            PbInterviewStatusView.this.faI.setVisibility(0);
                            PbInterviewStatusView.this.faF.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.faQ = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.faR != null) {
                    this.faR.p(true);
                }
                this.faE.setVisibility(8);
                this.faI.setVisibility(8);
                this.faF.setVisibility(8);
                this.faJ.setVisibility(0);
                this.faD.setTextSize(0, k.f(pbActivity.getPageContext().getPageActivity(), d.f.fontsize28));
                aj.k(this.mRootView, d.e.cp_bg_line_e);
                aj.i(this.faD, d.e.cp_cont_f);
                aj.k(this.faJ, d.e.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (sd == 2) {
                    this.faD.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_in_process));
                    if (this.faP) {
                        am(pbActivity);
                        return;
                    }
                    return;
                }
                this.faD.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void am(final PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(d.j.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(d.h.transfer_count_down);
            View findViewById = inflate.findViewById(d.h.line_left);
            View findViewById2 = inflate.findViewById(d.h.line_right);
            aj.j((ImageView) inflate.findViewById(d.h.pop_live), d.g.pic_pop_live_n);
            aj.i((TextView) inflate.findViewById(d.h.transfer_tip_txt), d.e.cp_cont_b);
            aj.i((TextView) inflate.findViewById(d.h.transfer_tip_txt_1), d.e.cp_cont_b);
            aj.k(findViewById, d.e.cp_bg_line_a);
            aj.k(findViewById2, d.e.cp_bg_line_a);
            aj.i(textView, d.e.cp_cont_f);
            this.faL = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.faL.v(inflate);
            this.faL.a((String) null, (a.b) null);
            this.faL.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.faO != null) {
                        PbInterviewStatusView.this.faO.cancel();
                    }
                    if (PbInterviewStatusView.this.faL != null) {
                        PbInterviewStatusView.this.faL.dismiss();
                    }
                }
            });
            this.faL.ar(false);
            this.faL.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.fQ().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.faL != null) {
                        PbInterviewStatusView.this.faL.to();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.faO = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.faL != null) {
                        PbInterviewStatusView.this.faL.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.aQQ();
                    }
                }
            }.start();
        }
    }

    private Animation an(PbActivity pbActivity) {
        if (this.faK == null) {
            this.faK = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.faK.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.faK.setInterpolator(new LinearInterpolator());
            this.faK.setFillAfter(true);
        }
        return this.faK;
    }

    public boolean getIndicateStatus() {
        return this.faQ;
    }

    public void clearStatus() {
        if (this.faM != null) {
            this.faM.cancel();
            this.faM = null;
        }
        if (this.faN != null) {
            this.faN.cancel();
            this.faN = null;
        }
        if (this.faO != null) {
            this.faO.cancel();
            this.faO = null;
        }
        if (this.faL != null) {
            this.faL.dismiss();
            this.faL = null;
        }
    }
}
