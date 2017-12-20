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
    private String WF;
    private TextView flj;
    private ImageView flk;
    private FrameLayout fll;
    private TextView flm;
    private ImageView fln;
    private ImageView flo;
    private View flp;
    private Animation flq;
    private com.baidu.tbadk.core.dialog.a flr;
    private CountDownTimer fls;
    private CountDownTimer flt;
    private CountDownTimer flu;
    private boolean flv;
    private boolean flw;
    private a flx;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void p(boolean z);
    }

    public void setCallback(a aVar) {
        this.flx = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.flr = null;
        this.fls = null;
        this.flt = null;
        this.flu = null;
        this.flv = true;
        this.flw = false;
        this.WF = null;
        this.flx = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.flr = null;
        this.fls = null;
        this.flt = null;
        this.flu = null;
        this.flv = true;
        this.flw = false;
        this.WF = null;
        this.flx = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.flr = null;
        this.fls = null;
        this.flt = null;
        this.flu = null;
        this.flv = true;
        this.flw = false;
        this.WF = null;
        this.flx = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.h.pb_interview_status, (ViewGroup) this, true);
        this.flj = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.fll = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.flk = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.flo = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.flm = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.fln = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.flp = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        aj.k(this.mRootView, d.C0096d.cp_link_tip_a);
        aj.i(this.flj, d.C0096d.cp_cont_g);
        aj.j(this.fln, d.f.icon_interview_loding);
        aj.i(this.flm, d.C0096d.cp_cont_g);
        aj.j(this.flk, d.f.icon_interview_mic);
        aj.j(this.flo, d.f.icon_arrow_tip_white);
        aj.k(this.flp, d.C0096d.cp_bg_line_c);
    }

    public void c(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.WF = fVar.aRp().rb().pG();
        if (StringUtils.isNull(this.WF)) {
            this.WF = fVar.aRp().rb().getTaskId();
        }
        this.flv = !"from_interview_live".equals(pbActivity.aTw());
        d(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void d(final PbActivity pbActivity, final com.baidu.tieba.pb.data.f fVar) {
        int rX = fVar.aRp().rX();
        switch (rX) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aRp().rb().qV()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.fls = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.d(pbActivity, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.flx != null) {
                        this.flx.p(false);
                    }
                } else {
                    TiebaStatic.log(new ak("c11105").ac("obj_id", this.WF));
                    this.mRootView.setVisibility(0);
                    if (this.flx != null) {
                        this.flx.p(true);
                    }
                    this.flj.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_before_start));
                    this.flj.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.flk.setVisibility(8);
                    this.flo.setVisibility(8);
                    this.flp.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.fln, aq(pbActivity), null);
                    if (this.flt != null) {
                        this.flt.cancel();
                    }
                    this.flt = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.flm.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ak("c11106").ac("obj_id", PbInterviewStatusView.this.WF));
                            PbInterviewStatusView.this.flv = false;
                            PbInterviewStatusView.this.flj.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_start));
                            PbInterviewStatusView.this.flj.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.flk.setVisibility(0);
                            PbInterviewStatusView.this.flp.setVisibility(8);
                            PbInterviewStatusView.this.flo.setVisibility(0);
                            PbInterviewStatusView.this.fll.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.flw = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.flx != null) {
                    this.flx.p(true);
                }
                this.flk.setVisibility(8);
                this.flo.setVisibility(8);
                this.fll.setVisibility(8);
                this.flp.setVisibility(0);
                this.flj.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                aj.k(this.mRootView, d.C0096d.cp_bg_line_e);
                aj.i(this.flj, d.C0096d.cp_cont_f);
                aj.k(this.flp, d.C0096d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (rX == 2) {
                    this.flj.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_in_process));
                    if (this.flv) {
                        ap(pbActivity);
                        return;
                    }
                    return;
                }
                this.flj.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void ap(final PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(d.h.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(d.g.transfer_count_down);
            View findViewById = inflate.findViewById(d.g.line_left);
            View findViewById2 = inflate.findViewById(d.g.line_right);
            aj.j((ImageView) inflate.findViewById(d.g.pop_live), d.f.pic_pop_live_n);
            aj.i((TextView) inflate.findViewById(d.g.transfer_tip_txt), d.C0096d.cp_cont_b);
            aj.i((TextView) inflate.findViewById(d.g.transfer_tip_txt_1), d.C0096d.cp_cont_b);
            aj.k(findViewById, d.C0096d.cp_bg_line_a);
            aj.k(findViewById2, d.C0096d.cp_bg_line_a);
            aj.i(textView, d.C0096d.cp_cont_f);
            this.flr = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.flr.v(inflate);
            this.flr.a((String) null, (a.b) null);
            this.flr.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.flu != null) {
                        PbInterviewStatusView.this.flu.cancel();
                    }
                    if (PbInterviewStatusView.this.flr != null) {
                        PbInterviewStatusView.this.flr.dismiss();
                    }
                }
            });
            this.flr.ao(false);
            this.flr.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.flr != null) {
                        PbInterviewStatusView.this.flr.th();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.flu = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.flr != null) {
                        PbInterviewStatusView.this.flr.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.aTu();
                    }
                }
            }.start();
        }
    }

    private Animation aq(PbActivity pbActivity) {
        if (this.flq == null) {
            this.flq = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.flq.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.flq.setInterpolator(new LinearInterpolator());
            this.flq.setFillAfter(true);
        }
        return this.flq;
    }

    public boolean getIndicateStatus() {
        return this.flw;
    }

    public void clearStatus() {
        if (this.fls != null) {
            this.fls.cancel();
            this.fls = null;
        }
        if (this.flt != null) {
            this.flt.cancel();
            this.flt = null;
        }
        if (this.flu != null) {
            this.flu.cancel();
            this.flu = null;
        }
        if (this.flr != null) {
            this.flr.dismiss();
            this.flr = null;
        }
    }
}
