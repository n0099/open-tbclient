package com.baidu.tieba.play;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Animation.AnimationListener {
    final /* synthetic */ c eUa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(c cVar) {
        this.eUa = cVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        View view2;
        ProgressBar progressBar;
        c.InterfaceC0070c interfaceC0070c;
        c.InterfaceC0070c interfaceC0070c2;
        view = this.eUa.duh;
        if (view != null) {
            view2 = this.eUa.duh;
            view2.setVisibility(8);
            progressBar = this.eUa.eTO;
            progressBar.setVisibility(0);
            this.eUa.dur = false;
            interfaceC0070c = this.eUa.eTW;
            if (interfaceC0070c != null) {
                interfaceC0070c2 = this.eUa.eTW;
                interfaceC0070c2.aPw();
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
