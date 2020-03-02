package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.g.a.a.c;
/* loaded from: classes3.dex */
public class a implements com.baidu.tieba.sdk.a.a {
    private com.baidu.g.a.a.a aIv;
    private c idr = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.g.a.a.c
        public void onLoginStatusChanged(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.cEi().cEj();
        }
    };

    public a(Application application) {
        this.aIv = com.baidu.g.b.a.aP(application).BQ();
        this.aIv.a(this.idr);
    }

    @Override // com.baidu.tieba.sdk.a.a
    public com.baidu.tieba.sdk.b.a cdD() {
        com.baidu.g.a.a.b BI;
        if (this.aIv.isLogin() && (BI = this.aIv.BI()) != null) {
            return a(BI);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.a.a
    public void cdE() {
        this.aIv.login();
    }

    private com.baidu.tieba.sdk.b.a a(com.baidu.g.a.a.b bVar) {
        com.baidu.tieba.sdk.b.a aVar = new com.baidu.tieba.sdk.b.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.getDisplayname();
        aVar.nickName = bVar.getDisplayname();
        aVar.portrait = bVar.BJ();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
