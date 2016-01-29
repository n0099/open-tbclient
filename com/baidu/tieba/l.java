package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
class l implements p.a {
    final /* synthetic */ k aHO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.aHO = kVar;
    }

    @Override // com.baidu.tieba.p.a
    public void HZ() {
        LogoActivity logoActivity;
        boolean z;
        LogoActivity logoActivity2;
        LogoActivity.a aVar;
        LogoActivity logoActivity3;
        Bitmap bitmap;
        LogoActivity logoActivity4;
        Runnable runnable;
        logoActivity = this.aHO.aHJ;
        z = logoActivity.aHv;
        if (!z) {
            logoActivity3 = this.aHO.aHJ;
            bitmap = logoActivity3.aHy;
            if (bitmap != null && com.baidu.tieba.a.a.Lb().Le()) {
                com.baidu.adp.lib.h.h hr = com.baidu.adp.lib.h.h.hr();
                logoActivity4 = this.aHO.aHJ;
                runnable = logoActivity4.aHD;
                hr.post(runnable);
                return;
            }
        }
        com.baidu.adp.lib.h.h hr2 = com.baidu.adp.lib.h.h.hr();
        logoActivity2 = this.aHO.aHJ;
        aVar = logoActivity2.aHC;
        hr2.post(aVar);
    }
}
