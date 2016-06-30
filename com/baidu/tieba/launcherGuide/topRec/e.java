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
    private TextView dkB;
    private Animation dkC;
    private Animation dkD;
    private TopRecActivity dkm;
    private BdListView dku;
    private Button dkv;
    private final View dkw;
    private LinearLayout dkx;
    private TextView dky;
    private ImageView dkz;
    Handler mHandler;
    NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private w mPullView;
    private int dkA = 0;
    private boolean dkl = false;

    public e(TopRecActivity topRecActivity) {
        this.mHandler = null;
        this.dkm = topRecActivity;
        this.mHandler = new Handler();
        this.dkm.setContentView(u.h.top_recommended_activity);
        this.dku = (BdListView) this.dkm.findViewById(u.g.top_list);
        this.mNavigationBar = (NavigationBar) topRecActivity.findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(topRecActivity.getPageContext().getString(u.j.top_recommended));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.nb_item_top_rec, (View.OnClickListener) null);
        this.dkv = (Button) addCustomView.findViewById(u.g.title_finish);
        this.dkv.setOnClickListener(this.dkm);
        this.dkB = (TextView) addCustomView.findViewById(u.g.title_finish_cover);
        this.mPullView = new w(this.dkm.getPageContext());
        this.dkx = (LinearLayout) LayoutInflater.from(topRecActivity.getPageContext().getPageActivity()).inflate(u.h.forum_list_forum_footer, (ViewGroup) null);
        this.dkw = this.dkx.findViewById(u.g.footer_background);
        this.dky = (TextView) this.dkx.findViewById(u.g.footer_text);
        this.dkz = (ImageView) this.dkx.findViewById(u.g.footer_icon);
        avI();
        this.dkC = AnimationUtils.loadAnimation(this.dkm.getPageContext().getPageActivity(), u.a.top_recommended_finish_a);
        this.dkD = AnimationUtils.loadAnimation(this.dkm.getPageContext().getPageActivity(), u.a.top_recommended_finish_b);
        this.dkC.setAnimationListener(new f(this));
        this.dkD.setAnimationListener(new g(this));
        this.dkv.setText(String.valueOf(this.dkm.getPageContext().getString(u.j.done)) + "(" + this.dkA + ")");
        this.dku.setPullRefresh(this.mPullView);
        this.mProgressBar = (ProgressBar) this.dkm.findViewById(u.g.loading);
    }

    public LinearLayout avG() {
        return this.dkx;
    }

    public Button avH() {
        return this.dkv;
    }

    public void a(d dVar) {
        this.dku.setAdapter((ListAdapter) dVar);
    }

    public void b(t.b bVar) {
        this.mPullView.a(bVar);
    }

    public void jA() {
        this.dku.removeFooterView(this.dkx);
        this.dku.addFooterView(this.dkx);
        this.dku.k(2000L);
    }

    public void lO(int i) {
        this.dkv.invalidate();
        if (this.dkA < 100) {
            this.dkB.setText(String.valueOf(this.dkm.getPageContext().getString(u.j.done)) + "(" + this.dkA + ")");
        } else {
            this.dkB.setText(String.valueOf(this.dkm.getPageContext().getString(u.j.done)) + "(99+)");
        }
        this.dkv.setText(" ");
        this.dkB.setVisibility(0);
        this.dkB.setAnimation(this.dkC);
        this.dkC.start();
        this.dkA = i;
    }

    public void avI() {
        this.dky.setText(this.dkm.getPageContext().getString(u.j.flist_expand_list));
        av.k(this.dkz, u.f.ico_downward);
        this.dkx.setOnClickListener(this.dkm);
    }

    public void avJ() {
        this.dky.setText(this.dkm.getPageContext().getString(u.j.to_the_end));
        this.dkz.setVisibility(8);
        this.dkx.setClickable(false);
        this.dkx.setOnClickListener(null);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.dkm.getPageContext(), i);
        av.h(this.dkm.findViewById(u.g.container), i);
        av.f(this.dkv, i);
        av.e(this.dkv, i);
        av.e(this.dkB, i);
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.dku.setDivider(new ColorDrawable(-13881543));
        } else {
            this.dku.setDivider(new ColorDrawable(-1775893));
        }
        this.dku.setDividerHeight(2);
        av.k(this.dkw, u.f.bg_black_banner_down);
        av.c(this.dky, u.d.common_color_10243, 1);
        if (this.dkl) {
            this.dkz.setVisibility(8);
        } else {
            av.c(this.dkz, u.f.ico_downward);
        }
    }

    public void fp(boolean z) {
        if (z) {
            this.mProgressBar.setVisibility(0);
        } else {
            this.mProgressBar.setVisibility(8);
        }
    }
}
