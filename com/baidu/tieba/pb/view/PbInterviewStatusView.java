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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String UW;
    private com.baidu.tbadk.core.dialog.a eLA;
    private CountDownTimer eLB;
    private CountDownTimer eLC;
    private CountDownTimer eLD;
    private boolean eLE;
    private boolean eLF;
    private a eLG;
    private TextView eLs;
    private ImageView eLt;
    private FrameLayout eLu;
    private TextView eLv;
    private ImageView eLw;
    private ImageView eLx;
    private View eLy;
    private Animation eLz;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void p(boolean z);
    }

    public void setCallback(a aVar) {
        this.eLG = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.eLA = null;
        this.eLB = null;
        this.eLC = null;
        this.eLD = null;
        this.eLE = true;
        this.eLF = false;
        this.UW = null;
        this.eLG = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.eLA = null;
        this.eLB = null;
        this.eLC = null;
        this.eLD = null;
        this.eLE = true;
        this.eLF = false;
        this.UW = null;
        this.eLG = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.eLA = null;
        this.eLB = null;
        this.eLC = null;
        this.eLD = null;
        this.eLE = true;
        this.eLF = false;
        this.UW = null;
        this.eLG = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(w.j.pb_interview_status, (ViewGroup) this, true);
        this.eLs = (TextView) this.mRootView.findViewById(w.h.interview_live_status_btn);
        this.eLu = (FrameLayout) this.mRootView.findViewById(w.h.count_container);
        this.eLt = (ImageView) this.mRootView.findViewById(w.h.interview_mic);
        this.eLx = (ImageView) this.mRootView.findViewById(w.h.interview_arrow);
        this.eLv = (TextView) this.mRootView.findViewById(w.h.count_text);
        this.eLw = (ImageView) this.mRootView.findViewById(w.h.count_bg);
        this.eLy = this.mRootView.findViewById(w.h.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        as.k(this.mRootView, w.e.cp_link_tip_a);
        as.i(this.eLs, w.e.cp_cont_g);
        as.j(this.eLw, w.g.icon_interview_loding);
        as.i(this.eLv, w.e.cp_cont_g);
        as.j(this.eLt, w.g.icon_interview_mic);
        as.j(this.eLx, w.g.icon_arrow_tip_white);
        as.k(this.eLy, w.e.cp_bg_line_c);
    }

    public void a(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.UW = fVar.aMv().ra().pu();
        if (StringUtils.isNull(this.UW)) {
            this.UW = fVar.aMv().ra().getTaskId();
        }
        this.eLE = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aOc());
        b(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        int rT = fVar.aMv().rT();
        switch (rT) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aMv().ra().qT()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.eLB = new g(this, millis2, millis2, pbActivity, fVar).start();
                    this.mRootView.setVisibility(8);
                    if (this.eLG != null) {
                        this.eLG.p(false);
                    }
                } else {
                    TiebaStatic.log(new au("c11105").Z("obj_id", this.UW));
                    this.mRootView.setVisibility(0);
                    if (this.eLG != null) {
                        this.eLG.p(true);
                    }
                    this.eLs.setText(pbActivity.getPageContext().getPageActivity().getString(w.l.interview_live_before_start));
                    this.eLs.setTextSize(0, com.baidu.adp.lib.util.k.g(pbActivity.getPageContext().getPageActivity(), w.f.fontsize24));
                    this.eLt.setVisibility(8);
                    this.eLx.setVisibility(8);
                    this.eLy.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.eLw, ao(pbActivity), (Animation.AnimationListener) null);
                    if (this.eLC != null) {
                        this.eLC.cancel();
                    }
                    this.eLC = new h(this, millis, TimeUnit.SECONDS.toMillis(1L), pbActivity).start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.eLG != null) {
                    this.eLG.p(true);
                }
                this.eLt.setVisibility(8);
                this.eLx.setVisibility(8);
                this.eLu.setVisibility(8);
                this.eLy.setVisibility(0);
                this.eLs.setTextSize(0, com.baidu.adp.lib.util.k.g(pbActivity.getPageContext().getPageActivity(), w.f.fontsize28));
                as.k(this.mRootView, w.e.cp_bg_line_e);
                as.i(this.eLs, w.e.cp_cont_f);
                as.k(this.eLy, w.e.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (rT == 2) {
                    this.eLs.setText(pbActivity.getPageContext().getPageActivity().getString(w.l.interview_live_in_process));
                    if (this.eLE) {
                        an(pbActivity);
                        return;
                    }
                    return;
                }
                this.eLs.setText(pbActivity.getPageContext().getPageActivity().getString(w.l.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    private void an(PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(w.j.interview_transfer_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(w.h.transfer_count_down);
            View findViewById = inflate.findViewById(w.h.line_left);
            View findViewById2 = inflate.findViewById(w.h.line_right);
            as.j((ImageView) inflate.findViewById(w.h.pop_live), w.g.pic_pop_live_n);
            as.i((TextView) inflate.findViewById(w.h.transfer_tip_txt), w.e.cp_cont_b);
            as.i((TextView) inflate.findViewById(w.h.transfer_tip_txt_1), w.e.cp_cont_b);
            as.k(findViewById, w.e.cp_bg_line_a);
            as.k(findViewById2, w.e.cp_bg_line_a);
            as.i(textView, w.e.cp_cont_f);
            this.eLA = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.eLA.v(inflate);
            this.eLA.a((String) null, (a.b) null);
            this.eLA.b(w.l.cancel, new i(this));
            this.eLA.as(false);
            this.eLA.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.h.fR().postDelayed(new j(this), TimeUnit.MICROSECONDS.toMillis(200L));
            this.eLD = new k(this, TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L), textView, pbActivity).start();
        }
    }

    private Animation ao(PbActivity pbActivity) {
        if (this.eLz == null) {
            this.eLz = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), w.a.rotate_anim);
            this.eLz.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.eLz.setInterpolator(new LinearInterpolator());
            this.eLz.setFillAfter(true);
        }
        return this.eLz;
    }

    public boolean getIndicateStatus() {
        return this.eLF;
    }

    public void clearStatus() {
        if (this.eLB != null) {
            this.eLB.cancel();
            this.eLB = null;
        }
        if (this.eLC != null) {
            this.eLC.cancel();
            this.eLC = null;
        }
        if (this.eLD != null) {
            this.eLD.cancel();
            this.eLD = null;
        }
        if (this.eLA != null) {
            this.eLA.dismiss();
            this.eLA = null;
        }
    }
}
