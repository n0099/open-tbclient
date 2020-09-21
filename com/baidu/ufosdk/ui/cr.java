package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes21.dex */
final class cr implements View.OnLongClickListener {
    final /* synthetic */ cg a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(cg cgVar) {
        this.a = cgVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.a.a.a(view);
        return false;
    }
}
