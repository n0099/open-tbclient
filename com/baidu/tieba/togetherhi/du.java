package com.baidu.tieba.togetherhi;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class du implements a.b {
    final /* synthetic */ TogetherhiH5ProxyActivity fMz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public du(TogetherhiH5ProxyActivity togetherhiH5ProxyActivity) {
        this.fMz = togetherhiH5ProxyActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(a aVar) {
        aVar.dismiss();
        this.fMz.finish();
    }
}
