package com.baidu.tieba;

import com.baidu.tieba.s;
/* loaded from: classes.dex */
class j implements s.a {
    final /* synthetic */ i aRX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.aRX = iVar;
    }

    @Override // com.baidu.tieba.s.a
    public void onCompleted() {
        LogoActivity logoActivity;
        logoActivity = this.aRX.aRW;
        logoActivity.Jt();
    }
}
