package com.baidu.tieba.topRec;

import android.view.animation.Animation;
import android.widget.Button;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1872a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.f1872a = hVar;
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
        i = this.f1872a.l;
        if (i < 100) {
            button3 = this.f1872a.e;
            topRecActivity2 = this.f1872a.k;
            StringBuilder append = new StringBuilder(String.valueOf(topRecActivity2.getString(R.string.done))).append("(");
            i2 = this.f1872a.l;
            button3.setText(append.append(i2).append(")").toString());
        } else {
            button = this.f1872a.e;
            topRecActivity = this.f1872a.k;
            button.setText(String.valueOf(topRecActivity.getString(R.string.done)) + "(99+)");
        }
        button2 = this.f1872a.e;
        button2.invalidate();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
