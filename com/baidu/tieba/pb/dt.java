package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dt implements com.baidu.tieba.g.b {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(cu cuVar) {
        this.a = cuVar;
    }

    @Override // com.baidu.tieba.g.b
    public final boolean a(View view) {
        cu.a(this.a, false);
        cu.a(this.a, view);
        cu.a(this.a, true);
        return true;
    }

    @Override // com.baidu.tieba.g.b
    public final boolean a() {
        this.a.R();
        return false;
    }
}
