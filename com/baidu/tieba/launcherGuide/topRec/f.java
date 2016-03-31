package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ e cFn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cFn = eVar;
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
        i = this.cFn.cFj;
        if (i < 100) {
            textView5 = this.cFn.cFk;
            topRecActivity2 = this.cFn.cEU;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(t.j.done))).append("(");
            i2 = this.cFn.cFj;
            textView5.setText(append.append(i2).append(")").toString());
        } else {
            textView = this.cFn.cFk;
            topRecActivity = this.cFn.cEU;
            textView.setText(String.valueOf(topRecActivity.getPageContext().getString(t.j.done)) + "(99+)");
        }
        textView2 = this.cFn.cFk;
        textView2.invalidate();
        textView3 = this.cFn.cFk;
        animation2 = this.cFn.cFm;
        textView3.setAnimation(animation2);
        animation3 = this.cFn.cFm;
        animation3.start();
        textView4 = this.cFn.cFk;
        textView4.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
