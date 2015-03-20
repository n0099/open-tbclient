package com.baidu.tieba.launcherGuide.topRec;

import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tbadk.core.view.ag;
import com.baidu.tieba.p;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class g {
    private TopRecActivity bxM;
    private BdListView bxW;
    private Button bxX;
    private final View bxY;
    private LinearLayout bxZ;
    private TextView bya;
    private ImageView byb;
    private TextView byd;
    private Animation bye;
    private Animation byf;
    Handler mHandler;
    NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ag mPullView;
    private int byc = 0;
    private boolean bxL = false;

    public g(TopRecActivity topRecActivity) {
        this.mHandler = null;
        this.bxM = topRecActivity;
        this.mHandler = new Handler();
        this.bxM.setContentView(w.top_recommended_activity);
        this.bxW = (BdListView) this.bxM.findViewById(v.top_list);
        this.mNavigationBar = (NavigationBar) topRecActivity.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(topRecActivity.getPageContext().getString(y.top_recommended));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.nb_item_top_rec, (View.OnClickListener) null);
        this.bxX = (Button) addCustomView.findViewById(v.title_finish);
        this.bxX.setOnClickListener(this.bxM);
        this.byd = (TextView) addCustomView.findViewById(v.title_finish_cover);
        this.mPullView = new ag(this.bxM.getPageContext());
        this.bxZ = (LinearLayout) com.baidu.adp.lib.g.b.hH().inflate(topRecActivity.getPageContext().getPageActivity(), w.forum_list_forum_footer, null);
        this.bxY = this.bxZ.findViewById(v.footer_background);
        this.bya = (TextView) this.bxZ.findViewById(v.footer_text);
        this.byb = (ImageView) this.bxZ.findViewById(v.footer_icon);
        Wx();
        this.bye = AnimationUtils.loadAnimation(this.bxM.getPageContext().getPageActivity(), p.top_recommended_finish_a);
        this.byf = AnimationUtils.loadAnimation(this.bxM.getPageContext().getPageActivity(), p.top_recommended_finish_b);
        this.bye.setAnimationListener(new h(this));
        this.byf.setAnimationListener(new i(this));
        this.bxX.setText(String.valueOf(this.bxM.getPageContext().getString(y.done)) + "(" + this.byc + ")");
        this.bxW.setPullRefresh(this.mPullView);
        this.mProgressBar = (ProgressBar) this.bxM.findViewById(v.loading);
    }

    public LinearLayout Wv() {
        return this.bxZ;
    }

    public Button Ww() {
        return this.bxX;
    }

    public void a(e eVar) {
        this.bxW.setAdapter((ListAdapter) eVar);
    }

    public void b(ae aeVar) {
        this.mPullView.a(aeVar);
    }

    public void mW() {
        this.bxW.removeFooterView(this.bxZ);
        this.bxW.addFooterView(this.bxZ);
        this.bxW.mW();
    }

    public void gI(int i) {
        this.bxX.invalidate();
        if (this.byc < 100) {
            this.byd.setText(String.valueOf(this.bxM.getPageContext().getString(y.done)) + "(" + this.byc + ")");
        } else {
            this.byd.setText(String.valueOf(this.bxM.getPageContext().getString(y.done)) + "(99+)");
        }
        this.bxX.setText(" ");
        this.byd.setVisibility(0);
        this.byd.setAnimation(this.bye);
        this.bye.start();
        this.byc = i;
    }

    public void Wx() {
        this.bya.setText(this.bxM.getPageContext().getString(y.flist_expand_list));
        ba.i(this.byb, u.ico_downward);
        this.bxZ.setOnClickListener(this.bxM);
    }

    public void Wy() {
        this.bya.setText(this.bxM.getPageContext().getString(y.to_the_end));
        this.byb.setVisibility(8);
        this.bxZ.setClickable(false);
        this.bxZ.setOnClickListener(null);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bxM.getPageContext(), i);
        ba.f(this.bxM.findViewById(v.container), i);
        ba.f((TextView) this.bxX, i);
        ba.e((TextView) this.bxX, i);
        ba.e(this.byd, i);
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.bxW.setDivider(new ColorDrawable(-13881543));
        } else {
            this.bxW.setDivider(new ColorDrawable(-1775893));
        }
        this.bxW.setDividerHeight(2);
        ba.i(this.bxY, u.bg_black_banner_down);
        ba.b(this.bya, s.flist_text_color_day, 1);
        if (this.bxL) {
            this.byb.setVisibility(8);
        } else {
            ba.c(this.byb, u.ico_downward);
        }
    }

    public void cK(boolean z) {
        if (z) {
            this.mProgressBar.setVisibility(0);
        } else {
            this.mProgressBar.setVisibility(8);
        }
    }
}
