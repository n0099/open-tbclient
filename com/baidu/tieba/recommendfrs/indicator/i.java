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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class i {
    private View azA;
    private ImageView dFu;
    private TextView dFv;
    private View dFw;
    private SlidingTabLayout dFx;
    private Animation dFy;
    private Animation dFz;
    private Context mContext;
    private boolean dFA = true;
    private com.baidu.adp.lib.h.d ckh = new j(this);

    public i(Context context, View view) {
        this.azA = view;
        this.mContext = context;
        this.dFv = (TextView) view.findViewById(t.g.tab_widget_switch);
        this.dFw = view.findViewById(t.g.tab_widget_line);
        this.dFu = (ImageView) view.findViewById(t.g.tab_widget_more);
        this.dFx = (SlidingTabLayout) view.findViewById(t.g.tab_widget_sliding_tab);
    }

    public void Q(View.OnClickListener onClickListener) {
        if (this.dFu != null) {
            this.dFu.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.dFx != null) {
            this.dFx.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        ar.l(this.azA, t.d.cp_bg_line_e);
        ar.l(this.dFv, t.d.cp_bg_line_e);
        ar.b(this.dFv, t.d.cp_cont_f, 1);
        ar.l(this.dFw, t.d.cp_bg_line_b);
        if (this.dFA) {
            ar.c(this.dFu, t.f.icon_triangle_down_normal);
        } else {
            ar.c(this.dFu, t.f.icon_triangle_up_normal);
        }
        ar.k(this.dFu, t.f.rec_frs_btn_more_selector);
        if (this.dFx != null) {
            this.dFx.onChangeSkinType(i);
        }
    }

    public void aFP() {
        this.dFA = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, true));
        if (this.dFv != null) {
            this.dFv.clearAnimation();
            this.dFv.setVisibility(0);
            this.dFv.startAnimation(getInAnimation());
        }
        ar.c(this.dFu, t.f.icon_triangle_up_normal);
        this.dFx.setDrawBottomLine(false);
        this.dFw.setVisibility(8);
    }

    public void aFQ() {
        this.dFA = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, false));
        if (this.dFv != null) {
            this.dFv.clearAnimation();
            this.dFv.startAnimation(getOutAnimation());
        }
        ar.c(this.dFu, t.f.icon_triangle_down_normal);
        this.dFx.setDrawBottomLine(true);
        this.dFw.setVisibility(0);
    }

    private Animation getInAnimation() {
        if (this.dFy == null) {
            this.dFy = AnimationUtils.loadAnimation(this.mContext, t.a.fade_in);
            this.dFy.setAnimationListener(this.ckh);
        }
        return this.dFy;
    }

    private Animation getOutAnimation() {
        if (this.dFz == null) {
            this.dFz = AnimationUtils.loadAnimation(this.mContext, t.a.fade_out);
            this.dFz.setAnimationListener(this.ckh);
        }
        return this.dFz;
    }

    public void aU(int i, int i2) {
        if (this.dFx != null) {
            this.dFx.aU(i, i2);
        }
    }
}
