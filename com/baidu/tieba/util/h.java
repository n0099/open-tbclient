package com.baidu.tieba.util;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements DialogInterface.OnClickListener {
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.sharedPref.b.a().b("anti_vcode_no_longer_tip", true);
        dialogInterface.dismiss();
    }
}
