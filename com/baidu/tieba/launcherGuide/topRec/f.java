package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ e cFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cFg = eVar;
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
        i = this.cFg.cFc;
        if (i < 100) {
            textView5 = this.cFg.cFd;
            topRecActivity2 = this.cFg.cEM;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(t.j.done))).append("(");
            i2 = this.cFg.cFc;
            textView5.setText(append.append(i2).append(")").toString());
        } else {
            textView = this.cFg.cFd;
            topRecActivity = this.cFg.cEM;
            textView.setText(String.valueOf(topRecActivity.getPageContext().getString(t.j.done)) + "(99+)");
        }
        textView2 = this.cFg.cFd;
        textView2.invalidate();
        textView3 = this.cFg.cFd;
        animation2 = this.cFg.cFf;
        textView3.setAnimation(animation2);
        animation3 = this.cFg.cFf;
        animation3.start();
        textView4 = this.cFg.cFd;
        textView4.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
