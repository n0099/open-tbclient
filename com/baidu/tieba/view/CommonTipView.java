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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class CommonTipView extends TextView {
    private int Cs;
    private Runnable cFO;
    private TranslateAnimation cFR;
    private Animation fXR;
    private a fXS;

    /* loaded from: classes.dex */
    public interface a {
        void bqO();
    }

    public CommonTipView(Context context) {
        super(context);
        this.Cs = 4000;
        this.fXR = AnimationUtils.loadAnimation(TbadkCoreApplication.m9getInst(), r.a.fade_out);
        this.cFR = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.ds56), 0.0f);
        this.cFO = new d(this);
        init();
    }

    private void init() {
        setTextSize(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds24));
        setGravity(17);
        this.fXR.setAnimationListener(new e(this));
        this.cFR.setDuration(400L);
        this.cFR.setAnimationListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        removeCallbacks(this.cFO);
        if (this != null && getParent() != null) {
            startAnimation(this.fXR);
        }
    }

    public void b(LinearLayout linearLayout, int i) {
        if (linearLayout != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds56));
            layoutParams.gravity = 48;
            linearLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.cFR);
        }
    }

    public void a(FrameLayout frameLayout, int i) {
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds56));
            layoutParams.setMargins(0, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT), 0, 0);
            frameLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.cFR);
        }
    }

    public void setTipDuration(int i) {
        if (i > 0) {
            this.Cs = i;
        }
    }

    public void onChangeSkinType(int i) {
        av.d(this, r.d.common_color_10260, i);
        av.b(this, r.d.cp_cont_g, 1, i);
    }

    public void onDestroy() {
        removeCallbacks(this.cFO);
    }
}
