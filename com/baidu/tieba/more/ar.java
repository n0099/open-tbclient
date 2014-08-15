package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ar implements DialogInterface.OnClickListener {
    final /* synthetic */ SystemHelpSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.a = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        av avVar;
        this.a.showLoadingDialog(this.a.getString(com.baidu.tieba.x.deleting));
        avVar = this.a.b;
        avVar.a();
        dialogInterface.cancel();
    }
}
