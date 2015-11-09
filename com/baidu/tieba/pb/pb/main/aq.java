package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements a.b {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.cjN.ciZ;
        aVar2.dismiss();
        str = this.cjN.cja;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.cjN.getPageContext().getPageActivity();
            str2 = this.cjN.cja;
            com.baidu.tbadk.browser.g.b(pageActivity, false, str2);
        }
    }
}
