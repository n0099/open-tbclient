package com.baidu.tieba.view;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class CommonTipView extends TextView {
    private TranslateAnimation dYD;
    private Runnable dpt;
    private Animation eWh;
    private a eWi;
    private int zD;

    /* loaded from: classes.dex */
    public interface a {
        void baT();
    }

    public CommonTipView(Context context) {
        super(context);
        this.zD = 4000;
        this.eWh = AnimationUtils.loadAnimation(TbadkCoreApplication.m11getInst(), t.a.fade_out);
        this.dYD = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m11getInst().getResources().getDimension(t.e.ds56), 0.0f);
        this.dpt = new d(this);
        init();
    }

    private void init() {
        setTextSize(0, TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds24));
        setGravity(17);
        this.eWh.setAnimationListener(new e(this));
        this.dYD.setDuration(400L);
        this.dYD.setAnimationListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        removeCallbacks(this.dpt);
        if (this != null && getParent() != null) {
            startAnimation(this.eWh);
        }
    }

    public void b(LinearLayout linearLayout, int i) {
        if (linearLayout != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds56));
            layoutParams.gravity = 48;
            linearLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.dYD);
        }
    }

    public void a(FrameLayout frameLayout, int i) {
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds56));
            layoutParams.setMargins(0, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT), 0, 0);
            frameLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.dYD);
        }
    }

    public void setTipDuration(int i) {
        if (i > 0) {
            this.zD = i;
        }
    }

    public void onChangeSkinType(int i) {
        at.d(this, t.d.cp_link_tip_a_alpha80, i);
        at.b(this, t.d.cp_cont_g, 1, i);
    }

    public void onDestroy() {
        removeCallbacks(this.dpt);
    }
}
