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
public class i {
    private View aAh;
    private ImageView cIl;
    private TextView cIm;
    private Animation cIo;
    private Animation cIp;
    private boolean cIq = true;
    private com.baidu.adp.lib.h.d cuN = new j(this);
    private View dXt;
    private SlidingTabLayout dXu;
    private Context mContext;

    public i(Context context, View view) {
        this.aAh = view;
        this.mContext = context;
        this.cIm = (TextView) view.findViewById(t.g.tab_widget_switch);
        this.dXt = view.findViewById(t.g.tab_widget_line);
        this.cIl = (ImageView) view.findViewById(t.g.tab_widget_more);
        this.cIl.setContentDescription("展开");
        this.dXu = (SlidingTabLayout) view.findViewById(t.g.tab_widget_sliding_tab);
    }

    public void x(View.OnClickListener onClickListener) {
        if (this.cIl != null) {
            this.cIl.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.dXu != null) {
            this.dXu.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        at.l(this.aAh, t.d.cp_bg_line_e);
        at.l(this.cIm, t.d.cp_bg_line_e);
        at.b(this.cIm, t.d.cp_cont_f, 1);
        at.l(this.dXt, t.d.cp_bg_line_b);
        if (this.cIq) {
            at.c(this.cIl, t.f.icon_triangle_down_normal);
        } else {
            at.c(this.cIl, t.f.icon_triangle_up_normal);
        }
        at.k(this.cIl, t.f.rec_frs_btn_more_selector);
        if (this.dXu != null) {
            this.dXu.onChangeSkinType(i);
        }
    }

    public void aol() {
        this.cIq = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, true));
        if (this.cIm != null) {
            this.cIm.clearAnimation();
            this.cIm.setVisibility(0);
            this.cIm.startAnimation(getInAnimation());
        }
        at.c(this.cIl, t.f.icon_triangle_up_normal);
        this.dXu.setDrawBottomLine(false);
        this.dXt.setVisibility(8);
    }

    public void aom() {
        this.cIq = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, false));
        if (this.cIm != null) {
            this.cIm.clearAnimation();
            this.cIm.startAnimation(getOutAnimation());
        }
        at.c(this.cIl, t.f.icon_triangle_down_normal);
        this.dXu.setDrawBottomLine(true);
        this.dXt.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.cIo == null) {
            this.cIo = AnimationUtils.loadAnimation(this.mContext, t.a.fade_in);
            this.cIo.setAnimationListener(this.cuN);
        }
        return this.cIo;
    }

    private Animation getOutAnimation() {
        if (this.cIp == null) {
            this.cIp = AnimationUtils.loadAnimation(this.mContext, t.a.fade_out);
            this.cIp.setAnimationListener(this.cuN);
        }
        return this.cIp;
    }

    public void aU(int i, int i2) {
        if (this.dXu != null) {
            this.dXu.aU(i, i2);
        }
    }
}
