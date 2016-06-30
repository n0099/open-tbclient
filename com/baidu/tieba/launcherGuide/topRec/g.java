package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.Button;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Animation.AnimationListener {
    final /* synthetic */ e dkE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.dkE = eVar;
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
        i = this.dkE.dkA;
        if (i < 100) {
            button3 = this.dkE.dkv;
            topRecActivity2 = this.dkE.dkm;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(u.j.done))).append("(");
            i2 = this.dkE.dkA;
            button3.setText(append.append(i2).append(")").toString());
        } else {
            button = this.dkE.dkv;
            topRecActivity = this.dkE.dkm;
            button.setText(String.valueOf(topRecActivity.getPageContext().getString(u.j.done)) + "(99+)");
        }
        button2 = this.dkE.dkv;
        button2.invalidate();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
