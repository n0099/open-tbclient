package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
class l implements p.a {
    final /* synthetic */ k aKK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.aKK = kVar;
    }

    @Override // com.baidu.tieba.p.a
    public void Jv() {
        LogoActivity logoActivity;
        boolean z;
        LogoActivity logoActivity2;
        LogoActivity.a aVar;
        LogoActivity logoActivity3;
        Bitmap bitmap;
        LogoActivity logoActivity4;
        Runnable runnable;
        logoActivity = this.aKK.aKF;
        z = logoActivity.aKr;
        if (!z) {
            logoActivity3 = this.aKK.aKF;
            bitmap = logoActivity3.aKu;
            if (bitmap != null && com.baidu.tieba.a.a.Mw().My()) {
                com.baidu.adp.lib.h.h hx = com.baidu.adp.lib.h.h.hx();
                logoActivity4 = this.aKK.aKF;
                runnable = logoActivity4.aKz;
                hx.post(runnable);
                return;
            }
        }
        com.baidu.adp.lib.h.h hx2 = com.baidu.adp.lib.h.h.hx();
        logoActivity2 = this.aKK.aKF;
        aVar = logoActivity2.aKy;
        hx2.post(aVar);
    }
}
