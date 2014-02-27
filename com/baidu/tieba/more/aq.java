package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class aq implements DialogInterface.OnClickListener {
    final /* synthetic */ SystemHelpSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.a = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        au auVar;
        this.a.showLoadingDialog(this.a.getString(R.string.deleting));
        auVar = this.a.b;
        auVar.a();
        dialogInterface.cancel();
    }
}
