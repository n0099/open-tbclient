package com.baidu.tieba.usermute;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements DialogInterface.OnCancelListener {
    final /* synthetic */ UserMuteAddAndDelModel dkH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(UserMuteAddAndDelModel userMuteAddAndDelModel) {
        this.dkH = userMuteAddAndDelModel;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.dkH.cancelLoadData();
    }
}
