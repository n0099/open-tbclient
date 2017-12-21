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
    private String WI;
    private boolean flA;
    private boolean flB;
    private a flC;
    private TextView flo;
    private ImageView flp;
    private FrameLayout flq;
    private TextView flr;
    private ImageView fls;
    private ImageView flt;
    private View flu;
    private Animation flv;
    private com.baidu.tbadk.core.dialog.a flw;
    private CountDownTimer flx;
    private CountDownTimer fly;
    private CountDownTimer flz;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void p(boolean z);
    }

    public void setCallback(a aVar) {
        this.flC = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.flw = null;
        this.flx = null;
        this.fly = null;
        this.flz = null;
        this.flA = true;
        this.flB = false;
        this.WI = null;
        this.flC = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.flw = null;
        this.flx = null;
        this.fly = null;
        this.flz = null;
        this.flA = true;
        this.flB = false;
        this.WI = null;
        this.flC = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.flw = null;
        this.flx = null;
        this.fly = null;
        this.flz = null;
        this.flA = true;
        this.flB = false;
        this.WI = null;
        this.flC = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.h.pb_interview_status, (ViewGroup) this, true);
        this.flo = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.flq = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.flp = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.flt = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.flr = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.fls = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.flu = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        aj.k(this.mRootView, d.C0095d.cp_link_tip_a);
        aj.i(this.flo, d.C0095d.cp_cont_g);
        aj.j(this.fls, d.f.icon_interview_loding);
        aj.i(this.flr, d.C0095d.cp_cont_g);
        aj.j(this.flp, d.f.icon_interview_mic);
        aj.j(this.flt, d.f.icon_arrow_tip_white);
        aj.k(this.flu, d.C0095d.cp_bg_line_c);
    }

    public void c(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.WI = fVar.aRq().rb().pG();
        if (StringUtils.isNull(this.WI)) {
            this.WI = fVar.aRq().rb().getTaskId();
        }
        this.flA = !"from_interview_live".equals(pbActivity.aTx());
        d(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void d(final PbActivity pbActivity, final com.baidu.tieba.pb.data.f fVar) {
        int rX = fVar.aRq().rX();
        switch (rX) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aRq().rb().qV()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.flx = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.d(pbActivity, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.flC != null) {
                        this.flC.p(false);
                    }
                } else {
                    TiebaStatic.log(new ak("c11105").ac("obj_id", this.WI));
                    this.mRootView.setVisibility(0);
                    if (this.flC != null) {
                        this.flC.p(true);
                    }
                    this.flo.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_before_start));
                    this.flo.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.flp.setVisibility(8);
                    this.flt.setVisibility(8);
                    this.flu.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.fls, aq(pbActivity), null);
                    if (this.fly != null) {
                        this.fly.cancel();
                    }
                    this.fly = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.flr.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ak("c11106").ac("obj_id", PbInterviewStatusView.this.WI));
                            PbInterviewStatusView.this.flA = false;
                            PbInterviewStatusView.this.flo.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_start));
                            PbInterviewStatusView.this.flo.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.flp.setVisibility(0);
                            PbInterviewStatusView.this.flu.setVisibility(8);
                            PbInterviewStatusView.this.flt.setVisibility(0);
                            PbInterviewStatusView.this.flq.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.flB = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.flC != null) {
                    this.flC.p(true);
                }
                this.flp.setVisibility(8);
                this.flt.setVisibility(8);
                this.flq.setVisibility(8);
                this.flu.setVisibility(0);
                this.flo.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                aj.k(this.mRootView, d.C0095d.cp_bg_line_e);
                aj.i(this.flo, d.C0095d.cp_cont_f);
                aj.k(this.flu, d.C0095d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (rX == 2) {
                    this.flo.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_in_process));
                    if (this.flA) {
                        ap(pbActivity);
                        return;
                    }
                    return;
                }
                this.flo.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_finished));
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
            aj.i((TextView) inflate.findViewById(d.g.transfer_tip_txt), d.C0095d.cp_cont_b);
            aj.i((TextView) inflate.findViewById(d.g.transfer_tip_txt_1), d.C0095d.cp_cont_b);
            aj.k(findViewById, d.C0095d.cp_bg_line_a);
            aj.k(findViewById2, d.C0095d.cp_bg_line_a);
            aj.i(textView, d.C0095d.cp_cont_f);
            this.flw = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.flw.v(inflate);
            this.flw.a((String) null, (a.b) null);
            this.flw.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.flz != null) {
                        PbInterviewStatusView.this.flz.cancel();
                    }
                    if (PbInterviewStatusView.this.flw != null) {
                        PbInterviewStatusView.this.flw.dismiss();
                    }
                }
            });
            this.flw.ao(false);
            this.flw.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.flw != null) {
                        PbInterviewStatusView.this.flw.th();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.flz = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.flw != null) {
                        PbInterviewStatusView.this.flw.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.aTv();
                    }
                }
            }.start();
        }
    }

    private Animation aq(PbActivity pbActivity) {
        if (this.flv == null) {
            this.flv = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.flv.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.flv.setInterpolator(new LinearInterpolator());
            this.flv.setFillAfter(true);
        }
        return this.flv;
    }

    public boolean getIndicateStatus() {
        return this.flB;
    }

    public void clearStatus() {
        if (this.flx != null) {
            this.flx.cancel();
            this.flx = null;
        }
        if (this.fly != null) {
            this.fly.cancel();
            this.fly = null;
        }
        if (this.flz != null) {
            this.flz.cancel();
            this.flz = null;
        }
        if (this.flw != null) {
            this.flw.dismiss();
            this.flw = null;
        }
    }
}
