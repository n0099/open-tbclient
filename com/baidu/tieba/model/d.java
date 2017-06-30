package com.baidu.tieba.model;

import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.a.h;
import com.baidu.tieba.model.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements h.a {
    private final /* synthetic */ String ecA;
    private final /* synthetic */ c.a ecy;
    private final /* synthetic */ a.InterfaceC0037a ecz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c.a aVar, a.InterfaceC0037a interfaceC0037a, String str) {
        this.ecy = aVar;
        this.ecz = interfaceC0037a;
        this.ecA = str;
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onSuccess(String str) {
        this.ecy.setStoken(str);
        this.ecy.execute(new String[0]);
    }

    @Override // com.baidu.tbadk.core.a.h.a
    public void onFailed() {
        if (this.ecz != null) {
            this.ecz.b(this.ecA, 1, null);
        }
    }
}
