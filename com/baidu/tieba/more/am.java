package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class am implements DialogInterface.OnClickListener {
    final /* synthetic */ SystemHelpSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.a = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        aq aqVar;
        this.a.showLoadingDialog(this.a.getString(com.baidu.tieba.y.deleting));
        aqVar = this.a.b;
        aqVar.a();
        dialogInterface.cancel();
    }
}
