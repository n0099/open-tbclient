package com.baidu.webkit.internal.b;

import android.app.AlertDialog;
/* loaded from: classes15.dex */
final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AlertDialog f5945a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f5946b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, AlertDialog alertDialog) {
        this.f5946b = bVar;
        this.f5945a = alertDialog;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f5945a.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
