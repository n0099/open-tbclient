package com.baidu.tieba.view;

import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.view.CommonTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animation.AnimationListener {
    final /* synthetic */ CommonTipView eWi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CommonTipView commonTipView) {
        this.eWi = commonTipView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        CommonTipView.a aVar;
        CommonTipView.a aVar2;
        this.eWi.onDestroy();
        ViewGroup viewGroup = (ViewGroup) this.eWi.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.eWi);
        }
        aVar = this.eWi.eWh;
        if (aVar != null) {
            aVar2 = this.eWi.eWh;
            aVar2.bba();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
