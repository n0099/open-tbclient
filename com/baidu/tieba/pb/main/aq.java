package com.baidu.tieba.pb.main;

import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.bvg.bus;
        aVar2.dismiss();
        str = this.bvg.but;
        if (!TextUtils.isEmpty(str)) {
            PbActivity pbActivity = this.bvg;
            str2 = this.bvg.but;
            com.baidu.tbadk.browser.a.i(pbActivity, str2);
        }
    }
}
