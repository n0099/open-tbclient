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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class e {
    private ImageView cJk;
    private TextView cJl;
    private SlidingTabLayout cJm;
    private Animation cJn;
    private Animation cJo;
    private Context mContext;
    private View rootView;
    private boolean cJp = true;
    private com.baidu.adp.lib.g.d bMi = new f(this);

    public e(Context context, View view) {
        this.rootView = view;
        this.mContext = context;
        this.cJl = (TextView) view.findViewById(i.f.tab_widget_switch);
        this.cJk = (ImageView) view.findViewById(i.f.tab_widget_more);
        this.cJm = (SlidingTabLayout) view.findViewById(i.f.tab_widget_sliding_tab);
    }

    public void H(View.OnClickListener onClickListener) {
        if (this.cJk != null) {
            this.cJk.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.cJm != null) {
            this.cJm.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        an.j(this.rootView, i.c.cp_bg_line_e);
        an.j((View) this.cJl, i.c.cp_bg_line_e);
        an.b(this.cJl, i.c.cp_cont_f, 1);
        if (this.cJp) {
            an.c(this.cJk, i.e.icon_triangle_down_normal);
        } else {
            an.c(this.cJk, i.e.icon_triangle_up_normal);
        }
        an.i(this.cJk, i.e.rec_frs_btn_more_selector);
        if (this.cJm != null) {
            this.cJm.onChangeSkinType(i);
        }
    }

    public void aqB() {
        this.cJp = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, true));
        if (this.cJl != null) {
            this.cJl.clearAnimation();
            this.cJl.setVisibility(0);
            this.cJl.startAnimation(getInAnimation());
        }
        an.c(this.cJk, i.e.icon_triangle_up_normal);
        this.cJm.setDrawBottomLine(false);
    }

    public void aqC() {
        this.cJp = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, false));
        if (this.cJl != null) {
            this.cJl.clearAnimation();
            this.cJl.startAnimation(getOutAnimation());
        }
        an.c(this.cJk, i.e.icon_triangle_down_normal);
        this.cJm.setDrawBottomLine(true);
    }

    private Animation getInAnimation() {
        if (this.cJn == null) {
            this.cJn = AnimationUtils.loadAnimation(this.mContext, i.a.fade_in);
            this.cJn.setAnimationListener(this.bMi);
        }
        return this.cJn;
    }

    private Animation getOutAnimation() {
        if (this.cJo == null) {
            this.cJo = AnimationUtils.loadAnimation(this.mContext, i.a.fade_out);
            this.cJo.setAnimationListener(this.bMi);
        }
        return this.cJo;
    }
}
