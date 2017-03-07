package com.baidu.tieba.launcherGuide.topRec;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ e dsJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.dsJ = eVar;
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
        i = this.dsJ.dsF;
        if (i < 100) {
            textView5 = this.dsJ.dsG;
            topRecActivity2 = this.dsJ.dsp;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getPageContext().getString(w.l.done))).append("(");
            i2 = this.dsJ.dsF;
            textView5.setText(append.append(i2).append(")").toString());
        } else {
            textView = this.dsJ.dsG;
            topRecActivity = this.dsJ.dsp;
            textView.setText(String.valueOf(topRecActivity.getPageContext().getString(w.l.done)) + "(99+)");
        }
        textView2 = this.dsJ.dsG;
        textView2.invalidate();
        textView3 = this.dsJ.dsG;
        animation2 = this.dsJ.dsI;
        textView3.setAnimation(animation2);
        animation3 = this.dsJ.dsI;
        animation3.start();
        textView4 = this.dsJ.dsG;
        textView4.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
