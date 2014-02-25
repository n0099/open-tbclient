package com.baidu.tieba.pb;

import android.view.animation.Animation;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx implements Animation.AnimationListener {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(cu cuVar) {
        this.a = cuVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        NewPbActivity newPbActivity;
        this.a.f.setVisibility(4);
        newPbActivity = this.a.h;
        newPbActivity.showToast(R.string.pb_double_click_tips, 0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
