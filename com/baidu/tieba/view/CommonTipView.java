package com.baidu.tieba.view;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class CommonTipView extends TextView {
    private int BF;
    private TranslateAnimation bJJ;
    private Runnable bJK;
    private Animation fDc;
    private a fDd;

    /* loaded from: classes.dex */
    public interface a {
        void blM();
    }

    public CommonTipView(Context context) {
        super(context);
        this.BF = 4000;
        this.fDc = AnimationUtils.loadAnimation(TbadkCoreApplication.m9getInst(), r.a.fade_out);
        this.bJJ = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m9getInst().getResources().getDimension(r.f.ds56), 0.0f);
        this.bJK = new d(this);
        init();
    }

    private void init() {
        setTextSize(0, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds24));
        setGravity(17);
        this.fDc.setAnimationListener(new e(this));
        this.bJJ.setDuration(400L);
        this.bJJ.setAnimationListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        removeCallbacks(this.bJK);
        if (this != null && getParent() != null) {
            startAnimation(this.fDc);
        }
    }

    public void b(LinearLayout linearLayout, int i) {
        if (linearLayout != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds56));
            layoutParams.gravity = 48;
            linearLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.bJJ);
        }
    }

    public void a(FrameLayout frameLayout, int i) {
        if (frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds56));
            layoutParams.setMargins(0, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT), 0, 0);
            frameLayout.addView(this, layoutParams);
            onChangeSkinType(i);
            startAnimation(this.bJJ);
        }
    }

    public void setTipDuration(int i) {
        if (i > 0) {
            this.BF = i;
        }
    }

    public void onChangeSkinType(int i) {
        ap.d(this, r.e.common_color_10260, i);
        ap.b(this, r.e.cp_cont_g, 1, i);
    }

    public void onDestroy() {
        removeCallbacks(this.bJK);
    }
}
