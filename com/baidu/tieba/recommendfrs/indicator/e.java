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
    private ImageView cts;
    private TextView ctt;
    private SlidingTabLayout ctu;
    private Animation ctv;
    private Animation ctw;
    private Context mContext;
    private View rootView;
    private boolean ctx = true;
    private com.baidu.adp.lib.g.d bIl = new f(this);

    public e(Context context, View view) {
        this.rootView = view;
        this.mContext = context;
        this.ctt = (TextView) view.findViewById(i.f.tab_widget_switch);
        this.cts = (ImageView) view.findViewById(i.f.tab_widget_more);
        this.ctu = (SlidingTabLayout) view.findViewById(i.f.tab_widget_sliding_tab);
    }

    public void F(View.OnClickListener onClickListener) {
        if (this.cts != null) {
            this.cts.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.ctu != null) {
            this.ctu.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        al.j(this.rootView, i.c.cp_bg_line_e);
        al.j((View) this.ctt, i.c.cp_bg_line_e);
        al.b(this.ctt, i.c.cp_cont_f, 1);
        if (this.ctx) {
            al.c(this.cts, i.e.icon_triangle_down_normal);
        } else {
            al.c(this.cts, i.e.icon_triangle_up_normal);
        }
        al.i(this.cts, i.e.rec_frs_btn_more_selector);
        if (this.ctu != null) {
            this.ctu.onChangeSkinType(i);
        }
    }

    public void ajX() {
        this.ctx = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, true));
        if (this.ctt != null) {
            this.ctt.clearAnimation();
            this.ctt.setVisibility(0);
            this.ctt.startAnimation(getInAnimation());
        }
        al.c(this.cts, i.e.icon_triangle_up_normal);
        this.ctu.setDrawBottomLine(false);
    }

    public void ajY() {
        this.ctx = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, false));
        if (this.ctt != null) {
            this.ctt.clearAnimation();
            this.ctt.startAnimation(getOutAnimation());
        }
        al.c(this.cts, i.e.icon_triangle_down_normal);
        this.ctu.setDrawBottomLine(true);
    }

    private Animation getInAnimation() {
        if (this.ctv == null) {
            this.ctv = AnimationUtils.loadAnimation(this.mContext, i.a.fade_in);
            this.ctv.setAnimationListener(this.bIl);
        }
        return this.ctv;
    }

    private Animation getOutAnimation() {
        if (this.ctw == null) {
            this.ctw = AnimationUtils.loadAnimation(this.mContext, i.a.fade_out);
            this.ctw.setAnimationListener(this.bIl);
        }
        return this.ctw;
    }
}
