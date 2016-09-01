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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.pb.data.h;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String QF;
    private TextView exA;
    private ImageView exB;
    private FrameLayout exC;
    private TextView exD;
    private ImageView exE;
    private ImageView exF;
    private View exG;
    private Animation exH;
    private com.baidu.tbadk.core.dialog.a exI;
    private CountDownTimer exJ;
    private CountDownTimer exK;
    private CountDownTimer exL;
    private boolean exM;
    private boolean exN;
    private a exO;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void o(boolean z);
    }

    public void setCallback(a aVar) {
        this.exO = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.exI = null;
        this.exJ = null;
        this.exK = null;
        this.exL = null;
        this.exM = true;
        this.exN = false;
        this.QF = null;
        this.exO = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.exI = null;
        this.exJ = null;
        this.exK = null;
        this.exL = null;
        this.exM = true;
        this.exN = false;
        this.QF = null;
        this.exO = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.exI = null;
        this.exJ = null;
        this.exK = null;
        this.exL = null;
        this.exM = true;
        this.exN = false;
        this.QF = null;
        this.exO = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(t.h.pb_interview_status, (ViewGroup) this, true);
        this.exA = (TextView) this.mRootView.findViewById(t.g.interview_live_status_btn);
        this.exC = (FrameLayout) this.mRootView.findViewById(t.g.count_container);
        this.exB = (ImageView) this.mRootView.findViewById(t.g.interview_mic);
        this.exF = (ImageView) this.mRootView.findViewById(t.g.interview_arrow);
        this.exD = (TextView) this.mRootView.findViewById(t.g.count_text);
        this.exE = (ImageView) this.mRootView.findViewById(t.g.count_bg);
        this.exG = this.mRootView.findViewById(t.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        av.l(this.mRootView, t.d.cp_link_tip_a);
        av.j((View) this.exA, t.d.cp_cont_g);
        av.k(this.exE, t.f.icon_interview_loding);
        av.j((View) this.exD, t.d.cp_cont_g);
        av.k(this.exB, t.f.icon_interview_mic);
        av.k(this.exF, t.f.icon_arrow_tip_white);
        av.l(this.exG, t.d.cp_bg_line_c);
    }

    public void a(PbActivity pbActivity, h hVar) {
        this.QF = hVar.aLQ().rl().ps();
        if (StringUtils.isNull(this.QF)) {
            this.QF = hVar.aLQ().rl().getTaskId();
        }
        this.exM = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aNg());
        b(pbActivity, hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PbActivity pbActivity, h hVar) {
        int sc = hVar.aLQ().sc();
        switch (sc) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(hVar.aLQ().rl().rf()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.exJ = new n(this, millis2, millis2, pbActivity, hVar).start();
                    this.mRootView.setVisibility(8);
                    if (this.exO != null) {
                        this.exO.o(false);
                    }
                } else {
                    TiebaStatic.log(new ay("c11105").ab("obj_id", this.QF));
                    this.mRootView.setVisibility(0);
                    if (this.exO != null) {
                        this.exO.o(true);
                    }
                    this.exA.setText(pbActivity.getPageContext().getPageActivity().getString(t.j.interview_live_before_start));
                    this.exA.setTextSize(0, k.e(pbActivity.getPageContext().getPageActivity(), t.e.fontsize24));
                    this.exB.setVisibility(8);
                    this.exF.setVisibility(8);
                    this.exG.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.exE, ae(pbActivity), (Animation.AnimationListener) null);
                    if (this.exK != null) {
                        this.exK.cancel();
                    }
                    this.exK = new o(this, millis, TimeUnit.SECONDS.toMillis(1L), pbActivity).start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.exO != null) {
                    this.exO.o(true);
                }
                this.exB.setVisibility(8);
                this.exF.setVisibility(8);
                this.exC.setVisibility(8);
                this.exG.setVisibility(0);
                this.exA.setTextSize(0, k.e(pbActivity.getPageContext().getPageActivity(), t.e.fontsize28));
                av.l(this.mRootView, t.d.cp_bg_line_e);
                av.j((View) this.exA, t.d.cp_cont_f);
                av.l(this.exG, t.d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (sc == 2) {
                    this.exA.setText(pbActivity.getPageContext().getPageActivity().getString(t.j.interview_live_in_process));
                    if (this.exM) {
                        ad(pbActivity);
                        return;
                    }
                    return;
                }
                this.exA.setText(pbActivity.getPageContext().getPageActivity().getString(t.j.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    private void ad(PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(t.h.interview_transfer_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(t.g.transfer_count_down);
            View findViewById = inflate.findViewById(t.g.line_left);
            View findViewById2 = inflate.findViewById(t.g.line_right);
            av.k((ImageView) inflate.findViewById(t.g.pop_live), t.f.pic_pop_live_n);
            av.j((View) ((TextView) inflate.findViewById(t.g.transfer_tip_txt)), t.d.cp_cont_b);
            av.j((View) ((TextView) inflate.findViewById(t.g.transfer_tip_txt_1)), t.d.cp_cont_b);
            av.l(findViewById, t.d.cp_bg_line_a);
            av.l(findViewById2, t.d.cp_bg_line_a);
            av.j((View) textView, t.d.cp_cont_f);
            this.exI = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.exI.z(inflate);
            this.exI.a((String) null, (a.b) null);
            this.exI.b(t.j.cancel, new p(this));
            this.exI.aq(false);
            this.exI.b(pbActivity.getPageContext());
            com.baidu.adp.lib.h.h.eG().postDelayed(new q(this), TimeUnit.MICROSECONDS.toMillis(200L));
            this.exL = new r(this, TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L), textView, pbActivity).start();
        }
    }

    private Animation ae(PbActivity pbActivity) {
        if (this.exH == null) {
            this.exH = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), t.a.rotate_anim);
            this.exH.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.exH.setInterpolator(new LinearInterpolator());
            this.exH.setFillAfter(true);
        }
        return this.exH;
    }

    public boolean getIndicateStatus() {
        return this.exN;
    }

    public void clearStatus() {
        if (this.exJ != null) {
            this.exJ.cancel();
            this.exJ = null;
        }
        if (this.exK != null) {
            this.exK.cancel();
            this.exK = null;
        }
        if (this.exL != null) {
            this.exL.cancel();
            this.exL = null;
        }
        if (this.exI != null) {
            this.exI.dismiss();
            this.exI = null;
        }
    }
}
