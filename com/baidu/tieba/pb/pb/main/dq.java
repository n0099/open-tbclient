package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class dq extends com.baidu.adp.base.f<PbActivity> {
    private Runnable CI;
    private View.OnClickListener ahN;
    private PbActivity elH;
    private TextView esa;
    private TextView esi;
    private TextView esj;
    private TextView esk;
    private TextView esl;
    public TextView esm;
    private ViewGroup esn;
    private TextView eso;
    private ImageView esp;
    private View esq;
    private FlowLayout esr;
    private LinearLayout ess;
    private TextView est;
    private View esu;
    private View mView;

    public dq(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.esa = null;
        this.esi = null;
        this.esj = null;
        this.esk = null;
        this.esl = null;
        this.eso = null;
        this.elH = null;
        this.ahN = null;
        this.elH = pbActivity;
        this.ahN = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aOU() {
        return this.esa;
    }

    public TextView aPd() {
        return this.esi;
    }

    public TextView aPe() {
        return this.esj;
    }

    public TextView aPf() {
        return this.esl;
    }

    public TextView aPg() {
        return this.esk;
    }

    public TextView aPh() {
        return this.eso;
    }

    public TextView aPi() {
        return this.est;
    }

    public View aPj() {
        return this.esq;
    }

    public void aPk() {
        if (this.CI == null) {
            this.CI = new dr(this);
        }
        this.esq.postDelayed(this.CI, 200L);
    }

    public void aPl() {
        this.esq.setBackgroundColor(this.elH.getResources().getColor(r.d.common_color_10022));
    }

    public void release() {
        this.esq.removeCallbacks(this.CI);
    }

    public void il(boolean z) {
        if (z) {
            this.esl.setVisibility(8);
        } else {
            this.esl.setVisibility(0);
        }
    }

    public void im(boolean z) {
        if (z) {
            this.esm.setVisibility(8);
        } else {
            this.esm.setVisibility(0);
        }
    }

    public void in(boolean z) {
        if (z) {
            this.esk.setVisibility(8);
        } else {
            this.esk.setVisibility(0);
        }
    }

    public void io(boolean z) {
        this.esn.setVisibility(z ? 0 : 8);
    }

    public void aPm() {
        this.esp.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("pb_god_call_tips_shown", false);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.elH.getPageContext().getPageActivity()).inflate(r.h.pb_more_pop_view, (ViewGroup) null);
        this.esa = (TextView) this.mView.findViewById(r.g.pb_more_view_item_mark);
        this.esa.setOnClickListener(this.ahN);
        this.esi = (TextView) this.mView.findViewById(r.g.pb_more_view_item_jump);
        this.esi.setOnClickListener(this.ahN);
        this.esj = (TextView) this.mView.findViewById(r.g.pb_more_view_item_see);
        this.esj.setOnClickListener(this.ahN);
        this.esl = (TextView) this.mView.findViewById(r.g.pb_more_view_item_report);
        this.esl.setOnClickListener(this.ahN);
        this.esm = (TextView) this.mView.findViewById(r.g.pb_more_view_item_report_ecomm);
        this.esm.setOnClickListener(this.ahN);
        this.esk = (TextView) this.mView.findViewById(r.g.pb_more_view_item_upgrade_thread);
        this.esk.setOnClickListener(this.ahN);
        this.esn = (ViewGroup) this.mView.findViewById(r.g.pb_more_view_item_god_call_layout);
        this.eso = (TextView) this.mView.findViewById(r.g.pb_more_view_item_god_call);
        this.esp = (ImageView) this.mView.findViewById(r.g.pb_more_view_item_god_call_tip);
        this.eso.setOnClickListener(this.ahN);
        this.esp.setVisibility(com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("pb_god_call_tips_shown", true) ? 0 : 8);
        this.esq = this.mView.findViewById(r.g.pb_more_layer);
        this.esr = (FlowLayout) this.mView.findViewById(r.g.pb_more_flowlayout);
        this.ess = (LinearLayout) this.mView.findViewById(r.g.size_seek_bar_group);
        this.esu = this.mView.findViewById(r.g.pb_more_seekbar_line);
        this.est = (TextView) this.mView.findViewById(r.g.pb_more_cancel);
        this.est.setOnClickListener(this.ahN);
        this.esq.setOnClickListener(this.ahN);
    }

    public void aPn() {
        com.baidu.tbadk.core.util.av.l(this.esr, r.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.av.l(this.ess, r.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.av.l(this.esu, r.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.av.k(this.est, r.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.av.c(this.est, r.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.av.c(this.esa, r.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.esi, r.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.esj, r.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.esl, r.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.esm, r.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.esk, r.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.eso, r.d.cp_cont_c, 1);
        this.esr.setHorizontalSpacing(((((WindowManager) this.elH.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.e.ds80)) - (TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.e.ds130) * 4)) / 3);
        this.esa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(r.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.esi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(r.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.esj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(r.f.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
        this.esl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(r.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.esm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(r.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.esk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(r.f.icon_recommend_shengji_selector), (Drawable) null, (Drawable) null);
        this.eso.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(r.f.pb_more_god_call_selector), (Drawable) null, (Drawable) null);
        this.esp.setImageDrawable(com.baidu.tbadk.core.util.av.getDrawable(r.f.icon_chat_dot));
    }
}
