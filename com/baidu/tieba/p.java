package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Animation.AnimationListener {
    private final /* synthetic */ GifView aKl;
    private final /* synthetic */ TextView aKo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(GifView gifView, TextView textView) {
        this.aKl = gifView;
        this.aKo = textView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.aKl.setVisibility(0);
        this.aKl.DN();
        com.baidu.adp.lib.g.h.eE().postDelayed(new q(this, this.aKo), 800L);
    }
}
