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
    private TextView eZJ;
    private ImageView eZK;
    private FrameLayout eZL;
    private TextView eZM;
    private ImageView eZN;
    private ImageView eZO;
    private View eZP;
    private Animation eZQ;
    private com.baidu.tbadk.core.dialog.a eZR;
    private CountDownTimer eZS;
    private CountDownTimer eZT;
    private CountDownTimer eZU;
    private boolean eZV;
    private boolean eZW;
    private a eZX;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void p(boolean z);
    }

    public void setCallback(a aVar) {
        this.eZX = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.eZR = null;
        this.eZS = null;
        this.eZT = null;
        this.eZU = null;
        this.eZV = true;
        this.eZW = false;
        this.VU = null;
        this.eZX = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.eZR = null;
        this.eZS = null;
        this.eZT = null;
        this.eZU = null;
        this.eZV = true;
        this.eZW = false;
        this.VU = null;
        this.eZX = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.eZR = null;
        this.eZS = null;
        this.eZT = null;
        this.eZU = null;
        this.eZV = true;
        this.eZW = false;
        this.VU = null;
        this.eZX = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.j.pb_interview_status, (ViewGroup) this, true);
        this.eZJ = (TextView) this.mRootView.findViewById(d.h.interview_live_status_btn);
        this.eZL = (FrameLayout) this.mRootView.findViewById(d.h.count_container);
        this.eZK = (ImageView) this.mRootView.findViewById(d.h.interview_mic);
        this.eZO = (ImageView) this.mRootView.findViewById(d.h.interview_arrow);
        this.eZM = (TextView) this.mRootView.findViewById(d.h.count_text);
        this.eZN = (ImageView) this.mRootView.findViewById(d.h.count_bg);
        this.eZP = this.mRootView.findViewById(d.h.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        aj.k(this.mRootView, d.e.cp_link_tip_a);
        aj.i(this.eZJ, d.e.cp_cont_g);
        aj.j(this.eZN, d.g.icon_interview_loding);
        aj.i(this.eZM, d.e.cp_cont_g);
        aj.j(this.eZK, d.g.icon_interview_mic);
        aj.j(this.eZO, d.g.icon_arrow_tip_white);
        aj.k(this.eZP, d.e.cp_bg_line_c);
    }

    public void b(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.VU = fVar.aOX().ri().pC();
        if (StringUtils.isNull(this.VU)) {
            this.VU = fVar.aOX().ri().getTaskId();
        }
        this.eZV = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aQH());
        c(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final com.baidu.tieba.pb.data.f fVar) {
        int sd = fVar.aOX().sd();
        switch (sd) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aOX().ri().rb()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.eZS = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.eZX != null) {
                        this.eZX.p(false);
                    }
                } else {
                    TiebaStatic.log(new ak("c11105").ad("obj_id", this.VU));
                    this.mRootView.setVisibility(0);
                    if (this.eZX != null) {
                        this.eZX.p(true);
                    }
                    this.eZJ.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_before_start));
                    this.eZJ.setTextSize(0, k.g(pbActivity.getPageContext().getPageActivity(), d.f.fontsize24));
                    this.eZK.setVisibility(8);
                    this.eZO.setVisibility(8);
                    this.eZP.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.eZN, an(pbActivity), (Animation.AnimationListener) null);
                    if (this.eZT != null) {
                        this.eZT.cancel();
                    }
                    this.eZT = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.eZM.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ak("c11106").ad("obj_id", PbInterviewStatusView.this.VU));
                            PbInterviewStatusView.this.eZV = false;
                            PbInterviewStatusView.this.eZJ.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_start));
                            PbInterviewStatusView.this.eZJ.setTextSize(0, k.g(pbActivity.getPageContext().getPageActivity(), d.f.fontsize24));
                            PbInterviewStatusView.this.eZK.setVisibility(0);
                            PbInterviewStatusView.this.eZP.setVisibility(8);
                            PbInterviewStatusView.this.eZO.setVisibility(0);
                            PbInterviewStatusView.this.eZL.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.eZW = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.eZX != null) {
                    this.eZX.p(true);
                }
                this.eZK.setVisibility(8);
                this.eZO.setVisibility(8);
                this.eZL.setVisibility(8);
                this.eZP.setVisibility(0);
                this.eZJ.setTextSize(0, k.g(pbActivity.getPageContext().getPageActivity(), d.f.fontsize28));
                aj.k(this.mRootView, d.e.cp_bg_line_e);
                aj.i(this.eZJ, d.e.cp_cont_f);
                aj.k(this.eZP, d.e.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (sd == 2) {
                    this.eZJ.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_in_process));
                    if (this.eZV) {
                        am(pbActivity);
                        return;
                    }
                    return;
                }
                this.eZJ.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_finished));
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
            this.eZR = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.eZR.v(inflate);
            this.eZR.a((String) null, (a.b) null);
            this.eZR.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.eZU != null) {
                        PbInterviewStatusView.this.eZU.cancel();
                    }
                    if (PbInterviewStatusView.this.eZR != null) {
                        PbInterviewStatusView.this.eZR.dismiss();
                    }
                }
            });
            this.eZR.ar(false);
            this.eZR.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.fQ().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.eZR != null) {
                        PbInterviewStatusView.this.eZR.to();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.eZU = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.eZR != null) {
                        PbInterviewStatusView.this.eZR.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.aQF();
                    }
                }
            }.start();
        }
    }

    private Animation an(PbActivity pbActivity) {
        if (this.eZQ == null) {
            this.eZQ = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.eZQ.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.eZQ.setInterpolator(new LinearInterpolator());
            this.eZQ.setFillAfter(true);
        }
        return this.eZQ;
    }

    public boolean getIndicateStatus() {
        return this.eZW;
    }

    public void clearStatus() {
        if (this.eZS != null) {
            this.eZS.cancel();
            this.eZS = null;
        }
        if (this.eZT != null) {
            this.eZT.cancel();
            this.eZT = null;
        }
        if (this.eZU != null) {
            this.eZU.cancel();
            this.eZU = null;
        }
        if (this.eZR != null) {
            this.eZR.dismiss();
            this.eZR = null;
        }
    }
}
