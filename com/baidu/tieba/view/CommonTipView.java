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
    private int Iv;
    private TranslateAnimation bSV;
    private Runnable bSW;
    private Animation fLI;
    private a fLJ;

    /* loaded from: classes.dex */
    public interface a {
        void bnm();
    }

    public CommonTipView(Context context) {
        super(context);
        this.Iv = 4000;
        this.fLI = AnimationUtils.loadAnimation(TbadkCoreApplication.m9getInst(), w.a.fade_out);
        this.bSV = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds56), 0.0f);
        this.bSW = new d(this);
        init();
    }

    private void init() {
        setTextSize(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds24));
        setGravity(17);
        this.fLI.setAnimationListener(new e(this));
        this.bSV.setDuration(400L);
        this.bSV.setAnimationListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        removeCallbacks(this.bSW);
        if (this != null && getParent() != null) {
            startAnimation(this.fLI);
        }
    }

    public void b(LinearLayout linearLayout, int i) {
        if (linearLayout != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds56));
            layoutParams.gravity = 48;
            linearLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.bSV);
        }
    }

    public void a(FrameLayout frameLayout, int i) {
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds56));
            layoutParams.setMargins(0, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT), 0, 0);
            frameLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.bSV);
        }
    }

    public void setTipDuration(int i) {
        if (i > 0) {
            this.Iv = i;
        }
    }

    public void onChangeSkinType(int i) {
        aq.d(this, w.e.common_color_10260, i);
        aq.b(this, w.e.cp_cont_g, 1, i);
    }

    public void onDestroy() {
        removeCallbacks(this.bSW);
    }
}
