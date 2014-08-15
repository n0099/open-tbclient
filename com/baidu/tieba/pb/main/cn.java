package com.baidu.tieba.pb.main;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements com.baidu.tieba.c.b {
    final /* synthetic */ bs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(bs bsVar) {
        this.a = bsVar;
    }

    @Override // com.baidu.tieba.c.b
    public boolean a(View view, MotionEvent motionEvent) {
        this.a.k(false);
        this.a.b(view);
        this.a.k(true);
        return true;
    }

    @Override // com.baidu.tieba.c.b
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.c.b
    public boolean c(View view, MotionEvent motionEvent) {
        this.a.b();
        this.a.ad();
        return false;
    }
}
