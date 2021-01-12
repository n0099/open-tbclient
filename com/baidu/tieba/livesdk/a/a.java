package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.h.a.a.c;
/* loaded from: classes9.dex */
public class a implements com.baidu.tieba.sdk.b.a {
    private com.baidu.h.a.a.a cba;
    private c kYU = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.h.a.a.c
        public void onLoginStatusChanged(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.dDg().dDh();
        }
    };

    public a(Application application) {
        this.cba = com.baidu.h.b.a.bx(application).Yb();
        this.cba.a(this.kYU);
    }

    @Override // com.baidu.tieba.sdk.b.a
    public com.baidu.tieba.sdk.c.a dbs() {
        com.baidu.h.a.a.b XT;
        if (this.cba.isLogin() && (XT = this.cba.XT()) != null) {
            return a(XT);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.b.a
    public void dbt() {
        this.cba.login();
    }

    private com.baidu.tieba.sdk.c.a a(com.baidu.h.a.a.b bVar) {
        com.baidu.tieba.sdk.c.a aVar = new com.baidu.tieba.sdk.c.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.getDisplayname();
        aVar.nickName = bVar.getDisplayname();
        aVar.portrait = bVar.XU();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
