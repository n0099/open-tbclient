package com.baidu.tieba.pb;

import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
/* loaded from: classes.dex */
class ee implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2161a;
    final /* synthetic */ int b;
    final /* synthetic */ View c;
    final /* synthetic */ ed d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ee(ed edVar, String str, int i, View view) {
        this.d = edVar;
        this.f2161a = str;
        this.b = i;
        this.c = view;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        new Handler().postDelayed(new ef(this), 200L);
    }
}
