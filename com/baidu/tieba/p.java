package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Animation.AnimationListener {
    private final /* synthetic */ GifView aLj;
    private final /* synthetic */ TextView aLm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(GifView gifView, TextView textView) {
        this.aLj = gifView;
        this.aLm = textView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.aLj.setVisibility(0);
        this.aLj.DS();
        com.baidu.adp.lib.h.h.eG().postDelayed(new q(this, this.aLm), 800L);
    }
}
