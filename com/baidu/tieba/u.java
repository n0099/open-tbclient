package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Animation.AnimationListener {
    private final /* synthetic */ GifView aQn;
    private final /* synthetic */ TextView aQq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(GifView gifView, TextView textView) {
        this.aQn = gifView;
        this.aQq = textView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.aQn.setVisibility(0);
        this.aQn.EE();
        com.baidu.adp.lib.g.h.fR().postDelayed(new v(this, this.aQq), 800L);
    }
}
