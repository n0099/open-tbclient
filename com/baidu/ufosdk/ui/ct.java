package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes8.dex */
final class ct implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cg f5789a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cg cgVar) {
        this.f5789a = cgVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f5789a.f5772a.a(view);
        return false;
    }
}
