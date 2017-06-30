package com.baidu.tieba.pb.pb.main.emotion.view;

import android.animation.ValueAnimator;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ a eFJ;
    private final /* synthetic */ FrameLayout.LayoutParams eFK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, FrameLayout.LayoutParams layoutParams) {
        this.eFJ = aVar;
        this.eFK = layoutParams;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int pd;
        this.eFK.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        a aVar = this.eFJ;
        pd = this.eFJ.pd(this.eFK.leftMargin);
        aVar.pe(pd);
        this.eFJ.setLayoutParams(this.eFK);
        this.eFJ.pf(this.eFK.leftMargin);
    }
}
