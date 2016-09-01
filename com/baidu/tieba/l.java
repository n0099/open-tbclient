package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
class l implements p.a {
    final /* synthetic */ k aLF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.aLF = kVar;
    }

    @Override // com.baidu.tieba.p.a
    public void onCompleted() {
        LogoActivity logoActivity;
        boolean Jc;
        LogoActivity logoActivity2;
        boolean z;
        LogoActivity logoActivity3;
        LogoActivity.a aVar;
        LogoActivity logoActivity4;
        Bitmap bitmap;
        LogoActivity logoActivity5;
        Runnable runnable;
        LogoActivity logoActivity6;
        logoActivity = this.aLF.aLA;
        Jc = logoActivity.Jc();
        if (Jc) {
            logoActivity6 = this.aLF.aLA;
            logoActivity6.finish();
            return;
        }
        logoActivity2 = this.aLF.aLA;
        z = logoActivity2.aLm;
        if (!z) {
            logoActivity4 = this.aLF.aLA;
            bitmap = logoActivity4.aLp;
            if (bitmap != null && com.baidu.tieba.d.a.OI().OK()) {
                com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
                logoActivity5 = this.aLF.aLA;
                runnable = logoActivity5.aLu;
                eG.post(runnable);
                return;
            }
        }
        com.baidu.adp.lib.h.h eG2 = com.baidu.adp.lib.h.h.eG();
        logoActivity3 = this.aLF.aLA;
        aVar = logoActivity3.aLt;
        eG2.post(aVar);
    }
}
