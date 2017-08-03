package com.baidu.tieba.pb.pb.main.view;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.x;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.pb.view.f;
/* loaded from: classes.dex */
public class d {
    private Runnable aFV;
    public final View aKL;
    public View bZl;
    private PbActivity eFn;
    public final TextView eTh;
    public final ImageView eTi;
    public final ImageView eTj;
    public final ImageView eTk;
    private final ImageView eTl;
    private final LinearLayout eTm;
    private View eTp;
    private ImageView etl;
    public final NavigationBar mNavigationBar;
    private f eTn = null;
    private x eTo = null;
    private boolean eTq = false;
    private boolean eOr = false;

    public d(PbActivity pbActivity) {
        this.eFn = pbActivity;
        this.mNavigationBar = (NavigationBar) this.eFn.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eFn.afk();
            }
        });
        this.aKL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbActivity.cjs);
        this.aKL.setPadding(k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds18), this.aKL.getPaddingTop(), this.aKL.getPaddingRight(), this.aKL.getPaddingBottom());
        this.bZl = new View(this.eFn.getPageContext().getPageActivity());
        this.bZl.setVisibility(8);
        ai.k(this.bZl, d.e.cp_cont_f_alpha60);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.bZl, pbActivity.cjs);
        if (this.bZl.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bZl.getLayoutParams();
            layoutParams.width = k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds1);
            layoutParams.height = k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds40);
            layoutParams.rightMargin = k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds20);
            this.bZl.setLayoutParams(layoutParams);
        }
        this.eTh = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.j.pb_title_textview, (View.OnClickListener) null);
        this.eTl = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.eTm = (LinearLayout) this.mNavigationBar.getCenterImgBoxLayout();
        int g = k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds20);
        this.eTm.setPadding(g, 0, g, 0);
        ai.b(this.eTl, d.g.icon_pb_play_small, d.g.icon_pb_play_small);
        this.eTl.setVisibility(8);
        this.eTi = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nb_item_floor_host, pbActivity.cjs);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds30), 0, k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds26), 0);
        this.eTi.setLayoutParams(layoutParams2);
        this.eTi.setVisibility(8);
        this.eTk = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nb_item_floor_share, pbActivity.cjs);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, 0, k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds40), 0);
        this.eTk.setLayoutParams(layoutParams3);
        this.eTk.setVisibility(8);
        ai.b(this.eTk, d.g.icon_pb_share_selector, d.g.icon_pb_share_selector);
        this.eTj = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.nb_item_floor_more, pbActivity.cjs);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.setMargins(0, 0, k.g(this.eFn.getPageContext().getPageActivity(), d.f.ds28), 0);
        this.eTj.setLayoutParams(layoutParams4);
        ai.b(this.eTj, d.g.icon_nav_more_selector, d.g.icon_nav_more_selector);
        this.eTh.setOnClickListener(pbActivity.cjs);
        this.eTl.setOnClickListener(pbActivity.cjs);
        this.etl = (ImageView) this.aKL.findViewById(d.h.widget_navi_back_button);
        this.eTp = this.mNavigationBar.getBottomLine();
        if (this.eTp != null) {
            this.eTp.setVisibility(8);
        }
    }

    public void jD(boolean z) {
        this.eTj.setVisibility(z ? 0 : 8);
    }

    public NavigationBar aUu() {
        return this.mNavigationBar;
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.aKL.setVisibility(0);
        } else {
            this.aKL.setVisibility(8);
        }
        jT(z);
    }

    public void mQ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eTh.setText(this.eFn.getResources().getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 11, true)));
            jT(true);
            h.oN().co(str);
            return;
        }
        jT(false);
    }

    public void aUv() {
        this.eTi.setVisibility(4);
        this.eTi.setEnabled(false);
    }

    public void jH(boolean z) {
        if (z) {
            ai.c(this.eTi, d.g.s_only_host_button_bg);
            this.eTi.setContentDescription(this.eFn.getResources().getString(d.l.view_host_selected));
        } else {
            ai.b(this.eTi, d.g.icon_floor_host_bg, d.g.icon_floor_host_bg);
            this.eTi.setContentDescription(this.eFn.getResources().getString(d.l.view_host));
        }
        this.eOr = z;
    }

    public void a(y yVar) {
        if (!this.eFn.isProgressBarShown()) {
            if (this.eTn == null) {
                this.eTo = new x((PbActivity) this.eFn.getPageContext().getOrignalPage(), this.eFn.cjs);
                this.eTn = new f(this.eFn.getPageContext().getPageActivity(), this.eTo.getView(), ai.getDrawable(d.g.bg_pull_down_right_n), new d.a() { // from class: com.baidu.tieba.pb.pb.main.view.d.2
                    @Override // com.baidu.tbadk.core.view.d.a
                    public void oj() {
                        d.this.eFn.aQj();
                    }

                    @Override // com.baidu.tbadk.core.view.d.a
                    public void ok() {
                    }
                });
            }
            this.eTo.Vq();
            this.eTn.showAtLocation(this.eFn.findViewById(d.h.pb_layout), 17, 0, 0);
            this.eTo.jq(yVar == null ? false : yVar.eLh);
            this.eTo.jp(yVar == null ? false : yVar.eLj);
            this.eTo.jt(yVar == null ? false : yVar.eLp);
            this.eTo.ju(yVar == null ? false : yVar.eLq);
            this.eTo.jr(yVar == null ? false : yVar.eLi);
            this.eTo.jw(yVar == null ? false : yVar.eLm);
            this.eTo.jv(yVar == null ? false : yVar.eLr);
            if (yVar == null) {
                this.eTo.E(false, false);
                this.eTo.F(false, false);
            } else {
                this.eTo.E(yVar.eLn, yVar.eLt);
                this.eTo.F(yVar.eLo, yVar.eLs);
            }
            boolean z = yVar == null ? false : yVar.eLl;
            boolean z2 = yVar == null ? false : yVar.eDz;
            boolean z3 = yVar == null ? false : yVar.isHostOnly;
            boolean z4 = yVar == null ? false : yVar.eLu;
            this.eTo.js(yVar != null ? yVar.eLk : false);
            this.eTo.D(z4, z3);
            i(z, z2, z3);
        }
    }

    private void i(boolean z, boolean z2, boolean z3) {
        if (this.eTo != null) {
            this.eTo.Vu();
            if (z) {
                this.eTo.aSd().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_recommend_see_selector), (Drawable) null, (Drawable) null);
                this.eTo.aSd().setText(this.eFn.getResources().getString(d.l.view_reverse));
            } else {
                this.eTo.aSd().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_recommend_see_down_selector), (Drawable) null, (Drawable) null);
                this.eTo.aSd().setText(this.eFn.getResources().getString(d.l.view_positive_sequence));
            }
            if (z2) {
                this.eTo.aRU().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_recommend_collect_h_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eTo.aRU().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_recommend_collect_selector), (Drawable) null, (Drawable) null);
            }
            if (z3) {
                this.eTo.aSh().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_host_only_selector), (Drawable) null, (Drawable) null);
            } else {
                this.eTo.aSh().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.getDrawable(d.g.icon_not_host_only_selector), (Drawable) null, (Drawable) null);
            }
        }
    }

    public void og() {
        if (this.eTo != null) {
            this.eTo.Vr();
        }
        if (this.aFV == null) {
            this.aFV = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.d.3
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.eTn != null) {
                        g.a(d.this.eTn, d.this.eFn.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.fP().postDelayed(this.aFV, 100L);
    }

    public x aUw() {
        return this.eTo;
    }

    public View aUx() {
        return this.eTl;
    }

    public boolean Xe() {
        return this.eTn != null && this.eTn.isShowing();
    }

    public void aBq() {
        if (this.eTo != null) {
            this.eTo.release();
        }
        this.eTn = null;
        this.eTo = null;
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aFV);
    }

    public void aUy() {
        this.eTi.setVisibility(8);
        this.eTj.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ai.cR(d.g.s_navbar_bg)));
            this.mNavigationBar.onChangeSkinType(this.eFn.getPageContext(), i);
        }
        ai.b(this.eTj, d.g.icon_nav_more_selector, d.g.icon_nav_more_selector);
        ai.b(this.eTh, d.e.cp_cont_b, d.e.s_navbar_title_color);
        ai.k(this.bZl, d.e.cp_cont_f_alpha60);
    }

    public void px(int i) {
        this.mNavigationBar.onChangeSkinType(this.eFn.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(d.g.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mNavigationBar.getBarBgView().setBackgroundColor(this.eFn.getResources().getColor(d.e.black_alpha85));
        this.eTp.setVisibility(8);
        aUv();
        this.eTk.setImageResource(d.g.icon_pb_share_selector);
        this.eTj.setImageResource(d.g.icon_more_bg);
        this.eTh.setTextColor(this.eFn.getResources().getColor(d.e.cp_cont_g));
        this.bZl.setBackgroundColor(this.eFn.getResources().getColor(d.e.cp_cont_g));
        this.etl.setImageResource(d.g.icon_return_bg);
    }

    public void aUz() {
        this.etl.setVisibility(0);
        jT(false);
        this.eTi.setVisibility(8);
        this.eTj.setVisibility(8);
    }

    public void jS(boolean z) {
        this.etl.setVisibility(0);
        jT(z);
        this.eTi.setVisibility(8);
        if (TbadkCoreApplication.isLogin()) {
            this.eTj.setVisibility(0);
        } else {
            this.eTj.setVisibility(8);
        }
    }

    public void jT(boolean z) {
        if (z && !"".equals(this.eTh.getText().toString())) {
            this.eTh.setVisibility(0);
            this.bZl.setVisibility(0);
            return;
        }
        this.eTh.setVisibility(8);
        this.bZl.setVisibility(8);
    }

    public void jU(boolean z) {
    }

    public void jV(boolean z) {
        this.eTq = z;
    }
}
