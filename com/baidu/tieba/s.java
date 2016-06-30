package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Animation.AnimationListener {
    private final /* synthetic */ TextView aHC;
    private final /* synthetic */ GifView aHz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(GifView gifView, TextView textView) {
        this.aHz = gifView;
        this.aHC = textView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.aHz.setVisibility(0);
        this.aHz.CL();
        com.baidu.adp.lib.h.h.dM().postDelayed(new t(this, this.aHC), 800L);
    }
}
