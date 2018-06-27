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
public class aa extends com.baidu.adp.base.c<PbActivity> {
    private Runnable aRn;
    private TextView cDS;
    private TextView fBL;
    private TextView fBX;
    private TextView fBY;
    private TextView fBZ;
    private TextView fCa;
    private TextView fCb;
    private TextView fCc;
    private TextView fCd;
    private TextView fCe;
    private TextView fCf;
    private TextView fCg;
    private TextView fCh;
    private PbActivity fCi;
    private View fCj;
    private FlowLayout fCk;
    private LinearLayout fCl;
    private TextSizeSeekBar fCm;
    public boolean fCn;
    public boolean fCo;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.fBL = null;
        this.fBX = null;
        this.fCf = null;
        this.fCi = null;
        this.mClickListener = null;
        this.fCi = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView beB() {
        return this.fBL;
    }

    public TextView beJ() {
        return this.fBX;
    }

    public TextView beK() {
        return this.fCf;
    }

    public TextView getCancelView() {
        return this.cDS;
    }

    public View beL() {
        return this.fCj;
    }

    public TextView beM() {
        return this.fCh;
    }

    public TextView beN() {
        return this.fCb;
    }

    public TextView beO() {
        return this.fBZ;
    }

    public TextView beP() {
        return this.fCe;
    }

    public TextView beQ() {
        return this.fBY;
    }

    public TextView beR() {
        return this.fCa;
    }

    public TextView beS() {
        return this.fCc;
    }

    public TextView beT() {
        return this.fCd;
    }

    public TextView beU() {
        return this.fCg;
    }

