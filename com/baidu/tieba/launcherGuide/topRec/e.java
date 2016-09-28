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
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.y;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e {
    private Animation dAA;
    private Animation dAB;
    private TopRecActivity dAk;
    private BdListView dAs;
    private Button dAt;
    private final View dAu;
    private LinearLayout dAv;
    private TextView dAw;
    private ImageView dAx;
    private TextView dAz;
    Handler mHandler;
    NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ab mPullView;
    private int dAy = 0;
    private boolean dAj = false;

    public e(TopRecActivity topRecActivity) {
        this.mHandler = null;
        this.dAk = topRecActivity;
        this.mHandler = new Handler();
        this.dAk.setContentView(r.h.top_recommended_activity);
        this.dAs = (BdListView) this.dAk.findViewById(r.g.top_list);
        this.mNavigationBar = (NavigationBar) topRecActivity.findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(topRecActivity.getPageContext().getString(r.j.top_recommended));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.nb_item_top_rec, (View.OnClickListener) null);
        this.dAt = (Button) addCustomView.findViewById(r.g.title_finish);
        this.dAt.setOnClickListener(this.dAk);
        this.dAz = (TextView) addCustomView.findViewById(r.g.title_finish_cover);
        this.mPullView = new ab(this.dAk.getPageContext());
        this.dAv = (LinearLayout) LayoutInflater.from(topRecActivity.getPageContext().getPageActivity()).inflate(r.h.forum_list_forum_footer, (ViewGroup) null);
        this.dAu = this.dAv.findViewById(r.g.footer_background);
        this.dAw = (TextView) this.dAv.findViewById(r.g.footer_text);
        this.dAx = (ImageView) this.dAv.findViewById(r.g.footer_icon);
        aBF();
        this.dAA = AnimationUtils.loadAnimation(this.dAk.getPageContext().getPageActivity(), r.a.top_recommended_finish_a);
        this.dAB = AnimationUtils.loadAnimation(this.dAk.getPageContext().getPageActivity(), r.a.top_recommended_finish_b);
        this.dAA.setAnimationListener(new f(this));
        this.dAB.setAnimationListener(new g(this));
        this.dAt.setText(String.valueOf(this.dAk.getPageContext().getString(r.j.done)) + "(" + this.dAy + ")");
        this.dAs.setPullRefresh(this.mPullView);
        this.mProgressBar = (ProgressBar) this.dAk.findViewById(r.g.loading);
    }

    public LinearLayout aBD() {
        return this.dAv;
    }

    public Button aBE() {
        return this.dAt;
    }

    public void a(d dVar) {
        this.dAs.setAdapter((ListAdapter) dVar);
    }

    public void b(y.b bVar) {
        this.mPullView.a(bVar);
    }

    public void ku() {
        this.dAs.removeFooterView(this.dAv);
        this.dAs.addFooterView(this.dAv);
        this.dAs.l(2000L);
    }

    public void mF(int i) {
        this.dAt.invalidate();
        if (this.dAy < 100) {
            this.dAz.setText(String.valueOf(this.dAk.getPageContext().getString(r.j.done)) + "(" + this.dAy + ")");
        } else {
            this.dAz.setText(String.valueOf(this.dAk.getPageContext().getString(r.j.done)) + "(99+)");
        }
        this.dAt.setText(" ");
        this.dAz.setVisibility(0);
        this.dAz.setAnimation(this.dAA);
        this.dAA.start();
        this.dAy = i;
    }

    public void aBF() {
        this.dAw.setText(this.dAk.getPageContext().getString(r.j.flist_expand_list));
        av.k(this.dAx, r.f.ico_downward);
        this.dAv.setOnClickListener(this.dAk);
    }

    public void aBG() {
        this.dAw.setText(this.dAk.getPageContext().getString(r.j.to_the_end));
        this.dAx.setVisibility(8);
        this.dAv.setClickable(false);
        this.dAv.setOnClickListener(null);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.dAk.getPageContext(), i);
        av.h(this.dAk.findViewById(r.g.container), i);
        av.f(this.dAt, i);
        av.e(this.dAt, i);
        av.e(this.dAz, i);
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.dAs.setDivider(new ColorDrawable(-13881543));
        } else {
            this.dAs.setDivider(new ColorDrawable(-1775893));
        }
        this.dAs.setDividerHeight(2);
        av.k(this.dAu, r.f.bg_black_banner_down);
        av.c(this.dAw, r.d.common_color_10243, 1);
        if (this.dAj) {
            this.dAx.setVisibility(8);
        } else {
            av.c(this.dAx, r.f.ico_downward);
        }
    }

    public void fQ(boolean z) {
        if (z) {
            this.mProgressBar.setVisibility(0);
        } else {
            this.mProgressBar.setVisibility(8);
        }
    }
}
