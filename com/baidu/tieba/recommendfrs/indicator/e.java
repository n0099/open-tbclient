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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class e {
    private ImageView cIL;
    private TextView cIM;
    private SlidingTabLayout cIN;
    private Animation cIO;
    private Animation cIP;
    private Context mContext;
    private View rootView;
    private boolean cIQ = true;
    private com.baidu.adp.lib.g.d bLX = new f(this);

    public e(Context context, View view) {
        this.rootView = view;
        this.mContext = context;
        this.cIM = (TextView) view.findViewById(i.f.tab_widget_switch);
        this.cIL = (ImageView) view.findViewById(i.f.tab_widget_more);
        this.cIN = (SlidingTabLayout) view.findViewById(i.f.tab_widget_sliding_tab);
    }

    public void H(View.OnClickListener onClickListener) {
        if (this.cIL != null) {
            this.cIL.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.cIN != null) {
            this.cIN.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        am.j(this.rootView, i.c.cp_bg_line_e);
        am.j((View) this.cIM, i.c.cp_bg_line_e);
        am.b(this.cIM, i.c.cp_cont_f, 1);
        if (this.cIQ) {
            am.c(this.cIL, i.e.icon_triangle_down_normal);
        } else {
            am.c(this.cIL, i.e.icon_triangle_up_normal);
        }
        am.i(this.cIL, i.e.rec_frs_btn_more_selector);
        if (this.cIN != null) {
            this.cIN.onChangeSkinType(i);
        }
    }

    public void aqv() {
        this.cIQ = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, true));
        if (this.cIM != null) {
            this.cIM.clearAnimation();
            this.cIM.setVisibility(0);
            this.cIM.startAnimation(getInAnimation());
        }
        am.c(this.cIL, i.e.icon_triangle_up_normal);
        this.cIN.setDrawBottomLine(false);
    }

    public void aqw() {
        this.cIQ = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, false));
        if (this.cIM != null) {
            this.cIM.clearAnimation();
            this.cIM.startAnimation(getOutAnimation());
        }
        am.c(this.cIL, i.e.icon_triangle_down_normal);
        this.cIN.setDrawBottomLine(true);
    }

    private Animation getInAnimation() {
        if (this.cIO == null) {
            this.cIO = AnimationUtils.loadAnimation(this.mContext, i.a.fade_in);
            this.cIO.setAnimationListener(this.bLX);
        }
        return this.cIO;
    }

    private Animation getOutAnimation() {
        if (this.cIP == null) {
            this.cIP = AnimationUtils.loadAnimation(this.mContext, i.a.fade_out);
            this.cIP.setAnimationListener(this.bLX);
        }
        return this.cIP;
    }
}
