package com.baidu.tieba.usermute;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    final /* synthetic */ UserMuteAddAndDelModel djb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(UserMuteAddAndDelModel userMuteAddAndDelModel) {
        this.djb = userMuteAddAndDelModel;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
    }
}
