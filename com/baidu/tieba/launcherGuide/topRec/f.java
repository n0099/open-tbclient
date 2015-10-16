package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ e bTs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bTs = eVar;
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
        i = this.bTs.bTo;
        if (i < 100) {
            textView5 = this.bTs.bTp;
            topRecActivity2 = this.bTs.bSY;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(i.h.done))).append("(");
            i2 = this.bTs.bTo;
            textView5.setText(append.append(i2).append(")").toString());
        } else {
            textView = this.bTs.bTp;
            topRecActivity = this.bTs.bSY;
            textView.setText(String.valueOf(topRecActivity.getPageContext().getString(i.h.done)) + "(99+)");
        }
        textView2 = this.bTs.bTp;
        textView2.invalidate();
        textView3 = this.bTs.bTp;
        animation2 = this.bTs.bTr;
        textView3.setAnimation(animation2);
        animation3 = this.bTs.bTr;
        animation3.start();
        textView4 = this.bTs.bTp;
        textView4.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
