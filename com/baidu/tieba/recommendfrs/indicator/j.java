package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class j {
    private View awk;
    private ImageView cIP;
    private TextView cIQ;
    private Animation cIS;
    private Animation cIT;
    private boolean cIU = true;
    private com.baidu.adp.lib.h.d cvK = new k(this);
    private View eaD;
    private SlidingTabLayout eaE;
    private Context mContext;

    public j(Context context, View view) {
        this.mContext = context;
        this.awk = view;
        this.cIQ = (TextView) view.findViewById(t.g.tab_widget_switch);
        this.eaD = view.findViewById(t.g.tab_widget_line);
        this.cIP = (ImageView) view.findViewById(t.g.tab_widget_more);
        this.cIP.setContentDescription("展开");
        this.eaE = (SlidingTabLayout) view.findViewById(t.g.tab_widget_sliding_tab);
    }

    public void t(View.OnClickListener onClickListener) {
        if (this.cIP != null) {
            this.cIP.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.eaE != null) {
            this.eaE.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        at.l(this.awk, t.d.navigation_bar_bg);
        at.l(this.cIQ, t.d.cp_bg_line_e);
        at.c(this.cIQ, t.d.cp_cont_f, 1);
        at.l(this.eaD, t.d.cp_bg_line_b);
        if (this.cIU) {
            at.c(this.cIP, t.f.icon_triangle_down_normal);
            at.k(this.cIP, t.f.rec_frs_btn_more_selector);
        } else {
            at.c(this.cIP, t.f.icon_triangle_up_normal);
            at.k(this.cIP, t.f.rec_frs_btn_more_up_selector);
        }
        if (this.eaE != null) {
            this.eaE.onChangeSkinType(i);
        }
    }

    public void aor() {
        this.cIU = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, true));
        if (this.cIQ != null) {
            this.cIQ.clearAnimation();
            this.cIQ.setVisibility(0);
            this.cIQ.startAnimation(getInAnimation());
        }
        at.c(this.cIP, t.f.icon_triangle_up_normal);
        at.k(this.cIP, t.f.rec_frs_btn_more_up_selector);
        this.eaE.setDrawBottomLine(false);
        this.eaD.setVisibility(8);
    }

    public void aos() {
        this.cIU = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, false));
        if (this.cIQ != null) {
            this.cIQ.clearAnimation();
            this.cIQ.startAnimation(getOutAnimation());
        }
        at.c(this.cIP, t.f.icon_triangle_down_normal);
        at.k(this.cIP, t.f.rec_frs_btn_more_selector);
        this.eaE.setDrawBottomLine(true);
        this.eaD.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.cIS == null) {
            this.cIS = AnimationUtils.loadAnimation(this.mContext, t.a.fade_in);
            this.cIS.setAnimationListener(this.cvK);
        }
        return this.cIS;
    }

    private Animation getOutAnimation() {
        if (this.cIT == null) {
            this.cIT = AnimationUtils.loadAnimation(this.mContext, t.a.fade_out);
            this.cIT.setAnimationListener(this.cvK);
        }
        return this.cIT;
    }

    public void aV(int i, int i2) {
        if (this.eaE != null) {
            this.eaE.aV(i, i2);
        }
    }
}
