package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ e ckb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.ckb = eVar;
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
        i = this.ckb.cjX;
        if (i < 100) {
            textView5 = this.ckb.cjY;
            topRecActivity2 = this.ckb.cjH;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(n.i.done))).append("(");
            i2 = this.ckb.cjX;
            textView5.setText(append.append(i2).append(")").toString());
        } else {
            textView = this.ckb.cjY;
            topRecActivity = this.ckb.cjH;
            textView.setText(String.valueOf(topRecActivity.getPageContext().getString(n.i.done)) + "(99+)");
        }
        textView2 = this.ckb.cjY;
        textView2.invalidate();
        textView3 = this.ckb.cjY;
        animation2 = this.ckb.cka;
        textView3.setAnimation(animation2);
        animation3 = this.ckb.cka;
        animation3.start();
        textView4 = this.ckb.cjY;
        textView4.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
