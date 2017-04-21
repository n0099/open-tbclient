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
    private String VR;
    private TextView exX;
    private ImageView exY;
    private FrameLayout exZ;
    private TextView eya;
    private ImageView eyb;
    private ImageView eyc;
    private View eyd;
    private Animation eye;
    private com.baidu.tbadk.core.dialog.a eyf;
    private CountDownTimer eyg;
    private CountDownTimer eyh;
    private CountDownTimer eyi;
    private boolean eyj;
    private boolean eyk;
    private a eyl;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void p(boolean z);
    }

    public void setCallback(a aVar) {
        this.eyl = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.eyf = null;
        this.eyg = null;
        this.eyh = null;
        this.eyi = null;
        this.eyj = true;
        this.eyk = false;
        this.VR = null;
        this.eyl = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.eyf = null;
        this.eyg = null;
        this.eyh = null;
        this.eyi = null;
        this.eyj = true;
        this.eyk = false;
        this.VR = null;
        this.eyl = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.eyf = null;
        this.eyg = null;
        this.eyh = null;
        this.eyi = null;
        this.eyj = true;
        this.eyk = false;
        this.VR = null;
        this.eyl = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(w.j.pb_interview_status, (ViewGroup) this, true);
        this.exX = (TextView) this.mRootView.findViewById(w.h.interview_live_status_btn);
        this.exZ = (FrameLayout) this.mRootView.findViewById(w.h.count_container);
        this.exY = (ImageView) this.mRootView.findViewById(w.h.interview_mic);
        this.eyc = (ImageView) this.mRootView.findViewById(w.h.interview_arrow);
        this.eya = (TextView) this.mRootView.findViewById(w.h.count_text);
        this.eyb = (ImageView) this.mRootView.findViewById(w.h.count_bg);
        this.eyd = this.mRootView.findViewById(w.h.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        aq.k(this.mRootView, w.e.cp_link_tip_a);
        aq.i(this.exX, w.e.cp_cont_g);
        aq.j(this.eyb, w.g.icon_interview_loding);
        aq.i(this.eya, w.e.cp_cont_g);
        aq.j(this.exY, w.g.icon_interview_mic);
        aq.j(this.eyc, w.g.icon_arrow_tip_white);
        aq.k(this.eyd, w.e.cp_bg_line_c);
    }

    public void a(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.VR = fVar.aKy().rX().qb();
        if (StringUtils.isNull(this.VR)) {
            this.VR = fVar.aKy().rX().getTaskId();
        }
        this.eyj = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aLQ());
        b(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        int sQ = fVar.aKy().sQ();
        switch (sQ) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aKy().rX().rQ()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.eyg = new e(this, millis2, millis2, pbActivity, fVar).start();
                    this.mRootView.setVisibility(8);
                    if (this.eyl != null) {
                        this.eyl.p(false);
                    }
                } else {
                    TiebaStatic.log(new as("c11105").aa("obj_id", this.VR));
                    this.mRootView.setVisibility(0);
                    if (this.eyl != null) {
                        this.eyl.p(true);
                    }
                    this.exX.setText(pbActivity.getPageContext().getPageActivity().getString(w.l.interview_live_before_start));
                    this.exX.setTextSize(0, com.baidu.adp.lib.util.k.g(pbActivity.getPageContext().getPageActivity(), w.f.fontsize24));
                    this.exY.setVisibility(8);
                    this.eyc.setVisibility(8);
                    this.eyd.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.eyb, ac(pbActivity), (Animation.AnimationListener) null);
                    if (this.eyh != null) {
                        this.eyh.cancel();
                    }
                    this.eyh = new f(this, millis, TimeUnit.SECONDS.toMillis(1L), pbActivity).start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.eyl != null) {
                    this.eyl.p(true);
                }
                this.exY.setVisibility(8);
                this.eyc.setVisibility(8);
                this.exZ.setVisibility(8);
                this.eyd.setVisibility(0);
                this.exX.setTextSize(0, com.baidu.adp.lib.util.k.g(pbActivity.getPageContext().getPageActivity(), w.f.fontsize28));
                aq.k(this.mRootView, w.e.cp_bg_line_e);
                aq.i(this.exX, w.e.cp_cont_f);
                aq.k(this.eyd, w.e.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (sQ == 2) {
                    this.exX.setText(pbActivity.getPageContext().getPageActivity().getString(w.l.interview_live_in_process));
                    if (this.eyj) {
                        ab(pbActivity);
                        return;
                    }
                    return;
                }
                this.exX.setText(pbActivity.getPageContext().getPageActivity().getString(w.l.interview_live_finished));
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
            this.eyf = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.eyf.v(inflate);
            this.eyf.a((String) null, (a.b) null);
            this.eyf.b(w.l.cancel, new g(this));
            this.eyf.av(false);
            this.eyf.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.h.fS().postDelayed(new h(this), TimeUnit.MICROSECONDS.toMillis(200L));
            this.eyi = new i(this, TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L), textView, pbActivity).start();
        }
    }

    private Animation ac(PbActivity pbActivity) {
        if (this.eye == null) {
            this.eye = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), w.a.rotate_anim);
            this.eye.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.eye.setInterpolator(new LinearInterpolator());
            this.eye.setFillAfter(true);
        }
        return this.eye;
    }

    public boolean getIndicateStatus() {
        return this.eyk;
    }

    public void clearStatus() {
        if (this.eyg != null) {
            this.eyg.cancel();
            this.eyg = null;
        }
        if (this.eyh != null) {
            this.eyh.cancel();
            this.eyh = null;
        }
        if (this.eyi != null) {
            this.eyi.cancel();
            this.eyi = null;
        }
        if (this.eyf != null) {
            this.eyf.dismiss();
            this.eyf = null;
        }
    }
}
