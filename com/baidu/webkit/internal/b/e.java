package com.baidu.webkit.internal.b;

import android.app.AlertDialog;
/* loaded from: classes5.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AlertDialog f26873a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f26874b;

    public e(b bVar, AlertDialog alertDialog) {
        this.f26874b = bVar;
        this.f26873a = alertDialog;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f26873a.dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
