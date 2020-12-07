package com.baidu.webkit.internal.b;

import android.app.AlertDialog;
/* loaded from: classes12.dex */
final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AlertDialog f3927a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, AlertDialog alertDialog) {
        this.b = bVar;
        this.f3927a = alertDialog;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f3927a.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
