package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class at implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SystemHelpSettingActivity f1987a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.f1987a = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
