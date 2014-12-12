package com.baidu.tieba.topRec;

import android.view.animation.Animation;
import android.widget.Button;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Animation.AnimationListener {
    final /* synthetic */ g cdd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.cdd = gVar;
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
        i = this.cdd.ccZ;
        if (i < 100) {
            button3 = this.cdd.ccU;
            topRecActivity2 = this.cdd.ccO;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(z.done))).append("(");
            i2 = this.cdd.ccZ;
            button3.setText(append.append(i2).append(")").toString());
        } else {
            button = this.cdd.ccU;
            topRecActivity = this.cdd.ccO;
            button.setText(String.valueOf(topRecActivity.getPageContext().getString(z.done)) + "(99+)");
        }
        button2 = this.cdd.ccU;
        button2.invalidate();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
