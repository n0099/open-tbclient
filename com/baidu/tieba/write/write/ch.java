package com.baidu.tieba.write.write;

import android.os.Handler;
import com.baidu.tieba.write.model.a;
/* loaded from: classes.dex */
class ch implements a.InterfaceC0087a {
    final /* synthetic */ WriteUrlActivity gmD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(WriteUrlActivity writeUrlActivity) {
        this.gmD = writeUrlActivity;
    }

    @Override // com.baidu.tieba.write.model.a.InterfaceC0087a
    public void a(com.baidu.tieba.write.a.a aVar) {
        cq cqVar;
        com.baidu.tieba.write.a.a aVar2;
        cq cqVar2;
        boolean z;
        Runnable runnable;
        this.gmD.gmA = aVar;
        this.gmD.isLoading = false;
        cqVar = this.gmD.gmx;
        if (cqVar != null) {
            aVar2 = this.gmD.gmA;
            if (aVar2.ggH != 1) {
                cqVar2 = this.gmD.gmx;
                z = this.gmD.isLoading;
                cqVar2.a(aVar, z);
                return;
            }
            Handler safeHandler = this.gmD.getSafeHandler();
            runnable = this.gmD.gmC;
            safeHandler.postDelayed(runnable, 800L);
        }
    }
}
