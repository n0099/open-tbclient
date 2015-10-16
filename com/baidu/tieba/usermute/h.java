package com.baidu.tieba.usermute;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements DialogInterface.OnCancelListener {
    final /* synthetic */ UserMuteAddAndDelModel djb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(UserMuteAddAndDelModel userMuteAddAndDelModel) {
        this.djb = userMuteAddAndDelModel;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.djb.cancelLoadData();
    }
}
