package com.baidu.tieba.launcherGuide.guide;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class w implements DialogInterface.OnDismissListener {
    final /* synthetic */ t bxw;
    private final /* synthetic */ p bxx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, p pVar) {
        this.bxw = tVar;
        this.bxx = pVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.bxx.Ws();
    }
}
