package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class l implements DialogInterface.OnCancelListener {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.a = kVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        AccountActivity accountActivity;
        accountActivity = this.a.a;
        accountActivity.b();
    }
}
