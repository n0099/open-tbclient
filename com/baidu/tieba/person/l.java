package com.baidu.tieba.person;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class l implements DialogInterface.OnClickListener {
    final /* synthetic */ EditMarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EditMarkActivity editMarkActivity) {
        this.a = editMarkActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        m mVar;
        com.baidu.tieba.model.k kVar;
        com.baidu.tieba.model.k kVar2;
        mVar = this.a.b;
        kVar = this.a.a;
        mVar.a(kVar.a());
        kVar2 = this.a.a;
        kVar2.a((Boolean) true);
    }
}
