package com.baidu.tieba.livesdk.a;

import android.app.Application;
import com.baidu.c.a.a.c;
/* loaded from: classes3.dex */
public class a implements com.baidu.tieba.sdk.b.a {
    private com.baidu.c.a.a.a bmg;
    private c jeQ = new c() { // from class: com.baidu.tieba.livesdk.a.a.1
        @Override // com.baidu.c.a.a.c
        public void onLoginStatusChanged(boolean z, boolean z2) {
            com.baidu.tieba.sdk.a.cWv().cWw();
        }
    };

    public a(Application application) {
        this.bmg = com.baidu.c.b.a.az(application).JT();
        this.bmg.a(this.jeQ);
    }

    @Override // com.baidu.tieba.sdk.b.a
    public com.baidu.tieba.sdk.c.a cvh() {
        com.baidu.c.a.a.b JL;
        if (this.bmg.isLogin() && (JL = this.bmg.JL()) != null) {
            return a(JL);
        }
        return null;
    }

    @Override // com.baidu.tieba.sdk.b.a
    public void cvi() {
        this.bmg.login();
    }

    private com.baidu.tieba.sdk.c.a a(com.baidu.c.a.a.b bVar) {
        com.baidu.tieba.sdk.c.a aVar = new com.baidu.tieba.sdk.c.a();
        aVar.userId = bVar.getUid();
        aVar.userName = bVar.getDisplayname();
        aVar.nickName = bVar.getDisplayname();
        aVar.portrait = bVar.JM();
        aVar.bduss = bVar.getBduss();
        return aVar;
    }
}
