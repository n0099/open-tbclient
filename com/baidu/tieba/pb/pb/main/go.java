package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class go implements a.b {
    private final /* synthetic */ TbPageContext aAL;
    final /* synthetic */ gm eiH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public go(gm gmVar, TbPageContext tbPageContext) {
        this.eiH = gmVar;
        this.aAL = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.eiH.eiD;
        aVar2.dismiss();
        str = this.eiH.eiE;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.aAL.getPageActivity();
            str2 = this.eiH.eiE;
            com.baidu.tbadk.browser.f.a(pageActivity, false, str2);
        }
    }
}
