package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes5.dex */
public final class ct implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cg f22827a;

    public ct(cg cgVar) {
        this.f22827a = cgVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f22827a.f22808a.a(view);
        return false;
    }
}
