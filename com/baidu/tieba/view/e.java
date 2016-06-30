package com.baidu.tieba.view;

import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.view.CommonTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animation.AnimationListener {
    final /* synthetic */ CommonTipView fAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CommonTipView commonTipView) {
        this.fAW = commonTipView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        CommonTipView.a aVar;
        CommonTipView.a aVar2;
        this.fAW.onDestroy();
        ViewGroup viewGroup = (ViewGroup) this.fAW.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.fAW);
        }
        aVar = this.fAW.fAV;
        if (aVar != null) {
            aVar2 = this.fAW.fAV;
            aVar2.bjo();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
