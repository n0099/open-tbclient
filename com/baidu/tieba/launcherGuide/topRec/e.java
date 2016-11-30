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
import com.baidu.tbadk.core.view.ac;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e {
    private TopRecActivity dFO;
    private BdListView dFW;
    private Button dFX;
    private final View dFY;
    private LinearLayout dFZ;
    private TextView dGa;
    private ImageView dGb;
    private TextView dGd;
    private Animation dGe;
    private Animation dGf;
    Handler mHandler;
    NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ac mPullView;
    private int dGc = 0;
    private boolean dFN = false;

    public e(TopRecActivity topRecActivity) {
        this.mHandler = null;
        this.dFO = topRecActivity;
        this.mHandler = new Handler();
        this.dFO.setContentView(r.h.top_recommended_activity);
        this.dFW = (BdListView) this.dFO.findViewById(r.g.top_list);
        this.mNavigationBar = (NavigationBar) topRecActivity.findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(topRecActivity.getPageContext().getString(r.j.top_recommended));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.nb_item_top_rec, (View.OnClickListener) null);
        this.dFX = (Button) addCustomView.findViewById(r.g.title_finish);
        this.dFX.setOnClickListener(this.dFO);
        this.dGd = (TextView) addCustomView.findViewById(r.g.title_finish_cover);
        this.mPullView = new ac(this.dFO.getPageContext());
        this.dFZ = (LinearLayout) LayoutInflater.from(topRecActivity.getPageContext().getPageActivity()).inflate(r.h.forum_list_forum_footer, (ViewGroup) null);
        this.dFY = this.dFZ.findViewById(r.g.footer_background);
        this.dGa = (TextView) this.dFZ.findViewById(r.g.footer_text);
        this.dGb = (ImageView) this.dFZ.findViewById(r.g.footer_icon);
        aDB();
        this.dGe = AnimationUtils.loadAnimation(this.dFO.getPageContext().getPageActivity(), r.a.top_recommended_finish_a);
        this.dGf = AnimationUtils.loadAnimation(this.dFO.getPageContext().getPageActivity(), r.a.top_recommended_finish_b);
        this.dGe.setAnimationListener(new f(this));
        this.dGf.setAnimationListener(new g(this));
        this.dFX.setText(String.valueOf(this.dFO.getPageContext().getString(r.j.done)) + "(" + this.dGc + ")");
        this.dFW.setPullRefresh(this.mPullView);
        this.mProgressBar = (ProgressBar) this.dFO.findViewById(r.g.loading);
    }

    public LinearLayout aDz() {
        return this.dFZ;
    }

    public Button aDA() {
        return this.dFX;
    }

    public void a(d dVar) {
        this.dFW.setAdapter((ListAdapter) dVar);
    }

    public void b(z.b bVar) {
        this.mPullView.a(bVar);
    }

    public void ku() {
        this.dFW.removeFooterView(this.dFZ);
        this.dFW.addFooterView(this.dFZ);
        this.dFW.l(2000L);
    }

    public void mN(int i) {
        this.dFX.invalidate();
        if (this.dGc < 100) {
            this.dGd.setText(String.valueOf(this.dFO.getPageContext().getString(r.j.done)) + "(" + this.dGc + ")");
        } else {
            this.dGd.setText(String.valueOf(this.dFO.getPageContext().getString(r.j.done)) + "(99+)");
        }
        this.dFX.setText(" ");
        this.dGd.setVisibility(0);
        this.dGd.setAnimation(this.dGe);
        this.dGe.start();
        this.dGc = i;
    }

    public void aDB() {
        this.dGa.setText(this.dFO.getPageContext().getString(r.j.flist_expand_list));
        at.k(this.dGb, r.f.ico_downward);
        this.dFZ.setOnClickListener(this.dFO);
    }

    public void aDC() {
        this.dGa.setText(this.dFO.getPageContext().getString(r.j.to_the_end));
        this.dGb.setVisibility(8);
        this.dFZ.setClickable(false);
        this.dFZ.setOnClickListener(null);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.dFO.getPageContext(), i);
        at.h(this.dFO.findViewById(r.g.container), i);
        at.f(this.dFX, i);
        at.e(this.dFX, i);
        at.e(this.dGd, i);
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.dFW.setDivider(new ColorDrawable(-13881543));
        } else {
            this.dFW.setDivider(new ColorDrawable(-1775893));
        }
        this.dFW.setDividerHeight(2);
        at.k(this.dFY, r.f.bg_black_banner_down);
        at.c(this.dGa, r.d.common_color_10243, 1);
        if (this.dFN) {
            this.dGb.setVisibility(8);
        } else {
            at.c(this.dGb, r.f.ico_downward);
        }
    }

    public void gk(boolean z) {
        if (z) {
            this.mProgressBar.setVisibility(0);
        } else {
            this.mProgressBar.setVisibility(8);
        }
    }
}
