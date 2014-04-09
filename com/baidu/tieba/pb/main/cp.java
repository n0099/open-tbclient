package com.baidu.tieba.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cp implements com.baidu.tieba.c.b {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(bm bmVar) {
        this.a = bmVar;
    }

    @Override // com.baidu.tieba.c.b
    public final boolean a(View view) {
        bm.a(this.a, false);
        bm.a(this.a, view);
        bm.a(this.a, true);
        return true;
    }

    @Override // com.baidu.tieba.c.b
    public final boolean a() {
        this.a.b();
        this.a.ab();
        return false;
    }
}
