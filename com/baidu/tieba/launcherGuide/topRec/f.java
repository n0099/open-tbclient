package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ e dAC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.dAC = eVar;
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
        i = this.dAC.dAy;
        if (i < 100) {
            textView5 = this.dAC.dAz;
            topRecActivity2 = this.dAC.dAk;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(r.j.done))).append("(");
            i2 = this.dAC.dAy;
            textView5.setText(append.append(i2).append(")").toString());
        } else {
            textView = this.dAC.dAz;
            topRecActivity = this.dAC.dAk;
            textView.setText(String.valueOf(topRecActivity.getPageContext().getString(r.j.done)) + "(99+)");
        }
        textView2 = this.dAC.dAz;
        textView2.invalidate();
        textView3 = this.dAC.dAz;
        animation2 = this.dAC.dAB;
        textView3.setAnimation(animation2);
        animation3 = this.dAC.dAB;
        animation3.start();
        textView4 = this.dAC.dAz;
        textView4.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
