package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bd implements DialogInterface.OnClickListener {
    final /* synthetic */ SystemHelpSettingActivity byd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.byd = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        bf bfVar;
        this.byd.showLoadingDialog(this.byd.getPageContext().getString(com.baidu.tieba.z.deleting));
        bfVar = this.byd.byc;
        bfVar.Wq();
        dialogInterface.cancel();
    }
}
