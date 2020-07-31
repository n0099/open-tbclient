package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.d.a.a.c;
/* loaded from: classes4.dex */
public class a implements com.baidu.tieba.sdk.b.a {
    private com.baidu.d.a.a.a brC;
    private c jEE = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.d.a.a.c
        public void onLoginStatusChanged(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.ddS().ddT();
        }
    };

    public a(Application application) {
        this.brC = com.baidu.d.b.a.aA(application).Lj();
        this.brC.a(this.jEE);
    }

    @Override // com.baidu.tieba.sdk.b.a
    public com.baidu.tieba.sdk.c.a cCW() {
        com.baidu.d.a.a.b Lb;
        if (this.brC.isLogin() && (Lb = this.brC.Lb()) != null) {
            return a(Lb);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.b.a
    public void cCX() {
        this.brC.login();
    }

    private com.baidu.tieba.sdk.c.a a(com.baidu.d.a.a.b bVar) {
        com.baidu.tieba.sdk.c.a aVar = new com.baidu.tieba.sdk.c.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.getDisplayname();
        aVar.nickName = bVar.getDisplayname();
        aVar.portrait = bVar.Lc();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
