package com.baidu.tieba.usermute;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.b {
    final /* synthetic */ UserMuteAddAndDelModel dkH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(UserMuteAddAndDelModel userMuteAddAndDelModel) {
        this.dkH = userMuteAddAndDelModel;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
    }
}
