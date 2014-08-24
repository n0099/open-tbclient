package com.baidu.tieba.tblauncher;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class s implements DialogInterface.OnClickListener {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tbadk.core.b.b.a(this.a, 12, false);
    }
}
