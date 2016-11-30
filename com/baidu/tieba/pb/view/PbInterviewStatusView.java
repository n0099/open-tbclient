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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.pb.data.h;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String Rf;
    private CountDownTimer eGA;
    private CountDownTimer eGB;
    private boolean eGC;
    private boolean eGD;
    private a eGE;
    private TextView eGq;
    private ImageView eGr;
    private FrameLayout eGs;
    private TextView eGt;
    private ImageView eGu;
    private ImageView eGv;
    private View eGw;
    private Animation eGx;
    private com.baidu.tbadk.core.dialog.a eGy;
    private CountDownTimer eGz;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void o(boolean z);
    }

    public void setCallback(a aVar) {
        this.eGE = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.eGy = null;
        this.eGz = null;
        this.eGA = null;
        this.eGB = null;
        this.eGC = true;
        this.eGD = false;
        this.Rf = null;
        this.eGE = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.eGy = null;
        this.eGz = null;
        this.eGA = null;
        this.eGB = null;
        this.eGC = true;
        this.eGD = false;
        this.Rf = null;
        this.eGE = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.eGy = null;
        this.eGz = null;
        this.eGA = null;
        this.eGB = null;
        this.eGC = true;
        this.eGD = false;
        this.Rf = null;
        this.eGE = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(r.h.pb_interview_status, (ViewGroup) this, true);
        this.eGq = (TextView) this.mRootView.findViewById(r.g.interview_live_status_btn);
        this.eGs = (FrameLayout) this.mRootView.findViewById(r.g.count_container);
        this.eGr = (ImageView) this.mRootView.findViewById(r.g.interview_mic);
        this.eGv = (ImageView) this.mRootView.findViewById(r.g.interview_arrow);
        this.eGt = (TextView) this.mRootView.findViewById(r.g.count_text);
        this.eGu = (ImageView) this.mRootView.findViewById(r.g.count_bg);
        this.eGw = this.mRootView.findViewById(r.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        at.l(this.mRootView, r.d.cp_link_tip_a);
        at.j((View) this.eGq, r.d.cp_cont_g);
        at.k(this.eGu, r.f.icon_interview_loding);
        at.j((View) this.eGt, r.d.cp_cont_g);
        at.k(this.eGr, r.f.icon_interview_mic);
        at.k(this.eGv, r.f.icon_arrow_tip_white);
        at.l(this.eGw, r.d.cp_bg_line_c);
    }

    public void a(PbActivity pbActivity, h hVar) {
        this.Rf = hVar.aOl().rz().pw();
        if (StringUtils.isNull(this.Rf)) {
            this.Rf = hVar.aOl().rz().getTaskId();
        }
        this.eGC = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aPD());
        b(pbActivity, hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PbActivity pbActivity, h hVar) {
        int sq = hVar.aOl().sq();
        switch (sq) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(hVar.aOl().rz().rs()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.eGz = new l(this, millis2, millis2, pbActivity, hVar).start();
                    this.mRootView.setVisibility(8);
                    if (this.eGE != null) {
                        this.eGE.o(false);
                    }
                } else {
                    TiebaStatic.log(new av("c11105").ab("obj_id", this.Rf));
                    this.mRootView.setVisibility(0);
                    if (this.eGE != null) {
                        this.eGE.o(true);
                    }
                    this.eGq.setText(pbActivity.getPageContext().getPageActivity().getString(r.j.interview_live_before_start));
                    this.eGq.setTextSize(0, com.baidu.adp.lib.util.k.e(pbActivity.getPageContext().getPageActivity(), r.e.fontsize24));
                    this.eGr.setVisibility(8);
                    this.eGv.setVisibility(8);
                    this.eGw.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.eGu, ac(pbActivity), (Animation.AnimationListener) null);
                    if (this.eGA != null) {
                        this.eGA.cancel();
                    }
                    this.eGA = new m(this, millis, TimeUnit.SECONDS.toMillis(1L), pbActivity).start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.eGE != null) {
                    this.eGE.o(true);
                }
                this.eGr.setVisibility(8);
                this.eGv.setVisibility(8);
                this.eGs.setVisibility(8);
                this.eGw.setVisibility(0);
                this.eGq.setTextSize(0, com.baidu.adp.lib.util.k.e(pbActivity.getPageContext().getPageActivity(), r.e.fontsize28));
                at.l(this.mRootView, r.d.cp_bg_line_e);
                at.j((View) this.eGq, r.d.cp_cont_f);
                at.l(this.eGw, r.d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (sq == 2) {
                    this.eGq.setText(pbActivity.getPageContext().getPageActivity().getString(r.j.interview_live_in_process));
                    if (this.eGC) {
                        ab(pbActivity);
                        return;
                    }
                    return;
                }
                this.eGq.setText(pbActivity.getPageContext().getPageActivity().getString(r.j.interview_live_finished));
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
            at.k((ImageView) inflate.findViewById(r.g.pop_live), r.f.pic_pop_live_n);
            at.j((View) ((TextView) inflate.findViewById(r.g.transfer_tip_txt)), r.d.cp_cont_b);
            at.j((View) ((TextView) inflate.findViewById(r.g.transfer_tip_txt_1)), r.d.cp_cont_b);
            at.l(findViewById, r.d.cp_bg_line_a);
            at.l(findViewById2, r.d.cp_bg_line_a);
            at.j((View) textView, r.d.cp_cont_f);
            this.eGy = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.eGy.z(inflate);
            this.eGy.a((String) null, (a.b) null);
            this.eGy.b(r.j.cancel, new n(this));
            this.eGy.at(false);
            this.eGy.b(pbActivity.getPageContext());
            com.baidu.adp.lib.h.h.eG().postDelayed(new o(this), TimeUnit.MICROSECONDS.toMillis(200L));
            this.eGB = new p(this, TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L), textView, pbActivity).start();
        }
    }

    private Animation ac(PbActivity pbActivity) {
        if (this.eGx == null) {
            this.eGx = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), r.a.rotate_anim);
            this.eGx.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.eGx.setInterpolator(new LinearInterpolator());
            this.eGx.setFillAfter(true);
        }
        return this.eGx;
    }

    public boolean getIndicateStatus() {
        return this.eGD;
    }

    public void clearStatus() {
        if (this.eGz != null) {
            this.eGz.cancel();
            this.eGz = null;
        }
        if (this.eGA != null) {
            this.eGA.cancel();
            this.eGA = null;
        }
        if (this.eGB != null) {
            this.eGB.cancel();
            this.eGB = null;
        }
        if (this.eGy != null) {
            this.eGy.dismiss();
            this.eGy = null;
        }
    }
}
