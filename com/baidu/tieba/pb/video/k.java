package com.baidu.tieba.pb.video;

import android.animation.ValueAnimator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ g esY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar) {
        this.esY = gVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        frameLayout = this.esY.emJ;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.topMargin = intValue;
        frameLayout2 = this.esY.emJ;
        frameLayout2.setLayoutParams(layoutParams);
        this.esY.aNK();
    }
}
