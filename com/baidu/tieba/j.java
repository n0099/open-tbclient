package com.baidu.tieba;

import com.baidu.tieba.s;
/* loaded from: classes.dex */
class j implements s.a {
    final /* synthetic */ i aQE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.aQE = iVar;
    }

    @Override // com.baidu.tieba.s.a
    public void onCompleted() {
        LogoActivity logoActivity;
        logoActivity = this.aQE.aQD;
        logoActivity.IV();
    }
}
