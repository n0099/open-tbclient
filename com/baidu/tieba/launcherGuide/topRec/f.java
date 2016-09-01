package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ e dzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.dzl = eVar;
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
        i = this.dzl.dzh;
        if (i < 100) {
            textView5 = this.dzl.dzi;
            topRecActivity2 = this.dzl.dyT;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(t.j.done))).append("(");
            i2 = this.dzl.dzh;
            textView5.setText(append.append(i2).append(")").toString());
        } else {
            textView = this.dzl.dzi;
            topRecActivity = this.dzl.dyT;
            textView.setText(String.valueOf(topRecActivity.getPageContext().getString(t.j.done)) + "(99+)");
        }
        textView2 = this.dzl.dzi;
        textView2.invalidate();
        textView3 = this.dzl.dzi;
        animation2 = this.dzl.dzk;
        textView3.setAnimation(animation2);
        animation3 = this.dzl.dzk;
        animation3.start();
        textView4 = this.dzl.dzi;
        textView4.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
