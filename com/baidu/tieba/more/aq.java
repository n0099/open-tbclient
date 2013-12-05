package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aq implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SystemHelpSettingActivity f2078a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.f2078a = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        at atVar;
        this.f2078a.showLoadingDialog(this.f2078a.getString(R.string.deleting));
        atVar = this.f2078a.b;
        atVar.a();
        dialogInterface.cancel();
    }
}
