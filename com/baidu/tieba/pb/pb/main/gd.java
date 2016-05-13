package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gd implements a.b {
    private final /* synthetic */ TbPageContext azf;
    final /* synthetic */ gb dpH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gd(gb gbVar, TbPageContext tbPageContext) {
        this.dpH = gbVar;
        this.azf = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.dpH.dpD;
        aVar2.dismiss();
        str = this.dpH.dpE;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.azf.getPageActivity();
            str2 = this.dpH.dpE;
            com.baidu.tbadk.browser.f.a(pageActivity, false, str2);
        }
    }
}