    public void beV() {
        if (this.aRn == null) {
            this.aRn = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                @Override // java.lang.Runnable
                public void run() {
                    aa.this.fCj.setBackgroundColor(aa.this.fCi.getResources().getColor(d.C0142d.common_color_10082));
                }
            };
        }
        this.fCj.postDelayed(this.aRn, 200L);
    }

    public void beW() {
        this.fCj.setBackgroundColor(this.fCi.getResources().getColor(d.C0142d.common_color_10022));
    }

    public void release() {
        this.fCj.removeCallbacks(this.aRn);
    }

    public void kk(boolean z) {
        if (z) {
            this.fCf.setVisibility(0);
        } else {
            this.fCf.setVisibility(8);
        }
    }

    public void n(boolean z, String str) {
        if (z) {
            this.fCg.setVisibility(0);
            this.fCg.setText(str);
            return;
        }
        this.fCg.setVisibility(8);
    }

    public void kl(boolean z) {
        this.fBL.setVisibility(z ? 0 : 8);
    }

    public void I(boolean z, boolean z2) {
        this.fCh.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fCh.setText(d.k.group_info_intro_more);
        } else {
            this.fCh.setText(d.k.view_host);
        }
    }

    public void J(boolean z, boolean z2) {
        this.fCb.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fCb.setText(d.k.cancel_top);
        } else {
            this.fCb.setText(d.k.top);
        }
    }

    public void K(boolean z, boolean z2) {
        this.fCe.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fCe.setText(d.k.cancel_good);
        } else {
            this.fCe.setText(d.k.commit_good);
        }
    }

    public void km(boolean z) {
        this.fBZ.setVisibility(z ? 0 : 8);
    }

    public void kn(boolean z) {
        this.fBY.setVisibility(z ? 0 : 8);
    }

    public void ko(boolean z) {
        this.fCa.setVisibility(z ? 0 : 8);
    }

    public void L(boolean z, boolean z2) {
        this.fCc.setVisibility(z ? 0 : 8);
        this.fCo = z2;
        if (z2) {
            this.fCc.setText(d.k.view_reverse);
        } else {
            this.fCc.setText(d.k.default_sort);
        }
    }

    public void M(boolean z, boolean z2) {
        this.fCd.setVisibility(z ? 0 : 8);
        if (z2) {
            this.fCd.setText(d.k.normal_mode);
        } else {
            this.fCd.setText(d.k.eyeshield_mode);
        }
    }

    public void kp(boolean z) {
        this.fBX.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.fCi.getPageContext().getPageActivity()).inflate(d.i.pb_more_pop_view, (ViewGroup) null);
        this.fBL = (TextView) this.mView.findViewById(d.g.pb_more_view_item_mark);
        this.fBL.setOnClickListener(this.mClickListener);
        this.fBX = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump);
        this.fBX.setOnClickListener(this.mClickListener);
        this.fCf = (TextView) this.mView.findViewById(d.g.pb_more_view_item_report);
        this.fCf.setOnClickListener(this.mClickListener);
        this.fCg = (TextView) this.mView.findViewById(d.g.pb_more_view_item_fans_call);
        this.fCg.setOnClickListener(this.mClickListener);
        this.fBY = (TextView) this.mView.findViewById(d.g.pb_more_view_item_jump_top);
        this.fBY.setOnClickListener(this.mClickListener);
        this.fBZ = (TextView) this.mView.findViewById(d.g.pb_more_view_item_delete);
        this.fBZ.setOnClickListener(this.mClickListener);
        this.fCa = (TextView) this.mView.findViewById(d.g.pb_more_view_item_forbidden);
        this.fCa.setOnClickListener(this.mClickListener);
        this.fCc = (TextView) this.mView.findViewById(d.g.pb_more_view_item_reversed);
        this.fCc.setOnClickListener(this.mClickListener);
        this.fCd = (TextView) this.mView.findViewById(d.g.pb_more_view_item_night_style);
        this.fCd.setOnClickListener(this.mClickListener);
        this.fCb = (TextView) this.mView.findViewById(d.g.pb_more_view_item_make_top);
        this.fCb.setOnClickListener(this.mClickListener);
        this.fCe = (TextView) this.mView.findViewById(d.g.pb_more_view_item_add_good);
        this.fCe.setOnClickListener(this.mClickListener);
        this.fCh = (TextView) this.mView.findViewById(d.g.pb_more_view_item_host_only);
        this.fCh.setOnClickListener(this.mClickListener);
        this.fCj = this.mView.findViewById(d.g.pb_more_layer);
        this.fCk = (FlowLayout) this.mView.findViewById(d.g.pb_more_flowlayout);
        this.fCm = (TextSizeSeekBar) this.mView.findViewById(d.g.pb_more_text_size_seekbar);
        this.fCl = (LinearLayout) this.mView.findViewById(d.g.size_seek_bar_group);
        this.cDS = (TextView) this.mView.findViewById(d.g.pb_more_cancel);
        this.cDS.setOnClickListener(this.mClickListener);
        this.fCj.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.am.j(this.fCk, d.C0142d.cp_bg_line_e);
        com.baidu.tbadk.core.util.am.j(this.fCl, d.C0142d.cp_bg_line_e);
        com.baidu.tbadk.core.util.am.i(this.cDS, d.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.am.c(this.cDS, d.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.am.c(this.fBL, d.C0142d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fBX, d.C0142d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCf, d.C0142d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCg, d.C0142d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCh, d.C0142d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fBY, d.C0142d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fBZ, d.C0142d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCb, d.C0142d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCe, d.C0142d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCa, d.C0142d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCc, d.C0142d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.c(this.fCd, d.C0142d.cp_cont_f, 1);
        this.fCk.setHorizontalSpacing(((((WindowManager) this.fCi.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds100) * 5)) / 4);
        this.fBL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.fBX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.fCf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.fCg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.fBY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.fCn) {
            this.fBZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fBZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.fCb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.fCe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.fCa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.fCd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        if (this.fCo) {
            this.fCc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_reversed_down_selector), (Drawable) null, (Drawable) null);
        } else {
            this.fCc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        }
        this.fCh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(d.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.fCm != null) {
            this.fCm.onChangeSkinType();
        }
    }
}
