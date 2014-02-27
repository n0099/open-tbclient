package com.baidu.tieba.pb;

import android.view.animation.Animation;
import com.baidu.tieba.view.NavigationBar;
/* loaded from: classes.dex */
final class f implements Animation.AnimationListener {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        ImageActivity imageActivity;
        ImageActivity imageActivity2;
        boolean z;
        ImageActivity imageActivity3;
        ImageActivity imageActivity4;
        NavigationBar navigationBar;
        imageActivity = this.a.a;
        imageActivity.r = true;
        imageActivity2 = this.a.a;
        z = imageActivity2.s;
        if (z) {
            imageActivity3 = this.a.a;
            imageActivity3.s = false;
            imageActivity4 = this.a.a;
            navigationBar = imageActivity4.l;
            navigationBar.setVisibility(8);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
