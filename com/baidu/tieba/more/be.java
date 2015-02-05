package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class be implements DialogInterface.OnClickListener {
    final /* synthetic */ SystemHelpSettingActivity byd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.byd = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
