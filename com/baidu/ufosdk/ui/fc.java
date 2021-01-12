package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes7.dex */
final class fc implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fa f5590a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fc(fa faVar) {
        this.f5590a = faVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f5590a == null || !this.f5590a.isShowing()) {
            return;
        }
        this.f5590a.dismiss();
    }
}
