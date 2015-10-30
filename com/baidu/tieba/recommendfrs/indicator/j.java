package com.baidu.tieba.recommendfrs.indicator;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.recommendfrs.indicator.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.lib.g.d {
    final /* synthetic */ h cJu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.cJu = hVar;
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h.a aVar;
        ViewGroup viewGroup;
        View view;
        h.a aVar2;
        this.cJu.arH = false;
        aVar = this.cJu.cJs;
        if (aVar != null) {
            aVar2 = this.cJu.cJs;
            aVar2.aqw();
        }
        viewGroup = this.cJu.cJr;
        view = this.cJu.rootView;
        viewGroup.removeView(view);
    }
}
