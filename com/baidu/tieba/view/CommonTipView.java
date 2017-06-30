package com.baidu.tieba.view;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class CommonTipView extends TextView {
    private int Ii;
    private TranslateAnimation cfn;
    private Runnable cfo;
    private Animation fZV;
    private a fZW;

    /* loaded from: classes.dex */
    public interface a {
        void bqA();
    }

    public CommonTipView(Context context) {
        super(context);
        this.Ii = 4000;
        this.fZV = AnimationUtils.loadAnimation(TbadkCoreApplication.m9getInst(), w.a.fade_out);
        this.cfn = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds56), 0.0f);
        this.cfo = new d(this);
        init();
    }

    private void init() {
        setTextSize(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds24));
        setGravity(17);
        this.fZV.setAnimationListener(new e(this));
        this.cfn.setDuration(400L);
        this.cfn.setAnimationListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        removeCallbacks(this.cfo);
        if (this != null && getParent() != null) {
            startAnimation(this.fZV);
        }
    }

    public void b(LinearLayout linearLayout, int i) {
        if (linearLayout != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds56));
            layoutParams.gravity = 48;
            linearLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.cfn);
        }
    }

    public void a(FrameLayout frameLayout, int i) {
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds56));
            layoutParams.setMargins(0, 0, 0, 0);
            frameLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.cfn);
        }
    }

    public void setTipDuration(int i) {
        if (i > 0) {
            this.Ii = i;
        }
    }

    public void onChangeSkinType(int i) {
        as.d(this, w.e.common_color_10260, i);
        as.b(this, w.e.cp_cont_g, 1, i);
    }

    public void onDestroy() {
        removeCallbacks(this.cfo);
    }
}
