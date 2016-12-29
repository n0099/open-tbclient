package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gl implements a.b {
    private final /* synthetic */ TbPageContext aDH;
    final /* synthetic */ gj ehn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gl(gj gjVar, TbPageContext tbPageContext) {
        this.ehn = gjVar;
        this.aDH = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.ehn.ehj;
        aVar2.dismiss();
        str = this.ehn.ehk;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.aDH.getPageActivity();
            str2 = this.ehn.ehk;
            com.baidu.tbadk.browser.f.a(pageActivity, false, str2);
        }
    }
}
