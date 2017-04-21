package com.baidu.tieba.play;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Animation.AnimationListener {
    final /* synthetic */ c eWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(c cVar) {
        this.eWq = cVar;
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
        view = this.eWq.dwy;
        if (view != null) {
            view2 = this.eWq.dwy;
            view2.setVisibility(8);
            progressBar = this.eWq.eWe;
            progressBar.setVisibility(0);
            this.eWq.dwI = false;
            interfaceC0070c = this.eWq.eWm;
            if (interfaceC0070c != null) {
                interfaceC0070c2 = this.eWq.eWm;
                interfaceC0070c2.aQx();
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
