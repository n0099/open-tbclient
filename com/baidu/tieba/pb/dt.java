package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dt implements com.baidu.tieba.g.b {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(cu cuVar) {
        this.a = cuVar;
    }

    @Override // com.baidu.tieba.g.b
    public boolean a(View view, MotionEvent motionEvent) {
        this.a.j(false);
        this.a.b(view);
        this.a.j(true);
        return true;
    }

    @Override // com.baidu.tieba.g.b
    public boolean b(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.g.b
    public boolean c(View view, MotionEvent motionEvent) {
        this.a.Y();
        return false;
    }
}
