package com.baidu.tieba.recommendfrs;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Animation.AnimationListener {
    final /* synthetic */ p dDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(p pVar) {
        this.dDT = pVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.dDT.YY;
        if (textView != null) {
            textView2 = this.dDT.YY;
            ViewGroup viewGroup = (ViewGroup) textView2.getParent();
            if (viewGroup != null) {
                textView3 = this.dDT.YY;
                viewGroup.removeView(textView3);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
