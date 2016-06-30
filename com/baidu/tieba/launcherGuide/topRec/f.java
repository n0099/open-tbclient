package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ e dkE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.dkE = eVar;
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
        i = this.dkE.dkA;
        if (i < 100) {
            textView5 = this.dkE.dkB;
            topRecActivity2 = this.dkE.dkm;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(u.j.done))).append("(");
            i2 = this.dkE.dkA;
            textView5.setText(append.append(i2).append(")").toString());
        } else {
            textView = this.dkE.dkB;
            topRecActivity = this.dkE.dkm;
            textView.setText(String.valueOf(topRecActivity.getPageContext().getString(u.j.done)) + "(99+)");
        }
        textView2 = this.dkE.dkB;
        textView2.invalidate();
        textView3 = this.dkE.dkB;
        animation2 = this.dkE.dkD;
        textView3.setAnimation(animation2);
        animation3 = this.dkE.dkD;
        animation3.start();
        textView4 = this.dkE.dkB;
        textView4.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
