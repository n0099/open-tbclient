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
    private BdListView bTD;
    private Button bTE;
    private final View bTF;
    private LinearLayout bTG;
    private TextView bTH;
    private ImageView bTI;
    private TextView bTK;
    private Animation bTL;
    private Animation bTM;
    private TopRecActivity bTt;
    Handler mHandler;
    NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private r mPullView;
    private int bTJ = 0;
    private boolean bTs = false;

    public e(TopRecActivity topRecActivity) {
        this.mHandler = null;
        this.bTt = topRecActivity;
        this.mHandler = new Handler();
        this.bTt.setContentView(i.g.top_recommended_activity);
        this.bTD = (BdListView) this.bTt.findViewById(i.f.top_list);
        this.mNavigationBar = (NavigationBar) topRecActivity.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(topRecActivity.getPageContext().getString(i.h.top_recommended));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.nb_item_top_rec, (View.OnClickListener) null);
        this.bTE = (Button) addCustomView.findViewById(i.f.title_finish);
        this.bTE.setOnClickListener(this.bTt);
        this.bTK = (TextView) addCustomView.findViewById(i.f.title_finish_cover);
        this.mPullView = new r(this.bTt.getPageContext());
        this.bTG = (LinearLayout) LayoutInflater.from(topRecActivity.getPageContext().getPageActivity()).inflate(i.g.forum_list_forum_footer, (ViewGroup) null);
        this.bTF = this.bTG.findViewById(i.f.footer_background);
        this.bTH = (TextView) this.bTG.findViewById(i.f.footer_text);
        this.bTI = (ImageView) this.bTG.findViewById(i.f.footer_icon);
        abn();
        this.bTL = AnimationUtils.loadAnimation(this.bTt.getPageContext().getPageActivity(), i.a.top_recommended_finish_a);
        this.bTM = AnimationUtils.loadAnimation(this.bTt.getPageContext().getPageActivity(), i.a.top_recommended_finish_b);
        this.bTL.setAnimationListener(new f(this));
        this.bTM.setAnimationListener(new g(this));
        this.bTE.setText(String.valueOf(this.bTt.getPageContext().getString(i.h.done)) + "(" + this.bTJ + ")");
        this.bTD.setPullRefresh(this.mPullView);
        this.mProgressBar = (ProgressBar) this.bTt.findViewById(i.f.loading);
    }

    public LinearLayout abl() {
        return this.bTG;
    }

    public Button abm() {
        return this.bTE;
    }

    public void a(d dVar) {
        this.bTD.setAdapter((ListAdapter) dVar);
    }

    public void b(p.a aVar) {
        this.mPullView.a(aVar);
    }

    public void completePullRefresh() {
        this.bTD.removeFooterView(this.bTG);
        this.bTD.addFooterView(this.bTG);
        this.bTD.completePullRefresh();
    }

    public void il(int i) {
        this.bTE.invalidate();
        if (this.bTJ < 100) {
            this.bTK.setText(String.valueOf(this.bTt.getPageContext().getString(i.h.done)) + "(" + this.bTJ + ")");
        } else {
            this.bTK.setText(String.valueOf(this.bTt.getPageContext().getString(i.h.done)) + "(99+)");
        }
        this.bTE.setText(" ");
        this.bTK.setVisibility(0);
        this.bTK.setAnimation(this.bTL);
        this.bTL.start();
        this.bTJ = i;
    }

    public void abn() {
        this.bTH.setText(this.bTt.getPageContext().getString(i.h.flist_expand_list));
        an.i(this.bTI, i.e.ico_downward);
        this.bTG.setOnClickListener(this.bTt);
    }

    public void abo() {
        this.bTH.setText(this.bTt.getPageContext().getString(i.h.to_the_end));
        this.bTI.setVisibility(8);
        this.bTG.setClickable(false);
        this.bTG.setOnClickListener(null);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bTt.getPageContext(), i);
        an.f(this.bTt.findViewById(i.f.container), i);
        an.f((TextView) this.bTE, i);
        an.e((TextView) this.bTE, i);
        an.e(this.bTK, i);
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.bTD.setDivider(new ColorDrawable(-13881543));
        } else {
            this.bTD.setDivider(new ColorDrawable(-1775893));
        }
        this.bTD.setDividerHeight(2);
        an.i(this.bTF, i.e.bg_black_banner_down);
        an.b(this.bTH, i.c.flist_text_color_day, 1);
        if (this.bTs) {
            this.bTI.setVisibility(8);
        } else {
            an.c(this.bTI, i.e.ico_downward);
        }
    }

    public void dd(boolean z) {
        if (z) {
            this.mProgressBar.setVisibility(0);
        } else {
            this.mProgressBar.setVisibility(8);
        }
    }
}
