package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.c.a.a.c;
/* loaded from: classes3.dex */
public class a implements com.baidu.tieba.sdk.b.a {
    private com.baidu.c.a.a.a brh;
    private c jwa = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.c.a.a.c
        public void onLoginStatusChanged(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.daK().daL();
        }
    };

    public a(Application application) {
        this.brh = com.baidu.c.b.a.aA(application).Lc();
        this.brh.a(this.jwa);
    }

    @Override // com.baidu.tieba.sdk.b.a
    public com.baidu.tieba.sdk.c.a cyY() {
        com.baidu.c.a.a.b KU;
        if (this.brh.isLogin() && (KU = this.brh.KU()) != null) {
            return a(KU);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.b.a
    public void cyZ() {
        this.brh.login();
    }

    private com.baidu.tieba.sdk.c.a a(com.baidu.c.a.a.b bVar) {
        com.baidu.tieba.sdk.c.a aVar = new com.baidu.tieba.sdk.c.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.getDisplayname();
        aVar.nickName = bVar.getDisplayname();
        aVar.portrait = bVar.KV();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
