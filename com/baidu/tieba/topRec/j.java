package com.baidu.tieba.topRec;

import android.view.animation.Animation;
import android.widget.Button;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f2553a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.f2553a = hVar;
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
        i = this.f2553a.k;
        if (i < 100) {
            button3 = this.f2553a.d;
            StringBuilder sb = new StringBuilder();
            topRecActivity2 = this.f2553a.j;
            StringBuilder append = sb.append(topRecActivity2.getString(R.string.done)).append("(");
            i2 = this.f2553a.k;
            button3.setText(append.append(i2).append(")").toString());
        } else {
            button = this.f2553a.d;
            StringBuilder sb2 = new StringBuilder();
            topRecActivity = this.f2553a.j;
            button.setText(sb2.append(topRecActivity.getString(R.string.done)).append("(99+)").toString());
        }
        button2 = this.f2553a.d;
        button2.invalidate();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
