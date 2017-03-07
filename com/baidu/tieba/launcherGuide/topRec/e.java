package com.baidu.tieba.launcherGuide.topRec;

import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e {
    private Button dsA;
    private final View dsB;
    private LinearLayout dsC;
    private TextView dsD;
    private ImageView dsE;
    private TextView dsG;
    private Animation dsH;
    private Animation dsI;
    private TopRecActivity dsp;
    private BdListView dsz;
    Handler mHandler;
    NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ae mPullView;
    private int dsF = 0;
    private boolean dso = false;

    public e(TopRecActivity topRecActivity) {
        this.mHandler = null;
        this.dsp = topRecActivity;
        this.mHandler = new Handler();
        this.dsp.setContentView(w.j.top_recommended_activity);
        this.dsz = (BdListView) this.dsp.findViewById(w.h.top_list);
        this.mNavigationBar = (NavigationBar) topRecActivity.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(topRecActivity.getPageContext().getString(w.l.top_recommended));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.nb_item_top_rec, (View.OnClickListener) null);
        this.dsA = (Button) addCustomView.findViewById(w.h.title_finish);
        this.dsA.setOnClickListener(this.dsp);
        this.dsG = (TextView) addCustomView.findViewById(w.h.title_finish_cover);
        this.mPullView = new ae(this.dsp.getPageContext());
        this.dsC = (LinearLayout) LayoutInflater.from(topRecActivity.getPageContext().getPageActivity()).inflate(w.j.forum_list_forum_footer, (ViewGroup) null);
        this.dsB = this.dsC.findViewById(w.h.footer_background);
        this.dsD = (TextView) this.dsC.findViewById(w.h.footer_text);
        this.dsE = (ImageView) this.dsC.findViewById(w.h.footer_icon);
        axr();
        this.dsH = AnimationUtils.loadAnimation(this.dsp.getPageContext().getPageActivity(), w.a.top_recommended_finish_a);
        this.dsI = AnimationUtils.loadAnimation(this.dsp.getPageContext().getPageActivity(), w.a.top_recommended_finish_b);
        this.dsH.setAnimationListener(new f(this));
        this.dsI.setAnimationListener(new g(this));
        this.dsA.setText(String.valueOf(this.dsp.getPageContext().getString(w.l.done)) + "(" + this.dsF + ")");
        this.dsz.setPullRefresh(this.mPullView);
        this.mProgressBar = (ProgressBar) this.dsp.findViewById(w.h.loading);
    }

    public LinearLayout axp() {
        return this.dsC;
    }

    public Button axq() {
        return this.dsA;
    }

    public void a(d dVar) {
        this.dsz.setAdapter((ListAdapter) dVar);
    }

    public void b(ab.b bVar) {
        this.mPullView.a(bVar);
    }

    public void completePullRefresh() {
        this.dsz.removeFooterView(this.dsC);
        this.dsz.addFooterView(this.dsC);
        this.dsz.completePullRefreshPostDelayed(2000L);
    }

    public void mn(int i) {
        this.dsA.invalidate();
        if (this.dsF < 100) {
            this.dsG.setText(String.valueOf(this.dsp.getPageContext().getString(w.l.done)) + "(" + this.dsF + ")");
        } else {
            this.dsG.setText(String.valueOf(this.dsp.getPageContext().getString(w.l.done)) + "(99+)");
        }
        this.dsA.setText(" ");
        this.dsG.setVisibility(0);
        this.dsG.setAnimation(this.dsH);
        this.dsH.start();
        this.dsF = i;
    }

    public void axr() {
        this.dsD.setText(this.dsp.getPageContext().getString(w.l.flist_expand_list));
        aq.j(this.dsE, w.g.ico_downward);
        this.dsC.setOnClickListener(this.dsp);
    }

    public void axs() {
        this.dsD.setText(this.dsp.getPageContext().getString(w.l.to_the_end));
        this.dsE.setVisibility(8);
        this.dsC.setClickable(false);
        this.dsC.setOnClickListener(null);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.dsp.getPageContext(), i);
        aq.g(this.dsp.findViewById(w.h.container), i);
        aq.e(this.dsA, i);
        aq.d(this.dsA, i);
        aq.d(this.dsG, i);
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.dsz.setDivider(new ColorDrawable(-13881543));
        } else {
            this.dsz.setDivider(new ColorDrawable(-1775893));
        }
        this.dsz.setDividerHeight(2);
        aq.j(this.dsB, w.g.bg_black_banner_down);
        aq.c(this.dsD, w.e.common_color_10243, 1);
        if (this.dso) {
            this.dsE.setVisibility(8);
        } else {
            aq.c(this.dsE, w.g.ico_downward);
        }
    }

    public void fN(boolean z) {
        if (z) {
            this.mProgressBar.setVisibility(0);
        } else {
            this.mProgressBar.setVisibility(8);
        }
    }
}
