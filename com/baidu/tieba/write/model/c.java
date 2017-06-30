package com.baidu.tieba.write.model;

import com.baidu.tieba.write.model.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ a ghe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.ghe = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        a.InterfaceC0087a interfaceC0087a;
        a.InterfaceC0087a interfaceC0087a2;
        com.baidu.tieba.write.a.a aVar;
        this.ghe.bsM();
        com.baidu.tieba.write.a.a aVar2 = new com.baidu.tieba.write.a.a();
        aVar2.ggG = false;
        str = this.ghe.mLinkUrl;
        aVar2.linkUrl = str;
        aVar2.ggH = 1;
        this.ghe.ghc = aVar2;
        interfaceC0087a = this.ghe.ghb;
        if (interfaceC0087a != null) {
            interfaceC0087a2 = this.ghe.ghb;
            aVar = this.ghe.ghc;
            interfaceC0087a2.a(aVar);
        }
    }
}
