package com.baidu.tieba.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x implements View.OnClickListener {
    final /* synthetic */ v a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar) {
        this.a = vVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        v.b(this.a, view);
    }
}
