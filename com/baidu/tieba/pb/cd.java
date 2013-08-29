package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class cd implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bo f1533a;
    private final /* synthetic */ com.baidu.tieba.data.bd b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bo boVar, com.baidu.tieba.data.bd bdVar, boolean z, String str) {
        this.f1533a = boVar;
        this.b = bdVar;
        this.c = z;
        this.d = str;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        new Handler().post(new ce(this, this.b, this.c, this.d));
    }
}
