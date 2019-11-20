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
    private TextView bIV;
    private final float hRS;
    private TextView hRT;
    private TextView hRU;
    private TextView hRV;
    private TextView hRW;
    private TextView hRX;
    private TextView hRY;
    private TextView hRZ;
    private TextView hSa;
    private TextView hSb;
    private TextView hSc;
    private TextView hSd;
    private PbActivity hSe;
    private FlowLayout hSf;
    private LinearLayout hSg;
    private TextSizeSeekBar hSh;
    public boolean hSi;
    public boolean hSj;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.hRS = 0.5f;
        this.mView = null;
        this.hRT = null;
        this.hSb = null;
        this.hSe = null;
        this.mClickListener = null;
        this.hSe = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView bUx() {
        return this.hRT;
    }

    public TextView bUy() {
        return this.hSb;
    }

    public TextView getCancelView() {
        return this.bIV;
    }

    public TextView bUz() {
        return this.hSd;
    }

    public TextView bUA() {
        return this.hRX;
    }

    public TextView bUB() {
        return this.hRV;
    }

    public TextView bUC() {
        return this.hSa;
    }

    public TextView bUD() {
        return this.hRU;
    }

    public TextView bUE() {
        return this.hRW;
    }

    public TextView bUF() {
        return this.hRY;
    }

    public TextView bUG() {
        return this.hRZ;
    }

    public TextView bUH() {
        return this.hSc;
    }

    public void release() {
    }

    public void ou(boolean z) {
        if (z) {
            this.hSb.setVisibility(0);
        } else {
            this.hSb.setVisibility(8);
        }
    }

    public void v(boolean z, String str) {
        if (z) {
            this.hSc.setVisibility(0);
            this.hSc.setText(str);
            return;
        }
        this.hSc.setVisibility(8);
    }

    public void Y(boolean z, boolean z2) {
        this.hSd.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hSd.setText(R.string.group_info_intro_more);
        } else {
            this.hSd.setText(R.string.view_host);
        }
    }

    public void Z(boolean z, boolean z2) {
        this.hRX.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hRX.setText(R.string.cancel_top);
        } else {
            this.hRX.setText(R.string.top);
        }
    }

    public void aa(boolean z, boolean z2) {
        this.hSa.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hSa.setText(R.string.cancel_good);
        } else {
            this.hSa.setText(R.string.commit_good);
        }
    }

    public void ov(boolean z) {
        this.hRV.setVisibility(z ? 0 : 8);
    }

    public void ow(boolean z) {
        this.hRU.setVisibility(z ? 0 : 8);
    }

    public void ox(boolean z) {
        this.hRW.setVisibility(z ? 0 : 8);
    }

    public void ab(boolean z, boolean z2) {
        this.hRY.setVisibility(z ? 0 : 8);
        this.hSj = z2;
        if (z2) {
            this.hRY.setText(R.string.view_reverse);
        } else {
            this.hRY.setText(R.string.default_sort);
        }
        this.hRY.setText(R.string.sort_selector);
    }

    public void ac(boolean z, boolean z2) {
        this.hRZ.setVisibility(z ? 0 : 8);
        if (z2) {
            this.hRZ.setText(R.string.normal_mode);
        } else {
            this.hRZ.setText(R.string.eyeshield_mode);
        }
    }

    public void oy(boolean z) {
        this.hRT.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.hSe.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
        this.hRT = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump);
        this.hRT.setOnClickListener(this.mClickListener);
        this.hSb = (TextView) this.mView.findViewById(R.id.pb_more_view_item_report);
        this.hSb.setOnClickListener(this.mClickListener);
        this.hSc = (TextView) this.mView.findViewById(R.id.pb_more_view_item_fans_call);
        this.hSc.setOnClickListener(this.mClickListener);
        this.hRU = (TextView) this.mView.findViewById(R.id.pb_more_view_item_jump_top);
        this.hRU.setOnClickListener(this.mClickListener);
        this.hRV = (TextView) this.mView.findViewById(R.id.pb_more_view_item_delete);
        this.hRV.setOnClickListener(this.mClickListener);
        this.hRW = (TextView) this.mView.findViewById(R.id.pb_more_view_item_forbidden);
        this.hRW.setOnClickListener(this.mClickListener);
        this.hRY = (TextView) this.mView.findViewById(R.id.pb_more_view_item_reversed);
        this.hRY.setOnClickListener(this.mClickListener);
        this.hRZ = (TextView) this.mView.findViewById(R.id.pb_more_view_item_night_style);
        this.hRZ.setOnClickListener(this.mClickListener);
        this.hRX = (TextView) this.mView.findViewById(R.id.pb_more_view_item_make_top);
        this.hRX.setOnClickListener(this.mClickListener);
        this.hSa = (TextView) this.mView.findViewById(R.id.pb_more_view_item_add_good);
        this.hSa.setOnClickListener(this.mClickListener);
        this.hSd = (TextView) this.mView.findViewById(R.id.pb_more_view_item_host_only);
        this.hSd.setOnClickListener(this.mClickListener);
        this.hSf = (FlowLayout) this.mView.findViewById(R.id.pb_more_flowlayout);
        this.hSh = (TextSizeSeekBar) this.mView.findViewById(R.id.pb_more_text_size_seekbar);
        this.hSg = (LinearLayout) this.mView.findViewById(R.id.size_seek_bar_group);
        this.bIV = (TextView) this.mView.findViewById(R.id.pb_more_cancel);
        this.bIV.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.hSf, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.hSg, R.drawable.bg_pb_more_dialog);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.bIV, R.color.cp_bg_line_k);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.bIV, R.drawable.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hRT, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hSb, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hSc, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hSd, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hRU, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hRV, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hRX, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hSa, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hRW, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hRY, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.hRZ, R.color.cp_cont_f, 1);
        this.hSf.setHorizontalSpacing(((((WindowManager) this.hSe.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds100) * 5)) / 4);
        this.hRT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.amL().a(R.drawable.icon_pure_pb_recommend_jump_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hSb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.amL().a(R.drawable.icon_pure_pb_recommend_report_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hSc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.am.getDrawable(R.drawable.call_fans_selector), (Drawable) null, (Drawable) null);
        this.hRU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.amL().a(R.drawable.icon_pure_pb_recommend_initial_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hRV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.amL().a(this.hSi ? R.drawable.icon_pure_pb_recommend_report_n_svg : R.drawable.icon_pure_pb_recommend_delete_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hRX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.amL().a(R.drawable.icon_pure_pb_recommend_top_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hSa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.amL().a(R.drawable.icon_pure_pb_recommend_best_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hRZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.amL().a(R.drawable.icon_pure_pb_recommend_night_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hRW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.amL().a(R.drawable.icon_pure_pb_recommend_block_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hRY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.amL().a(R.drawable.icon_pure_pb_recommend_sort_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        this.hSd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SvgManager.amL().a(R.drawable.icon_pure_pb_recommend_host_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS), (Drawable) null, (Drawable) null);
        if (this.hSh != null) {
            this.hSh.onChangeSkinType();
        }
    }
}
