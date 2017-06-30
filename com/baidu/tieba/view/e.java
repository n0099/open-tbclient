package com.baidu.tieba.view;

import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.view.CommonTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animation.AnimationListener {
    final /* synthetic */ CommonTipView fZX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CommonTipView commonTipView) {
        this.fZX = commonTipView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        CommonTipView.a aVar;
        CommonTipView.a aVar2;
        this.fZX.onDestroy();
        ViewGroup viewGroup = (ViewGroup) this.fZX.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.fZX);
        }
        aVar = this.fZX.fZW;
        if (aVar != null) {
            aVar2 = this.fZX.fZW;
            aVar2.bqA();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
