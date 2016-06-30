package com.baidu.tieba.view;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class CommonTipView extends TextView {
    private Runnable cqF;
    private TranslateAnimation cqI;
    private Animation fAU;
    private a fAV;
    private int zC;

    /* loaded from: classes.dex */
    public interface a {
        void bjo();
    }

    public CommonTipView(Context context) {
        super(context);
        this.zC = 4000;
        this.fAU = AnimationUtils.loadAnimation(TbadkCoreApplication.m9getInst(), u.a.fade_out);
        this.cqI = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m9getInst().getResources().getDimension(u.e.ds56), 0.0f);
        this.cqF = new d(this);
        init();
    }

    private void init() {
        setTextSize(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds24));
        setGravity(17);
        this.fAU.setAnimationListener(new e(this));
        this.cqI.setDuration(400L);
        this.cqI.setAnimationListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        removeCallbacks(this.cqF);
        if (this != null && getParent() != null) {
            startAnimation(this.fAU);
        }
    }

    public void b(LinearLayout linearLayout, int i) {
        if (linearLayout != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds56));
            layoutParams.gravity = 48;
            linearLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.cqI);
        }
    }

    public void a(FrameLayout frameLayout, int i) {
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds56));
            layoutParams.setMargins(0, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT), 0, 0);
            frameLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.cqI);
        }
    }

    public void setTipDuration(int i) {
        if (i > 0) {
            this.zC = i;
        }
    }

    public void onChangeSkinType(int i) {
        av.d(this, u.d.common_color_10260, i);
        av.b(this, u.d.cp_cont_g, 1, i);
    }

    public void onDestroy() {
        removeCallbacks(this.cqF);
    }
}
