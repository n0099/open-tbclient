package com.baidu.tieba.recommendfrs;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    final /* synthetic */ q dVL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.dVL = qVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.dVL.Xr;
        if (textView != null) {
            textView2 = this.dVL.Xr;
            ViewGroup viewGroup = (ViewGroup) textView2.getParent();
            if (viewGroup != null) {
                textView3 = this.dVL.Xr;
                viewGroup.removeView(textView3);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
