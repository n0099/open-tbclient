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
import com.baidu.tieba.u;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String NX;
    private View elA;
    private Animation elB;
    private com.baidu.tbadk.core.dialog.a elC;
    private CountDownTimer elD;
    private CountDownTimer elE;
    private CountDownTimer elF;
    private boolean elG;
    private boolean elH;
    private a elI;
    private TextView elu;
    private ImageView elv;
    private FrameLayout elw;
    private TextView elx;
    private ImageView ely;
    private ImageView elz;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void m(boolean z);
    }

    public void setCallback(a aVar) {
        this.elI = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.elC = null;
        this.elD = null;
        this.elE = null;
        this.elF = null;
        this.elG = true;
        this.elH = false;
        this.NX = null;
        this.elI = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.elC = null;
        this.elD = null;
        this.elE = null;
        this.elF = null;
        this.elG = true;
        this.elH = false;
        this.NX = null;
        this.elI = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.elC = null;
        this.elD = null;
        this.elE = null;
        this.elF = null;
        this.elG = true;
        this.elH = false;
        this.NX = null;
        this.elI = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(u.h.pb_interview_status, (ViewGroup) this, true);
        this.elu = (TextView) this.mRootView.findViewById(u.g.interview_live_status_btn);
        this.elw = (FrameLayout) this.mRootView.findViewById(u.g.count_container);
        this.elv = (ImageView) this.mRootView.findViewById(u.g.interview_mic);
        this.elz = (ImageView) this.mRootView.findViewById(u.g.interview_arrow);
        this.elx = (TextView) this.mRootView.findViewById(u.g.count_text);
        this.ely = (ImageView) this.mRootView.findViewById(u.g.count_bg);
        this.elA = this.mRootView.findViewById(u.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        av.l(this.mRootView, u.d.cp_link_tip_a);
        av.j((View) this.elu, u.d.cp_cont_g);
        av.k(this.ely, u.f.icon_interview_loding);
        av.j((View) this.elx, u.d.cp_cont_g);
        av.k(this.elv, u.f.icon_interview_mic);
        av.k(this.elz, u.f.icon_arrow_tip_white);
        av.l(this.elA, u.d.cp_bg_line_c);
    }

    public void a(PbActivity pbActivity, h hVar) {
        this.NX = hVar.aGY().qh().ow();
        if (StringUtils.isNull(this.NX)) {
            this.NX = hVar.aGY().qh().getTaskId();
        }
        this.elG = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aIo());
        b(pbActivity, hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PbActivity pbActivity, h hVar) {
        int qX = hVar.aGY().qX();
        switch (qX) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(hVar.aGY().qh().qb()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.elD = new n(this, millis2, millis2, pbActivity, hVar).start();
                    this.mRootView.setVisibility(8);
                    if (this.elI != null) {
                        this.elI.m(false);
                    }
                } else {
                    TiebaStatic.log(new ay("c11105").ab("obj_id", this.NX));
                    this.mRootView.setVisibility(0);
                    if (this.elI != null) {
                        this.elI.m(true);
                    }
                    this.elu.setText(pbActivity.getPageContext().getPageActivity().getString(u.j.interview_live_before_start));
                    this.elu.setTextSize(0, k.c(pbActivity.getPageContext().getPageActivity(), u.e.fontsize24));
                    this.elv.setVisibility(8);
                    this.elz.setVisibility(8);
                    this.elA.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.ely, ae(pbActivity), (Animation.AnimationListener) null);
                    if (this.elE != null) {
                        this.elE.cancel();
                    }
                    this.elE = new o(this, millis, TimeUnit.SECONDS.toMillis(1L), pbActivity).start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.elI != null) {
                    this.elI.m(true);
                }
                this.elv.setVisibility(8);
                this.elz.setVisibility(8);
                this.elw.setVisibility(8);
                this.elA.setVisibility(0);
                this.elu.setTextSize(0, k.c(pbActivity.getPageContext().getPageActivity(), u.e.fontsize28));
                av.l(this.mRootView, u.d.cp_bg_line_e);
                av.j((View) this.elu, u.d.cp_cont_f);
                av.l(this.elA, u.d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (qX == 2) {
                    this.elu.setText(pbActivity.getPageContext().getPageActivity().getString(u.j.interview_live_in_process));
                    if (this.elG) {
                        ad(pbActivity);
                        return;
                    }
                    return;
                }
                this.elu.setText(pbActivity.getPageContext().getPageActivity().getString(u.j.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    private void ad(PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(u.h.interview_transfer_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(u.g.transfer_count_down);
            View findViewById = inflate.findViewById(u.g.line_left);
            View findViewById2 = inflate.findViewById(u.g.line_right);
            av.k((ImageView) inflate.findViewById(u.g.pop_live), u.f.pic_pop_live_n);
            av.j((View) ((TextView) inflate.findViewById(u.g.transfer_tip_txt)), u.d.cp_cont_b);
            av.j((View) ((TextView) inflate.findViewById(u.g.transfer_tip_txt_1)), u.d.cp_cont_b);
            av.l(findViewById, u.d.cp_bg_line_a);
            av.l(findViewById2, u.d.cp_bg_line_a);
            av.j((View) textView, u.d.cp_cont_f);
            this.elC = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.elC.y(inflate);
            this.elC.a((String) null, (a.b) null);
            this.elC.b(u.j.cancel, new p(this));
            this.elC.ap(false);
            this.elC.b(pbActivity.getPageContext());
            com.baidu.adp.lib.h.h.dL().postDelayed(new q(this), TimeUnit.MICROSECONDS.toMillis(200L));
            this.elF = new r(this, TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L), textView, pbActivity).start();
        }
    }

    private Animation ae(PbActivity pbActivity) {
        if (this.elB == null) {
            this.elB = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), u.a.rotate_anim);
            this.elB.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.elB.setInterpolator(new LinearInterpolator());
            this.elB.setFillAfter(true);
        }
        return this.elB;
    }

    public boolean getIndicateStatus() {
        return this.elH;
    }

    public void clearStatus() {
        if (this.elD != null) {
            this.elD.cancel();
            this.elD = null;
        }
        if (this.elE != null) {
            this.elE.cancel();
            this.elE = null;
        }
        if (this.elF != null) {
            this.elF.cancel();
            this.elF = null;
        }
        if (this.elC != null) {
            this.elC.dismiss();
            this.elC = null;
        }
    }
}
