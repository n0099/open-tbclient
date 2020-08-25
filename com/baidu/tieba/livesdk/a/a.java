package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.h.a.a.c;
/* loaded from: classes4.dex */
public class a implements com.baidu.tieba.sdk.b.a {
    private com.baidu.h.a.a.a bxs;
    private c jTZ = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.h.a.a.c
        public void onLoginStatusChanged(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.dpk().dpl();
        }
    };

    public a(Application application) {
        this.bxs = com.baidu.h.b.a.aF(application).Rj();
        this.bxs.a(this.jTZ);
    }

    @Override // com.baidu.tieba.sdk.b.a
    public com.baidu.tieba.sdk.c.a cNO() {
        com.baidu.h.a.a.b Rb;
        if (this.bxs.isLogin() && (Rb = this.bxs.Rb()) != null) {
            return a(Rb);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.b.a
    public void cNP() {
        this.bxs.login();
    }

    private com.baidu.tieba.sdk.c.a a(com.baidu.h.a.a.b bVar) {
        com.baidu.tieba.sdk.c.a aVar = new com.baidu.tieba.sdk.c.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.getDisplayname();
        aVar.nickName = bVar.getDisplayname();
        aVar.portrait = bVar.Rc();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
