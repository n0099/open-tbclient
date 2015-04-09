package com.baidu.tieba.pb.pb.main;

import android.content.DialogInterface;
import android.os.Handler;
/* loaded from: classes.dex */
class cx implements DialogInterface.OnDismissListener {
    final /* synthetic */ cj bMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(cj cjVar) {
        this.bMC = cjVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        new Handler().postDelayed(new cy(this), 200L);
    }
}
