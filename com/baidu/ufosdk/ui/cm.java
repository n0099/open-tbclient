package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes22.dex */
final class cm implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cg f3807a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cg cgVar) {
        this.f3807a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f3807a.f3801a.H) {
            return;
        }
        new Thread(new cn(this)).start();
    }
}
