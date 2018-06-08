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
    private Runnable aQr;
    private TextView cFZ;
    private TextView fxK;
    private TextView fxW;
    private TextView fxX;
    private TextView fxY;
    private TextView fxZ;
    private TextView fya;
    private TextView fyb;
    private TextView fyc;
    private TextView fyd;
    private TextView fye;
    private TextView fyf;
    private TextView fyg;
    private PbActivity fyh;
    private View fyi;
    private FlowLayout fyj;
    private LinearLayout fyk;
    private TextSizeSeekBar fyl;
    public boolean fym;
    public boolean fyn;
    private View.OnClickListener mClickListener;
    private View mView;

    public z(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.fxK = null;
        this.fxW = null;
        this.fye = null;
        this.fyh = null;
        this.mClickListener = null;
        this.fyh = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bdT() {
        return this.fxK;
    }

    public TextView beb() {
        return this.fxW;
    }

    public TextView bec() {
        return this.fye;
    }

    public TextView getCancelView() {
        return this.cFZ;
    }

    public View bed() {
        return this.fyi;
    }

    public TextView bee() {
        return this.fyg;
    }

    public TextView bef() {
        return this.fya;
    }

    public TextView beg() {
        return this.fxY;
    }

    public TextView beh() {
        return this.fyd;
    }

    public TextView bei() {
        return this.fxX;
    }

    public TextView bej() {
        return this.fxZ;
    }

    public TextView bek() {
        return this.fyb;
    }

    public TextView bel() {
        return this.fyc;
    }

    public TextView bem() {
        return this.fyf;
    }

    public void ben() {
        if (this.aQr == null) {
            this.aQr = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.z.1
                @Override // java.lang.Runnable
                public void run() {
                    z.this.fyi.setBackgroundColor(z.this.fyh.getResources().getColor(d.C0141d.common_color_10082));
                }
            };
        }
        this.fyi.postDelayed(this.aQr, 200L);
    }

    public void beo() {
        this.fyi.setBackgroundColor(this.fyh.getResources().getColor(d.C0141d.common_color_10022));
    }

    public void release() {
        this.fyi.removeCallbacks(this.aQr);
    }

    public void ka(boolean z) {
        if (z) {
            this.fye.setVisibility(0);
        } else {
            this.fye.setVisibility(8);
        }
    }

    public void n(boolean z, String str) {
        if (z) {
            this.fyf.setVisibility(0);
            this.fyf.setText(str);
            return;
        }
        this.fyf.setVisibility(8);
    }

    public void kb(boolean z) {
        this.fxK.setVisibility(z ? 0 : 8);
    }

    public void F(boolean z, boolean z2) {
        this.fyg.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fyg.setText(d.k.group_info_intro_more);
        } else {
            this.fyg.setText(d.k.view_host);
        }
    }

    public void G(boolean z, boolean z2) {
        this.fya.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fya.setText(d.k.cancel_top);
        } else {
            this.fya.setText(d.k.top);
        }
    }

    public void H(boolean z, boolean z2) {
        this.fyd.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fyd.setText(d.k.cancel_good);
        } else {
            this.fyd.setText(d.k.commit_good);
        }
    }

    public void kc(boolean z) {
        this.fxY.setVisibility(z ? 0 : 8);
    }

    public void kd(boolean z) {
        this.fxX.setVisibility(z ? 0 : 8);
    }

    public void ke(boolean z) {
        this.fxZ.setVisibility(z ? 0 : 8);
    }

    public void I(boolean z, boolean z2) {
        this.fyb.setVisibility(z ? 0 : 8);
        this.fyn = z2;
        if (z2) {
            this.fyb.setText(d.k.view_reverse);
        } else {
            this.fyb.setText(d.k.default_sort);
        }
    }

    public void J(boolean z, boolean z2) {
        this.fyc.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fyc.setText(d.k.normal_mode);
        } else {
            this.fyc.setText(d.k.eyeshield_mode);
        }
    }

    public void kf(boolean z) {
        this.fxW.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fyh.getPageContext().getPageActivity()).inflate(d.i.pb_more_pop_view, (ViewGroup) null);
        this.fxK = (TextView) this.mView.findViewById(d.g.pb_more_view_item_mark);
        this.fxK.setOnClickListener(this.mClickListener);
        this.fxW = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.fxW.setOnClickListener(this.mClickListener);
        this.fye = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.fye.setOnClickListener(this.mClickListener);
        this.fyf = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.fyf.setOnClickListener(this.mClickListener);
        this.fxX = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.fxX.setOnClickListener(this.mClickListener);
        this.fxY = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.fxY.setOnClickListener(this.mClickListener);
        this.fxZ = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.fxZ.setOnClickListener(this.mClickListener);
        this.fyb = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.fyb.setOnClickListener(this.mClickListener);
        this.fyc = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.fyc.setOnClickListener(this.mClickListener);
        this.fya = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.fya.setOnClickListener(this.mClickListener);
        this.fyd = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.fyd.setOnClickListener(this.mClickListener);
        this.fyg = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.fyg.setOnClickListener(this.mClickListener);
        this.fyi = this.mView.findViewById(d.g.pb_more_layer);
        this.fyj = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.fyl = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.fyk = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.cFZ = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.cFZ.setOnClickListener(this.mClickListener);
        this.fyi.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.al.j(this.fyj, d.C0141d.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.j(this.fyk, d.C0141d.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.i(this.cFZ, d.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.al.c(this.cFZ, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.al.c(this.fxK, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fxW, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fye, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fyf, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fyg, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fxX, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fxY, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fya, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fyd, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fxZ, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fyb, d.C0141d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.fyc, d.C0141d.cp_cont_f, 1);
        this.fyj.setHorizontalSpacing(((((WindowManager) this.fyh.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.fxK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.fxW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.fye.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.fyf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.fxX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.fym) {
            this.fxY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fxY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.fya.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.fyd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.fxZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.fyc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        if (this.fyn) {
            this.fyb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fyb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        }
        this.fyg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.fyl != null) {
            this.fyl.onChangeSkinType();
        }
    }
}
