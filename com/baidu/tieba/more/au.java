package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class au implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SystemHelpSettingActivity f1988a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.f1988a = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ax axVar;
        this.f1988a.showLoadingDialog(this.f1988a.getString(R.string.deleting));
        axVar = this.f1988a.b;
        axVar.a();
        dialogInterface.cancel();
    }
}
