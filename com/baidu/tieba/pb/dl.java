package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dl implements Animation.AnimationListener {
    final /* synthetic */ cu a;
    private final /* synthetic */ com.baidu.tieba.data.av b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dl(cu cuVar, com.baidu.tieba.data.av avVar, boolean z, String str, String str2) {
        this.a = cuVar;
        this.b = avVar;
        this.c = z;
        this.d = str;
        this.e = str2;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        new Handler().post(new dm(this, this.b, this.c, this.d, this.e));
    }
}
