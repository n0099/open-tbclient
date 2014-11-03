package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class at implements DialogInterface.OnClickListener {
    final /* synthetic */ SystemHelpSettingActivity bsX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.bsX = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
