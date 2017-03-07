package com.baidu.tieba.pb.video;

import android.animation.ValueAnimator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ d ewS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.ewS = dVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        frameLayout = this.ewS.eqD;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.topMargin = intValue;
        frameLayout2 = this.ewS.eqD;
        frameLayout2.setLayoutParams(layoutParams);
        this.ewS.aPj();
    }
}
