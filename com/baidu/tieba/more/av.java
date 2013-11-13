package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class av implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SystemHelpSettingActivity f1989a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.f1989a = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
