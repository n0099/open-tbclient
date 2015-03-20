package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.os.Handler;
/* loaded from: classes.dex */
class cw implements DialogInterface.OnDismissListener {
    final /* synthetic */ ci bMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(ci ciVar) {
        this.bMm = ciVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        new Handler().postDelayed(new cx(this), 200L);
    }
}
