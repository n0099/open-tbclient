package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class as implements DialogInterface.OnClickListener {
    final /* synthetic */ SystemHelpSettingActivity bsJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.bsJ = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        av avVar;
        this.bsJ.showLoadingDialog(this.bsJ.getString(com.baidu.tieba.y.deleting));
        avVar = this.bsJ.bsH;
        avVar.Vw();
        dialogInterface.cancel();
    }
}
