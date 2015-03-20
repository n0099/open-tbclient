package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.bIv.bHG;
        aVar2.dismiss();
        str = this.bIv.bHH;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.bIv.getPageContext().getPageActivity();
            str2 = this.bIv.bHH;
            com.baidu.tbadk.browser.f.b(pageActivity, false, str2);
        }
    }
}
