package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.h.a.a.c;
/* loaded from: classes4.dex */
public class a implements com.baidu.tieba.sdk.b.a {
    private com.baidu.h.a.a.a bAS;
    private c kcI = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.h.a.a.c
        public void onLoginStatusChanged(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.dsX().dsY();
        }
    };

    public a(Application application) {
        this.bAS = com.baidu.h.b.a.aF(application).Sa();
        this.bAS.a(this.kcI);
    }

    @Override // com.baidu.tieba.sdk.b.a
    public com.baidu.tieba.sdk.c.a cRu() {
        com.baidu.h.a.a.b RS;
        if (this.bAS.isLogin() && (RS = this.bAS.RS()) != null) {
            return a(RS);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.b.a
    public void cRv() {
        this.bAS.login();
    }

    private com.baidu.tieba.sdk.c.a a(com.baidu.h.a.a.b bVar) {
        com.baidu.tieba.sdk.c.a aVar = new com.baidu.tieba.sdk.c.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.getDisplayname();
        aVar.nickName = bVar.getDisplayname();
        aVar.portrait = bVar.RT();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
