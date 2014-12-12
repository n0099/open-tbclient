package com.baidu.tieba.pb.main;

import android.app.Activity;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.bzj.byx;
        aVar2.dismiss();
        str = this.bzj.byy;
        if (!TextUtils.isEmpty(str)) {
            Activity pageActivity = this.bzj.getPageContext().getPageActivity();
            str2 = this.bzj.byy;
            com.baidu.tbadk.browser.a.b(pageActivity, false, str2);
        }
    }
}
