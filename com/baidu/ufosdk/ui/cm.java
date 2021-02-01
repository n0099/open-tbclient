package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes8.dex */
final class cm implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cg f5500a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cg cgVar) {
        this.f5500a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f5500a.f5491a.H) {
            return;
        }
        new Thread(new cn(this)).start();
    }
}
