package com.baidu.tieba.tbluncher;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class p implements DialogInterface.OnClickListener {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tbadk.core.d.b.a(this.a, 12, false);
    }
}
