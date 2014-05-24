package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class af implements DialogInterface.OnClickListener {
    final /* synthetic */ SystemHelpSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.a = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        aj ajVar;
        this.a.showLoadingDialog(this.a.getString(com.baidu.tieba.y.deleting));
        ajVar = this.a.b;
        ajVar.a();
        dialogInterface.cancel();
    }
}
