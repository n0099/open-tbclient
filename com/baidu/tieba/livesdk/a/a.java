package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.h.a.a.c;
/* loaded from: classes4.dex */
public class a implements com.baidu.tieba.sdk.b.a {
    private com.baidu.h.a.a.a bPQ;
    private c kEt = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.h.a.a.c
        public void onLoginStatusChanged(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.dzQ().dzR();
        }
    };

    public a(Application application) {
        this.bPQ = com.baidu.h.b.a.aJ(application).VN();
        this.bPQ.a(this.kEt);
    }

    @Override // com.baidu.tieba.sdk.b.a
    public com.baidu.tieba.sdk.c.a cYm() {
        com.baidu.h.a.a.b VF;
        if (this.bPQ.isLogin() && (VF = this.bPQ.VF()) != null) {
            return a(VF);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.b.a
    public void cYn() {
        this.bPQ.login();
    }

    private com.baidu.tieba.sdk.c.a a(com.baidu.h.a.a.b bVar) {
        com.baidu.tieba.sdk.c.a aVar = new com.baidu.tieba.sdk.c.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.getDisplayname();
        aVar.nickName = bVar.getDisplayname();
        aVar.portrait = bVar.VG();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
