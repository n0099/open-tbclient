package com.baidu.tieba.write;

import android.view.animation.Animation;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AudioIcon f2120a;
    private final /* synthetic */ List b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AudioIcon audioIcon, List list) {
        this.f2120a = audioIcon;
        this.b = list;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        int i;
        int i2;
        i = AudioIcon.g;
        int i3 = i + 1;
        AudioIcon.g = i3;
        if (i3 < this.b.size()) {
            AudioIcon audioIcon = this.f2120a;
            List list = this.b;
            i2 = AudioIcon.g;
            audioIcon.startAnimation((Animation) list.get(i2));
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
