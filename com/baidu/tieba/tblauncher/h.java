package com.baidu.tieba.tblauncher;

import android.content.Intent;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class h implements a.b {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        try {
            this.this$0.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
            aVar.dismiss();
        } catch (Exception e) {
            this.this$0.showToast(r.l.goto_developActivity_error_toast);
        }
    }
}
