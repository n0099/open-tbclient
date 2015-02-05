package com.baidu.tieba.pb.main;

import android.app.Activity;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.bAS.bAf;
        aVar2.dismiss();
        str = this.bAS.bAg;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.bAS.getPageContext().getPageActivity();
            str2 = this.bAS.bAg;
            com.baidu.tbadk.browser.a.b(pageActivity, false, str2);
        }
    }
}
