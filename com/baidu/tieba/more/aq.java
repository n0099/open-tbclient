package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aq implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SystemHelpSettingActivity f2079a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.f2079a = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        at atVar;
        this.f2079a.showLoadingDialog(this.f2079a.getString(R.string.deleting));
        atVar = this.f2079a.b;
        atVar.a();
        dialogInterface.cancel();
    }
}
