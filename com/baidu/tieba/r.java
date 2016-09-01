package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Animation.AnimationListener {
    private final /* synthetic */ GifView aLH;
    private final /* synthetic */ TextView aLK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(GifView gifView, TextView textView) {
        this.aLH = gifView;
        this.aLK = textView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.aLH.setVisibility(0);
        this.aLH.Ef();
        com.baidu.adp.lib.h.h.eG().postDelayed(new s(this, this.aLK), 800L);
    }
}
