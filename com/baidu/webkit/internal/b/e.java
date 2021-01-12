package com.baidu.webkit.internal.b;

import android.app.AlertDialog;
/* loaded from: classes14.dex */
final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AlertDialog f5645a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f5646b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, AlertDialog alertDialog) {
        this.f5646b = bVar;
        this.f5645a = alertDialog;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f5645a.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
