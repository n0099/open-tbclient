package com.baidu.tieba.tblauncher;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class y implements DialogInterface.OnClickListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tbadk.core.b.b.a(this.this$0, 12, false);
    }
}
