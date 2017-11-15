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
    private String Wo;
    private a fdA;
    private TextView fdm;
    private ImageView fdn;
    private FrameLayout fdo;
    private TextView fdp;
    private ImageView fdq;
    private ImageView fdr;
    private View fds;
    private Animation fdt;
    private com.baidu.tbadk.core.dialog.a fdu;
    private CountDownTimer fdv;
    private CountDownTimer fdw;
    private CountDownTimer fdx;
    private boolean fdy;
    private boolean fdz;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void p(boolean z);
    }

    public void setCallback(a aVar) {
        this.fdA = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.fdu = null;
        this.fdv = null;
        this.fdw = null;
        this.fdx = null;
        this.fdy = true;
        this.fdz = false;
        this.Wo = null;
        this.fdA = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.fdu = null;
        this.fdv = null;
        this.fdw = null;
        this.fdx = null;
        this.fdy = true;
        this.fdz = false;
        this.Wo = null;
        this.fdA = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.fdu = null;
        this.fdv = null;
        this.fdw = null;
        this.fdx = null;
        this.fdy = true;
        this.fdz = false;
        this.Wo = null;
        this.fdA = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.h.pb_interview_status, (ViewGroup) this, true);
        this.fdm = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.fdo = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.fdn = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.fdr = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.fdp = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.fdq = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.fds = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        aj.k(this.mRootView, d.C0080d.cp_link_tip_a);
        aj.i(this.fdm, d.C0080d.cp_cont_g);
        aj.j(this.fdq, d.f.icon_interview_loding);
        aj.i(this.fdp, d.C0080d.cp_cont_g);
        aj.j(this.fdn, d.f.icon_interview_mic);
        aj.j(this.fdr, d.f.icon_arrow_tip_white);
        aj.k(this.fds, d.C0080d.cp_bg_line_c);
    }

    public void c(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.Wo = fVar.aPW().qZ().pB();
        if (StringUtils.isNull(this.Wo)) {
            this.Wo = fVar.aPW().qZ().getTaskId();
        }
        this.fdy = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aRX());
        d(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void d(final PbActivity pbActivity, final com.baidu.tieba.pb.data.f fVar) {
        int rW = fVar.aPW().rW();
        switch (rW) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aPW().qZ().qT()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.fdv = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.d(pbActivity, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.fdA != null) {
                        this.fdA.p(false);
                    }
                } else {
                    TiebaStatic.log(new ak("c11105").ac("obj_id", this.Wo));
                    this.mRootView.setVisibility(0);
                    if (this.fdA != null) {
                        this.fdA.p(true);
                    }
                    this.fdm.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_before_start));
                    this.fdm.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.fdn.setVisibility(8);
                    this.fdr.setVisibility(8);
                    this.fds.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.fdq, ar(pbActivity), null);
                    if (this.fdw != null) {
                        this.fdw.cancel();
                    }
                    this.fdw = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.fdp.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ak("c11106").ac("obj_id", PbInterviewStatusView.this.Wo));
                            PbInterviewStatusView.this.fdy = false;
                            PbInterviewStatusView.this.fdm.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_start));
                            PbInterviewStatusView.this.fdm.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.fdn.setVisibility(0);
                            PbInterviewStatusView.this.fds.setVisibility(8);
                            PbInterviewStatusView.this.fdr.setVisibility(0);
                            PbInterviewStatusView.this.fdo.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.fdz = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.fdA != null) {
                    this.fdA.p(true);
                }
                this.fdn.setVisibility(8);
                this.fdr.setVisibility(8);
                this.fdo.setVisibility(8);
                this.fds.setVisibility(0);
                this.fdm.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                aj.k(this.mRootView, d.C0080d.cp_bg_line_e);
                aj.i(this.fdm, d.C0080d.cp_cont_f);
                aj.k(this.fds, d.C0080d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (rW == 2) {
                    this.fdm.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_in_process));
                    if (this.fdy) {
                        aq(pbActivity);
                        return;
                    }
                    return;
                }
                this.fdm.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void aq(final PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(d.h.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(d.g.transfer_count_down);
            View findViewById = inflate.findViewById(d.g.line_left);
            View findViewById2 = inflate.findViewById(d.g.line_right);
            aj.j((ImageView) inflate.findViewById(d.g.pop_live), d.f.pic_pop_live_n);
            aj.i((TextView) inflate.findViewById(d.g.transfer_tip_txt), d.C0080d.cp_cont_b);
            aj.i((TextView) inflate.findViewById(d.g.transfer_tip_txt_1), d.C0080d.cp_cont_b);
            aj.k(findViewById, d.C0080d.cp_bg_line_a);
            aj.k(findViewById2, d.C0080d.cp_bg_line_a);
            aj.i(textView, d.C0080d.cp_cont_f);
            this.fdu = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.fdu.v(inflate);
            this.fdu.a((String) null, (a.b) null);
            this.fdu.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.fdx != null) {
                        PbInterviewStatusView.this.fdx.cancel();
                    }
                    if (PbInterviewStatusView.this.fdu != null) {
                        PbInterviewStatusView.this.fdu.dismiss();
                    }
                }
            });
            this.fdu.ao(false);
            this.fdu.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.fdu != null) {
                        PbInterviewStatusView.this.fdu.th();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.fdx = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.fdu != null) {
                        PbInterviewStatusView.this.fdu.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.aRV();
                    }
                }
            }.start();
        }
    }

    private Animation ar(PbActivity pbActivity) {
        if (this.fdt == null) {
            this.fdt = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.fdt.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.fdt.setInterpolator(new LinearInterpolator());
            this.fdt.setFillAfter(true);
        }
        return this.fdt;
    }

    public boolean getIndicateStatus() {
        return this.fdz;
    }

    public void clearStatus() {
        if (this.fdv != null) {
            this.fdv.cancel();
            this.fdv = null;
        }
        if (this.fdw != null) {
            this.fdw.cancel();
            this.fdw = null;
        }
        if (this.fdx != null) {
            this.fdx.cancel();
            this.fdx = null;
        }
        if (this.fdu != null) {
            this.fdu.dismiss();
            this.fdu = null;
        }
    }
}
