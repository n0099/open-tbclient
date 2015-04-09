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
    private TopRecActivity byc;
    private BdListView bym;
    private Button byn;
    private final View byo;
    private LinearLayout byp;
    private TextView byq;
    private ImageView byr;
    private TextView byt;
    private Animation byu;
    private Animation byv;
    Handler mHandler;
    NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ag mPullView;
    private int bys = 0;
    private boolean byb = false;

    public g(TopRecActivity topRecActivity) {
        this.mHandler = null;
        this.byc = topRecActivity;
        this.mHandler = new Handler();
        this.byc.setContentView(w.top_recommended_activity);
        this.bym = (BdListView) this.byc.findViewById(v.top_list);
        this.mNavigationBar = (NavigationBar) topRecActivity.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(topRecActivity.getPageContext().getString(y.top_recommended));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.nb_item_top_rec, (View.OnClickListener) null);
        this.byn = (Button) addCustomView.findViewById(v.title_finish);
        this.byn.setOnClickListener(this.byc);
        this.byt = (TextView) addCustomView.findViewById(v.title_finish_cover);
        this.mPullView = new ag(this.byc.getPageContext());
        this.byp = (LinearLayout) com.baidu.adp.lib.g.b.hH().inflate(topRecActivity.getPageContext().getPageActivity(), w.forum_list_forum_footer, null);
        this.byo = this.byp.findViewById(v.footer_background);
        this.byq = (TextView) this.byp.findViewById(v.footer_text);
        this.byr = (ImageView) this.byp.findViewById(v.footer_icon);
        WK();
        this.byu = AnimationUtils.loadAnimation(this.byc.getPageContext().getPageActivity(), p.top_recommended_finish_a);
        this.byv = AnimationUtils.loadAnimation(this.byc.getPageContext().getPageActivity(), p.top_recommended_finish_b);
        this.byu.setAnimationListener(new h(this));
        this.byv.setAnimationListener(new i(this));
        this.byn.setText(String.valueOf(this.byc.getPageContext().getString(y.done)) + "(" + this.bys + ")");
        this.bym.setPullRefresh(this.mPullView);
        this.mProgressBar = (ProgressBar) this.byc.findViewById(v.loading);
    }

    public LinearLayout WI() {
        return this.byp;
    }

    public Button WJ() {
        return this.byn;
    }

    public void a(e eVar) {
        this.bym.setAdapter((ListAdapter) eVar);
    }

    public void b(ae aeVar) {
        this.mPullView.a(aeVar);
    }

    public void mW() {
        this.bym.removeFooterView(this.byp);
        this.bym.addFooterView(this.byp);
        this.bym.mW();
    }

    public void gK(int i) {
        this.byn.invalidate();
        if (this.bys < 100) {
            this.byt.setText(String.valueOf(this.byc.getPageContext().getString(y.done)) + "(" + this.bys + ")");
        } else {
            this.byt.setText(String.valueOf(this.byc.getPageContext().getString(y.done)) + "(99+)");
        }
        this.byn.setText(" ");
        this.byt.setVisibility(0);
        this.byt.setAnimation(this.byu);
        this.byu.start();
        this.bys = i;
    }

    public void WK() {
        this.byq.setText(this.byc.getPageContext().getString(y.flist_expand_list));
        ba.i(this.byr, u.ico_downward);
        this.byp.setOnClickListener(this.byc);
    }

    public void WL() {
        this.byq.setText(this.byc.getPageContext().getString(y.to_the_end));
        this.byr.setVisibility(8);
        this.byp.setClickable(false);
        this.byp.setOnClickListener(null);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.byc.getPageContext(), i);
        ba.f(this.byc.findViewById(v.container), i);
        ba.f((TextView) this.byn, i);
        ba.e((TextView) this.byn, i);
        ba.e(this.byt, i);
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.bym.setDivider(new ColorDrawable(-13881543));
        } else {
            this.bym.setDivider(new ColorDrawable(-1775893));
        }
        this.bym.setDividerHeight(2);
        ba.i(this.byo, u.bg_black_banner_down);
        ba.b(this.byq, s.flist_text_color_day, 1);
        if (this.byb) {
            this.byr.setVisibility(8);
        } else {
            ba.c(this.byr, u.ico_downward);
        }
    }

    public void cI(boolean z) {
        if (z) {
            this.mProgressBar.setVisibility(0);
        } else {
            this.mProgressBar.setVisibility(8);
        }
    }
}
