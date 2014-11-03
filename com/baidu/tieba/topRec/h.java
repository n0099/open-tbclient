package com.baidu.tieba.topRec;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Animation.AnimationListener {
    final /* synthetic */ g bQd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bQd = gVar;
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
        i = this.bQd.bPZ;
        if (i < 100) {
            textView5 = this.bQd.bQa;
            topRecActivity2 = this.bQd.bPO;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getString(y.done))).append("(");
            i2 = this.bQd.bPZ;
            textView5.setText(append.append(i2).append(")").toString());
        } else {
            textView = this.bQd.bQa;
            topRecActivity = this.bQd.bPO;
            textView.setText(String.valueOf(topRecActivity.getString(y.done)) + "(99+)");
        }
        textView2 = this.bQd.bQa;
        textView2.invalidate();
        textView3 = this.bQd.bQa;
        animation2 = this.bQd.bQc;
        textView3.setAnimation(animation2);
        animation3 = this.bQd.bQc;
        animation3.start();
        textView4 = this.bQd.bQa;
        textView4.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
