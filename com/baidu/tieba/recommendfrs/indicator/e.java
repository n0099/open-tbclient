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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class e {
    private ImageView cBK;
    private TextView cBL;
    private SlidingTabLayout cBM;
    private Animation cBN;
    private Animation cBO;
    private Context mContext;
    private View rootView;
    private boolean cBP = true;
    private com.baidu.adp.lib.g.d bIS = new f(this);

    public e(Context context, View view) {
        this.rootView = view;
        this.mContext = context;
        this.cBL = (TextView) view.findViewById(i.f.tab_widget_switch);
        this.cBK = (ImageView) view.findViewById(i.f.tab_widget_more);
        this.cBM = (SlidingTabLayout) view.findViewById(i.f.tab_widget_sliding_tab);
    }

    public void G(View.OnClickListener onClickListener) {
        if (this.cBK != null) {
            this.cBK.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.cBM != null) {
            this.cBM.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        al.i(this.rootView, i.c.cp_bg_line_e);
        al.i((View) this.cBL, i.c.cp_bg_line_e);
        al.b(this.cBL, i.c.cp_cont_f, 1);
        if (this.cBP) {
            al.c(this.cBK, i.e.icon_triangle_down_normal);
        } else {
            al.c(this.cBK, i.e.icon_triangle_up_normal);
        }
        al.h(this.cBK, i.e.rec_frs_btn_more_selector);
        if (this.cBM != null) {
            this.cBM.onChangeSkinType(i);
        }
    }

    public void aod() {
        this.cBP = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, true));
        if (this.cBL != null) {
            this.cBL.clearAnimation();
            this.cBL.setVisibility(0);
            this.cBL.startAnimation(getInAnimation());
        }
        al.c(this.cBK, i.e.icon_triangle_up_normal);
        this.cBM.setDrawBottomLine(false);
    }

    public void aoe() {
        this.cBP = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, false));
        if (this.cBL != null) {
            this.cBL.clearAnimation();
            this.cBL.startAnimation(getOutAnimation());
        }
        al.c(this.cBK, i.e.icon_triangle_down_normal);
        this.cBM.setDrawBottomLine(true);
    }

    private Animation getInAnimation() {
        if (this.cBN == null) {
            this.cBN = AnimationUtils.loadAnimation(this.mContext, i.a.fade_in);
            this.cBN.setAnimationListener(this.bIS);
        }
        return this.cBN;
    }

    private Animation getOutAnimation() {
        if (this.cBO == null) {
            this.cBO = AnimationUtils.loadAnimation(this.mContext, i.a.fade_out);
            this.cBO.setAnimationListener(this.bIS);
        }
        return this.cBO;
    }
}
