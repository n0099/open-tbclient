package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.TextSizeSeekBar;
/* loaded from: classes4.dex */
public class aa extends com.baidu.adp.base.c<PbActivity> {
    private TextView brb;
    private final float hUb;
    private TextView hUc;
    private TextView hUd;
    private TextView hUe;
    private TextView hUf;
    private TextView hUg;
    private TextView hUh;
    private TextView hUi;
    private TextView hUj;
    private TextView hUk;
    private TextView hUl;
    private TextView hUm;
    private PbActivity hUn;
    private FlowLayout hUo;
    private LinearLayout hUp;
    private TextSizeSeekBar hUq;
    public boolean hUr;
    public boolean hUs;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.hUb = 0.5f;
        this.mView = null;
        this.hUc = null;
        this.hUk = null;
        this.hUn = null;
        this.mClickListener = null;
        this.hUn = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bXx() {
        return this.hUc;
    }

    public TextView bXy() {
        return this.hUk;
    }

    public TextView getCancelView() {
        return this.brb;
    }

    public TextView bXz() {
        return this.hUm;
    }

    public TextView bXA() {
        return this.hUg;
    }

    public TextView bXB() {
        return this.hUe;
    }

    public TextView bXC() {
        return this.hUj;
    }

    public TextView bXD() {
        return this.hUd;
    }

    public TextView bXE() {
        return this.hUf;
    }

    public TextView bXF() {
        return this.hUh;
    }

    public TextView bXG() {
        return this.hUi;
    }

    public TextView bXH() {
        return this.hUl;
    }

    public void release() {
    }

    public void oL(boolean z) {
        if (z) {
            this.hUk.setVisibility(0);
        } else {
            this.hUk.setVisibility(8);
        }
    }

    public void v(boolean z, String str) {
        if (z) {
            this.hUl.setVisibility(0);
            this.hUl.setText(str);
            return;
        }
        this.hUl.setVisibility(8);
    }

    public void W(boolean z, boolean z2) {
        this.hUm.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hUm.setText(R.string.group_info_intro_more);
        } else {
            this.hUm.setText(R.string.view_host);
        }
    }

    public void X(boolean z, boolean z2) {
        this.hUg.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hUg.setText(R.string.cancel_top);
        } else {
            this.hUg.setText(R.string.top);
        }
    }

    public void Y(boolean z, boolean z2) {
        this.hUj.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hUj.setText(R.string.cancel_good);
        } else {
            this.hUj.setText(R.string.commit_good);
        }
    }

    public void oM(boolean z) {
        this.hUe.setVisibility(z ? 0 : 8);
    }

    public void oN(boolean z) {
        this.hUd.setVisibility(z ? 0 : 8);
    }

    public void oO(boolean z) {
        this.hUf.setVisibility(z ? 0 : 8);
    }

    public void Z(boolean z, boolean z2) {
        this.hUh.setVisibility(z ? 0 : 8);
        this.hUs = z2;
        if (z2) {
            this.hUh.setText(R.string.view_reverse);
        } else {
            this.hUh.setText(R.string.default_sort);
        }
        this.hUh.setText(R.string.sort_selector);
    }

    public void aa(boolean z, boolean z2) {
        this.hUi.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hUi.setText(R.string.normal_mode);
        } else {
            this.hUi.setText(R.string.eyeshield_mode);
        }
    }

    public void oP(boolean z) {
        this.hUc.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.hUn.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.hUc = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.hUc.setOnClickListener(this.mClickListener);
        this.hUk = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.hUk.setOnClickListener(this.mClickListener);
        this.hUl = (TextView) this.mView.findViewById(R.id.pb_more_view_item_fans_call);
        this.hUl.setOnClickListener(this.mClickListener);
        this.hUd = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.hUd.setOnClickListener(this.mClickListener);
        this.hUe = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.hUe.setOnClickListener(this.mClickListener);
        this.hUf = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.hUf.setOnClickListener(this.mClickListener);
        this.hUh = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.hUh.setOnClickListener(this.mClickListener);
        this.hUi = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.hUi.setOnClickListener(this.mClickListener);
        this.hUg = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.hUg.setOnClickListener(this.mClickListener);
        this.hUj = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.hUj.setOnClickListener(this.mClickListener);
        this.hUm = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.hUm.setOnClickListener(this.mClickListener);
        this.hUo = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.hUq = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.hUp = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.brb = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.brb.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.am.l(this.hUo, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.k(this.hUp, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.am.k(this.brb, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.f(this.brb, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.am.f(this.hUc, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hUk, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hUl, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hUm, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hUd, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hUe, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hUg, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hUj, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hUf, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hUh, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.f(this.hUi, R.color.cp_cont_f, 1);
        this.hUo.setHorizontalSpacing(((((WindowManager) this.hUn.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds100) * 5)) / 4);
        this.hUc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.ajv().a(R.drawable.icon_pure_pb_recommend_jump_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hUk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.ajv().a(R.drawable.icon_pure_pb_recommend_report_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hUl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.call_fans_selector), (Drawable) null, (Drawable) null);
        this.hUd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.ajv().a(R.drawable.icon_pure_pb_recommend_initial_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hUe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.ajv().a(this.hUr ? R.drawable.icon_pure_pb_recommend_report_n_svg : R.drawable.icon_pure_pb_recommend_delete_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hUg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.ajv().a(R.drawable.icon_pure_pb_recommend_top_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hUj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.ajv().a(R.drawable.icon_pure_pb_recommend_best_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hUi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.ajv().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hUf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.ajv().a(R.drawable.icon_pure_pb_recommend_block_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hUh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.ajv().a(R.drawable.icon_pure_pb_recommend_sort_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hUm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.ajv().a(R.drawable.icon_pure_pb_recommend_host_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.hUq != null) {
            this.hUq.onChangeSkinType();
        }
    }
}
