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
    private TextView bJM;
    private final float hSJ;
    private TextView hSK;
    private TextView hSL;
    private TextView hSM;
    private TextView hSN;
    private TextView hSO;
    private TextView hSP;
    private TextView hSQ;
    private TextView hSR;
    private TextView hSS;
    private TextView hST;
    private TextView hSU;
    private PbActivity hSV;
    private FlowLayout hSW;
    private LinearLayout hSX;
    private TextSizeSeekBar hSY;
    public boolean hSZ;
    public boolean hTa;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.hSJ = 0.5f;
        this.mView = null;
        this.hSK = null;
        this.hSS = null;
        this.hSV = null;
        this.mClickListener = null;
        this.hSV = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bUz() {
        return this.hSK;
    }

    public TextView bUA() {
        return this.hSS;
    }

    public TextView getCancelView() {
        return this.bJM;
    }

    public TextView bUB() {
        return this.hSU;
    }

    public TextView bUC() {
        return this.hSO;
    }

    public TextView bUD() {
        return this.hSM;
    }

    public TextView bUE() {
        return this.hSR;
    }

    public TextView bUF() {
        return this.hSL;
    }

    public TextView bUG() {
        return this.hSN;
    }

    public TextView bUH() {
        return this.hSP;
    }

    public TextView bUI() {
        return this.hSQ;
    }

    public TextView bUJ() {
        return this.hST;
    }

    public void release() {
    }

    public void ou(boolean z) {
        if (z) {
            this.hSS.setVisibility(0);
        } else {
            this.hSS.setVisibility(8);
        }
    }

    public void v(boolean z, String str) {
        if (z) {
            this.hST.setVisibility(0);
            this.hST.setText(str);
            return;
        }
        this.hST.setVisibility(8);
    }

    public void Y(boolean z, boolean z2) {
        this.hSU.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hSU.setText(R.string.group_info_intro_more);
        } else {
            this.hSU.setText(R.string.view_host);
        }
    }

    public void Z(boolean z, boolean z2) {
        this.hSO.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hSO.setText(R.string.cancel_top);
        } else {
            this.hSO.setText(R.string.top);
        }
    }

    public void aa(boolean z, boolean z2) {
        this.hSR.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hSR.setText(R.string.cancel_good);
        } else {
            this.hSR.setText(R.string.commit_good);
        }
    }

    public void ov(boolean z) {
        this.hSM.setVisibility(z ? 0 : 8);
    }

    public void ow(boolean z) {
        this.hSL.setVisibility(z ? 0 : 8);
    }

    public void ox(boolean z) {
        this.hSN.setVisibility(z ? 0 : 8);
    }

    public void ab(boolean z, boolean z2) {
        this.hSP.setVisibility(z ? 0 : 8);
        this.hTa = z2;
        if (z2) {
            this.hSP.setText(R.string.view_reverse);
        } else {
            this.hSP.setText(R.string.default_sort);
        }
        this.hSP.setText(R.string.sort_selector);
    }

    public void ac(boolean z, boolean z2) {
        this.hSQ.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hSQ.setText(R.string.normal_mode);
        } else {
            this.hSQ.setText(R.string.eyeshield_mode);
        }
    }

    public void oy(boolean z) {
        this.hSK.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.hSV.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.hSK = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.hSK.setOnClickListener(this.mClickListener);
        this.hSS = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.hSS.setOnClickListener(this.mClickListener);
        this.hST = (TextView) this.mView.findViewById(R.id.pb_more_view_item_fans_call);
        this.hST.setOnClickListener(this.mClickListener);
        this.hSL = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.hSL.setOnClickListener(this.mClickListener);
        this.hSM = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.hSM.setOnClickListener(this.mClickListener);
        this.hSN = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.hSN.setOnClickListener(this.mClickListener);
        this.hSP = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.hSP.setOnClickListener(this.mClickListener);
        this.hSQ = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.hSQ.setOnClickListener(this.mClickListener);
        this.hSO = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.hSO.setOnClickListener(this.mClickListener);
        this.hSR = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.hSR.setOnClickListener(this.mClickListener);
        this.hSU = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.hSU.setOnClickListener(this.mClickListener);
        this.hSW = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.hSY = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.hSX = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.bJM = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.bJM.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.hSW, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.hSX, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.bJM, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.bJM, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hSK, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hSS, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hST, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hSU, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hSL, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hSM, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hSO, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hSR, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hSN, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hSP, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hSQ, R.color.cp_cont_f, 1);
        this.hSW.setHorizontalSpacing(((((WindowManager) this.hSV.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds100) * 5)) / 4);
        this.hSK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.amN().a(R.drawable.icon_pure_pb_recommend_jump_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hSS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.amN().a(R.drawable.icon_pure_pb_recommend_report_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hST.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.call_fans_selector), (Drawable) null, (Drawable) null);
        this.hSL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.amN().a(R.drawable.icon_pure_pb_recommend_initial_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hSM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.amN().a(this.hSZ ? R.drawable.icon_pure_pb_recommend_report_n_svg : R.drawable.icon_pure_pb_recommend_delete_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hSO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.amN().a(R.drawable.icon_pure_pb_recommend_top_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hSR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.amN().a(R.drawable.icon_pure_pb_recommend_best_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hSQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.amN().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hSN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.amN().a(R.drawable.icon_pure_pb_recommend_block_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hSP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.amN().a(R.drawable.icon_pure_pb_recommend_sort_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hSU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.amN().a(R.drawable.icon_pure_pb_recommend_host_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.hSY != null) {
            this.hSY.onChangeSkinType();
        }
    }
}
