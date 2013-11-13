package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements com.baidu.tieba.c.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cp f2122a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(cp cpVar) {
        this.f2122a = cpVar;
    }

    @Override // com.baidu.tieba.c.b
    public boolean a(View view, MotionEvent motionEvent) {
        this.f2122a.k(false);
        this.f2122a.b(view);
        this.f2122a.k(true);
        return true;
    }

    @Override // com.baidu.tieba.c.b
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.c.b
    public boolean c(View view, MotionEvent motionEvent) {
        return false;
    }
}
