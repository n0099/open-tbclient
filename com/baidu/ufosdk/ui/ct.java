package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes7.dex */
final class ct implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cg f5506a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cg cgVar) {
        this.f5506a = cgVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f5506a.f5489a.a(view);
        return false;
    }
}
