package com.baidu.tieba.topRec;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Animation.AnimationListener {
    final /* synthetic */ g cdd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.cdd = gVar;
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
        i = this.cdd.ccZ;
        if (i < 100) {
            textView5 = this.cdd.cda;
            topRecActivity2 = this.cdd.ccO;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(z.done))).append("(");
            i2 = this.cdd.ccZ;
            textView5.setText(append.append(i2).append(")").toString());
        } else {
            textView = this.cdd.cda;
            topRecActivity = this.cdd.ccO;
            textView.setText(String.valueOf(topRecActivity.getPageContext().getString(z.done)) + "(99+)");
        }
        textView2 = this.cdd.cda;
        textView2.invalidate();
        textView3 = this.cdd.cda;
        animation2 = this.cdd.cdc;
        textView3.setAnimation(animation2);
        animation3 = this.cdd.cdc;
        animation3.start();
        textView4 = this.cdd.cda;
        textView4.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
