package com.baidu.webkit.internal.b;

import android.app.AlertDialog;
/* loaded from: classes4.dex */
final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AlertDialog f5647a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f5648b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, AlertDialog alertDialog) {
        this.f5648b = bVar;
        this.f5647a = alertDialog;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f5647a.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
