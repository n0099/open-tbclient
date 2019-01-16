package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.view.TextSizeSeekBar;
/* loaded from: classes6.dex */
public class aa extends com.baidu.adp.base.c<PbActivity> {
    private Runnable bdZ;
    private TextView gdA;
    private TextView gdB;
    private TextView gdC;
    private TextView gdD;
    private TextView gdE;
    private PbActivity gdF;
    private View gdG;
    private FlowLayout gdH;
    private LinearLayout gdI;
    private TextSizeSeekBar gdJ;
    public boolean gdK;
    public boolean gdL;
    private TextView gdh;
    private TextView gdu;
    private TextView gdv;
    private TextView gdw;
    private TextView gdx;
    private TextView gdy;
    private TextView gdz;
    private TextView mCancelView;
    private View.OnClickListener mClickListener;
    private View mView;

    public aa(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity.getPageContext());
        this.mView = null;
        this.gdh = null;
        this.gdu = null;
        this.gdC = null;
        this.gdF = null;
        this.mClickListener = null;
        this.gdF = pbActivity;
        this.mClickListener = onClickListener;
        initUI();
    }

    public View getView() {
        return this.mView;
    }

    public TextView blj() {
        return this.gdh;
    }

    public TextView blr() {
        return this.gdu;
    }

    public TextView bls() {
        return this.gdC;
    }

    public TextView getCancelView() {
        return this.mCancelView;
    }

    public View blt() {
        return this.gdG;
    }

    public TextView blu() {
        return this.gdE;
    }

    public TextView blv() {
        return this.gdy;
    }

    public TextView blw() {
        return this.gdw;
    }

    public TextView blx() {
        return this.gdB;
    }

    public TextView bly() {
        return this.gdv;
    }

    public TextView blz() {
        return this.gdx;
    }

    public TextView blA() {
        return this.gdz;
    }

    public TextView blB() {
        return this.gdA;
    }

    public TextView blC() {
        return this.gdD;
    }

    public void blD() {
        if (this.bdZ == null) {
            this.bdZ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                @Override // java.lang.Runnable
                public void run() {
                    aa.this.gdG.setBackgroundColor(aa.this.gdF.getResources().getColor(e.d.common_color_10082));
                }
            };
        }
        this.gdG.postDelayed(this.bdZ, 200L);
    }

    public void blE() {
        this.gdG.setBackgroundColor(this.gdF.getResources().getColor(e.d.common_color_10022));
    }

    public void release() {
        this.gdG.removeCallbacks(this.bdZ);
    }

    public void lc(boolean z) {
        if (z) {
            this.gdC.setVisibility(0);
        } else {
            this.gdC.setVisibility(8);
        }
    }

    public void q(boolean z, String str) {
        if (z) {
            this.gdD.setVisibility(0);
            this.gdD.setText(str);
            return;
        }
        this.gdD.setVisibility(8);
    }

    public void ld(boolean z) {
        this.gdh.setVisibility(z ? 0 : 8);
    }

    public void N(boolean z, boolean z2) {
        this.gdE.setVisibility(z ? 0 : 8);
        if (z2) {
            this.gdE.setText(e.j.group_info_intro_more);
        } else {
            this.gdE.setText(e.j.view_host);
        }
    }

    public void O(boolean z, boolean z2) {
        this.gdy.setVisibility(z ? 0 : 8);
        if (z2) {
            this.gdy.setText(e.j.cancel_top);
        } else {
            this.gdy.setText(e.j.top);
        }
    }

    public void P(boolean z, boolean z2) {
        this.gdB.setVisibility(z ? 0 : 8);
        if (z2) {
            this.gdB.setText(e.j.cancel_good);
        } else {
            this.gdB.setText(e.j.commit_good);
        }
    }

    public void le(boolean z) {
        this.gdw.setVisibility(z ? 0 : 8);
    }

    public void lf(boolean z) {
        this.gdv.setVisibility(z ? 0 : 8);
    }

    public void lg(boolean z) {
        this.gdx.setVisibility(z ? 0 : 8);
    }

    public void Q(boolean z, boolean z2) {
        this.gdz.setVisibility(z ? 0 : 8);
        this.gdL = z2;
        if (z2) {
            this.gdz.setText(e.j.view_reverse);
        } else {
            this.gdz.setText(e.j.default_sort);
        }
        this.gdz.setText(e.j.sort_selector);
    }

    public void R(boolean z, boolean z2) {
        this.gdA.setVisibility(z ? 0 : 8);
        if (z2) {
            this.gdA.setText(e.j.normal_mode);
        } else {
            this.gdA.setText(e.j.eyeshield_mode);
        }
    }

    public void lh(boolean z) {
        this.gdu.setVisibility(z ? 0 : 8);
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.gdF.getPageContext().getPageActivity()).inflate(e.h.pb_more_pop_view, (ViewGroup) null);
        this.gdh = (TextView) this.mView.findViewById(e.g.pb_more_view_item_mark);
        this.gdh.setOnClickListener(this.mClickListener);
        this.gdu = (TextView) this.mView.findViewById(e.g.pb_more_view_item_jump);
        this.gdu.setOnClickListener(this.mClickListener);
        this.gdC = (TextView) this.mView.findViewById(e.g.pb_more_view_item_report);
        this.gdC.setOnClickListener(this.mClickListener);
        this.gdD = (TextView) this.mView.findViewById(e.g.pb_more_view_item_fans_call);
        this.gdD.setOnClickListener(this.mClickListener);
        this.gdv = (TextView) this.mView.findViewById(e.g.pb_more_view_item_jump_top);
        this.gdv.setOnClickListener(this.mClickListener);
        this.gdw = (TextView) this.mView.findViewById(e.g.pb_more_view_item_delete);
        this.gdw.setOnClickListener(this.mClickListener);
        this.gdx = (TextView) this.mView.findViewById(e.g.pb_more_view_item_forbidden);
        this.gdx.setOnClickListener(this.mClickListener);
        this.gdz = (TextView) this.mView.findViewById(e.g.pb_more_view_item_reversed);
        this.gdz.setOnClickListener(this.mClickListener);
        this.gdA = (TextView) this.mView.findViewById(e.g.pb_more_view_item_night_style);
        this.gdA.setOnClickListener(this.mClickListener);
        this.gdy = (TextView) this.mView.findViewById(e.g.pb_more_view_item_make_top);
        this.gdy.setOnClickListener(this.mClickListener);
        this.gdB = (TextView) this.mView.findViewById(e.g.pb_more_view_item_add_good);
        this.gdB.setOnClickListener(this.mClickListener);
        this.gdE = (TextView) this.mView.findViewById(e.g.pb_more_view_item_host_only);
        this.gdE.setOnClickListener(this.mClickListener);
        this.gdG = this.mView.findViewById(e.g.pb_more_layer);
        this.gdH = (FlowLayout) this.mView.findViewById(e.g.pb_more_flowlayout);
        this.gdJ = (TextSizeSeekBar) this.mView.findViewById(e.g.pb_more_text_size_seekbar);
        this.gdI = (LinearLayout) this.mView.findViewById(e.g.size_seek_bar_group);
        this.mCancelView = (TextView) this.mView.findViewById(e.g.pb_more_cancel);
        this.mCancelView.setOnClickListener(this.mClickListener);
        this.gdG.setOnClickListener(this.mClickListener);
    }

    public void setBackGround() {
        com.baidu.tbadk.core.util.al.j(this.gdH, e.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.j(this.gdI, e.d.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.i(this.mCancelView, e.f.pb_more_pop_cancle_selector);
        com.baidu.tbadk.core.util.al.c(this.mCancelView, e.f.pb_more_pop_cancel_text_selector, 1);
        com.baidu.tbadk.core.util.al.c(this.gdh, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gdu, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gdC, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gdD, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gdE, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gdv, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gdw, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gdy, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gdB, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gdx, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gdz, e.d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.c(this.gdA, e.d.cp_cont_f, 1);
        this.gdH.setHorizontalSpacing(((((WindowManager) this.gdF.getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay().getWidth() - TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds64)) - (TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0210e.ds100) * 5)) / 4);
        this.gdh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
        this.gdu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_jump_selector), (Drawable) null, (Drawable) null);
        this.gdC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        this.gdD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.call_fans_selector), (Drawable) null, (Drawable) null);
        this.gdv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_jump_top_selector), (Drawable) null, (Drawable) null);
        if (this.gdK) {
            this.gdw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_report_selector), (Drawable) null, (Drawable) null);
        } else {
            this.gdw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_delete_selector), (Drawable) null, (Drawable) null);
        }
        this.gdy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_make_top_selector), (Drawable) null, (Drawable) null);
        this.gdB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_make_good_selector), (Drawable) null, (Drawable) null);
        this.gdx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_forbidden_user_selector), (Drawable) null, (Drawable) null);
        this.gdA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_night_style_selector), (Drawable) null, (Drawable) null);
        this.gdz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_recommend_reversed_selector), (Drawable) null, (Drawable) null);
        this.gdE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.al.getDrawable(e.f.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
        if (this.gdJ != null) {
            this.gdJ.onChangeSkinType();
        }
    }
}
