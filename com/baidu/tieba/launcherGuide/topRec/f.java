package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ e dnD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.dnD = eVar;
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
        i = this.dnD.dnz;
        if (i < 100) {
            textView5 = this.dnD.dnA;
            topRecActivity2 = this.dnD.dnl;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(u.j.done))).append("(");
            i2 = this.dnD.dnz;
            textView5.setText(append.append(i2).append(")").toString());
        } else {
            textView = this.dnD.dnA;
            topRecActivity = this.dnD.dnl;
            textView.setText(String.valueOf(topRecActivity.getPageContext().getString(u.j.done)) + "(99+)");
        }
        textView2 = this.dnD.dnA;
        textView2.invalidate();
        textView3 = this.dnD.dnA;
        animation2 = this.dnD.dnC;
        textView3.setAnimation(animation2);
        animation3 = this.dnD.dnC;
        animation3.start();
        textView4 = this.dnD.dnA;
        textView4.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
