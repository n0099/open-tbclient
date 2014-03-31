package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class af implements DialogInterface.OnClickListener {
    final /* synthetic */ SystemHelpSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.a = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        aj ajVar;
        this.a.showLoadingDialog(this.a.getString(com.baidu.tieba.a.k.deleting));
        ajVar = this.a.b;
        ajVar.a();
        dialogInterface.cancel();
    }
}
