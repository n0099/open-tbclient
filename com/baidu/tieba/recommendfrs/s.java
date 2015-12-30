package com.baidu.tieba.recommendfrs;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Animation.AnimationListener {
    final /* synthetic */ n doE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(n nVar) {
        this.doE = nVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.doE.YB;
        if (textView != null) {
            textView2 = this.doE.YB;
            ViewGroup viewGroup = (ViewGroup) textView2.getParent();
            if (viewGroup != null) {
                textView3 = this.doE.YB;
                viewGroup.removeView(textView3);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
