package com.baidu.tieba.recommend;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f2405a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.f2405a = yVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        TextView textView;
        textView = this.f2405a.i;
        textView.setVisibility(8);
    }
}
