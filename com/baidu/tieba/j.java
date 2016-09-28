package com.baidu.tieba;

import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class j implements n.a {
    final /* synthetic */ i aKZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.aKZ = iVar;
    }

    @Override // com.baidu.tieba.n.a
    public void onCompleted() {
        LogoActivity logoActivity;
        boolean Jc;
        LogoActivity logoActivity2;
        LogoActivity.a aVar;
        LogoActivity logoActivity3;
        logoActivity = this.aKZ.aKV;
        Jc = logoActivity.Jc();
        if (Jc) {
            logoActivity3 = this.aKZ.aKV;
            logoActivity3.finish();
            return;
        }
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        logoActivity2 = this.aKZ.aKV;
        aVar = logoActivity2.aKP;
        eG.post(aVar);
    }
}
