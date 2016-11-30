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
public class ds extends com.baidu.adp.base.f<PbActivity> {
    private Runnable CI;
    private View.OnClickListener aNB;
    private PbActivity erE;
    private TextView exU;
    private TextView eyd;
    private TextView eye;
    private TextView eyf;
    private TextView eyg;
    private TextView eyh;
    private TextView eyi;
    private TextView eyj;
    private TextView eyk;
    private TextView eyl;
    private TextView eyn;
    private TextView eyo;
    public TextView eyp;
    private ViewGroup eyq;
    private TextView eyr;
    private ImageView eys;
    private View eyt;
    private FlowLayout eyu;
    private LinearLayout eyv;
    private TextView eyw;
    private View eyx;
    private View mView;

    public ds(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.exU = null;
        this.eyd = null;
        this.eye = null;
        this.eyn = null;
        this.eyo = null;
        this.eyr = null;
        this.erE = null;
        this.aNB = null;
        this.erE = pbActivity;
        this.aNB = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aQN() {
        return this.exU;
    }

    public TextView aQX() {
        return this.eyd;
    }

    public TextView aQY() {
        return this.eye;
    }

    public TextView aQZ() {
        return this.eyo;
    }

    public TextView aRa() {
        return this.eyn;
    }

    public TextView aRb() {
        return this.eyr;
    }

    public TextView aRc() {
        return this.eyw;
    }

    public View aRd() {
        return this.eyt;
    }

    public TextView aRe() {
        return this.eyf;
    }

    public TextView aRf() {
        return this.eyg;
    }

    public TextView aRg() {
        return this.eyk;
    }

    public TextView aRh() {
        return this.eyi;
    }

    public TextView aRi() {
        return this.eyl;
    }

    public TextView aRj() {
        return this.eyh;
    }

    public TextView aRk() {
        return this.eyj;
    }

    public void aRl() {
        if (this.CI == null) {
            this.CI = new dt(this);
        }
        this.eyt.postDelayed(this.CI, 200L);
    }

    public void aRm() {
        this.eyt.setBackgroundColor(this.erE.getResources().getColor(r.d.common_color_10022));
    }

    public void release() {
        this.eyt.removeCallbacks(this.CI);
    }

    public void iD(boolean z) {
        if (z) {
            this.eyo.setVisibility(0);
        } else {
            this.eyo.setVisibility(8);
        }
    }

    public void iE(boolean z) {
        if (z) {
            this.eyp.setVisibility(0);
        } else {
            this.eyp.setVisibility(8);
        }
    }

    public void iF(boolean z) {
        if (z) {
            this.eyn.setVisibility(0);
        } else {
            this.eyn.setVisibility(8);
        }
    }

    public void iG(boolean z) {
        this.eyq.setVisibility(z ? 0 : 8);
    }

    public void iH(boolean z) {
        this.eyf.setVisibility(z ? 0 : 8);
    }

    public void iI(boolean z) {
        this.exU.setVisibility(z ? 0 : 8);
    }

    public void iJ(boolean z) {
        this.eyg.setVisibility(z ? 0 : 8);
    }

    public void x(boolean z, boolean z2) {
        this.eyk.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eyk.setText(r.j.cancel_top);
        } else {
            this.eyk.setText(r.j.top);
        }
    }

