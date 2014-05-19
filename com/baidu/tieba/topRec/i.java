package com.baidu.tieba.topRec;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Animation.AnimationListener {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
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
        i = this.a.k;
        if (i < 100) {
            textView5 = this.a.m;
            topRecActivity2 = this.a.j;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getString(u.done))).append("(");
            i2 = this.a.k;
            textView5.setText(append.append(i2).append(")").toString());
        } else {
            textView = this.a.m;
            topRecActivity = this.a.j;
            textView.setText(String.valueOf(topRecActivity.getString(u.done)) + "(99+)");
        }
        textView2 = this.a.m;
        textView2.invalidate();
        textView3 = this.a.m;
        animation2 = this.a.p;
        textView3.setAnimation(animation2);
        animation3 = this.a.p;
        animation3.start();
        textView4 = this.a.m;
        textView4.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
