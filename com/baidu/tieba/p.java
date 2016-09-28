package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Animation.AnimationListener {
    private final /* synthetic */ GifView aLb;
    private final /* synthetic */ TextView aLe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(GifView gifView, TextView textView) {
        this.aLb = gifView;
        this.aLe = textView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.aLb.setVisibility(0);
        this.aLb.Ef();
        com.baidu.adp.lib.h.h.eG().postDelayed(new q(this, this.aLe), 800L);
    }
}
