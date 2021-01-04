package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes8.dex */
final class ct implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cg f5788a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cg cgVar) {
        this.f5788a = cgVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f5788a.f5771a.a(view);
        return false;
    }
}
