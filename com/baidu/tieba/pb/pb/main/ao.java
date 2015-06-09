package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.bKU.bKj;
        aVar2.dismiss();
        str = this.bKU.bKk;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.bKU.getPageContext().getPageActivity();
            str2 = this.bKU.bKk;
            com.baidu.tbadk.browser.f.b(pageActivity, false, str2);
        }
    }
}
