package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
class l implements p.a {
    final /* synthetic */ k aGV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.aGV = kVar;
    }

    @Override // com.baidu.tieba.p.a
    public void HO() {
        LogoActivity logoActivity;
        boolean z;
        LogoActivity logoActivity2;
        LogoActivity.a aVar;
        LogoActivity logoActivity3;
        Bitmap bitmap;
        LogoActivity logoActivity4;
        Runnable runnable;
        logoActivity = this.aGV.aGQ;
        z = logoActivity.aGC;
        if (!z) {
            logoActivity3 = this.aGV.aGQ;
            bitmap = logoActivity3.aGF;
            if (bitmap != null && com.baidu.tieba.b.a.Lh().Lj()) {
                com.baidu.adp.lib.h.h dL = com.baidu.adp.lib.h.h.dL();
                logoActivity4 = this.aGV.aGQ;
                runnable = logoActivity4.aGK;
                dL.post(runnable);
                return;
            }
        }
        com.baidu.adp.lib.h.h dL2 = com.baidu.adp.lib.h.h.dL();
        logoActivity2 = this.aGV.aGQ;
        aVar = logoActivity2.aGJ;
        dL2.post(aVar);
    }
}
