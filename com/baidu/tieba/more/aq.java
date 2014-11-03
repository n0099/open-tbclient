package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class aq implements DialogInterface.OnClickListener {
    final /* synthetic */ SystemHelpSettingActivity bsX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.bsX = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        av avVar;
        this.bsX.showLoadingDialog(this.bsX.getString(com.baidu.tieba.y.deleting));
        avVar = this.bsX.bsV;
        avVar.Vy();
        dialogInterface.cancel();
    }
}
