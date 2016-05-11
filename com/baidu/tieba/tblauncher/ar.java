package com.baidu.tieba.tblauncher;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ar implements DialogInterface.OnCancelListener {
    final /* synthetic */ aq exi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar) {
        this.exi = aqVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ab abVar;
        MainTabActivity mainTabActivity;
        abVar = this.exi.exg;
        mainTabActivity = abVar.ewR;
        mainTabActivity.closeLoadingDialog();
    }
}
