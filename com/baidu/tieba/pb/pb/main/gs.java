package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gs implements a.b {
    private final /* synthetic */ TbPageContext aEn;
    final /* synthetic */ gq eDh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gs(gq gqVar, TbPageContext tbPageContext) {
        this.eDh = gqVar;
        this.aEn = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.eDh.eDd;
        aVar2.dismiss();
        str = this.eDh.eDe;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.aEn.getPageActivity();
            str2 = this.eDh.eDe;
            com.baidu.tbadk.browser.f.a(pageActivity, false, str2);
        }
    }
}
