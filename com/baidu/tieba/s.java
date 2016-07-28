package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Animation.AnimationListener {
    private final /* synthetic */ GifView aIq;
    private final /* synthetic */ TextView aIt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(GifView gifView, TextView textView) {
        this.aIq = gifView;
        this.aIt = textView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.aIq.setVisibility(0);
        this.aIq.CK();
        com.baidu.adp.lib.h.h.dL().postDelayed(new t(this, this.aIt), 800L);
    }
}
