package com.baidu.webkit.internal.b;

import android.app.AlertDialog;
/* loaded from: classes8.dex */
final class e implements Runnable {
    final /* synthetic */ AlertDialog a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, AlertDialog alertDialog) {
        this.b = bVar;
        this.a = alertDialog;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
