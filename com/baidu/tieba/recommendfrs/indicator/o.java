package com.baidu.tieba.recommendfrs.indicator;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.recommendfrs.indicator.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.adp.lib.h.d {
    final /* synthetic */ m eaI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.eaI = mVar;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        m.a aVar;
        ViewGroup viewGroup;
        View view;
        m.a aVar2;
        this.eaI.arl = false;
        aVar = this.eaI.eaG;
        if (aVar != null) {
            aVar2 = this.eaI.eaG;
            aVar2.aoq();
        }
        viewGroup = this.eaI.cIW;
        view = this.eaI.awk;
        viewGroup.removeView(view);
    }
}
