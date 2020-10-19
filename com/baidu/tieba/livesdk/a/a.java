package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.h.a.a.c;
/* loaded from: classes4.dex */
public class a implements com.baidu.tieba.sdk.b.a {
    private com.baidu.h.a.a.a bHv;
    private c krW = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.h.a.a.c
        public void onLoginStatusChanged(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.dwI().dwJ();
        }
    };

    public a(Application application) {
        this.bHv = com.baidu.h.b.a.aJ(application).TT();
        this.bHv.a(this.krW);
    }

    @Override // com.baidu.tieba.sdk.b.a
    public com.baidu.tieba.sdk.c.a cVe() {
        com.baidu.h.a.a.b TL;
        if (this.bHv.isLogin() && (TL = this.bHv.TL()) != null) {
            return a(TL);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.b.a
    public void cVf() {
        this.bHv.login();
    }

    private com.baidu.tieba.sdk.c.a a(com.baidu.h.a.a.b bVar) {
        com.baidu.tieba.sdk.c.a aVar = new com.baidu.tieba.sdk.c.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.getDisplayname();
        aVar.nickName = bVar.getDisplayname();
        aVar.portrait = bVar.TM();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
