package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.Button;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Animation.AnimationListener {
    final /* synthetic */ e bTh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.bTh = eVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        int i;
        Button button;
        TopRecActivity topRecActivity;
        Button button2;
        Button button3;
        TopRecActivity topRecActivity2;
        int i2;
        i = this.bTh.bTd;
        if (i < 100) {
            button3 = this.bTh.bSY;
            topRecActivity2 = this.bTh.bSN;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(i.h.done))).append("(");
            i2 = this.bTh.bTd;
            button3.setText(append.append(i2).append(")").toString());
        } else {
            button = this.bTh.bSY;
            topRecActivity = this.bTh.bSN;
            button.setText(String.valueOf(topRecActivity.getPageContext().getString(i.h.done)) + "(99+)");
        }
        button2 = this.bTh.bSY;
        button2.invalidate();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
