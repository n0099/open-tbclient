package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements a.b {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.ciK = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.ciK.chW;
        aVar2.dismiss();
        str = this.ciK.chX;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.ciK.getPageContext().getPageActivity();
            str2 = this.ciK.chX;
            com.baidu.tbadk.browser.g.b(pageActivity, false, str2);
        }
    }
}
