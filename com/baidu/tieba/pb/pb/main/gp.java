package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gp implements a.b {
    private final /* synthetic */ TbPageContext aDS;
    final /* synthetic */ gn euO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gp(gn gnVar, TbPageContext tbPageContext) {
        this.euO = gnVar;
        this.aDS = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.euO.euK;
        aVar2.dismiss();
        str = this.euO.euL;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.aDS.getPageActivity();
            str2 = this.euO.euL;
            com.baidu.tbadk.browser.f.a(pageActivity, false, str2);
        }
    }
}
