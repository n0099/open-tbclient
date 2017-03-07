package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gv implements a.b {
    private final /* synthetic */ TbPageContext aHR;
    final /* synthetic */ gt etD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gv(gt gtVar, TbPageContext tbPageContext) {
        this.etD = gtVar;
        this.aHR = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.etD.etz;
        aVar2.dismiss();
        str = this.etD.etA;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.aHR.getPageActivity();
            str2 = this.etD.etA;
            com.baidu.tbadk.browser.f.a(pageActivity, false, str2);
        }
    }
}
