package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ e bTN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bTN = eVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        int i;
        TextView textView;
        TopRecActivity topRecActivity;
        TextView textView2;
        TextView textView3;
        Animation animation2;
        Animation animation3;
        TextView textView4;
        TextView textView5;
        TopRecActivity topRecActivity2;
        int i2;
        i = this.bTN.bTJ;
        if (i < 100) {
            textView5 = this.bTN.bTK;
            topRecActivity2 = this.bTN.bTt;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(i.h.done))).append("(");
            i2 = this.bTN.bTJ;
            textView5.setText(append.append(i2).append(")").toString());
        } else {
            textView = this.bTN.bTK;
            topRecActivity = this.bTN.bTt;
            textView.setText(String.valueOf(topRecActivity.getPageContext().getString(i.h.done)) + "(99+)");
        }
        textView2 = this.bTN.bTK;
        textView2.invalidate();
        textView3 = this.bTN.bTK;
        animation2 = this.bTN.bTM;
        textView3.setAnimation(animation2);
        animation3 = this.bTN.bTM;
        animation3.start();
        textView4 = this.bTN.bTK;
        textView4.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
