package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ e dqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.dqq = eVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        int i;
        TextView textView;
        TopRecActivity topRecActivity;
        TextView textView2;
        TextView textView3;
        Animation animation2;
        Animation animation3;
        TextView textView4;
        TextView textView5;
        TopRecActivity topRecActivity2;
        int i2;
        i = this.dqq.dqm;
        if (i < 100) {
            textView5 = this.dqq.dqn;
            topRecActivity2 = this.dqq.dpW;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(r.l.done))).append("(");
            i2 = this.dqq.dqm;
            textView5.setText(append.append(i2).append(")").toString());
        } else {
            textView = this.dqq.dqn;
            topRecActivity = this.dqq.dpW;
            textView.setText(String.valueOf(topRecActivity.getPageContext().getString(r.l.done)) + "(99+)");
        }
        textView2 = this.dqq.dqn;
        textView2.invalidate();
        textView3 = this.dqq.dqn;
        animation2 = this.dqq.dqp;
        textView3.setAnimation(animation2);
        animation3 = this.dqq.dqp;
        animation3.start();
        textView4 = this.dqq.dqn;
        textView4.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
