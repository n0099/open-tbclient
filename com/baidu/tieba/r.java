package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Animation.AnimationListener {
    private final /* synthetic */ GifView aKM;
    private final /* synthetic */ TextView aKP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(GifView gifView, TextView textView) {
        this.aKM = gifView;
        this.aKP = textView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.aKM.setVisibility(0);
        this.aKM.EJ();
        com.baidu.adp.lib.h.h.hx().postDelayed(new s(this, this.aKP), 800L);
    }
}
