package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ei implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ef f2255a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ei(ef efVar) {
        this.f2255a = efVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
