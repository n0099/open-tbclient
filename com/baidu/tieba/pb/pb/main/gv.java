package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gv implements a.b {
    private final /* synthetic */ TbPageContext aCz;
    final /* synthetic */ gt eqw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gv(gt gtVar, TbPageContext tbPageContext) {
        this.eqw = gtVar;
        this.aCz = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.eqw.eqs;
        aVar2.dismiss();
        str = this.eqw.eqt;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.aCz.getPageActivity();
            str2 = this.eqw.eqt;
            com.baidu.tbadk.browser.f.a(pageActivity, false, str2);
        }
    }
}
