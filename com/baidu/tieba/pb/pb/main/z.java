package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.view.TextSizeSeekBar;
/* loaded from: classes2.dex */
public class z extends com.baidu.adp.base.c<PbActivity> {
    private Runnable bxt;
    private TextView dex;
    private TextView fQW;
    private TextView fRi;
    private TextView fRj;
    private TextView fRk;
    private TextView fRl;
    private TextView fRm;
    private TextView fRn;
    private TextView fRo;
    private TextView fRp;
    private TextView fRq;
    private TextView fRr;
    private TextView fRs;
    private PbActivity fRt;
    private View fRu;
    private FlowLayout fRv;
    private LinearLayout fRw;
    private TextSizeSeekBar fRx;
    public boolean fRy;
    public boolean fRz;
    private View.OnClickListener mClickListener;
    private View mView;

    public z(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.fQW = null;
        this.fRi = null;
        this.fRq = null;
        this.fRt = null;
        this.mClickListener = null;
        this.fRt = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bdX() {
        return this.fQW;
    }

    public TextView bef() {
        return this.fRi;
    }

    public TextView beg() {
        return this.fRq;
    }

    public TextView getCancelView() {
        return this.dex;
    }

    public View beh() {
        return this.fRu;
    }

    public TextView bei() {
        return this.fRs;
    }

    public TextView bej() {
        return this.fRm;
    }

    public TextView bek() {
        return this.fRk;
    }

    public TextView bel() {
        return this.fRp;
    }

    public TextView bem() {
        return this.fRj;
    }

    public TextView ben() {
        return this.fRl;
    }

    public TextView beo() {
        return this.fRn;
    }

    public TextView bep() {
        return this.fRo;
    }

    public TextView beq() {
        return this.fRr;
    }

    public void ber() {
        if (this.bxt == null) {
            this.bxt = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.z.1
                @Override // java.lang.Runnable
                public void run() {
                    z.this.fRu.setBackgroundColor(z.this.fRt.getResources().getColor(d.C0141d.common_color_10082));
                }
            };
        }
        this.fRu.postDelayed(this.bxt, 200L);
    }

    public void bes() {
        this.fRu.setBackgroundColor(this.fRt.getResources().getColor(d.C0141d.common_color_10022));
    }

    public void release() {
        this.fRu.removeCallbacks(this.bxt);
    }

    public void ks(boolean z) {
        if (z) {
            this.fRq.setVisibility(0);
        } else {
            this.fRq.setVisibility(8);
        }
    }

    public void k(boolean z, String str) {
        if (z) {
            this.fRr.setVisibility(0);
            this.fRr.setText(str);
            return;
        }
        this.fRr.setVisibility(8);
    }

    public void kt(boolean z) {
        this.fQW.setVisibility(z ? 0 : 8);
    }

    public void K(boolean z, boolean z2) {
        this.fRs.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fRs.setText(d.j.group_info_intro_more);
        } else {
            this.fRs.setText(d.j.view_host);
        }
    }

    public void L(boolean z, boolean z2) {
        this.fRm.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fRm.setText(d.j.cancel_top);
        } else {
            this.fRm.setText(d.j.top);
        }
    }

    public void M(boolean z, boolean z2) {
        this.fRp.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fRp.setText(d.j.cancel_good);
        } else {
            this.fRp.setText(d.j.commit_good);
        }
    }

    public void ku(boolean z) {
        this.fRk.setVisibility(z ? 0 : 8);
    }

    public void kv(boolean z) {
        this.fRj.setVisibility(z ? 0 : 8);
    }

    public void kw(boolean z) {
        this.fRl.setVisibility(z ? 0 : 8);
    }

    public void N(boolean z, boolean z2) {
        this.fRn.setVisibility(z ? 0 : 8);
        this.fRz = z2;
        if (z2) {
            this.fRn.setText(d.j.view_reverse);
        } else {
            this.fRn.setText(d.j.default_sort);
        }
    }

    public void O(boolean z, boolean z2) {
        this.fRo.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fRo.setText(d.j.normal_mode);
        } else {
            this.fRo.setText(d.j.eyeshield_mode);
        }
    }

    public void kx(boolean z) {
        this.fRi.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fRt.getPageContext().getPageActivity()).inflate(d.h.pb_more_pop_view, (ViewGroup) null);
        this.fQW = (TextView) this.mView.findViewById(d.g.pb_more_view_item_mark);
        this.fQW.setOnClickListener(this.mClickListener);
        this.fRi = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.fRi.setOnClickListener(this.mClickListener);
        this.fRq = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.fRq.setOnClickListener(this.mClickListener);
        this.fRr = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.fRr.setOnClickListener(this.mClickListener);
        this.fRj = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.fRj.setOnClickListener(this.mClickListener);
        this.fRk = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.fRk.setOnClickListener(this.mClickListener);
        this.fRl = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.fRl.setOnClickListener(this.mClickListener);
        this.fRn = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.fRn.setOnClickListener(this.mClickListener);
        this.fRo = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.fRo.setOnClickListener(this.mClickListener);
        this.fRm = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.fRm.setOnClickListener(this.mClickListener);
        this.fRp = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.fRp.setOnClickListener(this.mClickListener);
        this.fRs = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.fRs.setOnClickListener(this.mClickListener);
        this.fRu = this.mView.findViewById(d.g.pb_more_layer);
        this.fRv = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.fRx = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.fRw = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.dex = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.dex.setOnClickListener(this.mClickListener);
        this.fRu.setOnClickListener(this.mClickListener);
    }

    public void amH() {
        com.baidu.tbadk.core.util.aj.t(this.fRv, d.C0141d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.t(this.fRw, d.C0141d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.s(this.dex, d.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.aj.e(this.dex, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.aj.e(this.fQW, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRi, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRq, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRr, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRs, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRj, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRk, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRm, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRp, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRl, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRn, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRo, d.C0141d.cp_cont_f, 1);
        this.fRv.setHorizontalSpacing(((((WindowManager) this.fRt.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.fQW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.fRi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.fRq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.fRr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.fRj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.fRy) {
            this.fRk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fRk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.fRm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.fRp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.fRl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.fRo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        if (this.fRz) {
            this.fRn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fRn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        }
        this.fRs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.fRx != null) {
            this.fRx.onChangeSkinType();
        }
    }
}
