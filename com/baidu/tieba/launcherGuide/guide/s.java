package com.baidu.tieba.launcherGuide.guide;

import android.content.DialogInterface;
import com.baidu.tieba.launcherGuide.guide.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements DialogInterface.OnDismissListener {
    final /* synthetic */ p ciY;
    private final /* synthetic */ k.a ciZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, k.a aVar) {
        this.ciY = pVar;
        this.ciZ = aVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.ciZ.aeB();
    }
}
