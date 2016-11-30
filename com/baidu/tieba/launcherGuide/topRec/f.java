package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ e dGg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.dGg = eVar;
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
        i = this.dGg.dGc;
        if (i < 100) {
            textView5 = this.dGg.dGd;
            topRecActivity2 = this.dGg.dFO;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(r.j.done))).append("(");
            i2 = this.dGg.dGc;
            textView5.setText(append.append(i2).append(")").toString());
        } else {
            textView = this.dGg.dGd;
            topRecActivity = this.dGg.dFO;
            textView.setText(String.valueOf(topRecActivity.getPageContext().getString(r.j.done)) + "(99+)");
        }
        textView2 = this.dGg.dGd;
        textView2.invalidate();
        textView3 = this.dGg.dGd;
        animation2 = this.dGg.dGf;
        textView3.setAnimation(animation2);
        animation3 = this.dGg.dGf;
        animation3.start();
        textView4 = this.dGg.dGd;
        textView4.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
