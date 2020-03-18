package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.g.a.a.c;
/* loaded from: classes3.dex */
public class a implements com.baidu.tieba.sdk.a.a {
    private com.baidu.g.a.a.a aIK;
    private c ifg = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.g.a.a.c
        public void onLoginStatusChanged(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.cED().cEE();
        }
    };

    public a(Application application) {
        this.aIK = com.baidu.g.b.a.aO(application).BX();
        this.aIK.a(this.ifg);
    }

    @Override // com.baidu.tieba.sdk.a.a
    public com.baidu.tieba.sdk.b.a cdX() {
        com.baidu.g.a.a.b BP;
        if (this.aIK.isLogin() && (BP = this.aIK.BP()) != null) {
            return a(BP);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.a.a
    public void cdY() {
        this.aIK.login();
    }

    private com.baidu.tieba.sdk.b.a a(com.baidu.g.a.a.b bVar) {
        com.baidu.tieba.sdk.b.a aVar = new com.baidu.tieba.sdk.b.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.getDisplayname();
        aVar.nickName = bVar.getDisplayname();
        aVar.portrait = bVar.BQ();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
