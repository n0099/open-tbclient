package com.baidu.tieba.pb;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements Animation.AnimationListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.a.av = true;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        TranslateAnimation translateAnimation;
        TranslateAnimation translateAnimation2;
        Button button;
        TextView textView;
        Button button2;
        Button button3;
        TextView textView2;
        Button button4;
        this.a.av = false;
        translateAnimation = this.a.as;
        if (animation != translateAnimation) {
            translateAnimation2 = this.a.at;
            if (animation == translateAnimation2) {
                this.a.aw = true;
                button = this.a.j;
                button.setClickable(true);
                textView = this.a.f;
                textView.setClickable(true);
                button2 = this.a.m;
                button2.setClickable(true);
                return;
            }
            return;
        }
        this.a.aw = false;
        button3 = this.a.j;
        button3.setClickable(false);
        textView2 = this.a.f;
        textView2.setClickable(false);
        button4 = this.a.m;
        button4.setClickable(false);
    }
}
