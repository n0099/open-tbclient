package com.baidu.tieba.recommendfrs.indicator;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.recommendfrs.indicator.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.adp.lib.h.d {
    final /* synthetic */ l dFF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.dFF = lVar;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        l.a aVar;
        ViewGroup viewGroup;
        View view;
        l.a aVar2;
        this.dFF.auM = false;
        aVar = this.dFF.dFD;
        if (aVar != null) {
            aVar2 = this.dFF.dFD;
            aVar2.aFO();
        }
        viewGroup = this.dFF.dFC;
        view = this.dFF.azA;
        viewGroup.removeView(view);
    }
}
