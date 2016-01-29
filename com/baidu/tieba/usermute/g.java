package com.baidu.tieba.usermute;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class g implements a.b {
    final /* synthetic */ UserMuteAddAndDelModel eld;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(UserMuteAddAndDelModel userMuteAddAndDelModel) {
        this.eld = userMuteAddAndDelModel;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
    }
}
