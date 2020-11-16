package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes21.dex */
final class ct implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cg f3814a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cg cgVar) {
        this.f3814a = cgVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f3814a.f3801a.a(view);
        return false;
    }
}
