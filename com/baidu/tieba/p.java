package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Animation.AnimationListener {
    private final /* synthetic */ GifView aLS;
    private final /* synthetic */ TextView aLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(GifView gifView, TextView textView) {
        this.aLS = gifView;
        this.aLV = textView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.aLS.setVisibility(0);
        this.aLS.Ek();
        com.baidu.adp.lib.h.h.eG().postDelayed(new q(this, this.aLV), 800L);
    }
}
