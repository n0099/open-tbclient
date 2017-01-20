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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ad;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e {
    private TopRecActivity dpW;
    private BdListView dqg;
    private Button dqh;
    private final View dqi;
    private LinearLayout dqj;
    private TextView dqk;
    private ImageView dql;
    private TextView dqn;
    private Animation dqo;
    private Animation dqp;
    Handler mHandler;
    NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ad mPullView;
    private int dqm = 0;
    private boolean dpV = false;

    public e(TopRecActivity topRecActivity) {
        this.mHandler = null;
        this.dpW = topRecActivity;
        this.mHandler = new Handler();
        this.dpW.setContentView(r.j.top_recommended_activity);
        this.dqg = (BdListView) this.dpW.findViewById(r.h.top_list);
        this.mNavigationBar = (NavigationBar) topRecActivity.findViewById(r.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(topRecActivity.getPageContext().getString(r.l.top_recommended));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.nb_item_top_rec, (View.OnClickListener) null);
        this.dqh = (Button) addCustomView.findViewById(r.h.title_finish);
        this.dqh.setOnClickListener(this.dpW);
        this.dqn = (TextView) addCustomView.findViewById(r.h.title_finish_cover);
        this.mPullView = new ad(this.dpW.getPageContext());
        this.dqj = (LinearLayout) LayoutInflater.from(topRecActivity.getPageContext().getPageActivity()).inflate(r.j.forum_list_forum_footer, (ViewGroup) null);
        this.dqi = this.dqj.findViewById(r.h.footer_background);
        this.dqk = (TextView) this.dqj.findViewById(r.h.footer_text);
        this.dql = (ImageView) this.dqj.findViewById(r.h.footer_icon);
        axV();
        this.dqo = AnimationUtils.loadAnimation(this.dpW.getPageContext().getPageActivity(), r.a.top_recommended_finish_a);
        this.dqp = AnimationUtils.loadAnimation(this.dpW.getPageContext().getPageActivity(), r.a.top_recommended_finish_b);
        this.dqo.setAnimationListener(new f(this));
        this.dqp.setAnimationListener(new g(this));
        this.dqh.setText(String.valueOf(this.dpW.getPageContext().getString(r.l.done)) + "(" + this.dqm + ")");
        this.dqg.setPullRefresh(this.mPullView);
        this.mProgressBar = (ProgressBar) this.dpW.findViewById(r.h.loading);
    }

    public LinearLayout axT() {
        return this.dqj;
    }

    public Button axU() {
        return this.dqh;
    }

    public void a(d dVar) {
        this.dqg.setAdapter((ListAdapter) dVar);
    }

    public void b(aa.b bVar) {
        this.mPullView.a(bVar);
    }

    public void completePullRefresh() {
        this.dqg.removeFooterView(this.dqj);
        this.dqg.addFooterView(this.dqj);
        this.dqg.completePullRefreshPostDelayed(2000L);
    }

    public void mx(int i) {
        this.dqh.invalidate();
        if (this.dqm < 100) {
            this.dqn.setText(String.valueOf(this.dpW.getPageContext().getString(r.l.done)) + "(" + this.dqm + ")");
        } else {
            this.dqn.setText(String.valueOf(this.dpW.getPageContext().getString(r.l.done)) + "(99+)");
        }
        this.dqh.setText(" ");
        this.dqn.setVisibility(0);
        this.dqn.setAnimation(this.dqo);
        this.dqo.start();
        this.dqm = i;
    }

    public void axV() {
        this.dqk.setText(this.dpW.getPageContext().getString(r.l.flist_expand_list));
        ap.j(this.dql, r.g.ico_downward);
        this.dqj.setOnClickListener(this.dpW);
    }

    public void axW() {
        this.dqk.setText(this.dpW.getPageContext().getString(r.l.to_the_end));
        this.dql.setVisibility(8);
        this.dqj.setClickable(false);
        this.dqj.setOnClickListener(null);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.dpW.getPageContext(), i);
        ap.g(this.dpW.findViewById(r.h.container), i);
        ap.f((TextView) this.dqh, i);
        ap.e(this.dqh, i);
        ap.e(this.dqn, i);
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.dqg.setDivider(new ColorDrawable(-13881543));
        } else {
            this.dqg.setDivider(new ColorDrawable(-1775893));
        }
        this.dqg.setDividerHeight(2);
        ap.j(this.dqi, r.g.bg_black_banner_down);
        ap.c(this.dqk, r.e.common_color_10243, 1);
        if (this.dpV) {
            this.dql.setVisibility(8);
        } else {
            ap.c(this.dql, r.g.ico_downward);
        }
    }

    public void fX(boolean z) {
        if (z) {
            this.mProgressBar.setVisibility(0);
        } else {
            this.mProgressBar.setVisibility(8);
        }
    }
}
