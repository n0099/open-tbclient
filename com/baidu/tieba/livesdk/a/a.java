package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.h.a.a.c;
/* loaded from: classes10.dex */
public class a implements com.baidu.tieba.sdk.b.a {
    private com.baidu.h.a.a.a cfm;
    private c lgY = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.h.a.a.c
        public void onLoginStatusChanged(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.dFp().dFq();
        }
    };

    public a(Application application) {
        this.cfm = com.baidu.h.b.a.bA(application).ZV();
        this.cfm.a(this.lgY);
    }

    @Override // com.baidu.tieba.sdk.b.a
    public com.baidu.tieba.sdk.c.a ddq() {
        com.baidu.h.a.a.b ZN;
        if (this.cfm.isLogin() && (ZN = this.cfm.ZN()) != null) {
            return a(ZN);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.b.a
    public void ddr() {
        this.cfm.login();
    }

    private com.baidu.tieba.sdk.c.a a(com.baidu.h.a.a.b bVar) {
        com.baidu.tieba.sdk.c.a aVar = new com.baidu.tieba.sdk.c.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.getDisplayname();
        aVar.nickName = bVar.getDisplayname();
        aVar.portrait = bVar.ZO();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
