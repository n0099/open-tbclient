package com.baidu.tieba.play;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Animation.AnimationListener {
    final /* synthetic */ c eSu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(c cVar) {
        this.eSu = cVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        View view2;
        ProgressBar progressBar;
        c.InterfaceC0072c interfaceC0072c;
        c.InterfaceC0072c interfaceC0072c2;
        view = this.eSu.duX;
        if (view != null) {
            view2 = this.eSu.duX;
            view2.setVisibility(8);
            progressBar = this.eSu.eSl;
            progressBar.setVisibility(0);
            this.eSu.dvw = false;
            interfaceC0072c = this.eSu.eSr;
            if (interfaceC0072c != null) {
                interfaceC0072c2 = this.eSu.eSr;
                interfaceC0072c2.aOr();
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
