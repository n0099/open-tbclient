package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.g.a.a.c;
/* loaded from: classes2.dex */
public class a implements com.baidu.tieba.sdk.a.a {
    private com.baidu.g.a.a.a aDw;
    private c hXM = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.g.a.a.c
        public void onLoginStatusChanged(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.cBx().cBy();
        }
    };

    public a(Application application) {
        this.aDw = com.baidu.g.b.a.aL(application).zc();
        this.aDw.a(this.hXM);
    }

    @Override // com.baidu.tieba.sdk.a.a
    public com.baidu.tieba.sdk.b.a caO() {
        com.baidu.g.a.a.b yU;
        if (this.aDw.isLogin() && (yU = this.aDw.yU()) != null) {
            return a(yU);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.a.a
    public void caP() {
        this.aDw.login();
    }

    private com.baidu.tieba.sdk.b.a a(com.baidu.g.a.a.b bVar) {
        com.baidu.tieba.sdk.b.a aVar = new com.baidu.tieba.sdk.b.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.getDisplayname();
        aVar.nickName = bVar.getDisplayname();
        aVar.portrait = bVar.yV();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
