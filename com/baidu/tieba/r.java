package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Animation.AnimationListener {
    private final /* synthetic */ GifView aGX;
    private final /* synthetic */ TextView aHa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(GifView gifView, TextView textView) {
        this.aGX = gifView;
        this.aHa = textView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.aGX.setVisibility(0);
        this.aGX.CC();
        com.baidu.adp.lib.h.h.dL().postDelayed(new s(this, this.aHa), 800L);
    }
}
