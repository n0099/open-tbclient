package com.baidu.tieba.usermute;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class g implements a.b {
    final /* synthetic */ UserMuteAddAndDelModel dIS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(UserMuteAddAndDelModel userMuteAddAndDelModel) {
        this.dIS = userMuteAddAndDelModel;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
    }
}
