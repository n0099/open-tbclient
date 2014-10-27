package com.baidu.tieba.topRec;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Animation.AnimationListener {
    final /* synthetic */ g bPO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bPO = gVar;
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
        i = this.bPO.bPK;
        if (i < 100) {
            textView5 = this.bPO.bPL;
            topRecActivity2 = this.bPO.bPz;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getString(y.done))).append("(");
            i2 = this.bPO.bPK;
            textView5.setText(append.append(i2).append(")").toString());
        } else {
            textView = this.bPO.bPL;
            topRecActivity = this.bPO.bPz;
            textView.setText(String.valueOf(topRecActivity.getString(y.done)) + "(99+)");
        }
        textView2 = this.bPO.bPL;
        textView2.invalidate();
        textView3 = this.bPO.bPL;
        animation2 = this.bPO.bPN;
        textView3.setAnimation(animation2);
        animation3 = this.bPO.bPN;
        animation3.start();
        textView4 = this.bPO.bPL;
        textView4.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
