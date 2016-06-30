package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.view.FlowLayout;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class dp extends com.baidu.adp.base.f<PbActivity> {
    private View.OnClickListener aew;
    private PbActivity dLv;
    private TextView dRJ;
    private TextView dRR;
    private TextView dRS;
    private TextView dRT;
    private TextView dRU;
    public TextView dRV;
    private View dRW;
    private FlowLayout dRX;
    private LinearLayout dRY;
    private TextView dRZ;
    private View dSa;
    private View mView;
    private Runnable zS;

    public dp(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.dRJ = null;
        this.dRR = null;
        this.dRS = null;
        this.dRT = null;
        this.dRU = null;
        this.dLv = null;
        this.aew = null;
        this.dLv = pbActivity;
        this.aew = onClickListener;
        nl();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aGk() {
        return this.dRJ;
    }

    public TextView aGt() {
        return this.dRR;
    }

    public TextView aGu() {
        return this.dRS;
    }

    public TextView aGv() {
        return this.dRU;
    }

    public TextView aGw() {
        return this.dRT;
    }

    public TextView aGx() {
        return this.dRZ;
    }

    public View aGy() {
        return this.dRW;
    }

    public void aGz() {
        if (this.zS == null) {
            this.zS = new dq(this);
        }
        this.dRW.postDelayed(this.zS, 200L);
    }

    public void aGA() {
        this.dRW.setBackgroundColor(this.dLv.getResources().getColor(u.d.common_color_10022));
    }

    public void release() {
        this.dRW.removeCallbacks(this.zS);
    }

    public void hC(boolean z) {
        if (z) {
            this.dRU.setVisibility(8);
        } else {
            this.dRU.setVisibility(0);
        }
    }

    public void hD(boolean z) {
        if (z) {
            this.dRV.setVisibility(8);
        } else {
            this.dRV.setVisibility(0);
        }
    }

    public void hE(boolean z) {
        if (z) {
            this.dRT.setVisibility(8);
        } else {
            this.dRT.setVisibility(0);
        }
    }

    private void nl() {
        this.mView = LayoutInflater.from(this.dLv.getPageContext().getPageActivity()).inflate(u.h.pb_more_pop_view, (ViewGroup) null);
        this.dRJ = (TextView) this.mView.findViewById(u.g.pb_more_view_item_mark);
        this.dRJ.setOnClickListener(this.aew);
        this.dRR = (TextView) this.mView.findViewById(u.g.pb_more_view_item_jump);
        this.dRR.setOnClickListener(this.aew);
        this.dRS = (TextView) this.mView.findViewById(u.g.pb_more_view_item_see);
        this.dRS.setOnClickListener(this.aew);
        this.dRU = (TextView) this.mView.findViewById(u.g.pb_more_view_item_report);
        this.dRU.setOnClickListener(this.aew);
        this.dRV = (TextView) this.mView.findViewById(u.g.pb_more_view_item_report_ecomm);
        this.dRV.setOnClickListener(this.aew);
        this.dRT = (TextView) this.mView.findViewById(u.g.pb_more_view_item_upgrade_thread);
        this.dRT.setOnClickListener(this.aew);
        this.dRW = this.mView.findViewById(u.g.pb_more_layer);
        this.dRX = (FlowLayout) this.mView.findViewById(u.g.pb_more_flowlayout);
        this.dRY = (LinearLayout) this.mView.findViewById(u.g.size_seek_bar_group);
        this.dSa = this.mView.findViewById(u.g.pb_more_seekbar_line);
        this.dRZ = (TextView) this.mView.findViewById(u.g.pb_more_cancel);
        this.dRZ.setOnClickListener(this.aew);
        this.dRW.setOnClickListener(this.aew);
    }

    public void aGB() {
        com.baidu.tbadk.core.util.av.l(this.dRX, u.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.av.l(this.dRY, u.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.av.l(this.dSa, u.d.cp_bg_line_b);
        com.baidu.tbadk.core.util.av.k(this.dRZ, u.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.av.c(this.dRZ, u.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.av.c(this.dRJ, u.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.dRR, u.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.dRS, u.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.dRU, u.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.dRV, u.d.cp_cont_c, 1);
        com.baidu.tbadk.core.util.av.c(this.dRT, u.d.cp_cont_c, 1);
        this.dRX.setHorizontalSpacing(((((WindowManager) this.dLv.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(u.e.ds80)) - (TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(u.e.ds130) * 4)) / 3);
        this.dRJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.dRR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.dRS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
        this.dRU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.dRV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.dRT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_recommend_shengji_selector), (Drawable) null, (Drawable) null);
    }
}
