package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gk implements a.b {
    private final /* synthetic */ TbPageContext azW;
    final /* synthetic */ gi dWe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gk(gi giVar, TbPageContext tbPageContext) {
        this.dWe = giVar;
        this.azW = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.dWe.dWa;
        aVar2.dismiss();
        str = this.dWe.dWb;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.azW.getPageActivity();
            str2 = this.dWe.dWb;
            com.baidu.tbadk.browser.f.a(pageActivity, false, str2);
        }
    }
}
