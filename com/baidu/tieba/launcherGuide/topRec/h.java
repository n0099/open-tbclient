package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Animation.AnimationListener {
    final /* synthetic */ g byw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.byw = gVar;
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
        i = this.byw.bys;
        if (i < 100) {
            textView5 = this.byw.byt;
            topRecActivity2 = this.byw.byc;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(y.done))).append("(");
            i2 = this.byw.bys;
            textView5.setText(append.append(i2).append(")").toString());
        } else {
            textView = this.byw.byt;
            topRecActivity = this.byw.byc;
            textView.setText(String.valueOf(topRecActivity.getPageContext().getString(y.done)) + "(99+)");
        }
        textView2 = this.byw.byt;
        textView2.invalidate();
        textView3 = this.byw.byt;
        animation2 = this.byw.byv;
        textView3.setAnimation(animation2);
        animation3 = this.byw.byv;
        animation3.start();
        textView4 = this.byw.byt;
        textView4.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
