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
    private String VW;
    private ImageView eUA;
    private FrameLayout eUB;
    private TextView eUC;
    private ImageView eUD;
    private ImageView eUE;
    private View eUF;
    private Animation eUG;
    private com.baidu.tbadk.core.dialog.a eUH;
    private CountDownTimer eUI;
    private CountDownTimer eUJ;
    private CountDownTimer eUK;
    private boolean eUL;
    private boolean eUM;
    private a eUN;
    private TextView eUz;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void p(boolean z);
    }

    public void setCallback(a aVar) {
        this.eUN = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.eUH = null;
        this.eUI = null;
        this.eUJ = null;
        this.eUK = null;
        this.eUL = true;
        this.eUM = false;
        this.VW = null;
        this.eUN = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.eUH = null;
        this.eUI = null;
        this.eUJ = null;
        this.eUK = null;
        this.eUL = true;
        this.eUM = false;
        this.VW = null;
        this.eUN = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.eUH = null;
        this.eUI = null;
        this.eUJ = null;
        this.eUK = null;
        this.eUL = true;
        this.eUM = false;
        this.VW = null;
        this.eUN = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.j.pb_interview_status, (ViewGroup) this, true);
        this.eUz = (TextView) this.mRootView.findViewById(d.h.interview_live_status_btn);
        this.eUB = (FrameLayout) this.mRootView.findViewById(d.h.count_container);
        this.eUA = (ImageView) this.mRootView.findViewById(d.h.interview_mic);
        this.eUE = (ImageView) this.mRootView.findViewById(d.h.interview_arrow);
        this.eUC = (TextView) this.mRootView.findViewById(d.h.count_text);
        this.eUD = (ImageView) this.mRootView.findViewById(d.h.count_bg);
        this.eUF = this.mRootView.findViewById(d.h.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        aj.k(this.mRootView, d.e.cp_link_tip_a);
        aj.i(this.eUz, d.e.cp_cont_g);
        aj.j(this.eUD, d.g.icon_interview_loding);
        aj.i(this.eUC, d.e.cp_cont_g);
        aj.j(this.eUA, d.g.icon_interview_mic);
        aj.j(this.eUE, d.g.icon_arrow_tip_white);
        aj.k(this.eUF, d.e.cp_bg_line_c);
    }

    public void c(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.VW = fVar.aMW().qV().pw();
        if (StringUtils.isNull(this.VW)) {
            this.VW = fVar.aMW().qV().getTaskId();
        }
        this.eUL = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aOI());
        d(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void d(final PbActivity pbActivity, final com.baidu.tieba.pb.data.f fVar) {
        int rQ = fVar.aMW().rQ();
        switch (rQ) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aMW().qV().qO()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.eUI = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.d(pbActivity, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.eUN != null) {
                        this.eUN.p(false);
                    }
                } else {
                    TiebaStatic.log(new ak("c11105").ac("obj_id", this.VW));
                    this.mRootView.setVisibility(0);
                    if (this.eUN != null) {
                        this.eUN.p(true);
                    }
                    this.eUz.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_before_start));
                    this.eUz.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.f.fontsize24));
                    this.eUA.setVisibility(8);
                    this.eUE.setVisibility(8);
                    this.eUF.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.eUD, aq(pbActivity), (Animation.AnimationListener) null);
                    if (this.eUJ != null) {
                        this.eUJ.cancel();
                    }
                    this.eUJ = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.eUC.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ak("c11106").ac("obj_id", PbInterviewStatusView.this.VW));
                            PbInterviewStatusView.this.eUL = false;
                            PbInterviewStatusView.this.eUz.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_start));
                            PbInterviewStatusView.this.eUz.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.f.fontsize24));
                            PbInterviewStatusView.this.eUA.setVisibility(0);
                            PbInterviewStatusView.this.eUF.setVisibility(8);
                            PbInterviewStatusView.this.eUE.setVisibility(0);
                            PbInterviewStatusView.this.eUB.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.eUM = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.eUN != null) {
                    this.eUN.p(true);
                }
                this.eUA.setVisibility(8);
                this.eUE.setVisibility(8);
                this.eUB.setVisibility(8);
                this.eUF.setVisibility(0);
                this.eUz.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.f.fontsize28));
                aj.k(this.mRootView, d.e.cp_bg_line_e);
                aj.i(this.eUz, d.e.cp_cont_f);
                aj.k(this.eUF, d.e.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (rQ == 2) {
                    this.eUz.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_in_process));
                    if (this.eUL) {
                        ap(pbActivity);
                        return;
                    }
                    return;
                }
                this.eUz.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_finished));
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
            this.eUH = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.eUH.v(inflate);
            this.eUH.a((String) null, (a.b) null);
            this.eUH.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.eUK != null) {
                        PbInterviewStatusView.this.eUK.cancel();
                    }
                    if (PbInterviewStatusView.this.eUH != null) {
                        PbInterviewStatusView.this.eUH.dismiss();
                    }
                }
            });
            this.eUH.aq(false);
            this.eUH.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.eUH != null) {
                        PbInterviewStatusView.this.eUH.tb();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.eUK = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.eUH != null) {
                        PbInterviewStatusView.this.eUH.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.aOG();
                    }
                }
            }.start();
        }
    }

    private Animation aq(PbActivity pbActivity) {
        if (this.eUG == null) {
            this.eUG = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.eUG.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.eUG.setInterpolator(new LinearInterpolator());
            this.eUG.setFillAfter(true);
        }
        return this.eUG;
    }

    public boolean getIndicateStatus() {
        return this.eUM;
    }

    public void clearStatus() {
        if (this.eUI != null) {
            this.eUI.cancel();
            this.eUI = null;
        }
        if (this.eUJ != null) {
            this.eUJ.cancel();
            this.eUJ = null;
        }
        if (this.eUK != null) {
            this.eUK.cancel();
            this.eUK = null;
        }
        if (this.eUH != null) {
            this.eUH.dismiss();
            this.eUH = null;
        }
    }
}
