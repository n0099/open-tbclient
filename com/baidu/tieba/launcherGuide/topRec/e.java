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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class e {
    private TopRecActivity cjH;
    private BdListView cjR;
    private Button cjS;
    private final View cjT;
    private LinearLayout cjU;
    private TextView cjV;
    private ImageView cjW;
    private TextView cjY;
    private Animation cjZ;
    private Animation cka;
    Handler mHandler;
    NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private s mPullView;
    private int cjX = 0;
    private boolean cjG = false;

    public e(TopRecActivity topRecActivity) {
        this.mHandler = null;
        this.cjH = topRecActivity;
        this.mHandler = new Handler();
        this.cjH.setContentView(n.g.top_recommended_activity);
        this.cjR = (BdListView) this.cjH.findViewById(n.f.top_list);
        this.mNavigationBar = (NavigationBar) topRecActivity.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(topRecActivity.getPageContext().getString(n.i.top_recommended));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.nb_item_top_rec, (View.OnClickListener) null);
        this.cjS = (Button) addCustomView.findViewById(n.f.title_finish);
        this.cjS.setOnClickListener(this.cjH);
        this.cjY = (TextView) addCustomView.findViewById(n.f.title_finish_cover);
        this.mPullView = new s(this.cjH.getPageContext());
        this.cjU = (LinearLayout) LayoutInflater.from(topRecActivity.getPageContext().getPageActivity()).inflate(n.g.forum_list_forum_footer, (ViewGroup) null);
        this.cjT = this.cjU.findViewById(n.f.footer_background);
        this.cjV = (TextView) this.cjU.findViewById(n.f.footer_text);
        this.cjW = (ImageView) this.cjU.findViewById(n.f.footer_icon);
        aeT();
        this.cjZ = AnimationUtils.loadAnimation(this.cjH.getPageContext().getPageActivity(), n.a.top_recommended_finish_a);
        this.cka = AnimationUtils.loadAnimation(this.cjH.getPageContext().getPageActivity(), n.a.top_recommended_finish_b);
        this.cjZ.setAnimationListener(new f(this));
        this.cka.setAnimationListener(new g(this));
        this.cjS.setText(String.valueOf(this.cjH.getPageContext().getString(n.i.done)) + "(" + this.cjX + ")");
        this.cjR.setPullRefresh(this.mPullView);
        this.mProgressBar = (ProgressBar) this.cjH.findViewById(n.f.loading);
    }

    public LinearLayout aeR() {
        return this.cjU;
    }

    public Button aeS() {
        return this.cjS;
    }

    public void a(d dVar) {
        this.cjR.setAdapter((ListAdapter) dVar);
    }

    public void b(q.a aVar) {
        this.mPullView.a(aVar);
    }

    public void completePullRefresh() {
        this.cjR.removeFooterView(this.cjU);
        this.cjR.addFooterView(this.cjU);
        this.cjR.completePullRefresh();
    }

    public void jf(int i) {
        this.cjS.invalidate();
        if (this.cjX < 100) {
            this.cjY.setText(String.valueOf(this.cjH.getPageContext().getString(n.i.done)) + "(" + this.cjX + ")");
        } else {
            this.cjY.setText(String.valueOf(this.cjH.getPageContext().getString(n.i.done)) + "(99+)");
        }
        this.cjS.setText(" ");
        this.cjY.setVisibility(0);
        this.cjY.setAnimation(this.cjZ);
        this.cjZ.start();
        this.cjX = i;
    }

    public void aeT() {
        this.cjV.setText(this.cjH.getPageContext().getString(n.i.flist_expand_list));
        as.i(this.cjW, n.e.ico_downward);
        this.cjU.setOnClickListener(this.cjH);
    }

    public void aeU() {
        this.cjV.setText(this.cjH.getPageContext().getString(n.i.to_the_end));
        this.cjW.setVisibility(8);
        this.cjU.setClickable(false);
        this.cjU.setOnClickListener(null);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cjH.getPageContext(), i);
        as.f(this.cjH.findViewById(n.f.container), i);
        as.f((TextView) this.cjS, i);
        as.e((TextView) this.cjS, i);
        as.e(this.cjY, i);
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.cjR.setDivider(new ColorDrawable(-13881543));
        } else {
            this.cjR.setDivider(new ColorDrawable(-1775893));
        }
        this.cjR.setDividerHeight(2);
        as.i(this.cjT, n.e.bg_black_banner_down);
        as.b(this.cjV, n.c.flist_text_color_day, 1);
        if (this.cjG) {
            this.cjW.setVisibility(8);
        } else {
            as.c(this.cjW, n.e.ico_downward);
        }
    }

    public void dz(boolean z) {
        if (z) {
            this.mProgressBar.setVisibility(0);
        } else {
            this.mProgressBar.setVisibility(8);
        }
    }
}
