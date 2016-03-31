package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements a.b {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.dht.dgo;
        aVar2.dismiss();
        str = this.dht.dgp;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.dht.getPageContext().getPageActivity();
            str2 = this.dht.dgp;
            com.baidu.tbadk.browser.f.a(pageActivity, false, str2);
        }
    }
}
