package com.baidu.tieba.usermute;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ UserMuteAddAndDelModel eVk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(UserMuteAddAndDelModel userMuteAddAndDelModel) {
        this.eVk = userMuteAddAndDelModel;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
    }
}
