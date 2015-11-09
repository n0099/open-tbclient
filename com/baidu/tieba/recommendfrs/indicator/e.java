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
    private ImageView cKG;
    private TextView cKH;
    private SlidingTabLayout cKI;
    private Animation cKJ;
    private Animation cKK;
    private Context mContext;
    private View rootView;
    private boolean cKL = true;
    private com.baidu.adp.lib.g.d bMD = new f(this);

    public e(Context context, View view) {
        this.rootView = view;
        this.mContext = context;
        this.cKH = (TextView) view.findViewById(i.f.tab_widget_switch);
        this.cKG = (ImageView) view.findViewById(i.f.tab_widget_more);
        this.cKI = (SlidingTabLayout) view.findViewById(i.f.tab_widget_sliding_tab);
    }

    public void H(View.OnClickListener onClickListener) {
        if (this.cKG != null) {
            this.cKG.setOnClickListener(onClickListener);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.cKI != null) {
            this.cKI.setViewPager(viewPager);
        }
    }

    public void onChangeSkinType(int i) {
        an.j(this.rootView, i.c.cp_bg_line_e);
        an.j((View) this.cKH, i.c.cp_bg_line_e);
        an.b(this.cKH, i.c.cp_cont_f, 1);
        if (this.cKL) {
            an.c(this.cKG, i.e.icon_triangle_down_normal);
        } else {
            an.c(this.cKG, i.e.icon_triangle_up_normal);
        }
        an.i(this.cKG, i.e.rec_frs_btn_more_selector);
        if (this.cKI != null) {
            this.cKI.onChangeSkinType(i);
        }
    }

    public void ard() {
        this.cKL = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, true));
        if (this.cKH != null) {
            this.cKH.clearAnimation();
            this.cKH.setVisibility(0);
            this.cKH.startAnimation(getInAnimation());
        }
        an.c(this.cKG, i.e.icon_triangle_up_normal);
        this.cKI.setDrawBottomLine(false);
    }

    public void are() {
        this.cKL = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_LAYER_VISIBLE, false));
        if (this.cKH != null) {
            this.cKH.clearAnimation();
            this.cKH.startAnimation(getOutAnimation());
        }
        an.c(this.cKG, i.e.icon_triangle_down_normal);
        this.cKI.setDrawBottomLine(true);
    }

    private Animation getInAnimation() {
        if (this.cKJ == null) {
            this.cKJ = AnimationUtils.loadAnimation(this.mContext, i.a.fade_in);
            this.cKJ.setAnimationListener(this.bMD);
        }
        return this.cKJ;
    }

    private Animation getOutAnimation() {
        if (this.cKK == null) {
            this.cKK = AnimationUtils.loadAnimation(this.mContext, i.a.fade_out);
            this.cKK.setAnimationListener(this.bMD);
        }
        return this.cKK;
    }
}
