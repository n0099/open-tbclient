package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.Button;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Animation.AnimationListener {
    final /* synthetic */ e cFn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.cFn = eVar;
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
        i = this.cFn.cFj;
        if (i < 100) {
            button3 = this.cFn.cFe;
            topRecActivity2 = this.cFn.cEU;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(t.j.done))).append("(");
            i2 = this.cFn.cFj;
            button3.setText(append.append(i2).append(")").toString());
        } else {
            button = this.cFn.cFe;
            topRecActivity = this.cFn.cEU;
            button.setText(String.valueOf(topRecActivity.getPageContext().getString(t.j.done)) + "(99+)");
        }
        button2 = this.cFn.cFe;
        button2.invalidate();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
