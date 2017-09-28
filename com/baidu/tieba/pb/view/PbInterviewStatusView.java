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
    private String Wi;
    private TextView eUN;
    private ImageView eUO;
    private FrameLayout eUP;
    private TextView eUQ;
    private ImageView eUR;
    private ImageView eUS;
    private View eUT;
    private Animation eUU;
    private com.baidu.tbadk.core.dialog.a eUV;
    private CountDownTimer eUW;
    private CountDownTimer eUX;
    private CountDownTimer eUY;
    private boolean eUZ;
    private boolean eVa;
    private a eVb;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void p(boolean z);
    }

    public void setCallback(a aVar) {
        this.eVb = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.eUV = null;
        this.eUW = null;
        this.eUX = null;
        this.eUY = null;
        this.eUZ = true;
        this.eVa = false;
        this.Wi = null;
        this.eVb = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.eUV = null;
        this.eUW = null;
        this.eUX = null;
        this.eUY = null;
        this.eUZ = true;
        this.eVa = false;
        this.Wi = null;
        this.eVb = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.eUV = null;
        this.eUW = null;
        this.eUX = null;
        this.eUY = null;
        this.eUZ = true;
        this.eVa = false;
        this.Wi = null;
        this.eVb = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.j.pb_interview_status, (ViewGroup) this, true);
        this.eUN = (TextView) this.mRootView.findViewById(d.h.interview_live_status_btn);
        this.eUP = (FrameLayout) this.mRootView.findViewById(d.h.count_container);
        this.eUO = (ImageView) this.mRootView.findViewById(d.h.interview_mic);
        this.eUS = (ImageView) this.mRootView.findViewById(d.h.interview_arrow);
        this.eUQ = (TextView) this.mRootView.findViewById(d.h.count_text);
        this.eUR = (ImageView) this.mRootView.findViewById(d.h.count_bg);
        this.eUT = this.mRootView.findViewById(d.h.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        aj.k(this.mRootView, d.e.cp_link_tip_a);
        aj.i(this.eUN, d.e.cp_cont_g);
        aj.j(this.eUR, d.g.icon_interview_loding);
        aj.i(this.eUQ, d.e.cp_cont_g);
        aj.j(this.eUO, d.g.icon_interview_mic);
        aj.j(this.eUS, d.g.icon_arrow_tip_white);
        aj.k(this.eUT, d.e.cp_bg_line_c);
    }

    public void c(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.Wi = fVar.aNb().rc().pD();
        if (StringUtils.isNull(this.Wi)) {
            this.Wi = fVar.aNb().rc().getTaskId();
        }
        this.eUZ = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aON());
        d(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void d(final PbActivity pbActivity, final com.baidu.tieba.pb.data.f fVar) {
        int rX = fVar.aNb().rX();
        switch (rX) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aNb().rc().qV()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.eUW = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.d(pbActivity, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.eVb != null) {
                        this.eVb.p(false);
                    }
                } else {
                    TiebaStatic.log(new ak("c11105").ad("obj_id", this.Wi));
                    this.mRootView.setVisibility(0);
                    if (this.eVb != null) {
                        this.eVb.p(true);
                    }
                    this.eUN.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_before_start));
                    this.eUN.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.f.fontsize24));
                    this.eUO.setVisibility(8);
                    this.eUS.setVisibility(8);
                    this.eUT.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.eUR, aq(pbActivity), (Animation.AnimationListener) null);
                    if (this.eUX != null) {
                        this.eUX.cancel();
                    }
                    this.eUX = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.eUQ.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ak("c11106").ad("obj_id", PbInterviewStatusView.this.Wi));
                            PbInterviewStatusView.this.eUZ = false;
                            PbInterviewStatusView.this.eUN.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_start));
                            PbInterviewStatusView.this.eUN.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.f.fontsize24));
                            PbInterviewStatusView.this.eUO.setVisibility(0);
                            PbInterviewStatusView.this.eUT.setVisibility(8);
                            PbInterviewStatusView.this.eUS.setVisibility(0);
                            PbInterviewStatusView.this.eUP.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.eVa = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.eVb != null) {
                    this.eVb.p(true);
                }
                this.eUO.setVisibility(8);
                this.eUS.setVisibility(8);
                this.eUP.setVisibility(8);
                this.eUT.setVisibility(0);
                this.eUN.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.f.fontsize28));
                aj.k(this.mRootView, d.e.cp_bg_line_e);
                aj.i(this.eUN, d.e.cp_cont_f);
                aj.k(this.eUT, d.e.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (rX == 2) {
                    this.eUN.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_in_process));
                    if (this.eUZ) {
                        ap(pbActivity);
                        return;
                    }
                    return;
                }
                this.eUN.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void ap(final PbActivity pbActivity) {
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
            this.eUV = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.eUV.v(inflate);
            this.eUV.a((String) null, (a.b) null);
            this.eUV.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.eUY != null) {
                        PbInterviewStatusView.this.eUY.cancel();
                    }
                    if (PbInterviewStatusView.this.eUV != null) {
                        PbInterviewStatusView.this.eUV.dismiss();
                    }
                }
            });
            this.eUV.ar(false);
            this.eUV.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.eUV != null) {
                        PbInterviewStatusView.this.eUV.ti();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.eUY = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.eUV != null) {
                        PbInterviewStatusView.this.eUV.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.aOL();
                    }
                }
            }.start();
        }
    }

    private Animation aq(PbActivity pbActivity) {
        if (this.eUU == null) {
            this.eUU = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.eUU.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.eUU.setInterpolator(new LinearInterpolator());
            this.eUU.setFillAfter(true);
        }
        return this.eUU;
    }

    public boolean getIndicateStatus() {
        return this.eVa;
    }

    public void clearStatus() {
        if (this.eUW != null) {
            this.eUW.cancel();
            this.eUW = null;
        }
        if (this.eUX != null) {
            this.eUX.cancel();
            this.eUX = null;
        }
        if (this.eUY != null) {
            this.eUY.cancel();
            this.eUY = null;
        }
        if (this.eUV != null) {
            this.eUV.dismiss();
            this.eUV = null;
        }
    }
}
