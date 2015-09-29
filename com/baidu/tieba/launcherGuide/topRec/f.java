package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ e bTh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bTh = eVar;
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
        i = this.bTh.bTd;
        if (i < 100) {
            textView5 = this.bTh.bTe;
            topRecActivity2 = this.bTh.bSN;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(i.h.done))).append("(");
            i2 = this.bTh.bTd;
            textView5.setText(append.append(i2).append(")").toString());
        } else {
            textView = this.bTh.bTe;
            topRecActivity = this.bTh.bSN;
            textView.setText(String.valueOf(topRecActivity.getPageContext().getString(i.h.done)) + "(99+)");
        }
        textView2 = this.bTh.bTe;
        textView2.invalidate();
        textView3 = this.bTh.bTe;
        animation2 = this.bTh.bTg;
        textView3.setAnimation(animation2);
        animation3 = this.bTh.bTg;
        animation3.start();
        textView4 = this.bTh.bTe;
        textView4.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
