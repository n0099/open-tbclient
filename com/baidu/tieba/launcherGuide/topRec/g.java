package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.Button;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Animation.AnimationListener {
    final /* synthetic */ e cFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.cFg = eVar;
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
        i = this.cFg.cFc;
        if (i < 100) {
            button3 = this.cFg.cEX;
            topRecActivity2 = this.cFg.cEM;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(t.j.done))).append("(");
            i2 = this.cFg.cFc;
            button3.setText(append.append(i2).append(")").toString());
        } else {
            button = this.cFg.cEX;
            topRecActivity = this.cFg.cEM;
            button.setText(String.valueOf(topRecActivity.getPageContext().getString(t.j.done)) + "(99+)");
        }
        button2 = this.cFg.cEX;
        button2.invalidate();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
