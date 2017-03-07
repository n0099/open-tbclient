package com.baidu.tieba.play;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Animation.AnimationListener {
    final /* synthetic */ c eWb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(c cVar) {
        this.eWb = cVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        View view2;
        ProgressBar progressBar;
        c.InterfaceC0071c interfaceC0071c;
        c.InterfaceC0071c interfaceC0071c2;
        view = this.eWb.dxx;
        if (view != null) {
            view2 = this.eWb.dxx;
            view2.setVisibility(8);
            progressBar = this.eWb.eVP;
            progressBar.setVisibility(0);
            this.eWb.dxU = false;
            interfaceC0071c = this.eWb.eVX;
            if (interfaceC0071c != null) {
                interfaceC0071c2 = this.eWb.eVX;
                interfaceC0071c2.aPn();
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
