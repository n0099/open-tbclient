package com.baidu.tieba.play;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Animation.AnimationListener {
    final /* synthetic */ c fbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(c cVar) {
        this.fbb = cVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        View view2;
        ProgressBar progressBar;
        c.InterfaceC0078c interfaceC0078c;
        c.InterfaceC0078c interfaceC0078c2;
        view = this.fbb.dvZ;
        if (view != null) {
            view2 = this.fbb.dvZ;
            view2.setVisibility(8);
            progressBar = this.fbb.faO;
            progressBar.setVisibility(0);
            this.fbb.dwj = false;
            interfaceC0078c = this.fbb.faW;
            if (interfaceC0078c != null) {
                interfaceC0078c2 = this.fbb.faW;
                interfaceC0078c2.aPc();
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
