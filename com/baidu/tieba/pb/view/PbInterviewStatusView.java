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
    private String UX;
    private TextView eBV;
    private ImageView eBW;
    private FrameLayout eBX;
    private TextView eBY;
    private ImageView eBZ;
    private ImageView eCa;
    private View eCb;
    private Animation eCc;
    private com.baidu.tbadk.core.dialog.a eCd;
    private CountDownTimer eCe;
    private CountDownTimer eCf;
    private CountDownTimer eCg;
    private boolean eCh;
    private boolean eCi;
    private a eCj;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void p(boolean z);
    }

    public void setCallback(a aVar) {
        this.eCj = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.eCd = null;
        this.eCe = null;
        this.eCf = null;
        this.eCg = null;
        this.eCh = true;
        this.eCi = false;
        this.UX = null;
        this.eCj = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.eCd = null;
        this.eCe = null;
        this.eCf = null;
        this.eCg = null;
        this.eCh = true;
        this.eCi = false;
        this.UX = null;
        this.eCj = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.eCd = null;
        this.eCe = null;
        this.eCf = null;
        this.eCg = null;
        this.eCh = true;
        this.eCi = false;
        this.UX = null;
        this.eCj = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(w.j.pb_interview_status, (ViewGroup) this, true);
        this.eBV = (TextView) this.mRootView.findViewById(w.h.interview_live_status_btn);
        this.eBX = (FrameLayout) this.mRootView.findViewById(w.h.count_container);
        this.eBW = (ImageView) this.mRootView.findViewById(w.h.interview_mic);
        this.eCa = (ImageView) this.mRootView.findViewById(w.h.interview_arrow);
        this.eBY = (TextView) this.mRootView.findViewById(w.h.count_text);
        this.eBZ = (ImageView) this.mRootView.findViewById(w.h.count_bg);
        this.eCb = this.mRootView.findViewById(w.h.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        aq.k(this.mRootView, w.e.cp_link_tip_a);
        aq.i(this.eBV, w.e.cp_cont_g);
        aq.j(this.eBZ, w.g.icon_interview_loding);
        aq.i(this.eBY, w.e.cp_cont_g);
        aq.j(this.eBW, w.g.icon_interview_mic);
        aq.j(this.eCa, w.g.icon_arrow_tip_white);
        aq.k(this.eCb, w.e.cp_bg_line_c);
    }

    public void a(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.UX = fVar.aIB().rd().px();
        if (StringUtils.isNull(this.UX)) {
            this.UX = fVar.aIB().rd().getTaskId();
        }
        this.eCh = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aKf());
        b(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        int rW = fVar.aIB().rW();
        switch (rW) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aIB().rd().qW()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.eCe = new g(this, millis2, millis2, pbActivity, fVar).start();
                    this.mRootView.setVisibility(8);
                    if (this.eCj != null) {
                        this.eCj.p(false);
                    }
                } else {
                    TiebaStatic.log(new as("c11105").Z("obj_id", this.UX));
                    this.mRootView.setVisibility(0);
                    if (this.eCj != null) {
                        this.eCj.p(true);
                    }
                    this.eBV.setText(pbActivity.getPageContext().getPageActivity().getString(w.l.interview_live_before_start));
                    this.eBV.setTextSize(0, com.baidu.adp.lib.util.k.g(pbActivity.getPageContext().getPageActivity(), w.f.fontsize24));
                    this.eBW.setVisibility(8);
                    this.eCa.setVisibility(8);
                    this.eCb.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.eBZ, ah(pbActivity), (Animation.AnimationListener) null);
                    if (this.eCf != null) {
                        this.eCf.cancel();
                    }
                    this.eCf = new h(this, millis, TimeUnit.SECONDS.toMillis(1L), pbActivity).start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.eCj != null) {
                    this.eCj.p(true);
                }
                this.eBW.setVisibility(8);
                this.eCa.setVisibility(8);
                this.eBX.setVisibility(8);
                this.eCb.setVisibility(0);
                this.eBV.setTextSize(0, com.baidu.adp.lib.util.k.g(pbActivity.getPageContext().getPageActivity(), w.f.fontsize28));
                aq.k(this.mRootView, w.e.cp_bg_line_e);
                aq.i(this.eBV, w.e.cp_cont_f);
                aq.k(this.eCb, w.e.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (rW == 2) {
                    this.eBV.setText(pbActivity.getPageContext().getPageActivity().getString(w.l.interview_live_in_process));
                    if (this.eCh) {
                        ag(pbActivity);
                        return;
                    }
                    return;
                }
                this.eBV.setText(pbActivity.getPageContext().getPageActivity().getString(w.l.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    private void ag(PbActivity pbActivity) {
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
            this.eCd = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.eCd.v(inflate);
            this.eCd.a((String) null, (a.b) null);
            this.eCd.b(w.l.cancel, new i(this));
            this.eCd.ar(false);
            this.eCd.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.h.fS().postDelayed(new j(this), TimeUnit.MICROSECONDS.toMillis(200L));
            this.eCg = new k(this, TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L), textView, pbActivity).start();
        }
    }

    private Animation ah(PbActivity pbActivity) {
        if (this.eCc == null) {
            this.eCc = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), w.a.rotate_anim);
            this.eCc.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.eCc.setInterpolator(new LinearInterpolator());
            this.eCc.setFillAfter(true);
        }
        return this.eCc;
    }

    public boolean getIndicateStatus() {
        return this.eCi;
    }

    public void clearStatus() {
        if (this.eCe != null) {
            this.eCe.cancel();
            this.eCe = null;
        }
        if (this.eCf != null) {
            this.eCf.cancel();
            this.eCf = null;
        }
        if (this.eCg != null) {
            this.eCg.cancel();
            this.eCg = null;
        }
        if (this.eCd != null) {
            this.eCd.dismiss();
            this.eCd = null;
        }
    }
}
