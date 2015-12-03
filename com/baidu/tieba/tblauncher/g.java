package com.baidu.tieba.tblauncher;

import android.content.Intent;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class g implements a.b {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        try {
            this.this$0.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
            aVar.dismiss();
        } catch (Exception e) {
            this.this$0.showToast(n.i.goto_developActivity_error_toast);
        }
    }
}
