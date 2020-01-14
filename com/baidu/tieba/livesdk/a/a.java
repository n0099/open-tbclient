package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.g.a.a.c;
/* loaded from: classes2.dex */
public class a implements com.baidu.tieba.sdk.a.a {
    private com.baidu.g.a.a.a aEo;
    private c ibr = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.g.a.a.c
        public void onLoginStatusChanged(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.cCF().cCG();
        }
    };

    public a(Application application) {
        this.aEo = com.baidu.g.b.a.aL(application).zy();
        this.aEo.a(this.ibr);
    }

    @Override // com.baidu.tieba.sdk.a.a
    public com.baidu.tieba.sdk.b.a cbX() {
        com.baidu.g.a.a.b zq;
        if (this.aEo.isLogin() && (zq = this.aEo.zq()) != null) {
            return a(zq);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.a.a
    public void cbY() {
        this.aEo.login();
    }

    private com.baidu.tieba.sdk.b.a a(com.baidu.g.a.a.b bVar) {
        com.baidu.tieba.sdk.b.a aVar = new com.baidu.tieba.sdk.b.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.getDisplayname();
        aVar.nickName = bVar.getDisplayname();
        aVar.portrait = bVar.zr();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
