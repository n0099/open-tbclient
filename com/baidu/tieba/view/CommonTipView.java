package com.baidu.tieba.view;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class CommonTipView extends TextView {
    private int Jn;
    private TranslateAnimation dVC;
    private Runnable dnb;
    private Animation eFt;
    private a eFu;

    /* loaded from: classes.dex */
    public interface a {
        void aYC();
    }

    public CommonTipView(Context context) {
        super(context);
        this.Jn = 4000;
        this.eFt = AnimationUtils.loadAnimation(TbadkCoreApplication.m411getInst(), t.a.fade_out);
        this.dVC = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.ds56), 0.0f);
        this.dnb = new c(this);
        init();
    }

    private void init() {
        setTextSize(0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds24));
        setGravity(17);
        this.eFt.setAnimationListener(new d(this));
        this.dVC.setDuration(400L);
        this.dVC.setAnimationListener(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        removeCallbacks(this.dnb);
        if (this != null && getParent() != null) {
            startAnimation(this.eFt);
        }
    }

    public void a(RelativeLayout relativeLayout, int i) {
        if (relativeLayout != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds56));
            layoutParams.addRule(10);
            relativeLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.dVC);
        }
    }

    public void a(FrameLayout frameLayout, int i) {
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds56));
            layoutParams.gravity = 48;
            frameLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.dVC);
        }
    }

    public void setTipDuration(int i) {
        if (i > 0) {
            this.Jn = i;
        }
    }

    public void onChangeSkinType(int i) {
        at.c(this, t.d.cp_link_tip_a_alpha80, i);
        at.a(this, t.d.cp_cont_g, 1, i);
    }

    public void onDestroy() {
        removeCallbacks(this.dnb);
    }
}
