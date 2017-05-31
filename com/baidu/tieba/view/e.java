package com.baidu.tieba.view;

import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.view.CommonTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animation.AnimationListener {
    final /* synthetic */ CommonTipView fQg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CommonTipView commonTipView) {
        this.fQg = commonTipView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        CommonTipView.a aVar;
        CommonTipView.a aVar2;
        this.fQg.onDestroy();
        ViewGroup viewGroup = (ViewGroup) this.fQg.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.fQg);
        }
        aVar = this.fQg.fQf;
        if (aVar != null) {
            aVar2 = this.fQg.fQf;
            aVar2.bmq();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
