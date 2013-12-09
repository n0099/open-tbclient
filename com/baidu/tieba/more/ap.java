package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ap implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SystemHelpSettingActivity f2078a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.f2078a = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
