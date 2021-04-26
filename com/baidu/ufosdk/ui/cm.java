package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes5.dex */
public final class cm implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cg f23527a;

    public cm(cg cgVar) {
        this.f23527a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f23527a.f23518a.H) {
            return;
        }
        new Thread(new cn(this)).start();
    }
}
