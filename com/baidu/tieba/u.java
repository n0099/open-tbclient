package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Animation.AnimationListener {
    private final /* synthetic */ GifView aSc;
    private final /* synthetic */ TextView aSf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(GifView gifView, TextView textView) {
        this.aSc = gifView;
        this.aSf = textView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.aSc.setVisibility(0);
        this.aSc.DW();
        com.baidu.adp.lib.g.h.fR().postDelayed(new v(this, this.aSf), 800L);
    }
}
