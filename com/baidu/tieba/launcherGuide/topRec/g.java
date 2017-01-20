package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.Button;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Animation.AnimationListener {
    final /* synthetic */ e dqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.dqq = eVar;
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
        i = this.dqq.dqm;
        if (i < 100) {
            button3 = this.dqq.dqh;
            topRecActivity2 = this.dqq.dpW;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(r.l.done))).append("(");
            i2 = this.dqq.dqm;
            button3.setText(append.append(i2).append(")").toString());
        } else {
            button = this.dqq.dqh;
            topRecActivity = this.dqq.dpW;
            button.setText(String.valueOf(topRecActivity.getPageContext().getString(r.l.done)) + "(99+)");
        }
        button2 = this.dqq.dqh;
        button2.invalidate();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
