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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class e {
    private TopRecActivity bSN;
    private BdListView bSX;
    private Button bSY;
    private final View bSZ;
    private LinearLayout bTa;
    private TextView bTb;
    private ImageView bTc;
    private TextView bTe;
    private Animation bTf;
    private Animation bTg;
    Handler mHandler;
    NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private r mPullView;
    private int bTd = 0;
    private boolean bSM = false;

    public e(TopRecActivity topRecActivity) {
        this.mHandler = null;
        this.bSN = topRecActivity;
        this.mHandler = new Handler();
        this.bSN.setContentView(i.g.top_recommended_activity);
        this.bSX = (BdListView) this.bSN.findViewById(i.f.top_list);
        this.mNavigationBar = (NavigationBar) topRecActivity.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(topRecActivity.getPageContext().getString(i.h.top_recommended));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_top_rec, (View.OnClickListener) null);
        this.bSY = (Button) addCustomView.findViewById(i.f.title_finish);
        this.bSY.setOnClickListener(this.bSN);
        this.bTe = (TextView) addCustomView.findViewById(i.f.title_finish_cover);
        this.mPullView = new r(this.bSN.getPageContext());
        this.bTa = (LinearLayout) LayoutInflater.from(topRecActivity.getPageContext().getPageActivity()).inflate(i.g.forum_list_forum_footer, (ViewGroup) null);
        this.bSZ = this.bTa.findViewById(i.f.footer_background);
        this.bTb = (TextView) this.bTa.findViewById(i.f.footer_text);
        this.bTc = (ImageView) this.bTa.findViewById(i.f.footer_icon);
        aaW();
        this.bTf = AnimationUtils.loadAnimation(this.bSN.getPageContext().getPageActivity(), i.a.top_recommended_finish_a);
        this.bTg = AnimationUtils.loadAnimation(this.bSN.getPageContext().getPageActivity(), i.a.top_recommended_finish_b);
        this.bTf.setAnimationListener(new f(this));
        this.bTg.setAnimationListener(new g(this));
        this.bSY.setText(String.valueOf(this.bSN.getPageContext().getString(i.h.done)) + "(" + this.bTd + ")");
        this.bSX.setPullRefresh(this.mPullView);
        this.mProgressBar = (ProgressBar) this.bSN.findViewById(i.f.loading);
    }

    public LinearLayout aaU() {
        return this.bTa;
    }

    public Button aaV() {
        return this.bSY;
    }

    public void a(d dVar) {
        this.bSX.setAdapter((ListAdapter) dVar);
    }

    public void b(p.a aVar) {
        this.mPullView.a(aVar);
    }

    public void completePullRefresh() {
        this.bSX.removeFooterView(this.bTa);
        this.bSX.addFooterView(this.bTa);
        this.bSX.completePullRefresh();
    }

    public void hX(int i) {
        this.bSY.invalidate();
        if (this.bTd < 100) {
            this.bTe.setText(String.valueOf(this.bSN.getPageContext().getString(i.h.done)) + "(" + this.bTd + ")");
        } else {
            this.bTe.setText(String.valueOf(this.bSN.getPageContext().getString(i.h.done)) + "(99+)");
        }
        this.bSY.setText(" ");
        this.bTe.setVisibility(0);
        this.bTe.setAnimation(this.bTf);
        this.bTf.start();
        this.bTd = i;
    }

    public void aaW() {
        this.bTb.setText(this.bSN.getPageContext().getString(i.h.flist_expand_list));
        am.i(this.bTc, i.e.ico_downward);
        this.bTa.setOnClickListener(this.bSN);
    }

    public void aaX() {
        this.bTb.setText(this.bSN.getPageContext().getString(i.h.to_the_end));
        this.bTc.setVisibility(8);
        this.bTa.setClickable(false);
        this.bTa.setOnClickListener(null);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bSN.getPageContext(), i);
        am.f(this.bSN.findViewById(i.f.container), i);
        am.f((TextView) this.bSY, i);
        am.e((TextView) this.bSY, i);
        am.e(this.bTe, i);
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.bSX.setDivider(new ColorDrawable(-13881543));
        } else {
            this.bSX.setDivider(new ColorDrawable(-1775893));
        }
        this.bSX.setDividerHeight(2);
        am.i(this.bSZ, i.e.bg_black_banner_down);
        am.b(this.bTb, i.c.flist_text_color_day, 1);
        if (this.bSM) {
            this.bTc.setVisibility(8);
        } else {
            am.c(this.bTc, i.e.ico_downward);
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
