package com.baidu.tieba.usermute;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class j implements a.b {
    final /* synthetic */ UserMuteAddAndDelModel eED;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(UserMuteAddAndDelModel userMuteAddAndDelModel) {
        this.eED = userMuteAddAndDelModel;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
    }
}
