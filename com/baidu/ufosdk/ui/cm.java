package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes7.dex */
final class cm implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cg f5498a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cg cgVar) {
        this.f5498a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f5498a.f5489a.H) {
            return;
        }
        new Thread(new cn(this)).start();
    }
}
