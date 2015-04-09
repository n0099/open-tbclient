package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.Button;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Animation.AnimationListener {
    final /* synthetic */ g byw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.byw = gVar;
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
        i = this.byw.bys;
        if (i < 100) {
            button3 = this.byw.byn;
            topRecActivity2 = this.byw.byc;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(y.done))).append("(");
            i2 = this.byw.bys;
            button3.setText(append.append(i2).append(")").toString());
        } else {
            button = this.byw.byn;
            topRecActivity = this.byw.byc;
            button.setText(String.valueOf(topRecActivity.getPageContext().getString(y.done)) + "(99+)");
        }
        button2 = this.byw.byn;
        button2.invalidate();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
