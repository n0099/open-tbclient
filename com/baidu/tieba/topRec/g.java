package com.baidu.tieba.topRec;

import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.View;
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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.ak;
import com.baidu.tieba.q;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class g {
    private TopRecActivity ccO;
    private BdListView ccT;
    private Button ccU;
    private final View ccV;
    private LinearLayout ccW;
    private TextView ccX;
    private ImageView ccY;
    private TextView cda;
    private Animation cdb;
    private Animation cdc;
    Handler mHandler;
    NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ak mPullView;
    private int ccZ = 0;
    private boolean ccN = false;

    public g(TopRecActivity topRecActivity) {
        this.mHandler = null;
        this.ccO = topRecActivity;
        this.mHandler = new Handler();
        this.ccO.setContentView(x.top_recommended_activity);
        this.ccT = (BdListView) this.ccO.findViewById(w.top_list);
        this.mNavigationBar = (NavigationBar) topRecActivity.findViewById(w.view_navigation_bar);
        this.mNavigationBar.setTitleText(topRecActivity.getPageContext().getString(z.top_recommended));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.nb_item_top_rec, (View.OnClickListener) null);
        this.ccU = (Button) addCustomView.findViewById(w.title_finish);
        this.ccU.setOnClickListener(this.ccO);
        this.cda = (TextView) addCustomView.findViewById(w.title_finish_cover);
        this.mPullView = new ak(this.ccO.getPageContext().getPageActivity());
        this.ccW = (LinearLayout) com.baidu.adp.lib.g.b.ek().inflate(topRecActivity.getPageContext().getPageActivity(), x.forum_list_forum_footer, null);
        this.ccV = this.ccW.findViewById(w.footer_background);
        this.ccX = (TextView) this.ccW.findViewById(w.footer_text);
        this.ccY = (ImageView) this.ccW.findViewById(w.footer_icon);
        ajC();
        this.cdb = AnimationUtils.loadAnimation(this.ccO.getPageContext().getPageActivity(), q.top_recommended_finish_a);
        this.cdc = AnimationUtils.loadAnimation(this.ccO.getPageContext().getPageActivity(), q.top_recommended_finish_b);
        this.cdb.setAnimationListener(new h(this));
        this.cdc.setAnimationListener(new i(this));
        this.ccU.setText(String.valueOf(this.ccO.getPageContext().getString(z.done)) + "(" + this.ccZ + ")");
        this.ccT.setPullRefresh(this.mPullView);
        this.mProgressBar = (ProgressBar) this.ccO.findViewById(w.loading);
    }

    public LinearLayout ajA() {
        return this.ccW;
    }

    public Button ajB() {
        return this.ccU;
    }

    public void a(e eVar) {
        this.ccT.setAdapter((ListAdapter) eVar);
    }

    public void b(com.baidu.adp.widget.ListView.g gVar) {
        this.mPullView.a(gVar);
    }

    public void jJ() {
        this.ccT.removeFooterView(this.ccW);
        this.ccT.addFooterView(this.ccW);
        this.ccT.jJ();
    }

    public void il(int i) {
        this.ccU.invalidate();
        if (this.ccZ < 100) {
            this.cda.setText(String.valueOf(this.ccO.getPageContext().getString(z.done)) + "(" + this.ccZ + ")");
        } else {
            this.cda.setText(String.valueOf(this.ccO.getPageContext().getString(z.done)) + "(99+)");
        }
        this.ccU.setText(" ");
        this.cda.setVisibility(0);
        this.cda.setAnimation(this.cdb);
        this.cdb.start();
        this.ccZ = i;
    }

    public void ajC() {
        this.ccX.setText(this.ccO.getPageContext().getString(z.flist_expand_list));
        ax.i(this.ccY, v.ico_downward);
        this.ccW.setOnClickListener(this.ccO);
    }

    public void ajD() {
        this.ccX.setText(this.ccO.getPageContext().getString(z.to_the_end));
        this.ccY.setVisibility(8);
        this.ccW.setClickable(false);
        this.ccW.setOnClickListener(null);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.ccO.getPageContext(), i);
        ax.f(this.ccO.findViewById(w.container), i);
        ax.f((TextView) this.ccU, i);
        ax.e((TextView) this.ccU, i);
        ax.e(this.cda, i);
        if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
            this.ccT.setDivider(new ColorDrawable(-13881543));
        } else {
            this.ccT.setDivider(new ColorDrawable(-1775893));
        }
        this.ccT.setDividerHeight(2);
        ax.i(this.ccV, v.bg_black_banner_down);
        ax.b(this.ccX, t.flist_text_color_day, 1);
        if (this.ccN) {
            this.ccY.setVisibility(8);
        } else {
            ax.c(this.ccY, v.ico_downward);
        }
    }

    public void cR(boolean z) {
        if (z) {
            this.mProgressBar.setVisibility(0);
        } else {
            this.mProgressBar.setVisibility(8);
        }
    }
}
