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
    private String VP;
    private TextView evG;
    private ImageView evH;
    private FrameLayout evI;
    private TextView evJ;
    private ImageView evK;
    private ImageView evL;
    private View evM;
    private Animation evN;
    private com.baidu.tbadk.core.dialog.a evO;
    private CountDownTimer evP;
    private CountDownTimer evQ;
    private CountDownTimer evR;
    private boolean evS;
    private boolean evT;
    private a evU;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void p(boolean z);
    }

    public void setCallback(a aVar) {
        this.evU = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.evO = null;
        this.evP = null;
        this.evQ = null;
        this.evR = null;
        this.evS = true;
        this.evT = false;
        this.VP = null;
        this.evU = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.evO = null;
        this.evP = null;
        this.evQ = null;
        this.evR = null;
        this.evS = true;
        this.evT = false;
        this.VP = null;
        this.evU = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.evO = null;
        this.evP = null;
        this.evQ = null;
        this.evR = null;
        this.evS = true;
        this.evT = false;
        this.VP = null;
        this.evU = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(w.j.pb_interview_status, (ViewGroup) this, true);
        this.evG = (TextView) this.mRootView.findViewById(w.h.interview_live_status_btn);
        this.evI = (FrameLayout) this.mRootView.findViewById(w.h.count_container);
        this.evH = (ImageView) this.mRootView.findViewById(w.h.interview_mic);
        this.evL = (ImageView) this.mRootView.findViewById(w.h.interview_arrow);
        this.evJ = (TextView) this.mRootView.findViewById(w.h.count_text);
        this.evK = (ImageView) this.mRootView.findViewById(w.h.count_bg);
        this.evM = this.mRootView.findViewById(w.h.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        aq.k(this.mRootView, w.e.cp_link_tip_a);
        aq.i(this.evG, w.e.cp_cont_g);
        aq.j(this.evK, w.g.icon_interview_loding);
        aq.i(this.evJ, w.e.cp_cont_g);
        aq.j(this.evH, w.g.icon_interview_mic);
        aq.j(this.evL, w.g.icon_arrow_tip_white);
        aq.k(this.evM, w.e.cp_bg_line_c);
    }

    public void a(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.VP = fVar.aJx().rX().qb();
        if (StringUtils.isNull(this.VP)) {
            this.VP = fVar.aJx().rX().getTaskId();
        }
        this.evS = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aKQ());
        b(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        int sQ = fVar.aJx().sQ();
        switch (sQ) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aJx().rX().rQ()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.evP = new e(this, millis2, millis2, pbActivity, fVar).start();
                    this.mRootView.setVisibility(8);
                    if (this.evU != null) {
                        this.evU.p(false);
                    }
                } else {
                    TiebaStatic.log(new as("c11105").aa("obj_id", this.VP));
                    this.mRootView.setVisibility(0);
                    if (this.evU != null) {
                        this.evU.p(true);
                    }
                    this.evG.setText(pbActivity.getPageContext().getPageActivity().getString(w.l.interview_live_before_start));
                    this.evG.setTextSize(0, com.baidu.adp.lib.util.k.g(pbActivity.getPageContext().getPageActivity(), w.f.fontsize24));
                    this.evH.setVisibility(8);
                    this.evL.setVisibility(8);
                    this.evM.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.evK, ac(pbActivity), (Animation.AnimationListener) null);
                    if (this.evQ != null) {
                        this.evQ.cancel();
                    }
                    this.evQ = new f(this, millis, TimeUnit.SECONDS.toMillis(1L), pbActivity).start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.evU != null) {
                    this.evU.p(true);
                }
                this.evH.setVisibility(8);
                this.evL.setVisibility(8);
                this.evI.setVisibility(8);
                this.evM.setVisibility(0);
                this.evG.setTextSize(0, com.baidu.adp.lib.util.k.g(pbActivity.getPageContext().getPageActivity(), w.f.fontsize28));
                aq.k(this.mRootView, w.e.cp_bg_line_e);
                aq.i(this.evG, w.e.cp_cont_f);
                aq.k(this.evM, w.e.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (sQ == 2) {
                    this.evG.setText(pbActivity.getPageContext().getPageActivity().getString(w.l.interview_live_in_process));
                    if (this.evS) {
                        ab(pbActivity);
                        return;
                    }
                    return;
                }
                this.evG.setText(pbActivity.getPageContext().getPageActivity().getString(w.l.interview_live_finished));
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
            aq.i((TextView) inflate.findViewById(w.h.transfer_tip_txt), w.e.cp_cont_b);
            aq.i((TextView) inflate.findViewById(w.h.transfer_tip_txt_1), w.e.cp_cont_b);
            aq.k(findViewById, w.e.cp_bg_line_a);
            aq.k(findViewById2, w.e.cp_bg_line_a);
            aq.i(textView, w.e.cp_cont_f);
            this.evO = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.evO.v(inflate);
            this.evO.a((String) null, (a.b) null);
            this.evO.b(w.l.cancel, new g(this));
            this.evO.av(false);
            this.evO.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.h.fR().postDelayed(new h(this), TimeUnit.MICROSECONDS.toMillis(200L));
            this.evR = new i(this, TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L), textView, pbActivity).start();
        }
    }

    private Animation ac(PbActivity pbActivity) {
        if (this.evN == null) {
            this.evN = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), w.a.rotate_anim);
            this.evN.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.evN.setInterpolator(new LinearInterpolator());
            this.evN.setFillAfter(true);
        }
        return this.evN;
    }

    public boolean getIndicateStatus() {
        return this.evT;
    }

    public void clearStatus() {
        if (this.evP != null) {
            this.evP.cancel();
            this.evP = null;
        }
        if (this.evQ != null) {
            this.evQ.cancel();
            this.evQ = null;
        }
        if (this.evR != null) {
            this.evR.cancel();
            this.evR = null;
        }
        if (this.evO != null) {
            this.evO.dismiss();
            this.evO = null;
        }
    }
}
