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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class e {
    private TopRecActivity bSY;
    private BdListView bTi;
    private Button bTj;
    private final View bTk;
    private LinearLayout bTl;
    private TextView bTm;
    private ImageView bTn;
    private TextView bTp;
    private Animation bTq;
    private Animation bTr;
    Handler mHandler;
    NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private r mPullView;
    private int bTo = 0;
    private boolean bSX = false;

    public e(TopRecActivity topRecActivity) {
        this.mHandler = null;
        this.bSY = topRecActivity;
        this.mHandler = new Handler();
        this.bSY.setContentView(i.g.top_recommended_activity);
        this.bTi = (BdListView) this.bSY.findViewById(i.f.top_list);
        this.mNavigationBar = (NavigationBar) topRecActivity.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(topRecActivity.getPageContext().getString(i.h.top_recommended));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_top_rec, (View.OnClickListener) null);
        this.bTj = (Button) addCustomView.findViewById(i.f.title_finish);
        this.bTj.setOnClickListener(this.bSY);
        this.bTp = (TextView) addCustomView.findViewById(i.f.title_finish_cover);
        this.mPullView = new r(this.bSY.getPageContext());
        this.bTl = (LinearLayout) LayoutInflater.from(topRecActivity.getPageContext().getPageActivity()).inflate(i.g.forum_list_forum_footer, (ViewGroup) null);
        this.bTk = this.bTl.findViewById(i.f.footer_background);
        this.bTm = (TextView) this.bTl.findViewById(i.f.footer_text);
        this.bTn = (ImageView) this.bTl.findViewById(i.f.footer_icon);
        aaS();
        this.bTq = AnimationUtils.loadAnimation(this.bSY.getPageContext().getPageActivity(), i.a.top_recommended_finish_a);
        this.bTr = AnimationUtils.loadAnimation(this.bSY.getPageContext().getPageActivity(), i.a.top_recommended_finish_b);
        this.bTq.setAnimationListener(new f(this));
        this.bTr.setAnimationListener(new g(this));
        this.bTj.setText(String.valueOf(this.bSY.getPageContext().getString(i.h.done)) + "(" + this.bTo + ")");
        this.bTi.setPullRefresh(this.mPullView);
        this.mProgressBar = (ProgressBar) this.bSY.findViewById(i.f.loading);
    }

    public LinearLayout aaQ() {
        return this.bTl;
    }

    public Button aaR() {
        return this.bTj;
    }

    public void a(d dVar) {
        this.bTi.setAdapter((ListAdapter) dVar);
    }

    public void b(p.a aVar) {
        this.mPullView.a(aVar);
    }

    public void completePullRefresh() {
        this.bTi.removeFooterView(this.bTl);
        this.bTi.addFooterView(this.bTl);
        this.bTi.completePullRefresh();
    }

    public void hX(int i) {
        this.bTj.invalidate();
        if (this.bTo < 100) {
            this.bTp.setText(String.valueOf(this.bSY.getPageContext().getString(i.h.done)) + "(" + this.bTo + ")");
        } else {
            this.bTp.setText(String.valueOf(this.bSY.getPageContext().getString(i.h.done)) + "(99+)");
        }
        this.bTj.setText(" ");
        this.bTp.setVisibility(0);
        this.bTp.setAnimation(this.bTq);
        this.bTq.start();
        this.bTo = i;
    }

    public void aaS() {
        this.bTm.setText(this.bSY.getPageContext().getString(i.h.flist_expand_list));
        an.i(this.bTn, i.e.ico_downward);
        this.bTl.setOnClickListener(this.bSY);
    }

    public void aaT() {
        this.bTm.setText(this.bSY.getPageContext().getString(i.h.to_the_end));
        this.bTn.setVisibility(8);
        this.bTl.setClickable(false);
        this.bTl.setOnClickListener(null);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bSY.getPageContext(), i);
        an.f(this.bSY.findViewById(i.f.container), i);
        an.f((TextView) this.bTj, i);
        an.e((TextView) this.bTj, i);
        an.e(this.bTp, i);
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.bTi.setDivider(new ColorDrawable(-13881543));
        } else {
            this.bTi.setDivider(new ColorDrawable(-1775893));
        }
        this.bTi.setDividerHeight(2);
        an.i(this.bTk, i.e.bg_black_banner_down);
        an.b(this.bTm, i.c.flist_text_color_day, 1);
        if (this.bSX) {
            this.bTn.setVisibility(8);
        } else {
            an.c(this.bTn, i.e.ico_downward);
        }
    }

    public void db(boolean z) {
        if (z) {
            this.mProgressBar.setVisibility(0);
        } else {
            this.mProgressBar.setVisibility(8);
        }
    }
}
