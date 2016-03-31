package com.baidu.tieba.usermute;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class b implements DialogInterface.OnCancelListener {
    final /* synthetic */ UserMuteAddAndDelModel eED;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(UserMuteAddAndDelModel userMuteAddAndDelModel) {
        this.eED = userMuteAddAndDelModel;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.eED.cancelLoadData();
    }
}
