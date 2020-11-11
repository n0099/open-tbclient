package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.h.a.a.c;
/* loaded from: classes4.dex */
public class a implements com.baidu.tieba.sdk.b.a {
    private com.baidu.h.a.a.a bVA;
    private c kKp = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.h.a.a.c
        public void onLoginStatusChanged(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.dCs().dCt();
        }
    };

    public a(Application application) {
        this.bVA = com.baidu.h.b.a.aJ(application).Ym();
        this.bVA.a(this.kKp);
    }

    @Override // com.baidu.tieba.sdk.b.a
    public com.baidu.tieba.sdk.c.a daN() {
        com.baidu.h.a.a.b Ye;
        if (this.bVA.isLogin() && (Ye = this.bVA.Ye()) != null) {
            return a(Ye);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.b.a
    public void daO() {
        this.bVA.login();
    }

    private com.baidu.tieba.sdk.c.a a(com.baidu.h.a.a.b bVar) {
        com.baidu.tieba.sdk.c.a aVar = new com.baidu.tieba.sdk.c.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.getDisplayname();
        aVar.nickName = bVar.getDisplayname();
        aVar.portrait = bVar.Yf();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
