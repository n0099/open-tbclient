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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String Vy;
    private TextView exB;
    private ImageView exC;
    private FrameLayout exD;
    private TextView exE;
    private ImageView exF;
    private ImageView exG;
    private View exH;
    private Animation exI;
    private com.baidu.tbadk.core.dialog.a exJ;
    private CountDownTimer exK;
    private CountDownTimer exL;
    private CountDownTimer exM;
    private boolean exN;
    private boolean exO;
    private a exP;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void p(boolean z);
    }

    public void setCallback(a aVar) {
        this.exP = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.exJ = null;
        this.exK = null;
        this.exL = null;
        this.exM = null;
        this.exN = true;
        this.exO = false;
        this.Vy = null;
        this.exP = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.exJ = null;
        this.exK = null;
        this.exL = null;
        this.exM = null;
        this.exN = true;
        this.exO = false;
        this.Vy = null;
        this.exP = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.exJ = null;
        this.exK = null;
        this.exL = null;
        this.exM = null;
        this.exN = true;
        this.exO = false;
        this.Vy = null;
        this.exP = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(w.j.pb_interview_status, (ViewGroup) this, true);
        this.exB = (TextView) this.mRootView.findViewById(w.h.interview_live_status_btn);
        this.exD = (FrameLayout) this.mRootView.findViewById(w.h.count_container);
        this.exC = (ImageView) this.mRootView.findViewById(w.h.interview_mic);
        this.exG = (ImageView) this.mRootView.findViewById(w.h.interview_arrow);
        this.exE = (TextView) this.mRootView.findViewById(w.h.count_text);
        this.exF = (ImageView) this.mRootView.findViewById(w.h.count_bg);
        this.exH = this.mRootView.findViewById(w.h.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        aq.k(this.mRootView, w.e.cp_link_tip_a);
        aq.i((View) this.exB, w.e.cp_cont_g);
        aq.j(this.exF, w.g.icon_interview_loding);
        aq.i((View) this.exE, w.e.cp_cont_g);
        aq.j(this.exC, w.g.icon_interview_mic);
        aq.j(this.exG, w.g.icon_arrow_tip_white);
        aq.k(this.exH, w.e.cp_bg_line_c);
    }

    public void a(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.Vy = fVar.aJq().rz().pD();
        if (StringUtils.isNull(this.Vy)) {
            this.Vy = fVar.aJq().rz().getTaskId();
        }
        this.exN = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aKK());
        b(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        int ss = fVar.aJq().ss();
        switch (ss) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aJq().rz().rs()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.exK = new e(this, millis2, millis2, pbActivity, fVar).start();
                    this.mRootView.setVisibility(8);
                    if (this.exP != null) {
                        this.exP.p(false);
                    }
                } else {
                    TiebaStatic.log(new as("c11105").Z("obj_id", this.Vy));
                    this.mRootView.setVisibility(0);
                    if (this.exP != null) {
                        this.exP.p(true);
                    }
                    this.exB.setText(pbActivity.getPageContext().getPageActivity().getString(w.l.interview_live_before_start));
                    this.exB.setTextSize(0, com.baidu.adp.lib.util.k.g(pbActivity.getPageContext().getPageActivity(), w.f.fontsize24));
                    this.exC.setVisibility(8);
                    this.exG.setVisibility(8);
                    this.exH.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.exF, ac(pbActivity), (Animation.AnimationListener) null);
                    if (this.exL != null) {
                        this.exL.cancel();
                    }
                    this.exL = new f(this, millis, TimeUnit.SECONDS.toMillis(1L), pbActivity).start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.exP != null) {
                    this.exP.p(true);
                }
                this.exC.setVisibility(8);
                this.exG.setVisibility(8);
                this.exD.setVisibility(8);
                this.exH.setVisibility(0);
                this.exB.setTextSize(0, com.baidu.adp.lib.util.k.g(pbActivity.getPageContext().getPageActivity(), w.f.fontsize28));
                aq.k(this.mRootView, w.e.cp_bg_line_e);
                aq.i((View) this.exB, w.e.cp_cont_f);
                aq.k(this.exH, w.e.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (ss == 2) {
                    this.exB.setText(pbActivity.getPageContext().getPageActivity().getString(w.l.interview_live_in_process));
                    if (this.exN) {
                        ab(pbActivity);
                        return;
                    }
                    return;
                }
                this.exB.setText(pbActivity.getPageContext().getPageActivity().getString(w.l.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    private void ab(PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(w.j.interview_transfer_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(w.h.transfer_count_down);
            View findViewById = inflate.findViewById(w.h.line_left);
            View findViewById2 = inflate.findViewById(w.h.line_right);
            aq.j((ImageView) inflate.findViewById(w.h.pop_live), w.g.pic_pop_live_n);
            aq.i((View) ((TextView) inflate.findViewById(w.h.transfer_tip_txt)), w.e.cp_cont_b);
            aq.i((View) ((TextView) inflate.findViewById(w.h.transfer_tip_txt_1)), w.e.cp_cont_b);
            aq.k(findViewById, w.e.cp_bg_line_a);
            aq.k(findViewById2, w.e.cp_bg_line_a);
            aq.i((View) textView, w.e.cp_cont_f);
            this.exJ = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.exJ.v(inflate);
            this.exJ.a((String) null, (a.b) null);
            this.exJ.b(w.l.cancel, new g(this));
            this.exJ.at(false);
            this.exJ.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.h.fM().postDelayed(new h(this), TimeUnit.MICROSECONDS.toMillis(200L));
            this.exM = new i(this, TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L), textView, pbActivity).start();
        }
    }

    private Animation ac(PbActivity pbActivity) {
        if (this.exI == null) {
            this.exI = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), w.a.rotate_anim);
            this.exI.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.exI.setInterpolator(new LinearInterpolator());
            this.exI.setFillAfter(true);
        }
        return this.exI;
    }

    public boolean getIndicateStatus() {
        return this.exO;
    }

    public void clearStatus() {
        if (this.exK != null) {
            this.exK.cancel();
            this.exK = null;
        }
        if (this.exL != null) {
            this.exL.cancel();
            this.exL = null;
        }
        if (this.exM != null) {
            this.exM.cancel();
            this.exM = null;
        }
        if (this.exJ != null) {
            this.exJ.dismiss();
            this.exJ = null;
        }
    }
}
