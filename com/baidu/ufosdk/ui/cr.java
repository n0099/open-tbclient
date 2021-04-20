package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes5.dex */
public final class cr implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cg f22817a;

    public cr(cg cgVar) {
        this.f22817a = cgVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f22817a.f22800a.a(view);
        return false;
    }
}
