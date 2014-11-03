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
    private y Yg;
    private TopRecActivity bPO;
    private BdListView bPT;
    private Button bPU;
    private final View bPV;
    private LinearLayout bPW;
    private TextView bPX;
    private ImageView bPY;
    private TextView bQa;
    private Animation bQb;
    private Animation bQc;
    Handler mHandler;
    NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private int bPZ = 0;
    private boolean bPN = false;

    public g(TopRecActivity topRecActivity) {
        this.mHandler = null;
        this.bPO = topRecActivity;
        this.mHandler = new Handler();
        this.bPO.setContentView(w.top_recommended_activity);
        this.bPT = (BdListView) this.bPO.findViewById(v.top_list);
        this.mNavigationBar = (NavigationBar) topRecActivity.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(topRecActivity.getString(com.baidu.tieba.y.top_recommended));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.nb_item_top_rec, (View.OnClickListener) null);
        this.bPU = (Button) addCustomView.findViewById(v.title_finish);
        this.bPU.setOnClickListener(this.bPO);
        this.bQa = (TextView) addCustomView.findViewById(v.title_finish_cover);
        this.Yg = new y(this.bPO);
        this.bPW = (LinearLayout) com.baidu.adp.lib.g.b.ek().inflate(topRecActivity, w.forum_list_forum_footer, null);
        this.bPV = this.bPW.findViewById(v.footer_background);
        this.bPX = (TextView) this.bPW.findViewById(v.footer_text);
        this.bPY = (ImageView) this.bPW.findViewById(v.footer_icon);
        aey();
        this.bQb = AnimationUtils.loadAnimation(this.bPO, p.top_recommended_finish_a);
        this.bQc = AnimationUtils.loadAnimation(this.bPO, p.top_recommended_finish_b);
        this.bQb.setAnimationListener(new h(this));
        this.bQc.setAnimationListener(new i(this));
        this.bPU.setText(String.valueOf(this.bPO.getString(com.baidu.tieba.y.done)) + "(" + this.bPZ + ")");
        this.bPT.setPullRefresh(this.Yg);
        this.mProgressBar = (ProgressBar) this.bPO.findViewById(v.loading);
    }

    public LinearLayout aew() {
        return this.bPW;
    }

    public Button aex() {
        return this.bPU;
    }

    public void a(e eVar) {
        this.bPT.setAdapter((ListAdapter) eVar);
    }

    public void b(com.baidu.adp.widget.ListView.f fVar) {
        this.Yg.a(fVar);
    }

    public void hN() {
        this.bPT.removeFooterView(this.bPW);
        this.bPT.addFooterView(this.bPW);
        this.bPT.hN();
    }

    public void hv(int i) {
        this.bPU.invalidate();
        if (this.bPZ < 100) {
            this.bQa.setText(String.valueOf(this.bPO.getString(com.baidu.tieba.y.done)) + "(" + this.bPZ + ")");
        } else {
            this.bQa.setText(String.valueOf(this.bPO.getString(com.baidu.tieba.y.done)) + "(99+)");
        }
        this.bPU.setText(" ");
        this.bQa.setVisibility(0);
        this.bQa.setAnimation(this.bQb);
        this.bQb.start();
        this.bPZ = i;
    }

    public void aey() {
        this.bPX.setText(this.bPO.getString(com.baidu.tieba.y.flist_expand_list));
        aw.h(this.bPY, u.ico_downward);
        this.bPW.setOnClickListener(this.bPO);
    }

    public void aez() {
        this.bPX.setText(this.bPO.getString(com.baidu.tieba.y.to_the_end));
        this.bPY.setVisibility(8);
        this.bPW.setClickable(false);
        this.bPW.setOnClickListener(null);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(i);
        aw.e(this.bPO.findViewById(v.container), i);
        aw.e((TextView) this.bPU, i);
        aw.d((TextView) this.bPU, i);
        aw.d(this.bQa, i);
        if (TbadkApplication.m251getInst().getSkinType() == 1) {
            this.bPT.setDivider(new ColorDrawable(-13881543));
        } else {
            this.bPT.setDivider(new ColorDrawable(-1775893));
        }
        this.bPT.setDividerHeight(2);
        aw.h(this.bPV, u.bg_black_banner_down);
        aw.b(this.bPX, s.flist_text_color_day, 1);
        if (this.bPN) {
            this.bPY.setVisibility(8);
        } else {
            aw.c(this.bPY, u.ico_downward);
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
