package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnClickListener {
    final /* synthetic */ SystemHelpSettingActivity bye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.bye = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
