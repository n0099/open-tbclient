package com.baidu.tieba.usermute;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class h implements DialogInterface.OnCancelListener {
    final /* synthetic */ UserMuteAddAndDelModel dIS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(UserMuteAddAndDelModel userMuteAddAndDelModel) {
        this.dIS = userMuteAddAndDelModel;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.dIS.cancelLoadData();
    }
}
