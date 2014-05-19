package com.baidu.tieba.pb.main;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements com.baidu.tieba.b.b {
    final /* synthetic */ bj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(bj bjVar) {
        this.a = bjVar;
    }

    @Override // com.baidu.tieba.b.b
    public boolean a(View view, MotionEvent motionEvent) {
        this.a.j(false);
        this.a.b(view);
        this.a.j(true);
        return true;
    }

    @Override // com.baidu.tieba.b.b
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.b.b
    public boolean c(View view, MotionEvent motionEvent) {
        this.a.b();
        this.a.ac();
        return false;
    }
}
