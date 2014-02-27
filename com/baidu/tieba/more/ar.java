package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class ar implements DialogInterface.OnClickListener {
    final /* synthetic */ SystemHelpSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.a = systemHelpSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
