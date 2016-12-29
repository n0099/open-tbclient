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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.ac;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e {
    private TopRecActivity diM;
    private BdListView diW;
    private Button diX;
    private final View diY;
    private LinearLayout diZ;
    private TextView dja;
    private ImageView djb;
    private TextView djd;
    private Animation dje;
    private Animation djf;
    Handler mHandler;
    NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ac mPullView;
    private int djc = 0;
    private boolean diL = false;

    public e(TopRecActivity topRecActivity) {
        this.mHandler = null;
        this.diM = topRecActivity;
        this.mHandler = new Handler();
        this.diM.setContentView(r.h.top_recommended_activity);
        this.diW = (BdListView) this.diM.findViewById(r.g.top_list);
        this.mNavigationBar = (NavigationBar) topRecActivity.findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(topRecActivity.getPageContext().getString(r.j.top_recommended));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.nb_item_top_rec, (View.OnClickListener) null);
        this.diX = (Button) addCustomView.findViewById(r.g.title_finish);
        this.diX.setOnClickListener(this.diM);
        this.djd = (TextView) addCustomView.findViewById(r.g.title_finish_cover);
        this.mPullView = new ac(this.diM.getPageContext());
        this.diZ = (LinearLayout) LayoutInflater.from(topRecActivity.getPageContext().getPageActivity()).inflate(r.h.forum_list_forum_footer, (ViewGroup) null);
        this.diY = this.diZ.findViewById(r.g.footer_background);
        this.dja = (TextView) this.diZ.findViewById(r.g.footer_text);
        this.djb = (ImageView) this.diZ.findViewById(r.g.footer_icon);
        awO();
        this.dje = AnimationUtils.loadAnimation(this.diM.getPageContext().getPageActivity(), r.a.top_recommended_finish_a);
        this.djf = AnimationUtils.loadAnimation(this.diM.getPageContext().getPageActivity(), r.a.top_recommended_finish_b);
        this.dje.setAnimationListener(new f(this));
        this.djf.setAnimationListener(new g(this));
        this.diX.setText(String.valueOf(this.diM.getPageContext().getString(r.j.done)) + "(" + this.djc + ")");
        this.diW.setPullRefresh(this.mPullView);
        this.mProgressBar = (ProgressBar) this.diM.findViewById(r.g.loading);
    }

    public LinearLayout awM() {
        return this.diZ;
    }

    public Button awN() {
        return this.diX;
    }

    public void a(d dVar) {
        this.diW.setAdapter((ListAdapter) dVar);
    }

    public void b(z.b bVar) {
        this.mPullView.a(bVar);
    }

    public void ku() {
        this.diW.removeFooterView(this.diZ);
        this.diW.addFooterView(this.diZ);
        this.diW.l(2000L);
    }

    public void lK(int i) {
        this.diX.invalidate();
        if (this.djc < 100) {
            this.djd.setText(String.valueOf(this.diM.getPageContext().getString(r.j.done)) + "(" + this.djc + ")");
        } else {
            this.djd.setText(String.valueOf(this.diM.getPageContext().getString(r.j.done)) + "(99+)");
        }
        this.diX.setText(" ");
        this.djd.setVisibility(0);
        this.djd.setAnimation(this.dje);
        this.dje.start();
        this.djc = i;
    }

    public void awO() {
        this.dja.setText(this.diM.getPageContext().getString(r.j.flist_expand_list));
        ar.k(this.djb, r.f.ico_downward);
        this.diZ.setOnClickListener(this.diM);
    }

    public void awP() {
        this.dja.setText(this.diM.getPageContext().getString(r.j.to_the_end));
        this.djb.setVisibility(8);
        this.diZ.setClickable(false);
        this.diZ.setOnClickListener(null);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.diM.getPageContext(), i);
        ar.h(this.diM.findViewById(r.g.container), i);
        ar.f(this.diX, i);
        ar.e(this.diX, i);
        ar.e(this.djd, i);
        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            this.diW.setDivider(new ColorDrawable(-13881543));
        } else {
            this.diW.setDivider(new ColorDrawable(-1775893));
        }
        this.diW.setDividerHeight(2);
        ar.k(this.diY, r.f.bg_black_banner_down);
        ar.c(this.dja, r.d.common_color_10243, 1);
        if (this.diL) {
            this.djb.setVisibility(8);
        } else {
            ar.c(this.djb, r.f.ico_downward);
        }
    }

    public void fU(boolean z) {
        if (z) {
            this.mProgressBar.setVisibility(0);
        } else {
            this.mProgressBar.setVisibility(8);
        }
    }
}
