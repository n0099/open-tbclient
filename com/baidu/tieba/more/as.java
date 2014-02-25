package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class as implements DialogInterface.OnClickListener {
    final /* synthetic */ SystemHelpSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.a = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        au auVar;
        this.a.showLoadingDialog(this.a.getString(R.string.deleting));
        auVar = this.a.b;
        auVar.b();
        dialogInterface.cancel();
    }
}
