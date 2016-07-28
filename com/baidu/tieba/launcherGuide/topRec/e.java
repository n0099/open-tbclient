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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.core.view.w;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e {
    private TextView dnA;
    private Animation dnB;
    private Animation dnC;
    private TopRecActivity dnl;
    private BdListView dnt;
    private Button dnu;
    private final View dnv;
    private LinearLayout dnw;
    private TextView dnx;
    private ImageView dny;
    Handler mHandler;
    NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private w mPullView;
    private int dnz = 0;
    private boolean dnk = false;

    public e(TopRecActivity topRecActivity) {
        this.mHandler = null;
        this.dnl = topRecActivity;
        this.mHandler = new Handler();
        this.dnl.setContentView(u.h.top_recommended_activity);
        this.dnt = (BdListView) this.dnl.findViewById(u.g.top_list);
        this.mNavigationBar = (NavigationBar) topRecActivity.findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(topRecActivity.getPageContext().getString(u.j.top_recommended));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.nb_item_top_rec, (View.OnClickListener) null);
        this.dnu = (Button) addCustomView.findViewById(u.g.title_finish);
        this.dnu.setOnClickListener(this.dnl);
        this.dnA = (TextView) addCustomView.findViewById(u.g.title_finish_cover);
        this.mPullView = new w(this.dnl.getPageContext());
        this.dnw = (LinearLayout) LayoutInflater.from(topRecActivity.getPageContext().getPageActivity()).inflate(u.h.forum_list_forum_footer, (ViewGroup) null);
        this.dnv = this.dnw.findViewById(u.g.footer_background);
        this.dnx = (TextView) this.dnw.findViewById(u.g.footer_text);
        this.dny = (ImageView) this.dnw.findViewById(u.g.footer_icon);
        awu();
        this.dnB = AnimationUtils.loadAnimation(this.dnl.getPageContext().getPageActivity(), u.a.top_recommended_finish_a);
        this.dnC = AnimationUtils.loadAnimation(this.dnl.getPageContext().getPageActivity(), u.a.top_recommended_finish_b);
        this.dnB.setAnimationListener(new f(this));
        this.dnC.setAnimationListener(new g(this));
        this.dnu.setText(String.valueOf(this.dnl.getPageContext().getString(u.j.done)) + "(" + this.dnz + ")");
        this.dnt.setPullRefresh(this.mPullView);
        this.mProgressBar = (ProgressBar) this.dnl.findViewById(u.g.loading);
    }

    public LinearLayout aws() {
        return this.dnw;
    }

    public Button awt() {
        return this.dnu;
    }

    public void a(d dVar) {
        this.dnt.setAdapter((ListAdapter) dVar);
    }

    public void b(t.b bVar) {
        this.mPullView.a(bVar);
    }

    public void jz() {
        this.dnt.removeFooterView(this.dnw);
        this.dnt.addFooterView(this.dnw);
        this.dnt.l(2000L);
    }

    public void lU(int i) {
        this.dnu.invalidate();
        if (this.dnz < 100) {
            this.dnA.setText(String.valueOf(this.dnl.getPageContext().getString(u.j.done)) + "(" + this.dnz + ")");
        } else {
            this.dnA.setText(String.valueOf(this.dnl.getPageContext().getString(u.j.done)) + "(99+)");
        }
        this.dnu.setText(" ");
        this.dnA.setVisibility(0);
        this.dnA.setAnimation(this.dnB);
        this.dnB.start();
        this.dnz = i;
    }

    public void awu() {
        this.dnx.setText(this.dnl.getPageContext().getString(u.j.flist_expand_list));
        av.k(this.dny, u.f.ico_downward);
        this.dnw.setOnClickListener(this.dnl);
    }

    public void awv() {
        this.dnx.setText(this.dnl.getPageContext().getString(u.j.to_the_end));
        this.dny.setVisibility(8);
        this.dnw.setClickable(false);
        this.dnw.setOnClickListener(null);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.dnl.getPageContext(), i);
        av.h(this.dnl.findViewById(u.g.container), i);
        av.f(this.dnu, i);
        av.e(this.dnu, i);
        av.e(this.dnA, i);
        if (TbadkCoreApplication.m10getInst().getSkinType() == 1) {
            this.dnt.setDivider(new ColorDrawable(-13881543));
        } else {
            this.dnt.setDivider(new ColorDrawable(-1775893));
        }
        this.dnt.setDividerHeight(2);
        av.k(this.dnv, u.f.bg_black_banner_down);
        av.c(this.dnx, u.d.common_color_10243, 1);
        if (this.dnk) {
            this.dny.setVisibility(8);
        } else {
            av.c(this.dny, u.f.ico_downward);
        }
    }

    public void fr(boolean z) {
        if (z) {
            this.mProgressBar.setVisibility(0);
        } else {
            this.mProgressBar.setVisibility(8);
        }
    }
}
