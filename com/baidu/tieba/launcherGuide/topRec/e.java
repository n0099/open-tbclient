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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.core.view.u;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e {
    private TopRecActivity cEU;
    private BdListView cFd;
    private Button cFe;
    private final View cFf;
    private LinearLayout cFg;
    private TextView cFh;
    private ImageView cFi;
    private TextView cFk;
    private Animation cFl;
    private Animation cFm;
    Handler mHandler;
    NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private u mPullView;
    private int cFj = 0;
    private boolean cET = false;

    public e(TopRecActivity topRecActivity) {
        this.mHandler = null;
        this.cEU = topRecActivity;
        this.mHandler = new Handler();
        this.cEU.setContentView(t.h.top_recommended_activity);
        this.cFd = (BdListView) this.cEU.findViewById(t.g.top_list);
        this.mNavigationBar = (NavigationBar) topRecActivity.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(topRecActivity.getPageContext().getString(t.j.top_recommended));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_top_rec, (View.OnClickListener) null);
        this.cFe = (Button) addCustomView.findViewById(t.g.title_finish);
        this.cFe.setOnClickListener(this.cEU);
        this.cFk = (TextView) addCustomView.findViewById(t.g.title_finish_cover);
        this.mPullView = new u(this.cEU.getPageContext());
        this.cFg = (LinearLayout) LayoutInflater.from(topRecActivity.getPageContext().getPageActivity()).inflate(t.h.forum_list_forum_footer, (ViewGroup) null);
        this.cFf = this.cFg.findViewById(t.g.footer_background);
        this.cFh = (TextView) this.cFg.findViewById(t.g.footer_text);
        this.cFi = (ImageView) this.cFg.findViewById(t.g.footer_icon);
        anx();
        this.cFl = AnimationUtils.loadAnimation(this.cEU.getPageContext().getPageActivity(), t.a.top_recommended_finish_a);
        this.cFm = AnimationUtils.loadAnimation(this.cEU.getPageContext().getPageActivity(), t.a.top_recommended_finish_b);
        this.cFl.setAnimationListener(new f(this));
        this.cFm.setAnimationListener(new g(this));
        this.cFe.setText(String.valueOf(this.cEU.getPageContext().getString(t.j.done)) + "(" + this.cFj + ")");
        this.cFd.setPullRefresh(this.mPullView);
        this.mProgressBar = (ProgressBar) this.cEU.findViewById(t.g.loading);
    }

    public LinearLayout anv() {
        return this.cFg;
    }

    public Button anw() {
        return this.cFe;
    }

    public void a(d dVar) {
        this.cFd.setAdapter((ListAdapter) dVar);
    }

    public void b(s.a aVar) {
        this.mPullView.a(aVar);
    }

    public void nj() {
        this.cFd.removeFooterView(this.cFg);
        this.cFd.addFooterView(this.cFg);
        this.cFd.nj();
    }

    public void kI(int i) {
        this.cFe.invalidate();
        if (this.cFj < 100) {
            this.cFk.setText(String.valueOf(this.cEU.getPageContext().getString(t.j.done)) + "(" + this.cFj + ")");
        } else {
            this.cFk.setText(String.valueOf(this.cEU.getPageContext().getString(t.j.done)) + "(99+)");
        }
        this.cFe.setText(" ");
        this.cFk.setVisibility(0);
        this.cFk.setAnimation(this.cFl);
        this.cFl.start();
        this.cFj = i;
    }

    public void anx() {
        this.cFh.setText(this.cEU.getPageContext().getString(t.j.flist_expand_list));
        at.k(this.cFi, t.f.ico_downward);
        this.cFg.setOnClickListener(this.cEU);
    }

    public void any() {
        this.cFh.setText(this.cEU.getPageContext().getString(t.j.to_the_end));
        this.cFi.setVisibility(8);
        this.cFg.setClickable(false);
        this.cFg.setOnClickListener(null);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cEU.getPageContext(), i);
        at.h(this.cEU.findViewById(t.g.container), i);
        at.f(this.cFe, i);
        at.e(this.cFe, i);
        at.e(this.cFk, i);
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.cFd.setDivider(new ColorDrawable(-13881543));
        } else {
            this.cFd.setDivider(new ColorDrawable(-1775893));
        }
        this.cFd.setDividerHeight(2);
        at.k(this.cFf, t.f.bg_black_banner_down);
        at.b(this.cFh, t.d.flist_text_color_day, 1);
        if (this.cET) {
            this.cFi.setVisibility(8);
        } else {
            at.c(this.cFi, t.f.ico_downward);
        }
    }

    public void ea(boolean z) {
        if (z) {
            this.mProgressBar.setVisibility(0);
        } else {
            this.mProgressBar.setVisibility(8);
        }
    }
}
