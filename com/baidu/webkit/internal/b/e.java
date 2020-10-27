package com.baidu.webkit.internal.b;

import android.app.AlertDialog;
/* loaded from: classes11.dex */
final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AlertDialog f3922a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, AlertDialog alertDialog) {
        this.b = bVar;
        this.f3922a = alertDialog;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f3922a.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
