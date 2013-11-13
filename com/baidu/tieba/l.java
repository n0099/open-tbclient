package com.baidu.tieba;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1819a;
    private View b;

    public l(j jVar, View view) {
        this.f1819a = jVar;
        this.b = null;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f1819a.isFinishing()) {
            this.f1819a.ShowSoftKeyPad((InputMethodManager) this.f1819a.getSystemService("input_method"), this.b);
        }
    }
}
