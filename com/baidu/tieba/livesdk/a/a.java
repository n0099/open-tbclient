package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.c.a.a.c;
/* loaded from: classes6.dex */
public class a implements com.baidu.tieba.sdk.a.a {
    private com.baidu.c.a.a.a avE;
    private c hjM = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.c.a.a.c
        public void h(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.chv().chw();
        }
    };

    public a(Application application) {
        this.avE = com.baidu.c.b.a.aB(application).xe();
        this.avE.a(this.hjM);
    }

    @Override // com.baidu.tieba.sdk.a.a
    public com.baidu.tieba.sdk.b.a bJB() {
        com.baidu.c.a.a.b wV;
        if (this.avE.isLogin() && (wV = this.avE.wV()) != null) {
            return a(wV);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.a.a
    public void bJC() {
        this.avE.login();
    }

    private com.baidu.tieba.sdk.b.a a(com.baidu.c.a.a.b bVar) {
        com.baidu.tieba.sdk.b.a aVar = new com.baidu.tieba.sdk.b.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.wW();
        aVar.nickName = bVar.wW();
        aVar.portrait = bVar.wX();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
