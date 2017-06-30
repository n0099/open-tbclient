package com.baidu.tieba.pb.pb.main.emotion.view;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ a eFJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.eFJ = aVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        LinearLayout linearLayout5;
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        linearLayout = this.eFJ.eFG;
        linearLayout.setAlpha(floatValue);
        if (floatValue == 0.0f) {
            linearLayout2 = this.eFJ.eFG;
            linearLayout2.setVisibility(8);
            linearLayout3 = this.eFJ.eFG;
            if (linearLayout3.getParent() != null) {
                linearLayout4 = this.eFJ.eFG;
                ViewParent parent = linearLayout4.getParent();
                viewGroup = this.eFJ.dsD;
                if (parent == viewGroup) {
                    viewGroup2 = this.eFJ.dsD;
                    linearLayout5 = this.eFJ.eFG;
                    viewGroup2.removeView(linearLayout5);
                }
            }
        }
    }
}
