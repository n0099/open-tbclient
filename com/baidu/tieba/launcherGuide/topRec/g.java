package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.Button;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Animation.AnimationListener {
    final /* synthetic */ e ckb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.ckb = eVar;
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
        i = this.ckb.cjX;
        if (i < 100) {
            button3 = this.ckb.cjS;
            topRecActivity2 = this.ckb.cjH;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(n.i.done))).append("(");
            i2 = this.ckb.cjX;
            button3.setText(append.append(i2).append(")").toString());
        } else {
            button = this.ckb.cjS;
            topRecActivity = this.ckb.cjH;
            button.setText(String.valueOf(topRecActivity.getPageContext().getString(n.i.done)) + "(99+)");
        }
        button2 = this.ckb.cjS;
        button2.invalidate();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