    public void y(boolean z, boolean z2) {
        this.eyl.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eyl.setText(r.j.cancel_good);
        } else {
            this.eyl.setText(r.j.commit_good);
        }
    }

    public void iK(boolean z) {
        this.eyi.setVisibility(z ? 0 : 8);
    }

    public void iL(boolean z) {
        this.eyh.setVisibility(z ? 0 : 8);
    }

    public void iM(boolean z) {
        this.eyj.setVisibility(z ? 0 : 8);
    }

    public void aRn() {
        this.eys.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.um().putBoolean("pb_god_call_tips_shown", false);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.erE.getPageContext().getPageActivity()).inflate(r.h.pb_more_pop_view, (ViewGroup) null);
        this.exU = (TextView) this.mView.findViewById(r.g.pb_more_view_item_mark);
        this.exU.setOnClickListener(this.aNB);
        this.eyd = (TextView) this.mView.findViewById(r.g.pb_more_view_item_jump);
        this.eyd.setOnClickListener(this.aNB);
        this.eye = (TextView) this.mView.findViewById(r.g.pb_more_view_item_see);
        this.eye.setOnClickListener(this.aNB);
        this.eyo = (TextView) this.mView.findViewById(r.g.pb_more_view_item_report);
        this.eyo.setOnClickListener(this.aNB);
        this.eyp = (TextView) this.mView.findViewById(r.g.pb_more_view_item_report_ecomm);
        this.eyp.setOnClickListener(this.aNB);
        this.eyn = (TextView) this.mView.findViewById(r.g.pb_more_view_item_upgrade_thread);
        this.eyn.setOnClickListener(this.aNB);
        this.eyf = (TextView) this.mView.findViewById(r.g.pb_more_view_item_read_post);
        this.eyf.setOnClickListener(this.aNB);
        this.eyg = (TextView) this.mView.findViewById(r.g.pb_more_view_item_share);
        this.eyg.setOnClickListener(this.aNB);
        this.eyh = (TextView) this.mView.findViewById(r.g.pb_more_view_item_jump_top);
        this.eyh.setOnClickListener(this.aNB);
        this.eyi = (TextView) this.mView.findViewById(r.g.pb_more_view_item_delete);
        this.eyi.setOnClickListener(this.aNB);
        this.eyj = (TextView) this.mView.findViewById(r.g.pb_more_view_item_forbidden);
        this.eyj.setOnClickListener(this.aNB);
        this.eyk = (TextView) this.mView.findViewById(r.g.pb_more_view_item_make_top);
        this.eyk.setOnClickListener(this.aNB);
        this.eyl = (TextView) this.mView.findViewById(r.g.pb_more_view_item_add_good);
        this.eyl.setOnClickListener(this.aNB);
        this.eyq = (ViewGroup) this.mView.findViewById(r.g.pb_more_view_item_god_call_layout);
        this.eyr = (TextView) this.mView.findViewById(r.g.pb_more_view_item_god_call);
        this.eys = (ImageView) this.mView.findViewById(r.g.pb_more_view_item_god_call_tip);
        this.eyr.setOnClickListener(this.aNB);
        this.eys.setVisibility(com.baidu.tbadk.core.sharedPref.b.um().getBoolean("pb_god_call_tips_shown", true) ? 0 : 8);
        this.eyt = this.mView.findViewById(r.g.pb_more_layer);
        this.eyu = (FlowLayout) this.mView.findViewById(r.g.pb_more_flowlayout);
        this.eyv = (LinearLayout) this.mView.findViewById(r.g.size_seek_bar_group);
        this.eyx = this.mView.findViewById(r.g.pb_more_seekbar_line);
        this.eyw = (TextView) this.mView.findViewById(r.g.pb_more_cancel);
        this.eyw.setOnClickListener(this.aNB);
        this.eyt.setOnClickListener(this.aNB);
    }

    public void aRo() {
        com.baidu.tbadk.core.util.at.l(this.eyu, r.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.at.l(this.eyv, r.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.at.l(this.eyx, r.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.at.k(this.eyw, r.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.at.c(this.eyw, r.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.at.c(this.exU, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.at.c(this.eyd, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.at.c(this.eye, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.at.c(this.eyo, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.at.c(this.eyp, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.at.c(this.eyn, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.at.c(this.eyr, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.at.c(this.eyf, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.at.c(this.eyg, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.at.c(this.eyh, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.at.c(this.eyi, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.at.c(this.eyk, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.at.c(this.eyl, r.d.cp_cont_j, 1);
        com.baidu.tbadk.core.util.at.c(this.eyj, r.d.cp_cont_j, 1);
        this.eyu.setHorizontalSpacing(((((WindowManager) this.erE.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.e.ds64)) - (TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.e.ds100) * 5)) / 4);
        this.exU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.eyd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.eye.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
        this.eyo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.eyp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.eyn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_recommend_shengji_selector), (Drawable) null, (Drawable) null);
        this.eyr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(r.f.pb_more_god_call_selector), (Drawable) null, (Drawable) null);
        this.eys.setImageDrawable(com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_chat_dot));
        this.eyf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_recommend_readthread_selector), (Drawable) null, (Drawable) null);
        this.eyg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_recommend_share_selector), (Drawable) null, (Drawable) null);
        this.eyh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        this.eyi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        this.eyk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.eyl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.eyj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
    }
}
