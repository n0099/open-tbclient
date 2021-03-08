package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.h.a.a.c;
/* loaded from: classes9.dex */
public class a implements com.baidu.tieba.sdk.b.a {
    private com.baidu.h.a.a.a cgM;
    private c ljo = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.h.a.a.c
        public void onLoginStatusChanged(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.dFF().dFG();
        }
    };

    public a(Application application) {
        this.cgM = com.baidu.h.b.a.bz(application).ZY();
        this.cgM.a(this.ljo);
    }

    @Override // com.baidu.tieba.sdk.b.a
    public com.baidu.tieba.sdk.c.a ddG() {
        com.baidu.h.a.a.b ZQ;
        if (this.cgM.isLogin() && (ZQ = this.cgM.ZQ()) != null) {
            return a(ZQ);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.b.a
    public void ddH() {
        this.cgM.login();
    }

    private com.baidu.tieba.sdk.c.a a(com.baidu.h.a.a.b bVar) {
        com.baidu.tieba.sdk.c.a aVar = new com.baidu.tieba.sdk.c.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.getDisplayname();
        aVar.nickName = bVar.getDisplayname();
        aVar.portrait = bVar.ZR();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
