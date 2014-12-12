package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class aq implements DialogInterface.OnClickListener {
    final /* synthetic */ SystemHelpSettingActivity bwu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.bwu = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
