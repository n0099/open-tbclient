package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.bKT.bKi;
        aVar2.dismiss();
        str = this.bKT.bKj;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.bKT.getPageContext().getPageActivity();
            str2 = this.bKT.bKj;
            com.baidu.tbadk.browser.f.b(pageActivity, false, str2);
        }
    }
}
