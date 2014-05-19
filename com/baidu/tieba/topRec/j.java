package com.baidu.tieba.topRec;

import android.view.animation.Animation;
import android.widget.Button;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Animation.AnimationListener {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.a = hVar;
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
        i = this.a.k;
        if (i < 100) {
            button3 = this.a.d;
            topRecActivity2 = this.a.j;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getString(u.done))).append("(");
            i2 = this.a.k;
            button3.setText(append.append(i2).append(")").toString());
        } else {
            button = this.a.d;
            topRecActivity = this.a.j;
            button.setText(String.valueOf(topRecActivity.getString(u.done)) + "(99+)");
        }
        button2 = this.a.d;
        button2.invalidate();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
