package com.baidu.tieba.launcherGuide.guide;

import android.content.DialogInterface;
import com.baidu.tieba.launcherGuide.guide.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements DialogInterface.OnDismissListener {
    final /* synthetic */ p bSK;
    private final /* synthetic */ k.a bSL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, k.a aVar) {
        this.bSK = pVar;
        this.bSL = aVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.bSL.aaV();
    }
}
