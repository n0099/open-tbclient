package com.baidu.tieba.view;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class CommonTipView extends TextView {
    private int It;
    private TranslateAnimation bQE;
    private Runnable bQF;
    private Animation fJm;
    private a fJn;

    /* loaded from: classes.dex */
    public interface a {
        void bml();
    }

    public CommonTipView(Context context) {
        super(context);
        this.It = 4000;
        this.fJm = AnimationUtils.loadAnimation(TbadkCoreApplication.m9getInst(), w.a.fade_out);
        this.bQE = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds56), 0.0f);
        this.bQF = new d(this);
        init();
    }

    private void init() {
        setTextSize(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds24));
        setGravity(17);
        this.fJm.setAnimationListener(new e(this));
        this.bQE.setDuration(400L);
        this.bQE.setAnimationListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        removeCallbacks(this.bQF);
        if (this != null && getParent() != null) {
            startAnimation(this.fJm);
        }
    }

    public void b(LinearLayout linearLayout, int i) {
        if (linearLayout != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds56));
            layoutParams.gravity = 48;
            linearLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.bQE);
        }
    }

    public void a(FrameLayout frameLayout, int i) {
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds56));
            layoutParams.setMargins(0, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT), 0, 0);
            frameLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.bQE);
        }
    }

    public void setTipDuration(int i) {
        if (i > 0) {
            this.It = i;
        }
    }

    public void onChangeSkinType(int i) {
        aq.d(this, w.e.common_color_10260, i);
        aq.b(this, w.e.cp_cont_g, 1, i);
    }

    public void onDestroy() {
        removeCallbacks(this.bQF);
    }
}
