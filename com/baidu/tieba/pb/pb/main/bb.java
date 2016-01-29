package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements a.b {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.cNq.cMu;
        aVar2.dismiss();
        str = this.cNq.cMv;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.cNq.getPageContext().getPageActivity();
            str2 = this.cNq.cMv;
            com.baidu.tbadk.browser.f.a(pageActivity, false, str2);
        }
    }
}
