package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.g.a.a.c;
/* loaded from: classes3.dex */
public class a implements com.baidu.tieba.sdk.a.a {
    private com.baidu.g.a.a.a aIu;
    private c idp = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.g.a.a.c
        public void onLoginStatusChanged(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.cEg().cEh();
        }
    };

    public a(Application application) {
        this.aIu = com.baidu.g.b.a.aP(application).BO();
        this.aIu.a(this.idp);
    }

    @Override // com.baidu.tieba.sdk.a.a
    public com.baidu.tieba.sdk.b.a cdB() {
        com.baidu.g.a.a.b BG;
        if (this.aIu.isLogin() && (BG = this.aIu.BG()) != null) {
            return a(BG);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.a.a
    public void cdC() {
        this.aIu.login();
    }

    private com.baidu.tieba.sdk.b.a a(com.baidu.g.a.a.b bVar) {
        com.baidu.tieba.sdk.b.a aVar = new com.baidu.tieba.sdk.b.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.getDisplayname();
        aVar.nickName = bVar.getDisplayname();
        aVar.portrait = bVar.BH();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
