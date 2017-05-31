package com.baidu.tieba.write.model;

import com.baidu.tieba.write.model.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ a fWp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.fWp = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        a.InterfaceC0085a interfaceC0085a;
        a.InterfaceC0085a interfaceC0085a2;
        com.baidu.tieba.write.a.a aVar;
        this.fWp.boo();
        com.baidu.tieba.write.a.a aVar2 = new com.baidu.tieba.write.a.a();
        aVar2.fVV = false;
        str = this.fWp.mLinkUrl;
        aVar2.linkUrl = str;
        aVar2.fVW = 1;
        this.fWp.fWn = aVar2;
        interfaceC0085a = this.fWp.fWm;
        if (interfaceC0085a != null) {
            interfaceC0085a2 = this.fWp.fWm;
            aVar = this.fWp.fWn;
            interfaceC0085a2.a(aVar);
        }
    }
}
