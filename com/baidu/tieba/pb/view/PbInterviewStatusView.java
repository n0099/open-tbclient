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
    private String Vk;
    private TextView etH;
    private ImageView etI;
    private FrameLayout etJ;
    private TextView etK;
    private ImageView etL;
    private ImageView etM;
    private View etN;
    private Animation etO;
    private com.baidu.tbadk.core.dialog.a etP;
    private CountDownTimer etQ;
    private CountDownTimer etR;
    private CountDownTimer etS;
    private boolean etT;
    private boolean etU;
    private a etV;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void p(boolean z);
    }

    public void setCallback(a aVar) {
        this.etV = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.etP = null;
        this.etQ = null;
        this.etR = null;
        this.etS = null;
        this.etT = true;
        this.etU = false;
        this.Vk = null;
        this.etV = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.etP = null;
        this.etQ = null;
        this.etR = null;
        this.etS = null;
        this.etT = true;
        this.etU = false;
        this.Vk = null;
        this.etV = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.etP = null;
        this.etQ = null;
        this.etR = null;
        this.etS = null;
        this.etT = true;
        this.etU = false;
        this.Vk = null;
        this.etV = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(w.j.pb_interview_status, (ViewGroup) this, true);
        this.etH = (TextView) this.mRootView.findViewById(w.h.interview_live_status_btn);
        this.etJ = (FrameLayout) this.mRootView.findViewById(w.h.count_container);
        this.etI = (ImageView) this.mRootView.findViewById(w.h.interview_mic);
        this.etM = (ImageView) this.mRootView.findViewById(w.h.interview_arrow);
        this.etK = (TextView) this.mRootView.findViewById(w.h.count_text);
        this.etL = (ImageView) this.mRootView.findViewById(w.h.count_bg);
        this.etN = this.mRootView.findViewById(w.h.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        aq.k(this.mRootView, w.e.cp_link_tip_a);
        aq.i(this.etH, w.e.cp_cont_g);
        aq.j(this.etL, w.g.icon_interview_loding);
        aq.i(this.etK, w.e.cp_cont_g);
        aq.j(this.etI, w.g.icon_interview_mic);
        aq.j(this.etM, w.g.icon_arrow_tip_white);
        aq.k(this.etN, w.e.cp_bg_line_c);
    }

    public void a(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.Vk = fVar.aHG().rh().pF();
        if (StringUtils.isNull(this.Vk)) {
            this.Vk = fVar.aHG().rh().getTaskId();
        }
        this.etT = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aJn());
        b(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        int sa = fVar.aHG().sa();
        switch (sa) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aHG().rh().ra()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.etQ = new e(this, millis2, millis2, pbActivity, fVar).start();
                    this.mRootView.setVisibility(8);
                    if (this.etV != null) {
                        this.etV.p(false);
                    }
                } else {
                    TiebaStatic.log(new as("c11105").aa("obj_id", this.Vk));
                    this.mRootView.setVisibility(0);
                    if (this.etV != null) {
                        this.etV.p(true);
                    }
                    this.etH.setText(pbActivity.getPageContext().getPageActivity().getString(w.l.interview_live_before_start));
                    this.etH.setTextSize(0, com.baidu.adp.lib.util.k.g(pbActivity.getPageContext().getPageActivity(), w.f.fontsize24));
                    this.etI.setVisibility(8);
                    this.etM.setVisibility(8);
                    this.etN.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.etL, ae(pbActivity), (Animation.AnimationListener) null);
                    if (this.etR != null) {
                        this.etR.cancel();
                    }
                    this.etR = new f(this, millis, TimeUnit.SECONDS.toMillis(1L), pbActivity).start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.etV != null) {
                    this.etV.p(true);
                }
                this.etI.setVisibility(8);
                this.etM.setVisibility(8);
                this.etJ.setVisibility(8);
                this.etN.setVisibility(0);
                this.etH.setTextSize(0, com.baidu.adp.lib.util.k.g(pbActivity.getPageContext().getPageActivity(), w.f.fontsize28));
                aq.k(this.mRootView, w.e.cp_bg_line_e);
                aq.i(this.etH, w.e.cp_cont_f);
                aq.k(this.etN, w.e.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (sa == 2) {
                    this.etH.setText(pbActivity.getPageContext().getPageActivity().getString(w.l.interview_live_in_process));
                    if (this.etT) {
                        ad(pbActivity);
                        return;
                    }
                    return;
                }
                this.etH.setText(pbActivity.getPageContext().getPageActivity().getString(w.l.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    private void ad(PbActivity pbActivity) {
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
            this.etP = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.etP.v(inflate);
            this.etP.a((String) null, (a.b) null);
            this.etP.b(w.l.cancel, new g(this));
            this.etP.as(false);
            this.etP.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.h.fS().postDelayed(new h(this), TimeUnit.MICROSECONDS.toMillis(200L));
            this.etS = new i(this, TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L), textView, pbActivity).start();
        }
    }

    private Animation ae(PbActivity pbActivity) {
        if (this.etO == null) {
            this.etO = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), w.a.rotate_anim);
            this.etO.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.etO.setInterpolator(new LinearInterpolator());
            this.etO.setFillAfter(true);
        }
        return this.etO;
    }

    public boolean getIndicateStatus() {
        return this.etU;
    }

    public void clearStatus() {
        if (this.etQ != null) {
            this.etQ.cancel();
            this.etQ = null;
        }
        if (this.etR != null) {
            this.etR.cancel();
            this.etR = null;
        }
        if (this.etS != null) {
            this.etS.cancel();
            this.etS = null;
        }
        if (this.etP != null) {
            this.etP.dismiss();
            this.etP = null;
        }
    }
}
