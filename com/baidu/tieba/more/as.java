package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class as implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SystemHelpSettingActivity f2080a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.f2080a = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        at atVar;
        this.f2080a.showLoadingDialog(this.f2080a.getString(R.string.deleting));
        atVar = this.f2080a.b;
        atVar.b();
        dialogInterface.cancel();
    }
}
