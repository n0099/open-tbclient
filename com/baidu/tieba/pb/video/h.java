package com.baidu.tieba.pb.video;

import android.animation.ValueAnimator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ d exo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar) {
        this.exo = dVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        frameLayout = this.exo.erd;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.topMargin = intValue;
        frameLayout2 = this.exo.erd;
        frameLayout2.setLayoutParams(layoutParams);
        this.exo.aQt();
    }
}
