package com.baidu.tieba.topRec;

import android.view.animation.Animation;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f2452a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f2452a = hVar;
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
        i = this.f2452a.k;
        if (i < 100) {
            textView5 = this.f2452a.m;
            StringBuilder sb = new StringBuilder();
            topRecActivity2 = this.f2452a.j;
            StringBuilder append = sb.append(topRecActivity2.getString(R.string.done)).append("(");
            i2 = this.f2452a.k;
            textView5.setText(append.append(i2).append(")").toString());
        } else {
            textView = this.f2452a.m;
            StringBuilder sb2 = new StringBuilder();
            topRecActivity = this.f2452a.j;
            textView.setText(sb2.append(topRecActivity.getString(R.string.done)).append("(99+)").toString());
        }
        textView2 = this.f2452a.m;
        textView2.invalidate();
        textView3 = this.f2452a.m;
        animation2 = this.f2452a.p;
        textView3.setAnimation(animation2);
        animation3 = this.f2452a.p;
        animation3.start();
        textView4 = this.f2452a.m;
        textView4.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
