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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class dr extends com.baidu.adp.base.e<PbActivity> {
    private Runnable IL;
    private View.OnClickListener aRY;
    private View bsT;
    private FlowLayout bsU;
    private TextView bsV;
    private TextView eoC;
    private TextView eoK;
    private TextView eoL;
    private TextView eoM;
    private TextView eoN;
    private TextView eoO;
    private TextView eoP;
    private TextView eoQ;
    private TextView eoR;
    private TextView eoS;
    private TextView eoT;
    private ViewGroup eoU;
    private TextView eoV;
    private ImageView eoW;
    private TextView eoX;
    private PbActivity eoY;
    private LinearLayout eoZ;
    private View epa;
    private View mView;

    public dr(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.eoC = null;
        this.eoK = null;
        this.eoL = null;
        this.eoS = null;
        this.eoT = null;
        this.eoV = null;
        this.eoY = null;
        this.aRY = null;
        this.eoY = pbActivity;
        this.aRY = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView aNg() {
        return this.eoC;
    }

    public TextView aNo() {
        return this.eoK;
    }

    public TextView aNp() {
        return this.eoL;
    }

    public TextView aNq() {
        return this.eoT;
    }

    public TextView aNr() {
        return this.eoS;
    }

    public TextView aNs() {
        return this.eoV;
    }

    public TextView getCancelView() {
        return this.bsV;
    }

    public View Tx() {
        return this.bsT;
    }

    public TextView aNt() {
        return this.eoM;
    }

    public TextView aNu() {
        return this.eoX;
    }

    public TextView aNv() {
        return this.eoQ;
    }

    public TextView aNw() {
        return this.eoO;
    }

    public TextView aNx() {
        return this.eoR;
    }

    public TextView aNy() {
        return this.eoN;
    }

    public TextView aNz() {
        return this.eoP;
    }

    public void Ty() {
        if (this.IL == null) {
            this.IL = new ds(this);
        }
        this.bsT.postDelayed(this.IL, 200L);
    }

    public void Tz() {
        this.bsT.setBackgroundColor(this.eoY.getResources().getColor(w.e.common_color_10022));
    }

    public void release() {
        this.bsT.removeCallbacks(this.IL);
    }

    public void iF(boolean z) {
        if (z) {
            this.eoT.setVisibility(0);
        } else {
            this.eoT.setVisibility(8);
        }
    }

    public void iG(boolean z) {
        if (z) {
            this.eoS.setVisibility(0);
        } else {
            this.eoS.setVisibility(8);
        }
    }

    public void iH(boolean z) {
        this.eoU.setVisibility(z ? 0 : 8);
    }

    public void iI(boolean z) {
        this.eoC.setVisibility(z ? 0 : 8);
    }

    public void v(boolean z, boolean z2) {
        this.eoX.setVisibility(z ? 0 : 8);
    }

    public void iJ(boolean z) {
        this.eoM.setVisibility(z ? 0 : 8);
    }

    public void w(boolean z, boolean z2) {
        this.eoQ.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eoQ.setText(w.l.cancel_top);
        } else {
            this.eoQ.setText(w.l.top);
        }
    }

    public void x(boolean z, boolean z2) {
        this.eoR.setVisibility(z ? 0 : 8);
        if (z2) {
            this.eoR.setText(w.l.cancel_good);
        } else {
            this.eoR.setText(w.l.commit_good);
        }
    }

    public void iK(boolean z) {
        this.eoO.setVisibility(z ? 0 : 8);
    }

    public void iL(boolean z) {
        this.eoN.setVisibility(z ? 0 : 8);
    }

    public void iM(boolean z) {
        this.eoP.setVisibility(z ? 0 : 8);
    }

    public void aNA() {
        this.eoW.setVisibility(8);
        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("pb_god_call_tips_shown", false);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.eoY.getPageContext().getPageActivity()).inflate(w.j.pb_more_pop_view, (ViewGroup) null);
        this.eoC = (TextView) this.mView.findViewById(w.h.pb_more_view_item_mark);
        this.eoC.setOnClickListener(this.aRY);
        this.eoK = (TextView) this.mView.findViewById(w.h.pb_more_view_item_jump);
        this.eoK.setOnClickListener(this.aRY);
        this.eoL = (TextView) this.mView.findViewById(w.h.pb_more_view_item_see);
        this.eoL.setOnClickListener(this.aRY);
        this.eoT = (TextView) this.mView.findViewById(w.h.pb_more_view_item_report);
        this.eoT.setOnClickListener(this.aRY);
        this.eoS = (TextView) this.mView.findViewById(w.h.pb_more_view_item_upgrade_thread);
        this.eoS.setOnClickListener(this.aRY);
        this.eoM = (TextView) this.mView.findViewById(w.h.pb_more_view_item_share);
        this.eoM.setOnClickListener(this.aRY);
        this.eoN = (TextView) this.mView.findViewById(w.h.pb_more_view_item_jump_top);
        this.eoN.setOnClickListener(this.aRY);
        this.eoO = (TextView) this.mView.findViewById(w.h.pb_more_view_item_delete);
        this.eoO.setOnClickListener(this.aRY);
        this.eoP = (TextView) this.mView.findViewById(w.h.pb_more_view_item_forbidden);
        this.eoP.setOnClickListener(this.aRY);
        this.eoQ = (TextView) this.mView.findViewById(w.h.pb_more_view_item_make_top);
        this.eoQ.setOnClickListener(this.aRY);
        this.eoR = (TextView) this.mView.findViewById(w.h.pb_more_view_item_add_good);
        this.eoR.setOnClickListener(this.aRY);
        this.eoX = (TextView) this.mView.findViewById(w.h.pb_more_view_item_host_only);
        this.eoX.setOnClickListener(this.aRY);
        this.eoU = (ViewGroup) this.mView.findViewById(w.h.pb_more_view_item_god_call_layout);
        this.eoV = (TextView) this.mView.findViewById(w.h.pb_more_view_item_god_call);
        this.eoW = (ImageView) this.mView.findViewById(w.h.pb_more_view_item_god_call_tip);
        this.eoV.setOnClickListener(this.aRY);
        this.eoW.setVisibility(com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("pb_god_call_tips_shown", true) ? 0 : 8);
        this.bsT = this.mView.findViewById(w.h.pb_more_layer);
        this.bsU = (FlowLayout) this.mView.findViewById(w.h.pb_more_flowlayout);
        this.eoZ = (LinearLayout) this.mView.findViewById(w.h.size_seek_bar_group);
        this.epa = this.mView.findViewById(w.h.pb_more_seekbar_line);
        this.bsV = (TextView) this.mView.findViewById(w.h.pb_more_cancel);
        this.bsV.setOnClickListener(this.aRY);
        this.bsT.setOnClickListener(this.aRY);
    }

    public void TC() {
        com.baidu.tbadk.core.util.aq.k(this.bsU, w.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aq.k(this.eoZ, w.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.aq.k(this.epa, w.e.cp_bg_line_b);
        com.baidu.tbadk.core.util.aq.j(this.bsV, w.g.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.aq.c(this.bsV, w.g.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.aq.c(this.eoC, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eoK, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eoL, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eoT, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eoS, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eoV, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eoX, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eoM, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eoN, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eoO, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eoQ, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eoR, w.e.cp_cont_j, 1);
        com.baidu.tbadk.core.util.aq.c(this.eoP, w.e.cp_cont_j, 1);
        this.bsU.setHorizontalSpacing(((((WindowManager) this.eoY.getSystemService("window")).getDefaultDisplay().getWidth() - TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds64)) - (TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds100) * 5)) / 4);
        this.eoC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.eoK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.eoL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
        this.eoT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.eoS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_shengji_selector), (Drawable) null, (Drawable) null);
        this.eoV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.pb_more_god_call_selector), (Drawable) null, (Drawable) null);
        this.eoW.setImageDrawable(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_chat_dot));
        this.eoM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_share_selector), (Drawable) null, (Drawable) null);
        this.eoN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        this.eoO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        this.eoQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.eoR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.eoP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.eoX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
    }
}
