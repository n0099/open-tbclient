package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.Button;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Animation.AnimationListener {
    final /* synthetic */ e djg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.djg = eVar;
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
        i = this.djg.djc;
        if (i < 100) {
            button3 = this.djg.diX;
            topRecActivity2 = this.djg.diM;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(r.j.done))).append("(");
            i2 = this.djg.djc;
            button3.setText(append.append(i2).append(")").toString());
        } else {
            button = this.djg.diX;
            topRecActivity = this.djg.diM;
            button.setText(String.valueOf(topRecActivity.getPageContext().getString(r.j.done)) + "(99+)");
        }
        button2 = this.djg.diX;
        button2.invalidate();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
