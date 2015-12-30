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
    private ImageView dpG;
    private TextView dpH;
    private SlidingTabLayout dpI;
    private Animation dpJ;
    private Animation dpK;
    private Context mContext;
    private View rootView;
    private boolean dpL = true;
    private com.baidu.adp.lib.h.d cfH = new f(this);

    public e(Context context, View view) {
        this.rootView = view;
        this.mContext = context;
        this.dpH = (TextView) view.findViewById(n.g.tab_widget_switch);
        this.dpG = (ImageView) view.findViewById(n.g.tab_widget_more);
        this.dpI = (SlidingTabLayout) view.findViewById(n.g.tab_widget_sliding_tab);
    }

    public void L(View.OnClickListener onClickListener) {
        if (this.dpG != null) {
            this.dpG.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.dpI != null) {
            this.dpI.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        as.j(this.rootView, n.d.cp_bg_line_e);
        as.j((View) this.dpH, n.d.cp_bg_line_e);
        as.b(this.dpH, n.d.cp_cont_f, 1);
        if (this.dpL) {
            as.c(this.dpG, n.f.icon_triangle_down_normal);
        } else {
            as.c(this.dpG, n.f.icon_triangle_up_normal);
        }
        as.i(this.dpG, n.f.rec_frs_btn_more_selector);
        if (this.dpI != null) {
            this.dpI.onChangeSkinType(i);
        }
    }

    public void ayH() {
        this.dpL = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, true));
        if (this.dpH != null) {
            this.dpH.clearAnimation();
            this.dpH.setVisibility(0);
            this.dpH.startAnimation(getInAnimation());
        }
        as.c(this.dpG, n.f.icon_triangle_up_normal);
        this.dpI.setDrawBottomLine(false);
    }

    public void ayI() {
        this.dpL = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, false));
        if (this.dpH != null) {
            this.dpH.clearAnimation();
            this.dpH.startAnimation(getOutAnimation());
        }
        as.c(this.dpG, n.f.icon_triangle_down_normal);
        this.dpI.setDrawBottomLine(true);
    }

    private Animation getInAnimation() {
        if (this.dpJ == null) {
            this.dpJ = AnimationUtils.loadAnimation(this.mContext, n.a.fade_in);
            this.dpJ.setAnimationListener(this.cfH);
        }
        return this.dpJ;
    }

    private Animation getOutAnimation() {
        if (this.dpK == null) {
            this.dpK = AnimationUtils.loadAnimation(this.mContext, n.a.fade_out);
            this.dpK.setAnimationListener(this.cfH);
        }
        return this.dpK;
    }
}
