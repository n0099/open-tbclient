package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.Button;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Animation.AnimationListener {
    final /* synthetic */ e dnD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.dnD = eVar;
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
        i = this.dnD.dnz;
        if (i < 100) {
            button3 = this.dnD.dnu;
            topRecActivity2 = this.dnD.dnl;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(u.j.done))).append("(");
            i2 = this.dnD.dnz;
            button3.setText(append.append(i2).append(")").toString());
        } else {
            button = this.dnD.dnu;
            topRecActivity = this.dnD.dnl;
            button.setText(String.valueOf(topRecActivity.getPageContext().getString(u.j.done)) + "(99+)");
        }
        button2 = this.dnD.dnu;
        button2.invalidate();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
