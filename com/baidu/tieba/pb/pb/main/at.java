package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements a.b {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.cFS.cFb;
        aVar2.dismiss();
        str = this.cFS.cFc;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.cFS.getPageContext().getPageActivity();
            str2 = this.cFS.cFc;
            com.baidu.tbadk.browser.f.b(pageActivity, false, str2);
        }
    }
}
