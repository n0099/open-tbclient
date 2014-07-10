package com.baidu.tieba.topRec;

import android.view.animation.Animation;
import android.widget.Button;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Animation.AnimationListener {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.a = gVar;
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
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getString(y.done))).append("(");
            i2 = this.a.k;
            button3.setText(append.append(i2).append(")").toString());
        } else {
            button = this.a.d;
            topRecActivity = this.a.j;
            button.setText(String.valueOf(topRecActivity.getString(y.done)) + "(99+)");
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
