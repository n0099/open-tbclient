package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.c.a.a.c;
/* loaded from: classes3.dex */
public class a implements com.baidu.tieba.sdk.a.a {
    private com.baidu.c.a.a.a beG;
    private c iPc = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.c.a.a.c
        public void onLoginStatusChanged(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.cPc().cPd();
        }
    };

    public a(Application application) {
        this.beG = com.baidu.c.b.a.ap(application).Ia();
        this.beG.a(this.iPc);
    }

    @Override // com.baidu.tieba.sdk.a.a
    public com.baidu.tieba.sdk.b.a cov() {
        com.baidu.c.a.a.b HS;
        if (this.beG.isLogin() && (HS = this.beG.HS()) != null) {
            return a(HS);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.a.a
    public void cow() {
        this.beG.login();
    }

    private com.baidu.tieba.sdk.b.a a(com.baidu.c.a.a.b bVar) {
        com.baidu.tieba.sdk.b.a aVar = new com.baidu.tieba.sdk.b.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.getDisplayname();
        aVar.nickName = bVar.getDisplayname();
        aVar.portrait = bVar.HT();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
