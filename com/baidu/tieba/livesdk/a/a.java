package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.c.a.a.c;
/* loaded from: classes6.dex */
public class a implements com.baidu.tieba.sdk.a.a {
    private com.baidu.c.a.a.a avW;
    private c hkD = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.c.a.a.c
        public void h(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.chx().chy();
        }
    };

    public a(Application application) {
        this.avW = com.baidu.c.b.a.aB(application).xd();
        this.avW.a(this.hkD);
    }

    @Override // com.baidu.tieba.sdk.a.a
    public com.baidu.tieba.sdk.b.a bJD() {
        com.baidu.c.a.a.b wU;
        if (this.avW.isLogin() && (wU = this.avW.wU()) != null) {
            return a(wU);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.a.a
    public void bJE() {
        this.avW.login();
    }

    private com.baidu.tieba.sdk.b.a a(com.baidu.c.a.a.b bVar) {
        com.baidu.tieba.sdk.b.a aVar = new com.baidu.tieba.sdk.b.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.wV();
        aVar.nickName = bVar.wV();
        aVar.portrait = bVar.wW();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
