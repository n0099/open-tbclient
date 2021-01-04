package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.j.a.a.c;
/* loaded from: classes10.dex */
public class a implements com.baidu.tieba.sdk.b.a {
    private com.baidu.j.a.a.a cfQ;
    private c ldB = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.j.a.a.c
        public void onLoginStatusChanged(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.dGX().dGY();
        }
    };

    public a(Application application) {
        this.cfQ = com.baidu.j.b.a.by(application).abT();
        this.cfQ.a(this.ldB);
    }

    @Override // com.baidu.tieba.sdk.b.a
    public com.baidu.tieba.sdk.c.a dfj() {
        com.baidu.j.a.a.b abL;
        if (this.cfQ.isLogin() && (abL = this.cfQ.abL()) != null) {
            return a(abL);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.b.a
    public void dfk() {
        this.cfQ.login();
    }

    private com.baidu.tieba.sdk.c.a a(com.baidu.j.a.a.b bVar) {
        com.baidu.tieba.sdk.c.a aVar = new com.baidu.tieba.sdk.c.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.getDisplayname();
        aVar.nickName = bVar.getDisplayname();
        aVar.portrait = bVar.abM();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
