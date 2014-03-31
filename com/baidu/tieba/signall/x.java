package com.baidu.tieba.signall;

import android.content.Context;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x implements Runnable {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.a = uVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        ProgressBar progressBar;
        context = this.a.c;
        int a = com.baidu.adp.lib.util.i.a(context, 6.0f);
        context2 = this.a.c;
        int a2 = com.baidu.adp.lib.util.i.a(context2, 100.0f);
        int i = a2 - (a * 2);
        int i2 = (a2 - i) / 2;
        int i3 = i + i2;
        progressBar = this.a.d;
        progressBar.getProgressDrawable().setBounds(i2, i2, i3, i3);
    }
}
