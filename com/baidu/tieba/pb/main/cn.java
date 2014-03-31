package com.baidu.tieba.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cn implements com.baidu.tieba.c.b {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(bk bkVar) {
        this.a = bkVar;
    }

    @Override // com.baidu.tieba.c.b
    public final boolean a(View view) {
        bk.a(this.a, false);
        bk.a(this.a, view);
        bk.a(this.a, true);
        return true;
    }

    @Override // com.baidu.tieba.c.b
    public final boolean a() {
        this.a.b();
        this.a.ab();
        return false;
    }
}
