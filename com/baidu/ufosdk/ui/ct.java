package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes7.dex */
final class ct implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cg f3720a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cg cgVar) {
        this.f3720a = cgVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f3720a.f3707a.a(view);
        return false;
    }
}
