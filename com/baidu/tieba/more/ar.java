package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ar implements DialogInterface.OnClickListener {
    final /* synthetic */ SystemHelpSettingActivity bwu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.bwu = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        at atVar;
        this.bwu.showLoadingDialog(this.bwu.getPageContext().getString(com.baidu.tieba.z.deleting));
        atVar = this.bwu.bws;
        atVar.VO();
        dialogInterface.cancel();
    }
}
