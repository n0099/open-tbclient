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
    private Runnable bxG;
    private TextView deJ;
    private TextView fRA;
    private TextView fRB;
    private TextView fRC;
    private TextView fRD;
    private PbActivity fRE;
    private View fRF;
    private FlowLayout fRG;
    private LinearLayout fRH;
    private TextSizeSeekBar fRI;
    public boolean fRJ;
    public boolean fRK;
    private TextView fRh;
    private TextView fRt;
    private TextView fRu;
    private TextView fRv;
    private TextView fRw;
    private TextView fRx;
    private TextView fRy;
    private TextView fRz;
    private View.OnClickListener mClickListener;
    private View mView;

    public z(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.fRh = null;
        this.fRt = null;
        this.fRB = null;
        this.fRE = null;
        this.mClickListener = null;
        this.fRE = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bdY() {
        return this.fRh;
    }

    public TextView beg() {
        return this.fRt;
    }

    public TextView beh() {
        return this.fRB;
    }

    public TextView getCancelView() {
        return this.deJ;
    }

    public View bei() {
        return this.fRF;
    }

    public TextView bej() {
        return this.fRD;
    }

    public TextView bek() {
        return this.fRx;
    }

    public TextView bel() {
        return this.fRv;
    }

    public TextView bem() {
        return this.fRA;
    }

    public TextView ben() {
        return this.fRu;
    }

    public TextView beo() {
        return this.fRw;
    }

    public TextView bep() {
        return this.fRy;
    }

    public TextView beq() {
        return this.fRz;
    }

    public TextView ber() {
        return this.fRC;
    }

    public void bes() {
        if (this.bxG == null) {
            this.bxG = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.z.1
                @Override // java.lang.Runnable
                public void run() {
                    z.this.fRF.setBackgroundColor(z.this.fRE.getResources().getColor(d.C0140d.common_color_10082));
                }
            };
        }
        this.fRF.postDelayed(this.bxG, 200L);
    }

    public void bet() {
        this.fRF.setBackgroundColor(this.fRE.getResources().getColor(d.C0140d.common_color_10022));
    }

    public void release() {
        this.fRF.removeCallbacks(this.bxG);
    }

    public void ks(boolean z) {
        if (z) {
            this.fRB.setVisibility(0);
        } else {
            this.fRB.setVisibility(8);
        }
    }

    public void k(boolean z, String str) {
        if (z) {
            this.fRC.setVisibility(0);
            this.fRC.setText(str);
            return;
        }
        this.fRC.setVisibility(8);
    }

    public void kt(boolean z) {
        this.fRh.setVisibility(z ? 0 : 8);
    }

    public void K(boolean z, boolean z2) {
        this.fRD.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fRD.setText(d.j.group_info_intro_more);
        } else {
            this.fRD.setText(d.j.view_host);
        }
    }

    public void L(boolean z, boolean z2) {
        this.fRx.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fRx.setText(d.j.cancel_top);
        } else {
            this.fRx.setText(d.j.top);
        }
    }

    public void M(boolean z, boolean z2) {
        this.fRA.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fRA.setText(d.j.cancel_good);
        } else {
            this.fRA.setText(d.j.commit_good);
        }
    }

    public void ku(boolean z) {
        this.fRv.setVisibility(z ? 0 : 8);
    }

    public void kv(boolean z) {
        this.fRu.setVisibility(z ? 0 : 8);
    }

    public void kw(boolean z) {
        this.fRw.setVisibility(z ? 0 : 8);
    }

    public void N(boolean z, boolean z2) {
        this.fRy.setVisibility(z ? 0 : 8);
        this.fRK = z2;
        if (z2) {
            this.fRy.setText(d.j.view_reverse);
        } else {
            this.fRy.setText(d.j.default_sort);
        }
    }

    public void O(boolean z, boolean z2) {
        this.fRz.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fRz.setText(d.j.normal_mode);
        } else {
            this.fRz.setText(d.j.eyeshield_mode);
        }
    }

    public void kx(boolean z) {
        this.fRt.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fRE.getPageContext().getPageActivity()).inflate(d.h.pb_more_pop_view, (ViewGroup) null);
        this.fRh = (TextView) this.mView.findViewById(d.g.pb_more_view_item_mark);
        this.fRh.setOnClickListener(this.mClickListener);
        this.fRt = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.fRt.setOnClickListener(this.mClickListener);
        this.fRB = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.fRB.setOnClickListener(this.mClickListener);
        this.fRC = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.fRC.setOnClickListener(this.mClickListener);
        this.fRu = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.fRu.setOnClickListener(this.mClickListener);
        this.fRv = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.fRv.setOnClickListener(this.mClickListener);
        this.fRw = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.fRw.setOnClickListener(this.mClickListener);
        this.fRy = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.fRy.setOnClickListener(this.mClickListener);
        this.fRz = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.fRz.setOnClickListener(this.mClickListener);
        this.fRx = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.fRx.setOnClickListener(this.mClickListener);
        this.fRA = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.fRA.setOnClickListener(this.mClickListener);
        this.fRD = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.fRD.setOnClickListener(this.mClickListener);
        this.fRF = this.mView.findViewById(d.g.pb_more_layer);
        this.fRG = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.fRI = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.fRH = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.deJ = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.deJ.setOnClickListener(this.mClickListener);
        this.fRF.setOnClickListener(this.mClickListener);
    }

    public void amI() {
        com.baidu.tbadk.core.util.aj.t(this.fRG, d.C0140d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.t(this.fRH, d.C0140d.cp_bg_line_e);
        com.baidu.tbadk.core.util.aj.s(this.deJ, d.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.aj.e(this.deJ, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRh, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRt, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRB, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRC, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRD, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRu, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRv, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRx, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRA, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRw, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRy, d.C0140d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.aj.e(this.fRz, d.C0140d.cp_cont_f, 1);
        this.fRG.setHorizontalSpacing(((((WindowManager) this.fRE.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.fRh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.fRt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.fRB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.fRC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.fRu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.fRJ) {
            this.fRv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fRv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.fRx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.fRA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.fRw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.fRz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        if (this.fRK) {
            this.fRy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fRy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        }
        this.fRD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aj.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.fRI != null) {
            this.fRI.onChangeSkinType();
        }
    }
}
