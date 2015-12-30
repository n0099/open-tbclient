package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Animation.AnimationListener {
    private final /* synthetic */ GifView aGO;
    private final /* synthetic */ TextView aGR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(GifView gifView, TextView textView) {
        this.aGO = gifView;
        this.aGR = textView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.aGO.setVisibility(0);
        this.aGO.CH();
        com.baidu.adp.lib.h.h.hj().postDelayed(new m(this, this.aGR), 800L);
    }
}
