package com.baidu.webkit.internal.b;

import android.app.AlertDialog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AlertDialog f5944a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f5945b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, AlertDialog alertDialog) {
        this.f5945b = bVar;
        this.f5944a = alertDialog;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f5944a.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
