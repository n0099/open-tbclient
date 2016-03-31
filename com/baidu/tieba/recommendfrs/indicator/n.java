package com.baidu.tieba.recommendfrs.indicator;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.recommendfrs.indicator.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.adp.lib.h.d {
    final /* synthetic */ l dXy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.dXy = lVar;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        l.a aVar;
        ViewGroup viewGroup;
        View view;
        l.a aVar2;
        this.dXy.avm = false;
        aVar = this.dXy.dXw;
        if (aVar != null) {
            aVar2 = this.dXy.dXw;
            aVar2.aok();
        }
        viewGroup = this.dXy.cIs;
        view = this.dXy.aAh;
        viewGroup.removeView(view);
    }
}
