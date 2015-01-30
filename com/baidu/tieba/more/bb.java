package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bb implements DialogInterface.OnClickListener {
    final /* synthetic */ SystemHelpSettingActivity bye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.bye = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        bf bfVar;
        this.bye.showLoadingDialog(this.bye.getPageContext().getString(com.baidu.tieba.z.deleting));
        bfVar = this.bye.byd;
        bfVar.Wu();
        dialogInterface.cancel();
    }
}
