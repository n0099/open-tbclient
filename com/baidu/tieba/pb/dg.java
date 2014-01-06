package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dg implements Animation.AnimationListener {
    final /* synthetic */ com.baidu.tieba.data.ax a;
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ cs e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(cs csVar, com.baidu.tieba.data.ax axVar, boolean z, String str, String str2) {
        this.e = csVar;
        this.a = axVar;
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
        new Handler().post(new dh(this));
    }
}
