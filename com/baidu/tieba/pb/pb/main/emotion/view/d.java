package com.baidu.tieba.pb.pb.main.emotion.view;

import android.animation.ValueAnimator;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ a ewn;
    private final /* synthetic */ FrameLayout.LayoutParams ewo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, FrameLayout.LayoutParams layoutParams) {
        this.ewn = aVar;
        this.ewo = layoutParams;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int oL;
        this.ewo.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        a aVar = this.ewn;
        oL = this.ewn.oL(this.ewo.leftMargin);
        aVar.oM(oL);
        this.ewn.setLayoutParams(this.ewo);
        this.ewn.oN(this.ewo.leftMargin);
    }
}
