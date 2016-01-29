package com.baidu.tieba;

import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Animation.AnimationListener {
    private final /* synthetic */ GifView aHQ;
    private final /* synthetic */ TextView aHT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(GifView gifView, TextView textView) {
        this.aHQ = gifView;
        this.aHT = textView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.aHQ.setVisibility(0);
        this.aHQ.DY();
        com.baidu.adp.lib.h.h.hr().postDelayed(new s(this, this.aHT), 800L);
    }
}
