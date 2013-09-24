package com.baidu.tieba.square;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ag implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ae f1818a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar) {
        this.f1818a = aeVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
