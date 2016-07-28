package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.q;
/* loaded from: classes.dex */
class m implements q.a {
    final /* synthetic */ l aIo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.aIo = lVar;
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
        logoActivity = this.aIo.aIj;
        z = logoActivity.aHV;
        if (!z) {
            logoActivity3 = this.aIo.aIj;
            bitmap = logoActivity3.aHY;
            if (bitmap != null && com.baidu.tieba.c.a.Md().Mf()) {
                com.baidu.adp.lib.h.h dL = com.baidu.adp.lib.h.h.dL();
                logoActivity4 = this.aIo.aIj;
                runnable = logoActivity4.aId;
                dL.post(runnable);
                return;
            }
        }
        com.baidu.adp.lib.h.h dL2 = com.baidu.adp.lib.h.h.dL();
        logoActivity2 = this.aIo.aIj;
        aVar = logoActivity2.aIc;
        dL2.post(aVar);
    }
}
