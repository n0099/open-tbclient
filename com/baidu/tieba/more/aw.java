package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aw implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SystemHelpSettingActivity f1990a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.f1990a = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ax axVar;
        this.f1990a.showLoadingDialog(this.f1990a.getString(R.string.deleting));
        axVar = this.f1990a.b;
        axVar.b();
        dialogInterface.cancel();
    }
}
