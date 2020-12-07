package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.i.a.a.c;
/* loaded from: classes4.dex */
public class a implements com.baidu.tieba.sdk.b.a {
    private com.baidu.i.a.a.a bZg;
    private c kXV = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.i.a.a.c
        public void onLoginStatusChanged(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.dHh().dHi();
        }
    };

    public a(Application application) {
        this.bZg = com.baidu.i.b.a.bn(application).aag();
        this.bZg.a(this.kXV);
    }

    @Override // com.baidu.tieba.sdk.b.a
    public com.baidu.tieba.sdk.c.a dfw() {
        com.baidu.i.a.a.b ZY;
        if (this.bZg.isLogin() && (ZY = this.bZg.ZY()) != null) {
            return a(ZY);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.b.a
    public void dfx() {
        this.bZg.login();
    }

    private com.baidu.tieba.sdk.c.a a(com.baidu.i.a.a.b bVar) {
        com.baidu.tieba.sdk.c.a aVar = new com.baidu.tieba.sdk.c.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.getDisplayname();
        aVar.nickName = bVar.getDisplayname();
        aVar.portrait = bVar.ZZ();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
