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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.pb.data.h;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String QJ;
    private TextView ezH;
    private ImageView ezI;
    private FrameLayout ezJ;
    private TextView ezK;
    private ImageView ezL;
    private ImageView ezM;
    private View ezN;
    private Animation ezO;
    private com.baidu.tbadk.core.dialog.a ezP;
    private CountDownTimer ezQ;
    private CountDownTimer ezR;
    private CountDownTimer ezS;
    private boolean ezT;
    private boolean ezU;
    private a ezV;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void o(boolean z);
    }

    public void setCallback(a aVar) {
        this.ezV = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.ezP = null;
        this.ezQ = null;
        this.ezR = null;
        this.ezS = null;
        this.ezT = true;
        this.ezU = false;
        this.QJ = null;
        this.ezV = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.ezP = null;
        this.ezQ = null;
        this.ezR = null;
        this.ezS = null;
        this.ezT = true;
        this.ezU = false;
        this.QJ = null;
        this.ezV = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.ezP = null;
        this.ezQ = null;
        this.ezR = null;
        this.ezS = null;
        this.ezT = true;
        this.ezU = false;
        this.QJ = null;
        this.ezV = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(r.h.pb_interview_status, (ViewGroup) this, true);
        this.ezH = (TextView) this.mRootView.findViewById(r.g.interview_live_status_btn);
        this.ezJ = (FrameLayout) this.mRootView.findViewById(r.g.count_container);
        this.ezI = (ImageView) this.mRootView.findViewById(r.g.interview_mic);
        this.ezM = (ImageView) this.mRootView.findViewById(r.g.interview_arrow);
        this.ezK = (TextView) this.mRootView.findViewById(r.g.count_text);
        this.ezL = (ImageView) this.mRootView.findViewById(r.g.count_bg);
        this.ezN = this.mRootView.findViewById(r.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        av.l(this.mRootView, r.d.cp_link_tip_a);
        av.j((View) this.ezH, r.d.cp_cont_g);
        av.k(this.ezL, r.f.icon_interview_loding);
        av.j((View) this.ezK, r.d.cp_cont_g);
        av.k(this.ezI, r.f.icon_interview_mic);
        av.k(this.ezM, r.f.icon_arrow_tip_white);
        av.l(this.ezN, r.d.cp_bg_line_c);
    }

    public void a(PbActivity pbActivity, h hVar) {
        this.QJ = hVar.aMs().rx().pt();
        if (StringUtils.isNull(this.QJ)) {
            this.QJ = hVar.aMs().rx().getTaskId();
        }
        this.ezT = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aNM());
        b(pbActivity, hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PbActivity pbActivity, h hVar) {
        int so = hVar.aMs().so();
        switch (so) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(hVar.aMs().rx().rq()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.ezQ = new n(this, millis2, millis2, pbActivity, hVar).start();
                    this.mRootView.setVisibility(8);
                    if (this.ezV != null) {
                        this.ezV.o(false);
                    }
                } else {
                    TiebaStatic.log(new ax("c11105").ab("obj_id", this.QJ));
                    this.mRootView.setVisibility(0);
                    if (this.ezV != null) {
                        this.ezV.o(true);
                    }
                    this.ezH.setText(pbActivity.getPageContext().getPageActivity().getString(r.j.interview_live_before_start));
                    this.ezH.setTextSize(0, k.e(pbActivity.getPageContext().getPageActivity(), r.e.fontsize24));
                    this.ezI.setVisibility(8);
                    this.ezM.setVisibility(8);
                    this.ezN.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.ezL, af(pbActivity), (Animation.AnimationListener) null);
                    if (this.ezR != null) {
                        this.ezR.cancel();
                    }
                    this.ezR = new o(this, millis, TimeUnit.SECONDS.toMillis(1L), pbActivity).start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.ezV != null) {
                    this.ezV.o(true);
                }
                this.ezI.setVisibility(8);
                this.ezM.setVisibility(8);
                this.ezJ.setVisibility(8);
                this.ezN.setVisibility(0);
                this.ezH.setTextSize(0, k.e(pbActivity.getPageContext().getPageActivity(), r.e.fontsize28));
                av.l(this.mRootView, r.d.cp_bg_line_e);
                av.j((View) this.ezH, r.d.cp_cont_f);
                av.l(this.ezN, r.d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (so == 2) {
                    this.ezH.setText(pbActivity.getPageContext().getPageActivity().getString(r.j.interview_live_in_process));
                    if (this.ezT) {
                        ae(pbActivity);
                        return;
                    }
                    return;
                }
                this.ezH.setText(pbActivity.getPageContext().getPageActivity().getString(r.j.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    private void ae(PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(r.h.interview_transfer_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(r.g.transfer_count_down);
            View findViewById = inflate.findViewById(r.g.line_left);
            View findViewById2 = inflate.findViewById(r.g.line_right);
            av.k((ImageView) inflate.findViewById(r.g.pop_live), r.f.pic_pop_live_n);
            av.j((View) ((TextView) inflate.findViewById(r.g.transfer_tip_txt)), r.d.cp_cont_b);
            av.j((View) ((TextView) inflate.findViewById(r.g.transfer_tip_txt_1)), r.d.cp_cont_b);
            av.l(findViewById, r.d.cp_bg_line_a);
            av.l(findViewById2, r.d.cp_bg_line_a);
            av.j((View) textView, r.d.cp_cont_f);
            this.ezP = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.ezP.z(inflate);
            this.ezP.a((String) null, (a.b) null);
            this.ezP.b(r.j.cancel, new p(this));
            this.ezP.aq(false);
            this.ezP.b(pbActivity.getPageContext());
            com.baidu.adp.lib.h.h.eG().postDelayed(new q(this), TimeUnit.MICROSECONDS.toMillis(200L));
            this.ezS = new r(this, TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L), textView, pbActivity).start();
        }
    }

    private Animation af(PbActivity pbActivity) {
        if (this.ezO == null) {
            this.ezO = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), r.a.rotate_anim);
            this.ezO.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.ezO.setInterpolator(new LinearInterpolator());
            this.ezO.setFillAfter(true);
        }
        return this.ezO;
    }

    public boolean getIndicateStatus() {
        return this.ezU;
    }

    public void clearStatus() {
        if (this.ezQ != null) {
            this.ezQ.cancel();
            this.ezQ = null;
        }
        if (this.ezR != null) {
            this.ezR.cancel();
            this.ezR = null;
        }
        if (this.ezS != null) {
            this.ezS.cancel();
            this.ezS = null;
        }
        if (this.ezP != null) {
            this.ezP.dismiss();
            this.ezP = null;
        }
    }
}
