package com.baidu.tieba.view;

import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.view.CommonTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animation.AnimationListener {
    final /* synthetic */ CommonTipView fHF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CommonTipView commonTipView) {
        this.fHF = commonTipView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        CommonTipView.a aVar;
        CommonTipView.a aVar2;
        this.fHF.onDestroy();
        ViewGroup viewGroup = (ViewGroup) this.fHF.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.fHF);
        }
        aVar = this.fHF.fHE;
        if (aVar != null) {
            aVar2 = this.fHF.fHE;
            aVar2.blB();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
