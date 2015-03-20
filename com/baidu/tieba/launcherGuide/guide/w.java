package com.baidu.tieba.launcherGuide.guide;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class w implements DialogInterface.OnDismissListener {
    final /* synthetic */ t bxg;
    private final /* synthetic */ p bxh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, p pVar) {
        this.bxg = tVar;
        this.bxh = pVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.bxh.Wf();
    }
}
