package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements a.b {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.cCm.cBw;
        aVar2.dismiss();
        str = this.cCm.cBx;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.cCm.getPageContext().getPageActivity();
            str2 = this.cCm.cBx;
            com.baidu.tbadk.browser.f.b(pageActivity, false, str2);
        }
    }
}
