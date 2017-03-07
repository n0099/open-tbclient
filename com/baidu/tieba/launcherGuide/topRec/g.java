package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.Button;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Animation.AnimationListener {
    final /* synthetic */ e dsJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.dsJ = eVar;
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
        i = this.dsJ.dsF;
        if (i < 100) {
            button3 = this.dsJ.dsA;
            topRecActivity2 = this.dsJ.dsp;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(w.l.done))).append("(");
            i2 = this.dsJ.dsF;
            button3.setText(append.append(i2).append(")").toString());
        } else {
            button = this.dsJ.dsA;
            topRecActivity = this.dsJ.dsp;
            button.setText(String.valueOf(topRecActivity.getPageContext().getString(w.l.done)) + "(99+)");
        }
        button2 = this.dsJ.dsA;
        button2.invalidate();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
