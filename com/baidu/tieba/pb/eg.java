package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class eg implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ed f2163a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eg(ed edVar) {
        this.f2163a = edVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
