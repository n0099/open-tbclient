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
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.core.view.w;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e {
    private TopRecActivity cEM;
    private BdListView cEW;
    private Button cEX;
    private final View cEY;
    private LinearLayout cEZ;
    private TextView cFa;
    private ImageView cFb;
    private TextView cFd;
    private Animation cFe;
    private Animation cFf;
    Handler mHandler;
    NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private w mPullView;
    private int cFc = 0;
    private boolean cEL = false;

    public e(TopRecActivity topRecActivity) {
        this.mHandler = null;
        this.cEM = topRecActivity;
        this.mHandler = new Handler();
        this.cEM.setContentView(t.h.top_recommended_activity);
        this.cEW = (BdListView) this.cEM.findViewById(t.g.top_list);
        this.mNavigationBar = (NavigationBar) topRecActivity.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(topRecActivity.getPageContext().getString(t.j.top_recommended));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_top_rec, (View.OnClickListener) null);
        this.cEX = (Button) addCustomView.findViewById(t.g.title_finish);
        this.cEX.setOnClickListener(this.cEM);
        this.cFd = (TextView) addCustomView.findViewById(t.g.title_finish_cover);
        this.mPullView = new w(this.cEM.getPageContext());
        this.cEZ = (LinearLayout) LayoutInflater.from(topRecActivity.getPageContext().getPageActivity()).inflate(t.h.forum_list_forum_footer, (ViewGroup) null);
        this.cEY = this.cEZ.findViewById(t.g.footer_background);
        this.cFa = (TextView) this.cEZ.findViewById(t.g.footer_text);
        this.cFb = (ImageView) this.cEZ.findViewById(t.g.footer_icon);
        ant();
        this.cFe = AnimationUtils.loadAnimation(this.cEM.getPageContext().getPageActivity(), t.a.top_recommended_finish_a);
        this.cFf = AnimationUtils.loadAnimation(this.cEM.getPageContext().getPageActivity(), t.a.top_recommended_finish_b);
        this.cFe.setAnimationListener(new f(this));
        this.cFf.setAnimationListener(new g(this));
        this.cEX.setText(String.valueOf(this.cEM.getPageContext().getString(t.j.done)) + "(" + this.cFc + ")");
        this.cEW.setPullRefresh(this.mPullView);
        this.mProgressBar = (ProgressBar) this.cEM.findViewById(t.g.loading);
    }

    public LinearLayout anr() {
        return this.cEZ;
    }

    public Button ans() {
        return this.cEX;
    }

    public void a(d dVar) {
        this.cEW.setAdapter((ListAdapter) dVar);
    }

    public void b(t.b bVar) {
        this.mPullView.a(bVar);
    }

    public void jx() {
        this.cEW.removeFooterView(this.cEZ);
        this.cEW.addFooterView(this.cEZ);
        this.cEW.k(2000L);
    }

    public void kn(int i) {
        this.cEX.invalidate();
        if (this.cFc < 100) {
            this.cFd.setText(String.valueOf(this.cEM.getPageContext().getString(t.j.done)) + "(" + this.cFc + ")");
        } else {
            this.cFd.setText(String.valueOf(this.cEM.getPageContext().getString(t.j.done)) + "(99+)");
        }
        this.cEX.setText(" ");
        this.cFd.setVisibility(0);
        this.cFd.setAnimation(this.cFe);
        this.cFe.start();
        this.cFc = i;
    }

    public void ant() {
        this.cFa.setText(this.cEM.getPageContext().getString(t.j.flist_expand_list));
        at.k(this.cFb, t.f.ico_downward);
        this.cEZ.setOnClickListener(this.cEM);
    }

    public void anu() {
        this.cFa.setText(this.cEM.getPageContext().getString(t.j.to_the_end));
        this.cFb.setVisibility(8);
        this.cEZ.setClickable(false);
        this.cEZ.setOnClickListener(null);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cEM.getPageContext(), i);
        at.h(this.cEM.findViewById(t.g.container), i);
        at.f(this.cEX, i);
        at.e(this.cEX, i);
        at.e(this.cFd, i);
        if (TbadkCoreApplication.m11getInst().getSkinType() == 1) {
            this.cEW.setDivider(new ColorDrawable(-13881543));
        } else {
            this.cEW.setDivider(new ColorDrawable(-1775893));
        }
        this.cEW.setDividerHeight(2);
        at.k(this.cEY, t.f.bg_black_banner_down);
        at.c(this.cFa, t.d.flist_text_color_day, 1);
        if (this.cEL) {
            this.cFb.setVisibility(8);
        } else {
            at.c(this.cFb, t.f.ico_downward);
        }
    }

    public void eB(boolean z) {
        if (z) {
            this.mProgressBar.setVisibility(0);
        } else {
            this.mProgressBar.setVisibility(8);
        }
    }
}
