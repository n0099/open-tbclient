package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Animation.AnimationListener {
    private final /* synthetic */ GifView aQI;
    private final /* synthetic */ TextView aQL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(GifView gifView, TextView textView) {
        this.aQI = gifView;
        this.aQL = textView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.aQI.setVisibility(0);
        this.aQI.DI();
        com.baidu.adp.lib.g.h.fS().postDelayed(new v(this, this.aQL), 800L);
    }
}
