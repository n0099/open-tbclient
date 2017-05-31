package com.baidu.tieba.write.write;

import android.os.Handler;
import com.baidu.tieba.write.model.a;
/* loaded from: classes.dex */
class cj implements a.InterfaceC0085a {
    final /* synthetic */ WriteUrlActivity gbF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(WriteUrlActivity writeUrlActivity) {
        this.gbF = writeUrlActivity;
    }

    @Override // com.baidu.tieba.write.model.a.InterfaceC0085a
    public void a(com.baidu.tieba.write.a.a aVar) {
        cs csVar;
        com.baidu.tieba.write.a.a aVar2;
        cs csVar2;
        boolean z;
        Runnable runnable;
        this.gbF.gbC = aVar;
        this.gbF.isLoading = false;
        csVar = this.gbF.gbz;
        if (csVar != null) {
            aVar2 = this.gbF.gbC;
            if (aVar2.fVW != 1) {
                csVar2 = this.gbF.gbz;
                z = this.gbF.isLoading;
                csVar2.a(aVar, z);
                return;
            }
            Handler safeHandler = this.gbF.getSafeHandler();
            runnable = this.gbF.gbE;
            safeHandler.postDelayed(runnable, 800L);
        }
    }
}
