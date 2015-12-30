package com.baidu.tieba.usermute;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class h implements DialogInterface.OnCancelListener {
    final /* synthetic */ UserMuteAddAndDelModel dQt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(UserMuteAddAndDelModel userMuteAddAndDelModel) {
        this.dQt = userMuteAddAndDelModel;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.dQt.cancelLoadData();
    }
}
