package com.baidu.tieba.tblauncher;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class i implements a.b {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.this$0.aOe();
    }
}
