package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dc implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.data.aw f2135a;
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ cp e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(cp cpVar, com.baidu.tieba.data.aw awVar, boolean z, String str, String str2) {
        this.e = cpVar;
        this.f2135a = awVar;
        this.b = z;
        this.c = str;
        this.d = str2;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        new Handler().post(new dd(this));
    }
}
