package com.baidu.tieba.tblauncher;

import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        try {
            this.this$0.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
            aVar.dismiss();
        } catch (Exception e) {
            this.this$0.showToast(com.baidu.tieba.y.goto_developActivity_error_toast);
        }
    }
}
