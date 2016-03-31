package com.baidu.tieba.view;

import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.view.CommonTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Animation.AnimationListener {
    final /* synthetic */ CommonTipView eFv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CommonTipView commonTipView) {
        this.eFv = commonTipView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        CommonTipView.a aVar;
        CommonTipView.a aVar2;
        this.eFv.onDestroy();
        ViewGroup viewGroup = (ViewGroup) this.eFv.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.eFv);
        }
        aVar = this.eFv.eFu;
        if (aVar != null) {
            aVar2 = this.eFv.eFu;
            aVar2.aYC();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
