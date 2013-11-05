package com.baidu.tieba.write;

import android.view.animation.Animation;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f2665a;
    final /* synthetic */ AudioIcon b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AudioIcon audioIcon, List list) {
        this.b = audioIcon;
        this.f2665a = list;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        int i;
        if (AudioIcon.i() < this.f2665a.size()) {
            AudioIcon audioIcon = this.b;
            List list = this.f2665a;
            i = AudioIcon.g;
            audioIcon.startAnimation((Animation) list.get(i));
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
