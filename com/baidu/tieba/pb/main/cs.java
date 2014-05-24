package com.baidu.tieba.pb.main;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements com.baidu.tieba.b.b {
    final /* synthetic */ bq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(bq bqVar) {
        this.a = bqVar;
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
