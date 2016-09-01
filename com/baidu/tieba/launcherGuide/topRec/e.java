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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e {
    private TopRecActivity dyT;
    private BdListView dzb;
    private Button dzc;
    private final View dzd;
    private LinearLayout dze;
    private TextView dzf;
    private ImageView dzg;
    private TextView dzi;
    private Animation dzj;
    private Animation dzk;
    Handler mHandler;
    NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private w mPullView;
    private int dzh = 0;
    private boolean dyS = false;

    public e(TopRecActivity topRecActivity) {
        this.mHandler = null;
        this.dyT = topRecActivity;
        this.mHandler = new Handler();
        this.dyT.setContentView(t.h.top_recommended_activity);
        this.dzb = (BdListView) this.dyT.findViewById(t.g.top_list);
        this.mNavigationBar = (NavigationBar) topRecActivity.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(topRecActivity.getPageContext().getString(t.j.top_recommended));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_top_rec, (View.OnClickListener) null);
        this.dzc = (Button) addCustomView.findViewById(t.g.title_finish);
        this.dzc.setOnClickListener(this.dyT);
        this.dzi = (TextView) addCustomView.findViewById(t.g.title_finish_cover);
        this.mPullView = new w(this.dyT.getPageContext());
        this.dze = (LinearLayout) LayoutInflater.from(topRecActivity.getPageContext().getPageActivity()).inflate(t.h.forum_list_forum_footer, (ViewGroup) null);
        this.dzd = this.dze.findViewById(t.g.footer_background);
        this.dzf = (TextView) this.dze.findViewById(t.g.footer_text);
        this.dzg = (ImageView) this.dze.findViewById(t.g.footer_icon);
        aBh();
        this.dzj = AnimationUtils.loadAnimation(this.dyT.getPageContext().getPageActivity(), t.a.top_recommended_finish_a);
        this.dzk = AnimationUtils.loadAnimation(this.dyT.getPageContext().getPageActivity(), t.a.top_recommended_finish_b);
        this.dzj.setAnimationListener(new f(this));
        this.dzk.setAnimationListener(new g(this));
        this.dzc.setText(String.valueOf(this.dyT.getPageContext().getString(t.j.done)) + "(" + this.dzh + ")");
        this.dzb.setPullRefresh(this.mPullView);
        this.mProgressBar = (ProgressBar) this.dyT.findViewById(t.g.loading);
    }

    public LinearLayout aBf() {
        return this.dze;
    }

    public Button aBg() {
        return this.dzc;
    }

    public void a(d dVar) {
        this.dzb.setAdapter((ListAdapter) dVar);
    }

    public void b(t.b bVar) {
        this.mPullView.a(bVar);
    }

    public void ku() {
        this.dzb.removeFooterView(this.dze);
        this.dzb.addFooterView(this.dze);
        this.dzb.l(2000L);
    }

    public void mx(int i) {
        this.dzc.invalidate();
        if (this.dzh < 100) {
            this.dzi.setText(String.valueOf(this.dyT.getPageContext().getString(t.j.done)) + "(" + this.dzh + ")");
        } else {
            this.dzi.setText(String.valueOf(this.dyT.getPageContext().getString(t.j.done)) + "(99+)");
        }
        this.dzc.setText(" ");
        this.dzi.setVisibility(0);
        this.dzi.setAnimation(this.dzj);
        this.dzj.start();
        this.dzh = i;
    }

    public void aBh() {
        this.dzf.setText(this.dyT.getPageContext().getString(t.j.flist_expand_list));
        av.k(this.dzg, t.f.ico_downward);
        this.dze.setOnClickListener(this.dyT);
    }

    public void aBi() {
        this.dzf.setText(this.dyT.getPageContext().getString(t.j.to_the_end));
        this.dzg.setVisibility(8);
        this.dze.setClickable(false);
        this.dze.setOnClickListener(null);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.dyT.getPageContext(), i);
        av.h(this.dyT.findViewById(t.g.container), i);
        av.f(this.dzc, i);
        av.e(this.dzc, i);
        av.e(this.dzi, i);
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.dzb.setDivider(new ColorDrawable(-13881543));
        } else {
            this.dzb.setDivider(new ColorDrawable(-1775893));
        }
        this.dzb.setDividerHeight(2);
        av.k(this.dzd, t.f.bg_black_banner_down);
        av.c(this.dzf, t.d.common_color_10243, 1);
        if (this.dyS) {
            this.dzg.setVisibility(8);
        } else {
            av.c(this.dzg, t.f.ico_downward);
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
