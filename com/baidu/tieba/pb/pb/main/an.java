package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements a.b {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.cbo.caB;
        aVar2.dismiss();
        str = this.cbo.caC;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.cbo.getPageContext().getPageActivity();
            str2 = this.cbo.caC;
            com.baidu.tbadk.browser.f.b(pageActivity, false, str2);
        }
    }
}
