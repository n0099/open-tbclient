package com.baidu.tieba.topRec;

import android.view.animation.Animation;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1871a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f1871a = hVar;
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
        i = this.f1871a.l;
        if (i < 100) {
            textView5 = this.f1871a.n;
            topRecActivity2 = this.f1871a.k;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getString(R.string.done))).append("(");
            i2 = this.f1871a.l;
            textView5.setText(append.append(i2).append(")").toString());
        } else {
            textView = this.f1871a.n;
            topRecActivity = this.f1871a.k;
            textView.setText(String.valueOf(topRecActivity.getString(R.string.done)) + "(99+)");
        }
        textView2 = this.f1871a.n;
        textView2.invalidate();
        textView3 = this.f1871a.n;
        animation2 = this.f1871a.q;
        textView3.setAnimation(animation2);
        animation3 = this.f1871a.q;
        animation3.start();
        textView4 = this.f1871a.n;
        textView4.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
