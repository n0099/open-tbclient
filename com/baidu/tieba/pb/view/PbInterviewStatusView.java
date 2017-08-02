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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String Vm;
    private TextView eXU;
    private ImageView eXV;
    private FrameLayout eXW;
    private TextView eXX;
    private ImageView eXY;
    private ImageView eXZ;
    private View eYa;
    private Animation eYb;
    private com.baidu.tbadk.core.dialog.a eYc;
    private CountDownTimer eYd;
    private CountDownTimer eYe;
    private CountDownTimer eYf;
    private boolean eYg;
    private boolean eYh;
    private a eYi;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void p(boolean z);
    }

    public void setCallback(a aVar) {
        this.eYi = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.eYc = null;
        this.eYd = null;
        this.eYe = null;
        this.eYf = null;
        this.eYg = true;
        this.eYh = false;
        this.Vm = null;
        this.eYi = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.eYc = null;
        this.eYd = null;
        this.eYe = null;
        this.eYf = null;
        this.eYg = true;
        this.eYh = false;
        this.Vm = null;
        this.eYi = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.eYc = null;
        this.eYd = null;
        this.eYe = null;
        this.eYf = null;
        this.eYg = true;
        this.eYh = false;
        this.Vm = null;
        this.eYi = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.j.pb_interview_status, (ViewGroup) this, true);
        this.eXU = (TextView) this.mRootView.findViewById(d.h.interview_live_status_btn);
        this.eXW = (FrameLayout) this.mRootView.findViewById(d.h.count_container);
        this.eXV = (ImageView) this.mRootView.findViewById(d.h.interview_mic);
        this.eXZ = (ImageView) this.mRootView.findViewById(d.h.interview_arrow);
        this.eXX = (TextView) this.mRootView.findViewById(d.h.count_text);
        this.eXY = (ImageView) this.mRootView.findViewById(d.h.count_bg);
        this.eYa = this.mRootView.findViewById(d.h.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ai.k(this.mRootView, d.e.cp_link_tip_a);
        ai.i(this.eXU, d.e.cp_cont_g);
        ai.j(this.eXY, d.g.icon_interview_loding);
        ai.i(this.eXX, d.e.cp_cont_g);
        ai.j(this.eXV, d.g.icon_interview_mic);
        ai.j(this.eXZ, d.g.icon_arrow_tip_white);
        ai.k(this.eYa, d.e.cp_bg_line_c);
    }

    public void a(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.Vm = fVar.aOY().rd().px();
        if (StringUtils.isNull(this.Vm)) {
            this.Vm = fVar.aOY().rd().getTaskId();
        }
        this.eYg = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aQG());
        b(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbActivity pbActivity, final com.baidu.tieba.pb.data.f fVar) {
        int rX = fVar.aOY().rX();
        switch (rX) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aOY().rd().qW()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.eYd = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbActivity, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.eYi != null) {
                        this.eYi.p(false);
                    }
                } else {
                    TiebaStatic.log(new aj("c11105").aa("obj_id", this.Vm));
                    this.mRootView.setVisibility(0);
                    if (this.eYi != null) {
                        this.eYi.p(true);
                    }
                    this.eXU.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_before_start));
                    this.eXU.setTextSize(0, k.g(pbActivity.getPageContext().getPageActivity(), d.f.fontsize24));
                    this.eXV.setVisibility(8);
                    this.eXZ.setVisibility(8);
                    this.eYa.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.eXY, as(pbActivity), (Animation.AnimationListener) null);
                    if (this.eYe != null) {
                        this.eYe.cancel();
                    }
                    this.eYe = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.eXX.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new aj("c11106").aa("obj_id", PbInterviewStatusView.this.Vm));
                            PbInterviewStatusView.this.eYg = false;
                            PbInterviewStatusView.this.eXU.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_start));
                            PbInterviewStatusView.this.eXU.setTextSize(0, k.g(pbActivity.getPageContext().getPageActivity(), d.f.fontsize24));
                            PbInterviewStatusView.this.eXV.setVisibility(0);
                            PbInterviewStatusView.this.eYa.setVisibility(8);
                            PbInterviewStatusView.this.eXZ.setVisibility(0);
                            PbInterviewStatusView.this.eXW.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.eYh = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.eYi != null) {
                    this.eYi.p(true);
                }
                this.eXV.setVisibility(8);
                this.eXZ.setVisibility(8);
                this.eXW.setVisibility(8);
                this.eYa.setVisibility(0);
                this.eXU.setTextSize(0, k.g(pbActivity.getPageContext().getPageActivity(), d.f.fontsize28));
                ai.k(this.mRootView, d.e.cp_bg_line_e);
                ai.i(this.eXU, d.e.cp_cont_f);
                ai.k(this.eYa, d.e.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (rX == 2) {
                    this.eXU.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_in_process));
                    if (this.eYg) {
                        ar(pbActivity);
                        return;
                    }
                    return;
                }
                this.eXU.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void ar(final PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(d.j.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(d.h.transfer_count_down);
            View findViewById = inflate.findViewById(d.h.line_left);
            View findViewById2 = inflate.findViewById(d.h.line_right);
            ai.j((ImageView) inflate.findViewById(d.h.pop_live), d.g.pic_pop_live_n);
            ai.i((TextView) inflate.findViewById(d.h.transfer_tip_txt), d.e.cp_cont_b);
            ai.i((TextView) inflate.findViewById(d.h.transfer_tip_txt_1), d.e.cp_cont_b);
            ai.k(findViewById, d.e.cp_bg_line_a);
            ai.k(findViewById2, d.e.cp_bg_line_a);
            ai.i(textView, d.e.cp_cont_f);
            this.eYc = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.eYc.v(inflate);
            this.eYc.a((String) null, (a.b) null);
            this.eYc.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.eYf != null) {
                        PbInterviewStatusView.this.eYf.cancel();
                    }
                    if (PbInterviewStatusView.this.eYc != null) {
                        PbInterviewStatusView.this.eYc.dismiss();
                    }
                }
            });
            this.eYc.ar(false);
            this.eYc.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.eYc != null) {
                        PbInterviewStatusView.this.eYc.th();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.eYf = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.eYc != null) {
                        PbInterviewStatusView.this.eYc.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.aQE();
                    }
                }
            }.start();
        }
    }

    private Animation as(PbActivity pbActivity) {
        if (this.eYb == null) {
            this.eYb = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.eYb.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.eYb.setInterpolator(new LinearInterpolator());
            this.eYb.setFillAfter(true);
        }
        return this.eYb;
    }

    public boolean getIndicateStatus() {
        return this.eYh;
    }

    public void clearStatus() {
        if (this.eYd != null) {
            this.eYd.cancel();
            this.eYd = null;
        }
        if (this.eYe != null) {
            this.eYe.cancel();
            this.eYe = null;
        }
        if (this.eYf != null) {
            this.eYf.cancel();
            this.eYf = null;
        }
        if (this.eYc != null) {
            this.eYc.dismiss();
            this.eYc = null;
        }
    }
}
