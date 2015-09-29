package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements a.b {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.ciz = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.ciz.chL;
        aVar2.dismiss();
        str = this.ciz.chM;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.ciz.getPageContext().getPageActivity();
            str2 = this.ciz.chM;
            com.baidu.tbadk.browser.g.b(pageActivity, false, str2);
        }
    }
}
