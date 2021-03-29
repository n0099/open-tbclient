package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes5.dex */
public final class cm implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cg f23124a;

    public cm(cg cgVar) {
        this.f23124a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f23124a.f23115a.H) {
            return;
        }
        new Thread(new cn(this)).start();
    }
}
