package com.baidu.tieba.more;

import android.content.DialogInterface;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class au implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SystemHelpSettingActivity f1996a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.f1996a = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ax axVar;
        this.f1996a.b(this.f1996a.getString(R.string.deleting));
        axVar = this.f1996a.b;
        axVar.a();
        com.baidu.tieba.util.o.c();
        dialogInterface.cancel();
    }
}
