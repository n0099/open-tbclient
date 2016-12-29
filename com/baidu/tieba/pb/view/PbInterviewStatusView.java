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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String Rc;
    private TextView ekj;
    private ImageView ekk;
    private FrameLayout ekl;
    private TextView ekm;
    private ImageView ekn;
    private ImageView eko;
    private View ekp;
    private Animation ekq;
    private com.baidu.tbadk.core.dialog.a ekr;
    private CountDownTimer eks;
    private CountDownTimer ekt;
    private CountDownTimer eku;
    private boolean ekv;
    private boolean ekw;
    private a ekx;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void o(boolean z);
    }

    public void setCallback(a aVar) {
        this.ekx = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.ekr = null;
        this.eks = null;
        this.ekt = null;
        this.eku = null;
        this.ekv = true;
        this.ekw = false;
        this.Rc = null;
        this.ekx = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.ekr = null;
        this.eks = null;
        this.ekt = null;
        this.eku = null;
        this.ekv = true;
        this.ekw = false;
        this.Rc = null;
        this.ekx = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.ekr = null;
        this.eks = null;
        this.ekt = null;
        this.eku = null;
        this.ekv = true;
        this.ekw = false;
        this.Rc = null;
        this.ekx = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(r.h.pb_interview_status, (ViewGroup) this, true);
        this.ekj = (TextView) this.mRootView.findViewById(r.g.interview_live_status_btn);
        this.ekl = (FrameLayout) this.mRootView.findViewById(r.g.count_container);
        this.ekk = (ImageView) this.mRootView.findViewById(r.g.interview_mic);
        this.eko = (ImageView) this.mRootView.findViewById(r.g.interview_arrow);
        this.ekm = (TextView) this.mRootView.findViewById(r.g.count_text);
        this.ekn = (ImageView) this.mRootView.findViewById(r.g.count_bg);
        this.ekp = this.mRootView.findViewById(r.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ar.l(this.mRootView, r.d.cp_link_tip_a);
        ar.j((View) this.ekj, r.d.cp_cont_g);
        ar.k(this.ekn, r.f.icon_interview_loding);
        ar.j((View) this.ekm, r.d.cp_cont_g);
        ar.k(this.ekk, r.f.icon_interview_mic);
        ar.k(this.eko, r.f.icon_arrow_tip_white);
        ar.l(this.ekp, r.d.cp_bg_line_c);
    }

    public void a(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.Rc = fVar.aIl().ro().pw();
        if (StringUtils.isNull(this.Rc)) {
            this.Rc = fVar.aIl().ro().getTaskId();
        }
        this.ekv = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aJC());
        b(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        int sf = fVar.aIl().sf();
        switch (sf) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aIl().ro().rh()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.eks = new e(this, millis2, millis2, pbActivity, fVar).start();
                    this.mRootView.setVisibility(8);
                    if (this.ekx != null) {
                        this.ekx.o(false);
                    }
                } else {
                    TiebaStatic.log(new at("c11105").ab("obj_id", this.Rc));
                    this.mRootView.setVisibility(0);
                    if (this.ekx != null) {
                        this.ekx.o(true);
                    }
                    this.ekj.setText(pbActivity.getPageContext().getPageActivity().getString(r.j.interview_live_before_start));
                    this.ekj.setTextSize(0, com.baidu.adp.lib.util.k.e(pbActivity.getPageContext().getPageActivity(), r.e.fontsize24));
                    this.ekk.setVisibility(8);
                    this.eko.setVisibility(8);
                    this.ekp.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.ekn, ac(pbActivity), (Animation.AnimationListener) null);
                    if (this.ekt != null) {
                        this.ekt.cancel();
                    }
                    this.ekt = new f(this, millis, TimeUnit.SECONDS.toMillis(1L), pbActivity).start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.ekx != null) {
                    this.ekx.o(true);
                }
                this.ekk.setVisibility(8);
                this.eko.setVisibility(8);
                this.ekl.setVisibility(8);
                this.ekp.setVisibility(0);
                this.ekj.setTextSize(0, com.baidu.adp.lib.util.k.e(pbActivity.getPageContext().getPageActivity(), r.e.fontsize28));
                ar.l(this.mRootView, r.d.cp_bg_line_e);
                ar.j((View) this.ekj, r.d.cp_cont_f);
                ar.l(this.ekp, r.d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (sf == 2) {
                    this.ekj.setText(pbActivity.getPageContext().getPageActivity().getString(r.j.interview_live_in_process));
                    if (this.ekv) {
                        ab(pbActivity);
                        return;
                    }
                    return;
                }
                this.ekj.setText(pbActivity.getPageContext().getPageActivity().getString(r.j.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    private void ab(PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(r.h.interview_transfer_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(r.g.transfer_count_down);
            View findViewById = inflate.findViewById(r.g.line_left);
            View findViewById2 = inflate.findViewById(r.g.line_right);
            ar.k((ImageView) inflate.findViewById(r.g.pop_live), r.f.pic_pop_live_n);
            ar.j((View) ((TextView) inflate.findViewById(r.g.transfer_tip_txt)), r.d.cp_cont_b);
            ar.j((View) ((TextView) inflate.findViewById(r.g.transfer_tip_txt_1)), r.d.cp_cont_b);
            ar.l(findViewById, r.d.cp_bg_line_a);
            ar.l(findViewById2, r.d.cp_bg_line_a);
            ar.j((View) textView, r.d.cp_cont_f);
            this.ekr = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.ekr.z(inflate);
            this.ekr.a((String) null, (a.b) null);
            this.ekr.b(r.j.cancel, new g(this));
            this.ekr.au(false);
            this.ekr.b(pbActivity.getPageContext());
            com.baidu.adp.lib.h.h.eG().postDelayed(new h(this), TimeUnit.MICROSECONDS.toMillis(200L));
            this.eku = new i(this, TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L), textView, pbActivity).start();
        }
    }

    private Animation ac(PbActivity pbActivity) {
        if (this.ekq == null) {
            this.ekq = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), r.a.rotate_anim);
            this.ekq.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.ekq.setInterpolator(new LinearInterpolator());
            this.ekq.setFillAfter(true);
        }
        return this.ekq;
    }

    public boolean getIndicateStatus() {
        return this.ekw;
    }

    public void clearStatus() {
        if (this.eks != null) {
            this.eks.cancel();
            this.eks = null;
        }
        if (this.ekt != null) {
            this.ekt.cancel();
            this.ekt = null;
        }
        if (this.eku != null) {
            this.eku.cancel();
            this.eku = null;
        }
        if (this.ekr != null) {
            this.ekr.dismiss();
            this.ekr = null;
        }
    }
}
