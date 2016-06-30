package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.q;
/* loaded from: classes.dex */
class m implements q.a {
    final /* synthetic */ l aHx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.aHx = lVar;
    }

    @Override // com.baidu.tieba.q.a
    public void onCompleted() {
        LogoActivity logoActivity;
        boolean z;
        LogoActivity logoActivity2;
        LogoActivity.a aVar;
        LogoActivity logoActivity3;
        Bitmap bitmap;
        LogoActivity logoActivity4;
        Runnable runnable;
        logoActivity = this.aHx.aHs;
        z = logoActivity.aHe;
        if (!z) {
            logoActivity3 = this.aHx.aHs;
            bitmap = logoActivity3.aHh;
            if (bitmap != null && com.baidu.tieba.c.a.Me().Mg()) {
                com.baidu.adp.lib.h.h dM = com.baidu.adp.lib.h.h.dM();
                logoActivity4 = this.aHx.aHs;
                runnable = logoActivity4.aHm;
                dM.post(runnable);
                return;
            }
        }
        com.baidu.adp.lib.h.h dM2 = com.baidu.adp.lib.h.h.dM();
        logoActivity2 = this.aHx.aHs;
        aVar = logoActivity2.aHl;
        dM2.post(aVar);
    }
}
