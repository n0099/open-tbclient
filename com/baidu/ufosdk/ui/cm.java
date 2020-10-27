package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes22.dex */
final class cm implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cg f3805a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cg cgVar) {
        this.f3805a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f3805a.f3799a.H) {
            return;
        }
        new Thread(new cn(this)).start();
    }
}
