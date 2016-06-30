package com.baidu.tieba.togetherhi;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class du implements a.b {
    final /* synthetic */ TogetherhiH5ProxyActivity foI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public du(TogetherhiH5ProxyActivity togetherhiH5ProxyActivity) {
        this.foI = togetherhiH5ProxyActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(a aVar) {
        aVar.dismiss();
        this.foI.finish();
    }
}
