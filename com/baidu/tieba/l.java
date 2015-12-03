package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Animation.AnimationListener {
    private final /* synthetic */ GifView aFo;
    private final /* synthetic */ TextView aFr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(GifView gifView, TextView textView) {
        this.aFo = gifView;
        this.aFr = textView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.aFo.setVisibility(0);
        this.aFo.CS();
        com.baidu.adp.lib.h.h.hj().postDelayed(new m(this, this.aFr), 800L);
    }
}
