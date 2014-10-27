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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.y;
import com.baidu.tieba.p;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class g {
    private y Yc;
    private BdListView bPE;
    private Button bPF;
    private final View bPG;
    private LinearLayout bPH;
    private TextView bPI;
    private ImageView bPJ;
    private TextView bPL;
    private Animation bPM;
    private Animation bPN;
    private TopRecActivity bPz;
    Handler mHandler;
    NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private int bPK = 0;
    private boolean bPy = false;

    public g(TopRecActivity topRecActivity) {
        this.mHandler = null;
        this.bPz = topRecActivity;
        this.mHandler = new Handler();
        this.bPz.setContentView(w.top_recommended_activity);
        this.bPE = (BdListView) this.bPz.findViewById(v.top_list);
        this.mNavigationBar = (NavigationBar) topRecActivity.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(topRecActivity.getString(com.baidu.tieba.y.top_recommended));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.nb_item_top_rec, (View.OnClickListener) null);
        this.bPF = (Button) addCustomView.findViewById(v.title_finish);
        this.bPF.setOnClickListener(this.bPz);
        this.bPL = (TextView) addCustomView.findViewById(v.title_finish_cover);
        this.Yc = new y(this.bPz);
        this.bPH = (LinearLayout) com.baidu.adp.lib.g.b.ek().inflate(topRecActivity, w.forum_list_forum_footer, null);
        this.bPG = this.bPH.findViewById(v.footer_background);
        this.bPI = (TextView) this.bPH.findViewById(v.footer_text);
        this.bPJ = (ImageView) this.bPH.findViewById(v.footer_icon);
        aev();
        this.bPM = AnimationUtils.loadAnimation(this.bPz, p.top_recommended_finish_a);
        this.bPN = AnimationUtils.loadAnimation(this.bPz, p.top_recommended_finish_b);
        this.bPM.setAnimationListener(new h(this));
        this.bPN.setAnimationListener(new i(this));
        this.bPF.setText(String.valueOf(this.bPz.getString(com.baidu.tieba.y.done)) + "(" + this.bPK + ")");
        this.bPE.setPullRefresh(this.Yc);
        this.mProgressBar = (ProgressBar) this.bPz.findViewById(v.loading);
    }

    public LinearLayout aet() {
        return this.bPH;
    }

    public Button aeu() {
        return this.bPF;
    }

    public void a(e eVar) {
        this.bPE.setAdapter((ListAdapter) eVar);
    }

    public void b(com.baidu.adp.widget.ListView.f fVar) {
        this.Yc.a(fVar);
    }

    public void hN() {
        this.bPE.removeFooterView(this.bPH);
        this.bPE.addFooterView(this.bPH);
        this.bPE.hN();
    }

    public void hv(int i) {
        this.bPF.invalidate();
        if (this.bPK < 100) {
            this.bPL.setText(String.valueOf(this.bPz.getString(com.baidu.tieba.y.done)) + "(" + this.bPK + ")");
        } else {
            this.bPL.setText(String.valueOf(this.bPz.getString(com.baidu.tieba.y.done)) + "(99+)");
        }
        this.bPF.setText(" ");
        this.bPL.setVisibility(0);
        this.bPL.setAnimation(this.bPM);
        this.bPM.start();
        this.bPK = i;
    }

    public void aev() {
        this.bPI.setText(this.bPz.getString(com.baidu.tieba.y.flist_expand_list));
        aw.h(this.bPJ, u.ico_downward);
        this.bPH.setOnClickListener(this.bPz);
    }

    public void aew() {
        this.bPI.setText(this.bPz.getString(com.baidu.tieba.y.to_the_end));
        this.bPJ.setVisibility(8);
        this.bPH.setClickable(false);
        this.bPH.setOnClickListener(null);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        aw.e(this.bPz.findViewById(v.container), i);
        aw.e((TextView) this.bPF, i);
        aw.d((TextView) this.bPF, i);
        aw.d(this.bPL, i);
        if (TbadkApplication.m251getInst().getSkinType() == 1) {
            this.bPE.setDivider(new ColorDrawable(-13881543));
        } else {
            this.bPE.setDivider(new ColorDrawable(-1775893));
        }
        this.bPE.setDividerHeight(2);
        aw.h(this.bPG, u.bg_black_banner_down);
        aw.b(this.bPI, s.flist_text_color_day, 1);
        if (this.bPy) {
            this.bPJ.setVisibility(8);
        } else {
            aw.c(this.bPJ, u.ico_downward);
        }
    }

    public void da(boolean z) {
        if (z) {
            this.mProgressBar.setVisibility(0);
        } else {
            this.mProgressBar.setVisibility(8);
        }
    }
}
