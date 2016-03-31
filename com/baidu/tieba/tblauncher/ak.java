package com.baidu.tieba.tblauncher;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ak implements DialogInterface.OnCancelListener {
    final /* synthetic */ aj etZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.etZ = ajVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        aa aaVar;
        MainTabActivity mainTabActivity;
        aaVar = this.etZ.etY;
        mainTabActivity = aaVar.etM;
        mainTabActivity.closeLoadingDialog();
    }
}
