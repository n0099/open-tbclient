package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes5.dex */
public final class cm implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cg f22817a;

    public cm(cg cgVar) {
        this.f22817a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f22817a.f22808a.H) {
            return;
        }
        new Thread(new cn(this)).start();
    }
}
