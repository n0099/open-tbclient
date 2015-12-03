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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class e {
    private ImageView djc;
    private TextView djd;
    private SlidingTabLayout dje;
    private Animation djf;
    private Animation djg;
    private Context mContext;
    private View rootView;
    private boolean djh = true;
    private com.baidu.adp.lib.h.d cbH = new f(this);

    public e(Context context, View view) {
        this.rootView = view;
        this.mContext = context;
        this.djd = (TextView) view.findViewById(n.f.tab_widget_switch);
        this.djc = (ImageView) view.findViewById(n.f.tab_widget_more);
        this.dje = (SlidingTabLayout) view.findViewById(n.f.tab_widget_sliding_tab);
    }

    public void L(View.OnClickListener onClickListener) {
        if (this.djc != null) {
            this.djc.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.dje != null) {
            this.dje.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        as.j(this.rootView, n.c.cp_bg_line_e);
        as.j((View) this.djd, n.c.cp_bg_line_e);
        as.b(this.djd, n.c.cp_cont_f, 1);
        if (this.djh) {
            as.c(this.djc, n.e.icon_triangle_down_normal);
        } else {
            as.c(this.djc, n.e.icon_triangle_up_normal);
        }
        as.i(this.djc, n.e.rec_frs_btn_more_selector);
        if (this.dje != null) {
            this.dje.onChangeSkinType(i);
        }
    }

    public void awB() {
        this.djh = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, true));
        if (this.djd != null) {
            this.djd.clearAnimation();
            this.djd.setVisibility(0);
            this.djd.startAnimation(getInAnimation());
        }
        as.c(this.djc, n.e.icon_triangle_up_normal);
        this.dje.setDrawBottomLine(false);
    }

    public void awC() {
        this.djh = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, false));
        if (this.djd != null) {
            this.djd.clearAnimation();
            this.djd.startAnimation(getOutAnimation());
        }
        as.c(this.djc, n.e.icon_triangle_down_normal);
        this.dje.setDrawBottomLine(true);
    }

    private Animation getInAnimation() {
        if (this.djf == null) {
            this.djf = AnimationUtils.loadAnimation(this.mContext, n.a.fade_in);
            this.djf.setAnimationListener(this.cbH);
        }
        return this.djf;
    }

    private Animation getOutAnimation() {
        if (this.djg == null) {
            this.djg = AnimationUtils.loadAnimation(this.mContext, n.a.fade_out);
            this.djg.setAnimationListener(this.cbH);
        }
        return this.djg;
    }
}
